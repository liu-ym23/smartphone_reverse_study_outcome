package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/database/index/FirstCompletionMaterialization;", "", "firstCompletionStartedAtMs", "", "completedAtMs", "waitDurationMs", "<init>", "(JJJ)V", "getFirstCompletionStartedAtMs", "()J", "getCompletedAtMs", "getWaitDurationMs", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9445b;
    private final long c;

    public w(long r1, long r3, long r5) {
        this.f9444a = r1;
        this.f9445b = r3;
        this.c = r5;
    }

    public final long a() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, w.class) == true) goto L8;
        return false;
    L8:
        w r10 = (w) ZeusTransformUtils.preCheckCast(r9, w.class, "com.obric.memorydata.plugin");
        if (this.f9444a == r10.f9444a) goto L12;
        return false;
    L12:
        if (this.f9445b == r10.f9445b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f9444a) * 31) + Long.hashCode(this.f9445b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "FirstCompletionMaterialization(firstCompletionStartedAtMs=" + this.f9444a + ", completedAtMs=" + this.f9445b + ", waitDurationMs=" + this.c + ')';
    }
}
