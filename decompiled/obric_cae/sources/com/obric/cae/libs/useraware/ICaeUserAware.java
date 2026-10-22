package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeUserAware extends IInterface {
    public static final int ENTER_COMPANY_GEOFENCE_EVENT = 3;
    public static final int ENTER_HOME_GEOFENCE_EVENT = 1;
    public static final int EXIT_COMPANY_GEOFENCE_EVENT = 4;
    public static final int EXIT_HOEM_GEOFENCE_EVENT = 2;
    public static final int LEVEL1_MODEL_RESULT = 1;
    public static final int LEVEL2_MODEL_RESULT = 2;
    public static final int MASK_SCAN_AUDIO = 16;
    public static final int MASK_SCAN_BT = 2;
    public static final int MASK_SCAN_CELL = 4;
    public static final int MASK_SCAN_LOCATION = 8;
    public static final int MASK_SCAN_WIFI = 1;
    public static final int MASK_SENSOR_ACCELEROMETER = 32;
    public static final int MASK_SENSOR_GYROSCOPE = 128;
    public static final int MASK_SENSOR_LIGHT = 1024;
    public static final int MASK_SENSOR_LINEAR_ACCELERATION = 64;
    public static final int MASK_SENSOR_MAGNETIC_FIELD = 256;
    public static final int MASK_SENSOR_ORIENTATION = 8192;
    public static final int MASK_SENSOR_OUT_ELEVATOR = 4096;
    public static final int MASK_SENSOR_PRESSURE = 2048;
    public static final int MASK_SENSOR_PROXIMITY = 16384;
    public static final int MASK_SENSOR_ROTATION_MATRIX = 32768;
    public static final int MASK_SENSOR_STEP_COUNTER = 512;
    public static final int PREDICTED_ENTER_ROOM_EVENT = 1;
    public static final int PREDICTED_EXIT_ROOM_EVENT = 2;
    public static final String USER_AWARE_REPORT_HAR_FEEDBACK_INFO = "useraware_HAR_feedback_info";
    public static final String USER_AWARE_REPORT_HAR_STATE_INFO = "useraware_HAR_state_info";
    public static final String USER_AWARE_REPORT_NEAR_ELEVATOR_INFO = "useraware_near_elevator_info";
    public static final String USER_AWARE_REPORT_STAR_GEOFENCE_INFO = "useraware_star_geofence_info";
    public static final String USER_AWARE_REPORT_STAR_ZPP_INFO = "useraware_star_zpp_info";
    public static final String USER_AWARE_REPORT_USER_FEEDBACK_INFO = "useraware_user_feedback_info";
    public static final String USER_AWARE_REPORT_WIFI_CONNECT_INFO = "useraware_wifi_conn_info";
    public static final String USER_AWARE_REPORT_WIFI_PNO_STATS = "useraware_wifi_pno_stats";
    public static final String USER_AWARE_REPORT_WIFI_SCAN_COUNT = "useraware_wifi_scan_count";
    public static final String USER_AWARE_REPORT_WIFI_SCAN_INFO = "useraware_wifi_scan_info";

    public static class Default implements ICaeUserAware {
        public Default() {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void addBssidsToAvoidRomingScan(List<String> r8) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void addHomeWifiBssids(List<String> r8) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void clearHomeWifiBssids() {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public HarMonitorParams getHarMonitorParams() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyGeofenceChanged(int r8) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyHarEvent(HarEventData r8) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyLearningSuccess(boolean r8) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyRoomChangedPredicted(int r8) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void registerCallback(ICaeUserAwareCallback r8) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r8) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setHarMonitorParams(HarMonitorParams r8) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setHarState(int r8, long r10, int r11) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setLevel2DataCollection(List<HarLevel2DataReq> r8, int r10, HarLevel2DataResp r11) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setWifiRssiTriggerThresholds(int r8, int r10, int r11, int r12, int r13) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void unregisterCallback(ICaeUserAwareCallback r8) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r8) {
        }
    }

    public static abstract class Stub extends Binder implements ICaeUserAware {
        private static final String DESCRIPTOR = "com.obric.cae.libs.useraware.ICaeUserAware";
        static final int TRANSACTION_addBssidsToAvoidRomingScan = 7;
        static final int TRANSACTION_addHomeWifiBssids = 3;
        static final int TRANSACTION_clearHomeWifiBssids = 4;
        static final int TRANSACTION_getHarMonitorParams = 13;
        static final int TRANSACTION_notifyGeofenceChanged = 6;
        static final int TRANSACTION_notifyHarEvent = 14;
        static final int TRANSACTION_notifyLearningSuccess = 16;
        static final int TRANSACTION_notifyRoomChangedPredicted = 5;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_registerSmartBluetoothEvent = 10;
        static final int TRANSACTION_setHarMonitorParams = 12;
        static final int TRANSACTION_setHarState = 8;
        static final int TRANSACTION_setLevel2DataCollection = 9;
        static final int TRANSACTION_setWifiRssiTriggerThresholds = 15;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_unregisterSmartBluetoothEvent = 11;

        public static class Proxy implements ICaeUserAware {
            public static ICaeUserAware sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void addBssidsToAvoidRomingScan(List<String> r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeStringList(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().addBssidsToAvoidRomingScan(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void addHomeWifiBssids(List<String> r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeStringList(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().addHomeWifiBssids(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void clearHomeWifiBssids() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().clearHomeWifiBssids();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public HarMonitorParams getHarMonitorParams() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                if (this.mRemote.transact(13, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L15
                if (r10.readInt() == 0) goto L14;
                HarMonitorParams r11 = HarMonitorParams.CREATOR.createFromParcel(r10);     // Catch: Throwable -> L15
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L14:
                r11 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getHarMonitorParams();     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyGeofenceChanged(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyGeofenceChanged(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyHarEvent(HarEventData r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(14, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyHarEvent(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyLearningSuccess(boolean r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(16, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyLearningSuccess(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyRoomChangedPredicted(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyRoomChangedPredicted(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void registerCallback(ICaeUserAwareCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(10, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerSmartBluetoothEvent(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setHarMonitorParams(HarMonitorParams r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(12, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setHarMonitorParams(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setHarState(int r8, long r10, int r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r12.writeInt(r8);     // Catch: Throwable -> L12
                r12.writeLong(r10);     // Catch: Throwable -> L12
                r12.writeInt(r11);     // Catch: Throwable -> L12
                if (this.mRemote.transact(8, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L12
            L8:
                r13.recycle();
                r12.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setHarState(r8, r10, r11);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setLevel2DataCollection(List<HarLevel2DataReq> r8, int r10, HarLevel2DataResp r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r12.writeTypedList(r8);     // Catch: Throwable -> L16
                r12.writeInt(r10);     // Catch: Throwable -> L16
                if (r11 == null) goto L6;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L16
            L7:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L16
                if (this.mRemote.transact(9, r12, r13, 0) == false) goto L10;
            L14:
                r13.readException();     // Catch: Throwable -> L16
            L12:
                r13.recycle();
                r12.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setLevel2DataCollection(r8, r10, r11);     // Catch: Throwable -> L16
                goto L12
            L6:
                r14 = null;
            L16:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setWifiRssiTriggerThresholds(int r10, int r11, int r12, int r13, int r14) {
                Parcel r8 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r8.writeInt(r10);     // Catch: Throwable -> L12
                r8.writeInt(r11);     // Catch: Throwable -> L12
                r8.writeInt(r12);     // Catch: Throwable -> L12
                r8.writeInt(r13);     // Catch: Throwable -> L12
                r8.writeInt(r14);     // Catch: Throwable -> L12
                if (this.mRemote.transact(15, r8, r15, 0) == false) goto L6;
            L10:
                r15.readException();     // Catch: Throwable -> L12
            L8:
                r15.recycle();
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setWifiRssiTriggerThresholds(r10, r11, r12, r13, r14);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r15.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void unregisterCallback(ICaeUserAwareCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(11, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterSmartBluetoothEvent(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeUserAware asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeUserAware) == false) goto L12;
            return (ICaeUserAware) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeUserAware getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeUserAware r8) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r8 == null) goto L7;
            Proxy.sDefaultImpl = r8;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 == 1598968902) goto L39;
            boolean r8 = false;
            HarMonitorParams r14 = null;
            HarEventData r15 = null;
            switch(r10) {
                case 1: goto L38;
                case 2: goto L37;
                case 3: goto L36;
                case 4: goto L35;
                case 5: goto L34;
                case 6: goto L33;
                case 7: goto L32;
                case 8: goto L31;
                case 9: goto L30;
                case 10: goto L29;
                case 11: goto L28;
                case 12: goto L24;
                case 13: goto L19;
                case 14: goto L15;
                case 15: goto L14;
                case 16: goto L8;
                default: goto L7;
            };
        L8:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L11;
            r8 = true;
        L11:
            notifyLearningSuccess(r8);
        L12:
            r12.writeNoException();
            return true;
        L14:
            r11.enforceInterface(DESCRIPTOR);
            setWifiRssiTriggerThresholds(r11.readInt(), r11.readInt(), r11.readInt(), r11.readInt(), r11.readInt());
            goto L12
        L15:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L18;
            r15 = HarEventData.CREATOR.createFromParcel(r11);
        L18:
            notifyHarEvent(r15);
            goto L12
        L19:
            r11.enforceInterface(DESCRIPTOR);
            HarMonitorParams r16 = getHarMonitorParams();
            r12.writeNoException();
            if (r16 == null) goto L22;
            r12.writeInt(1);
            r16.writeToParcel(r12, 1);
        L23:
            return true;
        L22:
            r12.writeInt(0);
            goto L23
        L24:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L27;
            r14 = HarMonitorParams.CREATOR.createFromParcel(r11);
        L27:
            setHarMonitorParams(r14);
            goto L12
        L28:
            r11.enforceInterface(DESCRIPTOR);
            unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L12
        L29:
            r11.enforceInterface(DESCRIPTOR);
            registerSmartBluetoothEvent(ISmartBluetoothEventCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L12
        L30:
            r11.enforceInterface(DESCRIPTOR);
            setLevel2DataCollection(r11.createTypedArrayList(HarLevel2DataReq.CREATOR), r11.readInt(), HarLevel2DataResp.Stub.asInterface(r11.readStrongBinder()));
            goto L12
        L31:
            r11.enforceInterface(DESCRIPTOR);
            setHarState(r11.readInt(), r11.readLong(), r11.readInt());
            goto L12
        L32:
            r11.enforceInterface(DESCRIPTOR);
            addBssidsToAvoidRomingScan(r11.createStringArrayList());
            goto L12
        L33:
            r11.enforceInterface(DESCRIPTOR);
            notifyGeofenceChanged(r11.readInt());
            goto L12
        L34:
            r11.enforceInterface(DESCRIPTOR);
            notifyRoomChangedPredicted(r11.readInt());
            goto L12
        L35:
            r11.enforceInterface(DESCRIPTOR);
            clearHomeWifiBssids();
            goto L12
        L36:
            r11.enforceInterface(DESCRIPTOR);
            addHomeWifiBssids(r11.createStringArrayList());
            goto L12
        L37:
            r11.enforceInterface(DESCRIPTOR);
            unregisterCallback(ICaeUserAwareCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L12
        L38:
            r11.enforceInterface(DESCRIPTOR);
            registerCallback(ICaeUserAwareCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L12
        L7:
            return super.onTransact(r10, r11, r12, r13);
        L39:
            r12.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addBssidsToAvoidRomingScan(List<String> r8);

    void addHomeWifiBssids(List<String> r8);

    void clearHomeWifiBssids();

    HarMonitorParams getHarMonitorParams();

    void notifyGeofenceChanged(int r8);

    void notifyHarEvent(HarEventData r8);

    void notifyLearningSuccess(boolean r8);

    void notifyRoomChangedPredicted(int r8);

    void registerCallback(ICaeUserAwareCallback r8);

    void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r8);

    void setHarMonitorParams(HarMonitorParams r8);

    void setHarState(int r8, long r10, int r11);

    void setLevel2DataCollection(List<HarLevel2DataReq> r8, int r10, HarLevel2DataResp r11);

    void setWifiRssiTriggerThresholds(int r8, int r10, int r11, int r12, int r13);

    void unregisterCallback(ICaeUserAwareCallback r8);

    void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r8);
}
