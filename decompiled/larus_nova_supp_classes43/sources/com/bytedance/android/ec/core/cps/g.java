package com.bytedance.android.ec.core.cps;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/core/cps/g;", "", "", "sort", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "hashDict", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("m")
    private final Map<String, String> hashDict;

    @SerializedName("f")
    private final String sort;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof g) == false) goto L10;
        g r11 = (g) r10;
        if (Intrinsics.areEqual(this.sort, r11.sort) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hashDict, r11.hashDict) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.sort;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        Map<String, String> r12 = this.hashDict;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicEventProguardResult(sort=" + this.sort + ", hashDict=" + this.hashDict + ")";
    }

    public g() {
        this.sort = null;
        this.hashDict = null;
    }

    public final Map<String, String> a() {
        return this.hashDict;
    }

    public final String b() {
        return this.sort;
    }
}
