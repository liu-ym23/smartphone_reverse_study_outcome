package com.obric.cae.libs.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface IBleAlwaysOnCallback extends IInterface {

    public static class Default implements IBleAlwaysOnCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IBleAlwaysOnCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.IBleAlwaysOnCallback";

        public static class Proxy implements IBleAlwaysOnCallback {
            public static IBleAlwaysOnCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IBleAlwaysOnCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IBleAlwaysOnCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IBleAlwaysOnCallback) == false) goto L12;
            return (IBleAlwaysOnCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IBleAlwaysOnCallback r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r2, Parcel r3, Parcel r4, int r5) throws RemoteException {
            if (r2 != 1598968902) goto L5;
            r4.writeString(DESCRIPTOR);
            return true;
        L5:
            return super.onTransact(r2, r3, r4, r5);
        }
    }
}
