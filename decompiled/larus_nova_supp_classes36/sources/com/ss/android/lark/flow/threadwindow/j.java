package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface j {
    void insertSendingRootPlaceholder(Message r1);

    void markRootSendFailed(Message r1);

    void markRootSendSuccess(Message r1, String r2);
}
