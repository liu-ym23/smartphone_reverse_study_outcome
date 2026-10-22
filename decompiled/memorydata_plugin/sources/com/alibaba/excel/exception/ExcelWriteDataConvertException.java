package com.alibaba.excel.exception;

import com.alibaba.excel.j.a.b.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ExcelWriteDataConvertException extends ExcelDataConvertException {
    private a cellWriteHandlerContext;

    public ExcelWriteDataConvertException(a r7, String r8) {
        super(r7.f(), r7.h(), r7.l(), r7.n(), r8);
        this.cellWriteHandlerContext = r7;
    }

    public ExcelWriteDataConvertException(a r8, String r9, Throwable r10) {
        super(r8.f(), r8.h(), r8.l(), r8.n(), r9, r10);
        this.cellWriteHandlerContext = r8;
    }

    @Override // com.alibaba.excel.exception.ExcelDataConvertException
    public boolean canEqual(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, ExcelWriteDataConvertException.class);
    }

    @Override // com.alibaba.excel.exception.ExcelDataConvertException
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ExcelWriteDataConvertException.class) == true) goto L8;
        return false;
    L8:
        ExcelWriteDataConvertException r0 = (ExcelWriteDataConvertException) ZeusTransformUtils.preCheckCast(r5, ExcelWriteDataConvertException.class, "com.obric.memorydata.plugin");
        if (r0.canEqual(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        a r4 = getCellWriteHandlerContext();
        a r6 = r0.getCellWriteHandlerContext();
        if (r4 != null) goto L19;
        if (r6 != null) goto L20;
    L21:
        return true;
    L20:
        return false;
    L19:
        if (r4.equals(r6) == true) goto L21;
        goto L20
    }

    public a getCellWriteHandlerContext() {
        return this.cellWriteHandlerContext;
    }

    @Override // com.alibaba.excel.exception.ExcelDataConvertException
    public int hashCode() {
        int r0 = super.hashCode();
        a r1 = getCellWriteHandlerContext();
        int r2 = r0 * 59;
        if (r1 != null) goto L5;
        int r3 = 43;
    L7:
        return r2 + r3;
    L5:
        r3 = r1.hashCode();
        goto L7
    }

    public void setCellWriteHandlerContext(a r1) {
        this.cellWriteHandlerContext = r1;
    }
}
