package com.larus.dora.impl.settings;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001e\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001e\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001e\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/larus/dora/impl/settings/OTATriggerSceneConfig;", "", "<init>", "()V", "inconsistentVersionsEnable", "", "getInconsistentVersionsEnable", "()Z", "setInconsistentVersionsEnable", "(Z)V", "specificSceneTriggerDelayEnable", "getSpecificSceneTriggerDelayEnable", "setSpecificSceneTriggerDelayEnable", "autoUpdateDelay", "", "getAutoUpdateDelay", "()J", "setAutoUpdateDelay", "(J)V", "specificSceneTriggerDelay", "getSpecificSceneTriggerDelay", "setSpecificSceneTriggerDelay", "silencePowerThreshold", "getSilencePowerThreshold", "setSilencePowerThreshold", "manualPowerThreshold", "getManualPowerThreshold", "setManualPowerThreshold", "otaBesErrorSwitch", "getOtaBesErrorSwitch", "setOtaBesErrorSwitch", "otaDarEnable", "getOtaDarEnable", "setOtaDarEnable", "otaHearBudsEnable", "getOtaHearBudsEnable", "setOtaHearBudsEnable", "otaDisconnectResetLoadingEnable", "getOtaDisconnectResetLoadingEnable", "setOtaDisconnectResetLoadingEnable", "otaTodayCount", "", "getOtaTodayCount", "()I", "setOtaTodayCount", "(I)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j1 {

    @SerializedName("auto_update_delay")
    private long autoUpdateDelay;

    @SerializedName("inconsistent_versions_enable")
    private boolean inconsistentVersionsEnable;

    @SerializedName("manual_power_threshold")
    private long manualPowerThreshold;

    @SerializedName("ota_bes_error_switch")
    private boolean otaBesErrorSwitch;

    @SerializedName("ota_dar_enable")
    private boolean otaDarEnable;

    @SerializedName("ota_disconnect_reset_loading_enable")
    private boolean otaDisconnectResetLoadingEnable;

    @SerializedName("ota_heart_buds_enable")
    private boolean otaHearBudsEnable;

    @SerializedName("ota_today_count")
    private int otaTodayCount;

    @SerializedName("silence_power_threshold")
    private long silencePowerThreshold;

    @SerializedName("specific_scene_trigger_delay")
    private long specificSceneTriggerDelay;

    @SerializedName("specific_scene_trigger_delay_enable")
    private boolean specificSceneTriggerDelayEnable;

    public j1() {
        this.inconsistentVersionsEnable = true;
        this.specificSceneTriggerDelayEnable = true;
        this.autoUpdateDelay = com.larus.dora.impl.ota.g2.j0.G2_OTA_DISCONNECT_WATCHDOG_MS;
        this.specificSceneTriggerDelay = DoraObricDeviceHomeViewModel.SCAN_TIMEOUT_MS;
        this.silencePowerThreshold = 30;
        this.manualPowerThreshold = 30;
        this.otaDarEnable = true;
        this.otaDisconnectResetLoadingEnable = true;
        this.otaTodayCount = 3;
    }

    public final long a() {
        return this.autoUpdateDelay;
    }

    public final boolean b() {
        return this.inconsistentVersionsEnable;
    }

    public final long c() {
        return this.manualPowerThreshold;
    }

    public final boolean d() {
        return this.otaBesErrorSwitch;
    }

    public final boolean e() {
        return this.otaDarEnable;
    }

    public final boolean f() {
        return this.otaDisconnectResetLoadingEnable;
    }

    public final boolean g() {
        return this.otaHearBudsEnable;
    }

    public final long h() {
        return this.silencePowerThreshold;
    }

    public final long i() {
        return this.specificSceneTriggerDelay;
    }

    public final boolean j() {
        return this.specificSceneTriggerDelayEnable;
    }
}
