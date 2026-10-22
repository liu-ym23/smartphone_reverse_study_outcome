package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.biz.im.api.s0;
import com.ss.android.lark.chat.entity.chat.Chat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements s0 {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Integer a(Chat r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return Integer.valueOf(r1.getLastThreadPosition());
    }
}
