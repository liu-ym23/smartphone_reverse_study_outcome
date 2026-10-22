package com.bytedance.bdlocation.utils.json.deserializer;

import android.os.Build;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.BdLBSResult;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationDeserializer implements JsonDeserializer<BDLocation> {
    public static final String TAG = "BDLocationDeserializer";

    public BDLocationDeserializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public BDLocation deserialize(JsonElement r7, Type r8, JsonDeserializationContext r9) {
        Type r10 = (Type) ZeusTransformUtils.wrapperContextForParams(r8, Type.class, "com.obric.memorydata.plugin");
        JsonDeserializationContext r11 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r9, JsonDeserializationContext.class, "com.obric.memorydata.plugin");
        JsonObject r12 = r7.getAsJsonObject();
        if (r12 != null) goto L6;
        return null;
    L6:
        BDLocation r13 = new BDLocation(r12.getAsJsonPrimitive("mProvider").getAsString(), r12.getAsJsonPrimitive("mLocationSDKName").getAsString());
        r13.setCoordinateSystem(r12.getAsJsonPrimitive("mCoordinateSystem").getAsString());
        r13.setAccuracy(r12.getAsJsonPrimitive("mAccuracy").getAsFloat());
        r13.setAltitude(r12.getAsJsonPrimitive("mAltitude").getAsFloat());
        r13.setBearing(r12.getAsJsonPrimitive("mBearing").getAsFloat());
        if (Build.VERSION.SDK_INT < 26) goto L10;
        r13.setBearingAccuracyDegrees(r12.getAsJsonPrimitive("mBearingAccuracyDegrees").getAsFloat());
    L10:
        if (Build.VERSION.SDK_INT < 17) goto L12;
        r13.setElapsedRealtimeNanos(r12.getAsJsonPrimitive("mElapsedRealtimeNanos").getAsLong());
    L12:
        r13.setLatitude(r12.getAsJsonPrimitive("mLatitude").getAsDouble());
        r13.setLongitude(r12.getAsJsonPrimitive("mLongitude").getAsDouble());
        r13.setSpeed(r12.getAsJsonPrimitive("mSpeed").getAsFloat());
        if (Build.VERSION.SDK_INT < 26) goto L15;
        r13.setSpeedAccuracyMetersPerSecond(r12.getAsJsonPrimitive("mSpeedAccuracyMetersPerSecond").getAsFloat());
    L15:
        r13.setTime(r12.getAsJsonPrimitive("mTime").getAsLong());
        if (Build.VERSION.SDK_INT < 26) goto L18;
        r13.setVerticalAccuracyMeters(r12.getAsJsonPrimitive("mVerticalAccuracyMeters").getAsFloat());
    L18:
        JsonPrimitive r14 = r12.getAsJsonPrimitive("mAddress");
        if (r14 == null) goto L21;
        r13.setAddress(r14.getAsString());
    L21:
        JsonPrimitive r15 = r12.getAsJsonPrimitive("mCountry");
        if (r15 == null) goto L24;
        r13.setCountry(r15.getAsString());
    L24:
        JsonPrimitive r16 = r12.getAsJsonPrimitive("mAdministrativeArea");
        if (r16 == null) goto L27;
        r13.setAdministrativeArea(r16.getAsString());
    L27:
        JsonPrimitive r17 = r12.getAsJsonPrimitive("mSubAdministrativeArea");
        if (r17 == null) goto L30;
        r13.setSubAdministrativeArea(r17.getAsString());
    L30:
        JsonPrimitive r18 = r12.getAsJsonPrimitive("mCity");
        if (r18 == null) goto L33;
        r13.setCity(r18.getAsString());
    L33:
        JsonPrimitive r19 = r12.getAsJsonPrimitive("mDistrict");
        if (r19 == null) goto L36;
        r13.setDistrict(r19.getAsString());
    L36:
        JsonPrimitive r20 = r12.getAsJsonPrimitive("mCityCode");
        if (r20 == null) goto L39;
        r13.setCityCode(r20.getAsString());
    L39:
        JsonPrimitive r21 = r12.getAsJsonPrimitive("mStreet");
        if (r21 == null) goto L42;
        r13.setStreet(r21.getAsString());
    L42:
        JsonPrimitive r22 = r12.getAsJsonPrimitive("mStreetNum");
        if (r22 == null) goto L45;
        r13.setStreetNum(r22.getAsString());
    L45:
        JsonPrimitive r23 = r12.getAsJsonPrimitive("mFloor");
        if (r23 == null) goto L48;
        r13.setFloor(r23.getAsString());
    L48:
        r13.setLocationMs(r12.getAsJsonPrimitive("mLocationMs").getAsLong());
        JsonPrimitive r24 = r12.getAsJsonPrimitive("mLocationSDKName");
        if (r24 == null) goto L51;
        r13.setLocationSDKName(r24.getAsString());
    L51:
        JsonPrimitive r25 = r12.getAsJsonPrimitive("mPoi");
        if (r25 == null) goto L54;
        r13.setPoi(r25.getAsString());
    L54:
        BDPoint r26 = new BDPoint();
        JsonObject r3 = r12.getAsJsonObject("mGCJ02");
        if (r3 == null) goto L60;
        JsonPrimitive r4 = r3.getAsJsonPrimitive("provider");
        if (r4 == null) goto L59;
        r26.setProvider(r4.getAsString());
    L59:
        r26.setLongitude(r3.getAsJsonPrimitive("longitude").getAsDouble());
        r26.setLatitude(r3.getAsJsonPrimitive("latitude").getAsDouble());
        r13.setGCJ02(r26);
    L60:
        r13.setLocationType(r12.getAsJsonPrimitive("mLocationType").getAsInt());
        JsonPrimitive r27 = r12.getAsJsonPrimitive("mCountryCode");
        if (r27 == null) goto L63;
        r13.setCountryCode(r27.getAsString());
    L63:
        JsonPrimitive r28 = r12.getAsJsonPrimitive("mCountryLocalID");
        if (r28 == null) goto L66;
        r13.setCountryLocalID(r28.getAsString());
    L66:
        JsonPrimitive r29 = r12.getAsJsonPrimitive("mLocalID");
        if (r29 == null) goto L69;
        r13.setLocalID(r29.getAsString());
    L69:
        JsonPrimitive r30 = r12.getAsJsonPrimitive("mDistrictLocalID");
        if (r30 == null) goto L72;
        r13.setDistrictLocalID(r30.getAsString());
    L72:
        JsonPrimitive r31 = r12.getAsJsonPrimitive("mGeoNameID");
        if (r31 == null) goto L75;
        r13.setGeoNameID(r31.getAsString());
    L75:
        JsonPrimitive r32 = r12.getAsJsonPrimitive("mGeocodeSDKName");
        if (r32 == null) goto L78;
        r13.setGeocodeSDKName(r32.getAsString());
    L78:
        JsonPrimitive r33 = r12.getAsJsonPrimitive("mAoi");
        if (r33 == null) goto L81;
        r13.setAoi(r33.getAsString());
    L81:
        JsonPrimitive r34 = r12.getAsJsonPrimitive("mMockDuration");
        if (r34 == null) goto L84;
        r13.setMockDuration(r34.getAsLong());
    L84:
        JsonPrimitive r35 = r12.getAsJsonPrimitive("mTown");
        if (r35 == null) goto L87;
        r13.setTown(r35.getAsString());
    L87:
        JsonPrimitive r36 = r12.getAsJsonPrimitive("mVillage");
        if (r36 == null) goto L90;
        r13.setVillage(r36.getAsString());
    L90:
        JsonPrimitive r37 = r12.getAsJsonPrimitive("mCountryId");
        if (r37 == null) goto L93;
        r13.setCountryId(r37.getAsLong());
    L93:
        JsonPrimitive r38 = r12.getAsJsonPrimitive("mSubdivisionId");
        if (r38 == null) goto L96;
        r13.setSubdivisionId(r38.getAsLong());
    L96:
        JsonPrimitive r39 = r12.getAsJsonPrimitive("mCityId");
        if (r39 == null) goto L99;
        r13.setCityId(r39.getAsLong());
    L99:
        JsonPrimitive r40 = r12.getAsJsonPrimitive("mDistrictId");
        if (r40 == null) goto L102;
        r13.setDistrictId(r40.getAsLong());
    L102:
        JsonPrimitive r41 = r12.getAsJsonPrimitive("mTownId");
        if (r41 == null) goto L105;
        r13.setTownId(r41.getAsLong());
    L105:
        JsonPrimitive r42 = r12.getAsJsonPrimitive("mVillageId");
        if (r42 == null) goto L108;
        r13.setVillageId(r42.getAsLong());
    L108:
        JsonPrimitive r43 = r12.getAsJsonPrimitive("mCountryAsciName");
        if (r43 == null) goto L111;
        r13.setCountryAsciName(r43.getAsString());
    L111:
        JsonPrimitive r44 = r12.getAsJsonPrimitive("mSubdivisionAsciName");
        if (r44 == null) goto L114;
        r13.setSubdivisionAsciName(r44.getAsString());
    L114:
        JsonPrimitive r45 = r12.getAsJsonPrimitive("mCityAsciName");
        if (r45 == null) goto L117;
        r13.setCityAsciName(r45.getAsString());
    L117:
        JsonPrimitive r46 = r12.getAsJsonPrimitive("mDistrictAsciName");
        if (r46 == null) goto L120;
        r13.setDistrictAsciName(r46.getAsString());
    L120:
        JsonPrimitive r47 = r12.getAsJsonPrimitive("mTownAsciName");
        if (r47 == null) goto L123;
        r13.setTownAsciName(r47.getAsString());
    L123:
        JsonPrimitive r48 = r12.getAsJsonPrimitive("mVillageAsciName");
        if (r48 == null) goto L126;
        r13.setVillageAsciName(r48.getAsString());
    L126:
        JsonPrimitive r49 = r12.getAsJsonPrimitive("mAdCode");
        if (r49 == null) goto L129;
        r13.setAdCode(r49.getAsString());
    L129:
        JsonPrimitive r50 = r12.getAsJsonPrimitive("mIsDisputed");
        if (r50 == null) goto L132;
        r13.setIsDisputed(r50.getAsBoolean());
    L132:
        JsonPrimitive r51 = r12.getAsJsonPrimitive("mIsCompliance");
        if (r51 == null) goto L135;
        r13.setIsCompliance(r51.getAsBoolean());
    L135:
        JsonPrimitive r52 = r12.getAsJsonPrimitive("mTrustedLevel");
        if (r52 == null) goto L138;
        r13.setTrustedLevel(r52.getAsInt());
    L138:
        JsonPrimitive r53 = r12.getAsJsonPrimitive("mLocationDetail");
        if (r53 == null) goto L141;
        r13.setLocationDetail(r53.getAsString());
    L141:
        JsonPrimitive r54 = r12.getAsJsonPrimitive("mSatellites");
        if (r54 == null) goto L144;
        r13.setSatellites(r54.getAsInt());
    L144:
        JsonPrimitive r55 = r12.getAsJsonPrimitive("mBuildingId");
        if (r55 == null) goto L147;
        r13.setBuildingId(r55.getAsString());
    L147:
        JsonPrimitive r56 = r12.getAsJsonPrimitive("mInOutDoorStatus");
        if (r56 == null) goto L150;
        r13.setInOutDoorStatus(r56.getAsInt());
    L150:
        JsonPrimitive r57 = r12.getAsJsonPrimitive("mInOutDoorConfidence");
        if (r57 == null) goto L194;
        r13.setInOutDoorConfidence(r57.getAsFloat());
    L194:
        JsonObject r58 = r12.getAsJsonObject("mBdLBSResult");     // Catch: Exception -> L157
        if (r58 == null) goto L192;
        r13.setBdLBSResult((BdLBSResult) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(r58, BdLBSResult.class), BdLBSResult.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L157
    L192:
        JsonObject r59 = r12.getAsJsonObject("mLocationResult");     // Catch: Exception -> L163
        if (r59 == null) goto L196;
        r13.setLocationResult((LocationResult) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(r59, LocationResult.class), LocationResult.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L163
    L196:
        JsonObject r60 = r12.getAsJsonObject("mGCJ02");     // Catch: Exception -> L169
        if (r60 == null) goto L190;
        r13.setGCJ02((BDPoint) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(r60, BDPoint.class), BDPoint.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L169
    L190:
        JsonArray r61 = r12.getAsJsonArray("mPoiEntities");     // Catch: Exception -> L175
        if (r61 == null) goto L200;
        r13.setPoiEntities((List) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(r61, new AnonymousClass1(this).getType()), List.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L175
    L200:
        JsonArray r62 = r12.getAsJsonArray("mAoiEntities");     // Catch: Exception -> L181
        if (r62 == null) goto L198;
        r13.setAoiEntities((List) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(r62, new AnonymousClass2(this).getType()), List.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L181
    L198:
        JsonObject r6 = r12.getAsJsonObject("mConnectedWifiInfo");     // Catch: Exception -> L187
        if (r6 == null) goto L189;
        r13.setConnectedWifiInfo((WifiInfo) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(r6, WifiInfo.class), WifiInfo.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L187
    L189:
        return r13;
    L187:
        e = move-exception;
        Logger.e(TAG, e);
    L181:
        e = move-exception;
        Logger.e(TAG, e);
    L175:
        e = move-exception;
        Logger.e(TAG, e);
    L169:
        e = move-exception;
        Logger.e(TAG, e);
    L163:
        e = move-exception;
        Logger.e(TAG, e);
    L157:
        e = move-exception;
        Logger.e(TAG, e);
        goto L192
    }

    @Override // com.google.gson.JsonDeserializer
    public /* synthetic */ BDLocation deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        return deserialize(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.memorydata.plugin"));
    }
}
