package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\tHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/database/index/LegacyOwnerBuildTypeDeleteSpec;", "Lcom/obric/memorydata/database/index/PendingDeleteSpec;", "rawDbIds", "", "", "entityTypes", "", "", "buildTypes", "", "<init>", "(Ljava/util/List;Ljava/util/Set;Ljava/util/Set;)V", "getRawDbIds", "()Ljava/util/List;", "getEntityTypes", "()Ljava/util/Set;", "getBuildTypes", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ar implements ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Long> f9379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Integer> f9380b;
    private final Set<String> c;

    public ar(List<Long> r3, Set<Integer> r4, Set<String> r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Set<Integer> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "rawDbIds");
        Intrinsics.checkNotNullParameter(r7, "entityTypes");
        Intrinsics.checkNotNullParameter(r8, "buildTypes");
        this.f9379a = r6;
        this.f9380b = r7;
        this.c = r8;
    }

    public final List<Long> a() {
        return this.f9379a;
    }

    public final Set<Integer> b() {
        return this.f9380b;
    }

    public final Set<String> c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ar.class) == true) goto L8;
        return false;
    L8:
        ar r6 = (ar) ZeusTransformUtils.preCheckCast(r5, ar.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9379a, r6.f9379a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9380b, r6.f9380b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f9379a.hashCode() * 31) + this.f9380b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "LegacyOwnerBuildTypeDeleteSpec(rawDbIds=" + this.f9379a + ", entityTypes=" + this.f9380b + ", buildTypes=" + this.c + ')';
    }
}
