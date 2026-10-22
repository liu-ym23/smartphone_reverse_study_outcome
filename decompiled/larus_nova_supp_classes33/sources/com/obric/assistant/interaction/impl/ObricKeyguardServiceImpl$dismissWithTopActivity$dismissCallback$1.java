package com.obric.assistant.interaction.impl;

import android.app.KeyguardManager;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/obric/assistant/interaction/impl/ObricKeyguardServiceImpl$dismissWithTopActivity$dismissCallback$1", "Landroid/app/KeyguardManager$KeyguardDismissCallback;", "onDismissCancelled", "", "onDismissError", "onDismissSucceeded", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricKeyguardServiceImpl$dismissWithTopActivity$dismissCallback$1 extends KeyguardManager.KeyguardDismissCallback {
    final /* synthetic */ KeyguardDismissTerminalGate $terminalGate;
    final /* synthetic */ ObricKeyguardServiceImpl this$0;

    public static /* synthetic */ Unit a() {
        return onDismissError$lambda$1();
    }

    public static /* synthetic */ Unit b() {
        return onDismissCancelled$lambda$0();
    }

    public static /* synthetic */ Unit c() {
        return onDismissSucceeded$lambda$2();
    }

    private static final Unit onDismissCancelled$lambda$0() {
        ObricKeyguardServiceImpl.Companion.onKeyguardDismissCancelled$impl_mainlandRelease();
        return Unit.INSTANCE;
    }

    private static final Unit onDismissError$lambda$1() {
        ObricKeyguardServiceImpl.Companion.onKeyguardDismissError$impl_mainlandRelease();
        return Unit.INSTANCE;
    }

    private static final Unit onDismissSucceeded$lambda$2() {
        ObricKeyguardServiceImpl.Companion.onKeyguardDismissSucceeded$impl_mainlandRelease();
        return Unit.INSTANCE;
    }

    @Override // android.app.KeyguardManager.KeyguardDismissCallback
    public void onDismissCancelled() {
        FLogger.a.i("DismissKeyguardHelper", "onDismissCancelled with top activity");
        super.onDismissCancelled();
        ObricKeyguardServiceImpl.access$completeTopActivityDismiss(this.this$0, this.$terminalGate, "system_cancelled", new z());
    }

    @Override // android.app.KeyguardManager.KeyguardDismissCallback
    public void onDismissError() {
        FLogger.a.i("DismissKeyguardHelper", "onDismissError with top activity");
        super.onDismissError();
        ObricKeyguardServiceImpl.access$completeTopActivityDismiss(this.this$0, this.$terminalGate, "system_error", new x());
    }

    @Override // android.app.KeyguardManager.KeyguardDismissCallback
    public void onDismissSucceeded() {
        FLogger.a.i("DismissKeyguardHelper", "onDismissSucceeded with top activity");
        super.onDismissSucceeded();
        ObricKeyguardServiceImpl.access$completeTopActivityDismiss(this.this$0, this.$terminalGate, "system_succeeded", new y());
    }

    public ObricKeyguardServiceImpl$dismissWithTopActivity$dismissCallback$1(ObricKeyguardServiceImpl r1, KeyguardDismissTerminalGate r2) {
        this.this$0 = r1;
        this.$terminalGate = r2;
    }
}
