package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Vector;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.ss.usermodel.BuiltinFormats;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFDataFormat {
    private static final String[] _builtinFormats = null;
    private final Vector<String> _formats;
    private boolean _movedBuiltins;
    private final InternalWorkbook _workbook;

    static {
        _builtinFormats = BuiltinFormats.getAll();
    }

    HSSFDataFormat(InternalWorkbook r4) {
        this._formats = new Vector();
        this._workbook = r4;
        Iterator<FormatRecord> r5 = r4.getFormats().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        FormatRecord r0 = (FormatRecord) ZeusTransformUtils.preCheckCast(r5.next(), FormatRecord.class, "com.obric.memorydata.plugin");
        ensureFormatsSize(r0.getIndexCode());
        this._formats.set(r0.getIndexCode(), r0.getFormatString());
        goto L4
    }

    private void ensureFormatsSize(int r2) {
        if (this._formats.size() > r2) goto L6;
        this._formats.setSize(r2 + 1);
        return;
    }

    public static String getBuiltinFormat(short r0) {
        return BuiltinFormats.getBuiltinFormat(r0);
    }

    public static int getNumberOfBuiltinBuiltinFormats() {
        return _builtinFormats.length;
    }

    public String getFormat(short r4) {
        if (this._movedBuiltins == true) goto L5;
        String r2 = null;
        if (r4 != (-1)) goto L10;
        return null;
    L10:
        if (this._formats.size() <= r4) goto L12;
        r2 = (String) ZeusTransformUtils.preCheckCast(this._formats.get(r4), String.class, "com.obric.memorydata.plugin");
    L12:
        String[] r3 = _builtinFormats;
        if (r3.length > r4) goto L15;
    L20:
        return r2;
    L15:
        if (r3[r4] == null) goto L20;
        if (r2 == null) goto L19;
        return r2;
    L19:
        return r3[r4];
    L5:
        return (String) ZeusTransformUtils.preCheckCast(this._formats.get(r4), String.class, "com.obric.memorydata.plugin");
    }
}
