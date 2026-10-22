package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeUserAwareCallback extends IInterface {

    public static class Default implements ICaeUserAwareCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onCellInfoChange(CellAwareInfo r8) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onCellNeighbourInfoChange(List<CellAwareInfo> r8) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onInSubWayChange(int r8, String r10) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onUserAwareReportData(String r8, String r10) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiConnectInfoChanged(WifiStandardData r8) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiNetworkAvailable(boolean r8) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiScanInfoChanged(List<WifiStandardData> r8) {
        }
    }

    public static abstract class Stub extends Binder implements ICaeUserAwareCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.useraware.ICaeUserAwareCallback";
        static final int TRANSACTION_onCellInfoChange = 4;
        static final int TRANSACTION_onCellNeighbourInfoChange = 5;
        static final int TRANSACTION_onInSubWayChange = 7;
        static final int TRANSACTION_onUserAwareReportData = 6;
        static final int TRANSACTION_onWifiConnectInfoChanged = 2;
        static final int TRANSACTION_onWifiNetworkAvailable = 3;
        static final int TRANSACTION_onWifiScanInfoChanged = 1;

        public static class Proxy implements ICaeUserAwareCallback {
            public static ICaeUserAwareCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onCellInfoChange(CellAwareInfo r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(4, r10, null, 1) == false) goto L10;
            L14:
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onCellInfoChange(r8);     // Catch: Throwable -> L16
                r10.recycle();
                return;
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onCellNeighbourInfoChange(List<CellAwareInfo> r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeTypedList(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r10, null, 1) == false) goto L6;
            L10:
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onCellNeighbourInfoChange(r8);     // Catch: Throwable -> L12
                r10.recycle();
                return;
            L12:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onInSubWayChange(int r8, String r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeInt(r8);     // Catch: Throwable -> L12
                r11.writeString(r10);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r11, null, 1) == false) goto L6;
            L10:
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onInSubWayChange(r8, r10);     // Catch: Throwable -> L12
                r11.recycle();
                return;
            L12:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onUserAwareReportData(String r8, String r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeString(r8);     // Catch: Throwable -> L12
                r11.writeString(r10);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r11, null, 1) == false) goto L6;
            L10:
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onUserAwareReportData(r8, r10);     // Catch: Throwable -> L12
                r11.recycle();
                return;
            L12:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiConnectInfoChanged(WifiStandardData r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(2, r10, null, 1) == false) goto L10;
            L14:
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onWifiConnectInfoChanged(r8);     // Catch: Throwable -> L16
                r10.recycle();
                return;
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiNetworkAvailable(boolean r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r10, null, 1) == false) goto L6;
            L10:
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onWifiNetworkAvailable(r8);     // Catch: Throwable -> L12
                r10.recycle();
                return;
            L12:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiScanInfoChanged(List<WifiStandardData> r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeTypedList(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r10, null, 1) == false) goto L6;
            L10:
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onWifiScanInfoChanged(r8);     // Catch: Throwable -> L12
                r10.recycle();
                return;
            L12:
                th = move-exception;
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeUserAwareCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeUserAwareCallback) == false) goto L12;
            return (ICaeUserAwareCallback) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeUserAwareCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeUserAwareCallback r8) {
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
        public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 == 1598968902) goto L32;
            WifiStandardData r13 = null;
            CellAwareInfo r14 = null;
            switch(r8) {
                case 1: goto L30;
                case 2: goto L25;
                case 3: goto L19;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface(DESCRIPTOR);
            onInSubWayChange(r10.readInt(), r10.readString());
            return true;
        L10:
            r10.enforceInterface(DESCRIPTOR);
            onUserAwareReportData(r10.readString(), r10.readString());
            return true;
        L12:
            r10.enforceInterface(DESCRIPTOR);
            onCellNeighbourInfoChange(r10.createTypedArrayList(CellAwareInfo.CREATOR));
            return true;
        L14:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L17;
            r14 = CellAwareInfo.CREATOR.createFromParcel(r10);
        L17:
            onCellInfoChange(r14);
            return true;
        L19:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L22;
            boolean r15 = true;
        L23:
            onWifiNetworkAvailable(r15);
            return true;
        L22:
            r15 = false;
            goto L23
        L25:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L28;
            r13 = WifiStandardData.CREATOR.createFromParcel(r10);
        L28:
            onWifiConnectInfoChanged(r13);
            return true;
        L30:
            r10.enforceInterface(DESCRIPTOR);
            onWifiScanInfoChanged(r10.createTypedArrayList(WifiStandardData.CREATOR));
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        L32:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onCellInfoChange(CellAwareInfo r8);

    void onCellNeighbourInfoChange(List<CellAwareInfo> r8);

    void onInSubWayChange(int r8, String r10);

    void onUserAwareReportData(String r8, String r10);

    void onWifiConnectInfoChanged(WifiStandardData r8);

    void onWifiNetworkAvailable(boolean r8);

    void onWifiScanInfoChanged(List<WifiStandardData> r8);
}
