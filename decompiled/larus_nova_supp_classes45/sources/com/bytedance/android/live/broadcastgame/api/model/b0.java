package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/b0;", "", "", "kind", "J", "getKind", "()J", "", LiveSlardarConstants.EXTRA_KEY_URL, "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b0 {

    @SerializedName("kind")
    private final long kind;

    @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
    private final String url;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b0) == false) goto L10;
        b0 r7 = (b0) r6;
        if (this.kind == r7.kind) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.url, r7.url) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r0 = this.kind;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.url;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public final String toString() {
        return "MediaInfo(kind=" + this.kind + ", url=" + this.url + ")";
    }
}
