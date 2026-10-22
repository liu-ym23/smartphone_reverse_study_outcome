package com.larus.share.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface j {

    public static final class a implements j {
        public final Long a;
        public final String b;
        public final Throwable c;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 7);
        }

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
            Long r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Throwable r7 = this.c;
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
            return "Failed(code=" + this.a + ", message=" + this.b + ", cause=" + this.c + ')';
        }

        public /* synthetic */ a(String r3, Throwable r4, int r5) {
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = null;
        L8:
            this(null, r3, r4);
        }

        public a(Long r1, String r2, Throwable r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b implements j {
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
            return "Success(url=" + this.a + ')';
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
            this.a = r2;
        }
    }

    public static final class c implements j {
        public final long a;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.a == ((c) r8).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public final String toString() {
            return "Timeout(timeoutMs=" + this.a + ')';
        }

        public c(long r1) {
            this.a = r1;
        }
    }
}
