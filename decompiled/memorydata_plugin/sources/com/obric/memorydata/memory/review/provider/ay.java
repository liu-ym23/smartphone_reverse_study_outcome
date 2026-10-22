package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/RawObservationEvidence;", "", "rawObservationIds", "", "", "rawObservations", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getRawObservationIds", "()Ljava/util/List;", "getRawObservations", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Long> f10431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<RawObservationEntity> f10432b;

    public ay(List<Long> r3, List<RawObservationEntity> r4) {
        List<Long> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<RawObservationEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "rawObservationIds");
        Intrinsics.checkNotNullParameter(r6, "rawObservations");
        this.f10431a = r5;
        this.f10432b = r6;
    }

    public final List<Long> a() {
        return this.f10431a;
    }

    public final List<RawObservationEntity> b() {
        return this.f10432b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ay.class) == true) goto L8;
        return false;
    L8:
        ay r6 = (ay) ZeusTransformUtils.preCheckCast(r5, ay.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10431a, r6.f10431a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10432b, r6.f10432b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f10431a.hashCode() * 31) + this.f10432b.hashCode();
    }

    public String toString() {
        return "RawObservationEvidence(rawObservationIds=" + this.f10431a + ", rawObservations=" + this.f10432b + ')';
    }
}
