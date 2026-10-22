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
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
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
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J0\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0 2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J&\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0 H\u0002J\u0010\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006)"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/DocxFileProcessor;", "Lcom/obric/memorydata/database/util/file_utils/AbstractWordFileProcessor;", "<init>", "()V", "fileTypeTag", "", "getFileTypeTag", "()Ljava/lang/String;", "imageIndexCounter", "", "supportedFileType", "Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "getSupportedFileType", "()Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "process", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "(Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readDocFileByAfd", "afd", "Landroid/content/res/AssetFileDescriptor;", "parseDocxFile", "inputStream", "Ljava/io/InputStream;", "docFileEntity", "handleImage", "Lcom/obric/memorydata/database/util/file_utils/DocNode;", "picture", "Lorg/apache/poi/xwpf/usermodel/XWPFPicture;", "tree", "stack", "", "handleTable", "", "table", "Lorg/apache/poi/xwpf/usermodel/XWPFTable;", "detectHeadingLevel", "para", "Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k extends com.obric.memorydata.database.util.file_utils.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9657b = null;
    private final String c;
    private int d;
    private final FileExtension e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/DocxFileProcessor$Companion;", "", "<init>", "()V", "TAG", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9657b = new a(null);
    }

    public k() {
        this.c = "DocxFileProcessor";
        this.e = FileExtension.DOCX;
    }

    private final int a(XWPFParagraph r5) {
        String r4 = r5.getStyle();
        if (r4 == null) goto L17;
        Integer r6 = StringsKt.toIntOrNull(r4);
        if (r6 == null) goto L18;
        Integer r7 = Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue());
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue();
        boolean r1 = false;
        if (1 <= r0) goto L9;
    L11:
        if (r1 == true) goto L14;
        r7 = null;
    L14:
        if (r7 != null) goto L16;
        return -1;
    L16:
        return r7.intValue();
    L9:
        if (r0 >= 9) goto L11;
        r1 = true;
        goto L11
    L18:
        return -1;
    L17:
        return -1;
    }

    private final h a(XWPFPicture r22, j r23, List<h> r24, FileEntity r25) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        int r12 = this.d + 1;
        this.d = r12;
        int r13 = ((h) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r0), h.class, "com.obric.memorydata.plugin")).a();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        k r2 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        XWPFPictureData r3 = r22.getPictureData();     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        Pair r4 = new Pair(r3.getData(), r3.suggestFileExtension());     // Catch: Throwable -> L9
    L7:
        Object r5 = Result.m1421constructorimpl(r4);     // Catch: Throwable -> L9
    L11:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L15;
        RunLog.INSTANCE.error("DocxFileProcessor", "Failed to get picture data", r6);
        r5 = null;
    L15:
        Pair r7 = (Pair) ZeusTransformUtils.preCheckCast(r5, Pair.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L18;
        return null;
    L18:
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new DocxFileProcessor$handleImage$3(this, (byte[]) ZeusTransformUtils.preCheckCast(r7.component1(), byte[].class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r7.component2(), String.class, "com.obric.memorydata.plugin"), r12, r23, r13, r25, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return r23.a(NodeType.IMAGE, q.f9661a.a(new q(String.valueOf(r12), null, 2, null)), 1, Integer.valueOf(r13));
    L6:
        r4 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final j a(final AssetFileDescriptor r3, final FileEntity r4) {
        return (j) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.y.a($$Lambda$k$wxWt6RaM44H0Vv9kDCDHyqD8.INSTANCE, new $$Lambda$k$0hdVYMl4FzPctlLA1gp70oebYqU(r3, this, r4)), j.class, "com.obric.memorydata.plugin");
    }

    private static final j a(AssetFileDescriptor r3, k r4, FileEntity r5) {
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

    public static final /* synthetic */ j a(k r0, AssetFileDescriptor r1, FileEntity r2) {
        return r0.a(r1, r2);
    }

    private final j a(InputStream r17, FileEntity r18) {
        XWPFDocument r2 = new XWPFDocument(r17);
        j r3 = new j();
        List<h> r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        h r5 = r3.a();
        if (r5 == null) goto L5;
        r4.add(r5);
    L5:
        List<IBodyElement> r6 = r2.getBodyElements();
        Intrinsics.checkNotNullExpressionValue(r6, "getBodyElements(...)");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r7.hasNext() == false) goto L44;
        IBodyElement r8 = (IBodyElement) ZeusTransformUtils.preCheckCast(r7.next(), IBodyElement.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, XWPFParagraph.class) == false) goto L24;
        List<XWPFRun> r9 = ((XWPFParagraph) ZeusTransformUtils.preCheckCast(r8, XWPFParagraph.class, "com.obric.memorydata.plugin")).getRuns();
        Intrinsics.checkNotNullExpressionValue(r9, "getRuns(...)");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r10.hasNext() == false) goto L17;
        List<XWPFPicture> r11 = ((XWPFRun) ZeusTransformUtils.preCheckCast(r10.next(), XWPFRun.class, "com.obric.memorydata.plugin")).getEmbeddedPictures();
        Intrinsics.checkNotNullExpressionValue(r11, "getEmbeddedPictures(...)");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r12.hasNext() == false) goto L12;
        XWPFPicture r13 = (XWPFPicture) ZeusTransformUtils.preCheckCast(r12.next(), XWPFPicture.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r13);
        a(r13, r3, r4, r18);
        goto L15
    L17:
        int r14 = a((XWPFParagraph) ZeusTransformUtils.preCheckCast(r8, XWPFParagraph.class, "com.obric.memorydata.plugin"));
        if (r14 <= 0) goto L20;
        String r15 = ((XWPFParagraph) ZeusTransformUtils.preCheckCast(r8, XWPFParagraph.class, "com.obric.memorydata.plugin")).getText();
        Intrinsics.checkNotNullExpressionValue(r15, "getText(...)");
        a(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")).toString(), r14, r3, r4);
    L42:
        Iterator r19 = r7;
    L43:
        r7 = r19;
        goto L7
    L20:
        String r16 = ((XWPFParagraph) ZeusTransformUtils.preCheckCast(r8, XWPFParagraph.class, "com.obric.memorydata.plugin")).getText();
        Intrinsics.checkNotNullExpressionValue(r16, "getText(...)");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L42;
        String r20 = ((XWPFParagraph) ZeusTransformUtils.preCheckCast(r8, XWPFParagraph.class, "com.obric.memorydata.plugin")).getText();
        Intrinsics.checkNotNullExpressionValue(r20, "getText(...)");
        a(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")).toString(), r3, r4);
        goto L42
    L24:
        if (ZeusTransformUtils.instanceOf(r8, XWPFTable.class) == false) goto L42;
        List<XWPFTableRow> r21 = ((XWPFTable) ZeusTransformUtils.preCheckCast(r8, XWPFTable.class, "com.obric.memorydata.plugin")).getRows();
        Intrinsics.checkNotNullExpressionValue(r21, "getRows(...)");
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L27:
        if (r22.hasNext() == false) goto L41;
        List<XWPFTableCell> r110 = ((XWPFTableRow) ZeusTransformUtils.preCheckCast(r22.next(), XWPFTableRow.class, "com.obric.memorydata.plugin")).getTableCells();
        Intrinsics.checkNotNullExpressionValue(r110, "getTableCells(...)");
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L30:
        if (r111.hasNext() == false) goto L27;
        List<XWPFParagraph> r112 = ((XWPFTableCell) ZeusTransformUtils.preCheckCast(r111.next(), XWPFTableCell.class, "com.obric.memorydata.plugin")).getParagraphs();
        Intrinsics.checkNotNullExpressionValue(r112, "getParagraphs(...)");
        Iterator r113 = ((Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L33:
        if (r113.hasNext() == false) goto L30;
        List<XWPFRun> r114 = ((XWPFParagraph) ZeusTransformUtils.preCheckCast(r113.next(), XWPFParagraph.class, "com.obric.memorydata.plugin")).getRuns();
        Intrinsics.checkNotNullExpressionValue(r114, "getRuns(...)");
        Iterator r115 = ((Iterable) ZeusTransformUtils.preCheckCast(r114, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L36:
        if (r115.hasNext() == false) goto L33;
        List<XWPFPicture> r116 = ((XWPFRun) ZeusTransformUtils.preCheckCast(r115.next(), XWPFRun.class, "com.obric.memorydata.plugin")).getEmbeddedPictures();
        Intrinsics.checkNotNullExpressionValue(r116, "getEmbeddedPictures(...)");
        Iterator r117 = ((Iterable) ZeusTransformUtils.preCheckCast(r116, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L39:
        if (r117.hasNext() == false) goto L36;
        Iterator r118 = r7;
        XWPFPicture r23 = (XWPFPicture) ZeusTransformUtils.preCheckCast(r117.next(), XWPFPicture.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r23);
        a(r23, r3, r4, r18);
        r7 = r118;
        goto L39
    L41:
        r19 = r7;
        a((XWPFTable) ZeusTransformUtils.preCheckCast(r8, XWPFTable.class, "com.obric.memorydata.plugin"), r3, r4);
        goto L43
    L44:
        r2.close();
        return r3;
    }

    private static final j a(Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        RunLog.INSTANCE.error("DocxFileProcessor", "读取DOCX文件失败：" + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin")), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    private final void a(XWPFTable r11, j r12, List<h> r13) {
        List<h> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List<XWPFTableRow> r0 = r11.getRows();
        Intrinsics.checkNotNullExpressionValue(r0, "getRows(...)");
        XWPFTableRow r1 = (XWPFTableRow) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r0), XWPFTableRow.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        List<XWPFTableCell> r2 = r1.getTableCells();
        if (r2 == null) goto L7;
        int r3 = r2.size();
    L8:
        r14.add(j.a(r12, NodeType.TABLE, "Table " + r11.getRows().size() + 'x' + r3, 0, Integer.valueOf(((h) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r14), h.class, "com.obric.memorydata.plugin")).a()), 4, null));
        List<XWPFTableRow> r15 = r11.getRows();
        Intrinsics.checkNotNullExpressionValue(r15, "getRows(...)");
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r16.hasNext() == false) goto L23;
        List<XWPFTableCell> r4 = ((XWPFTableRow) ZeusTransformUtils.preCheckCast(r16.next(), XWPFTableRow.class, "com.obric.memorydata.plugin")).getTableCells();
        Intrinsics.checkNotNullExpressionValue(r4, "getTableCells(...)");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r5.hasNext() == false) goto L10;
        List<XWPFParagraph> r6 = ((XWPFTableCell) ZeusTransformUtils.preCheckCast(r5.next(), XWPFTableCell.class, "com.obric.memorydata.plugin")).getParagraphs();
        Intrinsics.checkNotNullExpressionValue(r6, "getParagraphs(...)");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r7.hasNext() == false) goto L13;
        XWPFParagraph r8 = (XWPFParagraph) ZeusTransformUtils.preCheckCast(r7.next(), XWPFParagraph.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r8);
        int r9 = a(r8);
        if (r9 > 0) goto L19;
        String r10 = r8.getText();
        Intrinsics.checkNotNullExpressionValue(r10, "getText(...)");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L16;
        String r17 = r8.getText();
        Intrinsics.checkNotNullExpressionValue(r17, "getText(...)");
        a(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin")).toString(), r12, r14);
        goto L16
    L19:
        String r18 = r8.getText();
        Intrinsics.checkNotNullExpressionValue(r18, "getText(...)");
        a(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).toString(), r9, r12, r14);
        goto L16
    L23:
        r14.remove(CollectionsKt.getLastIndex(r14));
        return;
    L7:
        r3 = 0;
        goto L8
    }

    public static /* synthetic */ j lambda$0hdVYMl4FzPctlLA1gp70oebYqU(AssetFileDescriptor r0, k r1, FileEntity r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$wxWt6RaM-44H0Vv9kDCDHy-q-D8, reason: not valid java name */
    public static /* synthetic */ j m581lambda$wxWt6RaM44H0Vv9kDCDHyqD8(Exception r0) {
        return a(r0);
    }

    @Override // com.obric.memorydata.database.util.file_utils.b, com.obric.memorydata.database.util.file_utils.o
    public Object a(FileEntity r19, Continuation<? super j> r20) {
        k r0 = this;
        FileEntity r1 = r19;
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, DocxFileProcessor$process$1.class) == false) goto L7;
        DocxFileProcessor$process$1 r5 = (DocxFileProcessor$process$1) ZeusTransformUtils.preCheckCast(r3, DocxFileProcessor$process$1.class, "com.obric.memorydata.plugin");
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
        k r9 = (k) ZeusTransformUtils.preCheckCast(r5.L$0, k.class, "com.obric.memorydata.plugin");
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
        k r24 = (k) ZeusTransformUtils.preCheckCast(r5.L$0, k.class, "com.obric.memorydata.plugin");
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
        r5 = new DocxFileProcessor$process$1(r0, r3);
        goto L8
    }

    @Override // com.obric.memorydata.database.util.file_utils.b
    public String a() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.util.file_utils.o
    public FileExtension j() {
        return this.e;
    }
}
