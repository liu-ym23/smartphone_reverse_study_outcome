package com.larus.dora.impl.device.settings.general;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface w {

    public static final class a implements w {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements w {
        public final int a;
        public final DoraDevice b;
        public final boolean c;
        public final boolean d;
        public final String e;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
            int r2 = 1231;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.d == true) goto L10;
            r2 = 1237;
        L10:
            int r4 = (r3 + r2) * 31;
            String r5 = this.e;
            if (r5 != null) goto L13;
            int r6 = 0;
        L15:
            return r4 + r6;
        L13:
            r6 = r5.hashCode();
            goto L15
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "Success(id=" + this.a + ", device=" + this.b + ", isMultiDeviceLinked=" + this.c + ", autoWearSensorEnable=" + this.d + ", newVersion=" + this.e + ')';
        }

        public b(int r2, DoraDevice r3, boolean r4, boolean r5, String r6) {
            Intrinsics.checkNotNullParameter(r3, "device");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public static b a(b r6, int r7, boolean r8, boolean r9, String r10, int r11) {
            if ((r11 & 1) == 0) goto L5;
            r7 = r6.a;
        L5:
            int r1 = r7;
            if ((r11 & 2) == 0) goto L8;
            DoraDevice r12 = r6.b;
        L9:
            DoraDevice r2 = r12;
            if ((r11 & 4) == 0) goto L12;
            r8 = r6.c;
        L12:
            boolean r3 = r8;
            if ((r11 & 8) == 0) goto L15;
            r9 = r6.d;
        L15:
            boolean r4 = r9;
            if ((r11 & 16) == 0) goto L18;
            r10 = r6.e;
        L18:
            r6.getClass();
            Intrinsics.checkNotNullParameter(r2, "device");
            return new b(r1, r2, r3, r4, r10);
        L8:
            r12 = null;
            goto L9
        }
    }
}
