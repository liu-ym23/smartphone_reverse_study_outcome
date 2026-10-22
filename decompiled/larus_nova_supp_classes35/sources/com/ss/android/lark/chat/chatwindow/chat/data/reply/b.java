package com.ss.android.lark.chat.chatwindow.chat.data.reply;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.MessageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b {
    CharSequence a(MessageInfo r1);

    void b(MessageInfo r1, boolean r2, IGetDataCallback<i7b.c> r3);

    void c(MessageInfo r1, IGetDataCallback<i7b.c> r2);

    void d(MessageInfo r1, IGetDataCallback<i7b.c> r2);
}
