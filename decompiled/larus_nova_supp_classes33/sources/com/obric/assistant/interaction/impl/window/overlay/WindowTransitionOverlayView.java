package com.obric.assistant.interaction.impl.window.overlay;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.common.oea.foundation.animation.builder.b;
import com.obric.common.oea.foundation.animation.builder.c;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Delay;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import fja.d;
import java.util.concurrent.atomic.AtomicBoolean;
import kea.a;
import kea.e;
import kea.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010#\u001a\u00020\u0006J\b\u0010$\u001a\u00020\u0006H\u0002J\u0016\u0010%\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\u0006H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/overlay/WindowTransitionOverlayView;", "", "context", "Landroid/content/Context;", "onCompleteCovered", "Lkotlin/Function0;", "", "onDisappeared", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnCompleteCovered", "()Lkotlin/jvm/functions/Function0;", "getOnDisappeared", "overlayView", "Landroid/view/View;", "getOverlayView", "()Landroid/view/View;", "overlayView$delegate", "Lkotlin/Lazy;", "windowManager", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "windowManager$delegate", "fadeInAnimationManager", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "fadeOutAnimationManager", "_isPlayingAnimation", "Ljava/util/concurrent/atomic/AtomicBoolean;", "windowLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "getWindowLayoutParams", "()Landroid/view/WindowManager$LayoutParams;", "windowLayoutParams$delegate", "isStarted", "start", "playFadeInAnimation", "playFadeOutAnimation", "isPlayingAnimation", "", "dismiss", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowTransitionOverlayView {
    public static final Companion Companion = null;
    public static final String TAG = "WindowTransitionOverlayView";
    private final AtomicBoolean _isPlayingAnimation;
    private d fadeInAnimationManager;
    private d fadeOutAnimationManager;
    private final AtomicBoolean isStarted;
    private final Function0<Unit> onCompleteCovered;
    private final Function0<Unit> onDisappeared;
    private final Lazy overlayView$delegate;
    private final Lazy windowLayoutParams$delegate;
    private final Lazy windowManager$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/overlay/WindowTransitionOverlayView$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public static /* synthetic */ View a(Context r0) {
        return overlayView_delegate$lambda$1(r0);
    }

    public static /* synthetic */ WindowManager b(Context r0) {
        return windowManager_delegate$lambda$2(r0);
    }

    public static /* synthetic */ void c(WindowTransitionOverlayView r0) {
        playFadeInAnimation$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ Unit d(WindowTransitionOverlayView r0, Function0 r1, boolean r2, Throwable r3) {
        return playFadeOutAnimation$lambda$7(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit e(WindowTransitionOverlayView r0, boolean r1, Throwable r2) {
        return playFadeInAnimation$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ WindowManager.LayoutParams f() {
        return windowLayoutParams_delegate$lambda$4();
    }

    private final void dismiss() {
        FLogger.a.i(TAG, "dismiss");
        this._isPlayingAnimation.set(false);
        getWindowManager().removeView(getOverlayView());
    }

    private final View getOverlayView() {
        return (View) this.overlayView$delegate.getValue();
    }

    private final WindowManager.LayoutParams getWindowLayoutParams() {
        return (WindowManager.LayoutParams) this.windowLayoutParams$delegate.getValue();
    }

    private final WindowManager getWindowManager() {
        return (WindowManager) this.windowManager$delegate.getValue();
    }

    private final void playFadeInAnimation() {
        FLogger.a.i(TAG, "playFadeInAnimation: start");
        b.a r0 = c.a(getOverlayView());
        b.a.c(r0, AnimationProperty$FloatProperty.ALPHA, Float.valueOf(getOverlayView().getAlpha()), 1.0f, gja.b.d(Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_4, Token$Delay.OUI_ANIMATION_DELAY_NONE, Token$Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD));
        Function2<? super Boolean, ? super Throwable, Unit> r1 = new f(this);
        Intrinsics.checkNotNullParameter(r1, "callback");
        r0.e = r1;
        this.fadeInAnimationManager = b.a(r0.a());
    }

    private static final WindowManager.LayoutParams windowLayoutParams_delegate$lambda$4() {
        WindowManager.LayoutParams r6 = new WindowManager.LayoutParams(-1, -1, WindowHost.INSTANCE.getWindowType(IKeyguardStateKt.getKeyguardState().isKeyguardLocked()), 218629400, -3);
        r6.windowAnimations = 0;
        r6.dimAmount = 0.0f;
        r6.gravity = 49;
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r6.layoutInDisplayCutoutMode = 1;
    L5:
        WindowUtils.INSTANCE.setTrustedOverlayReflectively(r6);
        return r6;
    }

    public final boolean isPlayingAnimation() {
        return this._isPlayingAnimation.get();
    }

    public final void start() {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "start");
        if (this.isStarted.compareAndSet(false, true) == true) goto L6;
        r0.i(TAG, "start: already started");
        return;
    L6:
        this._isPlayingAnimation.set(true);
        getOverlayView().setAlpha(0.0f);
        INVOKEINTERFACE_com_obric_assistant_interaction_impl_window_overlay_WindowTransitionOverlayView_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(getWindowManager(), getOverlayView(), getWindowLayoutParams());
        playFadeInAnimation();
    }

    public final Function0<Unit> getOnCompleteCovered() {
        return this.onCompleteCovered;
    }

    public final Function0<Unit> getOnDisappeared() {
        return this.onDisappeared;
    }

    private static final View overlayView_delegate$lambda$1(Context r3) {
        View r0 = new View(r3);
        r0.setBackgroundColor(ContextCompat.getColor(r3, v19.c.b(2130972364, r3, 2131103343)));
        return r0;
    }

    private static final void playFadeInAnimation$lambda$6$lambda$5(WindowTransitionOverlayView r1) {
        r1.playFadeOutAnimation(r1.onDisappeared);
    }

    private final void playFadeOutAnimation(final Function0<Unit> r7) {
        FLogger.a.i(TAG, "playFadeOutAnimation: start");
        b.a r0 = c.a(getOverlayView());
        b.a.c(r0, AnimationProperty$FloatProperty.ALPHA, Float.valueOf(getOverlayView().getAlpha()), 0.0f, gja.b.d(Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_4, Token$Delay.OUI_ANIMATION_DELAY_NONE, Token$Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD));
        Function2<? super Boolean, ? super Throwable, Unit> r1 = new kea.d(this, r7);
        Intrinsics.checkNotNullParameter(r1, "callback");
        r0.e = r1;
        this.fadeOutAnimationManager = b.a(r0.a());
    }

    private static final WindowManager windowManager_delegate$lambda$2(Context r1) {
        Object r2 = r1.getSystemService("window");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.WindowManager");
        return (WindowManager) r2;
    }

    public WindowTransitionOverlayView(final Context r2, Function0<Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onCompleteCovered");
        Intrinsics.checkNotNullParameter(r4, "onDisappeared");
        this.onCompleteCovered = r3;
        this.onDisappeared = r4;
        this.overlayView$delegate = LazyKt.lazy(new a(r2));
        this.windowManager$delegate = LazyKt.lazy(new kea.b(r2));
        this._isPlayingAnimation = new AtomicBoolean(false);
        this.windowLayoutParams$delegate = LazyKt.lazy(new kea.c());
        this.isStarted = new AtomicBoolean(false);
    }

    public static void INVOKEINTERFACE_com_obric_assistant_interaction_impl_window_overlay_WindowTransitionOverlayView_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(WindowManager r0, View r1, ViewGroup.LayoutParams r2) {
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r1, r2);
        r0.addView(r1, r2);
    }

    private static final Unit playFadeInAnimation$lambda$6(final WindowTransitionOverlayView r1, boolean r2, Throwable r3) {
        FLogger.a.i(TAG, "playFadeInAnimation: end");
        r1.fadeInAnimationManager = null;
        r1.onCompleteCovered.invoke();
        t0.a.post(new e(r1));
        return Unit.INSTANCE;
    }

    private static final Unit playFadeOutAnimation$lambda$7(WindowTransitionOverlayView r1, Function0 r2, boolean r3, Throwable r4) {
        FLogger.a.i(TAG, "stopTransitionOverlayAnimation: end");
        r1.fadeOutAnimationManager = null;
        r2.invoke();
        r1.dismiss();
        return Unit.INSTANCE;
    }
}
