package com.larus.bmhome.chat.nestedmenu.ui;

import com.larus.bmhome.taskskill.model.PcDevice;
import di8.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class w {

    public static final class a extends w {
        public final d0 a;
        public final String b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "CloudComputer(model=" + this.a + ')';
        }

        @Override // com.larus.bmhome.chat.nestedmenu.ui.w
        public final String a() {
            return this.b;
        }

        @Override // com.larus.bmhome.chat.nestedmenu.ui.w
        public final d0 b() {
            return this.a;
        }

        public a(d0 r2) {
            Intrinsics.checkNotNullParameter(r2, "model");
            this.a = r2;
            this.b = "cloud";
        }
    }

    public static final class b extends w {
        public final d0 a;
        public final String b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "LocalDevice(model=" + this.a + ')';
        }

        public final PcDevice c() {
            PcDevice r0 = v.a(this.a);
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        @Override // com.larus.bmhome.chat.nestedmenu.ui.w
        public final String a() {
            return this.b;
        }

        @Override // com.larus.bmhome.chat.nestedmenu.ui.w
        public final d0 b() {
            return this.a;
        }

        public b(d0 r2) {
            Intrinsics.checkNotNullParameter(r2, "model");
            this.a = r2;
            String r3 = c().getDeviceId();
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            this.b = "local_".concat(r3);
        }
    }

    public w() {
    }

    public abstract String a();

    public abstract d0 b();
}
