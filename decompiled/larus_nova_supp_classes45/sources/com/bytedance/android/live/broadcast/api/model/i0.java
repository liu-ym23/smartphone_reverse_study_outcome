package com.bytedance.android.live.broadcast.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/i0;", "", "", "starStatus", "I", "getStarStatus", "()I", "Lcom/bytedance/android/live/broadcast/api/model/i;", "anchorStarOpenInfo", "Lcom/bytedance/android/live/broadcast/api/model/i;", "getAnchorStarOpenInfo", "()Lcom/bytedance/android/live/broadcast/api/model/i;", "", "Lcom/bytedance/android/live/broadcast/api/model/j;", "starTasks", "Ljava/util/List;", "getStarTasks", "()Ljava/util/List;", "showIcon", "getShowIcon", "withNewTasks", "getWithNewTasks", "yellowDot", "getYellowDot", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i0 {

    @SerializedName("star_info")
    private final i anchorStarOpenInfo;

    @SerializedName("is_show_icon")
    private final int showIcon;

    @SerializedName("star_status")
    private final int starStatus;

    @SerializedName("star_tasks")
    private final List<j> starTasks;

    @SerializedName("has_new_task")
    private final int withNewTasks;

    @SerializedName("is_show_yellow")
    private final int yellowDot;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i0) == false) goto L18;
        i0 r4 = (i0) r3;
        if (this.starStatus == r4.starStatus) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.anchorStarOpenInfo, r4.anchorStarOpenInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.starTasks, r4.starTasks) == true) goto L12;
        return false;
    L12:
        if (this.showIcon == r4.showIcon) goto L14;
        return false;
    L14:
        if (this.withNewTasks == r4.withNewTasks) goto L16;
        return false;
    L16:
        if (this.yellowDot == r4.yellowDot) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r0 = this.starStatus * 31;
        i r1 = this.anchorStarOpenInfo;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        List<j> r5 = this.starTasks;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return ((((((r4 + r2) * 31) + this.showIcon) * 31) + this.withNewTasks) * 31) + this.yellowDot;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "GetAnchorStarStatusResponseData(starStatus=" + this.starStatus + ", anchorStarOpenInfo=" + this.anchorStarOpenInfo + ", starTasks=" + this.starTasks + ", showIcon=" + this.showIcon + ", withNewTasks=" + this.withNewTasks + ", yellowDot=" + this.yellowDot + ")";
    }
}
