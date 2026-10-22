package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.fonts.FontFamily;
import org.apache.poi.common.usermodel.fonts.FontPitch;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class FontEntityAtom extends RecordAtom {
    private static final int[] FLAGS_MASKS = null;
    private static final String[] FLAGS_NAMES = null;
    private final byte[] _header;
    private byte[] _recdata;

    static {
        FLAGS_MASKS = new int[]{1, 256, 512, 1024, 2048};
        FLAGS_NAMES = new String[]{"EMBED_SUBSETTED", "RASTER_FONT", "DEVICE_FONT", "TRUETYPE_FONT", "NO_FONT_SUBSTITUTION"};
    }

    public FontEntityAtom() {
        this._recdata = new byte[68];
        byte[] r0 = new byte[8];
        this._header = r0;
        LittleEndian.putShort(r0, 2, (short) getRecordType());
        LittleEndian.putInt(r0, 4, this._recdata.length);
    }

    FontEntityAtom(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._recdata = IOUtils.safelyClone(r2, r0, r4 - 8, getMaxRecordLength());
    }

    public int getCharSet() {
        return this._recdata[64];
    }

    public int getFontFlags() {
        return this._recdata[65];
    }

    public int getFontIndex() {
        return LittleEndian.getShort(this._header, 0) >> 4;
    }

    public String getFontName() {
        int r0 = Math.min(this._recdata.length, 64) / 2;
        return StringUtil.getFromUnicodeLE0Terminated(this._recdata, 0, r0);
    }

    public int getFontType() {
        return this._recdata[66];
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("fontName", new $$Lambda$HMg88WGm9z2hpRhmy0XT55G2MYU(this), "fontIndex", new $$Lambda$annBGAwUNkRwUQp6f14p4HYtPng(this), "charset", new $$Lambda$aY2zTzodVVtfpXWCB8PuCMNwk(this), "fontFlags", GenericRecordUtil.getBitsAsString(new $$Lambda$tkUvMjoyUQpRkQCAAhMe_gqliMY(this), FLAGS_MASKS, FLAGS_NAMES), "fontPitch", new $$Lambda$FontEntityAtom$6L5wEf8sZcZwnDOjjD7EKbpvQbE(this), "fontFamily", new $$Lambda$FontEntityAtom$Vmu6IKiEUG6r0z9RR2WUYgaiwNc(this));
    }

    public int getPitchAndFamily() {
        return this._recdata[67];
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.FontEntityAtom.typeID;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$FontEntityAtom() {
        return FontPitch.valueOfPitchFamily((byte) getPitchAndFamily());
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$FontEntityAtom() {
        return FontFamily.valueOfPitchFamily((byte) getPitchAndFamily());
    }

    public void setCharSet(int r2) {
        this._recdata[64] = (byte) r2;
    }

    public void setFontFlags(int r2) {
        this._recdata[65] = (byte) r2;
    }

    public void setFontIndex(int r2) {
        LittleEndian.putShort(this._header, 0, (short) r2);
    }

    public void setFontName(String r4) {
        if ((r4.length() + (!r4.endsWith("\u0000"))) > 32) goto L7;
        byte[] r5 = StringUtil.getToUnicodeLE(r4);
        System.arraycopy(r5, 0, this._recdata, 0, r5.length);
        Arrays.fill(this._recdata, r5.length, 64, (byte) 0);
        return;
    L7:
        throw new HSLFException("The length of the font name, including null termination, must not exceed 32 characters");
    }

    public void setFontType(int r2) {
        this._recdata[66] = (byte) r2;
    }

    public void setPitchAndFamily(int r2) {
        this._recdata[67] = (byte) r2;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._recdata);
    }
}
