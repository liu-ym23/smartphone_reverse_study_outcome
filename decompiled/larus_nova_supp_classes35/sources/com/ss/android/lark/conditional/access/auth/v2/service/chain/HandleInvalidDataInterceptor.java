package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import android.os.Handler;
import com.larksuite.framework.utils.NetworkUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.conditional.access.auth.v2.l;
import com.ss.android.lark.conditional.access.auth.v2.service.i;
import com.ss.android.lark.conditional.access.auth.v2.y;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyEntityWithBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import i8b.n;
import i8b.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class HandleInvalidDataInterceptor implements n {
    public final q a;
    public final l b;
    public final Object c;
    public final LinkedHashMap<String, PolicyModel> d;
    public final Lazy e;
    public boolean f;
    public final b g;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ HandleInvalidDataInterceptor a;

        public b(HandleInvalidDataInterceptor r1) {
            this.a = r1;
        }

        public final void a() {
            HandleInvalidDataInterceptor r0 = this.a;
            Object r1 = r0.c;
            monitor-enter(r1);
            r0.f = false;     // Catch: Throwable -> L19
            List r2 = CollectionsKt.toList(r0.d.values());     // Catch: Throwable -> L19
            r0.d.clear();     // Catch: Throwable -> L19
            monitor-exit(r1);
            if (r2.isEmpty() == true) goto L30;
            ArrayList r3 = new ArrayList();
            ArrayList r4 = new ArrayList();
            Iterator r5 = r2.iterator();
        L12:
            if (r5.hasNext() == false) goto L17;
            Object r6 = r5.next();
            if (com.ss.android.lark.security.compliance.api.model.filepolicy.f.a.values().contains(((PolicyModel) r6).getPointKey()) == true) goto L15;
            r4.add(r6);
            goto L12
        L15:
            r3.add(r6);
            goto L12
        L17:
            Pair r7 = new Pair(r3, r4);
            List<PolicyModel> r8 = (List) r7.component1();
            List<PolicyModel> r9 = (List) r7.component2();
            int r10 = ScsLogger.a;
            ScsLogger.d("SecurityPolicy_HandleInvalidDataInterceptor", "flush NoCacheRetry batch, total:" + r2.size() + ", policyEngine:" + r9.size() + ", dlp:" + r8.size());
            r0.f(r9);
            r0.f(r8);
            return;
        L30:
            return;
        L19:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public HandleInvalidDataInterceptor(q r2) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
        this.a = r2;
        this.b = new l();
        this.c = new Object();
        this.d = new LinkedHashMap();
        this.e = LazyKt.lazy(HandleInvalidDataInterceptor$noCacheRetryHandler$2.INSTANCE);
        this.g = new b(this);
    }

    public static List c(PolicyModel r10) {
        DecisionData.Action r0 = new DecisionData.Action();
        r0.setName("FILE_BLOCK_COMMON");
        r0.setParams(MapsKt.mapOf(new Pair[]{new Pair("entity_operation", r10.getEntity().getEntityOperate()), new Pair("file_biz_domain", r10.getEntity().getEntityDomain().getDomainName())}));
        DecisionData.Action r2 = new DecisionData.Action();
        r2.setName("BLOCKED_BY_IP_STRICT_POLICY");
        r2.setParams(MapsKt.mapOf(new Pair[]{new Pair("entity_operation", r10.getEntity().getEntityOperate()), new Pair("file_biz_domain", r10.getEntity().getEntityDomain().getDomainName()), new Pair("policyType", "FILE_PROTECT")}));
        return CollectionsKt.listOf(new DecisionData.Action[]{r0, r2});
    }

    @Override // i8b.n
    public final com.ss.android.lark.conditional.access.auth.v2.c a(g r21) {
        Intrinsics.checkNotNullParameter(r21, "chain");
        PolicyModel r2 = r21.c;
        com.ss.android.lark.conditional.access.auth.v2.c r0 = r21.a(r2);
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.c == true) goto L23;
        if (r0.e() == true) goto L11;
        if (r0.k() == false) goto L11;
        if (r0.h() == ResultType.ERROR) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L40;
        com.ss.android.lark.storage.kv.repo.a r4 = y.a;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.a == true) goto L18;
    L38:
        r3 = false;
        goto L40
    L18:
        if (Intrinsics.areEqual(r2.getPointKey(), "PointKey_IM_MSG_FILE_READ") == false) goto L38;
        if (r0.j() == true) goto L38;
    L39:
        r3 = true;
    L40:
        long r6 = 0;
        if (r3 == false) goto L67;
        l r5 = this.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r2, "model");
        if (idb.f.a().isEnable("lark.security.android_disable_policy_req_opt") == false) goto L45;
        boolean r7 = true;
    L57:
        if (r7 == false) goto L67;
        if (w4c.c.a().k() == false) goto L61;
        ScsLogger.d("SecurityPolicy_HandleInvalidDataInterceptor", "data is invalid or result is ERROR, notify NoCacheRetry immediately");
        f(CollectionsKt.listOf(r2));
    L62:
        this.b.a(r2);
        goto L67
    L61:
        ScsLogger.d("SecurityPolicy_HandleInvalidDataInterceptor", "data is invalid or result is ERROR, enqueue NoCacheRetry");
        e(r2);
        goto L62
    L45:
        Object r8 = r5.a;
        monitor-enter(r8);
        Long r9 = r5.b.get(r2.getTaskId());     // Catch: Throwable -> L63
        if (r9 == null) goto L50;
        long r10 = r9.longValue();     // Catch: Throwable -> L63
    L51:
        if ((System.currentTimeMillis() - r10) <= 2000) goto L55;
        r7 = true;
    L56:
        monitor-exit(r8);
        goto L57
    L55:
        r7 = false;
        goto L56
    L50:
        r10 = 0;
    L63:
        th = move-exception;
        throw th;
    L67:
        if (r0.h() != ResultType.ERROR) goto L77;
        r0 = this.a.a(r2);
        FileAuthMonitor.UpdateTrigger[] r11 = FileAuthMonitor.a;
        Intrinsics.checkNotNullParameter(r2, "policyModel");
        PolicyEntityWithBizDomain r12 = r2.getEntity();
        if ((r12 instanceof PolicyEntityWithBizDomain) == false) goto L71;
        String r13 = r12.getFileBizDomain().getBiz();
    L72:
        String r14 = u4c.a.a;
        u4c.a.a("scs_security_policy_no_cache_downgrade", MapsKt.mapOf(new Pair[]{TuplesKt.to("operation", r2.getEntity().getEntityOperate()), TuplesKt.to("entityType", r2.getEntity().getEntityType()), TuplesKt.to("entityDomain", r2.getEntity().getEntityDomain()), TuplesKt.to("pointKey", r2.getPointKey()), TuplesKt.to("fileBizDomain", r13), TuplesKt.to("networkAvailable", Boolean.valueOf(NetworkUtils.d(LarkContext.getApplication())))}), null, null, 0, 28);
        if (idb.f.a().isEnable("lark.security.file_ip_disconnect_deny") == true) goto L75;
    L89:
        return r0;
    L75:
        if (d(r0, r2) == false) goto L89;
        Log.i("SecurityPolicy_HandleInvalidDataInterceptor", "sync check with ip limit cache " + r2.getTaskId());
        r0.l(c(r2));
        r0.s(ResultType.DENY);
        r0.r(ValidateResultSource.DOWNGRADE);
        goto L89
    L71:
        r13 = BuildConfig.FLAVOR;
        goto L72
    L77:
        String r15 = r2.getTaskId();
        if (this.a.i().keySet().contains(r15) == false) goto L89;
        i r16 = this.a.i().get(r15);
        if (r16 == null) goto L89;
        if (r16.a == false) goto L89;
        if (r16.b == null) goto L89;
        long r17 = System.currentTimeMillis();
        Long r18 = r16.b;
        if (r18 == null) goto L88;
        r6 = r18.longValue();
    L88:
        FileAuthMonitor.UpdateTrigger[] r19 = FileAuthMonitor.a;
        Intrinsics.checkNotNullParameter(r2, "policyModel");
        String r20 = u4c.a.a;
        u4c.a.a("scs_security_policy_hit_delay_clear_cache", MapsKt.mapOf(new Pair[]{TuplesKt.to("operation", r2.getEntity().getEntityOperate()), TuplesKt.to("entityType", r2.getEntity().getEntityType()), TuplesKt.to("entityDomain", r2.getEntity().getEntityDomain()), TuplesKt.to("pointKey", r2.getPointKey())}), MapsKt.mapOf(TuplesKt.to("delay_duration", Long.valueOf((r17 - r6) / ((long) 1000)))), null, 0, 24);
    L11:
        if (Intrinsics.areEqual(r2.getPointKey(), "PointKey_IM_MSG_FILE_READ") == true) goto L13;
        r3 = true;
        goto L14
    L23:
        if (Intrinsics.areEqual(r2.getPointKey(), "PointKey_IM_MSG_FILE_READ") == false) goto L32;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.b == true) goto L32;
        com.ss.android.lark.storage.kv.repo.a r22 = y.a;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.a == false) goto L38;
        if (r0.j() == true) goto L38;
    L32:
        if (r0.e() == true) goto L39;
        if (r0.k() == false) goto L39;
        if (r0.h() != ResultType.ERROR) goto L38;
        goto L38
    }

    public final void e(PolicyModel r5) {
        Object r0 = this.c;
        monitor-enter(r0);
        this.d.put(r5.getTaskId(), r5);     // Catch: Throwable -> L10
        if (this.f == true) goto L7;
        this.f = true;     // Catch: Throwable -> L10
        ((Handler) this.e.getValue()).postDelayed(this.g, 1000);     // Catch: Throwable -> L10
    L7:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void f(List<PolicyModel> r7) {
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        this.a.c(new i8b.c(new i8b.b(new FileAuthMonitor.a(FileAuthMonitor.UpdateTrigger.NoCacheRetry, null), r7)));
    }

    @Override // i8b.n
    public final Object b(com.ss.android.lark.conditional.access.auth.v2.service.chain.a r10, Continuation r11) {
        if ((r11 instanceof HandleInvalidDataInterceptor$intercept$1) == false) goto L7;
        HandleInvalidDataInterceptor$intercept$1 r0 = (HandleInvalidDataInterceptor$intercept$1) r11;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        List<PolicyModel> r13 = (List) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L18:
        Map r14 = (Map) r12;
        if (idb.f.a().isEnable("lark.security.file_ip_disconnect_deny") == false) goto L38;
        LinkedHashMap r4 = new LinkedHashMap(MapsKt.mapCapacity(r14.size()));
        Iterator r15 = r14.entrySet().iterator();
    L22:
        if (r15.hasNext() == false) goto L37;
        Map.Entry r5 = (Map.Entry) r15.next();
        Object r6 = r5.getKey();
        com.ss.android.lark.conditional.access.auth.v2.c r7 = (com.ss.android.lark.conditional.access.auth.v2.c) r5.getValue();
        Iterator<T> r8 = r13.iterator();
    L25:
        if (r8.hasNext() == false) goto L29;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((PolicyModel) r9).getTaskId(), r5.getKey()) == false) goto L25;
    L30:
        PolicyModel r16 = (PolicyModel) r9;
        if (r16 == null) goto L36;
        if (d(r7, r16) == false) goto L36;
        Log.i("SecurityPolicy_HandleInvalidDataInterceptor", "handle async check ip limit result: " + r13);
        r7.l(c(r16));
        r7.s(ResultType.DENY);
        r7.r(ValidateResultSource.DOWNGRADE);
    L36:
        r4.put(r6, r7);
        goto L22
    L29:
        r9 = null;
        goto L30
    L37:
        return r4;
    L38:
        return r14;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        List<PolicyModel> r17 = r10.c;
        r0.L$0 = r17;
        r0.label = 1;
        Object r18 = r10.a(r17, r0);
        if (r18 != r2) goto L17;
        return r2;
    L17:
        r12 = r18;
        r13 = r17;
    L7:
        r0 = new HandleInvalidDataInterceptor$intercept$1(this, r11);
        goto L8
    }

    public final boolean d(com.ss.android.lark.conditional.access.auth.v2.c r4, PolicyModel r5) {
        boolean r1 = true;
        boolean r0 = !NetworkUtils.d(LarkContext.getApplication());
        if (r4.g() != ValidateResultSource.DOWNGRADE) goto L8;
        if (r0 == false) goto L8;
        if (this.a.f(r5) == false) goto L8;
    L9:
        int r6 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_HandleInvalidDataInterceptor", "checkResultShouldDenyByIp network: " + r0 + ", result " + r1);
        return r1;
    L8:
        r1 = false;
        goto L9
    }
}
