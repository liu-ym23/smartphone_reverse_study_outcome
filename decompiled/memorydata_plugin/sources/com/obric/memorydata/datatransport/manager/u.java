package com.obric.memorydata.datatransport.manager;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.datatransport.utils.RoomToExcelExporter;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportStatisticsAggregator;", "", "<init>", "()V", "categories", "", "Lcom/obric/memorydata/datatransport/manager/ExportStatisticsAggregator$Category;", "build", "Lcom/obric/memorydata/datatransport/manager/ExportResult;", "tableResults", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$TableExportResult;", "attachmentResult", "Lcom/obric/memorydata/datatransport/utils/EntityFileExporter$AttachmentExportResult;", "file", "Ljava/io/File;", "progressStatistics", "Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;", "Category", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f9798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<a> f9799b = null;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportStatisticsAggregator$Category;", "", "labelRes", "", "tableName", "", "groupValue", "excludedGroupValues", "", "databaseScope", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$DatabaseScope;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$DatabaseScope;)V", "getLabelRes", "()I", "getTableName", "()Ljava/lang/String;", "getGroupValue", "getExcludedGroupValues", "()Ljava/util/Set;", "getDatabaseScope", "()Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$DatabaseScope;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9801b;
        private final String c;
        private final Set<String> d;
        private final RoomToExcelExporter.DatabaseScope e;

        public a(int r3, String r4, String r5, Set<String> r6, RoomToExcelExporter.DatabaseScope r7) {
            Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "tableName");
            Intrinsics.checkNotNullParameter(r8, "excludedGroupValues");
            this.f9800a = r3;
            this.f9801b = r4;
            this.c = r5;
            this.d = r8;
            this.e = r7;
        }

        public /* synthetic */ a(int r8, String r9, String r10, Set r11, RoomToExcelExporter.DatabaseScope r12, int r13, DefaultConstructorMarker r14) {
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

        public final int a() {
            return this.f9800a;
        }

        public final String b() {
            return this.f9801b;
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
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f9800a == r6.f9800a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9801b, r6.f9801b) == true) goto L15;
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
            int r0 = ((Integer.hashCode(this.f9800a) * 31) + this.f9801b.hashCode()) * 31;
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
            return "Category(labelRes=" + this.f9800a + ", tableName=" + this.f9801b + ", groupValue=" + this.c + ", excludedGroupValues=" + this.d + ", databaseScope=" + this.e + ')';
        }
    }

    static {
        f9798a = new u();
        Set r15 = null;
        RoomToExcelExporter.DatabaseScope r16 = null;
        DefaultConstructorMarker r18 = null;
        String r14 = null;
        int r17 = 28;
        String r19 = null;
        int r110 = 28;
        f9799b = CollectionsKt.listOf(new a[]{new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_contacts, TypedValues.Custom.S_STRING, "data_transport_export_stat_contacts"), "RawContactEntity", null, null, null, 28, null), new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_photos, TypedValues.Custom.S_STRING, "data_transport_export_stat_photos"), "RawPhotoEntity", "PHOTO", r15, r16, 24, r18), new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_call_history, TypedValues.Custom.S_STRING, "data_transport_export_stat_call_history"), "RawCallHistoryEntity", r14, r15, r16, r17, r18), new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_messages, TypedValues.Custom.S_STRING, "data_transport_export_stat_messages"), "RawMessageEntity", r14, r15, r16, r17, r18), new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_recordings, TypedValues.Custom.S_STRING, "data_transport_export_stat_recordings"), "RawRecordingEntity", r14, r15, r16, r17, r18), new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_calendar, TypedValues.Custom.S_STRING, "data_transport_export_stat_calendar"), "RawScheduleEntity", r14, r15, r16, r17, r18), new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_notes, TypedValues.Custom.S_STRING, "data_transport_export_stat_notes"), "RawNoteEntity", r14, r15, r16, r17, r18), new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_files, TypedValues.Custom.S_STRING, "data_transport_export_stat_files"), "RawFileEntity", r14, r15, r16, r17, r18), new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_alarms, TypedValues.Custom.S_STRING, "data_transport_export_stat_alarms"), "RawAlarmEntity", r14, r15, r16, r17, r18), new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_timers, TypedValues.Custom.S_STRING, "data_transport_export_stat_timers"), "RawCountdownEntity", r14, r15, r16, r17, r18), new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_videos, TypedValues.Custom.S_STRING, "data_transport_export_stat_videos"), "RawPhotoEntity", "VIDEO", r15, r16, 24, r18), new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_albums, TypedValues.Custom.S_STRING, "data_transport_export_stat_albums"), "RawAlbumEntity", r19, r15, r16, r110, r18), new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_memory, TypedValues.Custom.S_STRING, "data_transport_export_stat_memory"), "ShortMemory", r19, r15, r16, r110, r18), new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_personal_info, TypedValues.Custom.S_STRING, "data_transport_export_stat_personal_info"), "UnionSemanticMemory", r19, SetsKt.setOf("1004"), RoomToExcelExporter.DatabaseScope.PERSONAL, 4, r18), new a(ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_memory_tasks, TypedValues.Custom.S_STRING, "data_transport_export_stat_memory_tasks"), "AutoMemoryPro", r19, null, null, 28, r18)});
    }

    private u() {
    }

    public final s a(List<RoomToExcelExporter.e> r18, com.obric.memorydata.datatransport.utils.e.a r19, File r20, q r21) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "tableResults");
        Intrinsics.checkNotNullParameter(r19, "attachmentResult");
        Intrinsics.checkNotNullParameter(r20, "file");
        Intrinsics.checkNotNullParameter(r21, "progressStatistics");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Object r6 = r3.next();
        if (((RoomToExcelExporter.e) ZeusTransformUtils.preCheckCast(r6, RoomToExcelExporter.e.class, "com.obric.memorydata.plugin")).d() != null) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == false) goto L4;
        r5.add(r6);
        goto L4
    L8:
        r7 = false;
        goto L9
    L11:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r9 = r4.iterator();
    L13:
        if (r9.hasNext() == false) goto L18;
        Object r10 = r9.next();
        String r11 = ((RoomToExcelExporter.e) ZeusTransformUtils.preCheckCast(r10, RoomToExcelExporter.e.class, "com.obric.memorydata.plugin")).a();
        Object r12 = r8.get(r11);
        if (r12 != null) goto L17;
        r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r8.put(r11, r12);
    L17:
        ((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin")).add(r10);
        goto L13
    L18:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(f9799b, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L20:
        if (r15.hasNext() == false) goto L41;
        a r16 = (a) ZeusTransformUtils.preCheckCast(r15.next(), a.class, "com.obric.memorydata.plugin");
        int r17 = r16.a();
        List r110 = (List) ZeusTransformUtils.preCheckCast(r8.get(r16.b()), List.class, "com.obric.memorydata.plugin");
        if (r110 != null) goto L24;
        r110 = CollectionsKt.emptyList();
    L24:
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin");
        Collection r112 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r113 = r111.iterator();
    L26:
        if (r113.hasNext() == false) goto L36;
        Object r114 = r113.next();
        RoomToExcelExporter.e r115 = (RoomToExcelExporter.e) ZeusTransformUtils.preCheckCast(r114, RoomToExcelExporter.e.class, "com.obric.memorydata.plugin");
        if (r16.e() != null) goto L30;
    L33:
        boolean r22 = true;
    L34:
        if (r22 == false) goto L26;
        r112.add(r114);
        goto L26
    L30:
        if (r115.e() == r16.e()) goto L33;
        r22 = false;
        goto L34
    L36:
        long r116 = 0;
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r112, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L38:
        if (r23.hasNext() == false) goto L40;
        r116 = r116 + r.a((RoomToExcelExporter.e) ZeusTransformUtils.preCheckCast(r23.next(), RoomToExcelExporter.e.class, "com.obric.memorydata.plugin"), r16.c(), r16.d());
        goto L38
    L40:
        r14.add(new t(r17, r116));
        goto L20
    L41:
        List r24 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r26 = r1.iterator();
    L43:
        if (r26.hasNext() == false) goto L50;
        RoomToExcelExporter.e r27 = (RoomToExcelExporter.e) ZeusTransformUtils.preCheckCast(r26.next(), RoomToExcelExporter.e.class, "com.obric.memorydata.plugin");
        String r28 = r27.d();
        if (r28 == null) goto L47;
        v r29 = new v(r27.a(), r28);
    L48:
        if (r29 == null) goto L43;
        r25.add(r29);
        goto L43
    L47:
        r29 = null;
        goto L48
    L50:
        List r30 = (List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin");
        return new s(r20, r24, r19.a(), r19.b(), r30, r21);
    }
}
