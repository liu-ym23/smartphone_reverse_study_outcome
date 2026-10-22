package com.obric.memorydata.memory.review.provider;

import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/BaseMemoryReviewDataProvider;", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewDataProvider;", "module", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "feedbackStore", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackStore;", "<init>", "(Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackStore;)V", "getModule", "()Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "getPage", "Lcom/obric/memorydata/memory/review/model/MemoryReviewPage;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/memory/review/model/MemoryReviewPageRequest;", "submitFeedback", "Lcom/obric/memorydata/memory/review/model/MemoryReviewSubmitResult;", "feedback", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedback;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class n implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MemoryReviewModule f10463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f10464b;

    public n(MemoryReviewModule r3, ah r4) {
        ah r5 = (ah) ZeusTransformUtils.wrapperContextForParams(r4, ah.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r5, "feedbackStore");
        this.f10463a = r3;
        this.f10464b = r5;
    }

    public MemoryReviewModule a() {
        return this.f10463a;
    }

    @Override // com.obric.memorydata.memory.review.provider.z
    public com.obric.memorydata.memory.review.model.f a(com.obric.memorydata.memory.review.model.g r10) {
        Intrinsics.checkNotNullParameter(r10, Ext.KEY_REQUEST);
        return com.obric.memorydata.memory.review.model.f.a.a(com.obric.memorydata.memory.review.model.f.f10389a, a(), 0, 0, 6, null);
    }

    @Override // com.obric.memorydata.memory.review.provider.z
    public com.obric.memorydata.memory.review.model.j a(com.obric.memorydata.memory.review.model.c r2) {
        Intrinsics.checkNotNullParameter(r2, "feedback");
        return this.f10464b.a(r2);
    }
}
