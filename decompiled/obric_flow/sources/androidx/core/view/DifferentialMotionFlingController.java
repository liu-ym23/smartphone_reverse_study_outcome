package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
public class DifferentialMotionFlingController {
    private final Context mContext;
    private final int[] mFlingVelocityThresholds;
    private float mLastFlingVelocity;
    private int mLastProcessedAxis;
    private int mLastProcessedDeviceId;
    private int mLastProcessedSource;
    private final DifferentialMotionFlingTarget mTarget;
    private final DifferentialVelocityProvider mVelocityProvider;
    private final FlingVelocityThresholdCalculator mVelocityThresholdCalculator;

    @Nullable
    private VelocityTracker mVelocityTracker;

    @VisibleForTesting
    public interface DifferentialVelocityProvider {
        float getCurrentVelocity(VelocityTracker r5, MotionEvent r10, int r11);
    }

    @VisibleForTesting
    public interface FlingVelocityThresholdCalculator {
        void calculateFlingVelocityThresholds(Context r5, int[] r10, MotionEvent r11, int r12);
    }

    public DifferentialMotionFlingController(@NonNull Context r5, @NonNull DifferentialMotionFlingTarget r10) {
        this(r5, r10, new b(), new b());
    }

    public static /* synthetic */ void a(Context r5, int[] r10, MotionEvent r11, int r12) {
        calculateFlingVelocityThresholds(r5, r10, r11, r12);
    }

    public static /* synthetic */ float b(VelocityTracker r5, MotionEvent r10, int r11) {
        return getCurrentVelocity(r5, r10, r11);
    }

    private boolean calculateFlingVelocityThresholds(MotionEvent r10, int r11) {
        int r5 = r10.getSource();
        int r12 = r10.getDeviceId();
        if (this.mLastProcessedSource == r5) goto L5;
    L11:
        this.mVelocityThresholdCalculator.calculateFlingVelocityThresholds(this.mContext, this.mFlingVelocityThresholds, r10, r11);
        this.mLastProcessedSource = r5;
        this.mLastProcessedDeviceId = r12;
        this.mLastProcessedAxis = r11;
        return true;
    L5:
        if (this.mLastProcessedDeviceId != r12) goto L11;
        if (this.mLastProcessedAxis != r11) goto L11;
        return false;
    }

    private float getCurrentVelocity(MotionEvent r5, int r10) {
        if (this.mVelocityTracker != null) goto L6;
        this.mVelocityTracker = VelocityTracker.obtain();
    L6:
        return this.mVelocityProvider.getCurrentVelocity(this.mVelocityTracker, r5, r10);
    }

    public void onMotionEvent(@NonNull MotionEvent r5, int r10) {
        boolean r11 = calculateFlingVelocityThresholds(r5, r10);
        if (this.mFlingVelocityThresholds[0] != Integer.MAX_VALUE) goto L8;
        VelocityTracker r12 = this.mVelocityTracker;
        if (r12 == null) goto L23;
        r12.recycle();
        this.mVelocityTracker = null;
        return;
    L23:
        return;
    L8:
        float r13 = this.mTarget.getScaledScrollFactor() * getCurrentVelocity(r5, r10);
        float r14 = Math.signum(r13);
        float r15 = 0.0f;
        if (r11 == false) goto L11;
    L14:
        this.mTarget.stopDifferentialMotionFling();
    L15:
        float r16 = Math.abs(r13);
        int[] r17 = this.mFlingVelocityThresholds;
        if (r16 >= r17[0]) goto L18;
        return;
    L18:
        int r18 = r17[1];
        float r19 = Math.max(-r18, Math.min(r13, r18));
        if (this.mTarget.startDifferentialMotionFling(r19) == false) goto L21;
        r15 = r19;
    L21:
        this.mLastFlingVelocity = r15;
        return;
    L11:
        if (r14 == Math.signum(this.mLastFlingVelocity)) goto L15;
        if (r14 == 0.0f) goto L15;
        goto L14
    }

    @VisibleForTesting
    public DifferentialMotionFlingController(Context r5, DifferentialMotionFlingTarget r10, FlingVelocityThresholdCalculator r11, DifferentialVelocityProvider r12) {
        this.mLastProcessedAxis = -1;
        this.mLastProcessedSource = -1;
        this.mLastProcessedDeviceId = -1;
        this.mFlingVelocityThresholds = new int[]{Integer.MAX_VALUE, 0};
        this.mContext = r5;
        this.mTarget = r10;
        this.mVelocityThresholdCalculator = r11;
        this.mVelocityProvider = r12;
    }

    private static float getCurrentVelocity(VelocityTracker r5, MotionEvent r10, int r11) {
        VelocityTrackerCompat.addMovement(r5, r10);
        VelocityTrackerCompat.computeCurrentVelocity(r5, 1000);
        return VelocityTrackerCompat.getAxisVelocity(r5, r11);
    }

    private static void calculateFlingVelocityThresholds(Context r5, int[] r10, MotionEvent r11, int r12) {
        ViewConfiguration r13 = ViewConfiguration.get(r5);
        r10[0] = ViewConfigurationCompat.getScaledMinimumFlingVelocity(r5, r13, r11.getDeviceId(), r12, r11.getSource());
        r10[1] = ViewConfigurationCompat.getScaledMaximumFlingVelocity(r5, r13, r11.getDeviceId(), r12, r11.getSource());
    }
}
