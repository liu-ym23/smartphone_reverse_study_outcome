package com.obric.capabilitykit.entity;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/capabilitykit/entity/IndexProgress;", "", "left", "", "total", "(II)V", "getLeft", "()I", "getTotal", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class IndexProgress {
    private final int left;
    private final int total;

    public IndexProgress(int r1, int r2) {
        this.left = r1;
        this.total = r2;
    }

    public static /* synthetic */ IndexProgress copy$default(IndexProgress r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.left;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.total;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.total;
    }

    public final IndexProgress copy(int r2, int r3) {
        return new IndexProgress(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IndexProgress) == true) goto L8;
        return false;
    L8:
        IndexProgress r6 = (IndexProgress) r5;
        if (this.left == r6.left) goto L12;
        return false;
    L12:
        if (this.total == r6.total) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (this.left * 31) + this.total;
    }

    public String toString() {
        return "IndexProgress(left=" + this.left + ", total=" + this.total + ')';
    }
}
