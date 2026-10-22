package com.bytedance.android.live.broadcastgame.api.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    public final String a;
    public final long b;
    public final String c;
    public final boolean d;
    public final boolean e;

    public final String toString() {
        return "{appId:" + this.a + ", gameId:" + this.b + ", gameName: " + this.c + ", audienceEnable:" + this.d + " scoreEnable:" + this.e + '}';
    }

    public i(String r2, long r3, String r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r5, "gameName");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
