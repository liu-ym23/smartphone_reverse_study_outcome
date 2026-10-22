package com.ss.android.lark.chat.chatwindow.chat.message.actionimpl;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import kotlin.jvm.internal.Intrinsics;
import mya.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements n {
    public final v4b.d a;

    public c() {
        this.a = null;
    }

    public final void n(String r3, FragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "context");
        v4b.d r5 = this.a;
        if (r5 == null) goto L12;
        MessageInfo r6 = r5.f;
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.getMessage().getType() == Message.Type.FOLDER) goto L10;
        return;
    L10:
        Message r7 = r6.getMessage();
        ChatCoreModule.a().getFileDetailDependency().e(r4, r7, null);
        return;
    }
}
