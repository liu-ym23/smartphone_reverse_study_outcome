package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/q;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "buffLevel", "I", "getBuffLevel", "()I", "minPayGradeLevel", "getMinPayGradeLevel", "preChargeDiamond", "getPreChargeDiamond", "reimbursementDiamond", "getReimbursementDiamond", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("buff_level")
    private final int buffLevel;

    @SerializedName("min_pay_grade_level")
    private final int minPayGradeLevel;

    @SerializedName("pre_charge_diamond")
    private final int preChargeDiamond;

    @SerializedName("reimbursement_diamond")
    private final int reimbursementDiamond;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof q) == false) goto L14;
        q r4 = (q) r3;
        if (this.buffLevel == r4.buffLevel) goto L8;
        return false;
    L8:
        if (this.minPayGradeLevel == r4.minPayGradeLevel) goto L10;
        return false;
    L10:
        if (this.preChargeDiamond == r4.preChargeDiamond) goto L12;
        return false;
    L12:
        if (this.reimbursementDiamond == r4.reimbursementDiamond) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.buffLevel * 31) + this.minPayGradeLevel) * 31) + this.preChargeDiamond) * 31) + this.reimbursementDiamond;
    }

    public final String toString() {
        return "GradeBuffItem(buffLevel=" + this.buffLevel + ", minPayGradeLevel=" + this.minPayGradeLevel + ", preChargeDiamond=" + this.preChargeDiamond + ", reimbursementDiamond=" + this.reimbursementDiamond + ")";
    }

    public q() {
        this.buffLevel = 0;
        this.minPayGradeLevel = 0;
        this.preChargeDiamond = 0;
        this.reimbursementDiamond = 0;
    }
}
