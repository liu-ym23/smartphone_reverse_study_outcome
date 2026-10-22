package androidx.recyclerview.base;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012J\u001e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\u001bJ\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0012J\f\u0010$\u001a\u00020\t*\u00020\tH\u0002J\f\u0010#\u001a\u00020\t*\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/recyclerview/base/EdgeEffectAdapter;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animationElapsedTime", "", "animationStartTime", "currentDistance", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "<set-?>", "", "isFinished", "()Z", "mode", "", "pullDistanceSign", "springBack", "Landroidx/recyclerview/base/FluidSpringBack;", "totalPullDistance", "viewportRange", "computeScrollOffset", "getDistance", "onAbsorb", "", "velocity", "onPullDistance", "deltaDistance", "forReleasing", "fromAnim", "onRelease", "updateViewportRange", "px", "dp", "Companion", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EdgeEffectAdapter {
    public static final Companion Companion = null;
    private static final int MODE_IDLE = 0;
    private static final int MODE_PULLING = 1;
    private static final int MODE_SPRING_BACK = 2;
    private long animationElapsedTime;
    private long animationStartTime;
    private final Context context;
    private float currentDistance;
    private final DisplayMetrics displayMetrics;
    private boolean isFinished;
    private int mode;
    private float pullDistanceSign;
    private FluidSpringBack springBack;
    private float totalPullDistance;
    private float viewportRange;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/recyclerview/base/EdgeEffectAdapter$Companion;", "", "()V", "MODE_IDLE", "", "MODE_PULLING", "MODE_SPRING_BACK", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public EdgeEffectAdapter(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
        this.animationStartTime = -1;
        this.animationElapsedTime = -1;
        this.springBack = new FluidSpringBack();
        this.isFinished = true;
        this.displayMetrics = r5.getResources().getDisplayMetrics();
    }

    private final float dp(float r5) {
        return r5 / this.displayMetrics.density;
    }

    private final float px(float r5) {
        return TypedValue.applyDimension(1, r5, this.displayMetrics);
    }

    public final boolean computeScrollOffset() {
        if (this.animationStartTime != (-1)) goto L6;
        return false;
    L6:
        if (this.mode != 1) goto L8;
        return true;
    L8:
        long r5 = AnimationUtils.currentAnimationTimeMillis() - this.animationStartTime;
        this.animationElapsedTime = r5;
        FluidSpringBack.SpringBackValue r10 = this.springBack.value(r5);
        this.currentDistance = px(r10.getValue());
        boolean r11 = r10.isFinished();
        this.isFinished = r11;
        if (r11 == false) goto L12;
        this.mode = 0;
    L12:
        return !r11;
    }

    public final float getDistance() {
        return this.currentDistance;
    }

    public final boolean isFinished() {
        return this.isFinished;
    }

    public final void onAbsorb(int r5) {
        float r10 = dp(r5 / 1000.0f);
        this.animationStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.springBack.absorb(r10, 0.0f);
        this.mode = 2;
        this.isFinished = false;
    }

    public final float onPullDistance(float r10, boolean r11, boolean r12) {
        if (Math.signum(r10) != Math.signum(this.currentDistance)) goto L5;
        boolean r5 = true;
    L7:
        if (r5 != r11) goto L41;
        if (r12 == true) goto L41;
        float r13 = dp(r10);
        if (this.mode == 1) goto L18;
        float r14 = FluidRubberBand.Companion.distance(Math.abs(dp(this.currentDistance)), this.viewportRange) * (-Math.signum(this.currentDistance));
        this.totalPullDistance = r14;
        if (r14 != 0.0f) goto L15;
        float r15 = Math.signum(r13);
    L16:
        this.pullDistanceSign = r15;
    L20:
        float r16 = this.totalPullDistance;
        float r17 = r13 + r16;
        this.totalPullDistance = r17;
        float r18 = Math.signum(r17);
        float r19 = this.pullDistanceSign;
        if (r18 == r19) goto L26;
        if (r19 == 0.0f) goto L26;
        if (r11 == false) goto L30;
        this.totalPullDistance = 0.0f;
        this.pullDistanceSign = 0.0f;
        r17 = 0.0f;
    L31:
        this.currentDistance = px(Math.signum(r17) * (-FluidRubberBand.Companion.offset(Math.abs(r17), this.viewportRange)));
        this.mode = 1;
        this.isFinished = false;
        if (r5 == false) goto L40;
        if (r17 == 0.0f) goto L36;
        return r10;
    L36:
        if (r16 != 0.0f) goto L43;
        return r10;
    L43:
        return -px(r16);
    L40:
        return 0.0f;
    L30:
        this.pullDistanceSign = Math.signum(r17);
    L26:
        if (this.totalPullDistance != 0.0f) goto L31;
        this.pullDistanceSign = 0.0f;
        goto L31
    L15:
        r15 = Math.signum(r14);
        goto L16
    L18:
        if (this.pullDistanceSign != 0.0f) goto L20;
        this.pullDistanceSign = Math.signum(r13);
    L41:
        return 0.0f;
    L5:
        r5 = false;
        goto L7
    }

    public final void onRelease() {
        float r5 = dp(this.currentDistance);
        this.animationStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.springBack.absorb((-r5) / 100.0f, r5);
        this.mode = 2;
        this.isFinished = false;
    }

    public final void updateViewportRange(int r5) {
        this.viewportRange = dp(r5);
    }
}
