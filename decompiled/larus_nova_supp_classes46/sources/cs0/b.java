package cs0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final String a;
    public final String b;
    public final boolean c;

    public b(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "sdkKey");
        Intrinsics.checkNotNullParameter(r3, "changeReason");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
