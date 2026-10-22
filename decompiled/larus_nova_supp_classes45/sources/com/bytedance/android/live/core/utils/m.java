package com.bytedance.android.live.core.utils;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m implements o60.e {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ Cert f;
    public final /* synthetic */ p1 g;

    @Override // o60.e
    public final void onPermissionDenied(String... r1) {
        TokenCert r2 = q.a;
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r7) {
        q.i(this.a, this.b, this.c, this.d, this.e, this.g);
    }

    public m(Activity r1, Fragment r2, int r3, boolean r4, boolean r5, TokenCert r6, com.bytedance.android.livesdk.utils.k2.a r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
