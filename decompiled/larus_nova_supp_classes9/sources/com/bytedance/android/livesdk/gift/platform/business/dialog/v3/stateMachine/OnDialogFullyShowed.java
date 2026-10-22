package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OnDialogFullyShowed;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "locateGiftInfo", "Lcom/bytedance/android/livesdk/chatroom/event/LocateGiftInfo;", "(Lcom/bytedance/android/livesdk/chatroom/event/LocateGiftInfo;)V", "getLocateGiftInfo", "()Lcom/bytedance/android/livesdk/chatroom/event/LocateGiftInfo;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnDialogFullyShowed extends GiftUIAction {
    private final LocateGiftInfo locateGiftInfo;

    public final LocateGiftInfo getLocateGiftInfo() {
        return this.locateGiftInfo;
    }

    public OnDialogFullyShowed(LocateGiftInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "locateGiftInfo");
        super(false, "OnDialogFullyShowed", 1, null);
        this.locateGiftInfo = r5;
    }
}
