package com.byted.mgl.merge.service.model;

import android.content.Context;
import android.content.res.Resources;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BdpPoiInfo implements Serializable {
    private static final int DISTANCE_TOO_CLOSE_THRESHOLD_IN_METER = 50;
    public long distanceInMeter;
    public BdpLatLng latLng;
    public String poiAddress;
    public String poiName;

    public BdpPoiInfo() {
    }

    public String toFriendlyDistanceString(Context r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.getResources() == null) goto L19;
        Resources r11 = r10.getResources();
        long r0 = this.distanceInMeter;
        if (r0 < 1000) goto L10;
        return r11.getString(2131894483, new Object[]{Float.valueOf(r0 / 1000.0f)});
    L10:
        if (r0 < 50) goto L14;
        return r11.getString(2131894484, new Object[]{Long.valueOf(r0)});
    L14:
        if (r0 >= 0) goto L16;
        return null;
    L16:
        return r11.getString(2131894485, new Object[]{Integer.valueOf(DISTANCE_TOO_CLOSE_THRESHOLD_IN_METER)});
    L19:
        return null;
    }
}
