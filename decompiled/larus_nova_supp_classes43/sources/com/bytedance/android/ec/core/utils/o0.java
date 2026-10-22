package com.bytedance.android.ec.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o0 {
    public final String a;
    public final HashMap<String, String> b;

    public final String c() {
        String r0 = this.a + '?';
        Iterator<Map.Entry<String, String>> r1 = this.b.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<String, String> r10 = r1.next();
        r0 = r0 + r10.getKey() + '=' + r10.getValue() + '&';
        goto L4
    L7:
        return StringsKt.dropLast(r0, 1);
    }

    public o0(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a = "";
        this.b = new HashMap();
        List r11 = d(r10, "?");
        String r12 = (String) CollectionsKt.getOrNull(r11, 0);
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        this.a = r12;
        String r13 = (String) CollectionsKt.getOrNull(r11, 1);
        if (r13 == null) goto L24;
        List r14 = StringsKt.split$default(r13, new String[]{"&"}, false, 0, 6, null);
        if (r14 == null) goto L29;
        Iterator r15 = r14.iterator();
    L11:
        if (r15.hasNext() == false) goto L30;
        Iterator r16 = ((ArrayList) d((String) r15.next(), "=")).iterator();
        String r17 = "";
        String r18 = r17;
        int r19 = 0;
    L14:
        if (r16.hasNext() == false) goto L23;
        Object r20 = r16.next();
        int r21 = r19 + 1;
        if (r19 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        String r22 = (String) r20;
        if (r19 != 0) goto L21;
        r17 = r22;
    L22:
        r19 = r21;
        goto L14
    L21:
        r18 = r22;
        goto L22
    L23:
        this.b.put(r17, r18);
        goto L11
    L30:
        return;
    L29:
        return;
    }

    public final String e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return this.b.get(r10);
    }

    public static List d(String r10, String r11) {
        ArrayList r0 = new ArrayList();
        Iterator r12 = StringsKt.split$default(r10, new String[]{r11}, false, 2, 2, null).iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        r0.add((String) r12.next());
        goto L4
    L7:
        if (r0.size() >= 2) goto L9;
        r0.add("");
    L9:
        return r0;
    }

    public final void a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        HashMap<String, String> r0 = this.b;
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r0.put(r10, r11);
    }

    public final void b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (this.b.containsKey(r10) == true) goto L9;
        HashMap<String, String> r0 = this.b;
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        r0.put(r10, r11);
        return;
    }
}
