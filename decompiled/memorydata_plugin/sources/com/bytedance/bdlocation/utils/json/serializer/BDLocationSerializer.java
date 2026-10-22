package com.bytedance.bdlocation.utils.json.serializer;

import android.os.Build;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationSerializer implements JsonSerializer<BDLocation> {
    public BDLocationSerializer() {
    }

    /* JADX INFO: renamed from: serialize, reason: avoid collision after fix types in other method */
    public JsonElement serialize2(BDLocation r4, Type r5, JsonSerializationContext r6) {
        Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        JsonSerializationContext r8 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r6, JsonSerializationContext.class, "com.obric.memorydata.plugin");
        JsonObject r9 = new JsonObject();
        r9.addProperty("mProvider", r4.getProvider());     // Catch: Exception -> L17
        r9.addProperty("mAccuracy", Float.valueOf(r4.getAccuracy()));     // Catch: Exception -> L17
        r9.addProperty("mAltitude", Double.valueOf(r4.getAltitude()));     // Catch: Exception -> L17
        r9.addProperty("mBearing", Float.valueOf(r4.getBearing()));     // Catch: Exception -> L17
        if (Build.VERSION.SDK_INT < 26) goto L7;
        r9.addProperty("mBearingAccuracyDegrees", Float.valueOf(r4.getBearingAccuracyDegrees()));     // Catch: Exception -> L17
    L7:
        if (Build.VERSION.SDK_INT < 17) goto L9;
        r9.addProperty("mElapsedRealtimeNanos", Long.valueOf(r4.getElapsedRealtimeNanos()));     // Catch: Exception -> L17
    L9:
        r9.addProperty("mLatitude", Double.valueOf(r4.getLatitude()));     // Catch: Exception -> L17
        r9.addProperty("mLongitude", Double.valueOf(r4.getLongitude()));     // Catch: Exception -> L17
        r9.addProperty("mProvider", r4.getProvider());     // Catch: Exception -> L17
        r9.addProperty("mSpeed", Float.valueOf(r4.getSpeed()));     // Catch: Exception -> L17
        if (Build.VERSION.SDK_INT < 26) goto L12;
        r9.addProperty("mSpeedAccuracyMetersPerSecond", Float.valueOf(r4.getSpeedAccuracyMetersPerSecond()));     // Catch: Exception -> L17
    L12:
        r9.addProperty("mTime", Long.valueOf(r4.getTime()));     // Catch: Exception -> L17
        if (Build.VERSION.SDK_INT < 26) goto L15;
        r9.addProperty("mVerticalAccuracyMeters", Float.valueOf(r4.getVerticalAccuracyMeters()));     // Catch: Exception -> L17
    L15:
        r9.addProperty("mAddress", r4.getAddress());     // Catch: Exception -> L17
        r9.addProperty("mCountry", r4.getCountry());     // Catch: Exception -> L17
        r9.addProperty("mAdministrativeArea", r4.getAdministrativeArea());     // Catch: Exception -> L17
        r9.addProperty("mSubAdministrativeArea", r4.getSubAdministrativeArea());     // Catch: Exception -> L17
        r9.addProperty("mCity", r4.getCity());     // Catch: Exception -> L17
        r9.addProperty("mDistrict", r4.getDistrict());     // Catch: Exception -> L17
        r9.addProperty("mCityCode", r4.getCityCode());     // Catch: Exception -> L17
        r9.addProperty("mStreet", r4.getStreet());     // Catch: Exception -> L17
        r9.addProperty("mStreetNum", r4.getStreetNum());     // Catch: Exception -> L17
        r9.addProperty("mFloor", r4.getFloor());     // Catch: Exception -> L17
        r9.addProperty("mLocationMs", Long.valueOf(r4.getLocationMs()));     // Catch: Exception -> L17
        r9.addProperty("mLocationSDKName", r4.getLocationSDKName());     // Catch: Exception -> L17
        r9.addProperty("mCoordinateSystem", r4.getCoordinateSystem());     // Catch: Exception -> L17
        r9.addProperty("mPoi", r4.getPoi());     // Catch: Exception -> L17
        r9.addProperty("mLocationType", Integer.valueOf(r4.getLocationType()));     // Catch: Exception -> L17
        r9.addProperty("mCountryCode", r4.getCountryCode());     // Catch: Exception -> L17
        r9.addProperty("mCountryLocalID", r4.getCountryLocalID());     // Catch: Exception -> L17
        r9.addProperty("mLocalID", r4.getLocalID());     // Catch: Exception -> L17
        r9.addProperty("mDistrictLocalID", r4.getDistrictLocalID());     // Catch: Exception -> L17
        r9.addProperty("mGeoNameID", r4.getGeoNameID());     // Catch: Exception -> L17
        r9.addProperty("mGeocodeSDKName", r4.getGeocodeSDKName());     // Catch: Exception -> L17
        r9.addProperty("mAoi", r4.getAoi());     // Catch: Exception -> L17
        r9.addProperty("mMockDuration", Long.valueOf(r4.getMockDuration()));     // Catch: Exception -> L17
        r9.addProperty("mTown", r4.getTown());     // Catch: Exception -> L17
        r9.addProperty("mVillage", r4.getVillage());     // Catch: Exception -> L17
        r9.addProperty("mCountryId", Long.valueOf(r4.getCountryId()));     // Catch: Exception -> L17
        r9.addProperty("mSubdivisionId", Long.valueOf(r4.getSubdivisionId()));     // Catch: Exception -> L17
        r9.addProperty("mCityId", Long.valueOf(r4.getCityId()));     // Catch: Exception -> L17
        r9.addProperty("mDistrictId", Long.valueOf(r4.getDistrictId()));     // Catch: Exception -> L17
        r9.addProperty("mTownId", Long.valueOf(r4.getTownId()));     // Catch: Exception -> L17
        r9.addProperty("mVillageId", Long.valueOf(r4.getVillageId()));     // Catch: Exception -> L17
        r9.addProperty("mCountryAsciName", r4.getCountryAsciName());     // Catch: Exception -> L17
        r9.addProperty("mSubdivisionAsciName", r4.getSubdivisionAsciName());     // Catch: Exception -> L17
        r9.addProperty("mCityAsciName", r4.getCityAsciName());     // Catch: Exception -> L17
        r9.addProperty("mDistrictAsciName", r4.getDistrictAsciName());     // Catch: Exception -> L17
        r9.addProperty("mTownAsciName", r4.getTownAsciName());     // Catch: Exception -> L17
        r9.addProperty("mVillageAsciName", r4.getVillageAsciName());     // Catch: Exception -> L17
        r9.addProperty("mAdCode", r4.getAdCode());     // Catch: Exception -> L17
        r9.addProperty("mIsDisputed", Boolean.valueOf(r4.getIsDisputed()));     // Catch: Exception -> L17
        r9.addProperty("mIsCompliance", Boolean.valueOf(r4.getIsCompliance()));     // Catch: Exception -> L17
        r9.addProperty("mTrustedLevel", Integer.valueOf(r4.getTrustedLevel()));     // Catch: Exception -> L17
        r9.addProperty("mLocationDetail", r4.getLocationDetail());     // Catch: Exception -> L17
        r9.addProperty("mSatellites", Integer.valueOf(r4.getSatellites()));     // Catch: Exception -> L17
        r9.addProperty("mBuildingId", r4.getBuildingId());     // Catch: Exception -> L17
        r9.add("mBdLBSResult", JsonUtil.safeToJsonTree(r4.getBdLBSResult()));     // Catch: Exception -> L17
        r9.add("mLocationResult", JsonUtil.safeToJsonTree(r4.getLocationResult()));     // Catch: Exception -> L17
        r9.add("mGCJ02", JsonUtil.safeToJsonTree(r4.getGCJ02()));     // Catch: Exception -> L17
        r9.add("mPoiEntities", JsonUtil.safeToJsonTree(r4.getPoiEntities()));     // Catch: Exception -> L17
        r9.add("mAoiEntities", JsonUtil.safeToJsonTree(r4.getAoiEntities()));     // Catch: Exception -> L17
        r9.add("mConnectedWifiInfo", JsonUtil.safeToJsonTree(r4.getConnectedWifiInfo()));     // Catch: Exception -> L17
        r9.addProperty("mInOutDoorStatus", Integer.valueOf(r4.getInOutDoorStatus()));     // Catch: Exception -> L17
    L19:
        return r9;
    L17:
        e = move-exception;
        Logger.i(e.getMessage());
        goto L19
    }

    @Override // com.google.gson.JsonSerializer
    public /* synthetic */ JsonElement serialize(BDLocation r3, Type r4, JsonSerializationContext r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        JsonSerializationContext r7 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonSerializationContext.class, "com.obric.memorydata.plugin");
        return serialize2((BDLocation) ZeusTransformUtils.preCheckCast(r3, BDLocation.class, "com.obric.memorydata.plugin"), r6, r7);
    }
}
