package com.bytedance.android.ec.core.imagex;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/e;", "Lcom/bytedance/android/shopping/api/image/d$b;", "", "Lcom/bytedance/android/shopping/api/image/d;", "supportMather", "Ljava/util/List;", "e", "()Ljava/util/List;", "", "targetQuality", "Ljava/lang/Integer;", "getTargetQuality", "()Ljava/lang/Integer;", "", "matchersType", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "", "ignoreMatch", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e implements com.bytedance.android.shopping.api.image.d.b {

    @SerializedName("ignore_match")
    private final Boolean ignoreMatch;

    @SerializedName("matchers_type")
    private final String matchersType;

    @SerializedName("support_mather")
    private final List<com.bytedance.android.shopping.api.image.d> supportMather;

    @SerializedName("target_quality")
    private final Integer targetQuality;

    public e() {
        this(null);
    }

    public final int hashCode() {
        List<com.bytedance.android.shopping.api.image.d> r0 = this.supportMather;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        Integer r12 = this.targetQuality;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.matchersType;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        Boolean r18 = this.ignoreMatch;
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
        return "ECImageCustomDecodeRGBConfig(supportMather=" + this.supportMather + ", targetQuality=" + this.targetQuality + ", matchersType=" + this.matchersType + ", ignoreMatch=" + this.ignoreMatch + ")";
    }

    public final Boolean c() {
        return this.ignoreMatch;
    }

    public final List<com.bytedance.android.shopping.api.image.d> e() {
        return this.supportMather;
    }

    public final String g() {
        return this.matchersType;
    }

    public e(Object r1) {
        this.supportMather = null;
        this.targetQuality = null;
        this.matchersType = null;
        this.ignoreMatch = null;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof e) == false) goto L14;
        e r11 = (e) r10;
        if (Intrinsics.areEqual(this.supportMather, r11.supportMather) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.targetQuality, r11.targetQuality) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.matchersType, r11.matchersType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ignoreMatch, r11.ignoreMatch) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }
}
