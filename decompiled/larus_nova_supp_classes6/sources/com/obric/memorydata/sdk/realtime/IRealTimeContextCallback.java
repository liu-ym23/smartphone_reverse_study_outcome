package com.obric.memorydata.sdk.realtime;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IRealTimeContextCallback extends IInterface {

    public static abstract class Stub extends Binder implements IRealTimeContextCallback {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.realtime.IRealTimeContextCallback";
        static final int TRANSACTION_updateActionContext = 2;
        static final int TRANSACTION_updateRealTimeContext = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRealTimeContextCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IRealTimeContextCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IRealTimeContextCallback) == false) goto L12;
            return (IRealTimeContextCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IRealTimeContextCallback r1) {
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
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            RealTimeContext r0 = null;
            ActionContext r1 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L21;
            r0 = RealTimeContext.CREATOR.createFromParcel(r6);
        L21:
            if (r6.readInt() == 0) goto L23;
            boolean r9 = true;
        L24:
            updateRealTimeContext(r0, r9);
            r7.writeNoException();
            return true;
        L23:
            r9 = false;
            goto L24
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L15;
            r1 = ActionContext.CREATOR.createFromParcel(r6);
        L15:
            updateActionContext(r1);
            r7.writeNoException();
            return true;
        L7:
            if (r5 != 1598968902) goto L9;
            r7.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    void updateActionContext(ActionContext r1) throws RemoteException;

    void updateRealTimeContext(RealTimeContext r1, boolean r2) throws RemoteException;
}
