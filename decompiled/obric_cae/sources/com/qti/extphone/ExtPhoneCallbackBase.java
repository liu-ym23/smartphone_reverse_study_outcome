package com.qti.extphone;

import android.telephony.CellInfo;
import android.util.Log;
import defpackage.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ExtPhoneCallbackBase extends IExtPhoneCallback.Stub {
    private static final String TAG = "ExtPhoneCallbackBase";

    public ExtPhoneCallbackBase() {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void getFacilityLockForAppResponse(Status r8, int[] r10) {
        Log.d(TAG, "getFacilityLockForAppResponse: status = " + r8 + " response = " + r10);
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void getNetworkSelectionModeResponse(int r8, Token r10, Status r11, NetworkSelectionMode r12) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void getQosParametersResponse(int r8, Token r10, Status r11, QosParametersResult r12) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void getQtiRadioCapabilityResponse(int r8, Token r10, Status r11, int r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: getQtiRadioCapabilityResponse: slotId = ", r8, " token = ", r10, " status");
        r13.append(r11);
        r13.append(" raf = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void getSecureModeStatusResponse(Token r8, Status r10, boolean r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void networkScanResult(int r8, Token r10, int r11, int r12, List<CellInfo> r13) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void on5gConfigInfo(int r8, Token r10, Status r11, NrConfigType r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: on5gConfigInfo: slotId = ", r8, " token = ", r10, " status");
        r13.append(r11);
        r13.append(" NrConfigType = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void on5gStatus(int r8, Token r10, Status r11, boolean r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: on5gStatus: slotId = ", r8, " token = ", r10, " status");
        r13.append(r11);
        r13.append(" enableStatus = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onAnyNrBearerAllocation(int r8, Token r10, Status r11, BearerAllocationStatus r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onNrBearerAllocationChange: slotId = ", r8, " token = ", r10, " status = ");
        r13.append(r11);
        r13.append(" bearerStatus = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onCiwlanAvailable(int r8, boolean r10) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onCiwlanConfigChange(int r8, CiwlanConfig r10) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onDataDeactivateDelayTime(int r8, long r10) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onDdsSwitchCapabilityChange(int r8, Token r10, Status r11, boolean r12) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onDdsSwitchConfigCapabilityChanged(Token r8, Status r10, boolean r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onDdsSwitchConfigCriteriaChanged(boolean r8) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onDdsSwitchConfigRecommendation(int r8) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onDdsSwitchCriteriaChange(int r8, boolean r10) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onDdsSwitchRecommendation(int r8, int r10) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onDiagInfoChanged(BdDiagInfo r8) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onDisableEndc(int r8, Token r10, Status r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onDualDataCapabilityChanged(Token r8, Status r10, boolean r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onDualDataRecommendation(DualDataRecommendation r8) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onEnableEndc(int r8, Token r10, Status r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: onEnableEndc: slotId = ", r8, " token = ", r10, " status = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onEndcStatus(int r8, Token r10, Status r11, boolean r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onEndcStatus: slotId = ", r8, " token = ", r10, " status = ");
        r13.append(r11);
        r13.append(" enableStatus = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onEpdgOverCellularDataSupported(int r8, boolean r10) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onGetDiagInfoResponse(Token r8, Status r10, BdDiagInfo r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onImeiTypeChanged(QtiImeiInfo[] r8) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onLockLteBand(int r8, Token r10, Status r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onLockLteCell(int r8, Token r10, Status r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onLockNrBand(int r8, Token r10, Status r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onLockNrCell(int r8, Token r10, Status r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onNrConfigStatus(int r8, Token r10, Status r11, NrConfig r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onNrConfigStatus: slotId = ", r8, " token = ", r10, " status = ");
        r13.append(r11);
        r13.append(" NrConfig = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onNrDcParam(int r8, Token r10, Status r11, DcParam r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onNrDcParam: slotId = ", r8, " token = ", r10, " status");
        r13.append(r11);
        r13.append(" dcParam = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onNrIconChange(int r8, NrIcon r10) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onNrIconResponse(int r8, Token r10, Status r11, NrIcon r12) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onNrIconType(int r8, Token r10, Status r11, NrIconType r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onNrIconType: slotId = ", r8, " token = ", r10, " status = ");
        r13.append(r11);
        r13.append(" NrIconType = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onQosParametersChanged(int r8, int r10, QosParametersResult r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onSecureModeStatusChange(boolean r8) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onSendUserPreferenceConfigForDataDuringVoiceCall(Token r8, Status r10) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onSendUserPreferenceForDataDuringVoiceCall(int r8, Token r10, Status r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onSetNrConfig(int r8, Token r10, Status r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: onSetNrConfig: slotId = ", r8, " token = ", r10, " status = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onSignalStrength(int r8, Token r10, Status r11, SignalStrength r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onSignalStrength: slotId = ", r8, " token = ", r10, " status");
        r13.append(r11);
        r13.append(" signalStrength = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onSimPersoUnlockStatusChange(int r8, QtiPersoUnlockStatus r10) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onSimTypeChanged(QtiSimType[] r8) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void onUpperLayerIndInfo(int r8, Token r10, Status r11, UpperLayerIndInfo r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: onUpperLayerIndInfo: slotId = ", r8, " token = ", r10, " status");
        r13.append(r11);
        r13.append(" UpperLayerIndInfo = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void queryCallForwardStatusResponse(Status r8, QtiCallForwardInfo[] r10) {
        Log.d(TAG, "queryCallForwardStatusResponse: status = " + r8 + " CallForwardInfo = " + r10);
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void sendCdmaSmsResponse(int r8, Token r10, Status r11, SmsResult r12) {
        StringBuilder r13 = b.g("UNIMPLEMENTED: sendCdmaSmsResponse: slotId = ", r8, " token = ", r10, " status = ");
        r13.append(r11);
        r13.append(" SmsResult = ");
        r13.append(r12);
        Log.d(TAG, r13.toString());
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void setCarrierInfoForImsiEncryptionResponse(int r8, Token r10, QRadioResponseInfo r11) {
        StringBuilder r12 = b.g("UNIMPLEMENTED: setCarrierInfoForImsiEncryptionResponse: slotId = ", r8, " token = ", r10, " info = ");
        r12.append(r11);
        Log.d(TAG, r12.toString());
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void setCellularRoamingPreferenceResponse(int r8, Token r10, Status r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void setCiwlanModeUserPreferenceResponse(int r8, Token r10, Status r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void setDualDataUserPreferenceResponse(Token r8, Status r10) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void setMsimPreferenceResponse(Token r8, Status r10) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void setNetworkSelectionModeAutomaticResponse(int r8, Token r10, int r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void setNetworkSelectionModeManualResponse(int r8, Token r10, int r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void setSimTypeResponse(Token r8, Status r10) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void setSmartDdsSwitchToggleResponse(Token r8, boolean r10) {
        Log.d(TAG, "setSmartDdsSwitchToggleResponse: token = " + r8 + " result = " + r10);
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void startNetworkScanResponse(int r8, Token r10, int r11) {
    }

    @Override // com.qti.extphone.IExtPhoneCallback
    public void stopNetworkScanResponse(int r8, Token r10, int r11) {
    }
}
