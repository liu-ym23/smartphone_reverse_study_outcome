package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.framework.base.TraceExclude;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/RefreshGiftList;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/w1;", "giftPages", "Ljava/util/List;", "getGiftPages", "()Ljava/util/List;", BuildConfig.FLAVOR, "scene", "I", "getScene", "()I", "Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;", "receiverType", "Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;", "getReceiverType", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;", BuildConfig.FLAVOR, "requestTime", "J", "getRequestTime", "()J", "<init>", "(Ljava/util/List;ILcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;J)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RefreshGiftList extends GiftRepoAction {

    @TraceExclude
    private final List<w1> giftPages;
    private final ReceiverType receiverType;
    private final long requestTime;
    private final int scene;

    public final List<w1> getGiftPages() {
        return this.giftPages;
    }

    public final ReceiverType getReceiverType() {
        return this.receiverType;
    }

    public final long getRequestTime() {
        return this.requestTime;
    }

    public final int getScene() {
        return this.scene;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RefreshGiftList(List<? extends w1> r2, int r3, ReceiverType r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "giftPages");
        Intrinsics.checkNotNullParameter(r4, "receiverType");
        super("RefreshGiftList");
        this.giftPages = r2;
        this.scene = r3;
        this.receiverType = r4;
        this.requestTime = r5;
    }
}
