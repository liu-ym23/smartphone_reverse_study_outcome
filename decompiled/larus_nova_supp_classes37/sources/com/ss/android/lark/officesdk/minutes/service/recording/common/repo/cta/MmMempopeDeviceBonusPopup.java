package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmMempopeDeviceBonusPopup;", "Ljava/io/Serializable;", "isShow", "", "featureDetail", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "<init>", "(ZLcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;)V", "()Z", "getFeatureDetail", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmMempopeDeviceBonusPopup implements Serializable {

    @SerializedName("feature_detail")
    private final MmFeatureDetail featureDetail;

    @SerializedName("is_show")
    private final boolean isShow;

    public MmMempopeDeviceBonusPopup() {
        MmFeatureDetail r0 = null;
        boolean r2 = false;
        this(r2, r0, 3, r0);
    }

    public static /* synthetic */ MmMempopeDeviceBonusPopup copy$default(MmMempopeDeviceBonusPopup r0, boolean r1, MmFeatureDetail r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.isShow;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.featureDetail;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.isShow;
    }

    public final MmFeatureDetail component2() {
        return this.featureDetail;
    }

    public final MmMempopeDeviceBonusPopup copy(boolean r2, MmFeatureDetail r3) {
        return new MmMempopeDeviceBonusPopup(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmMempopeDeviceBonusPopup) == true) goto L8;
        return false;
    L8:
        MmMempopeDeviceBonusPopup r6 = (MmMempopeDeviceBonusPopup) r5;
        if (this.isShow == r6.isShow) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.featureDetail, r6.featureDetail) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.isShow == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        MmFeatureDetail r2 = this.featureDetail;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "MmMempopeDeviceBonusPopup(isShow=" + this.isShow + ", featureDetail=" + this.featureDetail + ')';
    }

    public final MmFeatureDetail getFeatureDetail() {
        return this.featureDetail;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public MmMempopeDeviceBonusPopup(boolean r1, MmFeatureDetail r2) {
        this.isShow = r1;
        this.featureDetail = r2;
    }

    public /* synthetic */ MmMempopeDeviceBonusPopup(boolean r1, MmFeatureDetail r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }
}
