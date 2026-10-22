package s2b;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends com.ss.android.lark.chat.message.menu.context.b {
    public final /* synthetic */ y6b.c h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ c j;

    @Override // com.ss.android.lark.chat.message.menu.context.b
    public final Fragment d() {
        return this.j.e.getFragment();
    }

    public final Message g() {
        MessageInfo r0 = this.j.e.p(this.h.c);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMessage();
    }

    public final <T extends x1b.b> T get() {
        return this.j.a;
    }

    public final p5b.c k() {
        return this.j.e.p(this.h.c);
    }

    public final Chatter q() {
        return this.j.e.g7();
    }

    public final Chatter u() {
        return this.j.e.N0();
    }

    public final boolean Y() {
        return this.i;
    }

    public final v5b.c m() {
        return this.h;
    }

    public final <T extends mya.g> T j(Class<T> r2) {
        return (T) this.j.b.j5().b(r2);
    }

    public b(c r1, yya.n r2, PageType r3, m2b.a r4, com.ss.android.lark.chat.chatwindow.chat.menu.handler.b r5, y6b.c r6) {
        this.j = r1;
        this.h = r6;
        this.i = true;
        super(r2, r3, r4, r5);
    }
}
