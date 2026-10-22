package com.larus.dora.impl.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/settings/DoraGAmbientVolumeConfig;", "", "ambientVolumeSwitch", "", "antiSoundLeakSwitch", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAmbientVolumeSwitch", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAntiSoundLeakSwitch", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/dora/impl/settings/DoraGAmbientVolumeConfig;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGAmbientVolumeConfig {

    @SerializedName("ambient_volume_switch")
    private final Boolean ambientVolumeSwitch;

    @SerializedName("anti_sound_leak_switch")
    private final Boolean antiSoundLeakSwitch;

    public DoraGAmbientVolumeConfig() {
        Boolean r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ DoraGAmbientVolumeConfig copy$default(DoraGAmbientVolumeConfig r0, Boolean r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.ambientVolumeSwitch;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.antiSoundLeakSwitch;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.ambientVolumeSwitch;
    }

    public final Boolean component2() {
        return this.antiSoundLeakSwitch;
    }

    public final DoraGAmbientVolumeConfig copy(Boolean r2, Boolean r3) {
        return new DoraGAmbientVolumeConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraGAmbientVolumeConfig) == true) goto L8;
        return false;
    L8:
        DoraGAmbientVolumeConfig r6 = (DoraGAmbientVolumeConfig) r5;
        if (Intrinsics.areEqual(this.ambientVolumeSwitch, r6.ambientVolumeSwitch) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.antiSoundLeakSwitch, r6.antiSoundLeakSwitch) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.ambientVolumeSwitch;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.antiSoundLeakSwitch;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DoraGAmbientVolumeConfig(ambientVolumeSwitch=" + this.ambientVolumeSwitch + ", antiSoundLeakSwitch=" + this.antiSoundLeakSwitch + ')';
    }

    public final Boolean getAmbientVolumeSwitch() {
        return this.ambientVolumeSwitch;
    }

    public final Boolean getAntiSoundLeakSwitch() {
        return this.antiSoundLeakSwitch;
    }

    public DoraGAmbientVolumeConfig(Boolean r1, Boolean r2) {
        this.ambientVolumeSwitch = r1;
        this.antiSoundLeakSwitch = r2;
    }

    public /* synthetic */ DoraGAmbientVolumeConfig(Boolean r2, Boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
