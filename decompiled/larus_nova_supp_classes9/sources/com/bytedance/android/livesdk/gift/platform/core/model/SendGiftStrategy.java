package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/SendGiftStrategy;", BuildConfig.FLAVOR, "ONE_SEND_ONE_REQUEST", "REQUEST_AFTER_RESPONSE", "ONLY_SEND_ONCE", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SendGiftStrategy extends Enum<SendGiftStrategy> {
    public static final SendGiftStrategy ONE_SEND_ONE_REQUEST = null;
    public static final SendGiftStrategy ONLY_SEND_ONCE = null;
    public static final SendGiftStrategy REQUEST_AFTER_RESPONSE = null;
    public static final /* synthetic */ SendGiftStrategy[] a = null;

    static {
        SendGiftStrategy r1 = new SendGiftStrategy("ONE_SEND_ONE_REQUEST", 0);
        ONE_SEND_ONE_REQUEST = r1;
        SendGiftStrategy r2 = new SendGiftStrategy("REQUEST_AFTER_RESPONSE", 1);
        REQUEST_AFTER_RESPONSE = r2;
        SendGiftStrategy r3 = new SendGiftStrategy("ONLY_SEND_ONCE", 2);
        ONLY_SEND_ONCE = r3;
        a = new SendGiftStrategy[]{r1, r2, r3};
    }

    public static SendGiftStrategy valueOf(String r1) {
        return (SendGiftStrategy) r27.a.a(SendGiftStrategy.class, r1);
    }

    public static SendGiftStrategy[] values() {
        return (SendGiftStrategy[]) a.clone();
    }

    public SendGiftStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
