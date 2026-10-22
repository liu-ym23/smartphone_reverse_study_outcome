package com.obric.cae.userAware.Garage;

import android.content.Context;
import com.google.protobuf.InvalidProtocolBufferException;
import com.obric.cae.location.cell.g;
import com.obric.cae.log.a;
import com.obric.cae.userAware.Garage.proto.GarageApScanResultRequest;
import com.obric.cae.userAware.Garage.proto.GarageApScanStatus;
import com.obric.cae.userAware.Garage.proto.GarageDetectEvent;
import com.obric.cae.userAware.Garage.proto.GarageReportReason;
import com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequest;
import com.obric.cae.userAware.Garage.proto.GarageTelemetryChunk;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import vendor.aware.sensorbridge.SensorBridgeEvent;
import vendor.aware.sensorbridge.SensorBridgeSensor;

/* JADX INFO: loaded from: classes3.dex */
public final class GarageOwnerManager implements SensorBridgeClient.Listener {
    private static final long BLE_WINDOW_MS = 2000;
    private static final long GARAGE_SUID_HIGH = 1172175556004884884L;
    private static final long GARAGE_SUID_LOW = -4880977503479293329L;
    private static final long GNSS_TIMEOUT_MS = 5000;
    private static final int MAX_RUNTIME_SEND_ATTEMPTS = 3;
    private static final int MSG_AP_SCAN_RESULT = 602;
    private static final int MSG_GARAGE_EVENT = 1024;
    private static final int MSG_GARAGE_TELEMETRY = 1026;
    private static final int MSG_RUNTIME_STATE = 604;
    private static final long RUNTIME_ACK_TIMEOUT_MS = 2000;
    private static final int RUNTIME_PROTOCOL_VERSION = 1;
    private static final int SCAN_MASK_BLE = 2;
    private static final int SCAN_MASK_GNSS = 4;
    private static final String SENSOR_NAME = "garage_detect";
    private static final String TAG = "GarageOwnerManager";
    private int mActiveScanId;
    private GarageBleScanner.Result mBleResult;
    private final GarageBleScanner mBleScanner;
    private final SensorBridgeClient mBridgeClient;
    private final GarageCapabilityMonitor mCapabilityMonitor;
    private GarageCapabilityMonitor.Snapshot mDesiredRuntime;
    private final ScheduledExecutorService mExecutor;
    private final GarageGnssCollector mGnssCollector;
    private GarageGnssCollector.Result mGnssResult;
    private int mNextRuntimeRequestId;
    private int mRespondedScanId;
    private boolean mRuntimeAckPending;
    private int mRuntimeSendAttempts;
    private volatile boolean mStarted;
    private boolean mSubscriptionReady;
    private final GarageTelemetryReassembler mTelemetryReassembler;

    public GarageOwnerManager(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        ScheduledExecutorService r0 = Executors.newSingleThreadScheduledExecutor($$Lambda$GarageOwnerManager$pdobMvCCTr64P9wQTeXXIeXpbs.INSTANCE);
        this.mExecutor = r0;
        this.mTelemetryReassembler = new GarageTelemetryReassembler();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r6, "context"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        r6 = r1;
    L5:
        this.mBleScanner = new GarageBleScanner(r6, r0);
        this.mGnssCollector = new GarageGnssCollector(r6, r0);
        this.mBridgeClient = new SensorBridgeClient(r6, this);
        this.mCapabilityMonitor = new GarageCapabilityMonitor(r6, r0, new $$Lambda$GarageOwnerManager$efQvgzooSWADBvFoWxVeQAjvjjU(this));
    }

    private void cancelActiveScan() {
        int r0 = this.mActiveScanId;
        if (r0 == 0) goto L5;
        this.mBleScanner.cancel(r0);
        this.mGnssCollector.cancel(r0);
    L5:
        this.mActiveScanId = 0;
        this.mRespondedScanId = 0;
        this.mBleResult = null;
        this.mGnssResult = null;
    }

    private static GarageBleScanner.Result emptyBle(int r14, GarageApScanStatus r15) {
        return new GarageBleScanner.Result(r14, r15, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    private static GarageGnssCollector.Result emptyGnss(int r9, GarageApScanStatus r10) {
        return new GarageGnssCollector.Result(r9, r10, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    private void handleCapabilitySnapshot(GarageCapabilityMonitor.Snapshot r2) {
        if (this.mStarted == false) goto L11;
        if (r2 == null) goto L12;
        this.mDesiredRuntime = r2;
        this.mRuntimeAckPending = false;
        this.mRuntimeSendAttempts = 0;
        if (r2.enabled == true) goto L9;
        cancelActiveScan();
        this.mTelemetryReassembler.clear();
    L9:
        sendDesiredRuntimeState();
        return;
    L12:
        return;
    }

    private void handleCompletion(GarageDetectEvent r3) {
        int r0 = r3.getScanId();
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = r3.getRequestedScanMask() & 6;
        if (r1 != 0) goto L8;
        return;
    L8:
        if ((r3.getCompletedScanMask() & r1) == r1) goto L10;
        return;
    L10:
        if (r0 != this.mActiveScanId) goto L13;
        cancelActiveScan();
        return;
    L13:
        if (r0 != this.mRespondedScanId) goto L19;
        this.mRespondedScanId = 0;
        return;
    }

    private void handleEvents(SensorBridgeEvent[] r8) {
        int r1 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L33;
        SensorBridgeEvent r3 = r8[r2];
        if (isExpectedSensorEvent(r3) == false) goto L32;
        int r4 = r3.messageId;     // Catch: RuntimeException -> L28 InvalidProtocolBufferException -> L30
        if (r4 != MSG_GARAGE_TELEMETRY) goto L18;
        GarageCapabilityMonitor.Snapshot r5 = this.mDesiredRuntime;     // Catch: RuntimeException -> L28 InvalidProtocolBufferException -> L30
        if (r5 == null) goto L32;
        if (r5.enabled == false) goto L32;
        GarageTelemetryReassembler.Result r6 = this.mTelemetryReassembler.accept(GarageTelemetryChunk.parseFrom(r3.payload));     // Catch: RuntimeException -> L28 InvalidProtocolBufferException -> L30
        if (r6 == null) goto L32;
        GarageTelemetryDispatcher.report(r6.header, r6.payload);     // Catch: RuntimeException -> L28 InvalidProtocolBufferException -> L30
        goto L32
    L18:
        if (r4 != 1024) goto L32;
        GarageDetectEvent r7 = GarageDetectEvent.parseFrom(r3.payload);     // Catch: RuntimeException -> L28 InvalidProtocolBufferException -> L30
        if (r7.getReason() != GarageReportReason.GARAGE_REPORT_REASON_RUNTIME_STATE_CHANGED) goto L23;
        handleRuntimeStateEvent(r7);     // Catch: RuntimeException -> L28 InvalidProtocolBufferException -> L30
        goto L32
    L23:
        a.e(TAG, "garage event id=" + r7.getScanId() + " reason=" + r7.getReason().getNumber() + " requested=0x" + Integer.toHexString(r7.getRequestedScanMask()) + " completed=0x" + Integer.toHexString(r7.getCompletedScanMask()));     // Catch: RuntimeException -> L28 InvalidProtocolBufferException -> L30
        if (r7.getReason() != GarageReportReason.GARAGE_REPORT_REASON_TRIGGERED) goto L26;
        handleTrigger(r7);     // Catch: RuntimeException -> L28 InvalidProtocolBufferException -> L30
    L26:
        handleCompletion(r7);     // Catch: RuntimeException -> L28 InvalidProtocolBufferException -> L30
        goto L32
    L30:
        e = move-exception;
        a.a(TAG, "invalid garage payload messageId=" + r3.messageId, e);
    L28:
        e = move-exception;
        a.a(TAG, "garage event processing failed", e);
    L32:
        r2 = r2 + 1;
        goto L3
    }

    private void handleRuntimeStateEvent(GarageDetectEvent r4) {
        if (r4.hasRuntimeEnabled() == true) goto L5;
    L23:
        a.i(TAG, "invalid runtime state event");
        return;
    L5:
        if (r4.hasRuntimeRequestId() == false) goto L23;
        if (this.mDesiredRuntime == null) goto L23;
        if (r4.getRuntimeRequestId() == this.mNextRuntimeRequestId) goto L12;
        return;
    L12:
        this.mRuntimeAckPending = false;
        if (r4.getRuntimeEnabled() != this.mDesiredRuntime.enabled) goto L17;
        this.mRuntimeSendAttempts = 0;
        return;
    L17:
        if (this.mRuntimeSendAttempts >= 3) goto L21;
        final int r5 = this.mNextRuntimeRequestId;
        this.mRuntimeAckPending = true;
        this.mExecutor.schedule(new $$Lambda$GarageOwnerManager$9VvHo8ZdxWGn2wEF34ruxmodjy4(this, r5), 1, TimeUnit.SECONDS);     // Catch: RejectedExecutionException -> L25
        return;
    L29:
        return;
    L21:
        a.i(TAG, "runtime state mismatch after max send attempts");
    }

    private void handleTrigger(GarageDetectEvent r6) {
        int r0 = r6.getScanId();
        int r1 = r6.getRequestedScanMask();
        int r7 = r6.getCompletedScanMask();
        int r2 = r1 & 6;
        GarageCapabilityMonitor.Snapshot r3 = this.mDesiredRuntime;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.enabled == false) goto L37;
        if (r0 == 0) goto L38;
        if (r2 != 0) goto L9;
        return;
    L9:
        if ((r7 & r2) == 0) goto L11;
        return;
    L11:
        if (r0 == this.mRespondedScanId) goto L41;
        int r8 = this.mActiveScanId;
        if (r0 == r8) goto L42;
        if (r8 == 0) goto L18;
        a.g(TAG, "reject overlapping AP scan active=" + this.mActiveScanId + " new=" + r0);
        return;
    L18:
        this.mActiveScanId = r0;
        int r9 = r2 & 2;
        GarageGnssCollector.Result r4 = null;
        if (r9 != 0) goto L21;
        GarageBleScanner.Result r5 = emptyBle(r0, GarageApScanStatus.GARAGE_AP_SCAN_STATUS_CANCELLED);
    L22:
        this.mBleResult = r5;
        int r10 = r2 & 4;
        if (r10 != 0) goto L25;
        r4 = emptyGnss(r0, GarageApScanStatus.GARAGE_AP_SCAN_STATUS_CANCELLED);
    L25:
        this.mGnssResult = r4;
        if (r9 != 0) goto L28;
    L30:
        if (r10 != 0) goto L32;
    L34:
        sendResultIfReady();
        return;
    L32:
        if (this.mGnssCollector.start(r0, 5000, new $$Lambda$GarageOwnerManager$Kq4kgIVCGjX1z4usq6j_Sm823M8(this)) == true) goto L34;
        this.mGnssResult = emptyGnss(r0, GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SCAN_FAILED);
        goto L34
    L28:
        if (this.mBleScanner.start(r0, 2000, new $$Lambda$GarageOwnerManager$q2HHO40D_RegM_pUrrVajSUNUw(this)) == true) goto L30;
        this.mBleResult = emptyBle(r0, GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SCAN_FAILED);
        goto L30
    L21:
        r5 = null;
        goto L22
    L42:
        return;
    L41:
        return;
    L38:
        return;
    }

    private boolean isExpectedSensorEvent(SensorBridgeEvent r5) {
        if (r5 != null) goto L4;
        SensorBridgeSensor r4 = null;
    L5:
        if (r5 != null) goto L7;
    L16:
        return false;
    L7:
        if (r5.payload == null) goto L16;
        if (r4 == null) goto L16;
        if (SENSOR_NAME.equals(r4.sensorName) == false) goto L16;
        if (r4.suidLow != GARAGE_SUID_LOW) goto L16;
        if (r4.suidHigh != GARAGE_SUID_HIGH) goto L16;
        return true;
    L4:
        r4 = r5.sensor;
        goto L5
    }

    static /* synthetic */ Thread lambda$new$0(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "GarageOwner");
        r0.setDaemon(true);
        return r0;
    }

    private void onBleResult(GarageBleScanner.Result r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.scanId == this.mActiveScanId) goto L6;
        return;
    L6:
        if (this.mBleResult != null) goto L12;
        this.mBleResult = r3;
        sendResultIfReady();
        return;
    }

    private void onGnssResult(GarageGnssCollector.Result r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.scanId == this.mActiveScanId) goto L6;
        return;
    L6:
        if (this.mGnssResult != null) goto L12;
        this.mGnssResult = r3;
        sendResultIfReady();
        return;
    }

    private void post(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (this.mStarted == true) goto L8;
        return;
    L8:
        this.mExecutor.execute(r4);     // Catch: RejectedExecutionException -> L7
        return;
    }

    private void sendDesiredRuntimeState() {
        GarageCapabilityMonitor.Snapshot r0 = this.mDesiredRuntime;
        if (this.mStarted == true) goto L5;
        return;
    L5:
        if (this.mSubscriptionReady == false) goto L11;
        if (r0 == null) goto L12;
        sendRuntimeState(r0, true);
        return;
    L12:
        return;
    }

    private void sendResultIfReady() {
        int r0 = this.mActiveScanId;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (this.mBleResult != null) goto L7;
        return;
    L7:
        if (this.mGnssResult == null) goto L13;
        GarageApScanResultRequest r1 = GarageApScanResultRequest.newBuilder().setScanId(r0).setBleStatus(this.mBleResult.status).setBtDensityBucket(this.mBleResult.densityBucket).setBtRssiMean(this.mBleResult.rssiMean).setBtRssiStd(this.mBleResult.rssiStd).setBtStrongM80Fraction(this.mBleResult.strongM80Fraction).setBtHasUuidFraction(this.mBleResult.hasUuidFraction).setBtDevicetype2Fraction(this.mBleResult.deviceType2Fraction).setBtDevicetype3Fraction(this.mBleResult.deviceType3Fraction).setBtDevclassMajor0Fraction(this.mBleResult.deviceClassMajor0Fraction).setBtDevclassMajor5Fraction(this.mBleResult.deviceClassMajor5Fraction).setGnssStatus(this.mGnssResult.status).setGnssSvCount(this.mGnssResult.svCount).setGnssMeanCn0(this.mGnssResult.meanCn0).setGnssTop4Cn0(this.mGnssResult.top4Cn0).setGnssUsedSvCount(this.mGnssResult.usedSvCount).setGnssUsedFraction(this.mGnssResult.usedFraction).setBleValidUniqueCount(this.mBleResult.validUniqueCount).build();
        this.mBridgeClient.sendRequest(SENSOR_NAME, 602, r1.toByteArray(), r0);
        this.mRespondedScanId = r0;
        this.mActiveScanId = 0;
        this.mBleResult = null;
        this.mGnssResult = null;
        return;
    }

    private void sendRuntimeState(GarageCapabilityMonitor.Snapshot r6, boolean r7) {
        this.mRuntimeSendAttempts++;
        int r0 = this.mNextRuntimeRequestId + 1;
        this.mNextRuntimeRequestId = r0;
        if (r0 > 0) goto L5;
        this.mNextRuntimeRequestId = 1;
    L5:
        GarageRuntimeStateRequest r1 = GarageRuntimeStateRequest.newBuilder().setVersion(1).setEnabled(r6.enabled).setCapabilityMask(r6.capabilityMask).setRequestId(this.mNextRuntimeRequestId).build();
        g.a(new StringBuilder("send runtime state enabled=").append(r6.enabled).append(" mask=0x").append(Integer.toHexString(r6.capabilityMask)).append(" requestId="), this.mNextRuntimeRequestId, TAG);
        this.mBridgeClient.sendRequest(SENSOR_NAME, 604, r1.toByteArray(), this.mNextRuntimeRequestId);
        if (r7 == true) goto L8;
        return;
    L8:
        this.mRuntimeAckPending = true;
        final int r8 = this.mNextRuntimeRequestId;
        this.mExecutor.schedule(new $$Lambda$GarageOwnerManager$e6bvUsiWhtWmRRaHcoIXvh5aHM(this, r8), 2000, TimeUnit.MILLISECONDS);     // Catch: RejectedExecutionException -> L11
        return;
    }

    public /* synthetic */ void lambda$handleRuntimeStateEvent$8$GarageOwnerManager(int r2) {
        if (this.mStarted == true) goto L5;
        return;
    L5:
        if (this.mRuntimeAckPending == true) goto L7;
        return;
    L7:
        if (r2 != this.mNextRuntimeRequestId) goto L13;
        this.mRuntimeAckPending = false;
        sendDesiredRuntimeState();
        return;
    }

    public /* synthetic */ void lambda$handleTrigger$10$GarageOwnerManager(final GarageBleScanner.Result r2) {
        post(new $$Lambda$GarageOwnerManager$2B8xNOiFS1NxjgiZuV32LCKljs(this, r2));
    }

    public /* synthetic */ void lambda$handleTrigger$11$GarageOwnerManager(GarageGnssCollector.Result r1) {
        onGnssResult(r1);
    }

    public /* synthetic */ void lambda$handleTrigger$12$GarageOwnerManager(final GarageGnssCollector.Result r2) {
        post(new $$Lambda$GarageOwnerManager$GPIHasgZcw0EMNKUP0CIkgpEng(this, r2));
    }

    public /* synthetic */ void lambda$handleTrigger$9$GarageOwnerManager(GarageBleScanner.Result r1) {
        onBleResult(r1);
    }

    public /* synthetic */ void lambda$new$1$GarageOwnerManager(GarageCapabilityMonitor.Snapshot r1) {
        handleCapabilitySnapshot(r1);
    }

    public /* synthetic */ void lambda$onConnected$3$GarageOwnerManager() {
        this.mSubscriptionReady = false;
    }

    public /* synthetic */ void lambda$onDisconnected$5$GarageOwnerManager() {
        a.g(TAG, "sensorbridge disconnected");
        this.mSubscriptionReady = false;
        this.mRuntimeAckPending = false;
        cancelActiveScan();
        this.mTelemetryReassembler.clear();
    }

    public /* synthetic */ void lambda$onEvents$6$GarageOwnerManager(SensorBridgeEvent[] r1) {
        handleEvents(r1);
    }

    public /* synthetic */ void lambda$onSubscribed$4$GarageOwnerManager() {
        this.mSubscriptionReady = true;
        this.mRuntimeAckPending = false;
        this.mRuntimeSendAttempts = 0;
        sendDesiredRuntimeState();
    }

    public /* synthetic */ void lambda$sendRuntimeState$7$GarageOwnerManager(int r2) {
        if (this.mStarted == true) goto L5;
        return;
    L5:
        if (this.mRuntimeAckPending == true) goto L7;
        return;
    L7:
        if (r2 != this.mNextRuntimeRequestId) goto L17;
        this.mRuntimeAckPending = false;
        if (this.mRuntimeSendAttempts >= 3) goto L12;
        sendDesiredRuntimeState();
        return;
    L12:
        a.i(TAG, "runtime state ACK timed out");
        return;
    }

    public /* synthetic */ void lambda$stop$2$GarageOwnerManager() {
        sendRuntimeState(new GarageCapabilityMonitor.Snapshot(0), false);
        cancelActiveScan();
        this.mTelemetryReassembler.clear();
        this.mBridgeClient.stop();
        this.mExecutor.shutdown();
    }

    @Override // com.obric.cae.userAware.Garage.SensorBridgeClient.Listener
    public void onConnected() {
        a.e(TAG, "sensorbridge connected");
        post(new $$Lambda$GarageOwnerManager$FyAUsrxR0ky4sfuY4XSylJxdU(this));
        this.mBridgeClient.subscribe(SENSOR_NAME, new int[]{1024, MSG_GARAGE_TELEMETRY});
    }

    @Override // com.obric.cae.userAware.Garage.SensorBridgeClient.Listener
    public void onDisconnected() {
        post(new $$Lambda$GarageOwnerManager$dcrvZbL0n0qwnnqkl0qcDlFb9_8(this));
    }

    @Override // com.obric.cae.userAware.Garage.SensorBridgeClient.Listener
    public void onError(String r1, Throwable r2) {
        if (r2 != null) goto L5;
        a.g(TAG, r1);
        return;
    L5:
        a.a(TAG, r1, r2);
    }

    @Override // com.obric.cae.userAware.Garage.SensorBridgeClient.Listener
    public void onEvents(final SensorBridgeEvent[] r2) {
        if (r2 == null) goto L5;
        post(new $$Lambda$GarageOwnerManager$CPKNibJRVa95IVRuWSxv9k4wE8(this, r2));
        return;
    }

    @Override // com.obric.cae.userAware.Garage.SensorBridgeClient.Listener
    public void onSubscribed() {
        post(new $$Lambda$GarageOwnerManager$TZ_AxHZey7MOCNvIMPivZ9M6JhI(this));
    }

    public synchronized void start() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.mStarted = true;     // Catch: Throwable -> L11
        this.mCapabilityMonitor.start();     // Catch: Throwable -> L11
        ScheduledExecutorService r1 = this.mExecutor;     // Catch: Throwable -> L11
        final GarageTelemetryReassembler r0 = this.mTelemetryReassembler;     // Catch: Throwable -> L11
        Objects.requireNonNull(r0);     // Catch: Throwable -> L11
        r1.scheduleWithFixedDelay(new $$Lambda$0XXG5qR0GbVRewk6hXY7MetnzzE(r0), 30000, 30000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L11
        this.mBridgeClient.start();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public synchronized void stop() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.mStarted = false;     // Catch: Throwable -> L14
        this.mCapabilityMonitor.stop();     // Catch: Throwable -> L14
        this.mExecutor.execute(new $$Lambda$GarageOwnerManager$rREROwhMkGoAb7Zxn1uw6uRqLWk(this));     // Catch: RejectedExecutionException -> L11 Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L11:
        sendRuntimeState(new GarageCapabilityMonitor.Snapshot(0), false);     // Catch: Throwable -> L14
        cancelActiveScan();     // Catch: Throwable -> L14
        this.mTelemetryReassembler.clear();     // Catch: Throwable -> L14
        this.mBridgeClient.stop();     // Catch: Throwable -> L14
        goto L12
    }
}
