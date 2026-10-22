package qv0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b implements Comparable<b> {
    public final int a;

    public static final class a extends b {
        public a() {
            super("Creating", 1);
        }

        static {
            new a();
        }
    }

    /* JADX INFO: renamed from: qv0.b$b, reason: collision with other inner class name */
    public static final class C0303b extends b {
        public static final C0303b b = null;

        public C0303b() {
            super("Idle", 2);
        }

        static {
            b = new C0303b();
        }
    }

    public static final class c extends b {
        public static final c b = null;

        public c() {
            super("Initial", 0);
        }

        static {
            b = new c();
        }
    }

    public static final class d extends b {
        public static final d b = null;

        public d() {
            super("Paused", 4);
        }

        static {
            b = new d();
        }
    }

    public static final class e extends b {
        public static final e b = null;

        public e() {
            super("Running", 3);
        }

        static {
            b = new e();
        }
    }

    public static final class f extends b {
        public static final f b = null;

        public f() {
            super("Terminated", -1);
        }

        static {
            b = new f();
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(b r2) {
        b r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "other");
        return Intrinsics.compare(this.a, r3.a);
    }

    public b(String r1, int r2) {
        this.a = r2;
    }
}
