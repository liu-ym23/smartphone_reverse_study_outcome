package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IMusicStateListenerIDL extends IInterface {

    public static abstract class Stub extends Binder implements IMusicStateListenerIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IMusicStateListenerIDL";
        static final int TRANSACTION_onMusicStateChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMusicStateListenerIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IMusicStateListenerIDL asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IMusicStateListenerIDL) == false) goto L12;
            return (IMusicStateListenerIDL) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IMusicStateListenerIDL r1) {
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
            Bundle r8 = (Bundle) Bundle.CREATOR.createFromParcel(r5);
        L14:
            onMusicStateChanged(r8);
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

    void onMusicStateChanged(Bundle r1) throws RemoteException;
}
