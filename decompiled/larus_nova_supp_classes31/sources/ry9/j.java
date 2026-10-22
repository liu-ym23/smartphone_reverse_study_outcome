package ry9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class j {
    public final i a;

    public static final class a extends j {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super(null);
        }
    }

    public static final class b extends j {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
            super(null);
        }
    }

    public static final class c extends j {
        public final i b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((c) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            i r0 = this.b;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Filled(data=" + this.b + ')';
        }

        @Override // ry9.j
        public final i a() {
            return this.b;
        }

        public c(i r1) {
            super(r1);
            this.b = r1;
        }
    }

    public static final class d extends j {
        public static final d b = null;

        static {
            b = new d();
        }

        public d() {
            super(null);
        }
    }

    public static final class e extends j {
        public static final e b = null;

        static {
            b = new e();
        }

        public e() {
            super(null);
        }
    }

    public static final class f extends j {
        public static final f b = null;

        static {
            b = new f();
        }

        public f() {
            super(null);
        }
    }

    public static final class g extends j {
        public static final g b = null;

        static {
            b = new g();
        }

        public g() {
            super(null);
        }
    }

    public static final class h extends j {
        public static final h b = null;

        static {
            b = new h();
        }

        public h() {
            super(null);
        }
    }

    public i a() {
        return this.a;
    }

    public j(i r1) {
        this.a = r1;
    }
}
