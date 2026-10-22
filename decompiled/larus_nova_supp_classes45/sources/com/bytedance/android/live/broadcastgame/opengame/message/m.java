package com.bytedance.android.live.broadcastgame.opengame.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class m implements com.bytedance.android.live.broadcastgame.v {
    public final String a;
    public final long b;
    public final long c;

    public static final class a {
    }

    static {
    }

    public m(String r2, long r3, long r5) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
