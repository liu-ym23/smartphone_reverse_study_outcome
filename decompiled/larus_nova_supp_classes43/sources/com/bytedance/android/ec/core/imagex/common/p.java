package com.bytedance.android.ec.core.imagex.common;

import com.bytedance.android.ec.core.imagex.common.z;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003R0\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/common/p;", "Lcom/bytedance/android/ec/core/imagex/common/z;", "T", "", "", "", "", "sceneConfig", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "commonLowConfig", "Ljava/util/List;", "b", "()Ljava/util/List;", "commonHighConfig", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p<T extends z> {

    @SerializedName("common_high_config")
    private final List<T> commonHighConfig;

    @SerializedName("common_low_config")
    private final List<T> commonLowConfig;

    @SerializedName("scene_config")
    private final Map<String, List<T>> sceneConfig;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof p) == false) goto L12;
        p r11 = (p) r10;
        if (Intrinsics.areEqual(this.sceneConfig, r11.sceneConfig) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.commonLowConfig, r11.commonLowConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.commonHighConfig, r11.commonHighConfig) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<String, List<T>> r0 = this.sceneConfig;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        List<T> r12 = this.commonLowConfig;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        List<T> r15 = this.commonHighConfig;
        if (r15 == null) goto L14;
        r1 = r15.hashCode();
    L14:
        return r14 + r1;
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiMapConfig(sceneConfig=" + this.sceneConfig + ", commonLowConfig=" + this.commonLowConfig + ", commonHighConfig=" + this.commonHighConfig + ")";
    }

    public final List<T> a() {
        return this.commonHighConfig;
    }

    public final List<T> b() {
        return this.commonLowConfig;
    }

    public final Map<String, List<T>> c() {
        return this.sceneConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(Map<String, ? extends List<? extends T>> r1, List<? extends T> r10, List<? extends T> r11) {
        this.sceneConfig = r1;
        this.commonLowConfig = r10;
        this.commonHighConfig = r11;
    }
}
