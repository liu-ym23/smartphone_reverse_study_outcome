package com.obric.cae.libs.cloud;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICloudEventCallback extends IInterface {

    public static class Default implements ICloudEventCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.cloud.ICloudEventCallback
        public void onCloudDataChange(String r8) {
        }

        @Override // com.obric.cae.libs.cloud.ICloudEventCallback
        public void onPostStateChange(int r8, String r10, String r11) {
        }
    }

    public static abstract class Stub extends Binder implements ICloudEventCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cloud.ICloudEventCallback";
        static final int TRANSACTION_onCloudDataChange = 1;
        static final int TRANSACTION_onPostStateChange = 2;

        public static class Proxy implements ICloudEventCallback {
            public static ICloudEventCallback sDefaultImpl;
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

            @Override // com.obric.cae.libs.cloud.ICloudEventCallback
            public void onCloudDataChange(String r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeString(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onCloudDataChange(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cloud.ICloudEventCallback
            public void onPostStateChange(int r8, String r10, String r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r12.writeInt(r8);     // Catch: Throwable -> L12
                r12.writeString(r10);     // Catch: Throwable -> L12
                r12.writeString(r11);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L12
            L8:
                r13.recycle();
                r12.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPostStateChange(r8, r10, r11);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICloudEventCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICloudEventCallback) == false) goto L12;
            return (ICloudEventCallback) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICloudEventCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICloudEventCallback r8) {
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
            onCloudDataChange(r10.readString());
        L13:
            r11.writeNoException();
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            onPostStateChange(r10.readInt(), r10.readString(), r10.readString());
            goto L13
        L7:
            if (r8 != 1598968902) goto L9;
            r11.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void onCloudDataChange(String r8);

    void onPostStateChange(int r8, String r10, String r11);
}
