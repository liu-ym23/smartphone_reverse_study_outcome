package com.bytedance.bdlocation.api;

import android.os.Looper;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationOption;

/* JADX INFO: loaded from: classes.dex */
public interface ILocate extends IManager {
    float calculateLineDistance(BDPoint r1, BDPoint r2);

    BDPoint convertGCJ02(BDPoint r1);

    String getLocateName();

    boolean isAMapDataAvailable(double r1, double r3);

    void startLocation(BDLocationCallback r1, LocationOption r2, Looper r3);

    void stopLocation();

    void stopLocationForBusiness(String r1);
}
