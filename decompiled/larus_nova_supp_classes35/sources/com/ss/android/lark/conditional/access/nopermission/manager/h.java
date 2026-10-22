package com.ss.android.lark.conditional.access.nopermission.manager;

import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements ozb.c {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final /* synthetic */ void a() {
    }

    public final void b(ozb.a r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "maybeRestoreInterception: logout, cancel prober");
        com.ss.android.lark.conditional.access.nopermission.interception.b.a.getClass();
        Job r5 = com.ss.android.lark.conditional.access.nopermission.interception.b.b;
        if (r5 == null) goto L5;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "cancel: probeUserId=" + com.ss.android.lark.conditional.access.nopermission.interception.b.c);
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L5:
        com.ss.android.lark.conditional.access.nopermission.interception.b.b = null;
        com.ss.android.lark.conditional.access.nopermission.interception.b.c = BuildConfig.FLAVOR;
    }
}
