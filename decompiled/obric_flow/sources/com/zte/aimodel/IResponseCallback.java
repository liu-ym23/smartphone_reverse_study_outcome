package com.zte.aimodel;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.activity.e;

/* JADX INFO: loaded from: classes3.dex */
public interface IResponseCallback extends IInterface {
    public static final String DESCRIPTOR = "com.zte.aimodel.IResponseCallback";

    public static class Default implements IResponseCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zte.aimodel.IResponseCallback
        public void onFailure(String r5) throws RemoteException {
        }

        @Override // com.zte.aimodel.IResponseCallback
        public boolean onSuccess(String r5, boolean r10) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IResponseCallback {
        static final int TRANSACTION_onFailure = 2;
        static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements IResponseCallback {
            private IBinder mRemote;

            public Proxy(IBinder r5) {
                this.mRemote = r5;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IResponseCallback.DESCRIPTOR;
            }

            @Override // com.zte.aimodel.IResponseCallback
            public void onFailure(String r5) throws RemoteException {
                Parcel r10 = e.g(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IResponseCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.zte.aimodel.IResponseCallback
            public boolean onSuccess(String r5, boolean r10) throws RemoteException {
                Parcel r11 = e.g(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IResponseCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeString(r5);     // Catch: Throwable -> L6
                r11.writeBoolean(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                boolean r13 = r12.readBoolean();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IResponseCallback.DESCRIPTOR);
        }

        public static IResponseCallback asInterface(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface(IResponseCallback.DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IResponseCallback) == false) goto L12;
            return (IResponseCallback) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) throws RemoteException {
            if (r5 < 1) goto L8;
            if (r5 > 16777215) goto L8;
            r10.enforceInterface(IResponseCallback.DESCRIPTOR);
        L8:
            if (r5 == 1598968902) goto L17;
            if (r5 != 1) goto L11;
            String r13 = r10.readString();
            boolean r14 = r10.readBoolean();
            e.q(r10);
            boolean r15 = onSuccess(r13, r14);
            r11.writeNoException();
            r11.writeBoolean(r15);
        L16:
            return true;
        L11:
            if (r5 != 2) goto L13;
            String r16 = r10.readString();
            e.q(r10);
            onFailure(r16);
            r11.writeNoException();
            goto L16
        L13:
            return super.onTransact(r5, r10, r11, r12);
        L17:
            r11.writeString(IResponseCallback.DESCRIPTOR);
            return true;
        }
    }

    void onFailure(String r5) throws RemoteException;

    boolean onSuccess(String r5, boolean r10) throws RemoteException;
}
