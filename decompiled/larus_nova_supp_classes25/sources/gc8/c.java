package gc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface c {

    public static final class a implements c {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "Resource(resId=" + this.a + ')';
        }

        public a(int r1) {
            this.a = r1;
        }
    }

    public static final class b implements c {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Url(url=" + this.a + ')';
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
            this.a = r2;
        }
    }
}
