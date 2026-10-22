package com.larus.dora.impl.device.settings.sound;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface b {

    public static final class a implements b {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "FAILED(targetState=" + this.a + ", reason=" + this.b + ')';
        }

        public a(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.b$b, reason: collision with other inner class name */
    public static final class C0057b implements b {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0057b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0057b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "SUCCESS(targetState=" + this.a + ')';
        }

        public C0057b(int r1) {
            this.a = r1;
        }
    }
}
