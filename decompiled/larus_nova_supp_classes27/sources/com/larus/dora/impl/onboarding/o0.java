package com.larus.dora.impl.onboarding;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface o0 {

    public static final class a implements o0 {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
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
            return 973411519;
        }

        public final String toString() {
            return "AuthDeviceFailed";
        }
    }

    public static final class b implements o0 {
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
            return this.a.hashCode();
        }

        public final String toString() {
            return "AuthDeviceSuccess(device=" + this.a + ')';
        }

        public b(DoraDevice r2) {
            Intrinsics.checkNotNullParameter(r2, "device");
            this.a = r2;
        }
    }

    public static final class c implements o0 {
        public final DoraDevice a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ShowNeedUnbindDialog(device=" + this.a + ')';
        }

        public c(DoraDevice r2) {
            Intrinsics.checkNotNullParameter(r2, "device");
            this.a = r2;
        }
    }

    public static final class d implements o0 {
        public final String a;
        public final TOAST_TYPE b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ShowToast(text=" + this.a + ", type=" + this.b + ')';
        }

        public final TOAST_TYPE getType() {
            return this.b;
        }

        public /* synthetic */ d(String r2) {
            this(r2, TOAST_TYPE.TOAST_TYPE_ERROR);
        }

        public d(String r2, TOAST_TYPE r3) {
            Intrinsics.checkNotNullParameter(r2, "text");
            Intrinsics.checkNotNullParameter(r3, "type");
            this.a = r2;
            this.b = r3;
        }
    }
}
