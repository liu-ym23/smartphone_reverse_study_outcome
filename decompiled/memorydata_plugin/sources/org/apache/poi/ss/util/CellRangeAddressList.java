package org.apache.poi.ss.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.RecordInputStream;

/* JADX INFO: loaded from: classes7.dex */
public class CellRangeAddressList implements GenericRecord {
    protected final List<CellRangeAddress> _list;

    public CellRangeAddressList() {
        this._list = new ArrayList();
    }

    public CellRangeAddressList(RecordInputStream r5) {
        this._list = new ArrayList();
        int r0 = r5.readUShort();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this._list.add(new CellRangeAddress(r5));
        r1 = r1 + 1;
        goto L3
    }

    public static int getEncodedSize(int r0) {
        return CellRangeAddress.getEncodedSize(r0) + 2;
    }

    public CellRangeAddress[] getCellRangeAddresses() {
        CellRangeAddress[] r0 = new CellRangeAddress[this._list.size()];
        this._list.toArray(r0);
        return r0;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public List<CellRangeAddress> getGenericChildren() {
        return this._list;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }

    public int getSize() {
        return getEncodedSize(this._list.size());
    }
}
