package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.common.usermodel.fonts.FontCharset;
import org.apache.poi.common.usermodel.fonts.FontFamily;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.common.usermodel.fonts.FontPitch;

/* JADX INFO: loaded from: classes7.dex */
public final enum HSLFFontInfoPredefined extends Enum<HSLFFontInfoPredefined> implements FontInfo {
    private static final /* synthetic */ HSLFFontInfoPredefined[] $VALUES = null;
    public static final HSLFFontInfoPredefined ARIAL = null;
    public static final HSLFFontInfoPredefined COURIER_NEW = null;
    public static final HSLFFontInfoPredefined TIMES_NEW_ROMAN = null;
    public static final HSLFFontInfoPredefined WINGDINGS = null;
    private FontCharset charset;
    private FontFamily family;
    private FontPitch pitch;
    private String typeface;

    static {
        HSLFFontInfoPredefined r7 = new HSLFFontInfoPredefined("ARIAL", 0, "Arial", FontCharset.ANSI, FontPitch.VARIABLE, FontFamily.FF_SWISS);
        ARIAL = r7;
        HSLFFontInfoPredefined r0 = new HSLFFontInfoPredefined("TIMES_NEW_ROMAN", 1, "Times New Roman", FontCharset.ANSI, FontPitch.VARIABLE, FontFamily.FF_ROMAN);
        TIMES_NEW_ROMAN = r0;
        HSLFFontInfoPredefined r1 = new HSLFFontInfoPredefined("COURIER_NEW", 2, "Courier New", FontCharset.ANSI, FontPitch.FIXED, FontFamily.FF_MODERN);
        COURIER_NEW = r1;
        HSLFFontInfoPredefined r2 = new HSLFFontInfoPredefined("WINGDINGS", 3, "Wingdings", FontCharset.SYMBOL, FontPitch.VARIABLE, FontFamily.FF_DONTCARE);
        WINGDINGS = r2;
        $VALUES = new HSLFFontInfoPredefined[]{r7, r0, r1, r2};
    }

    private HSLFFontInfoPredefined(String r1, int r2, String r3, FontCharset r4, FontPitch r5, FontFamily r6) {
        super(r1, r2);
        this.typeface = r3;
        this.charset = r4;
        this.pitch = r5;
        this.family = r6;
    }

    public static HSLFFontInfoPredefined valueOf(String r2) {
        return (HSLFFontInfoPredefined) ZeusTransformUtils.preCheckCast(Enum.valueOf(HSLFFontInfoPredefined.class, r2), HSLFFontInfoPredefined.class, "com.obric.memorydata.plugin");
    }

    public static HSLFFontInfoPredefined[] values() {
        return (HSLFFontInfoPredefined[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HSLFFontInfoPredefined[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontCharset getCharset() {
        return this.charset;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontFamily getFamily() {
        return this.family;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontPitch getPitch() {
        return this.pitch;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public String getTypeface() {
        return this.typeface;
    }
}
