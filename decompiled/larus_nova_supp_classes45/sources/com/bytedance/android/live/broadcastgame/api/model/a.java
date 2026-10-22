package com.bytedance.android.live.broadcastgame.api.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/a;", "", "", "showMaxCount", "I", "getShowMaxCount", "()I", "", "initialTime", "J", "b", "()J", "deadline", "a", "delayShow", "getDelayShow", "priority", "getPriority", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("deadline")
    private final long deadline;

    @SerializedName("delay_show")
    private final int delayShow;

    @SerializedName("initial_time")
    private final long initialTime;

    @SerializedName("priority")
    private final int priority;

    @SerializedName("show_max_count")
    private final int showMaxCount;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L16;
        a r7 = (a) r6;
        if (this.showMaxCount == r7.showMaxCount) goto L8;
        return false;
    L8:
        if (this.initialTime == r7.initialTime) goto L10;
        return false;
    L10:
        if (this.deadline == r7.deadline) goto L12;
        return false;
    L12:
        if (this.delayShow == r7.delayShow) goto L14;
        return false;
    L14:
        if (this.priority == r7.priority) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r0 = this.showMaxCount * 31;
        long r1 = this.initialTime;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.deadline;
        return ((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.delayShow) * 31) + this.priority;
    }

    public final String toString() {
        return "BreathingLightConfig(showMaxCount=" + this.showMaxCount + ", initialTime=" + this.initialTime + ", deadline=" + this.deadline + ", delayShow=" + this.delayShow + ", priority=" + this.priority + ")";
    }

    public final long a() {
        return this.deadline;
    }

    public final long b() {
        return this.initialTime;
    }
}
