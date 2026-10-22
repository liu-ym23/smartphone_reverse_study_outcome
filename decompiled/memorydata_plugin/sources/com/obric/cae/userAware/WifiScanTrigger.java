package com.obric.cae.userAware;

/* JADX INFO: loaded from: classes3.dex */
public interface WifiScanTrigger {
    ConcurrentWifiScanner.RequestHandle start(WifiScanRequestSpec r1);

    boolean stop(ConcurrentWifiScanner.RequestHandle r1);
}
