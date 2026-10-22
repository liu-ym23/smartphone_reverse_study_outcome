package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/database/index/IndexTaskCostInfo;", "", "actualFinishTimeStamp", "", "indexTaskCost", "finishTimeStamp", "isSlowIndex", "", "<init>", "(JJJZ)V", "getActualFinishTimeStamp", "()J", "getIndexTaskCost", "getFinishTimeStamp", "()Z", "setSlowIndex", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IndexTaskCostInfo {
    private final long actualFinishTimeStamp;
    private final long finishTimeStamp;
    private final long indexTaskCost;
    private boolean isSlowIndex;

    public IndexTaskCostInfo(long r1, long r3, long r5, boolean r7) {
        this.actualFinishTimeStamp = r1;
        this.indexTaskCost = r3;
        this.finishTimeStamp = r5;
        this.isSlowIndex = r7;
    }

    public /* synthetic */ IndexTaskCostInfo(long r10, long r12, long r14, boolean r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 8) == 0) goto L5;
        boolean r8 = false;
    L6:
        this(r10, r12, r14, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public static /* synthetic */ IndexTaskCostInfo copy$default(IndexTaskCostInfo r8, long r9, long r11, long r13, boolean r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        long r1 = r8.actualFinishTimeStamp;
    L7:
        if ((r16 & 2) == 0) goto L9;
        long r3 = r8.indexTaskCost;
    L11:
        if ((r16 & 4) == 0) goto L13;
        long r5 = r8.finishTimeStamp;
    L15:
        if ((r16 & 8) == 0) goto L17;
        boolean r7 = r8.isSlowIndex;
    L19:
        return r8.copy(r1, r3, r5, r7);
    L17:
        r7 = r15;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }

    public final long component1() {
        return this.actualFinishTimeStamp;
    }

    public final long component2() {
        return this.indexTaskCost;
    }

    public final long component3() {
        return this.finishTimeStamp;
    }

    public final boolean component4() {
        return this.isSlowIndex;
    }

    public final IndexTaskCostInfo copy(long r9, long r11, long r13, boolean r15) {
        return new IndexTaskCostInfo(r9, r11, r13, r15);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, IndexTaskCostInfo.class) == true) goto L8;
        return false;
    L8:
        IndexTaskCostInfo r10 = (IndexTaskCostInfo) ZeusTransformUtils.preCheckCast(r9, IndexTaskCostInfo.class, "com.obric.memorydata.plugin");
        if (this.actualFinishTimeStamp == r10.actualFinishTimeStamp) goto L12;
        return false;
    L12:
        if (this.indexTaskCost == r10.indexTaskCost) goto L15;
        return false;
    L15:
        if (this.finishTimeStamp == r10.finishTimeStamp) goto L18;
        return false;
    L18:
        if (this.isSlowIndex == r10.isSlowIndex) goto L20;
        return false;
    L20:
        return true;
    }

    public final long getActualFinishTimeStamp() {
        return this.actualFinishTimeStamp;
    }

    public final long getFinishTimeStamp() {
        return this.finishTimeStamp;
    }

    public final long getIndexTaskCost() {
        return this.indexTaskCost;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.actualFinishTimeStamp) * 31) + Long.hashCode(this.indexTaskCost)) * 31) + Long.hashCode(this.finishTimeStamp)) * 31) + Boolean.hashCode(this.isSlowIndex);
    }

    public final boolean isSlowIndex() {
        return this.isSlowIndex;
    }

    public final void setSlowIndex(boolean r1) {
        this.isSlowIndex = r1;
    }

    public String toString() {
        return "IndexTaskCostInfo(actualFinishTimeStamp=" + this.actualFinishTimeStamp + ", indexTaskCost=" + this.indexTaskCost + ", finishTimeStamp=" + this.finishTimeStamp + ", isSlowIndex=" + this.isSlowIndex + ')';
    }
}
