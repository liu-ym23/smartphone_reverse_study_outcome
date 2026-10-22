package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IScreenshotCallbackIDL extends IInterface {

    public static abstract class Stub extends Binder implements IScreenshotCallbackIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL";
        static final int TRANSACTION_onError = 3;
        static final int TRANSACTION_onReceivedScreenshot = 1;
        static final int TRANSACTION_onReceivedScreenshotUri = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IScreenshotCallbackIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IScreenshotCallbackIDL asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IScreenshotCallbackIDL) == false) goto L12;
            return (IScreenshotCallbackIDL) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IScreenshotCallbackIDL r1) {
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
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            Bitmap r0 = null;
            Uri r1 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L24;
            r0 = (Bitmap) Bitmap.CREATOR.createFromParcel(r6);
        L24:
            onReceivedScreenshot(r0);
            return true;
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L19;
            r1 = (Uri) Uri.CREATOR.createFromParcel(r6);
        L19:
            onReceivedScreenshotUri(r1);
            return true;
        L7:
            if (r5 != 3) goto L9;
            r6.enforceInterface(DESCRIPTOR);
            onError(r6.readString());
            return true;
        L9:
            if (r5 != 1598968902) goto L11;
            r7.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    void onError(String r1) throws RemoteException;

    void onReceivedScreenshot(Bitmap r1) throws RemoteException;

    void onReceivedScreenshotUri(Uri r1) throws RemoteException;
}
