package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OnComboSingleClickStart;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "isSearch", BuildConfig.FLAVOR, "(Z)V", "()Z", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnComboSingleClickStart extends GiftUIAction {
    private final boolean isSearch;

    public OnComboSingleClickStart() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public final boolean isSearch() {
        return this.isSearch;
    }

    public OnComboSingleClickStart(boolean r5) {
        super(false, "OnComboSingleClickStart", 1, null);
        this.isSearch = r5;
    }

    public /* synthetic */ OnComboSingleClickStart(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }
}
