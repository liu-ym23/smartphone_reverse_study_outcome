package com.obric.capabilitykit.entity.search;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IInAppSearchCallback extends IInterface {

    public static abstract class Stub extends Binder implements IInAppSearchCallback {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.entity.search.IInAppSearchCallback";
        public static final int TRANSACTION_onCompleted = 2;
        public static final int TRANSACTION_onError = 3;
        public static final int TRANSACTION_onSearchResult = 1;
        public static final int TRANSACTION_onSearchResultWithoutEntity = 4;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IInAppSearchCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IInAppSearchCallback) == false) goto L12;
            return (IInAppSearchCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static IInAppSearchCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IInAppSearchCallback r1) {
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
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            if (r5 == 1598968902) goto L26;
            InAppSearchResultWithoutEntity r0 = null;
            if (r5 != 1) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L25;
            r0 = InAppSearchResult.CREATOR.createFromParcel(r6);
        L25:
            onSearchResult(r0);
        L18:
            r7.writeNoException();
            return true;
        L7:
            if (r5 != 2) goto L9;
            r6.enforceInterface(DESCRIPTOR);
            onCompleted();
            goto L18
        L9:
            if (r5 != 3) goto L11;
            r6.enforceInterface(DESCRIPTOR);
            onError(r6.readInt(), r6.readString());
            goto L18
        L11:
            if (r5 != 4) goto L13;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L17;
            r0 = InAppSearchResultWithoutEntity.CREATOR.createFromParcel(r6);
        L17:
            onSearchResultWithoutEntity(r0);
            goto L18
        L13:
            return super.onTransact(r5, r6, r7, r8);
        L26:
            r7.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onCompleted() throws RemoteException;

    void onError(int r1, String r2) throws RemoteException;

    void onSearchResult(InAppSearchResult r1) throws RemoteException;

    void onSearchResultWithoutEntity(InAppSearchResultWithoutEntity r1) throws RemoteException;
}
