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
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/CsvStreamingProcessor;", "Lcom/obric/memorydata/database/util/file_utils/BaseDocumentImageProcessor;", "<init>", "()V", "fileTypeTag", "", "getFileTypeTag", "()Ljava/lang/String;", "processedRows", "", "getProcessedRows", "()I", "setProcessedRows", "(I)V", "startTime", "", "getStartTime", "()J", "lastLogTime", "getLastLogTime", "setLastLogTime", "(J)V", "supportedFileType", "Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "getSupportedFileType", "()Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "process", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "(Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseWithEasyExcel", "input", "Ljava/io/InputStream;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9645b;
    private int c;
    private final long d;
    private long e;
    private final FileExtension f;

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J%\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\f\u001a\u00020\rH\u0096\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J$\u0010\u000f\u001a\u00020\n2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"com/obric/memorydata/database/util/file_utils/CsvStreamingProcessor$parseWithEasyExcel$1", "Lcom/alibaba/excel/event/AnalysisEventListener;", "", "", "", "currentSheetName", "", "hasHeader", "", "invoke", "", "dataMap", "context", "Lcom/alibaba/excel/context/AnalysisContext;", "doAfterAllAnalysed", "invokeHeadMap", "headMap", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends com.alibaba.excel.g.a<Map<Integer, ? extends Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f9646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f9647b;
        private String c;
        private boolean d;

        a(f r1, j r2) {
            this.f9646a = r1;
            this.f9647b = r2;
            this.c = "CSV Data";
        }

        @Override // com.alibaba.excel.h.b.c
        public void a(com.alibaba.excel.e.a r3) {
            Intrinsics.checkNotNullParameter((com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin"), "context");
            RunLog.INSTANCE.debug(this.f9646a.a(), "Finish analysing CSV file");
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
            if (this.d == true) goto L6;
            this.c = "CSV Data";
            j.a(this.f9647b, NodeType.TITLE, "CSV Data", 2, null, 8, null);
            j.a(this.f9647b, NodeType.TABLE_HEADER, CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r1.values(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" | ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null), 0, null, 12, null);
            this.d = true;
            return;
        }

        public void c(Map<Integer, ? extends Object> r14, com.alibaba.excel.e.a r15) {
            Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
            com.alibaba.excel.e.a r17 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r15, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r16, "dataMap");
            Intrinsics.checkNotNullParameter(r17, "context");
            this.f9646a.b(this.f9646a.g() + 1);
            long r3 = System.currentTimeMillis();
            if ((this.f9646a.g() % 10000) != 0) goto L5;
        L6:
            double r5 = ((double) this.f9646a.g()) / ((r3 - this.f9646a.h()) / 1000.0d);
            RunLog r18 = RunLog.INSTANCE;
            String r0 = this.f9646a.a();
            StringBuilder r7 = new StringBuilder().append("Processing CSV: Progress: ").append(this.f9646a.g()).append(" (");
            String r2 = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r5)}, 1));
            Intrinsics.checkNotNullExpressionValue(r2, "format(...)");
            r18.debug(r0, r7.append(r2).append(" rows/sec)").toString());
            this.f9646a.a(r3);
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
            j.a(this.f9647b, NodeType.TABLE_ROW, CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" | ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null), 0, null, 12, null);
            return;
        L5:
            if ((r3 - this.f9646a.i()) <= 1000) goto L7;
            goto L6
        }
    }

    public f() {
        this.f9645b = "CsvStreamingProcessor";
        long r0 = System.currentTimeMillis();
        this.d = r0;
        this.e = r0;
        this.f = FileExtension.CSV;
    }

    public static final /* synthetic */ j a(f r0, InputStream r1) {
        return r0.a(r1);
    }

    private final j a(InputStream r5) {
        j r1 = new j();
        ((com.alibaba.excel.h.a.b) ZeusTransformUtils.preCheckCast(com.alibaba.excel.a.a(r5).a(ExcelTypeEnum.CSV).a((com.alibaba.excel.h.b.c) ZeusTransformUtils.preCheckCast(new a(this, r1), com.alibaba.excel.h.b.c.class, "com.obric.memorydata.plugin")), com.alibaba.excel.h.a.b.class, "com.obric.memorydata.plugin")).e().d();     // Catch: Error -> L5 Exception -> L7
    L10:
        return r1;
    L5:
        e = move-exception;
        RunLog r2 = RunLog.INSTANCE;
        String r4 = a();
        Throwable r6 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
        String r0 = "CSV processing error";
    L9:
        r2.error(r4, r0, r6);
    L7:
        e = move-exception;
        r2 = RunLog.INSTANCE;
        r4 = a();
        r6 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
        r0 = "CSV processing failed";
        goto L9
    }

    @Override // com.obric.memorydata.database.util.file_utils.b, com.obric.memorydata.database.util.file_utils.o
    public Object a(FileEntity r19, Continuation<? super j> r20) {
        f r0 = this;
        FileEntity r1 = r19;
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, CsvStreamingProcessor$process$1.class) == false) goto L7;
        CsvStreamingProcessor$process$1 r5 = (CsvStreamingProcessor$process$1) ZeusTransformUtils.preCheckCast(r3, CsvStreamingProcessor$process$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        if (r7 == 0) goto L20;
        if (r7 == 1) goto L19;
        if (r7 != 2) goto L18;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r5.L$1, String.class, "com.obric.memorydata.plugin");
        r0 = (f) ZeusTransformUtils.preCheckCast(r5.L$0, f.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L15
    L28:
        UriFileAccessSession r8 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r4, UriFileAccessSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r8 == null) goto L43;
        AssetFileDescriptor r9 = r8.getFd();     // Catch: Throwable -> L15
        if (r9 == null) goto L43;
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r9, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        FileInputStream r11 = ((AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r10, AssetFileDescriptor.class, "com.obric.memorydata.plugin")).createInputStream();     // Catch: Throwable -> L36
        Intrinsics.checkNotNullExpressionValue(r11, "createInputStream(...)");     // Catch: Throwable -> L36
        j r12 = a(r0, (InputStream) ZeusTransformUtils.preCheckCast(r11, InputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L15
    L44:
        Object r13 = Result.m1421constructorimpl(r12);     // Catch: Throwable -> L15
    L49:
        String r14 = r2;
        Throwable r15 = Result.m1424exceptionOrNullimpl(r13);
        if (r15 == null) goto L73;
        if (ZeusTransformUtils.instanceOf(r15, NotOfficeXmlFileException.class) == false) goto L56;
        IRunLog r16 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r17 = new StringBuilder();
        String r18 = "File is not a valid Office XML file: ";
    L54:
        IRunLog.a.a(r16, r14, r17.append(r18).append(r15.getMessage()).toString(), null, 4, null);
    L69:
        if (AppContext.INSTANCE.isDebug() == false) goto L73;
        throw r15;
    L56:
        if (ZeusTransformUtils.instanceOf(r15, IllegalArgumentException.class) == false) goto L59;
        r16 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r17 = new StringBuilder();
        r18 = "Doubao Assistant is not started, unable to obtain permission: ";
        goto L54
    L59:
        if (ZeusTransformUtils.instanceOf(r15, RecordFormatException.class) == false) goto L62;
        RunLog.INSTANCE.warn(r14, "POI memory limit exceeded : " + r15.getMessage() + " (" + ExceptionsKt.stackTraceToString(r15) + ')', r15);
        goto L69
    L62:
        if (ZeusTransformUtils.instanceOf(r15, POIXMLException.class) == false) goto L65;
        r16 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r17 = new StringBuilder();
        r18 = "POI ZIP stream error (possibly closed): ";
        goto L54
    L65:
        if (ZeusTransformUtils.instanceOf(r15, OutOfMemoryError.class) == false) goto L67;
        RunLog.INSTANCE.error(r14, "OOM while use " + r14 + " parser. The file may be too large or corrupt.", r15);
        System.gc();
        return null;
    L67:
        RunLog.INSTANCE.error(r14, "File access failed", r15);
    L73:
        if (Result.m1427isFailureimpl(r13) == false) goto L76;
        return null;
    L76:
        return r13;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L43:
        r12 = null;
    L15:
        th = th;
    L48:
        Result.Companion r21 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L49
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        FileEntity r22 = (FileEntity) ZeusTransformUtils.preCheckCast(r5.L$1, FileEntity.class, "com.obric.memorydata.plugin");
        f r23 = (f) ZeusTransformUtils.preCheckCast(r5.L$0, f.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r1 = r22;
        r0 = r23;
    L23:
        String r24 = r0.a();
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L46
        Continuation r26 = (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        m r27 = m.f9660a;     // Catch: Throwable -> L46
        r5.L$0 = r0;     // Catch: Throwable -> L46
        r5.L$1 = r24;     // Catch: Throwable -> L46
        r5.label = 2;     // Catch: Throwable -> L46
        r4 = r27.a(r1, r5);     // Catch: Throwable -> L46
        if (r4 != r6) goto L27;
        return r6;
    L27:
        r2 = r24;
    L46:
        th = th;
        r2 = r24;
        goto L48
    L20:
        ResultKt.throwOnFailure(r4);
        r5.L$0 = r0;
        r5.L$1 = r1;
        r5.label = 1;
        if (super.a(r1, r5) != r6) goto L23;
        return r6;
    L7:
        r5 = new CsvStreamingProcessor$process$1(r0, r3);
        goto L8
    }

    @Override // com.obric.memorydata.database.util.file_utils.b
    public String a() {
        return this.f9645b;
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
