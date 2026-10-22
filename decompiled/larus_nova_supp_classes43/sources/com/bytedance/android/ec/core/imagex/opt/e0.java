package com.bytedance.android.ec.core.imagex.opt;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/opt/e0;", "", "", "formatValue", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 {

    @SerializedName("format")
    private final String formatValue;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof e0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.formatValue, ((e0) r10).formatValue) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r0 = this.formatValue;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "ImageXModifyFormat(formatValue=" + this.formatValue + ")";
    }

    public e0() {
        this.formatValue = null;
    }

    public final String a() {
        return this.formatValue;
    }
}
