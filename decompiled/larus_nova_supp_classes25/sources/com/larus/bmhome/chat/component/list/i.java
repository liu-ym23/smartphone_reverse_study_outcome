package com.larus.bmhome.chat.component.list;

import ap8.a;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.adapter.MessageModifyMode;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i implements Function4 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ i(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r9, Object r10, Object r11, Object r12) {
        ChatListComponent r0 = this.a;
        com.larus.bmhome.chat.api.q0 r13 = (com.larus.bmhome.chat.api.q0) r9;
        Message r14 = (Message) r10;
        int r15 = ((Integer) r11).intValue();
        boolean r16 = ((Boolean) r12).booleanValue();
        int r1 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter(r13, "adapter");
        Intrinsics.checkNotNullParameter(r14, "message");
        if (r15 != 1) goto L119;
        ICoreInputAbility r17 = r0.T4();
        if (r17 == null) goto L119;
        MessageAdapter r2 = r0.O;
        if (r2 != null) goto L9;
        MessageModifyMode r3 = MessageModifyMode.MODIFY_TO_REPLACE_TXT;
    L117:
        r17.jm(r13, r14, r16, r3);
        goto L119
    L9:
        List<b> r4 = r2.z2();
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        r5.add(((b) r6.next()).getMessage());
        goto L11
    L13:
        Iterator r7 = r5.iterator();
    L14:
        String r8 = null;
        if (r7.hasNext() == false) goto L19;
        Object r18 = r7.next();
        if (Intrinsics.areEqual(((Message) r18).getReplyId(), r14.getMessageId()) == false) goto L14;
    L20:
        Message r19 = (Message) r18;
        boolean r20 = false;
        if (r19 != null) goto L23;
    L25:
        boolean r21 = false;
    L26:
        if (r21 == true) goto L116;
        if (r19 == null) goto L31;
        Map r22 = r19.getExt();
        if (r22 == null) goto L31;
        String r23 = (String) r22.get("is_rewrite_prompt");
    L33:
        if (Intrinsics.areEqual(r23, "true") == true) goto L116;
        if (r19 == null) goto L38;
        Map r24 = r19.getExt();
        if (r24 == null) goto L38;
        String r25 = (String) r24.get("ai_create_show_mode");
    L40:
        if (com.larus.utils.o0.d(r25) == true) goto L116;
        if (r19 != null) goto L44;
    L52:
        Integer r26 = ic8.j.b(r14);
        if (r26 != null) goto L56;
    L58:
        if (r26 != null) goto L61;
    L63:
        MessageAdapter r27 = r0.O;
        if (r27 == null) goto L66;
        String r28 = r27.C;
    L68:
        if (com.larus.bmhome.chat.adapter.h0.b(r14, r28) == true) goto L111;
        if (r28 != null) goto L72;
    L75:
        boolean r29 = true;
    L76:
        if (r29 == true) goto L113;
        MessageAdapter r30 = r0.O;
        if (r30 == null) goto L113;
        List<b> r31 = r30.z2();
        if (r31 == null) goto L113;
        Sequence r32 = CollectionsKt.asSequence(r31);
        if (r32 == null) goto L113;
        Sequence r33 = SequencesKt.map(r32, new o0());
        if (r33 == null) goto L113;
        Iterator r34 = r33.iterator();
    L88:
        if (r34.hasNext() == false) goto L92;
        Object r35 = r34.next();
        if (Intrinsics.areEqual(((Message) r35).getLocalMessageId(), r28) == false) goto L88;
    L93:
        Message r36 = (Message) r35;
        if (r36 == null) goto L113;
        Map r37 = r14.getExt();
        if (r37 == null) goto L98;
        String r38 = (String) r37.get("collection_id");
    L99:
        Map r39 = r36.getExt();
        if (r39 == null) goto L102;
        r8 = (String) r39.get("collection_id");
    L102:
        if (r38 != null) goto L104;
    L107:
        boolean r40 = true;
    L108:
        if (r40 == true) goto L113;
        if (Intrinsics.areEqual(r38, r8) == false) goto L113;
    L104:
        if (r38.length() == 0) goto L107;
        r40 = false;
        goto L108
    L98:
        r38 = null;
        goto L99
    L92:
        r35 = null;
    L113:
        if ((!r20) == false) goto L115;
        r3 = MessageModifyMode.MODIFY_TO_REGENERATE;
        goto L117
    L115:
        r3 = MessageModifyMode.MODIFY_TO_REPLACE_TXT;
        goto L117
    L72:
        if (r28.length() == 0) goto L75;
        r29 = false;
    L111:
        r20 = true;
        goto L113
    L66:
        r28 = null;
        goto L68
    L61:
        if (r26.intValue() != 1) goto L63;
        r3 = MessageModifyMode.MODIFY_TO_REGENERATE;
        goto L117
    L56:
        if (r26.intValue() != 4) goto L58;
        r3 = MessageModifyMode.MODIFY_TO_REGENERATE;
        goto L117
    L44:
        if (d.I0(r19) == false) goto L48;
        if (CollectionsKt.contains(CollectionsKt.listOf(new String[]{"image", "avatar_image", "music", "avatar_image"}), a.b(r19)) == false) goto L48;
    L50:
        if (d.N0(r19) == true) goto L52;
        r3 = MessageModifyMode.MODIFY_TO_REGENERATE;
    L48:
        if (CollectionsKt.listOf(new Integer[]{6, 72}).contains(Integer.valueOf(r19.getContentType())) == false) goto L52;
    L38:
        r25 = null;
    L31:
        r23 = null;
    L116:
        r3 = MessageModifyMode.MODIFY_TO_REGENERATE;
        goto L117
    L23:
        if (d.j1(r19) != true) goto L25;
        r21 = true;
        goto L26
    L19:
        r18 = null;
    L119:
        return Unit.INSTANCE;
    }
}
