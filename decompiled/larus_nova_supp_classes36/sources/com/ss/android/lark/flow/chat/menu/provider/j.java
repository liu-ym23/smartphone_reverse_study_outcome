package com.ss.android.lark.flow.chat.menu.provider;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j {
    public static final boolean a(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        w4b.c.p r0 = ChatCoreModule.a().getProfile();
        if (r0 == null) goto L6;
        r0.getClass();
    L6:
        if (com.ss.android.lark.chat.utils.k.d(r2.getChat()) == true) goto L10;
        return false;
    L10:
        return true;
    }
}
