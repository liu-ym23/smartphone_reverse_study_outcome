package com.obric.aikernel.res.update;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/obric/aikernel/res/update/UpdateExecutionResult;", "", "results", "", "", "Lcom/obric/aikernel/res/update/UpdateResult;", "metadataOutcome", "Lcom/obric/aikernel/res/update/MetadataRequestOutcome;", "cachedPackageCount", "", "(Ljava/util/Map;Lcom/obric/aikernel/res/update/MetadataRequestOutcome;I)V", "getCachedPackageCount", "()I", "getMetadataOutcome", "()Lcom/obric/aikernel/res/update/MetadataRequestOutcome;", "getResults", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, UpdateResult> f6147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f6148b;
    private final int c;

    public q(Map<String, UpdateResult> r3, f r4, int r5) {
        Map<String, UpdateResult> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "results");
        this.f6147a = r6;
        this.f6148b = r4;
        this.c = r5;
    }

    public final Map<String, UpdateResult> a() {
        return this.f6147a;
    }

    public final f b() {
        return this.f6148b;
    }

    public final int c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, q.class) == true) goto L8;
        return false;
    L8:
        q r6 = (q) ZeusTransformUtils.preCheckCast(r5, q.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6147a, r6.f6147a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6148b, r6.f6148b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.f6147a.hashCode() * 31;
        f r1 = this.f6148b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Integer.hashCode(this.c);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "UpdateExecutionResult(results=" + this.f6147a + ", metadataOutcome=" + this.f6148b + ", cachedPackageCount=" + this.c + ')';
    }
}
