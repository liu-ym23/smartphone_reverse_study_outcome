package com.bytedance.android.live.effect.common;

import androidx.lifecycle.Observer;
import com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerLoadingStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s<T> implements Observer {
    public final /* synthetic */ LiveCommonStickerListView a;

    public s(LiveCommonStickerListView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        LiveCommonStickerListView r0 = this.a;
        LiveCommonStickerListView.Z5(r0, (StickerLoadingStatus) r2);
    }
}
