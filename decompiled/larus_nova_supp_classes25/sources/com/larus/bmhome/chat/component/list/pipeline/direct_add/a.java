package com.larus.bmhome.chat.component.list.pipeline.direct_add;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.utils.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import td8.c;
import td8.d;
import wc9.e;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements c {
    public final d a;

    @Override // td8.c
    public final boolean a(int r1, b r2, b r3, List<? extends b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        return true;
    }

    public a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    @Override // td8.c
    public final List<b> b(int r54, b r55, b r56, List<b> r57) {
        Intrinsics.checkNotNullParameter(r56, "current");
        Intrinsics.checkNotNullParameter(r57, "input");
        ArrayList r2 = new ArrayList();
        Iterator<T> r1 = r57.iterator();
    L3:
        boolean r4 = true;
        if (r1.hasNext() == false) goto L14;
        Object r3 = r1.next();
        Integer r5 = b0.c(((b) r3).getMessage());
        if (r5 != null) goto L9;
    L11:
        r4 = false;
    L12:
        if (r4 == true) goto L3;
        r2.add(r3);
        goto L3
    L9:
        if (r5.intValue() != 14) goto L11;
    L14:
        ArrayList r6 = new ArrayList();
        int r7 = UserActiveDeleteTipHelper.a;
        int r8 = ra9.a.a;
        String r9 = ga9.a.e("delete_msg_tip_display", "0");
        String r10 = null;
        if (Intrinsics.areEqual(r9, "0") == false) goto L18;
        UserActiveDeleteTipHelper.DeleteMsgTipDisplay r11 = null;
    L21:
        if (r11 == null) goto L23;
        LinkedHashSet r12 = new LinkedHashSet();
        Iterator r13 = r2.iterator();
    L26:
        if (r13.hasNext() == false) goto L38;
        b r14 = (b) r13.next();
        int r15 = UserActiveDeleteTipHelper.a;
        List r16 = UserActiveDeleteTipHelper.e(r14.getMessage());
        ArrayList r17 = new ArrayList();
        Iterator r18 = r16.iterator();
    L29:
        if (r18.hasNext() == false) goto L34;
        Object r19 = r18.next();
        if (r12.add((String) r19) == false) goto L29;
        r17.add(r19);
        goto L29
    L34:
        if ((!r17.isEmpty()) == false) goto L36;
        r6.add(new cg8.c(UserActiveDeleteTipHelper.a(r14.getMessage(), r17, r11)));
    L36:
        r6.add(r14);
        goto L26
    L38:
        if (this.a.e() == false) goto L67;
        int r20 = UserActiveDeleteTipHelper.a;
        int r21 = p0.a;
        e r22 = this.a.g();
        if (r22 == null) goto L42;
        String r23 = r22.r;
    L43:
        JSONObject r24 = p0.b(r23);
        if (r24 != null) goto L46;
        List r25 = CollectionsKt.emptyList();
    L50:
        b r26 = (b) CollectionsKt.lastOrNull(r2);
        if (r26 == null) goto L54;
        Message r27 = r26.getMessage();
        if (r27 == null) goto L54;
    L58:
        ArrayList r28 = new ArrayList();
        Iterator r29 = r25.iterator();
    L60:
        if (r29.hasNext() == false) goto L65;
        Object r30 = r29.next();
        if (r12.add((String) r30) == false) goto L60;
        r28.add(r30);
        goto L60
    L65:
        if ((true ^ r28.isEmpty()) == false) goto L67;
        r6.add(new cg8.c(UserActiveDeleteTipHelper.a(r27, r28, r11)));
    L54:
        e r31 = this.a.g();
        if (r31 == null) goto L57;
        r10 = r31.a;
    L57:
        r27 = new Message(r10, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -2, 31, null);
        goto L58
    L46:
        String r32 = r24.optString("suffix_active_delete_message_id_list");
        if (StringsKt.isBlank(r32) == false) goto L49;
        r32 = r24.optString("sub_active_msg_id_list");
    L49:
        r25 = UserActiveDeleteTipHelper.b(r32);
        goto L50
    L42:
        r23 = null;
    L67:
        return r6;
    L23:
        return CollectionsKt.toMutableList(r2);
    L18:
        if (Intrinsics.areEqual(r9, "2") == false) goto L20;
        r11 = UserActiveDeleteTipHelper.DeleteMsgTipDisplay.RECALL;
        goto L21
    L20:
        r11 = UserActiveDeleteTipHelper.DeleteMsgTipDisplay.DELETE;
        goto L21
    }
}
