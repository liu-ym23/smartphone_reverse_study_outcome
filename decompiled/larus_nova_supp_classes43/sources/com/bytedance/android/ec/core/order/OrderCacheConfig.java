package com.bytedance.android.ec.core.order;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001$B?\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\n\u001a\u00020\u0004HÆ\u0003JA\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00022\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0011\u001a\u00020\bHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b \u0010\u001b¨\u0006%"}, d2 = {"Lcom/bytedance/android/ec/core/order/OrderCacheConfig;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "", "", "component4", "component5", "cacheDuration", "cacheOpt", "cacheOrderCount", "nodeBlackList", "on", "copy", "toString", "hashCode", "", "other", "equals", "I", "getCacheDuration", "()I", "Z", "getCacheOpt", "()Z", "getCacheOrderCount", "Ljava/util/List;", "getNodeBlackList", "()Ljava/util/List;", "getOn", "<init>", "(IZILjava/util/List;Z)V", "Companion", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderCacheConfig implements Serializable {
    public static final a Companion = null;
    public static final List<String> a = null;

    @SerializedName("cache_duration")
    private final int cacheDuration;

    @SerializedName("cache_opt")
    private final boolean cacheOpt;

    @SerializedName("cache_order_count")
    private final int cacheOrderCount;

    @SerializedName("node_black_list")
    private final List<String> nodeBlackList;

    @SerializedName("on")
    private final boolean on;

    public static final class a {
        public a() {
        }
    }

    public OrderCacheConfig() {
        this(0, false, 0, null, false, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OrderCacheConfig copy$default(OrderCacheConfig r10, int r11, boolean r12, int r13, List r14, boolean r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.cacheDuration;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.cacheOpt;
    L8:
        boolean r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.cacheOrderCount;
    L11:
        int r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.nodeBlackList;
    L14:
        List r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.on;
    L17:
        int r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final int component1() {
        return this.cacheDuration;
    }

    public final boolean component2() {
        return this.cacheOpt;
    }

    public final int component3() {
        return this.cacheOrderCount;
    }

    public final List<String> component4() {
        return this.nodeBlackList;
    }

    public final boolean component5() {
        return this.on;
    }

    public final OrderCacheConfig copy(int r10, boolean r11, int r12, List<String> r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "nodeBlackList");
        return new OrderCacheConfig(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof OrderCacheConfig) == false) goto L16;
        OrderCacheConfig r11 = (OrderCacheConfig) r10;
        if (this.cacheDuration == r11.cacheDuration) goto L8;
        return false;
    L8:
        if (this.cacheOpt == r11.cacheOpt) goto L10;
        return false;
    L10:
        if (this.cacheOrderCount == r11.cacheOrderCount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nodeBlackList, r11.nodeBlackList) == true) goto L14;
        return false;
    L14:
        if (this.on == r11.on) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = this.cacheDuration * 31;
        boolean r1 = this.cacheOpt;
        ?? r10 = 1;
        ?? r11 = r1;
        if (r1 == false) goto L5;
        r11 = 1;
    L5:
        int r12 = (((r0 + r11) * 31) + this.cacheOrderCount) * 31;
        List<String> r13 = this.nodeBlackList;
        if (r13 == null) goto L8;
        int r14 = r13.hashCode();
    L9:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.on;
        if (r16 == true) goto L14;
        r10 = r16;
    L14:
        return r15 + r10;
    L8:
        r14 = 0;
        goto L9
    }

    public String toString() {
        return "OrderCacheConfig(cacheDuration=" + this.cacheDuration + ", cacheOpt=" + this.cacheOpt + ", cacheOrderCount=" + this.cacheOrderCount + ", nodeBlackList=" + this.nodeBlackList + ", on=" + this.on + ")";
    }

    static {
        Companion = new a();
        a = CollectionsKt.listOf(new String[]{"after_render", "order_list_footer", "order_list_header_sticky", "order_list_scroll", "lower_price_recomendation"});
    }

    public final int getCacheDuration() {
        return this.cacheDuration;
    }

    public final boolean getCacheOpt() {
        return this.cacheOpt;
    }

    public final int getCacheOrderCount() {
        return this.cacheOrderCount;
    }

    public final List<String> getNodeBlackList() {
        return this.nodeBlackList;
    }

    public final boolean getOn() {
        return this.on;
    }

    public OrderCacheConfig(int r10, boolean r11, int r12, List<String> r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "nodeBlackList");
        this.cacheDuration = r10;
        this.cacheOpt = r11;
        this.cacheOrderCount = r12;
        this.nodeBlackList = r13;
        this.on = r14;
    }

    public /* synthetic */ OrderCacheConfig(int r10, boolean r11, int r12, List r13, boolean r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L5;
        r10 = 86400;
    L5:
        boolean r0 = false;
        if ((r15 & 2) == 0) goto L8;
        boolean r17 = false;
    L10:
        if ((r15 & 4) == 0) goto L12;
        int r1 = 3;
    L14:
        if ((r15 & 8) == 0) goto L16;
        r13 = a;
    L16:
        List r18 = r13;
        if ((r15 & 16) != 0) goto L20;
        r0 = r14;
    L20:
        this(r10, r17, r1, r18, r0);
        return;
    L12:
        r1 = r12;
        goto L14
    L8:
        r17 = r11;
        goto L10
    }
}
