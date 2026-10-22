package com.obric.cae.libs.softap;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeSoftApManager extends IInterface {

    public static class Default implements ICaeSoftApManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public long getSoftApCapabilityBits() {
            return 0;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public int getSoftApInterfaceVersion() {
            return 0;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public CaeSoftApStatus getStatus() {
            return null;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public void registerCallback(ICaeSoftApCallback r8) {
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public int startSoftAp(CaeSoftApConfig r8, ICaeSoftApCallback r10) {
            return 0;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public int stopSoftAp() {
            return 0;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public void unregisterCallback(ICaeSoftApCallback r8) {
        }
    }

    public static abstract class Stub extends Binder implements ICaeSoftApManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.softap.ICaeSoftApManager";
        static final int TRANSACTION_getSoftApCapabilityBits = 7;
        static final int TRANSACTION_getSoftApInterfaceVersion = 6;
        static final int TRANSACTION_getStatus = 3;
        static final int TRANSACTION_registerCallback = 4;
        static final int TRANSACTION_startSoftAp = 1;
        static final int TRANSACTION_stopSoftAp = 2;
        static final int TRANSACTION_unregisterCallback = 5;

        public static class Proxy implements ICaeSoftApManager {
            public static ICaeSoftApManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public long getSoftApCapabilityBits() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                long r11 = r10.readLong();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getSoftApCapabilityBits();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public int getSoftApInterfaceVersion() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                int r11 = r10.readInt();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getSoftApInterfaceVersion();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public CaeSoftApStatus getStatus() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                if (this.mRemote.transact(3, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L15
                if (r10.readInt() == 0) goto L14;
                CaeSoftApStatus r11 = CaeSoftApStatus.CREATOR.createFromParcel(r10);     // Catch: Throwable -> L15
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L14:
                r11 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getStatus();     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public void registerCallback(ICaeSoftApCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(4, r10, r11, 0) == false) goto L10;
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

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public int startSoftAp(CaeSoftApConfig r8, ICaeSoftApCallback r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r8 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L19
                r8.writeToParcel(r11, 0);     // Catch: Throwable -> L19
            L7:
                if (r10 == null) goto L9;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L19
            L10:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L19
                if (this.mRemote.transact(1, r11, r12, 0) == false) goto L13;
            L17:
                r12.readException();     // Catch: Throwable -> L19
                int r14 = r12.readInt();     // Catch: Throwable -> L19
            L15:
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                r14 = Stub.getDefaultImpl().startSoftAp(r8, r10);     // Catch: Throwable -> L19
                goto L15
            L9:
                r13 = null;
                goto L10
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public int stopSoftAp() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                int r11 = r10.readInt();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().stopSoftAp();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public void unregisterCallback(ICaeSoftApCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(5, r10, r11, 0) == false) goto L10;
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
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeSoftApManager asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeSoftApManager) == false) goto L12;
            return (ICaeSoftApManager) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeSoftApManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeSoftApManager r8) {
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
            if (r8 == 1598968902) goto L28;
            switch(r8) {
                case 1: goto L22;
                case 2: goto L20;
                case 3: goto L15;
                case 4: goto L13;
                case 5: goto L11;
                case 6: goto L9;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r10.enforceInterface(DESCRIPTOR);
            long r13 = getSoftApCapabilityBits();
            r11.writeNoException();
            r11.writeLong(r13);
            return true;
        L9:
            r10.enforceInterface(DESCRIPTOR);
            int r14 = getSoftApInterfaceVersion();
            r11.writeNoException();
            r11.writeInt(r14);
            return true;
        L11:
            r10.enforceInterface(DESCRIPTOR);
            unregisterCallback(ICaeSoftApCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L13:
            r10.enforceInterface(DESCRIPTOR);
            registerCallback(ICaeSoftApCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L15:
            r10.enforceInterface(DESCRIPTOR);
            CaeSoftApStatus r15 = getStatus();
            r11.writeNoException();
            if (r15 == null) goto L18;
            r11.writeInt(1);
            r15.writeToParcel(r11, 1);
        L19:
            return true;
        L18:
            r11.writeInt(0);
            goto L19
        L20:
            r10.enforceInterface(DESCRIPTOR);
            int r16 = stopSoftAp();
            r11.writeNoException();
            r11.writeInt(r16);
            return true;
        L22:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L25;
            CaeSoftApConfig r17 = CaeSoftApConfig.CREATOR.createFromParcel(r10);
        L26:
            int r18 = startSoftAp(r17, ICaeSoftApCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            r11.writeInt(r18);
            return true;
        L25:
            r17 = null;
            goto L26
        L6:
            return super.onTransact(r8, r10, r11, r12);
        L28:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    long getSoftApCapabilityBits();

    int getSoftApInterfaceVersion();

    CaeSoftApStatus getStatus();

    void registerCallback(ICaeSoftApCallback r8);

    int startSoftAp(CaeSoftApConfig r8, ICaeSoftApCallback r10);

    int stopSoftAp();

    void unregisterCallback(ICaeSoftApCallback r8);
}
