package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftAction;", "needListen", BuildConfig.FLAVOR, "tag", BuildConfig.FLAVOR, "(ZLjava/lang/String;)V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class GiftUIAction extends GiftAction {
    public GiftUIAction(boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        super(r9, r10, 0, 4, null);
    }

    public /* synthetic */ GiftUIAction(boolean r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = true;
    L5:
        this(r1, r2);
    }
}
