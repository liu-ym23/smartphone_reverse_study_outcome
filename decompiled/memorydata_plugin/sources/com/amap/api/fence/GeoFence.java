package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.loc.fd;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GeoFence implements Parcelable {
    public static final int ADDGEOFENCE_SUCCESS = 0;
    public static final String BUNDLE_KEY_CUSTOMID = "customId";
    public static final String BUNDLE_KEY_FENCE = "fence";
    public static final String BUNDLE_KEY_FENCEID = "fenceid";
    public static final String BUNDLE_KEY_FENCESTATUS = "event";
    public static final String BUNDLE_KEY_LOCERRORCODE = "location_errorcode";
    public static final Parcelable.Creator<GeoFence> CREATOR = null;
    public static final int ERROR_CODE_EXISTS = 17;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int ERROR_NO_VALIDFENCE = 16;
    public static final int STATUS_IN = 1;
    public static final int STATUS_LOCFAIL = 4;
    public static final int STATUS_OUT = 2;
    public static final int STATUS_STAYED = 3;
    public static final int STATUS_UNKNOWN = 0;
    public static final int TYPE_AMAPPOI = 2;
    public static final int TYPE_DISTRICT = 3;
    public static final int TYPE_POLYGON = 1;
    public static final int TYPE_ROUND = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f471b;
    private String c;
    private PendingIntent d;
    private int e;
    private PoiItem f;
    private List<DistrictItem> g;
    private List<List<DPoint>> h;
    private float i;
    private long j;
    private int k;
    private float l;
    private float m;
    private DPoint n;
    private int o;
    private long p;
    private boolean q;
    private AMapLocation r;

    static {
        CREATOR = new AnonymousClass1();
    }

    public GeoFence() {
        this.d = null;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.i = 0.0f;
        this.j = -1;
        this.k = 1;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = null;
        this.o = 0;
        this.p = -1;
        this.q = true;
        this.r = null;
    }

    public GeoFence(Parcel r9) {
        this.d = null;
        boolean r1 = false;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.i = 0.0f;
        this.j = -1;
        this.k = 1;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = null;
        this.o = 0;
        this.p = -1;
        this.q = true;
        this.r = null;
        this.f470a = r9.readString();
        this.f471b = r9.readString();
        this.c = r9.readString();
        this.d = (PendingIntent) ZeusTransformUtils.preCheckCast(r9.readParcelable(PendingIntent.class.getClassLoader()), PendingIntent.class, "com.obric.memorydata.plugin");
        this.e = r9.readInt();
        this.f = (PoiItem) ZeusTransformUtils.preCheckCast(r9.readParcelable(PoiItem.class.getClassLoader()), PoiItem.class, "com.obric.memorydata.plugin");
        this.g = r9.createTypedArrayList(DistrictItem.CREATOR);
        this.i = r9.readFloat();
        this.j = r9.readLong();
        this.k = r9.readInt();
        this.l = r9.readFloat();
        this.m = r9.readFloat();
        this.n = (DPoint) ZeusTransformUtils.preCheckCast(r9.readParcelable(DPoint.class.getClassLoader()), DPoint.class, "com.obric.memorydata.plugin");
        this.o = r9.readInt();
        this.p = r9.readLong();
        int r0 = r9.readInt();
        if (r0 == 0) goto L8;
        this.h = new ArrayList();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L8;
        this.h.add(r9.createTypedArrayList(DPoint.CREATOR));
        r2 = r2 + 1;
    L8:
        if (r9.readByte() == 0) goto L10;
        r1 = true;
    L10:
        this.q = r1;
        this.r = (AMapLocation) ZeusTransformUtils.preCheckCast(r9.readParcelable(AMapLocation.class.getClassLoader()), AMapLocation.class, "com.obric.memorydata.plugin");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, GeoFence.class) == true) goto L5;
        return false;
    L5:
        GeoFence r5 = (GeoFence) ZeusTransformUtils.preCheckCast(r4, GeoFence.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(this.f471b) == false) goto L11;
        if (TextUtils.isEmpty(r5.f471b) == true) goto L13;
        return false;
    L13:
        DPoint r0 = this.n;
        if (r0 != null) goto L19;
        if (r5.n == null) goto L22;
        return false;
    L22:
        if (this.i == r5.i) goto L24;
        return false;
    L24:
        List<List<DPoint>> r3 = this.h;
        if (r3 != null) goto L30;
        if (r5.h == null) goto L32;
        return false;
    L32:
        return true;
    L30:
        if (r3.equals(r5.h) == true) goto L34;
        return false;
    L34:
        return true;
    L19:
        if (r0.equals(r5.n) == true) goto L22;
        return false;
    L11:
        if (this.f471b.equals(r5.f471b) == true) goto L13;
        return false;
    }

    public int getActivatesAction() {
        return this.k;
    }

    public DPoint getCenter() {
        return this.n;
    }

    public AMapLocation getCurrentLocation() {
        return this.r;
    }

    public String getCustomId() {
        return this.f471b;
    }

    public List<DistrictItem> getDistrictItemList() {
        return this.g;
    }

    public long getEnterTime() {
        return this.p;
    }

    public long getExpiration() {
        return this.j;
    }

    public String getFenceId() {
        return this.f470a;
    }

    public float getMaxDis2Center() {
        return this.m;
    }

    public float getMinDis2Center() {
        return this.l;
    }

    public PendingIntent getPendingIntent() {
        return this.d;
    }

    public String getPendingIntentAction() {
        return this.c;
    }

    public PoiItem getPoiItem() {
        return this.f;
    }

    public List<List<DPoint>> getPointList() {
        return this.h;
    }

    public float getRadius() {
        return this.i;
    }

    public int getStatus() {
        return this.o;
    }

    public int getType() {
        return this.e;
    }

    public int hashCode() {
        return ((this.f471b.hashCode() + this.h.hashCode()) + this.n.hashCode()) + ((int) (this.i * 100.0f));
    }

    public boolean isAble() {
        return this.q;
    }

    public void setAble(boolean r1) {
        this.q = r1;
    }

    public void setActivatesAction(int r1) {
        this.k = r1;
    }

    public void setCenter(DPoint r1) {
        this.n = r1;
    }

    public void setCurrentLocation(AMapLocation r1) {
        this.r = r1.clone();
    }

    public void setCustomId(String r1) {
        this.f471b = r1;
    }

    public void setDistrictItemList(List<DistrictItem> r3) {
        this.g = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setEnterTime(long r1) {
        this.p = r1;
    }

    public void setExpiration(long r3) {
        if (r3 >= 0) goto L7;
        long r4 = -1;
    L5:
        this.j = r4;
        return;
    L7:
        r4 = r3 + fd.b();
        goto L5
    }

    public void setFenceId(String r1) {
        this.f470a = r1;
    }

    public void setMaxDis2Center(float r1) {
        this.m = r1;
    }

    public void setMinDis2Center(float r1) {
        this.l = r1;
    }

    public void setPendingIntent(PendingIntent r1) {
        this.d = r1;
    }

    public void setPendingIntentAction(String r1) {
        this.c = r1;
    }

    public void setPoiItem(PoiItem r1) {
        this.f = r1;
    }

    public void setPointList(List<List<DPoint>> r3) {
        this.h = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setRadius(float r1) {
        this.i = r1;
    }

    public void setStatus(int r1) {
        this.o = r1;
    }

    public void setType(int r1) {
        this.e = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeString(this.f470a);
        r5.writeString(this.f471b);
        r5.writeString(this.c);
        r5.writeParcelable(this.d, r6);
        r5.writeInt(this.e);
        r5.writeParcelable(this.f, r6);
        r5.writeTypedList(this.g);
        r5.writeFloat(this.i);
        r5.writeLong(this.j);
        r5.writeInt(this.k);
        r5.writeFloat(this.l);
        r5.writeFloat(this.m);
        r5.writeParcelable(this.n, r6);
        r5.writeInt(this.o);
        r5.writeLong(this.p);
        List<List<DPoint>> r0 = this.h;
        if (r0 != null) goto L5;
    L10:
        r5.writeByte(this.q ? 1 : 0);
        r5.writeParcelable(this.r, r6);
        return;
    L5:
        if (r0.isEmpty() == true) goto L10;
        r5.writeInt(this.h.size());
        Iterator<List<DPoint>> r1 = this.h.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r5.writeTypedList((List) ZeusTransformUtils.preCheckCast(r1.next(), List.class, "com.obric.memorydata.plugin"));
        goto L8
    }
}
