package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.hslf.model.textproperties.TextPropCollection;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class TxMasterStyleAtom extends RecordAtom {
    private static final c LOG = null;
    private static final long _type = 0;
    private byte[] _data;
    private final byte[] _header;
    private List<TextPropCollection> charStyles;
    private List<TextPropCollection> paragraphStyles;

    static {
        LOG = b.a(TxMasterStyleAtom.class);
        _type = RecordTypes.TxMasterStyleAtom.typeID;
    }

    public TxMasterStyleAtom(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._data = IOUtils.safelyClone(r2, r0, r4 - 8, getMaxRecordLength());
        init();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        LOG.atWarn().a(e).a("Exception when reading available styles");
    }

    public List<TextPropCollection> getCharacterStyles() {
        return this.charStyles;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("paragraphStyles", new $$Lambda$SQJ1D0IZFNNgcldfmM7rvuXm4(this), "charStyles", new $$Lambda$3Se8JsWG8alZCdIwVj7PhvghLMs(this));
    }

    public List<TextPropCollection> getParagraphStyles() {
        return this.paragraphStyles;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public int getTextType() {
        return LittleEndian.getShort(this._header, 0) >> 4;
    }

    public void init() {
        int r0 = getTextType();
        short r1 = LittleEndian.getShort(this._data, 0);
        this.paragraphStyles = new ArrayList(r1);
        this.charStyles = new ArrayList(r1);
        int r3 = 2;
        short r4 = 0;
    L3:
        if (r4 >= r1) goto L9;
        TextPropCollection r5 = new TextPropCollection(0, TextPropCollection.TextPropType.paragraph);
        if (r0 < TextShape.TextPlaceholder.CENTER_BODY.nativeId) goto L7;
        r5.setIndentLevel(LittleEndian.getShort(this._data, r3));
        r3 = r3 + 2;
    L8:
        int r6 = LittleEndian.getInt(this._data, r3);
        int r7 = r3 + 4;
        int r8 = r7 + r5.buildTextPropList(r6, this._data, r7);
        this.paragraphStyles.add(r5);
        int r9 = LittleEndian.getInt(this._data, r8);
        int r10 = r8 + 4;
        TextPropCollection r11 = new TextPropCollection(0, TextPropCollection.TextPropType.character);
        r3 = r10 + r11.buildTextPropList(r9, this._data, r10);
        this.charStyles.add(r11);
        r4 = (short) (r4 + 1);
        goto L3
    L7:
        r5.setIndentLevel(-1);
        goto L8
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._data);
    }
}
