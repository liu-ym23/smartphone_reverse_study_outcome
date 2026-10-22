package com.larus.bmhome.chat.list.cell.test;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y extends b {
    public static final /* synthetic */ int e = 0;

    public static final class a {
        public static y a(Message r50) {
            Intrinsics.checkNotNullParameter(r50, "message");
            int r2 = com.larus.bmhome.chat.layout.holder.helper.s.a;
            Intrinsics.checkNotNullParameter(r50, "message");
            List r1 = com.larus.bmhome.chat.layout.holder.helper.s.a(r50);
            if (r1 == null) goto L20;
            Iterator r3 = r1.iterator();
            if (r3.hasNext() == true) goto L7;
            Object r4 = null;
        L17:
            Message r5 = (Message) r4;
            if (r5 == null) goto L20;
            long r6 = r5.getLocalIndex();
        L21:
            long r22 = r6 - 1;
            String r7 = r50.getConversationId();
            String r8 = r50.getSenderId();
            String r21 = r50.getMessageId() + "-crowd-onClick-tab";
            String r27 = r50.getSectionId();
            String r37 = r50.getReplyId();
            MessageStatus r11 = MessageStatus.MessageStatus_AVAILABLE;
            List r45 = r50.getSubListGroup();
            Pair[] r9 = new Pair[1];
            String r10 = r50.getMessageId();
            String r12 = "";
            if (r10 != null) goto L24;
            r10 = "";
        L24:
            r9[0] = TuplesKt.to("refer_msg_id", r10);
            Map<String, String> r19 = c.a(MapsKt.mutableMapOf(r9), r50);
            Pair[] r13 = new Pair[1];
            String r0 = r50.getSenderId();
            if (r0 == null) goto L28;
            r12 = r0;
        L28:
            r13[0] = TuplesKt.to("bot_id", r12);
            return new y(b0.j(new Message(r7, null, r8, 0, 21, r11, 800, false, null, null, null, null, null, r19, null, r21, r22, 0, false, r27, null, null, MapsKt.mutableMapOf(r13), null, null, 0, false, 0, r37, null, false, "crowd_test_tab", null, 0, null, r45, null, 1874222986, 23, null), 7));
        L7:
            Object r14 = r3.next();
            if (r3.hasNext() == true) goto L10;
        L9:
            r4 = r14;
            goto L17
        L10:
            long r15 = ((Message) r14).getServerIndex();
        L11:
            Object r16 = r3.next();
            long r17 = ((Message) r16).getServerIndex();
            if (r15 <= r17) goto L15;
            r14 = r16;
            r15 = r17;
        L15:
            if (r3.hasNext() == true) goto L11;
        L20:
            r6 = r50.getLocalIndex();
            goto L21
        }
    }

    static {
    }

    @Override // xc8.b
    public final int d() {
        return 0;
    }

    public y(Message r1) {
        super(r1);
    }
}
