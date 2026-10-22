package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/r2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "priceRange", "Ljava/util/List;", "a", "()Ljava/util/List;", BuildConfig.FLAVOR, "urlList", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r2 {

    @SerializedName("price_range")
    private final List<Integer> priceRange;

    @SerializedName("url_list")
    private final List<String> urlList;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r2) == false) goto L10;
        r2 r4 = (r2) r3;
        if (Intrinsics.areEqual(this.priceRange, r4.priceRange) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.urlList, r4.urlList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<Integer> r0 = this.priceRange;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.urlList;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TrayBaseImageConfig(priceRange=" + this.priceRange + ", urlList=" + this.urlList + ")";
    }

    public r2() {
        List<Integer> r0 = CollectionsKt.emptyList();
        List<String> r1 = CollectionsKt.emptyList();
        this.priceRange = r0;
        this.urlList = r1;
    }

    public final List<Integer> a() {
        return this.priceRange;
    }

    public final List<String> b() {
        return this.urlList;
    }
}
