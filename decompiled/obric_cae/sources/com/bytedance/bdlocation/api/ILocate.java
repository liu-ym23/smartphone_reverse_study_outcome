package com.bytedance.bdlocation.api;

import android.os.Looper;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationOption;

/* JADX INFO: loaded from: classes.dex */
public interface ILocate extends IManager {
    float calculateLineDistance(BDPoint r8, BDPoint r10);

    BDPoint convertGCJ02(BDPoint r8);

    String getLocateName();

    boolean isAMapDataAvailable(double r8, double r10);

    void startLocation(BDLocationCallback r8, LocationOption r10, Looper r11);

    void stopLocation();

    void stopLocationForBusiness(String r8);
}
