package com.obric.memorydata.database.util.file_utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0014J*\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J6\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u0004\u0018\u00010\"*\u00020#2\u0006\u0010$\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006,"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PdfFileProcessor;", "Lcom/obric/memorydata/database/util/file_utils/BaseDocumentImageProcessor;", "<init>", "()V", "fileTypeTag", "", "getFileTypeTag", "()Ljava/lang/String;", "supportedFileType", "Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "getSupportedFileType", "()Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "process", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "(Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readPdfFileWithImages", "afd", "Landroid/content/res/AssetFileDescriptor;", "(Landroid/content/res/AssetFileDescriptor;Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processPageText", "document", "Lcom/tom_roush/pdfbox/pdmodel/PDDocument;", "pageIndex", "", "totalChars", "totalCharLimit", "processPageImages", "", "documentTree", "parentId", "(Lcom/tom_roush/pdfbox/pdmodel/PDDocument;ILcom/obric/memorydata/database/util/file_utils/DocumentTree;ILcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toByteArray", "", "Landroid/graphics/Bitmap;", "format", "getImageFormat", "image", "Lcom/tom_roush/pdfbox/pdmodel/graphics/image/PDImageXObject;", "countTotalImages", "getPdfPageCount", "Companion", "TooComplexPage", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PdfFileProcessor extends com.obric.memorydata.database.util.file_utils.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9628b = null;
    private final String c;
    private final FileExtension d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PdfFileProcessor$TooComplexPage;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "<init>", "()V", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class TooComplexPage extends RuntimeException {
        public TooComplexPage() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PdfFileProcessor$Companion;", "", "<init>", "()V", "TAG", "", "MAX_PDF_PAGES", "", "MAX_IMAGE_COUNT", "DEFAULT_IMAGE_QUALITY", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"com/obric/memorydata/database/util/file_utils/PdfFileProcessor$processPageText$stripper$1", "Lcom/tom_roush/pdfbox/text/PDFTextStripper;", "glyphs", "", "maxGlyphs", "processTextPosition", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Lcom/tom_roush/pdfbox/text/TextPosition;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends com.tom_roush.pdfbox.c.b {
        private int e;
        private final int f;

        b() {
            this.f = 80000;
        }

        @Override // com.tom_roush.pdfbox.c.b, com.tom_roush.pdfbox.c.a
        public void a(com.tom_roush.pdfbox.c.c r3) {
            int r0 = this.e + 1;
            this.e = r0;
            if (r0 > this.f) goto L7;
            super.a(r3);
            return;
        L7:
            throw new TooComplexPage();
        }
    }

    static {
        f9628b = new a(null);
    }

    public PdfFileProcessor() {
        this.c = FileExtension.PDF.getValue();
        com.tom_roush.pdfbox.android.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        a(50);
        this.d = FileExtension.PDF;
    }

    private final int a(final AssetFileDescriptor r2) {
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.y.a($$Lambda$PdfFileProcessor$jZgo75mC8DLY8eh0mfJe_ncG8wo.INSTANCE, new $$Lambda$PdfFileProcessor$ciIvfd2x6vWghQkqoh5IELicZUc(r2)), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return r1.intValue();
    }

    private static final int a(Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        RunLog.INSTANCE.error("PdfFileProcessor", "获取PDF页数失败: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin")), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        return Integer.MAX_VALUE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x013f -> B:40:0x01ba). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x01a1 -> B:39:0x01ad). Please report as a decompilation issue!!! */
    private final Object a(AssetFileDescriptor r27, FileEntity r28, Continuation<? super j> r29) {
        String r1 = "com.obric.memorydata.plugin";
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r29, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, PdfFileProcessor$readPdfFileWithImages$1.class) == false) goto L7;
        PdfFileProcessor$readPdfFileWithImages$1 r2 = (PdfFileProcessor$readPdfFileWithImages$1) ZeusTransformUtils.preCheckCast(r0, PdfFileProcessor$readPdfFileWithImages$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
        PdfFileProcessor r3 = this;
    L8:
        Object r4 = r2.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r2.label;
        int r7 = 0;
        String r8 = "PdfFileProcessor";
        if (r6 == 0) goto L19;
        if (r6 != 1) goto L18;
        int r9 = r2.I$3;
        int r10 = r2.I$2;
        int r11 = r2.I$1;
        int r12 = r2.I$0;
        h r13 = (h) ZeusTransformUtils.preCheckCast(r2.L$7, h.class, "com.obric.memorydata.plugin");
        j r14 = (j) ZeusTransformUtils.preCheckCast(r2.L$6, j.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.pdmodel.c r15 = (com.tom_roush.pdfbox.pdmodel.c) ZeusTransformUtils.preCheckCast(r2.L$5, com.tom_roush.pdfbox.pdmodel.c.class, "com.obric.memorydata.plugin");
        Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(r2.L$4, Closeable.class, "com.obric.memorydata.plugin");
        Closeable r17 = (Closeable) ZeusTransformUtils.preCheckCast(r2.L$3, Closeable.class, "com.obric.memorydata.plugin");
        Closeable r18 = (Closeable) ZeusTransformUtils.preCheckCast(r2.L$2, Closeable.class, "com.obric.memorydata.plugin");
        FileEntity r19 = (FileEntity) ZeusTransformUtils.preCheckCast(r2.L$1, FileEntity.class, "com.obric.memorydata.plugin");
        PdfFileProcessor$readPdfFileWithImages$1 r110 = r2;
        PdfFileProcessor r20 = (PdfFileProcessor) ZeusTransformUtils.preCheckCast(r2.L$0, PdfFileProcessor.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L14
        String r25 = "com.obric.memorydata.plugin";
        FileEntity r21 = r19;
        String r24 = "PdfFileProcessor";
        int r22 = r9;
    L39:
        Closeable r111 = r16;
        int r23 = 1;
        com.tom_roush.pdfbox.pdmodel.c r112 = r15;
        j r113 = r14;
        h r114 = r13;
        int r115 = r12;
        Closeable r116 = r17;
        Closeable r26 = r18;
        int r30 = r11;
        r7 = r22;
        r3 = r20;
        PdfFileProcessor$readPdfFileWithImages$1 r31 = r110;
    L40:
        r7 = r7 + r23;
        r8 = r24;
        r1 = r25;
    L27:
        if (r7 < r115) goto L112;
        r25 = r1;
        r24 = r8;
        r1 = null;
        CloseableKt.closeFinally(r111, null);     // Catch: Throwable -> L55
        CloseableKt.closeFinally(r116, null);     // Catch: Throwable -> L53
        CloseableKt.closeFinally(r26, null);     // Catch: Exception -> L83 OutOfMemoryError -> L85
        return r113;
    L53:
        th = move-exception;
        Throwable r32 = th;
        r18 = r26;
    L124:
        throw r32;     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        CloseableKt.closeFinally(r18, r32);     // Catch: Exception -> L83 OutOfMemoryError -> L85
        throw th;     // Catch: Exception -> L83 OutOfMemoryError -> L85
    L55:
        th = move-exception;
        Throwable r33 = th;
        r18 = r26;
        r17 = r116;
    L108:
        throw r33;     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        CloseableKt.closeFinally(r17, r33);     // Catch: Throwable -> L73
        throw th;     // Catch: Throwable -> L73
    L73:
        th = th;
    L77:
        r32 = th;
        goto L124
    L112:
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L45
        String r117 = r3.a(r112, r7, r30, r10);     // Catch: Throwable -> L45
        if (r117 != null) goto L31;
        r25 = r1;
        r24 = r8;
        r23 = 1;
        goto L40
    L31:
        int r34 = r30 + r117.length();     // Catch: Throwable -> L45
        h r118 = j.a(r113, NodeType.TEXT, r117, 0, null, 8, null);     // Catch: Throwable -> L45
        r24 = r8;
        r25 = r1;
        r114.e().add(Boxing.boxInt(r118.a()));     // Catch: Throwable -> L41
        int r210 = r118.a();     // Catch: Throwable -> L41
        r31.L$0 = r3;     // Catch: Throwable -> L41
        r31.L$1 = r21;     // Catch: Throwable -> L41
        r31.L$2 = r26;     // Catch: Throwable -> L41
        r31.L$3 = r116;     // Catch: Throwable -> L41
        r31.L$4 = r111;     // Catch: Throwable -> L41
        r31.L$5 = r112;     // Catch: Throwable -> L41
        r31.L$6 = r113;     // Catch: Throwable -> L41
        r31.L$7 = r114;     // Catch: Throwable -> L41
        r31.I$0 = r115;     // Catch: Throwable -> L41
        r31.I$1 = r34;     // Catch: Throwable -> L41
        r31.I$2 = r10;     // Catch: Throwable -> L41
        r31.I$3 = r7;     // Catch: Throwable -> L41
        r31.label = 1;     // Catch: Throwable -> L41
        if (r3.a(r112, r7, r113, r210, r21, r31) != r5) goto L38;
        return r5;
    L38:
        r110 = r31;
        r20 = r3;
        r22 = r7;
        r11 = r34;
        r18 = r26;
        r17 = r116;
        r12 = r115;
        r13 = r114;
        r14 = r113;
        r15 = r112;
        r16 = r111;
    L41:
        th = th;
    L47:
        Throwable r35 = th;
        r18 = r26;
        r17 = r116;
        r16 = r111;
    L16:
        r1 = null;
    L122:
        throw r35;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        CloseableKt.closeFinally(r16, r35);     // Catch: Throwable -> L64
        throw th;     // Catch: Throwable -> L64
    L64:
        th = th;
    L65:
        r33 = th;
    L43:
        th = th;
        r25 = r1;
    L45:
        th = th;
        r25 = r1;
        r24 = r8;
    L14:
        th = move-exception;
        r35 = th;
        r25 = "com.obric.memorydata.plugin";
        r24 = "PdfFileProcessor";
        goto L16
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        PdfFileProcessor$readPdfFileWithImages$1 r119 = r2;
        ResultKt.throwOnFailure(r4);
        ParcelFileDescriptor r36 = r27.getParcelFileDescriptor();     // Catch: Exception -> L91 OutOfMemoryError -> L94
        if (r36 != null) goto L130;
        r1 = null;
    L99:
        return r1;
    L130:
        r18 = (Closeable) ZeusTransformUtils.preCheckCast(r36, Closeable.class, "com.obric.memorydata.plugin");     // Catch: OutOfMemoryError -> L87 Exception -> L91
    L120:
        ParcelFileDescriptor r37 = (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r18, ParcelFileDescriptor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L75
        r17 = (Closeable) ZeusTransformUtils.preCheckCast(r27.createInputStream(), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L75
        r16 = (Closeable) ZeusTransformUtils.preCheckCast(com.tom_roush.pdfbox.pdmodel.c.a((InputStream) ZeusTransformUtils.preCheckCast((FileInputStream) ZeusTransformUtils.preCheckCast(r17, FileInputStream.class, "com.obric.memorydata.plugin"), InputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L66
        com.tom_roush.pdfbox.pdmodel.c r38 = (com.tom_roush.pdfbox.pdmodel.c) ZeusTransformUtils.preCheckCast(r16, com.tom_roush.pdfbox.pdmodel.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        j r39 = new j();     // Catch: Throwable -> L57
        r113 = r39;
        r114 = j.a(r39, NodeType.VIRTUAL, "", 0, null, 8, null);     // Catch: Throwable -> L57
        r10 = 1000000;
        r111 = r16;
        r31 = r119;
        r112 = r38;
        r115 = r38.d();     // Catch: Throwable -> L57
        r21 = r28;
        r116 = r17;
        r26 = r18;
        r30 = 0;
    L57:
        th = move-exception;
        r25 = "com.obric.memorydata.plugin";
        r24 = "PdfFileProcessor";
        r1 = null;
        r35 = th;
    L66:
        th = th;
        r25 = "com.obric.memorydata.plugin";
        r24 = "PdfFileProcessor";
        r1 = null;
    L75:
        th = th;
        r25 = "com.obric.memorydata.plugin";
        r24 = "PdfFileProcessor";
        r1 = null;
    L87:
        e = e;
        r25 = "com.obric.memorydata.plugin";
        r1 = null;
        String r40 = "PdfFileProcessor";
    L89:
        String r41 = r25;
    L96:
        RunLog r42 = RunLog.INSTANCE;
        Throwable r43 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, r41);
        String r44 = "PDF解析发生 OOM";
    L97:
        r42.error(r40, r44, r43);
    L91:
        e = e;
        r25 = "com.obric.memorydata.plugin";
        r24 = "PdfFileProcessor";
        r1 = null;
    L93:
        r42 = RunLog.INSTANCE;
        r43 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, r25);
        r44 = "PDF解析失败";
        r40 = r24;
    L94:
        e = e;
        r41 = "com.obric.memorydata.plugin";
        r40 = "PdfFileProcessor";
        r1 = null;
    L83:
        e = e;
    L85:
        e = e;
        r40 = r24;
    L7:
        r3 = this;
        r2 = new PdfFileProcessor$readPdfFileWithImages$1(r3, r0);
        goto L8
    }

    public static final /* synthetic */ Object a(PdfFileProcessor r2, AssetFileDescriptor r3, FileEntity r4, Continuation r5) {
        return r2.a(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(com.tom_roush.pdfbox.pdmodel.c r13, int r14, j r15, int r16, FileEntity r17, Continuation<? super Unit> r18) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        Object r1 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new PdfFileProcessor$processPageImages$2(r13, r14, this, r15, r16, r17, null), Function2.class, "com.obric.memorydata.plugin"), r0);
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r1;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ String a(PdfFileProcessor r0, com.tom_roush.pdfbox.pdmodel.graphics.d.b r1) {
        return r0.a(r1);
    }

    private final String a(com.tom_roush.pdfbox.pdmodel.c r12, int r13, int r14, int r15) {
        b r1 = new b();
        boolean r2 = false;
        r1.b(false);
        int r16 = r13 + 1;
        r1.a(r16);
        r1.b(r16);
        String r17 = r1.a(r12);     // Catch: Throwable -> L18 OutOfMemoryError -> L20 TooComplexPage -> L23
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18 OutOfMemoryError -> L20 TooComplexPage -> L23
        if (r3 != null) goto L6;
    L7:
        r2 = true;
    L8:
        if (r2 == false) goto L11;
        return null;
    L11:
        if (r17.length() > 200000) goto L17;
    L14:
        if ((r14 + r17.length()) > r15) goto L17;
        return r17;
    L17:
        return null;
    L6:
        if (r3.length() != 0) goto L8;
    L23:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PdfFileProcessor", "Page " + r16 + " too complex (glyphs exceeded limit).", null, 4, null);
        return null;
    L20:
        e = move-exception;
        RunLog r18 = RunLog.INSTANCE;
        String r19 = "OOM while parsing page " + r16 + '.';
        th = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
    L22:
        r18.error("PdfFileProcessor", r19, th);
        return null;
    L18:
        th = th;
        r18 = RunLog.INSTANCE;
        r19 = "Unexpected error while parsing page " + r16 + ": " + th.getMessage();
        goto L22
    }

    private final String a(com.tom_roush.pdfbox.pdmodel.graphics.d.b r5) {
        String r4 = r5.j();
        if (r4 == null) goto L21;
        switch(r4.hashCode()) {
            case 97669: goto L17;
            case 102340: goto L13;
            case 105441: goto L11;
            case 111145: goto L9;
            case 3268712: goto L7;
            default: goto L21;
        };
    L7:
        r4.equals("jpeg");
        goto L21
    L11:
        r4.equals("jpg");
        goto L21
    L9:
        if (r4.equals("png") == false) goto L21;
        return "png";
    L13:
        if (r4.equals("gif") == false) goto L21;
        return "gif";
    L17:
        if (r4.equals("bmp") == false) goto L21;
        return "bmp";
    L21:
        return "jpg";
    }

    private final byte[] a(Bitmap r7, String r8) {
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(new ByteArrayOutputStream(), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L31
        ByteArrayOutputStream r2 = (ByteArrayOutputStream) ZeusTransformUtils.preCheckCast(r1, ByteArrayOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        int r3 = r8.hashCode();     // Catch: Throwable -> L26
        if (r3 == 105441) goto L19;
        if (r3 == 111145) goto L15;
        if (r3 == 3268712) goto L12;
    L20:
        Bitmap.CompressFormat r9 = Bitmap.CompressFormat.JPEG;     // Catch: Throwable -> L26
        OutputStream r4 = (OutputStream) ZeusTransformUtils.preCheckCast(r2, OutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
    L21:
        r7.compress(r9, 90, r4);     // Catch: Throwable -> L26
    L23:
        byte[] r10 = r2.toByteArray();     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r1, null);     // Catch: Exception -> L31
        return r10;
    L12:
        if (r8.equals("jpeg") == false) goto L20;
    L22:
        r9 = Bitmap.CompressFormat.JPEG;     // Catch: Throwable -> L26
        r4 = (OutputStream) ZeusTransformUtils.preCheckCast(r2, OutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        goto L21
    L15:
        if (r8.equals("png") == false) goto L20;
        r7.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream) ZeusTransformUtils.preCheckCast(r2, OutputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L26
        goto L23
    L19:
        if (r8.equals("jpg") == true) goto L22;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Exception -> L31
        throw th;     // Catch: Exception -> L31
    L31:
        e = move-exception;
        RunLog.INSTANCE.error("PdfFileProcessor", "Failed to convert bitmap to byte array", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    public static final /* synthetic */ byte[] a(PdfFileProcessor r0, Bitmap r1, String r2) {
        return r0.a(r1, r2);
    }

    private static final int b(AssetFileDescriptor r1) {
        return new PdfRenderer(r1.getParcelFileDescriptor()).getPageCount();
    }

    public static /* synthetic */ int lambda$ciIvfd2x6vWghQkqoh5IELicZUc(AssetFileDescriptor r0) {
        return b(r0);
    }

    public static /* synthetic */ int lambda$jZgo75mC8DLY8eh0mfJe_ncG8wo(Exception r0) {
        return a(r0);
    }

    @Override // com.obric.memorydata.database.util.file_utils.b, com.obric.memorydata.database.util.file_utils.o
    public Object a(FileEntity r21, Continuation<? super j> r22) {
        PdfFileProcessor r0 = this;
        FileEntity r1 = r21;
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, PdfFileProcessor$process$1.class) == false) goto L7;
        PdfFileProcessor$process$1 r5 = (PdfFileProcessor$process$1) ZeusTransformUtils.preCheckCast(r3, PdfFileProcessor$process$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        if (r7 == 0) goto L32;
        if (r7 == 1) goto L31;
        if (r7 == 2) goto L24;
        if (r7 == 3) goto L21;
        if (r7 != 4) goto L20;
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(r5.L$0, Closeable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L17
    L73:
        j r8 = (j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r2, null);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        return r8;
    L17:
        th = th;
    L18:
        Throwable r9 = th;
        throw r9;     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        CloseableKt.closeFinally(r2, r9);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        throw th;     // Catch: Exception -> L27 IllegalArgumentException -> L29
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        FileEntity r10 = (FileEntity) ZeusTransformUtils.preCheckCast(r5.L$1, FileEntity.class, "com.obric.memorydata.plugin");
        PdfFileProcessor r11 = (PdfFileProcessor) ZeusTransformUtils.preCheckCast(r5.L$0, PdfFileProcessor.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Exception -> L27 IllegalArgumentException -> L29
    L64:
        UriFileAccessSession r12 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r4, UriFileAccessSession.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27 IllegalArgumentException -> L29
        if (r12 == null) goto L99;
        AssetFileDescriptor r13 = r12.getFd();     // Catch: Exception -> L27 IllegalArgumentException -> L29
        if (r13 == null) goto L100;
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(r13, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27 IllegalArgumentException -> L29
        AssetFileDescriptor r15 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r14, AssetFileDescriptor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L76
        r5.L$0 = r14;     // Catch: Throwable -> L76
        r5.L$1 = null;     // Catch: Throwable -> L76
        r5.label = 4;     // Catch: Throwable -> L76
        r4 = r11.a(r15, r10, r5);     // Catch: Throwable -> L76
        if (r4 != r6) goto L72;
        return r6;
    L72:
        r2 = r14;
    L76:
        th = th;
        r2 = r14;
        goto L18
    L100:
        return null;
    L99:
        return null;
    L24:
        Ref.BooleanRef r16 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(r5.L$2, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        r1 = (FileEntity) ZeusTransformUtils.preCheckCast(r5.L$1, FileEntity.class, "com.obric.memorydata.plugin");
        PdfFileProcessor r17 = (PdfFileProcessor) ZeusTransformUtils.preCheckCast(r5.L$0, PdfFileProcessor.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Exception -> L27 IllegalArgumentException -> L29
    L39:
        UriFileAccessSession r18 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r4, UriFileAccessSession.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27 IllegalArgumentException -> L29
        if (r18 == null) goto L58;
        AssetFileDescriptor r19 = r18.getFd();     // Catch: Exception -> L27 IllegalArgumentException -> L29
        if (r19 == null) goto L58;
        Closeable r20 = (Closeable) ZeusTransformUtils.preCheckCast(r19, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27 IllegalArgumentException -> L29
        int r23 = r17.a((AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r20, AssetFileDescriptor.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L50
        if (r23 <= 1000) goto L47;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PdfFileProcessor", "PDF pages exceed parsing limit: " + r23 + " > 1000", null, 4, null);     // Catch: Throwable -> L50
        r16.element = true;     // Catch: Throwable -> L50
    L48:
        CloseableKt.closeFinally(r20, null);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        goto L58
    L47:
        r16.element = false;     // Catch: Throwable -> L50
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        CloseableKt.closeFinally(r20, th);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        throw th;     // Catch: Exception -> L27 IllegalArgumentException -> L29
    L58:
        if (r16.element == false) goto L60;
        return null;
    L60:
        m r25 = m.f9660a;     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r5.L$0 = r17;     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r5.L$1 = r1;     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r5.L$2 = null;     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r5.label = 3;     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r4 = r25.a(r1, r5);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        if (r4 != r6) goto L63;
        return r6;
    L63:
        r10 = r1;
        r11 = r17;
        goto L64
    L31:
        FileEntity r26 = (FileEntity) ZeusTransformUtils.preCheckCast(r5.L$1, FileEntity.class, "com.obric.memorydata.plugin");
        PdfFileProcessor r27 = (PdfFileProcessor) ZeusTransformUtils.preCheckCast(r5.L$0, PdfFileProcessor.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r1 = r26;
        r0 = r27;
    L35:
        Ref.BooleanRef r28 = new Ref.BooleanRef();     // Catch: Exception -> L27 IllegalArgumentException -> L29
        m r29 = m.f9660a;     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r5.L$0 = r0;     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r5.L$1 = r1;     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r5.L$2 = r28;     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r5.label = 2;     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r4 = r29.a(r1, r5);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        if (r4 != r6) goto L38;
        return r6;
    L38:
        r17 = r0;
        r16 = r28;
        goto L39
    L32:
        ResultKt.throwOnFailure(r4);
        r5.L$0 = r0;
        r5.L$1 = r1;
        r5.label = 1;
        if (super.a(r1, r5) != r6) goto L35;
        return r6;
    L29:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PdfFileProcessor", "Doubao Assistant is not started, unable to obtain permission: " + e.getMessage(), null, 4, null);
        return null;
    L27:
        e = move-exception;
        RunLog.INSTANCE.error("PdfFileProcessor", "File access failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        if (AppContext.INSTANCE.isDebug() == false) goto L102;
        throw e;
    L102:
        return null;
    L7:
        r5 = new PdfFileProcessor$process$1(r0, r3);
        goto L8
    }

    @Override // com.obric.memorydata.database.util.file_utils.b
    public String a() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.util.file_utils.o
    public FileExtension j() {
        return this.d;
    }
}
