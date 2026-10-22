package com.obric.cae.libs.l4NetStatus;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IQoeStatusReportManager extends IInterface {

    public static class Default implements IQoeStatusReportManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
        public boolean registerQoeStatusListener(String r8, IQoeStatusListener r10) {
            return false;
        }

        @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
        public boolean unregisterQoeStatusListener(String r8, IQoeStatusListener r10) {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IQoeStatusReportManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager";
        static final int TRANSACTION_registerQoeStatusListener = 1;
        static final int TRANSACTION_unregisterQoeStatusListener = 2;

        public static class Proxy implements IQoeStatusReportManager {
            public static IQoeStatusReportManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
            public boolean registerQoeStatusListener(String r8, IQoeStatusListener r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r11.writeString(r8);     // Catch: Throwable -> L19
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L19
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L19
                boolean r14 = false;
                if (this.mRemote.transact(1, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L19
                if (r12.readInt() == 0) goto L17;
                r14 = true;
            L17:
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r15 = Stub.getDefaultImpl().registerQoeStatusListener(r8, r10);     // Catch: Throwable -> L19
                r12.recycle();
                r11.recycle();
                return r15;
            L6:
                r13 = null;
            L19:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
            public boolean unregisterQoeStatusListener(String r8, IQoeStatusListener r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r11.writeString(r8);     // Catch: Throwable -> L19
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L19
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L19
                boolean r14 = false;
                if (this.mRemote.transact(2, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L19
                if (r12.readInt() == 0) goto L17;
                r14 = true;
            L17:
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r15 = Stub.getDefaultImpl().unregisterQoeStatusListener(r8, r10);     // Catch: Throwable -> L19
                r12.recycle();
                r11.recycle();
                return r15;
            L6:
                r13 = null;
            L19:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IQoeStatusReportManager asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IQoeStatusReportManager) == false) goto L12;
            return (IQoeStatusReportManager) r10;
        L12:
            return new Proxy(r8);
        }

        public static IQoeStatusReportManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IQoeStatusReportManager r8) {
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1) goto L5;
            r10.enforceInterface(DESCRIPTOR);
            int r13 = registerQoeStatusListener(r10.readString(), IQoeStatusListener.Stub.asInterface(r10.readStrongBinder()));
        L13:
            r11.writeNoException();
            r11.writeInt(r13);
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            r13 = unregisterQoeStatusListener(r10.readString(), IQoeStatusListener.Stub.asInterface(r10.readStrongBinder()));
            goto L13
        L7:
            if (r8 != 1598968902) goto L9;
            r11.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    boolean registerQoeStatusListener(String r8, IQoeStatusListener r10);

    boolean unregisterQoeStatusListener(String r8, IQoeStatusListener r10);
}
