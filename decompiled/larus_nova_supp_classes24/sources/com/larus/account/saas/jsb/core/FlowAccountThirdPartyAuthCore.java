package com.larus.account.saas.jsb.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class FlowAccountThirdPartyAuthCore {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/account/saas/jsb/core/FlowAccountThirdPartyAuthCore$Error;", "", "", "code", "I", "getCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "UNSUPPORTED_PLATFORM", "ACTIVITY_NULL", "CONFIG_MISSING", "SERVICE_UNAVAILABLE", "REQUEST_REJECTED", "account-saas-jsb-core_release"}, k = 1, mv = {1, 7, 1})
    public static final enum Error extends Enum<Error> {
        public static final Error ACTIVITY_NULL = null;
        public static final Error CONFIG_MISSING = null;
        public static final Error REQUEST_REJECTED = null;
        public static final Error SERVICE_UNAVAILABLE = null;
        public static final Error UNSUPPORTED_PLATFORM = null;
        public static final /* synthetic */ Error[] a = null;
        private final int code;
        private final String message;

        public static Error valueOf(String r1) {
            return (Error) r27.a.a(Error.class, r1);
        }

        public static Error[] values() {
            return (Error[]) a.clone();
        }

        static {
            Error r0 = new Error("UNSUPPORTED_PLATFORM", 0, 1, "unsupported platform");
            UNSUPPORTED_PLATFORM = r0;
            Error r1 = new Error("ACTIVITY_NULL", 1, 2, "activity is null");
            ACTIVITY_NULL = r1;
            Error r2 = new Error("CONFIG_MISSING", 2, 3, "third party auth config is missing");
            CONFIG_MISSING = r2;
            Error r5 = new Error("SERVICE_UNAVAILABLE", 3, 4, "authorize service is not initialized");
            SERVICE_UNAVAILABLE = r5;
            Error r7 = new Error("REQUEST_REJECTED", 4, 5, "authorize request rejected");
            REQUEST_REJECTED = r7;
            a = new Error[]{r0, r1, r2, r5, r7};
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public Error(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.code = r3;
            this.message = r4;
        }
    }

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;
        public final Number h;
        public final String i;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.f;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r19 = (r15 + r17) * 31;
            String r20 = this.g;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            Number r23 = this.h;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            String r26 = this.i;
            if (r26 == null) goto L39;
            r1 = r26.hashCode();
        L39:
            return r25 + r1;
        L33:
            r24 = r23.hashCode();
            goto L34
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Result(platform=" + this.a + ", platformAppId=" + this.b + ", code=" + this.c + ", openId=" + this.d + ", accessToken=" + this.e + ", accessTokenSecret=" + this.f + ", expiresIn=" + this.g + ", errorCode=" + this.h + ", rawData=" + this.i + ')';
        }

        public a(String r3, String r4, String r5, String r6, String r7, String r8, String r9, Number r10, int r11) {
            if ((r11 & 4) == 0) goto L6;
            r5 = null;
        L6:
            if ((r11 & 8) == 0) goto L9;
            r6 = null;
        L9:
            if ((r11 & 16) == 0) goto L12;
            r7 = null;
        L12:
            if ((r11 & 32) == 0) goto L15;
            r8 = null;
        L15:
            if ((r11 & 64) == 0) goto L18;
            r9 = null;
        L18:
            if ((r11 & 128) == 0) goto L20;
            r10 = null;
        L20:
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = null;
        }
    }

    static {
    }
}
