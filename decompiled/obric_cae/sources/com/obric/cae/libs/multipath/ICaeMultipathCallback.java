package com.obric.cae.libs.multipath;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeMultipathCallback extends IInterface {

    public static class Default implements ICaeMultipathCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathCallback
        public boolean changePathCtlAction(String r8, int r10) {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICaeMultipathCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.multipath.ICaeMultipathCallback";
        static final int TRANSACTION_changePathCtlAction = 1;

        public static class Proxy implements ICaeMultipathCallback {
            public static ICaeMultipathCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathCallback
            public boolean changePathCtlAction(String r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r11.writeString(r8);     // Catch: Throwable -> L15
                r11.writeInt(r10);     // Catch: Throwable -> L15
                boolean r13 = false;
                if (this.mRemote.transact(1, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L15
                if (r12.readInt() == 0) goto L13;
                r13 = true;
            L13:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r14 = Stub.getDefaultImpl().changePathCtlAction(r8, r10);     // Catch: Throwable -> L15
                r12.recycle();
                r11.recycle();
                return r14;
            L15:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeMultipathCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeMultipathCallback) == false) goto L12;
            return (ICaeMultipathCallback) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeMultipathCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeMultipathCallback r8) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r8 == null) goto L7;
            Proxy.sDefaultImpl = r8;
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
        public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1) goto L5;
            r10.enforceInterface(DESCRIPTOR);
            boolean r13 = changePathCtlAction(r10.readString(), r10.readInt());
            r11.writeNoException();
            r11.writeInt(r13 ? 1 : 0);
            return true;
        L5:
            if (r8 != 1598968902) goto L7;
            r11.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    boolean changePathCtlAction(String r8, int r10);
}
