package sy9;

import android.graphics.Bitmap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface b {

    public static final class a implements b {
        public final boolean a;

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
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Empty(showFull=" + this.a + ')';
        }

        public a(boolean r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: sy9.b$b, reason: collision with other inner class name */
    public static final class C0075b implements b {
        public final Bitmap a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0075b) == true) goto L8;
            return false;
        L8:
            C0075b r6 = (C0075b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Bitmap r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            int r2 = r1 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L11:
            return r2 + r3;
        L9:
            r3 = 1237;
            goto L11
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Failed(bitmap=" + this.a + ", showFull=" + this.b + ')';
        }

        public C0075b(Bitmap r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements b {
        public final Bitmap a;
        public final boolean b;

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
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Bitmap r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            int r2 = r1 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L11:
            return r2 + r3;
        L9:
            r3 = 1237;
            goto L11
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Filled(bitmap=" + this.a + ", showFull=" + this.b + ')';
        }

        public c(Bitmap r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements b {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e implements b {
        public final Bitmap a;
        public final boolean b;
        public final Pair<Integer, Integer> c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Bitmap r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            int r4 = 1231;
            if (this.b == false) goto L9;
            int r5 = 1231;
        L10:
            int r6 = (r3 + r5) * 31;
            Pair<Integer, Integer> r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            int r8 = (r6 + r1) * 31;
            if (this.d == true) goto L19;
            r4 = 1237;
        L19:
            return r8 + r4;
        L9:
            r5 = 1237;
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Uploading(bitmap=" + this.a + ", showFull=" + this.b + ", size=" + this.c + ", hideLoading=" + this.d + ')';
        }

        public e(Bitmap r1, boolean r2, Pair<Integer, Integer> r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public static e a(e r3, boolean r4, boolean r5, int r6) {
            Pair<Integer, Integer> r1 = null;
            if ((r6 & 1) == 0) goto L5;
            Bitmap r0 = r3.a;
        L7:
            if ((r6 & 2) == 0) goto L10;
            r4 = r3.b;
        L10:
            if ((r6 & 4) == 0) goto L13;
            r1 = r3.c;
        L13:
            if ((r6 & 8) == 0) goto L15;
            r5 = r3.d;
        L15:
            r3.getClass();
            return new e(r0, r4, r1, r5);
        L5:
            r0 = null;
            goto L7
        }

        public /* synthetic */ e(Bitmap r1, boolean r2, Pair r3, int r4) {
            if ((r4 & 4) == 0) goto L5;
            r3 = null;
        L5:
            this(r1, r2, r3, false);
        }
    }
}
