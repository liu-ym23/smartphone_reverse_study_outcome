package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.keyboard.base.ChatAttachmentEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b1 {
    static {
    }

    public static m5b.d a(com.ss.android.lark.keyboard.base.q r30) {
        Intrinsics.checkNotNullParameter(r30, "sendInfo");
        com.ss.android.lark.keyboard.base.r r1 = r30.j;
        m5b.d r8 = new m5b.d(r30.a, r30.b, r30.c, r30.d, null);
        ArrayList r2 = null;
        if (r1 == null) goto L5;
        Context r10 = r1.getContext();
    L7:
        if (r1 != null) goto L9;
    L11:
        boolean r11 = false;
    L12:
        if (r1 != null) goto L14;
    L16:
        boolean r12 = false;
    L17:
        if (r1 == null) goto L19;
        Long r13 = r1.d;
    L20:
        if (r1 == null) goto L22;
        Boolean r14 = r1.e;
    L23:
        if (r1 == null) goto L25;
        String r15 = r1.f;
    L26:
        if (r1 == null) goto L28;
        String r16 = r1.g;
    L29:
        if (r1 == null) goto L31;
        String r17 = r1.h;
    L32:
        if (r1 == null) goto L34;
        String r18 = r1.i;
    L35:
        if (r1 == null) goto L37;
        String r19 = r1.l;
    L38:
        if (r1 == null) goto L40;
        String r20 = r1.m;
    L41:
        if (r1 == null) goto L43;
        Integer r21 = r1.n;
    L44:
        if (r1 == null) goto L46;
        Integer r22 = r1.o;
    L47:
        if (r1 == null) goto L49;
        String r23 = r1.p;
    L50:
        if (r1 == null) goto L52;
        Uri r24 = r1.q;
    L53:
        if (r1 != null) goto L55;
    L57:
        boolean r25 = false;
    L58:
        if (r1 == null) goto L60;
        xcb.a r26 = r1.s;
    L61:
        if (r1 == null) goto L63;
        List r5 = r1.k;
    L64:
        List r6 = r5;
        if (r6 != null) goto L67;
    L70:
        boolean r7 = true;
    L71:
        if (r7 == false) goto L73;
    L72:
        ArrayList r27 = r2;
        if (r1 != null) goto L79;
    L81:
        boolean r28 = false;
    L82:
        r8.e = new m5b.e(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, 285179904);
        return r8;
    L79:
        if (r1.v != true) goto L81;
        r28 = true;
        goto L82
    L73:
        List r9 = r5;
        r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r29 = r9.iterator();
    L75:
        if (r29.hasNext() == false) goto L72;
        r2.add(((ChatAttachmentEntity) r29.next()).toSendPbFile());
        goto L75
    L67:
        if (r6.isEmpty() == true) goto L70;
        r7 = false;
        goto L71
    L63:
        r5 = null;
        goto L64
    L60:
        r26 = null;
        goto L61
    L55:
        if (r1.r != true) goto L57;
        r25 = true;
        goto L58
    L52:
        r24 = null;
        goto L53
    L49:
        r23 = null;
        goto L50
    L46:
        r22 = null;
        goto L47
    L43:
        r21 = null;
        goto L44
    L40:
        r20 = null;
        goto L41
    L37:
        r19 = null;
        goto L38
    L34:
        r18 = null;
        goto L35
    L31:
        r17 = null;
        goto L32
    L28:
        r16 = null;
        goto L29
    L25:
        r15 = null;
        goto L26
    L22:
        r14 = null;
        goto L23
    L19:
        r13 = null;
        goto L20
    L14:
        if (r1.c != true) goto L16;
        r12 = true;
        goto L17
    L9:
        if (r1.b != true) goto L11;
        r11 = true;
        goto L12
    L5:
        r10 = null;
        goto L7
    }
}
