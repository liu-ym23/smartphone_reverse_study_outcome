package dy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a {
    public final String a;

    /* JADX INFO: renamed from: dy.a$a, reason: collision with other inner class name */
    public static final class C0225a extends a {
        public static final C0225a b = null;

        static {
            b = new C0225a();
        }

        public C0225a() {
            super("JoinFailed");
        }
    }

    public static final class b extends a {
        public final String b;

        @Override // dy.a
        public final String toString() {
            return this.a + '_' + this.b;
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "reqSrc");
            super("RTCEndSuccess");
            this.b = r2;
        }
    }

    public static final class c extends a {
        public final String b;

        @Override // dy.a
        public final String toString() {
            return this.a + '_' + this.b;
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "endReason");
            super("StopLiveBroadcast");
            this.b = r2;
        }
    }

    public static final class d extends a {
        public final String b;

        @Override // dy.a
        public final String toString() {
            return this.a + '_' + this.b;
        }

        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "reqSrc");
            super("UnExceptUnload");
            this.b = r2;
        }
    }

    public static final class e extends a {
        public static final e b = null;

        static {
            b = new e();
        }

        public e() {
            super("Unknown");
        }
    }

    public String toString() {
        return this.a;
    }

    public a(String r1) {
        this.a = r1;
    }
}
