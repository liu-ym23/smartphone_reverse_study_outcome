package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements o60.d {
    public final /* synthetic */ a a;
    public final /* synthetic */ Cert b;

    public d(a r1, TokenCert r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ALogger.d("ttlive_link", "skip bluetooth permission denied and go to settings");
        qh0.d<rh0.a> r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r0.onResult(null);
    }
}
