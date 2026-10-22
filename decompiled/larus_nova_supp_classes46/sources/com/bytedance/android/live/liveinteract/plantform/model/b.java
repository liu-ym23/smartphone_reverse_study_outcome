package com.bytedance.android.live.liveinteract.plantform.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/b;", "", "", "version", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("version")
    private final String version;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.version, ((b) r2).version) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r0 = this.version;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "ChannelInfo(version=" + this.version + ")";
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "version");
        this.version = r2;
    }
}
