package com.larus.dora.impl.device;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.dora.impl.device.a$a, reason: collision with other inner class name */
    public static final class C0031a implements a {
        public final DoraDevice a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0031a) == true) goto L8;
            return false;
        L8:
            C0031a r6 = (C0031a) r5;
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
            return "LaunchOnboarding(device=" + this.a + ", autoConnect=" + this.b + ')';
        }

        public C0031a(DoraDevice r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "device");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements a {
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
            return "NeedUnbind(device=" + this.a + ')';
        }

        public b(DoraDevice r2) {
            Intrinsics.checkNotNullParameter(r2, "device");
            this.a = r2;
        }
    }

    public static final class c implements a {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d implements a {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }
}
