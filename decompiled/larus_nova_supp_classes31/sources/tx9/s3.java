package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s3 {
    public static void a(String r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("scene", r5);     // Catch: JSONException -> L5
    L7:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r2 = new by7.a("spring_client_downgrade_toast");
        r2.a.merge(r6);
        r2.b();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L10
        com.larus.platform.service.g.a.monitorEventForSlardar("spring_client_downgrade_toast", r0, null, null);     // Catch: Throwable -> L10
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L21;
        FLogger.a.e("SpringClientEvent", "slardar report error, mobSpringClientDowngradeToast " + r9.getLocalizedMessage());
        return;
    L21:
        return;
    L10:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        e = move-exception;
        FLogger.a.e("SpringClientEvent", "error in SpringClientEvent mobSpringClientDowngradeToast " + e.getLocalizedMessage());
        goto L7
    }
}
