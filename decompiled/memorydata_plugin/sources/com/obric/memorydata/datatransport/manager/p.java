package com.obric.memorydata.datatransport.manager;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.datatransport.utils.RoomToExcelExporter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportProgressAccumulator;", "", "<init>", "()V", "rows", "Ljava/util/LinkedHashMap;", "Lcom/obric/memorydata/datatransport/manager/ExportStatisticsCategory;", "Lcom/obric/memorydata/datatransport/manager/ExportCategoryProgress;", "Lkotlin/collections/LinkedHashMap;", "recordAttachment", "", EventBody.KEY_CATEGORY, "succeeded", "", "failureReason", "Lcom/obric/memorydata/datatransport/manager/ExportFailureReason;", "recordTable", "result", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$TableExportResult;", "snapshot", "Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;", "TableMapping", "Companion", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f9788a = null;
    private static final List<b> c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashMap<ExportStatisticsCategory, k> f9789b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportProgressAccumulator$Companion;", "", "<init>", "()V", "tableMappings", "", "Lcom/obric/memorydata/datatransport/manager/ExportProgressAccumulator$TableMapping;", "getTableMappings", "()Ljava/util/List;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportProgressAccumulator$TableMapping;", "", EventBody.KEY_CATEGORY, "Lcom/obric/memorydata/datatransport/manager/ExportStatisticsCategory;", "tableName", "", "groupValue", "excludedGroupValues", "", "databaseScope", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$DatabaseScope;", "<init>", "(Lcom/obric/memorydata/datatransport/manager/ExportStatisticsCategory;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$DatabaseScope;)V", "getCategory", "()Lcom/obric/memorydata/datatransport/manager/ExportStatisticsCategory;", "getTableName", "()Ljava/lang/String;", "getGroupValue", "getExcludedGroupValues", "()Ljava/util/Set;", "getDatabaseScope", "()Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$DatabaseScope;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExportStatisticsCategory f9790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9791b;
        private final String c;
        private final Set<String> d;
        private final RoomToExcelExporter.DatabaseScope e;

        public b(ExportStatisticsCategory r3, String r4, String r5, Set<String> r6, RoomToExcelExporter.DatabaseScope r7) {
            Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, EventBody.KEY_CATEGORY);
            Intrinsics.checkNotNullParameter(r4, "tableName");
            Intrinsics.checkNotNullParameter(r8, "excludedGroupValues");
            this.f9790a = r3;
            this.f9791b = r4;
            this.c = r5;
            this.d = r8;
            this.e = r7;
        }

        public /* synthetic */ b(ExportStatisticsCategory r8, String r9, String r10, Set r11, RoomToExcelExporter.DatabaseScope r12, int r13, DefaultConstructorMarker r14) {
            Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
            if ((r13 & 4) == 0) goto L5;
            String r4 = null;
        L7:
            if ((r13 & 8) == 0) goto L9;
            r15 = SetsKt.emptySet();
        L9:
            Set r5 = r15;
            if ((r13 & 16) == 0) goto L12;
            RoomToExcelExporter.DatabaseScope r6 = null;
        L13:
            this(r8, r9, r4, r5, r6);
            return;
        L12:
            r6 = r12;
            goto L13
        L5:
            r4 = r10;
            goto L7
        }

        public final ExportStatisticsCategory a() {
            return this.f9790a;
        }

        public final String b() {
            return this.f9791b;
        }

        public final String c() {
            return this.c;
        }

        public final Set<String> d() {
            return this.d;
        }

        public final RoomToExcelExporter.DatabaseScope e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f9790a == r6.f9790a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9791b, r6.f9791b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f9790a.hashCode() * 31) + this.f9791b.hashCode()) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.d.hashCode()) * 31;
            RoomToExcelExporter.DatabaseScope r5 = this.e;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "TableMapping(category=" + this.f9790a + ", tableName=" + this.f9791b + ", groupValue=" + this.c + ", excludedGroupValues=" + this.d + ", databaseScope=" + this.e + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f9788a = new a(null);
        Set r7 = null;
        int r9 = 28;
        DefaultConstructorMarker r10 = null;
        String r6 = null;
        int r11 = 28;
        c = CollectionsKt.listOf(new b[]{new b(ExportStatisticsCategory.CONTACTS, "RawContactEntity", null, null, null, 28, null), new b(ExportStatisticsCategory.PHOTOS, "RawPhotoEntity", "PHOTO", null, null, 24, null), new b(ExportStatisticsCategory.CALL_HISTORY, "RawCallHistoryEntity", 0 == true ? 1 : 0, r7, 0 == true ? 1 : 0, r9, r10), new b(ExportStatisticsCategory.MESSAGES, "RawMessageEntity", 0 == true ? 1 : 0, r7, 0 == true ? 1 : 0, r9, r10), new b(ExportStatisticsCategory.RECORDINGS, "RawRecordingEntity", 0 == true ? 1 : 0, r7, 0 == true ? 1 : 0, r9, r10), new b(ExportStatisticsCategory.CALENDAR, "RawScheduleEntity", 0 == true ? 1 : 0, r7, 0 == true ? 1 : 0, r9, r10), new b(ExportStatisticsCategory.NOTES, "RawNoteEntity", 0 == true ? 1 : 0, r7, 0 == true ? 1 : 0, r9, r10), new b(ExportStatisticsCategory.FILES, "RawFileEntity", 0 == true ? 1 : 0, r7, 0 == true ? 1 : 0, r9, r10), new b(ExportStatisticsCategory.ALARMS, "RawAlarmEntity", 0 == true ? 1 : 0, r7, 0 == true ? 1 : 0, r9, r10), new b(ExportStatisticsCategory.TIMERS, "RawCountdownEntity", 0 == true ? 1 : 0, r7, 0 == true ? 1 : 0, r9, r10), new b(ExportStatisticsCategory.VIDEOS, "RawPhotoEntity", "VIDEO", r7, 0 == true ? 1 : 0, 24, r10), new b(ExportStatisticsCategory.ALBUMS, "RawAlbumEntity", r6, r7, 0 == true ? 1 : 0, r11, r10), new b(ExportStatisticsCategory.MEMORY, "ShortMemory", r6, r7, 0 == true ? 1 : 0, r11, r10), new b(ExportStatisticsCategory.PERSONAL_INFO, "UnionSemanticMemory", r6, SetsKt.setOf("1004"), RoomToExcelExporter.DatabaseScope.PERSONAL, 4, r10), new b(ExportStatisticsCategory.MEMORY_TASKS, "AutoMemoryPro", r6, null, null, 28, r10)});
    }

    public p() {
        LinkedHashMap<ExportStatisticsCategory, k> r0 = new LinkedHashMap();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(ExportStatisticsCategory.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ExportStatisticsCategory r2 = (ExportStatisticsCategory) ZeusTransformUtils.preCheckCast(r1.next(), ExportStatisticsCategory.class, "com.obric.memorydata.plugin");
        r0.put(r2, new k(r2, 0, 0, 0, null, 30, null));
        goto L4
    L6:
        this.f9789b = r0;
    }

    public final synchronized q a() {
        monitor-enter(this);
        Collection<k> r1 = this.f9789b.values();     // Catch: Throwable -> L6
        Intrinsics.checkNotNullExpressionValue(r1, "<get-values>(...)");     // Catch: Throwable -> L6
        q r0 = new q(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(ExportStatisticsCategory r17, boolean r18, ExportFailureReason r19) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r17, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L18
        k r3 = (k) ZeusTransformUtils.preCheckCast(MapsKt.getValue((Map) ZeusTransformUtils.preCheckCast(this.f9789b, Map.class, "com.obric.memorydata.plugin"), r17), k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(this.f9789b, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r18 == false) goto L7;
        k r4 = k.a(r3, null, r3.b() + 1, r3.c() + 1, 0, null, 25, null);     // Catch: Throwable -> L18
    L15:
        r2.put(r17, r4);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L7:
        if (r19 != null) goto L9;
        ExportFailureReason r6 = ExportFailureReason.UNKNOWN;     // Catch: Throwable -> L18
    L10:
        long r8 = r3.b() + 1;     // Catch: Throwable -> L18
        long r12 = r3.d() + 1;     // Catch: Throwable -> L18
        Map<ExportFailureReason, Long> r14 = r3.e();     // Catch: Throwable -> L18
        Long r10 = (Long) ZeusTransformUtils.preCheckCast(r3.e().get(r6), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r10 == null) goto L13;
        long r11 = r10.longValue();     // Catch: Throwable -> L18
    L14:
        r4 = k.a(r3, null, r8, 0, r12, MapsKt.plus(r14, TuplesKt.to(r6, Long.valueOf(r11 + 1))), 5, null);     // Catch: Throwable -> L18
        goto L15
    L13:
        r11 = 0;
        goto L14
    L9:
        r6 = r19;
    L18:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(RoomToExcelExporter.e r21) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r21, "result");     // Catch: Throwable -> L44
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L44
    L6:
        if (r4.hasNext() == false) goto L10;
        Object r5 = r4.next();     // Catch: Throwable -> L44
        if (Intrinsics.areEqual(((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin")).b(), r21.a()) == false) goto L6;
        r3.add(r5);     // Catch: Throwable -> L44
        goto L6
    L10:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        Iterator r9 = r7.iterator();     // Catch: Throwable -> L44
    L11:
        boolean r10 = true;
        if (r9.hasNext() == false) goto L21;
        Object r11 = r9.next();     // Catch: Throwable -> L44
        b r12 = (b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (r12.e() != null) goto L16;
    L19:
        if (r10 == false) goto L11;
        r8.add(r11);     // Catch: Throwable -> L44
        goto L11
    L16:
        if (r12.e() == r21.e()) goto L19;
        r10 = false;
        goto L19
    L21:
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (r13.isEmpty() == true) goto L25;
    L29:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L44
    L30:
        if (r14.hasNext() == false) goto L42;
        b r15 = (b) ZeusTransformUtils.preCheckCast(r14.next(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        k r16 = (k) ZeusTransformUtils.preCheckCast(MapsKt.getValue((Map) ZeusTransformUtils.preCheckCast(this.f9789b, Map.class, "com.obric.memorydata.plugin"), r15.a()), k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (r21.d() != null) goto L36;
        long r17 = r.a(r21, r15.c(), r15.d());     // Catch: Throwable -> L44
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(this.f9789b, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        ExportStatisticsCategory r19 = r15.a();     // Catch: Throwable -> L44
        k r20 = k.a(r16, null, r16.b() + r17, r16.c() + r17, 0, null, 25, null);     // Catch: Throwable -> L44
    L35:
        r18.put(r19, r20);     // Catch: Throwable -> L44
        goto L30
    L36:
        r18 = (Map) ZeusTransformUtils.preCheckCast(this.f9789b, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        r19 = r15.a();     // Catch: Throwable -> L44
        long r22 = r16.b() + 1;     // Catch: Throwable -> L44
        long r110 = r16.d() + 1;     // Catch: Throwable -> L44
        Map<ExportFailureReason, Long> r111 = r16.e();     // Catch: Throwable -> L44
        ExportFailureReason r112 = ExportFailureReason.QUERY_FAILED;     // Catch: Throwable -> L44
        Long r23 = (Long) ZeusTransformUtils.preCheckCast(r16.e().get(ExportFailureReason.QUERY_FAILED), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (r23 == null) goto L39;
        long r24 = r23.longValue();     // Catch: Throwable -> L44
    L40:
        r20 = k.a(r16, null, r22, 0, r110, MapsKt.plus(r111, TuplesKt.to(r112, Long.valueOf(r24 + 1))), 5, null);     // Catch: Throwable -> L44
        goto L35
    L39:
        r24 = 0;
        goto L40
    L42:
        monitor-exit(this);
        return;
    L25:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L28;
        monitor-exit(this);
        return;
    L28:
        r13 = CollectionsKt.listOf(new b(ExportStatisticsCategory.OTHER_DATABASE_TABLES, r21.a(), null, null, null, 28, null));     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }
}
