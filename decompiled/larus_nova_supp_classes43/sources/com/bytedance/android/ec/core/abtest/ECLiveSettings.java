package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.local.api.ab.ECLiveSettingPanel;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u0002H\n¢\u0006\u0002\u0010\u000eR\u001b\u0010\u0003\u001a\u00020\u00048GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/core/abtest/ECLiveSettings;", "", "()V", "HOT_SALE_NUM_LIMIT", "", "getHOT_SALE_NUM_LIMIT", "()I", "HOT_SALE_NUM_LIMIT$delegate", "Lkotlin/Lazy;", "getLiveSettingValue", "T", "key", "", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSettings {
    private static final Lazy HOT_SALE_NUM_LIMIT$delegate = null;
    public static final ECLiveSettings INSTANCE = null;

    private ECLiveSettings() {
    }

    @ECLiveSettingPanel(desc = "热卖氛围展示最大值", key = "ec_live_hot_sale_num_show_limit")
    public final int getHOT_SALE_NUM_LIMIT() {
        return ((Number) HOT_SALE_NUM_LIMIT$delegate.getValue()).intValue();
    }

    static {
        INSTANCE = new ECLiveSettings();
        HOT_SALE_NUM_LIMIT$delegate = LazyKt.lazy(ECLiveSettings$HOT_SALE_NUM_LIMIT$2.INSTANCE);
    }

    public final <T> T getLiveSettingValue(String r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L9;
        T r12 = (T) r1.getLiveSettingsValue(r10, r11);
        if (r12 != null) goto L8;
        return r11;
    L8:
        return r12;
    L9:
        return r11;
    }
}
