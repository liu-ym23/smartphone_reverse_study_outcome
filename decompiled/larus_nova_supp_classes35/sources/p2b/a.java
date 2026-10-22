package p2b;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import y6b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements d<v5b.a<?>> {
    public final v5b.b<?> a;
    public final Context b;
    public final gya.a<Content> c;

    @Override // y6b.d
    public final Message.Type a() {
        return Message.Type.forNumber(this.a.a().getNumber());
    }

    public a(v5b.b<?> r2) {
        this.a = r2;
        this.b = ChatCoreModule.a().getContext();
        this.c = ChatCoreModule.a().getExtensionDependency().a(r2.a());
    }

    @Override // y6b.d
    public final CharSequence b(MessageInfo r1) {
        return d(r1);
    }

    @Override // y6b.d
    public final CharSequence d(f5b.b r4) {
        gya.a<Content> r0 = this.c;
        if (r0 != null) goto L7;
        return this.a.b(r4);
    L7:
        if (r0.c() == false) goto L9;
        String r1 = this.c.h(this.b, r4);
    L11:
        if (TextUtils.isEmpty(r1) == true) goto L14;
        return r1;
    L14:
        return this.a.b(r4);
    L9:
        Content r2 = r4.getMessage().getContent();
        r1 = this.c.d(this.b, r2);
        goto L11
    }

    @Override // y6b.d
    public final v5b.a c(v r1, f5b.b r2) {
        return this.a.c(r2);
    }
}
