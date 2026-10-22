package com.obric.cae.userAware;

/* JADX INFO: loaded from: classes3.dex */
public final class WifiScanAttributionFactory {
    private WifiScanAttributionFactory() {
    }

    public static WifiScanAttribution collection(int r2) {
        if (WifiScanSceneType.isCollectionScene(r2) == true) goto L7;
        return invalid();
    L7:
        return new WifiScanAttribution(4, r2);
    }

    public static WifiScanAttribution elevator(int r2) {
        if (WifiScanSceneType.isElevatorScene(r2) == true) goto L7;
        return invalid();
    L7:
        return new WifiScanAttribution(3, r2);
    }

    public static WifiScanAttribution har(int r2) {
        if (WifiScanSceneType.isHarScene(r2) == true) goto L7;
        return invalid();
    L7:
        return new WifiScanAttribution(2, r2);
    }

    public static WifiScanAttribution homeCompany(int r2) {
        if (WifiScanSceneType.isHomeCompanyAwareScene(r2) == true) goto L7;
        return invalid();
    L7:
        return new WifiScanAttribution(1, r2);
    }

    public static WifiScanAttribution invalid() {
        return WifiScanAttribution.INVALID;
    }
}
