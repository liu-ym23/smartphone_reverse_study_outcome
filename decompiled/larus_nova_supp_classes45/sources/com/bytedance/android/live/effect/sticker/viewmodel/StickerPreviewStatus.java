package com.bytedance.android.live.effect.sticker.viewmodel;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerPreviewStatus;", "", "None", "Downgrade", "Preview", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StickerPreviewStatus extends Enum<StickerPreviewStatus> {
    public static final StickerPreviewStatus Downgrade = null;
    public static final StickerPreviewStatus None = null;
    public static final StickerPreviewStatus Preview = null;
    public static final /* synthetic */ StickerPreviewStatus[] a = null;

    static {
        StickerPreviewStatus r1 = new StickerPreviewStatus("None", 0);
        None = r1;
        StickerPreviewStatus r2 = new StickerPreviewStatus("Downgrade", 1);
        Downgrade = r2;
        StickerPreviewStatus r3 = new StickerPreviewStatus("Preview", 2);
        Preview = r3;
        a = new StickerPreviewStatus[]{r1, r2, r3};
    }

    public static StickerPreviewStatus valueOf(String r1) {
        return (StickerPreviewStatus) r27.a.a(StickerPreviewStatus.class, r1);
    }

    public static StickerPreviewStatus[] values() {
        return (StickerPreviewStatus[]) a.clone();
    }

    public StickerPreviewStatus(String r1, int r2) {
        super(r1, r2);
    }
}
