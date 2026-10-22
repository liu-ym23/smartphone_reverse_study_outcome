package h1a;

import com.larus.platform.service.g;
import com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static void a(OldUgcGenImgPerfMonitor.b r3, com.larus.ugc.perf.impl.e r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        c.a(r3, r4, null);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r1 = new JSONObject(a.a.toJson(r3));     // Catch: Throwable -> L5
        g.a.monitorEventForSlardar("chat_generate_image", r1, new JSONObject(), null);     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L14;
        FLogger.a.e("UgcCompatGenerateImageEvent", String.valueOf(r7.getMessage()));
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void b(a r1, com.larus.ugc.perf.impl.e r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        c.a(r1, r2, null);
    }
}
