package com.bytedance.android.live.effect.common;

import com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerLoadingStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class p {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[StickerLoadingStatus.values().length];
        a = r0;
        r0[StickerLoadingStatus.Loading.ordinal()] = 1;
        r0[StickerLoadingStatus.Error.ordinal()] = 2;
        r0[StickerLoadingStatus.Normal.ordinal()] = 3;
    }
}
