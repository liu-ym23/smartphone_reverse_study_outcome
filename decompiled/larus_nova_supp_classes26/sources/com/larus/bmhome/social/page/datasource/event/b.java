package com.larus.bmhome.social.page.datasource.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class b {

    public static final class a extends b {
        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            ((a) r3).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "ItemsInserted : 0 , 0";
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.event.b$b, reason: collision with other inner class name */
    public static final class C0034b extends b {
        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0034b) == true) goto L9;
            return false;
        L9:
            ((C0034b) r3).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "ItemsRemoved : 0 0";
        }
    }

    public static final class c extends b {
        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof c) == true) goto L9;
            return false;
        L9:
            ((c) r3).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "ItemsUpdate : 0 , 0";
        }
    }

    public static final class d extends b {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.a == ((d) r4).a) goto L11;
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
            return "RefreshAll : " + this.a;
        }

        public d(boolean r1) {
            this.a = r1;
        }
    }

    public b() {
    }
}
