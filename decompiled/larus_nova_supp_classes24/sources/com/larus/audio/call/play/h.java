package com.larus.audio.call.play;

import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class h {

    public static final class a extends h {
        public final byte[] a;
        public final String b;
        public final String c;
        public final d0 d;

        public final String toString() {
            return "Play(data=" + Arrays.toString(this.a) + ", sectionId=" + this.b + ", queryRound=" + this.c + ", extra=" + this.d + ')';
        }

        public final int hashCode() {
            int r0 = ((Arrays.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
            d0 r1 = this.d;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (a.class == r5.getClass()) goto L11;
            return false;
        L11:
            a r6 = (a) r5;
            if (Arrays.equals(this.a, r6.a) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public a(byte[] r2, String r3, String r4, d0 r5) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r3, "sectionId");
            Intrinsics.checkNotNullParameter(r4, "queryRound");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b extends h {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends h {
        public final Map<String, String> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Map<String, String> r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "TtsStart(extra=" + this.a + ')';
        }

        public c(Map<String, String> r1) {
            this.a = r1;
        }
    }

    public static final class d extends h {
        public final byte[] a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Arrays.hashCode(this.a);
        }

        public final String toString() {
            return "Warmup(data=" + Arrays.toString(this.a) + ')';
        }

        public d(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
        }
    }

    public h() {
    }
}
