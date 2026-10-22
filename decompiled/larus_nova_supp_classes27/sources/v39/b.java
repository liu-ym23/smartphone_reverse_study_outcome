package v39;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class b {
    public final int a;

    public static final class a extends b {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super(-3);
        }
    }

    /* JADX INFO: renamed from: v39.b$b, reason: collision with other inner class name */
    public static final class C0145b extends b {
        public final v39.a b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0145b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((C0145b) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "FrameLoss(remoteData=" + this.b + ')';
        }

        public C0145b(v39.a r2) {
            Intrinsics.checkNotNullParameter(r2, "remoteData");
            super(-8);
            this.b = r2;
        }
    }

    public static final class c extends b {
        public static final c b = null;

        static {
            b = new c();
        }

        public c() {
            super(-3);
        }
    }

    public static final class d extends b {
        public static final d b = null;

        static {
            b = new d();
        }

        public d() {
            super(-8);
        }
    }

    public static final class e extends b {
        public static final e b = null;

        static {
            b = new e();
        }

        public e() {
            super(-3);
        }
    }

    public static final class f extends b {
        public final v39.a b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((f) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "Success(remoteData=" + this.b + ')';
        }

        public f(v39.a r2) {
            Intrinsics.checkNotNullParameter(r2, "remoteData");
            super(0);
            this.b = r2;
        }
    }

    public b(int r1) {
        this.a = r1;
    }
}
