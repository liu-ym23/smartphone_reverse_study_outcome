package com.obric.memorydata.database.util.file_utils;

import android.content.res.AssetFileDescriptor;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u0015J\u0018\u0010'\u001a\u0004\u0018\u00010\u000f2\u0006\u0010(\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001e\"\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/XlsxStreamingProcessor;", "Lcom/obric/memorydata/database/util/file_utils/BaseDocumentImageProcessor;", "<init>", "()V", "fileTypeTag", "", "getFileTypeTag", "()Ljava/lang/String;", "processImage", "", "imageBytes", "", "imageInfo", "Lcom/obric/memorydata/database/util/file_utils/DocumentImageInfo;", "tree", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "parentId", "", "docFileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "useAutoIncrement", "([BLcom/obric/memorydata/database/util/file_utils/DocumentImageInfo;Lcom/obric/memorydata/database/util/file_utils/DocumentTree;ILcom/obric/capabilitykit/entity/app/FileEntity;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processedRows", "getProcessedRows", "()I", "setProcessedRows", "(I)V", "startTime", "", "getStartTime", "()J", "lastLogTime", "getLastLogTime", "setLastLogTime", "(J)V", "supportedFileType", "Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "getSupportedFileType", "()Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "process", "fileEntity", "(Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseWithEasyExcel", "input", "Ljava/io/InputStream;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ae extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9634b;
    private int c;
    private final long d;
    private long e;
    private final FileExtension f;

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J%\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u0010\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"com/obric/memorydata/database/util/file_utils/XlsxStreamingProcessor$parseWithEasyExcel$1", "Lcom/alibaba/excel/event/AnalysisEventListener;", "", "", "", "currentSheetName", "", "currentRowIndex", "totalRows", "", "invoke", "", "dataMap", "context", "Lcom/alibaba/excel/context/AnalysisContext;", "doAfterAllAnalysed", "invokeHeadMap", "headMap", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends com.alibaba.excel.g.a<Map<Integer, ? extends Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ae f9635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f9636b;
        private String c;
        private int d;
        private long e;

        a(ae r1, j r2) {
            this.f9635a = r1;
            this.f9636b = r2;
            this.c = "";
        }

        @Override // com.alibaba.excel.h.b.c
        public void a(com.alibaba.excel.e.a r4) {
            Intrinsics.checkNotNullParameter((com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin"), "context");
            RunLog.INSTANCE.debug(this.f9635a.a(), "finish analyse sheet[" + this.c + ']');
        }

        @Override // com.alibaba.excel.h.b.c
        public /* synthetic */ void a(Object r3, com.alibaba.excel.e.a r4) {
            com.alibaba.excel.e.a r5 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
            c((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin"), r5);
        }

        @Override // com.alibaba.excel.g.a
        public void b(Map<Integer, String> r23, com.alibaba.excel.e.a r24) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin");
            com.alibaba.excel.e.a r3 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r24, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "headMap");
            Intrinsics.checkNotNullParameter(r3, "context");
            String r4 = r3.b().q();
            Intrinsics.checkNotNullExpressionValue(r4, "getSheetName(...)");
            this.c = r4;
            this.d = 0;
            j.a(this.f9636b, NodeType.TITLE, "Sheet: " + this.c, 2, null, 8, null);
            j.a(this.f9636b, NodeType.TABLE_HEADER, CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r1.values(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" | ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null), 0, null, 12, null);
        }

        public void c(Map<Integer, ? extends Object> r14, com.alibaba.excel.e.a r15) {
            Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
            com.alibaba.excel.e.a r17 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r15, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r16, "dataMap");
            Intrinsics.checkNotNullParameter(r17, "context");
            this.f9635a.b(this.f9635a.g() + 1);
            long r3 = System.currentTimeMillis();
            if ((this.f9635a.g() % 10000) != 0) goto L5;
        L6:
            double r5 = (((double) this.f9635a.g()) / ((r3 - this.f9635a.h()) / 1000.0d)) / ((double) 100);
            RunLog r18 = RunLog.INSTANCE;
            String r0 = this.f9635a.a();
            StringBuilder r7 = new StringBuilder().append("Processing: Sheet[").append(this.c).append("] Progress: ").append(this.f9635a.g()).append('/').append(this.e).append(" (");
            String r2 = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r5)}, 1));
            Intrinsics.checkNotNullExpressionValue(r2, "format(...)");
            r18.debug(r0, r7.append(r2).append(" rows/100sec)").toString());
            this.f9635a.a(r3);
        L7:
            Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r16.values(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r111 = r19.iterator();
        L9:
            if (r111.hasNext() == false) goto L21;
            Object r1 = r111.next();
            if (r1 != null) goto L14;
            String r4 = "";
        L20:
            r110.add(r4);
            goto L9
        L14:
            if (ZeusTransformUtils.instanceOf(r1, Number.class) == false) goto L17;
        L15:
            r4 = r1.toString();
            goto L20
        L17:
            if (ZeusTransformUtils.instanceOf(r1, Boolean.class) == false) goto L19;
            r4 = String.valueOf(((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
            goto L20
        L19:
            r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r1.toString(), CharSequence.class, "com.obric.memorydata.plugin"));
            goto L15
        L21:
            j.a(this.f9636b, NodeType.TABLE_ROW, CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" | ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null), 0, null, 12, null);
            return;
        L5:
            if ((r3 - this.f9635a.i()) <= 1000) goto L7;
            goto L6
        }
    }

    public ae() {
        this.f9634b = "XlsxStreamingProcessor";
        long r0 = System.currentTimeMillis();
        this.d = r0;
        this.e = r0;
        this.f = FileExtension.XLSX;
    }

    public static final /* synthetic */ j a(ae r0, InputStream r1) {
        return r0.a(r1);
    }

    private final j a(InputStream r5) {
        j r1 = new j();
        com.alibaba.excel.a.a(r5, (com.alibaba.excel.h.b.c) ZeusTransformUtils.preCheckCast(new a(this, r1), com.alibaba.excel.h.b.c.class, "com.obric.memorydata.plugin")).a(ExcelTypeEnum.XLSX).d();     // Catch: Error -> L5 Exception -> L7
    L10:
        return r1;
    L5:
        e = move-exception;
        RunLog r2 = RunLog.INSTANCE;
        String r4 = a();
        Throwable r6 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
        String r0 = "Excel processing error";
    L9:
        r2.error(r4, r0, r6);
    L7:
        e = move-exception;
        r2 = RunLog.INSTANCE;
        r4 = a();
        r6 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
        r0 = "Excel processing failed";
        goto L9
    }

    @Override // com.obric.memorydata.database.util.file_utils.b, com.obric.memorydata.database.util.file_utils.o
    public Object a(FileEntity r14, Continuation<? super j> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, XlsxStreamingProcessor$process$1.class) == false) goto L7;
        XlsxStreamingProcessor$process$1 r0 = (XlsxStreamingProcessor$process$1) ZeusTransformUtils.preCheckCast(r16, XlsxStreamingProcessor$process$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r0.L$1, String.class, "com.obric.memorydata.plugin");
        ae r18 = (ae) ZeusTransformUtils.preCheckCast(r0.L$0, ae.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L14
        String r19 = r13;
        ae this = r18;
        Object r110 = r17;
    L22:
        UriFileAccessSession r111 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r110, UriFileAccessSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (r111 == null) goto L35;
        AssetFileDescriptor r112 = r111.getFd();     // Catch: Throwable -> L38
        if (r112 == null) goto L35;
        Closeable r113 = (Closeable) ZeusTransformUtils.preCheckCast(r112, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        FileInputStream r1 = ((AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r113, AssetFileDescriptor.class, "com.obric.memorydata.plugin")).createInputStream();     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r1, "createInputStream(...)");     // Catch: Throwable -> L30
        j r114 = a(this, (InputStream) ZeusTransformUtils.preCheckCast(r1, InputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r113, null);     // Catch: Throwable -> L38
    L36:
        Object r115 = Result.m1421constructorimpl(r114);     // Catch: Throwable -> L38
        String r7 = r19;
    L41:
        Throwable r116 = Result.m1424exceptionOrNullimpl(r115);
        if (r116 == null) goto L65;
        if (ZeusTransformUtils.instanceOf(r116, NotOfficeXmlFileException.class) == false) goto L48;
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r117 = new StringBuilder();
        String r4 = "File is not a valid Office XML file: ";
    L46:
        IRunLog.a.a(r6, r7, r117.append(r4).append(r116.getMessage()).toString(), null, 4, null);
    L61:
        if (AppContext.INSTANCE.isDebug() == false) goto L65;
        throw r116;
    L48:
        if (ZeusTransformUtils.instanceOf(r116, IllegalArgumentException.class) == false) goto L51;
        r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r117 = new StringBuilder();
        r4 = "Doubao Assistant is not started, unable to obtain permission: ";
        goto L46
    L51:
        if (ZeusTransformUtils.instanceOf(r116, RecordFormatException.class) == false) goto L54;
        RunLog.INSTANCE.warn(r7, "POI memory limit exceeded : " + r116.getMessage() + " (" + ExceptionsKt.stackTraceToString(r116) + ')', r116);
        goto L61
    L54:
        if (ZeusTransformUtils.instanceOf(r116, POIXMLException.class) == false) goto L57;
        r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r117 = new StringBuilder();
        r4 = "POI ZIP stream error (possibly closed): ";
        goto L46
    L57:
        if (ZeusTransformUtils.instanceOf(r116, OutOfMemoryError.class) == false) goto L59;
        RunLog.INSTANCE.error(r7, "OOM while use " + r7 + " parser. The file may be too large or corrupt.", r116);
        System.gc();
        return null;
    L59:
        RunLog.INSTANCE.error(r7, "File access failed", r116);
    L65:
        if (Result.m1427isFailureimpl(r115) == false) goto L68;
        return null;
    L68:
        return r115;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r113, th);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L38:
        Throwable th = th;
        r13 = r19;
    L40:
        Result.Companion r118 = Result.Companion;
        r7 = r13;
        r115 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L35:
        r114 = null;
    L14:
        th = th;
        goto L40
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r17);
        r19 = a();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L38
        Continuation r8 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        m r9 = m.f9660a;     // Catch: Throwable -> L38
        r0.L$0 = this;     // Catch: Throwable -> L38
        r0.L$1 = r19;     // Catch: Throwable -> L38
        r0.label = 1;     // Catch: Throwable -> L38
        r110 = r9.a(r14, r0);     // Catch: Throwable -> L38
        if (r110 != r2) goto L22;
        return r2;
    L7:
        r0 = new XlsxStreamingProcessor$process$1(this, r16);
        goto L8
    }

    @Override // com.obric.memorydata.database.util.file_utils.b, com.obric.memorydata.database.util.file_utils.n
    public Object a(byte[] r1, i r2, j r3, int r4, FileEntity r5, boolean r6, Continuation<? super Boolean> r7) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return Boxing.boxBoolean(false);
    }

    @Override // com.obric.memorydata.database.util.file_utils.b
    public String a() {
        return this.f9634b;
    }

    public final void a(long r1) {
        this.e = r1;
    }

    public final void b(int r1) {
        this.c = r1;
    }

    public final int g() {
        return this.c;
    }

    public final long h() {
        return this.d;
    }

    public final long i() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.util.file_utils.o
    public FileExtension j() {
        return this.f;
    }
}
