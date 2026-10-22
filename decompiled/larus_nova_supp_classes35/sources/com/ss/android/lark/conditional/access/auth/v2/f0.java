package com.ss.android.lark.conditional.access.auth.v2;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f0 implements ozb.c {
    public final /* synthetic */ SecurityPolicyAuthManager a;

    public f0(SecurityPolicyAuthManager r1) {
        this.a = r1;
    }

    public final /* synthetic */ void a() {
    }

    public final void b(ozb.a r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        ArrayList<String> r4 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityPolicyAuthManager", "call Logout", false);
        this.a.m();
    }
}
