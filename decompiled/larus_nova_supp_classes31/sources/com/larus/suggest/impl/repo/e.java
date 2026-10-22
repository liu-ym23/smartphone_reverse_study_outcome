package com.larus.suggest.impl.repo;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final e a = null;
    public static final c b = null;

    public static final class a {
        public final long a;
        public final NexPulseResponseData b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "WcbPolicyResponsePayload(version=" + this.a + ", response=" + this.b + ')';
        }

        public a(long r2, NexPulseResponseData r4) {
            Intrinsics.checkNotNullParameter(r4, "response");
            this.a = r2;
            this.b = r4;
        }
    }

    public e() {
    }

    static {
        a = new e();
        b = c.a;
    }

    public static String c(String r2, int r3) {
        return "wcb_policy_response_v2_" + r2 + '_' + r3;
    }

    public static String d(String r2, int r3) {
        return "wcb_policy_state_v2_" + r2 + '_' + r3;
    }

    public static void a(String r19, int r20, String r21) {
        Intrinsics.checkNotNullParameter(r19, "conversationId");
        Intrinsics.checkNotNullParameter(r21, "userId");
        c r2 = b;
        String r3 = c(r19, r20);
        r2.getClass();
        c.a(r3, r21);
        d r4 = b(r19, r20, r21);
        if (r4 != null) goto L5;
        return;
    L5:
        e(r19, r20, d.a(r4, 0, 0, 0, null, 0, 0, 0, 60), r21);
    }

    public static d b(String r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "conversationId");
        Intrinsics.checkNotNullParameter(r10, "userId");
        String r2 = d(r8, r9);
        b.getClass();
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r10, "userId");
        Object r4 = null;
        String r3 = ((Keva) c.b.getValue()).getString(c.b(r2, r10), null);
        if (r3 != null) goto L18;
        return null;
    L18:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L7
        Object r6 = Result.constructor-impl((d) HttpExtKt.f.fromJson(r3, d.class));     // Catch: Throwable -> L7
    L9:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L13;
        FLogger.a.e("WcbLog", "[keva] invalid policy state, conversationId=" + r8 + ", scene=" + r9, r7);
        a.getClass();
        Intrinsics.checkNotNullParameter(r8, "conversationId");
        Intrinsics.checkNotNullParameter(r10, "userId");
        c r0 = b;
        String r1 = d(r8, r9);
        r0.getClass();
        c.a(r1, r10);
        c.a(c(r8, r9), r10);
    L13:
        if (Result.isFailure-impl(r6) == true) goto L17;
        r4 = r6;
    L17:
        return (d) r4;
    L7:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public static void e(String r1, int r2, d r3, String r4) {
        c r0 = b;
        String r5 = d(r1, r2);
        String r6 = GsonProtectorUtils.toJson(HttpExtKt.f, r3);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "value");
        Intrinsics.checkNotNullParameter(r4, "userId");
        ((Keva) c.b.getValue()).storeString(c.b(r5, r4), r6);
    }

    private final void update(String r3, int r4, String r5, Function1<? super d, d> r6) {
        d r0 = b(r3, r4, r5);
        if (r0 != null) goto L5;
        r0 = new d(0);
    L5:
        e(r3, r4, (d) r6.invoke(r0), r5);
    }
}
