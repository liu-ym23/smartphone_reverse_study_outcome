package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.bytedance.lark.policy.model.ResponseType;
import com.bytedance.lark.policy.model.b0;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import i8b.n;
import i8b.q;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements n {
    public final q a;

    public c(q r2) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
        this.a = r2;
    }

    @Override // i8b.n
    public final com.ss.android.lark.conditional.access.auth.v2.c a(g r8) {
        Intrinsics.checkNotNullParameter(r8, "chain");
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    }

    @Override // i8b.n
    public final Object b(a r7, Continuation r8) {
        if ((r8 instanceof PolicyCheckInterceptor$intercept$1) == false) goto L7;
        PolicyCheckInterceptor$intercept$1 r0 = (PolicyCheckInterceptor$intercept$1) r8;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        String r10 = (String) r0.L$1;
        List<PolicyModel> r4 = (List) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L14
    L24:
        Map r11 = (Map) r9;     // Catch: Throwable -> L14
        qqb.a.a();
        qqb.a.f(r10);
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<T> r5 = r4.iterator();
    L27:
        if (r5.hasNext() == false) goto L51;
        PolicyModel r6 = (PolicyModel) r5.next();
        b0 r13 = (b0) r11.get(r6.getTaskId());
        if (r13 == null) goto L46;
        int r14 = com.ss.android.lark.conditional.access.utils.e.a;
        ResponseType r15 = r13.getType();
        if (r15 != null) goto L33;
        int r16 = -1;
    L34:
        if (r16 != 1) goto L36;
        ValidateResultSource r17 = ValidateResultSource.REMOTE_POLICY;
    L47:
        com.ss.android.lark.conditional.access.auth.v2.c r18 = com.ss.android.lark.conditional.access.auth.v2.b.a(r13, r17);
        if (Intrinsics.areEqual(r6.getPointKey(), "PointKey_CCM_OPEN_EXTERNAL_ACCESS_WITH_OBJECT") == false) goto L50;
        r18.u(CollectionsKt.emptyList());
    L50:
        r12.put(r6.getTaskId(), r18);
        goto L27
    L36:
        if (r16 != 2) goto L38;
        r17 = ValidateResultSource.LOCAL_POLICY;
        goto L47
    L38:
        if (r16 != 3) goto L40;
        r17 = ValidateResultSource.DOWNGRADE;
        goto L47
    L40:
        if (r16 == 4) goto L42;
        r17 = ValidateResultSource.OTHERS;
        goto L47
    L42:
        r17 = ValidateResultSource.FAST_PASS;
        goto L47
    L33:
        r16 = com.ss.android.lark.conditional.access.utils.e.a.a[r15.ordinal()];
        goto L34
    L46:
        r17 = ValidateResultSource.OTHERS;
        goto L47
    L51:
        return r12;
    L14:
        th = th;
        String r19 = r10;
    L57:
        qqb.a.a();
        qqb.a.f(r19);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r9);
        List<PolicyModel> r20 = r7.c;
        String r21 = r7.e;
        r19 = qqb.a.d();     // Catch: Throwable -> L55
        qqb.a.f(r21);     // Catch: Throwable -> L53
        q r22 = this.a;     // Catch: Throwable -> L53
        FileAuthMonitor.UpdateTrigger r23 = FileAuthMonitor.UpdateTrigger.BusinessCheck;     // Catch: Throwable -> L53
        r0.L$0 = r20;     // Catch: Throwable -> L53
        r0.L$1 = r19;     // Catch: Throwable -> L53
        r0.label = 1;     // Catch: Throwable -> L53
        Object r24 = r22.e(r20, r23, r0);     // Catch: Throwable -> L53
        if (r24 != r2) goto L23;
        return r2;
    L23:
        r4 = r20;
        r9 = r24;
        r10 = r19;
    L53:
        th = move-exception;
        th = th;
    L55:
        th = th;
        r19 = BuildConfig.FLAVOR;
    L7:
        r0 = new PolicyCheckInterceptor$intercept$1(this, r8);
        goto L8
    }
}
