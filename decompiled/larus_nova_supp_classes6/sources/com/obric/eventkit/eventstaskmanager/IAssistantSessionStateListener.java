package com.obric.eventkit.eventstaskmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IAssistantSessionStateListener extends IInterface {

    public static abstract class Stub extends Binder implements IAssistantSessionStateListener {
        private static final String DESCRIPTOR = "com.obric.eventkit.eventstaskmanager.IAssistantSessionStateListener";
        public static final int TRANSACTION_onAssistantSessionStateChanged = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAssistantSessionStateListener asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAssistantSessionStateListener) == false) goto L12;
            return (IAssistantSessionStateListener) r0;
        L12:
            return new Proxy(r2);
        }

        public static IAssistantSessionStateListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAssistantSessionStateListener r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            onAssistantSessionStateChanged(r5.readInt());
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

    void onAssistantSessionStateChanged(int r1);
}
