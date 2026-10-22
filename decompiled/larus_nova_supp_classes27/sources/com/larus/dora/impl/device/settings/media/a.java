package com.larus.dora.impl.device.settings.media;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.a$a, reason: collision with other inner class name */
    public static final class C0052a implements a {
        public final boolean a;
        public final boolean b;
        public final long c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0052a) == true) goto L8;
            return false;
        L8:
            C0052a r9 = (C0052a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
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
            if (this.b == true) goto L10;
            r1 = 1237;
        L10:
            int r3 = (r2 + r1) * 31;
            long r4 = this.c;
            return r3 + ((int) (r4 ^ (r4 >>> 32)));
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Action(needRequestPermission=" + this.a + ", needToast=" + this.b + ", version=" + this.c + ')';
        }

        public C0052a() {
            long r0 = System.currentTimeMillis();
            this.a = true;
            this.b = false;
            this.c = r0;
        }
    }

    public static final class b implements a {
        public final long a;

        public b() {
            this(0);
        }

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
            return "RecordLocationRequestPermission(version=" + this.a + ')';
        }

        public b(int r3) {
            this.a = System.currentTimeMillis();
        }
    }

    public static final class c implements a {
        public final long a;

        public c() {
            this(0);
        }

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
            return "RecordLocationShowAlwaysAllowDialog(version=" + this.a + ')';
        }

        public c(int r3) {
            this.a = System.currentTimeMillis();
        }
    }
}
