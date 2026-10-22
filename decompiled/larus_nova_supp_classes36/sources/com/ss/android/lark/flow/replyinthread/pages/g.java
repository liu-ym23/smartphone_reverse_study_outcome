package com.ss.android.lark.flow.replyinthread.pages;

import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ FlowReplyInThreadFragment a;

    public g(FlowReplyInThreadFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Chat r5 = (Chat) r4;
        FlowReplyInThreadFragment r0 = this.a;
        int r1 = FlowReplyInThreadFragment.y;
        r0.getClass();
        if (r5 == null) goto L12;
        String r2 = r5.getId();
        String r3 = ChatCoreModule.a().getLoginDependency().getUserId();
        String r6 = ChatParamUtils.a;
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r5, "chat");
        if (ChatParamUtils.a != null) goto L8;
    L10:
        ChatParamUtils.j(r2, r3, r5, null, null);
        return;
    L8:
        if (ChatParamUtils.b == null) goto L10;
        return;
    }
}
