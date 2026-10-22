package com.bytedance.android.live.profit.taskcenter.preload;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        JsonObject r8 = (JsonObject) r7;
        ALogger.i("TaskCenterService", "preload task center api success, value = " + r8);
        d r0 = this.a;
        r0.getClass();
        if (r8 == null) goto L7;
        com.bytedance.android.live.recharge.util.a r1 = com.bytedance.android.live.recharge.util.a.i;
        Gson r2 = GsonHelper.get();
        c r3 = new c();
        r3.c(String.valueOf(r8));
        r3.d(String.valueOf(r0.f.getRoom().getRoomId()));
        r3.b(r0.f.getRoom().getOwnerUserIdString());
        r3.f(((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId());
        r3.e(System.currentTimeMillis());
        String r9 = GsonProtectorUtils.toJson(r2, r3);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        com.bytedance.android.live.recharge.util.a.h.setValue(r1, com.bytedance.android.live.recharge.util.a.a[6], r9);
        return;
    }
}
