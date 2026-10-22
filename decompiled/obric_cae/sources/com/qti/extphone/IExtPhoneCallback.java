package com.qti.extphone;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.telephony.CellInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtPhoneCallback extends IInterface {
    public static final String DESCRIPTOR = "com.qti.extphone.IExtPhoneCallback";

    public static class Default implements IExtPhoneCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void getFacilityLockForAppResponse(Status r8, int[] r10) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void getNetworkSelectionModeResponse(int r8, Token r10, Status r11, NetworkSelectionMode r12) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void getQosParametersResponse(int r8, Token r10, Status r11, QosParametersResult r12) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void getQtiRadioCapabilityResponse(int r8, Token r10, Status r11, int r12) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void getSecureModeStatusResponse(Token r8, Status r10, boolean r11) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void networkScanResult(int r8, Token r10, int r11, int r12, List<CellInfo> r13) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void on5gConfigInfo(int r8, Token r10, Status r11, NrConfigType r12) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void on5gStatus(int r8, Token r10, Status r11, boolean r12) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onAnyNrBearerAllocation(int r8, Token r10, Status r11, BearerAllocationStatus r12) {
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
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onEndcStatus(int r8, Token r10, Status r11, boolean r12) {
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
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onNrDcParam(int r8, Token r10, Status r11, DcParam r12) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onNrIconChange(int r8, NrIcon r10) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onNrIconResponse(int r8, Token r10, Status r11, NrIcon r12) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onNrIconType(int r8, Token r10, Status r11, NrIconType r12) {
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
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onSignalStrength(int r8, Token r10, Status r11, SignalStrength r12) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onSimPersoUnlockStatusChange(int r8, QtiPersoUnlockStatus r10) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onSimTypeChanged(QtiSimType[] r8) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void onUpperLayerIndInfo(int r8, Token r10, Status r11, UpperLayerIndInfo r12) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void queryCallForwardStatusResponse(Status r8, QtiCallForwardInfo[] r10) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void sendCdmaSmsResponse(int r8, Token r10, Status r11, SmsResult r12) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void setCarrierInfoForImsiEncryptionResponse(int r8, Token r10, QRadioResponseInfo r11) {
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
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void startNetworkScanResponse(int r8, Token r10, int r11) {
        }

        @Override // com.qti.extphone.IExtPhoneCallback
        public void stopNetworkScanResponse(int r8, Token r10, int r11) {
        }
    }

    public static abstract class Stub extends Binder implements IExtPhoneCallback {
        static final int TRANSACTION_getFacilityLockForAppResponse = 16;
        static final int TRANSACTION_getNetworkSelectionModeResponse = 33;
        static final int TRANSACTION_getQosParametersResponse = 25;
        static final int TRANSACTION_getQtiRadioCapabilityResponse = 7;
        static final int TRANSACTION_getSecureModeStatusResponse = 27;
        static final int TRANSACTION_networkScanResult = 34;
        static final int TRANSACTION_on5gConfigInfo = 12;
        static final int TRANSACTION_on5gStatus = 8;
        static final int TRANSACTION_onAnyNrBearerAllocation = 9;
        static final int TRANSACTION_onCiwlanAvailable = 47;
        static final int TRANSACTION_onCiwlanConfigChange = 48;
        static final int TRANSACTION_onDataDeactivateDelayTime = 23;
        static final int TRANSACTION_onDdsSwitchCapabilityChange = 20;
        static final int TRANSACTION_onDdsSwitchConfigCapabilityChanged = 42;
        static final int TRANSACTION_onDdsSwitchConfigCriteriaChanged = 43;
        static final int TRANSACTION_onDdsSwitchConfigRecommendation = 44;
        static final int TRANSACTION_onDdsSwitchCriteriaChange = 21;
        static final int TRANSACTION_onDdsSwitchRecommendation = 22;
        static final int TRANSACTION_onDiagInfoChanged = 57;
        static final int TRANSACTION_onDisableEndc = 52;
        static final int TRANSACTION_onDualDataCapabilityChanged = 38;
        static final int TRANSACTION_onDualDataRecommendation = 40;
        static final int TRANSACTION_onEnableEndc = 2;
        static final int TRANSACTION_onEndcStatus = 3;
        static final int TRANSACTION_onEpdgOverCellularDataSupported = 24;
        static final int TRANSACTION_onGetDiagInfoResponse = 58;
        static final int TRANSACTION_onImeiTypeChanged = 18;
        static final int TRANSACTION_onLockLteBand = 55;
        static final int TRANSACTION_onLockLteCell = 53;
        static final int TRANSACTION_onLockNrBand = 56;
        static final int TRANSACTION_onLockNrCell = 54;
        static final int TRANSACTION_onNrConfigStatus = 5;
        static final int TRANSACTION_onNrDcParam = 10;
        static final int TRANSACTION_onNrIconChange = 50;
        static final int TRANSACTION_onNrIconResponse = 51;
        static final int TRANSACTION_onNrIconType = 1;
        static final int TRANSACTION_onQosParametersChanged = 26;
        static final int TRANSACTION_onSecureModeStatusChange = 28;
        static final int TRANSACTION_onSendUserPreferenceConfigForDataDuringVoiceCall = 45;
        static final int TRANSACTION_onSendUserPreferenceForDataDuringVoiceCall = 19;
        static final int TRANSACTION_onSetNrConfig = 4;
        static final int TRANSACTION_onSignalStrength = 13;
        static final int TRANSACTION_onSimPersoUnlockStatusChange = 41;
        static final int TRANSACTION_onSimTypeChanged = 37;
        static final int TRANSACTION_onUpperLayerIndInfo = 11;
        static final int TRANSACTION_queryCallForwardStatusResponse = 15;
        static final int TRANSACTION_sendCdmaSmsResponse = 6;
        static final int TRANSACTION_setCarrierInfoForImsiEncryptionResponse = 14;
        static final int TRANSACTION_setCellularRoamingPreferenceResponse = 46;
        static final int TRANSACTION_setCiwlanModeUserPreferenceResponse = 49;
        static final int TRANSACTION_setDualDataUserPreferenceResponse = 39;
        static final int TRANSACTION_setMsimPreferenceResponse = 35;
        static final int TRANSACTION_setNetworkSelectionModeAutomaticResponse = 31;
        static final int TRANSACTION_setNetworkSelectionModeManualResponse = 32;
        static final int TRANSACTION_setSimTypeResponse = 36;
        static final int TRANSACTION_setSmartDdsSwitchToggleResponse = 17;
        static final int TRANSACTION_startNetworkScanResponse = 29;
        static final int TRANSACTION_stopNetworkScanResponse = 30;

        public static class Proxy implements IExtPhoneCallback {
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void getFacilityLockForAppResponse(Status r8, int[] r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r11.writeIntArray(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(16, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return IExtPhoneCallback.DESCRIPTOR;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void getNetworkSelectionModeResponse(int r8, Token r10, Status r11, NetworkSelectionMode r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r12, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(33, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void getQosParametersResponse(int r8, Token r10, Status r11, QosParametersResult r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r12, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(25, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void getQtiRadioCapabilityResponse(int r8, Token r10, Status r11, int r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeInt(r12);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void getSecureModeStatusResponse(Token r8, Status r10, boolean r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeBoolean(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(27, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void networkScanResult(int r8, Token r10, int r11, int r12, List<CellInfo> r13) {
                Parcel r14 = Parcel.obtain(asBinder());
                Parcel r15 = Parcel.obtain();
                r14.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r14.writeInt(r8);     // Catch: Throwable -> L6
                r14.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r14.writeInt(r11);     // Catch: Throwable -> L6
                r14.writeInt(r12);     // Catch: Throwable -> L6
                r14.writeTypedList(r13, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(34, r14, r15, 0);     // Catch: Throwable -> L6
                r15.readException();     // Catch: Throwable -> L6
                r15.recycle();
                r14.recycle();
                return;
            L6:
                th = move-exception;
                r15.recycle();
                r14.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void on5gConfigInfo(int r8, Token r10, Status r11, NrConfigType r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r12, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void on5gStatus(int r8, Token r10, Status r11, boolean r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeBoolean(r12);     // Catch: Throwable -> L6
                this.mRemote.transact(8, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onAnyNrBearerAllocation(int r8, Token r10, Status r11, BearerAllocationStatus r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r12, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onCiwlanAvailable(int r8, boolean r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeBoolean(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(47, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onCiwlanConfigChange(int r8, CiwlanConfig r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(48, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onDataDeactivateDelayTime(int r8, long r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeLong(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(23, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onDdsSwitchCapabilityChange(int r8, Token r10, Status r11, boolean r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeBoolean(r12);     // Catch: Throwable -> L6
                this.mRemote.transact(20, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onDdsSwitchConfigCapabilityChanged(Token r8, Status r10, boolean r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeBoolean(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(42, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onDdsSwitchConfigCriteriaChanged(boolean r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeBoolean(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(43, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onDdsSwitchConfigRecommendation(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(44, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onDdsSwitchCriteriaChange(int r8, boolean r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeBoolean(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(21, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onDdsSwitchRecommendation(int r8, int r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(22, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onDiagInfoChanged(BdDiagInfo r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(57, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onDisableEndc(int r8, Token r10, Status r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(52, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onDualDataCapabilityChanged(Token r8, Status r10, boolean r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeBoolean(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(38, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onDualDataRecommendation(DualDataRecommendation r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(40, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onEnableEndc(int r8, Token r10, Status r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onEndcStatus(int r8, Token r10, Status r11, boolean r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeBoolean(r12);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onEpdgOverCellularDataSupported(int r8, boolean r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeBoolean(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(24, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onGetDiagInfoResponse(Token r8, Status r10, BdDiagInfo r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(58, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onImeiTypeChanged(QtiImeiInfo[] r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeTypedArray(r8, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(18, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onLockLteBand(int r8, Token r10, Status r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(55, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onLockLteCell(int r8, Token r10, Status r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(53, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onLockNrBand(int r8, Token r10, Status r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(56, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onLockNrCell(int r8, Token r10, Status r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(54, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onNrConfigStatus(int r8, Token r10, Status r11, NrConfig r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r12, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onNrDcParam(int r8, Token r10, Status r11, DcParam r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r12, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onNrIconChange(int r8, NrIcon r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(50, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onNrIconResponse(int r8, Token r10, Status r11, NrIcon r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r12, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(51, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onNrIconType(int r8, Token r10, Status r11, NrIconType r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r12, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onQosParametersChanged(int r8, int r10, QosParametersResult r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(26, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onSecureModeStatusChange(boolean r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeBoolean(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(28, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onSendUserPreferenceConfigForDataDuringVoiceCall(Token r8, Status r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(45, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onSendUserPreferenceForDataDuringVoiceCall(int r8, Token r10, Status r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(19, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onSetNrConfig(int r8, Token r10, Status r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onSignalStrength(int r8, Token r10, Status r11, SignalStrength r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r12, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(13, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onSimPersoUnlockStatusChange(int r8, QtiPersoUnlockStatus r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(41, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onSimTypeChanged(QtiSimType[] r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeTypedArray(r8, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(37, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void onUpperLayerIndInfo(int r8, Token r10, Status r11, UpperLayerIndInfo r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r12, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void queryCallForwardStatusResponse(Status r8, QtiCallForwardInfo[] r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r11.writeTypedArray(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(15, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void sendCdmaSmsResponse(int r8, Token r10, Status r11, SmsResult r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                r13.writeTypedObject(r12, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void setCarrierInfoForImsiEncryptionResponse(int r8, Token r10, QRadioResponseInfo r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(14, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void setCellularRoamingPreferenceResponse(int r8, Token r10, Status r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(46, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void setCiwlanModeUserPreferenceResponse(int r8, Token r10, Status r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(49, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void setDualDataUserPreferenceResponse(Token r8, Status r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(39, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void setMsimPreferenceResponse(Token r8, Status r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(35, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void setNetworkSelectionModeAutomaticResponse(int r8, Token r10, int r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeInt(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(31, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void setNetworkSelectionModeManualResponse(int r8, Token r10, int r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeInt(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(32, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void setSimTypeResponse(Token r8, Status r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(36, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void setSmartDdsSwitchToggleResponse(Token r8, boolean r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r11.writeBoolean(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(17, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void startNetworkScanResponse(int r8, Token r10, int r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeInt(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(29, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhoneCallback
            public void stopNetworkScanResponse(int r8, Token r10, int r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhoneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeInt(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(30, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IExtPhoneCallback.DESCRIPTOR);
        }

        public static IExtPhoneCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(IExtPhoneCallback.DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IExtPhoneCallback) == false) goto L12;
            return (IExtPhoneCallback) r10;
        L12:
            return new Proxy(r8);
        }

        public static String getDefaultTransactionName(int r8) {
            switch(r8) {
                case 1: goto L119;
                case 2: goto L117;
                case 3: goto L115;
                case 4: goto L113;
                case 5: goto L111;
                case 6: goto L109;
                case 7: goto L107;
                case 8: goto L105;
                case 9: goto L103;
                case 10: goto L101;
                case 11: goto L99;
                case 12: goto L97;
                case 13: goto L95;
                case 14: goto L93;
                case 15: goto L91;
                case 16: goto L89;
                case 17: goto L87;
                case 18: goto L85;
                case 19: goto L83;
                case 20: goto L81;
                case 21: goto L79;
                case 22: goto L77;
                case 23: goto L75;
                case 24: goto L73;
                case 25: goto L71;
                case 26: goto L69;
                case 27: goto L67;
                case 28: goto L65;
                case 29: goto L63;
                case 30: goto L61;
                case 31: goto L59;
                case 32: goto L57;
                case 33: goto L55;
                case 34: goto L53;
                case 35: goto L51;
                case 36: goto L49;
                case 37: goto L47;
                case 38: goto L45;
                case 39: goto L43;
                case 40: goto L41;
                case 41: goto L39;
                case 42: goto L37;
                case 43: goto L35;
                case 44: goto L33;
                case 45: goto L31;
                case 46: goto L29;
                case 47: goto L27;
                case 48: goto L25;
                case 49: goto L23;
                case 50: goto L21;
                case 51: goto L19;
                case 52: goto L17;
                case 53: goto L15;
                case 54: goto L13;
                case 55: goto L11;
                case 56: goto L9;
                case 57: goto L7;
                case 58: goto L5;
                default: goto L3;
            };
        L3:
            return null;
        L5:
            return "onGetDiagInfoResponse";
        L7:
            return "onDiagInfoChanged";
        L9:
            return "onLockNrBand";
        L11:
            return "onLockLteBand";
        L13:
            return "onLockNrCell";
        L15:
            return "onLockLteCell";
        L17:
            return "onDisableEndc";
        L19:
            return "onNrIconResponse";
        L21:
            return "onNrIconChange";
        L23:
            return "setCiwlanModeUserPreferenceResponse";
        L25:
            return "onCiwlanConfigChange";
        L27:
            return "onCiwlanAvailable";
        L29:
            return "setCellularRoamingPreferenceResponse";
        L31:
            return "onSendUserPreferenceConfigForDataDuringVoiceCall";
        L33:
            return "onDdsSwitchConfigRecommendation";
        L35:
            return "onDdsSwitchConfigCriteriaChanged";
        L37:
            return "onDdsSwitchConfigCapabilityChanged";
        L39:
            return "onSimPersoUnlockStatusChange";
        L41:
            return "onDualDataRecommendation";
        L43:
            return "setDualDataUserPreferenceResponse";
        L45:
            return "onDualDataCapabilityChanged";
        L47:
            return "onSimTypeChanged";
        L49:
            return "setSimTypeResponse";
        L51:
            return "setMsimPreferenceResponse";
        L53:
            return "networkScanResult";
        L55:
            return "getNetworkSelectionModeResponse";
        L57:
            return "setNetworkSelectionModeManualResponse";
        L59:
            return "setNetworkSelectionModeAutomaticResponse";
        L61:
            return "stopNetworkScanResponse";
        L63:
            return "startNetworkScanResponse";
        L65:
            return "onSecureModeStatusChange";
        L67:
            return "getSecureModeStatusResponse";
        L69:
            return "onQosParametersChanged";
        L71:
            return "getQosParametersResponse";
        L73:
            return "onEpdgOverCellularDataSupported";
        L75:
            return "onDataDeactivateDelayTime";
        L77:
            return "onDdsSwitchRecommendation";
        L79:
            return "onDdsSwitchCriteriaChange";
        L81:
            return "onDdsSwitchCapabilityChange";
        L83:
            return "onSendUserPreferenceForDataDuringVoiceCall";
        L85:
            return "onImeiTypeChanged";
        L87:
            return "setSmartDdsSwitchToggleResponse";
        L89:
            return "getFacilityLockForAppResponse";
        L91:
            return "queryCallForwardStatusResponse";
        L93:
            return "setCarrierInfoForImsiEncryptionResponse";
        L95:
            return "onSignalStrength";
        L97:
            return "on5gConfigInfo";
        L99:
            return "onUpperLayerIndInfo";
        L101:
            return "onNrDcParam";
        L103:
            return "onAnyNrBearerAllocation";
        L105:
            return "on5gStatus";
        L107:
            return "getQtiRadioCapabilityResponse";
        L109:
            return "sendCdmaSmsResponse";
        L111:
            return "onNrConfigStatus";
        L113:
            return "onSetNrConfig";
        L115:
            return "onEndcStatus";
        L117:
            return "onEnableEndc";
        L119:
            return "onNrIconType";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public int getMaxTransactionId() {
            return 57;
        }

        public String getTransactionName(int r8) {
            return getDefaultTransactionName(r8);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface(IExtPhoneCallback.DESCRIPTOR);
        L8:
            if (r10 != 1598968902) goto L11;
            r12.writeString(IExtPhoneCallback.DESCRIPTOR);
            return true;
        L11:
            switch(r10) {
                case 1: goto L71;
                case 2: goto L70;
                case 3: goto L69;
                case 4: goto L68;
                case 5: goto L67;
                case 6: goto L66;
                case 7: goto L65;
                case 8: goto L64;
                case 9: goto L63;
                case 10: goto L62;
                case 11: goto L61;
                case 12: goto L60;
                case 13: goto L59;
                case 14: goto L58;
                case 15: goto L57;
                case 16: goto L56;
                case 17: goto L55;
                case 18: goto L54;
                case 19: goto L53;
                case 20: goto L52;
                case 21: goto L51;
                case 22: goto L50;
                case 23: goto L49;
                case 24: goto L48;
                case 25: goto L47;
                case 26: goto L46;
                case 27: goto L45;
                case 28: goto L44;
                case 29: goto L43;
                case 30: goto L42;
                case 31: goto L41;
                case 32: goto L40;
                case 33: goto L39;
                case 34: goto L38;
                case 35: goto L37;
                case 36: goto L36;
                case 37: goto L35;
                case 38: goto L34;
                case 39: goto L33;
                case 40: goto L32;
                case 41: goto L31;
                case 42: goto L30;
                case 43: goto L29;
                case 44: goto L28;
                case 45: goto L27;
                case 46: goto L26;
                case 47: goto L25;
                case 48: goto L24;
                case 49: goto L23;
                case 50: goto L22;
                case 51: goto L21;
                case 52: goto L20;
                case 53: goto L19;
                case 54: goto L18;
                case 55: goto L17;
                case 56: goto L16;
                case 57: goto L15;
                case 58: goto L14;
                default: goto L13;
            };
        L14:
            Token r14 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r15 = (Status) r11.readTypedObject(Status.CREATOR);
            BdDiagInfo r8 = (BdDiagInfo) r11.readTypedObject(BdDiagInfo.CREATOR);
            r11.enforceNoDataAvail();
            onGetDiagInfoResponse(r14, r15, r8);
        L72:
            r12.writeNoException();
            return true;
        L15:
            BdDiagInfo r16 = (BdDiagInfo) r11.readTypedObject(BdDiagInfo.CREATOR);
            r11.enforceNoDataAvail();
            onDiagInfoChanged(r16);
            goto L72
        L16:
            int r17 = r11.readInt();
            Token r18 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r19 = (Status) r11.readTypedObject(Status.CREATOR);
            r11.enforceNoDataAvail();
            onLockNrBand(r17, r18, r19);
            goto L72
        L17:
            int r20 = r11.readInt();
            Token r110 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r21 = (Status) r11.readTypedObject(Status.CREATOR);
            r11.enforceNoDataAvail();
            onLockLteBand(r20, r110, r21);
            goto L72
        L18:
            int r22 = r11.readInt();
            Token r111 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r23 = (Status) r11.readTypedObject(Status.CREATOR);
            r11.enforceNoDataAvail();
            onLockNrCell(r22, r111, r23);
            goto L72
        L19:
            int r24 = r11.readInt();
            Token r112 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r25 = (Status) r11.readTypedObject(Status.CREATOR);
            r11.enforceNoDataAvail();
            onLockLteCell(r24, r112, r25);
            goto L72
        L20:
            int r26 = r11.readInt();
            Token r113 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r27 = (Status) r11.readTypedObject(Status.CREATOR);
            r11.enforceNoDataAvail();
            onDisableEndc(r26, r113, r27);
            goto L72
        L21:
            int r28 = r11.readInt();
            Token r114 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r29 = (Status) r11.readTypedObject(Status.CREATOR);
            NrIcon r30 = (NrIcon) r11.readTypedObject(NrIcon.CREATOR);
            r11.enforceNoDataAvail();
            onNrIconResponse(r28, r114, r29, r30);
            goto L72
        L22:
            int r31 = r11.readInt();
            NrIcon r115 = (NrIcon) r11.readTypedObject(NrIcon.CREATOR);
            r11.enforceNoDataAvail();
            onNrIconChange(r31, r115);
            goto L72
        L23:
            int r32 = r11.readInt();
            Token r116 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r33 = (Status) r11.readTypedObject(Status.CREATOR);
            r11.enforceNoDataAvail();
            setCiwlanModeUserPreferenceResponse(r32, r116, r33);
            goto L72
        L24:
            int r34 = r11.readInt();
            CiwlanConfig r117 = (CiwlanConfig) r11.readTypedObject(CiwlanConfig.CREATOR);
            r11.enforceNoDataAvail();
            onCiwlanConfigChange(r34, r117);
            goto L72
        L25:
            int r35 = r11.readInt();
            boolean r118 = r11.readBoolean();
            r11.enforceNoDataAvail();
            onCiwlanAvailable(r35, r118);
            goto L72
        L26:
            int r36 = r11.readInt();
            Token r119 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r37 = (Status) r11.readTypedObject(Status.CREATOR);
            r11.enforceNoDataAvail();
            setCellularRoamingPreferenceResponse(r36, r119, r37);
            goto L72
        L27:
            Token r38 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r120 = (Status) r11.readTypedObject(Status.CREATOR);
            r11.enforceNoDataAvail();
            onSendUserPreferenceConfigForDataDuringVoiceCall(r38, r120);
            goto L72
        L28:
            int r39 = r11.readInt();
            r11.enforceNoDataAvail();
            onDdsSwitchConfigRecommendation(r39);
            goto L72
        L29:
            boolean r40 = r11.readBoolean();
            r11.enforceNoDataAvail();
            onDdsSwitchConfigCriteriaChanged(r40);
            goto L72
        L30:
            Token r41 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r121 = (Status) r11.readTypedObject(Status.CREATOR);
            boolean r42 = r11.readBoolean();
            r11.enforceNoDataAvail();
            onDdsSwitchConfigCapabilityChanged(r41, r121, r42);
            goto L72
        L31:
            int r43 = r11.readInt();
            QtiPersoUnlockStatus r122 = (QtiPersoUnlockStatus) r11.readTypedObject(QtiPersoUnlockStatus.CREATOR);
            r11.enforceNoDataAvail();
            onSimPersoUnlockStatusChange(r43, r122);
            goto L72
        L32:
            DualDataRecommendation r44 = (DualDataRecommendation) r11.readTypedObject(DualDataRecommendation.CREATOR);
            r11.enforceNoDataAvail();
            onDualDataRecommendation(r44);
            goto L72
        L33:
            Token r45 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r123 = (Status) r11.readTypedObject(Status.CREATOR);
            r11.enforceNoDataAvail();
            setDualDataUserPreferenceResponse(r45, r123);
            goto L72
        L34:
            Token r46 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r124 = (Status) r11.readTypedObject(Status.CREATOR);
            boolean r47 = r11.readBoolean();
            r11.enforceNoDataAvail();
            onDualDataCapabilityChanged(r46, r124, r47);
            goto L72
        L35:
            QtiSimType[] r48 = (QtiSimType[]) r11.createTypedArray(QtiSimType.CREATOR);
            r11.enforceNoDataAvail();
            onSimTypeChanged(r48);
            goto L72
        L36:
            Token r49 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r125 = (Status) r11.readTypedObject(Status.CREATOR);
            r11.enforceNoDataAvail();
            setSimTypeResponse(r49, r125);
            goto L72
        L37:
            Token r50 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r126 = (Status) r11.readTypedObject(Status.CREATOR);
            r11.enforceNoDataAvail();
            setMsimPreferenceResponse(r50, r126);
            goto L72
        L38:
            int r51 = r11.readInt();
            Token r52 = (Token) r11.readTypedObject(Token.CREATOR);
            int r53 = r11.readInt();
            int r54 = r11.readInt();
            ArrayList r55 = r11.createTypedArrayList(CellInfo.CREATOR);
            r11.enforceNoDataAvail();
            networkScanResult(r51, r52, r53, r54, r55);
            goto L72
        L39:
            int r56 = r11.readInt();
            Token r127 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r57 = (Status) r11.readTypedObject(Status.CREATOR);
            NetworkSelectionMode r58 = (NetworkSelectionMode) r11.readTypedObject(NetworkSelectionMode.CREATOR);
            r11.enforceNoDataAvail();
            getNetworkSelectionModeResponse(r56, r127, r57, r58);
            goto L72
        L40:
            int r59 = r11.readInt();
            Token r128 = (Token) r11.readTypedObject(Token.CREATOR);
            int r60 = r11.readInt();
            r11.enforceNoDataAvail();
            setNetworkSelectionModeManualResponse(r59, r128, r60);
            goto L72
        L41:
            int r61 = r11.readInt();
            Token r129 = (Token) r11.readTypedObject(Token.CREATOR);
            int r62 = r11.readInt();
            r11.enforceNoDataAvail();
            setNetworkSelectionModeAutomaticResponse(r61, r129, r62);
            goto L72
        L42:
            int r63 = r11.readInt();
            Token r130 = (Token) r11.readTypedObject(Token.CREATOR);
            int r64 = r11.readInt();
            r11.enforceNoDataAvail();
            stopNetworkScanResponse(r63, r130, r64);
            goto L72
        L43:
            int r65 = r11.readInt();
            Token r131 = (Token) r11.readTypedObject(Token.CREATOR);
            int r66 = r11.readInt();
            r11.enforceNoDataAvail();
            startNetworkScanResponse(r65, r131, r66);
            goto L72
        L44:
            boolean r67 = r11.readBoolean();
            r11.enforceNoDataAvail();
            onSecureModeStatusChange(r67);
            goto L72
        L45:
            Token r68 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r132 = (Status) r11.readTypedObject(Status.CREATOR);
            boolean r69 = r11.readBoolean();
            r11.enforceNoDataAvail();
            getSecureModeStatusResponse(r68, r132, r69);
            goto L72
        L46:
            int r70 = r11.readInt();
            int r133 = r11.readInt();
            QosParametersResult r71 = (QosParametersResult) r11.readTypedObject(QosParametersResult.CREATOR);
            r11.enforceNoDataAvail();
            onQosParametersChanged(r70, r133, r71);
            goto L72
        L47:
            int r72 = r11.readInt();
            Token r134 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r73 = (Status) r11.readTypedObject(Status.CREATOR);
            QosParametersResult r74 = (QosParametersResult) r11.readTypedObject(QosParametersResult.CREATOR);
            r11.enforceNoDataAvail();
            getQosParametersResponse(r72, r134, r73, r74);
            goto L72
        L48:
            int r75 = r11.readInt();
            boolean r135 = r11.readBoolean();
            r11.enforceNoDataAvail();
            onEpdgOverCellularDataSupported(r75, r135);
            goto L72
        L49:
            int r76 = r11.readInt();
            long r77 = r11.readLong();
            r11.enforceNoDataAvail();
            onDataDeactivateDelayTime(r76, r77);
            goto L72
        L50:
            int r78 = r11.readInt();
            int r136 = r11.readInt();
            r11.enforceNoDataAvail();
            onDdsSwitchRecommendation(r78, r136);
            goto L72
        L51:
            int r79 = r11.readInt();
            boolean r137 = r11.readBoolean();
            r11.enforceNoDataAvail();
            onDdsSwitchCriteriaChange(r79, r137);
            goto L72
        L52:
            int r80 = r11.readInt();
            Token r138 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r81 = (Status) r11.readTypedObject(Status.CREATOR);
            boolean r82 = r11.readBoolean();
            r11.enforceNoDataAvail();
            onDdsSwitchCapabilityChange(r80, r138, r81, r82);
            goto L72
        L53:
            int r83 = r11.readInt();
            Token r139 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r84 = (Status) r11.readTypedObject(Status.CREATOR);
            r11.enforceNoDataAvail();
            onSendUserPreferenceForDataDuringVoiceCall(r83, r139, r84);
            goto L72
        L54:
            QtiImeiInfo[] r85 = (QtiImeiInfo[]) r11.createTypedArray(QtiImeiInfo.CREATOR);
            r11.enforceNoDataAvail();
            onImeiTypeChanged(r85);
            goto L72
        L55:
            Token r86 = (Token) r11.readTypedObject(Token.CREATOR);
            boolean r140 = r11.readBoolean();
            r11.enforceNoDataAvail();
            setSmartDdsSwitchToggleResponse(r86, r140);
            goto L72
        L56:
            Status r87 = (Status) r11.readTypedObject(Status.CREATOR);
            int[] r141 = r11.createIntArray();
            r11.enforceNoDataAvail();
            getFacilityLockForAppResponse(r87, r141);
            goto L72
        L57:
            Status r88 = (Status) r11.readTypedObject(Status.CREATOR);
            QtiCallForwardInfo[] r142 = (QtiCallForwardInfo[]) r11.createTypedArray(QtiCallForwardInfo.CREATOR);
            r11.enforceNoDataAvail();
            queryCallForwardStatusResponse(r88, r142);
            goto L72
        L58:
            int r89 = r11.readInt();
            Token r143 = (Token) r11.readTypedObject(Token.CREATOR);
            QRadioResponseInfo r90 = (QRadioResponseInfo) r11.readTypedObject(QRadioResponseInfo.CREATOR);
            r11.enforceNoDataAvail();
            setCarrierInfoForImsiEncryptionResponse(r89, r143, r90);
            goto L72
        L59:
            int r91 = r11.readInt();
            Token r144 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r92 = (Status) r11.readTypedObject(Status.CREATOR);
            SignalStrength r93 = (SignalStrength) r11.readTypedObject(SignalStrength.CREATOR);
            r11.enforceNoDataAvail();
            onSignalStrength(r91, r144, r92, r93);
            goto L72
        L60:
            int r94 = r11.readInt();
            Token r145 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r95 = (Status) r11.readTypedObject(Status.CREATOR);
            NrConfigType r96 = (NrConfigType) r11.readTypedObject(NrConfigType.CREATOR);
            r11.enforceNoDataAvail();
            on5gConfigInfo(r94, r145, r95, r96);
            goto L72
        L61:
            int r97 = r11.readInt();
            Token r146 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r98 = (Status) r11.readTypedObject(Status.CREATOR);
            UpperLayerIndInfo r99 = (UpperLayerIndInfo) r11.readTypedObject(UpperLayerIndInfo.CREATOR);
            r11.enforceNoDataAvail();
            onUpperLayerIndInfo(r97, r146, r98, r99);
            goto L72
        L62:
            int r100 = r11.readInt();
            Token r147 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r101 = (Status) r11.readTypedObject(Status.CREATOR);
            DcParam r102 = (DcParam) r11.readTypedObject(DcParam.CREATOR);
            r11.enforceNoDataAvail();
            onNrDcParam(r100, r147, r101, r102);
            goto L72
        L63:
            int r103 = r11.readInt();
            Token r148 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r104 = (Status) r11.readTypedObject(Status.CREATOR);
            BearerAllocationStatus r105 = (BearerAllocationStatus) r11.readTypedObject(BearerAllocationStatus.CREATOR);
            r11.enforceNoDataAvail();
            onAnyNrBearerAllocation(r103, r148, r104, r105);
            goto L72
        L64:
            int r106 = r11.readInt();
            Token r149 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r107 = (Status) r11.readTypedObject(Status.CREATOR);
            boolean r108 = r11.readBoolean();
            r11.enforceNoDataAvail();
            on5gStatus(r106, r149, r107, r108);
            goto L72
        L65:
            int r109 = r11.readInt();
            Token r150 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r151 = (Status) r11.readTypedObject(Status.CREATOR);
            int r152 = r11.readInt();
            r11.enforceNoDataAvail();
            getQtiRadioCapabilityResponse(r109, r150, r151, r152);
            goto L72
        L66:
            int r153 = r11.readInt();
            Token r154 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r155 = (Status) r11.readTypedObject(Status.CREATOR);
            SmsResult r156 = (SmsResult) r11.readTypedObject(SmsResult.CREATOR);
            r11.enforceNoDataAvail();
            sendCdmaSmsResponse(r153, r154, r155, r156);
            goto L72
        L67:
            int r157 = r11.readInt();
            Token r158 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r159 = (Status) r11.readTypedObject(Status.CREATOR);
            NrConfig r160 = (NrConfig) r11.readTypedObject(NrConfig.CREATOR);
            r11.enforceNoDataAvail();
            onNrConfigStatus(r157, r158, r159, r160);
            goto L72
        L68:
            int r161 = r11.readInt();
            Token r162 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r163 = (Status) r11.readTypedObject(Status.CREATOR);
            r11.enforceNoDataAvail();
            onSetNrConfig(r161, r162, r163);
            goto L72
        L69:
            int r164 = r11.readInt();
            Token r165 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r166 = (Status) r11.readTypedObject(Status.CREATOR);
            boolean r167 = r11.readBoolean();
            r11.enforceNoDataAvail();
            onEndcStatus(r164, r165, r166, r167);
            goto L72
        L70:
            int r168 = r11.readInt();
            Token r169 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r170 = (Status) r11.readTypedObject(Status.CREATOR);
            r11.enforceNoDataAvail();
            onEnableEndc(r168, r169, r170);
            goto L72
        L71:
            int r171 = r11.readInt();
            Token r172 = (Token) r11.readTypedObject(Token.CREATOR);
            Status r173 = (Status) r11.readTypedObject(Status.CREATOR);
            NrIconType r174 = (NrIconType) r11.readTypedObject(NrIconType.CREATOR);
            r11.enforceNoDataAvail();
            onNrIconType(r171, r172, r173, r174);
            goto L72
        L13:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void getFacilityLockForAppResponse(Status r8, int[] r10);

    void getNetworkSelectionModeResponse(int r8, Token r10, Status r11, NetworkSelectionMode r12);

    void getQosParametersResponse(int r8, Token r10, Status r11, QosParametersResult r12);

    void getQtiRadioCapabilityResponse(int r8, Token r10, Status r11, int r12);

    void getSecureModeStatusResponse(Token r8, Status r10, boolean r11);

    void networkScanResult(int r8, Token r10, int r11, int r12, List<CellInfo> r13);

    @Deprecated
    void on5gConfigInfo(int r8, Token r10, Status r11, NrConfigType r12);

    @Deprecated
    void on5gStatus(int r8, Token r10, Status r11, boolean r12);

    @Deprecated
    void onAnyNrBearerAllocation(int r8, Token r10, Status r11, BearerAllocationStatus r12);

    void onCiwlanAvailable(int r8, boolean r10);

    void onCiwlanConfigChange(int r8, CiwlanConfig r10);

    void onDataDeactivateDelayTime(int r8, long r10);

    void onDdsSwitchCapabilityChange(int r8, Token r10, Status r11, boolean r12);

    void onDdsSwitchConfigCapabilityChanged(Token r8, Status r10, boolean r11);

    void onDdsSwitchConfigCriteriaChanged(boolean r8);

    void onDdsSwitchConfigRecommendation(int r8);

    void onDdsSwitchCriteriaChange(int r8, boolean r10);

    void onDdsSwitchRecommendation(int r8, int r10);

    void onDiagInfoChanged(BdDiagInfo r8);

    void onDisableEndc(int r8, Token r10, Status r11);

    void onDualDataCapabilityChanged(Token r8, Status r10, boolean r11);

    void onDualDataRecommendation(DualDataRecommendation r8);

    void onEnableEndc(int r8, Token r10, Status r11);

    void onEndcStatus(int r8, Token r10, Status r11, boolean r12);

    void onEpdgOverCellularDataSupported(int r8, boolean r10);

    void onGetDiagInfoResponse(Token r8, Status r10, BdDiagInfo r11);

    void onImeiTypeChanged(QtiImeiInfo[] r8);

    void onLockLteBand(int r8, Token r10, Status r11);

    void onLockLteCell(int r8, Token r10, Status r11);

    void onLockNrBand(int r8, Token r10, Status r11);

    void onLockNrCell(int r8, Token r10, Status r11);

    void onNrConfigStatus(int r8, Token r10, Status r11, NrConfig r12);

    @Deprecated
    void onNrDcParam(int r8, Token r10, Status r11, DcParam r12);

    void onNrIconChange(int r8, NrIcon r10);

    void onNrIconResponse(int r8, Token r10, Status r11, NrIcon r12);

    void onNrIconType(int r8, Token r10, Status r11, NrIconType r12);

    void onQosParametersChanged(int r8, int r10, QosParametersResult r11);

    void onSecureModeStatusChange(boolean r8);

    void onSendUserPreferenceConfigForDataDuringVoiceCall(Token r8, Status r10);

    void onSendUserPreferenceForDataDuringVoiceCall(int r8, Token r10, Status r11);

    void onSetNrConfig(int r8, Token r10, Status r11);

    @Deprecated
    void onSignalStrength(int r8, Token r10, Status r11, SignalStrength r12);

    void onSimPersoUnlockStatusChange(int r8, QtiPersoUnlockStatus r10);

    void onSimTypeChanged(QtiSimType[] r8);

    @Deprecated
    void onUpperLayerIndInfo(int r8, Token r10, Status r11, UpperLayerIndInfo r12);

    void queryCallForwardStatusResponse(Status r8, QtiCallForwardInfo[] r10);

    void sendCdmaSmsResponse(int r8, Token r10, Status r11, SmsResult r12);

    void setCarrierInfoForImsiEncryptionResponse(int r8, Token r10, QRadioResponseInfo r11);

    void setCellularRoamingPreferenceResponse(int r8, Token r10, Status r11);

    void setCiwlanModeUserPreferenceResponse(int r8, Token r10, Status r11);

    void setDualDataUserPreferenceResponse(Token r8, Status r10);

    void setMsimPreferenceResponse(Token r8, Status r10);

    void setNetworkSelectionModeAutomaticResponse(int r8, Token r10, int r11);

    void setNetworkSelectionModeManualResponse(int r8, Token r10, int r11);

    void setSimTypeResponse(Token r8, Status r10);

    void setSmartDdsSwitchToggleResponse(Token r8, boolean r10);

    void startNetworkScanResponse(int r8, Token r10, int r11);

    void stopNetworkScanResponse(int r8, Token r10, int r11);
}
