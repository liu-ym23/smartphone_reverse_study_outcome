package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements o60.d {
    public final /* synthetic */ i a;
    public final /* synthetic */ Cert b;

    public l(i r1, TokenCert r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        qh0.d<rh0.a> r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        qh0.f.c r2 = this.a.b;
        r0.b(new BaseCheckException(r2.c, r2.b, BaseCheckException.CheckType.AndroidPermission, "android permission denied and go to settings.", null, 16, null));
    }
}
