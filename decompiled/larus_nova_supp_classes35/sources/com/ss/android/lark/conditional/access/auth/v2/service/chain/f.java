package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.h;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.n;
import i8b.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements n {
    public final q a;

    public f(q r2) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
        this.a = r2;
    }

    @Override // i8b.n
    public final com.ss.android.lark.conditional.access.auth.v2.c a(g r7) {
        Intrinsics.checkNotNullParameter(r7, "chain");
        long r0 = System.currentTimeMillis();
        PolicyModel r2 = r7.c;
        r2.setConfig(new PolicyModel.a(this.a.b(r2)));
        com.ss.android.lark.conditional.access.auth.v2.c r3 = r7.a(r2);
        PolicyModel r4 = h.j(r2);
        if (r4 == null) goto L5;
        com.ss.android.lark.conditional.access.auth.v2.c r8 = r7.a(r4);
    L6:
        int r5 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_CheckAuthService", "checkAuthorityWithMergedResult(), subjectResult is " + r3 + ", objectResult is " + r8);
        com.ss.android.lark.conditional.access.auth.v2.c r9 = r3.a(r8);
        if (r9.h() != ResultType.ERROR) goto L9;
        r9 = com.ss.android.lark.conditional.access.utils.e.a();
    L9:
        FileAuthMonitor.UpdateTrigger[] r6 = FileAuthMonitor.a;
        FileAuthMonitor.q(r2, r9, FileAuthMonitor.CheckType.CacheCheck, System.currentTimeMillis() - r0);
        return r9;
    L5:
        r8 = null;
        goto L6
    }

    @Override // i8b.n
    public final Object b(a r10, Continuation r11) {
        long r5 = System.currentTimeMillis();
        List<PolicyModel> r2 = r10.c;
        List<PolicyModel> r0 = r2;
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        PolicyModel r3 = (PolicyModel) r1.next();
        r3.setConfig(new PolicyModel.a(this.a.b(r3)));
        goto L4
    L6:
        ArrayList r4 = new ArrayList();
        Iterator<T> r6 = r0.iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        PolicyModel r7 = h.j((PolicyModel) r6.next());
        if (r7 == null) goto L8;
        r4.add(r7);
        goto L8
    L13:
        return CoroutineScopeKt.coroutineScope(new SplitAndMergeInterceptor$intercept$3(r10, r2, r4, this, r5, null), r11);
    }
}
