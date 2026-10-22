package com.larus.dora.impl.ota.g;

import com.larus.dora.impl.ota.tracker.DoraOTACheckReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface u extends com.larus.dora.impl.ota.c {

    public static final class a implements u {
        public final int a;
        public final String b;

        public a() {
            this(0);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "CheckRequestFailed(retryCount=" + this.a + ')';
        }

        @Override // j69.c
        public final String a() {
            return this.b;
        }

        public a(int r1) {
            this.a = r1;
            this.b = DoraOTACheckReason.CHECK_REQUEST_FAIL;
        }
    }

    public static final class b implements u {
        public final int a;
        public final String b;

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
            return this.a;
        }

        public final String toString() {
            return "PeripheralsError(errorCode=" + this.a + ')';
        }

        @Override // j69.c
        public final String a() {
            return this.b;
        }

        public b(int r3) {
            this.a = r3;
            this.b = DoraOTACheckReason.ERROR_CODE_PREFIX + r3;
        }
    }

    public static final class c implements u {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // j69.c
        public final String a() {
            return DoraOTACheckReason.LOW_BATTERY;
        }
    }

    public static final class d implements u {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // j69.c
        public final String a() {
            return "peripherals_ota_failed_require_reboot";
        }
    }

    public static final class e implements u {
        public final int a;
        public final String b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (this.a == ((e) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "PeripheralsPrepared(status=" + this.a + ')';
        }

        @Override // j69.c
        public final String a() {
            return this.b;
        }

        public e(int r3) {
            this.a = r3;
            this.b = "peripherals_prepared_" + r3;
        }
    }

    public static final class f implements u {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // j69.c
        public final String a() {
            return DoraOTACheckReason.NOT_ENOUGH_SPACE_ON_PERIPHERAL;
        }
    }
}
