package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.profile.monitor.DataType;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/o;", "", "", "counterId", "Ljava/lang/String;", "getCounterId", "()Ljava/lang/String;", "", "Lcom/bytedance/android/live/profit/scoreboard/m;", "points", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "updateTime", "J", "d", "()J", "expectFinishTime", "a", "actualFinishTime", "getActualFinishTime", "", "leftResetTime", "I", "b", "()I", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class o {
    public final boolean a;

    @SerializedName("actual_finish_time")
    private final long actualFinishTime;

    @SerializedName("counter_id")
    private final String counterId;

    @SerializedName("expect_finish_time")
    private final long expectFinishTime;

    @SerializedName("left_reset_time")
    private final int leftResetTime;

    @SerializedName("points")
    private final List<m> points;

    @SerializedName("update_time")
    private final long updateTime;

    public o() {
        this(null, null, 0, 0, 0, 0, 127);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof o) == false) goto L20;
        o r7 = (o) r6;
        if (Intrinsics.areEqual(this.counterId, r7.counterId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.points, r7.points) == true) goto L10;
        return false;
    L10:
        if (this.updateTime == r7.updateTime) goto L12;
        return false;
    L12:
        if (this.expectFinishTime == r7.expectFinishTime) goto L14;
        return false;
    L14:
        if (this.actualFinishTime == r7.actualFinishTime) goto L16;
        return false;
    L16:
        if (this.leftResetTime == r7.leftResetTime) goto L18;
        return false;
    L18:
        if (this.a == r7.a) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public final int hashCode() {
        String r0 = this.counterId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<m> r4 = this.points;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        long r6 = this.updateTime;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.expectFinishTime;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = this.actualFinishTime;
        int r12 = (((r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31) + this.leftResetTime) * 31;
        boolean r13 = this.a;
        ?? r14 = r13;
        if (r13 == false) goto L13;
        r14 = 1;
    L13:
        return r12 + r14;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ScoreCountingMessage(counterId=" + this.counterId + ", points=" + this.points + ", updateTime=" + this.updateTime + ", expectFinishTime=" + this.expectFinishTime + ", actualFinishTime=" + this.actualFinishTime + ", leftResetTime=" + this.leftResetTime + ", isNextRoundStarted=" + this.a + ")";
    }

    public final long a() {
        return this.expectFinishTime;
    }

    public final int b() {
        return this.leftResetTime;
    }

    public final List<m> c() {
        return this.points;
    }

    public final long d() {
        return this.updateTime;
    }

    public o(String r4, List r5, long r6, long r8, long r10, int r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r4 = DataType.FALSE;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r5 = CollectionsKt.emptyList();
    L9:
        if ((r13 & 4) == 0) goto L12;
        r6 = 0;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r8 = 0;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r10 = 0;
    L18:
        if ((r13 & 32) == 0) goto L20;
        r12 = 60;
    L20:
        Intrinsics.checkNotNullParameter(r4, "counterId");
        Intrinsics.checkNotNullParameter(r5, "points");
        this.counterId = r4;
        this.points = r5;
        this.updateTime = r6;
        this.expectFinishTime = r8;
        this.actualFinishTime = r10;
        this.leftResetTime = r12;
        this.a = false;
    }
}
