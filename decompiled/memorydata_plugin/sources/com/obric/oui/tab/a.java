package com.obric.oui.tab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 D2\u00020\u0001:\u0001DB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0002J>\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fJ\u0010\u0010-\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\nH\u0002J\u0006\u0010/\u001a\u00020\nJ\b\u00100\u001a\u00020\u001cH\u0002J\u0006\u00101\u001a\u00020\fJ \u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0002J\b\u00106\u001a\u00020\fH\u0002J\u0010\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\nH\u0002J\u0010\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\fH\u0002J\u000e\u0010;\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020\nJ\u0016\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u0015J\u0006\u0010A\u001a\u00020\fJ\u0006\u0010B\u001a\u00020\fJ\u001e\u0010C\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/obric/oui/tab/OTabLayoutEdgeFadeHelper;", "", "()V", "animator", "Landroid/animation/ValueAnimator;", "dstInXfermode", "Landroid/graphics/PorterDuffXfermode;", "edgeFadePaint", "Landroid/graphics/Paint;", "edgeFadeShaderLength", "", "enabled", "", "fadeLength", "lastTargetLeftStrength", "lastTargetRightStrength", "leftEdgeFadeMatrix", "Landroid/graphics/Matrix;", "leftEdgeFadeShader", "Landroid/graphics/LinearGradient;", "leftEdgeFadeShaderAlpha", "", "leftFadeStrength", "rightEdgeFadeMatrix", "rightEdgeFadeShader", "rightEdgeFadeShaderAlpha", "rightFadeStrength", "animateFadeStrength", "", "targetLeftStrength", "targetRightStrength", "invalidateView", "Landroid/view/View;", "clearAnimatorReference", "animation", "Landroid/animation/Animator;", "drawOverlay", "canvas", "Landroid/graphics/Canvas;", "left", "top", "right", "bottom", "showLeftFade", "showRightFade", "ensureLeftEdgeFadeShader", "ensureRightEdgeFadeShader", "getFadeLength", "invalidateShaders", "isEnabled", "lerp", CommonConsts.APM_INNER_EVENT_COST_START, "end", "fraction", "resetFadeState", "resolveEdgeAlpha", "strength", "resolveTargetStrength", "visible", "setEnabled", "setFadeLength", "lengthPx", "shouldApply", "width", "height", "shouldDrawLeftFade", "shouldDrawRightFade", "updateFadeVisibility", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0780a f14548a = null;
    private static final float[] r = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f14549b;
    private final PorterDuffXfermode c;
    private final Matrix d;
    private final Matrix e;
    private boolean f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private LinearGradient l;
    private LinearGradient m;
    private float n;
    private int o;
    private int p;
    private ValueAnimator q;

    /* JADX INFO: renamed from: com.obric.oui.tab.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/oui/tab/OTabLayoutEdgeFadeHelper$Companion;", "", "()V", "DEFAULT_EDGE_FADE_LENGTH_DP", "", "EDGE_FADE_ANIM_DURATION_MS", "", "EDGE_FADE_POSITIONS", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0780a {
        private C0780a() {
        }

        public /* synthetic */ C0780a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/oui/tab/OTabLayoutEdgeFadeHelper$animateFadeStrength$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f14550a;

        b(a r1) {
            this.f14550a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            a.a(this.f14550a, r2);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            a.a(this.f14550a, r2);
        }
    }

    static {
        f14548a = new C0780a(null);
        r = new float[]{0.0f, 1.0f};
    }

    public a() {
        this.f14549b = new Paint(1);
        this.c = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.d = new Matrix();
        this.e = new Matrix();
        this.n = -1.0f;
        this.o = -1;
        this.p = -1;
    }

    private final float a(float r2, float r3, float r4) {
        return r2 + ((r3 - r2) * RangesKt.coerceIn(r4, 0.0f, 1.0f));
    }

    private final void a(final float r11, final float r12, final View r13) {
        boolean r1 = true;
        if (this.j != r11) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L13:
        final float r5 = this.h;
        final float r7 = this.i;
        this.j = r11;
        this.k = r12;
        if (r5 != r11) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == true) goto L19;
    L24:
        ValueAnimator r3 = this.q;
        if (r3 == null) goto L28;
        r3.cancel();
    L28:
        ValueAnimator r4 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r4.setDuration(Math.max(1, (long) (120 * Math.max(Math.abs(r11 - r5), Math.abs(r12 - r7)))));
        r4.addUpdateListener(new $$Lambda$a$lDlyBXhXQjno7k11UKHZm9YQ1g(this, r5, r11, r7, r12, r13));
        r4.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new b(this), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        this.q = r4;
        if (r4 == null) goto L33;
        r4.start();
        return;
    L33:
        return;
    L19:
        if (r7 == r12) goto L22;
        r1 = false;
    L22:
        if (r1 == false) goto L24;
        return;
    L16:
        r2 = false;
        goto L17
    L8:
        if (this.k != r12) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L13;
        return;
    L10:
        r6 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    private final void a(Animator r2) {
        if (this.q != r2) goto L6;
        this.q = null;
        return;
    }

    private static final void a(a r2, float r3, float r4, float r5, float r6, View r7, ValueAnimator r8) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r7, "$invalidateView");
        Intrinsics.checkNotNullParameter(r8, "it");
        Object r9 = r8.getAnimatedValue();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type kotlin.Float");
        float r10 = ((Float) ZeusTransformUtils.preCheckCast(r9, Float.class, "com.obric.memorydata.plugin")).floatValue();
        r2.h = r2.a(r3, r4, r10);
        r2.i = r2.a(r5, r6, r10);
        r7.invalidate();
    }

    public static final /* synthetic */ void a(a r0, Animator r1) {
        r0.a(r1);
    }

    private final float b(boolean r1) {
        if (r1 == false) goto L4;
        return 1.0f;
    L4:
        return 0.0f;
    }

    private final LinearGradient b(float r14) {
        int r0 = d(this.h);
        LinearGradient r1 = this.l;
        if (r1 != null) goto L5;
    L12:
        LinearGradient r2 = new LinearGradient(0.0f, 0.0f, r14, 0.0f, new int[]{Color.argb(r0, 0, 0, 0), Color.argb(255, 0, 0, 0)}, r, Shader.TileMode.CLAMP);
        this.l = r2;
        this.n = r14;
        this.o = r0;
        return r2;
    L5:
        if (this.n != r14) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L12;
        if (this.o != r0) goto L12;
        return r1;
    L7:
        r4 = false;
        goto L8
    }

    private final LinearGradient c(float r14) {
        int r0 = d(this.i);
        LinearGradient r1 = this.m;
        if (r1 != null) goto L5;
    L12:
        LinearGradient r2 = new LinearGradient(0.0f, 0.0f, r14, 0.0f, new int[]{Color.argb(255, 0, 0, 0), Color.argb(r0, 0, 0, 0)}, r, Shader.TileMode.CLAMP);
        this.m = r2;
        this.n = r14;
        this.p = r0;
        return r2;
    L5:
        if (this.n != r14) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L12;
        if (this.p != r0) goto L12;
        return r1;
    L7:
        r4 = false;
        goto L8
    }

    private final int d(float r3) {
        return MathKt.roundToInt(255 * (1.0f - RangesKt.coerceIn(r3, 0.0f, 1.0f)));
    }

    private final boolean d() {
        if (a() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        ValueAnimator r1 = this.q;
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        this.q = null;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        e();
        return r0;
    L5:
        if (b() == true) goto L8;
        r0 = false;
        goto L9
    }

    private final void e() {
        this.n = -1.0f;
        this.l = null;
        this.m = null;
        this.o = -1;
        this.p = -1;
    }

    /* JADX INFO: renamed from: lambda$lDlyBXhX-Qjno7k11UKHZm9YQ1g, reason: not valid java name */
    public static /* synthetic */ void m1374lambda$lDlyBXhXQjno7k11UKHZm9YQ1g(a r0, float r1, float r2, float r3, float r4, View r5, ValueAnimator r6) {
        a(r0, r1, r2, r3, r4, r5, r6);
    }

    public final void a(Canvas r13, float r14, float r15, float r16, float r17, boolean r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        float r8 = Math.min(this.g, ((int) (r16 - r14)) / 2.0f);
        if (r8 > 0.0f) goto L5;
        return;
    L5:
        this.f14549b.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(this.c, Xfermode.class, "com.obric.memorydata.plugin"));
        if (r18 == false) goto L10;
        float r1 = this.h * r8;
        if (r1 <= 0.0f) goto L10;
        LinearGradient r3 = b(r8);
        this.d.reset();
        this.d.setScale(r1 / r8, 1.0f);
        this.d.postTranslate(r14, 0.0f);
        r3.setLocalMatrix(this.d);
        this.f14549b.setShader((Shader) ZeusTransformUtils.preCheckCast(r3, Shader.class, "com.obric.memorydata.plugin"));
        r13.drawRect(r14, r15, r14 + r1, r17, this.f14549b);
    L10:
        if (r19 == false) goto L14;
        float r2 = this.i * r8;
        if (r2 <= 0.0f) goto L14;
        LinearGradient r4 = c(r8);
        this.e.reset();
        this.e.setScale(r2 / r8, 1.0f);
        float r5 = r16 - r2;
        this.e.postTranslate(r5, 0.0f);
        r4.setLocalMatrix(this.e);
        this.f14549b.setShader((Shader) ZeusTransformUtils.preCheckCast(r4, Shader.class, "com.obric.memorydata.plugin"));
        r13.drawRect(r5, r15, r16, r17, this.f14549b);
    L14:
        this.f14549b.setShader(null);
        this.f14549b.setXfermode(null);
    }

    public final void a(boolean r3, boolean r4, View r5) {
        Intrinsics.checkNotNullParameter(r5, "invalidateView");
        if (this.f == false) goto L10;
        if (this.g <= 0.0f) goto L10;
        a(b(r3), b(r4), r5);
        return;
    L10:
        if (d() == false) goto L13;
        r5.invalidate();
        return;
    }

    public final boolean a() {
        if (this.h <= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean a(float r4) {
        float r5 = RangesKt.coerceAtLeast(r4, 0.0f);
        if (this.g != r5) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        this.g = r5;
        e();
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean a(int r3, int r4) {
        if (this.f == true) goto L5;
    L13:
        return false;
    L5:
        if (this.g <= 0.0f) goto L13;
        if (r3 <= 0) goto L13;
        if (r4 <= 0) goto L13;
        if (a() == false) goto L11;
    L12:
        return true;
    L11:
        if (b() == false) goto L13;
        goto L12
    }

    public final boolean a(boolean r2) {
        if (this.f != r2) goto L6;
        return false;
    L6:
        this.f = r2;
        return true;
    }

    public final boolean b() {
        if (this.i <= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public final float c() {
        return this.g;
    }
}
