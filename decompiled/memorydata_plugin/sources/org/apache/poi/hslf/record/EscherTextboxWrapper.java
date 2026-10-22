package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class EscherTextboxWrapper extends RecordContainer {
    private final EscherTextboxRecord _escherRecord;
    private long _type;
    private int shapeId;
    private StyleTextProp9Atom styleTextProp9Atom;
    private StyleTextPropAtom styleTextPropAtom;

    public EscherTextboxWrapper() {
        EscherTextboxRecord r0 = new EscherTextboxRecord();
        this._escherRecord = r0;
        r0.setRecordId(EscherTextboxRecord.RECORD_ID);
        r0.setOptions(15);
        this._children = new Record[0];
    }

    public EscherTextboxWrapper(EscherTextboxRecord r6) {
        this._escherRecord = r6;
        this._type = r6.getRecordId();
        byte[] r7 = r6.getData();
        int r1 = 0;
        this._children = Record.findChildRecords(r7, 0, r7.length);
        Record[] r8 = this._children;
        int r0 = r8.length;
    L3:
        if (r1 >= r0) goto L8;
        Record r2 = r8[r1];
        if (ZeusTransformUtils.instanceOf(r2, StyleTextPropAtom.class) == false) goto L7;
        this.styleTextPropAtom = (StyleTextPropAtom) ZeusTransformUtils.preCheckCast(r2, StyleTextPropAtom.class, "com.obric.memorydata.plugin");
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public EscherTextboxRecord getEscherRecord() {
        return this._escherRecord;
    }

    @Override // org.apache.poi.hslf.record.RecordContainer, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("shapeId", new $$Lambda$LGSF92hbgO9HndZtemDwKoEKi4U(this), "escherRecord", new $$Lambda$WDqKDgZmTMF91feBvPHPy_qiUQ(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return this._type;
    }

    public int getShapeId() {
        return this.shapeId;
    }

    public StyleTextProp9Atom getStyleTextProp9Atom() {
        return this.styleTextProp9Atom;
    }

    public void setShapeId(int r1) {
        this.shapeId = r1;
    }

    public void setStyleTextProp9Atom(StyleTextProp9Atom r1) {
        this.styleTextProp9Atom = r1;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r5) {
        UnsynchronizedByteArrayOutputStream r6 = new UnsynchronizedByteArrayOutputStream();
        Record[] r0 = this._children;     // Catch: Throwable -> L9
        int r1 = r0.length;     // Catch: Throwable -> L9
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L6;
        r0[r2].writeOut(r6);     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L4
    L6:
        this._escherRecord.setData(r6.toByteArray());     // Catch: Throwable -> L9
        r6.close();
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r6.close();     // Catch: Throwable -> L14
    L16:
        throw th;
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    }
}
