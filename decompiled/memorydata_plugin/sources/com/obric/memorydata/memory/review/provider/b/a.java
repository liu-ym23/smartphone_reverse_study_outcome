package com.obric.memorydata.memory.review.provider.b;

import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.aa;
import com.obric.memorydata.memory.review.model.MemoryReviewFeedbackState;
import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.obric.memorydata.memory.review.model.d;
import com.obric.memorydata.memory.review.model.f;
import com.obric.memorydata.memory.review.model.g;
import com.obric.memorydata.memory.review.model.h;
import com.obric.memorydata.memory.review.provider.ae;
import com.obric.memorydata.memory.review.provider.ah;
import com.obric.memorydata.memory.review.provider.ak;
import com.obric.memorydata.memory.review.provider.al;
import com.obric.memorydata.memory.review.provider.ay;
import com.obric.memorydata.memory.review.provider.az;
import com.obric.memorydata.memory.review.provider.ba;
import com.obric.memorydata.memory.review.provider.m;
import com.obric.memorydata.memory.review.provider.n;
import com.obric.memorydata.memory.review.provider.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002J\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/automemorypro/AutoMemoryProReviewProvider;", "Lcom/obric/memorydata/memory/review/provider/BaseMemoryReviewDataProvider;", "pageSource", "Lcom/obric/memorydata/memory/review/provider/AutoMemoryProReviewPageSource;", "feedbackStore", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackStore;", "rawObservationStore", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewRawObservationStore;", "ruleTitleStore", "Lcom/obric/memorydata/memory/review/provider/automemorypro/MemoryReviewRuleTitleStore;", "<init>", "(Lcom/obric/memorydata/memory/review/provider/AutoMemoryProReviewPageSource;Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackStore;Lcom/obric/memorydata/memory/review/provider/MemoryReviewRawObservationStore;Lcom/obric/memorydata/memory/review/provider/automemorypro/MemoryReviewRuleTitleStore;)V", "getPage", "Lcom/obric/memorydata/memory/review/model/MemoryReviewPage;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/memory/review/model/MemoryReviewPageRequest;", "toJsonObjectOrEmpty", "Lorg/json/JSONObject;", "", "ruleIdFromSnapshotJson", "", "Lcom/obric/memorydata/database/entity/AutoMemoryProSnapShotEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f10436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f10437b;
    private final al c;
    private final c d;

    public a() {
        this(null, null, null, null, 15, null);
    }

    public a(m r3, ah r4, al r5, c r6) {
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        ah r8 = (ah) ZeusTransformUtils.wrapperContextForParams(r4, ah.class, "com.obric.memorydata.plugin");
        al r9 = (al) ZeusTransformUtils.wrapperContextForParams(r5, al.class, "com.obric.memorydata.plugin");
        c r10 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "pageSource");
        Intrinsics.checkNotNullParameter(r8, "feedbackStore");
        Intrinsics.checkNotNullParameter(r9, "rawObservationStore");
        Intrinsics.checkNotNullParameter(r10, "ruleTitleStore");
        super(MemoryReviewModule.AUTO_MEMORY_PRO, r8);
        this.f10436a = r7;
        this.f10437b = r8;
        this.c = r9;
        this.d = r10;
    }

    public /* synthetic */ a(m r17, ah r18, al r19, c r20, int r21, DefaultConstructorMarker r22) {
        m r0 = (m) ZeusTransformUtils.wrapperContextForParams(r17, m.class, "com.obric.memorydata.plugin");
        ah r2 = (ah) ZeusTransformUtils.wrapperContextForParams(r18, ah.class, "com.obric.memorydata.plugin");
        al r3 = (al) ZeusTransformUtils.wrapperContextForParams(r19, al.class, "com.obric.memorydata.plugin");
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r20, c.class, "com.obric.memorydata.plugin");
        if ((r21 & 1) == 0) goto L6;
        r0 = (m) ZeusTransformUtils.preCheckCast(new r(null, 1, null), m.class, "com.obric.memorydata.plugin");
    L6:
        if ((r21 & 2) == 0) goto L9;
        r2 = (ah) ZeusTransformUtils.preCheckCast(new ae(null, null, null, null, null, 31, null), ah.class, "com.obric.memorydata.plugin");
    L9:
        if ((r21 & 4) == 0) goto L12;
        r3 = (al) ZeusTransformUtils.preCheckCast(new ak(null, 1, null), al.class, "com.obric.memorydata.plugin");
    L12:
        if ((r21 & 8) == 0) goto L14;
        r4 = (c) ZeusTransformUtils.preCheckCast(new b(null, 1, null), c.class, "com.obric.memorydata.plugin");
    L14:
        this(r0, r2, r3, r4);
    }

    private final long a(aa r3) {
        return a(r3.e()).optLong("ruleId", 0);
    }

    private final JSONObject a(String r2) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L4
        Object r3 = Result.m1421constructorimpl(new JSONObject(r2));     // Catch: Throwable -> L4
    L6:
        JSONObject r4 = new JSONObject();
        if (Result.m1427isFailureimpl(r3) == false) goto L10;
        r3 = r4;
    L10:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin");
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.memorydata.memory.review.provider.n, com.obric.memorydata.memory.review.provider.z
    public f a(g r28) {
        Intrinsics.checkNotNullParameter(r28, Ext.KEY_REQUEST);
        int r1 = r28.e();
        com.obric.memorydata.memory.review.model.b r3 = com.obric.memorydata.memory.review.model.a.f10381a.a(r28.b());
        m r4 = this.f10436a;
        long r5 = r28.c();
        long r7 = r28.d();
        long r9 = Long.MAX_VALUE;
        if (r3 == null) goto L5;
        long r11 = r3.b();
    L6:
        if (r3 == null) goto L12;
        String r6 = r3.c();
        if (r6 == null) goto L12;
        Long r8 = StringsKt.toLongOrNull(r6);
        if (r8 == null) goto L12;
        r9 = r8.longValue();
    L12:
        List<aa> r10 = r4.a(r5, r7, r11, r9, r1 + 1);
        List r12 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"), r1);
        ah r13 = this.f10437b;
        MemoryReviewModule r14 = a();
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L14:
        if (r17.hasNext() == false) goto L16;
        r16.add(String.valueOf(((aa) ZeusTransformUtils.preCheckCast(r17.next(), aa.class, "com.obric.memorydata.plugin")).a()));
        goto L14
    L16:
        Map<String, d> r18 = r13.a(r14, (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"));
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Map r20 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r19, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r21 = r19.iterator();
    L18:
        if (r21.hasNext() == false) goto L20;
        aa r22 = (aa) ZeusTransformUtils.preCheckCast(r21.next(), aa.class, "com.obric.memorydata.plugin");
        Pair r23 = TuplesKt.to(Long.valueOf(r22.a()), az.f10433a.a(a(r22.e())));
        r20.put(r23.getFirst(), r23.getSecond());
        goto L18
    L20:
        c r24 = this.d;
        Iterable r25 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r26 = r25.iterator();
    L21:
        Long r111 = null;
        if (r26.hasNext() == false) goto L31;
        Long r112 = Long.valueOf(a((aa) ZeusTransformUtils.preCheckCast(r26.next(), aa.class, "com.obric.memorydata.plugin")));
        if (((Number) ZeusTransformUtils.preCheckCast(r112, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L26;
        boolean r113 = true;
    L27:
        if (r113 == false) goto L29;
        r111 = r112;
    L29:
        if (r111 == null) goto L21;
        r110.add(r111);
        goto L21
    L26:
        r113 = false;
        goto L27
    L31:
        Map<Long, String> r27 = r24.a((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
        Map<Long, ay> r29 = this.c.b(r20);
        Iterable r30 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r114 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r31 = r30.iterator();
    L33:
        if (r31.hasNext() == false) goto L52;
        aa r115 = (aa) ZeusTransformUtils.preCheckCast(r31.next(), aa.class, "com.obric.memorydata.plugin");
        ay r116 = (ay) ZeusTransformUtils.preCheckCast(r29.get(Long.valueOf(r115.a())), ay.class, "com.obric.memorydata.plugin");
        ba r117 = ba.f10439a;
        if (r116 == null) goto L37;
        List<Long> r118 = r116.a();
    L38:
        if (r118 != null) goto L40;
        r118 = CollectionsKt.emptyList();
    L40:
        List<Long> r210 = r118;
        if (r116 == null) goto L43;
        List<RawObservationEntity> r119 = r116.b();
    L44:
        if (r119 != null) goto L46;
        r119 = CollectionsKt.emptyList();
    L46:
        List<RawObservationEntity> r211 = r119;
        d r120 = (d) ZeusTransformUtils.preCheckCast(r18.get(String.valueOf(r115.a())), d.class, "com.obric.memorydata.plugin");
        if (r120 == null) goto L50;
        MemoryReviewFeedbackState r121 = r120.a();
        if (r121 == null) goto L50;
    L51:
        r114.add(r117.a(r115, r27, r210, r211, r121));
    L50:
        r121 = MemoryReviewFeedbackState.PENDING;
        goto L51
    L43:
        r119 = null;
        goto L44
    L37:
        r118 = null;
        goto L38
    L52:
        List<h> r122 = (List) ZeusTransformUtils.preCheckCast(r114, List.class, "com.obric.memorydata.plugin");
        if (r10.size() <= r1) goto L55;
        boolean r212 = true;
    L56:
        aa r2 = (aa) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r12), aa.class, "com.obric.memorydata.plugin");
        f.a r123 = f.f10389a;
        MemoryReviewModule r124 = a();
        long r125 = r28.c();
        long r32 = r28.d();
        if (r212 == false) goto L60;
        if (r2 == null) goto L60;
        String r126 = com.obric.memorydata.memory.review.model.a.f10381a.a(r28.d(), r2.f(), String.valueOf(r2.a()));
    L62:
        return r123.a(r124, r125, r32, r122, r18, r126, r212);
    L60:
        r126 = null;
        goto L62
    L55:
        r212 = false;
        goto L56
    L5:
        r11 = Long.MAX_VALUE;
        goto L6
    }
}
