package com.ss.android.lark.conditional.access.auth.v2.service;

import android.os.Build;
import android.os.Looper;
import android.util.LruCache;
import com.bytedance.lark.policy.model.ResponseType;
import com.bytedance.lark.policy.model.b0;
import com.google.gson.Gson;
import com.ss.android.lark.conditional.access.auth.v2.SecurityPolicyAuthManager;
import com.ss.android.lark.conditional.access.auth.v2.SenderTenantMap;
import com.ss.android.lark.conditional.access.auth.v2.o;
import com.ss.android.lark.conditional.access.auth.v2.p;
import com.ss.android.lark.conditional.access.auth.v2.r;
import com.ss.android.lark.conditional.access.auth.v2.u;
import com.ss.android.lark.conditional.access.auth.v2.x;
import com.ss.android.lark.conditional.access.auth.v2.y;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateLogInfo;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.e0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import i8b.s;
import i8b.v;
import i8b.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PolicyCacheService extends i8b.m {
    public HashMap<String, com.ss.android.lark.conditional.access.auth.v2.d> b;
    public final HashMap<String, LruCache<String, com.ss.android.lark.conditional.access.auth.v2.d>> c;
    public HashMap<Long, Boolean> d;
    public String e;
    public final Lazy f;
    public final Lazy g;
    public final List<String> h;
    public final List<String> i;

    public static final class a {
    }

    static {
    }

    @Override // i8b.a
    public final void a() {
    }

    public final void i() {
        com.ss.android.lark.storage.kv.repo.a r0 = y.a;
        Function1<SenderTenantMap, Unit> r1 = new PolicyCacheService$readSenderTenantIdMap$1(this);
        Intrinsics.checkNotNullParameter(r1, "onResult");
        y.g.execute(new r(r1));
        Iterator r2 = com.ss.android.lark.security.compliance.api.model.filepolicy.f.a.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        final String r3 = (String) r2.next();
        com.ss.android.lark.storage.kv.repo.a r4 = y.a;
        Function1<Map<String, ? extends com.ss.android.lark.conditional.access.auth.v2.d>, Unit> r5 = new PolicyCacheService$loadDynamicData$1$1(this, r3);
        Intrinsics.checkNotNullParameter(r3, "pointKey");
        Intrinsics.checkNotNullParameter(r5, "onResult");
        y.g.execute(new o(r3, r5));
        goto L4
    L6:
        Iterator r6 = com.ss.android.lark.security.compliance.api.model.filepolicy.f.b.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        final String r7 = (String) r6.next();
        com.ss.android.lark.storage.kv.repo.a r8 = y.a;
        Function1<Map<String, ? extends com.ss.android.lark.conditional.access.auth.v2.d>, Unit> r9 = new PolicyCacheService$loadDynamicData$2$1(this, r7);
        Intrinsics.checkNotNullParameter(r7, "pointKey");
        Intrinsics.checkNotNullParameter(r9, "onResult");
        y.g.execute(new o(r7, r9));
        goto L8
    L10:
        com.ss.android.lark.storage.kv.repo.a r10 = y.a;
        if (y.b() == false) goto L13;
        int r11 = w4c.c.a().v().a();
    L14:
        Function1<LruCache<String, com.ss.android.lark.conditional.access.auth.v2.d>, Unit> r12 = new PolicyCacheService$loadDynamicData$3(this);
        Intrinsics.checkNotNullParameter(r12, "onResult");
        if (y.b() == false) goto L19;
        int r13 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "getLatestImFileReadResult() V2, size:" + r11);
        com.ss.android.lark.conditional.access.auth.v2.j r14 = y.h;
        if (r14 == null) goto L26;
        Intrinsics.checkNotNullParameter(r12, "onResult");
        r14.c.execute(new com.ss.android.lark.conditional.access.auth.v2.h(r11, r14, r12));
        return;
    L26:
        return;
    L19:
        int r15 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "getLatestImFileReadResult() V1, size:" + r11);
        if (y.b == null) goto L22;
        y.g.execute(new p(r11, r12));
        return;
    L22:
        r12.invoke(new LruCache(r11));
        return;
    L13:
        r11 = w4c.c.a().i0();
        goto L14
    }

    public PolicyCacheService(SecurityPolicyAuthManager r2) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
        super(r2);
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = BuildConfig.FLAVOR;
        this.f = LazyKt.lazy(PolicyCacheService$debugMode$2.INSTANCE);
        this.g = LazyKt.lazy(PolicyCacheService$devMode$2.INSTANCE);
        this.h = CollectionsKt.plus(com.ss.android.lark.security.compliance.api.model.filepolicy.f.b, w4c.c.a().q0());
        this.i = w4c.c.a().h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r24) {
        Intrinsics.checkNotNullParameter(r24, "event");
        String r4 = "SecurityPolicy_PolicyCacheService";
        if ((r24 instanceof w) == false) goto L141;
        ArrayList<String> r2 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_PolicyCacheService", "handleEvent ValidateUpdateEvent.", false);
        v r1 = (v) ((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((w) r24)).a;
        List<PolicyModel> r3 = r1.a;
        Map<String, b0> r6 = r1.b;
        FileAuthMonitor.a r5 = r1.c;
        Intrinsics.checkNotNullParameter(r3, "models");
        Intrinsics.checkNotNullParameter(r6, "resultMap");
        Intrinsics.checkNotNullParameter(r5, "updateInfo");
        ArrayList r7 = new ArrayList();
        ArrayList r8 = new ArrayList();
        Iterator r9 = r3.iterator();
        boolean r10 = false;
    L5:
        boolean r11 = true;
        if (r9.hasNext() == false) goto L127;
        PolicyModel r12 = (PolicyModel) r9.next();
        String r13 = r12.getPointKey();
        String r14 = r12.getTaskId();
        b0 r15 = r6.get(r14);
        if (r15 != null) goto L10;
    L125:
        FileAuthMonitor.a r22 = r5;
        Iterator r17 = r9;
        String r19 = r4;
        Map<String, b0> r18 = r6;
        r7 = r7;
    L126:
        r9 = r17;
        r6 = r18;
        r4 = r19;
        r7 = r7;
        r5 = r22;
        goto L5
    L10:
        if (com.ss.android.lark.conditional.access.auth.v2.b.a.contains(r12.getPointKey()) == true) goto L125;
        if (r15.c() != null) goto L125;
        if (com.bytedance.lark.policy.utils.d.a(r15) == true) goto L125;
        boolean r110 = r15.f();
        String r111 = r15.e();
        ResponseType r112 = r15.getType();
        int r16 = com.ss.android.lark.conditional.access.utils.e.a;
        com.ss.android.lark.conditional.access.auth.v2.d r20 = new com.ss.android.lark.conditional.access.auth.v2.d(r110, r111, r112, com.ss.android.lark.conditional.access.utils.e.d(r15.a()), r15.d(), qqb.a.d());
        if (com.ss.android.lark.conditional.access.auth.v2.b.d.contains(r13) == false) goto L32;
        PolicyModel.a r113 = r12.getConfig();
        if (r113 != null) goto L20;
    L22:
        boolean r114 = false;
    L23:
        if (r114 == true) goto L32;
        com.ss.android.lark.conditional.access.auth.v2.d r115 = this.b.put(r14, r20);
        if (r115 != null) goto L27;
    L29:
        r11 = false;
    L30:
        if (r11 == true) goto L125;
        r7.add(r13);
        goto L125
    L27:
        if (r115.b() != r20.b()) goto L29;
    L20:
        if (r113.a != true) goto L22;
        r114 = true;
    L32:
        com.ss.android.lark.conditional.access.auth.v2.d r116 = l(r12, r20);
        if (r116 == null) goto L37;
        r17 = r9;
        if (r116.b() != r20.b()) goto L38;
        boolean r21 = true;
    L39:
        if (r21 == true) goto L42;
        r7.add(r13);
    L42:
        if (this.i.contains(r12.getPointKey()) == false) goto L73;
        Intrinsics.checkNotNullParameter(r15, "<this>");
        List r23 = r15.a();
        if (r23 == null) goto L58;
        Iterator r25 = r23.iterator();
    L47:
        if (r25.hasNext() == false) goto L52;
        Object r117 = r25.next();
        Iterator r118 = r25;
        r18 = r6;
        if (Intrinsics.areEqual(((com.bytedance.lark.policy.model.a) r117).a(), "ACCESS_CONTROL_ACTION_COMMON") == true) goto L53;
        r6 = r18;
        r25 = r118;
    L53:
        com.bytedance.lark.policy.model.a r119 = (com.bytedance.lark.policy.model.a) r117;
        if (r119 == null) goto L59;
        Map r26 = r119.b();
        if (r26 == null) goto L59;
        String r27 = (String) r26.get("decisionCacheTTL");
    L61:
        if ((r27 instanceof Number) == false) goto L63;
        Long r28 = Long.valueOf(((Number) r27).longValue());
    L66:
        if (r28 != null) goto L68;
    L74:
        r28 = null;
    L75:
        String r29 = r12.getPointKey();
        r19 = r4;
        if (Intrinsics.areEqual(r29, "PointKey_IM_MSG_FILE_READ") == false) goto L111;
        if (r28 == null) goto L79;
        r22 = r5;
        r20.h(Long.valueOf(System.currentTimeMillis() + (r28.longValue() * ((long) 1000))));
    L85:
        com.ss.android.lark.storage.kv.repo.a r30 = y.a;
        Intrinsics.checkNotNullParameter(r14, "key");
        Intrinsics.checkNotNullParameter(r20, Keys.API_RETURN_KEY_DATA);
        if (y.b() == false) goto L90;
        int r31 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "saveDynamicResult() V2, key:" + r14 + ", data:" + com.ss.android.lark.security.compliance.infra.util.f.c(r20));
        com.ss.android.lark.conditional.access.auth.v2.j r32 = y.h;
        if (r32 == null) goto L91;
        Intrinsics.checkNotNullParameter(r14, "key");
        Intrinsics.checkNotNullParameter(r20, Keys.API_RETURN_KEY_DATA);
        r32.c.execute(new com.ss.android.lark.conditional.access.auth.v2.i(r20, r32, r14));
    L91:
        IMFileEntity r33 = r12.getEntity();
        if ((r33 instanceof IMFileEntity) == false) goto L94;
        IMFileEntity r34 = r33;
    L95:
        if (r34 == null) goto L97;
        Long r120 = r34.getSenderTenantId();
    L98:
        boolean r35 = r15.f();
        if (r120 == null) goto L110;
        Boolean r36 = this.d.get(r120);
        if (r36 != null) goto L104;
        this.d.put(r120, Boolean.valueOf(r35));
        goto L110
    L104:
        HashMap<Long, Boolean> r37 = this.d;
        if (r36.booleanValue() == false) goto L108;
        if (r35 == false) goto L108;
        boolean r38 = true;
    L109:
        r37.put(r120, Boolean.valueOf(r38));
    L108:
        r38 = false;
    L110:
        r10 = true;
        goto L126
    L97:
        r120 = null;
        goto L98
    L94:
        r34 = null;
        goto L95
    L90:
        int r39 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "saveDynamicResult() V1, key:" + r14 + ", data:" + com.ss.android.lark.security.compliance.infra.util.f.c(r20));
        y.g.execute(new com.ss.android.lark.conditional.access.auth.v2.v(r14, r20));
        goto L91
    L79:
        r22 = r5;
        com.ss.android.lark.storage.kv.repo.a r40 = y.a;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.a == false) goto L85;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.b == true) goto L85;
        r20.h(Long.valueOf(System.currentTimeMillis() + (w4c.c.a().h0() * ((long) 1000))));
        goto L85
    L111:
        r22 = r5;
        r7 = r7;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.f.a.values().contains(r29) == false) goto L119;
        r20.h(Long.valueOf(System.currentTimeMillis() + (w4c.c.a().t() * ((long) 1000))));
        com.ss.android.lark.storage.kv.repo.a r41 = y.a;
        LruCache<String, com.ss.android.lark.conditional.access.auth.v2.d> r42 = this.c.get(r13);
        if (r42 == null) goto L116;
        Map<String, com.ss.android.lark.conditional.access.auth.v2.d> r43 = r42.snapshot();
    L117:
        Intrinsics.checkNotNullParameter(r13, "pointKey");
        y.g.execute(new u(r43, r13));
        r8.add(r116);
        goto L126
    L116:
        r43 = null;
        goto L117
    L119:
        if (this.h.contains(r29) == false) goto L126;
        com.ss.android.lark.storage.kv.repo.a r44 = y.a;
        LruCache<String, com.ss.android.lark.conditional.access.auth.v2.d> r45 = this.c.get(r13);
        if (r45 == null) goto L123;
        Map<String, com.ss.android.lark.conditional.access.auth.v2.d> r121 = r45.snapshot();
    L124:
        Intrinsics.checkNotNullParameter(r13, "pointKey");
        y.g.execute(new u(r121, r13));
        goto L126
    L123:
        r121 = null;
        goto L124
    L68:
        if (r28.longValue() <= 0) goto L70;
        boolean r46 = true;
    L71:
        if (r46 == false) goto L74;
    L70:
        r46 = false;
        goto L71
    L63:
        if (r27 == 0) goto L65;
        r28 = StringsKt.toLongOrNull(r27);
        goto L66
    L65:
        r28 = null;
    L59:
        r27 = 0;
        goto L61
    L52:
        r18 = r6;
        r117 = null;
        goto L53
    L58:
        r18 = r6;
        goto L59
    L73:
        r18 = r6;
    L38:
        r21 = false;
        goto L39
    L37:
        r17 = r9;
        goto L38
    L127:
        FileAuthMonitor.a r210 = r5;
        String r122 = r4;
        ArrayList r211 = r7;
        ArrayList r47 = new ArrayList();
        Iterator r48 = r8.iterator();
    L129:
        if (r48.hasNext() == false) goto L136;
        com.ss.android.lark.conditional.access.auth.v2.d r49 = (com.ss.android.lark.conditional.access.auth.v2.d) r48.next();
        if (r49 == null) goto L133;
        ValidateLogInfo r50 = com.ss.android.lark.conditional.access.auth.v2.g.b(r49);
    L134:
        if (r50 == null) goto L129;
        r47.add(r50);
        goto L129
    L133:
        r50 = null;
        goto L134
    L136:
        c(new i8b.j(r47));
        if ((!r211.isEmpty()) == false) goto L139;
        c(new i8b.i(new i8b.h(r211, r210)));
    L139:
        j(r10);
        ScsLogger.d(r122, "[end update auth result]");
        return;
    L141:
        if ((r24 instanceof s) == false) goto L169;
        List r51 = (List) ((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((s) r24)).a;
        int r52 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyCacheService", "removeResult, taskIDs size is " + r51.size());
        Iterator r53 = r51.iterator();
    L144:
        if (r53.hasNext() == false) goto L148;
        String r54 = (String) r53.next();
        this.b.remove(r54);
        String r55 = com.ss.android.lark.security.compliance.api.model.filepolicy.h.k(r54);
        if (r55 == null) goto L144;
        this.c.put(r55, new LruCache(w4c.c.a().l0()));
        com.ss.android.lark.storage.kv.repo.a r56 = y.a;
        Map r57 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r55, "pointKey");
        y.g.execute(new u(r57, r55));
        goto L144
    L148:
        j(false);
        return;
    }

    @Override // i8b.m
    public final com.ss.android.lark.conditional.access.auth.v2.c f(PolicyModel r13) {
        Intrinsics.checkNotNullParameter(r13, "policyModel");
        IMFileEntity r14 = r13.getEntity();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity");
        Long r15 = r14.getSenderTenantId();
        if (Intrinsics.areEqual(this.d.get(r15), Boolean.FALSE) == false) goto L6;
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.DENY, ValidateResultSource.FALLBACK, null, null, 1016);
    L6:
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.FALLBACK, null, null, 1016);
    }

    @Override // i8b.m
    public final void h(List<PolicyModel> r6) {
        Intrinsics.checkNotNullParameter(r6, "policyModels");
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyCacheService", "removeCaches, policyModels size is " + ((ArrayList) r6).size());
        Iterator<T> r7 = r6.iterator();
    L3:
        boolean r1 = false;
        if (r7.hasNext() == false) goto L15;
        PolicyModel r2 = (PolicyModel) r7.next();
        String r3 = r2.getTaskId();
        if (com.ss.android.lark.conditional.access.auth.v2.b.d.contains(r2.getPointKey()) == false) goto L14;
        PolicyModel.a r4 = r2.getConfig();
        if (r4 != null) goto L10;
    L12:
        if (r1 == true) goto L14;
        this.b.remove(r3);
        goto L3
    L10:
        if (r4.a != true) goto L12;
        r1 = true;
    L14:
        k(r2.getPointKey(), r3);
        goto L3
    L15:
        j(false);
    }

    public final void j(boolean r4) {
        com.ss.android.lark.conditional.access.auth.v2.k r0 = new com.ss.android.lark.conditional.access.auth.v2.k(this.b);
        if (Intrinsics.areEqual(this.e, BuildConfig.FLAVOR) == true) goto L11;
        com.ss.android.lark.storage.kv.repo.a r1 = y.a;
        Intrinsics.checkNotNullParameter(r0, Keys.API_RETURN_KEY_DATA);
        com.ss.android.lark.storage.kv.repo.a r2 = y.a;
        if (r2 == null) goto L7;
        r2.putJSONObject("FilePolicyValidateResult", r0);
    L7:
        ArrayList<String> r3 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_PolicyCacheService", "putMemoryIntoLocal() done", false);
        if (r4 == false) goto L12;
        SenderTenantMap r5 = new SenderTenantMap(this.d);
        Intrinsics.checkNotNullParameter(r5, "tenantMap");
        y.g.execute(new x(r5));
        return;
    L12:
        return;
    }

    @Override // i8b.a
    public final void d(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "tenantId");
        this.e = r3;
        HashMap<String, com.ss.android.lark.conditional.access.auth.v2.d> r5 = this.b;
        monitor-enter(r5);
        this.b.clear();     // Catch: Throwable -> L19
        this.c.clear();     // Catch: Throwable -> L19
        ArrayList<String> r6 = com.ss.android.lark.conditional.access.utils.c.a;     // Catch: Throwable -> L19
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_PolicyCacheService", "loadLocalData(), old data clear", false);     // Catch: Throwable -> L19
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r5);
        com.ss.android.lark.storage.kv.repo.a r8 = y.a;
        if (r8 == null) goto L9;
        com.ss.android.lark.conditional.access.auth.v2.k r9 = (com.ss.android.lark.conditional.access.auth.v2.k) r8.getJSONObject("FilePolicyValidateResult", com.ss.android.lark.conditional.access.auth.v2.k.class);
    L10:
        if (r9 != null) goto L12;
    L14:
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_PolicyCacheService", "loadLocalData(), update curUid static data complete", false);
        if (Build.VERSION.SDK_INT < 23) goto L17;
        Looper.getMainLooper().getQueue().addIdleHandler(new l(this));
        return;
    L17:
        i();
        return;
    L12:
        if (r9.a() == null) goto L14;
        this.b = r9.a();
        goto L14
    L9:
        r9 = null;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // i8b.m
    public final com.ss.android.lark.conditional.access.auth.v2.e e(PolicyModel r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "policyModel");
        String r0 = r8.getTaskId();
        String r2 = null;
        if (com.ss.android.lark.conditional.access.auth.v2.b.d.contains(r8.getPointKey()) == false) goto L12;
        PolicyModel.a r1 = r8.getConfig();
        if (r1 == null) goto L9;
        boolean r3 = true;
        if (r1.a != true) goto L9;
    L10:
        if (r3 == true) goto L12;
        com.ss.android.lark.conditional.access.auth.v2.d r10 = this.b.get(r0);
        String r11 = "StaticCache";
    L47:
        if (r10 == null) goto L49;
        int r4 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyCacheService", "[cacheType:" + r11 + "], [hitCache:True], [traceId:" + r10.e() + ']');
    L50:
        if (r10 == null) goto L53;
        r2 = r11;
    L53:
        return new com.ss.android.lark.conditional.access.auth.v2.e(r10, r2);
    L49:
        int r5 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyCacheService", "[cacheType:" + r11 + "], [hitCache:False]");
    L9:
        r3 = false;
    L12:
        LruCache<String, com.ss.android.lark.conditional.access.auth.v2.d> r6 = this.c.get(r8.getPointKey());
        if (r6 == null) goto L15;
        com.ss.android.lark.conditional.access.auth.v2.d r7 = r6.get(r0);
    L16:
        if (r7 != null) goto L44;
        if (r9 == true) goto L44;
        if (Intrinsics.areEqual(r8.getPointKey(), "PointKey_IM_MSG_FILE_READ") == false) goto L44;
        com.ss.android.lark.storage.kv.repo.a r12 = y.a;
        Intrinsics.checkNotNullParameter(r0, "key");
        if (y.b() == false) goto L34;
        com.ss.android.lark.conditional.access.auth.v2.j r13 = y.h;
        if (r13 == null) goto L32;
        Intrinsics.checkNotNullParameter(r0, "key");
        x4c.g r14 = r13.a();
        Intrinsics.checkNotNullParameter(r0, "key");
        x4c.f r15 = (x4c.f) ((HashMap) r14.c).get(r0);
        if (r15 == null) goto L27;
        r15.d = System.currentTimeMillis();
        r14.b.b(r15);
        String r16 = r15.c;
    L31:
        Gson r17 = e0.a;
        com.ss.android.lark.conditional.access.auth.v2.d r18 = (com.ss.android.lark.conditional.access.auth.v2.d) e0.a(r16, com.ss.android.lark.conditional.access.auth.v2.d.class);
    L33:
        int r19 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "getDynamicResult() V2, key:" + r0 + ", data:" + com.ss.android.lark.security.compliance.infra.util.f.c(r18));
    L39:
        if (r18 != null) goto L41;
    L43:
        r10 = r18;
    L45:
        r11 = "LRUCache";
        goto L47
    L41:
        if (r18.c() == true) goto L43;
        l(r8, r18);
        goto L43
    L27:
        x4c.f r20 = r14.b.a(r0);
        if (r20 == null) goto L30;
        r20.d = System.currentTimeMillis();
        r14.b.b(r20);
        ((HashMap) r14.c).put(r0, r20);
        r16 = r20.c;
        goto L31
    L30:
        r16 = null;
        goto L31
    L32:
        r18 = null;
        goto L33
    L34:
        com.ss.android.lark.storage.kv.repo.a r21 = y.b;
        if (r21 == null) goto L37;
        r18 = (com.ss.android.lark.conditional.access.auth.v2.d) r21.getJSONObject(r0, com.ss.android.lark.conditional.access.auth.v2.d.class);
    L38:
        int r22 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "getDynamicResult() V1, key:" + r0 + ", data:" + com.ss.android.lark.security.compliance.infra.util.f.c(r18));
        goto L39
    L37:
        r18 = null;
    L44:
        r10 = r7;
        goto L45
    L15:
        r7 = null;
        goto L16
    }

    public final void k(String r5, String r6) {
        if (Intrinsics.areEqual(r5, "PointKey_IM_MSG_FILE_READ") == false) goto L10;
        LruCache<String, com.ss.android.lark.conditional.access.auth.v2.d> r7 = this.c.get(r5);
        if (r7 == null) goto L9;
        com.ss.android.lark.conditional.access.auth.v2.d r8 = r7.get(r6);
        if (r8 == null) goto L9;
        r8.h(Long.valueOf(System.currentTimeMillis() - 1));
    L9:
        com.ss.android.lark.storage.kv.repo.a r9 = y.a;
        Intrinsics.checkNotNullParameter(r6, "key");
        y.g.execute(new com.ss.android.lark.conditional.access.auth.v2.s(r6));
        return;
    L10:
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyCacheService", "removeDynamicCache skipped, pointKey: " + r5 + ", taskID: " + r6);
    }

    public final com.ss.android.lark.conditional.access.auth.v2.d l(PolicyModel r7, com.ss.android.lark.conditional.access.auth.v2.d r8) {
        if (w4c.c.a().j() == false) goto L5;
        return null;
    L5:
        String r0 = r7.getTaskId();
        if (this.c.get(r7.getPointKey()) == null) goto L8;
    L17:
        LruCache<String, com.ss.android.lark.conditional.access.auth.v2.d> r9 = this.c.get(r7.getPointKey());
        if (r9 != null) goto L20;
        return null;
    L20:
        return r9.put(r0, r8);
    L8:
        if (Intrinsics.areEqual(r7.getPointKey(), "PointKey_IM_MSG_FILE_READ") == false) goto L15;
        com.ss.android.lark.storage.kv.repo.a r2 = y.a;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.a == true) goto L12;
    L14:
        int r3 = w4c.c.a().l0();
    L16:
        this.c.put(r7.getPointKey(), new LruCache(r3));
        goto L17
    L12:
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.b == true) goto L14;
        r3 = w4c.c.a().i0();
        goto L16
    L15:
        r3 = w4c.c.a().l0();
        goto L16
    }

    @Override // i8b.m
    public final void g(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "taskID");
        Intrinsics.checkNotNullParameter(r4, "cacheType");
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyCacheService", "removeCache, taskID is " + r3 + ", cacheType is " + r4 + ", pointKey is " + r5);
        if (Intrinsics.areEqual(r4, "StaticCache") == false) goto L6;
        this.b.remove(r3);
        j(false);
        return;
    L6:
        k(r5, r3);
        j(false);
    }
}
