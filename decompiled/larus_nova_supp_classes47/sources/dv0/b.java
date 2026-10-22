package dv0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final String a;
    public final long b;
    public final String c;

    public b(String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "miniAppId");
        Intrinsics.checkNotNullParameter(r5, "prompt");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
