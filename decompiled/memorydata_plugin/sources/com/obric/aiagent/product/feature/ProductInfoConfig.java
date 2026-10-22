package com.obric.aiagent.product.feature;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crypto.platform.PlatformConst;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jo\u0010\u001a\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/obric/aiagent/product/feature/ProductInfoConfig;", "Landroid/os/Parcelable;", "manufacturer", "", "", PlatformConst.BUNDLE_KEY_BRAND, "model", ActivityLifecycle.NAME, "device", "policy", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getManufacturer", "()Ljava/util/List;", "getBrand", "getModel", "getName", "getDevice", "getPolicy", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProductInfoConfig implements Parcelable {
    public static final Parcelable.Creator<ProductInfoConfig> CREATOR = null;

    @SerializedName(PlatformConst.PROP_BRAND)
    private final List<String> brand;

    @SerializedName("ro.product.device")
    private final List<String> device;

    @SerializedName(PlatformConst.PROP_MANUFACTURER)
    private final List<String> manufacturer;

    @SerializedName("ro.product.model")
    private final List<String> model;

    @SerializedName("ro.product.name")
    private final List<String> name;

    @SerializedName("policy")
    private final String policy;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ProductInfoConfig> {
        public a() {
        }

        public final ProductInfoConfig a(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            return new ProductInfoConfig((List) ZeusTransformUtils.preCheckCast(r8.createStringArrayList(), List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(r8.createStringArrayList(), List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(r8.createStringArrayList(), List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(r8.createStringArrayList(), List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(r8.createStringArrayList(), List.class, "com.obric.memorydata.plugin"), r8.readString());
        }

        public final ProductInfoConfig[] a(int r1) {
            return new ProductInfoConfig[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProductInfoConfig createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProductInfoConfig[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public ProductInfoConfig() {
        this(null, null, null, null, null, null, 63, null);
    }

    public ProductInfoConfig(List<String> r3, List<String> r4, List<String> r5, List<String> r6, List<String> r7, String r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.manufacturer = r9;
        this.brand = r10;
        this.model = r11;
        this.name = r12;
        this.device = r13;
        this.policy = r8;
    }

    public /* synthetic */ ProductInfoConfig(List r8, List r9, List r10, List r11, List r12, String r13, int r14, DefaultConstructorMarker r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List r18 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List r19 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List r110 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L5;
        r16 = CollectionsKt.emptyList();
    L5:
        List r1 = r16;
        if ((r14 & 2) == 0) goto L8;
        r17 = CollectionsKt.emptyList();
    L8:
        List r2 = r17;
        if ((r14 & 4) == 0) goto L11;
        r18 = CollectionsKt.emptyList();
    L11:
        List r3 = r18;
        if ((r14 & 8) == 0) goto L14;
        r19 = CollectionsKt.emptyList();
    L14:
        List r4 = r19;
        if ((r14 & 16) == 0) goto L17;
        r110 = CollectionsKt.emptyList();
    L17:
        List r5 = r110;
        if ((r14 & 32) == 0) goto L20;
        r13 = "and";
    L20:
        this(r1, r2, r3, r4, r5, r13);
    }

    public static /* synthetic */ ProductInfoConfig copy$default(ProductInfoConfig r7, List r8, List r9, List r10, List r11, List r12, String r13, int r14, Object r15) {
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List<String> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<String> r18 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List<String> r19 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List<String> r110 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L5;
        r16 = r7.manufacturer;
    L5:
        List<String> r1 = r16;
        if ((r14 & 2) == 0) goto L8;
        r17 = r7.brand;
    L8:
        List<String> r2 = r17;
        if ((r14 & 4) == 0) goto L11;
        r18 = r7.model;
    L11:
        List<String> r3 = r18;
        if ((r14 & 8) == 0) goto L14;
        r19 = r7.name;
    L14:
        List<String> r4 = r19;
        if ((r14 & 16) == 0) goto L17;
        r110 = r7.device;
    L17:
        List<String> r5 = r110;
        if ((r14 & 32) == 0) goto L21;
        r13 = r7.policy;
    L21:
        return r7.copy(r1, r2, r3, r4, r5, r13);
    }

    public final List<String> component1() {
        return this.manufacturer;
    }

    public final List<String> component2() {
        return this.brand;
    }

    public final List<String> component3() {
        return this.model;
    }

    public final List<String> component4() {
        return this.name;
    }

    public final List<String> component5() {
        return this.device;
    }

    public final String component6() {
        return this.policy;
    }

    public final ProductInfoConfig copy(List<String> r9, List<String> r10, List<String> r11, List<String> r12, List<String> r13, String r14) {
        return new ProductInfoConfig((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin"), r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ProductInfoConfig.class) == true) goto L8;
        return false;
    L8:
        ProductInfoConfig r6 = (ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5, ProductInfoConfig.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.manufacturer, r6.manufacturer) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.brand, r6.brand) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.model, r6.model) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.device, r6.device) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.policy, r6.policy) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final List<String> getBrand() {
        return this.brand;
    }

    public final List<String> getDevice() {
        return this.device;
    }

    public final List<String> getManufacturer() {
        return this.manufacturer;
    }

    public final List<String> getModel() {
        return this.model;
    }

    public final List<String> getName() {
        return this.name;
    }

    public final String getPolicy() {
        return this.policy;
    }

    public int hashCode() {
        List<String> r0 = this.manufacturer;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.brand;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.model;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.name;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.device;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.policy;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ProductInfoConfig(manufacturer=" + this.manufacturer + ", brand=" + this.brand + ", model=" + this.model + ", name=" + this.name + ", device=" + this.device + ", policy=" + this.policy + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeStringList(this.manufacturer);
        r1.writeStringList(this.brand);
        r1.writeStringList(this.model);
        r1.writeStringList(this.name);
        r1.writeStringList(this.device);
        r1.writeString(this.policy);
    }
}
