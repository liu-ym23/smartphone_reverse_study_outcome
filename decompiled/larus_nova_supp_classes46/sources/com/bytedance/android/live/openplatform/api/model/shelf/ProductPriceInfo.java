package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.ProductPriceInfo")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductPriceInfo;", "Landroid/os/Parcelable;", "", "originalPrice", "Ljava/lang/String;", "currentPrice", "currentPrefix", "currentSuffix", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductPriceInfo implements Parcelable, h {
    public static final Parcelable.Creator<ProductPriceInfo> CREATOR = null;

    @SerializedName("current_prefix")
    public String currentPrefix;

    @SerializedName("current_price")
    public String currentPrice;

    @SerializedName("current_suffix")
    public String currentSuffix;

    @SerializedName("original_price")
    public String originalPrice;

    public static class a implements Parcelable.Creator<ProductPriceInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProductPriceInfo createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "in");
            return new ProductPriceInfo(r5.readString(), r5.readString(), r5.readString(), r5.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ProductPriceInfo[] newArray(int r1) {
            return new ProductPriceInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ProductPriceInfo(String r1, String r2, String r3, String r4) {
        this.originalPrice = r1;
        this.currentPrice = r2;
        this.currentPrefix = r3;
        this.currentSuffix = r4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ProductPriceInfo) == false) goto L14;
        ProductPriceInfo r4 = (ProductPriceInfo) r3;
        if (Intrinsics.areEqual(this.originalPrice, r4.originalPrice) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.currentPrice, r4.currentPrice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.currentPrefix, r4.currentPrefix) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.currentSuffix, r4.currentSuffix) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.originalPrice;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.currentPrice;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.currentPrefix;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.currentSuffix;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductPriceInfo(originalPrice=" + this.originalPrice + ", currentPrice=" + this.currentPrice + ", currentPrefix=" + this.currentPrefix + ", currentSuffix=" + this.currentSuffix + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.originalPrice);
        r1.writeString(this.currentPrice);
        r1.writeString(this.currentPrefix);
        r1.writeString(this.currentSuffix);
    }

    public ProductPriceInfo() {
        this.originalPrice = null;
        this.currentPrice = null;
        this.currentPrefix = null;
        this.currentSuffix = null;
    }

    public ProductPriceInfo(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.originalPrice = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.currentPrice = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.currentPrefix = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.currentSuffix = am3.h.c(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
        if (this.originalPrice != null) goto L22;
        this.originalPrice = null;
    L22:
        if (this.currentPrice != null) goto L25;
        this.currentPrice = null;
    L25:
        if (this.currentPrefix != null) goto L28;
        this.currentPrefix = null;
    L28:
        if (this.currentSuffix != null) goto L46;
        this.currentSuffix = null;
        return;
    }
}
