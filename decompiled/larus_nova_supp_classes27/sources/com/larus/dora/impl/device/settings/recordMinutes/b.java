package com.larus.dora.impl.device.settings.recordMinutes;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class b {

    public static final class a extends b {
        public static final a a = null;

        static {
            a = new a();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            a r4 = (a) r3;
            return true;
        }

        public final int hashCode() {
            return 1715514963;
        }

        public final String toString() {
            return "Idle";
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.recordMinutes.b$b, reason: collision with other inner class name */
    public static final class C0054b extends b {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0054b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0054b) r4).a) goto L11;
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
            return "Success(recordMinutesEnabled=" + this.a + ')';
        }

        public C0054b(boolean r1) {
            this.a = r1;
        }
    }

    public b() {
    }
}
