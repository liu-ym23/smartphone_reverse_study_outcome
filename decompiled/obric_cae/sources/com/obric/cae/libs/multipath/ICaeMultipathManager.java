package com.obric.cae.libs.multipath;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeMultipathManager extends IInterface {

    public static class Default implements ICaeMultipathManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public String getLatestNetworkTruth() {
            return null;
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportAssistantFailure() {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportAssistantOperateApps(int[] r8) {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportMPAConnectionQuality(String r8, int r10, int r11, int r12, int r13, int r14) {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportPathCtlModeChanged(String r8, int r10) {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void setICaeMultipathCallback(ICaeMultipathCallback r8) {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void startMultipath() {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void stopMultipath() {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void unsetICaeMultipathCallback() {
        }
    }

    public static abstract class Stub extends Binder implements ICaeMultipathManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.multipath.ICaeMultipathManager";
        static final int TRANSACTION_getLatestNetworkTruth = 7;
        static final int TRANSACTION_reportAssistantFailure = 8;
        static final int TRANSACTION_reportAssistantOperateApps = 9;
        static final int TRANSACTION_reportMPAConnectionQuality = 3;
        static final int TRANSACTION_reportPathCtlModeChanged = 6;
        static final int TRANSACTION_setICaeMultipathCallback = 4;
        static final int TRANSACTION_startMultipath = 1;
        static final int TRANSACTION_stopMultipath = 2;
        static final int TRANSACTION_unsetICaeMultipathCallback = 5;

        public static class Proxy implements ICaeMultipathManager {
            public static ICaeMultipathManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public String getLatestNetworkTruth() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                String r11 = r10.readString();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getLatestNetworkTruth();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportAssistantFailure() {
                Parcel r8 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(8, r8, null, 1) == false) goto L6;
            L10:
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportAssistantFailure();     // Catch: Throwable -> L12
                r8.recycle();
                return;
            L12:
                th = move-exception;
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportAssistantOperateApps(int[] r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeIntArray(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(9, r10, null, 1) == false) goto L6;
            L10:
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportAssistantOperateApps(r8);     // Catch: Throwable -> L12
                r10.recycle();
                return;
            L12:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportMPAConnectionQuality(String r10, int r11, int r12, int r13, int r14, int r15) {
                Parcel r8 = Parcel.obtain();
                Parcel r16 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r8.writeString(r10);     // Catch: Throwable -> L12
                r8.writeInt(r11);     // Catch: Throwable -> L12
                r8.writeInt(r12);     // Catch: Throwable -> L12
                r8.writeInt(r13);     // Catch: Throwable -> L12
                r8.writeInt(r14);     // Catch: Throwable -> L12
                r8.writeInt(r15);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r8, r16, 0) == false) goto L6;
            L10:
                r16.readException();     // Catch: Throwable -> L12
            L8:
                r16.recycle();
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportMPAConnectionQuality(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r16.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportPathCtlModeChanged(String r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeString(r8);     // Catch: Throwable -> L12
                r11.writeInt(r10);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L12
            L8:
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportPathCtlModeChanged(r8, r10);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void setICaeMultipathCallback(ICaeMultipathCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(4, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setICaeMultipathCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void startMultipath() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().startMultipath();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void stopMultipath() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().stopMultipath();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void unsetICaeMultipathCallback() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unsetICaeMultipathCallback();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeMultipathManager asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeMultipathManager) == false) goto L12;
            return (ICaeMultipathManager) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeMultipathManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeMultipathManager r8) {
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
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 == 1598968902) goto L25;
            switch(r10) {
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L19;
                case 4: goto L17;
                case 5: goto L15;
                case 6: goto L13;
                case 7: goto L11;
                case 8: goto L9;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r11.enforceInterface(DESCRIPTOR);
            reportAssistantOperateApps(r11.createIntArray());
            return true;
        L9:
            r11.enforceInterface(DESCRIPTOR);
            reportAssistantFailure();
            return true;
        L11:
            r11.enforceInterface(DESCRIPTOR);
            String r14 = getLatestNetworkTruth();
            r12.writeNoException();
            r12.writeString(r14);
            return true;
        L13:
            r11.enforceInterface(DESCRIPTOR);
            reportPathCtlModeChanged(r11.readString(), r11.readInt());
            r12.writeNoException();
            return true;
        L15:
            r11.enforceInterface(DESCRIPTOR);
            unsetICaeMultipathCallback();
            r12.writeNoException();
            return true;
        L17:
            r11.enforceInterface(DESCRIPTOR);
            setICaeMultipathCallback(ICaeMultipathCallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L19:
            r11.enforceInterface(DESCRIPTOR);
            reportMPAConnectionQuality(r11.readString(), r11.readInt(), r11.readInt(), r11.readInt(), r11.readInt(), r11.readInt());
            r12.writeNoException();
            return true;
        L21:
            r11.enforceInterface(DESCRIPTOR);
            stopMultipath();
            r12.writeNoException();
            return true;
        L23:
            r11.enforceInterface(DESCRIPTOR);
            startMultipath();
            r12.writeNoException();
            return true;
        L6:
            return super.onTransact(r10, r11, r12, r13);
        L25:
            r12.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getLatestNetworkTruth();

    void reportAssistantFailure();

    void reportAssistantOperateApps(int[] r8);

    void reportMPAConnectionQuality(String r8, int r10, int r11, int r12, int r13, int r14);

    void reportPathCtlModeChanged(String r8, int r10);

    void setICaeMultipathCallback(ICaeMultipathCallback r8);

    void startMultipath();

    void stopMultipath();

    void unsetICaeMultipathCallback();
}
