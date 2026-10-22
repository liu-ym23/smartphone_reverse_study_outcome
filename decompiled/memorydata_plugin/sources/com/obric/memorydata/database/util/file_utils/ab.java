package com.obric.memorydata.database.util.file_utils;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J.\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/XlsFileProcessor;", "Lcom/obric/memorydata/database/util/file_utils/BaseExcelProcessor;", "<init>", "()V", "fileTypeTag", "", "getFileTypeTag", "()Ljava/lang/String;", "createWorkbook", "Lorg/apache/poi/hssf/usermodel/HSSFWorkbook;", "fis", "Ljava/io/FileInputStream;", "supportedFileType", "Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "getSupportedFileType", "()Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "processCellValue", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "Lorg/apache/poi/ss/usermodel/Cell;", "processSheetImages", "", "sheet", "Lorg/apache/poi/ss/usermodel/Sheet;", "tree", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "parentId", "", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "(Lorg/apache/poi/ss/usermodel/Sheet;Lcom/obric/memorydata/database/util/file_utils/DocumentTree;ILcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ab extends c {
    private final String c;
    private final FileExtension d;

    public ab() {
        this.c = "XlsFileProcessor";
        this.d = FileExtension.XLS;
    }

    @Override // com.obric.memorydata.database.util.file_utils.c
    public Object a(Sheet r21, j r22, int r23, FileEntity r24, Continuation<? super Unit> r25) {
        Sheet r0 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r21, Sheet.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r25, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, XlsFileProcessor$processSheetImages$1.class) == false) goto L7;
        XlsFileProcessor$processSheetImages$1 r3 = (XlsFileProcessor$processSheetImages$1) ZeusTransformUtils.preCheckCast(r2, XlsFileProcessor$processSheetImages$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
        ab r4 = this;
    L8:
        Object r5 = r3.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r3.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        int r1 = r3.I$1;
        int r8 = r3.I$0;
        Iterator r9 = (Iterator) ZeusTransformUtils.preCheckCast(r3.L$3, Iterator.class, "com.obric.memorydata.plugin");
        FileEntity r10 = (FileEntity) ZeusTransformUtils.preCheckCast(r3.L$2, FileEntity.class, "com.obric.memorydata.plugin");
        j r11 = (j) ZeusTransformUtils.preCheckCast(r3.L$1, j.class, "com.obric.memorydata.plugin");
        ab r12 = (ab) ZeusTransformUtils.preCheckCast(r3.L$0, ab.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        int r13 = r8;
        r4 = r12;
        int r14 = r1;
        j r15 = r11;
        FileEntity r16 = r10;
        Iterator r17 = r9;
        Object r18 = r6;
    L28:
        if (r17.hasNext() == false) goto L37;
        Object r19 = r17.next();
        int r110 = r14 + 1;
        if (r14 >= 0) goto L32;
        CollectionsKt.throwIndexOverflow();
    L32:
        Pair r111 = (Pair) ZeusTransformUtils.preCheckCast(r19, Pair.class, "com.obric.memorydata.plugin");
        byte[] r112 = (byte[]) ZeusTransformUtils.preCheckCast(r111.component1(), byte[].class, "com.obric.memorydata.plugin");
        i r113 = new i((String) ZeusTransformUtils.preCheckCast(r111.component2(), String.class, "com.obric.memorydata.plugin"), null, r14, 2, null);
        r3.L$0 = r4;
        r3.L$1 = r15;
        r3.L$2 = r16;
        r3.L$3 = r17;
        r3.I$0 = r13;
        r3.I$1 = r110;
        r3.label = 1;
        if (r4.a(r112, r113, r15, r13, r16, true, r3) == r18) goto L34;
        r14 = r110;
        goto L28
    L34:
        return r18;
    L37:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        Workbook r20 = r0.getWorkbook();
        List r26 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<? extends PictureData> r27 = r20.getAllPictures();
        Intrinsics.checkNotNullExpressionValue(r27, "getAllPictures(...)");
        Iterator r28 = ((Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r29 = 0;
    L16:
        if (r28.hasNext() == false) goto L26;
        Object r30 = r28.next();
        int r114 = r29 + 1;
        if (r29 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        PictureData r31 = (PictureData) ZeusTransformUtils.preCheckCast(r30, PictureData.class, "com.obric.memorydata.plugin");
        r26.add(TuplesKt.to(r31.getData(), r31.suggestFileExtension()));     // Catch: Exception -> L23
    L25:
        r29 = r114;
    L23:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), a(), "Failed to extract image #" + r29 + ": " + e.getMessage(), null, 4, null);
        goto L25
    L26:
        Iterator r32 = ((Iterable) ZeusTransformUtils.preCheckCast(r26, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r13 = r23;
        r18 = r6;
        r14 = 0;
        r17 = r32;
        r15 = r22;
        r16 = r24;
    L7:
        r4 = this;
        r3 = new XlsFileProcessor$processSheetImages$1(r4, r2);
        goto L8
    }

    @Override // com.obric.memorydata.database.util.file_utils.c, com.obric.memorydata.database.util.file_utils.b
    public String a() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.util.file_utils.c
    public String a(Cell r3) {
        Cell r4 = (Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        CellType r0 = r4.getCellType();
    L7:
        if (r0 != CellType.NUMERIC) goto L12;
        if (DateUtil.isCellDateFormatted(r4) == false) goto L12;
        String r2 = r4.getDateCellValue().toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        return r2;
    L12:
        return super.a(r4);
    L5:
        r0 = null;
        goto L7
    }

    @Override // com.obric.memorydata.database.util.file_utils.c
    public /* synthetic */ Workbook a(FileInputStream r2) {
        return (Workbook) ZeusTransformUtils.preCheckCast(b(r2), Workbook.class, "com.obric.memorydata.plugin");
    }

    public HSSFWorkbook b(FileInputStream r3) {
        Intrinsics.checkNotNullParameter(r3, "fis");
        return new HSSFWorkbook((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.util.file_utils.o
    public FileExtension j() {
        return this.d;
    }
}
