package k8b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class b {

    public static final class a extends b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: k8b.b$b, reason: collision with other inner class name */
    public static final class C0247b extends b {
        public static final C0247b a = null;

        static {
            a = new C0247b();
        }

        public C0247b() {
        }
    }

    public static final class c extends b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Failure(code=" + this.a + ", message=" + this.b + ')';
        }

        public c(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d extends b {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e extends b {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }
    }

    public b() {
    }
}
