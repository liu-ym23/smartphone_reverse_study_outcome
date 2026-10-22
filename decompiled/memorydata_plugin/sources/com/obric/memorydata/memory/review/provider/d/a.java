package com.obric.memorydata.memory.review.provider.d;

import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.iu;
import com.obric.memorydata.memory.review.model.MemoryReviewFeedbackState;
import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.obric.memorydata.memory.review.model.b;
import com.obric.memorydata.memory.review.model.d;
import com.obric.memorydata.memory.review.model.f;
import com.obric.memorydata.memory.review.model.g;
import com.obric.memorydata.memory.review.model.h;
import com.obric.memorydata.memory.review.provider.ae;
import com.obric.memorydata.memory.review.provider.ah;
import com.obric.memorydata.memory.review.provider.aw;
import com.obric.memorydata.memory.review.provider.ba;
import com.obric.memorydata.memory.review.provider.n;
import com.obric.memorydata.memory.review.provider.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/personalmemory/PersonalMemoryReviewProvider;", "Lcom/obric/memorydata/memory/review/provider/BaseMemoryReviewDataProvider;", "pageSource", "Lcom/obric/memorydata/memory/review/provider/PersonalMemoryReviewPageSource;", "feedbackStore", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackStore;", "<init>", "(Lcom/obric/memorydata/memory/review/provider/PersonalMemoryReviewPageSource;Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackStore;)V", "getPage", "Lcom/obric/memorydata/memory/review/model/MemoryReviewPage;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/memory/review/model/MemoryReviewPageRequest;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final aw f10449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f10450b;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public a(aw r3, ah r4) {
        aw r5 = (aw) ZeusTransformUtils.wrapperContextForParams(r3, aw.class, "com.obric.memorydata.plugin");
        ah r6 = (ah) ZeusTransformUtils.wrapperContextForParams(r4, ah.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "pageSource");
        Intrinsics.checkNotNullParameter(r6, "feedbackStore");
        super(MemoryReviewModule.PERSONAL_MEMORY, r6);
        this.f10449a = r5;
        this.f10450b = r6;
    }

    public /* synthetic */ a(aw r10, ah r11, int r12, DefaultConstructorMarker r13) {
        aw r14 = (aw) ZeusTransformUtils.wrapperContextForParams(r10, aw.class, "com.obric.memorydata.plugin");
        ah r15 = (ah) ZeusTransformUtils.wrapperContextForParams(r11, ah.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L6;
        r14 = (aw) ZeusTransformUtils.preCheckCast(new v(null, 1, null), aw.class, "com.obric.memorydata.plugin");
    L6:
        if ((r12 & 2) == 0) goto L8;
        r15 = (ah) ZeusTransformUtils.preCheckCast(new ae(null, null, null, null, null, 31, null), ah.class, "com.obric.memorydata.plugin");
    L8:
        this(r14, r15);
    }

    @Override // com.obric.memorydata.memory.review.provider.n, com.obric.memorydata.memory.review.provider.z
    public f a(g r28) {
        Intrinsics.checkNotNullParameter(r28, Ext.KEY_REQUEST);
        int r1 = r28.e();
        b r3 = com.obric.memorydata.memory.review.model.a.f10381a.a(r28.b());
        aw r4 = this.f10449a;
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
        List<iu> r10 = r4.a(r5, r7, r11, r9, r1 + 1);
        List r12 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"), r1);
        ah r13 = this.f10450b;
        MemoryReviewModule r14 = a();
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L14:
        if (r17.hasNext() == false) goto L16;
        r16.add(String.valueOf(((iu) ZeusTransformUtils.preCheckCast(r17.next(), iu.class, "com.obric.memorydata.plugin")).a()));
        goto L14
    L16:
        Map<String, d> r18 = r13.a(r14, (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"));
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r19.iterator();
    L18:
        if (r21.hasNext() == false) goto L25;
        iu r110 = (iu) ZeusTransformUtils.preCheckCast(r21.next(), iu.class, "com.obric.memorydata.plugin");
        ba r111 = ba.f10439a;
        d r22 = (d) ZeusTransformUtils.preCheckCast(r18.get(String.valueOf(r110.a())), d.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L23;
        MemoryReviewFeedbackState r23 = r22.a();
        if (r23 == null) goto L23;
    L24:
        r20.add(ba.a(r111, r110, null, r23, 2, null));
    L23:
        r23 = MemoryReviewFeedbackState.PENDING;
        goto L24
    L25:
        List<h> r112 = (List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin");
        if (r10.size() <= r1) goto L28;
        boolean r2 = true;
    L29:
        boolean r24 = r2;
        iu r25 = (iu) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r12), iu.class, "com.obric.memorydata.plugin");
        f.a r113 = f.f10389a;
        MemoryReviewModule r114 = a();
        long r115 = r28.c();
        long r116 = r28.d();
        if (r24 == false) goto L33;
        if (r25 == null) goto L33;
        String r0 = com.obric.memorydata.memory.review.model.a.f10381a.a(r28.d(), r25.f(), String.valueOf(r25.a()));
    L35:
        return r113.a(r114, r115, r116, r112, r18, r0, r24);
    L33:
        r0 = null;
        goto L35
    L28:
        r2 = false;
        goto L29
    L5:
        r11 = Long.MAX_VALUE;
        goto L6
    }
}
