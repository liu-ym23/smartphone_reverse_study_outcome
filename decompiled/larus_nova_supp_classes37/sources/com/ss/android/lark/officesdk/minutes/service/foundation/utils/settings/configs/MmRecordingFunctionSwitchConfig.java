package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "vc_function_switch")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRecordingFunctionSwitchConfig;", "", "enableMinutesFishbonePreload", "", "hwDeleteLocalFile", "hwAudioDumpFileExpiredDays", "", "<init>", "(ZZLjava/lang/Integer;)V", "getEnableMinutesFishbonePreload", "()Z", "getHwDeleteLocalFile", "getHwAudioDumpFileExpiredDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(ZZLjava/lang/Integer;)Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRecordingFunctionSwitchConfig;", "equals", "other", "hashCode", "toString", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRecordingFunctionSwitchConfig {

    @SerializedName("enableMinutesFishbonePreload")
    private final boolean enableMinutesFishbonePreload;

    @SerializedName("hwAudioDumpFileExpiredDays")
    private final Integer hwAudioDumpFileExpiredDays;

    @SerializedName("hwDeleteLocalFile")
    private final boolean hwDeleteLocalFile;

    public MmRecordingFunctionSwitchConfig() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmRecordingFunctionSwitchConfig) == true) goto L8;
        return false;
    L8:
        MmRecordingFunctionSwitchConfig r6 = (MmRecordingFunctionSwitchConfig) r5;
        if (this.enableMinutesFishbonePreload == r6.enableMinutesFishbonePreload) goto L12;
        return false;
    L12:
        if (this.hwDeleteLocalFile == r6.hwDeleteLocalFile) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.hwAudioDumpFileExpiredDays, r6.hwAudioDumpFileExpiredDays) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enableMinutesFishbonePreload == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.hwDeleteLocalFile == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        Integer r4 = this.hwAudioDumpFileExpiredDays;
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

    public final String toString() {
        return "MmRecordingFunctionSwitchConfig(enableMinutesFishbonePreload=" + this.enableMinutesFishbonePreload + ", hwDeleteLocalFile=" + this.hwDeleteLocalFile + ", hwAudioDumpFileExpiredDays=" + this.hwAudioDumpFileExpiredDays + ')';
    }

    public MmRecordingFunctionSwitchConfig(int r1) {
        this.enableMinutesFishbonePreload = false;
        this.hwDeleteLocalFile = true;
        this.hwAudioDumpFileExpiredDays = null;
    }
}
