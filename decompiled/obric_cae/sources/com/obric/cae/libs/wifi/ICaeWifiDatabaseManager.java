package com.obric.cae.libs.wifi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeWifiDatabaseManager extends IInterface {

    public static class Default implements ICaeWifiDatabaseManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
        public int getCountByBssidAndRssi(String r8, int r10) {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
        public int getThroughputByBssidAndRssi(String r8, int r10) {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
        public int getTriggerScanTput() {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
        public int getWifiQoeScore() {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ICaeWifiDatabaseManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ICaeWifiDatabaseManager";
        static final int TRANSACTION_getCountByBssidAndRssi = 2;
        static final int TRANSACTION_getThroughputByBssidAndRssi = 1;
        static final int TRANSACTION_getTriggerScanTput = 3;
        static final int TRANSACTION_getWifiQoeScore = 4;

        public static class Proxy implements ICaeWifiDatabaseManager {
            public static ICaeWifiDatabaseManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
            public int getCountByBssidAndRssi(String r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeString(r8);     // Catch: Throwable -> L12
                r11.writeInt(r10);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L12
                int r13 = r12.readInt();     // Catch: Throwable -> L12
            L8:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r13 = Stub.getDefaultImpl().getCountByBssidAndRssi(r8, r10);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
            public int getThroughputByBssidAndRssi(String r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeString(r8);     // Catch: Throwable -> L12
                r11.writeInt(r10);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L12
                int r13 = r12.readInt();     // Catch: Throwable -> L12
            L8:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r13 = Stub.getDefaultImpl().getThroughputByBssidAndRssi(r8, r10);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
            public int getTriggerScanTput() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                int r11 = r10.readInt();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getTriggerScanTput();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
            public int getWifiQoeScore() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                int r11 = r10.readInt();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getWifiQoeScore();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeWifiDatabaseManager asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeWifiDatabaseManager) == false) goto L12;
            return (ICaeWifiDatabaseManager) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeWifiDatabaseManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeWifiDatabaseManager r8) {
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
            if (r8 == 1598968902) goto L19;
            if (r8 != 1) goto L6;
            r10.enforceInterface(DESCRIPTOR);
            int r13 = getThroughputByBssidAndRssi(r10.readString(), r10.readInt());
        L14:
            r11.writeNoException();
            r11.writeInt(r13);
            return true;
        L6:
            if (r8 != 2) goto L8;
            r10.enforceInterface(DESCRIPTOR);
            r13 = getCountByBssidAndRssi(r10.readString(), r10.readInt());
            goto L14
        L8:
            if (r8 != 3) goto L10;
            r10.enforceInterface(DESCRIPTOR);
            r13 = getTriggerScanTput();
            goto L14
        L10:
            if (r8 != 4) goto L12;
            r10.enforceInterface(DESCRIPTOR);
            r13 = getWifiQoeScore();
            goto L14
        L12:
            return super.onTransact(r8, r10, r11, r12);
        L19:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getCountByBssidAndRssi(String r8, int r10);

    int getThroughputByBssidAndRssi(String r8, int r10);

    int getTriggerScanTput();

    int getWifiQoeScore();
}
