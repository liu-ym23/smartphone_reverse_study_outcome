package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x {
    @JvmStatic
    public static final boolean a() {
        if (com.bytedance.android.livesdk.m.c() == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.livesdk.config.k3.a.getValue().booleanValue() == false) goto L7;
        return true;
    }

    static {
    }
}
