package b71;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a {
    public final int a;
    public final String b;

    /* JADX INFO: renamed from: b71.a$a, reason: collision with other inner class name */
    public static final class C0004a extends a {
        public C0004a() {
            super(3);
        }
    }

    public static final class b extends a {
        public b() {
            super(1);
        }
    }

    public static final class c extends a {
        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "winnerId");
            super(2, r2);
        }
    }

    public /* synthetic */ a(int r2) {
        this(r2, "");
    }

    public a(int r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
