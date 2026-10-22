package com.obric.memorydata.memory.review.provider.c;

import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.bt;
import com.obric.memorydata.memory.review.model.MemoryReviewFeedbackState;
import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.obric.memorydata.memory.review.model.b;
import com.obric.memorydata.memory.review.model.d;
import com.obric.memorydata.memory.review.model.f;
import com.obric.memorydata.memory.review.model.g;
import com.obric.memorydata.memory.review.model.h;
import com.obric.memorydata.memory.review.provider.ae;
import com.obric.memorydata.memory.review.provider.ah;
import com.obric.memorydata.memory.review.provider.n;
import com.obric.memorydata.memory.review.provider.o;
import com.obric.memorydata.memory.review.provider.s;
import com.obric.memorydata.memory.review.provider.w;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/collectionmemory/CollectionMemoryReviewProvider;", "Lcom/obric/memorydata/memory/review/provider/BaseMemoryReviewDataProvider;", "pageSource", "Lcom/obric/memorydata/memory/review/provider/CollectionMemoryReviewPageSource;", "feedbackStore", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackStore;", "<init>", "(Lcom/obric/memorydata/memory/review/provider/CollectionMemoryReviewPageSource;Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackStore;)V", "getPage", "Lcom/obric/memorydata/memory/review/model/MemoryReviewPage;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/memory/review/model/MemoryReviewPageRequest;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0513a f10445a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f10446b;
    private final ah c;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.review.provider.c.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/collectionmemory/CollectionMemoryReviewProvider$Companion;", "", "<init>", "()V", "FIRST_CURSOR_ENTITY_ID", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0513a {
        private C0513a() {
        }

        public /* synthetic */ C0513a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10445a = new C0513a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public a(o r3, ah r4) {
        o r5 = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.memorydata.plugin");
        ah r6 = (ah) ZeusTransformUtils.wrapperContextForParams(r4, ah.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "pageSource");
        Intrinsics.checkNotNullParameter(r6, "feedbackStore");
        super(MemoryReviewModule.COLLECTION_MEMORY, r6);
        this.f10446b = r5;
        this.c = r6;
    }

    public /* synthetic */ a(o r10, ah r11, int r12, DefaultConstructorMarker r13) {
        o r14 = (o) ZeusTransformUtils.wrapperContextForParams(r10, o.class, "com.obric.memorydata.plugin");
        ah r15 = (ah) ZeusTransformUtils.wrapperContextForParams(r11, ah.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L6;
        r14 = (o) ZeusTransformUtils.preCheckCast(new s(null, 1, null), o.class, "com.obric.memorydata.plugin");
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
        o r4 = this.f10446b;
        long r5 = r28.c();
        long r7 = r28.d();
        if (r3 == null) goto L5;
        long r9 = r3.b();
    L6:
        if (r3 == null) goto L9;
        String r6 = r3.c();
        if (r6 == null) goto L9;
    L10:
        List<bt> r8 = r4.a(r5, r7, r9, r6, r1 + 1);
        List r10 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), r1);
        ah r11 = this.c;
        MemoryReviewModule r12 = a();
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        r14.add(((bt) ZeusTransformUtils.preCheckCast(r15.next(), bt.class, "com.obric.memorydata.plugin")).a().getEntityId());
        goto L12
    L14:
        Map<String, d> r16 = r11.a(r12, (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"));
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L16:
        if (r19.hasNext() == false) goto L23;
        bt r20 = (bt) ZeusTransformUtils.preCheckCast(r19.next(), bt.class, "com.obric.memorydata.plugin");
        w r110 = w.f10473a;
        d r111 = (d) ZeusTransformUtils.preCheckCast(r16.get(r20.a().getEntityId()), d.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L21;
        MemoryReviewFeedbackState r112 = r111.a();
        if (r112 == null) goto L21;
    L22:
        r18.add(r110.a(r20, r112));
    L21:
        r112 = MemoryReviewFeedbackState.PENDING;
        goto L22
    L23:
        List<h> r113 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
        if (r8.size() <= r1) goto L26;
        boolean r2 = true;
    L27:
        boolean r21 = r2;
        bt r22 = (bt) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r10), bt.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L30;
        EpisodicMemoryEntity r23 = r22.a();
    L31:
        f.a r114 = f.f10389a;
        MemoryReviewModule r115 = a();
        long r116 = r28.c();
        long r117 = r28.d();
        if (r21 == false) goto L35;
        if (r23 == null) goto L35;
        String r118 = com.obric.memorydata.memory.review.model.a.f10381a.a(r28.d(), r23.getModifyTime(), r23.getEntityId());
    L37:
        return r114.a(r115, r116, r117, r113, r16, r118, r21);
    L35:
        r118 = null;
        goto L37
    L30:
        r23 = null;
        goto L31
    L26:
        r2 = false;
    L9:
        r6 = "\uffff";
        goto L10
    L5:
        r9 = Long.MAX_VALUE;
        goto L6
    }
}
