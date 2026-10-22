package com.larus.bmhome.chat.component.list;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.uaigc.service.ICreationReportService;
import kotlin.jvm.internal.Intrinsics;
import ky9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatListComponent$changeListener$1$b implements IIMCallback<Message> {
    public final /* synthetic */ String a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ ChatListComponent c;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final void onSuccess(Object r7) {
        Message r3 = (Message) r7;
        Intrinsics.checkNotNullParameter(r3, "result");
        a r0 = ICreationReportService.a.j().b();
        String r1 = this.a;
        Message r2 = this.b;
        ChatListComponent r8 = this.c;
        int r4 = ChatListComponent.W3;
        wc9.e r9 = r8.R4();
        if (r9 == null) goto L5;
        String r10 = ic8.n.f(r9);
    L6:
        r0.d(r1, r2, r3, r10, this.c.getBotId());
        return;
    L5:
        r10 = null;
        goto L6
    }

    public ChatListComponent$changeListener$1$b(String r1, Message r2, ChatListComponent r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
