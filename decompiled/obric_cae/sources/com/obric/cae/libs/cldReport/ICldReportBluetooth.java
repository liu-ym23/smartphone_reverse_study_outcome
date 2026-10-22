package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICldReportBluetooth extends IInterface {
    public static final int CLD_ERRCODE_BLUETOOTH_BOND = 0;
    public static final int CLD_ERRCODE_BLUETOOTH_LINK = 1;

    public static class Default implements ICldReportBluetooth {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICldReportBluetooth {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportBluetooth";

        public static class Proxy implements ICldReportBluetooth {
            public static ICldReportBluetooth sDefaultImpl;
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
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICldReportBluetooth asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICldReportBluetooth) == false) goto L12;
            return (ICldReportBluetooth) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICldReportBluetooth getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICldReportBluetooth r8) {
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
            if (r8 != 1598968902) goto L5;
            r11.writeString(DESCRIPTOR);
            return true;
        L5:
            return super.onTransact(r8, r10, r11, r12);
        }
    }
}
