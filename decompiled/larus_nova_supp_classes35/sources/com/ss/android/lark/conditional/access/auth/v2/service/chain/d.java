package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.api.model.filepolicy.h;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.n;
import i8b.q;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements n {

    public static final class a {
    }

    static {
    }

    public d(q r2) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
    }

    public static boolean c(List r2) {
        if ((!r2.isEmpty()) == true) goto L5;
    L7:
        return false;
    L5:
        if (h.d(((PolicyModel) CollectionsKt.first(r2)).getEntity()) != FileBizDomain.FileBizDomainMeetingMinutes) goto L7;
        return true;
    }

    public static boolean d(List r2) {
        if ((!r2.isEmpty()) == true) goto L5;
    L7:
        return false;
    L5:
        if (h.d(((PolicyModel) CollectionsKt.first(r2)).getEntity()) != FileBizDomain.FileBizDomainVC) goto L7;
        return true;
    }

    public static boolean e(List r3) {
        if ((!r3.isEmpty()) == true) goto L5;
        return false;
    L5:
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.f.a.values().contains(((PolicyModel) CollectionsKt.first(r3)).getPointKey()) == false) goto L7;
        return false;
    L7:
        if (ArraysKt.contains(e.a, h.d(((PolicyModel) CollectionsKt.first(r3)).getEntity())) == true) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // i8b.n
    public final com.ss.android.lark.conditional.access.auth.v2.c a(g r11) {
        Intrinsics.checkNotNullParameter(r11, "chain");
        long r0 = System.currentTimeMillis();
        PolicyModel r2 = r11.c;
        if (com.ss.android.lark.conditional.access.utils.f.a() == true) goto L14;
        if (com.ss.android.lark.conditional.access.auth.v2.b.c.contains(r2.getPointKey()) == true) goto L14;
        List r3 = w4c.c.a().q0();
        if (r3 != null) goto L10;
        r3 = CollectionsKt.emptyList();
    L10:
        if (r3.contains(r2.getPointKey()) == true) goto L14;
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    L14:
        if (Intrinsics.areEqual(r2.getPointKey(), "PointKey_CCM_OPEN_EXTERNAL_ACCESS") == false) goto L18;
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    L18:
        if (d(CollectionsKt.listOf(r2)) == false) goto L22;
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    L22:
        if (w4c.c.a().L() == true) goto L28;
        if (c(CollectionsKt.listOf(r2)) == false) goto L28;
        ScsLogger.d("SecurityPolicy_PreCheckInterceptor", "syncCheck, MM is disable");
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    L28:
        if (Intrinsics.areEqual(r2.getEntity().getEntityOperate(), "IM_MSG_FILE_READ") == false) goto L34;
        if (w4c.c.a().q() == false) goto L34;
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    L34:
        if (w4c.c.a().D() == true) goto L36;
    L39:
        com.ss.android.lark.conditional.access.auth.v2.c r12 = r11.a(r2);
        FileAuthMonitor.UpdateTrigger[] r4 = FileAuthMonitor.a;
        FileAuthMonitor.m(r2, r12, FileAuthMonitor.CheckType.CacheCheck, System.currentTimeMillis() - r0);
        return r12;
    L36:
        if (e(CollectionsKt.listOf(r2)) == false) goto L39;
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    }

    @Override // i8b.n
    public final Object b(com.ss.android.lark.conditional.access.auth.v2.service.chain.a r9, Continuation r10) {
        if ((r10 instanceof PreCheckInterceptor$intercept$1) == false) goto L7;
        PreCheckInterceptor$intercept$1 r0 = (PreCheckInterceptor$intercept$1) r10;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r4 = r0.J$0;
        List<PolicyModel> r12 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L50:
        Map r13 = (Map) r11;
        Iterator<T> r14 = r12.iterator();
    L52:
        if (r14.hasNext() == false) goto L56;
        PolicyModel r5 = (PolicyModel) r14.next();
        com.ss.android.lark.conditional.access.auth.v2.c r6 = (com.ss.android.lark.conditional.access.auth.v2.c) r13.get(r5.getTaskId());
        if (r6 == null) goto L52;
        FileAuthMonitor.UpdateTrigger[] r7 = FileAuthMonitor.a;
        FileAuthMonitor.m(r5, r6, FileAuthMonitor.CheckType.AsyncCheck, System.currentTimeMillis() - r4);
        goto L52
    L56:
        return r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        long r8 = System.currentTimeMillis();
        List<PolicyModel> r15 = r9.c;
        List r16 = CollectionsKt.plus(w4c.c.a().q0(), com.ss.android.lark.conditional.access.auth.v2.b.c);
        if (com.ss.android.lark.conditional.access.utils.f.a() == true) goto L21;
        if (r16.contains(((PolicyModel) CollectionsKt.first(r15)).getPointKey()) == true) goto L21;
        return com.ss.android.lark.conditional.access.utils.e.b(r15);
    L21:
        if (Intrinsics.areEqual(((PolicyModel) CollectionsKt.first(r15)).getPointKey(), "PointKey_CCM_OPEN_EXTERNAL_ACCESS") == false) goto L25;
        return com.ss.android.lark.conditional.access.utils.e.b(r15);
    L25:
        if (d(r15) == false) goto L29;
        return com.ss.android.lark.conditional.access.utils.e.b(r15);
    L29:
        if (w4c.c.a().L() == true) goto L35;
        if (c(r15) == false) goto L35;
        ScsLogger.d("SecurityPolicy_PreCheckInterceptor", "asyncCheck, MM is disable");
        return com.ss.android.lark.conditional.access.utils.e.b(r15);
    L35:
        if (Intrinsics.areEqual(((PolicyModel) CollectionsKt.first(r15)).getEntity().getEntityOperate(), "IM_MSG_FILE_READ") == false) goto L41;
        if (w4c.c.a().q() == false) goto L41;
        return com.ss.android.lark.conditional.access.utils.e.b(r15);
    L41:
        if (w4c.c.a().D() == true) goto L43;
    L46:
        r0.L$0 = r15;
        r0.J$0 = r8;
        r0.label = 1;
        Object r17 = r9.a(r15, r0);
        if (r17 != r2) goto L49;
        return r2;
    L49:
        r4 = r8;
        r11 = r17;
        r12 = r15;
        goto L50
    L43:
        if (e(r15) == false) goto L46;
        return com.ss.android.lark.conditional.access.utils.e.b(r15);
    L7:
        r0 = new PreCheckInterceptor$intercept$1(this, r10);
        goto L8
    }
}
