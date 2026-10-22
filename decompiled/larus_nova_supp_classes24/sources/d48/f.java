package d48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface f {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        /* JADX INFO: renamed from: d48.f$a$a, reason: collision with other inner class name */
        public static final class C0098a implements f {
            public C0098a() {
            }
        }

        public static final class b implements b {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            @Override // d48.f.b
            public final long getLong(String r3) {
                Intrinsics.checkNotNullParameter(r3, "key");
                return 0;
            }

            @Override // d48.f.b
            public final String getString(String r2) {
                Intrinsics.checkNotNullParameter(r2, "key");
                Intrinsics.checkNotNullParameter("", "defValue");
                return "";
            }

            @Override // d48.f.b
            public final void putLong(String r1, long r2) {
                Intrinsics.checkNotNullParameter(r1, "key");
            }

            @Override // d48.f.b
            public final void putString(String r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "key");
                Intrinsics.checkNotNullParameter(r3, "value");
            }

            @Override // d48.f.b
            public final void remove(String r2) {
                Intrinsics.checkNotNullParameter(r2, "key");
            }
        }

        public a() {
        }

        static {
            a = new a();
            new C0098a();
        }
    }

    public interface b {
        long getLong(String r1);

        String getString(String r1);

        void putLong(String r1, long r2);

        void putString(String r1, String r2);

        void remove(String r1);
    }

    static {
        a = a.a;
    }
}
