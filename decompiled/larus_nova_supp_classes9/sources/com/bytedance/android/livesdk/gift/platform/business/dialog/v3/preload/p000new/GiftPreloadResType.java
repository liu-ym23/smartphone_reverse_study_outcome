package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/new/GiftPreloadResType;", BuildConfig.FLAVOR, "ITEM_LIST_DATA", "GIFT_ICON", "ICON_ANIMATOR_URI", "GIFT_PANEL_VIEW", "ANNIE_LYNX_MODEL", "GIFT_EXTRA", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftPreloadResType extends Enum<GiftPreloadResType> {
    public static final GiftPreloadResType ANNIE_LYNX_MODEL = null;
    public static final GiftPreloadResType GIFT_EXTRA = null;
    public static final GiftPreloadResType GIFT_ICON = null;
    public static final GiftPreloadResType GIFT_PANEL_VIEW = null;
    public static final GiftPreloadResType ICON_ANIMATOR_URI = null;
    public static final GiftPreloadResType ITEM_LIST_DATA = null;
    public static final /* synthetic */ GiftPreloadResType[] a = null;

    static {
        GiftPreloadResType r1 = new GiftPreloadResType("ITEM_LIST_DATA", 0);
        ITEM_LIST_DATA = r1;
        GiftPreloadResType r2 = new GiftPreloadResType("GIFT_ICON", 1);
        GIFT_ICON = r2;
        GiftPreloadResType r3 = new GiftPreloadResType("ICON_ANIMATOR_URI", 2);
        ICON_ANIMATOR_URI = r3;
        GiftPreloadResType r4 = new GiftPreloadResType("GIFT_PANEL_VIEW", 3);
        GIFT_PANEL_VIEW = r4;
        GiftPreloadResType r5 = new GiftPreloadResType("ANNIE_LYNX_MODEL", 4);
        ANNIE_LYNX_MODEL = r5;
        GiftPreloadResType r6 = new GiftPreloadResType("GIFT_EXTRA", 5);
        GIFT_EXTRA = r6;
        a = new GiftPreloadResType[]{r1, r2, r3, r4, r5, r6};
    }

    public static GiftPreloadResType valueOf(String r1) {
        return (GiftPreloadResType) a.a(GiftPreloadResType.class, r1);
    }

    public static GiftPreloadResType[] values() {
        return (GiftPreloadResType[]) a.clone();
    }

    public GiftPreloadResType(String r1, int r2) {
        super(r1, r2);
    }
}
