package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements o60.e {
    public final /* synthetic */ a a;
    public final /* synthetic */ Cert b;

    public final void onPermissionDenied(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        ALogger.d("ttlive_link", "skip bluetooth permission denied");
        qh0.d<rh0.a> r3 = this.a.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r3.onResult(null);
    }

    public final void onPermissionGrant(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        ALogger.d("ttlive_link", "check bluetooth permission denied");
        qh0.d<rh0.a> r3 = this.a.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r3.onResult(null);
    }

    public c(a r1, TokenCert r2) {
        this.a = r1;
        this.b = r2;
    }
}
