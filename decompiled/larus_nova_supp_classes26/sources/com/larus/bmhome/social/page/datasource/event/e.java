package com.larus.bmhome.social.page.datasource.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class e {

    public static abstract class a extends e {

        /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.event.e$a$a, reason: collision with other inner class name */
        public static final class C0035a extends a {
            public static final C0035a a = null;

            static {
                a = new C0035a();
            }

            public final String toString() {
                return "operation:append";
            }

            public C0035a() {
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public final String toString() {
                return "operation:prepend";
            }

            public b() {
            }
        }

        public a() {
        }
    }

    public static final class b extends e {
        public final boolean a;

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
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "operation:refresh,retry:" + this.a;
        }

        public b(boolean r1) {
            this.a = r1;
        }
    }

    public e() {
    }
}
