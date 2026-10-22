package com.bytedance.android.live.recharge.service;

import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.IPreRenderDataInfo;
import com.bytedance.android.livesdkapi.depend.model.IQueryPrePayCashierData;
import com.bytedance.android.livesdkapi.depend.model.IRenderDataInfoBase;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final void accept(Object r5) {
        jy0.b.d("RechargeRoomService", "pre fetch 0 cashier info");
        Map r6 = ((IQueryPrePayCashierData) r5).getRenderData();
        if (r6 == null) goto L13;
        IRenderDataInfoBase r7 = (IPreRenderDataInfo) r6.get(0L);
        if (r7 != null) goto L7;
        return;
    L7:
        if (r2.a(r7.getRenderData()) == true) goto L10;
        r7 = null;
    L10:
        if (r7 == null) goto L15;
        ConcurrentHashMap<Long, IRenderDataInfoBase> r2 = sw0.a.a;
        Intrinsics.checkNotNullParameter(r7, Constants.Keys.DATA);
        jy0.b.a("Recharge/PreCashierInfoMemoryCache", "cache write, price: 0");
        sw0.a.a.put(0L, r7);
        return;
    L15:
        return;
    }
}
