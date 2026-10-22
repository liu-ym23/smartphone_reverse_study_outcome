package com.larus.dora.impl.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/larus/dora/impl/network/DoraDeviceGetInfoInfo;", "", "envObserveSwitch", "", "envObservePauseTimeSwitch", "envObservePauseTimeStart", "envObservePauseTimeEnd", "endObserveAgreeStatus", "envObserveLightingSwitch", "quickChatSwitch", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnvObserveSwitch", "()Ljava/lang/String;", "getEnvObservePauseTimeSwitch", "getEnvObservePauseTimeStart", "getEnvObservePauseTimeEnd", "getEndObserveAgreeStatus", "getEnvObserveLightingSwitch", "getQuickChatSwitch", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    @SerializedName("environmental_observation_agreement_status")
    private final String endObserveAgreeStatus;

    @SerializedName("environmental_observation_lighting_switch")
    private final String envObserveLightingSwitch;

    @SerializedName("environmental_observation_pause_timing_end_time")
    private final String envObservePauseTimeEnd;

    @SerializedName("environmental_observation_pause_timing_start_time")
    private final String envObservePauseTimeStart;

    @SerializedName("environmental_observation_pause_timing_switch")
    private final String envObservePauseTimeSwitch;

    @SerializedName("environmental_observation_switch")
    private final String envObserveSwitch;

    @SerializedName("quick_chat_switch")
    private final String quickChatSwitch;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.envObserveSwitch, r6.envObserveSwitch) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.envObservePauseTimeSwitch, r6.envObservePauseTimeSwitch) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.envObservePauseTimeStart, r6.envObservePauseTimeStart) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.envObservePauseTimeEnd, r6.envObservePauseTimeEnd) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.endObserveAgreeStatus, r6.endObserveAgreeStatus) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.envObserveLightingSwitch, r6.envObserveLightingSwitch) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.quickChatSwitch, r6.quickChatSwitch) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r0 = this.envObserveSwitch;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.envObservePauseTimeSwitch;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.envObservePauseTimeStart;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.envObservePauseTimeEnd;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.endObserveAgreeStatus;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.envObserveLightingSwitch;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r20 = this.quickChatSwitch;
        if (r20 == null) goto L31;
        r1 = r20.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
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

    public final String toString() {
        return "DoraDeviceGetInfoInfo(envObserveSwitch=" + this.envObserveSwitch + ", envObservePauseTimeSwitch=" + this.envObservePauseTimeSwitch + ", envObservePauseTimeStart=" + this.envObservePauseTimeStart + ", envObservePauseTimeEnd=" + this.envObservePauseTimeEnd + ", endObserveAgreeStatus=" + this.endObserveAgreeStatus + ", envObserveLightingSwitch=" + this.envObserveLightingSwitch + ", quickChatSwitch=" + this.quickChatSwitch + ')';
    }

    public g() {
        this.envObserveSwitch = null;
        this.envObservePauseTimeSwitch = null;
        this.envObservePauseTimeStart = null;
        this.envObservePauseTimeEnd = null;
        this.endObserveAgreeStatus = null;
        this.envObserveLightingSwitch = null;
        this.quickChatSwitch = null;
    }

    public final String a() {
        return this.endObserveAgreeStatus;
    }

    public final String b() {
        return this.envObserveLightingSwitch;
    }

    public final String c() {
        return this.envObservePauseTimeEnd;
    }

    public final String d() {
        return this.envObservePauseTimeStart;
    }

    public final String e() {
        return this.envObservePauseTimeSwitch;
    }

    public final String f() {
        return this.envObserveSwitch;
    }

    public final String g() {
        return this.quickChatSwitch;
    }
}
