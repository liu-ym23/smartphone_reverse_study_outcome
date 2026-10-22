package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "vc_hardware_ble_scan_filter")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmHardwareBleScanConfig;", "", "enableExportHardwareLog", "", "enableExportLibertyEarbudsLog", "enableExportLibertyChargingCaseLog", "<init>", "(ZZZ)V", "getEnableExportHardwareLog", "()Z", "getEnableExportLibertyEarbudsLog", "getEnableExportLibertyChargingCaseLog", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmHardwareBleScanConfig {

    @SerializedName("enableExportHardwareLog")
    private final boolean enableExportHardwareLog;

    @SerializedName("enableExportLibertyChargingCaseLog")
    private final boolean enableExportLibertyChargingCaseLog;

    @SerializedName("enableExportLibertyEarbudsLog")
    private final boolean enableExportLibertyEarbudsLog;

    public MmHardwareBleScanConfig() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ MmHardwareBleScanConfig copy$default(MmHardwareBleScanConfig r0, boolean r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enableExportHardwareLog;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.enableExportLibertyEarbudsLog;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.enableExportLibertyChargingCaseLog;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.enableExportHardwareLog;
    }

    public final boolean component2() {
        return this.enableExportLibertyEarbudsLog;
    }

    public final boolean component3() {
        return this.enableExportLibertyChargingCaseLog;
    }

    public final MmHardwareBleScanConfig copy(boolean r2, boolean r3, boolean r4) {
        return new MmHardwareBleScanConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmHardwareBleScanConfig) == true) goto L8;
        return false;
    L8:
        MmHardwareBleScanConfig r6 = (MmHardwareBleScanConfig) r5;
        if (this.enableExportHardwareLog == r6.enableExportHardwareLog) goto L12;
        return false;
    L12:
        if (this.enableExportLibertyEarbudsLog == r6.enableExportLibertyEarbudsLog) goto L15;
        return false;
    L15:
        if (this.enableExportLibertyChargingCaseLog == r6.enableExportLibertyChargingCaseLog) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.enableExportHardwareLog == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableExportLibertyEarbudsLog == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.enableExportLibertyChargingCaseLog == true) goto L15;
        r1 = 1237;
    L15:
        return r4 + r1;
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "MmHardwareBleScanConfig(enableExportHardwareLog=" + this.enableExportHardwareLog + ", enableExportLibertyEarbudsLog=" + this.enableExportLibertyEarbudsLog + ", enableExportLibertyChargingCaseLog=" + this.enableExportLibertyChargingCaseLog + ')';
    }

    public final boolean getEnableExportHardwareLog() {
        return this.enableExportHardwareLog;
    }

    public final boolean getEnableExportLibertyChargingCaseLog() {
        return this.enableExportLibertyChargingCaseLog;
    }

    public final boolean getEnableExportLibertyEarbudsLog() {
        return this.enableExportLibertyEarbudsLog;
    }

    public MmHardwareBleScanConfig(boolean r1, boolean r2, boolean r3) {
        this.enableExportHardwareLog = r1;
        this.enableExportLibertyEarbudsLog = r2;
        this.enableExportLibertyChargingCaseLog = r3;
    }

    public /* synthetic */ MmHardwareBleScanConfig(boolean r2, boolean r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }
}
