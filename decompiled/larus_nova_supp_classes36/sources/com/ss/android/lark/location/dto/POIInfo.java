package com.ss.android.lark.location.dto;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class POIInfo implements Cloneable, Serializable {
    private static final long serialVersionUID = 1;
    public transient boolean a;
    private AddressComponent addressComponent;
    private final LarkLocation.CoordinateSystem coordinateSystem;
    private int errorCode;
    private String errorMsg;
    private boolean isInternal;
    private boolean isSelfDefine;
    private double latitude;
    private String locationAddress;
    private LocationImageData locationImageData;
    private String locationName;
    private double longitude;
    private int mZoomLevel;
    private String placeId;
    private String vendor;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Vendor {
        public static final String BAIDU = "baidu";
        public static final String GAODE = "gaode";
        public static final String GOOGLE = "google";
        public static final String TENCENT = "tencent";
    }

    public Object clone() {
        POIInfo r1 = (POIInfo) super.clone();     // Catch: CloneNotSupportedException -> L10
        LocationImageData r0 = this.locationImageData;     // Catch: CloneNotSupportedException -> L8
        if (r0 == null) goto L13;
        r1.setLocationImageData((LocationImageData) r0.clone());     // Catch: CloneNotSupportedException -> L8
    L13:
        return r1;
    L8:
        CloneNotSupportedException e = e;
    L12:
        Log.e("POIInfo", "failed to clone POIInfo.", e);
    L10:
        e = move-exception;
        r1 = null;
        e = e;
        goto L12
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.locationName, this.locationAddress});
    }

    public boolean isPlaceIdEmpty() {
        return TextUtils.isEmpty(this.placeId);
    }

    public POIInfo() {
        this(360.0d, 360.0d, LarkLocation.CoordinateSystem.DEFAULT);
    }

    public AddressComponent getAddressComponent() {
        return this.addressComponent;
    }

    public LarkLocation.CoordinateSystem getCoordinateSystem() {
        return this.coordinateSystem;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public boolean getIsCurrent() {
        return this.a;
    }

    public boolean getIsSelfDefine() {
        return this.isSelfDefine;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getLocationAddress() {
        return this.locationAddress;
    }

    public LocationImageData getLocationImageData() {
        return this.locationImageData;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public String getVendor() {
        return this.vendor;
    }

    public int getZoomLevel() {
        return this.mZoomLevel;
    }

    public boolean isInternal() {
        return this.isInternal;
    }

    public POIInfo(JSONObject r7) {
        this.errorCode = 0;
        this.errorMsg = "";
        this.locationName = r7.optString("locationName");
        this.locationAddress = r7.optString("locationAddress");
        this.latitude = r7.optDouble("latitude", 360.0d);
        this.longitude = r7.optDouble("longitude", 360.0d);
        this.coordinateSystem = LarkLocation.CoordinateSystem.DEFAULT;
        this.isSelfDefine = r7.optBoolean("isSelfDefine", false);
        this.placeId = r7.optString("placeId");
        this.a = false;
    }

    public static POIInfo parse(JSONObject r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new POIInfo(r1);
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof POIInfo) == false) goto L19;
        POIInfo r4 = (POIInfo) r3;
        String r0 = r4.locationName;
        String r1 = "";
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        String r5 = r4.locationAddress;
        if (r5 == null) goto L12;
        r1 = r5;
    L12:
        if (r0.equals(this.locationName) == true) goto L14;
    L16:
        return false;
    L14:
        if (r1.equals(this.locationAddress) == false) goto L16;
        return true;
    L19:
        return super.equals(r3);
    }

    public void setAddressComponent(AddressComponent r1) {
        this.addressComponent = r1;
    }

    public void setErrorCode(int r1) {
        this.errorCode = r1;
    }

    public void setErrorMsg(String r1) {
        this.errorMsg = r1;
    }

    public void setInternal(boolean r1) {
        this.isInternal = r1;
    }

    public void setIsCurrent(boolean r1) {
        this.a = r1;
    }

    public void setIsSelfDefine(boolean r1) {
        this.isSelfDefine = r1;
    }

    public void setLatitude(double r1) {
        this.latitude = r1;
    }

    public void setLocationAddress(String r1) {
        this.locationAddress = r1;
    }

    public void setLocationImageData(LocationImageData r1) {
        this.locationImageData = r1;
    }

    public void setLocationName(String r1) {
        this.locationName = r1;
    }

    public void setLongitude(double r1) {
        this.longitude = r1;
    }

    public void setVendor(String r1) {
        this.vendor = r1;
    }

    public void setZoomLevel(int r1) {
        this.mZoomLevel = r1;
    }

    public POIInfo(double r2, double r4, LarkLocation.CoordinateSystem r6) {
        this.errorCode = 0;
        this.errorMsg = "";
        this.latitude = r2;
        this.longitude = r4;
        this.coordinateSystem = r6;
    }

    public POIInfo(String r7, String r8, double r9, double r11, LarkLocation.CoordinateSystem r13) {
        this(r9, r11, r13);
        this.locationName = r7;
        this.locationAddress = r8;
    }

    public POIInfo(String r9, String r10, String r11, double r12, double r14, LarkLocation.CoordinateSystem r16) {
        this(r10, r11, r12, r14, r16);
        this.placeId = r9;
    }

    public POIInfo(String r1, String r2, double r3, double r5, LarkLocation.CoordinateSystem r7, boolean r8, boolean r9) {
        this(r1, r2, r3, r5, r7);
        this.a = r8;
        this.isSelfDefine = r9;
    }

    public POIInfo(String r11, String r12, String r13, double r14, double r16, LarkLocation.CoordinateSystem r18, boolean r19, boolean r20) {
        this(r12, r13, r14, r16, r18, r19, r20);
        this.placeId = r11;
    }
}
