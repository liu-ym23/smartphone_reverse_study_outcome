package com.bytedance.android.ec.core.sku;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/core/sku/UltimateBuyCacheConfig;", "Ljava/io/Serializable;", "cacheCount", "", "expireTime", "", "sceneTypeBlackList", "", "", "(IJLjava/util/List;)V", "getCacheCount", "()I", "setCacheCount", "(I)V", "getExpireTime", "()J", "getSceneTypeBlackList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UltimateBuyCacheConfig implements Serializable {

    @SerializedName("cache_count")
    private int cacheCount;

    @SerializedName("expire_time")
    private final long expireTime;

    @SerializedName("scene_type_black_list")
    private final List<String> sceneTypeBlackList;

    public UltimateBuyCacheConfig() {
        this(0, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UltimateBuyCacheConfig copy$default(UltimateBuyCacheConfig r0, int r1, long r10, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.cacheCount;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.expireTime;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.sceneTypeBlackList;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final int component1() {
        return this.cacheCount;
    }

    public final long component2() {
        return this.expireTime;
    }

    public final List<String> component3() {
        return this.sceneTypeBlackList;
    }

    public final UltimateBuyCacheConfig copy(int r10, long r11, List<String> r12) {
        return new UltimateBuyCacheConfig(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof UltimateBuyCacheConfig) == false) goto L12;
        UltimateBuyCacheConfig r11 = (UltimateBuyCacheConfig) r10;
        if (this.cacheCount == r11.cacheCount) goto L8;
        return false;
    L8:
        if (this.expireTime == r11.expireTime) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.sceneTypeBlackList, r11.sceneTypeBlackList) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r0 = this.cacheCount * 31;
        long r1 = this.expireTime;
        int r10 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        List<String> r11 = this.sceneTypeBlackList;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L7:
        return r10 + r12;
    L5:
        r12 = 0;
        goto L7
    }

    public String toString() {
        return "UltimateBuyCacheConfig(cacheCount=" + this.cacheCount + ", expireTime=" + this.expireTime + ", sceneTypeBlackList=" + this.sceneTypeBlackList + ")";
    }

    public final int getCacheCount() {
        return this.cacheCount;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public final List<String> getSceneTypeBlackList() {
        return this.sceneTypeBlackList;
    }

    public final void setCacheCount(int r1) {
        this.cacheCount = r1;
    }

    public UltimateBuyCacheConfig(int r1, long r10, List<String> r11) {
        this.cacheCount = r1;
        this.expireTime = r10;
        this.sceneTypeBlackList = r11;
    }

    public /* synthetic */ UltimateBuyCacheConfig(int r1, long r10, List r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = 5;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = 300;
    L9:
        if ((r12 & 4) == 0) goto L11;
        r11 = null;
    L11:
        this(r1, r10, r11);
    }
}
