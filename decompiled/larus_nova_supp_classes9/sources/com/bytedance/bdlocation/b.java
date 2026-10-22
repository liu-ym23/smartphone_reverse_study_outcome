package com.bytedance.bdlocation;

import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ BDLocation a;
    public final /* synthetic */ LocationUploadExtra b;
    public final /* synthetic */ LocationUploadCallback c;

    public /* synthetic */ b(BDLocation r1, LocationUploadExtra r2, LocationUploadCallback r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LocationUtil.b(this.a, this.b, this.c);
    }
}
