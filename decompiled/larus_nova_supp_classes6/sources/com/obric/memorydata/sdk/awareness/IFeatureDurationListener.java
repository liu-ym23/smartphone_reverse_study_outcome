package com.obric.memorydata.sdk.awareness;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IFeatureDurationListener extends IInterface {

    public static abstract class Stub extends Binder implements IFeatureDurationListener {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.awareness.IFeatureDurationListener";
        static final int TRANSACTION_onTriggered = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFeatureDurationListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFeatureDurationListener asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IFeatureDurationListener) == false) goto L12;
            return (IFeatureDurationListener) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IFeatureDurationListener r1) {
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
            onTriggered(r5.readString(), r5.readString(), r5.readLong());
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

    void onTriggered(String r1, String r2, long r3) throws RemoteException;
}
