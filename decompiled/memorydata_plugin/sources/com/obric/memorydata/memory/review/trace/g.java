package com.obric.memorydata.memory.review.trace;

import com.bytedance.bdinstall.Api;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.review.provider.am;
import com.obric.memorydata.memory.review.provider.av;
import com.obric.memorydata.memory.review.provider.x;
import com.obric.memorydata.memory.review.provider.y;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001QB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010+\u001a\u00020,J\u0014\u0010-\u001a\u00020,2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/J\u001b\u00101\u001a\u0002022\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0000¢\u0006\u0002\b3J\u001e\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005J\u0014\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;J \u0010=\u001a\u00020,2\u0006\u00105\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005H\u0002J.\u0010@\u001a\u0004\u0018\u00010A2\u0006\u00105\u001a\u00020\u00052\f\u0010B\u001a\b\u0012\u0004\u0012\u00020C0/2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050/H\u0002J\u0010\u0010E\u001a\u00020,2\u0006\u00105\u001a\u00020\u0005H\u0002J \u0010F\u001a\u0002092\u0006\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00052\u0006\u0010G\u001a\u00020HH\u0002J\u0016\u0010I\u001a\u0002092\f\u0010J\u001a\b\u0012\u0004\u0012\u00020K0/H\u0002J\u001e\u0010L\u001a\u0002092\u0006\u00105\u001a\u00020\u00052\f\u0010J\u001a\b\u0012\u0004\u0012\u00020K0/H\u0002J\u0012\u0010M\u001a\u0004\u0018\u00010K2\u0006\u0010N\u001a\u00020<H\u0002J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00020C0/2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0012\u0010P\u001a\b\u0012\u0004\u0012\u00020C0/*\u00020AH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b(\u0010)¨\u0006R"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportFacade;", "", "<init>", "()V", "TAG", "", "KEY_RAW_OBSERVATION_IDS", "SOURCE_MEMORY_BASE_BUILD", "SOURCE_MEMORY_BASE_BUILD_VIEW_TREE", "TOOL_MEMORY_DELETE", "MAX_DELETE_ENTITY_COUNT", "", "viewTreeReader", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeReader;", "getViewTreeReader", "()Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeReader;", "viewTreeReader$delegate", "Lkotlin/Lazy;", "audioUrlReader", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportAudioUrlReader;", "getAudioUrlReader", "()Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportAudioUrlReader;", "audioUrlReader$delegate", "hotwordsReader", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportHotwordsReader;", "getHotwordsReader", "()Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportHotwordsReader;", "hotwordsReader$delegate", "viewTreeFileStore", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore;", "getViewTreeFileStore", "()Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore;", "viewTreeFileStore$delegate", "deleteTraceContextStore", "Lcom/obric/memorydata/memory/review/trace/MemoryDeleteTraceContextStore;", "getDeleteTraceContextStore", "()Lcom/obric/memorydata/memory/review/trace/MemoryDeleteTraceContextStore;", "deleteTraceContextStore$delegate", "inAppTraceRemoteDataSource", "Lcom/obric/memorydata/memory/review/provider/InAppTraceReportRemoteDataSource;", "getInAppTraceRemoteDataSource", "()Lcom/obric/memorydata/memory/review/provider/InAppTraceReportRemoteDataSource;", "inAppTraceRemoteDataSource$delegate", "isMemoryTraceReportEnabled", "", "reportInAppTrace", "items", "", "Lcom/obric/memorydata/memory/api/InAppTraceReportItem;", "reportInAppTraceWithResult", "Lcom/obric/memorydata/memory/review/trace/InAppTraceReportResult;", "reportInAppTraceWithResult$memory_obricRelease", "reportMemoryOps", "logId", AILabCheckPermissionTask.KEY_SOURCE, "memoryOpsJson", "reportDeleteSuccessAsync", "", "appEntities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "reportViewTrees", "reportSource", "rawObservationIdsJson", "writeViewTreeFiles", "Lorg/json/JSONArray;", "observationIds", "", "viewTrees", "isEntryEnabled", "rememberDeleteEntityMappings", "reportData", "Lorg/json/JSONObject;", "reportDeleteSuccess", "deletedEntities", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportFacade$DeletedMemoryTraceEntity;", "queueDeleteTrace", "toDeleteTraceEntity", "appEntity", "parseRawObservationIds", "toLongIds", "DeletedMemoryTraceEntity", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f10488a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f10489b = null;
    private static final Lazy c = null;
    private static final Lazy d = null;
    private static final Lazy e = null;
    private static final Lazy f = null;
    private static final Lazy g = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportFacade$DeletedMemoryTraceEntity;", "", "entityId", "", "entityType", "", Api.KEY_UUID, "lastBuildLogId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getEntityId", "()Ljava/lang/String;", "getEntityType", "()I", "getUuid", "getLastBuildLogId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10491b;
        private final String c;
        private final String d;

        public a(String r2, int r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "entityId");
            this.f10490a = r2;
            this.f10491b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final String a() {
            return this.f10490a;
        }

        public final int b() {
            return this.f10491b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10490a, r6.f10490a) == true) goto L12;
            return false;
        L12:
            if (this.f10491b == r6.f10491b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f10490a.hashCode() * 31) + Integer.hashCode(this.f10491b)) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "DeletedMemoryTraceEntity(entityId=" + this.f10490a + ", entityType=" + this.f10491b + ", uuid=" + this.c + ", lastBuildLogId=" + this.d + ')';
        }
    }

    static {
        f10488a = new g();
        f10489b = LazyKt.lazy($$Lambda$g$WMZXtRanjgm9M_1e3IbUu1__xfw.INSTANCE);
        c = LazyKt.lazy($$Lambda$g$I9D3F7ZIKXzVWDdKMrXpsXolflg.INSTANCE);
        d = LazyKt.lazy($$Lambda$g$X7HNU8wIQwkLZppJgEZa2r63Zl0.INSTANCE);
        e = LazyKt.lazy($$Lambda$g$Z9o26p43X8lxRwmFkGoErIfHHoo.INSTANCE);
        f = LazyKt.lazy($$Lambda$g$7cMhRyM38TBk9MkJZEdK2l3Js0.INSTANCE);
        g = LazyKt.lazy($$Lambda$g$esX1SmM1xd9gqupNdP0JNqLJsFg.INSTANCE);
    }

    private g() {
    }

    private final a a(AppEntity r6) {
        String r5 = r6.getId();
        String r2 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r5 = null;
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        int r0 = cu.f8996a.a(r6.getType());
        String r3 = r6.getUuid();
        if (r3 != null) goto L11;
    L13:
        r3 = null;
    L15:
        if (ZeusTransformUtils.instanceOf(r6, MemoryEntity.class) == false) goto L17;
        MemoryEntity r7 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r6, MemoryEntity.class, "com.obric.memorydata.plugin");
    L18:
        if (r7 == null) goto L25;
        String r8 = r7.getLogId();
        if (r8 == null) goto L25;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L25;
        r2 = r8;
    L25:
        return new a(r5, r0, r3, r2);
    L17:
        r7 = null;
        goto L18
    L11:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L13;
        goto L13
    }

    public static final /* synthetic */ a a(g r0, AppEntity r1) {
        return r0.a(r1);
    }

    private static final String a(a r1) {
        Intrinsics.checkNotNullParameter(r1, "entity");
        return r1.a();
    }

    private final List<Long> a(JSONArray r10) {
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r10.length()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L20;
        Object r3 = r10.opt(((IntIterator) ZeusTransformUtils.preCheckCast(r11, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        Long r4 = null;
        if (r3 == null) goto L17;
        String r5 = r3.toString();
        if (r5 == null) goto L17;
        Long r6 = StringsKt.toLongOrNull(r5);
        if (r6 == null) goto L17;
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L17;
        r4 = r6;
        goto L17
    L14:
        r7 = false;
    L17:
        if (r4 == null) goto L4;
        r1.add(r4);
        goto L4
    L20:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final JSONArray a(String r3, List<Long> r4, List<String> r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.m1421constructorimpl(((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin")).e().a(r3, r6, r7));     // Catch: Throwable -> L5
    L7:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r2);
        if (r8 == null) goto L12;
        RunLog.INSTANCE.error("MemoryTraceReportFacade", "trace viewTrees file write failed, logId=" + r3, r8);
        r2 = null;
    L12:
        return (JSONArray) ZeusTransformUtils.preCheckCast(r2, JSONArray.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final void a(g r3, List r4) {
        List<a> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r3.c(r5);     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L13;
        RunLog.INSTANCE.error("MemoryTraceReportFacade", "delete trace task failed, entityCount=" + r5.size(), r7);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void a(String r7, String r8, JSONObject r9) {
        JSONObject r10 = r9.optJSONObject("memoryOps");
        if (r10 != null) goto L5;
        return;
    L5:
        c r6 = f().a(r7, r8, r10);
        if (r6 != null) goto L8;
        return;
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTraceReportFacade", "delete entity mappings cached, logId=" + r8 + ", mappedCount=" + r6.a() + ", evictedCount=" + r6.b() + ", retainedCount=" + r6.c(), false, 4, null);
    }

    private final void a(String r11, List<a> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        JSONArray r0 = new JSONArray();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.memorydata.plugin");
        JSONObject r5 = new JSONObject();
        String r6 = r3.c();
        String r7 = "";
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        JSONObject r4 = r5.put(Api.KEY_UUID, r6).put("entityId", r3.a()).put("toolName", "Memory_Delete").put("entityType", r3.b()).put("operateType", "delete");
        String r8 = r3.d();
        if (r8 == null) goto L12;
        r7 = r8;
    L12:
        r0.put(r4.put("lastBuildLogId", r7));
        goto L4
    L13:
        JSONObject r1 = new JSONObject().put("insert", new JSONArray()).put(BuildConfig.CHANNEL, new JSONArray()).put("delete", r0).put("search", new JSONArray()).put(Params.PROMPT, new JSONArray());
        j r9 = j.f10497a;
        String r10 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
        JSONObject r14 = r9.a("Memory_OperateNew", r10);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L16
        g r16 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        com.obric.memorydata.memory.review.b r17 = com.obric.memorydata.memory.review.b.f10376a;     // Catch: Throwable -> L16
        String r18 = r14.toString();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r18, "toString(...)");     // Catch: Throwable -> L16
        Object r19 = Result.m1421constructorimpl(Long.valueOf(r17.a(r11, r18)));     // Catch: Throwable -> L16
    L19:
        if (Result.m1428isSuccessimpl(r19) == false) goto L24;
        long r20 = ((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r20 <= 0) goto L23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTraceReportFacade", "delete trace queued, logId=" + r11 + ", rowId=" + r20 + ", entityCount=" + r13.size() + ", source=Memory_OperateNew", false, 4, null);
        goto L24
    L23:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTraceReportFacade", "delete trace skipped, reason=queue_failed, logId=" + r11, false, 4, null);
    L24:
        Throwable r110 = Result.m1424exceptionOrNullimpl(r19);
        if (r110 == null) goto L33;
        RunLog.INSTANCE.error("MemoryTraceReportFacade", "delete trace queue failed, logId=" + r11, r110);
        return;
    L33:
        return;
    L16:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    private final boolean a(String r7) {
        if (com.obric.memorydata.database.c.b.f8850a.a() == false) goto L6;
        return true;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTraceReportFacade", "trace report skipped, entry disabled, logId=" + r7, false, 4, null);
        return false;
    }

    private final l b() {
        return (l) ZeusTransformUtils.preCheckCast(f10489b.getValue(), l.class, "com.obric.memorydata.plugin");
    }

    private final List<Long> b(String r6) {
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        g r5 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        List<Long> r4 = null;
        if (StringsKt.startsWith$default(r7, "[", false, 2, null) == false) goto L10;
        List<Long> r8 = r5.a(new JSONArray(r7));     // Catch: Throwable -> L19
    L17:
        Object r9 = Result.m1421constructorimpl(r8);     // Catch: Throwable -> L19
    L21:
        List r10 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r9) == false) goto L25;
        r9 = r10;
    L25:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
    L10:
        if (StringsKt.startsWith$default(r7, "{", false, 2, null) == false) goto L15;
        JSONArray r11 = new JSONObject(r7).optJSONArray("rawObservationIds");     // Catch: Throwable -> L19
        if (r11 == null) goto L14;
        r4 = r5.a(r11);     // Catch: Throwable -> L19
    L14:
        if (r4 == null) goto L15;
        r8 = r4;
    L15:
        r8 = CollectionsKt.emptyList();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L21
    L5:
        return CollectionsKt.emptyList();
    }

    private final boolean b(String r23, String r24, String r25) {
        List<Long> r2 = b(r25);
        if (r2.isEmpty() == false) goto L7;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = new StringBuilder();
        String r4 = "trace viewTrees skipped, reason=no_raw_observation_ids, logId=";
    L5:
        IRunLog.a.a(r0, "MemoryTraceReportFacade", r3.append(r4).append(r23).toString(), false, 4, null);
        return false;
    L7:
        List<RawObservationEntity> r11 = b().a(r2);
        if (r11.isEmpty() == false) goto L10;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = new StringBuilder();
        r4 = "trace data skipped, reason=no_raw_observation, logId=";
        goto L5
    L10:
        List<String> r12 = b().b(r11);
        List<String> r13 = c().a(r11);
        JSONArray r7 = d().a(r11);
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r5.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        r6.add(Long.valueOf(((RawObservationEntity) ZeusTransformUtils.preCheckCast(r8.next(), RawObservationEntity.class, "com.obric.memorydata.plugin")).getId()));
        goto L12
    L14:
        JSONArray r9 = a(r23, (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), r12);
        if (r9 != null) goto L17;
        return false;
    L17:
        String r10 = j.f10497a.a(r24, i.f10494a.a(r11), r9, r13, r7).toString();
        Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L20
        g r1 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Object r15 = Result.m1421constructorimpl(Long.valueOf(com.obric.memorydata.memory.review.b.f10376a.a(r23, r10)));     // Catch: Throwable -> L20
    L23:
        if (Result.m1428isSuccessimpl(r15) == false) goto L54;
        long r16 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r16 > 0) goto L27;
        f10488a.e().a(r10);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTraceReportFacade", "trace viewTrees skipped, reason=queue_failed, logId=" + r23 + ", source=" + r24, false, 4, null);
        goto L54
    L27:
        IRunLog r17 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r18 = new StringBuilder().append("trace data queued, logId=").append(r23).append(", rowId=").append(r16).append(", source=").append(r24).append(", observationCount=").append(r11.size()).append(", viewTreeSlotCount=").append(r12.size()).append(", viewTreeContentCount=");
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r19, Collection.class) == true) goto L30;
    L32:
        Iterator r20 = r19.iterator();
        int r110 = 0;
    L34:
        if (r20.hasNext() == false) goto L40;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r20.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L34;
        r110 = r110 + 1;
        if (r110 >= 0) goto L34;
        CollectionsKt.throwCountOverflow();
    L40:
        StringBuilder r21 = r18.append(r110).append(", audioUrlSlotCount=").append(r13.size()).append(", audioUrlContentCount=");
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r22, Collection.class) == true) goto L43;
    L45:
        Iterator r26 = r22.iterator();
        int r111 = 0;
    L47:
        if (r26.hasNext() == false) goto L53;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r26.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L47;
        r111 = r111 + 1;
        if (r111 >= 0) goto L47;
        CollectionsKt.throwCountOverflow();
    L53:
        IRunLog.a.a(r17, "MemoryTraceReportFacade", r21.append(r111).toString(), false, 4, null);
        goto L54
    L43:
        if (((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L45;
        r111 = 0;
        goto L53
    L30:
        if (((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L32;
        r110 = 0;
    L54:
        Throwable r27 = Result.m1424exceptionOrNullimpl(r15);
        if (r27 == null) goto L58;
        f10488a.e().a(r10);
        RunLog.INSTANCE.error("MemoryTraceReportFacade", "trace viewTrees queue failed, logId=" + r23 + ", source=" + r24, r27);
    L58:
        if (Result.m1427isFailureimpl(r15) == false) goto L61;
        r15 = 0L;
    L61:
        if (((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).longValue() > 0) goto L82;
        return false;
    L82:
        return true;
    L20:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    private final f c() {
        return (f) ZeusTransformUtils.preCheckCast(c.getValue(), f.class, "com.obric.memorydata.plugin");
    }

    private final void c(List<a> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        boolean r0 = com.obric.memorydata.database.c.b.f8850a.a();
        d r8 = f();
        if (r0 == true) goto L7;
        r8.a();
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        int r4 = 4;
        Object r5 = null;
        String r2 = "MemoryTraceReportFacade";
        String r6 = "delete trace skipped, reason=entry_disabled";
    L5:
        IRunLog.a.a(r1, r2, r6, r3, r4, r5);
        return;
    L7:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r7.iterator();
    L9:
        if (r12.hasNext() == false) goto L11;
        r11.add(((a) ZeusTransformUtils.preCheckCast(r12.next(), a.class, "com.obric.memorydata.plugin")).a());
        goto L9
    L11:
        List<e> r13 = r8.a((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        if (r13.isEmpty() == false) goto L14;
        r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = "delete trace skipped, reason=no_confirmation_log_id, entityCount=" + r10.size();
        r3 = false;
        r4 = 4;
        r5 = null;
        r2 = "MemoryTraceReportFacade";
        goto L5
    L14:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Map r15 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r14, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L16:
        if (r16.hasNext() == false) goto L18;
        Object r17 = r16.next();
        r15.put(((a) ZeusTransformUtils.preCheckCast(r17, a.class, "com.obric.memorydata.plugin")).a(), r17);
        goto L16
    L18:
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Map r19 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L20:
        if (r20.hasNext() == false) goto L25;
        Object r21 = r20.next();
        String r22 = ((e) ZeusTransformUtils.preCheckCast(r21, e.class, "com.obric.memorydata.plugin")).b();
        Object r23 = r19.get(r22);
        if (r23 != null) goto L24;
        r23 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r19.put(r22, r23);
    L24:
        ((List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin")).add(r21);
        goto L20
    L25:
        Iterator r24 = r19.entrySet().iterator();
    L27:
        if (r24.hasNext() == false) goto L37;
        Map.Entry r25 = (Map.Entry) ZeusTransformUtils.preCheckCast(r24.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r26 = (String) ZeusTransformUtils.preCheckCast(r25.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r29 = r27.iterator();
    L30:
        if (r29.hasNext() == false) goto L34;
        a r30 = (a) ZeusTransformUtils.preCheckCast(r15.get(((e) ZeusTransformUtils.preCheckCast(r29.next(), e.class, "com.obric.memorydata.plugin")).a()), a.class, "com.obric.memorydata.plugin");
        if (r30 == null) goto L30;
        r28.add(r30);
        goto L30
    L34:
        List<a> r31 = (List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r31, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L27;
        f10488a.a(r26, r31);
        goto L27
    L37:
        int r32 = r10.size() - r13.size();
        if (r32 <= 0) goto L56;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTraceReportFacade", "delete trace partially skipped, reason=no_log_id, entityCount=" + r32, false, 4, null);
        return;
    }

    private final h d() {
        return (h) ZeusTransformUtils.preCheckCast(d.getValue(), h.class, "com.obric.memorydata.plugin");
    }

    private final k e() {
        return (k) ZeusTransformUtils.preCheckCast(e.getValue(), k.class, "com.obric.memorydata.plugin");
    }

    private final d f() {
        return (d) ZeusTransformUtils.preCheckCast(f.getValue(), d.class, "com.obric.memorydata.plugin");
    }

    private final x g() {
        return (x) ZeusTransformUtils.preCheckCast(g.getValue(), x.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final l h() {
        return new l(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final f i() {
        return new f(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final h j() {
        Object[] r1 = 0 == true ? 1 : 0;
        return new h(null, r1, 3, 0 == true ? 1 : 0);
    }

    private static final k k() {
        return k.f10498a.a();
    }

    private static final d l() {
        return new d(0, 1, null);
    }

    /* JADX INFO: renamed from: lambda$-7cMhRyM38TBk9MkJZEdK2l3Js0, reason: not valid java name */
    public static /* synthetic */ d m755lambda$7cMhRyM38TBk9MkJZEdK2l3Js0() {
        return l();
    }

    public static /* synthetic */ f lambda$I9D3F7ZIKXzVWDdKMrXpsXolflg() {
        return i();
    }

    public static /* synthetic */ l lambda$WMZXtRanjgm9M_1e3IbUu1__xfw() {
        return h();
    }

    public static /* synthetic */ h lambda$X7HNU8wIQwkLZppJgEZa2r63Zl0() {
        return j();
    }

    public static /* synthetic */ k lambda$Z9o26p43X8lxRwmFkGoErIfHHoo() {
        return k();
    }

    public static /* synthetic */ x lambda$esX1SmM1xd9gqupNdP0JNqLJsFg() {
        return m();
    }

    public static /* synthetic */ void lambda$iGCL4AG5rkUmQlWJEpf6YxOZxnw(g r0, List r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$mhcY7npdnJDXCRQVNkGN-kBDhME, reason: not valid java name */
    public static /* synthetic */ String m756lambda$mhcY7npdnJDXCRQVNkGNkBDhME(a r0) {
        return a(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final x m() {
        return (x) ZeusTransformUtils.preCheckCast(new av(null, 1, 0 == true ? 1 : 0), x.class, "com.obric.memorydata.plugin");
    }

    public final void a(Collection<? extends AppEntity> r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "appEntities");
        if (com.obric.memorydata.database.c.b.f8850a.a() == true) goto L8;
        f().a();
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        int r4 = 4;
        Object r5 = null;
        String r1 = "MemoryTraceReportFacade";
        String r2 = "delete trace skipped before scheduling, reason=entry_disabled";
    L5:
        IRunLog.a.a(r0, r1, r2, r3, r4, r5);
        return;
    L8:
        if (r8.isEmpty() == false) goto L10;
        return;
    L10:
        final List r9 = SequencesKt.toList(SequencesKt.take(SequencesKt.distinctBy(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(new MemoryTraceReportFacade$reportDeleteSuccessAsync$deletedEntities$1(this), Function1.class, "com.obric.memorydata.plugin")), $$Lambda$g$mhcY7npdnJDXCRQVNkGNkBDhME.INSTANCE), 101));
        if (r9.isEmpty() == false) goto L14;
        return;
    L14:
        if (r9.size() <= 100) goto L24;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = false;
        r4 = 4;
        r5 = null;
        r1 = "MemoryTraceReportFacade";
        r2 = "delete trace skipped, reason=too_many_entities, max=100";
        goto L5
    L24:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L18
        final g r10 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$g$iGCL4AG5rkUmQlWJEpf6YxOZxnw(r10, r9));     // Catch: Throwable -> L18
        Object r11 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r11);
        if (r12 == null) goto L26;
        RunLog.INSTANCE.error("MemoryTraceReportFacade", "delete trace schedule failed, entityCount=" + r9.size(), r12);
        return;
    L26:
        return;
    L18:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public final boolean a() {
        return com.obric.memorydata.database.c.b.f8850a.a();
    }

    public final boolean a(String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "logId");
        Intrinsics.checkNotNullParameter(r14, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r15, "memoryOpsJson");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L7;
        r13 = null;
    L7:
        if (r13 != null) goto L10;
        return false;
    L10:
        if (a(r13) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r14, "memory_base_build_view_tree") == true) goto L15;
        JSONObject r16 = j.f10497a.a(r14, r15);
        if (j.f10497a.b(r16) == true) goto L19;
        return false;
    L19:
        a(r14, r13, r16);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L22
        g r12 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        com.obric.memorydata.memory.review.b r17 = com.obric.memorydata.memory.review.b.f10376a;     // Catch: Throwable -> L22
        String r18 = r16.toString();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullExpressionValue(r18, "toString(...)");     // Catch: Throwable -> L22
        Object r19 = Result.m1421constructorimpl(Long.valueOf(r17.a(r13, r18)));     // Catch: Throwable -> L22
    L25:
        if (Result.m1428isSuccessimpl(r19) == false) goto L27;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTraceReportFacade", "trace ops queued, logId=" + r13 + ", rowId=" + ((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).longValue() + ", source=" + r14, false, 4, null);
    L27:
        Throwable r110 = Result.m1424exceptionOrNullimpl(r19);
        if (r110 == null) goto L31;
        RunLog.INSTANCE.error("MemoryTraceReportFacade", "trace ops queue failed, logId=" + r13 + ", source=" + r14, r110);
    L31:
        if (Result.m1427isFailureimpl(r19) == false) goto L34;
        r19 = 0L;
    L34:
        if (((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L37;
        return true;
    L37:
        return false;
    L22:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    L15:
        return b(r13, "memory_base_build", r15);
    }

    public final boolean a(List<com.obric.memorydata.memory.api.b> r3) {
        List<com.obric.memorydata.memory.api.b> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "items");
        return b(r4).a();
    }

    public final b b(List<com.obric.memorydata.memory.api.b> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "items");
        if (r13.isEmpty() == true) goto L5;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L8:
        if (r15.hasNext() == false) goto L28;
        com.obric.memorydata.memory.api.b r3 = (com.obric.memorydata.memory.api.b) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.memorydata.memory.api.b.class, "com.obric.memorydata.plugin");
        String r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        r2 = null;
    L16:
        String r5 = r2;
        if (r5 == null) goto L19;
        if (r3.b() <= 0) goto L27;
        if (r3.c() < r3.b()) goto L27;
        r0.add(com.obric.memorydata.memory.api.b.a(r3, r5, 0, 0, 6, null));
    L27:
        return new b(false, -1, "invalid timestamp range", "", "");
    L19:
        return new b(false, -1, "empty TOS URI", "", "");
    L12:
        r4 = false;
        goto L13
    L28:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        am r11 = g().a(new y(r16, System.currentTimeMillis()));
        return new b(r11.a(), r11.c(), r11.b(), r11.e(), r11.d());
    L5:
        return new b(false, -1, "empty items", "", "");
    }
}
