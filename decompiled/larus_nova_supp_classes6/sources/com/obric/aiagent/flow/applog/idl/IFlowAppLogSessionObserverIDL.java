package com.obric.aiagent.flow.applog.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IFlowAppLogSessionObserverIDL extends IInterface {

    public static abstract class Stub extends Binder implements IFlowAppLogSessionObserverIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL";
        static final int TRANSACTION_onSessionBatchEvent = 3;
        static final int TRANSACTION_onSessionStart = 1;
        static final int TRANSACTION_onSessionTerminate = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowAppLogSessionObserverIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowAppLogSessionObserverIDL asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IFlowAppLogSessionObserverIDL) == false) goto L12;
            return (IFlowAppLogSessionObserverIDL) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IFlowAppLogSessionObserverIDL r1) {
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
            onSessionStart(r5.readLong(), r5.readString());
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            onSessionTerminate(r5.readLong(), r5.readString());
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            onSessionBatchEvent(r5.readLong(), r5.readString());
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onSessionBatchEvent(long r1, String r3) throws RemoteException;

    void onSessionStart(long r1, String r3) throws RemoteException;

    void onSessionTerminate(long r1, String r3) throws RemoteException;
}
