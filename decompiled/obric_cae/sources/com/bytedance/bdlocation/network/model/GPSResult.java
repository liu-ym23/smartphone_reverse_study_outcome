package com.bytedance.bdlocation.network.model;

import android.aimedia.a;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;
import com.obric.cae.location.database.StarLocationDbManager;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class GPSResult {

    @b("Accuracy")
    public double accuracy;

    @b("Altitude")
    public String altitude;

    @b("AltitudeAccurary")
    public String altitudeAccurary;

    @b("CoordinateSystem")
    public String coordinateSystem;

    @b("Latitude")
    public double latitude;

    @b("Source")
    public int locateType;

    @b(StarLocationDbManager.GeofenceEntry.LONGITUDE)
    public double longitude;

    @b(BwdlDropProvider.BwdlDropEntry.TIMESTAMP)
    public long timestamp;

    public GPSResult() {
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("GPSResult{accuracy='");
        r8.append(this.accuracy);
        r8.append("', altitude='");
        r8.append(this.altitude);
        r8.append("', altitudeAccurary='");
        r8.append(this.altitudeAccurary);
        r8.append("', timestamp='");
        r8.append(this.timestamp);
        r8.append("', coordinateSystem='");
        r8.append(this.coordinateSystem);
        r8.append("', locateType='");
        return a.h(r8, this.locateType, "'}");
    }
}
