package com.larus.dora.impl.device.settings.media;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface b {

    public static final class a implements b {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final long f;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (this.f == r9.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (r2 + r3) * 31;
            if (this.c == false) goto L13;
            int r5 = 1231;
        L14:
            int r6 = (r4 + r5) * 31;
            if (this.d == false) goto L17;
            int r7 = 1231;
        L18:
            int r8 = (r6 + r7) * 31;
            if (this.e == true) goto L22;
            r1 = 1237;
        L22:
            int r9 = (r8 + r1) * 31;
            long r10 = this.f;
            return r9 + ((int) (r10 ^ (r10 >>> 32)));
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
            return "Config(isSupportMediaAndAlbum=" + this.a + ", autoSync=" + this.b + ", isSaveToGallery=" + this.c + ", recordLocationEnabled=" + this.d + ", locationAlwaysAllowed=" + this.e + ", version=" + this.f + ')';
        }

        public a(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, long r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public static a a(a r6, boolean r7, boolean r8, boolean r9, boolean r10, long r11, int r13) {
            if ((r13 & 1) == 0) goto L5;
            boolean r0 = r6.a;
        L7:
            if ((r13 & 2) == 0) goto L9;
            r7 = r6.b;
        L9:
            boolean r1 = r7;
            if ((r13 & 4) == 0) goto L12;
            r8 = r6.c;
        L12:
            boolean r2 = r8;
            if ((r13 & 8) == 0) goto L15;
            r9 = r6.d;
        L15:
            boolean r3 = r9;
            if ((r13 & 16) == 0) goto L18;
            r10 = r6.e;
        L18:
            boolean r4 = r10;
            if ((r13 & 32) == 0) goto L21;
            r11 = r6.f;
        L21:
            r6.getClass();
            boolean r12 = r0;
            return new a(r12, r1, r2, r3, r4, r11);
        L5:
            r0 = false;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.b$b, reason: collision with other inner class name */
    public static final class C0053b implements b {
        public static final C0053b a = null;

        static {
            a = new C0053b();
        }

        public C0053b() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0053b) == true) goto L9;
            return false;
        L9:
            C0053b r4 = (C0053b) r3;
            return true;
        }

        public final int hashCode() {
            return 1342660995;
        }

        public final String toString() {
            return "Empty";
        }
    }
}
