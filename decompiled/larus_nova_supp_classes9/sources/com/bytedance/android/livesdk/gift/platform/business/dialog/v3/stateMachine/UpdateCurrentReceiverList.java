package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.h;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/UpdateCurrentReceiverList;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/repo/receiver/h;", "currentReceivers", "Ljava/util/List;", "getCurrentReceivers", "()Ljava/util/List;", BuildConfig.FLAVOR, "triggerByReceiverPanel", "Z", "getTriggerByReceiverPanel", "()Z", "<init>", "(Ljava/util/List;Z)V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UpdateCurrentReceiverList extends GiftRepoAction {
    private final List<h> currentReceivers;
    private final boolean triggerByReceiverPanel;

    public final List<h> getCurrentReceivers() {
        return this.currentReceivers;
    }

    public final boolean getTriggerByReceiverPanel() {
        return this.triggerByReceiverPanel;
    }

    public UpdateCurrentReceiverList(List<h> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "currentReceivers");
        super("UpdateMultiSendReceiver");
        this.currentReceivers = r2;
        this.triggerByReceiverPanel = r3;
    }
}
