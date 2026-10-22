package com.lark.kmp.rustclient.api.model;

import com.lark.kmp.pb.basic.v1.Command;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public final int a;
    public final byte[] b;
    public final long c;

    public e(int r2, byte[] r3, Command r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "originCommand");
        Intrinsics.checkNotNullParameter(r5, "contextId");
        this.a = r2;
        this.b = r3;
        this.c = r6;
    }
}
