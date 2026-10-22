package com.ss.android.lark.conditional.access.utils;

import com.bytedance.lark.policy.model.ResponseType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.traffic.RegulateDispatcher;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.SecurityAction;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResponseType.values().length];
            r0[ResponseType.REMOTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ResponseType.LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ResponseType.DOWNGRADE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ResponseType.FAST_PASS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public static com.ss.android.lark.conditional.access.auth.v2.c a() {
        ResultType r6 = ResultType.DENY;
        com.ss.android.lark.conditional.access.auth.v2.c r7 = new com.ss.android.lark.conditional.access.auth.v2.c(r6, ValidateResultSource.FALLBACK, null, null, 1016);
        if (w4c.c.a().c0() == false) goto L5;
        r6 = ResultType.ALLOW;
    L5:
        r7.s(r6);
        return r7;
    }

    public static Map b(List r12) {
        Intrinsics.checkNotNullParameter(r12, "models");
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = r12.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.put(((PolicyModel) ListProtector.get(r12, r3)).getTaskId(), new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016));
        r3 = r3 + 1;
        goto L3
    L5:
        ArrayList<String> r13 = c.a;
        c.b("SecurityPolicy_SecurityHandleUtil", "do fastAllow()!", false);
        return r0;
    }

    public static List d(List r4) {
        if (r4 == null) goto L11;
        List r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L5:
        if (r6.hasNext() == false) goto L15;
        com.bytedance.lark.policy.model.a r1 = (com.bytedance.lark.policy.model.a) r6.next();
        DecisionData.Action r2 = new DecisionData.Action();
        r2.setName(r1.a());
        Map<String, String> r3 = r1.b();
        if (r3 != null) goto L9;
        r3 = MapsKt.emptyMap();
    L9:
        r2.setParams(r3);
        r0.add(r2);
        goto L5
    L15:
        return r0;
    L11:
        return CollectionsKt.emptyList();
    }

    public static void c(ValidateConfig r14, com.ss.android.lark.conditional.access.auth.v2.c r15) {
        Intrinsics.checkNotNullParameter(r15, "filePolicyResult");
        List<DecisionData.Action> r0 = r15.b();
        if (r0 == null) goto L6;
        DecisionData.Action r1 = (DecisionData.Action) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L6;
    L7:
        boolean r2 = false;
        if (r1.getName().length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L22;
        if (r15.h() != ResultType.DENY) goto L22;
        if (r15.g() != ValidateResultSource.DOWNGRADE) goto L18;
        r1.setName("FALLBACK_COMMON");
    L18:
        if (r15.g() != ValidateResultSource.FALLBACK) goto L20;
        r1.setName("UNIVERSAL_FALLBACK_COMMON");
    L20:
        r15.l(CollectionsKt.listOf(r1));
    L22:
        if (r15.h() != ResultType.DENY) goto L34;
        if (r14 != null) goto L25;
    L26:
        DecisionData r16 = new DecisionData();
        List<DecisionData.Action> r4 = r15.b();
        if (r4 != null) goto L30;
        r4 = CollectionsKt.emptyList();
    L30:
        r16.setActions(new LinkedList(r4));
        String r7 = com.ss.android.lark.security.compliance.infra.util.f.c(r16);
        int r17 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_SecurityHandleUtil", "do handleAction() with action:" + r1);
        PublishSubject<InternalSecurityAction> r18 = RegulateDispatcher.a;
        Intrinsics.checkNotNull(r7);
        SecurityAction r5 = new SecurityAction(r7, null, 0, 0, 14, null);
        List<DecisionData.Action> r19 = r15.b();
        if (r19 != null) goto L33;
        r19 = CollectionsKt.emptyList();
    L33:
        RegulateDispatcher.a(new InternalSecurityAction(r5, r1, r19), "SDK_INTERNAL");
        return;
    L25:
        if (r14.getIgnoreSecurityOperate() == false) goto L26;
    L34:
        int r6 = ScsLogger.a;
        StringBuilder r8 = new StringBuilder("do not handleAction(), filePolicyResult.resultType: ");
        r8.append(r15.h());
        r8.append(", config flag:");
        if (r14 != null) goto L37;
    L38:
        r2 = true;
    L39:
        r8.append(r2);
        ScsLogger.d("SecurityPolicy_SecurityHandleUtil", r8.toString());
        return;
    L37:
        if (r14.getIgnoreSecurityOperate() == true) goto L39;
    L10:
        r3 = false;
    L6:
        r1 = new DecisionData.Action();
        goto L7
    }

    public static Map e(List r4, List r5) {
        Intrinsics.checkNotNullParameter(r4, "policyModels");
        Intrinsics.checkNotNullParameter(r5, "validateResults");
        if (r4.size() == ((ArrayList) r5).size()) goto L6;
        ScsLogger.c("SecurityPolicy_SecurityHandleUtil", "policyModels.size != validateResult.size");
        EnsureManager.ensureNotReachHere("SecurityHandleUtil: policyModels.size != validateResult.size");
        return MapsKt.emptyMap();
    L6:
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r6 = r4.iterator();
        int r1 = 0;
    L8:
        if (r6.hasNext() == false) goto L13;
        Object r2 = r6.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        r0.put(((PolicyModel) r2).getTaskId(), ListProtector.get(r5, r1));
        r1 = r3;
        goto L8
    L13:
        return r0;
    }
}
