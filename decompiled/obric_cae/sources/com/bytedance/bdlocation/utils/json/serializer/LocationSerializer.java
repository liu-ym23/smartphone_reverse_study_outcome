package com.bytedance.bdlocation.utils.json.serializer;

import android.location.Location;
import com.bytedance.bdlocation.log.Logger;
import ha.p;
import ha.s;
import ha.v;
import ha.w;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class LocationSerializer implements w<Location> {
    public LocationSerializer() {
    }

    /* JADX INFO: renamed from: serialize, reason: avoid collision after fix types in other method */
    public p serialize2(Location r8, Type r10, v r11) {
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
    L7:
        return r12;
    L5:
        e = move-exception;
        Logger.i(e.getMessage());
        goto L7
    }

    @Override // ha.w
    public /* bridge */ /* synthetic */ p serialize(Location r8, Type r10, v r11) {
        return serialize2(r8, r10, r11);
    }
}
