package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.conditional.access.auth.v2.y;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CheckPriority;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateLogInfo;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import i8b.n;
import i8b.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements n {
    public final q a;

    public static final class a {
    }

    static {
    }

    public b(q r2) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
        this.a = r2;
    }

    @Override // i8b.n
    public final com.ss.android.lark.conditional.access.auth.v2.c a(g r8) {
        Intrinsics.checkNotNullParameter(r8, "chain");
        PolicyModel r9 = r8.c;
        if (Intrinsics.areEqual(r9.getEntity().getEntityOperate(), "IM_MSG_FILE_READ") == false) goto L8;
        if (w4c.c.a().r() == false) goto L8;
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ERROR, ValidateResultSource.OTHERS, null, null, 1016);
    L8:
        return c(r9, this.a.j(r9, true));
    }

    public static com.ss.android.lark.conditional.access.auth.v2.c c(PolicyModel r14, com.ss.android.lark.conditional.access.auth.v2.e r15) {
        com.ss.android.lark.conditional.access.auth.v2.d r0 = r15.a;
        if (r0 != null) goto L5;
        ScsLogger.d("SecurityPolicy_CheckAuthService", "memoryResult is null.");
    L5:
        com.ss.android.lark.conditional.access.auth.v2.c r1 = new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ERROR, ValidateResultSource.CACHE, null, null, 1016);
        r1.q(r14.getPointKey());
        if (r0 != null) goto L8;
    L36:
        return r1;
    L8:
        if (r0.b() == false) goto L10;
        ResultType r2 = ResultType.ALLOW;
    L11:
        r1.s(r2);
        r1.l(r0.a());
        r1.p(r0.c());
        r1.t(true);
        r1.m(r14.getTaskId());
        r1.n(r15.b);
        Long r16 = r0.g();
        if (r16 == null) goto L25;
        long r3 = r16.longValue();
        if (r3 >= System.currentTimeMillis()) goto L25;
        com.ss.android.lark.storage.kv.repo.a r17 = y.a;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.a == true) goto L18;
    L22:
        r1.t(false);
    L23:
        FileAuthMonitor.UpdateTrigger[] r18 = FileAuthMonitor.a;
        long r6 = System.currentTimeMillis() - r3;
        Intrinsics.checkNotNullParameter(r14, "policyModel");
        String r19 = u4c.a.a;
        u4c.a.a("scs_security_policy_hit_invalid_cache", MapsKt.mapOf(new Pair[]{TuplesKt.to("operation", r14.getEntity().getEntityOperate()), TuplesKt.to("entityType", r14.getEntity().getEntityType()), TuplesKt.to("entityDomain", r14.getEntity().getEntityDomain()), TuplesKt.to("pointKey", r14.getPointKey())}), MapsKt.mapOf(TuplesKt.to("invalid_duration", Long.valueOf(r6 / ((long) 1000)))), null, 0, 24);
        goto L25
    L18:
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.b == true) goto L22;
        if (Intrinsics.areEqual(r14.getPointKey(), "PointKey_IM_MSG_FILE_READ") == false) goto L22;
        r1.o();
    L25:
        if (r1.k() == true) goto L27;
    L30:
        ScsLogger.d("SecurityPolicy_MemoryCheckInterceptor", "[cacheIsValid:False]");
    L31:
        ValidateLogInfo r110 = com.ss.android.lark.conditional.access.auth.v2.g.b(r0);
        if (r110 == null) goto L36;
        if (Intrinsics.areEqual(r14.getPointKey(), "PointKey_CCM_OPEN_EXTERNAL_ACCESS_WITH_OBJECT") == true) goto L36;
        r1.u(CollectionsKt.listOf(r110));
        goto L36
    L27:
        if (r1.j() == false) goto L30;
        ScsLogger.d("SecurityPolicy_MemoryCheckInterceptor", "[cacheIsValid:True]");
        goto L31
    L10:
        r2 = ResultType.DENY;
        goto L11
    }

    @Override // i8b.n
    public final Object b(com.ss.android.lark.conditional.access.auth.v2.service.chain.a r23, Continuation r24) {
        String r3 = BuildConfig.FLAVOR;
        if ((r24 instanceof MemoryCheckInterceptor$intercept$1) == false) goto L7;
        Continuation<? super Map<String, com.ss.android.lark.conditional.access.auth.v2.c>> r5 = (MemoryCheckInterceptor$intercept$1) r24;
        int r6 = r5.label;
        if ((r6 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r5.label = r6 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r2 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        boolean r10 = false;
        if (r8 == 0) goto L16;
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L14;
        List r0 = (List) r5.L$1;
        Map r4 = (Map) r5.L$0;
        ResultKt.throwOnFailure(r2);
    L85:
        Map r9 = MapsKt.toMutableMap((Map) r2);
        Iterator r1 = r0.iterator();
    L87:
        if (r1.hasNext() == false) goto L97;
        PolicyModel r11 = (PolicyModel) r1.next();
        com.ss.android.lark.conditional.access.auth.v2.c r12 = (com.ss.android.lark.conditional.access.auth.v2.c) r9.get(r11.getTaskId());
        ValidateResultSource[] r13 = {ValidateResultSource.DOWNGRADE, ValidateResultSource.FALLBACK};
        if (r12 == null) goto L91;
        ValidateResultSource r14 = r12.g();
    L93:
        if (ArraysKt.contains(r13, r14) == false) goto L87;
        com.ss.android.lark.conditional.access.auth.v2.c r15 = c(r11, this.a.j(r11, false));
        if (r15.h() == ResultType.ERROR) goto L87;
        r9.put(r11.getTaskId(), r15);
        goto L87
    L91:
        r14 = null;
        goto L93
    L97:
        r4.putAll(r9);
        return r4;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r2);
    L23:
        return r2;
    L16:
        ResultKt.throwOnFailure(r2);
        List<PolicyModel> r16 = r23.c;
        if (Intrinsics.areEqual(((PolicyModel) CollectionsKt.first(r16)).getEntity().getEntityOperate(), "IM_MSG_FILE_READ") == true) goto L19;
    L24:
        LinkedHashMap r17 = new LinkedHashMap();
        ArrayList r18 = new ArrayList();
        String r19 = r23.e;
        String r110 = qqb.a.d();     // Catch: Throwable -> L104
        qqb.a.f(r19);     // Catch: Throwable -> L102
        Iterator<T> r20 = r16.iterator();     // Catch: Throwable -> L102
    L27:
        if (r20.hasNext() == false) goto L77;
        PolicyModel r111 = (PolicyModel) r20.next();     // Catch: Throwable -> L102
        if (Intrinsics.areEqual(r111.getPointKey(), "PointKey_CCM_OPEN_EXTERNAL_ACCESS") == false) goto L33;
        com.ss.android.lark.conditional.access.auth.v2.c r21 = new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);     // Catch: Throwable -> L102
    L75:
        r17.put(r111.getTaskId(), r21);     // Catch: Throwable -> L102
        r10 = false;
        goto L27
    L33:
        com.ss.android.lark.conditional.access.auth.v2.e r22 = this.a.j(r111, r10);     // Catch: Throwable -> L102
        com.ss.android.lark.conditional.access.auth.v2.c r25 = c(r111, r22);     // Catch: Throwable -> L102
        int r112 = ScsLogger.a;     // Catch: Throwable -> L102
        StringBuilder r113 = new StringBuilder();     // Catch: Throwable -> L102
        r113.append("checkPriority is: ");     // Catch: Throwable -> L102
        ValidateConfig r114 = r23.d;     // Catch: Throwable -> L102
        if (r114 == null) goto L36;
        CheckPriority r115 = r114.getCheckPriority();     // Catch: Throwable -> L102
    L37:
        r113.append(r115);     // Catch: Throwable -> L102
        ScsLogger.d("SecurityPolicy_CheckAuthService", r113.toString());     // Catch: Throwable -> L102
        ValidateConfig r116 = r23.d;     // Catch: Throwable -> L102
        if (r116 == null) goto L40;
        CheckPriority r117 = r116.getCheckPriority();     // Catch: Throwable -> L102
    L42:
        if (r117 != CheckPriority.RemoteFirst) goto L44;
        boolean r118 = true;
    L45:
        if (r118 == false) goto L47;
    L73:
        r18.add(r111);     // Catch: Throwable -> L102
    L74:
        r21 = r25;
        goto L75
    L47:
        if (r25.h() == ResultType.ERROR) goto L73;
        if (r25.e() == true) goto L73;
        if (r25.k() == false) goto L73;
        com.ss.android.lark.storage.kv.repo.a r119 = y.a;     // Catch: Throwable -> L102
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.a == false) goto L74;
        if (Intrinsics.areEqual(r111.getPointKey(), "PointKey_IM_MSG_FILE_READ") == false) goto L74;
        com.ss.android.lark.conditional.access.auth.v2.d r26 = r22.a;     // Catch: Throwable -> L102
        if (r26 == null) goto L70;
        Map<String, Integer> r120 = com.ss.android.lark.conditional.access.auth.v2.g.a;     // Catch: Throwable -> L102
        Intrinsics.checkNotNullParameter(r26, "<this>");     // Catch: Throwable -> L102
        Long r27 = r26.g();     // Catch: Throwable -> L102
        if (r27 == null) goto L62;
        long r121 = r27.longValue();     // Catch: Throwable -> L102
    L64:
        if ((r121 - System.currentTimeMillis()) < 0) goto L66;
        boolean r28 = true;
    L68:
        if (r28 != true) goto L70;
        boolean r29 = true;
    L71:
        if (r29 == true) goto L74;
        ScsLogger.d("SecurityPolicy_MemoryCheckInterceptor", "im share isInvalid, taskID: " + r111.getTaskId());     // Catch: Throwable -> L102
        r18.add(r111);     // Catch: Throwable -> L102
        goto L74
    L66:
        r28 = false;
        goto L68
    L62:
        r121 = 0;
    L70:
        r29 = false;
        goto L71
    L44:
        r118 = false;
        goto L45
    L40:
        r117 = null;
        goto L42
    L36:
        r115 = null;
        goto L37
    L77:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r110, "traceId");
        qqb.a.g(r110);
        if (r18.size() <= 0) goto L101;
        String r30 = r23.e;
        r3 = qqb.a.d();     // Catch: Throwable -> L98
        qqb.a.f(r30);     // Catch: Throwable -> L98
        ArrayList<String> r31 = com.ss.android.lark.conditional.access.utils.c.a;     // Catch: Throwable -> L98
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_CheckAuthService", "async check no cache models: " + r18.size(), false);     // Catch: Throwable -> L98
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r3, "traceId");
        qqb.a.g(r3);
        r5.L$0 = r17;
        r5.L$1 = r18;
        r5.label = 2;
        r2 = r23.a(r18, r5);
        if (r2 != r7) goto L84;
        return r7;
    L84:
        r4 = r17;
        r0 = r18;
    L98:
        th = move-exception;
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r3, "traceId");
        qqb.a.g(r3);
        throw th;
    L101:
        return r17;
    L102:
        th = th;
        r3 = r110;
    L105:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r3, "traceId");
        qqb.a.g(r3);
        throw th;
    L104:
        th = th;
        goto L105
    L19:
        if (w4c.c.a().r() == false) goto L24;
        r5.label = 1;
        r2 = r23.a(r16, r5);
        if (r2 != r7) goto L23;
        return r7;
    L7:
        r5 = new MemoryCheckInterceptor$intercept$1(this, r24);
        goto L8
    }
}
