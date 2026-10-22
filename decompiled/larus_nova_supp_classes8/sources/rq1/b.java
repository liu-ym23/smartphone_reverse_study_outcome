package rq1;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final void a(JSONObject r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$putIfNotEmpty");
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L15;
        r1.put(r2, r3);
        return;
    L15:
        return;
    L7:
        r0 = false;
        goto L8
    }
}
