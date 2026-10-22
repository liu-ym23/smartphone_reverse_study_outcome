package com.bytedance.android.live.broadcastgame.opengame.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f extends m {
    public final String d;

    public final String toString() {
        return "{roomId:" + this.b + ", appId:" + this.a + ", connId:" + this.c + ", data:" + this.d + '}';
    }

    public f(long r7, String r9, long r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "appId");
        Intrinsics.checkNotNullParameter(r12, "data");
        super(r9, r7, r11);
        this.d = r12;
    }
}
