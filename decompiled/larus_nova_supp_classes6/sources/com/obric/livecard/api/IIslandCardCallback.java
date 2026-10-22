package com.obric.livecard.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IIslandCardCallback extends IInterface {

    public static abstract class Stub extends Binder implements IIslandCardCallback {
        private static final String DESCRIPTOR = "com.obric.livecard.api.IIslandCardCallback";
        static final int TRANSACTION_hasViewClickId = 2;
        static final int TRANSACTION_onCardEvent = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IIslandCardCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IIslandCardCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IIslandCardCallback) == false) goto L12;
            return (IIslandCardCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IIslandCardCallback r1) {
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
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            String r9 = r6.readString();
            if (r6.readInt() == 0) goto L20;
            Bundle r10 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L21:
            Bundle r11 = onCardEvent(r9, r10);
            r7.writeNoException();
            if (r11 == null) goto L24;
            r7.writeInt(1);
            r11.writeToParcel(r7, 1);
        L25:
            return true;
        L24:
            r7.writeInt(0);
            goto L25
        L20:
            r10 = null;
            goto L21
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            Bundle r12 = hasViewClickId(r6.readString());
            r7.writeNoException();
            if (r12 == null) goto L15;
            r7.writeInt(1);
            r12.writeToParcel(r7, 1);
        L16:
            return true;
        L15:
            r7.writeInt(0);
            goto L16
        L7:
            if (r5 != 1598968902) goto L9;
            r7.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    Bundle hasViewClickId(String r1) throws RemoteException;

    Bundle onCardEvent(String r1, Bundle r2) throws RemoteException;
}
