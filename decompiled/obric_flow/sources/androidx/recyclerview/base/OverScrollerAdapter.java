package androidx.recyclerview.base;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u0000 22\u00020\u0001:\u00012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0014JF\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001fJ\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\u001fJ\u0006\u0010*\u001a\u00020\u001fJ\u0006\u0010+\u001a\u00020\u001fJ\u0006\u0010,\u001a\u00020\u001fJ\u0006\u0010-\u001a\u00020\u0014J.\u0010.\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018¨\u00063"}, d2 = {"Landroidx/recyclerview/base/OverScrollerAdapter;", "", "context", "Landroid/content/Context;", "interpolator", "Landroid/view/animation/Interpolator;", "(Landroid/content/Context;Landroid/view/animation/Interpolator;)V", "animationElapsedTime", "", "animationStartTime", "fluidScrollerX", "Landroidx/recyclerview/base/FluidScroller;", "getFluidScrollerX", "()Landroidx/recyclerview/base/FluidScroller;", "fluidScrollerX$delegate", "Lkotlin/Lazy;", "fluidScrollerY", "getFluidScrollerY", "fluidScrollerY$delegate", "isSmoothAnimation", "", "systemOverScroller", "Landroid/widget/OverScroller;", "getSystemOverScroller", "()Landroid/widget/OverScroller;", "systemOverScroller$delegate", "abortAnimation", "", "computeScrollOffset", "fling", "startX", "", "startY", "velocityX", "velocityY", "minX", "maxX", "minY", "maxY", "getCurrVelocity", "", "getCurrX", "getCurrY", "getFinalX", "getFinalY", "isFinished", "startScroll", "dx", "dy", "duration", "Companion", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OverScrollerAdapter {
    public static final Companion Companion = null;
    private static boolean forceUseSystemScroller;
    private long animationElapsedTime;
    private long animationStartTime;
    private final Context context;
    private final Lazy fluidScrollerX$delegate;
    private final Lazy fluidScrollerY$delegate;
    private final Interpolator interpolator;
    private boolean isSmoothAnimation;
    private final Lazy systemOverScroller$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/recyclerview/base/OverScrollerAdapter$Companion;", "", "()V", "forceUseSystemScroller", "", "getForceUseSystemScroller", "()Z", "setForceUseSystemScroller", "(Z)V", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final boolean getForceUseSystemScroller() {
            return OverScrollerAdapter.access$getForceUseSystemScroller$cp();
        }

        public final void setForceUseSystemScroller(boolean r5) {
            OverScrollerAdapter.access$setForceUseSystemScroller$cp(r5);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        forceUseSystemScroller = true;
    }

    public OverScrollerAdapter(Context r5, Interpolator r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "interpolator");
        this.context = r5;
        this.interpolator = r10;
        this.systemOverScroller$delegate = LazyKt.lazy(new OverScrollerAdapter$systemOverScroller$2(this));
        this.fluidScrollerX$delegate = LazyKt.lazy(OverScrollerAdapter$fluidScrollerX$2.INSTANCE);
        this.fluidScrollerY$delegate = LazyKt.lazy(OverScrollerAdapter$fluidScrollerY$2.INSTANCE);
        this.isSmoothAnimation = forceUseSystemScroller;
        this.animationStartTime = -1;
        this.animationElapsedTime = -1;
    }

    public static final /* synthetic */ Context access$getContext$p(OverScrollerAdapter r5) {
        return r5.context;
    }

    public static final /* synthetic */ boolean access$getForceUseSystemScroller$cp() {
        return forceUseSystemScroller;
    }

    public static final /* synthetic */ Interpolator access$getInterpolator$p(OverScrollerAdapter r5) {
        return r5.interpolator;
    }

    public static final /* synthetic */ void access$setForceUseSystemScroller$cp(boolean r5) {
        forceUseSystemScroller = r5;
    }

    private final FluidScroller getFluidScrollerX() {
        return (FluidScroller) this.fluidScrollerX$delegate.getValue();
    }

    private final FluidScroller getFluidScrollerY() {
        return (FluidScroller) this.fluidScrollerY$delegate.getValue();
    }

    private final OverScroller getSystemOverScroller() {
        return (OverScroller) this.systemOverScroller$delegate.getValue();
    }

    public final void abortAnimation() {
        if (this.isSmoothAnimation == false) goto L5;
        getSystemOverScroller().abortAnimation();
        return;
    L5:
        this.animationStartTime = -1;
    }

    public final boolean computeScrollOffset() {
        if (this.isSmoothAnimation == false) goto L7;
        return getSystemOverScroller().computeScrollOffset();
    L7:
        if (this.animationStartTime != (-1)) goto L10;
        return false;
    L10:
        this.animationElapsedTime = AnimationUtils.currentAnimationTimeMillis() - this.animationStartTime;
        return !isFinished();
    }

    public final void fling(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        if (forceUseSystemScroller == false) goto L6;
        getSystemOverScroller().fling(r12, r13, r14, r15, r16, r17, r18, r19);
        return;
    L6:
        this.isSmoothAnimation = false;
        float r5 = 1000;
        getFluidScrollerX().fling(r12, r14 / r5);
        getFluidScrollerY().fling(r13, r15 / r5);
        this.animationStartTime = AnimationUtils.currentAnimationTimeMillis();
    }

    public final float getCurrVelocity() {
        if (this.isSmoothAnimation == false) goto L7;
        return getSystemOverScroller().getCurrVelocity();
    L7:
        return ((float) Math.hypot(getFluidScrollerX().value(this.animationElapsedTime).getVelocity(), getFluidScrollerY().value(this.animationElapsedTime).getVelocity())) * 1000;
    }

    public final int getCurrX() {
        if (this.isSmoothAnimation == false) goto L7;
        return getSystemOverScroller().getCurrX();
    L7:
        return (int) getFluidScrollerX().value(this.animationElapsedTime).getValue();
    }

    public final int getCurrY() {
        if (this.isSmoothAnimation == false) goto L7;
        return getSystemOverScroller().getCurrY();
    L7:
        return (int) getFluidScrollerY().value(this.animationElapsedTime).getValue();
    }

    public final int getFinalX() {
        if (this.isSmoothAnimation == false) goto L7;
        return getSystemOverScroller().getFinalX();
    L7:
        return (int) getFluidScrollerX().finalOffset();
    }

    public final int getFinalY() {
        if (this.isSmoothAnimation == false) goto L7;
        return getSystemOverScroller().getFinalY();
    L7:
        return (int) getFluidScrollerY().finalOffset();
    }

    public final boolean isFinished() {
        if (this.isSmoothAnimation == true) goto L5;
        FluidScroller.ScrollValue r5 = getFluidScrollerX().value(this.animationElapsedTime);
        FluidScroller.ScrollValue r10 = getFluidScrollerY().value(this.animationElapsedTime);
        if (r5.isFinished() == true) goto L9;
    L11:
        return false;
    L9:
        if (r10.isFinished() == false) goto L11;
        return true;
    L5:
        return getSystemOverScroller().isFinished();
    }

    public final void startScroll(int r10, int r11, int r12, int r13, int r14) {
        this.isSmoothAnimation = true;
        getSystemOverScroller().startScroll(r10, r11, r12, r13, r14);
    }
}
