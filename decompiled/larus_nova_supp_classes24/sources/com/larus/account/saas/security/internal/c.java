package com.larus.account.saas.security.internal;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r2, Map r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "extras");
        JSONObject r1 = new JSONObject();
        r1.put("result", r2);
        Iterator r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r5 = (Map.Entry) r4.next();
        r1.put((String) r5.getKey(), r5.getValue());
        goto L4
    L6:
        com.larus.account.saas.runtime.internal.delegate.a.a.d("account_security_event", r1.toString());
    }
}
