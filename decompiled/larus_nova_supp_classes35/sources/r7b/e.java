package r7b;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class e implements c {
    public final b<ThreadTopic> a;

    @Override // r7b.c
    public final int b() {
        return 0;
    }

    @Override // r7b.c
    public final int G7() {
        return this.a.get().getLastMsgPos();
    }

    @Override // r7b.c
    public final int e() {
        return this.a.get().getReadPosBadgeCount();
    }

    @Override // r7b.c
    public final int h() {
        ThreadTopic r0 = this.a.get();
        return Math.min(r0.getLastMsgPos() - r0.getReadPos(), r0.getLastMsgPosBadgeCount() - r0.getReadPosBadgeCount());
    }

    @Override // r7b.c
    public final int i() {
        return this.a.get().getLastMsgPosBadgeCount();
    }

    @Override // r7b.c
    public final int l() {
        return this.a.get().getReadPos();
    }

    @Override // r7b.c
    public final Chat.MessagePosition f() {
        return Chat.MessagePosition.RECENT_LEFT;
    }

    public e(b<ThreadTopic> r1) {
        this.a = r1;
    }

    @Override // r7b.c
    public final int c(Message r1) {
        return r1.getThreadPosition();
    }

    @Override // r7b.c
    public final int d(MessageInfo r1) {
        return r1.getMessage().getThreadBadgeCount();
    }

    @Override // r7b.c
    public final boolean k(MessageInfo r2) {
        if (d(r2) > e()) goto L5;
        return true;
    L5:
        return false;
    }
}
