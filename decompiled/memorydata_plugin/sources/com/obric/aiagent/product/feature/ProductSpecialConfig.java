package com.obric.aiagent.product.feature;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/aiagent/product/feature/ProductSpecialConfig;", "Landroid/os/Parcelable;", "minRomVersion", "", "maxRomVersion", "romVersionBlackList", "", "minRomReleaseDate", "", "maxRomReleaseDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JJ)V", "getMinRomVersion", "()Ljava/lang/String;", "getMaxRomVersion", "getRomVersionBlackList", "()Ljava/util/List;", "getMinRomReleaseDate", "()J", "getMaxRomReleaseDate", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProductSpecialConfig implements Parcelable {
    public static final Parcelable.Creator<ProductSpecialConfig> CREATOR = null;

    @SerializedName("max_rom_release_date")
    private final long maxRomReleaseDate;

    @SerializedName("max_rom_version")
    private final String maxRomVersion;

    @SerializedName("min_rom_release_date")
    private final long minRomReleaseDate;

    @SerializedName("min_rom_version")
    private final String minRomVersion;

    @SerializedName("rom_version_black_list")
    private final List<String> romVersionBlackList;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ProductSpecialConfig> {
        public a() {
        }

        public final ProductSpecialConfig a(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            return new ProductSpecialConfig(r9.readString(), r9.readString(), (List) ZeusTransformUtils.preCheckCast(r9.createStringArrayList(), List.class, "com.obric.memorydata.plugin"), r9.readLong(), r9.readLong());
        }

        public final ProductSpecialConfig[] a(int r1) {
            return new ProductSpecialConfig[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProductSpecialConfig createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProductSpecialConfig[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public ProductSpecialConfig() {
        this(null, null, null, 0, 0, 31, null);
    }

    public ProductSpecialConfig(String r3, String r4, List<String> r5, long r6, long r8) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "minRomVersion");
        Intrinsics.checkNotNullParameter(r4, "maxRomVersion");
        Intrinsics.checkNotNullParameter(r7, "romVersionBlackList");
        this.minRomVersion = r3;
        this.maxRomVersion = r4;
        this.romVersionBlackList = r7;
        this.minRomReleaseDate = r6;
        this.maxRomReleaseDate = r8;
    }

    public /* synthetic */ ProductSpecialConfig(String r9, String r10, List r11, long r12, long r14, int r16, DefaultConstructorMarker r17) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        String r2 = "";
        if ((r16 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r16 & 2) != 0) goto L11;
        r2 = r10;
    L11:
        if ((r16 & 4) == 0) goto L13;
        r0 = CollectionsKt.emptyList();
    L13:
        long r4 = 0;
        if ((r16 & 8) == 0) goto L16;
        long r6 = 0;
    L18:
        if ((r16 & 16) != 0) goto L21;
        r4 = r14;
    L21:
        this(r1, r2, r0, r6, r4);
        return;
    L16:
        r6 = r12;
        goto L18
    L5:
        r1 = r9;
        goto L7
    }

    public static /* synthetic */ ProductSpecialConfig copy$default(ProductSpecialConfig r8, String r9, String r10, List r11, long r12, long r14, int r16, Object r17) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if ((r16 & 1) == 0) goto L5;
        String r2 = r8.minRomVersion;
    L7:
        if ((r16 & 2) == 0) goto L9;
        String r3 = r8.maxRomVersion;
    L11:
        if ((r16 & 4) == 0) goto L14;
        r1 = r8.romVersionBlackList;
    L14:
        if ((r16 & 8) == 0) goto L16;
        long r4 = r8.minRomReleaseDate;
    L18:
        if ((r16 & 16) == 0) goto L20;
        long r6 = r8.maxRomReleaseDate;
    L22:
        return r8.copy(r2, r3, r1, r4, r6);
    L20:
        r6 = r14;
        goto L22
    L16:
        r4 = r12;
        goto L18
    L9:
        r3 = r10;
        goto L11
    L5:
        r2 = r9;
        goto L7
    }

    public final String component1() {
        return this.minRomVersion;
    }

    public final String component2() {
        return this.maxRomVersion;
    }

    public final List<String> component3() {
        return this.romVersionBlackList;
    }

    public final long component4() {
        return this.minRomReleaseDate;
    }

    public final long component5() {
        return this.maxRomReleaseDate;
    }

    public final ProductSpecialConfig copy(String r9, String r10, List<String> r11, long r12, long r14) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "minRomVersion");
        Intrinsics.checkNotNullParameter(r10, "maxRomVersion");
        Intrinsics.checkNotNullParameter(r3, "romVersionBlackList");
        return new ProductSpecialConfig(r9, r10, r3, r12, r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProductSpecialConfig.class) == true) goto L8;
        return false;
    L8:
        ProductSpecialConfig r10 = (ProductSpecialConfig) ZeusTransformUtils.preCheckCast(r9, ProductSpecialConfig.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.minRomVersion, r10.minRomVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxRomVersion, r10.maxRomVersion) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.romVersionBlackList, r10.romVersionBlackList) == true) goto L18;
        return false;
    L18:
        if (this.minRomReleaseDate == r10.minRomReleaseDate) goto L21;
        return false;
    L21:
        if (this.maxRomReleaseDate == r10.maxRomReleaseDate) goto L23;
        return false;
    L23:
        return true;
    }

    public final long getMaxRomReleaseDate() {
        return this.maxRomReleaseDate;
    }

    public final String getMaxRomVersion() {
        return this.maxRomVersion;
    }

    public final long getMinRomReleaseDate() {
        return this.minRomReleaseDate;
    }

    public final String getMinRomVersion() {
        return this.minRomVersion;
    }

    public final List<String> getRomVersionBlackList() {
        return this.romVersionBlackList;
    }

    public int hashCode() {
        return (((((((this.minRomVersion.hashCode() * 31) + this.maxRomVersion.hashCode()) * 31) + this.romVersionBlackList.hashCode()) * 31) + Long.hashCode(this.minRomReleaseDate)) * 31) + Long.hashCode(this.maxRomReleaseDate);
    }

    public String toString() {
        return "ProductSpecialConfig(minRomVersion=" + this.minRomVersion + ", maxRomVersion=" + this.maxRomVersion + ", romVersionBlackList=" + this.romVersionBlackList + ", minRomReleaseDate=" + this.minRomReleaseDate + ", maxRomReleaseDate=" + this.maxRomReleaseDate + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.minRomVersion);
        r3.writeString(this.maxRomVersion);
        r3.writeStringList(this.romVersionBlackList);
        r3.writeLong(this.minRomReleaseDate);
        r3.writeLong(this.maxRomReleaseDate);
    }
}
