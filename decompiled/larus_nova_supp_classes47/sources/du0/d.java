package du0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Ldu0/d;", "", "", "userUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setUserUrl", "(Ljava/lang/String;)V", "authorUrl", "a", "setAuthorUrl", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("author_url")
    private String authorUrl;

    @SerializedName("user_url")
    private String userUrl;

    public d() {
        this.userUrl = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Fvip_user_douyin%2Fpages%2Findex%2Ftemplate.js&type=popup&gravity=bottom&business_type=revenue_vip&hide_loading=0&show_error=1&height_percent=73&web_bg_color=%2300000000&enable_latch=1&horizontal_width=375&disable_input_scroll=1&mask_alpha=0.6&radius=16&fallback_url=sslocal%3A%2F%2Fwebcast_webview%3Furl%3Dhttps%253A%252F%252Flf-webcast-sourcecdn-tos.bytegecko.com%252Fobj%252Fbyte-gurd-source%252Fwebcast%252Fmono%252Flynx%252Fdouyin_lynx_fansclub%252Ftemplate%252Fpages%252Ffansclub_vip%252Fsubscription_vip%252Fuser%252Findex.html%253Fweb_bg_color%253D%25252300000000%26landscape_custom_gravity%3D1%26type%3Dpopup%26gravity%3Dbottom%26height%3D5000";
        this.authorUrl = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Fvip_author_douyin%2Fpages%2Findex%2Ftemplate.js&type=popup&gravity=bottom&business_type=revenue_vip&hide_loading=0&show_error=1&height_percent=73&web_bg_color=%2300000000&enable_latch=1&horizontal_width=375&disable_input_scroll=1&mask_alpha=0.6&radius=16&fallback_url=sslocal%3A%2F%2Fwebcast_webview%3Furl%3Dhttps%253A%252F%252Flf-webcast-sourcecdn-tos.bytegecko.com%252Fobj%252Fbyte-gurd-source%252Fwebcast%252Fmono%252Flynx%252Fdouyin_lynx_fansclub%252Ftemplate%252Fpages%252Ffansclub_vip%252Fsubscription_vip%252Fanchor%252Findex.html%253Fweb_bg_color%253D%25252300000000%26landscape_custom_gravity%3D1%26type%3Dpopup%26gravity%3Dbottom%26height%3D5000";
    }

    public final String a() {
        return this.authorUrl;
    }

    public final String b() {
        return this.userUrl;
    }
}
