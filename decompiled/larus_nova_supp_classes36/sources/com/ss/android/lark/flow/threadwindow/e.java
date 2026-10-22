package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.biz.im.api.q0;
import com.ss.android.lark.biz.im.api.r0;
import com.ss.android.lark.chat.entity.chat.Chat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements r0 {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final q0 a(Chat r3) {
        return new q0(r3.getThreadUnReadBadgeCount(), r3.getReadThreadPosition());
    }
}
