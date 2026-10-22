package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "vc_minutes_recorder_config")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003Jw\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u00060"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRecordGeneralConfig;", "Ljava/io/Serializable;", "sliceDurationInSec", "", "tosErrorIntervalRetry", "", "backgroundUploadMaxAliveTime", "adaptiveUploadEnable", "ssthresh", "maxThresh", "audioFileCacheMaxAgeDays", "audioFileCacheThresholdMb", "enableOptimizeDozeMode", "minutesTokenRetryMaxTimes", "enableClientOpenSubtitle", "<init>", "(IZIZIIIIZIZ)V", "getSliceDurationInSec", "()I", "getTosErrorIntervalRetry", "()Z", "getBackgroundUploadMaxAliveTime", "getAdaptiveUploadEnable", "getSsthresh", "getMaxThresh", "getAudioFileCacheMaxAgeDays", "getAudioFileCacheThresholdMb", "getEnableOptimizeDozeMode", "getMinutesTokenRetryMaxTimes", "getEnableClientOpenSubtitle", "toString", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "", "hashCode", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRecordGeneralConfig implements Serializable {

    @SerializedName("adaptive_upload_enable")
    private final boolean adaptiveUploadEnable;

    @SerializedName("external_file_cache_max_age_days")
    private final int audioFileCacheMaxAgeDays;

    @SerializedName("external_file_threshold_mb")
    private final int audioFileCacheThresholdMb;

    @SerializedName("background_max_alive_time")
    private final int backgroundUploadMaxAliveTime;

    @SerializedName("enable_client_open_subtitle")
    private final boolean enableClientOpenSubtitle;

    @SerializedName("enable_optimize_doze_mode")
    private final boolean enableOptimizeDozeMode;

    @SerializedName("max_thresh")
    private final int maxThresh;

    @SerializedName("minutes_token_retry_max_times")
    private final int minutesTokenRetryMaxTimes;

    @SerializedName("slice_duration_in_sec")
    private final int sliceDurationInSec;

    @SerializedName("ssthresh")
    private final int ssthresh;

    @SerializedName("tos_error_interval_retry")
    private final boolean tosErrorIntervalRetry;

    public MmRecordGeneralConfig() {
        this(0, false, 0, false, 0, 0, 0, 0, false, 0, false, 2047, null);
    }

    public static /* synthetic */ MmRecordGeneralConfig copy$default(MmRecordGeneralConfig r12, int r13, boolean r14, int r15, boolean r16, int r17, int r18, int r19, int r20, boolean r21, int r22, boolean r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        int r2 = r12.sliceDurationInSec;
    L7:
        if ((r24 & 2) == 0) goto L9;
        boolean r3 = r12.tosErrorIntervalRetry;
    L11:
        if ((r24 & 4) == 0) goto L13;
        int r4 = r12.backgroundUploadMaxAliveTime;
    L15:
        if ((r24 & 8) == 0) goto L17;
        boolean r5 = r12.adaptiveUploadEnable;
    L19:
        if ((r24 & 16) == 0) goto L21;
        int r6 = r12.ssthresh;
    L23:
        if ((r24 & 32) == 0) goto L25;
        int r7 = r12.maxThresh;
    L27:
        if ((r24 & 64) == 0) goto L29;
        int r8 = r12.audioFileCacheMaxAgeDays;
    L31:
        if ((r24 & 128) == 0) goto L33;
        int r9 = r12.audioFileCacheThresholdMb;
    L35:
        if ((r24 & 256) == 0) goto L37;
        boolean r10 = r12.enableOptimizeDozeMode;
    L39:
        if ((r24 & 512) == 0) goto L41;
        int r11 = r12.minutesTokenRetryMaxTimes;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        boolean r1 = r12.enableClientOpenSubtitle;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final int component1() {
        return this.sliceDurationInSec;
    }

    public final int component10() {
        return this.minutesTokenRetryMaxTimes;
    }

    public final boolean component11() {
        return this.enableClientOpenSubtitle;
    }

    public final boolean component2() {
        return this.tosErrorIntervalRetry;
    }

    public final int component3() {
        return this.backgroundUploadMaxAliveTime;
    }

    public final boolean component4() {
        return this.adaptiveUploadEnable;
    }

    public final int component5() {
        return this.ssthresh;
    }

    public final int component6() {
        return this.maxThresh;
    }

    public final int component7() {
        return this.audioFileCacheMaxAgeDays;
    }

    public final int component8() {
        return this.audioFileCacheThresholdMb;
    }

    public final boolean component9() {
        return this.enableOptimizeDozeMode;
    }

    public final MmRecordGeneralConfig copy(int r14, boolean r15, int r16, boolean r17, int r18, int r19, int r20, int r21, boolean r22, int r23, boolean r24) {
        return new MmRecordGeneralConfig(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmRecordGeneralConfig) == true) goto L8;
        return false;
    L8:
        MmRecordGeneralConfig r6 = (MmRecordGeneralConfig) r5;
        if (this.sliceDurationInSec == r6.sliceDurationInSec) goto L12;
        return false;
    L12:
        if (this.tosErrorIntervalRetry == r6.tosErrorIntervalRetry) goto L15;
        return false;
    L15:
        if (this.backgroundUploadMaxAliveTime == r6.backgroundUploadMaxAliveTime) goto L18;
        return false;
    L18:
        if (this.adaptiveUploadEnable == r6.adaptiveUploadEnable) goto L21;
        return false;
    L21:
        if (this.ssthresh == r6.ssthresh) goto L24;
        return false;
    L24:
        if (this.maxThresh == r6.maxThresh) goto L27;
        return false;
    L27:
        if (this.audioFileCacheMaxAgeDays == r6.audioFileCacheMaxAgeDays) goto L30;
        return false;
    L30:
        if (this.audioFileCacheThresholdMb == r6.audioFileCacheThresholdMb) goto L33;
        return false;
    L33:
        if (this.enableOptimizeDozeMode == r6.enableOptimizeDozeMode) goto L36;
        return false;
    L36:
        if (this.minutesTokenRetryMaxTimes == r6.minutesTokenRetryMaxTimes) goto L39;
        return false;
    L39:
        if (this.enableClientOpenSubtitle == r6.enableClientOpenSubtitle) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = this.sliceDurationInSec * 31;
        int r2 = 1231;
        if (this.tosErrorIntervalRetry == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.backgroundUploadMaxAliveTime) * 31;
        if (this.adaptiveUploadEnable == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((((((((r3 + r4) * 31) + this.ssthresh) * 31) + this.maxThresh) * 31) + this.audioFileCacheMaxAgeDays) * 31) + this.audioFileCacheThresholdMb) * 31;
        if (this.enableOptimizeDozeMode == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (((r5 + r6) * 31) + this.minutesTokenRetryMaxTimes) * 31;
        if (this.enableClientOpenSubtitle == true) goto L19;
        r2 = 1237;
    L19:
        return r7 + r2;
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "MmRecordGeneralConfig(sliceDurationInSec=" + this.sliceDurationInSec + ", tosErrorIntervalRetry=" + this.tosErrorIntervalRetry + ", backgroundUploadMaxAliveTime=" + this.backgroundUploadMaxAliveTime + ", adaptiveUploadEnable=" + this.adaptiveUploadEnable + ", ssthresh=" + this.ssthresh + ", maxThresh=" + this.maxThresh + ", audioFileCacheMaxAgeDays=" + this.audioFileCacheMaxAgeDays + ", audioFileCacheThresholdMb=" + this.audioFileCacheThresholdMb + ", enableOptimizeDozeMode=" + this.enableOptimizeDozeMode + ", enableClientOpenSubtitle=" + this.enableClientOpenSubtitle + ')';
    }

    public final boolean getAdaptiveUploadEnable() {
        return this.adaptiveUploadEnable;
    }

    public final int getAudioFileCacheMaxAgeDays() {
        return this.audioFileCacheMaxAgeDays;
    }

    public final int getAudioFileCacheThresholdMb() {
        return this.audioFileCacheThresholdMb;
    }

    public final int getBackgroundUploadMaxAliveTime() {
        return this.backgroundUploadMaxAliveTime;
    }

    public final boolean getEnableClientOpenSubtitle() {
        return this.enableClientOpenSubtitle;
    }

    public final boolean getEnableOptimizeDozeMode() {
        return this.enableOptimizeDozeMode;
    }

    public final int getMaxThresh() {
        return this.maxThresh;
    }

    public final int getMinutesTokenRetryMaxTimes() {
        return this.minutesTokenRetryMaxTimes;
    }

    public final int getSliceDurationInSec() {
        return this.sliceDurationInSec;
    }

    public final int getSsthresh() {
        return this.ssthresh;
    }

    public final boolean getTosErrorIntervalRetry() {
        return this.tosErrorIntervalRetry;
    }

    public MmRecordGeneralConfig(int r1, boolean r2, int r3, boolean r4, int r5, int r6, int r7, int r8, boolean r9, int r10, boolean r11) {
        this.sliceDurationInSec = r1;
        this.tosErrorIntervalRetry = r2;
        this.backgroundUploadMaxAliveTime = r3;
        this.adaptiveUploadEnable = r4;
        this.ssthresh = r5;
        this.maxThresh = r6;
        this.audioFileCacheMaxAgeDays = r7;
        this.audioFileCacheThresholdMb = r8;
        this.enableOptimizeDozeMode = r9;
        this.minutesTokenRetryMaxTimes = r10;
        this.enableClientOpenSubtitle = r11;
    }

    public /* synthetic */ MmRecordGeneralConfig(int r12, boolean r13, int r14, boolean r15, int r16, int r17, int r18, int r19, boolean r20, int r21, boolean r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 1) == 0) goto L5;
        int r1 = 3;
    L6:
        boolean r3 = false;
        if ((r23 & 2) == 0) goto L9;
        boolean r2 = false;
    L11:
        if ((r23 & 4) == 0) goto L13;
        int r4 = 1800;
    L15:
        if ((r23 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r23 & 16) == 0) goto L21;
        int r6 = 16;
    L23:
        if ((r23 & 32) == 0) goto L25;
        int r7 = 24;
    L27:
        if ((r23 & 64) == 0) goto L29;
        int r8 = 7;
    L31:
        if ((r23 & 128) == 0) goto L33;
        int r9 = 300;
    L35:
        if ((r23 & 256) != 0) goto L39;
        r3 = r20;
    L39:
        if ((r23 & 512) == 0) goto L41;
        int r10 = 30;
    L43:
        if ((r23 & 1024) == 0) goto L45;
        boolean r0 = true;
    L46:
        this(r1, r2, r4, r5, r6, r7, r8, r9, r3, r10, r0);
        return;
    L45:
        r0 = r22;
        goto L46
    L41:
        r10 = r21;
        goto L43
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r2 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L6
    }
}
