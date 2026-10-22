package ifa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface c {

    public static final class a implements c {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final Integer e;
        public final Integer f;

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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            Integer r1 = this.e;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Integer r5 = this.f;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Image(id=" + this.a + ", blockId=" + this.b + ", path=" + this.c + ", fileUri=" + this.d + ", width=" + this.e + ", height=" + this.f + ')';
        }

        @Override // ifa.c
        public final String a() {
            return this.b;
        }

        @Override // ifa.c
        public final String getId() {
            return this.a;
        }

        public a(String r2, String r3, String r4, String r5, Integer r6, Integer r7) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "blockId");
            Intrinsics.checkNotNullParameter(r4, "path");
            Intrinsics.checkNotNullParameter(r5, "fileUri");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class b implements c {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final Integer g;
        public final Integer h;
        public final Integer i;
        public final Integer j;
        public final Double k;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            String r1 = this.e;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            Integer r8 = this.g;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Integer r11 = this.h;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Integer r14 = this.i;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            Integer r17 = this.j;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            Double r20 = this.k;
            if (r20 == null) goto L31;
            r2 = r20.hashCode();
        L31:
            return r19 + r2;
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Video(id=" + this.a + ", blockId=" + this.b + ", path=" + this.c + ", fileUri=" + this.d + ", coverPath=" + this.e + ", coverFileUri=" + this.f + ", coverWidth=" + this.g + ", coverHeight=" + this.h + ", width=" + this.i + ", height=" + this.j + ", duration=" + this.k + ')';
        }

        @Override // ifa.c
        public final String a() {
            return this.b;
        }

        @Override // ifa.c
        public final String getId() {
            return this.a;
        }

        public b(String r2, String r3, String r4, String r5, String r6, String r7, Integer r8, Integer r9, Integer r10, Integer r11, Double r12) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "blockId");
            Intrinsics.checkNotNullParameter(r4, "path");
            Intrinsics.checkNotNullParameter(r5, "fileUri");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
        }
    }

    String a();

    String getId();
}
