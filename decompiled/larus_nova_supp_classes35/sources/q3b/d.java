package q3b;

import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.model.FirstScreenLoader;
import com.ss.android.lark.log.Log;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends FirstScreenLoader<MessageInfo, x4b.a<MessageInfo>> {
    public final Chat g;

    @Override // com.ss.android.lark.chatbase.model.FirstScreenLoader
    public final String a() {
        return "normal_chat";
    }

    @Override // com.ss.android.lark.chatbase.model.FirstScreenLoader
    public final String b() {
        return "ChatFirstScreenLoader";
    }

    @Override // com.ss.android.lark.chatbase.model.FirstScreenLoader
    public final boolean d() {
        return true;
    }

    @Override // com.ss.android.lark.chatbase.model.FirstScreenLoader
    public final void g() {
        boolean r2 = true;
        if (com.ss.android.lark.chat.utils.k.c(this.g) != Chat.MessagePosition.NEWEST_UNREAD) goto L5;
        final int r0 = this.g.getReadPosition() + 1;
    L7:
        if (this.b.d >= r0) goto L9;
    L11:
        r2 = false;
    L12:
        if (r2 == true) goto L15;
        Log.i("ChatFirstScreenLoader", "preLoadMessage: position:" + r0);
        this.d.execute(new c(this, r0));
        return;
    L15:
        return;
    L9:
        if (this.b.c > r0) goto L11;
    L5:
        r0 = this.g.getLastMessagePosition();
        goto L7
    }

    @Override // com.ss.android.lark.chatbase.model.FirstScreenLoader
    public final void e(final List<Integer> r3, final IGetDataCallback<Boolean> r4) {
        this.d.execute(new b(this, r3, r4));
    }

    public d(n r1, m r2, x4b.d r3, x4b.d r4, CallbackManager r5, Chat r6) {
        super(r1, r2, r3, r4, r5);
        this.g = r6;
    }
}
