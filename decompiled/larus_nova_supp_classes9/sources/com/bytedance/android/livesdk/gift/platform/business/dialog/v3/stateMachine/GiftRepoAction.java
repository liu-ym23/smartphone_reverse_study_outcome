package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftAction;", "tag", BuildConfig.FLAVOR, "(Ljava/lang/String;)V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class GiftRepoAction extends GiftAction {
    public GiftRepoAction(String r9) {
        Intrinsics.checkNotNullParameter(r9, "tag");
        super(false, r9, 0, 5, null);
    }
}
