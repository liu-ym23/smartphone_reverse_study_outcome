package kdb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public boolean a;
    public final odb.a b;

    public a() {
        odb.a r0 = new odb.a();
        Intrinsics.checkNotNullParameter(r0, "metrics");
        this.a = false;
        this.b = r0;
    }

    public final void setResult(boolean r1) {
        this.a = r1;
    }
}
