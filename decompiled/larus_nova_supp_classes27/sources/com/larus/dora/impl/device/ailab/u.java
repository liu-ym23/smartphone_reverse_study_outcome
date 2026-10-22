package com.larus.dora.impl.device.ailab;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface u {

    public static final class a implements u {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements u {
        public final boolean a;
        public final int b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = ((r0 * 31) + this.b) * 31;
            if (this.c == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (r2 + r3) * 31;
            if (this.d == false) goto L13;
            int r5 = 1231;
        L14:
            int r6 = (r4 + r5) * 31;
            if (this.e == false) goto L17;
            int r7 = 1231;
        L18:
            int r8 = (r6 + r7) * 31;
            if (this.f == true) goto L23;
            r1 = 1237;
        L23:
            return r8 + r1;
        L17:
            r7 = 1237;
            goto L18
        L13:
            r5 = 1237;
            goto L14
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "V1(voiceWakeEnable=" + this.a + ", sku=" + this.b + ", isSupportDecouplingWakeup=" + this.c + ", precaptureUploadEnable=" + this.d + ", conversationStartEndSound=" + this.e + ", conversationVisualIntentSound=" + this.f + ')';
        }

        public b(boolean r1, int r2, boolean r3, boolean r4, boolean r5, boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public static b a(b r7, boolean r8, boolean r9, boolean r10, boolean r11, int r12) {
            if ((r12 & 1) == 0) goto L5;
            r8 = r7.a;
        L5:
            boolean r1 = r8;
            if ((r12 & 2) == 0) goto L8;
            int r2 = r7.b;
        L10:
            if ((r12 & 4) == 0) goto L12;
            boolean r3 = r7.c;
        L14:
            if ((r12 & 8) == 0) goto L16;
            r9 = r7.d;
        L16:
            boolean r4 = r9;
            if ((r12 & 16) == 0) goto L19;
            r10 = r7.e;
        L19:
            boolean r5 = r10;
            if ((r12 & 32) == 0) goto L22;
            r11 = r7.f;
        L22:
            r7.getClass();
            return new b(r1, r2, r3, r4, r5, r11);
        L12:
            r3 = false;
            goto L14
        L8:
            r2 = 0;
            goto L10
        }
    }

    public static final class c implements u {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.a == ((c) r4).a) goto L11;
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
            return "V2(voiceWakeEnable=" + this.a + ')';
        }

        public c(boolean r1) {
            this.a = r1;
        }
    }
}
