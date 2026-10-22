package com.larus.dora.impl.ota.connector;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface a extends com.larus.dora.impl.ota.c {

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.connector.a$a, reason: collision with other inner class name */
    public static final class C0091a implements a {
        public static final C0091a a = null;

        static {
            a = new C0091a();
        }

        public C0091a() {
        }

        @Override // j69.c
        public final String a() {
            return "ap_enabled";
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
            return "gps_disabled";
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
            return "location_permission_denied";
        }
    }

    public static final class d implements a {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // j69.c
        public final String a() {
            return "nearby_permission_denied";
        }
    }

    public static final class e implements a {
        public final String a;
        public final String b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((e) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "WifiConnectFailed(reason=" + this.a + ')';
        }

        public e() {
            this("");
        }

        @Override // j69.c
        public final String a() {
            return this.b;
        }

        public e(String r3) {
            Intrinsics.checkNotNullParameter(r3, "reason");
            this.a = r3;
            if (r3.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            String r4 = "wifi_connect_failed_" + r3;
        L9:
            this.b = r4;
            return;
        L8:
            r4 = "wifi_connect_failed";
            goto L9
        L5:
            r0 = false;
            goto L6
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
            return "wifi_disabled";
        }
    }
}
