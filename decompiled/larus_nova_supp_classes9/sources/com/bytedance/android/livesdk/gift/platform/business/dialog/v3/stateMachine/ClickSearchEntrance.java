package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ClickSearchEntrance;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "isNormalSearch", BuildConfig.FLAVOR, "isCloseGiftDialog", "(ZZ)V", "()Z", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClickSearchEntrance extends GiftUIAction {
    private final boolean isCloseGiftDialog;
    private final boolean isNormalSearch;

    public final boolean isCloseGiftDialog() {
        return this.isCloseGiftDialog;
    }

    public final boolean isNormalSearch() {
        return this.isNormalSearch;
    }

    public ClickSearchEntrance(boolean r5, boolean r6) {
        super(false, "ClickSearchEntrance", 1, null);
        this.isNormalSearch = r5;
        this.isCloseGiftDialog = r6;
    }
}
