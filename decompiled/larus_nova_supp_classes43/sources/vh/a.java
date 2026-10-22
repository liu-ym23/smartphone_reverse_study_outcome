package vh;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lvh/a;", "", "", "ecomAnchorManageFull", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "ecomAnchorManagePop", "b", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("ecom_anchor_manage_full")
    private final String ecomAnchorManageFull;

    @SerializedName("ecom_anchor_manage_pop")
    private final String ecomAnchorManagePop;

    public a() {
        this.ecomAnchorManageFull = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Fecom_live_anchor_manage%2Fmanage_full%2Ftemplate.js&type=fullscreen&height_percent=100&width_percent=100&load_taro=0&open_animate=1&top_level=1&trans_status_bar=1&hide_nav_bar=1";
        this.ecomAnchorManagePop = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Fecom_live_anchor_manage%2Fmanage_pop%2Ftemplate.js&load_taro=0&type=popup&height_percent=73&width_percent=100&open_animate=1&show_dim=0&gravity=bottom&use_real_screen_height=1&add_safe_area_height=0&show_mask=0&disable_input_scroll=1";
    }

    public final String a() {
        return this.ecomAnchorManageFull;
    }

    public final String b() {
        return this.ecomAnchorManagePop;
    }
}
