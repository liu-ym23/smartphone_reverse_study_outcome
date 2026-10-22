package com.bytedance.bdlocation.utils.json.deserializer;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.BdLBSResult;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.obric.cae.location.database.StarCellDbManager;
import ha.j;
import ha.m;
import ha.n;
import ha.o;
import ha.p;
import ha.s;
import ha.u;
import java.lang.reflect.Type;
import java.util.List;
import ka.f;
import oa.a;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationDeserializer implements o<BDLocation> {
    public static final String TAG = "BDLocationDeserializer";

    public BDLocationDeserializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // ha.o
    public BDLocation deserialize(p r8, Type r10, n r11) {
        s r12 = r8.f();
        BDLocation r13 = new BDLocation(r12.s("mProvider").j(), r12.s("mLocationSDKName").j());
        r13.setCoordinateSystem(r12.s("mCoordinateSystem").j());
        r13.setAccuracy(r12.s("mAccuracy").k());
        r13.setAltitude(r12.s("mAltitude").k());
        r13.setBearing(r12.s("mBearing").k());
        r13.setBearingAccuracyDegrees(r12.s("mBearingAccuracyDegrees").k());
        r13.setElapsedRealtimeNanos(r12.s("mElapsedRealtimeNanos").h());
        r13.setLatitude(r12.s("mLatitude").c());
        r13.setLongitude(r12.s("mLongitude").c());
        r13.setSpeed(r12.s("mSpeed").k());
        r13.setSpeedAccuracyMetersPerSecond(r12.s("mSpeedAccuracyMetersPerSecond").k());
        r13.setTime(r12.s("mTime").h());
        r13.setVerticalAccuracyMeters(r12.s("mVerticalAccuracyMeters").k());
        u r14 = r12.s("mAddress");
        if (r14 == null) goto L5;
        r13.setAddress(r14.j());
    L5:
        u r15 = r12.s("mCountry");
        if (r15 == null) goto L8;
        r13.setCountry(r15.j());
    L8:
        u r16 = r12.s("mAdministrativeArea");
        if (r16 == null) goto L11;
        r13.setAdministrativeArea(r16.j());
    L11:
        u r17 = r12.s("mSubAdministrativeArea");
        if (r17 == null) goto L14;
        r13.setSubAdministrativeArea(r17.j());
    L14:
        u r18 = r12.s("mCity");
        if (r18 == null) goto L17;
        r13.setCity(r18.j());
    L17:
        u r19 = r12.s("mDistrict");
        if (r19 == null) goto L20;
        r13.setDistrict(r19.j());
    L20:
        u r20 = r12.s("mCityCode");
        if (r20 == null) goto L23;
        r13.setCityCode(r20.j());
    L23:
        u r21 = r12.s("mStreet");
        if (r21 == null) goto L26;
        r13.setStreet(r21.j());
    L26:
        u r22 = r12.s("mStreetNum");
        if (r22 == null) goto L29;
        r13.setStreetNum(r22.j());
    L29:
        u r23 = r12.s("mFloor");
        if (r23 == null) goto L32;
        r13.setFloor(r23.j());
    L32:
        r13.setLocationMs(r12.s("mLocationMs").h());
        u r24 = r12.s("mLocationSDKName");
        if (r24 == null) goto L35;
        r13.setLocationSDKName(r24.j());
    L35:
        u r25 = r12.s("mPoi");
        if (r25 == null) goto L38;
        r13.setPoi(r25.j());
    L38:
        BDPoint r26 = new BDPoint();
        s r27 = r12.r("mGCJ02");
        if (r27 == null) goto L44;
        u r28 = r27.s("provider");
        if (r28 == null) goto L43;
        r26.setProvider(r28.j());
    L43:
        r26.setLongitude(r27.s(StarCellDbManager.CellInfoEntry.LONGITUDE).c());
        r26.setLatitude(r27.s("latitude").c());
        r13.setGCJ02(r26);
    L44:
        r13.setLocationType(r12.s("mLocationType").d());
        u r29 = r12.s("mCountryCode");
        if (r29 == null) goto L47;
        r13.setCountryCode(r29.j());
    L47:
        u r30 = r12.s("mCountryLocalID");
        if (r30 == null) goto L50;
        r13.setCountryLocalID(r30.j());
    L50:
        u r31 = r12.s("mLocalID");
        if (r31 == null) goto L53;
        r13.setLocalID(r31.j());
    L53:
        u r32 = r12.s("mDistrictLocalID");
        if (r32 == null) goto L56;
        r13.setDistrictLocalID(r32.j());
    L56:
        u r33 = r12.s("mGeoNameID");
        if (r33 == null) goto L59;
        r13.setGeoNameID(r33.j());
    L59:
        u r34 = r12.s("mGeocodeSDKName");
        if (r34 == null) goto L62;
        r13.setGeocodeSDKName(r34.j());
    L62:
        u r35 = r12.s("mAoi");
        if (r35 == null) goto L65;
        r13.setAoi(r35.j());
    L65:
        u r36 = r12.s("mMockDuration");
        if (r36 == null) goto L68;
        r13.setMockDuration(r36.h());
    L68:
        u r37 = r12.s("mTown");
        if (r37 == null) goto L71;
        r13.setTown(r37.j());
    L71:
        u r38 = r12.s("mVillage");
        if (r38 == null) goto L74;
        r13.setVillage(r38.j());
    L74:
        u r39 = r12.s("mCountryId");
        if (r39 == null) goto L77;
        r13.setCountryId(r39.h());
    L77:
        u r40 = r12.s("mSubdivisionId");
        if (r40 == null) goto L80;
        r13.setSubdivisionId(r40.h());
    L80:
        u r41 = r12.s("mCityId");
        if (r41 == null) goto L83;
        r13.setCityId(r41.h());
    L83:
        u r42 = r12.s("mDistrictId");
        if (r42 == null) goto L86;
        r13.setDistrictId(r42.h());
    L86:
        u r43 = r12.s("mTownId");
        if (r43 == null) goto L89;
        r13.setTownId(r43.h());
    L89:
        u r44 = r12.s("mVillageId");
        if (r44 == null) goto L92;
        r13.setVillageId(r44.h());
    L92:
        u r45 = r12.s("mCountryAsciName");
        if (r45 == null) goto L95;
        r13.setCountryAsciName(r45.j());
    L95:
        u r46 = r12.s("mSubdivisionAsciName");
        if (r46 == null) goto L98;
        r13.setSubdivisionAsciName(r46.j());
    L98:
        u r47 = r12.s("mCityAsciName");
        if (r47 == null) goto L101;
        r13.setCityAsciName(r47.j());
    L101:
        u r48 = r12.s("mDistrictAsciName");
        if (r48 == null) goto L104;
        r13.setDistrictAsciName(r48.j());
    L104:
        u r49 = r12.s("mTownAsciName");
        if (r49 == null) goto L107;
        r13.setTownAsciName(r49.j());
    L107:
        u r50 = r12.s("mVillageAsciName");
        if (r50 == null) goto L110;
        r13.setVillageAsciName(r50.j());
    L110:
        u r51 = r12.s("mAdCode");
        if (r51 == null) goto L113;
        r13.setAdCode(r51.j());
    L113:
        u r52 = r12.s("mIsDisputed");
        if (r52 == null) goto L116;
        r13.setIsDisputed(r52.b());
    L116:
        u r53 = r12.s("mIsCompliance");
        if (r53 == null) goto L119;
        r13.setIsCompliance(r53.b());
    L119:
        u r54 = r12.s("mTrustedLevel");
        if (r54 == null) goto L122;
        r13.setTrustedLevel(r54.d());
    L122:
        u r55 = r12.s("mLocationDetail");
        if (r55 == null) goto L125;
        r13.setLocationDetail(r55.j());
    L125:
        u r56 = r12.s("mSatellites");
        if (r56 == null) goto L128;
        r13.setSatellites(r56.d());
    L128:
        u r57 = r12.s("mBuildingId");
        if (r57 == null) goto L131;
        r13.setBuildingId(r57.j());
    L131:
        u r58 = r12.s("mInOutDoorStatus");
        if (r58 == null) goto L134;
        r13.setInOutDoorStatus(r58.d());
    L134:
        u r59 = r12.s("mInOutDoorConfidence");
        if (r59 == null) goto L178;
        r13.setInOutDoorConfidence(r59.k());
    L178:
        s r60 = r12.r("mBdLBSResult");     // Catch: Exception -> L141
        if (r60 == null) goto L184;
        r13.setBdLBSResult((BdLBSResult) JsonUtil.sGson.b(r60, BdLBSResult.class));     // Catch: Exception -> L141
    L184:
        s r61 = r12.r("mLocationResult");     // Catch: Exception -> L147
        if (r61 == null) goto L176;
        r13.setLocationResult((LocationResult) JsonUtil.sGson.b(r61, LocationResult.class));     // Catch: Exception -> L147
    L176:
        s r62 = r12.r("mGCJ02");     // Catch: Exception -> L153
        if (r62 == null) goto L180;
        r13.setGCJ02((BDPoint) JsonUtil.sGson.b(r62, BDPoint.class));     // Catch: Exception -> L153
    L180:
        m r63 = r12.q("mPoiEntities");     // Catch: Exception -> L159
        if (r63 == null) goto L182;
        j r64 = JsonUtil.sGson;     // Catch: Exception -> L159
        Type r65 = new AnonymousClass1(this).getType();     // Catch: Exception -> L159
        r64.getClass();     // Catch: Exception -> L159
        r13.setPoiEntities((List) r64.e(new f(r63), a.get(r65)));     // Catch: Exception -> L159
    L182:
        m r66 = r12.q("mAoiEntities");     // Catch: Exception -> L165
        if (r66 == null) goto L174;
        j r67 = JsonUtil.sGson;     // Catch: Exception -> L165
        Type r68 = new AnonymousClass2(this).getType();     // Catch: Exception -> L165
        r67.getClass();     // Catch: Exception -> L165
        r13.setAoiEntities((List) r67.e(new f(r66), a.get(r68)));     // Catch: Exception -> L165
    L174:
        s r69 = r12.r("mConnectedWifiInfo");     // Catch: Exception -> L171
        if (r69 == null) goto L173;
        r13.setConnectedWifiInfo((WifiInfo) JsonUtil.sGson.b(r69, WifiInfo.class));     // Catch: Exception -> L171
    L173:
        return r13;
    L171:
        e = move-exception;
        Logger.e(TAG, e);
    L165:
        e = move-exception;
        Logger.e(TAG, e);
    L159:
        e = move-exception;
        Logger.e(TAG, e);
    L153:
        e = move-exception;
        Logger.e(TAG, e);
    L147:
        e = move-exception;
        Logger.e(TAG, e);
    L141:
        e = move-exception;
        Logger.e(TAG, e);
        goto L184
    }

    @Override // ha.o
    public /* bridge */ /* synthetic */ BDLocation deserialize(p r8, Type r10, n r11) {
        return deserialize(r8, r10, r11);
    }
}
