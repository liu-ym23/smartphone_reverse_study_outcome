package com.qti.extphone;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IDepersoResCallback extends IInterface {
    public static final String DESCRIPTOR = "com.qti.extphone.IDepersoResCallback";

    public static class Default implements IDepersoResCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.qti.extphone.IDepersoResCallback
        public void onDepersoResult(int r8, int r10) {
        }
    }

    public static abstract class Stub extends Binder implements IDepersoResCallback {
        static final int TRANSACTION_onDepersoResult = 1;

        public static class Proxy implements IDepersoResCallback {
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDepersoResCallback.DESCRIPTOR;
            }

            @Override // com.qti.extphone.IDepersoResCallback
            public void onDepersoResult(int r8, int r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                r11.writeInterfaceToken(IDepersoResCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IDepersoResCallback.DESCRIPTOR);
        }

        public static IDepersoResCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(IDepersoResCallback.DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IDepersoResCallback) == false) goto L12;
            return (IDepersoResCallback) r10;
        L12:
            return new Proxy(r8);
        }

        public static String getDefaultTransactionName(int r8) {
            if (r8 == 1) goto L6;
            return null;
        L6:
            return "onDepersoResult";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public int getMaxTransactionId() {
            return 0;
        }

        public String getTransactionName(int r8) {
            return getDefaultTransactionName(r8);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface(IDepersoResCallback.DESCRIPTOR);
        L8:
            if (r8 != 1598968902) goto L11;
            r11.writeString(IDepersoResCallback.DESCRIPTOR);
            return true;
        L11:
            if (r8 != 1) goto L13;
            int r13 = r10.readInt();
            int r14 = r10.readInt();
            r10.enforceNoDataAvail();
            onDepersoResult(r13, r14);
            return true;
        L13:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void onDepersoResult(int r8, int r10);
}
