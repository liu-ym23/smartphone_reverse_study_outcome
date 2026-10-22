package com.obric.aiagent.product.feature;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012 \b\u0002\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J!\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b0\u000bHÆ\u0003Jo\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072 \b\u0002\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b0\u000bHÆ\u0001J\u0006\u0010 \u001a\u00020!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020!HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020!R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R.\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b0\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006,"}, d2 = {"Lcom/obric/aiagent/product/feature/FeatureConfig;", "Landroid/os/Parcelable;", "enabled", "", "defaultState", "", "dependencyOsFeatureList", "", "productBlackList", "productWhiteList", "productSpecialList", "", "Lcom/obric/aiagent/product/feature/ProductSpecialConfig;", "<init>", "(ZLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getEnabled", "()Z", "getDefaultState", "()Ljava/lang/String;", "getDependencyOsFeatureList", "()Ljava/util/List;", "getProductBlackList", "getProductWhiteList", "getProductSpecialList", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FeatureConfig implements Parcelable {
    public static final Parcelable.Creator<FeatureConfig> CREATOR = null;

    @SerializedName("default_state")
    private final String defaultState;

    @SerializedName("dependency_os_feature_list")
    private final List<String> dependencyOsFeatureList;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("product_black_list")
    private final List<String> productBlackList;

    @SerializedName("product_special_list")
    private final Map<String, Map<String, ProductSpecialConfig>> productSpecialList;

    @SerializedName("product_white_list")
    private final List<String> productWhiteList;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<FeatureConfig> {
        public a() {
        }

        public final FeatureConfig a(Parcel r17) {
            Intrinsics.checkNotNullParameter(r17, "parcel");
            if (r17.readInt() == 0) goto L5;
            boolean r4 = true;
        L6:
            String r5 = r17.readString();
            List r1 = (List) ZeusTransformUtils.preCheckCast(r17.createStringArrayList(), List.class, "com.obric.memorydata.plugin");
            List r7 = (List) ZeusTransformUtils.preCheckCast(r17.createStringArrayList(), List.class, "com.obric.memorydata.plugin");
            List r8 = (List) ZeusTransformUtils.preCheckCast(r17.createStringArrayList(), List.class, "com.obric.memorydata.plugin");
            int r3 = r17.readInt();
            LinkedHashMap r9 = new LinkedHashMap(r3);
            int r10 = 0;
        L7:
            if (r10 == r3) goto L13;
            String r11 = r17.readString();
            int r12 = r17.readInt();
            LinkedHashMap r13 = new LinkedHashMap(r12);
            int r14 = 0;
        L9:
            if (r14 == r12) goto L11;
            r13.put(r17.readString(), ProductSpecialConfig.CREATOR.createFromParcel(r17));
            r14 = r14 + 1;
            goto L9
        L11:
            r9.put(r11, r13);
            r10 = r10 + 1;
            goto L7
        L13:
            return new FeatureConfig(r4, r5, r1, r7, r8, (Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin"));
        L5:
            r4 = false;
            goto L6
        }

        public final FeatureConfig[] a(int r1) {
            return new FeatureConfig[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ FeatureConfig createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ FeatureConfig[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public FeatureConfig() {
        this(false, null, null, null, null, null, 63, null);
    }

    public FeatureConfig(boolean r3, String r4, List<String> r5, List<String> r6, List<String> r7, Map<String, ? extends Map<String, ProductSpecialConfig>> r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Map<String, Map<String, ProductSpecialConfig>> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "defaultState");
        Intrinsics.checkNotNullParameter(r9, "dependencyOsFeatureList");
        Intrinsics.checkNotNullParameter(r10, "productBlackList");
        Intrinsics.checkNotNullParameter(r11, "productWhiteList");
        Intrinsics.checkNotNullParameter(r12, "productSpecialList");
        this.enabled = r3;
        this.defaultState = r4;
        this.dependencyOsFeatureList = r9;
        this.productBlackList = r10;
        this.productWhiteList = r11;
        this.productSpecialList = r12;
    }

    public /* synthetic */ FeatureConfig(boolean r8, String r9, List r10, List r11, List r12, Map r13, int r14, DefaultConstructorMarker r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List r18 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Map r19 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = true;
    L5:
        boolean r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = "enabled";
    L8:
        String r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r16 = CollectionsKt.emptyList();
    L11:
        List r3 = r16;
        if ((r14 & 8) == 0) goto L14;
        r17 = CollectionsKt.emptyList();
    L14:
        List r4 = r17;
        if ((r14 & 16) == 0) goto L17;
        r18 = CollectionsKt.emptyList();
    L17:
        List r5 = r18;
        if ((r14 & 32) == 0) goto L20;
        r19 = MapsKt.emptyMap();
    L20:
        this(r1, r2, r3, r4, r5, r19);
    }

    public static /* synthetic */ FeatureConfig copy$default(FeatureConfig r7, boolean r8, String r9, List r10, List r11, List r12, Map r13, int r14, Object r15) {
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List<String> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List<String> r18 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Map<String, Map<String, ProductSpecialConfig>> r19 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.enabled;
    L5:
        boolean r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = r7.defaultState;
    L8:
        String r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r16 = r7.dependencyOsFeatureList;
    L11:
        List<String> r3 = r16;
        if ((r14 & 8) == 0) goto L14;
        r17 = r7.productBlackList;
    L14:
        List<String> r4 = r17;
        if ((r14 & 16) == 0) goto L17;
        r18 = r7.productWhiteList;
    L17:
        List<String> r5 = r18;
        if ((r14 & 32) == 0) goto L21;
        r19 = r7.productSpecialList;
    L21:
        return r7.copy(r1, r2, r3, r4, r5, r19);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final String component2() {
        return this.defaultState;
    }

    public final List<String> component3() {
        return this.dependencyOsFeatureList;
    }

    public final List<String> component4() {
        return this.productBlackList;
    }

    public final List<String> component5() {
        return this.productWhiteList;
    }

    public final Map<String, Map<String, ProductSpecialConfig>> component6() {
        return this.productSpecialList;
    }

    public final FeatureConfig copy(boolean r9, String r10, List<String> r11, List<String> r12, List<String> r13, Map<String, ? extends Map<String, ProductSpecialConfig>> r14) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "defaultState");
        Intrinsics.checkNotNullParameter(r4, "dependencyOsFeatureList");
        Intrinsics.checkNotNullParameter(r5, "productBlackList");
        Intrinsics.checkNotNullParameter(r6, "productWhiteList");
        Intrinsics.checkNotNullParameter(r7, "productSpecialList");
        return new FeatureConfig(r9, r10, r4, r5, r6, r7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FeatureConfig.class) == true) goto L8;
        return false;
    L8:
        FeatureConfig r6 = (FeatureConfig) ZeusTransformUtils.preCheckCast(r5, FeatureConfig.class, "com.obric.memorydata.plugin");
        if (this.enabled == r6.enabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultState, r6.defaultState) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.dependencyOsFeatureList, r6.dependencyOsFeatureList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.productBlackList, r6.productBlackList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.productWhiteList, r6.productWhiteList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.productSpecialList, r6.productSpecialList) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getDefaultState() {
        return this.defaultState;
    }

    public final List<String> getDependencyOsFeatureList() {
        return this.dependencyOsFeatureList;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<String> getProductBlackList() {
        return this.productBlackList;
    }

    public final Map<String, Map<String, ProductSpecialConfig>> getProductSpecialList() {
        return this.productSpecialList;
    }

    public final List<String> getProductWhiteList() {
        return this.productWhiteList;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.enabled) * 31) + this.defaultState.hashCode()) * 31) + this.dependencyOsFeatureList.hashCode()) * 31) + this.productBlackList.hashCode()) * 31) + this.productWhiteList.hashCode()) * 31) + this.productSpecialList.hashCode();
    }

    public String toString() {
        return "FeatureConfig(enabled=" + this.enabled + ", defaultState=" + this.defaultState + ", dependencyOsFeatureList=" + this.dependencyOsFeatureList + ", productBlackList=" + this.productBlackList + ", productWhiteList=" + this.productWhiteList + ", productSpecialList=" + this.productSpecialList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeInt(this.enabled ? 1 : 0);
        r6.writeString(this.defaultState);
        r6.writeStringList(this.dependencyOsFeatureList);
        r6.writeStringList(this.productBlackList);
        r6.writeStringList(this.productWhiteList);
        Map<String, Map<String, ProductSpecialConfig>> r5 = this.productSpecialList;
        r6.writeInt(r5.size());
        Iterator<Map.Entry<String, Map<String, ProductSpecialConfig>>> r8 = r5.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Map.Entry<String, Map<String, ProductSpecialConfig>> r0 = r8.next();
        r6.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin"));
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Map.class, "com.obric.memorydata.plugin");
        r6.writeInt(r1.size());
        Iterator r2 = r1.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        Object r3 = r2.next();
        r6.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin"));
        ((ProductSpecialConfig) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), ProductSpecialConfig.class, "com.obric.memorydata.plugin")).writeToParcel(r6, r7);
        goto L7
    }
}
