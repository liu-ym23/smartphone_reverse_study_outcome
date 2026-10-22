package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.ttnet.org.chromium.base.TimeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class FrameMetricsAggregator {
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    private static final int LAST_INDEX = 8;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX = 0;
    private final FrameMetricsBaseImpl mInstance;

    @RequiresApi(24)
    private static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {
        private static final int NANOS_PER_MS = 1000000;
        private static final int NANOS_ROUNDING_VALUE = 500000;
        private static Handler sHandler;
        private static HandlerThread sHandlerThread;
        private final ArrayList<WeakReference<Activity>> mActivities;
        Window.OnFrameMetricsAvailableListener mListener;
        SparseIntArray[] mMetrics;
        int mTrackingFlags;

        static {
        }

        FrameMetricsApi24Impl(int r10) {
            this.mMetrics = new SparseIntArray[9];
            this.mActivities = new ArrayList();
            this.mListener = new AnonymousClass1(this);
            this.mTrackingFlags = r10;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public void add(Activity r10) {
            if (sHandlerThread != null) goto L5;
            HandlerThread r11 = new HandlerThread("FrameMetricsAggregator");
            sHandlerThread = r11;
            r11.start();
            sHandler = new Handler(sHandlerThread.getLooper());
        L5:
            int r12 = 0;
        L7:
            if (r12 > 8) goto L14;
            SparseIntArray[] r13 = this.mMetrics;
            if (r13[r12] != null) goto L13;
            if ((this.mTrackingFlags & (1 << r12)) == 0) goto L13;
            r13[r12] = new SparseIntArray();
        L13:
            r12 = r12 + 1;
            goto L7
        L14:
            r10.getWindow().addOnFrameMetricsAvailableListener(this.mListener, sHandler);
            this.mActivities.add(new WeakReference(r10));
        }

        void addDurationItem(SparseIntArray r10, long r11) {
            if (r10 == null) goto L7;
            int r12 = (int) ((500000 + r11) / TimeUtils.NANOSECONDS_PER_MILLISECOND);
            if (r11 < 0) goto L8;
            r10.put(r12, r10.get(r12) + 1);
            return;
        L8:
            return;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] getMetrics() {
            return this.mMetrics;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] remove(Activity r10) {
            Iterator<WeakReference<Activity>> r11 = this.mActivities.iterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            WeakReference<Activity> r12 = r11.next();
            if (r12.get() != r10) goto L4;
            this.mActivities.remove(r12);
        L8:
            r10.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
            return this.mMetrics;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] reset() {
            SparseIntArray[] r10 = this.mMetrics;
            this.mMetrics = new SparseIntArray[9];
            return r10;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] stop() {
            int r10 = this.mActivities.size() - 1;
        L3:
            if (r10 < 0) goto L9;
            WeakReference<Activity> r11 = this.mActivities.get(r10);
            Activity r12 = r11.get();
            if (r11.get() == null) goto L7;
            r12.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
            this.mActivities.remove(r10);
        L7:
            r10 = r10 - 1;
            goto L3
        L9:
            return this.mMetrics;
        }
    }

    private static class FrameMetricsBaseImpl {
        FrameMetricsBaseImpl() {
        }

        public void add(Activity r10) {
        }

        public SparseIntArray[] getMetrics() {
            return null;
        }

        public SparseIntArray[] remove(Activity r10) {
            return null;
        }

        public SparseIntArray[] reset() {
            return null;
        }

        public SparseIntArray[] stop() {
            return null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface MetricType {
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public FrameMetricsAggregator(int r10) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        this.mInstance = new FrameMetricsApi24Impl(r10);
        return;
    L5:
        this.mInstance = new FrameMetricsBaseImpl();
    }

    public void add(@NonNull Activity r10) {
        this.mInstance.add(r10);
    }

    @Nullable
    public SparseIntArray[] getMetrics() {
        return this.mInstance.getMetrics();
    }

    @Nullable
    public SparseIntArray[] remove(@NonNull Activity r10) {
        return this.mInstance.remove(r10);
    }

    @Nullable
    public SparseIntArray[] reset() {
        return this.mInstance.reset();
    }

    @Nullable
    public SparseIntArray[] stop() {
        return this.mInstance.stop();
    }
}
