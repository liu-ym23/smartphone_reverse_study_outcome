package com.bytedance.android.livesdk.config.setting;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/config/setting/e;", "", "", "delKeys", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "rewriteKeys", "b", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("delKeys")
    private final String delKeys;

    @SerializedName("rewriteKeys")
    private final String rewriteKeys;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L14;
        e r4 = (e) r3;
        r4.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.delKeys, r4.delKeys) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rewriteKeys, r4.rewriteKeys) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.delKeys;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = (r2 + 0) * 31;
        String r4 = this.rewriteKeys;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "InterceptReplaceSchemaConfig(host=null, condition=null, delKeys=" + this.delKeys + ", rewriteKeys=" + this.rewriteKeys + ")";
    }

    public final String a() {
        return this.delKeys;
    }

    public final String b() {
        return this.rewriteKeys;
    }
}
