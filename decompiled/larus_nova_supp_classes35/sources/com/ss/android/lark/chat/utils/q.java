package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.core.api.ChatCoreModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q {
    public static final w4b.a a = null;

    public interface a {
        boolean a();

        String getChatId();
    }

    static {
        a = ChatCoreModule.a().getAuditDependency();
    }
}
