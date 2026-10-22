package cn.nubia.neopush.service.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface INBPushService extends IInterface {

    public static abstract class Stub extends Binder implements INBPushService {
        private static final String DESCRIPTOR = "cn.nubia.neopush.service.aidl.INBPushService";
        static final int TRANSACTION_getClickedMessage = 2;
        static final int TRANSACTION_getPassthroughMessageList = 1;

        public static class Proxy implements INBPushService {
            private IBinder mRemote;

            public Proxy(IBinder r5) {
                this.mRemote = r5;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // cn.nubia.neopush.service.aidl.INBPushService
            public Bundle getClickedMessage(long r5, String r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L7
                r11.writeLong(r5);     // Catch: Throwable -> L7
                r11.writeString(r10);     // Catch: Throwable -> L7
                this.mRemote.transact(2, r11, r12, 0);     // Catch: Throwable -> L7
                r12.readException();     // Catch: Throwable -> L7
                if (r12.readInt() == 0) goto L9;
                Bundle r13 = (Bundle) Bundle.CREATOR.createFromParcel(r12);     // Catch: Throwable -> L7
            L10:
                r12.recycle();
                r11.recycle();
                return r13;
            L9:
                r13 = null;
            L7:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // cn.nubia.neopush.service.aidl.INBPushService
            public Bundle getPassthroughMessageList(String r5) throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L7
                r10.writeString(r5);     // Catch: Throwable -> L7
                this.mRemote.transact(1, r10, r11, 0);     // Catch: Throwable -> L7
                r11.readException();     // Catch: Throwable -> L7
                if (r11.readInt() == 0) goto L9;
                Bundle r12 = (Bundle) Bundle.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L7
            L10:
                r11.recycle();
                r10.recycle();
                return r12;
            L9:
                r12 = null;
            L7:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static INBPushService asInterface(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof INBPushService) == false) goto L12;
            return (INBPushService) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
            if (r10 != 1) goto L5;
            r11.enforceInterface(DESCRIPTOR);
            Bundle r5 = getPassthroughMessageList(r11.readString());
            r12.writeNoException();
            if (r5 == null) goto L20;
            r12.writeInt(1);
            r5.writeToParcel(r12, 1);
        L21:
            return true;
        L20:
            r12.writeInt(0);
            goto L21
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface(DESCRIPTOR);
            Bundle r14 = getClickedMessage(r11.readLong(), r11.readString());
            r12.writeNoException();
            if (r14 == null) goto L15;
            r12.writeInt(1);
            r14.writeToParcel(r12, 1);
        L16:
            return true;
        L15:
            r12.writeInt(0);
            goto L16
        L7:
            if (r10 != 1598968902) goto L9;
            r12.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    Bundle getClickedMessage(long r5, String r10) throws RemoteException;

    Bundle getPassthroughMessageList(String r5) throws RemoteException;
}
