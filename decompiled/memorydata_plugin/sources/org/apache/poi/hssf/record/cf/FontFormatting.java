package org.apache.poi.hssf.record.cf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class FontFormatting implements GenericRecord {
    private static final BitField CANCELLATION = null;
    private static final BitField OUTLINE = null;
    private static final BitField POSTURE = null;
    private static final BitField SHADOW = null;
    private final byte[] _rawData;

    static {
        POSTURE = BitFieldFactory.getInstance(2);
        OUTLINE = BitFieldFactory.getInstance(8);
        SHADOW = BitFieldFactory.getInstance(16);
        CANCELLATION = BitFieldFactory.getInstance(128);
    }

    public FontFormatting() {
        this._rawData = new byte[118];
        setFontHeight(-1);
        setItalic(false);
        setFontWieghtModified(false);
        setOutline(false);
        setShadow(false);
        setStrikeout(false);
        setEscapementType(0);
        setUnderlineType(0);
        setFontColorIndex(-1);
        setFontStyleModified(false);
        setFontOutlineModified(false);
        setFontShadowModified(false);
        setFontCancellationModified(false);
        setEscapementTypeModified(false);
        setUnderlineTypeModified(false);
        setShort(0, 0);
        setInt(104, 1);
        setInt(108, 0);
        setInt(112, Integer.MAX_VALUE);
        setShort(116, 1);
    }

    public FontFormatting(RecordInputStream r2) {
        byte[] r0 = new byte[118];
        this._rawData = r0;
        r2.readFully(r0);
    }

    private int getInt(int r1) {
        return LittleEndian.getInt(this._rawData, r1);
    }

    private short getShort(int r1) {
        return LittleEndian.getShort(this._rawData, r1);
    }

    private void setFontOption(boolean r3, BitField r4) {
        setInt(68, r4.setBoolean(getInt(68), r3));
    }

    private void setInt(int r1, int r2) {
        LittleEndian.putInt(this._rawData, r1, r2);
    }

    private void setOptionFlag(boolean r3, BitField r4) {
        int r5 = !r3 ? 1 : 0;
        setInt(88, r4.setValue(getInt(88), r5));
    }

    private void setShort(int r1, int r2) {
        LittleEndian.putShort(this._rawData, r1, (short) r2);
    }

    public int getDataLength() {
        return 118;
    }

    public short getEscapementType() {
        return getShort(74);
    }

    public short getFontColorIndex() {
        return (short) getInt(80);
    }

    public int getFontHeight() {
        return getInt(64);
    }

    public short getFontWeight() {
        return getShort(72);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("fontHeight", new $$Lambda$KaV4ZzTHEHVDe_lisK3FrvOuiw(this));
        Supplier r2 = new $$Lambda$FontFormatting$gMmwlqmerHFs6v7SKbOhBcpRnyw(this);
        BitField r5 = POSTURE;
        BitField r7 = OUTLINE;
        BitField r9 = SHADOW;
        BitField r11 = CANCELLATION;
        r1.put("options", GenericRecordUtil.getBitsAsString(r2, new BitField[]{r5, r7, r9, r11}, new String[]{"POSTURE_MODIFIED", "OUTLINE_MODIFIED", "SHADOW_MODIFIED", "STRUCKOUT_MODIFIED"}));
        r1.put("fontOptions", GenericRecordUtil.getBitsAsString(new $$Lambda$FontFormatting$QqeSwve14QEvRt10fZq6qALF18(this), new BitField[]{r5, r7, r9, r11}, new String[]{"ITALIC", "OUTLINE", "SHADOW", "STRUCKOUT"}));
        r1.put("fontWEightModified", new $$Lambda$zrhcN4ZlfZelCxupH4_oaEhh8rA(this));
        r1.put("fontWeight", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$UHZO6R34yl362W7_Th4gWqlVjWM(this), new int[]{400, TypedValues.TransitionType.TYPE_DURATION}, new String[]{"NORMAL", "BOLD"}));
        r1.put("escapementTypeModified", new $$Lambda$CQ7SsRwzOt9ok_ftGD80Fj32PBA(this));
        r1.put("escapementType", new $$Lambda$PhXEUHq4IuolbUVgJcCZFkeP5Mw(this));
        r1.put("underlineTypeModified", new $$Lambda$SofvJG1a9AqI7v5aO2l9mrC0bRM(this));
        r1.put("underlineType", new $$Lambda$vqgKCsSt1_CuLgjDbXNuGQ2vUQ(this));
        r1.put("colorIndex", new $$Lambda$0V3WjdPSL3HYhmL_PaBQAOrRw(this));
        return Collections.unmodifiableMap(r1);
    }

    public byte[] getRawRecord() {
        return this._rawData;
    }

    public short getUnderlineType() {
        return getShort(76);
    }

    public boolean isEscapementTypeModified() {
        if (getInt(92) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFontWeightModified() {
        if (getInt(100) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUnderlineTypeModified() {
        if (getInt(96) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ Number lambda$getGenericProperties$0$FontFormatting() {
        return Integer.valueOf(getInt(88));
    }

    public /* synthetic */ Number lambda$getGenericProperties$1$FontFormatting() {
        return Integer.valueOf(getInt(68));
    }

    public void setEscapementType(short r2) {
        setShort(74, r2);
    }

    public void setEscapementTypeModified(boolean r2) {
        setInt(92, !r2 ? 1 : 0);
    }

    public void setFontCancellationModified(boolean r2) {
        setOptionFlag(r2, CANCELLATION);
    }

    public void setFontColorIndex(short r2) {
        setInt(80, r2);
    }

    public void setFontHeight(int r2) {
        setInt(64, r2);
    }

    public void setFontOutlineModified(boolean r2) {
        setOptionFlag(r2, OUTLINE);
    }

    public void setFontShadowModified(boolean r2) {
        setOptionFlag(r2, SHADOW);
    }

    public void setFontStyleModified(boolean r2) {
        setOptionFlag(r2, POSTURE);
    }

    public void setFontWieghtModified(boolean r2) {
        setInt(100, !r2 ? 1 : 0);
    }

    public void setItalic(boolean r2) {
        setFontOption(r2, POSTURE);
    }

    public void setOutline(boolean r2) {
        setFontOption(r2, OUTLINE);
    }

    public void setShadow(boolean r2) {
        setFontOption(r2, SHADOW);
    }

    public void setStrikeout(boolean r2) {
        setFontOption(r2, CANCELLATION);
    }

    public void setUnderlineType(short r2) {
        setShort(76, r2);
    }

    public void setUnderlineTypeModified(boolean r2) {
        setInt(96, !r2 ? 1 : 0);
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
