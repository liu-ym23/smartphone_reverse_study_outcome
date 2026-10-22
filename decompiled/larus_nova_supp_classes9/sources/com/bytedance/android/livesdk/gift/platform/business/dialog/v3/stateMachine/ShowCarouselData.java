package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u001f\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShowCarouselData;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "component1", "Lcom/bytedance/android/livesdk/gift/model/g0;", "component2", "canShow", "extraInfo", "copy", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "hashCode", "other", "equals", "Z", "getCanShow", "()Z", "Lcom/bytedance/android/livesdk/gift/model/g0;", "getExtraInfo", "()Lcom/bytedance/android/livesdk/gift/model/g0;", "<init>", "(ZLcom/bytedance/android/livesdk/gift/model/g0;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowCarouselData {
    private final boolean canShow;
    private final g0 extraInfo;

    public ShowCarouselData() {
        g0 r0 = null;
        boolean r2 = false;
        this(r2, r0, 3, r0);
    }

    public static /* synthetic */ ShowCarouselData copy$default(ShowCarouselData r0, boolean r1, g0 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.canShow;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.extraInfo;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.canShow;
    }

    public final g0 component2() {
        return this.extraInfo;
    }

    public final ShowCarouselData copy(boolean r2, g0 r3) {
        return new ShowCarouselData(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ShowCarouselData) == false) goto L10;
        ShowCarouselData r4 = (ShowCarouselData) r3;
        if (this.canShow == r4.canShow) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extraInfo, r4.extraInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r0 = this.canShow;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        g0 r3 = this.extraInfo;
        if (r3 == null) goto L8;
        int r4 = r3.hashCode();
    L10:
        return r2 + r4;
    L8:
        r4 = 0;
        goto L10
    }

    public String toString() {
        return "ShowCarouselData(canShow=" + this.canShow + ", extraInfo=" + this.extraInfo + ")";
    }

    public final boolean getCanShow() {
        return this.canShow;
    }

    public final g0 getExtraInfo() {
        return this.extraInfo;
    }

    public ShowCarouselData(boolean r1, g0 r2) {
        this.canShow = r1;
        this.extraInfo = r2;
    }

    public /* synthetic */ ShowCarouselData(boolean r1, g0 r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }
}
