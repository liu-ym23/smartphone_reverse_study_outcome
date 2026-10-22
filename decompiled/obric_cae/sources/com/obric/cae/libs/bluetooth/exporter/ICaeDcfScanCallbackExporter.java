package com.obric.cae.libs.bluetooth.exporter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.cae.libs.bluetooth.CaeDcfScanResult;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeDcfScanCallbackExporter extends IInterface {

    public static class Default implements ICaeDcfScanCallbackExporter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanCallbackExporter
        public void onDevicesChanged(List<CaeDcfScanResult> r8) {
        }
    }

    public static abstract class Stub extends Binder implements ICaeDcfScanCallbackExporter {
        private static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanCallbackExporter";
        static final int TRANSACTION_onDevicesChanged = 1;

        public static class Proxy implements ICaeDcfScanCallbackExporter {
            public static ICaeDcfScanCallbackExporter sDefaultImpl;
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanCallbackExporter
            public void onDevicesChanged(List<CaeDcfScanResult> r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeTypedList(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onDevicesChanged(r8);     // Catch: Throwable -> L12
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

        public static ICaeDcfScanCallbackExporter asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeDcfScanCallbackExporter) == false) goto L12;
            return (ICaeDcfScanCallbackExporter) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeDcfScanCallbackExporter getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeDcfScanCallbackExporter r8) {
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
            onDevicesChanged(r10.createTypedArrayList(CaeDcfScanResult.CREATOR));
            r11.writeNoException();
            return true;
        L5:
            if (r8 != 1598968902) goto L7;
            r11.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void onDevicesChanged(List<CaeDcfScanResult> r8);
}
