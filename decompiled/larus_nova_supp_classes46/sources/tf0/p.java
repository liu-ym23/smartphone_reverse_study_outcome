package tf0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class p {
    public final String a;

    public final String toString() {
        return "Action{mName='" + this.a + "'}";
    }

    public p(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.a = r2;
    }

    public p(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "name");
        this.a = r1;
    }
}
