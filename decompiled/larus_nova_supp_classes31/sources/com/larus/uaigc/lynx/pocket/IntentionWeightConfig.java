package com.larus.uaigc.lynx.pocket;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/IntentionWeightConfig;", "", "intentionType", "", "weight", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getIntentionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWeight", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/uaigc/lynx/pocket/IntentionWeightConfig;", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class IntentionWeightConfig {

    @SerializedName("intention_type")
    private final Integer intentionType;

    @SerializedName("weight")
    private final Integer weight;

    public IntentionWeightConfig() {
        Integer r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ IntentionWeightConfig copy$default(IntentionWeightConfig r0, Integer r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.intentionType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.weight;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.intentionType;
    }

    public final Integer component2() {
        return this.weight;
    }

    public final IntentionWeightConfig copy(Integer r2, Integer r3) {
        return new IntentionWeightConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IntentionWeightConfig) == true) goto L8;
        return false;
    L8:
        IntentionWeightConfig r6 = (IntentionWeightConfig) r5;
        if (Intrinsics.areEqual(this.intentionType, r6.intentionType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.weight, r6.weight) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.intentionType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.weight;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "IntentionWeightConfig(intentionType=" + this.intentionType + ", weight=" + this.weight + ')';
    }

    public final Integer getIntentionType() {
        return this.intentionType;
    }

    public final Integer getWeight() {
        return this.weight;
    }

    public IntentionWeightConfig(Integer r1, Integer r2) {
        this.intentionType = r1;
        this.weight = r2;
    }

    public /* synthetic */ IntentionWeightConfig(Integer r2, Integer r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
