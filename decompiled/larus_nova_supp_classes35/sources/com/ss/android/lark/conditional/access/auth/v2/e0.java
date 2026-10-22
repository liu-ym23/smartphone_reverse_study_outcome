package com.ss.android.lark.conditional.access.auth.v2;

import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e0 implements nzb.b {
    public final /* synthetic */ SecurityPolicyAuthManager a;

    public e0(SecurityPolicyAuthManager r1) {
        this.a = r1;
    }

    public final void a(nzb.a r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        ArrayList<String> r4 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityPolicyAuthManager", "call Login", false);
        this.a.m();
        this.a.k(FileAuthMonitor.UpdateTrigger.UIdChange);
    }
}
