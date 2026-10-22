package p71;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a {
    public final int a;
    public String b;

    /* JADX INFO: renamed from: p71.a$a, reason: collision with other inner class name */
    public static final class C0290a extends a {
        public static final C0290a c = null;

        public C0290a() {
            super(7, "卡片已经在展示了，重复调用show时被拦截");
        }

        static {
            c = new C0290a();
        }
    }

    public static final class b extends a {
        public b() {
            super(1);
        }
    }

    public static final class c extends a {
        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "id");
            super(3);
        }
    }

    public static final class d extends a {
        public d() {
            super(2);
        }
    }

    public static final class e extends a {
        public e() {
            super(5);
        }
    }

    public static final class f extends a {
        public f() {
            super(6);
        }
    }

    public static final class g extends a {
        public g(String r2) {
            Intrinsics.checkNotNullParameter(r2, "winnerId");
            super(4);
        }
    }

    public static final class h extends a {
        public static final h c = null;

        static {
            c = new h();
        }

        public h() {
            super(8, "卡片已经在展示了，在真正展示时被拦截");
        }
    }

    public /* synthetic */ a() {
        throw null;
    }

    public /* synthetic */ a(int r2) {
        this(r2, "");
    }

    public a(int r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
