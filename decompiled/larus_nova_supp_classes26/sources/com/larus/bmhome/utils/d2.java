package com.larus.bmhome.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d2 implements s0 {
    public final boolean a;

    @Override // com.larus.bmhome.utils.s0
    public final void a() {
    }

    public d2(boolean r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.utils.s0
    public final List<b> filter(List<? extends b> r9) {
        Intrinsics.checkNotNullParameter(r9, "message");
        int r1 = 0;
    L4:
        if (r1 >= r9.size()) goto L9;
        if (com.larus.bmhome.chat.bean.d.G0(((b) ListProtector.get(r9, r1)).getMessage()) == true) goto L9;
        r1 = r1 + 1;
    L9:
        if (r1 >= r9.size()) goto L25;
        int r2 = r1 + 1;
        if (r2 >= r9.size()) goto L25;
        if (com.larus.bmhome.chat.bean.d.G0(((b) ListProtector.get(r9, r2)).getMessage()) == false) goto L25;
        Map r3 = ((b) ListProtector.get(r9, r1)).getMessage().getBusinessExt();
        String r5 = null;
        if (r3 == null) goto L17;
        String r4 = (String) r3.get("message_group_id");
    L18:
        Map r6 = ((b) ListProtector.get(r9, r2)).getMessage().getBusinessExt();
        if (r6 == null) goto L22;
        r5 = (String) r6.get("message_group_id");
    L22:
        if (Intrinsics.areEqual(r4, r5) == false) goto L25;
        r1 = r2;
        goto L9
    L17:
        r4 = null;
    L25:
        if (this.a == false) goto L39;
        if (r1 >= r9.size()) goto L36;
        int r7 = r1 + 1;
        if (r7 >= r9.size()) goto L36;
        Message r8 = ((b) ListProtector.get(r9, r1)).getMessage();
        Message r10 = ((b) ListProtector.get(r9, r7)).getMessage();
        if (Intrinsics.areEqual(r8.getSectionId(), r10.getSectionId()) == true) goto L34;
    L35:
        boolean r11 = true;
    L37:
        if (r11 == false) goto L39;
    L40:
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r9.iterator();
        int r14 = 0;
    L42:
        if (r13.hasNext() == false) goto L54;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        b r17 = (b) r15;
        if (r14 > r1) goto L49;
        boolean r18 = true;
    L50:
        if (r18 == false) goto L52;
        r12.add(r15);
    L52:
        r14 = r16;
        goto L42
    L49:
        r18 = false;
        goto L50
    L54:
        return r12;
    L34:
        if (com.larus.bmhome.chat.bean.d.z0(r10) == true) goto L35;
    L36:
        r11 = false;
    L39:
        if (this.a == false) goto L40;
        return r9;
    }
}
