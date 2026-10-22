package com.obric.memorydata.aikernelcore.bridge;

import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/DatabaseBridgeSqlGuard;", "", "<init>", "()V", "GLOBAL_DATABASE_NAME", "", "PERSONAL_DATABASE_NAME", "personalDatabaseTableNames", "", "legacyPersonalBackupTableNames", "personalTablesByNormalizedName", "", "reportableTablesByNormalizedName", "evaluateGlobalDatabaseAccess", "Lcom/obric/memorydata/aikernelcore/bridge/DatabaseBridgeSqlGuard$Decision;", "dbName", "sql", "Decision", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8467a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f8468b = null;
    private static final Set<String> c = null;
    private static final Map<String, String> d = null;
    private static final Map<String, String> e = null;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/DatabaseBridgeSqlGuard$Decision;", "", "tablesToReport", "", "", "shouldRouteToPersonal", "", "<init>", "(Ljava/util/Set;Z)V", "getTablesToReport", "()Ljava/util/Set;", "getShouldRouteToPersonal", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0427a f8469a = null;
        private static final a d = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f8470b;
        private final boolean c;

        /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.bridge.b$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/DatabaseBridgeSqlGuard$Decision$Companion;", "", "<init>", "()V", "NONE", "Lcom/obric/memorydata/aikernelcore/bridge/DatabaseBridgeSqlGuard$Decision;", "getNONE", "()Lcom/obric/memorydata/aikernelcore/bridge/DatabaseBridgeSqlGuard$Decision;", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0427a {
            private C0427a() {
            }

            public /* synthetic */ C0427a(DefaultConstructorMarker r1) {
                this();
            }

            public final a a() {
                return a.c();
            }
        }

        static {
            f8469a = new C0427a(null);
            d = new a(SetsKt.emptySet(), false);
        }

        public a(Set<String> r3, boolean r4) {
            Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "tablesToReport");
            this.f8470b = r5;
            this.c = r4;
        }

        public static final /* synthetic */ a c() {
            return d;
        }

        public final Set<String> a() {
            return this.f8470b;
        }

        public final boolean b() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8470b, r6.f8470b) == true) goto L12;
            return false;
        L12:
            if (this.c == r6.c) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f8470b.hashCode() * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "Decision(tablesToReport=" + this.f8470b + ", shouldRouteToPersonal=" + this.c + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f8467a = new b();
        Set<String> r0 = SetsKt.setOf(new String[]{"AgentWatermark", "AssistantChatEntity", "AssistantChatMessageEntity", "AutoMemoryEpisodicRelevantData", "AutoMemoryPro", "AutoMemoryProEvaluationStats", "AutoMemoryProHistoryEntity", "AutoMemoryProRawSource", "AutoMemoryProSlmEpisodicMemory", "AutoMemoryProSlmPersonalInfo", "AutoMemoryProSnapShot", "AutoMemoryProTextVectorCopilot", "AutoMemorySemanticRelevantData", "BlockMemoryContent", "ComplexRecommendQuery", "EpisodicMemoryHistoryEntity", "EpisodicTopicMemory", "EpisodicTopicMemoryHistoryEntity", "EpisodicTopicMemoryTextVectorCopilot", "GlassesPendingEmbedding", "LifeLogEntityTextVectorCopilot", "Lifelog", "LifelogHistoryEntity", "MemoryBaseRequirement", "MemoryBaseScene", "MemoryEntityToCalendar", "MemoryKeyInfoEntity", "MemoryReviewFeedback", "MemoryRule", "MiddleUserProfile", "MemoryProcessUserInsight", "PendingContext", "PendingEpisodic", "PendingMemoryCalendar", "PendingSemantic", "ProactiveEpisodicRelevantData", "ProactiveSemanticRelevantData", "RawMemoryEntityCorrelation", "RawUserProfileEntity", "RawUserProfileHistoryEntity", "SemanticTextCopilot", "ShortMemory", "ShortMemoryContentTime", "ShortMemoryTextVectorCopilot", "SlmAgentWatermark", "SlmAutoMemoryProTempResult", "UnionSemanticMemory", "UnionSemanticMemoryExt", "UnionSemanticMemoryHistoryEntity", "UnionSemanticMemorySnapShot", "UnionSemanticTypeSummary", "UnionUserInsight", "UnionUserPersona", "UpdateProactiveSemanticRelevantData", "UpdateUnionSemanticMemory", "UserKeyword", "UserProfile", "UserProfileEntityTextVectorCopilot", "UserProfileMemoryEntity"});
        f8468b = r0;
        c = SetsKt.setOf(new String[]{"BackUpAgentWatermark", "BackUpAutoMemoryEpisodicRelevantData", "BackUpAutoMemoryProEntity", "BackUpAutoMemoryProSlmEpisodicMemory", "BackUpAutoMemoryProSlmPersonalInfo", "BackUpAutoMemoryProSnapShot", "BackUpAutoMemorySemanticRelevantData", "BackUpBlockMemoryContent", "BackUpEpisodicMemoryEntity", "BackUpEpisodicTopicMemory", "BackUpLifelog", "BackUpMemoryEntityToCalendar", "BackUpMemoryKeyInfoEntity", "BackUpMemoryReviewFeedback", "BackUpPendingMemoryCalendar", "BackUpProactiveEpisodicRelevantData", "BackUpProactiveSemanticRelevantData", "BackUpRawMemoryEntityCorrelation", "BackUpRawUserProfileEntity", "BackUpSlmAgentWatermark", "BackUpSlmAutoMemoryProTempResult", "BackUpUnionSemanticMemory", "BackUpUnionSemanticMemorySnapShot", "BackUpUpdateProactiveSemanticRelevantData", "BackUpUpdateUnionSemanticMemory", "BacupMemoryRule"});
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Object r5 = r2.next();
        String r8 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        Locale r9 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r9, "ROOT");
        String r7 = r8.toLowerCase(r9);
        Intrinsics.checkNotNullExpressionValue(r7, "toLowerCase(...)");
        r3.put(r7, r5);
        goto L4
    L6:
        d = r3;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(SetsKt.plus(f8468b, (Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Map<String, String> r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r4, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r10 = r4.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        Object r11 = r10.next();
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin");
        Locale r13 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r13, "ROOT");
        String r14 = r12.toLowerCase(r13);
        Intrinsics.checkNotNullExpressionValue(r14, "toLowerCase(...)");
        r6.put(r14, r11);
        goto L8
    L10:
        e = r6;
    }

    private b() {
    }

    public final a a(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "dbName");
        Intrinsics.checkNotNullParameter(r6, "sql");
        if (Intrinsics.areEqual(r5, MemoryDbEngine.ENCRYPT_DB_NAME) == false) goto L5;
        Set<String> r4 = SqlTableReferenceParser.f8457a.a(r6);
        if (r4 != null) goto L11;
        return a.f8469a.a();
    L11:
        if (r4.isEmpty() == true) goto L13;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        Locale r1 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r1, "ROOT");
        String r2 = r0.toLowerCase(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "toLowerCase(...)");
        r8.add(r2);
        goto L16
    L18:
        LinkedHashSet r10 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r8, LinkedHashSet.class, "com.obric.memorydata.plugin");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L20:
        if (r12.hasNext() == false) goto L24;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(e.get(r13), String.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L20;
        r3.add(r14);
        goto L20
    L24:
        LinkedHashSet r15 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r3, LinkedHashSet.class, "com.obric.memorydata.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Map<String, String> r17 = d;
        boolean r18 = true;
        if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L27;
    L29:
        Iterator r19 = r16.iterator();
    L31:
        if (r19.hasNext() == false) goto L36;
        if (r17.containsKey((String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin")) == true) goto L31;
        r18 = false;
    L36:
        return new a((Set) ZeusTransformUtils.preCheckCast(r15, Set.class, "com.obric.memorydata.plugin"), r18);
    L27:
        if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L29;
    L13:
        return a.f8469a.a();
    L5:
        return a.f8469a.a();
    }
}
