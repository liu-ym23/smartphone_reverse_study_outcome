package com.mammon.audiosdk.audiometrics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AduioMetricLiteModuleJNI {
    public AduioMetricLiteModuleJNI() {
    }

    public static final native String AudioMetricsLite_get_result__SWIG_0(long r0, AudioMetricsLite r2, int r3);

    public static final native String AudioMetricsLite_get_result__SWIG_1(long r0, AudioMetricsLite r2);

    public static final native int AudioMetricsLite_init(long r0, AudioMetricsLite r2);

    public static final native int AudioMetricsLite_prepare(long r0, AudioMetricsLite r2, String r3);

    public static final native int AudioMetricsLite_process__SWIG_1(long r0, AudioMetricsLite r2, float[] r3, int r4, int r5);

    public static final native int AudioMetricsLite_process_tail(long r0, AudioMetricsLite r2);

    public static final native void AudioMetricsLite_release(long r0, AudioMetricsLite r2);

    public static final native int AudioMetricsLite_reset(long r0, AudioMetricsLite r2);

    public static final native String AudioMetricsLite_version(long r0, AudioMetricsLite r2);

    public static final native int ERROR_AUDIO_METRICS_LITE_PARAM_ERROR_get();

    public static final native int ERROR_AUDIO_METRICS_LITE_STATUS_ERROR_get();

    public static final native int OK_AUDIO_METRICS_LITE_get();

    public static final native void delete_AudioMetricsLite(long r0);

    public static final native long new_AudioMetricsLite();
}
