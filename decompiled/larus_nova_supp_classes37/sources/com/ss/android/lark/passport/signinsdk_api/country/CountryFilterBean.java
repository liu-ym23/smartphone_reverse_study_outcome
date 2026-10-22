package com.ss.android.lark.passport.signinsdk_api.country;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B-\b\u0007\u0012\u0010\b\u0003\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J-\u0010\u000b\u001a\u00020\u00002\u0010\b\u0003\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rR\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/country/CountryFilterBean;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "allowRegionList", "", "", "blockRegionList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class CountryFilterBean implements Parcelable, Serializable {
    public static final Parcelable.Creator<CountryFilterBean> CREATOR = null;
    public List<String> allowRegionList;
    public List<String> blockRegionList;

    public static final class a implements Parcelable.Creator<CountryFilterBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CountryFilterBean createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new CountryFilterBean(r3.createStringArrayList(), r3.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final CountryFilterBean[] newArray(int r1) {
            return new CountryFilterBean[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CountryFilterBean() {
        List r0 = null;
        this(r0, r0, 3, r0);
    }

    public CountryFilterBean(@JSONField(name = "allow_region_list") List<String> r3) {
        List r0 = null;
        this(r3, r0, 2, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CountryFilterBean copy$default(CountryFilterBean r0, List r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.allowRegionList;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.blockRegionList;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<String> component1() {
        return this.allowRegionList;
    }

    public final List<String> component2() {
        return this.blockRegionList;
    }

    public final CountryFilterBean copy(@JSONField(name = "allow_region_list") List<String> r2, @JSONField(name = "block_region_list") List<String> r3) {
        return new CountryFilterBean(r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CountryFilterBean) == true) goto L8;
        return false;
    L8:
        CountryFilterBean r6 = (CountryFilterBean) r5;
        if (Intrinsics.areEqual(this.allowRegionList, r6.allowRegionList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blockRegionList, r6.blockRegionList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<String> r0 = this.allowRegionList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.blockRegionList;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CountryFilterBean(allowRegionList=" + this.allowRegionList + ", blockRegionList=" + this.blockRegionList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeStringList(this.allowRegionList);
        r1.writeStringList(this.blockRegionList);
    }

    public CountryFilterBean(@JSONField(name = "allow_region_list") List<String> r1, @JSONField(name = "block_region_list") List<String> r2) {
        this.allowRegionList = r1;
        this.blockRegionList = r2;
    }

    public /* synthetic */ CountryFilterBean(List r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
