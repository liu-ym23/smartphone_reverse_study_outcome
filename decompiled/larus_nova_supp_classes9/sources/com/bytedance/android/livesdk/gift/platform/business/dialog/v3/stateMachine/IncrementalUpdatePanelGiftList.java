package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/IncrementalUpdatePanelGiftList;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "receiverType", "Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;", "pageType", BuildConfig.FLAVOR, "topicId", BuildConfig.FLAVOR, "(Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;IJ)V", "getPageType", "()I", "getReceiverType", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;", "getTopicId", "()J", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IncrementalUpdatePanelGiftList extends GiftRepoAction {
    private final int pageType;
    private final ReceiverType receiverType;
    private final long topicId;

    public final int getPageType() {
        return this.pageType;
    }

    public final ReceiverType getReceiverType() {
        return this.receiverType;
    }

    public final long getTopicId() {
        return this.topicId;
    }

    public IncrementalUpdatePanelGiftList(ReceiverType r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "receiverType");
        super("IncrementalUpdatePanelGiftList");
        this.receiverType = r2;
        this.pageType = r3;
        this.topicId = r4;
    }

    public /* synthetic */ IncrementalUpdatePanelGiftList(ReceiverType r1, int r2, long r3, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = -1;
    L5:
        this(r1, r2, r3);
    }
}
