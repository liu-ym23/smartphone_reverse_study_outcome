package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.profile.monitor.DataType;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/b;", "", "", "counterId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "updateTime", "J", "e", "()J", "startTime", "d", "expectFinishTime", "c", "actualFinishTime", "a", "Lcom/bytedance/android/live/profit/scoreboard/n;", "rule", "Lcom/bytedance/android/live/profit/scoreboard/n;", "getRule", "()Lcom/bytedance/android/live/profit/scoreboard/n;", "", "Lcom/bytedance/android/live/profit/scoreboard/n1;", "topContributors", "Ljava/util/List;", "getTopContributors", "()Ljava/util/List;", "Lcom/bytedance/android/live/profit/scoreboard/m;", "points", "getPoints", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("actual_finish_time")
    private final long actualFinishTime;

    @SerializedName("counter_id")
    private final String counterId;

    @SerializedName("expect_finish_time")
    private final long expectFinishTime;

    @SerializedName("points")
    private final List<m> points;

    @SerializedName("rule")
    private final n rule;

    @SerializedName("start_time")
    private final long startTime;

    @SerializedName("top_contributors")
    private final List<n1> topContributors;

    @SerializedName("update_time")
    private final long updateTime;

    public b() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L22;
        b r7 = (b) r6;
        if (Intrinsics.areEqual(this.counterId, r7.counterId) == true) goto L8;
        return false;
    L8:
        if (this.updateTime == r7.updateTime) goto L10;
        return false;
    L10:
        if (this.startTime == r7.startTime) goto L12;
        return false;
    L12:
        if (this.expectFinishTime == r7.expectFinishTime) goto L14;
        return false;
    L14:
        if (this.actualFinishTime == r7.actualFinishTime) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.rule, r7.rule) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.topContributors, r7.topContributors) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.points, r7.points) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r0 = this.counterId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.updateTime;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.startTime;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.expectFinishTime;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.actualFinishTime;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        n r12 = this.rule;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r10 + r13) * 31;
        List<n1> r15 = this.topContributors;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        List<m> r18 = this.points;
        if (r18 == null) goto L18;
        r1 = r18.hashCode();
    L18:
        return r17 + r1;
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "CounterInfo(counterId=" + this.counterId + ", updateTime=" + this.updateTime + ", startTime=" + this.startTime + ", expectFinishTime=" + this.expectFinishTime + ", actualFinishTime=" + this.actualFinishTime + ", rule=" + this.rule + ", topContributors=" + this.topContributors + ", points=" + this.points + ")";
    }

    public final long a() {
        return this.actualFinishTime;
    }

    public final String b() {
        return this.counterId;
    }

    public final long c() {
        return this.expectFinishTime;
    }

    public final long d() {
        return this.startTime;
    }

    public final long e() {
        return this.updateTime;
    }

    public /* synthetic */ b(int r14) {
        this(DataType.FALSE, 0, 0, 0, 0, new n(0), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public b(String r2, long r3, long r5, long r7, long r9, n r12, List<n1> r13, List<m> r14) {
        Intrinsics.checkNotNullParameter(r2, "counterId");
        Intrinsics.checkNotNullParameter(r12, "rule");
        Intrinsics.checkNotNullParameter(r13, "topContributors");
        this.counterId = r2;
        this.updateTime = r3;
        this.startTime = r5;
        this.expectFinishTime = r7;
        this.actualFinishTime = r9;
        this.rule = r12;
        this.topContributors = r13;
        this.points = r14;
    }
}
