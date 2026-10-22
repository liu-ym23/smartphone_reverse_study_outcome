package com.obric.memorydata.database.util.file_utils;

import android.content.res.AssetFileDescriptor;
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
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J.\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0 2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/DocFileProcessor;", "Lcom/obric/memorydata/database/util/file_utils/AbstractWordFileProcessor;", "<init>", "()V", "supportedFileType", "Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "getSupportedFileType", "()Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "fileTypeTag", "", "getFileTypeTag", "()Ljava/lang/String;", "imageIndexCounter", "", "process", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "(Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readDocFileByAfd", "afd", "Landroid/content/res/AssetFileDescriptor;", "parseDocFile", "inputStream", "Ljava/io/InputStream;", "docFileEntity", "handleImage", "Lcom/obric/memorydata/database/util/file_utils/DocNode;", "picture", "Lorg/apache/poi/hwpf/usermodel/Picture;", "tree", "stack", "", "detectDocHeadingLevel", "paragraph", "Lorg/apache/poi/hwpf/usermodel/Paragraph;", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g extends com.obric.memorydata.database.util.file_utils.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9648b = null;
    private final FileExtension c;
    private final String d;
    private int e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/DocFileProcessor$Companion;", "", "<init>", "()V", "TAG", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9648b = new a(null);
    }

    public g() {
        this.c = FileExtension.DOC;
        this.d = "DocFileProcessor";
    }

    private final int a(Paragraph r4) {
        int r3 = r4.getLvl();
        if (r3 < 0) goto L6;
        if (r3 >= 9) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L13;
        if (r3 == 9) goto L14;
        return -1;
    L14:
        return 0;
    L13:
        return r3 + 1;
    L6:
        r2 = false;
        goto L7
    }

    private final h a(Picture r15, j r16, List<h> r17, FileEntity r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        int r10 = this.e + 1;
        this.e = r10;
        int r11 = ((h) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r0), h.class, "com.obric.memorydata.plugin")).a();
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new DocFileProcessor$handleImage$1(this, r15, r10, r16, r11, r18, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return r16.a(NodeType.IMAGE, q.f9661a.a(new q(String.valueOf(r10), null, 2, null)), 1, Integer.valueOf(r11));
    }

    private final j a(final AssetFileDescriptor r3, final FileEntity r4) {
        return (j) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.y.a($$Lambda$g$KqXOPgJh4RlpiESm4pMoVaSD_zM.INSTANCE, new $$Lambda$g$PhM1y_lAHfgsEIm9zRgO8KdULU(r3, this, r4)), j.class, "com.obric.memorydata.plugin");
    }

    private static final j a(AssetFileDescriptor r3, g r4, FileEntity r5) {
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(r3.createInputStream(), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r0 = (FileInputStream) ZeusTransformUtils.preCheckCast(r6, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L6
        j r7 = r4.a((InputStream) ZeusTransformUtils.preCheckCast(r0, InputStream.class, "com.obric.memorydata.plugin"), r5);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r6, null);
        return r7;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);
        throw th;
    }

    public static final /* synthetic */ j a(g r0, AssetFileDescriptor r1, FileEntity r2) {
        return r0.a(r1, r2);
    }

    private final j a(InputStream r10, FileEntity r11) {
        HWPFDocument r0 = new HWPFDocument(r10);
        j r12 = new j();
        List<h> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        h r2 = r12.a();
        if (r2 == null) goto L5;
        r1.add(r2);
    L5:
        List<Picture> r3 = r0.getPicturesTable().getAllPictures();
        Intrinsics.checkNotNullExpressionValue(r3, "getAllPictures(...)");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        Picture r5 = (Picture) ZeusTransformUtils.preCheckCast(r4.next(), Picture.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r5);
        a(r5, r12, r1, r11);
        goto L7
    L9:
        Range r13 = r0.getRange();
        int r6 = r13.numParagraphs();
        int r7 = 0;
    L10:
        if (r7 >= r6) goto L21;
        Paragraph r8 = r13.getParagraph(r7);
        String r9 = r8.text();
        Intrinsics.checkNotNullExpressionValue(r9, "text(...)");
        String r14 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L14;
        boolean r15 = true;
    L15:
        if (r15 == true) goto L20;
        Intrinsics.checkNotNull(r8);
        int r16 = a(r8);
        if (r16 <= 0) goto L19;
        a(r14, r16, r12, r1);
        goto L20
    L19:
        a(r14, r12, r1);
    L20:
        r7 = r7 + 1;
        goto L10
    L14:
        r15 = false;
        goto L15
    L21:
        r0.close();
        return r12;
    }

    private static final j a(Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("读取DOC文件失败：");
        r4.printStackTrace();
        r0.error("DocFileProcessor", r1.append(Unit.INSTANCE).toString(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    public static /* synthetic */ j lambda$KqXOPgJh4RlpiESm4pMoVaSD_zM(Exception r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$PhM1y_lAHfgsEIm9zRgO8-KdULU, reason: not valid java name */
    public static /* synthetic */ j m579lambda$PhM1y_lAHfgsEIm9zRgO8KdULU(AssetFileDescriptor r0, g r1, FileEntity r2) {
        return a(r0, r1, r2);
    }

    @Override // com.obric.memorydata.database.util.file_utils.b, com.obric.memorydata.database.util.file_utils.o
    public Object a(FileEntity r19, Continuation<? super j> r20) {
        g r0 = this;
        FileEntity r1 = r19;
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, DocFileProcessor$process$1.class) == false) goto L7;
        DocFileProcessor$process$1 r5 = (DocFileProcessor$process$1) ZeusTransformUtils.preCheckCast(r3, DocFileProcessor$process$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        if (r7 == 0) goto L20;
        if (r7 == 1) goto L19;
        if (r7 != 2) goto L18;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r5.L$2, String.class, "com.obric.memorydata.plugin");
        FileEntity r8 = (FileEntity) ZeusTransformUtils.preCheckCast(r5.L$1, FileEntity.class, "com.obric.memorydata.plugin");
        g r9 = (g) ZeusTransformUtils.preCheckCast(r5.L$0, g.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L15
    L28:
        UriFileAccessSession r10 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r4, UriFileAccessSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r10 == null) goto L43;
        AssetFileDescriptor r11 = r10.getFd();     // Catch: Throwable -> L15
        if (r11 == null) goto L43;
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(r11, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        j r13 = a(r9, (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r12, AssetFileDescriptor.class, "com.obric.memorydata.plugin"), r8);     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L15
    L44:
        Object r14 = Result.m1421constructorimpl(r13);     // Catch: Throwable -> L15
    L49:
        String r15 = r2;
        Throwable r16 = Result.m1424exceptionOrNullimpl(r14);
        if (r16 == null) goto L73;
        if (ZeusTransformUtils.instanceOf(r16, NotOfficeXmlFileException.class) == false) goto L56;
        IRunLog r17 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r18 = new StringBuilder();
        String r21 = "File is not a valid Office XML file: ";
    L54:
        IRunLog.a.a(r17, r15, r18.append(r21).append(r16.getMessage()).toString(), null, 4, null);
    L69:
        if (AppContext.INSTANCE.isDebug() == false) goto L73;
        throw r16;
    L56:
        if (ZeusTransformUtils.instanceOf(r16, IllegalArgumentException.class) == false) goto L59;
        r17 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r18 = new StringBuilder();
        r21 = "Doubao Assistant is not started, unable to obtain permission: ";
        goto L54
    L59:
        if (ZeusTransformUtils.instanceOf(r16, RecordFormatException.class) == false) goto L62;
        RunLog.INSTANCE.warn(r15, "POI memory limit exceeded : " + r16.getMessage() + " (" + ExceptionsKt.stackTraceToString(r16) + ')', r16);
        goto L69
    L62:
        if (ZeusTransformUtils.instanceOf(r16, POIXMLException.class) == false) goto L65;
        r17 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r18 = new StringBuilder();
        r21 = "POI ZIP stream error (possibly closed): ";
        goto L54
    L65:
        if (ZeusTransformUtils.instanceOf(r16, OutOfMemoryError.class) == false) goto L67;
        RunLog.INSTANCE.error(r15, "OOM while use " + r15 + " parser. The file may be too large or corrupt.", r16);
        System.gc();
        return null;
    L67:
        RunLog.INSTANCE.error(r15, "File access failed", r16);
    L73:
        if (Result.m1427isFailureimpl(r14) == false) goto L76;
        return null;
    L76:
        return r14;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L43:
        r13 = null;
    L15:
        th = th;
    L48:
        Result.Companion r22 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L49
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        FileEntity r23 = (FileEntity) ZeusTransformUtils.preCheckCast(r5.L$1, FileEntity.class, "com.obric.memorydata.plugin");
        g r24 = (g) ZeusTransformUtils.preCheckCast(r5.L$0, g.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r1 = r23;
        r0 = r24;
    L23:
        String r25 = r0.a();
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L46
        Continuation r27 = (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        m r28 = m.f9660a;     // Catch: Throwable -> L46
        r5.L$0 = r0;     // Catch: Throwable -> L46
        r5.L$1 = r1;     // Catch: Throwable -> L46
        r5.L$2 = r25;     // Catch: Throwable -> L46
        r5.label = 2;     // Catch: Throwable -> L46
        r4 = r28.a(r1, r5);     // Catch: Throwable -> L46
        if (r4 != r6) goto L27;
        return r6;
    L27:
        r9 = r0;
        r8 = r1;
        r2 = r25;
    L46:
        th = th;
        r2 = r25;
        goto L48
    L20:
        ResultKt.throwOnFailure(r4);
        r5.L$0 = r0;
        r5.L$1 = r1;
        r5.label = 1;
        if (super.a(r1, r5) != r6) goto L23;
        return r6;
    L7:
        r5 = new DocFileProcessor$process$1(r0, r3);
        goto L8
    }

    @Override // com.obric.memorydata.database.util.file_utils.b
    public String a() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.util.file_utils.o
    public FileExtension j() {
        return this.c;
    }
}
