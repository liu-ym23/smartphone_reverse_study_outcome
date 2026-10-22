package com.bytedance.android.live.broadcastgame.openplatform.miniapp.card;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class d {
    public final String a;

    public abstract void a();

    public d() {
        this("");
    }

    public d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.a = r2;
    }
}
