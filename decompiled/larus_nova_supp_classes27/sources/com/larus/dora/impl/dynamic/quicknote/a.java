package com.larus.dora.impl.dynamic.quicknote;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.quicknote.a$a, reason: collision with other inner class name */
    public static final class C0067a extends a {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0067a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0067a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "ClickItem(index=" + this.a + ')';
        }

        public C0067a(int r1) {
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

    public static final class d extends a {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public a() {
    }
}
