package com.ss.android.lark.chat.chatwindow.chat.message.actionimpl;

import android.content.Context;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import kotlin.jvm.internal.Intrinsics;
import mya.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements m {
    public final v4b.d a;

    public b() {
        this.a = null;
    }

    public final void f(String r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "context");
        v4b.d r5 = this.a;
        if (r5 == null) goto L12;
        MessageInfo r6 = r5.f;
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.getMessage().getType() == Message.Type.FILE) goto L10;
        return;
    L10:
        Message r7 = r6.getMessage();
        xtb.a r0 = ChatCoreModule.a().getFileDetailDependency();
        r0.getClass();
        r0.b(r4, r7, null);
        return;
    }
}
