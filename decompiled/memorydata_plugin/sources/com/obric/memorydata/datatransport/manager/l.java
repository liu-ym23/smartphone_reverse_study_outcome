package com.obric.memorydata.datatransport.manager;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.RoomDatabase;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.datatransport.impl.DataTransportManagerImpl;
import com.obric.memorydata.datatransport.utils.RoomToExcelExporter;
import com.obric.memorydata.memory.api.MemoryEntityManagerApi;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0002JKB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000f\u001a\u00020\u0010J)\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016\"\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0017J0\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0!H\u0002J.\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0!H\u0002J\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050&H\u0002J$\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010*\u001a\u00020+2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0!H\u0002J\u000e\u0010,\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\rH\u0002J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u000200H\u0002J\b\u00103\u001a\u00020\rH\u0002J\u0010\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u0005H\u0002J\u0010\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\u0005H\u0002J$\u00108\u001a\u0002092\u0006\u0010*\u001a\u00020+2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0!H\u0082@¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012H\u0002J\u000e\u0010>\u001a\b\u0012\u0004\u0012\u00020?0(H\u0002J\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020A0(H\u0082@¢\u0006\u0002\u0010-J\u000e\u0010B\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010-J)\u0010C\u001a\u00020\r2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00122\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010HJ\u0010\u0010I\u001a\u00020\r2\u0006\u0010*\u001a\u00020+H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportDataManager;", "", "<init>", "()V", "baseDir", "Ljava/io/File;", "getBaseDir", "()Ljava/io/File;", "shareDir", "getShareDir", "callback", "Lcom/obric/memorydata/datatransport/manager/ExportDataManager$ProgressCallback;", "setProgressCallback", "", com.tom_roush.pdfbox.pdmodel.a.d.f.c, "isExporting", "", TypedValues.Custom.S_STRING, "", "resId", "", "args", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "export", "Lcom/obric/memorydata/datatransport/manager/ExportResult;", "password", "taskId", "ownerUserId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performZipDirectly", "destFile", "ensureOwner", "Lkotlin/Function0;", "performZipAndEncrypt", "tempZipFile", "finalFile", "getExportSources", "", "exportDb", "", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$TableExportResult;", "statistics", "Lcom/obric/memorydata/datatransport/manager/ExportProgressAccumulator;", "importToDb", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearExportTables", "mergeImportResults", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$ImportResult;", "globalResult", "userResult", "clearLastExportData", "deleteFile", "file", "createNoMediaFile", "dir", "exportEntityFiles", "Lcom/obric/memorydata/datatransport/utils/EntityFileExporter$AttachmentExportResult;", "(Lcom/obric/memorydata/datatransport/manager/ExportProgressAccumulator;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attachmentCategoryForTable", "Lcom/obric/memorydata/datatransport/manager/ExportStatisticsCategory;", "tableName", "fetchEntityList", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "fetchShortMemoryEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "cleanOldData", "reportExportProgress", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/obric/memorydata/datatransport/manager/DataExportPhase;", "message", "percent", "(Lcom/obric/memorydata/datatransport/manager/DataExportPhase;Ljava/lang/String;Ljava/lang/Integer;)V", "reportLiveStatistics", "Companion", "ProgressCallback", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9781a = null;
    private static final Set<String> c = null;
    private static final Set<String> d = null;
    private static final Map<String, String> e = null;
    private static final kotlinx.coroutines.sync.a f = null;
    private static final AtomicBoolean g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile b f9782b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportDataManager$Companion;", "", "<init>", "()V", "TAG", "", "GLOBAL_IMPORT_TABLE_LIST", "", "USER_IMPORT_TABLE_LIST", "STATISTIC_GROUP_BY_COLUMNS", "", "exportFileOperationMutex", "Lkotlinx/coroutines/sync/Mutex;", "exportingFlag", "Ljava/util/concurrent/atomic/AtomicBoolean;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportDataManager$ProgressCallback;", "", "onProgress", "", "message", "", "exporting", "", "onExportProgress", "progress", "Lcom/obric/memorydata/datatransport/manager/ExportProgress;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface b {
        void a(o r1);

        void a(String r1, boolean r2);
    }

    static {
        f9781a = new a(null);
        c = SetsKt.setOf(new String[]{"RawContactEntity", "RawCallHistoryEntity", "RawMessageEntity", "RawNoteEntity", "RawScheduleEntity", "RawAlarmEntity", "RawCountdownEntity", "RawMemoryEntity"});
        d = SetsKt.setOf("ShortMemory");
        e = MapsKt.mapOf(new Pair[]{TuplesKt.to("RawPhotoEntity", "assetType"), TuplesKt.to("UnionSemanticMemory", "product_type")});
        f = kotlinx.coroutines.sync.c.a(false, 1, null);
        g = new AtomicBoolean(false);
    }

    public l() {
    }

    private final RoomToExcelExporter.c a(RoomToExcelExporter.c r9, RoomToExcelExporter.c r10) {
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new RoomToExcelExporter.c[]{r9, r10}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        Iterator<Map.Entry<String, Integer>> r3 = ((RoomToExcelExporter.c) ZeusTransformUtils.preCheckCast(r0.next(), RoomToExcelExporter.c.class, "com.obric.memorydata.plugin")).a().entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r4.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r8.get(r5), Integer.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L11;
        int r11 = r7.intValue();
    L12:
        r8.put(r5, Integer.valueOf(r11 + r6));
        goto L7
    L11:
        r11 = 0;
        goto L12
    L14:
        return new RoomToExcelExporter.c(r8, MapsKt.plus(r9.b(), r10.b()));
    }

    public static final /* synthetic */ Object a(l r2, p r3, Function0 r4, Continuation r5) {
        return r2.a(r3, (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [T, com.obric.memorydata.datatransport.utils.e$a] */
    /* JADX WARN: Type inference failed for: r0v48, types: [T, com.obric.memorydata.datatransport.utils.e$a] */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, com.obric.memorydata.datatransport.utils.e$a] */
    /* JADX WARN: Type inference failed for: r1v18, types: [T, com.obric.memorydata.datatransport.utils.e$a] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0328 -> B:51:0x03e3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x03b1 -> B:50:0x03c3). Please report as a decompilation issue!!! */
    private final Object a(p r32, Function0<Unit> r33, Continuation<? super com.obric.memorydata.datatransport.utils.e.a> r34) {
        Class<l> r1 = l.class;
        final Function0 r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r33, Function0.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r34, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ExportDataManager$exportEntityFiles$1.class) == false) goto L7;
        ExportDataManager$exportEntityFiles$1 r5 = (ExportDataManager$exportEntityFiles$1) ZeusTransformUtils.preCheckCast(r4, ExportDataManager$exportEntityFiles$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        String r9 = TypedValues.Custom.S_STRING;
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        int r0 = r5.I$2;
        int r3 = r5.I$1;
        int r10 = r5.I$0;
        Ref.ObjectRef r14 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$12, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datatransport.utils.e.a r11 = (com.obric.memorydata.datatransport.utils.e.a) ZeusTransformUtils.preCheckCast(r5.L$11, com.obric.memorydata.datatransport.utils.e.a.class, "com.obric.memorydata.plugin");
        Iterator r12 = (Iterator) ZeusTransformUtils.preCheckCast(r5.L$10, Iterator.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.preCheckCast(r5.L$9, List.class, "com.obric.memorydata.plugin");
        ExportStatisticsCategory r15 = (ExportStatisticsCategory) ZeusTransformUtils.preCheckCast(r5.L$8, ExportStatisticsCategory.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao r16 = (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5.L$7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        Iterator r17 = (Iterator) ZeusTransformUtils.preCheckCast(r5.L$6, Iterator.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r18 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$5, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datatransport.utils.e r20 = (com.obric.memorydata.datatransport.utils.e) ZeusTransformUtils.preCheckCast(r5.L$4, com.obric.memorydata.datatransport.utils.e.class, "com.obric.memorydata.plugin");
        List r21 = (List) ZeusTransformUtils.preCheckCast(r5.L$3, List.class, "com.obric.memorydata.plugin");
        Function0 r19 = (Function0) ZeusTransformUtils.preCheckCast(r5.L$2, Function0.class, "com.obric.memorydata.plugin");
        p r22 = (p) ZeusTransformUtils.preCheckCast(r5.L$1, p.class, "com.obric.memorydata.plugin");
        l r110 = (l) ZeusTransformUtils.preCheckCast(r5.L$0, r1, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        l r24 = r110;
        ExportStatisticsCategory r111 = r15;
        Iterator r112 = r12;
        int r23 = r10;
        ExportDataManager$exportEntityFiles$1 r25 = r5;
        Function0 r26 = r19;
        Class<l> r27 = r1;
        int r35 = r0;
        p r31 = r22;
        Ref.ObjectRef r28 = r14;
        IAppEntityRawDbDao r113 = r16;
        Ref.ObjectRef r114 = r18;
        String r115 = TypedValues.Custom.S_STRING;
        Iterator r29 = r17;
    L50:
        r28.element = r11.a((com.obric.memorydata.datatransport.utils.e.a) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.datatransport.utils.e.a.class, "com.obric.memorydata.plugin"));
        p r210 = r31;
        int r30 = r3;
        Object r211 = r7;
        ExportDataManager$exportEntityFiles$1 r116 = r25;
        int r212 = r23;
        ExportStatisticsCategory r213 = r111;
        l r36 = r24;
        int r37 = r35;
        List r214 = r13;
        Ref.ObjectRef r117 = r114;
        Function0 r118 = r26;
    L51:
        String r38 = r115;
        l r39 = r36;
        a(r39, DataExportPhase.EXPORTING, r36.a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_table_exporting_progress, r38, "data_transport_data_export_table_exporting_progress"), new Object[]{r113.getTableName(), Boxing.boxInt(r37), Boxing.boxInt(r214.size())}), null, 4, null);
        r115 = r38;
        r26 = r118;
        r25 = r116;
        r29 = r29;
        Iterator r119 = r112;
        IAppEntityRawDbDao r40 = r113;
        r114 = r117;
        com.obric.memorydata.datatransport.utils.e r120 = r20;
        List r41 = r21;
        r1 = r27;
        List r121 = r214;
        ExportStatisticsCategory r122 = r213;
        p r123 = r210;
        Object r215 = r211;
        int r216 = r212;
        int r42 = r30;
    L31:
        if (r119.hasNext() == false) goto L52;
        Object r43 = r119.next();
        Iterator r310 = r119;
        int r124 = r42 + 1;
        if (r42 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        r35 = r42;
        com.obric.memorydata.database.entity.d r44 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r43, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L38
        l r46 = (l) ZeusTransformUtils.preCheckCast(r39, r1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        Object r47 = Result.m1421constructorimpl(r44.convertToAppEntity());     // Catch: Throwable -> L38
    L41:
        if (Result.m1427isFailureimpl(r47) == false) goto L43;
        r47 = null;
    L43:
        AppEntity r48 = (AppEntity) ZeusTransformUtils.preCheckCast(r47, AppEntity.class, "com.obric.memorydata.plugin");
        if (r48 != null) goto L46;
        r123.a(r122, false, ExportFailureReason.CONVERSION_FAILED);
        r27 = r1;
        List r217 = r121;
        int r125 = 1;
        r114.element = ((com.obric.memorydata.datatransport.utils.e.a) ZeusTransformUtils.preCheckCast(r114.element, com.obric.memorydata.datatransport.utils.e.a.class, "com.obric.memorydata.plugin")).a(new com.obric.memorydata.datatransport.utils.e.a(0, r125, r125, null));
        r39.a(r123);
        r112 = r310;
        r37 = r35;
        r30 = r124;
        r36 = r39;
        r118 = r26;
        r213 = r122;
        r210 = r123;
        r211 = r215;
        r212 = r216;
        r214 = r217;
        r21 = r41;
        r113 = r40;
        r20 = r120;
        r117 = r114;
        r116 = r25;
        goto L51
    L46:
        r27 = r1;
        com.obric.memorydata.datatransport.utils.e.a r49 = (com.obric.memorydata.datatransport.utils.e.a) ZeusTransformUtils.preCheckCast(r114.element, com.obric.memorydata.datatransport.utils.e.a.class, "com.obric.memorydata.plugin");
        r25.L$0 = r39;
        r25.L$1 = r123;
        r25.L$2 = r26;
        r25.L$3 = r41;
        r25.L$4 = r120;
        r25.L$5 = r114;
        r25.L$6 = r29;
        r25.L$7 = r40;
        r25.L$8 = r122;
        r13 = r121;
        r25.L$9 = r13;
        r112 = r310;
        r25.L$10 = r112;
        r25.L$11 = r49;
        r25.L$12 = r114;
        r25.I$0 = r216;
        r25.I$1 = r124;
        r25.I$2 = r35;
        r25.label = 1;
        Object r50 = r120.a(r48, r25);
        Object r51 = r215;
        if (r50 != r51) goto L49;
        return r51;
    L49:
        r24 = r39;
        r20 = r120;
        r31 = r123;
        r6 = r50;
        r11 = r49;
        r28 = r114;
        r111 = r122;
        r3 = r124;
        r113 = r40;
        r23 = r216;
        r21 = r41;
        r7 = r51;
    L38:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        r47 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L41
    L52:
        l r53 = r39;
        Function0 r54 = r26;
        List r55 = r41;
        ExportDataManager$exportEntityFiles$1 r56 = r25;
        com.obric.memorydata.datatransport.utils.e r57 = r120;
        Ref.ObjectRef r126 = r114;
        final p r127 = r123;
        int r58 = r216;
        Object r59 = r215;
        Iterator r128 = r29;
        r9 = r115;
        r1 = r1;
    L16:
        if (r128.hasNext() == false) goto L54;
        Object r129 = r128.next();
        int r130 = r58 + 1;
        if (r58 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        IAppEntityRawDbDao r131 = (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r129, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        r54.invoke();
        Function0 r311 = r54;
        RunLog.INSTANCE.debug("ExportData", "start export <" + r131.getTableName() + "> entity files, progress: " + r130 + '/' + r55.size());
        List r312 = r55;
        a(r53, DataExportPhase.EXPORTING, r53.a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_table_exporting, r9, "data_transport_data_export_table_exporting"), new Object[]{r131.getTableName()}), null, 4, null);
        ExportStatisticsCategory r60 = r53.b(r131.getTableName());
        Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L23
        l r62 = (l) ZeusTransformUtils.preCheckCast(r53, r1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Object r63 = Result.m1421constructorimpl(r131.queryAll());     // Catch: Throwable -> L23
    L25:
        Throwable r64 = Result.m1424exceptionOrNullimpl(r63);
        if (r64 != null) goto L28;
        ExportDataManager$exportEntityFiles$1 r132 = r56;
        r215 = r59;
        List r65 = (List) ZeusTransformUtils.preCheckCast(r63, List.class, "com.obric.memorydata.plugin");
        r41 = r312;
        r123 = r127;
        r216 = r130;
        r25 = r132;
        r122 = r60;
        r115 = r9;
        r120 = r57;
        r29 = r128;
        r40 = r131;
        r121 = r65;
        r39 = r53;
        r114 = r126;
        r42 = 0;
        r119 = ((Iterable) ZeusTransformUtils.preCheckCast(r65, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r26 = r311;
        goto L31
    L28:
        ExportDataManager$exportEntityFiles$1 r133 = r56;
        r215 = r59;
        RunLog.INSTANCE.error("ExportData", "query attachment entities failed: " + r131.getTableName(), r64);
        r127.a(r60, false, ExportFailureReason.QUERY_FAILED);
        int r134 = 1;
        r126.element = ((com.obric.memorydata.datatransport.utils.e.a) ZeusTransformUtils.preCheckCast(r126.element, com.obric.memorydata.datatransport.utils.e.a.class, "com.obric.memorydata.plugin")).a(new com.obric.memorydata.datatransport.utils.e.a(0, r134, r134, null));
        r53.a(r127);
        List r66 = (List) ZeusTransformUtils.preCheckCast(CollectionsKt.emptyList(), List.class, "com.obric.memorydata.plugin");
        r41 = r312;
        r123 = r127;
        r216 = r130;
        r25 = r133;
        r122 = r60;
        r115 = r9;
        r120 = r57;
        r29 = r128;
        r40 = r131;
        r121 = r66;
        r39 = r53;
        r114 = r126;
        r42 = 0;
        r119 = ((Iterable) ZeusTransformUtils.preCheckCast(r66, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r26 = r311;
    L23:
        th = move-exception;
        Result.Companion r67 = Result.Companion;
        r63 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    L54:
        return r126.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        List r68 = CollectionsKt.listOf(new IAppEntityRawDbDao[]{MemoryDbEngine.INSTANCE.getGlobalDbEngine().getContactRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMessageRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAlbumRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoFaceRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRecordingRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getFileRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao()});
        r127 = r32;
        com.obric.memorydata.datatransport.utils.e r69 = new com.obric.memorydata.datatransport.utils.e(b(), new $$Lambda$l$7eXlifwybhKMuPAMFVYzundocc(r127, this), new $$Lambda$l$tLp7AwnDWXL8Mv1ZHl5yXeZOk(this, r2));
        Ref.ObjectRef r70 = new Ref.ObjectRef();
        r70.element = com.obric.memorydata.datatransport.utils.e.a.f9837a.a();
        r128 = ((Iterable) ZeusTransformUtils.preCheckCast(r68, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r126 = r70;
        r57 = r69;
        r59 = r7;
        r56 = r5;
        r55 = r68;
        r54 = r2;
        r53 = this;
        r58 = 0;
    L7:
        r5 = new ExportDataManager$exportEntityFiles$1(this, r4);
        goto L8
    }

    private final String a(int r3, Object... r4) {
        if (r4.length != 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r3);
    L10:
        Intrinsics.checkNotNull(r5);
        return r5;
    L9:
        r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r3, Arrays.copyOf(r4, r4.length));
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    private final List<RoomToExcelExporter.e> a(final p r22, Function0<Unit> r23) {
        final Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r23, Function0.class, "com.obric.memorydata.plugin");
        a(this, DataExportPhase.EXPORTING, a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_database_exporting, TypedValues.Custom.S_STRING, "data_transport_data_export_database_exporting"), new Object[0]), null, 4, null);
        RunLog.INSTANCE.debug("ExportData", "start export database");
        RoomToExcelExporter r10 = RoomToExcelExporter.f9813a;
        RoomDatabase r11 = (RoomDatabase) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine(), RoomDatabase.class, "com.obric.memorydata.plugin");
        RoomToExcelExporter.DatabaseScope r13 = RoomToExcelExporter.DatabaseScope.GLOBAL;
        Map<String, String> r18 = e;
        RoomToExcelExporter.b r0 = r10.a(r11, "memory_database_global", r13, r18, new $$Lambda$l$AWXo_ZGp7v9STbPpn6xQAQJxJYk(r22, this), new $$Lambda$l$uGxAsjVK8idGvb0KIzOpu8bjD8(this, r9));
        RoomToExcelExporter.b r2 = RoomToExcelExporter.f9813a.a((RoomDatabase) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine(), RoomDatabase.class, "com.obric.memorydata.plugin"), "memory_database_user", RoomToExcelExporter.DatabaseScope.PERSONAL, r18, new $$Lambda$l$DLWYTonoMdHJP3KJI4b5MOurBqA(r22, this), new $$Lambda$l$EWDDFRH72EQDnOgugOleI5WU2uk(this, r9));
        RunLog.INSTANCE.debug("ExportData", "end export database");
        return CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r0.a(), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r2.a(), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit a(p r1, l r2, RoomToExcelExporter.e r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r1.a(r3);
        r2.a(r1);
        return Unit.INSTANCE;
    }

    private static final Unit a(p r2, l r3, com.obric.memorydata.datatransport.utils.a r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        r2.a(r4.a(), r4.b(), r4.c());
        r3.a(r2);
        return Unit.INSTANCE;
    }

    private static final Unit a(Function0 r3, l r4, long r5, long r7) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin")).invoke();
        if (r7 <= 0) goto L5;
        int r6 = (int) ((r5 * ((long) 100)) / r7);
    L6:
        r4.a(DataExportPhase.ZIPPING, r4.a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_zipping_progress, TypedValues.Custom.S_STRING, "data_transport_data_export_zipping_progress"), new Object[]{Integer.valueOf(r6)}), Integer.valueOf(r6));
        return Unit.INSTANCE;
    L5:
        r6 = 0;
        goto L6
    }

    private final void a(DataExportPhase r9, String r10, Integer r11) {
        b r8 = this.f9782b;
        if (r8 == null) goto L6;
        r8.a(new o(r9, r10, r11, null, 8, null));
        return;
    }

    static /* synthetic */ void a(l r0, DataExportPhase r1, String r2, Integer r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    private final void a(p r10) {
        b r0 = this.f9782b;
        if (r0 == null) goto L6;
        r0.a(new o(DataExportPhase.EXPORTING, a(ZeusTransformUtils.mapRes(R.string.data_transport_export_statistics_running, TypedValues.Custom.S_STRING, "data_transport_export_statistics_running"), new Object[0]), null, r10.a(), 4, null));
        return;
    }

    private final void a(File r11, File r12, String r13, Function0<Unit> r14) {
        final Function0 r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
        Map<String, File> r0 = d();     // Catch: Throwable -> L8
        com.obric.memorydata.datatransport.utils.j.f9845a.a(r0, r11, new $$Lambda$l$fwGJEozwevLGJm3eaoeV4fLMdF4(r15, this));     // Catch: Throwable -> L8
        a(this, DataExportPhase.ENCRYPTING, a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_encrypting, TypedValues.Custom.S_STRING, "data_transport_data_export_encrypting"), new Object[0]), null, 4, null);     // Catch: Throwable -> L8
        com.obric.memorydata.datatransport.utils.j.f9845a.a(r11, r12, r13, new $$Lambda$l$CQTDhSK3Ihhlj8HF1O3mT3n64I(r15, this));     // Catch: Throwable -> L8
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "All Data Exported.", false, 4, null);     // Catch: Throwable -> L8
        if (r11.exists() == false) goto L15;
        r11.delete();
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (r11.exists() == false) goto L12;
        r11.delete();
    L12:
        throw th;
    }

    private final void a(File r4, Function0<Unit> r5) {
        final Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Map<String, File> r0 = d();
        com.obric.memorydata.datatransport.utils.j.f9845a.a(r0, r4, new $$Lambda$l$qPM1kdEABEhBBuzd5hgXsvoYvIY(r6, this));
        RunLog.INSTANCE.debug("ExportData", "All Data Exported.");
    }

    public static final /* synthetic */ void a(String r0) {
        c(r0);
    }

    private static final boolean a(l r2, Function0 r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        r4.invoke();     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r6) == false) goto L11;
        r6 = false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final boolean a(File r9) {
        if (r9.exists() == true) goto L14;
        return true;
    L14:
    L10:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "rm -rf failed for " + r9.getAbsolutePath() + ": " + e.getMessage(), null, 4, null);
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "delete file by rm failed: " + r9.getAbsolutePath(), false, 4, null);
        return FilesKt.deleteRecursively(r9);
    L6:
        if (Runtime.getRuntime().exec(new String[]{"rm", "-rf", r9.getAbsolutePath()}).waitFor() != 0) goto L12;
        if (r9.exists() == true) goto L12;
        return true;
    }

    private static final boolean a(File r3, String r4) {
        Intrinsics.checkNotNull(r4);
        if (StringsKt.startsWith$default(r4, "MemoryData_Export_", false, 2, null) == true) goto L5;
        return false;
    L5:
        if (StringsKt.endsWith$default(r4, ".zip", false, 2, null) == false) goto L7;
    L12:
        return true;
    L7:
        if (StringsKt.endsWith$default(r4, ".zip.enc", false, 2, null) == true) goto L12;
        if (StringsKt.endsWith$default(r4, ".partial", false, 2, null) == true) goto L12;
        if (StringsKt.endsWith$default(r4, "_temp.zip", false, 2, null) == true) goto L12;
        return false;
    }

    private final ExportStatisticsCategory b(String r1) {
        switch(r1.hashCode()) {
            case -2027251461: goto L39;
            case -1417415523: goto L35;
            case -882918388: goto L31;
            case -652430451: goto L27;
            case 93170594: goto L23;
            case 804820810: goto L19;
            case 1351903911: goto L17;
            case 1458491500: goto L14;
            case 1735856650: goto L10;
            case 1895849297: goto L6;
            default: goto L43;
        };
    L17:
        r1.equals("RawFileEntity");
        goto L43
    L6:
        if (r1.equals("RawAuditoryRecordingEntity") == false) goto L43;
        return ExportStatisticsCategory.AUDITORY_RECORDING;
    L10:
        if (r1.equals("RawAlbumEntity") == false) goto L43;
        return ExportStatisticsCategory.ALBUM_COVER;
    L14:
        if (r1.equals("RawMemoryEntity") == false) goto L43;
        return ExportStatisticsCategory.MEMORY_SCREENSHOT;
    L19:
        if (r1.equals("RawPhotoFaceEntity") == false) goto L43;
        return ExportStatisticsCategory.FACE_AVATAR;
    L23:
        if (r1.equals("RawMessageEntity") == false) goto L43;
        return ExportStatisticsCategory.MESSAGE_FILE;
    L27:
        if (r1.equals("RawPhotoEntity") == false) goto L43;
        return ExportStatisticsCategory.PHOTO_ORIGINAL;
    L31:
        if (r1.equals("RawRecordingEntity") == false) goto L43;
        return ExportStatisticsCategory.RECORDING_FILE;
    L35:
        if (r1.equals("RawNoteEntity") == false) goto L43;
        return ExportStatisticsCategory.NOTE_FILE;
    L39:
        if (r1.equals("RawContactEntity") == false) goto L43;
        return ExportStatisticsCategory.CONTACT_AVATAR;
    L43:
        return ExportStatisticsCategory.DOCUMENT;
    }

    private final File b() {
        return com.obric.memorydata.datatransport.api.d.f9726a.a();
    }

    private static final Unit b(p r1, l r2, RoomToExcelExporter.e r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r1.a(r3);
        r2.a(r1);
        return Unit.INSTANCE;
    }

    private static final Unit b(Function0 r3, l r4, long r5, long r7) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin")).invoke();
        if (r7 <= 0) goto L5;
        int r6 = (int) ((r5 * ((long) 100)) / r7);
    L6:
        r4.a(DataExportPhase.ZIPPING, r4.a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_zipping_progress, TypedValues.Custom.S_STRING, "data_transport_data_export_zipping_progress"), new Object[]{Integer.valueOf(r6)}), Integer.valueOf(r6));
        return Unit.INSTANCE;
    L5:
        r6 = 0;
        goto L6
    }

    private final void b(File r3) {
        File r0 = new File(r3, ".nomedia");
        if (r0.exists() == true) goto L11;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L6
        l r2 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        Result.m1421constructorimpl(Boolean.valueOf(r0.createNewFile()));     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    }

    private static final boolean b(l r2, Function0 r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        r4.invoke();     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r6) == false) goto L11;
        r6 = false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final File c() {
        return com.obric.memorydata.datatransport.api.d.f9726a.c();
    }

    private final Object c(Continuation<? super List<? extends com.obric.memorydata.database.entity.d>> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        List r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r0 = CollectionsKt.listOf(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao());
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L19;
        Object r5 = r2.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        EpisodicMemoryDao r7 = (EpisodicMemoryDao) ZeusTransformUtils.preCheckCast(r5, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("ExportData", "start export <" + r7.getTableName() + "> entity files, progress: " + r6 + '/' + r0.size());
        b r8 = this.f9782b;
        if (r8 == null) goto L11;
        r8.a(a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_table_fetching, TypedValues.Custom.S_STRING, "data_transport_data_export_table_fetching"), new Object[]{r7.getTableName()}), true);
    L11:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.queryAll(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r10 = 0;
    L13:
        if (r9.hasNext() == false) goto L18;
        Object r11 = r9.next();
        int r15 = r10 + 1;
        if (r10 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        r14.add((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r11, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin"));
        r10 = r15;
        goto L13
    L18:
        r4 = r6;
        goto L4
    L19:
        return r14;
    }

    private static final Unit c(Function0 r3, l r4, long r5, long r7) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin")).invoke();
        if (r7 <= 0) goto L5;
        int r6 = (int) ((r5 * ((long) 100)) / r7);
    L6:
        r4.a(DataExportPhase.ENCRYPTING, r4.a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_encrypting_progress, TypedValues.Custom.S_STRING, "data_transport_data_export_encrypting_progress"), new Object[]{Integer.valueOf(r6)}), Integer.valueOf(r6));
        return Unit.INSTANCE;
    L5:
        r6 = 0;
        goto L6
    }

    private static final void c(String r1) {
        if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), r1) == false) goto L6;
        return;
    L6:
        throw new CancellationException("data export account changed");
    }

    private static final boolean c(l r2, Function0 r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        r4.invoke();     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r6) == false) goto L11;
        r6 = false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final boolean c(File r4) {
        String r0 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r0, "getName(...)");
        if (StringsKt.endsWith(r0, ".xlsx", true) == true) goto L9;
        String r5 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r5, "getName(...)");
        if (StringsKt.endsWith(r5, ".zip", true) == true) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    private final Map<String, File> d() {
        Map<String, File> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r0.put("", b());
        r0.putAll(DataTransportManagerImpl.INSTANCE.getAllExportPaths());
        return r0;
    }

    private final void e() {
        RoomToExcelExporter.a(RoomToExcelExporter.f9813a, MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper().getWritableDatabase(), com.obric.memorydata.datatransport.api.a.f9723a.a(), false, 4, null);
        RoomToExcelExporter.a(RoomToExcelExporter.f9813a, MemoryDbEngine.INSTANCE.getPersonalDbEngine().getOpenHelper().getWritableDatabase(), com.obric.memorydata.datatransport.api.a.f9723a.b(), false, 4, null);
    }

    private final void f() {
        if (b().exists() == true) goto L5;
        return;
    L5:
        if (b().isDirectory() == false) goto L21;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        l r2 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r2.a(r2.b()) == false) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "delete file success: " + r2.b().getAbsolutePath(), false, 4, null);     // Catch: Throwable -> L12
    L10:
        Object r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);
        if (r4 == null) goto L22;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "delete file exception: " + b().getAbsolutePath() + ", " + r4.getMessage(), null, 4, null);
        return;
    L22:
        return;
    L9:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "delete file failed: " + r2.b().getAbsolutePath(), null, 4, null);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private final List<AppEntity> g() {
        List<AppEntity> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r1 = CollectionsKt.listOf(new IAppEntityRawDbDao[]{MemoryDbEngine.INSTANCE.getGlobalDbEngine().getContactRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCallHistoryRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMessageRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getScheduleRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAlarmRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCountdownRawDbDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao()});
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r6 = 0;
    L4:
        if (r3.hasNext() == false) goto L22;
        Object r7 = r3.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        IAppEntityRawDbDao r9 = (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("ExportData", "start export <" + r9.getTableName() + "> entity files, progress: " + r8 + '/' + r1.size());
        b r10 = this.f9782b;
        if (r10 == null) goto L11;
        r10.a(a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_table_fetching, TypedValues.Custom.S_STRING, "data_transport_data_export_table_fetching"), new Object[]{r9.getTableName()}), true);
    L11:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.queryAll(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r12 = 0;
    L13:
        if (r11.hasNext() == false) goto L21;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        AppEntity r15 = ((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r13, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        if (r15 == null) goto L20;
        r0.add(r15);
    L20:
        r12 = r14;
        goto L13
    L21:
        r6 = r8;
        goto L4
    L22:
        return r0;
    }

    /* JADX INFO: renamed from: lambda$7-eXlifwybhKMuPAMFVYzundocc, reason: not valid java name */
    public static /* synthetic */ Unit m637lambda$7eXlifwybhKMuPAMFVYzundocc(p r0, l r1, com.obric.memorydata.datatransport.utils.a r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$AWXo_ZGp7v9STbPpn6xQAQJxJYk(p r0, l r1, RoomToExcelExporter.e r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$CQTDhSK3Ihhlj8HF1O3-mT3n64I, reason: not valid java name */
    public static /* synthetic */ Unit m638lambda$CQTDhSK3Ihhlj8HF1O3mT3n64I(Function0 r0, l r1, long r2, long r4) {
        return c(r0, r1, r2, r4);
    }

    public static /* synthetic */ Unit lambda$DLWYTonoMdHJP3KJI4b5MOurBqA(p r0, l r1, RoomToExcelExporter.e r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$EWDDFRH72EQDnOgugOleI5WU2uk(l r0, Function0 r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ boolean lambda$EnhwtvAoY3XneUN8MP2UgTQo_OE(File r0) {
        return c(r0);
    }

    public static /* synthetic */ Unit lambda$fwGJEozwevLGJm3eaoeV4fLMdF4(Function0 r0, l r1, long r2, long r4) {
        return b(r0, r1, r2, r4);
    }

    public static /* synthetic */ boolean lambda$lDL51Ol77pzpFzQK6S80FC2yvgg(File r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$qPM1kdEABEhBBuzd5hgXsvoYvIY(Function0 r0, l r1, long r2, long r4) {
        return a(r0, r1, r2, r4);
    }

    /* JADX INFO: renamed from: lambda$tLp7AwnDWXL8M-v1ZHl5yXeZ-Ok, reason: not valid java name */
    public static /* synthetic */ boolean m639lambda$tLp7AwnDWXL8Mv1ZHl5yXeZOk(l r0, Function0 r1) {
        return c(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$uGxAsjVK8idGvb0KIz-Opu8bjD8, reason: not valid java name */
    public static /* synthetic */ boolean m640lambda$uGxAsjVK8idGvb0KIzOpu8bjD8(l r0, Function0 r1) {
        return a(r0, r1);
    }

    public final Object a(String r24, String r25, String r26, Continuation<? super s> r27) {
        l r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r27, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, ExportDataManager$export$1.class) == false) goto L7;
        ExportDataManager$export$1 r4 = (ExportDataManager$export$1) ZeusTransformUtils.preCheckCast(r2, ExportDataManager$export$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        List<RoomToExcelExporter.e> r1 = (List) ZeusTransformUtils.preCheckCast(r4.L$5, List.class, "com.obric.memorydata.plugin");
        p r7 = (p) ZeusTransformUtils.preCheckCast(r4.L$4, p.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r4.L$3, String.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4.L$2, String.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        l r11 = (l) ZeusTransformUtils.preCheckCast(r4.L$0, l.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L14
        List<RoomToExcelExporter.e> r12 = r1;
        r0 = r11;
        p r13 = r7;
        String r14 = r10;
        Object r15 = r3;
    L26:
        com.obric.memorydata.datatransport.utils.e.a r16 = (com.obric.memorydata.datatransport.utils.e.a) ZeusTransformUtils.preCheckCast(r15, com.obric.memorydata.datatransport.utils.e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "export createNoMediaFile", false, 4, null);     // Catch: Throwable -> L14
        r0.b(r0.b());     // Catch: Throwable -> L14
        a(r0, DataExportPhase.ZIPPING, r0.a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_zipping, TypedValues.Custom.S_STRING, "data_transport_data_export_zipping"), new Object[0]), null, 4, null);     // Catch: Throwable -> L14
        m.a r17 = m.f9783a;     // Catch: Throwable -> L14
        File r18 = r0.c();     // Catch: Throwable -> L14
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r19 != null) goto L29;
    L32:
        boolean r110 = true;
    L33:
        if (r110 == true) goto L35;
        boolean r111 = true;
    L36:
        m r20 = r17.a(r18, r9, r111);     // Catch: Throwable -> L14
        r20.f();     // Catch: Throwable -> L14
        CharSequence r112 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        if (r112 != null) goto L40;
    L43:
        boolean r113 = true;
    L44:
        if (r113 == false) goto L46;
        r0.a(r20.b(), (Function0) ZeusTransformUtils.preCheckCast(new ExportDataManager$export$exportedFile$1(r8), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L51
    L47:
        r20.e();     // Catch: Throwable -> L51
        s r21 = u.f9798a.a(r12, r16, r20.c(), r13.a());     // Catch: Throwable -> L14
        g.set(false);
        kotlinx.coroutines.sync.a.C0884a.b(f, null, 1, null);
        return r21;
    L46:
        r0.a(r20.a(), r20.b(), r14, (Function0) ZeusTransformUtils.preCheckCast(new ExportDataManager$export$exportedFile$2(r8), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L51
        goto L47
    L40:
        if (r112.length() == 0) goto L43;
        r113 = false;
    L51:
        th = move-exception;
        r20.f();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L35:
        r111 = false;
        goto L36
    L29:
        if (r19.length() == 0) goto L32;
        r110 = false;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r3);
        if (kotlinx.coroutines.sync.a.C0884a.a(f, null, 1, null) == true) goto L21;
        return null;
    L21:
        g.set(true);
        p r22 = new p();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "export start", false, 4, null);     // Catch: Throwable -> L14
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "export clearLastExportData", false, 4, null);     // Catch: Throwable -> L14
        f();     // Catch: Throwable -> L14
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "export exportDb", false, 4, null);     // Catch: Throwable -> L14
        List<RoomToExcelExporter.e> r23 = r0.a(r22, (Function0) ZeusTransformUtils.preCheckCast(new ExportDataManager$export$tableResults$1(r26), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "export exportEntityFiles", false, 4, null);     // Catch: Throwable -> L14
        Function0<Unit> r114 = (Function0) ZeusTransformUtils.preCheckCast(new ExportDataManager$export$attachmentResult$1(r26), Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        r4.L$0 = r0;     // Catch: Throwable -> L14
        r4.L$1 = r24;     // Catch: Throwable -> L14
        r4.L$2 = r25;     // Catch: Throwable -> L14
        r4.L$3 = r26;     // Catch: Throwable -> L14
        r4.L$4 = r22;     // Catch: Throwable -> L14
        r4.L$5 = r23;     // Catch: Throwable -> L14
        r4.label = 1;     // Catch: Throwable -> L14
        Object r28 = r0.a(r22, r114, r4);     // Catch: Throwable -> L14
        if (r28 != r5) goto L25;
        return r5;
    L25:
        r8 = r26;
        r15 = r28;
        r14 = r24;
        r13 = r22;
        r12 = r23;
        r9 = r25;
    L14:
        th = move-exception;
        g.set(false);
        kotlinx.coroutines.sync.a.C0884a.b(f, null, 1, null);
        throw th;
    L7:
        r4 = new ExportDataManager$export$1(r0, r2);
        goto L8
    }

    public final Object a(Continuation<? super Unit> r21) {
        l r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, ExportDataManager$importToDb$1.class) == false) goto L7;
        ExportDataManager$importToDb$1 r4 = (ExportDataManager$importToDb$1) ZeusTransformUtils.preCheckCast(r2, ExportDataManager$importToDb$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        List<AppEntity> r1 = (List) ZeusTransformUtils.preCheckCast(r4.L$1, List.class, "com.obric.memorydata.plugin");
        l r7 = (l) ZeusTransformUtils.preCheckCast(r4.L$0, l.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L35:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        r7.e();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r10 = 0;
    L37:
        if (r9.hasNext() == false) goto L49;
        Object r11 = r9.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        AppEntity r13 = (AppEntity) ZeusTransformUtils.preCheckCast(r11, AppEntity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, MemoryEntity.class) == false) goto L44;
        MemoryEntityManagerApi.INSTANCE.index((MemoryEntity) ZeusTransformUtils.preCheckCast(r13, MemoryEntity.class, "com.obric.memorydata.plugin"));
    L45:
        b r14 = r7.f9782b;
        if (r14 == null) goto L48;
        r14.a(r7.a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_donating_entity_progress, TypedValues.Custom.S_STRING, "data_transport_data_export_donating_entity_progress"), new Object[]{Boxing.boxInt(r12), Boxing.boxInt(r1.size())}), true);
    L48:
        r10 = r12;
        goto L37
    L44:
        Boxing.boxBoolean(EntityManager.INSTANCE.index(r13));
        goto L45
    L49:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L51:
        if (r15.hasNext() == false) goto L53;
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
        goto L51
    L53:
        b r16 = r7.f9782b;
        if (r16 == null) goto L60;
        r16.a(r7.a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_import_done, TypedValues.Custom.S_STRING, "data_transport_data_export_import_done"), new Object[0]), false);
    L60:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        RoomToExcelExporter.c r17 = (RoomToExcelExporter.c) ZeusTransformUtils.preCheckCast(r4.L$1, RoomToExcelExporter.c.class, "com.obric.memorydata.plugin");
        l r18 = (l) ZeusTransformUtils.preCheckCast(r4.L$0, l.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        RoomToExcelExporter.c r19 = r17;
        r0 = r18;
    L28:
        if ((!r19.b().isEmpty()) == false) goto L31;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "import error: " + r19.b(), null, 4, null);
        return Unit.INSTANCE;
    L31:
        List<AppEntity> r20 = r0.g();
        r4.L$0 = r0;
        r4.L$1 = r20;
        r4.label = 2;
        r3 = r0.c(r4);
        if (r3 != r5) goto L34;
        return r5;
    L34:
        r7 = r0;
        r1 = r20;
        goto L35
    L16:
        ResultKt.throwOnFailure(r3);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("is_instant_entity_index_switch_on", true);
        File[] r22 = new File("/data/data/com.obric.memorydata/databases").listFiles($$Lambda$l$EnhwtvAoY3XneUN8MP2UgTQo_OE.INSTANCE);
        if (r22 == null) goto L19;
        File r23 = (File) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r22), File.class, "com.obric.memorydata.plugin");
    L20:
        if (r23 == null) goto L56;
        e();
        File r110 = r23;
        r19 = r0.a(RoomToExcelExporter.a(RoomToExcelExporter.f9813a, r110, MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper().getWritableDatabase(), c, null, 8, null), RoomToExcelExporter.a(RoomToExcelExporter.f9813a, r110, MemoryDbEngine.INSTANCE.getPersonalDbEngine().getOpenHelper().getWritableDatabase(), d, null, 8, null));
        RunLog.INSTANCE.debug("ExportData", "import result: " + r19);
        b r24 = r0.f9782b;
        if (r24 == null) goto L24;
        r24.a(r0.a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_import_done_with_result, TypedValues.Custom.S_STRING, "data_transport_data_export_import_done_with_result"), new Object[]{r19}), false);
    L24:
        r4.L$0 = r0;
        r4.L$1 = r19;
        r4.label = 1;
        if (au.a(2000, r4) != r5) goto L28;
        return r5;
    L56:
        b r25 = r0.f9782b;
        if (r25 == null) goto L60;
        r25.a(r0.a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_import_failed_no_db_file, TypedValues.Custom.S_STRING, "data_transport_data_export_import_failed_no_db_file"), new Object[0]), false);
        goto L60
    L19:
        r23 = null;
    L7:
        r4 = new ExportDataManager$importToDb$1(r0, r2);
        goto L8
    }

    public final void a(b r3) {
        this.f9782b = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    public final boolean a() {
        return g.get();
    }

    public final Object b(Continuation<? super Boolean> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, ExportDataManager$cleanOldData$1.class) == false) goto L7;
        ExportDataManager$cleanOldData$1 r1 = (ExportDataManager$cleanOldData$1) ZeusTransformUtils.preCheckCast(r16, ExportDataManager$cleanOldData$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        int r5 = 0;
        if (r4 == 0) goto L16;
        if (r4 != 1) goto L15;
        l this = (l) ZeusTransformUtils.preCheckCast(r1.L$0, l.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L43
    L24:
        if (this.c().exists() == true) goto L26;
    L41:
        kotlinx.coroutines.sync.a.C0884a.b(f, null, 1, null);
        return Boxing.boxBoolean(true);
    L26:
        if (this.c().isDirectory() == false) goto L41;
        File[] r18 = this.c().listFiles($$Lambda$l$lDL51Ol77pzpFzQK6S80FC2yvgg.INSTANCE);     // Catch: Throwable -> L43
        if (r18 == null) goto L41;
        int r2 = r18.length;     // Catch: Throwable -> L43
    L30:
        if (r5 >= r2) goto L41;
        File r6 = r18[r5];     // Catch: Throwable -> L43
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L38
        l r8 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (r6.delete() == false) goto L35;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "delete zip file success: " + r6.getAbsolutePath(), false, 4, null);     // Catch: Throwable -> L38
    L36:
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        r5 = r5 + 1;
        goto L30
    L35:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "delete zip file failed: " + r6.getAbsolutePath(), null, 4, null);     // Catch: Throwable -> L38
        goto L36
    L38:
        th = move-exception;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L43
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L43
        goto L40
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r17);
        if (kotlinx.coroutines.sync.a.C0884a.a(f, null, 1, null) == false) goto L19;
        f();     // Catch: Throwable -> L43
        DataTransportManagerImpl r19 = DataTransportManagerImpl.INSTANCE;     // Catch: Throwable -> L43
        r1.L$0 = this;     // Catch: Throwable -> L43
        r1.label = 1;     // Catch: Throwable -> L43
        if (r19.cleanAll(r1) != r3) goto L24;
        return r3;
    L19:
        return Boxing.boxBoolean(false);
    L43:
        th = move-exception;
        kotlinx.coroutines.sync.a.C0884a.b(f, null, 1, null);
        throw th;
    L7:
        r1 = new ExportDataManager$cleanOldData$1(this, r16);
        goto L8
    }
}
