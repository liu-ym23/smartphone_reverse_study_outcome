package com.larus.bmhome.taskskill.ui;

import com.larus.bmhome.taskskill.model.PcDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class i {

    public static final class a extends i {
        public static final a a = null;
        public static final String b = null;

        static {
            a = new a();
            b = "add_computer";
        }

        public a() {
        }

        @Override // com.larus.bmhome.taskskill.ui.i
        public final String a() {
            return b;
        }
    }

    public static final class b extends i {
        public final PcDevice a;
        public final boolean b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Device(device=" + this.a + ", selected=" + this.b + ')';
        }

        @Override // com.larus.bmhome.taskskill.ui.i
        public final String a() {
            return this.c;
        }

        public b(PcDevice r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "device");
            this.a = r2;
            this.b = r3;
            String r4 = r2.getDeviceId();
            if (r4 != null) goto L5;
            r4 = "";
        L5:
            this.c = "device_".concat(r4);
        }
    }

    public static final class c extends i {
        public final boolean a;
        public final String b;

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
            return "DoNotUseComputer(selected=" + this.a + ')';
        }

        @Override // com.larus.bmhome.taskskill.ui.i
        public final String a() {
            return this.b;
        }

        public c(boolean r1) {
            this.a = r1;
            this.b = "do_not_use_computer";
        }
    }

    public static final class d extends i {
        public static final d a = null;
        public static final String b = null;

        static {
            a = new d();
            b = "loading";
        }

        public d() {
        }

        @Override // com.larus.bmhome.taskskill.ui.i
        public final String a() {
            return b;
        }
    }

    public i() {
    }

    public abstract String a();
}
