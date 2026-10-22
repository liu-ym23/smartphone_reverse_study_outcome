package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.obric.aiagent.assistant.idl.bean.OLocationInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IFlowGetLocationCallbackIDL extends IInterface {

    public static abstract class Stub extends Binder implements IFlowGetLocationCallbackIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowGetLocationCallbackIDL";
        static final int TRANSACTION_onLocationResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowGetLocationCallbackIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowGetLocationCallbackIDL asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IFlowGetLocationCallbackIDL) == false) goto L12;
            return (IFlowGetLocationCallbackIDL) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IFlowGetLocationCallbackIDL r1) {
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
            boolean r8 = true;
        L15:
            if (r5.readInt() == 0) goto L17;
            OLocationInfo r9 = (OLocationInfo) OLocationInfo.CREATOR.createFromParcel(r5);
        L18:
            onLocationResult(r8, r9);
            r6.writeNoException();
            return true;
        L17:
            r9 = null;
            goto L18
        L13:
            r8 = false;
            goto L15
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onLocationResult(boolean r1, OLocationInfo r2) throws RemoteException;
}
