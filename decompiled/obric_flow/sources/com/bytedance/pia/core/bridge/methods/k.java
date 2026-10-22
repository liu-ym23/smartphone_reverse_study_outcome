package com.bytedance.pia.core.bridge.methods;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/k;", "", "Lcom/google/gson/JsonObject;", "a", "Lcom/google/gson/JsonObject;", "getHeaders", "()Lcom/google/gson/JsonObject;", "headers", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("headers")
    private final JsonObject f6996a;

    public k(JsonObject r5) {
        this.f6996a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f6996a, ((k) r5).f6996a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        JsonObject r5 = this.f6996a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.hashCode();
    }

    public final String toString() {
        return "Result(headers=" + this.f6996a + ')';
    }
}
