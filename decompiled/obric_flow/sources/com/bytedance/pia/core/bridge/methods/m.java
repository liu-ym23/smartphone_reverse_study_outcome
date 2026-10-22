package com.bytedance.pia.core.bridge.methods;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/m;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "url", "", "Ljava/util/List;", "()Ljava/util/List;", "extraVary", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("url")
    private final String f7001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("extraVary")
    private final List<String> f7002b;

    public m() {
        this.f7001a = null;
        this.f7002b = null;
    }

    public final List a() {
        return this.f7002b;
    }

    public final String b() {
        return this.f7001a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r10 = (m) r5;
        if (Intrinsics.areEqual(this.f7001a, r10.f7001a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f7002b, r10.f7002b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f7001a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        List<String> r13 = this.f7002b;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Params(url=");
        r5.append(this.f7001a);
        r5.append(", extraVary=");
        return androidx.constraintlayout.motion.widget.a.v(r5, this.f7002b, ')');
    }
}
