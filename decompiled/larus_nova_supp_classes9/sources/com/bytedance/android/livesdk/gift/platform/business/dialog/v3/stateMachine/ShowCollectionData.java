package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShowCollectionData;", BuildConfig.FLAVOR, "canShow", BuildConfig.FLAVOR, "(Z)V", "getCanShow", "()Z", "component1", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowCollectionData {
    private final boolean canShow;

    public ShowCollectionData() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public static /* synthetic */ ShowCollectionData copy$default(ShowCollectionData r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.canShow;
    L6:
        return r0.copy(r1);
    }

    public final boolean component1() {
        return this.canShow;
    }

    public final ShowCollectionData copy(boolean r2) {
        return new ShowCollectionData(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof ShowCollectionData) == true) goto L6;
        return false;
    L6:
        if (this.canShow == ((ShowCollectionData) r2).canShow) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        boolean r0 = this.canShow;
        if (r0 == false) goto L6;
        return 1;
    L6:
        return r0 ? 1 : 0;
    }

    public String toString() {
        return "ShowCollectionData(canShow=" + this.canShow + ")";
    }

    public final boolean getCanShow() {
        return this.canShow;
    }

    public ShowCollectionData(boolean r1) {
        this.canShow = r1;
    }

    public /* synthetic */ ShowCollectionData(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }
}
