package com.obric.memorydata.database.util.file_utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J6\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0011H\u0094@¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PptxFileProcessor;", "Lcom/obric/memorydata/database/util/file_utils/BasePptProcessor;", "<init>", "()V", "imageIndexCounter", "", "fileTypeTag", "", "getFileTypeTag", "()Ljava/lang/String;", "supportedFileType", "Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "getSupportedFileType", "()Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "process", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "(Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPresentation", "Lorg/apache/poi/sl/usermodel/SlideShow;", "fis", "Ljava/io/FileInputStream;", "processPictureShape", "", "shape", "Lorg/apache/poi/sl/usermodel/Shape;", "tree", "parentId", "docFileEntity", "(Lorg/apache/poi/sl/usermodel/Shape;Lcom/obric/memorydata/database/util/file_utils/DocumentTree;ILcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u extends d {
    private int c;
    private final String d;
    private final FileExtension e;

    public u() {
        this.c = 1;
        this.d = "PptxFileProcessor";
        this.e = FileExtension.PPTX;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.obric.memorydata.database.util.file_utils.u] */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.obric.memorydata.middleware.api.log.RunLog] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v46, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.obric.memorydata.middleware.api.log.RunLog] */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v26, types: [com.obric.memorydata.middleware.api.log.RunLog] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v59, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v33, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.obric.memorydata.database.util.file_utils.PptxFileProcessor$process$1, java.lang.Object, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.obric.memorydata.database.util.file_utils.m] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.memorydata.database.util.file_utils.d, com.obric.memorydata.database.util.file_utils.b, com.obric.memorydata.database.util.file_utils.o
    public Object a(FileEntity r20, Continuation<? super j> r21) {
        u r0 = this;
        FileEntity r1 = r20;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, PptxFileProcessor$process$1.class) == false) goto L7;
        PptxFileProcessor$process$1 r4 = (PptxFileProcessor$process$1) ZeusTransformUtils.preCheckCast(r2, PptxFileProcessor$process$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
        ?? r5 = r4;
    L8:
        Object r3 = r5.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        if (r7 == 0) goto L24;
        if (r7 == 1) goto L19;
        if (r7 != 2) goto L18;
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r5.L$2, Closeable.class, "com.obric.memorydata.plugin");
        r6 = (Closeable) ZeusTransformUtils.preCheckCast(r5.L$1, Closeable.class, "com.obric.memorydata.plugin");
        r5 = (String) ZeusTransformUtils.preCheckCast(r5.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L15
        r5 = r5;
        r6 = r6;
    L52:
        j r9 = (j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L62
        ?? r10 = r5;
        ?? r11 = r6;
    L68:
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L22
        ?? r12 = r10;
    L70:
        ?? r13 = r12;
    L97:
        Object r14 = Result.m1421constructorimpl(r9);     // Catch: Throwable -> L22
        ?? r15 = r13;
    L104:
        ?? r16 = r15;
        Throwable r17 = Result.m1424exceptionOrNullimpl(r14);
        if (r17 == null) goto L128;
        if (ZeusTransformUtils.instanceOf(r17, NotOfficeXmlFileException.class) == false) goto L111;
        IRunLog r18 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r19 = new StringBuilder();
        String r22 = "File is not a valid Office XML file: ";
    L109:
        IRunLog.a.a(r18, r16, r19.append(r22).append(r17.getMessage()).toString(), null, 4, null);
    L124:
        if (AppContext.INSTANCE.isDebug() == false) goto L128;
        throw r17;
    L111:
        if (ZeusTransformUtils.instanceOf(r17, IllegalArgumentException.class) == false) goto L114;
        r18 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r19 = new StringBuilder();
        r22 = "Doubao Assistant is not started, unable to obtain permission: ";
        goto L109
    L114:
        if (ZeusTransformUtils.instanceOf(r17, RecordFormatException.class) == false) goto L117;
        RunLog.INSTANCE.warn(r16, "POI memory limit exceeded : " + r17.getMessage() + " (" + ExceptionsKt.stackTraceToString(r17) + ')', r17);
        goto L124
    L117:
        if (ZeusTransformUtils.instanceOf(r17, POIXMLException.class) == false) goto L120;
        r18 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r19 = new StringBuilder();
        r22 = "POI ZIP stream error (possibly closed): ";
        goto L109
    L120:
        if (ZeusTransformUtils.instanceOf(r17, OutOfMemoryError.class) == false) goto L122;
        RunLog.INSTANCE.error(r16, "OOM while use " + r16 + " parser. The file may be too large or corrupt.", r17);
        System.gc();
        return null;
    L122:
        RunLog.INSTANCE.error(r16, "File access failed", r17);
    L128:
        if (Result.m1427isFailureimpl(r14) == false) goto L131;
        return null;
    L131:
        return r14;
    L15:
        th = th;
    L16:
        Throwable r23 = th;
        throw r23;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        CloseableKt.closeFinally(r8, r23);     // Catch: Throwable -> L62
        throw th;     // Catch: Throwable -> L62
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ?? r24 = (String) ZeusTransformUtils.preCheckCast(r5.L$2, String.class, "com.obric.memorydata.plugin");
        FileEntity r25 = (FileEntity) ZeusTransformUtils.preCheckCast(r5.L$1, FileEntity.class, "com.obric.memorydata.plugin");
        u r26 = (u) ZeusTransformUtils.preCheckCast(r5.L$0, u.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L22
        r1 = r25;
        ?? r27 = r26;
        ?? r28 = r24;
    L151:
        UriFileAccessSession r29 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r3, UriFileAccessSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L99
        if (r29 == null) goto L96;
        AssetFileDescriptor r30 = r29.getFd();     // Catch: Throwable -> L99
        if (r30 == null) goto L96;
        Closeable r31 = (Closeable) ZeusTransformUtils.preCheckCast(r30, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L99
        Closeable r32 = (Closeable) ZeusTransformUtils.preCheckCast(((AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r31, AssetFileDescriptor.class, "com.obric.memorydata.plugin")).createInputStream(), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L89
        FileInputStream r110 = (FileInputStream) ZeusTransformUtils.preCheckCast(r32, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L82
        z r111 = z.f9676a;     // Catch: Throwable -> L82
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L82
        InputStream r112 = (InputStream) ZeusTransformUtils.preCheckCast(r110, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L82
        File r113 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir();     // Catch: Throwable -> L82
        Intrinsics.checkNotNullExpressionValue(r113, "getCacheDir(...)");     // Catch: Throwable -> L82
        y r114 = z.a(r111, r112, r113, 0, 4, null);     // Catch: Throwable -> L82
        CloseableKt.closeFinally(r32, null);     // Catch: Throwable -> L89
        CloseableKt.closeFinally(r31, null);     // Catch: Throwable -> L99
        if (r114 == null) goto L96;
        if (ZeusTransformUtils.instanceOf(r114, y.b.class) == false) goto L43;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r27.a(), "Skip PPTX indexing because the actual content exceeds the snapshot limit. filename=" + com.obric.memorydata.utils.q.f13259a.b(r1.getFileName()) + ", observedBytesAtLeast=" + ((y.b) ZeusTransformUtils.preCheckCast(r114, y.b.class, "com.obric.memorydata.plugin")).a(), null, 4, null);     // Catch: Throwable -> L99
        r9 = null;
        r12 = r28;
        goto L70
    L43:
        if (ZeusTransformUtils.instanceOf(r114, y.a.class) == false) goto L81;
        Closeable r33 = (Closeable) ZeusTransformUtils.preCheckCast(r114, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L99
        y.a r34 = (y.a) ZeusTransformUtils.preCheckCast(r33, y.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L73
        v r115 = x.f9673a.a(r34.a());     // Catch: Throwable -> L73
        if (ZeusTransformUtils.instanceOf(r115, v.a.class) == false) goto L65;
        RunLog.INSTANCE.debug(r27.a(), "PPTX preflight accepted: " + ((v.a) ZeusTransformUtils.preCheckCast(r115, v.a.class, "com.obric.memorydata.plugin")).a());     // Catch: Throwable -> L73
        Closeable r35 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r34.a()), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L73
        FileInputStream r116 = (FileInputStream) ZeusTransformUtils.preCheckCast(r35, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        r5.L$0 = r28;     // Catch: Throwable -> L55
        r5.L$1 = r33;     // Catch: Throwable -> L55
        r5.L$2 = r35;     // Catch: Throwable -> L55
        r5.label = 2;     // Catch: Throwable -> L55
        Object r36 = r27.a(r116, r1, r5);     // Catch: Throwable -> L55
        if (r36 != r6) goto L51;
        return r6;
    L51:
        r6 = r33;
        r5 = r28;
        r8 = r35;
        r3 = r36;
    L55:
        th = th;
        r6 = r33;
        r5 = r28;
        r8 = r35;
        goto L16
    L65:
        if (ZeusTransformUtils.instanceOf(r115, v.b.class) == false) goto L72;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r27.a(), "Skip PPTX indexing after preflight. filename=" + com.obric.memorydata.utils.q.f13259a.b(r1.getFileName()) + ", reason=" + ((v.b) ZeusTransformUtils.preCheckCast(r115, v.b.class, "com.obric.memorydata.plugin")).a() + ", stats=" + ((v.b) ZeusTransformUtils.preCheckCast(r115, v.b.class, "com.obric.memorydata.plugin")).b(), null, 4, null);     // Catch: Throwable -> L73
        r10 = r28;
        r9 = null;
        r11 = r33;
        goto L68
    L72:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        Throwable r37 = th;
        r24 = r28;
        ?? r38 = r33;
    L143:
        throw r37;     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        CloseableKt.closeFinally(r38, r37);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L81:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L99
    L82:
        th = move-exception;
        throw th;     // Catch: Throwable -> L85
    L85:
        th = move-exception;
        CloseableKt.closeFinally(r32, th);     // Catch: Throwable -> L89
        throw th;     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        throw th;     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        CloseableKt.closeFinally(r31, th);     // Catch: Throwable -> L99
        throw th;     // Catch: Throwable -> L99
    L96:
        r13 = r28;
        r9 = null;
    L99:
        th = th;
        r24 = r28;
    L103:
        Result.Companion r39 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        r15 = r24;
    L22:
        th = th;
        goto L103
    L24:
        ResultKt.throwOnFailure(r3);
        d();
        r0.c = 1;
        String r40 = a();
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L101
        Continuation r42 = (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L101
        ?? r43 = m.f9660a;     // Catch: Throwable -> L101
        r5.L$0 = r0;     // Catch: Throwable -> L101
        r5.L$1 = r1;     // Catch: Throwable -> L101
        r5.L$2 = r40;     // Catch: Throwable -> L101
        r5.label = 1;     // Catch: Throwable -> L101
        Object r44 = r43.a(r1, r5);     // Catch: Throwable -> L101
        if (r44 != r6) goto L28;
        return r6;
    L28:
        r28 = r40;
        r3 = r44;
        r27 = r0;
    L101:
        th = th;
        r24 = r40;
    L62:
        th = move-exception;
        r24 = r5;
        r38 = r6;
        r37 = th;
    L7:
        r5 = new PptxFileProcessor$process$1(r0, r2);
        goto L8
    }

    @Override // com.obric.memorydata.database.util.file_utils.d
    public Object a(Shape<?, ?> r16, j r17, int r18, FileEntity r19, Continuation<? super Unit> r20) {
        Shape r3 = (Shape) ZeusTransformUtils.wrapperContextForParams(r16, Shape.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, PptxFileProcessor$processPictureShape$1.class) == false) goto L7;
        PptxFileProcessor$processPictureShape$1 r4 = (PptxFileProcessor$processPictureShape$1) ZeusTransformUtils.preCheckCast(r0, PptxFileProcessor$processPictureShape$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        PptxFileProcessor$processPictureShape$1 r12 = r4;
        Object r1 = r12.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r12.label;
        if (r6 == 0) goto L16;
        if (r6 != 1) goto L15;
        Shape r7 = (Shape) ZeusTransformUtils.preCheckCast(r12.L$1, Shape.class, "com.obric.memorydata.plugin");
        u r2 = (u) ZeusTransformUtils.preCheckCast(r12.L$0, u.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r1);     // Catch: Exception -> L27 ClassCastException -> L29
    L32:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r1);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type org.apache.poi.xslf.usermodel.XSLFPictureShape");     // Catch: Exception -> L27 ClassCastException -> L29
        XSLFPictureData r8 = ((XSLFPictureShape) ZeusTransformUtils.preCheckCast(r3, XSLFPictureShape.class, "com.obric.memorydata.plugin")).getPictureData();     // Catch: Exception -> L27 ClassCastException -> L29
        if (r8.getType() != PictureData.PictureType.WMF) goto L20;
    L25:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), a(), "Unsupported image type: " + r8.getType() + ", skipping", null, 4, null);     // Catch: Exception -> L27 ClassCastException -> L29
        return Unit.INSTANCE;
    L20:
        if (r8.getType() == PictureData.PictureType.EMF) goto L25;
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L27 ClassCastException -> L29
        String r9 = a((PictureData) ZeusTransformUtils.preCheckCast(r8, PictureData.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L27 ClassCastException -> L29
        int r10 = this.c;     // Catch: Exception -> L27 ClassCastException -> L29
        this.c = r10 + 1;     // Catch: Exception -> L27 ClassCastException -> L29
        i r11 = new i(r9, "", r10);     // Catch: Exception -> L27 ClassCastException -> L29
        n r13 = (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27 ClassCastException -> L29
        byte[] r14 = r8.getData();     // Catch: Exception -> L27 ClassCastException -> L29
        Intrinsics.checkNotNullExpressionValue(r14, "getData(...)");     // Catch: Exception -> L27 ClassCastException -> L29
        r12.L$0 = this;     // Catch: Exception -> L27 ClassCastException -> L29
        r12.L$1 = r3;     // Catch: Exception -> L27 ClassCastException -> L29
        r12.label = 1;     // Catch: Exception -> L27 ClassCastException -> L29
        if (n.a.a(r13, r14, r11, r17, r18, r19, false, r12, 32, null) != r5) goto L32;
        return r5;
    L29:
        e = move-exception;
        RunLog.INSTANCE.error(a(), "Shape is not XSLFPictureShape: " + r3.getClass().getName(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L27:
        e = move-exception;
        RunLog.INSTANCE.error(a(), "Failed to process XSLF picture", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L7:
        r4 = new PptxFileProcessor$processPictureShape$1(this, r0);
        goto L8
    }

    @Override // com.obric.memorydata.database.util.file_utils.d, com.obric.memorydata.database.util.file_utils.b
    public String a() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.util.file_utils.d
    public SlideShow<?, ?> a(FileInputStream r3) {
        Intrinsics.checkNotNullParameter(r3, "fis");
        return (SlideShow) ZeusTransformUtils.preCheckCast(new XMLSlideShow((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin")), SlideShow.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.util.file_utils.o
    public FileExtension j() {
        return this.e;
    }
}
