package com.obric.memorydata.database.util.file_utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/XlsxFileProcessor;", "Lcom/obric/memorydata/database/util/file_utils/BaseExcelProcessor;", "<init>", "()V", "fileTypeTag", "", "getFileTypeTag", "()Ljava/lang/String;", "createWorkbook", "Lorg/apache/poi/xssf/usermodel/XSSFWorkbook;", "fis", "Ljava/io/FileInputStream;", "supportedFileType", "Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "getSupportedFileType", "()Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ad extends c {
    private final String c;
    private final FileExtension d;

    public ad() {
        this.c = "XlsxFileProcessor";
        this.d = FileExtension.XLSX;
    }

    @Override // com.obric.memorydata.database.util.file_utils.c, com.obric.memorydata.database.util.file_utils.b
    public String a() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.util.file_utils.c
    public /* synthetic */ Workbook a(FileInputStream r2) {
        return (Workbook) ZeusTransformUtils.preCheckCast(b(r2), Workbook.class, "com.obric.memorydata.plugin");
    }

    public XSSFWorkbook b(FileInputStream r3) {
        Intrinsics.checkNotNullParameter(r3, "fis");
        return new XSSFWorkbook((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.util.file_utils.o
    public FileExtension j() {
        return this.d;
    }
}
