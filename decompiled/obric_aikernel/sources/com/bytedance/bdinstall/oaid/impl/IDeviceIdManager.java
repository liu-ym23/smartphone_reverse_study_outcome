package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IDeviceIdManager extends IInterface {

    public static class Default implements IDeviceIdManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public String getAAID(String r10) {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public String getCoolOsVersion() {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public String getIMEI(String r10) {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public String getOAID(String r10) {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public String getUDID(String r10) {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public String getVAID(String r10) {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public boolean isCoolOs() {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IDeviceIdManager {
        private static final String DESCRIPTOR = "com.coolpad.deviceidsupport.IDeviceIdManager";
        static final int TRANSACTION_getAAID = 4;
        static final int TRANSACTION_getCoolOsVersion = 7;
        static final int TRANSACTION_getIMEI = 5;
        static final int TRANSACTION_getOAID = 2;
        static final int TRANSACTION_getUDID = 1;
        static final int TRANSACTION_getVAID = 3;
        static final int TRANSACTION_isCoolOs = 6;

        private static class Proxy implements IDeviceIdManager {
            public static IDeviceIdManager sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public String getAAID(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                String r13 = r12.readString();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r14 = Stub.getDefaultImpl().getAAID(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public String getCoolOsVersion() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                String r12 = r11.readString();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r13 = Stub.getDefaultImpl().getCoolOsVersion();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public String getIMEI(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                String r13 = r12.readString();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r14 = Stub.getDefaultImpl().getIMEI(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public String getOAID(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                String r13 = r12.readString();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r14 = Stub.getDefaultImpl().getOAID(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public String getUDID(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                String r13 = r12.readString();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r14 = Stub.getDefaultImpl().getUDID(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public String getVAID(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                String r13 = r12.readString();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r14 = Stub.getDefaultImpl().getVAID(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public boolean isCoolOs() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r12 = false;
                if (this.mRemote.transact(6, r10, r11, 0) == false) goto L6;
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
                boolean r13 = Stub.getDefaultImpl().isCoolOs();     // Catch: Throwable -> L15
                r11.recycle();
                r10.recycle();
                return r13;
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDeviceIdManager asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IDeviceIdManager) == false) goto L12;
            return (IDeviceIdManager) r11;
        L12:
            return new Proxy(r10);
        }

        public static IDeviceIdManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeviceIdManager r10) {
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
            if (r10 == 1598968902) goto L17;
            switch(r10) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r11.enforceInterface(DESCRIPTOR);
            String r14 = getCoolOsVersion();
        L8:
            r12.writeNoException();
            r12.writeString(r14);
            return true;
        L10:
            r11.enforceInterface(DESCRIPTOR);
            boolean r15 = isCoolOs();
            r12.writeNoException();
            r12.writeInt(r15 ? 1 : 0);
            return true;
        L12:
            r11.enforceInterface(DESCRIPTOR);
            r14 = getIMEI(r11.readString());
            goto L8
        L13:
            r11.enforceInterface(DESCRIPTOR);
            r14 = getAAID(r11.readString());
            goto L8
        L14:
            r11.enforceInterface(DESCRIPTOR);
            r14 = getVAID(r11.readString());
            goto L8
        L15:
            r11.enforceInterface(DESCRIPTOR);
            r14 = getOAID(r11.readString());
            goto L8
        L16:
            r11.enforceInterface(DESCRIPTOR);
            r14 = getUDID(r11.readString());
            goto L8
        L6:
            return super.onTransact(r10, r11, r12, r13);
        L17:
            r12.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getAAID(String r10);

    String getCoolOsVersion();

    String getIMEI(String r10);

    String getOAID(String r10);

    String getUDID(String r10);

    String getVAID(String r10);

    boolean isCoolOs();
}
