package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ ChatChannelIMEmojiAnimWidget a;

    public h(ChatChannelIMEmojiAnimWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        IMessageListManager.a r5 = (IMessageListManager.a) r4;
        if (r5.getType() != IMessageListManager.MessageChangeType.INSERT_BOTTOM) goto L17;
        com.bytedance.android.livesdk.interactivity.service.messagelist.c r6 = r5.e;
        if ((r6 instanceof i62.f) == true) goto L7;
        r6 = null;
    L7:
        i62.f r7 = (i62.f) r6;
        if (r7 != null) goto L10;
        return;
    L10:
        if (r7.a == true) goto L19;
        ChatChannelIMEmojiAnimWidget r0 = this.a;
        String r8 = r7.m.displayName;
        int r1 = ChatChannelIMEmojiAnimWidget.h;
        s22.e r2 = ChatChannelUtils.b(r0.getDataContext());
        if (r2 == null) goto L20;
        s22.b r3 = r2.getEmojiManager();
        if (r3 == null) goto L21;
        r3.b(r8, new ChatChannelIMEmojiAnimWidget$playEmojiAnim$1(r0, r8));
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }
}
