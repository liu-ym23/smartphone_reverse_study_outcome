package com.bytedance.bdlocation.utils.json.deserializer;

import android.location.Location;
import ha.n;
import ha.o;
import ha.p;
import ha.s;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class LocationDeserializer implements o<Location> {
    public LocationDeserializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // ha.o
    public Location deserialize(p r8, Type r10, n r11) {
        s r12 = r8.f();
        Location r13 = new Location(r12.s("mProvider").j());
        r13.setAccuracy(r12.s("mAccuracy").k());
        r13.setAltitude(r12.s("mAltitude").k());
        r13.setBearing(r12.s("mBearing").k());
        r13.setBearingAccuracyDegrees(r12.s("mBearingAccuracyDegrees").k());
        r13.setElapsedRealtimeNanos(r12.s("mElapsedRealtimeNanos").h());
        r13.setLatitude(r12.s("mLatitude").c());
        r13.setLongitude(r12.s("mLongitude").c());
        r13.setProvider(r12.s("mProvider").j());
        r13.setSpeed(r12.s("mSpeed").k());
        r13.setSpeedAccuracyMetersPerSecond(r12.s("mSpeedAccuracyMetersPerSecond").k());
        r13.setTime(r12.s("mTime").h());
        r13.setVerticalAccuracyMeters(r12.s("mVerticalAccuracyMeters").k());
        return r13;
    }

    @Override // ha.o
    public /* bridge */ /* synthetic */ Location deserialize(p r8, Type r10, n r11) {
        return deserialize(r8, r10, r11);
    }
}
