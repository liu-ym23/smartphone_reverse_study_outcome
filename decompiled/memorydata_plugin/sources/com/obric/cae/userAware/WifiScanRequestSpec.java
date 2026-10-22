package com.obric.cae.userAware;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class WifiScanRequestSpec {
    private final boolean allowFirstScanWithoutMovement;
    private final WifiScanAttribution attribution;
    private final ConcurrentWifiScanner.AttributedScanCallback callback;
    private final long durationMs;
    private final boolean ignoreMovementGate;
    private final long intervalMs;
    private final boolean prioritySingleScan;

    private WifiScanRequestSpec(WifiScanAttribution r3, long r4, long r6, boolean r8, boolean r9, boolean r10, ConcurrentWifiScanner.AttributedScanCallback r11) {
        ConcurrentWifiScanner.AttributedScanCallback r12 = (ConcurrentWifiScanner.AttributedScanCallback) ZeusTransformUtils.wrapperContextForParams(r11, ConcurrentWifiScanner.AttributedScanCallback.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        r3 = WifiScanAttributionFactory.invalid();
    L6:
        this.attribution = r3;
        this.intervalMs = r4;
        this.durationMs = r6;
        this.ignoreMovementGate = r8;
        this.allowFirstScanWithoutMovement = r9;
        this.prioritySingleScan = r10;
        this.callback = r12;
    }

    public static WifiScanRequestSpec normal(WifiScanAttribution r8, long r9, long r11, boolean r13, ConcurrentWifiScanner.AttributedScanCallback r14) {
        return normal(r8, r9, r11, r13, !r13, (ConcurrentWifiScanner.AttributedScanCallback) ZeusTransformUtils.wrapperContextForParams(r14, ConcurrentWifiScanner.AttributedScanCallback.class, "com.obric.memorydata.plugin"));
    }

    public static WifiScanRequestSpec normal(WifiScanAttribution r11, long r12, long r14, boolean r16, boolean r17, ConcurrentWifiScanner.AttributedScanCallback r18) {
        return new WifiScanRequestSpec(r11, r12, r14, r16, r17, false, (ConcurrentWifiScanner.AttributedScanCallback) ZeusTransformUtils.wrapperContextForParams(r18, ConcurrentWifiScanner.AttributedScanCallback.class, "com.obric.memorydata.plugin"));
    }

    public static WifiScanRequestSpec prioritySingle(WifiScanAttribution r10, long r11, long r13, ConcurrentWifiScanner.AttributedScanCallback r15) {
        return new WifiScanRequestSpec(r10, r11, r13, true, false, true, (ConcurrentWifiScanner.AttributedScanCallback) ZeusTransformUtils.wrapperContextForParams(r15, ConcurrentWifiScanner.AttributedScanCallback.class, "com.obric.memorydata.plugin"));
    }

    public WifiScanAttribution getAttribution() {
        return this.attribution;
    }

    public ConcurrentWifiScanner.AttributedScanCallback getCallback() {
        return this.callback;
    }

    public long getDurationMs() {
        return this.durationMs;
    }

    public long getIntervalMs() {
        return this.intervalMs;
    }

    public boolean isPrioritySingleScan() {
        return this.prioritySingleScan;
    }

    public boolean shouldAllowFirstScanWithoutMovement() {
        return this.allowFirstScanWithoutMovement;
    }

    public boolean shouldIgnoreMovementGate() {
        return this.ignoreMovementGate;
    }
}
