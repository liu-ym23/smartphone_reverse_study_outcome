package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface ICldReportGnss extends IInterface {
    public static final int CLD_ERRCODE_GNSS_EVENT_NFW_POWER = 4;
    public static final int CLD_ERRCODE_GNSS_FEEDBACK = 1;
    public static final int CLD_ERRCODE_GNSS_MAGIC_NUMBER_BUGREPORT = 2;
    public static final int CLD_ERRCODE_GNSS_MAGIC_NUMBER_MODEM = 3;

    public static class Default implements ICldReportGnss {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICldReportGnss {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportGnss";

        public static class Proxy implements ICldReportGnss {
            public static ICldReportGnss sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICldReportGnss getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICldReportGnss asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICldReportGnss) == false) goto L12;
            return (ICldReportGnss) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ICldReportGnss r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r2, Parcel r3, Parcel r4, int r5) throws RemoteException {
            if (r2 != 1598968902) goto L5;
            r4.writeString(DESCRIPTOR);
            return true;
        L5:
            return super.onTransact(r2, r3, r4, r5);
        }
    }
}
