package com.larus.platform.model.comment;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u000f\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR \u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR \u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/larus/platform/model/comment/SenceColor;", "Ljava/io/Serializable;", "<init>", "()V", "gradientEffectStart", "", "getGradientEffectStart", "()Ljava/lang/String;", "setGradientEffectStart", "(Ljava/lang/String;)V", "gradientEffectEnd", "getGradientEffectEnd", "setGradientEffectEnd", "alphaSegmentation", "", "", "getAlphaSegmentation", "()Ljava/util/List;", "setAlphaSegmentation", "(Ljava/util/List;)V", "themeColorSetting", "getThemeColorSetting", "setThemeColorSetting", "themeColorSettingDark", "getThemeColorSettingDark", "setThemeColorSettingDark", "themeColorSettingLight", "getThemeColorSettingLight", "setThemeColorSettingLight", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SenceColor implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 0;

    @SerializedName("alpha_segmentation")
    private List<Double> alphaSegmentation;

    @SerializedName("gradient_effect_end")
    private String gradientEffectEnd;

    @SerializedName("gradient_effect_start")
    private String gradientEffectStart;

    @SerializedName("theme_color_setting")
    private String themeColorSetting;

    @SerializedName("theme_color_setting_dark")
    private String themeColorSettingDark;

    @SerializedName("theme_color_setting_light")
    private String themeColorSettingLight;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SenceColor() {
    }

    public final List<Double> getAlphaSegmentation() {
        return this.alphaSegmentation;
    }

    public final String getGradientEffectEnd() {
        return this.gradientEffectEnd;
    }

    public final String getGradientEffectStart() {
        return this.gradientEffectStart;
    }

    public final String getThemeColorSetting() {
        return this.themeColorSetting;
    }

    public final String getThemeColorSettingDark() {
        return this.themeColorSettingDark;
    }

    public final String getThemeColorSettingLight() {
        return this.themeColorSettingLight;
    }

    public final void setAlphaSegmentation(List<Double> r1) {
        this.alphaSegmentation = r1;
    }

    public final void setGradientEffectEnd(String r1) {
        this.gradientEffectEnd = r1;
    }

    public final void setGradientEffectStart(String r1) {
        this.gradientEffectStart = r1;
    }

    public final void setThemeColorSetting(String r1) {
        this.themeColorSetting = r1;
    }

    public final void setThemeColorSettingDark(String r1) {
        this.themeColorSettingDark = r1;
    }

    public final void setThemeColorSettingLight(String r1) {
        this.themeColorSettingLight = r1;
    }
}
