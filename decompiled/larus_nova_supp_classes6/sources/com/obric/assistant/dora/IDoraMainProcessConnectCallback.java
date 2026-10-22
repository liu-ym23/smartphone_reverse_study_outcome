package com.obric.assistant.dora;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IDoraMainProcessConnectCallback extends IInterface {

    public static abstract class Stub extends Binder implements IDoraMainProcessConnectCallback {
        private static final String DESCRIPTOR = "com.obric.assistant.dora.IDoraMainProcessConnectCallback";
        static final int TRANSACTION_onConnectResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDoraMainProcessConnectCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IDoraMainProcessConnectCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IDoraMainProcessConnectCallback) == false) goto L12;
            return (IDoraMainProcessConnectCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IDoraMainProcessConnectCallback r1) {
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
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L13;
            DoraMainProcessConnectResult r8 = (DoraMainProcessConnectResult) DoraMainProcessConnectResult.CREATOR.createFromParcel(r5);
        L14:
            onConnectResult(r8);
            r6.writeNoException();
            return true;
        L13:
            r8 = null;
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onConnectResult(DoraMainProcessConnectResult r1) throws RemoteException;
}
