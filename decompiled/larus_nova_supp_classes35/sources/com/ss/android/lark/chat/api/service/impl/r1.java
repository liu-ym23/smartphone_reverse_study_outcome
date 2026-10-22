package com.ss.android.lark.chat.api.service.impl;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r1 implements Comparator<MessageInfo> {
    public r1() {
    }

    @Override // java.util.Comparator
    public final int compare(MessageInfo r1, MessageInfo r2) {
        return r1.getMessage().getThreadPosition() - r2.getMessage().getThreadPosition();
    }
}
