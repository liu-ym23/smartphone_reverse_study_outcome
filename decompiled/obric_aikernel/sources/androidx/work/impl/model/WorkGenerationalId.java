package androidx.work.impl.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class WorkGenerationalId {
    private final int generation;
    private final String workSpecId;

    public WorkGenerationalId(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "workSpecId");
        this.workSpecId = r10;
        this.generation = r11;
    }

    public static /* synthetic */ WorkGenerationalId copy$default(WorkGenerationalId r10, String r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.workSpecId;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.generation;
    L9:
        return r10.copy(r11, r12);
    }

    public final String component1() {
        return this.workSpecId;
    }

    public final int component2() {
        return this.generation;
    }

    public final WorkGenerationalId copy(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "workSpecId");
        return new WorkGenerationalId(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WorkGenerationalId) == true) goto L8;
        return false;
    L8:
        WorkGenerationalId r11 = (WorkGenerationalId) r10;
        if (Intrinsics.areEqual(this.workSpecId, r11.workSpecId) == true) goto L12;
        return false;
    L12:
        if (this.generation == r11.generation) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final String getWorkSpecId() {
        return this.workSpecId;
    }

    public int hashCode() {
        return (this.workSpecId.hashCode() * 31) + Integer.hashCode(this.generation);
    }

    public String toString() {
        return "WorkGenerationalId(workSpecId=" + this.workSpecId + ", generation=" + this.generation + ')';
    }
}
