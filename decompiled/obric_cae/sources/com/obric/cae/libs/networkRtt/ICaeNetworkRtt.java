package com.obric.cae.libs.networkRtt;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeNetworkRtt extends IInterface {

    public static class Default implements ICaeNetworkRtt {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.networkRtt.ICaeNetworkRtt
        public int getGameRttbyUid(int r8) {
            return 0;
        }

        @Override // com.obric.cae.libs.networkRtt.ICaeNetworkRtt
        public int getRttByUid(int r8) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ICaeNetworkRtt {
        private static final String DESCRIPTOR = "com.obric.cae.libs.networkRtt.ICaeNetworkRtt";
        static final int TRANSACTION_getGameRttbyUid = 2;
        static final int TRANSACTION_getRttByUid = 1;

        public static class Proxy implements ICaeNetworkRtt {
            public static ICaeNetworkRtt sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.networkRtt.ICaeNetworkRtt
            public int getGameRttbyUid(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
                int r12 = r11.readInt();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r12 = Stub.getDefaultImpl().getGameRttbyUid(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.networkRtt.ICaeNetworkRtt
            public int getRttByUid(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
                int r12 = r11.readInt();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r12 = Stub.getDefaultImpl().getRttByUid(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeNetworkRtt asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeNetworkRtt) == false) goto L12;
            return (ICaeNetworkRtt) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeNetworkRtt getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeNetworkRtt r8) {
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
            int r13 = getRttByUid(r10.readInt());
        L13:
            r11.writeNoException();
            r11.writeInt(r13);
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            r13 = getGameRttbyUid(r10.readInt());
            goto L13
        L7:
            if (r8 != 1598968902) goto L9;
            r11.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    int getGameRttbyUid(int r8);

    int getRttByUid(int r8);
}
