package com.qti.extphone;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import android.util.Log;
import defpackage.a;
import defpackage.b;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ExtPhoneCallbackListener {
    private static final boolean DBG = true;
    public static final int EVENT_ALL = 0;
    public static final int EVENT_GET_FACILITY_LOCK_FOR_APP_RESPONSE = 1;
    public static final int EVENT_GET_NETWORK_SELECTION_MODE_RESPONSE = 2;
    public static final int EVENT_GET_QOS_PARAMETERS_RESPONSE = 3;
    public static final int EVENT_GET_QTIRADIO_CAPABILITY_RESPONSE = 4;
    public static final int EVENT_GET_SECURE_MODE_STATUS_RESPONSE = 5;
    public static final int EVENT_NETWORK_SCAN_RESULT = 6;
    public static final int EVENT_ON_5G_CONFIG_INFO = 7;
    public static final int EVENT_ON_5G_STATUS = 8;
    public static final int EVENT_ON_ANY_NR_BEARER_ALLOCATION = 9;
    public static final int EVENT_ON_CIWLAN_AVAILABLE = 48;
    public static final int EVENT_ON_CIWLAN_CAPABILITY_CHANGE = 38;
    public static final int EVENT_ON_CIWLAN_CONFIG_CHANGE = 50;
    public static final int EVENT_ON_DATA_DEACTIVATE_DELAY_TIME = 10;
    public static final int EVENT_ON_DDS_SWITCH_CAPABILITY_CHANGE = 11;
    public static final int EVENT_ON_DDS_SWITCH_CONFIG_CAPABILITY_CHANGED = 43;
    public static final int EVENT_ON_DDS_SWITCH_CONFIG_CRITERIA_CHANGED = 44;
    public static final int EVENT_ON_DDS_SWITCH_CONFIG_RECOMMENDATION = 45;
    public static final int EVENT_ON_DDS_SWITCH_CRITERIA_CHANGE = 12;
    public static final int EVENT_ON_DDS_SWITCH_RECOMMENDATION = 13;
    public static final int EVENT_ON_DIAG_INFO = 101;
    public static final int EVENT_ON_DISABLE_ENDC = 100;
    public static final int EVENT_ON_DUAL_DATA_CAPABILITY_CHANGED = 39;
    public static final int EVENT_ON_DUAL_DATA_RECOMMENDATION = 41;
    public static final int EVENT_ON_ENABLE_ENDC = 14;
    public static final int EVENT_ON_ENDC_STATUS = 15;
    public static final int EVENT_ON_EPDG_OVER_CELLULAR_DATA_SUPPORTED = 16;
    public static final int EVENT_ON_GET_DIAG_INFO = 102;
    public static final int EVENT_ON_IMEI_TYPE_CHANGED = 17;
    public static final int EVENT_ON_LOCK_LTE_BAND = 202;
    public static final int EVENT_ON_LOCK_LTE_CELL = 200;
    public static final int EVENT_ON_LOCK_NR_BAND = 203;
    public static final int EVENT_ON_LOCK_NR_CELL = 201;
    public static final int EVENT_ON_NR_CONFIG_STATUS = 18;
    public static final int EVENT_ON_NR_DC_PARAM = 19;
    public static final int EVENT_ON_NR_ICON_CHANGE = 51;
    public static final int EVENT_ON_NR_ICON_TYPE = 20;
    public static final int EVENT_ON_QOS_PARAMETERS_CHANGED = 21;
    public static final int EVENT_ON_SECURE_MODE_STATUS_CHANGE = 22;
    public static final int EVENT_ON_SEND_USER_PREFERENCE_CONFIG_FOR_DATA_DURING_CALL = 46;
    public static final int EVENT_ON_SEND_USER_PREFERENCE_FOR_DATA_DURING_VOICE_CALL = 23;
    public static final int EVENT_ON_SET_NR_CONFIG = 24;
    public static final int EVENT_ON_SIGNAL_STRENGTH = 25;
    public static final int EVENT_ON_SIM_PERSO_UNLOCK_STATUS_CHANGE = 42;
    public static final int EVENT_ON_SIM_TYPE_CHANGED = 26;
    public static final int EVENT_ON_UPPER_LAYER_IND_INFO = 27;
    public static final int EVENT_QUERY_CALL_FORWARD_STATUS_RESPONSE = 28;
    public static final int EVENT_QUERY_NR_ICON_RESPONSE = 52;
    public static final int EVENT_SEND_CDMA_SMS_RESPONSE = 29;
    public static final int EVENT_SET_CARRIER_INFO_FOR_IMSI_ENCRYPTION_RESPONSE = 30;
    public static final int EVENT_SET_CELLULAR_ROAMING_PREFERENCE_RESPONSE = 47;
    public static final int EVENT_SET_CIWLAN_MODE_USER_PREFERENCE_RESPONSE = 49;
    public static final int EVENT_SET_DUAL_DATA_USER_PREFERENCE_RESPONSE = 40;
    public static final int EVENT_SET_MSIM_PREFERENCE_RESPONSE = 31;
    public static final int EVENT_SET_NETWORK_SELECTION_MODE_AUTOMATIC_RESPONSE = 32;
    public static final int EVENT_SET_NETWORK_SELECTION_MODE_MANUAL_RESPONSE = 33;
    public static final int EVENT_SET_SIM_TYPE_RESPONSE = 34;
    public static final int EVENT_SET_SMART_DDS_SWITCH_TOGGLE_RESPONSE = 35;
    public static final int EVENT_START_NETWORK_SCAN_RESPONSE = 36;
    public static final int EVENT_STOP_NETWORK_SCAN_RESPONSE = 37;
    private static final int SUCCESS = 0;
    private static final String TAG = "ExtPhoneCallbackListener";
    private static final int UNUSED_ARGUMENT = 0;
    private static final int UNUSED_SLOT_ID = -1;
    private static HandlerThread sHandlerThread;
    private static Object sLock;
    IExtPhoneCallback mCallback;
    private Handler mHandler;
    private Looper mLooper;

    public static class IExtPhoneCallbackStub extends IExtPhoneCallback.Stub {
        private WeakReference<ExtPhoneCallbackListener> mExtPhoneCallbackListenerWeakRef;

        public class Result {
            Object mData;
            int mError;
            int mSlotId;
            Status mStatus;
            Token mToken;
            final /* synthetic */ IExtPhoneCallbackStub this$0;

            public Result(IExtPhoneCallbackStub r8, int r10, Token r11, Status r12, int r13, Object r14) {
                this.this$0 = r8;
                this.mSlotId = r10;
                this.mToken = r11;
                this.mStatus = r12;
                this.mError = r13;
                this.mData = r14;
            }

            public String toString() {
                return "Result{mSlotId=" + this.mSlotId + ", mToken=" + this.mToken + ", mStatus=" + this.mStatus + ", mError=" + this.mError + ", mData=" + this.mData + "}";
            }
        }

        public IExtPhoneCallbackStub(ExtPhoneCallbackListener r8) {
            this.mExtPhoneCallbackListenerWeakRef = new WeakReference(r8);
        }

        private void send(int r8, int r10, int r11, Object r12) {
            ExtPhoneCallbackListener r13 = this.mExtPhoneCallbackListenerWeakRef.get();
            if (r13 == null) goto L5;
            Message.obtain(ExtPhoneCallbackListener.a(r13), r8, r10, r11, r12).sendToTarget();
            return;
        L5:
            Log.d(ExtPhoneCallbackListener.TAG, " listener is null");
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void getFacilityLockForAppResponse(Status r10, int[] r11) {
            send(1, 0, 0, new Result(this, 0, null, r10, 0, r11));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void getNetworkSelectionModeResponse(int r10, Token r11, Status r12, NetworkSelectionMode r13) {
            send(2, 0, 0, new Result(this, r10, r11, r12, 0, r13));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void getQosParametersResponse(int r10, Token r11, Status r12, QosParametersResult r13) {
            send(3, 0, 0, new Result(this, r10, r11, r12, 0, r13));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void getQtiRadioCapabilityResponse(int r10, Token r11, Status r12, int r13) {
            send(4, 0, 0, new Result(this, r10, r11, r12, 0, Integer.valueOf(r13)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void getSecureModeStatusResponse(Token r10, Status r11, boolean r12) {
            send(5, 0, 0, new Result(this, 0, r10, r11, 0, Boolean.valueOf(r12)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void networkScanResult(int r10, Token r11, int r12, int r13, List<CellInfo> r14) {
            send(6, 0, 0, new Result(this, r10, r11, new Status(r12), r13, r14));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void on5gConfigInfo(int r10, Token r11, Status r12, NrConfigType r13) {
            send(7, 0, 0, new Result(this, r10, r11, r12, 0, r13));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void on5gStatus(int r10, Token r11, Status r12, boolean r13) {
            send(8, 0, 0, new Result(this, r10, r11, r12, 0, Boolean.valueOf(r13)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onAnyNrBearerAllocation(int r10, Token r11, Status r12, BearerAllocationStatus r13) {
            send(9, 0, 0, new Result(this, r10, r11, r12, 0, r13));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onCiwlanAvailable(int r10, boolean r11) {
            send(48, 0, 0, new Result(this, r10, null, null, -1, Boolean.valueOf(r11)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onCiwlanConfigChange(int r10, CiwlanConfig r11) {
            send(50, 0, 0, new Result(this, r10, null, null, -1, r11));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onDataDeactivateDelayTime(int r10, long r11) {
            send(10, 0, 0, new Result(this, r10, null, null, -1, Long.valueOf(r11)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onDdsSwitchCapabilityChange(int r10, Token r11, Status r12, boolean r13) {
            send(11, 0, 0, new Result(this, r10, r11, r12, 0, Boolean.valueOf(r13)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onDdsSwitchConfigCapabilityChanged(Token r10, Status r11, boolean r12) {
            send(43, 0, 0, new Result(this, -1, r10, r11, 0, Boolean.valueOf(r12)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onDdsSwitchConfigCriteriaChanged(boolean r10) {
            send(44, 0, 0, new Result(this, -1, null, null, 0, Boolean.valueOf(r10)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onDdsSwitchConfigRecommendation(int r10) {
            send(45, 0, 0, new Result(this, -1, null, null, 0, Integer.valueOf(r10)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onDdsSwitchCriteriaChange(int r10, boolean r11) {
            send(12, 0, 0, new Result(this, r10, null, null, -1, Boolean.valueOf(r11)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onDdsSwitchRecommendation(int r10, int r11) {
            send(13, 0, 0, new Result(this, r10, null, null, -1, Integer.valueOf(r11)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onDiagInfoChanged(BdDiagInfo r10) {
            send(101, 0, 0, new Result(this, -1, null, null, 0, r10));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onDisableEndc(int r10, Token r11, Status r12) {
            send(100, 0, 0, new Result(this, r10, r11, r12, 0, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onDualDataCapabilityChanged(Token r10, Status r11, boolean r12) {
            send(39, 0, 0, new Result(this, -1, r10, r11, -1, Boolean.valueOf(r12)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onDualDataRecommendation(DualDataRecommendation r10) {
            send(41, 0, 0, new Result(this, -1, null, null, -1, r10));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onEnableEndc(int r10, Token r11, Status r12) {
            send(14, 0, 0, new Result(this, r10, r11, r12, 0, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onEndcStatus(int r10, Token r11, Status r12, boolean r13) {
            send(15, 0, 0, new Result(this, r10, r11, r12, 0, Boolean.valueOf(r13)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onEpdgOverCellularDataSupported(int r10, boolean r11) {
            send(16, 0, 0, new Result(this, r10, null, null, -1, Boolean.valueOf(r11)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onGetDiagInfoResponse(Token r10, Status r11, BdDiagInfo r12) {
            send(102, 0, 0, new Result(this, -1, r10, r11, 0, r12));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onImeiTypeChanged(QtiImeiInfo[] r10) {
            send(17, 0, 0, new Result(this, -1, null, null, -1, r10));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onLockLteBand(int r10, Token r11, Status r12) {
            send(202, 0, 0, new Result(this, r10, r11, r12, 0, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onLockLteCell(int r10, Token r11, Status r12) {
            send(200, 0, 0, new Result(this, r10, r11, r12, 0, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onLockNrBand(int r10, Token r11, Status r12) {
            send(203, 0, 0, new Result(this, r10, r11, r12, 0, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onLockNrCell(int r10, Token r11, Status r12) {
            send(201, 0, 0, new Result(this, r10, r11, r12, 0, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onNrConfigStatus(int r10, Token r11, Status r12, NrConfig r13) {
            send(18, 0, 0, new Result(this, r10, r11, r12, 0, r13));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onNrDcParam(int r10, Token r11, Status r12, DcParam r13) {
            send(19, 0, 0, new Result(this, r10, r11, r12, 0, r13));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onNrIconChange(int r10, NrIcon r11) {
            send(51, 0, 0, new Result(this, r10, null, null, -1, r11));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onNrIconResponse(int r10, Token r11, Status r12, NrIcon r13) {
            send(52, 0, 0, new Result(this, r10, r11, r12, -1, r13));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onNrIconType(int r10, Token r11, Status r12, NrIconType r13) {
            send(20, 0, 0, new Result(this, r10, r11, r12, 0, r13));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onQosParametersChanged(int r10, int r11, QosParametersResult r12) {
            send(21, 0, 0, new Result(this, r10, null, null, r11, r12));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onSecureModeStatusChange(boolean r10) {
            send(22, 0, 0, new Result(this, -1, null, null, -1, Boolean.valueOf(r10)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onSendUserPreferenceConfigForDataDuringVoiceCall(Token r10, Status r11) {
            send(46, 0, 0, new Result(this, -1, r10, r11, 0, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onSendUserPreferenceForDataDuringVoiceCall(int r10, Token r11, Status r12) {
            send(23, 0, 0, new Result(this, r10, r11, r12, 0, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onSetNrConfig(int r10, Token r11, Status r12) {
            send(24, 0, 0, new Result(this, r10, r11, r12, 0, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onSignalStrength(int r10, Token r11, Status r12, SignalStrength r13) {
            send(25, 0, 0, new Result(this, r10, r11, r12, 0, r13));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onSimPersoUnlockStatusChange(int r10, QtiPersoUnlockStatus r11) {
            send(42, 0, 0, new Result(this, r10, null, null, -1, r11));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onSimTypeChanged(QtiSimType[] r10) {
            send(26, 0, 0, new Result(this, -1, null, null, -1, r10));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onUpperLayerIndInfo(int r10, Token r11, Status r12, UpperLayerIndInfo r13) {
            send(27, 0, 0, new Result(this, r10, r11, r12, 0, r13));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void queryCallForwardStatusResponse(Status r10, QtiCallForwardInfo[] r11) {
            send(28, 0, 0, new Result(this, 0, null, r10, 0, r11));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void sendCdmaSmsResponse(int r10, Token r11, Status r12, SmsResult r13) {
            send(29, 0, 0, new Result(this, r10, r11, r12, 0, r13));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void setCarrierInfoForImsiEncryptionResponse(int r10, Token r11, QRadioResponseInfo r12) {
            send(30, 0, 0, new Result(this, r10, r11, null, 0, r12));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void setCellularRoamingPreferenceResponse(int r10, Token r11, Status r12) {
            send(47, 0, 0, new Result(this, r10, r11, r12, -1, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void setCiwlanModeUserPreferenceResponse(int r10, Token r11, Status r12) {
            send(49, 0, 0, new Result(this, r10, r11, r12, -1, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void setDualDataUserPreferenceResponse(Token r10, Status r11) {
            send(40, 0, 0, new Result(this, -1, r10, r11, -1, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void setMsimPreferenceResponse(Token r10, Status r11) {
            send(31, 0, 0, new Result(this, 0, r10, r11, 0, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void setNetworkSelectionModeAutomaticResponse(int r10, Token r11, int r12) {
            send(32, 0, 0, new Result(this, r10, r11, null, r12, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void setNetworkSelectionModeManualResponse(int r10, Token r11, int r12) {
            send(33, 0, 0, new Result(this, r10, r11, null, r12, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void setSimTypeResponse(Token r10, Status r11) {
            send(34, 0, 0, new Result(this, 0, r10, r11, 0, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void setSmartDdsSwitchToggleResponse(Token r10, boolean r11) {
            send(35, 0, 0, new Result(this, 0, r10, null, 0, Boolean.valueOf(r11)));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void startNetworkScanResponse(int r10, Token r11, int r12) {
            send(36, 0, 0, new Result(this, r10, r11, null, r12, null));
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void stopNetworkScanResponse(int r10, Token r11, int r12) {
            send(37, 0, 0, new Result(this, r10, r11, null, r12, null));
        }
    }

    static {
        sLock = new Object();
    }

    public ExtPhoneCallbackListener() {
        this.mCallback = new IExtPhoneCallbackStub(this);
        this.mLooper = acquireGlobalLooper();
        init();
    }

    public static /* bridge */ /* synthetic */ Handler a(ExtPhoneCallbackListener r8) {
        return r8.mHandler;
    }

    private Looper acquireGlobalLooper() {
        Object r8 = sLock;
        monitor-enter(r8);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sHandlerThread != null) goto L7;
        HandlerThread r10 = new HandlerThread(TAG);     // Catch: Throwable -> L10
        sHandlerThread = r10;     // Catch: Throwable -> L10
        r10.start();     // Catch: Throwable -> L10
    L7:
        Looper r11 = sHandlerThread.getLooper();     // Catch: Throwable -> L10
        monitor-exit(r8);     // Catch: Throwable -> L10
        return r11;
    }

    public static /* bridge */ /* synthetic */ Looper b(ExtPhoneCallbackListener r8) {
        return r8.mLooper;
    }

    private void init() {
        if (this.mLooper != null) goto L5;
        return;
    L5:
        final Looper r8 = this.mLooper;
        this.mHandler = new AnonymousClass1(this, r8);
    }

    private void releaseGlobalLooperUse() {
        Object r8 = sLock;
        monitor-enter(r8);
        HandlerThread r10 = sHandlerThread;     // Catch: Throwable -> L11
        if (r10 != null) goto L7;
    L9:
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L7:
        if (r10.getLooper() != this.mLooper) goto L9;
        this.mLooper = null;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void cleanup() {
        releaseGlobalLooperUse();
    }

    public void getFacilityLockForAppResponse(Status r8, int[] r10) {
        Log.d(TAG, "UNIMPLEMENTED: getFacilityLockForAppResponse: status = " + r8 + " response = " + r10);
    }

    public void getNetworkSelectionModeResponse(int r8, Token r10, Status r11, NetworkSelectionMode r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: getNetworkSelectionModeResponse: slotId = ", r8, " token = ", r10, " status = ");
        r13.append(r11);
        r13.append(" modes = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void getQosParametersResponse(int r8, Token r10, Status r11, QosParametersResult r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: getQosParametersResponse: slotId = ", r8, " token = ", r10, " status");
        r13.append(r11);
        r13.append(" result = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void getQtiRadioCapabilityResponse(int r8, Token r10, Status r11, int r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: getQtiRadioCapabilityResponse: slotId = ", r8, " token = ", r10, " status");
        r13.append(r11);
        r13.append(" raf = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void getSecureModeStatusResponse(Token r8, Status r10, boolean r11) {
        Log.d(TAG, "UNIMPLEMENTED: getSecureModeStatusResponse: token = " + r8 + " status = " + r10 + " enableStatus = " + r11);
    }

    public void networkScanResult(int r8, Token r10, int r11, int r12, List<CellInfo> r13) {
        StringBuilder r14 = b.g("UNIMPLEMENTED: networkScanResult: slotId = ", r8, " token = ", r10, " status = ");
        b.q(r14, r11, " error = ", r12, " cellInfos = ");
        r14.append(r13);
        Log.d(TAG, r14.toString());
    }

    public void on5gConfigInfo(int r8, Token r10, Status r11, NrConfigType r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: on5gConfigInfo: slotId = ", r8, " token = ", r10, " status");
        r13.append(r11);
        r13.append(" NrConfigType = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void on5gStatus(int r8, Token r10, Status r11, boolean r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: on5gStatus: slotId = ", r8, " token = ", r10, " status");
        r13.append(r11);
        r13.append(" enableStatus = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void onAnyNrBearerAllocation(int r8, Token r10, Status r11, BearerAllocationStatus r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onAnyNrBearerAllocation: slotId = ", r8, " token = ", r10, " status = ");
        r13.append(r11);
        r13.append(" bearerStatus = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void onCiwlanAvailable(int r8, boolean r10) {
        Log.d(TAG, "UNIMPLEMENTED: onCiwlanAvailable: slotId = " + r8 + " ciwlanAvailable = " + r10);
    }

    public void onCiwlanConfigChange(int r8, CiwlanConfig r10) {
        Log.d(TAG, "UNIMPLEMENTED: onCiwlanConfigChange: slotId = " + r8 + " CiwlanConfig = " + r10);
    }

    public void onDataDeactivateDelayTime(int r8, long r10) {
        Log.d(TAG, "UNIMPLEMENTED: onDataDeactivateDelayTime: slotId = " + r8 + " delayTimeMilliSecs = " + r10);
    }

    public void onDdsSwitchCapabilityChange(int r8, Token r10, Status r11, boolean r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onDdsSwitchCapabilityChange: slotId = ", r8, " token = ", r10, " status = ");
        r13.append(r11);
        r13.append(" support = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void onDdsSwitchConfigCapabilityChanged(Token r8, Status r10, boolean r11) {
        Log.d(TAG, "UNIMPLEMENTED: onDdsSwitchConfigCapabilityChanged: token = " + r8 + " status = " + r10 + " isCapable = " + r11);
    }

    public void onDdsSwitchConfigCriteriaChanged(boolean r8) {
        Log.d(TAG, "UNIMPLEMENTED: onDdsSwitchConfigCriteriaChanged: telephonyDdsSwitch = " + r8);
    }

    public void onDdsSwitchConfigRecommendation(int r8) {
        Log.d(TAG, "UNIMPLEMENTED: onDdsSwitchConfigRecommendation:  recommendedSlotId = " + r8);
    }

    public void onDdsSwitchCriteriaChange(int r8, boolean r10) {
        Log.d(TAG, "UNIMPLEMENTED: onDdsSwitchCriteriaChange: slotId = " + r8 + " telephonyDdsSwitch = " + r10);
    }

    public void onDdsSwitchRecommendation(int r8, int r10) {
        Log.d(TAG, "UNIMPLEMENTED: onDdsSwitchRecommendation: slotId = " + r8 + " recommendedSlotId = " + r10);
    }

    public void onDiagInfoChanged(BdDiagInfo r8) {
        Log.d(TAG, "UNIMPLEMENTED: onDiagInfoChanged  diagInfo" + r8.toString());
    }

    public void onDisableEndc(int r8, Token r10, Status r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: onEnableEndc: slotId = ", r8, " token = ", r10, " status = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void onDualDataCapabilityChanged(Token r8, Status r10, boolean r11) {
        Log.d(TAG, "UNIMPLEMENTED: onDualDataCapabilityChanged: support = " + r11);
    }

    public void onDualDataRecommendation(DualDataRecommendation r8) {
        Log.d(TAG, "UNIMPLEMENTED: onDualDataRecommendation: rec = " + r8);
    }

    public void onEnableEndc(int r8, Token r10, Status r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: onEnableEndc: slotId = ", r8, " token = ", r10, " status = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void onEndcStatus(int r8, Token r10, Status r11, boolean r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onEndcStatus: slotId = ", r8, " token = ", r10, " status = ");
        r13.append(r11);
        r13.append(" enableStatus = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void onEpdgOverCellularDataSupported(int r8, boolean r10) {
        Log.d(TAG, "UNIMPLEMENTED: onEpdgOverCellularDataSupported: slotId = " + r8 + " support = " + r10);
    }

    public void onGetDiagInfoResponse(Token r8, Status r10, BdDiagInfo r11) {
        Log.d(TAG, "UNIMPLEMENTED: onGetDiagInfoResponse  status = " + r10 + " diagInfo" + r11.toString());
    }

    public void onImeiTypeChanged(QtiImeiInfo[] r8) {
        Log.d(TAG, "UNIMPLEMENTED: onImeiTypeChanged: imeiInfo = " + r8);
    }

    public void onLockLteBand(int r8, Token r10, Status r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: onLockLteBand slotId = ", r8, " token = ", r10, " status = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void onLockLteCell(int r8, Token r10, Status r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: onLockLteCell slotId = ", r8, " token = ", r10, " status = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void onLockNrBand(int r8, Token r10, Status r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: onLockNrBand slotId = ", r8, " token = ", r10, " status = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void onLockNrCell(int r8, Token r10, Status r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: onLockNrCell slotId = ", r8, " token = ", r10, " status = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void onNrConfigStatus(int r8, Token r10, Status r11, NrConfig r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onNrConfigStatus: slotId = ", r8, " token = ", r10, " status = ");
        r13.append(r11);
        r13.append(" NrConfig = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void onNrDcParam(int r8, Token r10, Status r11, DcParam r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onNrDcParam: slotId = ", r8, " token = ", r10, " status");
        r13.append(r11);
        r13.append(" dcParam = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void onNrIconChange(int r8, NrIcon r10) {
        Log.d(TAG, "UNIMPLEMENTED: onNrIconChange: slotId = " + r8 + ", icon = " + r10);
    }

    public void onNrIconResponse(int r8, Token r10, Status r11, NrIcon r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onNrIconResponse: slotId = ", r8, ", token = ", r10, ", status = ");
        r13.append(r11);
        r13.append(", icon = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void onNrIconType(int r8, Token r10, Status r11, NrIconType r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onNrIconType: slotId = ", r8, " token = ", r10, " status = ");
        r13.append(r11);
        r13.append(" NrIconType = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void onQosParametersChanged(int r8, int r10, QosParametersResult r11) {
        StringBuilder r12 = a.g("UNIMPLEMENTED: onQosParametersChanged: slotId = ", r8, " cid = ", r10, " result = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void onSecureModeStatusChange(boolean r8) {
        Log.d(TAG, "UNIMPLEMENTED: onSecureModeStatusChange: enabled = " + r8);
    }

    public void onSendUserPreferenceConfigForDataDuringVoiceCall(Token r8, Status r10) {
        Log.d(TAG, "UNIMPLEMENTED: onSendUserPreferenceConfigForDataDuringVoiceCall: token = " + r8 + " status = " + r10);
    }

    public void onSendUserPreferenceForDataDuringVoiceCall(int r8, Token r10, Status r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: onSendUserPreferenceForDataDuringVoiceCall: slotId = ", r8, " token = ", r10, " status = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void onSetNrConfig(int r8, Token r10, Status r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: onSetNrConfig: slotId = ", r8, " token = ", r10, " status = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void onSignalStrength(int r8, Token r10, Status r11, SignalStrength r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onSignalStrength: slotId = ", r8, " token = ", r10, " status");
        r13.append(r11);
        r13.append(" signalStrength = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void onSimPersoUnlockStatusChange(int r8, QtiPersoUnlockStatus r10) {
        Log.d(TAG, "UNIMPLEMENTED: onSimPersoUnlockStatusChange: slotId = " + r8 + " persoUnlockStatus = " + r10);
    }

    public void onSimTypeChanged(QtiSimType[] r8) {
        Log.d(TAG, "UNIMPLEMENTED: onSimTypeChanged: simtype = " + r8);
    }

    public void onUpperLayerIndInfo(int r8, Token r10, Status r11, UpperLayerIndInfo r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onUpperLayerIndInfo: slotId = ", r8, " token = ", r10, " status");
        r13.append(r11);
        r13.append(" UpperLayerIndInfo = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void queryCallForwardStatusResponse(Status r8, QtiCallForwardInfo[] r10) {
        Log.d(TAG, "UNIMPLEMENTED: queryCallForwardStatusResponse: status = " + r8 + " CallForwardInfo = " + r10);
    }

    public void sendCdmaSmsResponse(int r8, Token r10, Status r11, SmsResult r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: sendCdmaSmsResponse: slotId = ", r8, " token = ", r10, " status = ");
        r13.append(r11);
        r13.append(" SmsResult = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    public void setCarrierInfoForImsiEncryptionResponse(int r8, Token r10, QRadioResponseInfo r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: setCarrierInfoForImsiEncryptionResponse: slotId = ", r8, " token = ", r10, " info = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void setCellularRoamingPreferenceResponse(int r8, Token r10, Status r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: setCellularRoamingPreferenceResponse: slotId = ", r8, " token = ", r10, " status = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void setCiwlanModeUserPreferenceResponse(int r8, Token r10, Status r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: setCiwlanModeUserPreferenceResponse: slotId = ", r8, " token = ", r10, " status = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void setDualDataUserPreferenceResponse(Token r8, Status r10) {
        Log.d(TAG, "UNIMPLEMENTED: setDualDataUserPreferenceResponse: token = " + r8 + " status = " + r10);
    }

    public void setMsimPreferenceResponse(Token r8, Status r10) {
        Log.d(TAG, "UNIMPLEMENTED: setMsimPreferenceResponse: token = " + r8 + " status = " + r10);
    }

    public void setNetworkSelectionModeAutomaticResponse(int r8, Token r10, int r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: setNetworkSelectionModeAutomaticResponse: slotId = ", r8, " token = ", r10, " errorCode = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void setNetworkSelectionModeManualResponse(int r8, Token r10, int r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: setNetworkSelectionModeManualResponse: slotId = ", r8, " token = ", r10, " errorCode = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void setSimTypeResponse(Token r8, Status r10) {
        Log.d(TAG, "UNIMPLEMENTED: setSimTypeResponse: token = " + r8 + " status = " + r10);
    }

    public void setSmartDdsSwitchToggleResponse(Token r8, boolean r10) {
        Log.d(TAG, "UNIMPLEMENTED: setSmartDdsSwitchToggleResponse: token = " + r8 + " result = " + r10);
    }

    public void setup() {
        if (this.mLooper != null) goto L8;
        this.mLooper = acquireGlobalLooper();
        if (this.mHandler != null) goto L9;
        init();
        return;
    L9:
        return;
    }

    public void startNetworkScanResponse(int r8, Token r10, int r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: startNetworkScanResponse: slotId = ", r8, " token = ", r10, " errorCode = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public void stopNetworkScanResponse(int r8, Token r10, int r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: stopNetworkScanResponse: slotId = ", r8, " token = ", r10, " errorCode = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    public ExtPhoneCallbackListener(Looper r8) {
        this.mCallback = new IExtPhoneCallbackStub(this);
        this.mLooper = r8;
        init();
    }
}
