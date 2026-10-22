package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IDidAidlInterface extends IInterface {

    public static abstract class Stub extends Binder implements IDidAidlInterface {
        private static final String DESCRIPTOR = "com.asus.msa.SupplementaryDID.IDidAidlInterface";
        static final int TRANSACTION_a = 2;
        static final int TRANSACTION_c = 4;
        static final int TRANSACTION_d = 5;
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_support = 1;

        private static class Proxy implements IDidAidlInterface {
            private IBinder mRemote;

            Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDidAidlInterface
            public String getAAID() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r10, r11, 0);     // Catch: Throwable -> L6
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

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDidAidlInterface
            public String getOAID() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.bdinstall.oaid.impl.IDidAidlInterface
            public String getUDID() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.bdinstall.oaid.impl.IDidAidlInterface
            public String getVAID() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.bdinstall.oaid.impl.IDidAidlInterface
            public boolean support() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r12 = false;
                this.mRemote.transact(1, r10, r11, 0);     // Catch: Throwable -> L8
                r11.readException();     // Catch: Throwable -> L8
                if (r11.readInt() == 0) goto L6;
                r12 = true;
            L6:
                r11.recycle();
                r10.recycle();
                return r12;
            L8:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDidAidlInterface asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IDidAidlInterface) == false) goto L12;
            return (IDidAidlInterface) r11;
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
            boolean r14 = support();
            r12.writeNoException();
            r12.writeInt(r14 ? 1 : 0);
            return true;
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface(DESCRIPTOR);
            String r15 = getUDID();
        L19:
            r12.writeNoException();
            r12.writeString(r15);
            return true;
        L7:
            if (r10 != 3) goto L9;
            r11.enforceInterface(DESCRIPTOR);
            r15 = getOAID();
            goto L19
        L9:
            if (r10 != 4) goto L11;
            r11.enforceInterface(DESCRIPTOR);
            r15 = getVAID();
            goto L19
        L11:
            if (r10 != 5) goto L13;
            r11.enforceInterface(DESCRIPTOR);
            r15 = getAAID();
            goto L19
        L13:
            if (r10 != 1598968902) goto L15;
            r12.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    String getAAID();

    String getOAID();

    String getUDID();

    String getVAID();

    boolean support();
}
