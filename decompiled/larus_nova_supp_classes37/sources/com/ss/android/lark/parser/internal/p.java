package com.ss.android.lark.parser.internal;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final /* synthetic */ class p implements Comparator {
    public /* synthetic */ p() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r1, Object r2) {
        return ((MessageInfo) r1).getMessage().getPosition() - ((MessageInfo) r2).getMessage().getPosition();
    }
}
