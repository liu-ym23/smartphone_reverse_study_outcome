package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.model.l1;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/UpdateSelectedBuffCard;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "Lcom/bytedance/android/livesdk/gift/model/l1;", "selectedBuffCard", "Lcom/bytedance/android/livesdk/gift/model/l1;", "getSelectedBuffCard", "()Lcom/bytedance/android/livesdk/gift/model/l1;", "<init>", "(Lcom/bytedance/android/livesdk/gift/model/l1;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdateSelectedBuffCard extends GiftRepoAction {
    private final l1 selectedBuffCard;

    public final l1 getSelectedBuffCard() {
        return this.selectedBuffCard;
    }

    public UpdateSelectedBuffCard(l1 r2) {
        super("UpdateSelectedBuffCard");
        this.selectedBuffCard = r2;
    }
}
