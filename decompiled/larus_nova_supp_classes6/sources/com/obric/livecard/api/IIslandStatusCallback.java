package com.obric.livecard.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IIslandStatusCallback extends IInterface {

    public static abstract class Stub extends Binder implements IIslandStatusCallback {
        private static final String DESCRIPTOR = "com.obric.livecard.api.IIslandStatusCallback";
        static final int TRANSACTION_getId = 2;
        static final int TRANSACTION_keepAliveOnAOD = 3;
        static final int TRANSACTION_onIslandDialogueMode = 6;
        static final int TRANSACTION_onIslandExpand = 1;
        static final int TRANSACTION_onIslandStartActivity = 4;
        static final int TRANSACTION_onIslandWidthChange = 5;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IIslandStatusCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IIslandStatusCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IIslandStatusCallback) == false) goto L12;
            return (IIslandStatusCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IIslandStatusCallback r1) {
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
            if (r4 == 1598968902) goto L26;
            boolean r0 = false;
            switch(r4) {
                case 1: goto L24;
                case 2: goto L22;
                case 3: goto L17;
                case 4: goto L15;
                case 5: goto L13;
                case 6: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L11;
            r0 = true;
        L11:
            onIslandDialogueMode(r0);
            r6.writeNoException();
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            onIslandWidthChange(r5.readInt());
            r6.writeNoException();
            return true;
        L15:
            r5.enforceInterface(DESCRIPTOR);
            onIslandStartActivity();
            r6.writeNoException();
            return true;
        L17:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L20;
            r0 = true;
        L20:
            keepAliveOnAOD(r0);
            r6.writeNoException();
            return true;
        L22:
            r5.enforceInterface(DESCRIPTOR);
            long r8 = getId();
            r6.writeNoException();
            r6.writeLong(r8);
            return true;
        L24:
            r5.enforceInterface(DESCRIPTOR);
            onIslandExpand();
            r6.writeNoException();
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L26:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    long getId() throws RemoteException;

    void keepAliveOnAOD(boolean r1) throws RemoteException;

    void onIslandDialogueMode(boolean r1) throws RemoteException;

    void onIslandExpand() throws RemoteException;

    void onIslandStartActivity() throws RemoteException;

    void onIslandWidthChange(int r1) throws RemoteException;
}
