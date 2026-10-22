package com.alibaba.excel.exception;

import com.alibaba.excel.metadata.a.c;
import com.alibaba.excel.metadata.data.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ExcelDataConvertException extends ExcelRuntimeException {
    private a<?> cellData;
    private Integer columnIndex;
    private c excelContentProperty;
    private Integer rowIndex;

    public ExcelDataConvertException(Integer r1, Integer r2, a<?> r3, c r4, String r5) {
        super(r5);
        this.rowIndex = r1;
        this.columnIndex = r2;
        this.cellData = r3;
        this.excelContentProperty = r4;
    }

    public ExcelDataConvertException(Integer r1, Integer r2, a<?> r3, c r4, String r5, Throwable r6) {
        super(r5, r6);
        this.rowIndex = r1;
        this.columnIndex = r2;
        this.cellData = r3;
        this.excelContentProperty = r4;
    }

    public boolean canEqual(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, ExcelDataConvertException.class);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ExcelDataConvertException.class) == true) goto L8;
        return false;
    L8:
        ExcelDataConvertException r0 = (ExcelDataConvertException) ZeusTransformUtils.preCheckCast(r5, ExcelDataConvertException.class, "com.obric.memorydata.plugin");
        if (r0.canEqual(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        Integer r6 = getRowIndex();
        Integer r2 = r0.getRowIndex();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        Integer r7 = getColumnIndex();
        Integer r3 = r0.getColumnIndex();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        a<?> r8 = getCellData();
        a<?> r4 = r0.getCellData();
        if (r8 != null) goto L33;
        if (r4 != null) goto L34;
    L35:
        c r9 = getExcelContentProperty();
        c r10 = r0.getExcelContentProperty();
        if (r9 != null) goto L40;
        if (r10 != null) goto L41;
    L42:
        return true;
    L41:
        return false;
    L40:
        if (r9.equals(r10) == true) goto L42;
    L34:
        return false;
    L33:
        if (r8.equals(r4) == true) goto L35;
    L27:
        return false;
    L26:
        if (r7.equals(r3) == true) goto L28;
    L20:
        return false;
    L19:
        if (r6.equals(r2) == true) goto L21;
        goto L20
    }

    public a<?> getCellData() {
        return this.cellData;
    }

    public Integer getColumnIndex() {
        return this.columnIndex;
    }

    public c getExcelContentProperty() {
        return this.excelContentProperty;
    }

    public Integer getRowIndex() {
        return this.rowIndex;
    }

    public int hashCode() {
        int r0 = super.hashCode();
        Integer r1 = getRowIndex();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        Integer r6 = getColumnIndex();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        int r9 = r7 + r8;
        a<?> r10 = getCellData();
        int r11 = r9 * 59;
        if (r10 != null) goto L13;
        int r12 = 43;
    L14:
        c r13 = getExcelContentProperty();
        int r14 = (r11 + r12) * 59;
        if (r13 == null) goto L19;
        r3 = r13.hashCode();
    L19:
        return r14 + r3;
    L13:
        r12 = r10.hashCode();
        goto L14
    L9:
        r8 = r6.hashCode();
        goto L10
    L5:
        r4 = r1.hashCode();
        goto L6
    }

    public void setCellData(a<?> r1) {
        this.cellData = r1;
    }

    public void setColumnIndex(Integer r1) {
        this.columnIndex = r1;
    }

    public void setExcelContentProperty(c r1) {
        this.excelContentProperty = r1;
    }

    public void setRowIndex(Integer r1) {
        this.rowIndex = r1;
    }
}
