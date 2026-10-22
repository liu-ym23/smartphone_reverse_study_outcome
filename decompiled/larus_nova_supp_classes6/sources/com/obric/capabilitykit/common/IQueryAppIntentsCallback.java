package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IQueryAppIntentsCallback extends IInterface {

    public static abstract class Stub extends Binder implements IQueryAppIntentsCallback {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.IQueryAppIntentsCallback";
        public static final int TRANSACTION_onResult = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IQueryAppIntentsCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IQueryAppIntentsCallback) == false) goto L12;
            return (IQueryAppIntentsCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static IQueryAppIntentsCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IQueryAppIntentsCallback r1) {
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
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            onResult(r5.createTypedArrayList(AppIntentImplInfo.CREATOR));
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

    void onResult(List<AppIntentImplInfo> r1) throws RemoteException;
}
