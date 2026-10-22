package com.loc;

import android.os.Bundle;
import com.amap.api.location.AMapLocation;

/* JADX INFO: loaded from: classes3.dex */
public final class et {
    public static void a(AMapLocation r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Bundle r0 = r3.getExtras();
        if (r0 != null) goto L9;
        Bundle r1 = new Bundle();
        r1.putInt(AMapLocation.LBS_REAL_LOCATION_TYPE, r3.getLocationType());
        r3.setExtras(r1);
        return;
    L9:
        if (r0.containsKey(AMapLocation.LBS_REAL_LOCATION_TYPE) == true) goto L12;
        r0.putInt(AMapLocation.LBS_REAL_LOCATION_TYPE, r3.getLocationType());
        return;
    }
}
