package com.larus.bmhome.chat.component.bottom.multimodal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class f1 {

    public static final class a extends f1 {
        public final boolean a;
        public final int b;

        public a() {
            this(false, 0, 3);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (r0 * 31) + this.b;
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "Album(multiTake=" + this.a + ", landingTabIndex=" + this.b + ')';
        }

        public a(boolean r2, int r3, int r4) {
            if ((r4 & 1) == 0) goto L6;
            r2 = true;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = 0;
        L8:
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends f1 {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends f1 {
        public final boolean a;
        public final boolean b;
        public final boolean c;

        public c() {
            this(false, 7);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
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
            if (this.c == true) goto L15;
            r1 = 1237;
        L15:
            return r4 + r1;
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "FileBrowser(multiTake=" + this.a + ", supportAudio=" + this.b + ", supportAudioOnly=" + this.c + ')';
        }

        public c(boolean r3, int r4) {
            if ((r4 & 1) == 0) goto L5;
            boolean r0 = true;
        L7:
            if ((r4 & 2) == 0) goto L9;
            r3 = false;
        L9:
            this.a = r0;
            this.b = r3;
            this.c = false;
            return;
        L5:
            r0 = false;
            goto L7
        }
    }

    public f1() {
    }
}
