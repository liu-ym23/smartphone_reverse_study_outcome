package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICldReportManager extends IInterface {
    public static final int CLD_MODULE_TYPE_BT = 1;
    public static final int CLD_MODULE_TYPE_GNSS = 3;
    public static final int CLD_MODULE_TYPE_LOGCAT = 5;
    public static final int CLD_MODULE_TYPE_NETWORK = 2;
    public static final int CLD_MODULE_TYPE_NFC = 4;
    public static final int CLD_MODULE_TYPE_WIFI = 0;

    public static class Default implements ICldReportManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void reportErrorEvent(int r8, int r10, int r11, int r12, String r13) {
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void startCollect(ICldReportCallback r8, int r10, int r11, int r12, int r13, String r14, boolean r15) {
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void stopCollect(ICldReportCallback r8, int r10, int r11) {
        }
    }

    public static abstract class Stub extends Binder implements ICldReportManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportManager";
        static final int TRANSACTION_reportErrorEvent = 1;
        static final int TRANSACTION_startCollect = 2;
        static final int TRANSACTION_stopCollect = 3;

        public static class Proxy implements ICldReportManager {
            public static ICldReportManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void reportErrorEvent(int r10, int r11, int r12, int r13, String r14) {
                Parcel r8 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r8.writeInt(r10);     // Catch: Throwable -> L12
                r8.writeInt(r11);     // Catch: Throwable -> L12
                r8.writeInt(r12);     // Catch: Throwable -> L12
                r8.writeInt(r13);     // Catch: Throwable -> L12
                r8.writeString(r14);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r8, r15, 0) == false) goto L6;
            L10:
                r15.readException();     // Catch: Throwable -> L12
            L8:
                r15.recycle();
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportErrorEvent(r10, r11, r12, r13, r14);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r15.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void startCollect(ICldReportCallback r12, int r13, int r14, int r15, int r16, String r17, boolean r18) {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r12 == null) goto L6;
                IBinder r11 = r12.asBinder();     // Catch: Throwable -> L16
            L7:
                r8.writeStrongBinder(r11);     // Catch: Throwable -> L16
                r8.writeInt(r13);     // Catch: Throwable -> L16
                r8.writeInt(r14);     // Catch: Throwable -> L16
                r8.writeInt(r15);     // Catch: Throwable -> L16
                r8.writeInt(r16);     // Catch: Throwable -> L16
                r8.writeString(r17);     // Catch: Throwable -> L16
                r8.writeInt(r18 ? 1 : 0);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r8, r10, 0) == false) goto L10;
            L14:
                r10.readException();     // Catch: Throwable -> L16
            L12:
                r10.recycle();
                r8.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().startCollect(r12, r13, r14, r15, r16, r17, r18);     // Catch: Throwable -> L16
                goto L12
            L6:
                r11 = null;
            L16:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void stopCollect(ICldReportCallback r8, int r10, int r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r14 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L16
                r12.writeInt(r10);     // Catch: Throwable -> L16
                r12.writeInt(r11);     // Catch: Throwable -> L16
                if (this.mRemote.transact(3, r12, r13, 0) == false) goto L10;
            L14:
                r13.readException();     // Catch: Throwable -> L16
            L12:
                r13.recycle();
                r12.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().stopCollect(r8, r10, r11);     // Catch: Throwable -> L16
                goto L12
            L6:
                r14 = null;
            L16:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICldReportManager asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICldReportManager) == false) goto L12;
            return (ICldReportManager) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICldReportManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICldReportManager r8) {
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
        public boolean onTransact(int r14, Parcel r15, Parcel r16, int r17) {
            if (r14 != 1) goto L5;
            r15.enforceInterface(DESCRIPTOR);
            reportErrorEvent(r15.readInt(), r15.readInt(), r15.readInt(), r15.readInt(), r15.readString());
            r16.writeNoException();
            return true;
        L5:
            if (r14 != 2) goto L7;
            r15.enforceInterface(DESCRIPTOR);
            ICldReportCallback r8 = ICldReportCallback.Stub.asInterface(r15.readStrongBinder());
            int r10 = r15.readInt();
            int r11 = r15.readInt();
            int r12 = r15.readInt();
            int r13 = r15.readInt();
            String r18 = r15.readString();
            if (r15.readInt() == 0) goto L19;
            boolean r19 = true;
        L20:
            startCollect(r8, r10, r11, r12, r13, r18, r19);
            r16.writeNoException();
            return true;
        L19:
            r19 = false;
            goto L20
        L7:
            if (r14 != 3) goto L9;
            r15.enforceInterface(DESCRIPTOR);
            stopCollect(ICldReportCallback.Stub.asInterface(r15.readStrongBinder()), r15.readInt(), r15.readInt());
            r16.writeNoException();
            return true;
        L9:
            if (r14 != 1598968902) goto L11;
            r16.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r14, r15, r16, r17);
        }
    }

    void reportErrorEvent(int r8, int r10, int r11, int r12, String r13);

    void startCollect(ICldReportCallback r8, int r10, int r11, int r12, int r13, String r14, boolean r15);

    void stopCollect(ICldReportCallback r8, int r10, int r11);
}
