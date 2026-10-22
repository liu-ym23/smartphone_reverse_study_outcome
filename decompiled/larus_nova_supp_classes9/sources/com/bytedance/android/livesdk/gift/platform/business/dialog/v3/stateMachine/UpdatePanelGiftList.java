package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/UpdatePanelGiftList;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "receiverType", "Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;", "(Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;)V", "getReceiverType", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdatePanelGiftList extends GiftRepoAction {
    private final ReceiverType receiverType;

    public final ReceiverType getReceiverType() {
        return this.receiverType;
    }

    public UpdatePanelGiftList(ReceiverType r2) {
        Intrinsics.checkNotNullParameter(r2, "receiverType");
        super("RefreshGiftList");
        this.receiverType = r2;
    }
}
