package com.larus.camera.impl.ui.component.result.general;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class e2 {

    public static final class a extends e2 {
        public final int a;

        public a() {
            this(0);
        }

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
            return "BottomAlignFocusBottom(margin=" + this.a + ')';
        }

        public a(int r1) {
            this.a = 0;
        }
    }

    public static final class b extends e2 {
        public final int a;

        public b() {
            this(0);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "BottomAlignScreenBottom(margin=" + this.a + ')';
        }

        public b(int r1) {
            this.a = r1;
        }
    }

    public static final class c extends e2 {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public e2() {
    }
}
