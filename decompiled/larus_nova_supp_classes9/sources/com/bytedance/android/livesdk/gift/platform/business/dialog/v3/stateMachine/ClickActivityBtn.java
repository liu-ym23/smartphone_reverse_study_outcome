package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ClickActivityBtn;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "currentTabName", BuildConfig.FLAVOR, "(Ljava/lang/String;)V", "getCurrentTabName", "()Ljava/lang/String;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClickActivityBtn extends GiftUIAction {
    private final String currentTabName;

    public final String getCurrentTabName() {
        return this.currentTabName;
    }

    public ClickActivityBtn(String r5) {
        Intrinsics.checkNotNullParameter(r5, "currentTabName");
        super(false, "ClickActivityButton", 1, null);
        this.currentTabName = r5;
    }
}
