package com.bytedance.pia.core.bridge.methods;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/q;", "", "", "a", "Z", "isUpdate", "()Z", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("isUpdate")
    private final boolean f7015a;

    public q(boolean r5) {
        this.f7015a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L9;
        return false;
    L9:
        if (this.f7015a == ((q) r5).f7015a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f7015a);
    }

    public final String toString() {
        return androidx.constraintlayout.motion.widget.a.w(new StringBuilder("Result(isUpdate="), this.f7015a, ')');
    }
}
