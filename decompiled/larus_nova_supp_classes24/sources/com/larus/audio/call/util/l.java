package com.larus.audio.call.util;

import com.larus.audio.call.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.a;
import ouc.d0;
import ouc.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l {
    public static final d0 c(d0 r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        c r0 = com.larus.audio.call.f.d().h;
        if (r0 != null) goto L5;
        return r7;
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = r7.keySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L14;
        String r3 = (String) r2.next();
        if (StringsKt.isBlank(r3) == true) goto L7;
        ouc.i r6 = (ouc.i) r7.get(r3);
        if (r6 == null) goto L7;
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r6, "element");
        ouc.i r4 = (ouc.i) r1.put(r3, r6);
        goto L7
    L14:
        g0 r8 = ouc.k.c(r0.a);
        Intrinsics.checkNotNullParameter("lark_sso_token", "key");
        Intrinsics.checkNotNullParameter(r8, "element");
        ouc.i r9 = (ouc.i) r1.put("lark_sso_token", r8);
        g0 r10 = ouc.k.c(r0.b);
        Intrinsics.checkNotNullParameter("luna_vip_mode", "key");
        Intrinsics.checkNotNullParameter(r10, "element");
        ouc.i r11 = (ouc.i) r1.put("luna_vip_mode", r10);
        return new d0(r1);
    }

    public static final d0 a(d0 r6, d0 r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r1 = r6.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        String r2 = (String) r1.next();
        if (StringsKt.isBlank(r2) == true) goto L4;
        ouc.i r5 = (ouc.i) r6.get(r2);
        if (r5 == null) goto L4;
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r5, "element");
        ouc.i r3 = (ouc.i) r0.put(r2, r5);
        goto L4
    L11:
        Iterator r8 = r7.keySet().iterator();
    L13:
        if (r8.hasNext() == false) goto L21;
        String r4 = (String) r8.next();
        if (StringsKt.isBlank(r4) == true) goto L13;
        ouc.i r9 = (ouc.i) r7.get(r4);
        if (r9 == null) goto L13;
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r9, "element");
        ouc.i r10 = (ouc.i) r0.put(r4, r9);
        goto L13
    L21:
        return new d0(r0);
    }

    public static final String b(String r3, String r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return r3;
    L11:
        if (r3 != null) goto L13;
    L14:
        r0 = true;
    L15:
        if (r0 == false) goto L17;
        return r4;
    L17:
        a.a r1 = a.d;
        d0 r5 = ouc.k.n(r1.e(r3));
        return a(ouc.k.n(r1.e(r4)), r5).toString();
    L13:
        if (StringsKt.isBlank(r3) == false) goto L15;
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r2 = false;
        goto L9
    }
}
