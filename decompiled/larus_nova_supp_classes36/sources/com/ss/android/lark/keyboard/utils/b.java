package com.ss.android.lark.keyboard.utils;

import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final boolean a(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        boolean r0 = PluginUtils.c();
        boolean r3 = r2.getDoubaoSetting().isDoubaoUsingEnabled();
        int r1 = com.ss.android.lark.biz.im.api.h.a;
        if (r0 == true) goto L6;
        if (r3 == false) goto L6;
        return true;
    L6:
        return false;
    }
}
