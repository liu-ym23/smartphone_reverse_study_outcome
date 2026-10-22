package com.larus.dora.impl.device.settings.lab.env;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface y {

    public static final class a implements y {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements y {
        public final boolean a;
        public final boolean b;
        public final String c;
        public final String d;
        public final boolean e;
        public final boolean f;

        public final boolean equals(Object r1) {
            return false;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (((((r2 + r3) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            if (this.e == false) goto L13;
            int r5 = 1231;
        L14:
            int r6 = (r4 + r5) * 31;
            if (this.f == true) goto L19;
            r1 = 1237;
        L19:
            return r6 + r1;
        L13:
            r5 = 1237;
            goto L14
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "State(envObserveEnable=" + this.a + ", timeEnable=" + this.b + ", startTime=" + this.c + ", endTime=" + this.d + ", lightEnable=" + this.e + ", updateSuccess=" + this.f + ')';
        }

        public b(boolean r2, boolean r3, String r4, String r5, boolean r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r4, "startTime");
            Intrinsics.checkNotNullParameter(r5, "endTime");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public static b a(b r7, boolean r8, boolean r9, String r10, String r11, boolean r12, boolean r13, int r14) {
            if ((r14 & 1) == 0) goto L5;
            r8 = r7.a;
        L5:
            boolean r1 = r8;
            if ((r14 & 2) == 0) goto L8;
            r9 = r7.b;
        L8:
            boolean r2 = r9;
            if ((r14 & 4) == 0) goto L11;
            r10 = r7.c;
        L11:
            String r3 = r10;
            if ((r14 & 8) == 0) goto L14;
            r11 = r7.d;
        L14:
            String r4 = r11;
            if ((r14 & 16) == 0) goto L17;
            r12 = r7.e;
        L17:
            boolean r5 = r12;
            if ((r14 & 32) == 0) goto L20;
            r13 = r7.f;
        L20:
            r7.getClass();
            Intrinsics.checkNotNullParameter(r3, "startTime");
            Intrinsics.checkNotNullParameter(r4, "endTime");
            return new b(r1, r2, r3, r4, r5, r13);
        }
    }
}
