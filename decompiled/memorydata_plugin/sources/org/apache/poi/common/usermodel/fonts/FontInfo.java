package org.apache.poi.common.usermodel.fonts;

/* JADX INFO: loaded from: classes4.dex */
public interface FontInfo {
    default FontCharset getCharset() {
        return FontCharset.ANSI;
    }

    default FontFamily getFamily() {
        return FontFamily.FF_DONTCARE;
    }

    default FontPitch getPitch() {
        return null;
    }

    String getTypeface();
}
