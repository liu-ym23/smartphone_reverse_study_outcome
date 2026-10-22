package com.ss.android.lark.conditional.access.traffic;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.sdk.g;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements g.b {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    public final void a(byte[] r5) {
        if (Intrinsics.areEqual(qqb.a.d(), BuildConfig.FLAVOR) == true) goto L5;
        String r0 = qqb.a.d();
    L6:
        int r1 = ScsLogger.a;
        ScsLogger.a("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "doListen, callback request:" + r5 + ", sid:, fromServerPipe:false, offlinePush:false");
        CoreThreadPool.getSerialTaskHandler().post(new c(r0, this.a, r5));
        return;
    L5:
        r0 = qqb.a.i(qqb.a.e());
        goto L6
    }
}
