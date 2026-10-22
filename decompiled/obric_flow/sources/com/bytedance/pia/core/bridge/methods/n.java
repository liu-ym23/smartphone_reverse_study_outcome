package com.bytedance.pia.core.bridge.methods;

import cn.nubia.neopush.commons.Constant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/n;", "", "", "a", "Z", "getDelete", "()Z", Constant.ClientMessageType.DELETE, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(Constant.ClientMessageType.DELETE)
    private final boolean f7003a;

    public n(boolean r5) {
        this.f7003a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L9;
        return false;
    L9:
        if (this.f7003a == ((n) r5).f7003a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f7003a);
    }

    public final String toString() {
        return androidx.constraintlayout.motion.widget.a.w(new StringBuilder("Result(delete="), this.f7003a, ')');
    }
}
