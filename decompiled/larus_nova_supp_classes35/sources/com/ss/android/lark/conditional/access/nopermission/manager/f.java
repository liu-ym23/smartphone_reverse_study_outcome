package com.ss.android.lark.conditional.access.nopermission.manager;

import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements nzb.b {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final void a(nzb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "maybeRestoreInterception: login event received, kick prober");
        com.ss.android.lark.conditional.access.nopermission.interception.b.a.getClass();
        com.ss.android.lark.conditional.access.nopermission.interception.b.a();
    }
}
