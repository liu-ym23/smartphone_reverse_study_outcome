package com.obric.cae.libs.nfc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeNfcForceFwEventCallback extends IInterface {

    public static class Default implements ICaeNfcForceFwEventCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcForceFwEventCallback
        public void onForceFwDownload() {
        }
    }

    public static abstract class Stub extends Binder implements ICaeNfcForceFwEventCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.nfc.ICaeNfcForceFwEventCallback";
        static final int TRANSACTION_onForceFwDownload = 1;

        public static class Proxy implements ICaeNfcForceFwEventCallback {
            public static ICaeNfcForceFwEventCallback sDefaultImpl;
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcForceFwEventCallback
            public void onForceFwDownload() {
                Parcel r8 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r8, null, 1) == false) goto L6;
            L10:
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onForceFwDownload();     // Catch: Throwable -> L12
                r8.recycle();
                return;
            L12:
                th = move-exception;
                r8.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeNfcForceFwEventCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeNfcForceFwEventCallback) == false) goto L12;
            return (ICaeNfcForceFwEventCallback) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeNfcForceFwEventCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeNfcForceFwEventCallback r8) {
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
            onForceFwDownload();
            return true;
        L5:
            if (r8 != 1598968902) goto L7;
            r11.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void onForceFwDownload();
}
