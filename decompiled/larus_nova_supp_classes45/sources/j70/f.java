package j70;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class f {
    public static final f c = null;
    public static final f d = null;
    public static final f e = null;
    public final String a;
    public final String b;

    public static final class a {
    }

    static {
        c = new f("unknown", "unknown");
        d = new f("parent", "parent");
        e = new f("unset", "unset");
    }

    public final String toString() {
        return this.a;
    }

    public f(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "description");
        Intrinsics.checkNotNullParameter(r3, "tag");
        this.a = r2;
        this.b = r3;
    }
}
