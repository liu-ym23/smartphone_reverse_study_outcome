package com.obric.aiagent.product.platform.impl.windoweffects;

import android.animation.Animator;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.obric.aiagent.platform.a.a;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.b;
import com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects;
import com.obric.aiagent.product.platform.impl.windoweffects.effects.android_common.AiScreenEdgeEffectView;
import com.obric.aiagent.product.platform.impl.windoweffects.effects.os_specific.OSGlobalEffectManager;
import com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.android_common.RippleEffectView;
import com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.os_specific.RippleEffect;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020$H\u0016J\u0018\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0016J\u001e\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020*2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020$0/H\u0002J\b\u00100\u001a\u00020\u0005H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005H\u0002J\b\u00102\u001a\u00020$H\u0002J\b\u00103\u001a\u00020$H\u0002J\b\u00104\u001a\u00020$H\u0002J\u0010\u00105\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0018\u00106\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u00107\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0002J\b\u00108\u001a\u00020$H\u0002J\b\u00109\u001a\u00020$H\u0002J\b\u0010:\u001a\u00020$H\u0002J\b\u0010;\u001a\u00020$H\u0002J\b\u0010<\u001a\u00020$H\u0002J\u0010\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b \u0010!¨\u0006@"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/WindowEffectsImpl;", "Lcom/obric/aiagent/product/platform/api/windoweffects/IWindowEffects;", "<init>", "()V", "isV1Added", "", "isV2Added", "isObricOs", "()Z", "isObricOs$delegate", "Lkotlin/Lazy;", "v1OverlayView", "Lcom/obric/aiagent/product/platform/impl/windoweffects/effects/android_common/AiScreenEdgeEffectView;", "getV1OverlayView", "()Lcom/obric/aiagent/product/platform/impl/windoweffects/effects/android_common/AiScreenEdgeEffectView;", "v1OverlayView$delegate", "v2RippleEffectView", "Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/android_common/RippleEffectView;", "getV2RippleEffectView", "()Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/android_common/RippleEffectView;", "v2RippleEffectView$delegate", "osSpecificEffectV2", "Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/os_specific/RippleEffect;", "getOsSpecificEffectV2", "()Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/os_specific/RippleEffect;", "osSpecificEffectV2$delegate", "createWindowLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "activeEffectShowTimeout", "Ljava/lang/Runnable;", "windowManager", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "windowManager$delegate", "startActivateEffect", "", "withRipple", "stopActivateEffect", "showScreenShotEffect", "skipWindowLayer", "windowLayerName", "", "playRippleEffect", "runIfSupportWindowEffects", "action", "block", "Lkotlin/Function0;", "useV2Effects", "startV1ActivateEffect", "stopV1ActivateEffect", "showV1ScreenShotEffect", "playV1RippleEffect", "startV2ActivateEffect", "showV2ScreenShotEffect", "playV2RippleEffect", "stopV2Effect", "addV1OverlayView", "removeV1OverlayView", "addV2OverlayView", "removeV2OverlayView", "setTrustedOverlayReflectively", "lp", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WindowEffectsImpl implements IWindowEffects {
    private static final long ACTIVE_EFFECT_TIMEOUT_MS = 300000;
    public static final Companion Companion = null;
    private static final String TAG = "WindowEffectsImpl";
    private final Runnable activeEffectShowTimeout;
    private final Lazy isObricOs$delegate;
    private boolean isV1Added;
    private boolean isV2Added;
    private final Lazy osSpecificEffectV2$delegate;
    private final Lazy v1OverlayView$delegate;
    private final Lazy v2RippleEffectView$delegate;
    private final Lazy windowManager$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/WindowEffectsImpl$Companion;", "", "<init>", "()V", "TAG", "", "ACTIVE_EFFECT_TIMEOUT_MS", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public WindowEffectsImpl() {
        d.f5954a.b(TAG, "WindowEffectsImpl: new instance");
        this.isObricOs$delegate = LazyKt.lazy($$Lambda$WindowEffectsImpl$kQps3GhE_8DKKpsLaZpoHiDRuMI.INSTANCE);
        this.v1OverlayView$delegate = LazyKt.lazy($$Lambda$WindowEffectsImpl$gvOA9QXbafWZD70LWv45kpco1ZQ.INSTANCE);
        this.v2RippleEffectView$delegate = LazyKt.lazy($$Lambda$WindowEffectsImpl$EBUtLTiAuTSYMcZT7U41dMzjqS8.INSTANCE);
        this.osSpecificEffectV2$delegate = LazyKt.lazy($$Lambda$WindowEffectsImpl$eBcInTedLCImBYkkQBA_YTaIDSc.INSTANCE);
        this.activeEffectShowTimeout = new $$Lambda$WindowEffectsImpl$POW0PZmudnssQve2ibYMAa6_m6E(this);
        this.windowManager$delegate = LazyKt.lazy($$Lambda$WindowEffectsImpl$W8IoAvIEN8I0pScSrAmw_ulZ7j8.INSTANCE);
    }

    private static final void activeEffectShowTimeout$lambda$5(WindowEffectsImpl r3) {
        d.f5954a.b(TAG, "activeEffectShowTimeout");
        r3.stopActivateEffect();
    }

    private final void addV1OverlayView() {
        AiScreenEdgeEffectView r0 = getV1OverlayView();
        if (r0 != null) goto L8;
        WindowEffectsImpl r5 = (WindowEffectsImpl) ZeusTransformUtils.preCheckCast(this, WindowEffectsImpl.class, "com.obric.memorydata.plugin");
        d.b r6 = d.f5954a;
        String r1 = "addV1OverlayView: v1OverlayView is null";
    L5:
        r6.c(TAG, r1);
        return;
    L8:
        if (this.isV1Added == false) goto L10;
        r6 = d.f5954a;
        r1 = "addV1OverlayView is already added";
        goto L5
    L10:
        d.f5954a.b(TAG, "addV1OverlayView");
        this.isV1Added = true;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        getWindowManager().addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(createWindowLayoutParams(), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
        Object r7 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L21;
        d.f5954a.a(TAG, "addV1OverlayView failed: " + r8.getMessage(), r8);
        return;
    L21:
        return;
    L13:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    private final void addV2OverlayView() {
        RippleEffectView r0 = getV2RippleEffectView();
        if (r0 != null) goto L8;
        WindowEffectsImpl r5 = (WindowEffectsImpl) ZeusTransformUtils.preCheckCast(this, WindowEffectsImpl.class, "com.obric.memorydata.plugin");
        d.b r6 = d.f5954a;
        String r1 = "addV2OverlayView: v2RippleEffectView is null";
    L5:
        r6.c(TAG, r1);
        return;
    L8:
        if (this.isV2Added == false) goto L10;
        r6 = d.f5954a;
        r1 = "addV2OverlayView is already added";
        goto L5
    L10:
        this.isV2Added = true;
        d.f5954a.b(TAG, "addV2OverlayView");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        getWindowManager().addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(createWindowLayoutParams(), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
        Object r7 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L21;
        d.f5954a.a(TAG, "addV2OverlayView failed: " + r8.getMessage(), r8);
        return;
    L21:
        return;
    L13:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    private final WindowManager.LayoutParams createWindowLayoutParams() {
        WindowManager.LayoutParams r6 = new WindowManager.LayoutParams(-1, -1, 2006, 218629400, -3);
        r6.windowAnimations = 0;
        r6.dimAmount = 0.0f;
        r6.gravity = 49;
        int r0 = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r6.layoutInDisplayCutoutMode = 1;
    L5:
        setTrustedOverlayReflectively(r6);
        return r6;
    }

    private final RippleEffect getOsSpecificEffectV2() {
        return (RippleEffect) ZeusTransformUtils.preCheckCast(this.osSpecificEffectV2$delegate.getValue(), RippleEffect.class, "com.obric.memorydata.plugin");
    }

    private final AiScreenEdgeEffectView getV1OverlayView() {
        return (AiScreenEdgeEffectView) ZeusTransformUtils.preCheckCast(this.v1OverlayView$delegate.getValue(), AiScreenEdgeEffectView.class, "com.obric.memorydata.plugin");
    }

    private final RippleEffectView getV2RippleEffectView() {
        return (RippleEffectView) ZeusTransformUtils.preCheckCast(this.v2RippleEffectView$delegate.getValue(), RippleEffectView.class, "com.obric.memorydata.plugin");
    }

    private final WindowManager getWindowManager() {
        return (WindowManager) ZeusTransformUtils.preCheckCast(this.windowManager$delegate.getValue(), WindowManager.class, "com.obric.memorydata.plugin");
    }

    private final boolean isObricOs() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.isObricOs$delegate.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final boolean isObricOs_delegate$lambda$0() {
        return b.f5974a.b().e();
    }

    public static /* synthetic */ void lambda$5ddKkZIMk7IlsG9iRgdMcYuB0co() {
        showV2ScreenShotEffect$lambda$28$lambda$27();
    }

    public static /* synthetic */ Unit lambda$7T8Jm7RGWIMyQOjolGXvLt9o1R0(WindowEffectsImpl r0, boolean r1, String r2) {
        return playRippleEffect$lambda$18(r0, r1, r2);
    }

    public static /* synthetic */ RippleEffectView lambda$EBUtLTiAuTSYMcZT7U41dMzjqS8() {
        return v2RippleEffectView_delegate$lambda$2();
    }

    /* JADX INFO: renamed from: lambda$F02QGZNJOO688pnIm357i9o-25Y, reason: not valid java name */
    public static /* synthetic */ void m182lambda$F02QGZNJOO688pnIm357i9o25Y(WindowEffectsImpl r0) {
        showV2ScreenShotEffect$lambda$30(r0);
    }

    public static /* synthetic */ Unit lambda$G9mnyZ8hajKPA8TtAvluUNw5ZX8(WindowEffectsImpl r0, boolean r1, String r2) {
        return showScreenShotEffect$lambda$15(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$GneEb8KNEo9rifAAt4vgSvypeSw(WindowEffectsImpl r0) {
        playV2RippleEffect$lambda$34(r0);
    }

    public static /* synthetic */ void lambda$LEi5Jsxh24BWc760wllpsP0qce0() {
        playV2RippleEffect$lambda$32$lambda$31();
    }

    public static /* synthetic */ void lambda$POW0PZmudnssQve2ibYMAa6_m6E(WindowEffectsImpl r0) {
        activeEffectShowTimeout$lambda$5(r0);
    }

    public static /* synthetic */ WindowManager lambda$W8IoAvIEN8I0pScSrAmw_ulZ7j8() {
        return windowManager_delegate$lambda$6();
    }

    public static /* synthetic */ Unit lambda$Wvb9hi8otnW_J45f6e5htHZ8SMo(AiScreenEdgeEffectView r0, WindowEffectsImpl r1, Animator r2) {
        return showV1ScreenShotEffect$lambda$26$lambda$25(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$X6dbmVNvnOYVF6JN8atjOnwoKS4(WindowEffectsImpl r0) {
        return stopActivateEffect$lambda$12(r0);
    }

    public static /* synthetic */ Unit lambda$YX5dHsWJgdXpDuNUCfKOdJuLZGo(Ref.BooleanRef r0, Animator r1) {
        return stopV1ActivateEffect$lambda$22$lambda$21(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$YtPB2bGvAPL_C-NBxonRaCdpRow, reason: not valid java name */
    public static /* synthetic */ Unit m183lambda$YtPB2bGvAPL_CNBxonRaCdpRow(WindowEffectsImpl r0, boolean r1) {
        return startActivateEffect$lambda$9(r0, r1);
    }

    public static /* synthetic */ RippleEffect lambda$eBcInTedLCImBYkkQBA_YTaIDSc() {
        return osSpecificEffectV2_delegate$lambda$3();
    }

    public static /* synthetic */ AiScreenEdgeEffectView lambda$gvOA9QXbafWZD70LWv45kpco1ZQ() {
        return v1OverlayView_delegate$lambda$1();
    }

    public static /* synthetic */ Unit lambda$hJDC35Pw6MzwsFmvZbmcgBnrUJU(Ref.BooleanRef r0, WindowEffectsImpl r1, Animator r2) {
        return stopV1ActivateEffect$lambda$22$lambda$20(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$hNIJhJ604Wy50xrZ0L9egR9Dlxk(Ref.BooleanRef r0, WindowEffectsImpl r1, Animator r2) {
        return showV1ScreenShotEffect$lambda$26$lambda$25$lambda$23(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$kQps3GhE_8DKKpsLaZpoHiDRuMI() {
        return isObricOs_delegate$lambda$0();
    }

    public static /* synthetic */ Unit lambda$kaQL5MgphFPW_Y7YEDlWBHGL6_Y(Ref.BooleanRef r0, Animator r1) {
        return showV1ScreenShotEffect$lambda$26$lambda$25$lambda$24(r0, r1);
    }

    private static final RippleEffect osSpecificEffectV2_delegate$lambda$3() {
        return new RippleEffect((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit playRippleEffect$lambda$18(WindowEffectsImpl r1, boolean r2, String r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        if (r1.useV2Effects() == false) goto L5;
        r1.playV2RippleEffect(r2, r3);     // Catch: Throwable -> L8
    L6:
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L14;
        d.f5954a.b(TAG, "playRippleEffect failed: " + r5.getMessage(), r5);
    L14:
        return Unit.INSTANCE;
    L5:
        r1.playV1RippleEffect();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void playV1RippleEffect() {
        d.f5954a.b(TAG, "playV1RippleEffect start");
        OSGlobalEffectManager.INSTANCE.playRippleEffect();
    }

    private final void playV2RippleEffect(boolean r4, String r5) {
        d.f5954a.b(TAG, "playV2RippleEffect start, skipWindowLayer = " + r4 + ", windowLayerName = " + r5);
        if (isObricOs() == true) goto L16;
        addV2OverlayView();
        RippleEffectView r6 = getV2RippleEffectView();
        if (r6 == null) goto L19;
        r6.playWakeUpEffect(new $$Lambda$WindowEffectsImpl$GneEb8KNEo9rifAAt4vgSvypeSw(this));
        return;
    L19:
        return;
    L16:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        ((WindowEffectsImpl) ZeusTransformUtils.preCheckCast(this, WindowEffectsImpl.class, "com.obric.memorydata.plugin")).getOsSpecificEffectV2().playWakeUpEffect(r4, r5, $$Lambda$WindowEffectsImpl$LEi5Jsxh24BWc760wllpsP0qce0.INSTANCE);     // Catch: Throwable -> L6
        Object r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r3);
        if (r7 == null) goto L11;
        d.f5954a.a(TAG, "playWakeUpEffect failed: " + r7.getMessage(), r7);
    L11:
        Result.m1420boximpl(r3);
        return;
    L6:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final void playV2RippleEffect$lambda$32$lambda$31() {
        d.f5954a.b(TAG, "playWakeUpEffect end");
    }

    private static final void playV2RippleEffect$lambda$34(WindowEffectsImpl r3) {
        d.f5954a.b(TAG, "playV2RippleEffect android_common end");
        r3.removeV2OverlayView();
    }

    private final void removeV1OverlayView() {
        AiScreenEdgeEffectView r0 = getV1OverlayView();
        if (r0 == null) goto L6;
        r0.cancelShow();
    L6:
        if (this.isV1Added == true) goto L9;
        d.f5954a.b(TAG, "removeV1OverlayView is not added");
        return;
    L9:
        d.f5954a.b(TAG, "removeV1OverlayView");
        this.isV1Added = false;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        getWindowManager().removeView((View) ZeusTransformUtils.preCheckCast(getV1OverlayView(), View.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L20;
        d.f5954a.c(TAG, "removeV1OverlayView failed: " + r5.getMessage());
        return;
    L20:
        return;
    L12:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private final void removeV2OverlayView() {
        if (this.isV2Added == true) goto L6;
        d.f5954a.b(TAG, "removeV2OverlayView is not added");
        return;
    L6:
        d.f5954a.b(TAG, "removeV2OverlayView");
        this.isV2Added = false;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        getWindowManager().removeView((View) ZeusTransformUtils.preCheckCast(getV2RippleEffectView(), View.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L17;
        d.f5954a.a(TAG, "removeV2OverlayView failed: " + r5.getMessage(), r5);
        return;
    L17:
        return;
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final void runIfSupportWindowEffects(String r3, Function0<Unit> r4) {
        Function0 r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 33) goto L6;
        d.f5954a.c(TAG, r3 + ": isSupportWindowEffects is false");
        return;
    L6:
        com.obric.aiagent.product.a.d.f5969a.b((Runnable) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.product.a.d.b(r2), Runnable.class, "com.obric.memorydata.plugin"));
    }

    private final void setTrustedOverlayReflectively(WindowManager.LayoutParams r5) {
        if (Build.VERSION.SDK_INT >= 31) goto L14;
        d.f5954a.b(TAG, "setTrustedOverlayReflectively failed, sdk version < 31");
        return;
    L14:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L6
        Method r6 = WindowManager.LayoutParams.class.getDeclaredMethod("setTrustedOverlay", new Class[0]);     // Catch: Throwable -> L6
        r6.setAccessible(true);     // Catch: Throwable -> L6
        Object r7 = Result.m1421constructorimpl(r6.invoke(r5, new Object[0]));     // Catch: Throwable -> L6
    L8:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L11;
        d.f5954a.a(TAG, "setTrustedOverlayReflectively failed", r8);
    L11:
        Result.m1420boximpl(r7);
        return;
    L6:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final Unit showScreenShotEffect$lambda$15(WindowEffectsImpl r1, boolean r2, String r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        if (r1.useV2Effects() == false) goto L5;
        r1.showV2ScreenShotEffect(r2, r3);     // Catch: Throwable -> L8
    L6:
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L14;
        d.f5954a.b(TAG, "showScreenShotEffect failed: " + r5.getMessage(), r5);
    L14:
        return Unit.INSTANCE;
    L5:
        r1.showV1ScreenShotEffect();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void showV1ScreenShotEffect() {
        addV1OverlayView();
        final AiScreenEdgeEffectView r0 = getV1OverlayView();
        if (r0 == null) goto L6;
        r0.prepareToShow();
        AiScreenEdgeEffectView.playFadeInAnimation$default(r0, null, null, 3, null);
        r0.playCaptureAnimation(new $$Lambda$WindowEffectsImpl$Wvb9hi8otnW_J45f6e5htHZ8SMo(r0, this));
        return;
    }

    private static final Unit showV1ScreenShotEffect$lambda$26$lambda$25(AiScreenEdgeEffectView r1, final WindowEffectsImpl r2, Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r1.isPlayingShimmerAnimation() == true) goto L6;
        final Ref.BooleanRef r4 = new Ref.BooleanRef();
        r1.playFadeOutAnimation(new $$Lambda$WindowEffectsImpl$hNIJhJ604Wy50xrZ0L9egR9Dlxk(r4, r2), new $$Lambda$WindowEffectsImpl$kaQL5MgphFPW_Y7YEDlWBHGL6_Y(r4));
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit showV1ScreenShotEffect$lambda$26$lambda$25$lambda$23(Ref.BooleanRef r2, WindowEffectsImpl r3, Animator r4) {
        d.f5954a.b(TAG, "showV1ScreenShotEffect onEnd");
        if (r2.element == true) goto L6;
        r3.removeV1OverlayView();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit showV1ScreenShotEffect$lambda$26$lambda$25$lambda$24(Ref.BooleanRef r2, Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        d.f5954a.b(TAG, "showV1ScreenShotEffect onCancel");
        r2.element = true;
        return Unit.INSTANCE;
    }

    private final void showV2ScreenShotEffect(boolean r4, String r5) {
        d.f5954a.b(TAG, "showV2ScreenShotEffect start, skipWindowLayer = " + r4 + ", windowLayerName = " + r5);
        if (isObricOs() == true) goto L16;
        addV2OverlayView();
        RippleEffectView r6 = getV2RippleEffectView();
        if (r6 == null) goto L19;
        r6.playCaptureEffect(new $$Lambda$WindowEffectsImpl$F02QGZNJOO688pnIm357i9o25Y(this));
        return;
    L19:
        return;
    L16:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        ((WindowEffectsImpl) ZeusTransformUtils.preCheckCast(this, WindowEffectsImpl.class, "com.obric.memorydata.plugin")).getOsSpecificEffectV2().playCaptureEffect(r4, r5, $$Lambda$WindowEffectsImpl$5ddKkZIMk7IlsG9iRgdMcYuB0co.INSTANCE);     // Catch: Throwable -> L6
        Object r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r3);
        if (r7 == null) goto L11;
        d.f5954a.a(TAG, "playCaptureEffect failed: " + r7.getMessage(), r7);
    L11:
        Result.m1420boximpl(r3);
        return;
    L6:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final void showV2ScreenShotEffect$lambda$28$lambda$27() {
        d.f5954a.b(TAG, "playCaptureEffect end");
    }

    private static final void showV2ScreenShotEffect$lambda$30(WindowEffectsImpl r3) {
        d.f5954a.b(TAG, "showV2ScreenShotEffect android_common end");
        r3.removeV2OverlayView();
    }

    private static final Unit startActivateEffect$lambda$9(WindowEffectsImpl r4, boolean r5) {
        com.obric.aiagent.product.a.d.f5969a.a().removeCallbacks(r4.activeEffectShowTimeout);
        com.obric.aiagent.product.a.d.f5969a.a().postDelayed(r4.activeEffectShowTimeout, 300000);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        if (r4.useV2Effects() == false) goto L6;
        r4.startV2ActivateEffect(r5);     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L15;
        d.f5954a.b(TAG, "startActivateEffect failed: " + r7.getMessage(), r7);
    L15:
        return Unit.INSTANCE;
    L6:
        r4.startV1ActivateEffect(r5);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final void startV1ActivateEffect(boolean r4) {
        addV1OverlayView();
        AiScreenEdgeEffectView r0 = getV1OverlayView();
        if (r0 == null) goto L8;
        r0.prepareToShow();
        AiScreenEdgeEffectView.playFadeInAnimation$default(r0, null, null, 3, null);
        if (r4 == false) goto L9;
        AiScreenEdgeEffectView.playShimmerAnimation$default(r0, null, 1, null);
        playV1RippleEffect();
        return;
    L9:
        return;
    }

    private final void startV2ActivateEffect(boolean r2) {
        if (r2 == false) goto L4;
        playV2RippleEffect(true, "obric-assistant-window");
        return;
    L4:
        d.f5954a.b(TAG, "startV2ActivateEffect: no activate overlay for v2");
    }

    private static final Unit stopActivateEffect$lambda$12(WindowEffectsImpl r3) {
        com.obric.aiagent.product.a.d.f5969a.a().removeCallbacks(r3.activeEffectShowTimeout);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r3.stopV1ActivateEffect();     // Catch: Throwable -> L5
        r3.stopV2Effect();     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L11;
        d.f5954a.b(TAG, "stopActivateEffect failed: " + r5.getMessage(), r5);
    L11:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void stopV1ActivateEffect() {
        AiScreenEdgeEffectView r0 = getV1OverlayView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isPlayingCaptureAnimation() == false) goto L7;
        return;
    L7:
        final Ref.BooleanRef r1 = new Ref.BooleanRef();
        r0.playFadeOutAnimation(new $$Lambda$WindowEffectsImpl$hJDC35Pw6MzwsFmvZbmcgBnrUJU(r1, this), new $$Lambda$WindowEffectsImpl$YX5dHsWJgdXpDuNUCfKOdJuLZGo(r1));
    }

    private static final Unit stopV1ActivateEffect$lambda$22$lambda$20(Ref.BooleanRef r2, WindowEffectsImpl r3, Animator r4) {
        d.f5954a.b(TAG, "stopV1ActivateEffect onEnd");
        if (r2.element == true) goto L6;
        r3.removeV1OverlayView();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit stopV1ActivateEffect$lambda$22$lambda$21(Ref.BooleanRef r2, Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        d.f5954a.b(TAG, "stopV1ActivateEffect onCancel");
        r2.element = true;
        return Unit.INSTANCE;
    }

    private final void stopV2Effect() {
        if (isObricOs() == true) goto L17;
        RippleEffectView r0 = getV2RippleEffectView();
        if (r0 == null) goto L15;
        r0.stop();
    L15:
        removeV2OverlayView();
        return;
    L17:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        ((WindowEffectsImpl) ZeusTransformUtils.preCheckCast(this, WindowEffectsImpl.class, "com.obric.memorydata.plugin")).getOsSpecificEffectV2().stop();     // Catch: Throwable -> L6
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r4);
        if (r2 == null) goto L11;
        d.f5954a.a(TAG, "stopEffect failed: " + r2.getMessage(), r2);
    L11:
        Result.m1420boximpl(r4);
        return;
    L6:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final boolean useV2Effects() {
        return true;
    }

    private static final AiScreenEdgeEffectView v1OverlayView_delegate$lambda$1() {
        if (Build.VERSION.SDK_INT >= 33) goto L7;
        return null;
    L7:
        return new AiScreenEdgeEffectView((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), null, 0, 360000, 6, null);
    }

    private static final RippleEffectView v2RippleEffectView_delegate$lambda$2() {
        if (Build.VERSION.SDK_INT >= 33) goto L7;
        return null;
    L7:
        return new RippleEffectView((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null);
    }

    private static final WindowManager windowManager_delegate$lambda$6() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService("window");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.WindowManager");
        return (WindowManager) ZeusTransformUtils.preCheckCast(r0, WindowManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void playRippleEffect(final boolean r4, final String r5) {
        Intrinsics.checkNotNullParameter(r5, "windowLayerName");
        d.f5954a.b(TAG, "playRippleEffect: isObricOS = " + isObricOs() + ", skipWindowLayer = " + r4 + ", windowLayerName = " + r5);
        runIfSupportWindowEffects("playRippleEffect", new $$Lambda$WindowEffectsImpl$7T8Jm7RGWIMyQOjolGXvLt9o1R0(this, r4, r5));
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void showScreenShotEffect(final boolean r4, final String r5) {
        Intrinsics.checkNotNullParameter(r5, "windowLayerName");
        d.f5954a.b(TAG, "showScreenShotEffect: isObricOS = " + isObricOs() + ", skipWindowLayer = " + r4 + ", windowLayerName = " + r5);
        runIfSupportWindowEffects("showScreenShotEffect", new $$Lambda$WindowEffectsImpl$G9mnyZ8hajKPA8TtAvluUNw5ZX8(this, r4, r5));
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void startActivateEffect(final boolean r4) {
        d.f5954a.b(TAG, "startActivateEffect: withRipple = " + r4 + ", isObricOS = " + isObricOs());
        runIfSupportWindowEffects("startActivateEffect", new $$Lambda$WindowEffectsImpl$YtPB2bGvAPL_CNBxonRaCdpRow(this, r4));
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void stopActivateEffect() {
        d.f5954a.b(TAG, "stopActivateEffect");
        runIfSupportWindowEffects("stopActivateEffect", new $$Lambda$WindowEffectsImpl$X6dbmVNvnOYVF6JN8atjOnwoKS4(this));
    }
}
