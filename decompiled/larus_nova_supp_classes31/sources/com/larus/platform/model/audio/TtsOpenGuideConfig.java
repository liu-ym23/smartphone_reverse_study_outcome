package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/audio/TtsOpenGuideConfig;", "", "enableEarphoneAuto", "", "enableOpenTtsGuide", "config", "Lcom/larus/platform/model/audio/GuideConfig;", "<init>", "(ZZLcom/larus/platform/model/audio/GuideConfig;)V", "getEnableEarphoneAuto", "()Z", "getEnableOpenTtsGuide", "getConfig", "()Lcom/larus/platform/model/audio/GuideConfig;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class TtsOpenGuideConfig {

    @SerializedName("guide_config")
    private final GuideConfig config;

    @SerializedName("enable_earphone_auto")
    private final boolean enableEarphoneAuto;

    @SerializedName("enable_open_tts_guide")
    private final boolean enableOpenTtsGuide;

    public TtsOpenGuideConfig() {
        this(false, false, null, 7, null);
    }

    public static /* synthetic */ TtsOpenGuideConfig copy$default(TtsOpenGuideConfig r0, boolean r1, boolean r2, GuideConfig r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enableEarphoneAuto;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.enableOpenTtsGuide;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.config;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.enableEarphoneAuto;
    }

    public final boolean component2() {
        return this.enableOpenTtsGuide;
    }

    public final GuideConfig component3() {
        return this.config;
    }

    public final TtsOpenGuideConfig copy(boolean r2, boolean r3, GuideConfig r4) {
        return new TtsOpenGuideConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TtsOpenGuideConfig) == true) goto L8;
        return false;
    L8:
        TtsOpenGuideConfig r6 = (TtsOpenGuideConfig) r5;
        if (this.enableEarphoneAuto == r6.enableEarphoneAuto) goto L12;
        return false;
    L12:
        if (this.enableOpenTtsGuide == r6.enableOpenTtsGuide) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.config, r6.config) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.enableEarphoneAuto == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableOpenTtsGuide == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        GuideConfig r4 = this.config;
        if (r4 != null) goto L13;
        int r5 = 0;
    L15:
        return r3 + r5;
    L13:
        r5 = r4.hashCode();
        goto L15
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "TtsOpenGuideConfig(enableEarphoneAuto=" + this.enableEarphoneAuto + ", enableOpenTtsGuide=" + this.enableOpenTtsGuide + ", config=" + this.config + ')';
    }

    public final GuideConfig getConfig() {
        return this.config;
    }

    public final boolean getEnableEarphoneAuto() {
        return this.enableEarphoneAuto;
    }

    public final boolean getEnableOpenTtsGuide() {
        return this.enableOpenTtsGuide;
    }

    public TtsOpenGuideConfig(boolean r1, boolean r2, GuideConfig r3) {
        this.enableEarphoneAuto = r1;
        this.enableOpenTtsGuide = r2;
        this.config = r3;
    }

    public /* synthetic */ TtsOpenGuideConfig(boolean r8, boolean r9, GuideConfig r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r8 = false;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r9 = false;
    L9:
        if ((r11 & 4) == 0) goto L11;
        r10 = new GuideConfig(0.0f, 0, 0.0f, 0.0f, 15, null);
    L11:
        this(r8, r9, r10);
    }
}
