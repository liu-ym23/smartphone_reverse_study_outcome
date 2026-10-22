package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/j;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", LiveSlardarConstants.EXTRA_KEY_URL, "getUrl", "", "status", "I", "getStatus", "()I", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("task_id")
    private final String id;

    @SerializedName("task_status")
    private final int status;

    @SerializedName("task_url")
    private final String url;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L12;
        j r4 = (j) r3;
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L10;
        return false;
    L10:
        if (this.status == r4.status) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.url;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.status;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorStarTask(id=" + this.id + ", url=" + this.url + ", status=" + this.status + ")";
    }
}
