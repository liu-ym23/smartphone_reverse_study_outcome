package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/wd1;", "", "", "lynxUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "lynxScheme", "a", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class wd1 {

    @SerializedName("lynx_scheme")
    private final String lynxScheme;

    @SerializedName("lynx_url")
    private final String lynxUrl;

    public wd1() {
        this.lynxUrl = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/lynx/webcast_native_lynx_douyin/pages/charge_linkmic/charge_panel/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D&business_type=linkmiccharge";
        this.lynxScheme = "sslocal://webcast_lynxview?mask_alpha=0&type=popup&gravity=bottom&hide_loading=0&show_error=1&radius=8";
    }

    public final String a() {
        return this.lynxScheme;
    }

    public final String b() {
        return this.lynxUrl;
    }
}
