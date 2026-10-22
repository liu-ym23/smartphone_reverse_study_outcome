package v89;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new h());
    }

    public static void a(String r4, String r5, long r6, String r8, String r9, Context r10) {
        Unit r1 = null;
        if ((r10 instanceof LifecycleOwner) == false) goto L5;
        LifecycleOwner r11 = (LifecycleOwner) r10;
    L6:
        if (r11 == null) goto L13;
        Lifecycle r12 = r11.getLifecycle();
        if (r12 == null) goto L13;
        Lifecycle.State r13 = r12.getCurrentState();
        if (r13 == null) goto L13;
        String r14 = r13.name();
        if (r14 == null) goto L13;
    L14:
        FLogger.a.i("FlowTransferRedirect", "[report] status=" + r4 + ", reason=" + r5 + ", duration=" + r6 + "ms, source=" + r9 + ", url=" + r8 + ", lifecycle=" + r14);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L20
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L20
        r2.put("status", r4);     // Catch: Throwable -> L20
        r2.put("reason", r5);     // Catch: Throwable -> L20
        r2.put("duration", r6);     // Catch: Throwable -> L20
        r2.put("url", r8);     // Catch: Throwable -> L20
        r2.put("source", r9);     // Catch: Throwable -> L20
        r2.put("lifecycle_state", r14);     // Catch: Throwable -> L20
        IApplog r7 = (IApplog) ServiceManager.get().getService(IApplog.class);     // Catch: Throwable -> L20
        if (r7 == null) goto L18;
        r7.reportEvent("flow_web_transfer_redirect_result", r2);     // Catch: Throwable -> L20
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Object r15 = Result.constructor-impl(r1);     // Catch: Throwable -> L20
    L22:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L28;
        FLogger.a.e("FlowTransferRedirect", "[report] error: " + r16.getMessage(), r16);
        return;
    L28:
        return;
    L20:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        r14 = "unknown";
        goto L14
    L5:
        r11 = null;
        goto L6
    }
}
