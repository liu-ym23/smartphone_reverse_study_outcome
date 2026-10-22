package e59;

import c59.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class d {

    public static final class a extends d {
        public final String a;
        public final d59.b b;
        public final o c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
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
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            d59.b r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            o r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ShowUnbindConfirm(deviceMac=" + this.a + ", cardContext=" + this.b + ", dialogConfig=" + this.c + ')';
        }

        public a(String r1, d59.b r2, o r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public d() {
    }
}
