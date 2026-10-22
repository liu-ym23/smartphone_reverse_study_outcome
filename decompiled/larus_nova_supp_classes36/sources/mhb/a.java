package mhb;

import com.ss.android.lark.biz.im.api.n0;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u2b.h;
import x4b.c;
import y6b.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements c<MessageInfo, y6b.c<?>>, h {
    public final u2b.c a;

    public final void a(boolean r2) {
        this.a.s = r2;
    }

    public final y6b.c b(Object r7) {
        MessageInfo r8 = (MessageInfo) r7;
        ArrayList r0 = null;
        if (r8 == null) goto L29;
        boolean r2 = true;
        y6b.c r1 = this.a.d(r8, true);
        List r3 = r1.g2;
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L27;
        List r9 = r8.getThreadMergeForwardSimplifyReplies();
        List r5 = r9;
        if (r5 != null) goto L16;
    L19:
        if (r2 == true) goto L25;
        r0 = new ArrayList();
        Iterator r10 = r9.iterator();
    L23:
        if (r10.hasNext() == false) goto L25;
        e5b.a r6 = (e5b.a) r10.next();
        f.a r11 = new f.a();
        String r12 = r6.a;
        Intrinsics.checkNotNullParameter(r12, "messageId");
        ((n0.a) r11).a = r12;
        CharSequence r13 = r6.e;
        Intrinsics.checkNotNullParameter(r13, "content");
        ((n0.a) r11).e = r13;
        ((n0.a) r11).f = r6.f;
        String r14 = r6.b;
        Intrinsics.checkNotNullParameter(r14, "senderId");
        ((n0.a) r11).b = r14;
        String r15 = r6.d;
        Intrinsics.checkNotNullParameter(r15, "name");
        ((n0.a) r11).d = r15;
        String r16 = r6.c;
        Intrinsics.checkNotNullParameter(r16, "avatarKey");
        ((n0.a) r11).c = r16;
        f r17 = new f(r11);
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.SimplifiedThreadReply");
        r0.add(r17);
    L25:
        r1.g2 = r0;
        goto L27
    L16:
        if (r5.isEmpty() == true) goto L19;
        r2 = false;
    L27:
        return r1;
    L8:
        if (r3.isEmpty() == true) goto L11;
        r4 = false;
        goto L12
    L29:
        return null;
    }

    public a(v r2, u2b.c r3) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        Intrinsics.checkNotNullParameter(r3, "originMapper");
        this.a = r3;
    }
}
