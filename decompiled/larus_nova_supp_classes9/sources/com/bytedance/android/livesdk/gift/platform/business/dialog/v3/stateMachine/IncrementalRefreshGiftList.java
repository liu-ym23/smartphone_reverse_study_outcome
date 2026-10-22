package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.k;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/IncrementalRefreshGiftList;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "Lcom/bytedance/android/livesdk/gift/model/w1;", "giftPage", "Lcom/bytedance/android/livesdk/gift/model/w1;", "getGiftPage", "()Lcom/bytedance/android/livesdk/gift/model/w1;", BuildConfig.FLAVOR, "scene", "I", "getScene", "()I", "Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;", "receiverType", "Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;", "getReceiverType", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;", "Lcom/bytedance/android/livesdk/gift/platform/core/giftlist/k;", "pagingGiftListModel", "Lcom/bytedance/android/livesdk/gift/platform/core/giftlist/k;", "getPagingGiftListModel", "()Lcom/bytedance/android/livesdk/gift/platform/core/giftlist/k;", BuildConfig.FLAVOR, "topicId", "J", "getTopicId", "()J", "<init>", "(Lcom/bytedance/android/livesdk/gift/model/w1;ILcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;Lcom/bytedance/android/livesdk/gift/platform/core/giftlist/k;J)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IncrementalRefreshGiftList extends GiftRepoAction {
    private final w1 giftPage;
    private final k pagingGiftListModel;
    private final ReceiverType receiverType;
    private final int scene;
    private final long topicId;

    public final w1 getGiftPage() {
        return this.giftPage;
    }

    public final k getPagingGiftListModel() {
        return this.pagingGiftListModel;
    }

    public final ReceiverType getReceiverType() {
        return this.receiverType;
    }

    public final int getScene() {
        return this.scene;
    }

    public final long getTopicId() {
        return this.topicId;
    }

    public IncrementalRefreshGiftList(w1 r2, int r3, ReceiverType r4, k r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "giftPage");
        Intrinsics.checkNotNullParameter(r4, "receiverType");
        super("IncrementalRefreshGiftList");
        this.giftPage = r2;
        this.scene = r3;
        this.receiverType = r4;
        this.pagingGiftListModel = r5;
        this.topicId = r6;
    }

    public /* synthetic */ IncrementalRefreshGiftList(w1 r8, int r9, ReceiverType r10, k r11, long r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 16) == 0) goto L5;
        r13 = -1;
    L5:
        this(r8, r9, r10, r11, r13);
    }
}
