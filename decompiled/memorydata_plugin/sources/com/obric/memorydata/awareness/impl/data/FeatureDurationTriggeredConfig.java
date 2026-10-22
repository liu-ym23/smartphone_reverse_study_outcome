package com.obric.memorydata.awareness.impl.data;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/awareness/impl/data/FeatureDurationTriggeredConfig;", "", "featureName", "", "targetFeatureValue", "durationSeconds", "", "oneShot", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JZ)V", "getFeatureName", "()Ljava/lang/String;", "getTargetFeatureValue", "getDurationSeconds", "()J", "getOneShot", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FeatureDurationTriggeredConfig {

    @SerializedName("duration_seconds")
    private final long durationSeconds;

    @SerializedName("feature_name")
    private final String featureName;

    @SerializedName("one_shot")
    private final boolean oneShot;

    @SerializedName("target_feature_value")
    private final String targetFeatureValue;

    public FeatureDurationTriggeredConfig(String r2, String r3, long r4, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        Intrinsics.checkNotNullParameter(r3, "targetFeatureValue");
        this.featureName = r2;
        this.targetFeatureValue = r3;
        this.durationSeconds = r4;
        this.oneShot = r6;
    }

    public /* synthetic */ FeatureDurationTriggeredConfig(String r7, String r8, long r9, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = false;
    L5:
        this(r7, r8, r9, r11);
    }

    public static /* synthetic */ FeatureDurationTriggeredConfig copy$default(FeatureDurationTriggeredConfig r3, String r4, String r5, long r6, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.featureName;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.targetFeatureValue;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.durationSeconds;
    L11:
        long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.oneShot;
    L14:
        String r7 = r4;
        return r3.copy(r7, r11, r0, r8);
    }

    public final String component1() {
        return this.featureName;
    }

    public final String component2() {
        return this.targetFeatureValue;
    }

    public final long component3() {
        return this.durationSeconds;
    }

    public final boolean component4() {
        return this.oneShot;
    }

    public final FeatureDurationTriggeredConfig copy(String r7, String r8, long r9, boolean r11) {
        Intrinsics.checkNotNullParameter(r7, "featureName");
        Intrinsics.checkNotNullParameter(r8, "targetFeatureValue");
        return new FeatureDurationTriggeredConfig(r7, r8, r9, r11);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, FeatureDurationTriggeredConfig.class) == true) goto L8;
        return false;
    L8:
        FeatureDurationTriggeredConfig r10 = (FeatureDurationTriggeredConfig) ZeusTransformUtils.preCheckCast(r9, FeatureDurationTriggeredConfig.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.featureName, r10.featureName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.targetFeatureValue, r10.targetFeatureValue) == true) goto L15;
        return false;
    L15:
        if (this.durationSeconds == r10.durationSeconds) goto L18;
        return false;
    L18:
        if (this.oneShot == r10.oneShot) goto L20;
        return false;
    L20:
        return true;
    }

    public final long getDurationSeconds() {
        return this.durationSeconds;
    }

    public final String getFeatureName() {
        return this.featureName;
    }

    public final boolean getOneShot() {
        return this.oneShot;
    }

    public final String getTargetFeatureValue() {
        return this.targetFeatureValue;
    }

    public int hashCode() {
        return (((((this.featureName.hashCode() * 31) + this.targetFeatureValue.hashCode()) * 31) + Long.hashCode(this.durationSeconds)) * 31) + Boolean.hashCode(this.oneShot);
    }

    public String toString() {
        return "FeatureDurationTriggeredConfig(featureName=" + this.featureName + ", targetFeatureValue=" + this.targetFeatureValue + ", durationSeconds=" + this.durationSeconds + ", oneShot=" + this.oneShot + ')';
    }
}
