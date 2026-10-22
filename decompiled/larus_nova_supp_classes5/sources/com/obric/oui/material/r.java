package com.obric.oui.material;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(String r2, Map r3) {
        Intrinsics.checkNotNullParameter(r3, "tokens");
        if (r2 == null) goto L7;
        String r4 = r2.toLowerCase(Locale.ROOT);
        if (r4 == null) goto L7;
        String r5 = StringsKt.trim(r4).toString();
    L9:
        if (r5 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L18;
        return null;
    L18:
        return r3.get(r5);
    L11:
        if (r5.length() == 0) goto L14;
        r1 = false;
    L7:
        r5 = null;
        goto L9
    }

    public static void b(Map r4, Map r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "tokenMap");
        Intrinsics.checkNotNullParameter(r5, "customTokens");
        if (r5.isEmpty() == false) goto L6;
        return;
    L6:
        if (r6 == false) goto L16;
        Iterator r7 = r5.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L27;
        Map.Entry r8 = (Map.Entry) r7.next();
        String r2 = (String) r8.getKey();
        Object r9 = r8.getValue();
        String r3 = StringsKt.trim(r2.toLowerCase(Locale.ROOT)).toString();
        if (r3.length() <= 0) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L9;
        r4.put(r3, r9);
        goto L9
    L13:
        r10 = false;
        goto L14
    L27:
        return;
    L16:
        Iterator r11 = r5.entrySet().iterator();
    L18:
        if (r11.hasNext() == false) goto L40;
        Map.Entry r12 = (Map.Entry) r11.next();
        String r13 = (String) r12.getKey();
        Object r14 = r12.getValue();
        String r15 = StringsKt.trim(r13.toLowerCase(Locale.ROOT)).toString();
        if (r15.length() <= 0) goto L22;
        boolean r16 = true;
    L23:
        if (r16 == false) goto L18;
        if (r4.containsKey(r15) == true) goto L18;
        r4.put(r15, r14);
        goto L18
    L22:
        r16 = false;
        goto L23
    }
}
