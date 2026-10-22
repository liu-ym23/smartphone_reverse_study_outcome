package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmBilingualSubtitleDisplayConfig;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmFunctionSettingsConfig;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmHardwareBleScanConfig;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmHardwareFunctionConfigSetting;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmRecordGeneralConfig;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmRecordingRemoteAudioSetting;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmRtcAppConfig;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmRtcNetworkConfig;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmSdkBandWidthThrottleConfig;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmSubtitleAsrOptConfig;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUpdateStatusRetryConfig;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUploadRetryConfigSetting;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmVcAIGuideConfig;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int l = 0;
    public final CoroutineScope a;
    public MmRecordingRemoteAudioSetting b;
    public MmUploadRetryConfigSetting c;
    public MmUpdateStatusRetryConfig d;
    public MmBilingualSubtitleDisplayConfig e;
    public MmSubtitleAsrOptConfig f;
    public MmSdkBandWidthThrottleConfig g;
    public MmRecordGeneralConfig h;
    public MmRtcAppConfig i;
    public MmRtcNetworkConfig j;
    public MmVcAIGuideConfig k;

    public static final class a {
    }

    static {
    }

    public b() {
        this.a = CoroutineScopeKt.CoroutineScope(MMCoroutines.a().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.b = new MmRecordingRemoteAudioSetting(0, null, 0, 0, false, null, 63, null);
        this.c = new MmUploadRetryConfigSetting(null, null, 3, null);
        this.d = new MmUpdateStatusRetryConfig(0, 0, 3, null);
        this.e = new MmBilingualSubtitleDisplayConfig(0.0f, 0, 3, null);
        this.f = new MmSubtitleAsrOptConfig(false, 1, null);
        this.g = new MmSdkBandWidthThrottleConfig();
        this.h = new MmRecordGeneralConfig(0, false, 0, false, 0, 0, 0, 0, false, 0, false, 2047, null);
        this.i = new MmRtcAppConfig(null, null, 3, null);
        this.j = new MmRtcNetworkConfig(0, 0, null, null, null, 31, null);
        new MmFunctionSettingsConfig(false, 1, null);
        this.k = new MmVcAIGuideConfig(null, 1, null);
        new MmHardwareBleScanConfig(false, false, false, 7, null);
        new MmHardwareFunctionConfigSetting(null, 1, null);
    }

    public final void a() {
        BuildersKt.launch$default(this.a, null, null, new MmAppSettingsService$initRemoteAudioSetting$1(this, null), 3, null);
        BuildersKt.launch$default(this.a, null, null, new MmAppSettingsService$initUploadTaskSetting$1(this, null), 3, null);
        BuildersKt.launch$default(this.a, null, null, new MmAppSettingsService$initUpdateStatusRetrySetting$1(this, null), 3, null);
        BuildersKt.launch$default(this.a, null, null, new MmAppSettingsService$initBilingualSubtitleDisplayConfig$1(this, null), 3, null);
        BuildersKt.launch$default(this.a, null, null, new MmAppSettingsService$initSubtitleAsrOptConfig$1(this, null), 3, null);
        BuildersKt.launch$default(this.a, null, null, new MmAppSettingsService$initSdkBandWidthConfig$1(this, null), 3, null);
        BuildersKt.launch$default(this.a, null, null, new MmAppSettingsService$initRecordGeneralConfig$1(this, null), 3, null);
        BuildersKt.launch$default(this.a, null, null, new MmAppSettingsService$initRtcAppConfig$1(this, null), 3, null);
        BuildersKt.launch$default(this.a, null, null, new MmAppSettingsService$initRtcNetworkConfig$1(this, null), 3, null);
        BuildersKt.launch$default(this.a, null, null, new MmAppSettingsService$initFunctionSettingsConfig$1(this, null), 3, null);
        BuildersKt.launch$default(this.a, null, null, new MmAppSettingsService$initFunctionSwitchConfig$1(this, null), 3, null);
        BuildersKt.launch$default(this.a, null, null, new MmAppSettingsService$initVcAIGuideConfig$1(this, null), 3, null);
        BuildersKt.launch$default(this.a, null, null, new MmAppSettingsService$initHardwareBleScanConfig$1(this, null), 3, null);
        BuildersKt.launch$default(this.a, null, null, new MmAppSettingsService$initHardwareFunctionConfig$1(this, null), 3, null);
    }
}
