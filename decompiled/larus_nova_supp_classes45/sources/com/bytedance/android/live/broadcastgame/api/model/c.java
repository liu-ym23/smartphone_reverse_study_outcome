package com.bytedance.android.live.broadcastgame.api.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/c;", "", "", "showMaxCount", "I", "getShowMaxCount", "()I", "", "initialTime", "J", "b", "()J", "deadline", "a", "priority", "getPriority", "delayShow", "getDelayShow", "", "tipText", "Ljava/lang/String;", "getTipText", "()Ljava/lang/String;", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

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

    @SerializedName("tip_text")
    private final String tipText;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L18;
        c r7 = (c) r6;
        if (this.showMaxCount == r7.showMaxCount) goto L8;
        return false;
    L8:
        if (this.initialTime == r7.initialTime) goto L10;
        return false;
    L10:
        if (this.deadline == r7.deadline) goto L12;
        return false;
    L12:
        if (this.priority == r7.priority) goto L14;
        return false;
    L14:
        if (this.delayShow == r7.delayShow) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.tipText, r7.tipText) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r0 = this.showMaxCount * 31;
        long r1 = this.initialTime;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.deadline;
        int r4 = (((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.priority) * 31) + this.delayShow) * 31;
        String r5 = this.tipText;
        if (r5 == null) goto L5;
        int r6 = r5.hashCode();
    L7:
        return r4 + r6;
    L5:
        r6 = 0;
        goto L7
    }

    public final String toString() {
        return "BubbleConfig(showMaxCount=" + this.showMaxCount + ", initialTime=" + this.initialTime + ", deadline=" + this.deadline + ", priority=" + this.priority + ", delayShow=" + this.delayShow + ", tipText=" + this.tipText + ")";
    }

    public final long a() {
        return this.deadline;
    }

    public final long b() {
        return this.initialTime;
    }
}
