package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u0000 22\u00020\u0001:\u00012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0014JF\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001fJ\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\u001fJ\u0006\u0010*\u001a\u00020\u001fJ\u0006\u0010+\u001a\u00020\u001fJ\u0006\u0010,\u001a\u00020\u001fJ\u0006\u0010-\u001a\u00020\u0014J.\u0010.\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018¨\u00063"}, d2 = {"Lcom/obric/oui/orecyclerview/base/OverScrollerAdapter;", "", "context", "Landroid/content/Context;", "interpolator", "Landroid/view/animation/Interpolator;", "(Landroid/content/Context;Landroid/view/animation/Interpolator;)V", "animationElapsedTime", "", "animationStartTime", "fluidScrollerX", "Lcom/obric/oui/orecyclerview/base/FluidScroller;", "getFluidScrollerX", "()Lcom/obric/oui/orecyclerview/base/FluidScroller;", "fluidScrollerX$delegate", "Lkotlin/Lazy;", "fluidScrollerY", "getFluidScrollerY", "fluidScrollerY$delegate", "isSmoothAnimation", "", "systemOverScroller", "Landroid/widget/OverScroller;", "getSystemOverScroller", "()Landroid/widget/OverScroller;", "systemOverScroller$delegate", "abortAnimation", "", "computeScrollOffset", "fling", "startX", "", "startY", "velocityX", "velocityY", "minX", "maxX", "minY", "maxY", "getCurrVelocity", "", "getCurrX", "getCurrY", "getFinalX", "getFinalY", "isFinished", "startScroll", "dx", "dy", "duration", "Companion", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14045a = null;
    private static boolean j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f14046b;
    private final Interpolator c;
    private final Lazy d;
    private final Lazy e;
    private final Lazy f;
    private boolean g;
    private long h;
    private long i;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/orecyclerview/base/OverScrollerAdapter$Companion;", "", "()V", "forceUseSystemScroller", "", "getForceUseSystemScroller", "()Z", "setForceUseSystemScroller", "(Z)V", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14045a = new a(null);
        j = true;
    }

    public f(Context r3, Interpolator r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Interpolator r6 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r4, Interpolator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "interpolator");
        this.f14046b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r6;
        this.d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OverScrollerAdapter$systemOverScroller$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.e = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(OverScrollerAdapter$fluidScrollerX$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        this.f = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(OverScrollerAdapter$fluidScrollerY$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        this.g = j;
        this.h = -1;
        this.i = -1;
    }

    public static final /* synthetic */ Context a(f r0) {
        return r0.f14046b;
    }

    public static final /* synthetic */ Interpolator b(f r0) {
        return r0.c;
    }

    private final OverScroller i() {
        return (OverScroller) ZeusTransformUtils.preCheckCast(this.d.getValue(), OverScroller.class, "com.obric.memorydata.plugin");
    }

    private final c j() {
        return (c) ZeusTransformUtils.preCheckCast(this.e.getValue(), c.class, "com.obric.memorydata.plugin");
    }

    private final c k() {
        return (c) ZeusTransformUtils.preCheckCast(this.f.getValue(), c.class, "com.obric.memorydata.plugin");
    }

    public final void a(int r8, int r9, int r10, int r11, int r12) {
        this.g = true;
        i().startScroll(r8, r9, r10, r11, r12);
    }

    public final void a(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        if (j == false) goto L6;
        i().fling(r12, r13, r14, r15, r16, r17, r18, r19);
        return;
    L6:
        this.g = false;
        float r4 = 1000;
        j().a(r12, r14 / r4);
        k().a(r13, r15 / r4);
        this.h = AnimationUtils.currentAnimationTimeMillis();
    }

    public final boolean a() {
        if (this.g == false) goto L7;
        return i().computeScrollOffset();
    L7:
        if (this.h != (-1)) goto L10;
        return false;
    L10:
        this.i = AnimationUtils.currentAnimationTimeMillis() - this.h;
        return !h();
    }

    public final void b() {
        if (this.g == false) goto L5;
        i().abortAnimation();
        return;
    L5:
        this.h = -1;
    }

    public final int c() {
        if (this.g == false) goto L7;
        return i().getCurrX();
    L7:
        return (int) j().a(this.i).a();
    }

    public final int d() {
        if (this.g == false) goto L7;
        return i().getCurrY();
    L7:
        return (int) k().a(this.i).a();
    }

    public final float e() {
        if (this.g == false) goto L7;
        return i().getCurrVelocity();
    L7:
        return ((float) Math.hypot(j().a(this.i).b(), k().a(this.i).b())) * 1000;
    }

    public final int f() {
        if (this.g == false) goto L7;
        return i().getFinalX();
    L7:
        return (int) j().a();
    }

    public final int g() {
        if (this.g == false) goto L7;
        return i().getFinalY();
    L7:
        return (int) k().a();
    }

    public final boolean h() {
        if (this.g == true) goto L5;
        c.b r0 = j().a(this.i);
        c.b r4 = k().a(this.i);
        if (r0.c() == true) goto L9;
    L11:
        return false;
    L9:
        if (r4.c() == false) goto L11;
        return true;
    L5:
        return i().isFinished();
    }
}
