package com.ss.android.lark.conditional.access.traffic.handler.policy.center;

import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class d implements com.ss.android.lark.conditional.access.traffic.handler.policy.center.a {
    public final String a;
    public a b;
    public long c;

    public static final class a {
        public final String a;

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
            return "ActionKey(displayId=" + this.a + ')';
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "displayId");
            this.a = r2;
        }
    }

    public static final class b {
    }

    static {
    }

    public static long a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Long.valueOf(w4c.c.a().r0()));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = 10L;
    L9:
        long r3 = ((Number) r1).longValue();
        if (r3 > 0) goto L13;
        int r2 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "cooling settings fallback, reason=invalid_value, value=" + r3 + ", coolingSeconds=10");
        return 10;
    L13:
        return r3;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static boolean b() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(w4c.c.a().m()));     // Catch: Throwable -> L4
    L6:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = r2;
    L10:
        return ((Boolean) r1).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    @Inject
    public d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        this.a = r2;
    }

    @Override // com.ss.android.lark.conditional.access.traffic.handler.policy.center.a
    public final synchronized boolean C5(InternalSecurityAction r17) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r17, Keys.API_PARAM_KEY_ACTION);     // Catch: Throwable -> L27
        if (b() == false) goto L9;
        this.b = null;     // Catch: Throwable -> L27
        this.c = 0;     // Catch: Throwable -> L27
        int r1 = ScsLogger.a;     // Catch: Throwable -> L27
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "incoming dedup bypassed by disable setting, " + c(this, r17, null, "dedup_disabled", null, null, 26));     // Catch: Throwable -> L27
        monitor-exit(this);
        return false;
    L9:
        a r3 = d(r17, "incoming");     // Catch: Throwable -> L27
        if (r3 != null) goto L13;
        monitor-exit(this);
        return false;
    L13:
        a r4 = this.b;     // Catch: Throwable -> L27
        if (r4 != null) goto L18;
        monitor-exit(this);
        return false;
    L18:
        if (this.c > System.currentTimeMillis()) goto L22;
        int r2 = ScsLogger.a;     // Catch: Throwable -> L27
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "cooling expired, " + c(this, r17, r4, "cooling_expired", null, null, 24));     // Catch: Throwable -> L27
        this.b = null;     // Catch: Throwable -> L27
        this.c = 0;     // Catch: Throwable -> L27
        monitor-exit(this);
        return false;
    L22:
        boolean r9 = Intrinsics.areEqual(r4, r3);     // Catch: Throwable -> L27
        if (r9 == false) goto L25;
        int r5 = ScsLogger.a;     // Catch: Throwable -> L27
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "incoming filtered by cooling, " + c(this, r17, r3, "cooling", null, null, 24));     // Catch: Throwable -> L27
    L25:
        monitor-exit(this);
        return r9;
    L27:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.conditional.access.traffic.handler.policy.center.a
    public final synchronized void i3(InternalSecurityAction r13) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (b() == false) goto L9;
        this.b = null;     // Catch: Throwable -> L17
        this.c = 0;     // Catch: Throwable -> L17
        int r0 = ScsLogger.a;     // Catch: Throwable -> L17
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "onPingSuccess dedup bypassed by disable setting, " + c(this, r13, null, "dedup_disabled", null, null, 26));     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L9:
        a r5 = d(r13, "ping_success");     // Catch: Throwable -> L17
        if (r5 != null) goto L14;
        int r1 = ScsLogger.a;     // Catch: Throwable -> L17
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "onPingSuccess bypass, " + c(this, r13, null, "missing_display_id", null, null, 26));     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L14:
        long r2 = a();     // Catch: Throwable -> L17
        this.b = r5;     // Catch: Throwable -> L17
        this.c = System.currentTimeMillis() + (((long) 1000) * r2);     // Catch: Throwable -> L17
        int r3 = ScsLogger.a;     // Catch: Throwable -> L17
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "onPingSuccess cooling start, " + c(this, r13, r5, "ping_success", Long.valueOf(r2), null, 16));     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public final a d(InternalSecurityAction r11, String r12) {
        if (r11 == null) goto L7;
        DecisionData.Action r1 = r11.getCurrentAction();
        if (r1 == null) goto L7;
        String r2 = r1.getName();
    L9:
        if (Intrinsics.areEqual(r2, "ACCESS_CONTROL_ACTION_COMMON") == true) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r11.getCurrentAction().getParams().get("policyType"), "POLICY_CENTER") == true) goto L15;
        return null;
    L15:
        if (Intrinsics.areEqual(r11.getCurrentAction().getParams().get("containerType"), "page") == true) goto L17;
        return null;
    L17:
        String r3 = r11.getCurrentAction().getParams().get("displayID");
        if (r3 != null) goto L20;
    L30:
        int r4 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "bypass, " + c(this, r11, null, "missing_display_id", null, r12, 10));
        return null;
    L20:
        if (r3.length() <= 0) goto L22;
        boolean r5 = true;
    L23:
        if (r5 == true) goto L26;
        r3 = null;
    L26:
        if (r3 == null) goto L30;
        return new a(r3);
    L22:
        r5 = false;
    L7:
        r2 = null;
        goto L9
    }

    public static String c(d r3, InternalSecurityAction r4, a r5, String r6, Long r7, String r8, int r9) {
        String r1 = null;
        if ((r9 & 2) == 0) goto L5;
        r5 = null;
    L5:
        Long r10 = r7;
        if ((r9 & 8) == 0) goto L9;
        r10 = null;
    L9:
        if ((r9 & 16) == 0) goto L11;
        r8 = "gate";
    L11:
        r3.getClass();
        if (r4 == null) goto L16;
        DecisionData.Action r11 = r4.getCurrentAction();
        if (r11 == null) goto L16;
        Map<String, String> r12 = r11.getParams();
    L17:
        if (r12 != null) goto L19;
        r12 = MapsKt.emptyMap();
    L19:
        StringBuilder r0 = new StringBuilder("userID=");
        r0.append(r3.a);
        r0.append(", displayID=");
        if (r5 == null) goto L23;
        String r13 = r5.a;
        if (r13 == null) goto L23;
    L26:
        r0.append(r13);
        r0.append(", traceId=");
        if (r4 == null) goto L29;
        r1 = r4.getTraceId();
    L29:
        if (r1 != null) goto L31;
        r1 = BuildConfig.FLAVOR;
    L31:
        r0.append(r1);
        r0.append(", logID=, containerType=");
        String r14 = r12.get("containerType");
        if (r14 != null) goto L34;
        r14 = BuildConfig.FLAVOR;
    L34:
        r0.append(r14);
        r0.append(", policyType=");
        String r15 = r12.get("policyType");
        if (r15 != null) goto L37;
        r15 = BuildConfig.FLAVOR;
    L37:
        r0.append(r15);
        r0.append(", challengeType=");
        String r16 = r12.get("challengeType");
        if (r16 != null) goto L40;
        r16 = BuildConfig.FLAVOR;
    L40:
        r0.append(r16);
        r0.append(", source=");
        r0.append(r8);
        r0.append(", reason=");
        r0.append(r6);
        r0.append(", coolingSeconds=");
        Object r17 = r10;
        if (r10 != null) goto L43;
        r17 = BuildConfig.FLAVOR;
    L43:
        r0.append(r17);
        return r0.toString();
    L23:
        r13 = r12.get("displayID");
        if (r13 != null) goto L26;
        r13 = BuildConfig.FLAVOR;
    L16:
        r12 = null;
        goto L17
    }
}
