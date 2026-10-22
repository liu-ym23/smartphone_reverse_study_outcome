package com.obric.cae.libs.cloud;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICloud extends IInterface {

    public static class Default implements ICloud {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void postToCloud(String r8) {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void registerCallback(ICloudEventCallback r8) {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void registerCallbackWithType(int r8, ICloudEventCallback r10) {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void unregisterCallback(ICloudEventCallback r8) {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void updateUserConfigData(int r8, String r10) {
        }
    }

    public static abstract class Stub extends Binder implements ICloud {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cloud.ICloud";
        static final int TRANSACTION_postToCloud = 4;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_registerCallbackWithType = 2;
        static final int TRANSACTION_unregisterCallback = 3;
        static final int TRANSACTION_updateUserConfigData = 5;

        public static class Proxy implements ICloud {
            public static ICloud sDefaultImpl;
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

            @Override // com.obric.cae.libs.cloud.ICloud
            public void postToCloud(String r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeString(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().postToCloud(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cloud.ICloud
            public void registerCallback(ICloudEventCallback r8) {
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

            @Override // com.obric.cae.libs.cloud.ICloud
            public void registerCallbackWithType(int r8, ICloudEventCallback r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r11.writeInt(r8);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L16
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L16
            L12:
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCallbackWithType(r8, r10);     // Catch: Throwable -> L16
                goto L12
            L6:
                r13 = null;
            L16:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cloud.ICloud
            public void unregisterCallback(ICloudEventCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(3, r10, r11, 0) == false) goto L10;
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

            @Override // com.obric.cae.libs.cloud.ICloud
            public void updateUserConfigData(int r8, String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeInt(r8);     // Catch: Throwable -> L12
                r11.writeString(r10);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L12
            L8:
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateUserConfigData(r8, r10);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICloud asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICloud) == false) goto L12;
            return (ICloud) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICloud getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICloud r8) {
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
            if (r8 == 1598968902) goto L22;
            if (r8 != 1) goto L6;
            r10.enforceInterface(DESCRIPTOR);
            registerCallback(ICloudEventCallback.Stub.asInterface(r10.readStrongBinder()));
        L16:
            r11.writeNoException();
            return true;
        L6:
            if (r8 != 2) goto L8;
            r10.enforceInterface(DESCRIPTOR);
            registerCallbackWithType(r10.readInt(), ICloudEventCallback.Stub.asInterface(r10.readStrongBinder()));
            goto L16
        L8:
            if (r8 != 3) goto L10;
            r10.enforceInterface(DESCRIPTOR);
            unregisterCallback(ICloudEventCallback.Stub.asInterface(r10.readStrongBinder()));
            goto L16
        L10:
            if (r8 != 4) goto L12;
            r10.enforceInterface(DESCRIPTOR);
            postToCloud(r10.readString());
            goto L16
        L12:
            if (r8 != 5) goto L14;
            r10.enforceInterface(DESCRIPTOR);
            updateUserConfigData(r10.readInt(), r10.readString());
            goto L16
        L14:
            return super.onTransact(r8, r10, r11, r12);
        L22:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    void postToCloud(String r8);

    void registerCallback(ICloudEventCallback r8);

    void registerCallbackWithType(int r8, ICloudEventCallback r10);

    void unregisterCallback(ICloudEventCallback r8);

    void updateUserConfigData(int r8, String r10);
}
