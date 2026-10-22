package com.obric.memorydata.thirdparty.impl.location;

import android.location.Location;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.thirdparty.api.location.ILocationManager;
import com.obric.memorydata.thirdparty.api.location.a;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0000H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J(\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016J \u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0016J \u0010\u0011\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/thirdparty/impl/location/LocationManagerImpl;", "Lcom/obric/memorydata/thirdparty/api/location/ILocationManager;", "<init>", "()V", "TAG", "", "getInst", "isLatLonValid", "", "latitude", "", "longitude", "getDistance", "longitude1", "latitude1", "longitude2", "latitude2", "isInRange", "geoPoint1", "Lcom/obric/memorydata/thirdparty/api/location/GeoPoint;", "geoPoint2", "distance", "geoPoint", "location", "Landroid/location/Location;", "location_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocationManagerImpl implements ILocationManager {
    public static final LocationManagerImpl INSTANCE = null;
    private static final String TAG = "LocationManager";

    static {
        INSTANCE = new LocationManagerImpl();
    }

    private LocationManagerImpl() {
    }

    private final double getDistance(a r10, Location r11) {
        return getDistance(r10.b(), r10.a(), r11.getLongitude(), r11.getLatitude());
    }

    private final double getDistance(a r10, a r11) {
        return getDistance(r10.b(), r10.a(), r11.b(), r11.a());
    }

    @JvmStatic
    public static final LocationManagerImpl getInst() {
        return INSTANCE;
    }

    private final boolean isInRange(a r3, Location r4, double r5) {
        double r2 = getDistance(r3, r4);
        RunLog.INSTANCE.debug(TAG, "this distance : " + r2 + " threshold distance : " + r5);
        if (r2 > r5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.memorydata.thirdparty.api.location.ILocationManager
    public double getDistance(double r6, double r8, double r10, double r12) {
        double r7 = r6 * 0.01745329251994329d;
        double r9 = r8 * 0.01745329251994329d;
        double r11 = r10 * 0.01745329251994329d;
        double r13 = r12 * 0.01745329251994329d;
        double[] r0 = {Math.cos(r9) * Math.cos(r7), Math.cos(r9) * Math.sin(r7), Math.sin(r9)};
        double[] r5 = {Math.cos(r13) * Math.cos(r11), Math.cos(r13) * Math.sin(r11), Math.sin(r13)};
        double r14 = r0[0] - r5[0];
        double r15 = r0[1] - r5[1];
        double r16 = r0[2] - r5[2];
        return Math.asin(Math.sqrt(((r14 * r14) + (r15 * r15)) + (r16 * r16)) / 2.0d) * 1.27420015798544E7d;
    }

    @Override // com.obric.memorydata.thirdparty.api.location.ILocationManager
    public boolean isInRange(a r3, a r4, double r5) {
        Intrinsics.checkNotNullParameter(r3, "geoPoint1");
        Intrinsics.checkNotNullParameter(r4, "geoPoint2");
        double r2 = getDistance(r3, r4);
        RunLog.INSTANCE.debug(TAG, "this distance : " + r2 + " threshold distance : " + r5);
        if (r2 > r5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.memorydata.thirdparty.api.location.ILocationManager
    public boolean isLatLonValid(double r3, double r5) {
        if (r3 >= (-90.0d)) goto L5;
    L11:
        return false;
    L5:
        if (r3 > 90.0d) goto L11;
        if (r5 < (-180.0d)) goto L11;
        if (r5 > 180.0d) goto L11;
        return true;
    }
}
