package ac0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final String a;
    public int b;
    public int c;

    public final String getType() {
        return this.a;
    }

    public c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a = r2;
        this.b = 0;
        this.c = 0;
    }
}
