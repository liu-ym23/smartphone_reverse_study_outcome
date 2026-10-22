package com.bytedance.android.ec.core.hybrid.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/model/TabKitDeeplinkPrefetchConfig;", "Ljava/io/Serializable;", "enableCFShortLinkTransform", "", "enableCFShortLinkPrefetch", "shortLinkPreloadGeckoResource", "", "", "rules", "Lcom/bytedance/android/ec/core/hybrid/model/TabKitDeeplinkPrefetchRule;", "(ZZLjava/util/List;Ljava/util/List;)V", "getEnableCFShortLinkPrefetch", "()Z", "getEnableCFShortLinkTransform", "getRules", "()Ljava/util/List;", "getShortLinkPreloadGeckoResource", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitDeeplinkPrefetchConfig implements Serializable {

    @SerializedName("enable_cf_short_link_prefetch")
    private final boolean enableCFShortLinkPrefetch;

    @SerializedName("enable_cf_short_link_transform")
    private final boolean enableCFShortLinkTransform;

    @SerializedName("rules")
    private final List<TabKitDeeplinkPrefetchRule> rules;

    @SerializedName("short_link_preload_gecko_resource")
    private final List<String> shortLinkPreloadGeckoResource;

    public TabKitDeeplinkPrefetchConfig() {
        this(false, false, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabKitDeeplinkPrefetchConfig copy$default(TabKitDeeplinkPrefetchConfig r0, boolean r1, boolean r10, List r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r1 = r0.enableCFShortLinkTransform;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = r0.enableCFShortLinkPrefetch;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = r0.shortLinkPreloadGeckoResource;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r12 = r0.rules;
    L15:
        return r0.copy(r1, r10, r11, r12);
    }

    public final boolean component1() {
        return this.enableCFShortLinkTransform;
    }

    public final boolean component2() {
        return this.enableCFShortLinkPrefetch;
    }

    public final List<String> component3() {
        return this.shortLinkPreloadGeckoResource;
    }

    public final List<TabKitDeeplinkPrefetchRule> component4() {
        return this.rules;
    }

    public final TabKitDeeplinkPrefetchConfig copy(boolean r10, boolean r11, List<String> r12, List<TabKitDeeplinkPrefetchRule> r13) {
        return new TabKitDeeplinkPrefetchConfig(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof TabKitDeeplinkPrefetchConfig) == false) goto L14;
        TabKitDeeplinkPrefetchConfig r11 = (TabKitDeeplinkPrefetchConfig) r10;
        if (this.enableCFShortLinkTransform == r11.enableCFShortLinkTransform) goto L8;
        return false;
    L8:
        if (this.enableCFShortLinkPrefetch == r11.enableCFShortLinkPrefetch) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shortLinkPreloadGeckoResource, r11.shortLinkPreloadGeckoResource) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rules, r11.rules) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        boolean r0 = this.enableCFShortLinkTransform;
        ?? r1 = 1;
        ?? r10 = r0;
        if (r0 == false) goto L5;
        r10 = 1;
    L5:
        int r11 = r10 * 31;
        boolean r12 = this.enableCFShortLinkPrefetch;
        if (r12 == true) goto L9;
        r1 = r12;
    L9:
        int r13 = (r11 + r1) * 31;
        List<String> r14 = this.shortLinkPreloadGeckoResource;
        int r15 = 0;
        if (r14 == null) goto L12;
        int r16 = r14.hashCode();
    L13:
        int r17 = (r13 + r16) * 31;
        List<TabKitDeeplinkPrefetchRule> r18 = this.rules;
        if (r18 == null) goto L17;
        r15 = r18.hashCode();
    L17:
        return r17 + r15;
    L12:
        r16 = 0;
        goto L13
    }

    public String toString() {
        return "TabKitDeeplinkPrefetchConfig(enableCFShortLinkTransform=" + this.enableCFShortLinkTransform + ", enableCFShortLinkPrefetch=" + this.enableCFShortLinkPrefetch + ", shortLinkPreloadGeckoResource=" + this.shortLinkPreloadGeckoResource + ", rules=" + this.rules + ")";
    }

    public final boolean getEnableCFShortLinkPrefetch() {
        return this.enableCFShortLinkPrefetch;
    }

    public final boolean getEnableCFShortLinkTransform() {
        return this.enableCFShortLinkTransform;
    }

    public final List<TabKitDeeplinkPrefetchRule> getRules() {
        return this.rules;
    }

    public final List<String> getShortLinkPreloadGeckoResource() {
        return this.shortLinkPreloadGeckoResource;
    }

    public TabKitDeeplinkPrefetchConfig(boolean r1, boolean r10, List<String> r11, List<TabKitDeeplinkPrefetchRule> r12) {
        this.enableCFShortLinkTransform = r1;
        this.enableCFShortLinkPrefetch = r10;
        this.shortLinkPreloadGeckoResource = r11;
        this.rules = r12;
    }

    public /* synthetic */ TabKitDeeplinkPrefetchConfig(boolean r10, boolean r11, List r12, List r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = false;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = false;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }
}
