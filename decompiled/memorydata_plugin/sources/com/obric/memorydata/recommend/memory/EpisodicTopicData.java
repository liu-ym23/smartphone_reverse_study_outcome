package com.obric.memorydata.recommend.memory;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013JH\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/obric/memorydata/recommend/memory/EpisodicTopicData;", "", "op", "", "summary", "observation", "relatedMemoryIds", "", "", "topicId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;)V", "getOp", "()Ljava/lang/String;", "getSummary", "getObservation", "getRelatedMemoryIds", "()Ljava/util/List;", "getTopicId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;)Lcom/obric/memorydata/recommend/memory/EpisodicTopicData;", "equals", "", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EpisodicTopicData {
    private final String observation;
    private final String op;

    @SerializedName("related_memory_ids")
    private final List<Long> relatedMemoryIds;
    private final String summary;

    @SerializedName("topic_id")
    private final Long topicId;

    public EpisodicTopicData(String r3, String r4, String r5, List<Long> r6, Long r7) {
        List<Long> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "op");
        Intrinsics.checkNotNullParameter(r4, "summary");
        Intrinsics.checkNotNullParameter(r5, "observation");
        Intrinsics.checkNotNullParameter(r8, "relatedMemoryIds");
        this.op = r3;
        this.summary = r4;
        this.observation = r5;
        this.relatedMemoryIds = r8;
        this.topicId = r7;
    }

    public static /* synthetic */ EpisodicTopicData copy$default(EpisodicTopicData r6, String r7, String r8, String r9, List r10, Long r11, int r12, Object r13) {
        List<Long> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.op;
    L5:
        String r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.summary;
    L8:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = r6.observation;
    L11:
        String r3 = r9;
        if ((r12 & 8) == 0) goto L14;
        r14 = r6.relatedMemoryIds;
    L14:
        List<Long> r4 = r14;
        if ((r12 & 16) == 0) goto L18;
        r11 = r6.topicId;
    L18:
        return r6.copy(r1, r2, r3, r4, r11);
    }

    public final String component1() {
        return this.op;
    }

    public final String component2() {
        return this.summary;
    }

    public final String component3() {
        return this.observation;
    }

    public final List<Long> component4() {
        return this.relatedMemoryIds;
    }

    public final Long component5() {
        return this.topicId;
    }

    public final EpisodicTopicData copy(String r7, String r8, String r9, List<Long> r10, Long r11) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "op");
        Intrinsics.checkNotNullParameter(r8, "summary");
        Intrinsics.checkNotNullParameter(r9, "observation");
        Intrinsics.checkNotNullParameter(r4, "relatedMemoryIds");
        return new EpisodicTopicData(r7, r8, r9, r4, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, EpisodicTopicData.class) == true) goto L8;
        return false;
    L8:
        EpisodicTopicData r6 = (EpisodicTopicData) ZeusTransformUtils.preCheckCast(r5, EpisodicTopicData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.op, r6.op) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.summary, r6.summary) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.observation, r6.observation) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.relatedMemoryIds, r6.relatedMemoryIds) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.topicId, r6.topicId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final String getObservation() {
        return this.observation;
    }

    public final String getOp() {
        return this.op;
    }

    public final List<Long> getRelatedMemoryIds() {
        return this.relatedMemoryIds;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final Long getTopicId() {
        return this.topicId;
    }

    public int hashCode() {
        int r0 = ((((((this.op.hashCode() * 31) + this.summary.hashCode()) * 31) + this.observation.hashCode()) * 31) + this.relatedMemoryIds.hashCode()) * 31;
        Long r2 = this.topicId;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "EpisodicTopicData(op=" + this.op + ", summary=" + this.summary + ", observation=" + this.observation + ", relatedMemoryIds=" + this.relatedMemoryIds + ", topicId=" + this.topicId + ')';
    }
}
