package com.ss.android.lark.conditional.access.auth.v2;

import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.traffic.RegulateDispatcher;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.SecurityAction;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class z {
    public static final z a = null;
    public static long b;
    public static a0 c;

    static {
        a = new z();
    }

    public z() {
    }

    public final void c(com.ss.android.lark.security.compliance.api.model.filepolicy.l r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        a0 r1 = c;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "event");
        f r2 = r1.b;
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r3, "event");
        r2.b.c(r3);
        return;
    L9:
        return;
    }

    public static void e(SecurityAction r11, @RegulateDispatcher.ActionFrom String r12) {
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_SecurityAuthSDK", "handleSecurityAction(),securityAction:" + r11.getRawActions());
        boolean r3 = true;
        if (r11.source != 1) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        r12 = "DOUBAO_RESPONSE";
    L9:
        if (w4c.c.a().l() == false) goto L11;
        return;
    L11:
        if (r1 == true) goto L13;
    L16:
        if (r1 == false) goto L22;
        FileAuthMonitor.UpdateTrigger[] r2 = FileAuthMonitor.a;
        long r4 = r11.sourceTimestampMs;
        if (r4 <= 0) goto L22;
        int r5 = (int) RangesKt.coerceAtMost(RangesKt.coerceAtLeast(System.currentTimeMillis() - r4, 0), 2147483647L);
        String r6 = u4c.a.a;
        u4c.a.a("scs_action_delivery", null, MapsKt.mapOf(TuplesKt.to("duration", Integer.valueOf(r5))), null, 0, 26);
    L22:
        if (r11.getRawActions().length() == 0) goto L25;
        r3 = false;
    L25:
        if (r3 == false) goto L41;
        ScsLogger.c("SecurityPolicy_SecurityAuthSDK", "handleSecurityAction(), but actions cant handle");
        r11.onError(new Exception("rawActions is empty!"));
        FileAuthMonitor.UpdateTrigger[] r7 = FileAuthMonitor.a;
        FileAuthMonitor.o(r12, r11.getRawActions(), "rawActionsEmpty");
        return;
    L41:
        DecisionData r8 = (DecisionData) com.ss.android.lark.security.compliance.infra.util.f.a(r11.getRawActions(), DecisionData.class);     // Catch: Exception -> L30
    L32:
        if (r8 != null) goto L34;
        r11.onError(new Exception("rawActions deserialization fail!"));
        ScsLogger.c("SecurityPolicy_SecurityAuthSDK", "handleSecurityAction(), but decisionData is null!");
        FileAuthMonitor.UpdateTrigger[] r9 = FileAuthMonitor.a;
        FileAuthMonitor.o(r12, r11.getRawActions(), "deserialization");
        return;
    L34:
        LinkedList<DecisionData.Action> r10 = r8.getActions();
        if (r10 == null) goto L39;
        DecisionData.Action r13 = (DecisionData.Action) CollectionsKt.getOrNull(r10, 0);
        if (r13 == null) goto L39;
        InternalSecurityAction r14 = new InternalSecurityAction(r11, r13, r8.getActions());
        r14.getInternalParams().put("SDK_ACTION_SOURCE", Integer.valueOf(r11.source));
        RegulateDispatcher.a(r14, r12);
        return;
    L39:
        ScsLogger.c("SecurityPolicy_SecurityAuthSDK", "handleSecurityAction(), but actions[] is empty");
        r11.onError(new Exception("actions[] is empty"));
        FileAuthMonitor.UpdateTrigger[] r15 = FileAuthMonitor.a;
        FileAuthMonitor.o(r12, r11.getRawActions(), "requiredFieldNotFound");
        return;
    L30:
        e = move-exception;
        int r16 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_SecurityAuthSDK", "handleSecurityAction() error! e:" + e.getMessage());
        r8 = null;
        goto L32
    L13:
        if (w4c.c.a().B() == true) goto L16;
        ScsLogger.d("SecurityPolicy_SecurityAuthSDK", "skip doubao security action by setting");
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void d(SecurityAction r4, @RegulateDispatcher.ActionFrom String r5) {
        Intrinsics.checkNotNullParameter(r4, "securityAction");
        Intrinsics.checkNotNullParameter(r5, "comeFrom");
        String r1 = r4.getTraceId();
        String r2 = qqb.a.d();     // Catch: Throwable -> L9
        qqb.a.f(r1);     // Catch: Throwable -> L7
        a.getClass();     // Catch: Throwable -> L7
        e(r4, r5);     // Catch: Throwable -> L7
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r2, "traceId");
        qqb.a.g(r2);
        return;
    L7:
        th = th;
    L11:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r2, "traceId");
        qqb.a.g(r2);
        throw th;
    L9:
        th = th;
        r2 = BuildConfig.FLAVOR;
        goto L11
    }

    public static ValidateResult b(PolicyModel r9, AuthEntity r10, ValidateConfig r11) {
        ArrayList<String> r0 = com.ss.android.lark.conditional.access.utils.c.a;
        StringBuilder r1 = new StringBuilder("[start check auth],do checkSecurityPolicy(), [policyModel:");
        r1.append(r9.toRawString());
        r1.append("], [validateType: Sync] authEntity is: ");
        if (r10 == null) goto L5;
        Integer r2 = Integer.valueOf(r10.getEntityType());
    L6:
        r1.append(r2);
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityAuthSDK", r1.toString(), true);
        a0 r3 = c;
        if (r3 == null) goto L19;
        Intrinsics.checkNotNullParameter(r9, "policyModel");
        long r4 = System.currentTimeMillis();
        f r6 = r3.b;
        if (r6 == null) goto L11;
        ValidateResult r12 = r6.a(r9, r11);
    L12:
        int r7 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_SecurityAuthService", "checkAuthSync(), security policy result is " + r12);
        if (r12.getResult() == ResultType.DENY) goto L20;
        ValidateResult.ValidateResultExtra r8 = r12.getValidateResultExtra();
        if (r10 == null) goto L18;
        ValidateResult r13 = r3.a.a(r10, null);
        r13.setValidateResultExtra(r8);
        r12 = r13;
    L18:
        FileAuthMonitor.UpdateTrigger[] r14 = FileAuthMonitor.a;
        FileAuthMonitor.t(r9, r12, FileAuthMonitor.CheckType.CacheCheck, System.currentTimeMillis() - r4);
    L20:
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityAuthSDK", "[end check auth],do checkSecurityPolicy(), [validateResult:" + r12 + "}]", true);
        return r12;
    L11:
        ScsLogger.d("SecurityPolicy_SecurityAuthService", "do checkAuthSync(), filePolicySecurityAuthExecutor is null!");
        r12 = com.ss.android.lark.security.compliance.api.model.filepolicy.p.a;
        goto L12
    L19:
        r12 = com.ss.android.lark.security.compliance.api.model.filepolicy.p.a;
        goto L20
    L5:
        r2 = null;
        goto L6
    }

    public static void a(PolicyModel[] r13, AuthEntity r14, ValidateConfig r15, com.ss.android.lark.security.compliance.api.model.filepolicy.m r16) {
        List r1 = ArraysKt.toList(r13);
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        String r4 = ((PolicyModel) r3.next()).toRawString();
        ArrayList<String> r6 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityAuthSDK", "do checkSecurityPolicyAsync(), [policyModel is:" + r4 + ']', true);
        r2.add(r4);
        goto L4
    L6:
        a0 r5 = c;
        int r8 = 0;
        if (r5 == null) goto L20;
        PolicyModel[] r7 = (PolicyModel[]) Arrays.copyOf(r13, r13.length);
        Intrinsics.checkNotNullParameter(r7, "policyModels");
        Intrinsics.checkNotNullParameter(r16, "callback");
        long r9 = System.currentTimeMillis();
        f r10 = r5.b;
        if (r10 == null) goto L16;
        PolicyModel[] r11 = (PolicyModel[]) Arrays.copyOf(r7, r7.length);
        b0 r12 = new b0(r5, r14, r7, r16, r9);
        Intrinsics.checkNotNullParameter(r11, "p");
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (r11.length != 0) goto L14;
        r8 = 1;
    L14:
        if ((r8 ^ 1) == 0) goto L28;
        List r0 = ArraysKt.toList(r11);
        SecurityPolicyAuthManager r17 = r10.b;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r0, "models");
        Intrinsics.checkNotNullParameter(r12, "callback");
        r17.q.f(r0, r15, r12);
        return;
    L28:
        return;
    L16:
        ArrayList<String> r18 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityAuthService", "do checkAuthAsync(), filePolicySecurityAuthExecutor is null!", true);
        ArrayList r19 = new ArrayList();
        int r20 = r7.length;
    L17:
        if (r8 >= r20) goto L19;
        r19.add(com.ss.android.lark.security.compliance.api.model.filepolicy.p.a);
        r8 = r8 + 1;
        goto L17
    L19:
        r5.a(r19, r14);
        ArrayList<String> r21 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityAuthService", "[end check auth],do checkAuthAsync(), return result:" + com.ss.android.lark.security.compliance.infra.util.f.c(r19), true);
        int r22 = com.ss.android.lark.conditional.access.utils.e.a;
        r16.onResult(com.ss.android.lark.conditional.access.utils.e.e(ArraysKt.toList(r7), r19));
        return;
    L20:
        ArrayList r23 = new ArrayList();
        int r24 = r13.length;
    L21:
        if (r8 >= r24) goto L23;
        r23.add(com.ss.android.lark.security.compliance.api.model.filepolicy.p.a);
        r8 = r8 + 1;
        goto L21
    L23:
        ArrayList<String> r25 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityAuthSDK", "do checkSecurityPolicyAsync(), SecurityAuthService is null!", true);
        int r26 = com.ss.android.lark.conditional.access.utils.e.a;
        r16.onResult(com.ss.android.lark.conditional.access.utils.e.e(ArraysKt.toList(r13), r23));
    }
}
