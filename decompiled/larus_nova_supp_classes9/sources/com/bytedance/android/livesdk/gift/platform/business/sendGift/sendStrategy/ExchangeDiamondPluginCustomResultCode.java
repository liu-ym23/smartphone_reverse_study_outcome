package com.bytedance.android.livesdk.gift.platform.business.sendGift.sendStrategy;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/sendGift/sendStrategy/ExchangeDiamondPluginCustomResultCode;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "SendGiftSuccess", "ExchangeCancel", "ExchangeFailed", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ExchangeDiamondPluginCustomResultCode extends Enum<ExchangeDiamondPluginCustomResultCode> {
    public static final ExchangeDiamondPluginCustomResultCode ExchangeCancel = null;
    public static final ExchangeDiamondPluginCustomResultCode ExchangeFailed = null;
    public static final ExchangeDiamondPluginCustomResultCode SendGiftSuccess = null;
    public static final /* synthetic */ ExchangeDiamondPluginCustomResultCode[] a = null;
    private final int value;

    static {
        ExchangeDiamondPluginCustomResultCode r2 = new ExchangeDiamondPluginCustomResultCode("SendGiftSuccess", 0, 1);
        SendGiftSuccess = r2;
        ExchangeDiamondPluginCustomResultCode r3 = new ExchangeDiamondPluginCustomResultCode("ExchangeCancel", 1, 2);
        ExchangeCancel = r3;
        ExchangeDiamondPluginCustomResultCode r4 = new ExchangeDiamondPluginCustomResultCode("ExchangeFailed", 2, 3);
        ExchangeFailed = r4;
        a = new ExchangeDiamondPluginCustomResultCode[]{r2, r3, r4};
    }

    public static ExchangeDiamondPluginCustomResultCode valueOf(String r1) {
        return (ExchangeDiamondPluginCustomResultCode) a.a(ExchangeDiamondPluginCustomResultCode.class, r1);
    }

    public static ExchangeDiamondPluginCustomResultCode[] values() {
        return (ExchangeDiamondPluginCustomResultCode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ExchangeDiamondPluginCustomResultCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
