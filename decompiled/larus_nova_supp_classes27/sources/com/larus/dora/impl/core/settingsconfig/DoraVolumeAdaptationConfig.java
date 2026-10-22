package com.larus.dora.impl.core.settingsconfig;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015JJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/larus/dora/impl/core/settingsconfig/DoraVolumeAdaptationConfig;", "", "maxGain", "", "maxVolumeLevelRange", "", "maxIncDb", "maxDecDb", "defaultState", "", "<init>", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;)V", "getMaxGain", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getMaxVolumeLevelRange", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxIncDb", "getMaxDecDb", "getDefaultState", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;)Lcom/larus/dora/impl/core/settingsconfig/DoraVolumeAdaptationConfig;", "equals", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraVolumeAdaptationConfig {

    @SerializedName("adaptation_default")
    private final Boolean defaultState;

    @SerializedName("adaptation_max_dec_db")
    private final Float maxDecDb;

    @SerializedName("adaptation_max_gain")
    private final Float maxGain;

    @SerializedName("adaptation_max_inc_db")
    private final Float maxIncDb;

    @SerializedName("adaptation_max_volume_level_range")
    private final Integer maxVolumeLevelRange;

    public DoraVolumeAdaptationConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ DoraVolumeAdaptationConfig copy$default(DoraVolumeAdaptationConfig r3, Float r4, Integer r5, Float r6, Float r7, Boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.maxGain;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.maxVolumeLevelRange;
    L8:
        Integer r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.maxIncDb;
    L11:
        Float r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.maxDecDb;
    L14:
        Float r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.defaultState;
    L17:
        Float r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final Float component1() {
        return this.maxGain;
    }

    public final Integer component2() {
        return this.maxVolumeLevelRange;
    }

    public final Float component3() {
        return this.maxIncDb;
    }

    public final Float component4() {
        return this.maxDecDb;
    }

    public final Boolean component5() {
        return this.defaultState;
    }

    public final DoraVolumeAdaptationConfig copy(Float r8, Integer r9, Float r10, Float r11, Boolean r12) {
        return new DoraVolumeAdaptationConfig(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraVolumeAdaptationConfig) == true) goto L8;
        return false;
    L8:
        DoraVolumeAdaptationConfig r6 = (DoraVolumeAdaptationConfig) r5;
        if (Intrinsics.areEqual(this.maxGain, r6.maxGain) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxVolumeLevelRange, r6.maxVolumeLevelRange) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxIncDb, r6.maxIncDb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxDecDb, r6.maxDecDb) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.defaultState, r6.defaultState) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Float r0 = this.maxGain;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.maxVolumeLevelRange;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Float r7 = this.maxIncDb;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Float r10 = this.maxDecDb;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.defaultState;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DoraVolumeAdaptationConfig(maxGain=" + this.maxGain + ", maxVolumeLevelRange=" + this.maxVolumeLevelRange + ", maxIncDb=" + this.maxIncDb + ", maxDecDb=" + this.maxDecDb + ", defaultState=" + this.defaultState + ')';
    }

    public final Boolean getDefaultState() {
        return this.defaultState;
    }

    public final Float getMaxDecDb() {
        return this.maxDecDb;
    }

    public final Float getMaxGain() {
        return this.maxGain;
    }

    public final Float getMaxIncDb() {
        return this.maxIncDb;
    }

    public final Integer getMaxVolumeLevelRange() {
        return this.maxVolumeLevelRange;
    }

    public DoraVolumeAdaptationConfig(Float r1, Integer r2, Float r3, Float r4, Boolean r5) {
        this.maxGain = r1;
        this.maxVolumeLevelRange = r2;
        this.maxIncDb = r3;
        this.maxDecDb = r4;
        this.defaultState = r5;
    }

    public /* synthetic */ DoraVolumeAdaptationConfig(Float r5, Integer r6, Float r7, Float r8, Boolean r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        Float r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        Integer r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        Float r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        Float r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        Boolean r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
