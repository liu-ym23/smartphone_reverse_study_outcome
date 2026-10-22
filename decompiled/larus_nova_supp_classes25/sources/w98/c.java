package w98;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface c {

    public static final class a implements c {
        public final we9.e a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Ocr(model=" + this.a + ')';
        }

        public a(we9.e r2) {
            Intrinsics.checkNotNullParameter(r2, "model");
            this.a = r2;
            r2.getClass();
        }
    }

    public static final class b implements c {
        public final tf9.a a;

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
            return "VideoFrame(frame=" + this.a + ')';
        }

        public b(tf9.a r5) {
            Intrinsics.checkNotNullParameter(r5, "frame");
            this.a = r5;
            long r0 = r5.c / ((long) 1000);
        }
    }
}
