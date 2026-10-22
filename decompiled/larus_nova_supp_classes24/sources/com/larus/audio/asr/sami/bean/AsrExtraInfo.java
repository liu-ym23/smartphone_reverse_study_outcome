package com.larus.audio.asr.sami.bean;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006#"}, d2 = {"Lcom/larus/audio/asr/sami/bean/AsrExtraInfo;", "", "asrMode", "", "appKey", "token", "language", "extraConfig", "maxRetryTime", "", "maxTimeOutDuration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAsrMode", "()Ljava/lang/String;", "getAppKey", "getToken", "getLanguage", "getExtraConfig", "getMaxRetryTime", "()I", "getMaxTimeOutDuration", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AsrExtraInfo {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("asr_mode")
    private final String asrMode;

    @SerializedName("extra_config")
    private final String extraConfig;

    @SerializedName("language")
    private final String language;

    @SerializedName("max_retry_time")
    private final int maxRetryTime;

    @SerializedName("time_out_duration")
    private final int maxTimeOutDuration;

    @SerializedName("token")
    private final String token;

    public AsrExtraInfo() {
        this(null, null, null, null, null, 0, 0, 127, null);
    }

    public static /* synthetic */ AsrExtraInfo copy$default(AsrExtraInfo r5, String r6, String r7, String r8, String r9, String r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.asrMode;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.appKey;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.token;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.language;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.extraConfig;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.maxRetryTime;
    L20:
        int r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.maxTimeOutDuration;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.asrMode;
    }

    public final String component2() {
        return this.appKey;
    }

    public final String component3() {
        return this.token;
    }

    public final String component4() {
        return this.language;
    }

    public final String component5() {
        return this.extraConfig;
    }

    public final int component6() {
        return this.maxRetryTime;
    }

    public final int component7() {
        return this.maxTimeOutDuration;
    }

    public final AsrExtraInfo copy(String r10, String r11, String r12, String r13, String r14, int r15, int r16) {
        return new AsrExtraInfo(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AsrExtraInfo) == true) goto L8;
        return false;
    L8:
        AsrExtraInfo r6 = (AsrExtraInfo) r5;
        if (Intrinsics.areEqual(this.asrMode, r6.asrMode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appKey, r6.appKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.language, r6.language) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extraConfig, r6.extraConfig) == true) goto L24;
        return false;
    L24:
        if (this.maxRetryTime == r6.maxRetryTime) goto L27;
        return false;
    L27:
        if (this.maxTimeOutDuration == r6.maxTimeOutDuration) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.asrMode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.appKey;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.token;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.language;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.extraConfig;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return ((((r12 + r1) * 31) + this.maxRetryTime) * 31) + this.maxTimeOutDuration;
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
        return "AsrExtraInfo(asrMode=" + this.asrMode + ", appKey=" + this.appKey + ", token=" + this.token + ", language=" + this.language + ", extraConfig=" + this.extraConfig + ", maxRetryTime=" + this.maxRetryTime + ", maxTimeOutDuration=" + this.maxTimeOutDuration + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getAsrMode() {
        return this.asrMode;
    }

    public final String getExtraConfig() {
        return this.extraConfig;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final int getMaxRetryTime() {
        return this.maxRetryTime;
    }

    public final int getMaxTimeOutDuration() {
        return this.maxTimeOutDuration;
    }

    public final String getToken() {
        return this.token;
    }

    public AsrExtraInfo(String r1, String r2, String r3, String r4, String r5, int r6, int r7) {
        this.asrMode = r1;
        this.appKey = r2;
        this.token = r3;
        this.language = r4;
        this.extraConfig = r5;
        this.maxRetryTime = r6;
        this.maxTimeOutDuration = r7;
    }

    public /* synthetic */ AsrExtraInfo(String r6, String r7, String r8, String r9, String r10, int r11, int r12, int r13, DefaultConstructorMarker r14) {
        String r0 = "";
        if ((r13 & 1) == 0) goto L5;
        String r15 = "";
    L7:
        if ((r13 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r13 & 4) == 0) goto L13;
        String r2 = "";
    L15:
        if ((r13 & 8) == 0) goto L17;
        String r3 = "";
    L19:
        if ((r13 & 16) != 0) goto L23;
        r0 = r10;
    L23:
        if ((r13 & 32) == 0) goto L25;
        int r4 = 0;
    L27:
        if ((r13 & 64) == 0) goto L29;
        int r16 = 0;
    L30:
        this(r15, r1, r2, r3, r0, r4, r16);
        return;
    L29:
        r16 = r12;
        goto L30
    L25:
        r4 = r11;
        goto L27
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r15 = r6;
        goto L7
    }
}
