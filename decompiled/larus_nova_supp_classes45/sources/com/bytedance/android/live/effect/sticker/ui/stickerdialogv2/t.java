package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import androidx.lifecycle.Observer;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t<T> implements Observer {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public t(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        List r3 = (List) r2;
        StickerDataViewModel r4 = this.a.f;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L5:
        r4.updateCampaignTabStatus();
    }
}
