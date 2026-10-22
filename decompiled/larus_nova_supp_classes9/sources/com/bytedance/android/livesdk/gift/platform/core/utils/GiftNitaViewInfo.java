package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/utils/GiftNitaViewInfo;", BuildConfig.FLAVOR, "Lzo2/a;", BuildConfig.FLAVOR, "getResId", "()I", "resId", BuildConfig.FLAVOR, "getTag", "()Ljava/lang/String;", "tag", "getCount", "count", "getType", "type", "TTLIVE_VIEW_GIFT_FAST_V3", "TTLIVE_VIEW_GIFT_NORMAL_V3", "TTLIVE_VIEW_GIFT_NORMAL_V3_PK", "TTLIVE_VIEW_GIFT_NORMAL_V2_LANDSCAPE_SPLIT", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftNitaViewInfo extends Enum<GiftNitaViewInfo> implements zo2.a {
    public static final GiftNitaViewInfo TTLIVE_VIEW_GIFT_FAST_V3 = null;
    public static final GiftNitaViewInfo TTLIVE_VIEW_GIFT_NORMAL_V2_LANDSCAPE_SPLIT = null;
    public static final GiftNitaViewInfo TTLIVE_VIEW_GIFT_NORMAL_V3 = null;
    public static final GiftNitaViewInfo TTLIVE_VIEW_GIFT_NORMAL_V3_PK = null;
    public static final /* synthetic */ GiftNitaViewInfo[] a = null;

    static {
        GiftNitaViewInfo r1 = new GiftNitaViewInfo("TTLIVE_VIEW_GIFT_FAST_V3", 0);
        TTLIVE_VIEW_GIFT_FAST_V3 = r1;
        GiftNitaViewInfo r2 = new GiftNitaViewInfo("TTLIVE_VIEW_GIFT_NORMAL_V3", 1);
        TTLIVE_VIEW_GIFT_NORMAL_V3 = r2;
        GiftNitaViewInfo r3 = new GiftNitaViewInfo("TTLIVE_VIEW_GIFT_NORMAL_V3_PK", 2);
        TTLIVE_VIEW_GIFT_NORMAL_V3_PK = r3;
        GiftNitaViewInfo r4 = new GiftNitaViewInfo("TTLIVE_VIEW_GIFT_NORMAL_V2_LANDSCAPE_SPLIT", 3);
        TTLIVE_VIEW_GIFT_NORMAL_V2_LANDSCAPE_SPLIT = r4;
        a = new GiftNitaViewInfo[]{r1, r2, r3, r4};
    }

    public static GiftNitaViewInfo valueOf(String r1) {
        return (GiftNitaViewInfo) r27.a.a(GiftNitaViewInfo.class, r1);
    }

    public static GiftNitaViewInfo[] values() {
        return (GiftNitaViewInfo[]) a.clone();
    }

    public int getType() {
        return 0;
    }

    public int getCount() {
        int r0 = n.b[ordinal()];
        if (r0 != 1) goto L5;
        return 1;
    L5:
        if (r0 != 2) goto L7;
    L13:
        return 2;
    L7:
        if (r0 == 3) goto L13;
        if (r0 != 4) goto L12;
        return 1;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public int getResId() {
        int r0 = n.a[ordinal()];
        if (r0 != 1) goto L5;
        return 2131567659;
    L5:
        if (r0 != 2) goto L7;
        return 2131567677;
    L7:
        if (r0 != 3) goto L9;
        return 2131567678;
    L9:
        if (r0 != 4) goto L12;
        return 2131567676;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public String getTag() {
        return name();
    }

    public GiftNitaViewInfo(String r1, int r2) {
        super(r1, r2);
    }
}
