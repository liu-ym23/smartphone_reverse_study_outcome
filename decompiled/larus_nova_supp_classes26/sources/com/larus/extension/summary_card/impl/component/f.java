package com.larus.extension.summary_card.impl.component;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class f {

    public static final class a extends f {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends f {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends f {
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
            return "EXPANDING(isRealMessage=" + this.a + ')';
        }

        public c(boolean r1) {
            this.a = r1;
        }
    }

    public static final class d extends f {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public f() {
    }
}
