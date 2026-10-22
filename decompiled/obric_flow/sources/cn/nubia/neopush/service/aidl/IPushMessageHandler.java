package cn.nubia.neopush.service.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IPushMessageHandler extends IInterface {

    public static abstract class Stub extends Binder implements IPushMessageHandler {
        private static final String DESCRIPTOR = "cn.nubia.neopush.service.aidl.IPushMessageHandler";
        static final int TRANSACTION_getMessage = 1;
        static final int TRANSACTION_getSdkVersion = 2;

        public static class Proxy implements IPushMessageHandler {
            private IBinder mRemote;

            public Proxy(IBinder r5) {
                this.mRemote = r5;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // cn.nubia.neopush.service.aidl.IPushMessageHandler
            public void getMessage(long r5, int r10, int r11, String r12, int r13, String r14, String r15) throws RemoteException {
                Parcel r16 = Parcel.obtain();
                Parcel r17 = Parcel.obtain();
                r16.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r16.writeLong(r5);     // Catch: Throwable -> L6
                r16.writeInt(r10);     // Catch: Throwable -> L6
                r16.writeInt(r11);     // Catch: Throwable -> L6
                r16.writeString(r12);     // Catch: Throwable -> L6
                r16.writeInt(r13);     // Catch: Throwable -> L6
                r16.writeString(r14);     // Catch: Throwable -> L6
                r16.writeString(r15);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r16, r17, 0);     // Catch: Throwable -> L6
                r17.readException();     // Catch: Throwable -> L6
                r17.recycle();
                r16.recycle();
                return;
            L6:
                th = move-exception;
                r17.recycle();
                r16.recycle();
                throw th;
            }

            @Override // cn.nubia.neopush.service.aidl.IPushMessageHandler
            public int getSdkVersion() throws RemoteException {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r5, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                int r11 = r10.readInt();     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPushMessageHandler asInterface(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IPushMessageHandler) == false) goto L12;
            return (IPushMessageHandler) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r12, Parcel r13, Parcel r14, int r15) throws RemoteException {
            if (r12 != 1) goto L5;
            r13.enforceInterface(DESCRIPTOR);
            getMessage(r13.readLong(), r13.readInt(), r13.readInt(), r13.readString(), r13.readInt(), r13.readString(), r13.readString());
            r14.writeNoException();
            return true;
        L5:
            if (r12 != 2) goto L7;
            r13.enforceInterface(DESCRIPTOR);
            int r11 = getSdkVersion();
            r14.writeNoException();
            r14.writeInt(r11);
            return true;
        L7:
            if (r12 != 1598968902) goto L9;
            r14.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r12, r13, r14, r15);
        }
    }

    void getMessage(long r5, int r10, int r11, String r12, int r13, String r14, String r15) throws RemoteException;

    int getSdkVersion() throws RemoteException;
}
