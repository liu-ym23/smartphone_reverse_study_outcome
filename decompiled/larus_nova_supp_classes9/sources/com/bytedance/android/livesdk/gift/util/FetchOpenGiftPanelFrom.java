package com.bytedance.android.livesdk.gift.util;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/util/FetchOpenGiftPanelFrom;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "TOUCH_DOWN", "DIALOG_CREATE_BEFORE", "GIFT_PANEL_CREATE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FetchOpenGiftPanelFrom extends Enum<FetchOpenGiftPanelFrom> {
    public static final FetchOpenGiftPanelFrom DIALOG_CREATE_BEFORE = null;
    public static final FetchOpenGiftPanelFrom GIFT_PANEL_CREATE = null;
    public static final FetchOpenGiftPanelFrom TOUCH_DOWN = null;
    public static final /* synthetic */ FetchOpenGiftPanelFrom[] a = null;
    private final int value;

    static {
        FetchOpenGiftPanelFrom r1 = new FetchOpenGiftPanelFrom("TOUCH_DOWN", 0, 0);
        TOUCH_DOWN = r1;
        FetchOpenGiftPanelFrom r2 = new FetchOpenGiftPanelFrom("DIALOG_CREATE_BEFORE", 1, 1);
        DIALOG_CREATE_BEFORE = r2;
        FetchOpenGiftPanelFrom r3 = new FetchOpenGiftPanelFrom("GIFT_PANEL_CREATE", 2, 2);
        GIFT_PANEL_CREATE = r3;
        a = new FetchOpenGiftPanelFrom[]{r1, r2, r3};
    }

    public static FetchOpenGiftPanelFrom valueOf(String r1) {
        return (FetchOpenGiftPanelFrom) r27.a.a(FetchOpenGiftPanelFrom.class, r1);
    }

    public static FetchOpenGiftPanelFrom[] values() {
        return (FetchOpenGiftPanelFrom[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public FetchOpenGiftPanelFrom(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
