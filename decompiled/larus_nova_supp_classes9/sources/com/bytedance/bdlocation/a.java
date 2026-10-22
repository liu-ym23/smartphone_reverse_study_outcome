package com.bytedance.bdlocation;

import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ LocationUploadExtra a;
    public final /* synthetic */ LocationUploadCallback b;

    public /* synthetic */ a(LocationUploadExtra r1, LocationUploadCallback r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LocationUtil.c(this.a, this.b);
    }
}
