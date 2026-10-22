package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IDeviceIdService extends IInterface {

    public static abstract class Stub extends Binder implements IDeviceIdService {
        private static final String DESCRIPTOR = "com.samsung.android.deviceidservice.IDeviceIdService";
        static final int TRANSACTION_getAAID = 3;
        static final int TRANSACTION_getOAID = 1;
        static final int TRANSACTION_getVAID = 2;

        private static class Proxy implements IDeviceIdService {
            private IBinder mRemote;

            Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdService
            public String getAAID(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeString(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                String r13 = r12.readString();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdService
            public String getOAID() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                String r12 = r11.readString();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdService
            public String getVAID(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeString(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                String r13 = r12.readString();     // Catch: Throwable -> L6
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
            attachInterface(this, DESCRIPTOR);
        }

        public static IDeviceIdService asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IDeviceIdService) == false) goto L12;
            return (IDeviceIdService) r11;
        L12:
            return new Proxy(r10);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface(DESCRIPTOR);
            String r14 = getOAID();
        L15:
            r12.writeNoException();
            r12.writeString(r14);
            return true;
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface(DESCRIPTOR);
            r14 = getVAID(r11.readString());
            goto L15
        L7:
            if (r10 != 3) goto L9;
            r11.enforceInterface(DESCRIPTOR);
            r14 = getAAID(r11.readString());
            goto L15
        L9:
            if (r10 != 1598968902) goto L11;
            r12.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    String getAAID(String r10);

    String getOAID();

    String getVAID(String r10);
}
