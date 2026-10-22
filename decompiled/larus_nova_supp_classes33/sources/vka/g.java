package vka;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g implements b<String> {
    public final String a;

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(f.a, "context");
        return this.a;
    }

    public g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.a = r2;
    }
}
