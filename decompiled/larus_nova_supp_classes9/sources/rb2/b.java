package rb2;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class b {

    @SerializedName("degrade_enter_effect_enable")
    public boolean degradeEnterEffect;

    @SerializedName("degrade_enter_title_font")
    public boolean degradeEnterTitleFont;

    @SerializedName("degrade_like_enable")
    public boolean degradeLike;

    @SerializedName("degrade_like_alpha_level")
    public int degradeLikeAlphaLevel;

    @SerializedName("degrade_like_threshold_config")
    public int degradeLikeThreshold;

    @SerializedName("degrade_notify_effect_enable")
    public boolean degradeNotifyEffect;

    @SerializedName("degrade_notify_effect_scene_config")
    public List<String> degradeNotifyEffectSceneList;

    @SerializedName("degrade_public_screen_enable")
    public boolean degradePublicScreen;

    @SerializedName("degrade_public_screen_badge_config")
    public List<Long> degradePublicScreenBadgePriority;

    @SerializedName("degrade_public_screen_text_color_config")
    public HashMap<String, String> degradePublicScreenTextColorConfig;

    @SerializedName("degrade_public_screen_user_color_config")
    public HashMap<String, String> degradePublicScreenUserColorConfig;

    public b() {
        this.degradeLike = false;
        this.degradeLikeThreshold = 10;
        this.degradeLikeAlphaLevel = 1;
        this.degradeNotifyEffect = false;
        this.degradeNotifyEffectSceneList = null;
        this.degradeEnterEffect = false;
        this.degradeEnterTitleFont = false;
        this.degradePublicScreen = false;
        this.degradePublicScreenBadgePriority = null;
        this.degradePublicScreenUserColorConfig = null;
        this.degradePublicScreenTextColorConfig = null;
    }
}
