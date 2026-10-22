package com.byted.mgl.merge.service.api.location;

import android.content.Context;
import com.byted.mgl.merge.service.model.BdpLatLng;
import com.byted.mgl.merge.service.model.BdpLocation;
import com.byted.mgl.merge.service.model.BdpLocator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface Locator {
    public static final int DEFAULT_REQUEST_INTERVAL_SEC = 2;

    BdpLocation getLastKnownLocation();

    BdpLocator.ISearchTask searchPoiListByKeyword(Context r1, BdpLatLng r10, String r11, String r12, int r13, int r14, BdpLocator.PoiResultCallback r15);

    BdpLocator.ISearchTask searchPoiListByLatLng(Context r1, BdpLatLng r10, int r11, int r12, int r13, BdpLocator.PoiResultCallback r14);

    void setLocationChangeListener(BdpLocator.ILocationListener r1);

    void startLocate(boolean r1);

    void stopLocate();
}
