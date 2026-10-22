package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/platform/model/audio/VoiceRecommendConfig;", "", "enable", "", "voiceHotEnable", "<init>", "(ZZ)V", "getEnable", "()Z", "getVoiceHotEnable", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class VoiceRecommendConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("voice_hot_enable")
    private final boolean voiceHotEnable;

    public VoiceRecommendConfig() {
        boolean r2 = false;
        this(r2, r2, 3, null);
    }

    public static /* synthetic */ VoiceRecommendConfig copy$default(VoiceRecommendConfig r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.voiceHotEnable;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final boolean component2() {
        return this.voiceHotEnable;
    }

    public final VoiceRecommendConfig copy(boolean r2, boolean r3) {
        return new VoiceRecommendConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VoiceRecommendConfig) == true) goto L8;
        return false;
    L8:
        VoiceRecommendConfig r6 = (VoiceRecommendConfig) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (this.voiceHotEnable == r6.voiceHotEnable) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.voiceHotEnable == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "VoiceRecommendConfig(enable=" + this.enable + ", voiceHotEnable=" + this.voiceHotEnable + ')';
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getVoiceHotEnable() {
        return this.voiceHotEnable;
    }

    public VoiceRecommendConfig(boolean r1, boolean r2) {
        this.enable = r1;
        this.voiceHotEnable = r2;
    }

    public /* synthetic */ VoiceRecommendConfig(boolean r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = true;
    L8:
        this(r1, r2);
    }
}
