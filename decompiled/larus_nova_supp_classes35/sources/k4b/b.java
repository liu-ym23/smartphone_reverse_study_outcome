package k4b;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Function1<f5b.b, Boolean> {
    public final String a;
    public final boolean b;

    public final Object invoke(Object r5) {
        f5b.b r6 = (f5b.b) r5;
        Intrinsics.checkNotNullParameter(r6, "chatMessage");
        if (this.b == true) goto L5;
    L21:
        ChatChatter r7 = r6.getMessageSender();
        if (r7 != null) goto L25;
        return Boolean.FALSE;
    L25:
        return Boolean.valueOf(Intrinsics.areEqual(r7.getId(), this.a));
    L5:
        if ((r6 instanceof MessageInfo) == false) goto L7;
        MessageInfo r0 = (MessageInfo) r6;
    L8:
        if (r0 == null) goto L21;
        List<MessageInfo> r1 = r0.getLatestRepliesInThread();
        if (r1 == null) goto L21;
        Iterator<T> r2 = r1.iterator();
    L13:
        if (r2.hasNext() == false) goto L21;
        ChatChatter r3 = ((MessageInfo) r2.next()).getMessageSender();
        if (r3 == null) goto L17;
        String r4 = r3.getId();
    L19:
        if (Intrinsics.areEqual(r4, this.a) == false) goto L13;
        return Boolean.TRUE;
    L17:
        r4 = null;
        goto L19
    L7:
        r0 = null;
        goto L8
    }

    public b(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        this.a = r2;
        this.b = r3;
    }
}
