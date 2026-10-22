package com.bytedance.android.live.broadcastgame.api.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/j0;", "", "", "initialTime", "J", "b", "()J", "deadline", "a", "", "showRedDot", "Z", "c", "()Z", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j0 {

    @SerializedName("deadline")
    private final long deadline;

    @SerializedName("initial_time")
    private final long initialTime;

    @SerializedName("show_red_dot")
    private final boolean showRedDot;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof j0) == false) goto L12;
        j0 r7 = (j0) r6;
        if (this.initialTime == r7.initialTime) goto L8;
        return false;
    L8:
        if (this.deadline == r7.deadline) goto L10;
        return false;
    L10:
        if (this.showRedDot == r7.showRedDot) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public final int hashCode() {
        long r0 = this.initialTime;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.deadline;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        boolean r4 = this.showRedDot;
        ?? r5 = r4;
        if (r4 == false) goto L6;
        r5 = 1;
    L6:
        return r2 + r5;
    }

    public final String toString() {
        return "RedDotConfig(initialTime=" + this.initialTime + ", deadline=" + this.deadline + ", showRedDot=" + this.showRedDot + ")";
    }

    public final long a() {
        return this.deadline;
    }

    public final long b() {
        return this.initialTime;
    }

    public final boolean c() {
        return this.showRedDot;
    }
}
