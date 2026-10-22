package com.qti.extphone;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.ImsiEncryptionInfo;
import android.telephony.NetworkScanRequest;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtPhone extends IInterface {
    public static final String DESCRIPTOR = "com.qti.extphone.IExtPhone";

    public static class Default implements IExtPhone {
        public Default() {
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean abortIncrementalScan(int r8) {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean checkSimPinLockStatus(int r8) {
            return false;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token disable5g(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token disableEndc(int r8, boolean r10, Client r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token enable5g(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token enable5gOnly(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token enableEndc(int r8, boolean r10, Client r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean getAirplaneMode() {
            return false;
        }

        @Override // com.qti.extphone.IExtPhone
        public CellularRoamingPreference getCellularRoamingPreference(int r8) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public CiwlanConfig getCiwlanConfig(int r8) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public CiwlanConfig getCiwlanModeUserPreference(int r8) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public int getCurrentPrimaryCardSlotId() {
            return 0;
        }

        @Override // com.qti.extphone.IExtPhone
        public QtiSimType[] getCurrentSimType() {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token getDdsSwitchCapability(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token getDdsSwitchConfigCapability(Client r8) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token getDiagInfo(int r8, int r10, Client r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean getDualDataCapability() {
            return false;
        }

        @Override // com.qti.extphone.IExtPhone
        public void getFacilityLockForApp(int r8, String r10, String r11, int r12, String r13, boolean r14, Client r15) {
        }

        @Override // com.qti.extphone.IExtPhone
        public QtiImeiInfo[] getImeiInfo() {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token getNetworkSelectionMode(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public int getPrimaryCarrierSlotId() {
            return 0;
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean getPropertyValueBool(String r8, boolean r10) {
            return false;
        }

        @Override // com.qti.extphone.IExtPhone
        public int getPropertyValueInt(String r8, int r10) {
            return 0;
        }

        @Override // com.qti.extphone.IExtPhone
        public String getPropertyValueString(String r8, String r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token getQosParameters(int r8, int r10, Client r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token getQtiRadioCapability(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token getSecureModeStatus(Client r8) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public QtiPersoUnlockStatus getSimPersoUnlockStatus(int r8) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public int[] getSimPinRetryTimes(int r8) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public QtiSimType[] getSupportedSimTypes() {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean isCiwlanAvailable(int r8) {
            return false;
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean isEpdgOverCellularDataSupported(int r8) {
            return false;
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean isFeatureSupported(int r8) {
            return false;
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean isPrimaryCarrierSlotId(int r8) {
            return false;
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean isSMSPromptEnabled() {
            return false;
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean isSmartDdsSwitchFeatureAvailable() {
            return false;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token lockLteBand(int r8, int r10, Client r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token lockLteCell(int r8, int r10, int r11, Client r12) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token lockNrBand(int r8, int r10, Client r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token lockNrCell(int r8, int r10, int r11, int r12, int r13, Client r14) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean performIncrementalScan(int r8) {
            return false;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token query5gConfigInfo(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token query5gStatus(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public void queryCallForwardStatus(int r8, int r10, int r11, String r12, boolean r13, Client r14) {
        }

        @Override // com.qti.extphone.IExtPhone
        public Token queryEndcStatus(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token queryNrBearerAllocation(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token queryNrConfig(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token queryNrDcParam(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token queryNrIcon(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token queryNrIconType(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token queryNrSignalStrength(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token queryUpperLayerIndInfo(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Client registerCallback(String r8, IExtPhoneCallback r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Client registerCallbackWithEvents(String r8, IExtPhoneCallback r10, int[] r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Client registerQtiRadioConfigCallback(String r8, IExtPhoneCallback r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token sendCdmaSms(int r8, byte[] r10, boolean r11, Client r12) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token sendUserPreferenceConfigForDataDuringVoiceCall(boolean[] r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token sendUserPreferenceForDataDuringVoiceCall(int r8, boolean r10, Client r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean setAirplaneMode(boolean r8) {
            return false;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token setCarrierInfoForImsiEncryption(int r8, ImsiEncryptionInfo r10, Client r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token setCellularRoamingPreference(Client r8, int r10, CellularRoamingPreference r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token setCiwlanModeUserPreference(int r8, Client r10, CiwlanConfig r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token setDualDataUserPreference(Client r8, boolean r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token setMsimPreference(Client r8, MsimPreference r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token setNetworkSelectionModeAutomatic(int r8, int r10, Client r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token setNetworkSelectionModeManual(int r8, QtiSetNetworkSelectionMode r10, Client r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token setNrConfig(int r8, NrConfig r10, Client r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public void setPrimaryCardOnSlot(int r8) {
        }

        @Override // com.qti.extphone.IExtPhone
        public void setSMSPromptEnabled(boolean r8) {
        }

        @Override // com.qti.extphone.IExtPhone
        public Token setSimType(Client r8, QtiSimType[] r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public void setSmartDdsSwitchToggle(boolean r8, Client r10) {
        }

        @Override // com.qti.extphone.IExtPhone
        public Token startNetworkScan(int r8, NetworkScanRequest r10, Client r11) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public Token stopNetworkScan(int r8, Client r10) {
            return null;
        }

        @Override // com.qti.extphone.IExtPhone
        public void supplyIccDepersonalization(String r8, String r10, IDepersoResCallback r11, int r12) {
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean toggleSimPinLock(int r8, boolean r10, String r11) {
            return false;
        }

        @Override // com.qti.extphone.IExtPhone
        public void unRegisterCallback(IExtPhoneCallback r8) {
        }

        @Override // com.qti.extphone.IExtPhone
        public void unregisterQtiRadioConfigCallback(IExtPhoneCallback r8) {
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean verifySimPin(int r8, String r10) {
            return false;
        }

        @Override // com.qti.extphone.IExtPhone
        public boolean verifySimPukChangePin(int r8, String r10, String r11) {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IExtPhone {
        static final int TRANSACTION_abortIncrementalScan = 9;
        static final int TRANSACTION_checkSimPinLockStatus = 46;
        static final int TRANSACTION_disable5g = 31;
        static final int TRANSACTION_disableEndc = 73;
        static final int TRANSACTION_enable5g = 30;
        static final int TRANSACTION_enable5gOnly = 33;
        static final int TRANSACTION_enableEndc = 19;
        static final int TRANSACTION_getAirplaneMode = 45;
        static final int TRANSACTION_getCellularRoamingPreference = 67;
        static final int TRANSACTION_getCiwlanConfig = 61;
        static final int TRANSACTION_getCiwlanModeUserPreference = 71;
        static final int TRANSACTION_getCurrentPrimaryCardSlotId = 4;
        static final int TRANSACTION_getCurrentSimType = 58;
        static final int TRANSACTION_getDdsSwitchCapability = 52;
        static final int TRANSACTION_getDdsSwitchConfigCapability = 66;
        static final int TRANSACTION_getDiagInfo = 79;
        static final int TRANSACTION_getDualDataCapability = 62;
        static final int TRANSACTION_getFacilityLockForApp = 41;
        static final int TRANSACTION_getImeiInfo = 51;
        static final int TRANSACTION_getNetworkSelectionMode = 14;
        static final int TRANSACTION_getPrimaryCarrierSlotId = 5;
        static final int TRANSACTION_getPropertyValueBool = 2;
        static final int TRANSACTION_getPropertyValueInt = 1;
        static final int TRANSACTION_getPropertyValueString = 3;
        static final int TRANSACTION_getQosParameters = 55;
        static final int TRANSACTION_getQtiRadioCapability = 29;
        static final int TRANSACTION_getSecureModeStatus = 56;
        static final int TRANSACTION_getSimPersoUnlockStatus = 64;
        static final int TRANSACTION_getSimPinRetryTimes = 74;
        static final int TRANSACTION_getSupportedSimTypes = 59;
        static final int TRANSACTION_isCiwlanAvailable = 69;
        static final int TRANSACTION_isEpdgOverCellularDataSupported = 54;
        static final int TRANSACTION_isFeatureSupported = 50;
        static final int TRANSACTION_isPrimaryCarrierSlotId = 6;
        static final int TRANSACTION_isSMSPromptEnabled = 15;
        static final int TRANSACTION_isSmartDdsSwitchFeatureAvailable = 42;
        static final int TRANSACTION_lockLteBand = 77;
        static final int TRANSACTION_lockLteCell = 75;
        static final int TRANSACTION_lockNrBand = 78;
        static final int TRANSACTION_lockNrCell = 76;
        static final int TRANSACTION_performIncrementalScan = 8;
        static final int TRANSACTION_query5gConfigInfo = 38;
        static final int TRANSACTION_query5gStatus = 34;
        static final int TRANSACTION_queryCallForwardStatus = 40;
        static final int TRANSACTION_queryEndcStatus = 20;
        static final int TRANSACTION_queryNrBearerAllocation = 32;
        static final int TRANSACTION_queryNrConfig = 27;
        static final int TRANSACTION_queryNrDcParam = 35;
        static final int TRANSACTION_queryNrIcon = 72;
        static final int TRANSACTION_queryNrIconType = 18;
        static final int TRANSACTION_queryNrSignalStrength = 36;
        static final int TRANSACTION_queryUpperLayerIndInfo = 37;
        static final int TRANSACTION_registerCallback = 21;
        static final int TRANSACTION_registerCallbackWithEvents = 22;
        static final int TRANSACTION_registerQtiRadioConfigCallback = 24;
        static final int TRANSACTION_sendCdmaSms = 28;
        static final int TRANSACTION_sendUserPreferenceConfigForDataDuringVoiceCall = 65;
        static final int TRANSACTION_sendUserPreferenceForDataDuringVoiceCall = 53;
        static final int TRANSACTION_setAirplaneMode = 44;
        static final int TRANSACTION_setCarrierInfoForImsiEncryption = 39;
        static final int TRANSACTION_setCellularRoamingPreference = 68;
        static final int TRANSACTION_setCiwlanModeUserPreference = 70;
        static final int TRANSACTION_setDualDataUserPreference = 63;
        static final int TRANSACTION_setMsimPreference = 57;
        static final int TRANSACTION_setNetworkSelectionModeAutomatic = 13;
        static final int TRANSACTION_setNetworkSelectionModeManual = 12;
        static final int TRANSACTION_setNrConfig = 26;
        static final int TRANSACTION_setPrimaryCardOnSlot = 7;
        static final int TRANSACTION_setSMSPromptEnabled = 16;
        static final int TRANSACTION_setSimType = 60;
        static final int TRANSACTION_setSmartDdsSwitchToggle = 43;
        static final int TRANSACTION_startNetworkScan = 10;
        static final int TRANSACTION_stopNetworkScan = 11;
        static final int TRANSACTION_supplyIccDepersonalization = 17;
        static final int TRANSACTION_toggleSimPinLock = 47;
        static final int TRANSACTION_unRegisterCallback = 23;
        static final int TRANSACTION_unregisterQtiRadioConfigCallback = 25;
        static final int TRANSACTION_verifySimPin = 48;
        static final int TRANSACTION_verifySimPukChangePin = 49;

        public static class Proxy implements IExtPhone {
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // com.qti.extphone.IExtPhone
            public boolean abortIncrementalScan(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                boolean r12 = r11.readBoolean();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.qti.extphone.IExtPhone
            public boolean checkSimPinLockStatus(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(46, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                boolean r12 = r11.readBoolean();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token disable5g(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(31, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token disableEndc(int r8, boolean r10, Client r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeBoolean(r10);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(Stub.TRANSACTION_disableEndc, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Token r14 = (Token) r13.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token enable5g(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(30, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token enable5gOnly(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(33, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token enableEndc(int r8, boolean r10, Client r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeBoolean(r10);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(19, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Token r14 = (Token) r13.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public boolean getAirplaneMode() {
                Parcel r8 = Parcel.obtain(asBinder());
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(45, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                boolean r11 = r10.readBoolean();     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public CellularRoamingPreference getCellularRoamingPreference(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(67, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                CellularRoamingPreference r12 = (CellularRoamingPreference) r11.readTypedObject(CellularRoamingPreference.CREATOR);     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public CiwlanConfig getCiwlanConfig(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(61, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                CiwlanConfig r12 = (CiwlanConfig) r11.readTypedObject(CiwlanConfig.CREATOR);     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public CiwlanConfig getCiwlanModeUserPreference(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(71, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                CiwlanConfig r12 = (CiwlanConfig) r11.readTypedObject(CiwlanConfig.CREATOR);     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public int getCurrentPrimaryCardSlotId() {
                Parcel r8 = Parcel.obtain(asBinder());
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                int r11 = r10.readInt();     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public QtiSimType[] getCurrentSimType() {
                Parcel r8 = Parcel.obtain(asBinder());
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(58, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                QtiSimType[] r11 = (QtiSimType[]) r10.createTypedArray(QtiSimType.CREATOR);     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token getDdsSwitchCapability(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(52, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token getDdsSwitchConfigCapability(Client r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(66, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                Token r12 = (Token) r11.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token getDiagInfo(int r8, int r10, Client r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(Stub.TRANSACTION_getDiagInfo, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Token r14 = (Token) r13.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public boolean getDualDataCapability() {
                Parcel r8 = Parcel.obtain(asBinder());
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(62, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                boolean r11 = r10.readBoolean();     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public void getFacilityLockForApp(int r8, String r10, String r11, int r12, String r13, boolean r14, Client r15) {
                Parcel r16 = Parcel.obtain(asBinder());
                Parcel r17 = Parcel.obtain();
                r16.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r16.writeInt(r8);     // Catch: Throwable -> L6
                r16.writeString(r10);     // Catch: Throwable -> L6
                r16.writeString(r11);     // Catch: Throwable -> L6
                r16.writeInt(r12);     // Catch: Throwable -> L6
                r16.writeString(r13);     // Catch: Throwable -> L6
                r16.writeBoolean(r14);     // Catch: Throwable -> L6
                r16.writeTypedObject(r15, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(41, r16, r17, 0);     // Catch: Throwable -> L6
                r17.readException();     // Catch: Throwable -> L6
                r17.recycle();
                r16.recycle();
                return;
            L6:
                th = move-exception;
                r17.recycle();
                r16.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public QtiImeiInfo[] getImeiInfo() {
                Parcel r8 = Parcel.obtain(asBinder());
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(51, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                QtiImeiInfo[] r11 = (QtiImeiInfo[]) r10.createTypedArray(QtiImeiInfo.CREATOR);     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return IExtPhone.DESCRIPTOR;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token getNetworkSelectionMode(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(14, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public int getPrimaryCarrierSlotId() {
                Parcel r8 = Parcel.obtain(asBinder());
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                int r11 = r10.readInt();     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public boolean getPropertyValueBool(String r8, boolean r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeString(r8);     // Catch: Throwable -> L6
                r11.writeBoolean(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                boolean r13 = r12.readBoolean();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public int getPropertyValueInt(String r8, int r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeString(r8);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                int r13 = r12.readInt();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public String getPropertyValueString(String r8, String r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeString(r8);     // Catch: Throwable -> L6
                r11.writeString(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                String r13 = r12.readString();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token getQosParameters(int r8, int r10, Client r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(55, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Token r14 = (Token) r13.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token getQtiRadioCapability(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(29, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token getSecureModeStatus(Client r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(56, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                Token r12 = (Token) r11.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public QtiPersoUnlockStatus getSimPersoUnlockStatus(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(64, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                QtiPersoUnlockStatus r12 = (QtiPersoUnlockStatus) r11.readTypedObject(QtiPersoUnlockStatus.CREATOR);     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public int[] getSimPinRetryTimes(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(Stub.TRANSACTION_getSimPinRetryTimes, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                int[] r12 = r11.createIntArray();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public QtiSimType[] getSupportedSimTypes() {
                Parcel r8 = Parcel.obtain(asBinder());
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(59, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                QtiSimType[] r11 = (QtiSimType[]) r10.createTypedArray(QtiSimType.CREATOR);     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public boolean isCiwlanAvailable(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(Stub.TRANSACTION_isCiwlanAvailable, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                boolean r12 = r11.readBoolean();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public boolean isEpdgOverCellularDataSupported(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(54, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                boolean r12 = r11.readBoolean();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public boolean isFeatureSupported(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(50, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                boolean r12 = r11.readBoolean();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public boolean isPrimaryCarrierSlotId(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                boolean r12 = r11.readBoolean();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public boolean isSMSPromptEnabled() {
                Parcel r8 = Parcel.obtain(asBinder());
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(15, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                boolean r11 = r10.readBoolean();     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public boolean isSmartDdsSwitchFeatureAvailable() {
                Parcel r8 = Parcel.obtain(asBinder());
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(42, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                boolean r11 = r10.readBoolean();     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token lockLteBand(int r8, int r10, Client r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(Stub.TRANSACTION_lockLteBand, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Token r14 = (Token) r13.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token lockLteCell(int r8, int r10, int r11, Client r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeInt(r10);     // Catch: Throwable -> L6
                r13.writeInt(r11);     // Catch: Throwable -> L6
                r13.writeTypedObject(r12, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(Stub.TRANSACTION_lockLteCell, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                Token r15 = (Token) r14.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return r15;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token lockNrBand(int r8, int r10, Client r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(Stub.TRANSACTION_lockNrBand, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Token r14 = (Token) r13.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token lockNrCell(int r8, int r10, int r11, int r12, int r13, Client r14) {
                Parcel r15 = Parcel.obtain(asBinder());
                Parcel r16 = Parcel.obtain();
                r15.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r15.writeInt(r8);     // Catch: Throwable -> L6
                r15.writeInt(r10);     // Catch: Throwable -> L6
                r15.writeInt(r11);     // Catch: Throwable -> L6
                r15.writeInt(r12);     // Catch: Throwable -> L6
                r15.writeInt(r13);     // Catch: Throwable -> L6
                r15.writeTypedObject(r14, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(76, r15, r16, 0);     // Catch: Throwable -> L6
                r16.readException();     // Catch: Throwable -> L6
                Token r17 = (Token) r16.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r16.recycle();
                r15.recycle();
                return r17;
            L6:
                th = move-exception;
                r16.recycle();
                r15.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public boolean performIncrementalScan(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(8, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                boolean r12 = r11.readBoolean();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token query5gConfigInfo(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(38, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token query5gStatus(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(34, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public void queryCallForwardStatus(int r8, int r10, int r11, String r12, boolean r13, Client r14) {
                Parcel r15 = Parcel.obtain(asBinder());
                Parcel r16 = Parcel.obtain();
                r15.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r15.writeInt(r8);     // Catch: Throwable -> L6
                r15.writeInt(r10);     // Catch: Throwable -> L6
                r15.writeInt(r11);     // Catch: Throwable -> L6
                r15.writeString(r12);     // Catch: Throwable -> L6
                r15.writeBoolean(r13);     // Catch: Throwable -> L6
                r15.writeTypedObject(r14, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(40, r15, r16, 0);     // Catch: Throwable -> L6
                r16.readException();     // Catch: Throwable -> L6
                r16.recycle();
                r15.recycle();
                return;
            L6:
                th = move-exception;
                r16.recycle();
                r15.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token queryEndcStatus(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(20, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token queryNrBearerAllocation(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(32, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token queryNrConfig(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(27, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token queryNrDcParam(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(35, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token queryNrIcon(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(Stub.TRANSACTION_queryNrIcon, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token queryNrIconType(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(18, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token queryNrSignalStrength(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(36, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token queryUpperLayerIndInfo(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(37, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Client registerCallback(String r8, IExtPhoneCallback r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeString(r8);     // Catch: Throwable -> L6
                r11.writeStrongInterface(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(21, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Client r13 = (Client) r12.readTypedObject(Client.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Client registerCallbackWithEvents(String r8, IExtPhoneCallback r10, int[] r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeString(r8);     // Catch: Throwable -> L6
                r12.writeStrongInterface(r10);     // Catch: Throwable -> L6
                r12.writeIntArray(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(22, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Client r14 = (Client) r13.readTypedObject(Client.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Client registerQtiRadioConfigCallback(String r8, IExtPhoneCallback r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeString(r8);     // Catch: Throwable -> L6
                r11.writeStrongInterface(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(24, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Client r13 = (Client) r12.readTypedObject(Client.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token sendCdmaSms(int r8, byte[] r10, boolean r11, Client r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeByteArray(r10);     // Catch: Throwable -> L6
                r13.writeBoolean(r11);     // Catch: Throwable -> L6
                r13.writeTypedObject(r12, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(28, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                Token r15 = (Token) r14.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return r15;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token sendUserPreferenceConfigForDataDuringVoiceCall(boolean[] r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeBooleanArray(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(65, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token sendUserPreferenceForDataDuringVoiceCall(int r8, boolean r10, Client r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeBoolean(r10);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(53, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Token r14 = (Token) r13.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public boolean setAirplaneMode(boolean r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeBoolean(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(44, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                boolean r12 = r11.readBoolean();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token setCarrierInfoForImsiEncryption(int r8, ImsiEncryptionInfo r10, Client r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(39, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Token r14 = (Token) r13.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token setCellularRoamingPreference(Client r8, int r10, CellularRoamingPreference r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(Stub.TRANSACTION_setCellularRoamingPreference, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Token r14 = (Token) r13.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token setCiwlanModeUserPreference(int r8, Client r10, CiwlanConfig r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(Stub.TRANSACTION_setCiwlanModeUserPreference, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Token r14 = (Token) r13.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token setDualDataUserPreference(Client r8, boolean r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r11.writeBoolean(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(63, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token setMsimPreference(Client r8, MsimPreference r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(57, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token setNetworkSelectionModeAutomatic(int r8, int r10, Client r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(13, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Token r14 = (Token) r13.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token setNetworkSelectionModeManual(int r8, QtiSetNetworkSelectionMode r10, Client r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Token r14 = (Token) r13.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token setNrConfig(int r8, NrConfig r10, Client r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(26, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Token r14 = (Token) r13.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public void setPrimaryCardOnSlot(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.qti.extphone.IExtPhone
            public void setSMSPromptEnabled(boolean r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeBoolean(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(16, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.qti.extphone.IExtPhone
            public Token setSimType(Client r8, QtiSimType[] r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                r11.writeTypedArray(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(60, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public void setSmartDdsSwitchToggle(boolean r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeBoolean(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(43, r11, r12, 0);     // Catch: Throwable -> L6
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

            @Override // com.qti.extphone.IExtPhone
            public Token startNetworkScan(int r8, NetworkScanRequest r10, Client r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                r12.writeTypedObject(r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                Token r14 = (Token) r13.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public Token stopNetworkScan(int r8, Client r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                Token r13 = (Token) r12.readTypedObject(Token.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public void supplyIccDepersonalization(String r8, String r10, IDepersoResCallback r11, int r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeString(r8);     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeStrongInterface(r11);     // Catch: Throwable -> L6
                r13.writeInt(r12);     // Catch: Throwable -> L6
                this.mRemote.transact(17, r13, r14, 0);     // Catch: Throwable -> L6
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

            @Override // com.qti.extphone.IExtPhone
            public boolean toggleSimPinLock(int r8, boolean r10, String r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeBoolean(r10);     // Catch: Throwable -> L6
                r12.writeString(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(47, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                boolean r14 = r13.readBoolean();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public void unRegisterCallback(IExtPhoneCallback r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeStrongInterface(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(23, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.qti.extphone.IExtPhone
            public void unregisterQtiRadioConfigCallback(IExtPhoneCallback r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeStrongInterface(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(25, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.qti.extphone.IExtPhone
            public boolean verifySimPin(int r8, String r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeString(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(48, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                boolean r13 = r12.readBoolean();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.qti.extphone.IExtPhone
            public boolean verifySimPukChangePin(int r8, String r10, String r11) {
                Parcel r12 = Parcel.obtain(asBinder());
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IExtPhone.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                r12.writeString(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(49, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                boolean r14 = r13.readBoolean();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IExtPhone.DESCRIPTOR);
        }

        public static IExtPhone asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(IExtPhone.DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IExtPhone) == false) goto L12;
            return (IExtPhone) r10;
        L12:
            return new Proxy(r8);
        }

        public static String getDefaultTransactionName(int r8) {
            switch(r8) {
                case 1: goto L161;
                case 2: goto L159;
                case 3: goto L157;
                case 4: goto L155;
                case 5: goto L153;
                case 6: goto L151;
                case 7: goto L149;
                case 8: goto L147;
                case 9: goto L145;
                case 10: goto L143;
                case 11: goto L141;
                case 12: goto L139;
                case 13: goto L137;
                case 14: goto L135;
                case 15: goto L133;
                case 16: goto L131;
                case 17: goto L129;
                case 18: goto L127;
                case 19: goto L125;
                case 20: goto L123;
                case 21: goto L121;
                case 22: goto L119;
                case 23: goto L117;
                case 24: goto L115;
                case 25: goto L113;
                case 26: goto L111;
                case 27: goto L109;
                case 28: goto L107;
                case 29: goto L105;
                case 30: goto L103;
                case 31: goto L101;
                case 32: goto L99;
                case 33: goto L97;
                case 34: goto L95;
                case 35: goto L93;
                case 36: goto L91;
                case 37: goto L89;
                case 38: goto L87;
                case 39: goto L85;
                case 40: goto L83;
                case 41: goto L81;
                case 42: goto L79;
                case 43: goto L77;
                case 44: goto L75;
                case 45: goto L73;
                case 46: goto L71;
                case 47: goto L69;
                case 48: goto L67;
                case 49: goto L65;
                case 50: goto L63;
                case 51: goto L61;
                case 52: goto L59;
                case 53: goto L57;
                case 54: goto L55;
                case 55: goto L53;
                case 56: goto L51;
                case 57: goto L49;
                case 58: goto L47;
                case 59: goto L45;
                case 60: goto L43;
                case 61: goto L41;
                case 62: goto L39;
                case 63: goto L37;
                case 64: goto L35;
                case 65: goto L33;
                case 66: goto L31;
                case 67: goto L29;
                case 68: goto L27;
                case 69: goto L25;
                case 70: goto L23;
                case 71: goto L21;
                case 72: goto L19;
                case 73: goto L17;
                case 74: goto L15;
                case 75: goto L13;
                case 76: goto L11;
                case 77: goto L9;
                case 78: goto L7;
                case 79: goto L5;
                default: goto L3;
            };
        L3:
            return null;
        L5:
            return "getDiagInfo";
        L7:
            return "lockNrBand";
        L9:
            return "lockLteBand";
        L11:
            return "lockNrCell";
        L13:
            return "lockLteCell";
        L15:
            return "getSimPinRetryTimes";
        L17:
            return "disableEndc";
        L19:
            return "queryNrIcon";
        L21:
            return "getCiwlanModeUserPreference";
        L23:
            return "setCiwlanModeUserPreference";
        L25:
            return "isCiwlanAvailable";
        L27:
            return "setCellularRoamingPreference";
        L29:
            return "getCellularRoamingPreference";
        L31:
            return "getDdsSwitchConfigCapability";
        L33:
            return "sendUserPreferenceConfigForDataDuringVoiceCall";
        L35:
            return "getSimPersoUnlockStatus";
        L37:
            return "setDualDataUserPreference";
        L39:
            return "getDualDataCapability";
        L41:
            return "getCiwlanConfig";
        L43:
            return "setSimType";
        L45:
            return "getSupportedSimTypes";
        L47:
            return "getCurrentSimType";
        L49:
            return "setMsimPreference";
        L51:
            return "getSecureModeStatus";
        L53:
            return "getQosParameters";
        L55:
            return "isEpdgOverCellularDataSupported";
        L57:
            return "sendUserPreferenceForDataDuringVoiceCall";
        L59:
            return "getDdsSwitchCapability";
        L61:
            return "getImeiInfo";
        L63:
            return "isFeatureSupported";
        L65:
            return "verifySimPukChangePin";
        L67:
            return "verifySimPin";
        L69:
            return "toggleSimPinLock";
        L71:
            return "checkSimPinLockStatus";
        L73:
            return "getAirplaneMode";
        L75:
            return "setAirplaneMode";
        L77:
            return "setSmartDdsSwitchToggle";
        L79:
            return "isSmartDdsSwitchFeatureAvailable";
        L81:
            return "getFacilityLockForApp";
        L83:
            return "queryCallForwardStatus";
        L85:
            return "setCarrierInfoForImsiEncryption";
        L87:
            return "query5gConfigInfo";
        L89:
            return "queryUpperLayerIndInfo";
        L91:
            return "queryNrSignalStrength";
        L93:
            return "queryNrDcParam";
        L95:
            return "query5gStatus";
        L97:
            return "enable5gOnly";
        L99:
            return "queryNrBearerAllocation";
        L101:
            return "disable5g";
        L103:
            return "enable5g";
        L105:
            return "getQtiRadioCapability";
        L107:
            return "sendCdmaSms";
        L109:
            return "queryNrConfig";
        L111:
            return "setNrConfig";
        L113:
            return "unregisterQtiRadioConfigCallback";
        L115:
            return "registerQtiRadioConfigCallback";
        L117:
            return "unRegisterCallback";
        L119:
            return "registerCallbackWithEvents";
        L121:
            return "registerCallback";
        L123:
            return "queryEndcStatus";
        L125:
            return "enableEndc";
        L127:
            return "queryNrIconType";
        L129:
            return "supplyIccDepersonalization";
        L131:
            return "setSMSPromptEnabled";
        L133:
            return "isSMSPromptEnabled";
        L135:
            return "getNetworkSelectionMode";
        L137:
            return "setNetworkSelectionModeAutomatic";
        L139:
            return "setNetworkSelectionModeManual";
        L141:
            return "stopNetworkScan";
        L143:
            return "startNetworkScan";
        L145:
            return "abortIncrementalScan";
        L147:
            return "performIncrementalScan";
        L149:
            return "setPrimaryCardOnSlot";
        L151:
            return "isPrimaryCarrierSlotId";
        L153:
            return "getPrimaryCarrierSlotId";
        L155:
            return "getCurrentPrimaryCardSlotId";
        L157:
            return "getPropertyValueString";
        L159:
            return "getPropertyValueBool";
        L161:
            return "getPropertyValueInt";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public int getMaxTransactionId() {
            return TRANSACTION_lockNrBand;
        }

        public String getTransactionName(int r8) {
            return getDefaultTransactionName(r8);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) {
            if (r11 < 1) goto L8;
            if (r11 > 16777215) goto L8;
            r12.enforceInterface(IExtPhone.DESCRIPTOR);
        L8:
            if (r11 != 1598968902) goto L11;
            r13.writeString(IExtPhone.DESCRIPTOR);
            return true;
        L11:
            switch(r11) {
                case 1: goto L95;
                case 2: goto L93;
                case 3: goto L92;
                case 4: goto L91;
                case 5: goto L90;
                case 6: goto L89;
                case 7: goto L87;
                case 8: goto L86;
                case 9: goto L85;
                case 10: goto L83;
                case 11: goto L82;
                case 12: goto L81;
                case 13: goto L80;
                case 14: goto L79;
                case 15: goto L78;
                case 16: goto L77;
                case 17: goto L76;
                case 18: goto L75;
                case 19: goto L74;
                case 20: goto L73;
                case 21: goto L72;
                case 22: goto L71;
                case 23: goto L70;
                case 24: goto L69;
                case 25: goto L68;
                case 26: goto L67;
                case 27: goto L66;
                case 28: goto L65;
                case 29: goto L64;
                case 30: goto L63;
                case 31: goto L62;
                case 32: goto L61;
                case 33: goto L60;
                case 34: goto L59;
                case 35: goto L58;
                case 36: goto L57;
                case 37: goto L56;
                case 38: goto L55;
                case 39: goto L54;
                case 40: goto L53;
                case 41: goto L52;
                case 42: goto L51;
                case 43: goto L50;
                case 44: goto L49;
                case 45: goto L48;
                case 46: goto L47;
                case 47: goto L46;
                case 48: goto L45;
                case 49: goto L44;
                case 50: goto L43;
                case 51: goto L42;
                case 52: goto L41;
                case 53: goto L40;
                case 54: goto L39;
                case 55: goto L38;
                case 56: goto L37;
                case 57: goto L36;
                case 58: goto L35;
                case 59: goto L34;
                case 60: goto L33;
                case 61: goto L32;
                case 62: goto L31;
                case 63: goto L30;
                case 64: goto L29;
                case 65: goto L28;
                case 66: goto L27;
                case 67: goto L26;
                case 68: goto L25;
                case 69: goto L24;
                case 70: goto L23;
                case 71: goto L22;
                case 72: goto L21;
                case 73: goto L20;
                case 74: goto L19;
                case 75: goto L18;
                case 76: goto L17;
                case 77: goto L16;
                case 78: goto L15;
                case 79: goto L14;
                default: goto L13;
            };
        L14:
            int r8 = r12.readInt();
            int r10 = r12.readInt();
            Client r15 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            Parcelable r16 = getDiagInfo(r8, r10, r15);
        L84:
            r13.writeNoException();
            r13.writeTypedObject(r16, 1);
        L97:
            return true;
        L15:
            int r17 = r12.readInt();
            int r18 = r12.readInt();
            Client r19 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = lockNrBand(r17, r18, r19);
            goto L84
        L16:
            int r20 = r12.readInt();
            int r21 = r12.readInt();
            Client r22 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = lockLteBand(r20, r21, r22);
            goto L84
        L17:
            int r23 = r12.readInt();
            int r24 = r12.readInt();
            int r25 = r12.readInt();
            int r26 = r12.readInt();
            int r27 = r12.readInt();
            Client r28 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = lockNrCell(r23, r24, r25, r26, r27, r28);
            goto L84
        L18:
            int r29 = r12.readInt();
            int r30 = r12.readInt();
            int r31 = r12.readInt();
            Client r32 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = lockLteCell(r29, r30, r31, r32);
            goto L84
        L19:
            int r33 = r12.readInt();
            r12.enforceNoDataAvail();
            int[] r34 = getSimPinRetryTimes(r33);
            r13.writeNoException();
            r13.writeIntArray(r34);
            goto L97
        L20:
            int r35 = r12.readInt();
            boolean r36 = r12.readBoolean();
            Client r37 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = disableEndc(r35, r36, r37);
            goto L84
        L21:
            int r38 = r12.readInt();
            Client r39 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = queryNrIcon(r38, r39);
            goto L84
        L22:
            int r40 = r12.readInt();
            r12.enforceNoDataAvail();
            r16 = getCiwlanModeUserPreference(r40);
            goto L84
        L23:
            int r41 = r12.readInt();
            Client r42 = (Client) r12.readTypedObject(Client.CREATOR);
            CiwlanConfig r43 = (CiwlanConfig) r12.readTypedObject(CiwlanConfig.CREATOR);
            r12.enforceNoDataAvail();
            r16 = setCiwlanModeUserPreference(r41, r42, r43);
            goto L84
        L24:
            int r44 = r12.readInt();
            r12.enforceNoDataAvail();
            boolean r45 = isCiwlanAvailable(r44);
        L94:
            r13.writeNoException();
            r13.writeBoolean(r45);
            goto L97
        L25:
            Client r46 = (Client) r12.readTypedObject(Client.CREATOR);
            int r47 = r12.readInt();
            CellularRoamingPreference r48 = (CellularRoamingPreference) r12.readTypedObject(CellularRoamingPreference.CREATOR);
            r12.enforceNoDataAvail();
            r16 = setCellularRoamingPreference(r46, r47, r48);
            goto L84
        L26:
            int r49 = r12.readInt();
            r12.enforceNoDataAvail();
            r16 = getCellularRoamingPreference(r49);
            goto L84
        L27:
            Client r50 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = getDdsSwitchConfigCapability(r50);
            goto L84
        L28:
            boolean[] r51 = r12.createBooleanArray();
            Client r52 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = sendUserPreferenceConfigForDataDuringVoiceCall(r51, r52);
            goto L84
        L29:
            int r53 = r12.readInt();
            r12.enforceNoDataAvail();
            r16 = getSimPersoUnlockStatus(r53);
            goto L84
        L30:
            Client r54 = (Client) r12.readTypedObject(Client.CREATOR);
            boolean r55 = r12.readBoolean();
            r12.enforceNoDataAvail();
            r16 = setDualDataUserPreference(r54, r55);
            goto L84
        L31:
            r45 = getDualDataCapability();
            goto L94
        L32:
            int r56 = r12.readInt();
            r12.enforceNoDataAvail();
            r16 = getCiwlanConfig(r56);
            goto L84
        L33:
            Client r57 = (Client) r12.readTypedObject(Client.CREATOR);
            QtiSimType[] r58 = (QtiSimType[]) r12.createTypedArray(QtiSimType.CREATOR);
            r12.enforceNoDataAvail();
            r16 = setSimType(r57, r58);
            goto L84
        L34:
            QtiSimType[] r59 = getSupportedSimTypes();
            r13.writeNoException();
            r13.writeTypedArray(r59, 1);
            goto L97
        L35:
            QtiSimType[] r60 = getCurrentSimType();
            r13.writeNoException();
            r13.writeTypedArray(r60, 1);
            goto L97
        L36:
            Client r61 = (Client) r12.readTypedObject(Client.CREATOR);
            MsimPreference r62 = (MsimPreference) r12.readTypedObject(MsimPreference.CREATOR);
            r12.enforceNoDataAvail();
            r16 = setMsimPreference(r61, r62);
            goto L84
        L37:
            Client r63 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = getSecureModeStatus(r63);
            goto L84
        L38:
            int r64 = r12.readInt();
            int r65 = r12.readInt();
            Client r66 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = getQosParameters(r64, r65, r66);
            goto L84
        L39:
            int r67 = r12.readInt();
            r12.enforceNoDataAvail();
            r45 = isEpdgOverCellularDataSupported(r67);
            goto L94
        L40:
            int r68 = r12.readInt();
            boolean r69 = r12.readBoolean();
            Client r70 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = sendUserPreferenceForDataDuringVoiceCall(r68, r69, r70);
            goto L84
        L41:
            int r71 = r12.readInt();
            Client r72 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = getDdsSwitchCapability(r71, r72);
            goto L84
        L42:
            QtiImeiInfo[] r73 = getImeiInfo();
            r13.writeNoException();
            r13.writeTypedArray(r73, 1);
            goto L97
        L43:
            int r74 = r12.readInt();
            r12.enforceNoDataAvail();
            r45 = isFeatureSupported(r74);
            goto L94
        L44:
            int r75 = r12.readInt();
            String r76 = r12.readString();
            String r77 = r12.readString();
            r12.enforceNoDataAvail();
            r45 = verifySimPukChangePin(r75, r76, r77);
            goto L94
        L45:
            int r78 = r12.readInt();
            String r79 = r12.readString();
            r12.enforceNoDataAvail();
            r45 = verifySimPin(r78, r79);
            goto L94
        L46:
            int r80 = r12.readInt();
            boolean r81 = r12.readBoolean();
            String r82 = r12.readString();
            r12.enforceNoDataAvail();
            r45 = toggleSimPinLock(r80, r81, r82);
            goto L94
        L47:
            int r83 = r12.readInt();
            r12.enforceNoDataAvail();
            r45 = checkSimPinLockStatus(r83);
            goto L94
        L48:
            r45 = getAirplaneMode();
            goto L94
        L49:
            boolean r84 = r12.readBoolean();
            r12.enforceNoDataAvail();
            r45 = setAirplaneMode(r84);
            goto L94
        L50:
            boolean r85 = r12.readBoolean();
            Client r86 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            setSmartDdsSwitchToggle(r85, r86);
        L88:
            r13.writeNoException();
            goto L97
        L51:
            r45 = isSmartDdsSwitchFeatureAvailable();
            goto L94
        L52:
            int r87 = r12.readInt();
            String r88 = r12.readString();
            String r89 = r12.readString();
            int r90 = r12.readInt();
            String r91 = r12.readString();
            boolean r92 = r12.readBoolean();
            Client r93 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            getFacilityLockForApp(r87, r88, r89, r90, r91, r92, r93);
            goto L88
        L53:
            int r94 = r12.readInt();
            int r95 = r12.readInt();
            int r96 = r12.readInt();
            String r97 = r12.readString();
            boolean r98 = r12.readBoolean();
            Client r99 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            queryCallForwardStatus(r94, r95, r96, r97, r98, r99);
            goto L88
        L54:
            int r100 = r12.readInt();
            ImsiEncryptionInfo r101 = (ImsiEncryptionInfo) r12.readTypedObject(ImsiEncryptionInfo.CREATOR);
            Client r102 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = setCarrierInfoForImsiEncryption(r100, r101, r102);
            goto L84
        L55:
            int r103 = r12.readInt();
            Client r104 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = query5gConfigInfo(r103, r104);
            goto L84
        L56:
            int r105 = r12.readInt();
            Client r106 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = queryUpperLayerIndInfo(r105, r106);
            goto L84
        L57:
            int r107 = r12.readInt();
            Client r108 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = queryNrSignalStrength(r107, r108);
            goto L84
        L58:
            int r109 = r12.readInt();
            Client r110 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = queryNrDcParam(r109, r110);
            goto L84
        L59:
            int r111 = r12.readInt();
            Client r112 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = query5gStatus(r111, r112);
            goto L84
        L60:
            int r113 = r12.readInt();
            Client r114 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = enable5gOnly(r113, r114);
            goto L84
        L61:
            int r115 = r12.readInt();
            Client r116 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = queryNrBearerAllocation(r115, r116);
            goto L84
        L62:
            int r117 = r12.readInt();
            Client r118 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = disable5g(r117, r118);
            goto L84
        L63:
            int r119 = r12.readInt();
            Client r120 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = enable5g(r119, r120);
            goto L84
        L64:
            int r121 = r12.readInt();
            Client r122 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = getQtiRadioCapability(r121, r122);
            goto L84
        L65:
            int r123 = r12.readInt();
            byte[] r124 = r12.createByteArray();
            boolean r125 = r12.readBoolean();
            Client r126 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = sendCdmaSms(r123, r124, r125, r126);
            goto L84
        L66:
            int r127 = r12.readInt();
            Client r128 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = queryNrConfig(r127, r128);
            goto L84
        L67:
            int r129 = r12.readInt();
            NrConfig r130 = (NrConfig) r12.readTypedObject(NrConfig.CREATOR);
            Client r131 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = setNrConfig(r129, r130, r131);
            goto L84
        L68:
            IExtPhoneCallback r132 = IExtPhoneCallback.Stub.asInterface(r12.readStrongBinder());
            r12.enforceNoDataAvail();
            unregisterQtiRadioConfigCallback(r132);
            goto L88
        L69:
            String r133 = r12.readString();
            IExtPhoneCallback r134 = IExtPhoneCallback.Stub.asInterface(r12.readStrongBinder());
            r12.enforceNoDataAvail();
            r16 = registerQtiRadioConfigCallback(r133, r134);
            goto L84
        L70:
            IExtPhoneCallback r135 = IExtPhoneCallback.Stub.asInterface(r12.readStrongBinder());
            r12.enforceNoDataAvail();
            unRegisterCallback(r135);
            goto L88
        L71:
            String r136 = r12.readString();
            IExtPhoneCallback r137 = IExtPhoneCallback.Stub.asInterface(r12.readStrongBinder());
            int[] r138 = r12.createIntArray();
            r12.enforceNoDataAvail();
            r16 = registerCallbackWithEvents(r136, r137, r138);
            goto L84
        L72:
            String r139 = r12.readString();
            IExtPhoneCallback r140 = IExtPhoneCallback.Stub.asInterface(r12.readStrongBinder());
            r12.enforceNoDataAvail();
            r16 = registerCallback(r139, r140);
            goto L84
        L73:
            int r141 = r12.readInt();
            Client r142 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = queryEndcStatus(r141, r142);
            goto L84
        L74:
            int r143 = r12.readInt();
            boolean r144 = r12.readBoolean();
            Client r145 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = enableEndc(r143, r144, r145);
            goto L84
        L75:
            int r146 = r12.readInt();
            Client r147 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = queryNrIconType(r146, r147);
            goto L84
        L76:
            String r148 = r12.readString();
            String r149 = r12.readString();
            IDepersoResCallback r150 = IDepersoResCallback.Stub.asInterface(r12.readStrongBinder());
            int r151 = r12.readInt();
            r12.enforceNoDataAvail();
            supplyIccDepersonalization(r148, r149, r150, r151);
            goto L88
        L77:
            boolean r152 = r12.readBoolean();
            r12.enforceNoDataAvail();
            setSMSPromptEnabled(r152);
            goto L88
        L78:
            r45 = isSMSPromptEnabled();
            goto L94
        L79:
            int r153 = r12.readInt();
            Client r154 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = getNetworkSelectionMode(r153, r154);
            goto L84
        L80:
            int r155 = r12.readInt();
            int r156 = r12.readInt();
            Client r157 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = setNetworkSelectionModeAutomatic(r155, r156, r157);
            goto L84
        L81:
            int r158 = r12.readInt();
            QtiSetNetworkSelectionMode r159 = (QtiSetNetworkSelectionMode) r12.readTypedObject(QtiSetNetworkSelectionMode.CREATOR);
            Client r160 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = setNetworkSelectionModeManual(r158, r159, r160);
            goto L84
        L82:
            int r161 = r12.readInt();
            Client r162 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = stopNetworkScan(r161, r162);
            goto L84
        L83:
            int r163 = r12.readInt();
            NetworkScanRequest r164 = (NetworkScanRequest) r12.readTypedObject(NetworkScanRequest.CREATOR);
            Client r165 = (Client) r12.readTypedObject(Client.CREATOR);
            r12.enforceNoDataAvail();
            r16 = startNetworkScan(r163, r164, r165);
            goto L84
        L85:
            int r166 = r12.readInt();
            r12.enforceNoDataAvail();
            r45 = abortIncrementalScan(r166);
            goto L94
        L86:
            int r167 = r12.readInt();
            r12.enforceNoDataAvail();
            r45 = performIncrementalScan(r167);
            goto L94
        L87:
            int r168 = r12.readInt();
            r12.enforceNoDataAvail();
            setPrimaryCardOnSlot(r168);
            goto L88
        L89:
            int r169 = r12.readInt();
            r12.enforceNoDataAvail();
            r45 = isPrimaryCarrierSlotId(r169);
            goto L94
        L90:
            int r170 = getPrimaryCarrierSlotId();
        L96:
            r13.writeNoException();
            r13.writeInt(r170);
            goto L97
        L91:
            r170 = getCurrentPrimaryCardSlotId();
            goto L96
        L92:
            String r171 = r12.readString();
            String r172 = r12.readString();
            r12.enforceNoDataAvail();
            String r173 = getPropertyValueString(r171, r172);
            r13.writeNoException();
            r13.writeString(r173);
            goto L97
        L93:
            String r174 = r12.readString();
            boolean r175 = r12.readBoolean();
            r12.enforceNoDataAvail();
            r45 = getPropertyValueBool(r174, r175);
            goto L94
        L95:
            String r176 = r12.readString();
            int r177 = r12.readInt();
            r12.enforceNoDataAvail();
            r170 = getPropertyValueInt(r176, r177);
            goto L96
        L13:
            return super.onTransact(r11, r12, r13, r14);
        }
    }

    boolean abortIncrementalScan(int r8);

    boolean checkSimPinLockStatus(int r8);

    @Deprecated
    Token disable5g(int r8, Client r10);

    Token disableEndc(int r8, boolean r10, Client r11);

    @Deprecated
    Token enable5g(int r8, Client r10);

    @Deprecated
    Token enable5gOnly(int r8, Client r10);

    Token enableEndc(int r8, boolean r10, Client r11);

    boolean getAirplaneMode();

    CellularRoamingPreference getCellularRoamingPreference(int r8);

    CiwlanConfig getCiwlanConfig(int r8);

    CiwlanConfig getCiwlanModeUserPreference(int r8);

    int getCurrentPrimaryCardSlotId();

    QtiSimType[] getCurrentSimType();

    Token getDdsSwitchCapability(int r8, Client r10);

    Token getDdsSwitchConfigCapability(Client r8);

    Token getDiagInfo(int r8, int r10, Client r11);

    boolean getDualDataCapability();

    void getFacilityLockForApp(int r8, String r10, String r11, int r12, String r13, boolean r14, Client r15);

    QtiImeiInfo[] getImeiInfo();

    Token getNetworkSelectionMode(int r8, Client r10);

    int getPrimaryCarrierSlotId();

    boolean getPropertyValueBool(String r8, boolean r10);

    int getPropertyValueInt(String r8, int r10);

    String getPropertyValueString(String r8, String r10);

    Token getQosParameters(int r8, int r10, Client r11);

    Token getQtiRadioCapability(int r8, Client r10);

    Token getSecureModeStatus(Client r8);

    QtiPersoUnlockStatus getSimPersoUnlockStatus(int r8);

    int[] getSimPinRetryTimes(int r8);

    QtiSimType[] getSupportedSimTypes();

    boolean isCiwlanAvailable(int r8);

    boolean isEpdgOverCellularDataSupported(int r8);

    boolean isFeatureSupported(int r8);

    boolean isPrimaryCarrierSlotId(int r8);

    boolean isSMSPromptEnabled();

    boolean isSmartDdsSwitchFeatureAvailable();

    Token lockLteBand(int r8, int r10, Client r11);

    Token lockLteCell(int r8, int r10, int r11, Client r12);

    Token lockNrBand(int r8, int r10, Client r11);

    Token lockNrCell(int r8, int r10, int r11, int r12, int r13, Client r14);

    boolean performIncrementalScan(int r8);

    @Deprecated
    Token query5gConfigInfo(int r8, Client r10);

    @Deprecated
    Token query5gStatus(int r8, Client r10);

    void queryCallForwardStatus(int r8, int r10, int r11, String r12, boolean r13, Client r14);

    Token queryEndcStatus(int r8, Client r10);

    @Deprecated
    Token queryNrBearerAllocation(int r8, Client r10);

    Token queryNrConfig(int r8, Client r10);

    @Deprecated
    Token queryNrDcParam(int r8, Client r10);

    Token queryNrIcon(int r8, Client r10);

    @Deprecated
    Token queryNrIconType(int r8, Client r10);

    @Deprecated
    Token queryNrSignalStrength(int r8, Client r10);

    @Deprecated
    Token queryUpperLayerIndInfo(int r8, Client r10);

    Client registerCallback(String r8, IExtPhoneCallback r10);

    Client registerCallbackWithEvents(String r8, IExtPhoneCallback r10, int[] r11);

    Client registerQtiRadioConfigCallback(String r8, IExtPhoneCallback r10);

    Token sendCdmaSms(int r8, byte[] r10, boolean r11, Client r12);

    Token sendUserPreferenceConfigForDataDuringVoiceCall(boolean[] r8, Client r10);

    Token sendUserPreferenceForDataDuringVoiceCall(int r8, boolean r10, Client r11);

    boolean setAirplaneMode(boolean r8);

    Token setCarrierInfoForImsiEncryption(int r8, ImsiEncryptionInfo r10, Client r11);

    Token setCellularRoamingPreference(Client r8, int r10, CellularRoamingPreference r11);

    Token setCiwlanModeUserPreference(int r8, Client r10, CiwlanConfig r11);

    Token setDualDataUserPreference(Client r8, boolean r10);

    Token setMsimPreference(Client r8, MsimPreference r10);

    Token setNetworkSelectionModeAutomatic(int r8, int r10, Client r11);

    Token setNetworkSelectionModeManual(int r8, QtiSetNetworkSelectionMode r10, Client r11);

    Token setNrConfig(int r8, NrConfig r10, Client r11);

    void setPrimaryCardOnSlot(int r8);

    void setSMSPromptEnabled(boolean r8);

    Token setSimType(Client r8, QtiSimType[] r10);

    void setSmartDdsSwitchToggle(boolean r8, Client r10);

    Token startNetworkScan(int r8, NetworkScanRequest r10, Client r11);

    Token stopNetworkScan(int r8, Client r10);

    void supplyIccDepersonalization(String r8, String r10, IDepersoResCallback r11, int r12);

    boolean toggleSimPinLock(int r8, boolean r10, String r11);

    void unRegisterCallback(IExtPhoneCallback r8);

    void unregisterQtiRadioConfigCallback(IExtPhoneCallback r8);

    boolean verifySimPin(int r8, String r10);

    boolean verifySimPukChangePin(int r8, String r10, String r11);
}
