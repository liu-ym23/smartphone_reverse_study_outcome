package com.mammon.audiosdk.audiometrics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface AduioMetricLiteModuleConstants {
    public static final int ERROR_AUDIO_METRICS_LITE_PARAM_ERROR = 0;
    public static final int ERROR_AUDIO_METRICS_LITE_STATUS_ERROR = 0;
    public static final int OK_AUDIO_METRICS_LITE = 0;

    static {
        OK_AUDIO_METRICS_LITE = AduioMetricLiteModuleJNI.OK_AUDIO_METRICS_LITE_get();
        ERROR_AUDIO_METRICS_LITE_PARAM_ERROR = AduioMetricLiteModuleJNI.ERROR_AUDIO_METRICS_LITE_PARAM_ERROR_get();
        ERROR_AUDIO_METRICS_LITE_STATUS_ERROR = AduioMetricLiteModuleJNI.ERROR_AUDIO_METRICS_LITE_STATUS_ERROR_get();
    }
}
