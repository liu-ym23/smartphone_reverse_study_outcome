package zo0;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public static final HashMap<String, f> a = null;
    public static final HashMap<String, b> b = null;
    public static final g c = null;

    public static final class a implements b {
        public static final a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        @Override // zo0.g.b
        public final f a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            return new f(r2);
        }
    }

    public interface b {
        f a(String r1);
    }

    public g() {
    }

    static {
        c = new g();
        a = new HashMap();
        b = new HashMap();
    }
}
