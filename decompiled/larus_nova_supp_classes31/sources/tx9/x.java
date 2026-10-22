package tx9;

import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x {
    public static final x a = null;
    public static final String[] b = null;

    public x() {
    }

    static {
        a = new x();
        b = new String[]{"app_key", "app_name", "app_type"};
    }

    public static void a(Map r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        if (r5 != null) goto L6;
        return;
    L6:
        String[] r1 = b;     // Catch: Throwable -> L14
        int r2 = r1.length;     // Catch: Throwable -> L14
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L12;
        String r4 = r1[r3];     // Catch: Throwable -> L14
        String r7 = (String) r5.get(r4);     // Catch: Throwable -> L14
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        r6.put(r4, r7);     // Catch: Throwable -> L14
        r3 = r3 + 1;     // Catch: Throwable -> L14
        goto L7
    L12:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
