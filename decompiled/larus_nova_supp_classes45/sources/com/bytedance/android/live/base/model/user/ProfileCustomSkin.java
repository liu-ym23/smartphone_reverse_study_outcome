package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ProfileCustomSkin {
    public static int IMAGE_TYPE_PNG = 0;
    public static int IMAGE_TYPE_WEBP = 1;

    @SerializedName("avatar_border")
    public py.k avatarBorder;

    @SerializedName("avatar_border_dress_id")
    public String avatarBorderDressId;

    @SerializedName("bg_ui")
    public BgUI bgSkin;

    @SerializedName("bg_ui_webp")
    public BgUIWebp bgUIWebp;

    @SerializedName("dress_id")
    public String dressId;

    @SerializedName("follow_info_color")
    public String followInfoColor;

    @SerializedName("honor_wall_ui")
    public HonorWallUI honorWallSkin;

    @SerializedName("main_button_ui")
    public MainButtonUI mainButtonUI;

    @SerializedName("nickname_color")
    public GradientColor nickNameColor;

    @SerializedName("panel")
    public Panel panel;

    @SerializedName("secondary_button_ui")
    public SecondaryButtonUI secondaryButtonSkin;

    @SerializedName("signature_color")
    public String signatureColor;

    @SerializedName("suit_shop_enter_button")
    public SuitShopEnterButton suitShopEnterButton;

    @SerializedName("tag_ui")
    public TagUI tagSkin;

    @SerializedName("visitor_button_color")
    public String visitorButtonColor;

    public static class BgUI {

        @SerializedName("color")
        public GradientColor bgColor;

        @SerializedName("overall_image")
        public py.k cardBg;

        @SerializedName("split_line_color")
        public String dividerColor;

        @SerializedName("extend_top_border")
        public ExtendTopBorder extendTopBorder;

        @SerializedName("right_image")
        public py.k rightBottomImage;

        @SerializedName("top_border")
        public com.bytedance.android.live.base.model.d topBorder;

        public BgUI() {
        }
    }

    public static class BgUIWebp {

        @SerializedName("overall_image")
        public py.k overallImage;

        public BgUIWebp() {
        }
    }

    public static class ExtendTopBorder {

        @SerializedName("overlay_image")
        public py.k overlayImage;

        @SerializedName("overlay_pic_type")
        public int overlayPicType;

        @SerializedName("overlay_webp_enter")
        public py.k overlayWebpEnter;

        @SerializedName("overlay_webp_loop")
        public py.k overlayWebpLoop;

        public ExtendTopBorder() {
        }
    }

    public static class GradientColor {

        @SerializedName("from")
        public String from;

        @SerializedName("to")
        public String to;

        public GradientColor() {
        }
    }

    public static class HonorWallUI {

        @SerializedName("content_color")
        public String contentColor;

        @SerializedName("title_color")
        public String titleColor;

        public HonorWallUI() {
        }
    }

    public static class MainButtonUI {

        @SerializedName("uri")
        public com.bytedance.android.live.base.model.d uri;

        public MainButtonUI() {
        }
    }

    public static class Panel {

        @SerializedName("close_interval")
        public long closeInterval;

        @SerializedName("close_rate_curve")
        public List<Double> closeRateCurve;

        @SerializedName("open_interval")
        public long openInterval;

        @SerializedName("open_rate_curve")
        public List<Double> openRateCurve;

        public Panel() {
        }
    }

    public static class SecondaryButtonUI {

        @SerializedName("background_color")
        public String backgroundColor;

        @SerializedName("border_color")
        public String borderColor;

        @SerializedName("icon_color")
        public String iconColor;

        public SecondaryButtonUI() {
        }
    }

    public static class SuitShopEnterButton {

        @SerializedName("bg_color")
        public String bgColor;

        @SerializedName("text_color")
        public String color;

        @SerializedName("schema")
        public String schema;

        @SerializedName("text")
        public String text;

        public SuitShopEnterButton() {
        }
    }

    public static class TagUI {

        @SerializedName("background_color")
        public String backgroundColor;

        @SerializedName("word_color")
        public String wordColor;

        public TagUI() {
        }
    }

    public ProfileCustomSkin() {
    }
}
