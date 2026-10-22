package org.apache.poi.hssf.eventusermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class FormatTrackingHSSFListener implements HSSFListener {
    private static final c LOG = null;
    private final HSSFListener _childListener;
    private final Map<Integer, FormatRecord> _customFormatRecords;
    private final NumberFormat _defaultFormat;
    private final HSSFDataFormatter _formatter;
    private final List<ExtendedFormatRecord> _xfRecords;

    static {
        LOG = b.a(FormatTrackingHSSFListener.class);
    }

    public FormatTrackingHSSFListener(HSSFListener r3) {
        this((HSSFListener) ZeusTransformUtils.wrapperContextForParams(r3, HSSFListener.class, "com.obric.memorydata.plugin"), LocaleUtil.getUserLocale());
    }

    public FormatTrackingHSSFListener(HSSFListener r3, Locale r4) {
        HSSFListener r5 = (HSSFListener) ZeusTransformUtils.wrapperContextForParams(r3, HSSFListener.class, "com.obric.memorydata.plugin");
        this._customFormatRecords = new HashMap();
        this._xfRecords = new ArrayList();
        this._childListener = r5;
        this._formatter = new HSSFDataFormatter(r4);
        this._defaultFormat = NumberFormat.getInstance(r4);
    }

    public int getFormatIndex(CellValueRecordInterface r4) {
        CellValueRecordInterface r5 = (CellValueRecordInterface) ZeusTransformUtils.wrapperContextForParams(r4, CellValueRecordInterface.class, "com.obric.memorydata.plugin");
        ExtendedFormatRecord r3 = (ExtendedFormatRecord) ZeusTransformUtils.preCheckCast(this._xfRecords.get(r5.getXFIndex()), ExtendedFormatRecord.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        LOG.atError().a("Cell {},{} uses XF with index {}, but we don't have that", v.a(r5.getRow()), v.a(r5.getColumn()), v.a(r5.getXFIndex()));
        return -1;
    L7:
        return r3.getFormatIndex();
    }

    public String getFormatString(int r3) {
        if (r3 < HSSFDataFormat.getNumberOfBuiltinBuiltinFormats()) goto L9;
        FormatRecord r2 = (FormatRecord) ZeusTransformUtils.preCheckCast(this._customFormatRecords.get(Integer.valueOf(r3)), FormatRecord.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L11;
        LOG.atError().a("Requested format at index {}, but it wasn't found", v.a(r3));
        return null;
    L11:
        return r2.getFormatString();
    L9:
        return HSSFDataFormat.getBuiltinFormat((short) r3);
    }

    public String getFormatString(CellValueRecordInterface r3) {
        int r4 = getFormatIndex((CellValueRecordInterface) ZeusTransformUtils.wrapperContextForParams(r3, CellValueRecordInterface.class, "com.obric.memorydata.plugin"));
        if (r4 != (-1)) goto L7;
        return null;
    L7:
        return getFormatString(r4);
    }

    @Override // org.apache.poi.hssf.eventusermodel.HSSFListener
    public void processRecord(Record r1) {
        processRecordInternally(r1);
        this._childListener.processRecord(r1);
    }

    public void processRecordInternally(Record r5) {
        if (ZeusTransformUtils.instanceOf(r5, FormatRecord.class) == false) goto L6;
        FormatRecord r0 = (FormatRecord) ZeusTransformUtils.preCheckCast(r5, FormatRecord.class, "com.obric.memorydata.plugin");
        this._customFormatRecords.put(Integer.valueOf(r0.getIndexCode()), r0);
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ExtendedFormatRecord.class) == false) goto L9;
        ExtendedFormatRecord r6 = (ExtendedFormatRecord) ZeusTransformUtils.preCheckCast(r5, ExtendedFormatRecord.class, "com.obric.memorydata.plugin");
        this._xfRecords.add(r6);
        return;
    }
}
