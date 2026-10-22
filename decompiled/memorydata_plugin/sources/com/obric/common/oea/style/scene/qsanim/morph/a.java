package com.obric.common.oea.style.scene.qsanim.morph;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.common.oea.style.scene.qsanim.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 N2\u00020\u0001:\u0001NB_\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\b\u00102\u001a\u00020\u001cH\u0002J4\u00103\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b042\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0005H\u0014J\u0006\u00109\u001a\u00020\u001cJ\b\u0010:\u001a\u00020\u001cH\u0002J\u0016\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005J\u0006\u0010>\u001a\u00020\u001cJ\r\u0010?\u001a\u00020@H\u0000¢\u0006\u0002\bAJ\u0006\u0010B\u001a\u00020\u001cJ\b\u0010C\u001a\u00020\rH\u0002J\u0018\u0010D\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0002J\u0006\u0010E\u001a\u00020\u001cJ\u0015\u0010F\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020@H\u0000¢\u0006\u0002\bHJ\u0016\u0010I\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0005J\u0016\u0010L\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005J\b\u0010M\u001a\u00020\rH\u0002R\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000RW\u0010\u0015\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0011¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u001a\u0010$\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010'R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100RW\u00101\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0011¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/ViewMorphAnimHelper;", "", "view", "Landroid/view/View;", "morphFactorX", "", "morphFactorY", "leftMorphStartForce", "", "rightMorphStartForce", "upMorphStartForce", "downMorphStartForce", "invertYDirection", "", "invertXDirection", "(Landroid/view/View;FFIIIIZZ)V", "currentResetAnimH", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation;", "currentResetAnimW", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "heightUpdateListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "animation", EventBody.KEY_VALUE, "velocity", "", "initialDownPoint", "Landroid/graphics/PointF;", "initialViewX", "initialViewY", "getMorphFactorX", "()F", "getMorphFactorY", "originalHeight", "getOriginalHeight", "setOriginalHeight", "(F)V", "originalWidth", "getOriginalWidth", "setOriginalWidth", "pHeight", "Lcom/obric/common/oea/style/scene/qsanim/common/SpringAnimUtils$CommonFloatProperty;", "pWidth", "touchDownWhenAnimRunning", "getView", "()Landroid/view/View;", "widthUpdateListener", "animResetView", "calculateNewSize", "Lkotlin/Pair;", "x", "y", "dx", "dy", "cancelAnim", "cancelResetAnim", "dragContinue", "forceX", "forceY", "dragEnd", "getOriginalViewParams", "Lcom/obric/common/oea/style/scene/qsanim/common/AnimViewParams;", "getOriginalViewParams$style_standardRelease", CommonConsts.APM_INNER_EVENT_COST_INIT, "isAnimRunning", "performViewMorph", "release", "setOriginalViewParams", "viewParams", "setOriginalViewParams$style_standardRelease", "setOriginalViewSize", "width", "height", "startDrag", "updateViewSize", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0383a f7835a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c.a f7836b;
    private c.a c;
    private float d;
    private float e;
    private float f;
    private float g;
    private PointF h;
    private com.obric.common.oea.foundation.animation.c.b<?> i;
    private com.obric.common.oea.foundation.animation.c.b<?> j;
    private boolean k;
    private final Function3<com.obric.common.oea.foundation.animation.c.b<?>, Float, Float, Unit> l;
    private final Function3<com.obric.common.oea.foundation.animation.c.b<?>, Float, Float, Unit> m;
    private final View n;
    private final float o;
    private final float p;
    private final int q;
    private final int r;
    private final int s;
    private final int t;
    private final boolean u;
    private final boolean v;

    /* JADX INFO: renamed from: com.obric.common.oea.style.scene.qsanim.morph.a$a, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/ViewMorphAnimHelper$Companion;", "", "()V", "TAG", "", "instanceNumber", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0383a {
        private C0383a() {
        }

        public /* synthetic */ C0383a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final class b implements com.obric.common.oea.foundation.animation.c.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function3 f7837a;

        b(Function3 r3) {
            this.f7837a = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.common.oea.foundation.animation.c.b.c
        public final /* synthetic */ void a(com.obric.common.oea.foundation.animation.c.b r1, float r2, float r3) {
            Intrinsics.checkNotNullExpressionValue(this.f7837a.invoke(r1, Float.valueOf(r2), Float.valueOf(r3)), "invoke(...)");
        }
    }

    static {
        f7835a = new C0383a(null);
    }

    public static final /* synthetic */ float a(a r0) {
        return r0.g;
    }

    public static final /* synthetic */ float b(a r0) {
        return r0.f;
    }

    private final void c(float r7, float r8) {
        if (this.o == 0.0f) goto L5;
    L8:
        float r0 = r7 - this.h.x;
        int r3 = -1;
        if (this.v == false) goto L11;
        int r2 = -1;
    L12:
        float r1 = r0 * r2;
        float r4 = r8 - this.h.y;
        if (this.u == true) goto L16;
        r3 = 1;
    L16:
        float r5 = r4 * r3;
        Pair<Integer, Integer> r9 = a(r7, r8, r1, r5);
        if (((Number) ZeusTransformUtils.preCheckCast(r9.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue() != this.e) goto L21;
        if (((Number) ZeusTransformUtils.preCheckCast(r9.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue() != this.d) goto L21;
        return;
    L21:
        if (this.o == 0.0f) goto L28;
        if (r1 >= 0) goto L25;
        float r10 = this.g - (((Number) ZeusTransformUtils.preCheckCast(r9.getFirst(), Number.class, "com.obric.memorydata.plugin")).floatValue() - this.d);
    L26:
        this.n.setX(r10);
        goto L28
    L25:
        r10 = this.g;
    L28:
        if (this.p != 0.0f) goto L30;
    L34:
        ViewGroup.LayoutParams r11 = this.n.getLayoutParams();
        r11.width = ((Number) ZeusTransformUtils.preCheckCast(r9.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue();
        r11.height = ((Number) ZeusTransformUtils.preCheckCast(r9.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue();
        this.n.requestLayout();
        return;
    L30:
        if (r5 >= 0) goto L32;
        float r12 = this.f - (((Number) ZeusTransformUtils.preCheckCast(r9.getSecond(), Number.class, "com.obric.memorydata.plugin")).floatValue() - this.e);
    L33:
        this.n.setY(r12);
        goto L34
    L32:
        r12 = this.f;
        goto L33
    L11:
        r2 = 1;
        goto L12
    L5:
        if (this.p != 0.0f) goto L8;
        com.obric.common.oea.foundation.a.b.f7661a.c("ViewMorphAnimHelper", "performViewMorph: morphFactorX and morphFactorY are both zero, skip");
    }

    private final void h() {
        com.obric.common.oea.foundation.animation.c.b<?> r0 = this.i;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        com.obric.common.oea.foundation.animation.c.b<?> r1 = this.i;
        if (r1 == null) goto L11;
        Function3<com.obric.common.oea.foundation.animation.c.b<?>, Float, Float, Unit> r2 = this.l;
        Object r3 = r2;
        if (r2 == null) goto L10;
        r3 = new b(r2);
    L10:
        r1.b((com.obric.common.oea.foundation.animation.c.b.c) ZeusTransformUtils.preCheckCast(r3, com.obric.common.oea.foundation.animation.c.b.c.class, "com.obric.memorydata.plugin"));
    L11:
        com.obric.common.oea.foundation.animation.c.b<?> r4 = this.j;
        if (r4 == null) goto L14;
        r4.b();
    L14:
        com.obric.common.oea.foundation.animation.c.b<?> r5 = this.j;
        if (r5 == null) goto L20;
        Function3<com.obric.common.oea.foundation.animation.c.b<?>, Float, Float, Unit> r6 = this.m;
        Object r7 = r6;
        if (r6 == null) goto L19;
        r7 = new b(r6);
    L19:
        r5.b((com.obric.common.oea.foundation.animation.c.b.c) ZeusTransformUtils.preCheckCast(r7, com.obric.common.oea.foundation.animation.c.b.c.class, "com.obric.memorydata.plugin"));
    L20:
        c.f7829a.a(this.f7836b, c.f7829a.a());
        c.f7829a.a(this.c, c.f7829a.a());
    }

    private final void i() {
        float r0 = this.n.getWidth();
        float r1 = this.n.getHeight();
        com.obric.common.oea.foundation.a.b.f7661a.b("ViewMorphAnimHelper", "animResetView, " + r0 + ", " + r1 + ", " + this.d + ", " + this.e);
        c r5 = c.f7829a;
        c.a r6 = this.f7836b;
        r6.a(r0);
        Unit r2 = Unit.INSTANCE;
        com.obric.common.oea.foundation.animation.c.c<c.a> r7 = c.f7829a.a();
        float r8 = this.d;
        Function3<com.obric.common.oea.foundation.animation.c.b<?>, Float, Float, Unit> r3 = this.l;
        Object r4 = r3;
        if (r3 == null) goto L5;
        r4 = new b(r3);
    L5:
        this.i = (com.obric.common.oea.foundation.animation.c.b) ZeusTransformUtils.preCheckCast(c.a(r5, r6, r7, r8, 0.0f, 0.0f, (com.obric.common.oea.foundation.animation.c.b.c) ZeusTransformUtils.preCheckCast(r4, com.obric.common.oea.foundation.animation.c.b.c.class, "com.obric.memorydata.plugin"), null, 44, null), com.obric.common.oea.foundation.animation.c.b.class, "com.obric.memorydata.plugin");
        c r9 = c.f7829a;
        c.a r10 = this.c;
        r10.a(r1);
        Unit r11 = Unit.INSTANCE;
        com.obric.common.oea.foundation.animation.c.c<c.a> r12 = c.f7829a.a();
        float r13 = this.e;
        Function3<com.obric.common.oea.foundation.animation.c.b<?>, Float, Float, Unit> r14 = this.m;
        Object r15 = r14;
        if (r14 == null) goto L8;
        r15 = new b(r14);
    L8:
        this.j = (com.obric.common.oea.foundation.animation.c.b) ZeusTransformUtils.preCheckCast(c.a(r9, r10, r12, r13, 0.0f, 0.0f, (com.obric.common.oea.foundation.animation.c.b.c) ZeusTransformUtils.preCheckCast(r15, com.obric.common.oea.foundation.animation.c.b.c.class, "com.obric.memorydata.plugin"), null, 44, null), com.obric.common.oea.foundation.animation.c.b.class, "com.obric.memorydata.plugin");
    }

    private final boolean j() {
        com.obric.common.oea.foundation.animation.c.b<?> r0 = this.j;
        if (r0 != null) goto L5;
    L6:
        com.obric.common.oea.foundation.animation.c.b<?> r2 = this.i;
        if (r2 != null) goto L9;
    L11:
        return false;
    L9:
        if (r2.c() != true) goto L11;
        return true;
    L5:
        if (r0.c() != true) goto L6;
        return true;
    }

    public final float a() {
        return this.d;
    }

    public Pair<Integer, Integer> a(float r12, float r13, float r14, float r15) {
        float r0 = 0;
        if (r14 <= r0) goto L5;
        float r1 = RangesKt.coerceAtLeast(r12 - this.r, 0.0f);
    L6:
        float r4 = r1;
        if (r15 <= r0) goto L9;
        float r2 = RangesKt.coerceAtMost(r13 - this.t, 0.0f);
    L11:
        if (this.o == 0.0f) goto L14;
        com.obric.common.oea.foundation.a.b.f7661a.b("ViewMorphAnimHelper", "calculateNewSize, x: " + r12 + ", dx: " + r14 + ", coercedDx: " + r4 + ", leftStart: " + this.q + ", rightStart: " + this.r);
    L14:
        if (this.p == 0.0f) goto L16;
        com.obric.common.oea.foundation.a.b.f7661a.b("ViewMorphAnimHelper", "calculateNewSize, y: " + r13 + ", dy: " + r15 + ", coercedDy: " + r2 + ", upStart: " + this.s + ", downStart: " + this.t);
    L16:
        float r16 = com.obric.common.oea.style.scene.qsanim.a.b.a(com.obric.common.oea.style.scene.qsanim.a.b.f7828a, r4, this.d * this.o, 0.0f, 4, null);
        float r17 = com.obric.common.oea.style.scene.qsanim.a.b.a(com.obric.common.oea.style.scene.qsanim.a.b.f7828a, r2, this.e * this.p, 0.0f, 4, null);
        float r18 = this.n.getWidth();
        float r19 = this.n.getHeight();
        float r3 = ((r18 * r17) * (-1.0f)) / r19;
        float r110 = ((r19 * r16) * (-1.0f)) / r18;
        return new Pair(Integer.valueOf(MathKt.roundToInt((this.d + r16) + r3)), Integer.valueOf(MathKt.roundToInt((this.e + r17) + r110)));
    L9:
        r2 = RangesKt.coerceAtLeast(r13 - this.s, 0.0f);
        goto L11
    L5:
        r1 = RangesKt.coerceAtMost(r12 - this.q, 0.0f);
        goto L6
    }

    public final void a(float r3, float r4) {
        if (j() == false) goto L5;
        boolean r0 = true;
    L6:
        this.k = r0;
        com.obric.common.oea.foundation.a.b.f7661a.b("ViewMorphAnimHelper", "startDrag, x: " + r3 + ", y: " + r4);
        return;
    L5:
        this.h = new PointF(r3, r4);
        r0 = false;
        goto L6
    }

    public final float b() {
        return this.e;
    }

    public final void b(float r3, float r4) {
        if (j() == false) goto L5;
    L7:
        com.obric.common.oea.foundation.a.b.f7661a.b("ViewMorphAnimHelper", "dragContinue, x: " + r3 + ", y: " + r4);
        return;
    L5:
        if (this.k == true) goto L7;
        c(r3, r4);
        goto L7
    }

    public final void c() {
        h();
    }

    public final void d() {
        if (j() == false) goto L5;
    L7:
        com.obric.common.oea.foundation.a.b.f7661a.b("ViewMorphAnimHelper", "dragEnd");
        return;
    L5:
        if (this.k == true) goto L7;
        i();
        goto L7
    }

    public final View e() {
        return this.n;
    }

    public final float f() {
        return this.o;
    }

    public final float g() {
        return this.p;
    }
}
