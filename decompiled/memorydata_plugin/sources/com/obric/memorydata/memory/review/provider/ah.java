package com.obric.memorydata.memory.review.provider;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rH&J*\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rH&J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackStore;", "", LocationMonitorConst.SUBMIT, "Lcom/obric/memorydata/memory/review/model/MemoryReviewSubmitResult;", "feedback", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedback;", "queryStateMap", "", "", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackState;", "module", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "recordIds", "", "queryFeedbackMap", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackInfo;", "querySubmittedFeedbackMap", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ah {
    com.obric.memorydata.memory.review.model.j a(com.obric.memorydata.memory.review.model.c r1);

    Map<String, com.obric.memorydata.memory.review.model.d> a(MemoryReviewModule r1);

    Map<String, com.obric.memorydata.memory.review.model.d> a(MemoryReviewModule r1, List<String> r2);
}
