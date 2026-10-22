package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hslf.model.textproperties.IndentProp;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class MasterTextPropAtom extends RecordAtom {
    private static int MAX_RECORD_LENGTH = 100000;
    private byte[] _data;
    private byte[] _header;
    private List<IndentProp> indents;

    static {
    }

    public MasterTextPropAtom() {
        byte[] r0 = new byte[8];
        this._header = r0;
        this._data = new byte[0];
        LittleEndian.putShort(r0, 2, (short) getRecordType());
        LittleEndian.putInt(this._header, 4, this._data.length);
        this.indents = new ArrayList();
    }

    public MasterTextPropAtom(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._data = IOUtils.safelyClone(r2, r0, r4 - 8, MAX_RECORD_LENGTH);
        read();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        LOG.atError().a(e).a("Failed to parse MasterTextPropAtom");
    }

    private void read() {
        this.indents = new ArrayList(this._data.length / 6);
        int r0 = 0;
    L3:
        byte[] r1 = this._data;
        if (r0 > (r1.length - 6)) goto L6;
        this.indents.add(new IndentProp(LittleEndian.getInt(r1, r0), LittleEndian.getShort(this._data, r0 + 4)));
        r0 = r0 + 6;
        goto L3
    }

    private void write() {
        this._data = IOUtils.safelyAllocate(Math.multiplyExact(this.indents.size(), 6), MAX_RECORD_LENGTH);
        Iterator<IndentProp> r0 = this.indents.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        IndentProp r2 = (IndentProp) ZeusTransformUtils.preCheckCast(r0.next(), IndentProp.class, "com.obric.memorydata.plugin");
        LittleEndian.putInt(this._data, r1, r2.getCharactersCovered());
        LittleEndian.putShort(this._data, r1 + 4, (short) r2.getIndentLevel());
        r1 = r1 + 6;
        goto L4
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("indents", new $$Lambda$KXZZMMAFhd56d5Utow5FForqsGI(this));
    }

    public List<IndentProp> getIndents() {
        return Collections.unmodifiableList(this.indents);
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.MasterTextPropAtom.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        write();
        r2.write(this._header);
        r2.write(this._data);
    }
}
