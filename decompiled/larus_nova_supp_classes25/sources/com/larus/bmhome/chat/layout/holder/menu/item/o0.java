package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o0 {
    public static final List a(ef8.b r8) {
        com.larus.bmhome.chat.api.q0.a r0 = r8.b;
        if (r0 == null) goto L56;
        IChatMessageShareAbility r1 = r0.J9();
        if (r1 == null) goto L56;
        Message r2 = r8.a;
        com.larus.bmhome.chat.api.q0 r3 = r8.c;
        if (r3 == null) goto L10;
        List r4 = r3.getCurrentList();
    L11:
        if (r4 != null) goto L13;
        r4 = CollectionsKt.emptyList();
    L13:
        List r5 = r1.Us(r2, r4);
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L15:
        if (r7.hasNext() == false) goto L19;
        Object r9 = r7.next();
        if (r1.yk((Message) r9) == false) goto L15;
        r6.add(r9);
        goto L15
    L19:
        Message r10 = r8.a;
        boolean r11 = false;
        if (r6.isEmpty() == true) goto L52;
        Iterator r12 = r6.iterator();
    L24:
        if (r12.hasNext() == false) goto L52;
        Message r13 = (Message) r12.next();
        if (r13 == r10) goto L49;
        String r14 = r13.getMessageId();
        if (r14 != null) goto L30;
    L33:
        boolean r15 = true;
    L34:
        if (r15 == false) goto L36;
    L37:
        String r16 = r13.getLocalMessageId();
        if (r16 != null) goto L40;
    L43:
        boolean r17 = true;
    L44:
        if (r17 == false) goto L46;
    L48:
        boolean r18 = false;
    L50:
        if (r18 == false) goto L24;
        r11 = true;
        goto L52
    L46:
        if (Intrinsics.areEqual(r13.getLocalMessageId(), r10.getLocalMessageId()) == false) goto L48;
    L40:
        if (r16.length() == 0) goto L43;
        r17 = false;
        goto L44
    L36:
        if (Intrinsics.areEqual(r13.getMessageId(), r10.getMessageId()) == true) goto L49;
    L30:
        if (r14.length() == 0) goto L33;
        r15 = false;
    L49:
        r18 = true;
    L52:
        if (r11 == false) goto L67;
        return r6;
    L67:
        return CollectionsKt.listOf(r8.a);
    L10:
        r4 = null;
    L56:
        return CollectionsKt.listOf(r8.a);
    }
}
