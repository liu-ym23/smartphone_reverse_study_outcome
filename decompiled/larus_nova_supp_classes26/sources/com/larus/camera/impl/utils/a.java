package com.larus.camera.impl.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.camera.impl.utils.a$a, reason: collision with other inner class name */
    public static final class C0084a extends a {
        public final long a;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0084a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0084a) r8).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public final String toString() {
            return "Oversize(maxSize=" + this.a + ')';
        }

        public C0084a(long r1) {
            this.a = r1;
        }
    }

    public static final class b extends a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public a() {
    }
}
