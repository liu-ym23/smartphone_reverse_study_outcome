package com.larus.bmhome.chat.messagetransfer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class g {

    public static final class a extends g {
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
            return "SelectCountLimit(selectCount=" + this.a + ')';
        }

        public a(int r1) {
            this.a = r1;
        }
    }

    public static final class b extends g {
        public final long a;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r8).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public final String toString() {
            return "SizeLimit(selectSizeBytes=" + this.a + ')';
        }

        public b(long r1) {
            this.a = r1;
        }
    }

    public g() {
    }
}
