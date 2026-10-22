package com.larus.dora.impl.device.settings.sound;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface l {

    public static final class a implements l {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements l {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c implements l {
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
            return "Success(isAmbientVolumeEnabled=" + this.a + ')';
        }

        public c(boolean r1) {
            this.a = r1;
        }
    }
}
