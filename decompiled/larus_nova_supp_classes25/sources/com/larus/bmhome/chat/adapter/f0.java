package com.larus.bmhome.chat.adapter;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f0 {
    public static final List<Message> a(Message r12, List<Message> r13) {
        Iterator<Message> r0 = r13.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r0.next().getMessageId(), r12.getMessageId()) == true) goto L10;
        r2 = r2 + 1;
    L10:
        int r3 = r2 + 1;
        Iterator<Message> r4 = r13.iterator();
        int r5 = 0;
    L12:
        if (r4.hasNext() == false) goto L26;
        Message r6 = r4.next();
        if (r6.getLocalIndex() < r12.getLocalIndex()) goto L16;
    L22:
        boolean r7 = false;
    L23:
        if (r7 == true) goto L27;
        r5 = r5 + 1;
    L27:
        if (r5 != (-1)) goto L30;
        r5 = r13.size();
    L30:
        if (r3 <= r5) goto L33;
        String r14 = "getLastRoundSelfMsgList error " + r3 + "  " + r5;
        Intrinsics.checkNotNullParameter("MessageListExt", "<this>");
        Intrinsics.checkNotNullParameter(r14, "errorMsg");
        FLogger.a.e("MessageListExt", r14);
        return null;
    L33:
        FLogger.a.i("MessageListExt", "getLastRoundSelfMsgList index range " + r3 + "  " + r5);
        return new ArrayList(r13.subList(r3, r5));
    L16:
        if (com.larus.utils.o0.d(r6.getReplyId()) == false) goto L22;
        if (Intrinsics.areEqual(r6.getReplyId(), r12.getReplyId()) == true) goto L22;
        if (com.larus.bmhome.chat.bean.d.G0(r6) == true) goto L22;
        r7 = true;
        goto L23
    L26:
        r5 = -1;
        goto L27
    L9:
        r2 = -1;
        goto L10
    }

    public static final Message b(Message r5, List<Message> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getContentType() != 6) goto L5;
        return r5;
    L5:
        Object r0 = null;
        if (r6 != null) goto L9;
        return null;
    L9:
        if (com.larus.utils.o0.d(com.larus.im.bean.message.a.g(r5)) == false) goto L30;
        List<Message> r7 = a(r5, r6);
        if (r7 == null) goto L31;
        Iterator<T> r8 = r7.iterator();
    L14:
        if (r8.hasNext() == false) goto L24;
        Object r1 = r8.next();
        Message r2 = (Message) r1;
        if (Intrinsics.areEqual(r2.getLocalMessageId(), r5.getLocalMessageId()) == false) goto L18;
    L20:
        boolean r3 = false;
    L21:
        if (r3 == false) goto L14;
        r0 = r1;
        goto L24
    L18:
        if (Intrinsics.areEqual(com.larus.im.bean.message.a.g(r2), com.larus.im.bean.message.a.g(r5)) == false) goto L20;
        r3 = true;
    L24:
        return (Message) r0;
    L31:
        return null;
    L30:
        return null;
    }

    public static final Message c(Message r4, List<Message> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Object r0 = null;
        if (r5 != null) goto L6;
        return null;
    L6:
        if (com.larus.utils.o0.d(r4.getReplyId()) == false) goto L20;
        List<Message> r6 = a(r4, r5);
        if (r6 == null) goto L21;
        Iterator<T> r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L16;
        Object r1 = r7.next();
        if (Intrinsics.areEqual(((Message) r1).getMessageId(), r4.getReplyId()) == false) goto L11;
        r0 = r1;
    L16:
        return (Message) r0;
    L21:
        return null;
    L20:
        return null;
    }
}
