package com.obric.memorydata.union.build;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.obric.cae.libs.nfc.CaeNfcCardInfo;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.dao.GlassesEpisodicRelevantDataDao;
import com.obric.memorydata.database.dao.ProactiveEpisodicRelevantDataDao;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.database.entity.by;
import com.obric.memorydata.database.entity.es;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.memory.api.MemoryBuildApi;
import com.obric.memorydata.memory.api.MemoryBuildService;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.EntityManager;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0002*+B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0002J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\fH\u0002J<\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001fH\u0002J\u001e\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001f2\b\u0010#\u001a\u0004\u0018\u00010\u0003H\u0002J\f\u0010$\u001a\u00020\u0018*\u00020\nH\u0002J\f\u0010%\u001a\u00020\u0003*\u00020\u0003H\u0002J&\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/memorydata/union/build/UnionEpisodicHandler;", "", "data", "", "<init>", "(Ljava/lang/String;)V", "handle", "processItemWithResult", "Lcom/obric/memorydata/union/build/EpisodicBuildResultItem;", "item", "Lcom/obric/memorydata/union/build/UnionEpisodicData;", "resolveOldEntity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "resolveSourceLinkInfo", "Lcom/obric/memorydata/union/build/UnionEpisodicHandler$ResolvedSourceLinkInfo;", "resolveAction", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$Action;", "requestedAction", "oldEntity", "insertProactiveEpisodicRelevantData", "", "entity", "action", "isNewEntity", "", "insertPendingMemoryCalendars", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/union/build/UnionRelevantSourceUtils$SourceInfo;", "insertMemoryKeyInfo", "appendPersonSpeakerSummary", "mergePersonSpeakerSummary", "", "existing", "incoming", "parsePersonSpeakerSummary", "rawSummary", "hasInlineRelevantSourceInfo", "toSummary", "extractRuleIdList", "", "", "relevantData", "Companion", "ResolvedSourceLinkInfo", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13093a = null;
    private static final Gson c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13094b;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rH\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/union/build/UnionEpisodicHandler$Companion;", "", "<init>", "()V", "TAG", "", GsonUtil.TAG, "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "Lcom/google/gson/Gson;", "mergeJsonArray", "existingJson", "incoming", "", "resolvedSourceRawRefIds", "item", "Lcom/obric/memorydata/union/build/UnionEpisodicData;", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.memorydata.union.build.k$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0716a extends TypeToken<List<? extends String>> {
            public C0716a() {
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ String a(a r2, String r3, List r4) {
            return r2.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
        }

        private final String a(String r4, List<String> r5) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            GsonUtil r1 = GsonUtil.INSTANCE;
            List r2 = null;
            if (r4 != null) goto L5;
        L13:
            if (r2 != null) goto L15;
            r2 = CollectionsKt.emptyList();
        L15:
            a(r6, r2);
            a(r6, r3);
            return GsonUtil.INSTANCE.toJson(r6);
        L5:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
            boolean r7 = true;
        L8:
            if (r7 == true) goto L11;
            r4 = null;
        L11:
            if (r4 == null) goto L13;
            r2 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r4, new C0716a().getType()), List.class, "com.obric.memorydata.plugin");
            goto L13
        L7:
            r7 = false;
            goto L8
        }

        private final List<String> a(UnionEpisodicData r5) {
            List<String> r4 = r5.getSourceRawRefIds();
            if (r4 != null) goto L5;
            r4 = CollectionsKt.emptyList();
        L5:
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r8 = r6.iterator();
        L7:
            if (r8.hasNext() == false) goto L12;
            Object r1 = r8.next();
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
            r7.add(r1);
            goto L7
        L12:
            return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        }

        public static final /* synthetic */ List a(a r0, UnionEpisodicData r1) {
            return r0.a(r1);
        }

        private static final void a(List<String> r3, List<String> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L5;
            r6 = CollectionsKt.emptyList();
        L5:
            Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L7:
            if (r7.hasNext() == false) goto L16;
            String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
            boolean r2 = true;
        L12:
            if (r2 == false) goto L7;
            if (r5.contains(r0) == true) goto L7;
            r5.add(r0);
            goto L7
        L11:
            r2 = false;
            goto L12
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/union/build/UnionEpisodicHandler$ResolvedSourceLinkInfo;", "", "sourceLink", "", "sourceLinkType", AILabCheckPermissionTask.KEY_SOURCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSourceLink", "()Ljava/lang/String;", "getSourceLinkType", "getSource", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13096b;
        private final String c;

        public b(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "sourceLink");
            Intrinsics.checkNotNullParameter(r4, AILabCheckPermissionTask.KEY_SOURCE);
            this.f13095a = r2;
            this.f13096b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f13095a;
        }

        public final String b() {
            return this.f13096b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13095a, r6.f13095a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13096b, r6.f13096b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = this.f13095a.hashCode() * 31;
            String r1 = this.f13096b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.c.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ResolvedSourceLinkInfo(sourceLink=" + this.f13095a + ", sourceLinkType=" + this.f13096b + ", source=" + this.c + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13097a = null;

        static {
            int[] r0 = new int[MemoryBuildApi.Action.values().length];
            r0[MemoryBuildApi.Action.INSERT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MemoryBuildApi.Action.INSERT_SNAPSHOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f13097a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/memorydata/union/build/UnionEpisodicHandler$handle$listType$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/obric/memorydata/union/build/UnionEpisodicData;", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends TypeToken<List<? extends UnionEpisodicData>> {
        d() {
        }
    }

    static {
        f13093a = new a(null);
        c = new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(UnionEpisodicData.class, Type.class, "com.obric.memorydata.plugin"), new UnionEpisodicHandler$Companion$GSON$1()).create();
    }

    public k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.f13094b = r2;
    }

    private final MemoryBuildApi.Action a(MemoryBuildApi.Action r1, EpisodicMemoryEntity r2) {
        if (r2 != null) goto L4;
        return r1;
    L4:
        int r0 = c.f13097a[r1.ordinal()];
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L12;
        return r1;
    L12:
        return MemoryBuildApi.Action.UPDATE_SNAPSHOT;
    L11:
        return MemoryBuildApi.Action.UPDATE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final EpisodicBuildResultItem a(UnionEpisodicData r122) {
        if (r122 == null) goto L5;
        RunLog.INSTANCE.debug("UnionEpisodicHandler", "process item: " + r122);
        if (com.obric.memorydata.utils.b.a(r122.getTitle()) == false) goto L10;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionEpisodicHandler", "item data is invalid: " + r122, null, 4, null);
        return new EpisodicBuildResultItem("400", "data invalid", null, null, 12, null);
    L10:
        MemoryBuildApi.Action r0 = r122.getActionType();
        EpisodicMemoryEntity r8 = b(r122);
        MemoryBuildApi.Action r9 = a(r0, r8);
        Long r1 = r122.getModifyTime();
        if (r1 == null) goto L13;
        long r5 = r1.longValue();
    L14:
        RunLog r2 = RunLog.INSTANCE;
        StringBuilder r7 = new StringBuilder().append("episodic time payload: action=").append(r122.getAction()).append(", resolvedAction=").append(r9.getValue()).append(", modifyTime=").append(r5).append(", hasOldEntity=");
        if (r8 == null) goto L17;
        boolean r10 = true;
    L18:
        r2.debug("UnionEpisodicHandler", r7.append(r10).toString());
        a r3 = f13093a;
        if (r8 == null) goto L21;
        String r11 = r8.getSceneIds();
    L22:
        String r15 = a.a(r3, r11, r122.getSceneIds());
        if (r8 == null) goto L25;
        String r12 = r8.getImportantRawRefIds();
    L26:
        String r13 = a.a(r3, r12, r122.getImportantRawRefIds());
        if (r8 == null) goto L29;
        String r14 = r8.getSourceRawRefIds();
    L30:
        String r16 = a.a(r3, r14, a.a(r3, r122));
        if (r8 == null) goto L33;
        String r17 = r8.getSourcePackageName();
    L34:
        String r18 = a.a(r3, r17, r122.getSourcePackageName());
        Integer r19 = (Integer) ZeusTransformUtils.preCheckCast(e.f13072a.a().get(r122.getBusinessType()), Integer.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L37;
        int r110 = r19.intValue();
    L38:
        f r111 = f.f13087a;
        String r112 = r122.getBusinessType();
        if (r8 == null) goto L41;
        Integer r4 = Integer.valueOf(r8.getProductType());
    L42:
        int r6 = r111.a(r112, r4, r110);
        if (r8 == null) goto L46;
        String r113 = r8.getEntityId();
        if (r113 == null) goto L46;
    L47:
        String r114 = r113;
        IRunLog r115 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        long r40 = r5;
        StringBuilder r20 = new StringBuilder().append("[LOGID_TRACE][ANDROID_EPISODIC_PROVENANCE] action=").append(r122.getAction()).append(" businessType=").append(r122.getBusinessType()).append(" logId=").append(r122.getLogId()).append(" sceneCount=");
        List<String> r21 = r122.getSceneIds();
        if (r21 == null) goto L50;
        int r22 = r21.size();
    L51:
        StringBuilder r23 = r20.append(r22).append(" importantCount=");
        List<String> r24 = r122.getImportantRawRefIds();
        if (r24 == null) goto L54;
        int r25 = r24.size();
    L55:
        StringBuilder r26 = r23.append(r25).append(" sourceCount=").append(a.a(r3, r122).size()).append(" sourcePackageCount=");
        List<String> r27 = r122.getSourcePackageName();
        if (r27 == null) goto L58;
        int r28 = r27.size();
    L59:
        IRunLog.a.a(r115, "UnionEpisodicHandler", r26.append(r28).toString(), false, 4, null);
        RunLog.INSTANCE.debug("UnionEpisodicHandler", "[LOGID_TRACE][ANDROID_EPISODIC_PROVENANCE_DETAIL] logId=" + r122.getLogId() + " sceneIds=" + r15 + " importantRawRefIds=" + r13 + " sourceRawRefIds=" + r16 + " sourcePackageName=" + r18);
        RunLog r29 = RunLog.INSTANCE;
        StringBuilder r30 = new StringBuilder().append("[LOGID_TRACE][ANDROID_EPISODIC_RESOLVE] action=").append(r122.getAction()).append(" resolvedAction=").append(r9.getValue()).append(" businessType=").append(r122.getBusinessType()).append(" productType=").append(r6).append(" logId=").append(r122.getLogId()).append(" entityId=").append(r114).append(" oldEntityId=");
        if (r8 == null) goto L62;
        String r31 = r8.getEntityId();
    L63:
        StringBuilder r32 = r30.append(r31).append(" oldLogId=");
        if (r8 == null) goto L66;
        String r33 = r8.getLogId();
    L67:
        r29.debug("UnionEpisodicHandler", r32.append(r33).toString());
        if (Intrinsics.areEqual(r122.getBusinessType(), "autoMemory") == false) goto L105;
        if (r8 == null) goto L72;
        long r116 = r8.getCreateTime();
    L71:
        long r38 = r116;
    L76:
        Long r34 = r122.getActionTimestamp();
        if (r34 == null) goto L79;
        long r210 = r34.longValue();
    L80:
        String r35 = r122.getFullContent();
        if (r35 != null) goto L83;
        r35 = r122.getTitle() + '\n' + r122.getContent();
    L83:
        String r36 = r122.getTitle();
        String r211 = r122.getContent();
        String r212 = r122.getObservation();
        String r117 = r122.getLocation();
        if (r117 != null) goto L86;
        r117 = "";
    L86:
        String r37 = r117;
        Integer r118 = r122.getCategory();
        if (r118 == null) goto L89;
        int r213 = r118.intValue();
    L90:
        String r39 = r122.getLogId();
        Boolean r119 = r122.getUseLocation();
        if (r119 == null) goto L93;
        boolean r310 = r119.booleanValue();
    L94:
        Long r120 = r122.getStartTimestamp();
        long r214 = 0;
        if (r120 == null) goto L97;
        long r311 = r120.longValue();
    L98:
        Long r121 = r122.getEndTimestamp();
        if (r121 == null) goto L101;
        r214 = r121.longValue();
    L101:
        String r1110 = " logId=";
        String r1111 = r114;
        String r1112 = " entityId=";
        boolean r1113 = false;
        long r123 = r210;
        String r215 = r35;
        EpisodicMemoryEntity r64 = new EpisodicMemoryEntity(0, r123, 0, r36, r211, null, r215, r212, r37, "", Integer.valueOf(r213), null, null, null, r39, false, Boolean.valueOf(r310), false, r311, r214, false, r1111, r38, r40, -306, System.currentTimeMillis(), BuildConfig.LIBRARY_PACKAGE_NAME, 0, null, null, r6, r13, r16, r15, r18, null, null, null, null, 805437441, 120, null);
        if (r8 == null) goto L104;
        r64 = EpisodicMemoryEntity.copy$default(r64, r8.getId(), 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, 0, null, null, 0, 0, 0, 0, null, 0, r8.getUuid(), null, 0, null, null, null, null, null, null, null, null, -268435458, 127, null);
    L104:
        String r1114 = " productType=";
        String r124 = " resolvedAction=";
        EpisodicMemoryEntity r41 = r64;
        EpisodicMemoryEntity r63 = r8;
        MemoryBuildApi.Action r65 = r9;
    L148:
        if (Intrinsics.areEqual(r122.getBusinessType(), "proactive") == false) goto L150;
    L153:
        String r42 = "com.obric.memorydata.plugin";
        g.f13090a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r41, com.obric.memorydata.database.entity.d.class, r42), r122.getPoisonLabel(), r122.getPoisonLabelVersion(), g.f13090a.a(r41.getTitle(), r41.getContent()));
    L154:
        String r43 = r124;
        String r44 = r1112;
        String r125 = r1110;
        RunLog.INSTANCE.debug("UnionEpisodicHandler", new StringBuilder().append("[LOGID_TRACE][ANDROID_EPISODIC_ENTITY] action=").append(r122.getAction()).append(r43).append(r65.getValue()).append(r44).append(r41.getEntityId()).append(r1114).append(r41.getProductType()).append(r125).append(r41.getLogId()).append(" dbId=").append(r41.getId()).append(" uuid=").append(r41.getUuid()).toString());
        RunLog.INSTANCE.debug("UnionEpisodicHandler", "index entity: " + r41);
        boolean r126 = r1113;
        if (com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r41, com.obric.memorydata.database.a.class, r42), r126, 1, null) == false) goto L222;
        RunLog.INSTANCE.debug("UnionEpisodicHandler", "[LOGID_TRACE][ANDROID_EPISODIC_INDEX_OK] action=" + r122.getAction() + r43 + r65.getValue() + r44 + r41.getEntityId() + r125 + r41.getLogId() + " dbId=" + r41.getId() + " uuid=" + r41.getUuid());
        RunLog.INSTANCE.debug("UnionEpisodicHandler", "index success");
        if (r6 != 1003) goto L173;
        k r45 = this;
        if (d(r122) == false) goto L164;
        if (r63 != null) goto L162;
        boolean r127 = true;
    L163:
        MemoryBuildApi.Action r46 = r65;
        r45.a(r122, r41, r46, r127);
        Unit r47 = Unit.INSTANCE;
    L171:
        List r312 = null;
    L172:
        MemoryBuildApi.Action r48 = r46;
    L195:
        if (l.a(r122.getBusinessType()) == false) goto L198;
        r45.b(r122, r41);
    L198:
        if (r6 != 1003) goto L200;
    L212:
        EntityManager.INSTANCE.launchIndexTask();
        if (r63 != null) goto L215;
        String r49 = "insert success";
    L216:
        if (r63 == null) goto L218;
        List r50 = CollectionsKt.listOf(r63.getEntityId());
    L220:
        return new EpisodicBuildResultItem(BDLocationException.SUCCESS, r49, r1111, r50);
    L218:
        r50 = r312;
        goto L220
    L215:
        r49 = "update success";
        goto L216
    L200:
        if (r48.isSnapshotAction() == true) goto L212;
        if (MemoryBuildService.INSTANCE.hasMemorySource(r6) == false) goto L212;
        MemoryBuildService r51 = MemoryBuildService.INSTANCE;
        String r216 = r41.getUuid();
        List<String> r52 = r122.getSourcePackageName();
        if (r52 == null) goto L206;
        String r217 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r52, Iterable.class, r42), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, r42), null, null, 0, null, null, 62, null);
    L207:
        long r218 = r41.getCreateTime();
        long r53 = r41.getModifyTime();
        if (r63 != null) goto L210;
        boolean r219 = true;
    L211:
        r51.trackNewProactiveMemory(new MemoryBuildApi.d(r216, r6, r217, r6, null, r218, r53, r219, false, null, null, null, CaeNfcCardInfo.LIFE_CYCLE_INACTIVE, null));
        goto L212
    L210:
        r219 = r126;
        goto L211
    L206:
        r217 = r312;
        goto L207
    L162:
        r127 = r126;
        goto L163
    L164:
        r46 = r65;
        String r128 = ((ProactiveEpisodicData) ZeusTransformUtils.preCheckCast(r122, ProactiveEpisodicData.class, r42)).getSessionId();
        if (r128 == null) goto L171;
        MemoryBuildService r54 = MemoryBuildService.INSTANCE;
        String r129 = r41.getEntityId();
        String r130 = r41.getUuid();
        int r131 = r41.getType();
        long r132 = r41.getCreateTime();
        long r133 = r41.getModifyTime();
        String r220 = ((ProactiveEpisodicData) ZeusTransformUtils.preCheckCast(r122, ProactiveEpisodicData.class, r42)).getContent();
        List<MemoryBuildApi.Schedule> r221 = ((ProactiveEpisodicData) ZeusTransformUtils.preCheckCast(r122, ProactiveEpisodicData.class, r42)).getSchedules();
        String r222 = ((ProactiveEpisodicData) ZeusTransformUtils.preCheckCast(r122, ProactiveEpisodicData.class, r42)).getTag();
        Map<String, List<String>> r223 = ((ProactiveEpisodicData) ZeusTransformUtils.preCheckCast(r122, ProactiveEpisodicData.class, r42)).getKeyInfoMap();
        String r224 = ((ProactiveEpisodicData) ZeusTransformUtils.preCheckCast(r122, ProactiveEpisodicData.class, r42)).getContentFrom();
        if (r63 != null) goto L169;
        boolean r225 = true;
    L170:
        r312 = null;
        r54.insertProactiveEpisodicRelevantData(new MemoryBuildApi.a(r128, r129, r130, r131, r132, r133, r46, r220, r221, r222, r223, r224, r225));
        Unit r55 = Unit.INSTANCE;
        Unit r56 = Unit.INSTANCE;
        goto L172
    L169:
        r225 = r126;
        goto L170
    L173:
        r45 = this;
        r126 = r126;
        r48 = r65;
        r312 = null;
        if (Intrinsics.areEqual(r122.getBusinessType(), "autoMemory") == false) goto L195;
        List<Long> r57 = r45.a(r122.getRelevantData());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r57, Collection.class, r42)).isEmpty()) == false) goto L195;
        long r226 = r41.getCreateTime();
        Iterator r58 = ((Iterable) ZeusTransformUtils.preCheckCast(r57, Iterable.class, r42)).iterator();
    L179:
        if (r58.hasNext() == false) goto L195;
        long r134 = ((Number) ZeusTransformUtils.preCheckCast(r58.next(), Number.class, r42)).longValue();
        Result.Companion r59 = Result.Companion;     // Catch: Throwable -> L187
        long r227 = r134;
        Object r60 = Result.m1421constructorimpl(Boolean.valueOf(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryEpisodicRelevantDataDao().insertIfAbsent(new com.obric.memorydata.database.entity.t(0, r41.getId(), r134, r226, null, 17, null))));     // Catch: Throwable -> L185
    L190:
        Throwable r61 = Result.m1424exceptionOrNullimpl(r60);
        if (r61 == null) goto L179;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r42), "UnionEpisodicHandler", "insert AutoMemoryEpisodicRelevantData failed, memoryId=" + r41.getId() + ", ruleId=" + r227 + ", err=" + r61.getMessage(), null, 4, null);
    L185:
        th = th;
    L189:
        Result.Companion r62 = Result.Companion;
        r60 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L187:
        th = th;
        r227 = r134;
        goto L189
    L222:
        return new EpisodicBuildResultItem("400", "index error", null, null, 12, null);
    L150:
        if (g.f13090a.a(r122.getPoisonLabel(), r122.getPoisonLabelVersion()) == true) goto L153;
        r42 = "com.obric.memorydata.plugin";
        goto L154
    L97:
        r311 = 0;
        goto L98
    L93:
        r310 = false;
        goto L94
    L89:
        r213 = 0;
        goto L90
    L79:
        r210 = r38;
        goto L80
    L72:
        Long r66 = r122.getCreateTime();
        if (r66 == null) goto L75;
        r116 = r66.longValue();
        goto L71
    L75:
        r38 = r40;
        goto L76
    L105:
        r1110 = " logId=";
        r1111 = r114;
        r1112 = " entityId=";
        r1113 = false;
        if (r8 == null) goto L108;
        long r68 = r8.getCreateTime();
    L109:
        Long r67 = r122.getActionTimestamp();
        if (r67 == null) goto L112;
    L111:
        long r70 = r67.longValue();
    L118:
        com.obric.memorydata.union.build.c r135 = com.obric.memorydata.union.build.c.f13070a;
        if (r8 == null) goto L121;
        Long r136 = Long.valueOf(r8.getStartTimestamp());
    L122:
        if (r8 == null) goto L124;
        Long r137 = Long.valueOf(r8.getEndTimestamp());
    L125:
        Long r138 = r122.getStartTimestamp();
        Long r139 = r122.getEndTimestamp();
        if (Intrinsics.areEqual(r122.getBusinessType(), "glasses") == false) goto L131;
        if (r8 == null) goto L131;
        if (r9 != MemoryBuildApi.Action.UPDATE) goto L131;
        boolean r140 = true;
    L132:
        com.obric.memorydata.union.build.b r69 = r135.a(r136, r137, r138, r139, r40, r140);
        Boolean r71 = r122.getUseLocation();
        if (r71 == null) goto L135;
    L134:
        boolean r510 = r71.booleanValue();
    L141:
        if (r8 == null) goto L145;
        String r610 = r18;
        long r72 = r40;
        r1114 = " productType=";
        r124 = " resolvedAction=";
        r63 = r8;
        r65 = r9;
        long r73 = r70;
        r41 = EpisodicMemoryEntity.copy$default(r8, 0, r73, 0, r122.getTitle(), r122.getContent(), null, null, r122.getObservation(), null, null, null, null, null, null, r122.getLogId(), null, Boolean.valueOf(r510), false, r69.a(), r69.b(), null, null, 0, r72, 0, 0, null, 0, null, null, r6, r13, r16, r15, r610, null, null, null, null, 1064484709, 120, null);
        if (r41 != null) goto L148;
    L146:
        long r141 = r70;
        r41 = new EpisodicMemoryEntity(0, r141, 0, r122.getTitle(), r122.getContent(), null, null, r122.getObservation(), null, null, null, null, null, null, r122.getLogId(), false, Boolean.valueOf(r510), false, r69.a(), r69.b(), false, r1111, r68, r72, 0, 0, null, 0, null, null, r6, r13, r16, r15, r610, null, null, null, null, 1057111909, 120, null);
        goto L148
    L145:
        r1114 = " productType=";
        r610 = r18;
        r65 = r9;
        r72 = r40;
        r124 = " resolvedAction=";
        r63 = r8;
        goto L146
    L135:
        if (r8 == null) goto L137;
        r71 = r8.getUseLocation();
    L138:
        if (r71 != null) goto L134;
        r510 = false;
        goto L141
    L137:
        r71 = null;
    L131:
        r140 = false;
        goto L132
    L124:
        r137 = null;
        goto L125
    L121:
        r136 = null;
        goto L122
    L112:
        if (r8 == null) goto L114;
        r67 = Long.valueOf(r8.getActionTimestamp());
    L115:
        if (r67 != null) goto L111;
        r70 = r68;
        goto L118
    L114:
        r67 = null;
        goto L115
    L108:
        r68 = r40;
        goto L109
    L66:
        r33 = null;
        goto L67
    L62:
        r31 = null;
        goto L63
    L58:
        r28 = 0;
        goto L59
    L54:
        r25 = 0;
        goto L55
    L50:
        r22 = 0;
    L46:
        r113 = com.obric.memorydata.union.build.a.f13066a.a(String.valueOf(r6));
        goto L47
    L41:
        r4 = null;
        goto L42
    L37:
        r110 = 0;
        goto L38
    L33:
        r17 = null;
        goto L34
    L29:
        r14 = null;
        goto L30
    L25:
        r12 = null;
        goto L26
    L21:
        r11 = null;
        goto L22
    L17:
        r10 = false;
        goto L18
    L13:
        r5 = System.currentTimeMillis();
        goto L14
    L5:
        return new EpisodicBuildResultItem("400", "data empty", null, null, 12, null);
    }

    private final List<Long> a(Map<String, ? extends Object> r7) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L35;
        Object r8 = r6.get("rule_id_list");
        if (r8 == null) goto L35;
        if (ZeusTransformUtils.instanceOf(r8, List.class) == false) goto L10;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L13:
        if (r11.hasNext() == false) goto L23;
        Object r1 = r11.next();
        if (ZeusTransformUtils.instanceOf(r1, Number.class) == false) goto L18;
        Long r2 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue());
    L21:
        if (r2 == null) goto L13;
        r10.add(r2);
        goto L13
    L18:
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L20;
        r2 = StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"));
        goto L21
    L20:
        r2 = null;
        goto L21
    L23:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L25:
        if (r14.hasNext() == false) goto L33;
        Object r3 = r14.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L29;
        boolean r4 = true;
    L30:
        if (r4 == false) goto L25;
        r13.add(r3);
        goto L25
    L29:
        r4 = false;
        goto L30
    L33:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L10:
        return CollectionsKt.emptyList();
    L35:
        return CollectionsKt.emptyList();
    }

    private final Map<String, String> a(String r7) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == true) goto L11;
        return l.a((Map) ZeusTransformUtils.preCheckCast(c.fromJson(r7, Map.class), Map.class, "com.obric.memorydata.plugin"));
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionEpisodicHandler", "parse existing person speaker summary failed", null, 4, null);
        return MapsKt.emptyMap();
    L11:
        return MapsKt.emptyMap();
    L5:
        if (StringsKt.isBlank(r6) == true) goto L8;
        r8 = false;
        goto L9
    }

    private final Map<String, String> a(Map<String, String> r5, Map<String, String> r6) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Map r8 = MapsKt.toMutableMap(r4);
        Iterator r9 = r7.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L14;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.getValue(), String.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.get(r1), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L12;
        if (Intrinsics.areEqual(r2, r11) == false) goto L11;
        r11 = r2;
        goto L12
    L11:
        r11 = r2 + '\n' + r11;
    L12:
        r8.put(r1, r11);
        goto L4
    L14:
        return (Map) ZeusTransformUtils.preCheckCast(MapsKt.toSortedMap(r8), Map.class, "com.obric.memorydata.plugin");
    }

    private static final void a(PersonalMemoryFrameDb r9, EpisodicMemoryEntity r10, k r11, Map r12) {
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        GlassesEpisodicRelevantDataDao r14 = r9.getGlassesEpisodicRelevantDataDao();
        by r1 = r14.queryByEpisodicId(r10.getEntityId());
        if (r1 == null) goto L5;
        String r0 = r1.c();
    L6:
        Map<String, String> r15 = r11.a(r11.a(r0), r13);
        String r6 = GsonUtil.INSTANCE.toJson(r15);
        if (r1 != null) goto L9;
        r14.insert(new by(0, r10.getEntityId(), r6, 1, null));
        return;
    L9:
        r14.update(by.a(r1, 0, null, r6, 3, null));
        return;
    L5:
        r0 = null;
        goto L6
    }

    private final void a(UnionEpisodicData r3, EpisodicMemoryEntity r4) {
        Map<String, List<String>> r0 = null;
        if (ZeusTransformUtils.instanceOf(r3, ProactiveEpisodicData.class) == false) goto L5;
        ProactiveEpisodicData r2 = (ProactiveEpisodicData) ZeusTransformUtils.preCheckCast(r3, ProactiveEpisodicData.class, "com.obric.memorydata.plugin");
    L6:
        if (r2 == null) goto L15;
        Map<String, List<String>> r5 = r2.getKeyInfoMap();
        if (r5 != null) goto L10;
        return;
    L10:
        if ((!r5.isEmpty()) == false) goto L12;
        r0 = r5;
    L12:
        if (r0 == null) goto L17;
        List<MemoryKeyInfoEntity> r6 = MemoryKeyInfoEntity.Companion.a(r4.getEntityId(), r0);
        RunLog.INSTANCE.debug("UnionEpisodicHandler", "insertMemoryKeyInfo keyInfoEntities: " + r6);
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryKeyInfoDao().batchInsert(r6);
        return;
    L17:
        return;
    L15:
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final void a(UnionEpisodicData r29, EpisodicMemoryEntity r30, MemoryBuildApi.Action r31, boolean r32) {
        m.a r2 = m.f13098a.a(r29.getSourceInfo());
        ProactiveEpisodicRelevantDataDao r3 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveEpisodicRelevantDataDao();
        String r7 = r30.getEntityId();
        String r8 = r2.a();
        String r9 = r2.b();
        String r10 = r2.f();
        String r11 = r2.g();
        String r12 = m.f13098a.b(r2.c());
        String r14 = r2.e();
        String r13 = r2.d();
        int r15 = r2.h();
        String r18 = b(r29.getContent());
        String r26 = null;
        if (ZeusTransformUtils.instanceOf(r29, ProactiveEpisodicData.class) == false) goto L5;
        ProactiveEpisodicData r4 = (ProactiveEpisodicData) ZeusTransformUtils.preCheckCast(r29, ProactiveEpisodicData.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L8;
        String r17 = r4.getTag();
    L10:
        if (r31.isSnapshotAction() == false) goto L12;
        int r5 = 1;
    L13:
        r3.insert(new es(0, r7, r8, r9, r10, r11, r12, r13, r14, r15, null, r17, r18, r5, null, null, null, null, 246785, null));
        a(r29, r30, r2);
        a(r29, r30);
        com.obric.memorydata.union.build.d r0 = com.obric.memorydata.union.build.d.f13071a;
        if (ZeusTransformUtils.instanceOf(r29, ProactiveEpisodicData.class) == false) goto L16;
        ProactiveEpisodicData r6 = (ProactiveEpisodicData) ZeusTransformUtils.preCheckCast(r29, ProactiveEpisodicData.class, "com.obric.memorydata.plugin");
    L17:
        if (r6 == null) goto L19;
        r26 = r6.getTag();
    L19:
        MemoryBuildApi.d r1 = r0.a(r29.getSourceInfo(), r30.getUuid(), r30.getCreateTime(), r30.getModifyTime(), r32, r31, r26);
        if (r1 == null) goto L23;
        MemoryBuildService.INSTANCE.trackNewProactiveMemory(r1);
        return;
    L23:
        return;
    L16:
        r6 = null;
        goto L17
    L12:
        r5 = 2;
        goto L13
    L8:
        r17 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    private final void a(UnionEpisodicData r22, EpisodicMemoryEntity r23, m.a r24) {
        List<MemoryBuildApi.Schedule> r2 = null;
        if (ZeusTransformUtils.instanceOf(r22, ProactiveEpisodicData.class) == false) goto L5;
        ProactiveEpisodicData r0 = (ProactiveEpisodicData) ZeusTransformUtils.preCheckCast(r22, ProactiveEpisodicData.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L29;
        List<MemoryBuildApi.Schedule> r1 = r0.getSchedules();
        if (r1 != null) goto L10;
        return;
    L10:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L12;
        r2 = r1;
    L12:
        if (r2 == null) goto L31;
        RunLog.INSTANCE.debug("UnionEpisodicHandler", "insertPendingMemoryCalendars schedules: " + r2);
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L15:
        if (r5.hasNext() == false) goto L24;
        MemoryBuildApi.Schedule r6 = (MemoryBuildApi.Schedule) ZeusTransformUtils.preCheckCast(r5.next(), MemoryBuildApi.Schedule.class, "com.obric.memorydata.plugin");
        String r7 = r6.getTitle();
        String r9 = r6.getScheduleType().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r9, "toUpperCase(...)");
        Long r11 = r6.getStartTime();
        Long r12 = r6.getEndTime();
        String r8 = r24.d();
        if (r8 != null) goto L19;
        String r14 = "";
    L20:
        String r10 = r24.e();
        if (r10 != null) goto L23;
        r10 = "";
    L23:
        r4.add(new PendingMemoryCalendar(0, r7, null, r9, null, r11, r12, null, r14, r10, r23.getUuid(), Integer.valueOf(r23.getType()), 0, 4245, null));
        r5 = r5;
        goto L15
    L19:
        r14 = r8;
        goto L20
    L24:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getPendingMemoryCalendarDao().batchInsert((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"));
        return;
    L31:
        return;
    L29:
        return;
    L5:
        r0 = null;
        goto L6
    }

    private final EpisodicMemoryEntity b(UnionEpisodicData r13) {
        List<String> r0 = r13.getEntityIdList();
        if (r0 == null) goto L11;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        EpisodicMemoryEntity r3 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityId(r2);
        if (r3 == null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionEpisodicHandler", "resolveOldEntity by entityId, entityId=" + r2 + ", memoryId=" + r3.getId() + ", entityType=" + r3.getType() + ", uuid=" + r3.getUuid(), false, 4, null);
        return r3;
    L11:
        MemoryBuildApi.Action r4 = r13.getActionType();
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(e.f13072a.a().get(r13.getBusinessType()), Integer.class, "com.obric.memorydata.plugin");
        boolean r6 = false;
        if (r5 == null) goto L14;
        int r7 = r5.intValue();
    L15:
        String r8 = null;
        if (r7 == 1003) goto L22;
        IRunLog r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r12 = new StringBuilder().append("resolveOldEntity skip sourceLink, productType=").append(r7);
        String r14 = ", action=";
    L18:
        StringBuilder r15 = r12.append(r14).append(r4);
    L19:
        IRunLog.a.a(r9, "UnionEpisodicHandler", r15.toString(), false, 4, null);
        return null;
    L22:
        if (r4 != MemoryBuildApi.Action.INSERT) goto L24;
    L26:
        b r16 = c(r13);
        if (r16 != null) goto L29;
        return null;
    L29:
        String r17 = r16.a();
        es r10 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveEpisodicRelevantDataDao().queryLatestBySourceLink(r17);
        if (r10 != null) goto L32;
        return null;
    L32:
        EpisodicMemoryEntity r11 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityId(r10.b());
        if (r11 != null) goto L35;
    L37:
        if (r6 == true) goto L47;
        r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r18 = new StringBuilder().append("resolveOldEntity skip sourceLink matched non-proactive entity, entityId=");
        if (r11 == null) goto L41;
        String r19 = r11.getEntityId();
    L42:
        StringBuilder r110 = r18.append(r19).append(", productType=");
        if (r11 == null) goto L45;
        Integer r111 = Integer.valueOf(r11.getProductType());
    L46:
        r15 = r110.append(r111);
        goto L19
    L45:
        r111 = null;
        goto L46
    L41:
        r19 = null;
        goto L42
    L47:
        IRunLog r20 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r112 = new StringBuilder().append("resolveOldEntity by sourceLink, source=").append(r16.c()).append(", sourceLinkType=").append(r16.b()).append(", sourceLinkHash=").append(r17.hashCode()).append(", sourceLinkLength=").append(r17.length()).append(", entityId=");
        if (r11 == null) goto L50;
        r8 = r11.getEntityId();
    L50:
        IRunLog.a.a(r20, "UnionEpisodicHandler", r112.append(r8).toString(), false, 4, null);
        return r11;
    L35:
        if (r11.getProductType() != 1003) goto L37;
        r6 = true;
        goto L37
    L24:
        if (r4 == MemoryBuildApi.Action.INSERT_SNAPSHOT) goto L26;
        r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r12 = new StringBuilder();
        r14 = "resolveOldEntity skip sourceLink, action=";
        goto L18
    L14:
        r7 = 0;
        goto L15
    }

    private final String b(String r8) {
        int r7 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), "**", 0, false, 6, null);
        if (r7 < 0) goto L6;
        r8 = r8.substring(0, r7);
        Intrinsics.checkNotNullExpressionValue(r8, "substring(...)");
    L6:
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    private final void b(UnionEpisodicData r3, final EpisodicMemoryEntity r4) {
        final Map<String, String> r5 = l.a(r3.getSpeakerSummary());
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        final PersonalMemoryFrameDb r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        r0.runInTransaction(new $$Lambda$k$W6fIpE8CGcdkM0Il6sNxrd5FWxs(r0, r4, this, r5));
    }

    private final b c(UnionEpisodicData r7) {
        m.a r0 = m.f13098a.a(r7.getSourceInfo());
        String r1 = r0.f();
        if (r1 != null) goto L5;
    L11:
        String r8 = r7.getSessionId();
        if (r8 != null) goto L14;
    L41:
        return null;
    L14:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L17;
        r8 = null;
    L17:
        if (r8 == null) goto L41;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        k r6 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Object r9 = Result.m1421constructorimpl(MemoryBuildService.INSTANCE.resolveProactiveSourceLinkBySession(r8));     // Catch: Throwable -> L21
    L23:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r9);
        if (r3 == null) goto L27;
        RunLog.INSTANCE.error("UnionEpisodicHandler", "resolve sourceLink by session failed, sessionId=" + r8, r3);
    L27:
        if (Result.m1427isFailureimpl(r9) == false) goto L29;
        r9 = null;
    L29:
        MemoryBuildApi.c r10 = (MemoryBuildApi.c) ZeusTransformUtils.preCheckCast(r9, MemoryBuildApi.c.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L41;
        String r11 = r10.a();
        if (r11 == null) goto L41;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L37;
        r11 = null;
    L37:
        if (r11 == null) goto L41;
        return new b(r11, r10.b(), "sessionPageContext");
    L21:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L11;
        return new b(r1, r0.g(), "inlineSourceInfo");
    }

    private final boolean d(UnionEpisodicData r3) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.getSessionId(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L12;
        return false;
    L12:
        return m.f13098a.b(r3.getSourceInfo());
    L5:
        if (r2.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public static /* synthetic */ void lambda$W6fIpE8CGcdkM0Il6sNxrd5FWxs(PersonalMemoryFrameDb r0, EpisodicMemoryEntity r1, k r2, Map r3) {
        a(r0, r1, r2, r3);
    }

    public final String a() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionEpisodicHandler", "start handle data length: " + this.f13094b.length(), false, 4, null);
        List r0 = (List) ZeusTransformUtils.preCheckCast(c.fromJson(this.f13094b, new d().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
    L6:
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        if (r3 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L16;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionEpisodicHandler", "handle error, items is null or empty", null, 4, null);
        return null;
    L16:
        List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r2.hasNext() == false) goto L27;
        Object r6 = r2.next();
        int r7 = r4 + 1;
        if (r4 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        UnionEpisodicData r8 = (UnionEpisodicData) ZeusTransformUtils.preCheckCast(r6, UnionEpisodicData.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("UnionEpisodicHandler", "[LOGID_TRACE][ANDROID_EPISODIC_PARSED] index=" + r4 + " businessType=" + r8.getBusinessType() + " action=" + r8.getAction() + " logId=" + r8.getLogId() + " entityIdList=" + r8.getEntityIdList() + " titleLen=" + r8.getTitle().length() + " contentLen=" + r8.getContent().length());
        EpisodicBuildResultItem r9 = a(r8);
        if (r9 == null) goto L25;
        r1.add(r9);
    L25:
        r4 = r7;
        goto L18
    L27:
        return GsonUtil.INSTANCE.toJson(r1);
    L9:
        if (r3.isEmpty() == true) goto L12;
        r5 = false;
    L5:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionEpisodicHandler", "handle error, fromJson failed: ${e.message}", null, 4, null);
        r0 = null;
        goto L6
    }
}
