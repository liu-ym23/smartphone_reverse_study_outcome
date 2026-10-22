package com.obric.memorydata.database.util.file_utils;

import android.content.res.AssetFileDescriptor;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFTextbox;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFPictureData;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSimpleShape;
import org.apache.poi.xssf.usermodel.XSSFTextBox;
import org.apache.poi.xssf.usermodel.XSSFTextParagraph;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH$J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J \u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0094@¢\u0006\u0002\u0010\u001bJ \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001dH\u0014J \u0010 \u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001dH\u0014J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&H\u0002J \u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u001e\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J(\u0010/\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u00100\u001a\u00020.H\u0002J(\u00101\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0002JB\u00102\u001a\u00020\u001d2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060-2\u0012\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060-0-2\u0006\u00105\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u00106\u001a\u000207H\u0002J.\u00108\u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010:J\u0018\u0010;\u001a\u0004\u0018\u00010\u00182\u0006\u00109\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010<J\u0006\u0010=\u001a\u00020\u000eR\u0012\u0010\u0005\u001a\u00020\u0006X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006?"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/BaseExcelProcessor;", "Lcom/obric/memorydata/database/util/file_utils/BaseDocumentImageProcessor;", "Lcom/obric/memorydata/database/util/file_utils/IFileProcessor;", "<init>", "()V", "fileTypeTag", "", "getFileTypeTag", "()Ljava/lang/String;", "createWorkbook", "Lorg/apache/poi/ss/usermodel/Workbook;", "fis", "Ljava/io/FileInputStream;", "shouldSkipSheet", "", "sheet", "Lorg/apache/poi/ss/usermodel/Sheet;", "hasAnyContent", "processCellValue", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "Lorg/apache/poi/ss/usermodel/Cell;", "isTrulyBlankString", "s", "fromStream", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "rawFileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "(Ljava/io/FileInputStream;Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processSheetData", "", "tree", "parentId", "extractTextFromShapes", "", "getAllXSSFShapes", "Lkotlin/sequences/Sequence;", "Lorg/apache/poi/xssf/usermodel/XSSFShape;", "drawing", "Lorg/apache/poi/xssf/usermodel/XSSFDrawing;", "processXSSFShape", "shape", "isRangeInTables", "range", "Lorg/apache/poi/ss/util/CellRangeAddress;", "tables", "", "LTableRegion;", "processTableRegion", Api.KEY_REGION, "processRawBlockAsSimpleTable", "processTableContent", "headers", "rows", "headerRowIndex", "parentNode", "Lcom/obric/memorydata/database/util/file_utils/DocNode;", "processSheetImages", "fileEntity", "(Lorg/apache/poi/ss/usermodel/Sheet;Lcom/obric/memorydata/database/util/file_utils/DocumentTree;ILcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "process", "(Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkStAXAvailable", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class c extends com.obric.memorydata.database.util.file_utils.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9639b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0084T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/BaseExcelProcessor$Companion;", "", "<init>", "()V", "MAX_SHEETS_TO_PROCESS", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9640a = null;

        static {
            int[] r0 = new int[CellType.values().length];
            r0[CellType.NUMERIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[CellType.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[CellType.BLANK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[CellType.FORMULA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f9640a = r0;
        }
    }

    static {
        f9639b = new a(null);
    }

    public c() {
    }

    private final int a(Sheet r28, j r29, int r30, defpackage.f r31) {
        Sheet r1 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r28, Sheet.class, "com.obric.memorydata.plugin");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(new IntRange(r31.a().getFirstRow(), r31.a().getLastRow()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Row r6 = r1.getRow(((IntIterator) ZeusTransformUtils.preCheckCast(r5, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r6 == null) goto L4;
        r4.add(r6);
        goto L4
    L8:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L21;
        Row r10 = (Row) ZeusTransformUtils.preCheckCast(r9.next(), Row.class, "com.obric.memorydata.plugin");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(new IntRange(r31.a().getFirstColumn(), r31.a().getLastColumn()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L13:
        if (r13.hasNext() == false) goto L20;
        Cell r14 = r10.getCell(((IntIterator) ZeusTransformUtils.preCheckCast(r13, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r14 == null) goto L18;
        String r15 = a(r14);
        if (r15 == null) goto L18;
    L19:
        r12.add(r15);
    L18:
        r15 = "";
        goto L19
    L20:
        r8.add((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"));
        goto L10
    L21:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(new IntRange(r31.a().getFirstColumn(), r31.a().getLastColumn()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L23:
        if (r19.hasNext() == false) goto L33;
        int r20 = ((IntIterator) ZeusTransformUtils.preCheckCast(r19, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        Row r21 = r1.getRow(r31.b());
        if (r21 == null) goto L31;
        Cell r22 = r21.getCell(r20);
        if (r22 == null) goto L31;
        String r23 = a(r22);
        if (r23 == null) goto L31;
    L32:
        r18.add(r23);
    L31:
        r23 = "";
        goto L32
    L33:
        List r0 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
        h r2 = j.a(r29, NodeType.VIRTUAL, "Table (Rows " + (r31.a().getFirstRow() + 1) + '-' + (r31.a().getLastRow() + 1) + ", Cols " + (r31.a().getFirstColumn() + 1) + '-' + (r31.a().getLastColumn() + 1) + ')', 0, Integer.valueOf(r30), 4, null);
        j.a(r29, NodeType.TABLE_HEADER, CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" | ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("| ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" |", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), 0, Integer.valueOf(r2.a()), 4, null);
        j.a(r29, NodeType.TABLE_HEADER, CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" | ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("| ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" |", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, $$Lambda$c$jugQ9H_94ejjHFaoieDl1oCh_I4.INSTANCE, 24, null), 0, Integer.valueOf(r2.a()), 4, null);
        if (r31.b() < 0) goto L36;
        int r24 = 1;
    L37:
        Iterable r25 = (Iterable) ZeusTransformUtils.preCheckCast(r16.subList(r24, r16.size()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r26 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r27 = r25.iterator();
    L39:
        if (r27.hasNext() == false) goto L53;
        Object r32 = r27.next();
        Iterable r33 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r32, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r33, Collection.class) == true) goto L43;
    L45:
        Iterator r34 = r33.iterator();
    L47:
        if (r34.hasNext() == false) goto L44;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r34.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L47;
        boolean r35 = true;
    L51:
        if (r35 == false) goto L39;
        r26.add(r32);
    L44:
        r35 = false;
        goto L51
    L43:
        if (((Collection) ZeusTransformUtils.preCheckCast(r33, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L45;
    L53:
        Iterable r36 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r26, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Iterator r37 = r36.iterator();
    L55:
        if (r37.hasNext() == false) goto L58;
        j.a(r29, NodeType.TABLE_ROW, CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r37.next(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" | ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("| ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" |", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), 0, Integer.valueOf(r2.a()), 4, null);
        goto L55
    L58:
        return ((Collection) ZeusTransformUtils.preCheckCast(r36, Collection.class, "com.obric.memorydata.plugin")).size();
    L36:
        r24 = 0;
        goto L37
    }

    private final int a(Sheet r17, j r18, int r19, CellRangeAddress r20) {
        Sheet r0 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r17, Sheet.class, "com.obric.memorydata.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(new IntRange(r20.getFirstRow(), r20.getLastRow()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Row r5 = r0.getRow(((IntIterator) ZeusTransformUtils.preCheckCast(r4, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r5 == null) goto L4;
        r3.add(r5);
        goto L4
    L8:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r1.iterator();
    L10:
        if (r7.hasNext() == false) goto L21;
        Row r8 = (Row) ZeusTransformUtils.preCheckCast(r7.next(), Row.class, "com.obric.memorydata.plugin");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(new IntRange(r20.getFirstColumn(), r20.getLastColumn()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L13:
        if (r11.hasNext() == false) goto L20;
        Cell r12 = r8.getCell(((IntIterator) ZeusTransformUtils.preCheckCast(r11, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r12 == null) goto L18;
        String r13 = a(r12);
        if (r13 == null) goto L18;
    L19:
        r10.add(r13);
    L18:
        r13 = "";
        goto L19
    L20:
        r6.add((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"));
        goto L10
    L21:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L22:
        boolean r21 = false;
        if (r16.hasNext() == false) goto L37;
        Object r22 = r16.next();
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r23, Collection.class) == true) goto L27;
    L29:
        Iterator r24 = r23.iterator();
    L31:
        if (r24.hasNext() == false) goto L35;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r24.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L31;
        r21 = true;
    L35:
        if (r21 == false) goto L22;
        r15.add(r22);
        goto L22
    L27:
        if (((Collection) ZeusTransformUtils.preCheckCast(r23, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L29;
    L37:
        List r25 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
        if (r25.isEmpty() == false) goto L40;
        return 0;
    L40:
        h r26 = j.a(r18, NodeType.VIRTUAL, "Simple Table (Rows " + (r20.getFirstRow() + 1) + '-' + (r20.getLastRow() + 1) + ", Cols " + (r20.getFirstColumn() + 1) + '-' + (r20.getLastColumn() + 1) + ')', 0, Integer.valueOf(r19), 4, null);
        Iterator r27 = ((Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L42:
        if (r27.hasNext() == false) goto L45;
        j.a(r18, NodeType.TABLE_ROW, CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r27.next(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" | ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("| ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" |", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), 0, Integer.valueOf(r26.a()), 4, null);
        goto L42
    L45:
        return r25.size();
    }

    private static final CharSequence a(XSSFTextParagraph r2) {
        String r3 = r2.getText();
        Intrinsics.checkNotNullExpressionValue(r3, "getText(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.memorydata.middleware.api.log.RunLog] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.obric.memorydata.database.util.file_utils.c] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v24, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v15, types: [com.obric.memorydata.middleware.api.log.RunLog] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v24, types: [com.obric.memorydata.middleware.api.log.RunLog] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.obric.memorydata.database.util.file_utils.BaseExcelProcessor$process$1, java.lang.Object, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v6, types: [com.obric.memorydata.database.util.file_utils.m] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object] */
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
    static /* synthetic */ Object a(c r17, FileEntity r18, Continuation<? super j> r19) {
        c r0 = r17;
        FileEntity r1 = r18;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, BaseExcelProcessor$process$1.class) == false) goto L7;
        BaseExcelProcessor$process$1 r4 = (BaseExcelProcessor$process$1) ZeusTransformUtils.preCheckCast(r2, BaseExcelProcessor$process$1.class, "com.obric.memorydata.plugin");
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
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r5.L$1, Closeable.class, "com.obric.memorydata.plugin");
        r5 = (String) ZeusTransformUtils.preCheckCast(r5.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L15
        r5 = r5;
    L40:
        j r9 = (j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L50
        ?? r10 = r5;
    L53:
        Object r11 = Result.m1421constructorimpl(r9);     // Catch: Throwable -> L22
        ?? r12 = r10;
    L62:
        ?? r13 = r12;
        Throwable r14 = Result.m1424exceptionOrNullimpl(r11);
        if (r14 == null) goto L86;
        if (ZeusTransformUtils.instanceOf(r14, NotOfficeXmlFileException.class) == false) goto L69;
        IRunLog r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r16 = new StringBuilder();
        String r20 = "File is not a valid Office XML file: ";
    L67:
        IRunLog.a.a(r15, r13, r16.append(r20).append(r14.getMessage()).toString(), null, 4, null);
    L82:
        if (AppContext.INSTANCE.isDebug() == false) goto L86;
        throw r14;
    L69:
        if (ZeusTransformUtils.instanceOf(r14, IllegalArgumentException.class) == false) goto L72;
        r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r16 = new StringBuilder();
        r20 = "Doubao Assistant is not started, unable to obtain permission: ";
        goto L67
    L72:
        if (ZeusTransformUtils.instanceOf(r14, RecordFormatException.class) == false) goto L75;
        RunLog.INSTANCE.warn(r13, "POI memory limit exceeded : " + r14.getMessage() + " (" + ExceptionsKt.stackTraceToString(r14) + ')', r14);
        goto L82
    L75:
        if (ZeusTransformUtils.instanceOf(r14, POIXMLException.class) == false) goto L78;
        r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r16 = new StringBuilder();
        r20 = "POI ZIP stream error (possibly closed): ";
        goto L67
    L78:
        if (ZeusTransformUtils.instanceOf(r14, OutOfMemoryError.class) == false) goto L80;
        RunLog.INSTANCE.error(r13, "OOM while use " + r13 + " parser. The file may be too large or corrupt.", r14);
        System.gc();
        return null;
    L80:
        RunLog.INSTANCE.error(r13, "File access failed", r14);
    L86:
        if (Result.m1427isFailureimpl(r11) == false) goto L89;
        return null;
    L89:
        return r11;
    L22:
        th = th;
    L61:
        Result.Companion r21 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        r12 = r10;
    L15:
        th = th;
    L16:
        Throwable r22 = th;
        throw r22;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        CloseableKt.closeFinally(r8, r22);     // Catch: Throwable -> L50
        throw th;     // Catch: Throwable -> L50
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r10 = (String) ZeusTransformUtils.preCheckCast(r5.L$2, String.class, "com.obric.memorydata.plugin");
        FileEntity r23 = (FileEntity) ZeusTransformUtils.preCheckCast(r5.L$1, FileEntity.class, "com.obric.memorydata.plugin");
        c r24 = (c) ZeusTransformUtils.preCheckCast(r5.L$0, c.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L22
        r1 = r23;
        ?? r25 = r24;
        ?? r26 = r10;
    L90:
        UriFileAccessSession r27 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r3, UriFileAccessSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        if (r27 == null) goto L52;
        AssetFileDescriptor r28 = r27.getFd();     // Catch: Throwable -> L55
        if (r28 == null) goto L52;
        Closeable r29 = (Closeable) ZeusTransformUtils.preCheckCast(r28, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        FileInputStream r30 = ((AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r29, AssetFileDescriptor.class, "com.obric.memorydata.plugin")).createInputStream();     // Catch: Throwable -> L43
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type java.io.FileInputStream");     // Catch: Throwable -> L43
        r5.L$0 = r26;     // Catch: Throwable -> L43
        r5.L$1 = r29;     // Catch: Throwable -> L43
        r5.L$2 = null;     // Catch: Throwable -> L43
        r5.label = 2;     // Catch: Throwable -> L43
        Object r31 = r25.a(r30, r1, r5);     // Catch: Throwable -> L43
        if (r31 != r6) goto L39;
        return r6;
    L39:
        r8 = r29;
        r5 = r26;
        r3 = r31;
    L43:
        th = th;
        r8 = r29;
        r5 = r26;
    L52:
        r10 = r26;
        r9 = null;
    L55:
        th = th;
        r10 = r26;
        goto L61
    L24:
        ResultKt.throwOnFailure(r3);
        String r32 = r17.a();
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L59
        if (r17.g() == false) goto L58;
        Continuation r34 = (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        ?? r35 = m.f9660a;     // Catch: Throwable -> L59
        r5.L$0 = r0;     // Catch: Throwable -> L59
        r5.L$1 = r1;     // Catch: Throwable -> L59
        r5.L$2 = r32;     // Catch: Throwable -> L59
        r5.label = 1;     // Catch: Throwable -> L59
        Object r36 = r35.a(r1, r5);     // Catch: Throwable -> L59
        if (r36 != r6) goto L30;
        return r6;
    L30:
        r26 = r32;
        r3 = r36;
        r25 = r0;
        goto L90
    L58:
        throw new RuntimeException(r32 + " pre-check failed!");     // Catch: Throwable -> L59
    L59:
        th = th;
        r10 = r32;
    L50:
        th = th;
        r10 = r5;
    L7:
        r5 = new BaseExcelProcessor$process$1(r0, r2);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v20, types: [com.obric.memorydata.database.util.file_utils.BaseExcelProcessor$fromStream$1] */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r12v6, types: [com.obric.memorydata.database.util.file_utils.c] */
    /* JADX WARN: Type inference failed for: r17v1, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.obric.memorydata.database.util.file_utils.BaseExcelProcessor$fromStream$1] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.obric.capabilitykit.entity.app.FileEntity] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00dd -> B:33:0x016c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0155 -> B:31:0x015c). Please report as a decompilation issue!!! */
    static /* synthetic */ Object a(c r19, FileInputStream r20, FileEntity r21, Continuation<? super j> r22) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, BaseExcelProcessor$fromStream$1.class) == false) goto L7;
        BaseExcelProcessor$fromStream$1 r2 = (BaseExcelProcessor$fromStream$1) ZeusTransformUtils.preCheckCast(r0, BaseExcelProcessor$fromStream$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
        c r3 = r19;
        ?? r4 = r2;
    L8:
        Object r1 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        int r7 = 1;
        if (r6 == 0) goto L19;
        if (r6 != 1) goto L18;
        int r8 = r4.I$1;
        int r9 = r4.I$0;
        h r10 = (h) ZeusTransformUtils.preCheckCast(r4.L$6, h.class, "com.obric.memorydata.plugin");
        Sheet r11 = (Sheet) ZeusTransformUtils.preCheckCast(r4.L$5, Sheet.class, "com.obric.memorydata.plugin");
        Workbook r12 = (Workbook) ZeusTransformUtils.preCheckCast(r4.L$4, Workbook.class, "com.obric.memorydata.plugin");
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r4.L$3, Closeable.class, "com.obric.memorydata.plugin");
        j r14 = (j) ZeusTransformUtils.preCheckCast(r4.L$2, j.class, "com.obric.memorydata.plugin");
        FileEntity r15 = (FileEntity) ZeusTransformUtils.preCheckCast(r4.L$1, FileEntity.class, "com.obric.memorydata.plugin");
        c r16 = (c) ZeusTransformUtils.preCheckCast(r4.L$0, c.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L14
        ?? r17 = r4;
        r15 = r15;
    L31:
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L14
        r16.b(r11, r14, r10.a());     // Catch: Throwable -> L14
        ?? r18 = r17;
        int r23 = r8;
        j r24 = r14;
        FileEntity r25 = r15;
        r3 = r16;
        int r26 = 1;
    L33:
        r23 = r23 + r26;
        r7 = r26;
        ?? r27 = r18;
        FileEntity r28 = r25;
    L23:
        if (r23 < r9) goto L66;
        Unit r29 = Unit.INSTANCE;     // Catch: Throwable -> L42
        r5 = null;
        CloseableKt.closeFinally(r13, null);     // Catch: Exception -> L52 OLE2NotOfficeXmlFileException -> L54
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r24.c(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L63;
        return r24;
    L63:
        return r5;
    L42:
        th = th;
        r5 = null;
        FileEntity r30 = r28;
    L46:
        Throwable r31 = th;
        r4 = r30;
    L70:
        throw r31;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        CloseableKt.closeFinally(r13, r31);     // Catch: Exception -> L52 OLE2NotOfficeXmlFileException -> L54
        throw th;     // Catch: Exception -> L52 OLE2NotOfficeXmlFileException -> L54
    L66:
        Sheet r110 = r12.getSheetAt(r23);     // Catch: Throwable -> L34
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L34
        if (r3.a(r110) == false) goto L27;
        RunLog.INSTANCE.debug(r3.a(), "No content detected, skipping sheet: " + r110.getSheetName());     // Catch: Throwable -> L34
        r26 = r7;
        r18 = r27;
        r25 = r28;
        goto L33
    L27:
        h r32 = j.a(r24, NodeType.TITLE, "Sheet: " + r110.getSheetName(), 2, null, 8, null);     // Catch: Throwable -> L34
        r3.a(r110, r24, r32.a());     // Catch: Throwable -> L34
        int r111 = r32.a();     // Catch: Throwable -> L34
        r27.L$0 = r3;     // Catch: Throwable -> L34
        r27.L$1 = r28;     // Catch: Throwable -> L34
        r27.L$2 = r24;     // Catch: Throwable -> L34
        r27.L$3 = r13;     // Catch: Throwable -> L34
        r27.L$4 = r12;     // Catch: Throwable -> L34
        r27.L$5 = r110;     // Catch: Throwable -> L34
        r27.L$6 = r32;     // Catch: Throwable -> L34
        r27.I$0 = r9;     // Catch: Throwable -> L34
        r27.I$1 = r23;     // Catch: Throwable -> L34
        r27.label = 1;     // Catch: Throwable -> L34
        if (r3.a(r110, r24, r111, r28, r27) != r5) goto L30;
        return r5;
    L30:
        r15 = r28;
        r16 = r3;
        r14 = r24;
        r8 = r23;
        r17 = r27;
        r10 = r32;
        r11 = r110;
    L34:
        th = move-exception;
        r31 = th;
        FileEntity r33 = r28;
    L16:
        r5 = null;
        r4 = r33;
    L14:
        th = move-exception;
        r31 = th;
        r33 = r15;
        r3 = r16;
        goto L16
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r1);
        j r34 = new j();
        r13 = (Closeable) ZeusTransformUtils.preCheckCast(r19.a(r20), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L56 OLE2NotOfficeXmlFileException -> L59
        Workbook r35 = (Workbook) ZeusTransformUtils.preCheckCast(r13, Workbook.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        int r36 = Math.min(r35.getNumberOfSheets(), 200);     // Catch: Throwable -> L44
        r19.d();     // Catch: Throwable -> L44
        r23 = 0;
        r12 = r35;
        r9 = r36;
        r24 = r34;
        r27 = r4;
        r28 = r21;
    L44:
        th = th;
        r5 = null;
        r30 = r21;
        goto L46
    L59:
        e = e;
        r5 = null;
        r4 = r21;
    L61:
        RunLog.INSTANCE.warn(r3.a(), "Processing failed - File format mismatch: File '" + r4.getFileName() + "' has .xlsx extension but is actually OLE2 format (.xls). Please check file format or use correct extension.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L56:
        e = e;
        r5 = null;
    L58:
        RunLog.INSTANCE.error(r3.a(), "Processing failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L54:
        e = e;
    L52:
        e = e;
    L7:
        r3 = r19;
        r4 = new BaseExcelProcessor$fromStream$1(r3, r0);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0162 -> B:35:0x016a). Please report as a decompilation issue!!! */
    static /* synthetic */ Object a(c r18, Sheet r19, j r20, int r21, FileEntity r22, Continuation<? super Unit> r23) {
        Sheet r0 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r19, Sheet.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, BaseExcelProcessor$processSheetImages$1.class) == false) goto L7;
        BaseExcelProcessor$processSheetImages$1 r3 = (BaseExcelProcessor$processSheetImages$1) ZeusTransformUtils.preCheckCast(r2, BaseExcelProcessor$processSheetImages$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
        c r4 = r18;
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
        c r12 = (c) ZeusTransformUtils.preCheckCast(r3.L$0, c.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        Object r15 = r6;
        Iterator r14 = r9;
        int r13 = r1;
        BaseExcelProcessor$processSheetImages$1 r16 = r3;
        FileEntity r17 = r10;
        j r24 = r11;
    L35:
        ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        int r25 = r8;
        r4 = r12;
    L27:
        if (r14.hasNext() == false) goto L37;
        Object r26 = r14.next();
        int r110 = r13 + 1;
        if (r13 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        Pair r27 = (Pair) ZeusTransformUtils.preCheckCast(r26, Pair.class, "com.obric.memorydata.plugin");
        byte[] r28 = (byte[]) ZeusTransformUtils.preCheckCast(r27.component1(), byte[].class, "com.obric.memorydata.plugin");
        String r29 = (String) ZeusTransformUtils.preCheckCast(r27.component2(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r28);
        Intrinsics.checkNotNull(r29);
        i r111 = new i(r29, null, r13, 2, null);
        r16.L$0 = r4;
        r16.L$1 = r24;
        r16.L$2 = r17;
        r16.L$3 = r14;
        r16.I$0 = r25;
        r16.I$1 = r110;
        r16.label = 1;
        Iterator r112 = r14;
        Object r30 = r15;
        Object r31 = r4.a(r28, r111, r24, r25, r17, true, r16);
        if (r31 != r30) goto L34;
        return r30;
    L34:
        r12 = r4;
        r15 = r30;
        r13 = r110;
        r14 = r112;
        r8 = r25;
        r5 = r31;
        goto L35
    L37:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        if (ZeusTransformUtils.instanceOf(r0, XSSFSheet.class) == false) goto L17;
        XSSFSheet r32 = (XSSFSheet) ZeusTransformUtils.preCheckCast(r0, XSSFSheet.class, "com.obric.memorydata.plugin");
    L18:
        if (r32 == null) goto L20;
        XSSFDrawing r33 = r32.getDrawingPatriarch();
        if (r33 == null) goto L24;
        List r34 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<XSSFShape> r35 = r33.getShapes();
        Intrinsics.checkNotNullExpressionValue(r35, "getShapes(...)");
        Sequence r36 = SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r35, Iterable.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(BaseExcelProcessor$processSheetImages$suspendImpl$$inlined$filterIsInstance$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        r14 = SequencesKt.mapNotNull(r36, $$Lambda$c$ynV6qO3mx5bcmDbjzAHeJlXTfI0.INSTANCE).iterator();
        r16 = r3;
        r15 = r6;
        r24 = r20;
        r17 = r22;
        r13 = 0;
        r25 = r21;
        goto L27
    L24:
        return Unit.INSTANCE;
    L20:
        return Unit.INSTANCE;
    L17:
        r32 = null;
    L7:
        r4 = r18;
        r3 = new BaseExcelProcessor$processSheetImages$1(r4, r2);
        goto L8
    }

    private static final Pair a(XSSFPicture r2) {
        Intrinsics.checkNotNullParameter(r2, "pic");
        XSSFPictureData r3 = r2.getPictureData();
        if (r3 != null) goto L7;
        return null;
    L7:
        return new Pair(r3.getData(), r3.suggestFileExtension());
    }

    private final Sequence<XSSFShape> a(XSSFDrawing r2) {
        return SequencesKt.sequence((Function2) ZeusTransformUtils.preCheckCast(new BaseExcelProcessor$getAllXSSFShapes$1(r2, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    private final void a(XSSFShape r12, j r13, int r14) {
    L25:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), a(), "Failed to process " + r12.getClass().getSimpleName() + ": " + e.getMessage(), null, 4, null);
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(r12, XSSFSimpleShape.class) == true) goto L6;
        return;
    L6:
        String r2 = "";
        if (ZeusTransformUtils.instanceOf(r12, XSSFTextBox.class) == false) goto L13;
        String r1 = ((XSSFTextBox) ZeusTransformUtils.preCheckCast(r12, XSSFTextBox.class, "com.obric.memorydata.plugin")).getText();     // Catch: Exception -> L25
        if (r1 == null) goto L18;
    L11:
        r2 = r1;
    L18:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L21;
        r2 = null;
    L21:
        String r5 = r2;
        if (r5 == null) goto L31;
        j.a(r13, NodeType.TEXT, r5, r14, null, 8, null);     // Catch: Exception -> L25
        return;
    L31:
        return;
    L13:
        if (((XSSFSimpleShape) ZeusTransformUtils.preCheckCast(r12, XSSFSimpleShape.class, "com.obric.memorydata.plugin")).getTextParagraphs() == null) goto L15;
        List<XSSFTextParagraph> r3 = ((XSSFSimpleShape) ZeusTransformUtils.preCheckCast(r12, XSSFSimpleShape.class, "com.obric.memorydata.plugin")).getTextParagraphs();     // Catch: Exception -> L25
        Intrinsics.checkNotNullExpressionValue(r3, "getTextParagraphs(...)");     // Catch: Exception -> L25
        r2 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$c$uD7SxyO2AluDcGlcFEnEpjHzus.INSTANCE, 30, null);     // Catch: Exception -> L25
        goto L18
    L15:
        r1 = ((XSSFSimpleShape) ZeusTransformUtils.preCheckCast(r12, XSSFSimpleShape.class, "com.obric.memorydata.plugin")).getText();     // Catch: Exception -> L25
        if (r1 != null) goto L11;
        goto L11
    }

    private final boolean a(String r2) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L12:
        return true;
    L5:
        if (Intrinsics.areEqual(r2, " ") == true) goto L12;
        if (Intrinsics.areEqual(r2, "\u200b") == true) goto L12;
        if (Intrinsics.areEqual(r2, "\ufeff") == true) goto L12;
        return false;
    }

    private final boolean a(CellRangeAddress r6, List<defpackage.f> r7) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r5.iterator();
    L9:
        if (r8.hasNext() == false) goto L21;
        defpackage.f r9 = (defpackage.f) ZeusTransformUtils.preCheckCast(r8.next(), defpackage.f.class, "com.obric.memorydata.plugin");
        if (r9.a().getFirstRow() <= r6.getFirstRow()) goto L13;
    L19:
        boolean r10 = false;
    L20:
        if (r10 == false) goto L9;
        return true;
    L13:
        if (r9.a().getLastRow() < r6.getLastRow()) goto L19;
        if (r9.a().getFirstColumn() > r6.getFirstColumn()) goto L19;
        if (r9.a().getLastColumn() < r6.getLastColumn()) goto L19;
        r10 = true;
    L21:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private static final CharSequence b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast("---", CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final boolean b(Sheet r7) {
        Sheet r6 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r7, Sheet.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, XSSFSheet.class) == false) goto L8;
        if (((XSSFSheet) ZeusTransformUtils.preCheckCast(r6, XSSFSheet.class, "com.obric.memorydata.plugin")).getDrawingPatriarch() == null) goto L8;
        return true;
    L8:
        if (ZeusTransformUtils.instanceOf(r6, HSSFSheet.class) == false) goto L13;
        if (((HSSFSheet) ZeusTransformUtils.preCheckCast(r6, HSSFSheet.class, "com.obric.memorydata.plugin")).getDrawingPatriarch() == null) goto L13;
        return true;
    L13:
        if (r6.getNumMergedRegions() <= 0) goto L15;
        return true;
    L15:
        Iterator<Row> r8 = r6.iterator();
        Intrinsics.checkNotNullExpressionValue(r8, "iterator(...)");
    L17:
        if (r8.hasNext() == false) goto L25;
        Iterator<Cell> r3 = ((Row) ZeusTransformUtils.preCheckCast(r8.next(), Row.class, "com.obric.memorydata.plugin")).iterator();
        Intrinsics.checkNotNullExpressionValue(r3, "iterator(...)");
    L20:
        if (r3.hasNext() == false) goto L17;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((Cell) ZeusTransformUtils.preCheckCast(r3.next(), Cell.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L20;
        return true;
    L25:
        if (ZeusTransformUtils.instanceOf(r6, XSSFSheet.class) == false) goto L32;
        XSSFDrawing r9 = ((XSSFSheet) ZeusTransformUtils.preCheckCast(r6, XSSFSheet.class, "com.obric.memorydata.plugin")).getDrawingPatriarch();
        if (r9 == null) goto L41;
        List<XSSFShape> r10 = r9.getShapes();
        if (r10 != null) goto L43;
        return false;
    L43:
        return !((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
    L41:
        return false;
    L32:
        if (ZeusTransformUtils.instanceOf(r6, HSSFSheet.class) == false) goto L44;
        HSSFPatriarch r11 = ((HSSFSheet) ZeusTransformUtils.preCheckCast(r6, HSSFSheet.class, "com.obric.memorydata.plugin")).getDrawingPatriarch();
        if (r11 != null) goto L36;
        return false;
    L36:
        return r11.containsChart();
    L44:
        return false;
    }

    public static /* synthetic */ CharSequence lambda$jugQ9H_94ejjHFaoieDl1oCh_I4(String r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$uD7SxyO2AluDcGlcFEnEpjHzu-s, reason: not valid java name */
    public static /* synthetic */ CharSequence m577lambda$uD7SxyO2AluDcGlcFEnEpjHzus(XSSFTextParagraph r0) {
        return a(r0);
    }

    public static /* synthetic */ Pair lambda$ynV6qO3mx5bcmDbjzAHeJlXTfI0(XSSFPicture r0) {
        return a(r0);
    }

    public int a(Sheet r7, j r8, int r9) {
        Sheet r10 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r7, Sheet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "sheet");
        Intrinsics.checkNotNullParameter(r8, "tree");
        e.a r0 = defpackage.e.f16366a.a(r10);
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L8;
        CellRangeAddress r4 = (CellRangeAddress) ZeusTransformUtils.preCheckCast(r2.next(), CellRangeAddress.class, "com.obric.memorydata.plugin");
        if (a(r4, r0.a()) == true) goto L4;
        r3 = r3 + a(r10, r8, r9, r4);
        goto L4
    L8:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        r3 = r3 + a(r10, r8, r9, (defpackage.f) ZeusTransformUtils.preCheckCast(r1.next(), defpackage.f.class, "com.obric.memorydata.plugin"));
        goto L10
    L12:
        return r3;
    }

    @Override // com.obric.memorydata.database.util.file_utils.b, com.obric.memorydata.database.util.file_utils.o
    public Object a(FileEntity r3, Continuation<? super j> r4) {
        return a(this, r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public Object a(FileInputStream r3, FileEntity r4, Continuation<? super j> r5) {
        return a(this, r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public Object a(Sheet r9, j r10, int r11, FileEntity r12, Continuation<? super Unit> r13) {
        return a(this, (Sheet) ZeusTransformUtils.wrapperContextForParams(r9, Sheet.class, "com.obric.memorydata.plugin"), r10, r11, r12, (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.util.file_utils.b
    public abstract String a();

    public String a(Cell r9) {
        Cell r10 = (Cell) ZeusTransformUtils.wrapperContextForParams(r9, Cell.class, "com.obric.memorydata.plugin");
        String r0 = "";
        if (r10 != null) goto L5;
        return "";
    L5:
        CellType r2 = r10.getCellType();
        int r3 = -1;
        if (r2 != null) goto L8;
        int r4 = -1;
    L9:
        boolean r5 = true;
        if (r4 == 1) goto L46;
        if (r4 != 2) goto L14;
        String r6 = r10.getStringCellValue();
        Intrinsics.checkNotNull(r6);
        if (a(r6) == true) goto L53;
        r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L53:
        if (r10.getCellType() == CellType.BLANK) goto L64;
        int r7 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L58;
        r5 = false;
    L58:
        if (r5 == false) goto L64;
        RunLog r8 = RunLog.INSTANCE;
        String r11 = a();
        StringBuilder r12 = new StringBuilder().append("Converted to empty: [").append(r10.getCellType()).append("] '").append(r10).append("' (");
        String r13 = r10.getStringCellValue();
        Intrinsics.checkNotNull(r13);
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r14.length()), Collection.class, "com.obric.memorydata.plugin");
    L61:
        if (r7 >= r14.length()) goto L63;
        String r16 = Integer.toString(r14.charAt(r7), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(r16, "toString(...)");
        r15.add(r16);
        r7 = r7 + 1;
        goto L61
    L63:
        r8.debug(r11, r12.append((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin")).append(')').toString());
    L64:
        return r0;
    L14:
        if (r4 == 3) goto L53;
        String r17 = null;
        if (r4 == 4) goto L65;
        String r18 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10.toString(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L20;
        r17 = r18;
    L20:
        if (r17 == null) goto L53;
    L22:
        r0 = r17;
        goto L53
    L65:
        CellType r19 = r10.getCachedFormulaResultType();     // Catch: Exception -> L40
        if (r19 == null) goto L27;
        r3 = b.f9640a[r19.ordinal()];     // Catch: Exception -> L40
    L27:
        if (r3 == 1) goto L38;
        if (r3 == 2) goto L34;
        String r20 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10.toString(), CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Exception -> L40
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L32;
        r17 = r20;
    L32:
        if (r17 != null) goto L22;
    L34:
        String r21 = r10.getStringCellValue();     // Catch: Exception -> L40
        Intrinsics.checkNotNull(r21);     // Catch: Exception -> L40
        if (a(r21) == true) goto L53;
        r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Exception -> L40
        goto L53
    L38:
        r0 = String.valueOf(r10.getNumericCellValue());     // Catch: Exception -> L40
    L40:
        r0 = "[Formula Error]";
        goto L53
    L46:
        if (DateUtil.isCellDateFormatted(r10) == false) goto L51;
        LocalDateTime r1 = r10.getLocalDateTimeCellValue();
        if (r1 == null) goto L51;
        r0 = r1.toString();
        if (r0 != null) goto L53;
    L51:
        r0 = String.valueOf(r10.getNumericCellValue());
        goto L53
    L8:
        r4 = b.f9640a[r2.ordinal()];
        goto L9
    }

    public abstract Workbook a(FileInputStream r1);

    public boolean a(Sheet r3) {
        Sheet r4 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r3, Sheet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "sheet");
        if (r4.getPhysicalNumberOfRows() == 0) goto L5;
        return false;
    L5:
        if (b(r4) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public void b(Sheet r10, j r11, int r12) {
        Sheet r13 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r10, Sheet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "sheet");
        Intrinsics.checkNotNullParameter(r11, "tree");
        if (ZeusTransformUtils.instanceOf(r13, XSSFSheet.class) == false) goto L11;
        XSSFDrawing r14 = ((XSSFSheet) ZeusTransformUtils.preCheckCast(r13, XSSFSheet.class, "com.obric.memorydata.plugin")).getDrawingPatriarch();
        if (r14 == null) goto L32;
        Iterator<XSSFShape> r15 = a(r14).iterator();
    L8:
        if (r15.hasNext() == false) goto L48;
        a((XSSFShape) ZeusTransformUtils.preCheckCast(r15.next(), XSSFShape.class, "com.obric.memorydata.plugin"), r11, r12);
        goto L8
    L48:
        return;
    L32:
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r13, HSSFSheet.class) == false) goto L45;
        HSSFPatriarch r9 = ((HSSFSheet) ZeusTransformUtils.preCheckCast(r13, HSSFSheet.class, "com.obric.memorydata.plugin")).getDrawingPatriarch();
        if (r9 == null) goto L46;
        List<HSSFShape> r16 = r9.getChildren();
        if (r16 == null) goto L47;
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r17.hasNext() == false) goto L49;
        HSSFShape r18 = (HSSFShape) ZeusTransformUtils.preCheckCast(r17.next(), HSSFShape.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r18, HSSFTextbox.class) == false) goto L18;
        HSSFRichTextString r19 = ((HSSFTextbox) ZeusTransformUtils.preCheckCast(r18, HSSFTextbox.class, "com.obric.memorydata.plugin")).getString();
        if (r19 == null) goto L18;
        String r110 = r19.getString();
        if (r110 == null) goto L18;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r110, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L29;
        r110 = null;
    L29:
        String r4 = r110;
        if (r4 == null) goto L18;
        j.a(r11, NodeType.TEXT, r4, r12, null, 8, null);
        goto L18
    L49:
        return;
    L47:
        return;
    L46:
        return;
    }

    public final boolean g() {
        ZeusTransformUtils.forName("com.ctc.wstx.stax.WstxInputFactory", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L5
        ZeusTransformUtils.forName("javax.xml.stream.XMLStreamReader", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L5
        return true;
    L5:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), a(), "StAX not available: " + e.getMessage(), null, 4, null);
        return false;
    }
}
