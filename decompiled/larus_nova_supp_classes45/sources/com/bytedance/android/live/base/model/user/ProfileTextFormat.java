package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ProfileTextFormat {
    public static int FONT_STYLE_BOLD = 1;
    public static int FONT_STYLE_NORMAL = 0;
    public static int FONT_TYPE_CLARITY_MONO_BOLD = 2;
    public static int FONT_TYPE_COMPATIBLE_NORMAL = 3;
    public static int FONT_TYPE_DEFAULT = 0;
    public static int FONT_TYPE_NORMAL = 1;

    @SerializedName("font_color")
    String fontColor;

    @SerializedName("font_size")
    int fontSize;

    @SerializedName("font_style")
    int fontStyle;

    @SerializedName("font_type")
    int fontType;

    public ProfileTextFormat() {
    }

    public String getFontColor() {
        return this.fontColor;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public int getFontStyle() {
        return this.fontStyle;
    }

    public int getFontType() {
        return this.fontType;
    }

    public void setFontColor(String r1) {
        this.fontColor = r1;
    }

    public void setFontSize(int r1) {
        this.fontSize = r1;
    }

    public void setFontStyle(int r1) {
        this.fontStyle = r1;
    }

    public void setFontType(int r1) {
        this.fontType = r1;
    }
}
