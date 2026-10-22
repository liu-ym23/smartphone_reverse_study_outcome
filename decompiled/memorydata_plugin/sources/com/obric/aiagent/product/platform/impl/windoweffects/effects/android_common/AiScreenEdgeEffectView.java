package com.obric.aiagent.product.platform.impl.windoweffects.effects.android_common;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.loc.o;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.b;
import com.obric.aiagent.product.platform.impl.windoweffects.utils.NumberExKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ;\u0010 \u001a\u00020\u001e2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\"2#\b\u0002\u0010#\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$JR\u0010)\u001a\u00020\u001e2%\b\u0002\u0010!\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$2#\b\u0002\u0010#\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$J+\u0010*\u001a\u00020\u001e2#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$J+\u0010+\u001a\u00020\u001e2#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J(\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u000206H\u0014J\u0010\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u0018H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u0018H\u0002J\b\u0010:\u001a\u00020\u001eH\u0002J\b\u0010;\u001a\u00020\u001eH\u0002J\b\u0010<\u001a\u00020\u001eH\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b>\u0010?R\u0018\u0010B\u001a\u00020\u0018*\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects/android_common/AiScreenEdgeEffectView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "activeEffectTimeoutMs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IJ)V", "getActiveEffectTimeoutMs", "()J", "shader", "Lcom/obric/aiagent/product/platform/impl/windoweffects/effects/android_common/AiScreenEdgeEffectShader;", "paint", "Landroid/graphics/Paint;", "timeAnimator", "Landroid/animation/ValueAnimator;", "fadeAnimator", "shimmerAnimator", "captureAnimator", "currentAlpha", "", "currentCaptureProgress", "currentShimmerProgress", "isPreparedToShow", "Ljava/util/concurrent/atomic/AtomicBoolean;", "prepareToShow", "", "cancelShow", "playFadeInAnimation", "onEnd", "Lkotlin/Function0;", "onCancel", "Lkotlin/Function1;", "Landroid/animation/Animator;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "animator", "playFadeOutAnimation", "playShimmerAnimation", "playCaptureAnimation", "isPlayingShimmerAnimation", "", "isPlayingCaptureAnimation", "onSizeChanged", "w", o.g, "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setShimmerProgress", "progress", "setCaptureProgress", "initializeShader", "startTimeAnimation", "setScreenCornerRadii", "density", "getDensity", "()F", "density$delegate", "Lkotlin/Lazy;", "dp", "getDp", "(F)F", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AiScreenEdgeEffectView extends View {
    public static final Companion Companion = null;
    private static final String TAG = "AiScreenEdgeEffectView";
    private final long activeEffectTimeoutMs;
    private ValueAnimator captureAnimator;
    private float currentAlpha;
    private float currentCaptureProgress;
    private float currentShimmerProgress;
    private final Lazy density$delegate;
    private ValueAnimator fadeAnimator;
    private AtomicBoolean isPreparedToShow;
    private final Paint paint;
    private final AiScreenEdgeEffectShader shader;
    private ValueAnimator shimmerAnimator;
    private ValueAnimator timeAnimator;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects/android_common/AiScreenEdgeEffectView$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AiScreenEdgeEffectView(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public AiScreenEdgeEffectView(Context r11, AttributeSet r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public AiScreenEdgeEffectView(Context r11, AttributeSet r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r13, 0, 8, null);
    }

    public AiScreenEdgeEffectView(Context r3, AttributeSet r4, int r5, long r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r5);
        this.activeEffectTimeoutMs = r6;
        AiScreenEdgeEffectShader r9 = new AiScreenEdgeEffectShader();
        this.shader = r9;
        Paint r10 = new Paint();
        this.paint = r10;
        this.isPreparedToShow = new AtomicBoolean(false);
        setLayerType(2, null);
        setBackground(null);
        r10.setShader((Shader) ZeusTransformUtils.preCheckCast(r9, Shader.class, "com.obric.memorydata.plugin"));
        this.density$delegate = LazyKt.lazy($$Lambda$AiScreenEdgeEffectView$9_lwyiVGY2HWQSX5NNSmj3xQtng.INSTANCE);
    }

    public /* synthetic */ AiScreenEdgeEffectView(Context r4, AttributeSet r5, int r6, long r7, int r9, DefaultConstructorMarker r10) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r9 & 2) == 0) goto L5;
        r11 = null;
    L5:
        AttributeSet r12 = r11;
        if ((r9 & 4) == 0) goto L8;
        r6 = 0;
    L8:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L11;
        r7 = 300000;
    L11:
        this(r8, r12, r0, r7);
    }

    private static final float density_delegate$lambda$21() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    private final float getDensity() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.density$delegate.getValue(), Number.class, "com.obric.memorydata.plugin")).floatValue();
    }

    private final float getDp(float r1) {
        return r1 * getDensity();
    }

    private final void initializeShader() {
        this.currentAlpha = 0.0f;
        setCaptureProgress(0.0f);
        setShimmerProgress(0.0f);
        AiScreenEdgeEffectShader r1 = this.shader;
        r1.setTime(0.0f);
        r1.setAlpha(this.currentAlpha);
        r1.setCaptureProgress(this.currentCaptureProgress);
        r1.setShimmerProgress(this.currentShimmerProgress);
    }

    public static /* synthetic */ void lambda$0Dna9Z3CjhtHGgkE5mAZraiQxwg(AiScreenEdgeEffectView r0, ValueAnimator r1) {
        playShimmerAnimation$lambda$11$lambda$10(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$1EgKn6XMqNjobNRKT-jjDdOf23E, reason: not valid java name */
    public static /* synthetic */ Unit m184lambda$1EgKn6XMqNjobNRKTjjDdOf23E(Animator r0) {
        return playFadeOutAnimation$lambda$5(r0);
    }

    public static /* synthetic */ Unit lambda$4NLw9fJfQZy_fHc_9ghtv3H2BME(Animator r0) {
        return playShimmerAnimation$lambda$9(r0);
    }

    public static /* synthetic */ Unit lambda$73ssWZsqfMjPu9KSCXuzonKCC6o(Animator r0) {
        return playCaptureAnimation$lambda$12(r0);
    }

    public static /* synthetic */ Unit lambda$9P9lMQ5pZjt7hlhZ_4fUXJkoPtU() {
        return playFadeInAnimation$lambda$0();
    }

    public static /* synthetic */ float lambda$9_lwyiVGY2HWQSX5NNSmj3xQtng() {
        return density_delegate$lambda$21();
    }

    public static /* synthetic */ void lambda$BzzLLkp9VKdjhIRPhPFkGQ2MpHM(AiScreenEdgeEffectView r0, Ref.LongRef r1, long r2, ValueAnimator r4) {
        startTimeAnimation$lambda$19$lambda$18(r0, r1, r2, r4);
    }

    /* JADX INFO: renamed from: lambda$C6-1B9ZLND2pwrsGiNoMKRj0KP8, reason: not valid java name */
    public static /* synthetic */ Unit m185lambda$C61B9ZLND2pwrsGiNoMKRj0KP8(Animator r0) {
        return playFadeOutAnimation$lambda$6(r0);
    }

    /* JADX INFO: renamed from: lambda$Q59fWvy6_nFJY6a5S2-QxHYTop8, reason: not valid java name */
    public static /* synthetic */ void m186lambda$Q59fWvy6_nFJY6a5S2QxHYTop8(AiScreenEdgeEffectView r0, ValueAnimator r1) {
        playFadeInAnimation$lambda$4$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit lambda$SCr_UqSr558RQFvJTjgTC7_zWgA(Animator r0) {
        return playFadeInAnimation$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$XEobn7vfXMS1wY8oiD3S6pcnYI4(AiScreenEdgeEffectView r0, ValueAnimator r1) {
        playFadeOutAnimation$lambda$8$lambda$7(r0, r1);
    }

    public static /* synthetic */ void lambda$ptU96Egww2wlmxte94O9ugNam04(AiScreenEdgeEffectView r0, ValueAnimator r1) {
        playCaptureAnimation$lambda$14$lambda$13(r0, r1);
    }

    public static /* synthetic */ void playCaptureAnimation$default(AiScreenEdgeEffectView r1, Function1 r2, int r3, Object r4) {
        Function1<? super Animator, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$AiScreenEdgeEffectView$73ssWZsqfMjPu9KSCXuzonKCC6o.INSTANCE;
    L5:
        r1.playCaptureAnimation(r5);
    }

    private static final Unit playCaptureAnimation$lambda$12(Animator r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private static final void playCaptureAnimation$lambda$14$lambda$13(AiScreenEdgeEffectView r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.setCaptureProgress(((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin")).floatValue());
    }

    public static /* synthetic */ void playFadeInAnimation$default(AiScreenEdgeEffectView r1, Function0 r2, Function1 r3, int r4, Object r5) {
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Function1<? super Animator, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = $$Lambda$AiScreenEdgeEffectView$9P9lMQ5pZjt7hlhZ_4fUXJkoPtU.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = $$Lambda$AiScreenEdgeEffectView$SCr_UqSr558RQFvJTjgTC7_zWgA.INSTANCE;
    L8:
        r1.playFadeInAnimation(r6, r7);
    }

    private static final Unit playFadeInAnimation$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Unit playFadeInAnimation$lambda$1(Animator r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private static final void playFadeInAnimation$lambda$4$lambda$2(AiScreenEdgeEffectView r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.currentAlpha = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin")).floatValue();
    }

    public static /* synthetic */ void playFadeOutAnimation$default(AiScreenEdgeEffectView r1, Function1 r2, Function1 r3, int r4, Object r5) {
        Function1<? super Animator, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Function1<? super Animator, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = $$Lambda$AiScreenEdgeEffectView$1EgKn6XMqNjobNRKTjjDdOf23E.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = $$Lambda$AiScreenEdgeEffectView$C61B9ZLND2pwrsGiNoMKRj0KP8.INSTANCE;
    L8:
        r1.playFadeOutAnimation(r6, r7);
    }

    private static final Unit playFadeOutAnimation$lambda$5(Animator r0) {
        return Unit.INSTANCE;
    }

    private static final Unit playFadeOutAnimation$lambda$6(Animator r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private static final void playFadeOutAnimation$lambda$8$lambda$7(AiScreenEdgeEffectView r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        float r5 = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin")).floatValue();
        r2.currentAlpha = r5;
        r2.shader.setAlpha(r5);
    }

    public static /* synthetic */ void playShimmerAnimation$default(AiScreenEdgeEffectView r1, Function1 r2, int r3, Object r4) {
        Function1<? super Animator, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$AiScreenEdgeEffectView$4NLw9fJfQZy_fHc_9ghtv3H2BME.INSTANCE;
    L5:
        r1.playShimmerAnimation(r5);
    }

    private static final void playShimmerAnimation$lambda$11$lambda$10(AiScreenEdgeEffectView r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.setShimmerProgress(((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin")).floatValue());
    }

    private static final Unit playShimmerAnimation$lambda$9(Animator r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private final void setCaptureProgress(float r1) {
        this.currentCaptureProgress = r1;
    }

    private final void setScreenCornerRadii() {
        AiScreenEdgeEffectShader r0 = this.shader;
        String r1 = b.f5974a.b().c();
        switch(r1.hashCode()) {
            case -2002884280: goto L21;
            case -2002884275: goto L18;
            case -1048984789: goto L14;
            case -807117175: goto L12;
            case 3440915: goto L9;
            case 1328894480: goto L6;
            default: goto L25;
        };
    L12:
        r1.equals("pacific");
    L25:
        r0.setScreenCornerRadii(getDp(44.0f), getDp(44.0f), getDp(42.0f), getDp(42.0f));
        return;
    L6:
        if (r1.equals("nerida-lite") == false) goto L25;
    L16:
        float r2 = 47.0f;
    L24:
        r0.setScreenCornerRadii(getDp(r2), getDp(r2), getDp(r2), getDp(r2));
        return;
    L9:
        if (r1.equals("pike") == false) goto L25;
        r0.setScreenCornerRadii(134.0f, 134.0f, 134.0f, 134.0f);
        return;
    L14:
        if (r1.equals("nerida") == true) goto L16;
    L18:
        if (r1.equals("Genesis-R") == false) goto L25;
    L23:
        r2 = 57.0f;
        goto L24
    L21:
        if (r1.equals("Genesis-M") == true) goto L23;
        goto L23
    }

    private final void setShimmerProgress(float r1) {
        this.currentShimmerProgress = r1;
    }

    private final void startTimeAnimation() {
        ValueAnimator r0 = this.timeAnimator;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, Float.MAX_VALUE});
        r2.setDuration(Long.MAX_VALUE);
        r2.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new LinearInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r2.setRepeatCount(-1);
        final Ref.LongRef r3 = new Ref.LongRef();
        final long r4 = SystemClock.elapsedRealtime();
        r2.addUpdateListener(new $$Lambda$AiScreenEdgeEffectView$BzzLLkp9VKdjhIRPhPFkGQ2MpHM(this, r3, r4));
        r2.start();
        this.timeAnimator = r2;
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
        goto L7
    }

    private static final void startTimeAnimation$lambda$19$lambda$18(AiScreenEdgeEffectView r6, Ref.LongRef r7, long r8, ValueAnimator r10) {
        Intrinsics.checkNotNullParameter(r10, "animator");
        AiScreenEdgeEffectShader r0 = r6.shader;
        r0.setTime((r10.getCurrentPlayTime() / 1000.0f) % 1000.0f);
        r0.setAlpha(r6.currentAlpha);
        float r1 = 1.0f;
        if (r6.isPlayingShimmerAnimation() == false) goto L5;
        float r11 = r6.currentShimmerProgress;
    L6:
        r0.setShimmerProgress(r11);
        if (r6.isPlayingCaptureAnimation() == false) goto L9;
        r1 = r6.currentCaptureProgress;
    L9:
        r0.setCaptureProgress(r1);
        long r2 = SystemClock.elapsedRealtime();
        if ((r2 - r7.element) < 1000) goto L14;
        r7.element = r2;
        long r3 = r2 - r8;
        d.f5954a.b(TAG, "is animating. played time = " + r3 + " ms");
        if (r3 < r6.activeEffectTimeoutMs) goto L14;
        d.f5954a.b(TAG, "time out for " + r3 + " ms");
        r6.cancelShow();
    L14:
        r6.invalidate();
        return;
    L5:
        r11 = 1.0f;
        goto L6
    }

    public final void cancelShow() {
        d.f5954a.b(TAG, "cancelShow");
        setVisibility(8);
        this.isPreparedToShow.set(false);
        ValueAnimator r0 = this.timeAnimator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ValueAnimator r1 = this.fadeAnimator;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        ValueAnimator r2 = this.shimmerAnimator;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        ValueAnimator r3 = this.captureAnimator;
        if (r3 == null) goto L14;
        r3.cancel();
    L14:
        this.timeAnimator = null;
        this.fadeAnimator = null;
        this.shimmerAnimator = null;
        this.captureAnimator = null;
    }

    public final long getActiveEffectTimeoutMs() {
        return this.activeEffectTimeoutMs;
    }

    public final boolean isPlayingCaptureAnimation() {
        ValueAnimator r2 = this.captureAnimator;
        if (r2 == null) goto L8;
        if (r2.isRunning() != true) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean isPlayingShimmerAnimation() {
        ValueAnimator r2 = this.shimmerAnimator;
        if (r2 == null) goto L8;
        if (r2.isRunning() != true) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (r2.isHardwareAccelerated() == true) goto L5;
        return;
    L5:
        super.onDraw(r2);
        r2.drawPaint(this.paint);
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        AiScreenEdgeEffectShader r5 = this.shader;
        r5.setResolution(r1, r2);
        r5.setDensity(Resources.getSystem().getDisplayMetrics().density);
        setScreenCornerRadii();
    }

    public final void playCaptureAnimation(Function1<? super Animator, Unit> r5) {
        final Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "onEnd");
        d.f5954a.b(TAG, "playCaptureAnimation");
        ValueAnimator r0 = this.captureAnimator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.setDuration(882);
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new SmoothInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r1.addUpdateListener(new $$Lambda$AiScreenEdgeEffectView$ptU96Egww2wlmxte94O9ugNam04(this));
        Intrinsics.checkNotNull(r1);
        Animator r2 = (Animator) ZeusTransformUtils.preCheckCast(r1, Animator.class, "com.obric.memorydata.plugin");
        Animator.AnimatorListener r3 = new AiScreenEdgeEffectView$playCaptureAnimation$lambda$14$$inlined$addListener$default$1(r6);
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        Animator.AnimatorListener r7 = (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        r1.start();
        this.captureAnimator = r1;
    }

    public final void playFadeInAnimation(Function0<Unit> r8, Function1<? super Animator, Unit> r9) {
        final Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        final Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "onEnd");
        Intrinsics.checkNotNullParameter(r11, "onCancel");
        d.f5954a.b(TAG, "playFadeInAnimation");
        ValueAnimator r0 = this.fadeAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (NumberExKt.equalsEpsilon$default(this.currentAlpha, 1.0f, 0.0f, 2, null) == false) goto L9;
        d.f5954a.b(TAG, "playFadeInAnimation: no need to play");
        r10.invoke();
        return;
    L9:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{this.currentAlpha, 1.0f});
        r1.setDuration(300);
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r1.addUpdateListener(new $$Lambda$AiScreenEdgeEffectView$Q59fWvy6_nFJY6a5S2QxHYTop8(this));
        Intrinsics.checkNotNull(r1);
        Animator r2 = (Animator) ZeusTransformUtils.preCheckCast(r1, Animator.class, "com.obric.memorydata.plugin");
        Animator.AnimatorListener r3 = new AiScreenEdgeEffectView$playFadeInAnimation$lambda$4$$inlined$addListener$default$1(r11, r10);
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        Animator.AnimatorListener r12 = (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        r1.start();
        this.fadeAnimator = r1;
    }

    public final void playFadeOutAnimation(Function1<? super Animator, Unit> r7, Function1<? super Animator, Unit> r8) {
        final Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        final Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "onEnd");
        Intrinsics.checkNotNullParameter(r10, "onCancel");
        d.f5954a.b(TAG, "playFadeOutAnimation");
        ValueAnimator r0 = this.fadeAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (NumberExKt.equalsEpsilon$default(this.currentAlpha, 0.0f, 0.0f, 2, null) == false) goto L9;
        d.f5954a.b(TAG, "playFadeOutAnimation: no need to play");
        r9.invoke(null);
        return;
    L9:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{this.currentAlpha, 0.0f});
        r1.setDuration(100);
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new LinearInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r1.addUpdateListener(new $$Lambda$AiScreenEdgeEffectView$XEobn7vfXMS1wY8oiD3S6pcnYI4(this));
        Intrinsics.checkNotNull(r1);
        Animator r2 = (Animator) ZeusTransformUtils.preCheckCast(r1, Animator.class, "com.obric.memorydata.plugin");
        Animator.AnimatorListener r3 = new AiScreenEdgeEffectView$playFadeOutAnimation$lambda$8$$inlined$addListener$default$1(r9, r10);
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        Animator.AnimatorListener r11 = (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        r1.start();
        this.fadeAnimator = r1;
    }

    public final void playShimmerAnimation(Function1<? super Animator, Unit> r6) {
        final Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "onEnd");
        d.f5954a.b(TAG, "playShimmerAnimation");
        ValueAnimator r0 = this.shimmerAnimator;
        boolean r3 = true;
        if (r0 != null) goto L5;
    L7:
        r3 = false;
    L8:
        if (r3 == false) goto L11;
        d.f5954a.b(TAG, "playShimmerAnimation: is playing shimmer animation");
        return;
    L11:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.setDuration(882);
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new SmoothInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r1.addUpdateListener(new $$Lambda$AiScreenEdgeEffectView$0Dna9Z3CjhtHGgkE5mAZraiQxwg(this));
        Intrinsics.checkNotNull(r1);
        Animator r2 = (Animator) ZeusTransformUtils.preCheckCast(r1, Animator.class, "com.obric.memorydata.plugin");
        Animator.AnimatorListener r4 = new AiScreenEdgeEffectView$playShimmerAnimation$lambda$11$$inlined$addListener$default$1(r7, r7);
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r4, Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        Animator.AnimatorListener r8 = (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r4, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        r1.start();
        this.shimmerAnimator = r1;
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
        goto L7
    }

    public final void prepareToShow() {
        d.f5954a.b(TAG, "prepareToShow");
        if (this.isPreparedToShow.compareAndSet(false, true) == false) goto L6;
        setVisibility(0);
        initializeShader();
        startTimeAnimation();
        return;
    }
}
