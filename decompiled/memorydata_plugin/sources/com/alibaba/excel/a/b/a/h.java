package com.alibaba.excel.a.b.a;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.enums.RowTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.util.Map;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.ss.usermodel.CellType;

/* JADX INFO: loaded from: classes.dex */
public class h extends a implements com.alibaba.excel.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f124a = null;

    /* JADX INFO: renamed from: com.alibaba.excel.a.b.a.h$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f125a = null;

        static {
            int[] r0 = new int[CellType.values().length];
            f125a = r0;
            r0[CellType.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f125a[CellType.NUMERIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f125a[CellType.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f125a[CellType.BOOLEAN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        f124a = org.slf4j.d.a(h.class);
    }

    public h() {
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r6, Record r7) {
        com.alibaba.excel.e.b.b r5 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r6, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        FormulaRecord r8 = (FormulaRecord) ZeusTransformUtils.preCheckCast(r7, FormulaRecord.class, "com.obric.memorydata.plugin");
        Map<Integer, com.alibaba.excel.metadata.e> r9 = r5.g().s();
        com.alibaba.excel.metadata.data.f<?> r0 = new com.alibaba.excel.metadata.data.f();
        r0.a(Integer.valueOf(r8.getRow()));
        r0.b(Integer.valueOf(r8.getColumn()));
        CellType r1 = CellType.forInt(r8.getCachedResultType());
        String r2 = HSSFFormulaParser.toFormulaString(r5.f().I(), r8.getParsedExpression());     // Catch: Exception -> L5
    L7:
        com.alibaba.excel.metadata.data.e r3 = new com.alibaba.excel.metadata.data.e();
        r3.a(r2);
        r0.a(r3);
        r5.g().a(RowTypeEnum.DATA);
        int r4 = AnonymousClass1.f125a[r1.ordinal()];
        if (r4 != 1) goto L10;
        r0.a(CellDataTypeEnum.STRING);
        r5.g().a(r0);
        return;
    L10:
        if (r4 != 2) goto L12;
        r0.a(CellDataTypeEnum.NUMBER);
        r0.b(BigDecimal.valueOf(r8.getValue()));
        r0.a(r0.j().round(com.alibaba.excel.d.b.f148a));
        int r10 = r5.f().H().getFormatIndex(r8);
        com.alibaba.excel.metadata.data.d r11 = new com.alibaba.excel.metadata.data.d();
        r11.a(Short.valueOf((short) r10));
        r11.a(com.alibaba.excel.d.a.a(r11.b(), r5.f().H().getFormatString(r8), r5.b().f().c()));
        r0.a(r11);
    L19:
        r9.put(Integer.valueOf(r8.getColumn()), r0);
        return;
    L12:
        if (r4 != 3) goto L14;
        r0.a(CellDataTypeEnum.ERROR);
        r0.a("#VALUE!");
        goto L19
    L14:
        if (r4 == 4) goto L16;
        r0.a(CellDataTypeEnum.EMPTY);
        goto L19
    L16:
        r0.a(CellDataTypeEnum.BOOLEAN);
        r0.a(Boolean.valueOf(r8.getCachedBooleanValue()));
    L5:
        e = move-exception;
        f124a.debug("Get formula value error.", e);
        r2 = null;
        goto L7
    }
}
