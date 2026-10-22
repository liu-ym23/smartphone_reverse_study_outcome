package com.larus.bmhome.chat.api;

import kotlin.jvm.internal.Intrinsics;
import wh8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p implements u {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    @Override // com.larus.bmhome.chat.api.u
    public final void a(ConversationFeedActionType r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r3, "data");
    }
}
