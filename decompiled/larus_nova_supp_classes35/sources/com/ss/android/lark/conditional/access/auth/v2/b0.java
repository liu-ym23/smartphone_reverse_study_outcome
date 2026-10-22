package com.ss.android.lark.conditional.access.auth.v2;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b0 implements com.ss.android.lark.security.compliance.api.model.filepolicy.m {
    public final /* synthetic */ a0 a;
    public final /* synthetic */ AuthEntity b;
    public final /* synthetic */ PolicyModel[] c;
    public final /* synthetic */ com.ss.android.lark.security.compliance.api.model.filepolicy.m d;
    public final /* synthetic */ long e;

    public final void onResult(Map<String, ValidateResult> r13) {
        Intrinsics.checkNotNullParameter(r13, ChameleonOpenTracker.ParamKey.RESULT);
        ArrayList<String> r0 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityAuthService", "do checkAuthAsync(),security policy return result:" + r13.values(), true);
        this.a.a(CollectionsKt.toList(r13.values()), this.b);
        int r3 = 0;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityAuthService", "[end check auth]", false);
        PolicyModel[] r1 = this.c;
        long r4 = this.e;
        int r6 = r1.length;
    L3:
        if (r3 >= r6) goto L8;
        PolicyModel r7 = r1[r3];
        ValidateResult r8 = r13.get(r7.getTaskId());
        if (r8 == null) goto L7;
        FileAuthMonitor.UpdateTrigger[] r9 = FileAuthMonitor.a;
        FileAuthMonitor.t(r7, r8, FileAuthMonitor.CheckType.AsyncCheck, System.currentTimeMillis() - r4);
    L7:
        ArrayList<String> r10 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityAuthService", "do checkAuthAsync(), [validateResult:" + r8 + ']', true);
        r3 = r3 + 1;
        goto L3
    L8:
        this.d.onResult(r13);
    }

    public b0(a0 r1, AuthEntity r2, PolicyModel[] r3, com.ss.android.lark.security.compliance.api.model.filepolicy.m r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
