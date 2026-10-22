package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.ShortCompanionObject;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.ss.usermodel.CellStyle;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFCellStyle implements CellStyle {
    private static final ThreadLocal<String> getDataFormatStringCache = null;
    private static final ThreadLocal<Short> lastDateFormat = null;
    private static final ThreadLocal<List<FormatRecord>> lastFormats = null;
    private final ExtendedFormatRecord _format;
    private final short _index;
    private final InternalWorkbook _workbook;

    static {
        lastDateFormat = ThreadLocal.withInitial($$Lambda$HSSFCellStyle$2QPZPFoJ5equKuw5Rpgmn4zHZ6U.INSTANCE);
        lastFormats = new ThreadLocal();
        getDataFormatStringCache = new ThreadLocal();
    }

    public HSSFCellStyle(short r1, ExtendedFormatRecord r2, InternalWorkbook r3) {
        this._workbook = r3;
        this._index = r1;
        this._format = r2;
    }

    public HSSFCellStyle(short r1, ExtendedFormatRecord r2, HSSFWorkbook r3) {
        this(r1, r2, r3.getWorkbook());
    }

    static /* synthetic */ Short lambda$static$0() {
        return Short.valueOf(ShortCompanionObject.MIN_VALUE);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, HSSFCellStyle.class) == false) goto L22;
        HSSFCellStyle r6 = (HSSFCellStyle) ZeusTransformUtils.preCheckCast(r5, HSSFCellStyle.class, "com.obric.memorydata.plugin");
        ExtendedFormatRecord r0 = this._format;
        if (r0 != null) goto L16;
        if (r6._format == null) goto L19;
        return false;
    L19:
        if (this._index == r6._index) goto L21;
        return false;
    L21:
        return true;
    L16:
        if (r0.equals(r6._format) == true) goto L19;
        return false;
    L22:
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getDataFormat() {
        return this._format.getFormatIndex();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public String getDataFormatString() {
        ThreadLocal<String> r0 = getDataFormatStringCache;
        if (r0.get() != null) goto L5;
    L10:
        lastFormats.set(this._workbook.getFormats());
        lastDateFormat.set(Short.valueOf(getDataFormat()));
        r0.set(getDataFormatString(this._workbook));
    L9:
        return (String) ZeusTransformUtils.preCheckCast(r0.get(), String.class, "com.obric.memorydata.plugin");
    L5:
        if (((Short) ZeusTransformUtils.preCheckCast(lastDateFormat.get(), Short.class, "com.obric.memorydata.plugin")).shortValue() != getDataFormat()) goto L10;
        if (this._workbook.getFormats().equals(lastFormats.get()) == false) goto L10;
        goto L10
    }

    public String getDataFormatString(InternalWorkbook r2) {
        return new HSSFDataFormat(r2).getFormat(getDataFormat());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public int getFontIndex() {
        return this._format.getFontIndex();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getIndention() {
        return this._format.getIndent();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getIndex() {
        return this._index;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getRotation() {
        short r1 = this._format.getRotation();
        if (r1 != 255) goto L6;
        return r1;
    L6:
        if (r1 > 90) goto L8;
        return r1;
    L8:
        return (short) (90 - r1);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this._format, Short.valueOf(this._index)});
    }
}
