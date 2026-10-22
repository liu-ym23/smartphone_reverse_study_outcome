package com.bytedance.android.livesdk.interactivity.virtualinteract.model;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/virtualinteract/model/d;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/virtualinteract/model/b;", "data", "Lcom/bytedance/android/livesdk/interactivity/virtualinteract/model/b;", "getData", "()Lcom/bytedance/android/livesdk/interactivity/virtualinteract/model/b;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("data")
    private final b data;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.data, ((d) r2).data) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        b r0 = this.data;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "NormalResult(data=" + this.data + ")";
    }

    public d(b r1) {
        this.data = r1;
    }
}
