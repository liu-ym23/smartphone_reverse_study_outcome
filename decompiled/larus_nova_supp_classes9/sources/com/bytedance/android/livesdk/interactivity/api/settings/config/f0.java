package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class f0 {

    @SerializedName("auto_scroll_to_bottom_time_threshold")
    public int autoScrollTimeThreshold;

    @SerializedName("cache_message_num_after_setting_changed")
    public int cacheNumAfterSettingChange;

    @SerializedName("drop_num_when_message_list_full")
    public int dropNumWhenMessageListFull;

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("hide_selected_message_list_max_size")
    public int listMaxSizeWhenHide;

    @SerializedName("show_selected_message_list_max_size")
    public int listMaxSizeWhenShow;

    @SerializedName("selected_message_buffer_size")
    public int messageBufferSize;

    @SerializedName("featured_public_screen_setting_lynx_url")
    public String settingPageSchema;

    @SerializedName("featured_public_screen_setting_lynx_url_ai")
    public String settingPageSchemaAi;

    @SerializedName("dialog_use_app_compact_style")
    public boolean useAppcompactStyle;

    public f0() {
        this.enable = false;
        this.listMaxSizeWhenShow = 100;
        this.listMaxSizeWhenHide = 50;
        this.dropNumWhenMessageListFull = 30;
        this.messageBufferSize = 50;
        this.cacheNumAfterSettingChange = 10;
        this.autoScrollTimeThreshold = 5;
        this.useAppcompactStyle = true;
    }
}
