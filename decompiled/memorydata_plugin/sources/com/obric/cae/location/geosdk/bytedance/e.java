package com.obric.cae.location.geosdk.bytedance;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements BDLocationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f7162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BDLocationCallback f7163b;

    public e(long r1, a.an r3) {
        this.f7162a = r1;
        this.f7163b = r3;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onError(BDLocationException r6) {
        com.obric.cae.log.a.b("StarLocation-BdLM", "costMs=" + (System.currentTimeMillis() - this.f7162a), r6);
        BDLocationCallback r5 = this.f7163b;
        if (r5 == null) goto L6;
        r5.onError(r6);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onLocationChanged(BDLocation r6) {
        com.obric.cae.log.a.d("StarLocation-BdLM", "costMs=" + (System.currentTimeMillis() - this.f7162a));
        BDLocationCallback r5 = this.f7163b;
        if (r5 == null) goto L6;
        r5.onLocationChanged(r6);
        return;
    }
}
