package com.obric.memorydata.memory.review.trace;

import com.obric.memorydata.database.dao.RawObservationDao;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.ha;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007J\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeReader;", "", "rawObservationDao", "Lcom/obric/memorydata/database/dao/RawObservationDao;", "<init>", "(Lcom/obric/memorydata/database/dao/RawObservationDao;)V", "readRawObservations", "", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "rawObservationIds", "", "readViewTrees", "", "rawObservations", "readViewTreeFile", "path", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RawObservationDao f10511b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeReader$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10510a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public l(RawObservationDao r3) {
        RawObservationDao r4 = (RawObservationDao) ZeusTransformUtils.wrapperContextForParams(r3, RawObservationDao.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "rawObservationDao");
        this.f10511b = r4;
    }

    public /* synthetic */ l(RawObservationDao r2, int r3, DefaultConstructorMarker r4) {
        RawObservationDao r5 = (RawObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, RawObservationDao.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao();
    L5:
        this(r5);
    }

    private final String a(String r10) {
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        l r9 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        File r11 = new File(r10);     // Catch: Throwable -> L13
        if (r11.isFile() == true) goto L7;
        RunLog.INSTANCE.debug("MemoryTraceReportViewTreeReader", "viewTree file ignored, not file: " + r10);     // Catch: Throwable -> L13
        return null;
    L7:
        String r12 = FilesKt.readText$default(r11, null, 1, null);     // Catch: Throwable -> L13
        if ((true ^ StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L11;
        r12 = null;
    L11:
        Object r13 = Result.m1421constructorimpl(r12);     // Catch: Throwable -> L13
    L15:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r13);
        if (r3 != null) goto L18;
        r1 = r13;
    L20:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    L18:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTraceReportViewTreeReader", "read viewTree file failed, path=" + r10 + ", error=" + r3, null, 4, null);
    L13:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final List<RawObservationEntity> a(List<Long> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "rawObservationIds");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Object r2 = r12.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        r3 = false;
        goto L9
    L11:
        List<Long> r13 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r13.isEmpty() == true) goto L14;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L27
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(((l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin")).f10511b.queryByIds(r13), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r8, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        Iterator r14 = r8.iterator();     // Catch: Throwable -> L27
    L17:
        if (r14.hasNext() == false) goto L19;
        Object r5 = r14.next();     // Catch: Throwable -> L27
        r4.put(Long.valueOf(((RawObservationEntity) ZeusTransformUtils.preCheckCast(r5, RawObservationEntity.class, "com.obric.memorydata.plugin")).getId()), r5);     // Catch: Throwable -> L27
        goto L17
    L19:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L27
    L21:
        if (r16.hasNext() == false) goto L25;
        RawObservationEntity r7 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r4.get(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r16.next(), Number.class, "com.obric.memorydata.plugin")).longValue())), RawObservationEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r7 == null) goto L21;
        r6.add(r7);     // Catch: Throwable -> L27
        goto L21
    L25:
        Object r17 = Result.m1421constructorimpl((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
    L29:
        Throwable r18 = Result.m1424exceptionOrNullimpl(r17);
        if (r18 == null) goto L34;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTraceReportViewTreeReader", "read RawObservations failed, count=" + r13.size() + ", error=" + r18, null, 4, null);
        r17 = CollectionsKt.emptyList();
    L34:
        return (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
    L27:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L29
    L14:
        return CollectionsKt.emptyList();
    }

    public final List<String> b(List<RawObservationEntity> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "rawObservations");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L15;
        String r2 = ha.f9173a.b((RawObservationEntity) ZeusTransformUtils.preCheckCast(r9.next(), RawObservationEntity.class, "com.obric.memorydata.plugin"));
        String r4 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L11;
        r4 = a(r2);
    L11:
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        r0.add(r4);
        goto L4
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }
}
