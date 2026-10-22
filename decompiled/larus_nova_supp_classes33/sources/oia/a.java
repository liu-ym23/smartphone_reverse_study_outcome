package oia;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.common.ErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a() {
        FLogger.a.i("EnrollDoraWakeupService", "disableVUI");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        return;
    L6:
        Result.constructor-impl(Integer.valueOf(r1.d().c()));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static void b() {
        FLogger.a.i("EnrollDoraWakeupService", "stopVUISilent");
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L8;
        SessionService r1 = r0.d();
        if (r1 == null) goto L9;
        IDoraService.h.a.a(r1, 4, ErrorCode.EXECUTE_ACTION_ERROR);
        return;
    L9:
        return;
    }

    public static void c(boolean r3) {
        FLogger.a.i("EnrollDoraWakeupService", "updateEnrollingStatus, enrolling=" + r3);
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L6;
        r0.i(r3);
        return;
    }
}
