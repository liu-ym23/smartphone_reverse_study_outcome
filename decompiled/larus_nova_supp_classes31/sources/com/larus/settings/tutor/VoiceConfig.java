package com.larus.settings.tutor;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0004\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/larus/settings/tutor/VoiceConfig;", "", "value", "", "isDefault", "", "<init>", "(Ljava/lang/Double;Ljava/lang/Boolean;)V", "getValue", "()Ljava/lang/Double;", "Ljava/lang/Double;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Boolean;)Lcom/larus/settings/tutor/VoiceConfig;", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class VoiceConfig {

    @SerializedName("is_default")
    private final Boolean isDefault;

    @SerializedName("value")
    private final Double value;

    /* JADX WARN: Multi-variable type inference failed */
    public VoiceConfig() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ VoiceConfig copy$default(VoiceConfig r0, Double r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.value;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isDefault;
    L9:
        return r0.copy(r1, r2);
    }

    public final Double component1() {
        return this.value;
    }

    public final Boolean component2() {
        return this.isDefault;
    }

    public final VoiceConfig copy(Double r2, Boolean r3) {
        return new VoiceConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VoiceConfig) == true) goto L8;
        return false;
    L8:
        VoiceConfig r6 = (VoiceConfig) r5;
        if (Intrinsics.areEqual(this.value, r6.value) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isDefault, r6.isDefault) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Double r0 = this.value;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isDefault;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "VoiceConfig(value=" + this.value + ", isDefault=" + this.isDefault + ')';
    }

    public final Double getValue() {
        return this.value;
    }

    public final Boolean isDefault() {
        return this.isDefault;
    }

    public VoiceConfig(Double r1, Boolean r2) {
        this.value = r1;
        this.isDefault = r2;
    }

    public /* synthetic */ VoiceConfig(Double r1, Boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = Boolean.FALSE;
    L8:
        this(r1, r2);
    }
}
