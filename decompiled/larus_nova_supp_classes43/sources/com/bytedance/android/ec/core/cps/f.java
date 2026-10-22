package com.bytedance.android.ec.core.cps;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/core/cps/f;", "", "", "version", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "hashDict", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "paramDict", "b", "Lcom/bytedance/android/ec/core/cps/g;", "proguardResult", "Lcom/bytedance/android/ec/core/cps/g;", "c", "()Lcom/bytedance/android/ec/core/cps/g;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("h")
    private final Map<String, String> hashDict;

    @SerializedName("d")
    private final Map<String, String> paramDict;

    @SerializedName("hf")
    private final g proguardResult;

    @SerializedName("v")
    private final String version;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof f) == false) goto L14;
        f r11 = (f) r10;
        if (Intrinsics.areEqual(this.version, r11.version) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hashDict, r11.hashDict) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.paramDict, r11.paramDict) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.proguardResult, r11.proguardResult) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.version;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        Map<String, String> r12 = this.hashDict;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        Map<String, String> r15 = this.paramDict;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        g r18 = this.proguardResult;
        if (r18 == null) goto L18;
        r1 = r18.hashCode();
    L18:
        return r17 + r1;
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicEventProguard(version=" + this.version + ", hashDict=" + this.hashDict + ", paramDict=" + this.paramDict + ", proguardResult=" + this.proguardResult + ")";
    }

    public f() {
        this.version = null;
        this.hashDict = null;
        this.paramDict = null;
        this.proguardResult = null;
    }

    public final Map<String, String> a() {
        return this.hashDict;
    }

    public final Map<String, String> b() {
        return this.paramDict;
    }

    public final g c() {
        return this.proguardResult;
    }

    public final String d() {
        return this.version;
    }
}
