package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.lark.policy.decision.PolicyDecision;
import com.bytedance.lark.policy.model.ValidateRequest;
import com.bytedance.lark.policy.model.b0;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import i8b.q;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PolicyValidateService extends i8b.a {
    public static final /* synthetic */ int c = 0;
    public String b;

    public static final class a {
    }

    static {
    }

    @Override // i8b.a
    public final void a() {
        CompositeDisposable r0 = j8b.d.a;
        j8b.d.a.clear();
    }

    public PolicyValidateService(q r2) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
        super(r2);
        this.b = BuildConfig.FLAVOR;
    }

    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        if ((r9 instanceof i8b.c) == false) goto L10;
        ScsLogger.d("SecurityPolicy_PolicyValidateService", "[start update auth result] BatchValidateEvent.");
        i8b.b r10 = (i8b.b) ((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((i8b.c) r9)).a;
        if (r10.b.isEmpty() == false) goto L8;
        ScsLogger.d("SecurityPolicy_PolicyValidateService", "data.validateModels isEmpty.");
        return;
    L8:
        String r0 = qqb.a.d();
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.a, Dispatchers.getIO(), null, new PolicyValidateService$handleEvent$1(r0, this, r10, null), 2, null);
        return;
    L10:
        if ((r9 instanceof i8b.e) == false) goto L13;
        ScsLogger.d("SecurityPolicy_PolicyValidateService", "[start update auth result] CCMDLPUpdateEvent.");
        String r1 = qqb.a.d();
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.a, Dispatchers.getIO(), null, new PolicyValidateService$handleEvent$2(r1, this, r9, null), 2, null);
        return;
    L13:
        if ((r9 instanceof i8b.g) == false) goto L18;
        ScsLogger.d("SecurityPolicy_PolicyValidateService", "[start update auth result] CCMFileProtectUpdateEvent.");
        String r2 = qqb.a.d();
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.a, Dispatchers.getIO(), null, new PolicyValidateService$handleEvent$3(r2, this, r9, null), 2, null);
        return;
    }

    @Override // i8b.a
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "tenantId");
        this.b = r2;
    }

    public final Object e(List<PolicyModel> r22, final FileAuthMonitor.a r23, Continuation<? super Map<String, b0>> r24) {
        List<PolicyModel> r0 = r22;
        if ((r24 instanceof PolicyValidateService$policyValidateWithCoroutine$1) == false) goto L7;
        PolicyValidateService$policyValidateWithCoroutine$1 r3 = (PolicyValidateService$policyValidateWithCoroutine$1) r24;
        int r4 = r3.label;
        if ((r4 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r3.label = r4 - PluginList.LEVEL_NOT_SET;
    L8:
        PolicyValidateService$policyValidateWithCoroutine$1 r9 = r3;
        Object r2 = r9.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r9.label;
        String r13 = BuildConfig.FLAVOR;
        String r15 = "SecurityPolicy_PolicyValidateService";
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        Map r1 = (Map) r9.L$1;
        String r6 = (String) r9.L$0;
        ResultKt.throwOnFailure(r2);
        String r19 = BuildConfig.FLAVOR;
        String r11 = "SecurityPolicy_PolicyValidateService";
    L84:
        String r14 = qqb.a.d();     // Catch: Throwable -> L69
        qqb.a.f(r6);     // Catch: Throwable -> L67
        ScsLogger.d(r11, "end policyValidateWithCoroutine.");     // Catch: Throwable -> L67
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r14, "traceId");
        qqb.a.g(r14);
        return r1;
    L67:
        th = th;
    L71:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r14, "traceId");
        qqb.a.g(r14);
        throw th;
    L69:
        th = th;
        r14 = r19;
        goto L71
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r7 = (String) r9.L$4;
        Map r8 = (Map) r9.L$3;
        String r12 = (String) r9.L$2;
        FileAuthMonitor.a r16 = (FileAuthMonitor.a) r9.L$1;
        List<PolicyModel> r17 = (List) r9.L$0;
        ResultKt.throwOnFailure(r2);
        String r18 = r7;
        String r110 = r12;
        FileAuthMonitor.a r20 = r16;
        r0 = r17;
        r19 = BuildConfig.FLAVOR;
        r11 = "SecurityPolicy_PolicyValidateService";
    L43:
        Map r111 = (Map) r2;
        if (Intrinsics.areEqual(r18, this.b) == true) goto L47;
        ArrayList<String> r21 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b(r11, "asyncValidate return result, but validateUid != userId", false);
        return MapsKt.emptyMap();
    L47:
        ArrayList r25 = new ArrayList();
        Iterator<T> r26 = r0.iterator();
    L49:
        if (r26.hasNext() == false) goto L53;
        Object r27 = r26.next();
        if ((!com.ss.android.lark.conditional.access.auth.v2.b.a.contains(((PolicyModel) r27).getPointKey())) == false) goto L49;
        r25.add(r27);
        goto L49
    L53:
        LinkedHashMap r28 = new LinkedHashMap();
        Iterator r29 = r25.iterator();
    L55:
        if (r29.hasNext() == false) goto L59;
        PolicyModel r30 = (PolicyModel) r29.next();
        b0 r31 = (b0) r111.get(r30.getTaskId());
        if (r31 == null) goto L55;
        r28.put(r30.getTaskId(), r31);
        goto L55
    L59:
        PolicyValidateService$policyValidateWithCoroutine$4 r32 = new PolicyValidateService$policyValidateWithCoroutine$4(r110, this, r25, r28, r20, null);
        r9.L$0 = r110;
        r9.L$1 = r111;
        r9.L$2 = null;
        r9.L$3 = null;
        r9.L$4 = null;
        r9.label = 2;
        if (CoroutineScopeKt.coroutineScope(r32, r9) != r10) goto L62;
        return r10;
    L62:
        r6 = r110;
        r1 = r111;
        goto L84
    L16:
        ResultKt.throwOnFailure(r2);
        int r33 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyValidateService", "start policyValidateWithCoroutine, [updateTrigger:" + r23.a.name() + ']');
        String r34 = qqb.a.d();
        final long r35 = System.currentTimeMillis();
        LinkedHashMap r36 = new LinkedHashMap();
        Iterator r37 = r0.iterator();
    L18:
        if (r37.hasNext() == false) goto L24;
        PolicyModel r112 = (PolicyModel) r37.next();
        String r113 = r112.getTaskId();
        boolean r38 = this.a.h(r112);
        Iterator r114 = r37;
        String r115 = r13;
        JSONObject r39 = new JSONObject(com.ss.android.lark.security.compliance.infra.util.f.c(r112.getEntity()));
        if (w4c.c.a().E() == false) goto L23;
        r39.put("base", new JSONObject().put("GUARDIAN_EVALUATOR_OPTION", new JSONObject().put("IS_PRE_EVALUATE", true)));
    L23:
        r36.put(r113, new ValidateRequest("PC:CLIENT:android:" + r112.getPointKey(), r39, r38));
        r37 = r114;
        r10 = r10;
        r13 = r115;
        r15 = r15;
        goto L18
    L24:
        Object r116 = r10;
        r19 = r13;
        String r210 = r15;
        this.a.g(r0, r23.a);
        r18 = this.b;
        r9.L$0 = r0;
        r9.L$1 = r23;
        r9.L$2 = r34;
        r9.L$3 = r36;
        r9.L$4 = r18;
        r9.J$0 = r35;
        r9.label = 1;
        final SafeContinuation r40 = new SafeContinuation(IntrinsicsKt.intercepted(r9));
        String r117 = qqb.a.d();     // Catch: Throwable -> L75
        Intrinsics.checkNotNullParameter(r34, "traceId");     // Catch: Throwable -> L73
        qqb.a.g(r34);     // Catch: Throwable -> L73
        Iterator<T> r118 = r0.iterator();     // Catch: Throwable -> L73
    L28:
        if (r118.hasNext() == false) goto L32;
        Object r119 = r118.next();     // Catch: Throwable -> L73
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.f.a.values().contains(((PolicyModel) r119).getPointKey()) == false) goto L28;
    L33:
        if (r119 == null) goto L35;
        r11 = r210;
        ScsLogger.d(r11, "start invoke DLPEngine.getDLPResult");     // Catch: Throwable -> L73
        CompositeDisposable r41 = j8b.d.a;     // Catch: Throwable -> L73
        j8b.d.a(r0, new PolicyValidateService$policyValidateWithCoroutine$resultMap$1$1$2(r35, r23, r40));     // Catch: Throwable -> L73
    L36:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r117, "traceId");
        qqb.a.g(r117);
        Object r42 = r40.getOrThrow();
        if (r42 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L39;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L39:
        r10 = r116;
        if (r42 != r10) goto L42;
        return r10;
    L42:
        r20 = r23;
        r110 = r34;
        r2 = r42;
        goto L43
    L35:
        r11 = r210;
        ScsLogger.d(r11, "start invoke PolicyEngine.asyncValidate");     // Catch: Throwable -> L73
        Function1<Map<String, ? extends b0>, Unit> r120 = new PolicyValidateService$policyValidateWithCoroutine$resultMap$1$1$3(r35, r23, r40);     // Catch: Throwable -> L73
        ke6.d r43 = ke6.d.a;     // Catch: Throwable -> L73
        Intrinsics.checkNotNullParameter(r36, "requestMap");     // Catch: Throwable -> L73
        Intrinsics.checkNotNullParameter(r120, "callback");     // Catch: Throwable -> L73
        int r44 = PolicyDecision.a;     // Catch: Throwable -> L73
        PolicyDecision.c(r36, r120);     // Catch: Throwable -> L73
        goto L36
    L32:
        r119 = null;
    L73:
        th = th;
        String r121 = r117;
    L77:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r121, "traceId");
        qqb.a.g(r121);
        throw th;
    L75:
        th = th;
        r121 = r19;
    L7:
        r3 = new PolicyValidateService$policyValidateWithCoroutine$1(this, r24);
        goto L8
    }
}
