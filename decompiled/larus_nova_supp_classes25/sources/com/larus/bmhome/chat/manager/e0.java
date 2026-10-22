package com.larus.bmhome.chat.manager;

import com.larus.im.bean.message.Message;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 {
    public static final Map<String, d0> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static d0 a(String r1) {
        return (d0) ((LinkedHashMap) a).get(r1);
    }

    public static void c(String r3, String r4, boolean r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        Map<String, d0> r0 = a;
        if (r0.containsKey(r3) == true) goto L7;
        r0.put(r3, new d0(0));
    L7:
        d0 r6 = (d0) ((LinkedHashMap) r0).get(r3);
        if (r6 != null) goto L10;
        return;
    L10:
        if (r5 == true) goto L12;
    L14:
        r6.c = r4;
        return;
    L12:
        if (Intrinsics.areEqual(r6.c, r4) == true) goto L14;
        r6.e = null;
        r6.f = null;
        r6.a = null;
        r6.b = 0;
        r6.d = -1;
        goto L14
    }

    public static void b(String r6, Message r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "msg");
        if (r6 != null) goto L5;
        return;
    L5:
        Map<String, d0> r0 = a;
        if (r0.containsKey(r6) == true) goto L8;
        r0.put(r6, new d0(0));
    L8:
        d0 r10 = (d0) ((LinkedHashMap) r0).get(r6);
        if (r10 != null) goto L11;
        return;
    L11:
        String r1 = r10.e;
        if (r1 != null) goto L14;
    L15:
        String r2 = r10.f;
        if (r2 != null) goto L18;
    L20:
        Message r3 = r10.a;
        if (r3 != null) goto L23;
    L28:
        r10.b = r8;
        r10.a = r7;
        r10.d = r9;
        return;
    L23:
        if (r3.getLocalIndex() < r7.getLocalIndex()) goto L28;
        if (Intrinsics.areEqual(r3.getLocalMessageId(), r7.getLocalMessageId()) == true) goto L27;
        return;
    L27:
        if (r8 > r10.b) goto L28;
        return;
    L18:
        if (Intrinsics.areEqual(r2, r7.getLocalMessageId()) == false) goto L20;
        return;
    L14:
        if (Intrinsics.areEqual(r1, r7.getMessageId()) == false) goto L15;
    }
}
