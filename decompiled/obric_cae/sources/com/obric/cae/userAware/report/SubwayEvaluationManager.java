package com.obric.cae.userAware.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.libs.nfc.CaeNfcAdapter;
import com.obric.cae.libs.nfc.CaeNfcEventManager;
import com.obric.cae.libs.nfc.CaeNfcTransitEventCallback;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.AlipayActivityMonitor;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SubwayEvaluationManager {
    private static final String TAG = "SubwayEvaluationManager";
    private static final long TIMEOUT_ENTER_MS = 1800000;
    private static SubwayEvaluationManager sInstance;
    private AlipayActivityMonitor.AlipayRidingCodeListener mAlipayListener;
    private Context mContext;
    private InnerAwareInfoCallback mInnerCallback;
    private boolean mIsInitialized;
    private final List<SubwayEvaluationEvent> mPendingEvents;
    private CaeNfcTransitEventCallback mTransitCallback;
    private Handler mWorkerHandler;

    private SubwayEvaluationManager() {
        this.mIsInitialized = false;
        this.mPendingEvents = new CopyOnWriteArrayList();
    }

    public static /* synthetic */ void access$000(SubwayEvaluationManager r8) {
        r8.handleAlipayRidingCodeEvent();
    }

    public static /* synthetic */ void access$100(SubwayEvaluationManager r8, int r10) {
        r8.handleHarStatusChanged(r10);
    }

    public static /* synthetic */ void access$200(SubwayEvaluationManager r8, Bundle r10) {
        r8.handleNfcTransitEvent(r10);
    }

    public static /* synthetic */ void access$300(SubwayEvaluationManager r8, SubwayEvaluationEvent r10) {
        r8.handleTimeout(r10);
    }

    private boolean checkAlipayVerifySuccess(SubwayEvaluationEvent r8, long r10) {
        r8.verifyEventType = "alipay";
        r8.verifyEventTime = r10;
        r8.verifyStatus = "success";
        r8.verifyMethod = "alipay";
        r8.delayMs = Math.abs(r10 - r8.triggerTime);
        completeEvaluation(r8);
        return true;
    }

    private boolean checkHarVerifySuccess(SubwayEvaluationEvent r8, int r10, long r11) {
        if (r10 != 5) goto L6;
        r8.verifyEventType = SubwayEvaluationEvent.VERIFY_EVENT_TYPE_HAR;
        r8.verifyEventTime = r11;
        r8.verifyEventHarState = Integer.valueOf(r10);
        r8.verifyStatus = "success";
        r8.verifyMethod = SubwayEvaluationEvent.VERIFY_METHOD_HAR_SUBWAY;
        r8.delayMs = Math.abs(r11 - r8.triggerTime);
        completeEvaluation(r8);
        return true;
    L6:
        return false;
    }

    private boolean checkNfcVerifySuccess(SubwayEvaluationEvent r8, long r10) {
        r8.verifyEventType = "nfc";
        r8.verifyEventTime = r10;
        r8.verifyStatus = "success";
        r8.verifyMethod = "nfc";
        r8.delayMs = Math.abs(r10 - r8.triggerTime);
        completeEvaluation(r8);
        return true;
    }

    private void completeEvaluation(SubwayEvaluationEvent r8) {
        this.mPendingEvents.remove(r8);
        reportEvaluationResult(r8);
    }

    private Runnable createTimeoutRunnable(final SubwayEvaluationEvent r8) {
        return new AnonymousClass4(this, r8);
    }

    public static synchronized SubwayEvaluationManager getInstance() {
        monitor-enter(SubwayEvaluationManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new SubwayEvaluationManager();     // Catch: Throwable -> L10
    L7:
        SubwayEvaluationManager r8 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(SubwayEvaluationManager.class);
        return r8;
    }

    private void handleAlipayRidingCodeEvent() {
        CaeLog.d(TAG, "Received Alipay riding code event");
        long r8 = System.currentTimeMillis();
        Iterator r10 = new ArrayList(this.mPendingEvents).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        checkAlipayVerifySuccess((SubwayEvaluationEvent) r10.next(), r8);
        goto L4
    }

    private void handleHarStatusChanged(int r8) {
        CaeLog.d(TAG, "HAR status changed: " + r8);
        long r10 = System.currentTimeMillis();
        Iterator r11 = new ArrayList(this.mPendingEvents).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        checkHarVerifySuccess((SubwayEvaluationEvent) r11.next(), r8, r10);
        goto L4
    }

    private void handleNfcTransitEvent(Bundle r8) {
        CaeLog.d(TAG, "Received NFC transit event");
        long r10 = System.currentTimeMillis();
        Iterator r11 = new ArrayList(this.mPendingEvents).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        checkNfcVerifySuccess((SubwayEvaluationEvent) r11.next(), r10);
        goto L4
    }

    private void handleTimeout(SubwayEvaluationEvent r8) {
        if (this.mPendingEvents.contains(r8) == true) goto L6;
        CaeLog.d(TAG, "Event already processed, ignoring timeout");
        return;
    L6:
        CaeLog.d(TAG, "Handling timeout for event: " + r8.eventType);
        r8.verifyStatus = "timeout";
        r8.verifyMethod = SubwayEvaluationEvent.VERIFY_METHOD_NONE;
        completeEvaluation(r8);
    }

    public static boolean isInitialized() {
        return sInstance.mIsInitialized;
    }

    private void registerCallbacks() {
        AlipayActivityMonitor.getInstance().init(this.mContext);
        AlipayActivityMonitor.getInstance().startListening();
        String r8 = TAG;
        CaeLog.d(r8, "AlipayActivityMonitor initialized and started");
        this.mAlipayListener = new AnonymousClass1(this);
        AlipayActivityMonitor.getInstance().registerListener(this.mAlipayListener);
        CaeLog.d(r8, "Alipay listener registered");
        this.mInnerCallback = new AnonymousClass2(this);
        UserAwareManager.getInstance().registerInnerCallback(this.mInnerCallback);
        CaeLog.d(r8, "Inner callback (HAR only) registered");
        CaeNfcAdapter r10 = CaeNfcAdapter.getDefaultAdapter(this.mContext);     // Catch: Exception -> L9
        if (r10 == null) goto L14;
        CaeNfcEventManager r11 = r10.getEventManager();     // Catch: Exception -> L9
        if (r11 == null) goto L15;
        r11.setTransitEventSource(2);     // Catch: Exception -> L9
        r11.setTransitEventAllowedAidTypes(2);     // Catch: Exception -> L9
        CaeNfcTransitEventCallback r12 = new AnonymousClass3(this);     // Catch: Exception -> L9
        this.mTransitCallback = r12;     // Catch: Exception -> L9
        r11.registerTransitCallback(r12);     // Catch: Exception -> L9
        CaeLog.d(r8, "NFC transit callback registered");     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        CaeLog.e(TAG, "Failed to register NFC transit callback", e);
    }

    private void reportEvaluationResult(SubwayEvaluationEvent r8) {
        String r10 = TAG;     // Catch: Exception -> L5
        CaeLog.d(r10, "Reporting evaluation result: " + r8.toJSON().toString());     // Catch: Exception -> L5
        ByteIOUtils.trackEvent("subway_evaluation", r8.toJSON());     // Catch: Exception -> L5
        CaeLog.d(r10, "Evaluation result reported successfully");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "Failed to report evaluation result", e);
    }

    private void unregisterCallbacks() {
        if (this.mAlipayListener == null) goto L5;
        AlipayActivityMonitor.getInstance().unregisterListener(this.mAlipayListener);
        this.mAlipayListener = null;
        CaeLog.d(TAG, "Alipay listener unregistered");
    L5:
        AlipayActivityMonitor.getInstance().stopListening();
        String r8 = TAG;
        CaeLog.d(r8, "AlipayActivityMonitor stopped");
        if (this.mInnerCallback == null) goto L19;
        UserAwareManager.getInstance().unregisterInnerCallback(this.mInnerCallback);
        this.mInnerCallback = null;
        CaeLog.d(r8, "Inner callback unregistered");
    L19:
        CaeNfcAdapter r10 = CaeNfcAdapter.getDefaultAdapter(this.mContext);     // Catch: Exception -> L16
        if (r10 != null) goto L11;
        return;
    L11:
        if (this.mTransitCallback == null) goto L22;
        CaeNfcEventManager r11 = r10.getEventManager();     // Catch: Exception -> L16
        if (r11 == null) goto L23;
        r11.unregisterTransitCallback(this.mTransitCallback);     // Catch: Exception -> L16
        this.mTransitCallback = null;     // Catch: Exception -> L16
        CaeLog.d(r8, "NFC transit callback unregistered");     // Catch: Exception -> L16
        return;
    L23:
        return;
    L22:
        return;
    L16:
        e = move-exception;
        CaeLog.e(TAG, "Failed to unregister NFC transit callback", e);
    }

    public synchronized void init(Context r8, Handler r10) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsInitialized == false) goto L8;
        CaeLog.d(TAG, "Already initialized");     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L8:
        this.mContext = r8.getApplicationContext();     // Catch: Throwable -> L15
        if (r10 != null) goto L12;
        r10 = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L15
    L12:
        this.mWorkerHandler = r10;     // Catch: Throwable -> L15
        registerCallbacks();     // Catch: Throwable -> L15
        this.mIsInitialized = true;     // Catch: Throwable -> L15
        CaeLog.d(TAG, "Initialized");     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    public void onSubwayEvaluationEvent(boolean r10, float r11, String r12, long r13, int r14, int r15, float r16, float r17, int r18, boolean r19, String r20) {
        if (this.mIsInitialized == true) goto L6;
        CaeLog.w(TAG, "Not initialized, ignoring subway event");
        return;
    L6:
        if (r10 == true) goto L9;
        CaeLog.d(TAG, "Ignoring exit subway event");
        return;
    L9:
        long r8 = System.currentTimeMillis();
        String r21 = TAG;
        CaeLog.d(r21, "onSubwayEvaluationEvent: isEnter=" + r10 + ", stationName=" + r12);
        SubwayEvaluationEvent r22 = new SubwayEvaluationEvent(SubwayEvaluationEvent.EVENT_TYPE_ENTER, r8);
        r22.confidenceScore = r11;
        r22.stationName = r12;
        r22.cellId = r13;
        r22.rat = r14;
        r22.tac = r15;
        r22.windowSeconds = 1800;
        r22.pressure = r16;
        r22.light = r17;
        r22.harState = r18;
        r22.wifiConnected = r19;
        r22.locationState = MatrixDidUtils.getDid(this.mContext);
        this.mPendingEvents.add(r22);
        this.mWorkerHandler.postDelayed(createTimeoutRunnable(r22), TIMEOUT_ENTER_MS);
        CaeLog.d(r21, "Created evaluation event, timeout in 1800000ms, pending size: " + this.mPendingEvents.size());
    }

    public synchronized void release() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsInitialized == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        unregisterCallbacks();     // Catch: Throwable -> L13
        Handler r8 = this.mWorkerHandler;     // Catch: Throwable -> L13
        if (r8 == null) goto L10;
        r8.removeCallbacksAndMessages(null);     // Catch: Throwable -> L13
    L10:
        this.mPendingEvents.clear();     // Catch: Throwable -> L13
        this.mIsInitialized = false;     // Catch: Throwable -> L13
        CaeLog.d(TAG, "Released");     // Catch: Throwable -> L13
        monitor-exit(this);
    }
}
