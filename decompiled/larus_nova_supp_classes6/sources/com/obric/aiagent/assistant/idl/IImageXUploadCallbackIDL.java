package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IImageXUploadCallbackIDL extends IInterface {

    public static abstract class Stub extends Binder implements IImageXUploadCallbackIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL";
        static final int TRANSACTION_onResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IImageXUploadCallbackIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IImageXUploadCallbackIDL asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IImageXUploadCallbackIDL) == false) goto L12;
            return (IImageXUploadCallbackIDL) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IImageXUploadCallbackIDL r1) {
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
        public boolean onTransact(int r8, Parcel r9, Parcel r10, int r11) throws RemoteException {
            if (r8 != 1) goto L5;
            r9.enforceInterface(DESCRIPTOR);
            if (r9.readInt() == 0) goto L13;
            boolean r2 = true;
        L14:
            onResult(r2, r9.readString(), r9.readString(), r9.readString(), r9.readString());
            return true;
        L13:
            r2 = false;
            goto L14
        L5:
            if (r8 != 1598968902) goto L7;
            r10.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r8, r9, r10, r11);
        }
    }

    void onResult(boolean r1, String r2, String r3, String r4, String r5) throws RemoteException;
}
