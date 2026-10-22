package com.bytedance.badger.z;

import com.bytedance.badger.collect.impl.helper.MiDetectHelper;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q0 implements MiDetectHelper.DetectCallback {
    public final /* synthetic */ r0 a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ CountDownLatch c;

    public q0(r0 r1, JSONObject r2, CountDownLatch r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.bytedance.badger.collect.impl.helper.MiDetectHelper.DetectCallback
    public final void onFailure(Throwable r5) {
        r0.c(this.a, this.b, "", -1, "getTrustDeviceStatus# onFailure" + r5.toString());
        this.c.countDown();
    }

    @Override // com.bytedance.badger.collect.impl.helper.MiDetectHelper.DetectCallback
    public final void onResult(String r4, int r5) {
        r0.c(this.a, this.b, r4, r5, "");
        this.c.countDown();
    }
}
