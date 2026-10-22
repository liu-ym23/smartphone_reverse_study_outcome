package com.bytedance.android.live.base.model;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class q {
    public boolean a;

    @SerializedName("accessible_name")
    public String accessibleName;

    @SerializedName("animation_quota")
    public int animationShowTimes;

    @SerializedName("animation_type")
    public int animationType;

    @SerializedName("sub_item_list")
    public List<String> businessList;

    @SerializedName("container_type")
    public int containerType;

    @SerializedName("short_touch_fallback_url")
    public String fallbackUrl;

    @SerializedName("height")
    public int height;

    @SerializedName("img_url")
    public String imageUrl;

    @SerializedName("img_layers")
    public a imgLayers;

    @SerializedName("jump_schema")
    public String jumpSchema;

    @SerializedName("short_touch_url")
    public String loadUrl;

    @SerializedName("show_animation")
    public int showAnimation;

    @SerializedName("width")
    public int width;

    public static class a {

        @SerializedName("base_height")
        public int baseHeight;

        @SerializedName("base_width")
        public int baseWidth;

        @SerializedName("layers")
        public List<C0014a> layers;

        /* JADX INFO: renamed from: com.bytedance.android.live.base.model.q$a$a, reason: collision with other inner class name */
        public static class C0014a {

            @SerializedName("height")
            public int height;

            @SerializedName("radius")
            public int radius;

            @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
            public String url;

            @SerializedName("width")
            public int width;

            @SerializedName("x")
            public int x;

            @SerializedName("y")
            public int y;

            public C0014a() {
                this.url = "";
            }
        }

        public a() {
        }
    }

    public q() {
        this.a = true;
    }
}
