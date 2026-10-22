package com.obric.matrix.platform.sdk.ones.account;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IAccountActionCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback";

    public static abstract class Stub extends Binder implements IAccountActionCallback {
        static final int TRANSACTION_onResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IAccountActionCallback.DESCRIPTOR);
        }

        public static IAccountActionCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IAccountActionCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAccountActionCallback) == false) goto L12;
            return (IAccountActionCallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IAccountActionCallback.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(IAccountActionCallback.DESCRIPTOR);
            return true;
        L11:
            if (r4 == 1) goto L15;
            return super.onTransact(r4, r5, r6, r7);
        L15:
            if (r5.readInt() == 0) goto L17;
            boolean r8 = true;
        L18:
            Parcelable.Creator r9 = Bundle.CREATOR;
            if (r5.readInt() == 0) goto L21;
            Object r10 = r9.createFromParcel(r5);
        L22:
            onResult(r8, (Bundle) r10);
            return true;
        L21:
            r10 = null;
            goto L22
        L17:
            r8 = false;
            goto L18
        }
    }

    void onResult(boolean r1, Bundle r2) throws RemoteException;
}
