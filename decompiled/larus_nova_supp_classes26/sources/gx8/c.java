package gx8;

import com.larus.platform.service.o;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public d a;

    public c() {
    }

    public final void a(String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "extraAttributes");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        d r1 = this.a;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        Iterator<String> r2 = r1.a().keys();     // Catch: Throwable -> L11
    L7:
        if (r2.hasNext() == false) goto L9;
        String r3 = r2.next();     // Catch: Throwable -> L11
        r6.put(r3, r1.a().get(r3));     // Catch: Throwable -> L11
    L9:
        Object r4 = Result.constructor-impl(r6);     // Catch: Throwable -> L11
    L13:
        Object r7 = r6;
        if (Result.exceptionOrNull-impl(r4) != null) goto L16;
        r7 = r4;
    L16:
        o r8 = o.a;
        r8.reportEvent(r5, (JSONObject) r7);
        return;
    L11:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
