package com.larus.bmhome.chat.service.action;

import com.larus.bmhome.chat.api.ConversationFeedActionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n0 extends k0 {
    public n0(a r3) {
        Intrinsics.checkNotNullParameter(r3, "executeContext");
        super(r3, false, ConversationFeedActionType.UNPIN);
    }
}
