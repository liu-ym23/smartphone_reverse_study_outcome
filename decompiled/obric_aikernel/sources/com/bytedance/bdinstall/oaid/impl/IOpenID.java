package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IOpenID extends IInterface {

    public static abstract class Stub extends Binder implements IOpenID {
        private static final String DESCRIPTOR = "com.heytap.openid.IOpenID";
        static final int TRANSACTION_getSerID = 1;

        private static class Proxy implements IOpenID {
            private IBinder mRemote;

            Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IOpenID
            public String getSerID(String r10, String r11, String r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeString(r11);     // Catch: Throwable -> L6
                r13.writeString(r12);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                String r15 = r14.readString();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return r15;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOpenID asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IOpenID) == false) goto L12;
            return (IOpenID) r11;
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
            String r14 = getSerID(r11.readString(), r11.readString(), r11.readString());
            r12.writeNoException();
            r12.writeString(r14);
            return true;
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    String getSerID(String r10, String r11, String r12);
}
