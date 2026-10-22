package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "sdk_bandwidth_throttle_config")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmSdkBandWidthThrottleConfig;", "", "<init>", "()V", "rtcBandWidthConfig", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/RtcBandWidthConfig;", "getRtcBandWidthConfig", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/RtcBandWidthConfig;", "setRtcBandWidthConfig", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/RtcBandWidthConfig;)V", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSdkBandWidthThrottleConfig {

    @SerializedName("vc_rtc_config")
    private RtcBandWidthConfig rtcBandWidthConfig;

    public MmSdkBandWidthThrottleConfig() {
    }

    public final RtcBandWidthConfig a() {
        return this.rtcBandWidthConfig;
    }
}
