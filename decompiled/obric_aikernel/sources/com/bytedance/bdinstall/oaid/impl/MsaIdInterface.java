package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface MsaIdInterface extends IInterface {

    public static class Default implements MsaIdInterface {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.MsaIdInterface
        public String getAAID() {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.MsaIdInterface
        public String getOAID() {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.MsaIdInterface
        public String getVAID() {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.MsaIdInterface
        public boolean isDataArrived() {
            return false;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.MsaIdInterface
        public boolean isSupported() {
            return false;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.MsaIdInterface
        public void shutDown() {
        }
    }

    public static abstract class Stub extends Binder implements MsaIdInterface {
        private static final String DESCRIPTOR = "com.bun.lib.MsaIdInterface";
        static final int TRANSACTION_getAAID = 2;
        static final int TRANSACTION_getOAID = 1;
        static final int TRANSACTION_getVAID = 3;
        static final int TRANSACTION_isDataArrived = 4;
        static final int TRANSACTION_isSupported = 5;
        static final int TRANSACTION_shutDown = 6;

        private static class Proxy implements MsaIdInterface {
            public static MsaIdInterface sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.MsaIdInterface
            public String getAAID() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                String r12 = r11.readString();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r13 = Stub.getDefaultImpl().getAAID();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.MsaIdInterface
            public String getOAID() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                String r12 = r11.readString();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r13 = Stub.getDefaultImpl().getOAID();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.MsaIdInterface
            public String getVAID() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                String r12 = r11.readString();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r13 = Stub.getDefaultImpl().getVAID();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.MsaIdInterface
            public boolean isDataArrived() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r12 = false;
                if (this.mRemote.transact(4, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L13;
                r12 = true;
            L13:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r13 = Stub.getDefaultImpl().isDataArrived();     // Catch: Throwable -> L15
                r11.recycle();
                r10.recycle();
                return r13;
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.MsaIdInterface
            public boolean isSupported() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r12 = false;
                if (this.mRemote.transact(5, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L13;
                r12 = true;
            L13:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r13 = Stub.getDefaultImpl().isSupported();     // Catch: Throwable -> L15
                r11.recycle();
                r10.recycle();
                return r13;
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.MsaIdInterface
            public void shutDown() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().shutDown();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static MsaIdInterface asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof MsaIdInterface) == false) goto L12;
            return (MsaIdInterface) r11;
        L12:
            return new Proxy(r10);
        }

        public static MsaIdInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(MsaIdInterface r10) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r10 == null) goto L7;
            Proxy.sDefaultImpl = r10;
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
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 == 1598968902) goto L19;
            switch(r10) {
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L13;
                case 4: goto L11;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r11.enforceInterface(DESCRIPTOR);
            shutDown();
            r12.writeNoException();
            return true;
        L9:
            r11.enforceInterface(DESCRIPTOR);
            boolean r14 = isSupported();
            r12.writeNoException();
            r12.writeInt(r14 ? 1 : 0);
            return true;
        L11:
            r11.enforceInterface(DESCRIPTOR);
            boolean r15 = isDataArrived();
            r12.writeNoException();
            r12.writeInt(r15 ? 1 : 0);
            return true;
        L13:
            r11.enforceInterface(DESCRIPTOR);
            String r16 = getVAID();
            r12.writeNoException();
            r12.writeString(r16);
            return true;
        L15:
            r11.enforceInterface(DESCRIPTOR);
            String r17 = getAAID();
            r12.writeNoException();
            r12.writeString(r17);
            return true;
        L17:
            r11.enforceInterface(DESCRIPTOR);
            String r18 = getOAID();
            r12.writeNoException();
            r12.writeString(r18);
            return true;
        L6:
            return super.onTransact(r10, r11, r12, r13);
        L19:
            r12.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getAAID();

    String getOAID();

    String getVAID();

    boolean isDataArrived();

    boolean isSupported();

    void shutDown();
}
