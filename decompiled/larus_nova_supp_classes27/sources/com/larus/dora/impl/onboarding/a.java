package com.larus.dora.impl.onboarding;

import com.larus.dora.api.model.FlowDoraConnectReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class a {
    public final String a;

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.a$a, reason: collision with other inner class name */
    public static final class C0087a extends a {
        public static final C0087a b = null;

        static {
            b = new C0087a();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0087a) == true) goto L9;
            return false;
        L9:
            C0087a r4 = (C0087a) r3;
            return true;
        }

        public final int hashCode() {
            return 365625524;
        }

        public final String toString() {
            return "DeviceAuthGetSignTokenFailed";
        }

        public C0087a() {
            super("deviceAuthGetSignTokenFailed");
        }
    }

    public static final class b extends a {
        public static final b b = null;

        static {
            b = new b();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof b) == true) goto L9;
            return false;
        L9:
            b r4 = (b) r3;
            return true;
        }

        public final int hashCode() {
            return -276508804;
        }

        public final String toString() {
            return "DeviceAuthProtocolInfoGetFailed";
        }

        public b() {
            super("deviceAuthProtocolInfoGetFailed");
        }
    }

    public static final class c extends a {
        public static final c b = null;

        static {
            b = new c();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof c) == true) goto L9;
            return false;
        L9:
            c r4 = (c) r3;
            return true;
        }

        public final int hashCode() {
            return -10250414;
        }

        public final String toString() {
            return "DeviceAuthSuccess";
        }

        public c() {
            super(FlowDoraConnectReason.SUCCESS);
        }
    }

    public static final class d extends a {
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.b == ((d) r8).b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r0 = this.b;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public final String toString() {
            return "DeviceSignTokenAuthFailed(code=" + this.b + ')';
        }

        public d(long r3) {
            super("deviceSignTokenAuthFailed(" + r3 + ')');
            this.b = r3;
        }
    }

    public a(String r1) {
        this.a = r1;
    }
}
