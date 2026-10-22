package com.larus.bmhome.chat.nestedmenu;

import com.larus.bmhome.actionbar.model.a2;
import com.larus.bmhome.actionbar.model.d1;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.s0;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.u0;
import com.larus.bmhome.actionbar.model.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final di8.a a(z0 r5, String r6) {
        d1 r0 = null;
        if (r5 == null) goto L78;
        p0 r7 = r5.o;
        if (r7 == null) goto L78;
        Boolean r1 = r7.k;
        Boolean r2 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r2) == false) goto L66;
        s0 r3 = r7.j;
        if (r3 == null) goto L12;
        boolean r4 = Intrinsics.areEqual(r3.d, r2);
    L13:
        if (r4 == false) goto L30;
        s0 r8 = r7.j;
        if (r8 == null) goto L30;
        u0 r9 = r8.a;
        if (r9 == null) goto L30;
        ArrayList<t0> r10 = r9.a;
        if (r10 == null) goto L30;
        Iterator<T> r11 = r10.iterator();
    L22:
        if (r11.hasNext() == false) goto L26;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((t0) r12).a, r6) == false) goto L22;
    L27:
        t0 r13 = (t0) r12;
        if (r13 == null) goto L30;
        a2 r14 = r13.r;
    L31:
        s0 r15 = r7.j;
        if (r15 == null) goto L34;
        a2 r16 = r15.b;
    L36:
        if (r15 == null) goto L40;
        u0 r17 = r15.a;
        if (r17 == null) goto L40;
        List r18 = r17.a;
    L41:
        if (r18 != null) goto L43;
        r18 = CollectionsKt.emptyList();
    L43:
        s0 r19 = r7.j;
        if (r19 == null) goto L48;
        u0 r20 = r19.a;
        if (r20 == null) goto L48;
        d1 r21 = r20.b;
    L49:
        if (r14 == null) goto L53;
        List r22 = r14.a;
        if (r22 == null) goto L53;
    L58:
        if (r14 == null) goto L63;
        d1 r23 = r14.b;
        if (r23 == null) goto L63;
        r0 = r23;
    L65:
        di8.a r24 = new di8.a(r18, r21, r22, r0);
    L76:
        return r24;
    L63:
        if (r16 == null) goto L65;
        r0 = r16.b;
    L53:
        if (r16 == null) goto L55;
        r22 = r16.a;
    L56:
        if (r22 != null) goto L58;
        r22 = CollectionsKt.emptyList();
        goto L58
    L55:
        r22 = null;
    L48:
        r21 = null;
    L40:
        r18 = null;
        goto L41
    L34:
        r16 = null;
        goto L36
    L26:
        r12 = null;
    L30:
        r14 = null;
        goto L31
    L12:
        r4 = false;
        goto L13
    L66:
        a2 r25 = r7.d();
        if (r25 == null) goto L69;
        List r26 = r25.a;
    L70:
        if (r26 != null) goto L72;
        r26 = CollectionsKt.emptyList();
    L72:
        a2 r27 = r7.d();
        if (r27 == null) goto L75;
        r0 = r27.b;
    L75:
        r24 = new di8.a(r26, r0, 3);
        goto L76
    L69:
        r26 = null;
    L78:
        return new di8.a(null, null, 15);
    }
}
