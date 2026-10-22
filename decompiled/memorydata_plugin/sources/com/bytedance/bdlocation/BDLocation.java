package com.bytedance.bdlocation;

import android.location.Location;
import android.os.Build;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public BDLocation(Location r3, String r4) {
        if (r3 != null) goto L5;
        String r1 = "";
    L6:
        super(r1);
        this.exception = null;
        this.mCoordinateSystem = LocationInfoConst.WGS_84;
        this.mAccuracyLevel = 4;
        this.mExtra = "";
        this.mServerLocateMethod = "unknown";
        this.mIsRecommendWifiResults = true;
        this.mInOutDoorStatus = 0;
        this.mInOutDoorConfidence = -1.0f;
        if (r3 != null) goto L9;
        return;
    L9:
        superLocation(r3);
        this.mLatitude = r3.getLatitude();
        this.mLongitude = r3.getLongitude();
        this.mLocationMs = System.currentTimeMillis();
        this.mThirdPartLocation = r3;
        this.mLocationSDKName = r4;
        this.mLocationType = transProvider(r3.getProvider());
        this.mBearing = r3.getBearing();
        this.mSpeed = r3.getSpeed();
        return;
    L5:
        r1 = r3.getProvider();
        goto L6
    }

    public BDLocation(BDLocation r3) {
        if (r3 != null) goto L5;
        String r1 = "";
    L6:
        super(r1);
        this.exception = null;
        this.mCoordinateSystem = LocationInfoConst.WGS_84;
        this.mAccuracyLevel = 4;
        this.mExtra = "";
        this.mServerLocateMethod = "unknown";
        this.mIsRecommendWifiResults = true;
        this.mInOutDoorStatus = 0;
        this.mInOutDoorConfidence = -1.0f;
        if (r3 != null) goto L9;
        return;
    L9:
        superLocation(r3);
        this.mThirdPartLocation = r3.mThirdPartLocation;
        this.mAddress = r3.mAddress;
        this.mCountry = r3.mCountry;
        this.mCountryId = r3.mCountryId;
        this.mAdministrativeArea = r3.mAdministrativeArea;
        this.mSubdivisionId = r3.mSubdivisionId;
        this.mSubAdministrativeArea = r3.mSubAdministrativeArea;
        this.mCity = r3.mCity;
        this.mCityId = r3.mCityId;
        this.mDistrict = r3.mDistrict;
        this.mDistrictId = r3.mDistrictId;
        this.mTown = r3.mTown;
        this.mTownId = r3.mTownId;
        this.mVillage = r3.mVillage;
        this.mVillageId = r3.mVillageId;
        this.mCountryAsciName = r3.mCountryAsciName;
        this.mSubdivisionAsciName = r3.mSubdivisionAsciName;
        this.mCityAsciName = r3.mCityAsciName;
        this.mDistrictAsciName = r3.mDistrictAsciName;
        this.mTownAsciName = r3.mTownAsciName;
        this.mVillageAsciName = r3.mVillageAsciName;
        this.mCityCode = r3.mCityCode;
        this.mAdCode = r3.mAdCode;
        setLatitude(r3.getLatitude());
        setLongitude(r3.getLongitude());
        this.mLocationMs = r3.mLocationMs;
        this.mStreet = r3.mStreet;
        this.mStreetNum = r3.mStreetNum;
        this.mFloor = r3.mFloor;
        this.mLocationSDKName = r3.mLocationSDKName;
        this.mGCJ02 = r3.mGCJ02;
        this.mPoi = r3.mPoi;
        this.mLocationType = r3.mLocationType;
        this.isCache = r3.isCache;
        this.mCountryCode = r3.mCountryCode;
        this.mCountryLocalID = r3.mCountryLocalID;
        this.mLocalID = r3.mLocalID;
        this.mDistrictLocalID = r3.mDistrictLocalID;
        this.mGeoNameID = r3.mGeoNameID;
        this.mBdLBSResult = r3.mBdLBSResult;
        this.mLocationResult = r3.mLocationResult;
        this.mGeocodeSDKName = r3.mGeocodeSDKName;
        this.mAoi = r3.mAoi;
        this.mIsDisputed = r3.mIsDisputed;
        this.mIsCompliance = r3.mIsCompliance;
        this.mCoordinateSystem = r3.mCoordinateSystem;
        this.mLocationException = r3.mLocationException;
        this.mPoiEntities = r3.mPoiEntities;
        this.mAoiEntities = r3.mAoiEntities;
        this.mBearing = r3.mBearing;
        this.mSpeed = r3.mSpeed;
        this.mTrustedLevel = r3.mTrustedLevel;
        this.mLocationDetail = r3.mLocationDetail;
        this.mSatellites = r3.mSatellites;
        this.mBuildingId = r3.mBuildingId;
        this.mMockDuration = r3.mMockDuration;
        this.mSubmitLogId = r3.mSubmitLogId;
        this.mExtra = r3.mExtra;
        this.mIsMock = r3.mIsMock;
        this.mServerLocateMethod = r3.mServerLocateMethod;
        this.mHasServerLatLng = r3.mHasServerLatLng;
        this.mIsServerLocateSuccess = r3.mIsServerLocateSuccess;
        this.mIsRecommendWifiResults = r3.mIsRecommendWifiResults;
        this.mGeoAoiList = r3.mGeoAoiList;
        this.mGeoPoiList = r3.mGeoPoiList;
        this.mGeoFormattedAddress = r3.mGeoFormattedAddress;
        this.mInOutDoorStatus = r3.mInOutDoorStatus;
        this.mInOutDoorConfidence = r3.mInOutDoorConfidence;
        this.mConnectedWifiInfo = r3.mConnectedWifiInfo;
        return;
    L5:
        r1 = r3.getProvider();
        goto L6
    }

    public BDLocation(String r2, String r3) {
        super(r2);
        this.exception = null;
        this.mCoordinateSystem = LocationInfoConst.WGS_84;
        this.mAccuracyLevel = 4;
        this.mExtra = "";
        this.mServerLocateMethod = "unknown";
        this.mIsRecommendWifiResults = true;
        this.mInOutDoorStatus = 0;
        this.mInOutDoorConfidence = -1.0f;
        this.mLocationSDKName = r3;
        this.mLocationType = transProvider(r2);
    }

    private void superLocation(Location r3) {
        setProvider(r3.getProvider());     // Catch: Exception -> L19
        setTime(r3.getTime());     // Catch: Exception -> L19
        if (Build.VERSION.SDK_INT < 17) goto L5;
        setElapsedRealtimeNanos(r3.getElapsedRealtimeNanos());     // Catch: Exception -> L19
    L5:
        setLatitude(r3.getLatitude());     // Catch: Exception -> L19
        setLongitude(r3.getLongitude());     // Catch: Exception -> L19
        setAltitude(r3.getAltitude());     // Catch: Exception -> L19
        setSpeed(r3.getSpeed());     // Catch: Exception -> L19
        setBearing(r3.getBearing());     // Catch: Exception -> L19
        setAccuracy(r3.getAccuracy());     // Catch: Exception -> L19
        if (Build.VERSION.SDK_INT < 26) goto L9;
        setVerticalAccuracyMeters(r3.getVerticalAccuracyMeters());     // Catch: Exception -> L19
    L9:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        setSpeedAccuracyMetersPerSecond(r3.getSpeedAccuracyMetersPerSecond());     // Catch: Exception -> L19
    L12:
        if (Build.VERSION.SDK_INT < 26) goto L15;
        setBearingAccuracyDegrees(r3.getBearingAccuracyDegrees());     // Catch: Exception -> L19
    L15:
        if (Build.VERSION.SDK_INT < 29) goto L17;
        setElapsedRealtimeUncertaintyNanos(r3.getElapsedRealtimeUncertaintyNanos());     // Catch: Exception -> L19
    L17:
        setExtras(r3.getExtras());     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        Logger.i(e.getMessage());
    }

    private int transProvider(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return 0;
    L6:
        if ("gps".equalsIgnoreCase(r3) == false) goto L10;
        return 1;
    L10:
        if ("network".equalsIgnoreCase(r3) == false) goto L13;
        return 4;
    L13:
        if ("bd_lbs".equalsIgnoreCase(r3) == false) goto L16;
        return 4;
    L16:
        if ("lbs".equalsIgnoreCase(r3) == false) goto L18;
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

    public void setAccuracyLevel(int r1) {
        this.mAccuracyLevel = r1;
        transformLocationForLevel(r1);
    }

    public void setAdCode(String r1) {
        this.mAdCode = r1;
    }

    public void setAddress(String r1) {
        this.mAddress = r1;
    }

    public void setAdministrativeArea(String r1) {
        this.mAdministrativeArea = r1;
    }

    public void setAoi(String r1) {
        this.mAoi = r1;
    }

    public void setAoiEntities(List<PoiInfoEntity> r3) {
        this.mAoiEntities = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setBdLBSResult(BdLBSResult r1) {
        this.mBdLBSResult = r1;
    }

    @Override // android.location.Location
    public void setBearing(float r1) {
        this.mBearing = r1;
    }

    public void setBuildingId(String r1) {
        this.mBuildingId = r1;
    }

    public void setCache(boolean r1) {
        this.isCache = r1;
    }

    public void setCity(String r1) {
        this.mCity = r1;
    }

    public void setCityAsciName(String r1) {
        this.mCityAsciName = r1;
    }

    public void setCityCode(String r1) {
        this.mCityCode = r1;
    }

    public void setCityId(long r1) {
        this.mCityId = r1;
    }

    public void setConnectedWifiInfo(WifiInfo r1) {
        this.mConnectedWifiInfo = r1;
    }

    public void setCoordinateSystem(String r1) {
        this.mCoordinateSystem = r1;
    }

    public void setCountry(String r1) {
        this.mCountry = r1;
    }

    public void setCountryAsciName(String r1) {
        this.mCountryAsciName = r1;
    }

    public void setCountryCode(String r1) {
        this.mCountryCode = r1;
    }

    public void setCountryId(long r1) {
        this.mCountryId = r1;
    }

    public void setCountryLocalID(String r1) {
        this.mCountryLocalID = r1;
    }

    public void setDistrict(String r1) {
        this.mDistrict = r1;
    }

    public void setDistrictAsciName(String r1) {
        this.mDistrictAsciName = r1;
    }

    public void setDistrictId(long r1) {
        this.mDistrictId = r1;
    }

    public void setDistrictLocalID(String r1) {
        this.mDistrictLocalID = r1;
    }

    public void setException(BDLocationException r1) {
        this.exception = r1;
    }

    public void setExtra(String r1) {
        this.mExtra = r1;
    }

    public void setFloor(String r1) {
        this.mFloor = r1;
    }

    public void setGCJ02(BDPoint r1) {
        this.mGCJ02 = r1;
    }

    public void setGeoAoiList(List<GeoPoiEntity> r3) {
        this.mGeoAoiList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setGeoFormattedAddress(String r1) {
        this.mGeoFormattedAddress = r1;
    }

    public void setGeoNameID(String r1) {
        this.mGeoNameID = r1;
    }

    public void setGeoPoiList(List<GeoPoiEntity> r3) {
        this.mGeoPoiList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setGeocodeSDKName(String r1) {
        this.mGeocodeSDKName = r1;
    }

    public void setHasServerLatLng(boolean r1) {
        this.mHasServerLatLng = r1;
    }

    public void setInOutDoorConfidence(float r1) {
        this.mInOutDoorConfidence = r1;
    }

    public void setInOutDoorStatus(int r1) {
        this.mInOutDoorStatus = r1;
    }

    public void setIsCompliance(boolean r1) {
        this.mIsCompliance = r1;
    }

    public void setIsDisputed(boolean r1) {
        this.mIsDisputed = r1;
    }

    @Override // android.location.Location
    public void setLatitude(double r1) {
        super.setLatitude(r1);
        this.mLatitude = r1;
    }

    public void setLocInfoRsp(LocInfoRspData r1) {
        this.mLocInfoRsp = r1;
    }

    public void setLocalID(String r1) {
        this.mLocalID = r1;
    }

    public void setLocationDetail(String r1) {
        this.mLocationDetail = r1;
    }

    public void setLocationException(BDLocationException r1) {
        this.mLocationException = r1;
    }

    public void setLocationMs(long r1) {
        this.mLocationMs = r1;
    }

    public void setLocationResult(LocationResult r1) {
        this.mLocationResult = r1;
    }

    public void setLocationSDKName(String r1) {
        this.mLocationSDKName = r1;
    }

    public void setLocationType(int r1) {
        this.mLocationType = r1;
    }

    @Override // android.location.Location
    public void setLongitude(double r1) {
        super.setLongitude(r1);
        this.mLongitude = r1;
    }

    @Override // android.location.Location
    public void setMock(boolean r1) {
        this.mIsMock = r1;
    }

    public void setMockDuration(long r1) {
        this.mMockDuration = r1;
    }

    public void setPoi(String r1) {
        this.mPoi = r1;
    }

    public void setPoiEntities(List<PoiInfoEntity> r3) {
        this.mPoiEntities = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setRecommendWifiResults(boolean r1) {
        this.mIsRecommendWifiResults = r1;
    }

    public void setSatellites(int r1) {
        this.mSatellites = r1;
    }

    public void setServerLocateMethod(String r1) {
        this.mServerLocateMethod = r1;
    }

    public void setServerLocateSuccess(boolean r1) {
        this.mIsServerLocateSuccess = r1;
    }

    @Override // android.location.Location
    public void setSpeed(float r1) {
        this.mSpeed = r1;
    }

    public void setStreet(String r1) {
        this.mStreet = r1;
    }

    public void setStreetNum(String r1) {
        this.mStreetNum = r1;
    }

    public void setSubAdministrativeArea(String r1) {
        this.mSubAdministrativeArea = r1;
    }

    public void setSubdivisionAsciName(String r1) {
        this.mSubdivisionAsciName = r1;
    }

    public void setSubdivisionId(long r1) {
        this.mSubdivisionId = r1;
    }

    public void setSubmitLogId(String r1) {
        this.mSubmitLogId = r1;
    }

    public void setThirdPartLocation(Location r1) {
        this.mThirdPartLocation = r1;
    }

    public void setTown(String r1) {
        this.mTown = r1;
    }

    public void setTownAsciName(String r1) {
        this.mTownAsciName = r1;
    }

    public void setTownId(long r1) {
        this.mTownId = r1;
    }

    public void setTrustedLevel(int r1) {
        this.mTrustedLevel = r1;
    }

    public void setVillage(String r1) {
        this.mVillage = r1;
    }

    public void setVillageAsciName(String r1) {
        this.mVillageAsciName = r1;
    }

    public void setVillageId(long r1) {
        this.mVillageId = r1;
    }

    @Override // android.location.Location
    public String toString() {
        String r0 = this.mThirdPartLocation.toString();     // Catch: Exception -> L4
    L5:
        StringBuilder r1 = new StringBuilder().append("BDLocation{mAddress='").append(this.mAddress).append('\'').append(", mCountry='").append(this.mCountry).append('\'').append(", mAdministrativeArea='").append(this.mAdministrativeArea).append('\'').append(", mSubAdministrativeArea='").append(this.mSubAdministrativeArea).append('\'').append(", mCity='").append(this.mCity).append('\'').append(", mDistrict='").append(this.mDistrict).append('\'').append(", mTown='").append(this.mTown).append('\'').append(", mVillage='").append(this.mVillage).append('\'').append(", mCityCode='").append(this.mCityCode).append('\'').append(", mAdCode='").append(this.mAdCode).append('\'').append(", mLatitude=").append(this.mLatitude).append(", mLongitude=").append(this.mLongitude).append(", mAccuracy=").append(getAccuracy()).append(", mStreet='").append(this.mStreet).append('\'').append(", mStreetNum='").append(this.mStreetNum).append('\'').append(", mFloor='").append(this.mFloor).append('\'').append(", mLocationMs=").append(this.mLocationMs).append(", mElapsedRealtimeNanos=");
        if (Build.VERSION.SDK_INT < 17) goto L8;
        long r3 = getElapsedRealtimeNanos();
    L10:
        return r1.append(r3).append(", mThirdPartLocation=").append(r0).append(", mLocationSDKName='").append(this.mLocationSDKName).append('\'').append(", mPoi='").append(this.mPoi).append('\'').append(", mGCJ02=").append(this.mGCJ02).append(", mLocationType=").append(this.mLocationType).append(", isCache=").append(this.isCache).append(", mCountryCode=").append(this.mCountryCode).append(", mCountryLocalID='").append(this.mCountryLocalID).append('\'').append(", mLocalID='").append(this.mLocalID).append('\'').append(", mDistrictLocalID='").append(this.mDistrictLocalID).append('\'').append(", mGeoNameID='").append(this.mGeoNameID).append('\'').append(", mSubdivisionId='").append(this.mSubdivisionId).append('\'').append(", mBdLBSResult=").append(this.mBdLBSResult).append(", mLocationResult=").append(this.mLocationResult).append(", mGeocodeSDKName='").append(this.mGeocodeSDKName).append('\'').append(", mAoi='").append(this.mAoi).append('\'').append(", mIsDisputed='").append(this.mIsDisputed).append('\'').append(", mIsCompliance='").append(this.mIsCompliance).append('\'').append(", mCoordinateSystem='").append(this.mCoordinateSystem).append('\'').append(", mBearing='").append(this.mBearing).append('\'').append(", mSpeed='").append(this.mSpeed).append('\'').append(", mTrustedLevel='").append(this.mTrustedLevel).append('\'').append(", mLocationDetail='").append(this.mLocationDetail).append('\'').append(", mSatellites='").append(this.mSatellites).append('\'').append(", mPoiEntities='").append(this.mPoiEntities).append('\'').append(", mAoiEntities='").append(this.mAoiEntities).append('\'').append(", mBuildingId='").append(this.mBuildingId).append('\'').append(", mInOutDoorStatus='").append(this.mInOutDoorStatus).append('\'').append(", mInOutDoorConfidence='").append(this.mInOutDoorConfidence).append('\'').append('}').toString();
    L8:
        r3 = 0;
    L4:
        r0 = "error toString()";
        goto L5
    }

    public void transformLocationForLevel(int r5) {
        if (r5 != 4) goto L5;
        return;
    L5:
        setLatitude(0.0d);
        setLongitude(0.0d);
        setTown("");
        setTownId(0);
        setTownAsciName("");
        setAddress("");
        if (r5 != 0) goto L11;
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
        if (r5 == 1) goto L8;
        if (r5 == 2) goto L9;
    }
}
