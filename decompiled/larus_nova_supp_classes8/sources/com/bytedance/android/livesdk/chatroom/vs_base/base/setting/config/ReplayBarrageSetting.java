package com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class ReplayBarrageSetting implements Serializable {
    public static final int DEFAULT_ALPHA = 75;

    @SerializedName("alpha")
    private float alpha;

    @SerializedName("barrage_area")
    private float barrageArea;

    @SerializedName("font_size")
    private int fontSize;

    @SerializedName("is_need_roll_back")
    private boolean isNeedRollback;

    @SerializedName("speed")
    private float speed;

    public static ReplayBarrageSetting getDefaultPortraitStyleSetting() {
        ReplayBarrageSetting r0 = new ReplayBarrageSetting();
        r0.setFontSize(ReplayBarrageSettingFont.VS_PORTRAIT_MID);
        r0.setBarrageArea(0.45f);
        r0.setAlpha(75.0f);
        return r0;
    }

    public static ReplayBarrageSetting getDefaultStyleSetting() {
        ReplayBarrageSetting r0 = new ReplayBarrageSetting();
        r0.setFontSize(ReplayBarrageSettingFont.MID);
        r0.setBarrageArea(0.45f);
        r0.setAlpha(75.0f);
        return r0;
    }

    public ReplayBarrageSettingFont getFontSize() {
        ReplayBarrageSettingFont.a r0 = ReplayBarrageSettingFont.Companion;
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
        return ReplayBarrageSettingFont.MID;
    L17:
        return ReplayBarrageSettingFont.PORTRAIT;
    L18:
        return ReplayBarrageSettingFont.VS_PORTRAIT_LARGE;
    L19:
        return ReplayBarrageSettingFont.VS_PORTRAIT_BIG;
    L20:
        return ReplayBarrageSettingFont.VS_PORTRAIT_MID;
    L21:
        return ReplayBarrageSettingFont.VS_PORTRAIT_SMALL;
    L22:
        return ReplayBarrageSettingFont.VS_PORTRAIT;
    L23:
        return ReplayBarrageSettingFont.SMALL;
    L24:
        return ReplayBarrageSettingFont.MID;
    L25:
        return ReplayBarrageSettingFont.BIG;
    L15:
        return ReplayBarrageSettingFont.LARGE;
    }

    public ReplayBarrageSettingSpeed getSpeed() {
        ReplayBarrageSettingSpeed.a r0 = ReplayBarrageSettingSpeed.Companion;
        float r1 = this.speed;
        r0.getClass();
        ReplayBarrageSettingSpeed[] r2 = ReplayBarrageSettingSpeed.values();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L11;
        ReplayBarrageSettingSpeed r5 = r2[r4];
        if (r5.getFactor() != r1) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L12;
        r4 = r4 + 1;
    L12:
        if (r5 == null) goto L14;
        return r5;
    L14:
        return ReplayBarrageSettingSpeed.NORMAL;
    L7:
        r6 = false;
        goto L8
    L11:
        r5 = null;
        goto L12
    }

    public ReplayBarrageSetting() {
        this.barrageArea = 0.45f;
        this.fontSize = ReplayBarrageSettingFont.MID.getFont();
        this.alpha = 100.0f;
        this.speed = 1.0f;
        this.isNeedRollback = false;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public float getBarrageArea() {
        return this.barrageArea;
    }

    public void setAlpha(float r1) {
        this.alpha = r1;
    }

    public void setBarrageArea(float r1) {
        this.barrageArea = r1;
    }

    public void setFontSize(ReplayBarrageSettingFont r1) {
        this.fontSize = r1.getFont();
    }

    public void setSpeed(ReplayBarrageSettingSpeed r1) {
        this.speed = r1.getFactor();
    }
}
