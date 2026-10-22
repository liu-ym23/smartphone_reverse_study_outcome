package com.zte.activityevent;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IActivityEventsCallback extends IInterface {
    public static final String DESCRIPTOR = "com.zte.activityevent.IActivityEventsCallback";

    public static class Default implements IActivityEventsCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zte.activityevent.IActivityEventsCallback
        public void notifiyActivityEvent(int r5, String r10, String r11, String r12) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IActivityEventsCallback {
        static final int TRANSACTION_notifiyActivityEvent = 1;

        public static class Proxy implements IActivityEventsCallback {
            public static IActivityEventsCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r5) {
                this.mRemote = r5;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IActivityEventsCallback.DESCRIPTOR;
            }

            @Override // com.zte.activityevent.IActivityEventsCallback
            public void notifiyActivityEvent(int r5, String r10, String r11, String r12) throws RemoteException {
                Parcel r13 = Parcel.obtain();
                r13.writeInterfaceToken(IActivityEventsCallback.DESCRIPTOR);     // Catch: Throwable -> L10
                r13.writeInt(r5);     // Catch: Throwable -> L10
                r13.writeString(r10);     // Catch: Throwable -> L10
                r13.writeString(r11);     // Catch: Throwable -> L10
                r13.writeString(r12);     // Catch: Throwable -> L10
                if (this.mRemote.transact(1, r13, null, 1) == false) goto L6;
            L12:
                r13.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().notifiyActivityEvent(r5, r10, r11, r12);     // Catch: Throwable -> L10
                r13.recycle();
                return;
            L10:
                th = move-exception;
                r13.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IActivityEventsCallback.DESCRIPTOR);
        }

        public static IActivityEventsCallback asInterface(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface(IActivityEventsCallback.DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IActivityEventsCallback) == false) goto L12;
            return (IActivityEventsCallback) r10;
        L12:
            return new Proxy(r5);
        }

        public static IActivityEventsCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IActivityEventsCallback r5) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r5 == null) goto L7;
            Proxy.sDefaultImpl = r5;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) throws RemoteException {
            if (r5 == 1598968902) goto L9;
            if (r5 != 1) goto L6;
            r10.enforceInterface(IActivityEventsCallback.DESCRIPTOR);
            notifiyActivityEvent(r10.readInt(), r10.readString(), r10.readString(), r10.readString());
            return true;
        L6:
            return super.onTransact(r5, r10, r11, r12);
        L9:
            r11.writeString(IActivityEventsCallback.DESCRIPTOR);
            return true;
        }
    }

    void notifiyActivityEvent(int r5, String r10, String r11, String r12) throws RemoteException;
}
