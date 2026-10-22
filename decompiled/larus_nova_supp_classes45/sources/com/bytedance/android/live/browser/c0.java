package com.bytedance.android.live.browser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface c0 {
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> a = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> b = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> c = null;

    static {
        a = new com.bytedance.android.livesdk.sharedpref.e("live_end_live_location_exposure_count", 0);
        b = new com.bytedance.android.livesdk.sharedpref.e("live_preview_location_show_state", 0);
        c = new com.bytedance.android.livesdk.sharedpref.e("live_preview_location_closed_actively", Boolean.FALSE);
    }
}
