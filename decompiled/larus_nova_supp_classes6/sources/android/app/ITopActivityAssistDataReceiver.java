package android.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface ITopActivityAssistDataReceiver extends IInterface {

    public static abstract class Stub extends Binder implements ITopActivityAssistDataReceiver {
        private static final String DESCRIPTOR = "android.app.ITopActivityAssistDataReceiver";
        static final int TRANSACTION_onResultData = 1;
        static final int TRANSACTION_onScreenshotData = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITopActivityAssistDataReceiver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ITopActivityAssistDataReceiver asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ITopActivityAssistDataReceiver) == false) goto L12;
            return (ITopActivityAssistDataReceiver) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ITopActivityAssistDataReceiver r1) {
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
            Bundle r0 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            int r9 = r6.readInt();
            if (r6.readInt() == 0) goto L20;
            r0 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L20:
            onResultData(r9, r0);
            return true;
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            int r10 = r6.readInt();
            if (r6.readInt() == 0) goto L15;
            r0 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L15:
            onScreenshotData(r10, r0);
            return true;
        L7:
            if (r5 != 1598968902) goto L9;
            r7.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    void onResultData(int r1, Bundle r2) throws RemoteException;

    void onScreenshotData(int r1, Bundle r2) throws RemoteException;
}
