package com.bytedance.bdlocation.utils.json.serializer;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import ha.p;
import ha.s;
import ha.v;
import ha.w;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationSerializer implements w<BDLocation> {
    public BDLocationSerializer() {
    }

    /* JADX INFO: renamed from: serialize, reason: avoid collision after fix types in other method */
    public p serialize2(BDLocation r8, Type r10, v r11) {
        s r12 = new s();
        r12.n("mProvider", r8.getProvider());     // Catch: Exception -> L5
        r12.m("mAccuracy", Float.valueOf(r8.getAccuracy()));     // Catch: Exception -> L5
        r12.m("mAltitude", Double.valueOf(r8.getAltitude()));     // Catch: Exception -> L5
        r12.m("mBearing", Float.valueOf(r8.getBearing()));     // Catch: Exception -> L5
        r12.m("mBearingAccuracyDegrees", Float.valueOf(r8.getBearingAccuracyDegrees()));     // Catch: Exception -> L5
        r12.m("mElapsedRealtimeNanos", Long.valueOf(r8.getElapsedRealtimeNanos()));     // Catch: Exception -> L5
        r12.m("mLatitude", Double.valueOf(r8.getLatitude()));     // Catch: Exception -> L5
        r12.m("mLongitude", Double.valueOf(r8.getLongitude()));     // Catch: Exception -> L5
        r12.n("mProvider", r8.getProvider());     // Catch: Exception -> L5
        r12.m("mSpeed", Float.valueOf(r8.getSpeed()));     // Catch: Exception -> L5
        r12.m("mSpeedAccuracyMetersPerSecond", Float.valueOf(r8.getSpeedAccuracyMetersPerSecond()));     // Catch: Exception -> L5
        r12.m("mTime", Long.valueOf(r8.getTime()));     // Catch: Exception -> L5
        r12.m("mVerticalAccuracyMeters", Float.valueOf(r8.getVerticalAccuracyMeters()));     // Catch: Exception -> L5
        r12.n("mAddress", r8.getAddress());     // Catch: Exception -> L5
        r12.n("mCountry", r8.getCountry());     // Catch: Exception -> L5
        r12.n("mAdministrativeArea", r8.getAdministrativeArea());     // Catch: Exception -> L5
        r12.n("mSubAdministrativeArea", r8.getSubAdministrativeArea());     // Catch: Exception -> L5
        r12.n("mCity", r8.getCity());     // Catch: Exception -> L5
        r12.n("mDistrict", r8.getDistrict());     // Catch: Exception -> L5
        r12.n("mCityCode", r8.getCityCode());     // Catch: Exception -> L5
        r12.n("mStreet", r8.getStreet());     // Catch: Exception -> L5
        r12.n("mStreetNum", r8.getStreetNum());     // Catch: Exception -> L5
        r12.n("mFloor", r8.getFloor());     // Catch: Exception -> L5
        r12.m("mLocationMs", Long.valueOf(r8.getLocationMs()));     // Catch: Exception -> L5
        r12.n("mLocationSDKName", r8.getLocationSDKName());     // Catch: Exception -> L5
        r12.n("mCoordinateSystem", r8.getCoordinateSystem());     // Catch: Exception -> L5
        r12.n("mPoi", r8.getPoi());     // Catch: Exception -> L5
        r12.m("mLocationType", Integer.valueOf(r8.getLocationType()));     // Catch: Exception -> L5
        r12.n("mCountryCode", r8.getCountryCode());     // Catch: Exception -> L5
        r12.n("mCountryLocalID", r8.getCountryLocalID());     // Catch: Exception -> L5
        r12.n("mLocalID", r8.getLocalID());     // Catch: Exception -> L5
        r12.n("mDistrictLocalID", r8.getDistrictLocalID());     // Catch: Exception -> L5
        r12.n("mGeoNameID", r8.getGeoNameID());     // Catch: Exception -> L5
        r12.n("mGeocodeSDKName", r8.getGeocodeSDKName());     // Catch: Exception -> L5
        r12.n("mAoi", r8.getAoi());     // Catch: Exception -> L5
        r12.m("mMockDuration", Long.valueOf(r8.getMockDuration()));     // Catch: Exception -> L5
        r12.n("mTown", r8.getTown());     // Catch: Exception -> L5
        r12.n("mVillage", r8.getVillage());     // Catch: Exception -> L5
        r12.m("mCountryId", Long.valueOf(r8.getCountryId()));     // Catch: Exception -> L5
        r12.m("mSubdivisionId", Long.valueOf(r8.getSubdivisionId()));     // Catch: Exception -> L5
        r12.m("mCityId", Long.valueOf(r8.getCityId()));     // Catch: Exception -> L5
        r12.m("mDistrictId", Long.valueOf(r8.getDistrictId()));     // Catch: Exception -> L5
        r12.m("mTownId", Long.valueOf(r8.getTownId()));     // Catch: Exception -> L5
        r12.m("mVillageId", Long.valueOf(r8.getVillageId()));     // Catch: Exception -> L5
        r12.n("mCountryAsciName", r8.getCountryAsciName());     // Catch: Exception -> L5
        r12.n("mSubdivisionAsciName", r8.getSubdivisionAsciName());     // Catch: Exception -> L5
        r12.n("mCityAsciName", r8.getCityAsciName());     // Catch: Exception -> L5
        r12.n("mDistrictAsciName", r8.getDistrictAsciName());     // Catch: Exception -> L5
        r12.n("mTownAsciName", r8.getTownAsciName());     // Catch: Exception -> L5
        r12.n("mVillageAsciName", r8.getVillageAsciName());     // Catch: Exception -> L5
        r12.n("mAdCode", r8.getAdCode());     // Catch: Exception -> L5
        r12.l("mIsDisputed", Boolean.valueOf(r8.getIsDisputed()));     // Catch: Exception -> L5
        r12.l("mIsCompliance", Boolean.valueOf(r8.getIsCompliance()));     // Catch: Exception -> L5
        r12.m("mTrustedLevel", Integer.valueOf(r8.getTrustedLevel()));     // Catch: Exception -> L5
        r12.n("mLocationDetail", r8.getLocationDetail());     // Catch: Exception -> L5
        r12.m("mSatellites", Integer.valueOf(r8.getSatellites()));     // Catch: Exception -> L5
        r12.n("mBuildingId", r8.getBuildingId());     // Catch: Exception -> L5
        r12.k("mBdLBSResult", JsonUtil.safeToJsonTree(r8.getBdLBSResult()));     // Catch: Exception -> L5
        r12.k("mLocationResult", JsonUtil.safeToJsonTree(r8.getLocationResult()));     // Catch: Exception -> L5
        r12.k("mGCJ02", JsonUtil.safeToJsonTree(r8.getGCJ02()));     // Catch: Exception -> L5
        r12.k("mPoiEntities", JsonUtil.safeToJsonTree(r8.getPoiEntities()));     // Catch: Exception -> L5
        r12.k("mAoiEntities", JsonUtil.safeToJsonTree(r8.getAoiEntities()));     // Catch: Exception -> L5
        r12.k("mConnectedWifiInfo", JsonUtil.safeToJsonTree(r8.getConnectedWifiInfo()));     // Catch: Exception -> L5
        r12.m("mInOutDoorStatus", Integer.valueOf(r8.getInOutDoorStatus()));     // Catch: Exception -> L5
    L7:
        return r12;
    L5:
        e = move-exception;
        Logger.i(e.getMessage());
        goto L7
    }

    @Override // ha.w
    public /* bridge */ /* synthetic */ p serialize(BDLocation r8, Type r10, v r11) {
        return serialize2(r8, r10, r11);
    }
}
