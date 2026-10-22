package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IRequestAuthenticationCallbackIDL extends IInterface {

    public static abstract class Stub extends Binder implements IRequestAuthenticationCallbackIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL";
        static final int TRANSACTION_onAuthenticationCancelled = 5;
        static final int TRANSACTION_onAuthenticationFailed = 3;
        static final int TRANSACTION_onAuthenticationNotAvailable = 4;
        static final int TRANSACTION_onAuthenticationPass = 1;
        static final int TRANSACTION_onAuthenticationTimeout = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRequestAuthenticationCallbackIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IRequestAuthenticationCallbackIDL asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IRequestAuthenticationCallbackIDL) == false) goto L12;
            return (IRequestAuthenticationCallbackIDL) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IRequestAuthenticationCallbackIDL r1) {
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
            onAuthenticationPass();
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            onAuthenticationTimeout();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            onAuthenticationFailed();
            return true;
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface(DESCRIPTOR);
            onAuthenticationNotAvailable();
            return true;
        L11:
            if (r4 != 5) goto L13;
            r5.enforceInterface(DESCRIPTOR);
            onAuthenticationCancelled();
            return true;
        L13:
            if (r4 != 1598968902) goto L15;
            r6.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onAuthenticationCancelled() throws RemoteException;

    void onAuthenticationFailed() throws RemoteException;

    void onAuthenticationNotAvailable() throws RemoteException;

    void onAuthenticationPass() throws RemoteException;

    void onAuthenticationTimeout() throws RemoteException;
}
