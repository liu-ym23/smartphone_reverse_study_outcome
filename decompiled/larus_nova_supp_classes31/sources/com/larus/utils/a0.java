package com.larus.utils;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0 {
    public static final void a(JSONObject r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "json");
        Iterator<String> r0 = r4.keys();
        Intrinsics.checkNotNull(r0);
    L4:
        if (r0.hasNext() == false) goto L17;
        String r1 = r0.next();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L4;
        Object r5 = r4.opt(r1);
        if (r5 == null) goto L4;
        r3.put(r1, r5);
        goto L4
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r2 = false;
        goto L12
    }
}
