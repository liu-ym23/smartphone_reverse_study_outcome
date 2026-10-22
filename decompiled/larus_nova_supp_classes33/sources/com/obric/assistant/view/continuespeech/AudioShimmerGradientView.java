package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 >2\u00020\u0001:\u0002=>B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010$\u001a\u00020\u001e2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u0018\u0010&\u001a\u00020\u001e2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u0006\u0010'\u001a\u00020\u001eJ\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020\u001eH\u0014J(\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0014J\u0018\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007H\u0014J\u0010\u00105\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u0007H\u0014J\b\u00106\u001a\u00020\u001eH\u0014J\u0018\u00107\u001a\u00020\u001e2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0002J\b\u00109\u001a\u00020\u001eH\u0002J\b\u0010:\u001a\u00020\u001eH\u0002J\b\u0010;\u001a\u00020\u001eH\u0002J\b\u0010<\u001a\u00020\u0018H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006?"}, d2 = {"Lcom/obric/assistant/view/continuespeech/AudioShimmerGradientView;", "Lcom/obric/assistant/view/continuespeech/AudioGradientView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shimmerShader", "Landroid/graphics/RuntimeShader;", "shimmerPaint", "Landroid/graphics/Paint;", "shimmerWidth", "", "shimmerAngle", "shimmerBaseAlpha", "shimmerHighlightAlpha", "shimmerState", "Lcom/obric/assistant/view/continuespeech/AudioShimmerGradientView$ShimmerState;", "shimmerOffset", "shimmerCycleStartOffset", "shimmerVisible", "", "pendingShimmerStart", "shimmerAnimator", "Landroid/animation/ValueAnimator;", "shimmerStopCallback", "Lkotlin/Function0;", "", "value", "isAnimating", "()Z", "setAnimating", "(Z)V", "playShimmerOnce", "onComplete", "stopShimmerAfterComplete", "stopShimmerImmediately", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onAttachedToWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "onWindowVisibilityChanged", "onDetachedFromWindow", "appendStopCallback", "callback", "dispatchStopCallback", "ensureShimmerCycleRunningIfNeeded", "ensureShimmerCycleRunning", "isReadyToAnimate", "ShimmerState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioShimmerGradientView extends AudioGradientView {
    public static final /* synthetic */ int p0 = 0;
    public final RuntimeShader K;
    public final Paint L;
    public final float M;
    public final float N;
    public final float O;
    public final float P;
    public ShimmerState Q;
    public float R;
    public float S;
    public boolean T;
    public boolean U;
    public ValueAnimator V;
    public Function0<Unit> W;
    public boolean k0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/view/continuespeech/AudioShimmerGradientView$ShimmerState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "SCROLLING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ShimmerState extends Enum<ShimmerState> {
        public static final ShimmerState IDLE = null;
        public static final ShimmerState SCROLLING = null;
        public static final /* synthetic */ ShimmerState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ShimmerState> getEntries() {
            return b;
        }

        static {
            ShimmerState r0 = new ShimmerState("IDLE", 0);
            IDLE = r0;
            ShimmerState r1 = new ShimmerState("SCROLLING", 1);
            SCROLLING = r1;
            ShimmerState[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ShimmerState[] values() {
            return (ShimmerState[]) a.clone();
        }

        public static ShimmerState valueOf(String r1) {
            return (ShimmerState) r27.a.a(ShimmerState.class, r1);
        }

        public ShimmerState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ AudioShimmerGradientView b;

        public b(AudioShimmerGradientView r1) {
            this.b = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            AudioShimmerGradientView r0 = this.b;
            if (r0.V == r4) goto L5;
            return;
        L5:
            r0.V = null;
            if (this.a == false) goto L8;
            return;
        L8:
            r0.R = r0.S + 1.0f;
            r0.invalidate();
            AudioShimmerGradientView r1 = this.b;
            r1.Q = ShimmerState.IDLE;
            Function0<Unit> r2 = r1.W;
            r1.W = null;
            if (r2 == null) goto L12;
            r2.invoke();
            return;
        }
    }

    static {
    }

    public AudioShimmerGradientView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AudioShimmerGradientView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void d() {
        setAnimating(false);
        this.T = false;
        this.U = false;
        this.W = null;
        ValueAnimator r1 = this.V;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        this.V = null;
        this.Q = ShimmerState.IDLE;
    }

    public final void b() {
        ValueAnimator r0 = this.V;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        return;
    L11:
        if (getWidth() > 0) goto L13;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == true) goto L21;
        this.U = true;
        return;
    L21:
        this.U = false;
        this.S = this.R;
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r3.setDuration(1250);
        r3.setInterpolator(new LinearInterpolator());
        r3.addUpdateListener(new c0(this));
        r3.addListener(new b(this));
        r3.start();
        this.V = r3;
        return;
    L13:
        if (getHeight() <= 0) goto L17;
        if (isShown() == false) goto L17;
        r2 = true;
        goto L18
    L5:
        if (r0.isRunning() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void c() {
        if (this.Q == ShimmerState.IDLE) goto L5;
    L6:
        b();
        return;
    L5:
        if (this.U == true) goto L6;
    }

    @Override // com.obric.assistant.view.continuespeech.AudioGradientView, android.view.View
    public final void onDetachedFromWindow() {
        ValueAnimator r0 = this.V;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.V = null;
        if (this.Q == ShimmerState.IDLE) goto L8;
        this.U = true;
    L8:
        super.onDetachedFromWindow();
    }

    @Override // com.obric.assistant.view.continuespeech.AudioGradientView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // com.obric.assistant.view.continuespeech.AudioGradientView, android.view.View
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        if (this.T == true) goto L6;
        super.onDraw(r8);
        return;
    L6:
        float r4 = getWidth();
        float r5 = getHeight();
        if (r4 > 0.0f) goto L9;
        return;
    L9:
        if (r5 <= 0.0f) goto L14;
        float r0 = ((this.R % 1.0f) + 1.0f) % 1.0f;
        this.K.setFloatUniform("uResolution", r4, r5);
        this.K.setFloatUniform("uPhase", r0);
        this.K.setFloatUniform("uShimmerWidthRatio", this.M);
        this.K.setFloatUniform("uAngle", this.N);
        this.K.setFloatUniform("uBaseAlpha", this.O);
        this.K.setFloatUniform("uHighlightAlpha", this.P);
        r8.drawRect(0.0f, 0.0f, r4, r5, this.L);
        return;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        if (r1 != 0) goto L6;
        c();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.obric.assistant.view.continuespeech.d0] */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0<kotlin.Unit>] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.obric.assistant.view.continuespeech.AudioGradientView
    public void setAnimating(boolean r5) {
        if (this.k0 != r5) goto L5;
        return;
    L5:
        this.k0 = r5;
        final Function0 r0 = null;
        if (r5 == false) goto L11;
        Function0<Unit> r6 = new b0(this);
        this.T = true;
        this.W = r6;
        this.U = false;
        ValueAnimator r7 = this.V;
        if (r7 == null) goto L10;
        r7.cancel();
    L10:
        this.V = null;
        this.R = 0.0f;
        this.Q = ShimmerState.SCROLLING;
        b();
        return;
    L11:
        final ?? r8 = new d0(this, r0);
        final Function0<Unit> r2 = this.W;
        ?? r9 = r8;
        if (r2 == null) goto L15;
        r9 = new e0(r2, r8);
    L15:
        this.W = r9;
        if (this.U == false) goto L21;
        if (this.V != null) goto L21;
        this.U = false;
        this.Q = ShimmerState.IDLE;
    L21:
        if (this.Q != ShimmerState.IDLE) goto L25;
        this.W = null;
        r9.invoke();
        return;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (r3 != 0) goto L6;
        c();
        return;
    }

    public AudioShimmerGradientView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        RuntimeShader r0 = new RuntimeShader("\n            uniform float2 uResolution;\n            uniform float uPhase;\n            uniform float uShimmerWidthRatio;\n            uniform float uAngle;\n            uniform float uBaseAlpha;\n            uniform float uHighlightAlpha;\n\n            half4 main(float2 p) {\n                float2 center = uResolution * 0.5;\n                float2 dir = float2(cos(uAngle), sin(uAngle));\n                float projected = dot(p - center, dir);\n\n                float bandWidth = max(uResolution.x * uShimmerWidthRatio, 1.0);\n                float travel = length(uResolution) + 3.0 * bandWidth;\n                float bandPos = -travel * 0.5 + uPhase * travel;\n\n                float d = (projected - bandPos) / bandWidth;\n                float t = clamp(exp(-d * d * 6.0), 0.0, 1.0);\n\n                float alpha = mix(uBaseAlpha, uHighlightAlpha, t);\n                return half4(half(alpha));\n            }\n        ");
        this.K = r0;
        Paint r1 = new Paint();
        r1.setShader(r0);
        this.L = r1;
        this.M = 0.5f;
        this.O = 1.0f;
        this.P = 0.5f;
        this.Q = ShimmerState.IDLE;
        TypedArray r8 = r5.obtainStyledAttributes(r6, new int[]{2130968788, 2130968795, 2130968965, 2130970213, 2130974042}, r7, 0);
        this.M = r8.getFloat(4, 0.5f);     // Catch: Throwable -> L8
        this.N = r8.getFloat(0, this.N);     // Catch: Throwable -> L8
        this.O = r8.getFloat(2, 1.0f);     // Catch: Throwable -> L8
        this.P = r8.getFloat(3, 0.5f);     // Catch: Throwable -> L8
        if (r8.getBoolean(1, false) == false) goto L6;
        setAnimating(true);     // Catch: Throwable -> L8
    L6:
        r8.recycle();
        return;
    L8:
        th = move-exception;
        r8.recycle();
        throw th;
    }

    public /* synthetic */ AudioShimmerGradientView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        c();
    }
}
