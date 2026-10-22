package lg8;

import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final boolean a(q0 r2, Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        if (r2 == null) goto L24;
        List r4 = r2.getCurrentList();
        if (r4 == null) goto L26;
        String r5 = r3.getReplyId();
        if (r5 == null) goto L25;
        List r6 = r4;
        if ((r6 instanceof Collection) == true) goto L12;
    L14:
        Iterator r7 = r6.iterator();
    L16:
        if (r7.hasNext() == false) goto L28;
        if (Intrinsics.areEqual(((Message) r7.next()).getMessageId(), r5) == false) goto L16;
        return true;
    L28:
        return false;
    L12:
        if (r6.isEmpty() == false) goto L14;
        return false;
    L25:
        return false;
    L26:
        return false;
    L24:
        return false;
    }

    public static final boolean b(q0 r5, Message r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        if (r5 == null) goto L22;
        List r7 = r5.getCurrentList();
        if (r7 == null) goto L22;
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L19;
        Object r1 = r8.next();
        Message r2 = (Message) r1;
        if (r2.getContentType() == 800) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L9;
    L21:
        return Intrinsics.areEqual(r6, r1);
    L13:
        if (Intrinsics.areEqual(r2.getBizContentType(), "edu_continue_shot") == false) goto L16;
        r3 = false;
        goto L17
    L19:
        r1 = null;
    L22:
        return false;
    }
}
