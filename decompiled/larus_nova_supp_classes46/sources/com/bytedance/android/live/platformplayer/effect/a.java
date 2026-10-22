package com.bytedance.android.live.platformplayer.effect;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final String a;
    public final int b;

    public final int getType() {
        return this.b;
    }

    public a(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r4, "description");
        this.a = r2;
        this.b = r3;
    }
}
