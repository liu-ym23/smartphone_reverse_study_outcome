package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/model/GiftPanelIconSource;", BuildConfig.FLAVOR, "GIFT_LIST", "BUFF_CARD", "DIY_CARD", "DIY_CACHE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftPanelIconSource extends Enum<GiftPanelIconSource> {
    public static final GiftPanelIconSource BUFF_CARD = null;
    public static final GiftPanelIconSource DIY_CACHE = null;
    public static final GiftPanelIconSource DIY_CARD = null;
    public static final GiftPanelIconSource GIFT_LIST = null;
    public static final /* synthetic */ GiftPanelIconSource[] a = null;

    static {
        GiftPanelIconSource r1 = new GiftPanelIconSource("GIFT_LIST", 0);
        GIFT_LIST = r1;
        GiftPanelIconSource r2 = new GiftPanelIconSource("BUFF_CARD", 1);
        BUFF_CARD = r2;
        GiftPanelIconSource r3 = new GiftPanelIconSource("DIY_CARD", 2);
        DIY_CARD = r3;
        GiftPanelIconSource r4 = new GiftPanelIconSource("DIY_CACHE", 3);
        DIY_CACHE = r4;
        a = new GiftPanelIconSource[]{r1, r2, r3, r4};
    }

    public static GiftPanelIconSource valueOf(String r1) {
        return (GiftPanelIconSource) a.a(GiftPanelIconSource.class, r1);
    }

    public static GiftPanelIconSource[] values() {
        return (GiftPanelIconSource[]) a.clone();
    }

    public GiftPanelIconSource(String r1, int r2) {
        super(r1, r2);
    }
}
