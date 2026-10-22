package com.ss.android.lark.parser.internal;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class q implements Comparator<MessageInfo> {
    public q() {
    }

    @Override // java.util.Comparator
    public final int compare(MessageInfo r1, MessageInfo r2) {
        return r1.getMessage().getPosition() - r2.getMessage().getPosition();
    }
}
