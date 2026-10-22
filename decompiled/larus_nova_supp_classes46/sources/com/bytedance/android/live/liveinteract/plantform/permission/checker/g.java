package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements o60.e {
    public final /* synthetic */ e a;
    public final /* synthetic */ qh0.d b;
    public final /* synthetic */ Cert c;

    public final void onPermissionDenied(String... r10) {
        Intrinsics.checkNotNullParameter(r10, "permissions");
        ALogger.i("ttlive_link", "checkAndroidSystemPermission failure");
        qh0.d r11 = this.b;
        qh0.f.b r0 = this.a.a;
        r11.b(new BaseCheckException(r0.c, r0.b, BaseCheckException.CheckType.AndroidPermission, "android permission denied.", null, 16, null));
        if (this.a.a.d == false) goto L5;
        f2.c(s1.B(2131917678), 0);
        return;
    L5:
        f2.c(s1.B(2131917583), 0);
    }

    public final void onPermissionGrant(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        ALogger.i("ttlive_link", "checkAndroidSystemPermission success");
        this.b.onResult(null);
    }

    public g(e r1, qh0.d r2, TokenCert r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
