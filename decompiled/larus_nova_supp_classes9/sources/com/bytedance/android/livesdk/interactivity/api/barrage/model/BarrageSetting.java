package com.bytedance.android.livesdk.interactivity.api.barrage.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class BarrageSetting implements Serializable {
    public static final int DEFAULT_ALPHA = 75;

    @SerializedName("alpha")
    private float alpha;

    @SerializedName("barrage_area")
    private int barrageArea;

    @SerializedName("font_size")
    private int fontSize;

    @SerializedName("is_carnival_barrage_open")
    private boolean isCarnivalBarrageOpen;

    @SerializedName("is_chat_channel_open")
    private boolean isChatChannelOpen;

    @SerializedName("is_gift_open")
    private boolean isGiftOpen;

    @SerializedName("is_lottery_open")
    private boolean isLotteryOpen;

    @SerializedName("is_need_roll_back")
    private boolean isNeedRollback;

    public static BarrageSetting getDefaultVSLiveSetting() {
        BarrageSetting r0 = new BarrageSetting();
        r0.setFontSize(BarrageSettingFont.MID);
        r0.setBarrageArea(BarrageSettingArea.TOP);
        r0.setAlpha(75.0f);
        r0.setGiftOpen(true);
        r0.setChatChannelOpen(true);
        return r0;
    }

    public BarrageSettingArea getBarrageArea() {
        BarrageSettingArea.a r0 = BarrageSettingArea.Companion;
        int r1 = this.barrageArea;
        r0.getClass();
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return BarrageSettingArea.HALF;
    L17:
        return BarrageSettingArea.FULL;
    L18:
        return BarrageSettingArea.HALF;
    L19:
        return BarrageSettingArea.TOP;
    L15:
        return BarrageSettingArea.CLOSE;
    }

    public BarrageSettingFont getFontSize() {
        BarrageSettingFont.a r0 = BarrageSettingFont.Companion;
        int r1 = this.fontSize;
        r0.getClass();
        switch(r1) {
            case -1: goto L15;
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            default: goto L16;
        };
    L16:
        return BarrageSettingFont.MID;
    L17:
        return BarrageSettingFont.PORTRAIT;
    L18:
        return BarrageSettingFont.VS_PORTRAIT_LARGE;
    L19:
        return BarrageSettingFont.VS_PORTRAIT_BIG;
    L20:
        return BarrageSettingFont.VS_PORTRAIT_MID;
    L21:
        return BarrageSettingFont.VS_PORTRAIT_SMALL;
    L22:
        return BarrageSettingFont.VS_PORTRAIT;
    L23:
        return BarrageSettingFont.SMALL;
    L24:
        return BarrageSettingFont.MID;
    L25:
        return BarrageSettingFont.BIG;
    L15:
        return BarrageSettingFont.LARGE;
    }

    public BarrageSetting() {
        this.barrageArea = BarrageSettingArea.HALF.getArea();
        this.fontSize = BarrageSettingFont.MID.getFont();
        this.alpha = 75.0f;
        this.isGiftOpen = true;
        this.isLotteryOpen = true;
        this.isChatChannelOpen = true;
        this.isNeedRollback = false;
        this.isCarnivalBarrageOpen = true;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public boolean isCarnivalBarrageOpen() {
        return this.isCarnivalBarrageOpen;
    }

    public boolean isChatChannelOpen() {
        return this.isChatChannelOpen;
    }

    public boolean isGiftOpen() {
        return this.isGiftOpen;
    }

    public boolean isLotteryOpen() {
        return this.isLotteryOpen;
    }

    public boolean isNeedRollback() {
        return this.isNeedRollback;
    }

    public BarrageSetting(boolean r3) {
        this.barrageArea = BarrageSettingArea.HALF.getArea();
        this.fontSize = BarrageSettingFont.MID.getFont();
        this.alpha = 75.0f;
        this.isGiftOpen = true;
        this.isLotteryOpen = true;
        this.isChatChannelOpen = true;
        this.isNeedRollback = false;
        this.isCarnivalBarrageOpen = true;
        if (r3 == false) goto L6;
        this.barrageArea = BarrageSettingArea.TOP.getArea();
        return;
    }

    public void setAlpha(float r1) {
        this.alpha = r1;
    }

    public void setBarrageArea(BarrageSettingArea r1) {
        this.barrageArea = r1.getArea();
    }

    public void setCarnivalBarrageOpen(boolean r1) {
        this.isCarnivalBarrageOpen = r1;
    }

    public void setChatChannelOpen(boolean r1) {
        this.isChatChannelOpen = r1;
    }

    public void setFontSize(BarrageSettingFont r1) {
        this.fontSize = r1.getFont();
    }

    public void setGiftOpen(boolean r1) {
        this.isGiftOpen = r1;
    }

    public void setLotteryOpen(boolean r1) {
        this.isLotteryOpen = r1;
    }

    public void setNeedRollback(boolean r1) {
        this.isNeedRollback = r1;
    }
}
