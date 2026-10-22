package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LiveStickerDialogV2$getPageStatus$currentPageStatus$1 extends MutablePropertyReference0Impl {
    public LiveStickerDialogV2$getPageStatus$currentPageStatus$1(LiveStickerDialogV2 r7) {
        super(r7, LiveStickerDialogV2.class, "stickerDataViewModel", "getStickerDataViewModel()Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDataViewModel;", 0);
    }

    public Object get() {
        StickerDataViewModel r0 = ((LiveStickerDialogV2) ((CallableReference) this).receiver).f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L5:
        return r0;
    }

    public void set(Object r2) {
        StickerDataViewModel r3 = (StickerDataViewModel) r2;
        ((LiveStickerDialogV2) ((CallableReference) this).receiver).f = r3;
    }
}
