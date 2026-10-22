package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.hssf.record.FontRecord;
import org.apache.poi.ss.usermodel.Font;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFFont implements Font {
    private final FontRecord font;
    private final int index;

    public HSSFFont(int r1, FontRecord r2) {
        this.font = r2;
        this.index = r1;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, HSSFFont.class) == false) goto L23;
        HSSFFont r6 = (HSSFFont) ZeusTransformUtils.preCheckCast(r5, HSSFFont.class, "com.obric.memorydata.plugin");
        FontRecord r0 = this.font;
        if (r0 != null) goto L16;
        if (r6.font == null) goto L19;
        return false;
    L19:
        if (this.index != r6.index) goto L22;
        return true;
    L22:
        return false;
    L16:
        if (r0.equals(r6.font) == true) goto L19;
        return false;
    L23:
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getBold() {
        if (this.font.getBoldWeight() != 700) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getFontHeightInPoints() {
        return (short) (this.font.getFontHeight() / 20);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public String getFontName() {
        return this.font.getFontName();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getItalic() {
        return this.font.isItalic();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public byte getUnderline() {
        return this.font.getUnderline();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.font, Integer.valueOf(this.index)});
    }

    public String toString() {
        return "org.apache.poi.hssf.usermodel.HSSFFont{" + this.font + "}";
    }
}
