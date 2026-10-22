package com.obric.memorydata.memory.inapptrace;

import com.obric.memorydata.database.dao.InAppTraceObservationRow;
import com.obric.memorydata.database.dao.InAppTraceUploadDao;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.cc;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppTraceReportAttachmentStore;", "", "<init>", "()V", "TAG", "", "FRAMEWORK_DELIVERY_GRACE_MS", "", "dao", "Lcom/obric/memorydata/database/dao/InAppTraceUploadDao;", "getDao", "()Lcom/obric/memorydata/database/dao/InAppTraceUploadDao;", "resolve", "Lcom/obric/memorydata/memory/inapptrace/InAppTraceReportAttachmentStore$ResolveResult;", "reportData", "Lorg/json/JSONObject;", "complete", "", "traceRowIds", "", "observationIds", "ResolveResult", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f10168a = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppTraceReportAttachmentStore$ResolveResult;", "", "<init>", "()V", "Ready", "Waiting", "Lcom/obric/memorydata/memory/inapptrace/InAppTraceReportAttachmentStore$ResolveResult$Ready;", "Lcom/obric/memorydata/memory/inapptrace/InAppTraceReportAttachmentStore$ResolveResult$Waiting;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class a {

        /* JADX INFO: renamed from: com.obric.memorydata.memory.inapptrace.f$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppTraceReportAttachmentStore$ResolveResult$Ready;", "Lcom/obric/memorydata/memory/inapptrace/InAppTraceReportAttachmentStore$ResolveResult;", "reportData", "Lorg/json/JSONObject;", "traceRowIds", "", "", "observationIds", "<init>", "(Lorg/json/JSONObject;Ljava/util/List;Ljava/util/List;)V", "getReportData", "()Lorg/json/JSONObject;", "getTraceRowIds", "()Ljava/util/List;", "getObservationIds", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0499a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final JSONObject f10169a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List<Long> f10170b;
            private final List<Long> c;

            public C0499a(JSONObject r3, List<Long> r4, List<Long> r5) {
                List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
                List<Long> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "reportData");
                Intrinsics.checkNotNullParameter(r6, "traceRowIds");
                Intrinsics.checkNotNullParameter(r7, "observationIds");
                super(null);
                this.f10169a = r3;
                this.f10170b = r6;
                this.c = r7;
            }

            public final JSONObject a() {
                return this.f10169a;
            }

            public final List<Long> b() {
                return this.f10170b;
            }

            public final List<Long> c() {
                return this.c;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0499a.class) == true) goto L8;
                return false;
            L8:
                C0499a r6 = (C0499a) ZeusTransformUtils.preCheckCast(r5, C0499a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f10169a, r6.f10169a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f10170b, r6.f10170b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f10169a.hashCode() * 31) + this.f10170b.hashCode()) * 31) + this.c.hashCode();
            }

            public String toString() {
                return "Ready(reportData=" + this.f10169a + ", traceRowIds=" + this.f10170b + ", observationIds=" + this.c + ')';
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppTraceReportAttachmentStore$ResolveResult$Waiting;", "Lcom/obric/memorydata/memory/inapptrace/InAppTraceReportAttachmentStore$ResolveResult;", "observationIds", "", "", "pendingRowIds", "retryAfterMs", "<init>", "(Ljava/util/List;Ljava/util/List;J)V", "getObservationIds", "()Ljava/util/List;", "getPendingRowIds", "getRetryAfterMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List<Long> f10171a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List<Long> f10172b;
            private final long c;

            public b(List<Long> r3, List<Long> r4, long r5) {
                List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                List<Long> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r6, "observationIds");
                Intrinsics.checkNotNullParameter(r7, "pendingRowIds");
                super(null);
                this.f10171a = r6;
                this.f10172b = r7;
                this.c = r5;
            }

            public final List<Long> a() {
                return this.f10171a;
            }

            public final List<Long> b() {
                return this.f10172b;
            }

            public final long c() {
                return this.c;
            }

            public boolean equals(Object r7) {
                if (this != r7) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
                return false;
            L8:
                b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f10171a, r8.f10171a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f10172b, r8.f10172b) == true) goto L15;
                return false;
            L15:
                if (this.c == r8.c) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f10171a.hashCode() * 31) + this.f10172b.hashCode()) * 31) + Long.hashCode(this.c);
            }

            public String toString() {
                return "Waiting(observationIds=" + this.f10171a + ", pendingRowIds=" + this.f10172b + ", retryAfterMs=" + this.c + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10168a = new f();
    }

    private f() {
    }

    private final InAppTraceUploadDao a() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getInAppTraceUploadDao();
    }

    public final a a(JSONObject r22) {
        Intrinsics.checkNotNullParameter(r22, "reportData");
        List<Long> r1 = com.obric.memorydata.memory.review.trace.j.f10497a.c(r22);
        if (r1.isEmpty() == false) goto L7;
        Object r0 = ZeusTransformUtils.preCheckCast(new a.C0499a(r22, CollectionsKt.emptyList(), CollectionsKt.emptyList()), a.class, "com.obric.memorydata.plugin");
    L6:
        return (a) r0;
    L7:
        long r10 = System.currentTimeMillis();
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao().queryScreenshotByIds(r1), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        r4.add(Long.valueOf(((RawObservationEntity) ZeusTransformUtils.preCheckCast(r3.next(), RawObservationEntity.class, "com.obric.memorydata.plugin")).getTimestamp()));
        goto L9
    L11:
        Long r5 = e.f10167a.a((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), r10, 10000);
        if (r5 == null) goto L15;
        a.b r6 = new a.b(r1, CollectionsKt.emptyList(), RangesKt.coerceAtLeast(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue(), 1000));
    L14:
        r0 = ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.memorydata.plugin");
        goto L6
    L15:
        Long r7 = d.f10164a.a((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"), r10);
        if (r7 == null) goto L18;
        r6 = new a.b(r1, CollectionsKt.emptyList(), RangesKt.coerceAtLeast(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).longValue(), 1000));
        goto L14
    L18:
        List<InAppTraceObservationRow> r8 = a().queryLinkedByObservationIds(r1);
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r9.iterator();
    L20:
        if (r12.hasNext() == false) goto L22;
        r11.add(((InAppTraceObservationRow) ZeusTransformUtils.preCheckCast(r12.next(), InAppTraceObservationRow.class, "com.obric.memorydata.plugin")).getTrace());
        goto L20
    L22:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r14 = new HashSet();
        ArrayList r15 = new ArrayList();
        Iterator r16 = r13.iterator();
    L24:
        if (r16.hasNext() == false) goto L28;
        Object r17 = r16.next();
        if (r14.add(Long.valueOf(((cc) ZeusTransformUtils.preCheckCast(r17, cc.class, "com.obric.memorydata.plugin")).a())) == false) goto L24;
        r15.add(r17);
        goto L24
    L28:
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L30:
        if (r20.hasNext() == false) goto L34;
        Object r21 = r20.next();
        if ((!Intrinsics.areEqual(((cc) ZeusTransformUtils.preCheckCast(r21, cc.class, "com.obric.memorydata.plugin")).j(), "TOS_UPLOADED")) == false) goto L30;
        r19.add(r21);
        goto L30
    L34:
        List r23 = (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r23, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L41;
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.memorydata.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r26 = r24.iterator();
    L38:
        if (r26.hasNext() == false) goto L40;
        r25.add(Long.valueOf(((cc) ZeusTransformUtils.preCheckCast(r26.next(), cc.class, "com.obric.memorydata.plugin")).a()));
        goto L38
    L40:
        r0 = ZeusTransformUtils.preCheckCast(new a.b(r1, (List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin"), 1000), a.class, "com.obric.memorydata.plugin");
        goto L6
    L41:
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r29 = r27.iterator();
    L43:
        if (r29.hasNext() == false) goto L45;
        InAppTraceObservationRow r30 = (InAppTraceObservationRow) ZeusTransformUtils.preCheckCast(r29.next(), InAppTraceObservationRow.class, "com.obric.memorydata.plugin");
        cc r31 = r30.getTrace();
        r28.add(new com.obric.memorydata.memory.review.trace.a(r30.getObservationId(), r31.k(), r31.e(), r31.f()));
        goto L43
    L45:
        JSONObject r32 = com.obric.memorydata.memory.review.trace.j.f10497a.a(r22, (List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.memorydata.plugin"));
        Iterable r33 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r34 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r35 = r33.iterator();
    L47:
        if (r35.hasNext() == false) goto L49;
        r34.add(Long.valueOf(((InAppTraceObservationRow) ZeusTransformUtils.preCheckCast(r35.next(), InAppTraceObservationRow.class, "com.obric.memorydata.plugin")).getTrace().a()));
        goto L47
    L49:
        r0 = ZeusTransformUtils.preCheckCast(new a.C0499a(r32, CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r34, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), r1), a.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void a(List<Long> r10, List<Long> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "traceRowIds");
        Intrinsics.checkNotNullParameter(r13, "observationIds");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        a().deleteObservationLinks(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")));
    L6:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
        a().releaseUnreferenced(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")), System.currentTimeMillis());
    L8:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r9.hasNext() == false) goto L14;
        long r14 = ((Number) ZeusTransformUtils.preCheckCast(r9.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        int r0 = f10168a.a().countObservationLinks(r14);
        RunLog.INSTANCE.info("InAppTraceAttachment", "release associated trace id=" + r14 + " remainingLinks=" + r0 + " retentionMs=604800000", true);
        if (r0 <= 0) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppTraceAttachment", "keep shared trace id=" + r14 + " because other observations still reference it", false, 4, null);
        goto L10
    }
}
