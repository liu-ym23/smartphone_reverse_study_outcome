package com.ss.android.lark.preload;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "preload_strategy_config")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/preload/StrategyConfig;", "", "bizFrequencyDisableValue", "", "hitRateDisableValue", "<init>", "(DD)V", "getBizFrequencyDisableValue", "()D", "getHitRateDisableValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "preload-manager_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class StrategyConfig {

    @SerializedName("biz_frequency_disable_value")
    private final double bizFrequencyDisableValue;

    @SerializedName("hit_rate_disable_value")
    private final double hitRateDisableValue;

    public StrategyConfig() {
        this(0.0d, 0.0d, 3, null);
    }

    public static /* synthetic */ StrategyConfig copy$default(StrategyConfig r0, double r1, double r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.bizFrequencyDisableValue;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.hitRateDisableValue;
    L9:
        return r0.copy(r1, r3);
    }

    public final double component1() {
        return this.bizFrequencyDisableValue;
    }

    public final double component2() {
        return this.hitRateDisableValue;
    }

    public final StrategyConfig copy(double r2, double r4) {
        return new StrategyConfig(r2, r4);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof StrategyConfig) == true) goto L8;
        return false;
    L8:
        StrategyConfig r9 = (StrategyConfig) r8;
        if (Double.compare(this.bizFrequencyDisableValue, r9.bizFrequencyDisableValue) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.hitRateDisableValue, r9.hitRateDisableValue) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r0 = Double.doubleToLongBits(this.bizFrequencyDisableValue);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = Double.doubleToLongBits(this.hitRateDisableValue);
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public String toString() {
        return "StrategyConfig(bizFrequencyDisableValue=" + this.bizFrequencyDisableValue + ", hitRateDisableValue=" + this.hitRateDisableValue + ')';
    }

    public final double getBizFrequencyDisableValue() {
        return this.bizFrequencyDisableValue;
    }

    public final double getHitRateDisableValue() {
        return this.hitRateDisableValue;
    }

    public StrategyConfig(double r1, double r3) {
        this.bizFrequencyDisableValue = r1;
        this.hitRateDisableValue = r3;
    }

    public /* synthetic */ StrategyConfig(double r3, double r5, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = -1.0d;
    L6:
        if ((r7 & 2) == 0) goto L8;
        r5 = -1.0d;
    L8:
        this(r3, r5);
    }
}
