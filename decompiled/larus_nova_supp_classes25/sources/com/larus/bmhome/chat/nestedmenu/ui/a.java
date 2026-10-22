package com.larus.bmhome.chat.nestedmenu.ui;

import com.larus.bmhome.view.screenmenu.l0;
import di8.d0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List a(LinkedHashMap r17, int r18, LinkedHashMap r19) {
        Intrinsics.checkNotNullParameter(r17, "sections");
        Intrinsics.checkNotNullParameter(r19, "clickSections");
        ArrayList r2 = new ArrayList();
        Set r3 = r17.entrySet();
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L22;
        Object r6 = r5.next();
        Map.Entry r8 = (Map.Entry) r6;
        Intrinsics.checkNotNull(r8);
        List r9 = (List) r8.getValue();
        if ((r9 instanceof Collection) == true) goto L8;
    L10:
        Iterator r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L19;
        if (com.larus.bmhome.chat.nestedmenu.e.a((d0) r10.next()) == null) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == false) goto L12;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L4;
        r4.add(r6);
        goto L4
    L16:
        r11 = false;
    L19:
        r7 = false;
        goto L20
    L8:
        if (r9.isEmpty() == false) goto L10;
    L22:
        Iterator r12 = r4.iterator();
        int r13 = 0;
        int r14 = 0;
    L24:
        if (r12.hasNext() == false) goto L42;
        Object r15 = r12.next();
        int r16 = r13 + 1;
        if (r13 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        Map.Entry r20 = (Map.Entry) r15;
        Intrinsics.checkNotNull(r20);
        String r110 = (String) r20.getKey();
        Iterator r21 = ((List) r20.getValue()).iterator();
    L30:
        if (r21.hasNext() == false) goto L38;
        d0 r111 = (d0) r21.next();
        l0 r112 = com.larus.bmhome.chat.nestedmenu.e.a(r111);
        q.a r113 = null;
        if (r112 == null) goto L35;
        r113 = new q.a(r110, r19, r111, l0.b(r112, r14, null, false, -2));
        r14 = r14 + 1;
    L35:
        if (r113 == null) goto L30;
        r2.add(r113);
        goto L30
    L38:
        if (r13 == (r4.size() - 1)) goto L41;
        if (r18 <= 0) goto L41;
        r2.add(new q.b(r18));
    L41:
        r13 = r16;
        goto L24
    L42:
        return r2;
    }
}
