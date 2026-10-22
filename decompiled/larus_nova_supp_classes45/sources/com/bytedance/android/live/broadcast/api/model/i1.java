package com.bytedance.android.live.broadcast.api.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0007R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/i1;", "", "", "setResult", "I", "getSetResult", "()I", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i1 {

    @SerializedName("set_result")
    private final int setResult;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof i1) == true) goto L6;
        return false;
    L6:
        if (this.setResult == ((i1) r2).setResult) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.setResult;
    }

    public final String toString() {
        return "SetAnchorStarOpenResponseData(setResult=" + this.setResult + ")";
    }
}
