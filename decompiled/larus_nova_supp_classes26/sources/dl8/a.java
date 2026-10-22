package dl8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface a {

    /* JADX INFO: renamed from: dl8.a$a, reason: collision with other inner class name */
    public static final class C0104a implements a {
        public final String a;
        public final String b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0104a) == true) goto L8;
            return false;
        L8:
            C0104a r6 = (C0104a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "Code(code=" + this.a + ", language=" + this.b + ", title=" + this.c + ')';
        }

        public C0104a(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "code");
            Intrinsics.checkNotNullParameter(r3, "language");
            Intrinsics.checkNotNullParameter(r4, "title");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b implements a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }
}
