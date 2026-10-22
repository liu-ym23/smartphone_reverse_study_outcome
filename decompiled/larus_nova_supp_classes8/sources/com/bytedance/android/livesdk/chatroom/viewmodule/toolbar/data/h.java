package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h {
    public final int a;
    public final String b;

    public final boolean a() {
        if (this.a != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public h(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "from");
        Intrinsics.checkNotNullParameter(r4, "tips");
        this.a = r2;
        this.b = r4;
    }
}
