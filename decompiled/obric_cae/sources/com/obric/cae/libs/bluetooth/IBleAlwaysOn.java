package com.obric.cae.libs.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IBleAlwaysOn extends IInterface {

    public static class Default implements IBleAlwaysOn {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
        public void registerEventCallback(IBleAlwaysOnCallback r8) {
        }

        @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
        public void setCaeWakeLockState(boolean r8) {
        }

        @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
        public void unregisterEventCallback(IBleAlwaysOnCallback r8) {
        }
    }

    public static abstract class Stub extends Binder implements IBleAlwaysOn {
        private static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.IBleAlwaysOn";
        static final int TRANSACTION_registerEventCallback = 1;
        static final int TRANSACTION_setCaeWakeLockState = 3;
        static final int TRANSACTION_unregisterEventCallback = 2;

        public static class Proxy implements IBleAlwaysOn {
            public static IBleAlwaysOn sDefaultImpl;
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

            @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
            public void registerEventCallback(IBleAlwaysOnCallback r8) {
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
                Stub.getDefaultImpl().registerEventCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
            public void setCaeWakeLockState(boolean r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setCaeWakeLockState(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
            public void unregisterEventCallback(IBleAlwaysOnCallback r8) {
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
                Stub.getDefaultImpl().unregisterEventCallback(r8);     // Catch: Throwable -> L16
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

        public static IBleAlwaysOn asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IBleAlwaysOn) == false) goto L12;
            return (IBleAlwaysOn) r10;
        L12:
            return new Proxy(r8);
        }

        public static IBleAlwaysOn getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IBleAlwaysOn r8) {
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
            registerEventCallback(IBleAlwaysOnCallback.Stub.asInterface(r10.readStrongBinder()));
        L19:
            r11.writeNoException();
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            unregisterEventCallback(IBleAlwaysOnCallback.Stub.asInterface(r10.readStrongBinder()));
            goto L19
        L7:
            if (r8 != 3) goto L9;
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L17;
            boolean r13 = true;
        L18:
            setCaeWakeLockState(r13);
            goto L19
        L17:
            r13 = false;
            goto L18
        L9:
            if (r8 != 1598968902) goto L11;
            r11.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void registerEventCallback(IBleAlwaysOnCallback r8);

    void setCaeWakeLockState(boolean r8);

    void unregisterEventCallback(IBleAlwaysOnCallback r8);
}
