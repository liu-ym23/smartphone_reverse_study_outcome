package com.bytedance.bdlocation;

import android.location.Location;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.entity.GeoPoiEntity;
import com.bytedance.bdlocation.entity.PoiInfoEntity;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.BdLBSResult;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.obric.cae.cloud.CloudServiceConstants;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BDLocation extends Location {
    private BDLocationException exception;
    private transient boolean isCache;
    transient double latitudeWgs84;
    transient double longitudeWgs84;
    private int mAccuracyLevel;
    private String mAdCode;
    private String mAddress;
    private String mAdministrativeArea;
    private String mAoi;
    private List<PoiInfoEntity> mAoiEntities;
    private BdLBSResult mBdLBSResult;
    private float mBearing;
    private String mBuildingId;
    private String mCity;
    private String mCityAsciName;

    @Deprecated
    private String mCityCode;
    private long mCityId;
    private WifiInfo mConnectedWifiInfo;
    private String mCoordinateSystem;
    private String mCountry;
    private String mCountryAsciName;
    private String mCountryCode;
    private long mCountryId;
    private String mCountryLocalID;
    private String mDistrict;
    private String mDistrictAsciName;
    private long mDistrictId;
    private String mDistrictLocalID;
    private String mExtra;
    private String mFloor;
    private BDPoint mGCJ02;
    private List<GeoPoiEntity> mGeoAoiList;
    private String mGeoFormattedAddress;
    private String mGeoNameID;
    private List<GeoPoiEntity> mGeoPoiList;
    private String mGeocodeSDKName;
    private boolean mHasServerLatLng;
    private float mInOutDoorConfidence;
    private int mInOutDoorStatus;
    private boolean mIsCompliance;
    private boolean mIsDisputed;
    private boolean mIsMock;
    private boolean mIsRecommendWifiResults;
    private boolean mIsServerLocateSuccess;
    private double mLatitude;
    private LocInfoRspData mLocInfoRsp;
    private String mLocalID;
    private String mLocationDetail;
    private BDLocationException mLocationException;
    private long mLocationMs;
    private LocationResult mLocationResult;
    private String mLocationSDKName;
    private int mLocationType;
    private double mLongitude;
    private long mMockDuration;
    private String mPoi;
    private List<PoiInfoEntity> mPoiEntities;
    private int mSatellites;
    private String mServerLocateMethod;
    private float mSpeed;
    private String mStreet;
    private String mStreetNum;
    private String mSubAdministrativeArea;
    private String mSubdivisionAsciName;
    private long mSubdivisionId;
    private String mSubmitLogId;
    private transient Location mThirdPartLocation;
    private String mTown;
    private String mTownAsciName;
    private long mTownId;
    private int mTrustedLevel;
    private String mVillage;
    private String mVillageAsciName;
    private long mVillageId;

    public BDLocation(Location r8, String r10) {
        if (r8 != null) goto L5;
        String r11 = "";
    L6:
        super(r11);
        this.exception = null;
        this.mCoordinateSystem = LocationInfoConst.WGS_84;
        this.mAccuracyLevel = 4;
        this.mExtra = "";
        this.mServerLocateMethod = "unknown";
        this.mIsRecommendWifiResults = true;
        this.mInOutDoorStatus = 0;
        this.mInOutDoorConfidence = -1.0f;
        if (r8 != null) goto L9;
        return;
    L9:
        superLocation(r8);
        this.mLatitude = r8.getLatitude();
        this.mLongitude = r8.getLongitude();
        this.mLocationMs = System.currentTimeMillis();
        this.mThirdPartLocation = r8;
        this.mLocationSDKName = r10;
        this.mLocationType = transProvider(r8.getProvider());
        this.mBearing = r8.getBearing();
        this.mSpeed = r8.getSpeed();
        return;
    L5:
        r11 = r8.getProvider();
        goto L6
    }

    private void superLocation(Location r8) {
        setProvider(r8.getProvider());     // Catch: Exception -> L4
        setTime(r8.getTime());     // Catch: Exception -> L4
        setElapsedRealtimeNanos(r8.getElapsedRealtimeNanos());     // Catch: Exception -> L4
        setLatitude(r8.getLatitude());     // Catch: Exception -> L4
        setLongitude(r8.getLongitude());     // Catch: Exception -> L4
        setAltitude(r8.getAltitude());     // Catch: Exception -> L4
        setSpeed(r8.getSpeed());     // Catch: Exception -> L4
        setBearing(r8.getBearing());     // Catch: Exception -> L4
        setAccuracy(r8.getAccuracy());     // Catch: Exception -> L4
        setVerticalAccuracyMeters(r8.getVerticalAccuracyMeters());     // Catch: Exception -> L4
        setSpeedAccuracyMetersPerSecond(r8.getSpeedAccuracyMetersPerSecond());     // Catch: Exception -> L4
        setBearingAccuracyDegrees(r8.getBearingAccuracyDegrees());     // Catch: Exception -> L4
        setElapsedRealtimeUncertaintyNanos(r8.getElapsedRealtimeUncertaintyNanos());     // Catch: Exception -> L4
        setExtras(r8.getExtras());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Logger.i(e.getMessage());
    }

    private int transProvider(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return 0;
    L6:
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equalsIgnoreCase(r8) == false) goto L10;
        return 1;
    L10:
        if ("network".equalsIgnoreCase(r8) == false) goto L13;
        return 4;
    L13:
        if ("bd_lbs".equalsIgnoreCase(r8) == false) goto L16;
        return 4;
    L16:
        if ("lbs".equalsIgnoreCase(r8) == false) goto L18;
        return 4;
    L18:
        return 0;
    }

    public int getAccuracyLevel() {
        return this.mAccuracyLevel;
    }

    public String getAdCode() {
        return this.mAdCode;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public String getAdministrativeArea() {
        return this.mAdministrativeArea;
    }

    public String getAoi() {
        return this.mAoi;
    }

    public List<PoiInfoEntity> getAoiEntities() {
        return this.mAoiEntities;
    }

    public BdLBSResult getBdLBSResult() {
        return this.mBdLBSResult;
    }

    @Override // android.location.Location
    public float getBearing() {
        return this.mBearing;
    }

    public String getBuildingId() {
        return this.mBuildingId;
    }

    public String getCity() {
        return this.mCity;
    }

    public String getCityAsciName() {
        return this.mCityAsciName;
    }

    @Deprecated
    public String getCityCode() {
        return this.mCityCode;
    }

    public long getCityId() {
        return this.mCityId;
    }

    public WifiInfo getConnectedWifiInfo() {
        return this.mConnectedWifiInfo;
    }

    public String getCoordinateSystem() {
        return this.mCoordinateSystem;
    }

    public String getCountry() {
        return this.mCountry;
    }

    public String getCountryAsciName() {
        return this.mCountryAsciName;
    }

    public String getCountryCode() {
        return this.mCountryCode;
    }

    public long getCountryId() {
        return this.mCountryId;
    }

    public String getCountryLocalID() {
        return this.mCountryLocalID;
    }

    public String getDistrict() {
        return this.mDistrict;
    }

    public String getDistrictAsciName() {
        return this.mDistrictAsciName;
    }

    public long getDistrictId() {
        return this.mDistrictId;
    }

    public String getDistrictLocalID() {
        return this.mDistrictLocalID;
    }

    public BDLocationException getException() {
        return this.exception;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public String getFloor() {
        return this.mFloor;
    }

    public BDPoint getGCJ02() {
        return this.mGCJ02;
    }

    public List<GeoPoiEntity> getGeoAoiList() {
        return this.mGeoAoiList;
    }

    public String getGeoFormattedAddress() {
        return this.mGeoFormattedAddress;
    }

    public String getGeoNameID() {
        return this.mGeoNameID;
    }

    public List<GeoPoiEntity> getGeoPoiList() {
        return this.mGeoPoiList;
    }

    public String getGeocodeSDKName() {
        return this.mGeocodeSDKName;
    }

    public float getInOutDoorConfidence() {
        return this.mInOutDoorConfidence;
    }

    public int getInOutDoorStatus() {
        return this.mInOutDoorStatus;
    }

    public boolean getIsCompliance() {
        return this.mIsCompliance;
    }

    public boolean getIsDisputed() {
        return this.mIsDisputed;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.mLatitude;
    }

    public LocInfoRspData getLocInfoRsp() {
        return this.mLocInfoRsp;
    }

    public String getLocalID() {
        return this.mLocalID;
    }

    public String getLocationDetail() {
        return this.mLocationDetail;
    }

    public BDLocationException getLocationException() {
        return this.mLocationException;
    }

    public long getLocationMs() {
        return this.mLocationMs;
    }

    public LocationResult getLocationResult() {
        return this.mLocationResult;
    }

    public String getLocationSDKName() {
        return this.mLocationSDKName;
    }

    public int getLocationType() {
        return this.mLocationType;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.mLongitude;
    }

    public long getMockDuration() {
        return this.mMockDuration;
    }

    public String getPoi() {
        return this.mPoi;
    }

    public List<PoiInfoEntity> getPoiEntities() {
        return this.mPoiEntities;
    }

    public int getSatellites() {
        return this.mSatellites;
    }

    public String getServerLocateMethod() {
        return this.mServerLocateMethod;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return this.mSpeed;
    }

    public String getStreet() {
        return this.mStreet;
    }

    public String getStreetNum() {
        return this.mStreetNum;
    }

    public String getSubAdministrativeArea() {
        return this.mSubAdministrativeArea;
    }

    public String getSubdivisionAsciName() {
        return this.mSubdivisionAsciName;
    }

    public long getSubdivisionId() {
        return this.mSubdivisionId;
    }

    public String getSubmitLogId() {
        return this.mSubmitLogId;
    }

    public Location getThirdPartLocation() {
        return this.mThirdPartLocation;
    }

    public String getTown() {
        return this.mTown;
    }

    public String getTownAsciName() {
        return this.mTownAsciName;
    }

    public long getTownId() {
        return this.mTownId;
    }

    public int getTrustedLevel() {
        return this.mTrustedLevel;
    }

    public String getVillage() {
        return this.mVillage;
    }

    public String getVillageAsciName() {
        return this.mVillageAsciName;
    }

    public long getVillageId() {
        return this.mVillageId;
    }

    public boolean hasAddress() {
        if (TextUtils.isEmpty(this.mAddress) == true) goto L5;
    L16:
        return true;
    L5:
        if (TextUtils.isEmpty(this.mCountry) == false) goto L16;
        if (TextUtils.isEmpty(this.mAdministrativeArea) == false) goto L16;
        if (TextUtils.isEmpty(this.mSubAdministrativeArea) == false) goto L16;
        if (TextUtils.isEmpty(this.mCity) == false) goto L16;
        if (TextUtils.isEmpty(this.mDistrict) == false) goto L16;
        return false;
    }

    public boolean hasLBSResult() {
        if (this.mBdLBSResult == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasServerLatLng() {
        return this.mHasServerLatLng;
    }

    public boolean isCache() {
        return this.isCache;
    }

    public boolean isEmpty() {
        if (Double.compare(this.mLatitude, 0.0d) == 0) goto L5;
    L19:
        return false;
    L5:
        if (Double.compare(this.mLongitude, 0.0d) != 0) goto L19;
        if (TextUtils.isEmpty(this.mAddress) == false) goto L19;
        if (TextUtils.isEmpty(this.mCountry) == false) goto L19;
        if (TextUtils.isEmpty(this.mAdministrativeArea) == false) goto L19;
        if (TextUtils.isEmpty(this.mSubAdministrativeArea) == false) goto L19;
        if (TextUtils.isEmpty(this.mCity) == false) goto L19;
        if (TextUtils.isEmpty(this.mDistrict) == false) goto L19;
        return true;
    }

    @Override // android.location.Location
    public boolean isMock() {
        return this.mIsMock;
    }

    public boolean isRecommendWifiResults() {
        return this.mIsRecommendWifiResults;
    }

    public boolean isServerLocateSuccess() {
        return this.mIsServerLocateSuccess;
    }

    public void setAccuracyLevel(int r8) {
        this.mAccuracyLevel = r8;
        transformLocationForLevel(r8);
    }

    public void setAdCode(String r8) {
        this.mAdCode = r8;
    }

    public void setAddress(String r8) {
        this.mAddress = r8;
    }

    public void setAdministrativeArea(String r8) {
        this.mAdministrativeArea = r8;
    }

    public void setAoi(String r8) {
        this.mAoi = r8;
    }

    public void setAoiEntities(List<PoiInfoEntity> r8) {
        this.mAoiEntities = r8;
    }

    public void setBdLBSResult(BdLBSResult r8) {
        this.mBdLBSResult = r8;
    }

    @Override // android.location.Location
    public void setBearing(float r8) {
        this.mBearing = r8;
    }

    public void setBuildingId(String r8) {
        this.mBuildingId = r8;
    }

    public void setCache(boolean r8) {
        this.isCache = r8;
    }

    public void setCity(String r8) {
        this.mCity = r8;
    }

    public void setCityAsciName(String r8) {
        this.mCityAsciName = r8;
    }

    public void setCityCode(String r8) {
        this.mCityCode = r8;
    }

    public void setCityId(long r8) {
        this.mCityId = r8;
    }

    public void setConnectedWifiInfo(WifiInfo r8) {
        this.mConnectedWifiInfo = r8;
    }

    public void setCoordinateSystem(String r8) {
        this.mCoordinateSystem = r8;
    }

    public void setCountry(String r8) {
        this.mCountry = r8;
    }

    public void setCountryAsciName(String r8) {
        this.mCountryAsciName = r8;
    }

    public void setCountryCode(String r8) {
        this.mCountryCode = r8;
    }

    public void setCountryId(long r8) {
        this.mCountryId = r8;
    }

    public void setCountryLocalID(String r8) {
        this.mCountryLocalID = r8;
    }

    public void setDistrict(String r8) {
        this.mDistrict = r8;
    }

    public void setDistrictAsciName(String r8) {
        this.mDistrictAsciName = r8;
    }

    public void setDistrictId(long r8) {
        this.mDistrictId = r8;
    }

    public void setDistrictLocalID(String r8) {
        this.mDistrictLocalID = r8;
    }

    public void setException(BDLocationException r8) {
        this.exception = r8;
    }

    public void setExtra(String r8) {
        this.mExtra = r8;
    }

    public void setFloor(String r8) {
        this.mFloor = r8;
    }

    public void setGCJ02(BDPoint r8) {
        this.mGCJ02 = r8;
    }

    public void setGeoAoiList(List<GeoPoiEntity> r8) {
        this.mGeoAoiList = r8;
    }

    public void setGeoFormattedAddress(String r8) {
        this.mGeoFormattedAddress = r8;
    }

    public void setGeoNameID(String r8) {
        this.mGeoNameID = r8;
    }

    public void setGeoPoiList(List<GeoPoiEntity> r8) {
        this.mGeoPoiList = r8;
    }

    public void setGeocodeSDKName(String r8) {
        this.mGeocodeSDKName = r8;
    }

    public void setHasServerLatLng(boolean r8) {
        this.mHasServerLatLng = r8;
    }

    public void setInOutDoorConfidence(float r8) {
        this.mInOutDoorConfidence = r8;
    }

    public void setInOutDoorStatus(int r8) {
        this.mInOutDoorStatus = r8;
    }

    public void setIsCompliance(boolean r8) {
        this.mIsCompliance = r8;
    }

    public void setIsDisputed(boolean r8) {
        this.mIsDisputed = r8;
    }

    @Override // android.location.Location
    public void setLatitude(double r8) {
        super.setLatitude(r8);
        this.mLatitude = r8;
    }

    public void setLocInfoRsp(LocInfoRspData r8) {
        this.mLocInfoRsp = r8;
    }

    public void setLocalID(String r8) {
        this.mLocalID = r8;
    }

    public void setLocationDetail(String r8) {
        this.mLocationDetail = r8;
    }

    public void setLocationException(BDLocationException r8) {
        this.mLocationException = r8;
    }

    public void setLocationMs(long r8) {
        this.mLocationMs = r8;
    }

    public void setLocationResult(LocationResult r8) {
        this.mLocationResult = r8;
    }

    public void setLocationSDKName(String r8) {
        this.mLocationSDKName = r8;
    }

    public void setLocationType(int r8) {
        this.mLocationType = r8;
    }

    @Override // android.location.Location
    public void setLongitude(double r8) {
        super.setLongitude(r8);
        this.mLongitude = r8;
    }

    @Override // android.location.Location
    public void setMock(boolean r8) {
        this.mIsMock = r8;
    }

    public void setMockDuration(long r8) {
        this.mMockDuration = r8;
    }

    public void setPoi(String r8) {
        this.mPoi = r8;
    }

    public void setPoiEntities(List<PoiInfoEntity> r8) {
        this.mPoiEntities = r8;
    }

    public void setRecommendWifiResults(boolean r8) {
        this.mIsRecommendWifiResults = r8;
    }

    public void setSatellites(int r8) {
        this.mSatellites = r8;
    }

    public void setServerLocateMethod(String r8) {
        this.mServerLocateMethod = r8;
    }

    public void setServerLocateSuccess(boolean r8) {
        this.mIsServerLocateSuccess = r8;
    }

    @Override // android.location.Location
    public void setSpeed(float r8) {
        this.mSpeed = r8;
    }

    public void setStreet(String r8) {
        this.mStreet = r8;
    }

    public void setStreetNum(String r8) {
        this.mStreetNum = r8;
    }

    public void setSubAdministrativeArea(String r8) {
        this.mSubAdministrativeArea = r8;
    }

    public void setSubdivisionAsciName(String r8) {
        this.mSubdivisionAsciName = r8;
    }

    public void setSubdivisionId(long r8) {
        this.mSubdivisionId = r8;
    }

    public void setSubmitLogId(String r8) {
        this.mSubmitLogId = r8;
    }

    public void setThirdPartLocation(Location r8) {
        this.mThirdPartLocation = r8;
    }

    public void setTown(String r8) {
        this.mTown = r8;
    }

    public void setTownAsciName(String r8) {
        this.mTownAsciName = r8;
    }

    public void setTownId(long r8) {
        this.mTownId = r8;
    }

    public void setTrustedLevel(int r8) {
        this.mTrustedLevel = r8;
    }

    public void setVillage(String r8) {
        this.mVillage = r8;
    }

    public void setVillageAsciName(String r8) {
        this.mVillageAsciName = r8;
    }

    public void setVillageId(long r8) {
        this.mVillageId = r8;
    }

    @Override // android.location.Location
    public String toString() {
        String r8 = this.mThirdPartLocation.toString();     // Catch: Exception -> L4
    L6:
        return "BDLocation{mAddress='" + this.mAddress + "', mCountry='" + this.mCountry + "', mAdministrativeArea='" + this.mAdministrativeArea + "', mSubAdministrativeArea='" + this.mSubAdministrativeArea + "', mCity='" + this.mCity + "', mDistrict='" + this.mDistrict + "', mTown='" + this.mTown + "', mVillage='" + this.mVillage + "', mCityCode='" + this.mCityCode + "', mAdCode='" + this.mAdCode + "', mLatitude=" + this.mLatitude + ", mLongitude=" + this.mLongitude + ", mAccuracy=" + getAccuracy() + ", mStreet='" + this.mStreet + "', mStreetNum='" + this.mStreetNum + "', mFloor='" + this.mFloor + "', mLocationMs=" + this.mLocationMs + ", mElapsedRealtimeNanos=" + getElapsedRealtimeNanos() + ", mThirdPartLocation=" + r8 + ", mLocationSDKName='" + this.mLocationSDKName + "', mPoi='" + this.mPoi + "', mGCJ02=" + this.mGCJ02 + ", mLocationType=" + this.mLocationType + ", isCache=" + this.isCache + ", mCountryCode=" + this.mCountryCode + ", mCountryLocalID='" + this.mCountryLocalID + "', mLocalID='" + this.mLocalID + "', mDistrictLocalID='" + this.mDistrictLocalID + "', mGeoNameID='" + this.mGeoNameID + "', mSubdivisionId='" + this.mSubdivisionId + "', mBdLBSResult=" + this.mBdLBSResult + ", mLocationResult=" + this.mLocationResult + ", mGeocodeSDKName='" + this.mGeocodeSDKName + "', mAoi='" + this.mAoi + "', mIsDisputed='" + this.mIsDisputed + "', mIsCompliance='" + this.mIsCompliance + "', mCoordinateSystem='" + this.mCoordinateSystem + "', mBearing='" + this.mBearing + "', mSpeed='" + this.mSpeed + "', mTrustedLevel='" + this.mTrustedLevel + "', mLocationDetail='" + this.mLocationDetail + "', mSatellites='" + this.mSatellites + "', mPoiEntities='" + this.mPoiEntities + "', mAoiEntities='" + this.mAoiEntities + "', mBuildingId='" + this.mBuildingId + "', mInOutDoorStatus='" + this.mInOutDoorStatus + "', mInOutDoorConfidence='" + this.mInOutDoorConfidence + "'}";
    L4:
        r8 = "error toString()";
        goto L6
    }

    public void transformLocationForLevel(int r8) {
        if (r8 != 4) goto L5;
        return;
    L5:
        setLatitude(0.0d);
        setLongitude(0.0d);
        setTown("");
        setTownId(0);
        setTownAsciName("");
        setAddress("");
        if (r8 != 0) goto L11;
        setAdministrativeArea("");
        setSubdivisionId(0);
        setSubdivisionAsciName("");
    L8:
        setCity("");
        setCityId(0);
        setCityAsciName("");
        setCityCode("");
    L9:
        setDistrict("");
        setDistrictId(0);
        setDistrictLocalID("");
        setDistrictAsciName("");
        return;
    L11:
        if (r8 == 1) goto L8;
        if (r8 == 2) goto L9;
    }

    public BDLocation(BDLocation r8) {
        if (r8 != null) goto L5;
        String r10 = "";
    L6:
        super(r10);
        this.exception = null;
        this.mCoordinateSystem = LocationInfoConst.WGS_84;
        this.mAccuracyLevel = 4;
        this.mExtra = "";
        this.mServerLocateMethod = "unknown";
        this.mIsRecommendWifiResults = true;
        this.mInOutDoorStatus = 0;
        this.mInOutDoorConfidence = -1.0f;
        if (r8 != null) goto L9;
        return;
    L9:
        superLocation(r8);
        this.mThirdPartLocation = r8.mThirdPartLocation;
        this.mAddress = r8.mAddress;
        this.mCountry = r8.mCountry;
        this.mCountryId = r8.mCountryId;
        this.mAdministrativeArea = r8.mAdministrativeArea;
        this.mSubdivisionId = r8.mSubdivisionId;
        this.mSubAdministrativeArea = r8.mSubAdministrativeArea;
        this.mCity = r8.mCity;
        this.mCityId = r8.mCityId;
        this.mDistrict = r8.mDistrict;
        this.mDistrictId = r8.mDistrictId;
        this.mTown = r8.mTown;
        this.mTownId = r8.mTownId;
        this.mVillage = r8.mVillage;
        this.mVillageId = r8.mVillageId;
        this.mCountryAsciName = r8.mCountryAsciName;
        this.mSubdivisionAsciName = r8.mSubdivisionAsciName;
        this.mCityAsciName = r8.mCityAsciName;
        this.mDistrictAsciName = r8.mDistrictAsciName;
        this.mTownAsciName = r8.mTownAsciName;
        this.mVillageAsciName = r8.mVillageAsciName;
        this.mCityCode = r8.mCityCode;
        this.mAdCode = r8.mAdCode;
        setLatitude(r8.getLatitude());
        setLongitude(r8.getLongitude());
        this.mLocationMs = r8.mLocationMs;
        this.mStreet = r8.mStreet;
        this.mStreetNum = r8.mStreetNum;
        this.mFloor = r8.mFloor;
        this.mLocationSDKName = r8.mLocationSDKName;
        this.mGCJ02 = r8.mGCJ02;
        this.mPoi = r8.mPoi;
        this.mLocationType = r8.mLocationType;
        this.isCache = r8.isCache;
        this.mCountryCode = r8.mCountryCode;
        this.mCountryLocalID = r8.mCountryLocalID;
        this.mLocalID = r8.mLocalID;
        this.mDistrictLocalID = r8.mDistrictLocalID;
        this.mGeoNameID = r8.mGeoNameID;
        this.mBdLBSResult = r8.mBdLBSResult;
        this.mLocationResult = r8.mLocationResult;
        this.mGeocodeSDKName = r8.mGeocodeSDKName;
        this.mAoi = r8.mAoi;
        this.mIsDisputed = r8.mIsDisputed;
        this.mIsCompliance = r8.mIsCompliance;
        this.mCoordinateSystem = r8.mCoordinateSystem;
        this.mLocationException = r8.mLocationException;
        this.mPoiEntities = r8.mPoiEntities;
        this.mAoiEntities = r8.mAoiEntities;
        this.mBearing = r8.mBearing;
        this.mSpeed = r8.mSpeed;
        this.mTrustedLevel = r8.mTrustedLevel;
        this.mLocationDetail = r8.mLocationDetail;
        this.mSatellites = r8.mSatellites;
        this.mBuildingId = r8.mBuildingId;
        this.mMockDuration = r8.mMockDuration;
        this.mSubmitLogId = r8.mSubmitLogId;
        this.mExtra = r8.mExtra;
        this.mIsMock = r8.mIsMock;
        this.mServerLocateMethod = r8.mServerLocateMethod;
        this.mHasServerLatLng = r8.mHasServerLatLng;
        this.mIsServerLocateSuccess = r8.mIsServerLocateSuccess;
        this.mIsRecommendWifiResults = r8.mIsRecommendWifiResults;
        this.mGeoAoiList = r8.mGeoAoiList;
        this.mGeoPoiList = r8.mGeoPoiList;
        this.mGeoFormattedAddress = r8.mGeoFormattedAddress;
        this.mInOutDoorStatus = r8.mInOutDoorStatus;
        this.mInOutDoorConfidence = r8.mInOutDoorConfidence;
        this.mConnectedWifiInfo = r8.mConnectedWifiInfo;
        return;
    L5:
        r10 = r8.getProvider();
        goto L6
    }

    public BDLocation(String r8, String r10) {
        super(r8);
        this.exception = null;
        this.mCoordinateSystem = LocationInfoConst.WGS_84;
        this.mAccuracyLevel = 4;
        this.mExtra = "";
        this.mServerLocateMethod = "unknown";
        this.mIsRecommendWifiResults = true;
        this.mInOutDoorStatus = 0;
        this.mInOutDoorConfidence = -1.0f;
        this.mLocationSDKName = r10;
        this.mLocationType = transProvider(r8);
    }
}
