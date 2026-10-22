package com.byted.mgl.merge.service.model;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface BdpLocator {

    public interface ILocationListener {
        void onLocationChanged(BdpLocation r1);
    }

    public interface ISearchTask {
        void cancel();
    }

    public static class LocateConfig {
        public static final int TYPE_GAODE = 2;
        public static final int TYPE_HOST = 3;
        public static final int TYPE_SYSTEM = 1;
        public boolean isUseGps;
        public long timeout;

        public LocateConfig() {
        }
    }

    public interface PoiResultCallback {
        void onFailed();

        void onSucceed(List<BdpPoiInfo> r1);
    }

    BdpLocation getLastKnwonLocation();

    ISearchTask searchPoiListByKeyword(BdpLatLng r1, String r10, String r11, int r12, int r13, PoiResultCallback r14);

    ISearchTask searchPoiListByLatLng(BdpLatLng r1, int r10, int r11, int r12, PoiResultCallback r13);

    void startLocate(LocateConfig r1, ILocationListener r10);

    void stopLocate(ILocationListener r1);
}
