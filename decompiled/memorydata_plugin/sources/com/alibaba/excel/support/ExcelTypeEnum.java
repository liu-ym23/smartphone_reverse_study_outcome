package com.alibaba.excel.support;

import com.alibaba.excel.exception.ExcelAnalysisException;
import com.alibaba.excel.exception.ExcelCommonException;
import com.alibaba.excel.h.c.c;
import com.alibaba.excel.i.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.util.IOUtils;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes.dex */
public final enum ExcelTypeEnum extends Enum<ExcelTypeEnum> {
    private static final /* synthetic */ ExcelTypeEnum[] $VALUES = null;
    public static final ExcelTypeEnum CSV = null;
    static final int MAX_PATTERN_LENGTH = 8;
    public static final ExcelTypeEnum XLS = null;
    public static final ExcelTypeEnum XLSX = null;
    final byte[] magic;
    final String value;

    static {
        ExcelTypeEnum r0 = new ExcelTypeEnum("CSV", 0, ".csv", new byte[]{-27, -89, -109, -27});
        CSV = r0;
        ExcelTypeEnum r2 = new ExcelTypeEnum("XLS", 1, ".xls", new byte[]{MessagePack.Code.INT8, MessagePack.Code.UINT64, 17, MessagePack.Code.NEGFIXINT_PREFIX, -95, -79, 26, -31});
        XLS = r2;
        ExcelTypeEnum r3 = new ExcelTypeEnum("XLSX", 2, ".xlsx", new byte[]{80, 75, 3, 4});
        XLSX = r3;
        $VALUES = new ExcelTypeEnum[]{r0, r2, r3};
    }

    private ExcelTypeEnum(String r1, int r2, String r3, byte[] r4) {
        super(r1, r2);
        this.value = r3;
        this.magic = r4;
    }

    private static boolean findMagic(byte[] r6, byte[] r7) {
        int r0 = r6.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L10;
        byte r4 = r6[r2];
        int r5 = r3 + 1;
        if (r7[r3] == r4) goto L9;
        if (r4 == 63) goto L9;
        return false;
    L9:
        r2 = r2 + 1;
        r3 = r5;
        goto L3
    L10:
        return true;
    }

    private static ExcelTypeEnum recognitionExcelType(InputStream r2) {
        byte[] r3 = IOUtils.peekFirstNBytes(r2, 8);
        ExcelTypeEnum r0 = XLSX;
        if (findMagic(r0.magic, r3) == false) goto L5;
        return r0;
    L5:
        ExcelTypeEnum r1 = XLS;
        if (findMagic(r1.magic, r3) == false) goto L9;
        return r1;
    L9:
        return CSV;
    }

    public static ExcelTypeEnum valueOf(c r5) {
        ExcelTypeEnum r0 = r5.k();
        if (r0 == null) goto L5;
        return r0;
    L5:
        File r1 = r5.m();
        InputStream r2 = r5.l();
        if (r1 != null) goto L11;
        if (r2 != null) goto L11;
        throw new ExcelAnalysisException("File and inputStream must be a non-null.");
    L11:
        if (r1 == null) goto L54;
    L61:
        e = move-exception;
        throw e;
    L58:
        e = move-exception;
        throw new ExcelCommonException("Convert excel format exception.You can try specifying the 'excelType' yourself", e);
    L13:
        if (r1.exists() == false) goto L52;
        if (o.a(r5.u()) == true) goto L28;
        BufferedInputStream r6 = new BufferedInputStream(new FileInputStream(r1));     // Catch: Exception -> L58 ExcelCommonException -> L61
        ExcelTypeEnum r3 = recognitionExcelType(r6);     // Catch: Throwable -> L20
        r6.close();     // Catch: Exception -> L58 ExcelCommonException -> L61
        return r3;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r6.close();     // Catch: Throwable -> L25
    L27:
        throw th;     // Catch: Exception -> L58 ExcelCommonException -> L61
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L58 ExcelCommonException -> L61
        goto L27
    L28:
        String r4 = r1.getName();     // Catch: Exception -> L58 ExcelCommonException -> L61
        ExcelTypeEnum r7 = XLSX;     // Catch: Exception -> L58 ExcelCommonException -> L61
        if (r4.endsWith(r7.getValue()) == false) goto L31;
        return r7;
    L31:
        ExcelTypeEnum r8 = XLS;     // Catch: Exception -> L58 ExcelCommonException -> L61
        if (r4.endsWith(r8.getValue()) == false) goto L34;
        return r8;
    L34:
        ExcelTypeEnum r9 = CSV;     // Catch: Exception -> L58 ExcelCommonException -> L61
        if (r4.endsWith(r9.getValue()) == false) goto L38;
        return r9;
    L38:
        if (o.a(r5.u()) == false) goto L54;
        BufferedInputStream r10 = new BufferedInputStream(new FileInputStream(r1));     // Catch: Exception -> L58 ExcelCommonException -> L61
        ExcelTypeEnum r11 = recognitionExcelType(r10);     // Catch: Throwable -> L43
        r10.close();     // Catch: Exception -> L58 ExcelCommonException -> L61
        return r11;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L48
    L50:
        throw th;     // Catch: Exception -> L58 ExcelCommonException -> L61
    L48:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L58 ExcelCommonException -> L61
        goto L50
    L52:
        throw new ExcelAnalysisException("File " + r1.getAbsolutePath() + " not exists.");     // Catch: Exception -> L58 ExcelCommonException -> L61
    L54:
        if (r2.markSupported() == true) goto L57;
        BufferedInputStream r12 = new BufferedInputStream(r2);     // Catch: Exception -> L58 ExcelCommonException -> L61
        r5.a(r12);     // Catch: Exception -> L58 ExcelCommonException -> L61
        r2 = r12;
    L57:
        return recognitionExcelType(r2);
    }

    public static ExcelTypeEnum valueOf(String r2) {
        return (ExcelTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(ExcelTypeEnum.class, r2), ExcelTypeEnum.class, "com.obric.memorydata.plugin");
    }

    public static ExcelTypeEnum[] values() {
        return (ExcelTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExcelTypeEnum[].class, "com.obric.memorydata.plugin");
    }

    public byte[] getMagic() {
        return this.magic;
    }

    public String getValue() {
        return this.value;
    }
}
