package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopVisibleChanged;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftPanelEffect;", "visible", BuildConfig.FLAVOR, "pagerPosition", BuildConfig.FLAVOR, "selectedPosition", "source", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/UpdateTopViewSource;", "isSearch", "(ZIILcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/UpdateTopViewSource;Z)V", "()Z", "getPagerPosition", "()I", "getSelectedPosition", "getSource", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/UpdateTopViewSource;", "getVisible", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTopVisibleChanged implements GiftPanelEffect {
    private final boolean isSearch;
    private final int pagerPosition;
    private final int selectedPosition;
    private final UpdateTopViewSource source;
    private final boolean visible;

    public final int getPagerPosition() {
        return this.pagerPosition;
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final UpdateTopViewSource getSource() {
        return this.source;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final boolean isSearch() {
        return this.isSearch;
    }

    public GiftTopVisibleChanged(boolean r2, int r3, int r4, UpdateTopViewSource r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "source");
        this.visible = r2;
        this.pagerPosition = r3;
        this.selectedPosition = r4;
        this.source = r5;
        this.isSearch = r6;
    }
}
