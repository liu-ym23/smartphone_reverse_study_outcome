package afa;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.handler.auth.DismissKeyguardActionHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b implements oga.a {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ kotlinx.coroutines.i<com.obric.assistant.obric_action.h<Unit>> b;

    @Override // oga.a
    public final void onDismissFailed() {
        FLogger.a.i("DismissKeyguardActionHandler", "onDismissFailed");
        DismissKeyguardActionHandler.e(this.a, this.b, com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.d, "dismissKeyguard failed", 2), "onDismissFailed");
    }

    @Override // oga.a
    public final void onDismissSucceeded() {
        FLogger.a.i("DismissKeyguardActionHandler", "onDismissSucceeded");
        DismissKeyguardActionHandler.e(this.a, this.b, com.obric.assistant.obric_action.h.a.c(com.obric.assistant.obric_action.h.d, null, null, 3), "onDismissSucceeded");
    }

    public b(AtomicBoolean r1, kotlinx.coroutines.j r2) {
        this.a = r1;
        this.b = r2;
    }
}
