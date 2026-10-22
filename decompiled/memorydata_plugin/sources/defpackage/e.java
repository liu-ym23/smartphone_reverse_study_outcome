package defpackage;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ2\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010H\u0002J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\rH\u0002J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\rH\u0002J\u0016\u0010\u0018\u001a\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020\u001b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0016\u0010!\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"LTableDetector;", "", "<init>", "()V", "MIN_CONTINUOUS_ROWS", "", "detectAllBlocks", "LTableDetector$DetectionResult;", "sheet", "Lorg/apache/poi/ss/usermodel/Sheet;", "handleBlockEnd", "", "block", "", "Lorg/apache/poi/ss/usermodel/Row;", "tables", "", "LTableRegion;", "rawBlocks", "Lorg/apache/poi/ss/util/CellRangeAddress;", "mergeRawBlocks", "blocks", "mergeOverlappingRegions", "regions", "detectHeaderRow", "rows", "isBlankRow", "", "row", "isBlankCell", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "Lorg/apache/poi/ss/usermodel/Cell;", "isContinuousBlock", "buildTableRange", "DetectionResult", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f16366a = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"LTableDetector$DetectionResult;", "", "tables", "", "LTableRegion;", "rawBlocks", "Lorg/apache/poi/ss/util/CellRangeAddress;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getTables", "()Ljava/util/List;", "getRawBlocks", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<f> f16367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<CellRangeAddress> f16368b;

        public a(List<f> r3, List<? extends CellRangeAddress> r4) {
            List<f> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<CellRangeAddress> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "tables");
            Intrinsics.checkNotNullParameter(r6, "rawBlocks");
            this.f16367a = r5;
            this.f16368b = r6;
        }

        public final List<f> a() {
            return this.f16367a;
        }

        public final List<CellRangeAddress> b() {
            return this.f16368b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f16367a, r6.f16367a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f16368b, r6.f16368b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f16367a.hashCode() * 31) + this.f16368b.hashCode();
        }

        public String toString() {
            return "DetectionResult(tables=" + this.f16367a + ", rawBlocks=" + this.f16368b + ')';
        }
    }

    static {
        f16366a = new e();
    }

    private e() {
    }

    private final List<CellRangeAddress> a(List<? extends CellRangeAddress> r9) {
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        List<CellRangeAddress> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        CellRangeAddress r1 = (CellRangeAddress) ZeusTransformUtils.preCheckCast(r11.next(), CellRangeAddress.class, "com.obric.memorydata.plugin");
        if (r10.isEmpty() == true) goto L7;
        CellRangeAddress r2 = (CellRangeAddress) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r10), CellRangeAddress.class, "com.obric.memorydata.plugin");
        if (r2.getLastRow() < (r1.getFirstRow() - 1)) goto L7;
        r10.remove(r10.size() - 1);
        r10.add(new CellRangeAddress(Math.min(r2.getFirstRow(), r1.getFirstRow()), Math.max(r2.getLastRow(), r1.getLastRow()), Math.min(r2.getFirstColumn(), r1.getFirstColumn()), Math.max(r2.getLastColumn(), r1.getLastColumn())));
    L7:
        r10.add(r1);
        goto L4
    L11:
        return r10;
    }

    private final void a(List<? extends Row> r3, List<f> r4, List<CellRangeAddress> r5) {
        List<? extends Row> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        CellRangeAddress r0 = d(r6);
        r8.add(r0);
        if (r6.size() < 3) goto L9;
        r7.add(new f(r0, c(r6)));
        return;
    }

    private final boolean a(Row r6) {
        Row r5 = (Row) ZeusTransformUtils.wrapperContextForParams(r6, Row.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r5.getLastCellNum()), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L15;
        Cell r2 = r5.getCell(((IntIterator) ZeusTransformUtils.preCheckCast(r8, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r2 == null) goto L13;
        boolean r3 = f16366a.a(r2);
    L14:
        if (r3 == true) goto L9;
        return false;
    L13:
        r3 = true;
    L15:
        return true;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final List<f> b(List<f> r10) {
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        List<f> r11 = CollectionsKt.emptyList();
        Iterator r12 = r9.iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        f r1 = (f) ZeusTransformUtils.preCheckCast(r12.next(), f.class, "com.obric.memorydata.plugin");
        if (r11.isEmpty() == true) goto L7;
        f r2 = (f) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r11), f.class, "com.obric.memorydata.plugin");
        if (r2.a().getLastRow() < (r1.a().getFirstRow() - 1)) goto L11;
        CellRangeAddress r3 = new CellRangeAddress(Math.min(r2.a().getFirstRow(), r1.a().getFirstRow()), Math.max(r2.a().getLastRow(), r1.a().getLastRow()), Math.min(r2.a().getFirstColumn(), r1.a().getFirstColumn()), Math.max(r2.a().getLastColumn(), r1.a().getLastColumn()));
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.dropLast(r11, 1), Collection.class, "com.obric.memorydata.plugin");
        r1 = new f(r3, r2.b());
    L12:
        r11 = CollectionsKt.plus(r13, r1);
        goto L4
    L11:
        r13 = (Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin");
        goto L12
    L7:
        r11 = CollectionsKt.listOf(r1);
        goto L4
    L13:
        return r11;
    }

    private final int c(List<? extends Row> r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        if (r0.size() >= 2) goto L5;
        return -1;
    L5:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.getIndices((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r2.hasNext() == true) goto L8;
        Object r5 = null;
    L108:
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L137;
        return -1;
    L137:
        return r1.intValue();
    L8:
        Object r4 = r2.next();
        if (r2.hasNext() == true) goto L11;
    L10:
        r5 = r4;
        goto L108
    L11:
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
        Row r7 = (Row) ZeusTransformUtils.preCheckCast(r0.get(r6), Row.class, "com.obric.memorydata.plugin");
        int r9 = 0;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r7.getLastCellNum()), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L14;
    L16:
        Iterator r10 = r8.iterator();
        int r11 = 0;
    L18:
        if (r10.hasNext() == false) goto L29;
        Cell r12 = r7.getCell(((IntIterator) ZeusTransformUtils.preCheckCast(r10, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r12 != null) goto L22;
    L24:
        boolean r13 = false;
    L25:
        if (r13 == false) goto L18;
        r11 = r11 + 1;
        if (r11 >= 0) goto L18;
        CollectionsKt.throwCountOverflow();
        goto L18
    L22:
        if (r12.getCellType() != CellType.STRING) goto L24;
        r13 = true;
    L29:
        float r14 = r11 / r7.getLastCellNum();
        if (r6 >= CollectionsKt.getLastIndex(r0)) goto L54;
        Row r15 = (Row) ZeusTransformUtils.preCheckCast(r0.get(r6 + 1), Row.class, "com.obric.memorydata.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, Math.min(r7.getLastCellNum(), r15.getLastCellNum())), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L34;
    L36:
        Iterator r17 = r16.iterator();
        int r19 = 0;
    L38:
        if (r17.hasNext() == false) goto L55;
        int r110 = ((IntIterator) ZeusTransformUtils.preCheckCast(r17, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        Cell r111 = r7.getCell(r110);
        if (r111 == null) goto L42;
        CellType r112 = r111.getCellType();
    L43:
        Cell r113 = r15.getCell(r110);
        if (r113 == null) goto L46;
        CellType r114 = r113.getCellType();
    L47:
        if (r112 == r114) goto L49;
        boolean r115 = true;
    L50:
        if (r115 == false) goto L38;
        r19 = r19 + 1;
        if (r19 >= 0) goto L38;
        CollectionsKt.throwCountOverflow();
        goto L38
    L49:
        r115 = false;
        goto L50
    L46:
        r114 = null;
        goto L47
    L42:
        r112 = null;
    L55:
        float r20 = (r14 * 0.7f) + (r19 * 0.3f);
    L56:
        Object r21 = r2.next();
        int r116 = ((Number) ZeusTransformUtils.preCheckCast(r21, Number.class, "com.obric.memorydata.plugin")).intValue();
        Row r117 = (Row) ZeusTransformUtils.preCheckCast(r0.get(r116), Row.class, "com.obric.memorydata.plugin");
        Iterable r118 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(r9, r117.getLastCellNum()), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r118, Collection.class) == true) goto L59;
    L61:
        Iterator r119 = r118.iterator();
        int r120 = r9;
    L63:
        if (r119.hasNext() == false) goto L75;
        Cell r3 = r117.getCell(((IntIterator) ZeusTransformUtils.preCheckCast(r119, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r3 != null) goto L67;
    L69:
        int r22 = r9;
    L70:
        if (r22 == 0) goto L63;
        r120 = r120 + 1;
        if (r120 >= 0) goto L63;
        CollectionsKt.throwCountOverflow();
        goto L63
    L67:
        if (r3.getCellType() != CellType.STRING) goto L69;
        r22 = 1;
    L75:
        float r23 = r120 / r117.getLastCellNum();
        if (r116 >= CollectionsKt.getLastIndex(r0)) goto L101;
        Row r24 = (Row) ZeusTransformUtils.preCheckCast(r0.get(r116 + 1), Row.class, "com.obric.memorydata.plugin");
        Iterable r121 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(r9, Math.min(r117.getLastCellNum(), r24.getLastCellNum())), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r121, Collection.class) == true) goto L80;
    L82:
        Iterator r122 = r121.iterator();
        int r123 = r9;
    L84:
        if (r122.hasNext() == false) goto L102;
        int r124 = ((IntIterator) ZeusTransformUtils.preCheckCast(r122, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        Cell r125 = r117.getCell(r124);
        if (r125 == null) goto L88;
        CellType r25 = r125.getCellType();
    L89:
        Cell r126 = r24.getCell(r124);
        if (r126 == null) goto L92;
        CellType r127 = r126.getCellType();
    L93:
        if (r25 == r127) goto L95;
        boolean r26 = true;
    L96:
        if (r26 == false) goto L84;
        r123 = r123 + 1;
        if (r123 >= 0) goto L84;
        CollectionsKt.throwCountOverflow();
        goto L84
    L95:
        r26 = false;
        goto L96
    L92:
        r127 = null;
        goto L93
    L88:
        r25 = null;
    L102:
        float r27 = (r23 * 0.7f) + (r123 * 0.3f);
        if (Float.compare(r20, r27) >= 0) goto L106;
        r20 = r27;
        r4 = r21;
    L106:
        if (r2.hasNext() == false) goto L10;
        r9 = 0;
        goto L56
    L80:
        if (((Collection) ZeusTransformUtils.preCheckCast(r121, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L82;
        r123 = r9;
        goto L102
    L101:
        r123 = 0;
        goto L102
    L59:
        if (((Collection) ZeusTransformUtils.preCheckCast(r118, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L61;
        r120 = r9;
        goto L75
    L34:
        if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L36;
    L54:
        r19 = 0;
        goto L55
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L16;
        r11 = 0;
        goto L29
    }

    private final CellRangeAddress d(List<? extends Row> r11) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        int r12 = ((Row) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r10), Row.class, "com.obric.memorydata.plugin")).getRowNum();
        int r1 = ((Row) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r10), Row.class, "com.obric.memorydata.plugin")).getRowNum();
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L3:
        int r4 = 0;
        if (r14.hasNext() == false) goto L15;
        Row r3 = (Row) ZeusTransformUtils.preCheckCast(r14.next(), Row.class, "com.obric.memorydata.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r3.getLastCellNum()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L14;
        Object r8 = r7.next();
        Cell r9 = r3.getCell(((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r9 == null) goto L11;
        boolean r15 = !f16366a.a(r9);
    L12:
        if (r15 == false) goto L7;
        r6.add(r8);
        goto L7
    L11:
        r15 = false;
        goto L12
    L14:
        CollectionsKt.addAll(r2, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        goto L3
    L15:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.minOrNull((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L18;
        int r18 = r17.intValue();
    L19:
        Integer r19 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.maxOrNull((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L23;
        r4 = r19.intValue();
    L23:
        return new CellRangeAddress(r12, r1, r18, r4);
    L18:
        r18 = 0;
        goto L19
    }

    public final a a(Sheet r8) {
        Sheet r9 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r8, Sheet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "sheet");
        List<f> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<CellRangeAddress> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<? extends Row> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L14;
        Row r4 = (Row) ZeusTransformUtils.preCheckCast(r10.next(), Row.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L4;
        e r5 = f16366a;
        if (r5.a(r4) == true) goto L12;
        r3.add(r4);
        goto L4
    L12:
        r5.a(r3, r0, r2);
        r3.clear();
        goto L4
    L14:
        a(r3, r0, r2);
        return new a(b(r0), a(r2));
    }

    public final boolean a(Cell r3) {
        Cell r2 = (Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        if (r2.getCellType() != CellType.BLANK) goto L5;
    L10:
        return true;
    L5:
        if (r2.getCellType() != CellType.STRING) goto L9;
        String r4 = r2.getStringCellValue();
        Intrinsics.checkNotNullExpressionValue(r4, "getStringCellValue(...)");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L10;
    L9:
        return false;
    }
}
