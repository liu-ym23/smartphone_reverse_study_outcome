package com.obric.aikernel.utils;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final void a(Map<String, String> r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "key");
        if (r12 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == true) goto L12;
        r10.put(r11, r12);
        return;
    L12:
        return;
    L5:
        if (r12.length() == 0) goto L8;
        r13 = false;
        goto L9
    }

    public static final <T> JSONObject b(Map<String, T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JSONObject r11 = new JSONObject();
        Iterator<Map.Entry<String, T>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<String, T> r13 = r12.next();
        r11.put(r13.getKey(), r13.getValue());
        goto L4
    L6:
        return r11;
    }
}
