package s00;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class f {

    public static final class a extends f {
        public a() {
            Intrinsics.checkNotNullParameter("default", "info");
        }
    }

    public static final class b extends f {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends f {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public f() {
    }
}
