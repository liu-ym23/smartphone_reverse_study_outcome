package com.obric.cae.userAware;

import android.net.wifi.ScanResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class WifiSceneScanController {
    private final ScanResultSink mResultSink;
    private final TrainingModeTrigger mTrainingModeTrigger;
    private final WifiScanTrigger mTrigger;

    public interface ScanResultSink {
        void onScanResults(List<ScanResult> r1, WifiScanAttribution r2);
    }

    public interface TrainingModeTrigger {
        void setTrainingMode(boolean r1, ConcurrentWifiScanner.AttributedScanCallback r2, WifiScanAttribution r3);
    }

    public WifiSceneScanController(WifiScanTrigger r3, TrainingModeTrigger r4, ScanResultSink r5) {
        WifiScanTrigger r6 = (WifiScanTrigger) ZeusTransformUtils.wrapperContextForParams(r3, WifiScanTrigger.class, "com.obric.memorydata.plugin");
        TrainingModeTrigger r7 = (TrainingModeTrigger) ZeusTransformUtils.wrapperContextForParams(r4, TrainingModeTrigger.class, "com.obric.memorydata.plugin");
        ScanResultSink r8 = (ScanResultSink) ZeusTransformUtils.wrapperContextForParams(r5, ScanResultSink.class, "com.obric.memorydata.plugin");
        this.mTrigger = r6;
        this.mTrainingModeTrigger = r7;
        this.mResultSink = r8;
    }

    private void dispatchScanResults(List<ScanResult> r3, WifiScanAttribution r4) {
        List<ScanResult> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        ScanResultSink r2 = this.mResultSink;
        if (r2 == null) goto L6;
        r2.onScanResults(r5, r4);
        return;
    }

    /* JADX INFO: renamed from: lambda$QWA23ZvztiA-oV4BHahsWw47S94, reason: not valid java name */
    public static /* synthetic */ void m404lambda$QWA23ZvztiAoV4BHahsWw47S94(WifiSceneScanController r0, List r1, WifiScanAttribution r2) {
        r0.dispatchScanResults(r1, r2);
    }

    private ConcurrentWifiScanner.RequestHandle start(WifiScanRequestSpec r1) {
        WifiScanTrigger r0 = this.mTrigger;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.start(r1);
    }

    public void setCollectionTrainingMode(boolean r2) {
        setCollectionTrainingMode(r2, 301);
    }

    public void setCollectionTrainingMode(boolean r3, int r4) {
        TrainingModeTrigger r0 = this.mTrainingModeTrigger;
        if (r0 == null) goto L6;
        r0.setTrainingMode(r3, new $$Lambda$WifiSceneScanController$QWA23ZvztiAoV4BHahsWw47S94(this), WifiScanAttributionFactory.collection(r4));
        return;
    }

    public ConcurrentWifiScanner.RequestHandle startCollectionWifiScan(int r7, long r8, long r10) {
        return start(WifiScanRequestSpec.prioritySingle(WifiScanAttributionFactory.collection(r7), r8, r10, new $$Lambda$WifiSceneScanController$QWA23ZvztiAoV4BHahsWw47S94(this)));
    }

    public ConcurrentWifiScanner.RequestHandle startCollectionWifiScan(long r7, long r9) {
        return startCollectionWifiScan(301, r7, r9);
    }

    public ConcurrentWifiScanner.RequestHandle startElevatorWifiScan(int r7, long r8, long r10) {
        return start(WifiScanRequestSpec.prioritySingle(WifiScanAttributionFactory.elevator(r7), r8, r10, new $$Lambda$WifiSceneScanController$QWA23ZvztiAoV4BHahsWw47S94(this)));
    }

    public ConcurrentWifiScanner.RequestHandle startElevatorWifiScan(long r7, long r9) {
        return startElevatorWifiScan(201, r7, r9);
    }

    public ConcurrentWifiScanner.RequestHandle startHarWifiScan(int r7, long r8, long r10) {
        return start(WifiScanRequestSpec.prioritySingle(WifiScanAttributionFactory.har(r7), r8, r10, new $$Lambda$WifiSceneScanController$QWA23ZvztiAoV4BHahsWw47S94(this)));
    }

    public ConcurrentWifiScanner.RequestHandle startHarWifiScan(long r7, long r9) {
        return startHarWifiScan(101, r7, r9);
    }

    public ConcurrentWifiScanner.RequestHandle startHomeCompanyScan(int r9, long r10, long r12, boolean r14) {
        return startHomeCompanyScan(r9, r10, r12, r14, !r14);
    }

    public ConcurrentWifiScanner.RequestHandle startHomeCompanyScan(int r9, long r10, long r12, boolean r14, boolean r15) {
        return start(WifiScanRequestSpec.normal(WifiScanAttributionFactory.homeCompany(r9), r10, r12, r14, r15, new $$Lambda$WifiSceneScanController$QWA23ZvztiAoV4BHahsWw47S94(this)));
    }
}
