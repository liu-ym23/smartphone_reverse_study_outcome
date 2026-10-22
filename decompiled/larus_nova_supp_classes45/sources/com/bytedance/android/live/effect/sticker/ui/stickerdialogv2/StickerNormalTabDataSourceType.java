package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/StickerNormalTabDataSourceType;", "", "Normal", "Favorite", "Campaign", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StickerNormalTabDataSourceType extends Enum<StickerNormalTabDataSourceType> {
    public static final StickerNormalTabDataSourceType Campaign = null;
    public static final StickerNormalTabDataSourceType Favorite = null;
    public static final StickerNormalTabDataSourceType Normal = null;
    public static final /* synthetic */ StickerNormalTabDataSourceType[] a = null;

    static {
        StickerNormalTabDataSourceType r1 = new StickerNormalTabDataSourceType("Normal", 0);
        Normal = r1;
        StickerNormalTabDataSourceType r2 = new StickerNormalTabDataSourceType("Favorite", 1);
        Favorite = r2;
        StickerNormalTabDataSourceType r3 = new StickerNormalTabDataSourceType("Campaign", 2);
        Campaign = r3;
        a = new StickerNormalTabDataSourceType[]{r1, r2, r3};
    }

    public static StickerNormalTabDataSourceType valueOf(String r1) {
        return (StickerNormalTabDataSourceType) r27.a.a(StickerNormalTabDataSourceType.class, r1);
    }

    public static StickerNormalTabDataSourceType[] values() {
        return (StickerNormalTabDataSourceType[]) a.clone();
    }

    public StickerNormalTabDataSourceType(String r1, int r2) {
        super(r1, r2);
    }
}
