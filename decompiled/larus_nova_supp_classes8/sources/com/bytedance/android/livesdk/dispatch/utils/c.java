package com.bytedance.android.livesdk.dispatch.utils;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static HashMap a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "raw");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        JSONObject r1 = new JSONObject(URLDecoder.decode(r4, "utf-8"));
        Intrinsics.checkNotNullParameter(r1, "$this$toMap");
        HashMap r5 = new HashMap();
        Iterator<String> r2 = r1.keys();
    L11:
        if (r2.hasNext() == false) goto L13;
        String r3 = r2.next();
        r5.put(r3, r1.get(r3).toString());
        goto L11
    L13:
        return r5;
    L8:
        return new HashMap();
    L5:
        r0 = false;
        goto L6
    }
}
