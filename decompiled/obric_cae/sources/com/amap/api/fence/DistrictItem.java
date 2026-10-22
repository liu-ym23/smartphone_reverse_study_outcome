package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.location.DPoint;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3604b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f3605m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f3606n;

    public static class a implements Parcelable.Creator<DistrictItem> {
        @Override // android.os.Parcelable.Creator
        public final DistrictItem createFromParcel(Parcel r8) {
            return new DistrictItem(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final DistrictItem[] newArray(int r8) {
            return new DistrictItem[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public DistrictItem() {
        this.f3603a = "";
        this.f3604b = null;
        this.f3605m = null;
        this.f3606n = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.f3603a);
        r8.writeString(this.f3604b);
        r8.writeString(this.f3605m);
        r8.writeTypedList(this.f3606n);
    }

    public DistrictItem(Parcel r8) {
        this.f3603a = "";
        this.f3604b = null;
        this.f3605m = null;
        this.f3606n = null;
        this.f3603a = r8.readString();
        this.f3604b = r8.readString();
        this.f3605m = r8.readString();
        this.f3606n = r8.createTypedArrayList(DPoint.CREATOR);
    }
}
