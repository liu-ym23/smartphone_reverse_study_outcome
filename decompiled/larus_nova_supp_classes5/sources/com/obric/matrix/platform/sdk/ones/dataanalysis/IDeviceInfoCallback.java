package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IDeviceInfoCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback";

    public static abstract class Stub extends Binder implements IDeviceInfoCallback {
        static final int TRANSACTION_onDeviceId = 1;
        static final int TRANSACTION_onInstallId = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IDeviceInfoCallback.DESCRIPTOR);
        }

        public static IDeviceInfoCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IDeviceInfoCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IDeviceInfoCallback) == false) goto L12;
            return (IDeviceInfoCallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IDeviceInfoCallback.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(IDeviceInfoCallback.DESCRIPTOR);
            return true;
        L11:
            if (r4 != 1) goto L13;
            onDeviceId(r5.readString());
            r6.writeNoException();
        L18:
            return true;
        L13:
            if (r4 != 2) goto L15;
            onInstallId(r5.readString());
            r6.writeNoException();
            goto L18
        L15:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onDeviceId(String r1) throws RemoteException;

    void onInstallId(String r1) throws RemoteException;
}
