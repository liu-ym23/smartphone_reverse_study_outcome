package com.obric.aiagent.product.feature.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.feature.ProductSpecialConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J!\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b0\bHÆ\u0003JU\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR.\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/aiagent/product/feature/bean/FeatureStateConfigItem;", "", "state", "", "stateList", "", "productList", "productSpecialList", "", "Lcom/obric/aiagent/product/feature/ProductSpecialConfig;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getState", "()Ljava/lang/String;", "getStateList", "()Ljava/util/List;", "getProductList", "getProductSpecialList", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FeatureStateConfigItem {

    @SerializedName("product_list")
    private final List<String> productList;

    @SerializedName("product_special_list")
    private final Map<String, Map<String, ProductSpecialConfig>> productSpecialList;

    @SerializedName("state")
    private final String state;

    @SerializedName("state_list")
    private final List<String> stateList;

    public FeatureStateConfigItem() {
        this(null, null, null, null, 15, null);
    }

    public FeatureStateConfigItem(String r3, List<String> r4, List<String> r5, Map<String, ? extends Map<String, ProductSpecialConfig>> r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Map<String, Map<String, ProductSpecialConfig>> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r7, "stateList");
        Intrinsics.checkNotNullParameter(r8, "productList");
        Intrinsics.checkNotNullParameter(r9, "productSpecialList");
        this.state = r3;
        this.stateList = r7;
        this.productList = r8;
        this.productSpecialList = r9;
    }

    public /* synthetic */ FeatureStateConfigItem(String r2, List r3, List r4, Map r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = CollectionsKt.emptyList();
    L9:
        if ((r6 & 4) == 0) goto L12;
        r9 = CollectionsKt.emptyList();
    L12:
        if ((r6 & 8) == 0) goto L14;
        r10 = MapsKt.emptyMap();
    L14:
        this(r2, r8, r9, r10);
    }

    public static /* synthetic */ FeatureStateConfigItem copy$default(FeatureStateConfigItem r1, String r2, List r3, List r4, Map r5, int r6, Object r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Map<String, Map<String, ProductSpecialConfig>> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.state;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = r1.stateList;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r9 = r1.productList;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r10 = r1.productSpecialList;
    L15:
        return r1.copy(r2, r8, r9, r10);
    }

    public final String component1() {
        return this.state;
    }

    public final List<String> component2() {
        return this.stateList;
    }

    public final List<String> component3() {
        return this.productList;
    }

    public final Map<String, Map<String, ProductSpecialConfig>> component4() {
        return this.productSpecialList;
    }

    public final FeatureStateConfigItem copy(String r2, List<String> r3, List<String> r4, Map<String, ? extends Map<String, ProductSpecialConfig>> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r1, "stateList");
        Intrinsics.checkNotNullParameter(r6, "productList");
        Intrinsics.checkNotNullParameter(r7, "productSpecialList");
        return new FeatureStateConfigItem(r2, r1, r6, r7);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FeatureStateConfigItem.class) == true) goto L8;
        return false;
    L8:
        FeatureStateConfigItem r6 = (FeatureStateConfigItem) ZeusTransformUtils.preCheckCast(r5, FeatureStateConfigItem.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.state, r6.state) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.stateList, r6.stateList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.productList, r6.productList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.productSpecialList, r6.productSpecialList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final List<String> getProductList() {
        return this.productList;
    }

    public final Map<String, Map<String, ProductSpecialConfig>> getProductSpecialList() {
        return this.productSpecialList;
    }

    public final String getState() {
        return this.state;
    }

    public final List<String> getStateList() {
        return this.stateList;
    }

    public int hashCode() {
        return (((((this.state.hashCode() * 31) + this.stateList.hashCode()) * 31) + this.productList.hashCode()) * 31) + this.productSpecialList.hashCode();
    }

    public String toString() {
        return "FeatureStateConfigItem(state=" + this.state + ", stateList=" + this.stateList + ", productList=" + this.productList + ", productSpecialList=" + this.productSpecialList + ')';
    }
}
