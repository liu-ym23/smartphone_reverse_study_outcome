package fc2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class b {

    @SerializedName("digg_hw_opt_enable")
    public boolean diggHWEnable;

    @SerializedName("public_screen_anim_opt_style")
    public int publicScreenAnimHWStyle;

    public b() {
        this.publicScreenAnimHWStyle = 1;
        this.diggHWEnable = true;
    }
}
