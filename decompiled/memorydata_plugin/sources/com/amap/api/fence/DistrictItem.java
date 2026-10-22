package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.location.DPoint;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f469b;
    private String c;
    private List<DPoint> d;

    static {
        CREATOR = new AnonymousClass1();
    }

    public DistrictItem() {
        this.f468a = "";
        this.f469b = null;
        this.c = null;
        this.d = null;
    }

    public DistrictItem(Parcel r2) {
        this.f468a = "";
        this.f469b = null;
        this.c = null;
        this.d = null;
        this.f468a = r2.readString();
        this.f469b = r2.readString();
        this.c = r2.readString();
        this.d = r2.createTypedArrayList(DPoint.CREATOR);
    }

    public static Parcelable.Creator<DistrictItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.c;
    }

    public String getCitycode() {
        return this.f469b;
    }

    public String getDistrictName() {
        return this.f468a;
    }

    public List<DPoint> getPolyline() {
        return this.d;
    }

    public void setAdcode(String r1) {
        this.c = r1;
    }

    public void setCitycode(String r1) {
        this.f469b = r1;
    }

    public void setDistrictName(String r1) {
        this.f468a = r1;
    }

    public void setPolyline(List<DPoint> r3) {
        this.d = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.f468a);
        r1.writeString(this.f469b);
        r1.writeString(this.c);
        r1.writeTypedList(this.d);
    }
}
