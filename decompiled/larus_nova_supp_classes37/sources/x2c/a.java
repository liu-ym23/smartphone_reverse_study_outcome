package x2c;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import kotlin.jvm.internal.Intrinsics;
import x4b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements c<MessageInfo, y6b.c<?>> {
    public final String a;
    public final boolean b;
    public final String c;
    public final u2b.c d;

    public final y6b.c b(Object r6) {
        MessageInfo r7 = (MessageInfo) r6;
        if (r7 != null) goto L5;
        return null;
    L5:
        boolean r1 = true;
        y6b.c r0 = this.d.d(r7, true);
        r0.W2 = r7.getMessage().getThreadPosition();
        r0.V2 = this.b;
        r0.X2 = r7.getMessage().getThreadBadgeCount();
        String r2 = r0.Q1;
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        String r4 = this.a;
        Intrinsics.checkNotNullParameter(r4, "threadId");
        r0.Q1 = r4;
    L14:
        String r5 = this.c;
        Object r8 = r7.getMessage().getFromId();
        if (r8 != null) goto L17;
        r8 = Boolean.FALSE;
    L17:
        boolean r9 = Intrinsics.areEqual(r5, r8);
        if (r7.getMessage().isFromMe() == true) goto L22;
        if (r9 == true) goto L22;
        r1 = false;
    L22:
        r0.i = r1;
        return r0;
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    public a(v r2, String r3, String r4, u2b.c r5) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        Intrinsics.checkNotNullParameter(r3, "threadTopicId");
        Intrinsics.checkNotNullParameter(r4, "anonymousId");
        Intrinsics.checkNotNullParameter(r5, "originMapper");
        this.a = r3;
        this.b = false;
        this.c = r4;
        this.d = r5;
        r5.t = true;
    }
}
