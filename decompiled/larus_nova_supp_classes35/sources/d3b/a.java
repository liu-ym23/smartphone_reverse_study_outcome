package d3b;

import android.content.Context;
import b3b.h;
import com.ss.android.lark.biz.im.api.message.params.f;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements h {
    public final Context a;
    public final IMessageListViewModel b;
    public final m2b.a c;

    public final Context getContext() {
        return this.a;
    }

    @Override // b3b.h
    public final void q(String r4) {
        Intrinsics.checkNotNullParameter(r4, "messageId");
        IMessageListViewModel r0 = this.b;
        if (r0 == null) goto L15;
        MessageInfo r5 = r0.getMessageInfoById(r4);
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.getMessage().getType() == Message.Type.FILE) goto L10;
        return;
    L10:
        Message r6 = r5.getMessage();
        xtb.a r1 = ChatCoreModule.a().getFileDetailDependency();
        m2b.a r2 = this.c;
        if (r2 == null) goto L13;
        f r3 = r2.d0(f.class);
    L13:
        Context r7 = this.a;
        Chat r8 = (Chat) this.b.getCurrentChat().getValue();
        r1.getClass();
        r1.b(r7, r6, r8);
        return;
    }

    public a(Context r2, IMessageListViewModel r3, m2b.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
