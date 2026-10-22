package com.obric.cae.libs.bluetooth.exporter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeDcfScanExporter extends IInterface {

    public static class Default implements ICaeDcfScanExporter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
        public boolean isDcfScanSupported() {
            return false;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
        public void registerDcfScanCallback(ICaeDcfScanCallbackExporter r8) {
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
        public void unregisterDcfScanCallback(ICaeDcfScanCallbackExporter r8) {
        }
    }

    public static abstract class Stub extends Binder implements ICaeDcfScanExporter {
        private static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter";
        static final int TRANSACTION_isDcfScanSupported = 3;
        static final int TRANSACTION_registerDcfScanCallback = 1;
        static final int TRANSACTION_unregisterDcfScanCallback = 2;

        public static class Proxy implements ICaeDcfScanExporter {
            public static ICaeDcfScanExporter sDefaultImpl;
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
            public boolean isDcfScanSupported() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r11 = false;
                if (this.mRemote.transact(3, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L15
                if (r10.readInt() == 0) goto L13;
                r11 = true;
            L13:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r12 = Stub.getDefaultImpl().isDcfScanSupported();     // Catch: Throwable -> L15
                r10.recycle();
                r8.recycle();
                return r12;
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
            public void registerDcfScanCallback(ICaeDcfScanCallbackExporter r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerDcfScanCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
            public void unregisterDcfScanCallback(ICaeDcfScanCallbackExporter r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterDcfScanCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeDcfScanExporter asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeDcfScanExporter) == false) goto L12;
            return (ICaeDcfScanExporter) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeDcfScanExporter getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeDcfScanExporter r8) {
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
            registerDcfScanCallback(ICaeDcfScanCallbackExporter.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            unregisterDcfScanCallback(ICaeDcfScanCallbackExporter.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L7:
            if (r8 != 3) goto L9;
            r10.enforceInterface(DESCRIPTOR);
            boolean r13 = isDcfScanSupported();
            r11.writeNoException();
            r11.writeInt(r13 ? 1 : 0);
            return true;
        L9:
            if (r8 != 1598968902) goto L11;
            r11.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    boolean isDcfScanSupported();

    void registerDcfScanCallback(ICaeDcfScanCallbackExporter r8);

    void unregisterDcfScanCallback(ICaeDcfScanCallbackExporter r8);
}
