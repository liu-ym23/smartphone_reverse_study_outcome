package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.hslf.model.textproperties.HSLFTabStop;
import org.apache.poi.hslf.model.textproperties.HSLFTabStopPropCollection;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LittleEndianOutputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class TextRulerAtom extends RecordAtom {
    private static final BitField C_LEVELS = null;
    private static final BitField DEFAULT_TAB_SIZE = null;
    private static final BitField[] INDENT_LVL_MASK = null;
    private static final BitField[] LEFT_MARGIN_LVL_MASK = null;
    private static final BitField TAB_STOPS = null;
    private final byte[] _header;
    private Integer defaultTabSize;
    private final Integer[] indent;
    private final Integer[] leftMargin;
    private Integer numLevels;
    private final List<HSLFTabStop> tabStops;

    static {
        DEFAULT_TAB_SIZE = BitFieldFactory.getInstance(1);
        C_LEVELS = BitFieldFactory.getInstance(2);
        TAB_STOPS = BitFieldFactory.getInstance(4);
        LEFT_MARGIN_LVL_MASK = new BitField[]{BitFieldFactory.getInstance(8), BitFieldFactory.getInstance(16), BitFieldFactory.getInstance(32), BitFieldFactory.getInstance(64), BitFieldFactory.getInstance(128)};
        INDENT_LVL_MASK = new BitField[]{BitFieldFactory.getInstance(256), BitFieldFactory.getInstance(512), BitFieldFactory.getInstance(1024), BitFieldFactory.getInstance(2048), BitFieldFactory.getInstance(4096)};
    }

    public TextRulerAtom() {
        byte[] r0 = new byte[8];
        this._header = r0;
        this.tabStops = new ArrayList();
        this.leftMargin = new Integer[5];
        this.indent = new Integer[5];
        LittleEndian.putShort(r0, 2, (short) getRecordType());
    }

    TextRulerAtom(byte[] r4, int r5, int r6) {
        byte[] r0 = new byte[8];
        this._header = r0;
        this.tabStops = new ArrayList();
        this.leftMargin = new Integer[5];
        this.indent = new Integer[5];
        LittleEndianByteArrayInputStream r1 = new LittleEndianByteArrayInputStream(r4, r5, Math.min(r6, getMaxRecordLength()));
        IOUtils.readFully(r1, r0);     // Catch: IOException -> L5
        read(r1);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        LOG.atError().a(e).a("Failed to parse TextRulerAtom");
    }

    private void read(LittleEndianByteArrayInputStream r5) {
        int r0 = r5.readInt();
        this.numLevels = readIf(r5, r0, C_LEVELS);
        this.defaultTabSize = readIf(r5, r0, DEFAULT_TAB_SIZE);
        if (TAB_STOPS.isSet(r0) == false) goto L5;
        this.tabStops.addAll(HSLFTabStopPropCollection.readTabStops(r5));
    L5:
        int r1 = 0;
    L7:
        if (r1 >= 5) goto L9;
        this.leftMargin[r1] = readIf(r5, r0, LEFT_MARGIN_LVL_MASK[r1]);
        this.indent[r1] = readIf(r5, r0, INDENT_LVL_MASK[r1]);
        r1 = r1 + 1;
        goto L7
    }

    private static Integer readIf(LittleEndianByteArrayInputStream r0, int r1, BitField r2) {
        if (r2.isSet(r1) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.readShort());
    }

    private static int writeIf(LittleEndianOutputStream r1, Integer r2, BitField r3) {
        if (r2 == null) goto L5;
        r1.writeShort(r2.intValue());
        boolean r4 = true;
    L7:
        return r3.setBoolean(0, r4);
    L5:
        r4 = false;
        goto L7
    }

    private static int writeIf(LittleEndianOutputStream r2, List<HSLFTabStop> r3, BitField r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
    L7:
        boolean r6 = false;
    L9:
        return r4.setBoolean(0, r6);
    L5:
        if (r5.isEmpty() == true) goto L7;
        HSLFTabStopPropCollection.writeTabStops(r2, r5);
        r6 = true;
        goto L9
    }

    public int getDefaultTabSize() {
        Integer r0 = this.defaultTabSize;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("defaultTabSize", new $$Lambda$RZ9GHiLnfUlbpn6CqA9wuPY8vw(this), "numLevels", new $$Lambda$llQvfJ8u3fQeEdsgdSRich2tIm0(this), "tabStops", new $$Lambda$r41x5TW9PVRGgfltCcoXm4Rdg4(this), "leftMargins", new $$Lambda$TextRulerAtom$zM3VWGvAbOYZ_Fk6Pcdf2qvQ_TA(this), "indents", new $$Lambda$TextRulerAtom$RIQQriU094H07RH6ae9z2EhNs(this));
    }

    public int getNumberOfLevels() {
        Integer r0 = this.numLevels;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.TextRulerAtom.typeID;
    }

    public List<HSLFTabStop> getTabStops() {
        return this.tabStops;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$TextRulerAtom() {
        return this.leftMargin;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$TextRulerAtom() {
        return this.indent;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r8) {
        UnsynchronizedByteArrayOutputStream r0 = new UnsynchronizedByteArrayOutputStream(200);
        LittleEndianOutputStream r1 = new LittleEndianOutputStream(r0);
        int r2 = ((writeIf(r1, this.numLevels, C_LEVELS) | 0) | writeIf(r1, this.defaultTabSize, DEFAULT_TAB_SIZE)) | writeIf(r1, this.tabStops, TAB_STOPS);
        int r4 = 0;
    L4:
        if (r4 >= 5) goto L6;
        r2 = (r2 | writeIf(r1, this.leftMargin[r4], LEFT_MARGIN_LVL_MASK[r4])) | writeIf(r1, this.indent[r4], INDENT_LVL_MASK[r4]);
        r4 = r4 + 1;
        goto L4
    L6:
        LittleEndian.putInt(this._header, 4, r0.size() + 4);
        r8.write(this._header);
        LittleEndian.putUShort(r2, r8);
        LittleEndian.putUShort(0, r8);
        r0.writeTo(r8);
    }
}
