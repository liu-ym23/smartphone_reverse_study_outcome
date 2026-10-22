package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements o60.d {
    public final /* synthetic */ e a;
    public final /* synthetic */ qh0.d b;
    public final /* synthetic */ Cert c;

    public h(e r1, qh0.d r2, TokenCert r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        ALogger.i("ttlive_link", "checkAndroidSystemPermission goToSettings");
        qh0.d r0 = this.b;
        qh0.f.b r1 = this.a.a;
        r0.b(new BaseCheckException(r1.c, r1.b, BaseCheckException.CheckType.AndroidPermission, "android permission denied and go to settings.", null, 16, null));
    }
}
