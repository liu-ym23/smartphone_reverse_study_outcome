package r7b;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a implements c {
    public final r7b.b<Chat> a;
    public final InterfaceC0293a b;
    public final b c;

    /* JADX INFO: renamed from: r7b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0293a {
        boolean a();
    }

    public interface b {
        void a();

        int b();

        int getTitleBarHeight();

        void getWidgetHeight();

        void z4();
    }

    @Override // r7b.c
    public final int G7() {
        return this.a.get().getLastMessagePosition();
    }

    @Override // r7b.c
    public final boolean a() {
        return this.b.a();
    }

    @Override // r7b.c
    public final int b() {
        return this.a.get().getFirstMessagePosition();
    }

    @Override // r7b.c
    public final int e() {
        return this.a.get().getReadPositionBadgeCount();
    }

    @Override // r7b.c
    public final Chat.MessagePosition f() {
        return k.c(this.a.get());
    }

    @Override // r7b.c
    public final int h() {
        return this.a.get().getUnReadBadgeCount();
    }

    @Override // r7b.c
    public final int i() {
        return this.a.get().getLastMessagePositionBadgeCount();
    }

    @Override // r7b.c
    public final int j() {
        int r0 = this.c.b();
        this.c.z4();
        this.c.getWidgetHeight();
        this.c.a();
        return (((r0 + 0) + 0) + 0) + this.c.getTitleBarHeight();
    }

    @Override // r7b.c
    public final int l() {
        return this.a.get().getReadPosition();
    }

    @Override // r7b.c
    public final int c(Message r1) {
        return r1.getPosition();
    }

    @Override // r7b.c
    public final int d(MessageInfo r1) {
        return r1.getMessage().getBadgeCount();
    }

    @Override // r7b.c
    public final boolean k(MessageInfo r2) {
        if (d(r2) > e()) goto L5;
        return true;
    L5:
        return false;
    }

    public a(r7b.b<Chat> r1, InterfaceC0293a r2, b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
