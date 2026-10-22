package com.larus.dora.impl.device;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.DoraSimpleDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface c {

    public static final class a implements c {
        public final long a;
        public final DoraDevice b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Connected(seq=" + this.a + ", device=" + this.b + ')';
        }

        public a(long r2, DoraDevice r4) {
            Intrinsics.checkNotNullParameter(r4, "device");
            this.a = r2;
            this.b = r4;
        }
    }

    public static final class b implements c {
        public final boolean a;
        public final DoraSimpleDevice b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            DoraSimpleDevice r2 = this.b;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Disconnected(isRetrying=" + this.a + ", lastConnectedDevice=" + this.b + ')';
        }

        public b(boolean r1, DoraSimpleDevice r2) {
            this.a = r1;
            this.b = r2;
        }

        public static b a(b r1, boolean r2) {
            DoraSimpleDevice r0 = r1.b;
            r1.getClass();
            return new b(r2, r0);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.c$c, reason: collision with other inner class name */
    public static final class C0034c implements c {
        public static final C0034c a = null;

        static {
            a = new C0034c();
        }

        public C0034c() {
        }
    }

    public static final class d implements c {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }
}
