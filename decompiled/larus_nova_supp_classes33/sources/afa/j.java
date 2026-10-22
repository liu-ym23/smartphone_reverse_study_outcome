package afa;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.n4;
import com.obric.assistant.obric_action.handler.auth.result.AuthenticationActionStatus;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {

    public static final class a implements Function1<Throwable, Unit> {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ String b;

        public a(AtomicBoolean r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke(Object r3) {
            Throwable r4 = (Throwable) r3;
            this.a.set(true);
            FLogger.a.i(this.b, "authentication continuation cancelled");
            return Unit.INSTANCE;
        }
    }

    public static final class b implements n4 {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ kotlinx.coroutines.i<com.obric.assistant.obric_action.h<bfa.b>> c;

        public final void onAuthenticationCancelled() {
            j.b(this.a, this.b, this.c, j.a(false, AuthenticationActionStatus.CANCELLED), "onAuthenticationCancelled");
        }

        public final void onAuthenticationFailed() {
            j.b(this.a, this.b, this.c, j.a(false, AuthenticationActionStatus.FAILED), "onAuthenticationFailed");
        }

        public final void onAuthenticationNotAvailable() {
            j.b(this.a, this.b, this.c, j.a(false, AuthenticationActionStatus.NOT_AVAILABLE), "onAuthenticationNotAvailable");
        }

        public final void onAuthenticationPass() {
            j.b(this.a, this.b, this.c, j.a(true, AuthenticationActionStatus.PASS), "onAuthenticationPass");
        }

        public final void onAuthenticationTimeout() {
            j.b(this.a, this.b, this.c, j.a(false, AuthenticationActionStatus.TIMEOUT), "onAuthenticationTimeout");
        }

        public b(AtomicBoolean r1, String r2, kotlinx.coroutines.j r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final ISessionAuthenticationService d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        ISessionAuthenticationService r0 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        if (r0 != null) goto L5;
        FLogger.a.w(r3, "ISessionAuthenticationService is null");
    L5:
        return r0;
    }

    public static final com.obric.assistant.obric_action.h a(boolean r3, AuthenticationActionStatus r4) {
        bfa.b r0 = new bfa.b(r4);
        if (r3 == false) goto L5;
        com.obric.assistant.obric_action.h.d.getClass();
        return new com.obric.assistant.obric_action.h(true, "authentication pass", r0);
    L5:
        com.obric.assistant.obric_action.h.a r5 = com.obric.assistant.obric_action.h.d;
        String r6 = "authentication " + r4.getValue();
        r5.getClass();
        return new com.obric.assistant.obric_action.h(false, r6, r0);
    }

    public static final Object c(String r7, Function1<? super n4, Unit> r8, Continuation<? super com.obric.assistant.obric_action.h<bfa.b>> r9) {
        boolean r2 = true;
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r9), 1);
        r0.C();
        AtomicBoolean r1 = new AtomicBoolean(false);
        r0.i(new a(r1, r7));
        b r4 = new b(r1, r7, r0);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        r8.invoke(r4);     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L19;
        FLogger.a.w(r7, "request authentication failed. " + r11.getMessage(), r11);
        com.obric.assistant.obric_action.h.a r6 = com.obric.assistant.obric_action.h.d;
        String r12 = r11.getMessage();
        if (r12 != null) goto L13;
        r12 = "";
    L13:
        if (r12.length() == 0) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L18;
        r12 = "request authentication failed";
    L18:
        b(r1, r7, r0, com.obric.assistant.obric_action.h.a.a(r6, r12, 2), "requestAuthenticationException");
    L19:
        Object r13 = r0.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L22:
        return r13;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static final void b(AtomicBoolean r2, String r3, kotlinx.coroutines.i r4, com.obric.assistant.obric_action.h r5, String r6) {
        if (r2.compareAndSet(false, true) == true) goto L6;
        FLogger.a.w(r3, r6.concat(" ignored because authentication result already completed"));
        return;
    L6:
        if (r4.isActive() == true) goto L8;
        FLogger.a.w(r3, r6.concat(" ignored because authentication continuation is inactive"));
        return;
    L8:
        r4.resumeWith(Result.constructor-impl(r5));
    }
}
