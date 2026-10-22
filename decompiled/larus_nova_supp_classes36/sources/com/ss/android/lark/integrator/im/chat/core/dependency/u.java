package com.ss.android.lark.integrator.im.chat.core.dependency;

import com.ss.android.lark.chat.entity.chat.Chat;
import w4b.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class u implements d0 {
    public u() {
    }

    public final long a() {
        return nmb.a.a().getCoreDependency().a();
    }

    public final Chat.MessagePosition b() {
        return Chat.MessagePosition.NEWEST_UNREAD;
    }

    public final boolean isInZenMode(long r1) {
        nmb.a.a().getCoreDependency().p();
        return false;
    }
}
