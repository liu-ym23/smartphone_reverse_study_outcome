package com.bytedance.badger.z;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.helper.MiDetectHelper;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataString;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r0 extends u0 {
    public r0() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r6, BadgerModuleBase.BadgerRequestData r7) {
        if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") == true) goto L10;
        String r1 = Build.BRAND;
        if (r1.equalsIgnoreCase("XIAOMI") == true) goto L10;
        if (r1.equalsIgnoreCase("REDMI") == true) goto L10;
        boolean r2 = false;
    L11:
        if (r2 == false) goto L23;
        CountDownLatch r3 = new CountDownLatch(1);
        JSONObject r4 = new JSONObject();
        if (MiDetectHelper.init(r6, MiDetectHelper.DOUYIN_APP_ID, MiDetectHelper.DOUYIN_APP_KEY) == false) goto L20;
        MiDetectHelper.getTrustDeviceStatus(UUID.randomUUID().toString(), new q0(this, r4, r3));
        com.bytedance.badger.v.d.f0.getClass();
        com.bytedance.badger.v.g r8 = com.bytedance.badger.v.d.L;
        KProperty r5 = com.bytedance.badger.v.d.a[38];
        com.bytedance.badger.v.w r9 = (com.bytedance.badger.v.w) r8.a();
        if (r3.await(r9.a, r9.b) == false) goto L19;
        return new BadgerResult.Success(new DataString(r4.toString()));
    L19:
        throw new TimeoutException("timeout");
    L20:
        r3.countDown();
        throw new RuntimeException("service bind error");
    L23:
        throw new RuntimeException("not support");
    L10:
        r2 = true;
        goto L11
    }

    public static final void c(r0 r3, JSONObject r4, String r5, int r6, String r7) {
        r3.getClass();
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r5) == false) goto L8;
        r5 = "";
    L8:
        r8.putOpt("result", r5);     // Catch: Exception -> L12
        r8.putOpt(Constants.OperatorKey.CODE, Integer.valueOf(r6));     // Catch: Exception -> L12
        r8.putOpt("error", r7);     // Catch: Exception -> L12
        r4.putOpt("trust_device_info", r8);     // Catch: Exception -> L12
        return;
    }
}
