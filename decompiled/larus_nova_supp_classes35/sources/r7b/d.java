package r7b;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.k;
import com.ss.android.lark.flow.threadwindow.plugin.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements c {
    public final b<Chat> a;
    public final Map<String, n5b.a> b;

    @Override // r7b.c
    public final boolean a() {
        return false;
    }

    @Override // r7b.c
    public final int b() {
        return 0;
    }

    @Override // r7b.c
    public final /* synthetic */ int j() {
        return 0;
    }

    @Override // r7b.c
    public final int G7() {
        return this.a.get().getLastThreadPosition();
    }

    @Override // r7b.c
    public final int e() {
        return this.a.get().getReadThreadPositionBadgeCount();
    }

    @Override // r7b.c
    public final Chat.MessagePosition f() {
        return k.c(this.a.get());
    }

    @Override // r7b.c
    public final int h() {
        Chat r0 = this.a.get();
        return Math.min(r0.getLastThreadPositionBadgeCount() - r0.getReadThreadPositionBadgeCount(), r0.getLastThreadPosition() - r0.getReadThreadPosition());
    }

    @Override // r7b.c
    public final int i() {
        return this.a.get().getLastThreadPositionBadgeCount();
    }

    @Override // r7b.c
    public final int l() {
        return this.a.get().getReadThreadPosition();
    }

    public d(g r2) {
        this.b = new HashMap();
        this.a = r2;
    }

    @Override // r7b.c
    public final int c(Message r2) {
        if (r2.isAtAll() == true) goto L7;
        return 0;
    L7:
        return r2.getPosition();
    }

    @Override // r7b.c
    public final int d(MessageInfo r1) {
        return r1.getMessage().getBadgeCount();
    }

    @Override // r7b.c
    public final boolean g(MessageInfo r2) {
        Message r3 = r2.getMessage();
        if (r3.isFromMe() == false) goto L5;
    L7:
        return false;
    L5:
        if (r3.isAtAll() == false) goto L7;
        return true;
    }

    @Override // r7b.c
    public final boolean k(MessageInfo r4) {
        if (r4.getMessage().isMeRead() == false) goto L5;
        return true;
    L5:
        Map<String, n5b.a> r0 = this.b;
        HashMap r1 = (HashMap) r0;
        n5b.a r2 = (n5b.a) r1.get(r4.getId());
        if (r2 == null) goto L15;
        ThreadTopic r3 = r2.b;
        if (r3 == null) goto L15;
        if (r3.getBadgeCount() <= e()) goto L19;
        return false;
    L19:
        return true;
    L15:
        if (d(r4) <= e()) goto L20;
        return false;
    L20:
        return true;
    }
}
