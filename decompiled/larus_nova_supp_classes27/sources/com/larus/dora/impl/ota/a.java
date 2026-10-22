package com.larus.dora.impl.ota;

import com.larus.dora.impl.ota.tracker.DoraOTAPreCheckReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface a extends com.larus.dora.impl.ota.c {

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.a$a, reason: collision with other inner class name */
    public static final class C0090a implements a {
        public static final C0090a a = null;

        static {
            a = new C0090a();
        }

        public C0090a() {
        }

        @Override // j69.c
        public final String a() {
            return "DataTransferFailed";
        }
    }

    public static final class b implements a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // j69.c
        public final String a() {
            return "DeviceDisconnected";
        }
    }

    public static final class c implements a {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // j69.c
        public final String a() {
            return "DownloadFailed";
        }
    }

    public static final class d implements a {
        public final e49.a a;
        public final String b;

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
            return "DownloadFailedOnlyWifi(response=" + this.a + ')';
        }

        @Override // j69.c
        public final String a() {
            return this.b;
        }

        public d(e49.a r2) {
            Intrinsics.checkNotNullParameter(r2, "response");
            this.a = r2;
            this.b = DoraOTAPreCheckReason.NOT_ALLOWED_CELLULAR;
        }
    }

    public static final class e implements a {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // j69.c
        public final String a() {
            return "OTAFailed";
        }
    }

    public static final class f implements a {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // j69.c
        public final String a() {
            return DoraOTAPreCheckReason.NOT_ENOUGH_SPACE_ON_PHONE;
        }
    }

    public static final class g implements a {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        @Override // j69.c
        public final String a() {
            return "vpn_connected";
        }
    }
}
