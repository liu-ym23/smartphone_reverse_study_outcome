package com.obric.cae.libs.wifi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeWifiAdapter extends IInterface {

    public static class Default implements ICaeWifiAdapter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public int getRoamRssiThreshold(int r8) {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public boolean setLatencyLevel(int r8, int r10) {
            return false;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public boolean setRoamRssiThreshold(int r8, int r10) {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICaeWifiAdapter {
        private static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ICaeWifiAdapter";
        static final int TRANSACTION_getRoamRssiThreshold = 3;
        static final int TRANSACTION_setLatencyLevel = 1;
        static final int TRANSACTION_setRoamRssiThreshold = 2;

        public static class Proxy implements ICaeWifiAdapter {
            public static ICaeWifiAdapter sDefaultImpl;
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

            @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
            public int getRoamRssiThreshold(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
                int r12 = r11.readInt();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r12 = Stub.getDefaultImpl().getRoamRssiThreshold(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
            public boolean setLatencyLevel(int r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r11.writeInt(r8);     // Catch: Throwable -> L15
                r11.writeInt(r10);     // Catch: Throwable -> L15
                boolean r13 = false;
                if (this.mRemote.transact(1, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L15
                if (r12.readInt() == 0) goto L13;
                r13 = true;
            L13:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r14 = Stub.getDefaultImpl().setLatencyLevel(r8, r10);     // Catch: Throwable -> L15
                r12.recycle();
                r11.recycle();
                return r14;
            L15:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
            public boolean setRoamRssiThreshold(int r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r11.writeInt(r8);     // Catch: Throwable -> L15
                r11.writeInt(r10);     // Catch: Throwable -> L15
                boolean r13 = false;
                if (this.mRemote.transact(2, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L15
                if (r12.readInt() == 0) goto L13;
                r13 = true;
            L13:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r14 = Stub.getDefaultImpl().setRoamRssiThreshold(r8, r10);     // Catch: Throwable -> L15
                r12.recycle();
                r11.recycle();
                return r14;
            L15:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeWifiAdapter asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeWifiAdapter) == false) goto L12;
            return (ICaeWifiAdapter) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeWifiAdapter getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeWifiAdapter r8) {
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
            if (r8 != 1) goto L5;
            r10.enforceInterface(DESCRIPTOR);
            int r13 = setLatencyLevel(r10.readInt(), r10.readInt());
        L15:
            r11.writeNoException();
            r11.writeInt(r13);
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            r13 = setRoamRssiThreshold(r10.readInt(), r10.readInt());
            goto L15
        L7:
            if (r8 != 3) goto L9;
            r10.enforceInterface(DESCRIPTOR);
            r13 = getRoamRssiThreshold(r10.readInt());
            goto L15
        L9:
            if (r8 != 1598968902) goto L11;
            r11.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    int getRoamRssiThreshold(int r8);

    boolean setLatencyLevel(int r8, int r10);

    boolean setRoamRssiThreshold(int r8, int r10);
}
