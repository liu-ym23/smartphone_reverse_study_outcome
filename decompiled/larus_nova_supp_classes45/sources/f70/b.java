package f70;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class b {
    public static final a c = null;
    public final String a;
    public final int b;

    public static final class a extends b {
        public a() {
            super("default", 0);
        }
    }

    static {
        c = new a();
    }

    public final String toString() {
        return this.a;
    }

    public b(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "description");
        this.a = r2;
        this.b = r3;
    }
}
