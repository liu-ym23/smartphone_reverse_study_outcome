package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/TryLoadMoreAction;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "pageType", BuildConfig.FLAVOR, "selectedTopicId", BuildConfig.FLAVOR, "(IJ)V", "getPageType", "()I", "getSelectedTopicId", "()J", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TryLoadMoreAction extends GiftUIAction {
    private final int pageType;
    private final long selectedTopicId;

    public final int getPageType() {
        return this.pageType;
    }

    public final long getSelectedTopicId() {
        return this.selectedTopicId;
    }

    public TryLoadMoreAction(int r5, long r6) {
        super(false, "TryLoadMoreAction", 1, null);
        this.pageType = r5;
        this.selectedTopicId = r6;
    }
}
