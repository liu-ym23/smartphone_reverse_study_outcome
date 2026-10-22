package com.byted.mgl.merge.service.model;

import android.location.Location;
import android.os.Build;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.log.BdpLogService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BdpLocation extends Location implements Cloneable {
    public static final int STATUS_ERROR_TYPE_NETWORK_ERROR = 3;
    public static final int STATUS_ERROR_TYPE_OTHERS = 1;
    public static final int STATUS_ERROR_TYPE_PERMISSION_ERROR = 4;
    public static final int STATUS_ERROR_TYPE_TIME_OUT = 2;
    public static final int STATUS_NO_ENOUGH_LOCATE_SIGNAL = 5;
    public static final int STATUS_SUCCESS = 0;
    private final String TAG;
    private String address;
    private String city;
    private String cityCode;
    private String country;
    private String countryCode;
    private String district;
    private String districtCode;
    private String errorMsg;
    private int mLocType;
    private int mRawImplStatusCode;
    private int mStatusCode;
    private String name;
    private String province;
    private String provinceCode;

    public JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        r0.putOpt("provider", getProvider());     // Catch: JSONException -> L9
        r0.putOpt("latitude", Double.valueOf(getLatitude()));     // Catch: JSONException -> L9
        r0.putOpt("longitude", Double.valueOf(getLongitude()));     // Catch: JSONException -> L9
        r0.putOpt("loc_time", Long.valueOf(getTime()));     // Catch: JSONException -> L9
        r0.putOpt("speed", Float.valueOf(getSpeed()));     // Catch: JSONException -> L9
        r0.putOpt("accuracy", Float.valueOf(getAccuracy()));     // Catch: JSONException -> L9
        r0.putOpt("altitude", Double.valueOf(getAltitude()));     // Catch: JSONException -> L9
        r0.putOpt(a.KEY_STATUS_CODE, Integer.valueOf(getStatusCode()));     // Catch: JSONException -> L9
        r0.putOpt("rawImplStatusCode", Integer.valueOf(getRawImplStatusCode()));     // Catch: JSONException -> L9
        r0.putOpt(a.KEY_SHOPPING_GUIDE_NAME, getName());     // Catch: JSONException -> L9
        r0.putOpt("address", getAddress());     // Catch: JSONException -> L9
        r0.putOpt("country", getCountry());     // Catch: JSONException -> L9
        r0.putOpt("province", getProvince());     // Catch: JSONException -> L9
        r0.putOpt("city", getCity());     // Catch: JSONException -> L9
        r0.putOpt("district", getDistrict());     // Catch: JSONException -> L9
        r0.putOpt("loctype", Integer.valueOf(getLocType()));     // Catch: JSONException -> L9
        r0.putOpt("countryCode", getCountryCode());     // Catch: JSONException -> L9
        r0.putOpt("provinceCode", getProvinceCode());     // Catch: JSONException -> L9
        r0.putOpt("cityCode", getCityCode());     // Catch: JSONException -> L9
        r0.putOpt("districtCode", getDistrictCode());     // Catch: JSONException -> L9
        r0.putOpt("errorMsg", getErrorMsg());     // Catch: JSONException -> L9
        if (Build.VERSION.SDK_INT < 26) goto L6;
        float r1 = getVerticalAccuracyMeters();     // Catch: JSONException -> L9
    L7:
        r0.put("verticalAccuracy", r1);     // Catch: JSONException -> L9
    L11:
        return r0;
    L6:
        r1 = 0.0f;
    L9:
        e = move-exception;
        BdpManager.getInst().getService(BdpLogService.class).e("bdp_BdpLocation", e.getMessage());
        goto L11
    }

    @Override // android.location.Location
    public String toString() {
        return "TMALocation{mStatusCode=" + this.mStatusCode + ", mRawImplStatusCode=" + this.mRawImplStatusCode + ", name='" + this.name + "', address='" + this.address + "', country='" + this.country + "', countryCode='" + this.countryCode + "', province='" + this.province + "', provinceCode='" + this.provinceCode + "', city='" + this.city + "', cityCode='" + this.cityCode + "', district='" + this.district + "', districtCode='" + this.districtCode + "', mLocType=" + this.mLocType + '}';
    }

    public Object clone() {
        return (BdpLocation) super.clone();
    L4:
        return null;
    }

    public float getHorizontalAccuracy() {
        return getAccuracy();
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getDistrictCode() {
        return this.districtCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public int getLocType() {
        return this.mLocType;
    }

    public String getName() {
        return this.name;
    }

    public String getProvince() {
        return this.province;
    }

    public String getProvinceCode() {
        return this.provinceCode;
    }

    public int getRawImplStatusCode() {
        return this.mRawImplStatusCode;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public BdpLocation(BdpLocation r10) {
        super(r10);
        this.TAG = "bdp_BdpLocation";
        this.mStatusCode = 0;
        this.mRawImplStatusCode = 0;
        setStatusCode(r10.getStatusCode());
        setName(r10.getName());
        setAddress(r10.getAddress());
        setCountry(r10.getCountry());
        setProvider(r10.getProvince());
        setCity(r10.getCity());
        setDistrict(r10.getDistrict());
        setLocType(r10.getLocType());
        setCityCode(r10.getCountryCode());
        setProvinceCode(r10.getProvinceCode());
        setCityCode(r10.getCityCode());
        setDistrictCode(r10.getDistrictCode());
        setErrorMsg(r10.getErrorMsg());
    }

    public static BdpLocation fromJson(JSONObject r10) throws JSONException {
        if (r10 != null) goto L5;
        return null;
    L5:
        BdpLocation r0 = new BdpLocation(r10.optString("provider"));
        r0.setLatitude(r10.optDouble("latitude"));
        r0.setLongitude(r10.optDouble("longitude"));
        r0.setTime(r10.optLong("loc_time"));
        r0.setSpeed((float) r10.optDouble("speed", 0.0d));
        r0.setAccuracy((float) r10.optDouble("accuracy"));
        r0.setAltitude(r10.optDouble("altitude"));
        r0.setStatusCode(r10.optInt(a.KEY_STATUS_CODE));
        r0.setRawImplStatusCode(r10.optInt("rawImplStatusCode"));
        r0.setName(r10.optString(a.KEY_SHOPPING_GUIDE_NAME));
        r0.setAddress(r10.optString("address"));
        r0.setCountry(r10.optString("country"));
        r0.setProvince(r10.optString("province"));
        r0.setCity(r10.optString("city"));
        r0.setDistrict(r10.optString("district"));
        r0.setLocType(r10.optInt("loctype"));
        r0.setCityCode(r10.optString("countryCode"));
        r0.setProvinceCode(r10.optString("provinceCode"));
        r0.setCityCode(r10.optString("cityCode"));
        r0.setDistrictCode(r10.optString("districtCode"));
        r0.setErrorMsg(r10.optString("errorMsg"));
        if (Build.VERSION.SDK_INT < 26) goto L8;
        r0.setVerticalAccuracyMeters(0.0f);
    L8:
        return r0;
    }

    public static boolean isSuccess(BdpLocation r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.getStatusCode() != 0) goto L6;
        return true;
    }

    public void setAddress(String r1) {
        this.address = r1;
    }

    public void setCity(String r1) {
        this.city = r1;
    }

    public void setCityCode(String r1) {
        this.cityCode = r1;
    }

    public void setCountry(String r1) {
        this.country = r1;
    }

    public void setCountryCode(String r1) {
        this.countryCode = r1;
    }

    public void setDistrict(String r1) {
        this.district = r1;
    }

    public void setDistrictCode(String r1) {
        this.districtCode = r1;
    }

    public void setErrorMsg(String r1) {
        this.errorMsg = r1;
    }

    public void setLocType(int r1) {
        this.mLocType = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setProvince(String r1) {
        this.province = r1;
    }

    public void setProvinceCode(String r1) {
        this.provinceCode = r1;
    }

    public void setRawImplStatusCode(int r1) {
        this.mRawImplStatusCode = r1;
    }

    public void setStatusCode(int r1) {
        this.mStatusCode = r1;
    }

    public BdpLocation(int r10) {
        super("");
        this.TAG = "bdp_BdpLocation";
        this.mRawImplStatusCode = 0;
        this.mStatusCode = r10;
    }

    public BdpLocation(Location r1) {
        super(r1);
        this.TAG = "bdp_BdpLocation";
        this.mStatusCode = 0;
        this.mRawImplStatusCode = 0;
    }

    public BdpLocation(String r1) {
        super(r1);
        this.TAG = "bdp_BdpLocation";
        this.mStatusCode = 0;
        this.mRawImplStatusCode = 0;
    }
}
