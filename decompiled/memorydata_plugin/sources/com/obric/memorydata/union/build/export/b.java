package com.obric.memorydata.union.build.export;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.datatransport.api.MemoryBuildExportTimeRange;
import com.obric.memorydata.migration.sdk.ag;
import com.obric.memorydata.migration.sdk.ai;
import com.obric.memorydata.migration.sdk.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.bouncycastle.crypto.CryptoServicesPermission;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ\u001c\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0002J\u001c\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J \u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0002J&\u0010 \u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\"H\u0002J \u0010#\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\"H\u0002J&\u0010$\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020%0\"H\u0002J \u0010&\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0013H\u0002J \u0010(\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020%0\"H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0017H\u0002¨\u0006*"}, d2 = {"Lcom/obric/memorydata/union/build/export/MemoryBuildDataPackageConfig;", "", "<init>", "()V", "buildBackupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "timeRange", "Lcom/obric/memorydata/datatransport/api/MemoryBuildExportTimeRange;", "onlyRawObservation", "", "buildAutoMemoryBackupConfig", "scope", "Lcom/obric/memorydata/union/build/export/AutoMemoryBuildExportScope;", "buildAutoMemoryBackupConfig$memory_build_obricRelease", "createBackupConfig", CryptoServicesPermission.GLOBAL_CONFIG, "Lcom/obric/memorydata/migration/sdk/DbConfig;", "personalConfig", "buildGlobalTableConfigs", "", "Lcom/obric/memorydata/migration/sdk/TableBackupConfig;", "sqlByTable", "", "", "buildPersonalTableConfigs", "buildRawObservationTableConfig", "exportSQL", "buildTimeRangeSqlByTable", "buildTimeRangeSql", "tableName", "columnName", "buildRawObservationSql", "buildStringInSql", "values", "", "buildStringInClause", "buildLongInSql", "", "buildLongAndSql", "clauses", "buildInClause", "buildEmptySql", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13076a = null;

    static {
        f13076a = new b();
    }

    private b() {
    }

    private final ai a(String r8) {
        return new ai("RawObservation", r8, MapsKt.mapOf(TuplesKt.to("payload", ag.f11885a.a(new String[]{"screenshot_path", "view_tree_path"}))), false, 8, null);
    }

    private final com.obric.memorydata.migration.sdk.b a(g r7, g r8) {
        return new com.obric.memorydata.migration.sdk.b(CollectionsKt.listOfNotNull(new g[]{r7, r8}), null, null, 6, null);
    }

    public static /* synthetic */ com.obric.memorydata.migration.sdk.b a(b r0, MemoryBuildExportTimeRange r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = false;
    L9:
        return r0.a(r1, r2);
    }

    static /* synthetic */ com.obric.memorydata.migration.sdk.b a(b r0, g r1, g r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.a(r1, r2);
    }

    private final String a(String r3, String r4, MemoryBuildExportTimeRange r5) {
        return "SELECT * FROM `" + r3 + "` WHERE `" + r4 + "` >= " + r5.getStartTimeMs() + " AND `" + r4 + "` <= " + r5.getEndTimeMs();
    }

    private final String a(String r3, String r4, Set<String> r5) {
        String r6 = a(r4, (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin"));
        if (r6 != null) goto L7;
        return b(r3);
    L7:
        return "SELECT * FROM `" + r3 + "` WHERE " + r6;
    }

    private final String a(String r12, List<String> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List r0 = CollectionsKt.filterNotNull((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"));
        if (r0.size() != r14.size()) goto L10;
        if (r0.isEmpty() == true) goto L10;
        return "SELECT * FROM `" + r12 + "` WHERE " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" AND ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L10:
        return b(r12);
    }

    private final String a(String r11, Set<String> r12) {
        String r10 = SequencesKt.joinToString$default(SequencesKt.sorted(SequencesKt.distinct(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(MemoryBuildDataPackageConfig$buildStringInClause$joined$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), $$Lambda$b$Y49BOBDciNgXHkCqBTFWColDRH8.INSTANCE))), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$b$u6Y2f1D9zjtlyok94mOjduWds.INSTANCE, 30, null);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r10 = null;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        return '`' + r11 + "` IN (" + r10 + ')';
    }

    private final List<ai> a(Map<String, String> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        return CollectionsKt.listOf(new ai[]{a((String) ZeusTransformUtils.preCheckCast(r12.get("RawObservation"), String.class, "com.obric.memorydata.plugin")), new ai("UnionSemanticMemoryExt", (String) ZeusTransformUtils.preCheckCast(r12.get("UnionSemanticMemoryExt"), String.class, "com.obric.memorydata.plugin"), null, false, 12, null)});
    }

    private final Map<String, String> a(MemoryBuildExportTimeRange r9) {
        String r1 = a("RawObservation", "timestamp", r9);
        String r3 = a("ShortMemory", "startTimestamp", r9);
        String r6 = a("UnionSemanticMemory", "modifyTime", r9);
        String r8 = a("AutoMemoryPro", "modifyTime", r9);
        Map r5 = MapsKt.createMapBuilder();
        r5.put("RawObservation", r1);
        r5.put("ShortMemory", r3);
        r5.put("UnionSemanticMemory", r6);
        r5.put("AutoMemoryPro", r8);
        r5.put("MemoryRule", "SELECT * FROM `MemoryRule` WHERE `id` IN (SELECT DISTINCT `rule_id` FROM `AutoMemoryPro` WHERE `modifyTime` >= " + r9.getStartTimeMs() + " AND `modifyTime` <= " + r9.getEndTimeMs() + ')');
        r5.put("UnionSemanticMemoryExt", "SELECT * FROM `UnionSemanticMemoryExt` WHERE `memory_id` IN (SELECT `entityId` FROM `UnionSemanticMemory` WHERE `modifyTime` >= " + r9.getStartTimeMs() + " AND `modifyTime` <= " + r9.getEndTimeMs() + ')');
        r5.put("ProactiveEpisodicRelevantData", "SELECT * FROM `ProactiveEpisodicRelevantData` WHERE `episodic_id` IN (SELECT `entityId` FROM `ShortMemory` WHERE `startTimestamp` >= " + r9.getStartTimeMs() + " AND `startTimestamp` <= " + r9.getEndTimeMs() + ')');
        r5.put("ProactiveSemanticRelevantData", "SELECT * FROM `ProactiveSemanticRelevantData` WHERE `semantic_id` IN (SELECT `entityId` FROM `UnionSemanticMemory` WHERE `modifyTime` >= " + r9.getStartTimeMs() + " AND `modifyTime` <= " + r9.getEndTimeMs() + ')');
        r5.put("AutoMemoryEpisodicRelevantData", "SELECT * FROM `AutoMemoryEpisodicRelevantData` WHERE `memoryId` IN (SELECT `id` FROM `ShortMemory` WHERE `startTimestamp` >= " + r9.getStartTimeMs() + " AND `startTimestamp` <= " + r9.getEndTimeMs() + ')');
        r5.put("AutoMemorySemanticRelevantData", "SELECT * FROM `AutoMemorySemanticRelevantData` WHERE `memoryId` IN (SELECT `id` FROM `UnionSemanticMemory` WHERE `modifyTime` >= " + r9.getStartTimeMs() + " AND `modifyTime` <= " + r9.getEndTimeMs() + ')');
        return MapsKt.build(r5);
    }

    private static final boolean a(long r2) {
        if (r2 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final String b(a r3) {
        return b("RawObservation", OaidModel.KEY_ID, r3.g());
    }

    private final String b(String r2) {
        return "SELECT * FROM `" + r2 + "` WHERE 1 = 0";
    }

    private final String b(String r3, String r4, Set<Long> r5) {
        String r6 = b(r4, (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin"));
        if (r6 != null) goto L7;
        return b(r3);
    L7:
        return "SELECT * FROM `" + r3 + "` WHERE " + r6;
    }

    private final String b(String r11, Set<Long> r12) {
        String r10 = SequencesKt.joinToString$default(SequencesKt.sorted(SequencesKt.distinct(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$b$n3svgtEiwb5xoRqFyFpzVo7SpYM.INSTANCE))), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r10 = null;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        return '`' + r11 + "` IN (" + r10 + ')';
    }

    private final List<ai> b(Map<String, String> r19) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        return CollectionsKt.listOf(new ai[]{new ai("UnionSemanticMemory", (String) ZeusTransformUtils.preCheckCast(r0.get("UnionSemanticMemory"), String.class, "com.obric.memorydata.plugin"), null, false, 12, null), new ai("ShortMemory", (String) ZeusTransformUtils.preCheckCast(r0.get("ShortMemory"), String.class, "com.obric.memorydata.plugin"), null, false, 12, null), new ai("AutoMemoryPro", (String) ZeusTransformUtils.preCheckCast(r0.get("AutoMemoryPro"), String.class, "com.obric.memorydata.plugin"), null, false, 12, null), new ai("MemoryRule", (String) ZeusTransformUtils.preCheckCast(r0.get("MemoryRule"), String.class, "com.obric.memorydata.plugin"), null, false, 12, null), new ai("ProactiveSemanticRelevantData", (String) ZeusTransformUtils.preCheckCast(r0.get("ProactiveSemanticRelevantData"), String.class, "com.obric.memorydata.plugin"), null, false, 12, null), new ai("ProactiveEpisodicRelevantData", (String) ZeusTransformUtils.preCheckCast(r0.get("ProactiveEpisodicRelevantData"), String.class, "com.obric.memorydata.plugin"), null, false, 12, null), new ai("AutoMemoryEpisodicRelevantData", (String) ZeusTransformUtils.preCheckCast(r0.get("AutoMemoryEpisodicRelevantData"), String.class, "com.obric.memorydata.plugin"), null, false, 12, null), new ai("AutoMemorySemanticRelevantData", (String) ZeusTransformUtils.preCheckCast(r0.get("AutoMemorySemanticRelevantData"), String.class, "com.obric.memorydata.plugin"), null, false, 12, null)});
    }

    private static final boolean c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        if (Intrinsics.areEqual(r3, "null") == true) goto L11;
        return true;
    L11:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    private static final CharSequence d(String r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast('\'' + StringsKt.replace$default(r8, "'", "''", false, 4, null) + '\'', CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ boolean lambda$Y49BOBDciNgXHkCqBTFWColDRH8(String r0) {
        return c(r0);
    }

    public static /* synthetic */ boolean lambda$n3svgtEiwb5xoRqFyFpzVo7SpYM(long r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$u6Y2f1D9zjtl-yok9-4mOjduWds, reason: not valid java name */
    public static /* synthetic */ CharSequence m1225lambda$u6Y2f1D9zjtlyok94mOjduWds(String r0) {
        return d(r0);
    }

    public final com.obric.memorydata.migration.sdk.b a(MemoryBuildExportTimeRange r18, boolean r19) {
        String r2 = null;
        if (r19 == true) goto L5;
        if (r18 != null) goto L11;
        Map<String, String> r1 = MapsKt.emptyMap();
    L13:
        return a(this, new g(MemoryDbEngine.ENCRYPT_DB_NAME, null, a(r1), null, 10, null), null, 2, null);
    L11:
        r1 = a(r18);
        goto L13
    L5:
        if (r18 == null) goto L8;
        r2 = f13076a.a("RawObservation", "timestamp", r18);
    L8:
        return a(new g(MemoryDbEngine.ENCRYPT_DB_NAME, null, CollectionsKt.listOf(a(r2)), null, 10, null), new g(MemoryDbEngine.USER_LOGIC_DB_NAME, null, CollectionsKt.listOf(new ai("MemoryRule", null, null, false, 14, null)), null, 10, null));
    }

    public final com.obric.memorydata.migration.sdk.b a(a r18) {
        Intrinsics.checkNotNullParameter(r18, "scope");
        Map r2 = MapsKt.createMapBuilder();
        b r3 = f13076a;
        r2.put("AutoMemoryPro", r3.b("AutoMemoryPro", OaidModel.KEY_ID, SetsKt.setOf(Long.valueOf(r18.a()))));
        r2.put("RawObservation", r3.b(r18));
        r2.put("ShortMemory", r3.a("ShortMemory", "entityId", r18.d()));
        r2.put("UnionSemanticMemory", r3.a("UnionSemanticMemory", "entityId", r18.f()));
        r2.put("UnionSemanticMemoryExt", r3.a("UnionSemanticMemoryExt", "memory_id", r18.f()));
        r2.put("MemoryRule", r3.b("MemoryRule", OaidModel.KEY_ID, SetsKt.setOf(Long.valueOf(r18.b()))));
        r2.put("ProactiveEpisodicRelevantData", r3.a("ProactiveEpisodicRelevantData", "episodic_id", r18.d()));
        r2.put("ProactiveSemanticRelevantData", r3.a("ProactiveSemanticRelevantData", "semantic_id", r18.f()));
        r2.put("AutoMemoryEpisodicRelevantData", r3.a("AutoMemoryEpisodicRelevantData", CollectionsKt.listOf(new String[]{r3.b("ruleId", SetsKt.setOf(Long.valueOf(r18.b()))), r3.b("memoryId", r18.c())})));
        r2.put("AutoMemorySemanticRelevantData", r3.a("AutoMemorySemanticRelevantData", CollectionsKt.listOf(new String[]{r3.b("ruleId", SetsKt.setOf(Long.valueOf(r18.b()))), r3.b("memoryId", r18.e())})));
        Map<String, String> r1 = MapsKt.build(r2);
        return a(new g(MemoryDbEngine.ENCRYPT_DB_NAME, null, a(r1), null, 10, null), new g(MemoryDbEngine.USER_LOGIC_DB_NAME, null, b(r1), null, 10, null));
    }
}
