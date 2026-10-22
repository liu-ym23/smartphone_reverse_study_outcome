package com.obric.matrix.push.common.cross_process;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface ICrossProcessCallbackInterface extends IInterface {

    public static abstract class Stub extends Binder implements ICrossProcessCallbackInterface {
        private static final String DESCRIPTOR = "com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface";
        static final int TRANSACTION_onCallBack = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICrossProcessCallbackInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICrossProcessCallbackInterface asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICrossProcessCallbackInterface) == false) goto L12;
            return (ICrossProcessCallbackInterface) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ICrossProcessCallbackInterface r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            onCallBack(r5.readArrayList(getClass().getClassLoader()));
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onCallBack(List r1) throws RemoteException;
}
