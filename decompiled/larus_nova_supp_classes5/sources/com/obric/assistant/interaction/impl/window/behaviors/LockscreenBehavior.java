package com.obric.assistant.interaction.impl.window.behaviors;

import android.os.PowerManager;
import android.service.voice.VoiceInteractionSession;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.window.IBehavior;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.voice.IObricVoiceService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0005\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\bH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/LockscreenBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "dismissKeyguardStatusListener", "com/obric/assistant/interaction/impl/window/behaviors/LockscreenBehavior$dismissKeyguardStatusListener$1", "Lcom/obric/assistant/interaction/impl/window/behaviors/LockscreenBehavior$dismissKeyguardStatusListener$1;", "init", "", "onWindowShow", "onWindowHide", "isDeviceInteractive", "", "popWindowAfterClosingSystemDialogs", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LockscreenBehavior implements IBehavior {
    public static final Companion Companion = null;
    private static final String TAG = "LockscreenBehavior";
    private static boolean stashedByDismissKeyguard;
    private final LockscreenBehavior$dismissKeyguardStatusListener$1 dismissKeyguardStatusListener;

    static {
        Companion = new Companion(null);
    }

    public void onWindowHide() {
    }

    private final boolean isDeviceInteractive() {
        Object r0 = AppHost.a.getApplication().getSystemService("power");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) r0).isInteractive();
    }

    private final void popWindowAfterClosingSystemDialogs() {
        FLogger.a.i(TAG, "popWindowAfterClosingSystemDialogs");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        IObricVoiceService.a.getClass();     // Catch: Throwable -> L11
        IObricVoiceService r3 = IObricVoiceService.a.a();     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        VoiceInteractionSession r4 = r3.m();     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        r4.closeSystemDialogs();     // Catch: Throwable -> L11
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L11
    L13:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L16;
        FLogger.a.e(TAG, "closeSystemDialogs before pop failed", r7);
    L16:
        WindowHost.pop$default(WindowHost.INSTANCE, null, 1, null);
        return;
    L8:
        r5 = null;
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public void init() {
        KeyguardService.a.registerDismissKeyguardChangedListener(this.dismissKeyguardStatusListener);
    }

    public void onWindowShow() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("on window show isRequestingDismissKeyguard = ");
        KeyguardService r2 = KeyguardService.a;
        r1.append(r2.isRequestingDismissKeyguard());
        r0.i(TAG, r1.toString());
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L5;
        return;
    L5:
        if (r2.isRequestingDismissKeyguard() == false) goto L9;
        stashedByDismissKeyguard = false;
        r2.cancelDismissKeyguard();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.assistant.interaction.impl.window.behaviors.LockscreenBehavior$dismissKeyguardStatusListener$1] */
    public LockscreenBehavior() {
        this.dismissKeyguardStatusListener = new LockscreenBehavior$dismissKeyguardStatusListener$1(this);
    }

    public static final /* synthetic */ boolean access$getStashedByDismissKeyguard$cp() {
        return stashedByDismissKeyguard;
    }

    public void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    public void onAppForeground() {
        IBehavior.DefaultImpls.onAppForeground(this);
    }

    public void onWindowDismiss() {
        IBehavior.DefaultImpls.onWindowDismiss(this);
    }

    public void onWindowPreDismiss() {
        IBehavior.DefaultImpls.onWindowPreDismiss(this);
    }

    public void onWindowPreHide() {
        IBehavior.DefaultImpls.onWindowPreHide(this);
    }

    public void onWindowPreOpenClear() {
        IBehavior.DefaultImpls.onWindowPreOpenClear(this);
    }

    public void onWindowPreShow() {
        IBehavior.DefaultImpls.onWindowPreShow(this);
    }

    public void onWindowPreloaded() {
        IBehavior.DefaultImpls.onWindowPreloaded(this);
    }

    public static final /* synthetic */ boolean access$isDeviceInteractive(LockscreenBehavior r0) {
        return r0.isDeviceInteractive();
    }

    public static final /* synthetic */ void access$popWindowAfterClosingSystemDialogs(LockscreenBehavior r0) {
        r0.popWindowAfterClosingSystemDialogs();
    }

    public static final /* synthetic */ void access$setStashedByDismissKeyguard$cp(boolean r0) {
        stashedByDismissKeyguard = r0;
    }

    public void onScreenRotationChanged(int r1, int r2) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r1, r2);
    }
}
