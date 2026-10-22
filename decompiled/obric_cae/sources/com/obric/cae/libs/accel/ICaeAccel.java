package com.obric.cae.libs.accel;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeAccel extends IInterface {

    public static class Default implements ICaeAccel {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageAccelEnable(String r8, boolean r10) {
            return 0;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageAutoDualWlanMode(String r8, int r10) {
            return 0;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageFlowSched(String r8, boolean r10) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ICaeAccel {
        private static final String DESCRIPTOR = "com.obric.cae.libs.accel.ICaeAccel";
        static final int TRANSACTION_setPackageAccelEnable = 1;
        static final int TRANSACTION_setPackageAutoDualWlanMode = 3;
        static final int TRANSACTION_setPackageFlowSched = 2;

        public static class Proxy implements ICaeAccel {
            public static ICaeAccel sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.accel.ICaeAccel
            public int setPackageAccelEnable(String r8, boolean r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeString(r8);     // Catch: Throwable -> L12
                r11.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L12
                int r13 = r12.readInt();     // Catch: Throwable -> L12
            L8:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r13 = Stub.getDefaultImpl().setPackageAccelEnable(r8, r10);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.accel.ICaeAccel
            public int setPackageAutoDualWlanMode(String r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeString(r8);     // Catch: Throwable -> L12
                r11.writeInt(r10);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L12
                int r13 = r12.readInt();     // Catch: Throwable -> L12
            L8:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r13 = Stub.getDefaultImpl().setPackageAutoDualWlanMode(r8, r10);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.accel.ICaeAccel
            public int setPackageFlowSched(String r8, boolean r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeString(r8);     // Catch: Throwable -> L12
                r11.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L12
                int r13 = r12.readInt();     // Catch: Throwable -> L12
            L8:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r13 = Stub.getDefaultImpl().setPackageFlowSched(r8, r10);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeAccel asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeAccel) == false) goto L12;
            return (ICaeAccel) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeAccel getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeAccel r8) {
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
            boolean r13 = false;
            if (r8 != 1) goto L5;
            r10.enforceInterface(DESCRIPTOR);
            String r14 = r10.readString();
            if (r10.readInt() == 0) goto L24;
            r13 = true;
        L24:
            int r15 = setPackageAccelEnable(r14, r13);
        L15:
            r11.writeNoException();
            r11.writeInt(r15);
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            String r16 = r10.readString();
            if (r10.readInt() == 0) goto L20;
            r13 = true;
        L20:
            r15 = setPackageFlowSched(r16, r13);
            goto L15
        L7:
            if (r8 != 3) goto L9;
            r10.enforceInterface(DESCRIPTOR);
            r15 = setPackageAutoDualWlanMode(r10.readString(), r10.readInt());
            goto L15
        L9:
            if (r8 != 1598968902) goto L11;
            r11.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    int setPackageAccelEnable(String r8, boolean r10);

    int setPackageAutoDualWlanMode(String r8, int r10);

    int setPackageFlowSched(String r8, boolean r10);
}
