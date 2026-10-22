package com.larus.dora.obric.device_management.device_home;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class i {

    public static final class a extends i {
        public final String a;
        public final Bundle b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Bundle r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Route(route=" + this.a + ", arguments=" + this.b + ')';
        }

        public a(String r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "route");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends i {
        public final String a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "ShowEnvironmentMemoryAuthorization(deviceMac=" + this.a + ", requestId=" + this.b + ')';
        }

        public b(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "deviceMac");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c extends i {
        public final DoraObricEnvironmentMemoryToastType a;

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
            return this.a.hashCode();
        }

        public final String toString() {
            return "ShowEnvironmentMemoryToast(type=" + this.a + ')';
        }

        public final DoraObricEnvironmentMemoryToastType getType() {
            return this.a;
        }

        public c(DoraObricEnvironmentMemoryToastType r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            this.a = r2;
        }
    }

    public i() {
    }
}
