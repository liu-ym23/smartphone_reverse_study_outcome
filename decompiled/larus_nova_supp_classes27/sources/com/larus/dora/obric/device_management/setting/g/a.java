package com.larus.dora.obric.device_management.setting.g;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.a$a, reason: collision with other inner class name */
    public static final class C0105a extends a {
        public final DoraDevice a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0105a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0105a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "NeedUnbind(device=" + this.a + ')';
        }

        public C0105a(DoraDevice r2) {
            Intrinsics.checkNotNullParameter(r2, "device");
            this.a = r2;
        }
    }

    public static final class b extends a {
        public final DoraDevice a;

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
            DoraDevice r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "ShowConnectFailedDialog(device=" + this.a + ')';
        }

        public b(DoraDevice r1) {
            this.a = r1;
        }
    }

    public static final class c extends a {
        public final int a;

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
            return this.a;
        }

        public final String toString() {
            return "Toast(resId=" + this.a + ')';
        }

        public c(int r1) {
            this.a = r1;
        }
    }

    public static final class d extends a {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ToastText(text=" + this.a + ')';
        }

        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.a = r2;
        }
    }

    public static final class e extends a {
        public static final e a = null;

        static {
            a = new e();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof e) == true) goto L9;
            return false;
        L9:
            e r4 = (e) r3;
            return true;
        }

        public final int hashCode() {
            return 466071147;
        }

        public final String toString() {
            return "UnbindSuccess";
        }

        public e() {
        }
    }

    public a() {
    }
}
