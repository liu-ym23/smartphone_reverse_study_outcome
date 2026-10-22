package com.bytedance.android.ec.core.opt.ab;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/opt/ab/b;", "", "", "", "header", "Ljava/util/List;", "a", "()Ljava/util/List;", "params", "b", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("header")
    private final List<String> header;

    @SerializedName("params")
    private final List<String> params;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof b) == false) goto L10;
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.header, r11.header) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.params, r11.params) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<String> r0 = this.header;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        List<String> r12 = this.params;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "BlackKeyConfig(header=" + this.header + ", params=" + this.params + ")";
    }

    public b() {
        this.header = null;
        this.params = null;
    }

    public final List<String> a() {
        return this.header;
    }

    public final List<String> b() {
        return this.params;
    }
}
