package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatListComponent$c implements IIMCallback<Message> {
    public final /* synthetic */ ChatListComponent a;
    public final /* synthetic */ Message b;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        Intrinsics.checkNotNullParameter(r5, "error");
        FLogger.a.i(this.a.n, "cancelCollectMessage onFailure = " + r5.getTips());
    }

    public final void onSuccess(Object r3) {
        Intrinsics.checkNotNullParameter((Message) r3, "result");
        MessageAdapter r4 = this.a.O;
        if (r4 == null) goto L9;
        String r0 = this.b.getMessageId();
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        r4.x7(r0, this.b.getContentType());
        return;
    }

    public ChatListComponent$c(ChatListComponent r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }
}
