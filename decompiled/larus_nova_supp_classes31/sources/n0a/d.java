package n0a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class d {

    public static final class a extends d {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends d {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends d {
        public final String a;

        public c() {
            this(0);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Error(message=" + this.a + ')';
        }

        public c(int r1) {
            this.a = null;
        }
    }

    /* JADX INFO: renamed from: n0a.d$d, reason: collision with other inner class name */
    public static final class C0068d extends d {
        public static final C0068d a = null;

        static {
            a = new C0068d();
        }

        public C0068d() {
        }
    }

    public static final class e extends d {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }
    }

    public static final class f extends d {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }
    }

    public d() {
    }
}
