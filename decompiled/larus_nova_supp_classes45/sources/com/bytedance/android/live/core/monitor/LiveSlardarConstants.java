package com.bytedance.android.live.core.monitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveSlardarConstants {
    public static final String EXTRA_KEY_ERROR_CODE = "error_code";
    public static final String EXTRA_KEY_ERROR_MSG = "error_msg";
    public static final String EXTRA_KEY_URL = "url";
    public static final String SERVICE_IMAGE_LOAD_STATUS = "ttlive_image_load_status";
    public static final String SERVICE_WEBVIEW_JSB_SAFE_HOST = "ttlive_webview_jsb_safe_host";
    public static final String SERVICE_WEBVIEW_LOAD_STATUS = "ttlive_webview_load_status";
    public static final int STATUS_FAIL = 1;
    public static final int STATUS_SUCCESS = 0;
    private static final String SUFFIX_ALL = "_all";
    private static final String SUFFIX_ERROR = "_error";

    public LiveSlardarConstants() {
    }

    public static String suffixAll(String r1) {
        return r1 + SUFFIX_ALL;
    }

    public static String suffixError(String r1) {
        return r1 + SUFFIX_ERROR;
    }
}
