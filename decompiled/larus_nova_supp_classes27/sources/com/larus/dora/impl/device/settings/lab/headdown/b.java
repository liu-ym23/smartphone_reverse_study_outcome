package com.larus.dora.impl.device.settings.lab.headdown;

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
            return 2044491162;
        }

        public final String toString() {
            return "FinishPage";
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headdown.b$b, reason: collision with other inner class name */
    public static final class C0050b extends b {
        public static final C0050b a = null;

        static {
            a = new C0050b();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0050b) == true) goto L9;
            return false;
        L9:
            C0050b r4 = (C0050b) r3;
            return true;
        }

        public final int hashCode() {
            return -604228846;
        }

        public final String toString() {
            return "ShowNeedWearDialog";
        }

        public C0050b() {
        }
    }

    public static final class c extends b {
        public static final c a = null;

        static {
            a = new c();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof c) == true) goto L9;
            return false;
        L9:
            c r4 = (c) r3;
            return true;
        }

        public final int hashCode() {
            return 1519484701;
        }

        public final String toString() {
            return "ShowNeedWearToast";
        }

        public c() {
        }
    }

    public b() {
    }
}
