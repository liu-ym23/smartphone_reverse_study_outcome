package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IErrorCodeCallback extends IInterface {

    public static abstract class Stub extends Binder implements IErrorCodeCallback {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.IErrorCodeCallback";
        public static final int TRANSACTION_onResult = 1;
        public static final int TRANSACTION_onResultBundled = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IErrorCodeCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IErrorCodeCallback) == false) goto L12;
            return (IErrorCodeCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static IErrorCodeCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IErrorCodeCallback r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            onResult(r5.readInt(), r5.readString());
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L15;
            Bundle r8 = (Bundle) Bundle.CREATOR.createFromParcel(r5);
        L16:
            onResultBundled(r8);
            return true;
        L15:
            r8 = null;
            goto L16
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onResult(int r1, String r2) throws RemoteException;

    void onResultBundled(Bundle r1) throws RemoteException;
}
