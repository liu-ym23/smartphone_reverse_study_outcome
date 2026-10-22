package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanelStatus;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerPreviewStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class h {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[StickerLoadingStatus.values().length];
        a = r0;
        r0[StickerLoadingStatus.Normal.ordinal()] = 1;
        r0[StickerLoadingStatus.Loading.ordinal()] = 2;
        r0[StickerLoadingStatus.Error.ordinal()] = 3;
        int[] r1 = new int[StickerPreviewStatus.values().length];
        b = r1;
        r1[StickerPreviewStatus.None.ordinal()] = 1;
        r1[StickerPreviewStatus.Preview.ordinal()] = 2;
        r1[StickerPreviewStatus.Downgrade.ordinal()] = 3;
        int[] r2 = new int[AigcTaskPanelStatus.values().length];
        c = r2;
        r2[AigcTaskPanelStatus.Done.ordinal()] = 1;
        r2[AigcTaskPanelStatus.Ready.ordinal()] = 2;
        r2[AigcTaskPanelStatus.Running.ordinal()] = 3;
    }
}
