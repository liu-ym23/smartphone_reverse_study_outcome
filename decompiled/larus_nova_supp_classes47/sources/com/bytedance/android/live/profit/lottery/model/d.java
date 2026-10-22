package com.bytedance.android.live.profit.lottery.model;

import com.bytedance.android.livesdk.revenue.message.k;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends k {
    public static final /* synthetic */ KProperty[] e = null;
    public final k.b d;

    static {
        e = new KProperty[]{Reflection.property1(new PropertyReference1Impl(d.class, "lotteryInfoSyncData", "getLotteryInfoSyncData()Lcom/bytedance/android/livesdk/revenue/message/IRevWrdsSettingItem;", 0))};
    }

    public d() {
        k.b r0 = new k.b(this, LotteryInfoSyncData.class);
        ((k) this).b.put("LotteryInfoSyncData", r0);
        this.d = r0;
    }
}
