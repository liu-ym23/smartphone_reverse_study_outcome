package com.larus.bmhome.chat.markdown.richtext;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q {
    public static final String a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "content");
        Regex r1 = n.a;
        Intrinsics.checkNotNullParameter(r9, "content");
        int r2 = 0;
        i r10 = n.n(r9, true, false, true);
        List<g> r3 = r10.b;
        if ((r3 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r4 = r3.iterator();
        int r5 = 0;
    L9:
        if (r4.hasNext() == false) goto L15;
        if (o.a((g) r4.next()) == false) goto L9;
        r5 = r5 + 1;
        if (r5 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L15:
        List<h> r6 = r10.c;
        if ((r6 instanceof Collection) == true) goto L18;
    L20:
        Iterator<T> r7 = r6.iterator();
        int r8 = 0;
    L22:
        if (r7.hasNext() == false) goto L35;
        String r11 = ((h) r7.next()).c;
        if (r11 != null) goto L26;
    L29:
        boolean r12 = true;
    L31:
        if ((!r12) == false) goto L22;
        r8 = r8 + 1;
        if (r8 >= 0) goto L22;
        CollectionsKt.throwCountOverflow();
        goto L22
    L26:
        if (StringsKt.isBlank(r11) == true) goto L29;
        r12 = false;
    L35:
        List<h> r13 = r10.c;
        if ((r13 instanceof Collection) == true) goto L38;
    L40:
        Iterator<T> r14 = r13.iterator();
        int r15 = 0;
    L42:
        if (r14.hasNext() == false) goto L55;
        String r16 = ((h) r14.next()).e;
        if (r16 != null) goto L46;
    L49:
        boolean r17 = true;
    L51:
        if ((!r17) == false) goto L42;
        r15 = r15 + 1;
        if (r15 >= 0) goto L42;
        CollectionsKt.throwCountOverflow();
        goto L42
    L46:
        if (StringsKt.isBlank(r16) == true) goto L49;
        r17 = false;
    L55:
        List<j> r18 = r10.d;
        if ((r18 instanceof Collection) == true) goto L58;
    L60:
        Iterator<T> r19 = r18.iterator();
        int r20 = 0;
    L62:
        if (r19.hasNext() == false) goto L74;
        r r21 = ((j) r19.next()).e;
        if ((r21 instanceof r.a) == false) goto L66;
    L69:
        boolean r22 = true;
    L70:
        if (r22 == false) goto L62;
        r20 = r20 + 1;
        if (r20 >= 0) goto L62;
        CollectionsKt.throwCountOverflow();
        goto L62
    L66:
        if ((r21 instanceof r.c) == true) goto L69;
        r22 = false;
    L74:
        List<j> r0 = r10.d;
        if ((r0 instanceof Collection) == true) goto L77;
    L79:
        Iterator<T> r23 = r0.iterator();
        int r24 = 0;
    L81:
        if (r23.hasNext() == false) goto L87;
        if ((((j) r23.next()).e instanceof r.b) == false) goto L81;
        r24 = r24 + 1;
        if (r24 >= 0) goto L81;
        CollectionsKt.throwCountOverflow();
    L87:
        List<j> r25 = r10.d;
        if ((r25 instanceof Collection) == true) goto L90;
    L92:
        Iterator<T> r26 = r25.iterator();
    L94:
        if (r26.hasNext() == false) goto L100;
        if ((((j) r26.next()).e instanceof r.d) == false) goto L94;
        r2 = r2 + 1;
        if (r2 >= 0) goto L94;
        CollectionsKt.throwCountOverflow();
    L100:
        JSONObject r27 = new JSONObject();
        if (r5 <= 0) goto L103;
        r27.put("cloud_doc", r5);
    L103:
        if (r8 <= 0) goto L105;
        r27.put("contact", r8);
    L105:
        if (r15 <= 0) goto L107;
        r27.put("group_chat", r15);
    L107:
        if (r20 <= 0) goto L109;
        r27.put("attachment", r20);
    L109:
        if (r24 <= 0) goto L111;
        r27.put("conversation", r24);
    L111:
        if (r2 <= 0) goto L114;
        r27.put("skill", r2);
    L114:
        return r27.toString();
    L90:
        if (r25.isEmpty() == false) goto L92;
    L77:
        if (r0.isEmpty() == false) goto L79;
        r24 = 0;
        goto L87
    L58:
        if (r18.isEmpty() == false) goto L60;
        r20 = 0;
        goto L74
    L38:
        if (r13.isEmpty() == false) goto L40;
        r15 = 0;
        goto L55
    L18:
        if (r6.isEmpty() == false) goto L20;
        r8 = 0;
        goto L35
    L5:
        if (r3.isEmpty() == false) goto L7;
        r5 = 0;
        goto L15
    }
}
