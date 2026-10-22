package com.bytedance.android.live.broadcast.rts;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final String a;
    public final String b;

    public a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tabKey");
        Intrinsics.checkNotNullParameter(r3, "content");
        this.a = "";
        this.b = "";
        this.a = r2;
        this.b = r3;
    }
}
