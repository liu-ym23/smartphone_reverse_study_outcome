package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.Deprecated;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Deprecated(message = "资料卡已迁移，profile目录中代码废弃")
public final class f {
    public static final /* synthetic */ int a = 0;

    public f() {
    }

    static {
    }

    public static e a(Function0 r2, Function0 r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return new e(false, r2, r3);
    }
}
