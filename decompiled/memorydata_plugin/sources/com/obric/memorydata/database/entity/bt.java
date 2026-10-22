package com.obric.memorydata.database.entity;

import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/database/entity/EpisodicWithRelevantPojo;", "", SlardarSettingsConstants.PERF_KEY_MEMORY, "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "relevantDataList", "", "Lcom/obric/memorydata/database/entity/ProactiveEpisodicRelevantData;", "<init>", "(Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;Ljava/util/List;)V", "getMemory", "()Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "getRelevantDataList", "()Ljava/util/List;", "relevantData", "getRelevantData", "()Lcom/obric/memorydata/database/entity/ProactiveEpisodicRelevantData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EpisodicMemoryEntity f8944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<es> f8945b;

    public bt(EpisodicMemoryEntity r3, List<es> r4) {
        List<es> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, SlardarSettingsConstants.PERF_KEY_MEMORY);
        Intrinsics.checkNotNullParameter(r5, "relevantDataList");
        this.f8944a = r3;
        this.f8945b = r5;
    }

    public final EpisodicMemoryEntity a() {
        return this.f8944a;
    }

    public final es b() {
        return (es) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(this.f8945b), es.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, bt.class) == true) goto L8;
        return false;
    L8:
        bt r6 = (bt) ZeusTransformUtils.preCheckCast(r5, bt.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8944a, r6.f8944a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8945b, r6.f8945b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f8944a.hashCode() * 31) + this.f8945b.hashCode();
    }

    public String toString() {
        return "EpisodicWithRelevantPojo(memory=" + this.f8944a + ", relevantDataList=" + this.f8945b + ')';
    }
}
