package com.bytedance.android.livesdk.interactivity.api.barrage.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class VSBarrageSetting implements Serializable {
    public static final int DEFAULT_ALPHA = 75;

    @SerializedName("alpha")
    private float alpha;

    @SerializedName("barrage_area")
    private float barrageArea;

    @SerializedName("font_size")
    private int fontSize;

    @SerializedName("is_ai_danmaku_enable")
    private boolean isAIDanmakuEnable;

    @SerializedName("is_character_danmaku_enable")
    private boolean isCharacterDanmakuEnable;

    @SerializedName("is_color_danmaku_enable")
    private boolean isColorDanmakuEnable;

    @SerializedName("is_gif_danmaku_enable")
    private boolean isGifDanmakuEnable;

    @SerializedName("is_gift_open")
    private boolean isGiftOpen;

    @SerializedName("is_mask_enable")
    private boolean isMaskEnable;

    @SerializedName("is_need_roll_back")
    private boolean isNeedRollback;

    @SerializedName("speed")
    private float speed;

    public static VSBarrageSetting getDefaultStyleSetting() {
        VSBarrageSetting r0 = new VSBarrageSetting();
        r0.setFontSize(BarrageSettingFont.MID);
        r0.setBarrageArea(0.45f);
        r0.setAlpha(75.0f);
        r0.setGiftOpen(true);
        r0.setAIDanmakuEnable(true);
        r0.setColorDanmakuEnable(true);
        r0.setCharacterDanmakuEnable(true);
        r0.setGifDanmakuEnable(true);
        return r0;
    }

    public VSBarrageSetting() {
        this.barrageArea = 0.45f;
        this.fontSize = BarrageSettingFont.MID.getFont();
        this.alpha = 100.0f;
        this.speed = 1.0f;
        this.isGiftOpen = true;
        this.isNeedRollback = false;
        this.isMaskEnable = true;
        this.isAIDanmakuEnable = true;
        this.isColorDanmakuEnable = true;
        this.isCharacterDanmakuEnable = true;
        this.isGifDanmakuEnable = true;
    }

    public boolean isGiftOpen() {
        return this.isGiftOpen;
    }

    public boolean isMaskEnable() {
        return this.isMaskEnable;
    }

    public void setAIDanmakuEnable(boolean r1) {
        this.isAIDanmakuEnable = r1;
    }

    public void setAlpha(float r1) {
        this.alpha = r1;
    }

    public void setBarrageArea(float r1) {
        this.barrageArea = r1;
    }

    public void setCharacterDanmakuEnable(boolean r1) {
        this.isCharacterDanmakuEnable = r1;
    }

    public void setColorDanmakuEnable(boolean r1) {
        this.isColorDanmakuEnable = r1;
    }

    public void setFontSize(BarrageSettingFont r1) {
        this.fontSize = r1.getFont();
    }

    public void setGifDanmakuEnable(boolean r1) {
        this.isGifDanmakuEnable = r1;
    }

    public void setGiftOpen(boolean r1) {
        this.isGiftOpen = r1;
    }

    public void setMaskEnable(boolean r1) {
        this.isMaskEnable = r1;
    }
}
