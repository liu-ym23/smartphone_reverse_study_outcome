package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICldReportGnss extends IInterface {
    public static final int CLD_ERRCODE_GNSS_EVENT_NFW_POWER = 4;
    public static final int CLD_ERRCODE_GNSS_FEEDBACK = 1;
    public static final int CLD_ERRCODE_GNSS_MAGIC_NUMBER_BUGREPORT = 2;
    public static final int CLD_ERRCODE_GNSS_MAGIC_NUMBER_MODEM = 3;
    public static final int CLD_ERRCODE_LOCATION_AOI_BOARD_BREACH = 6;
    public static final int CLD_ERRCODE_SENSOR_FLIGHT_MODE = 5;

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

        public static ICldReportGnss asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICldReportGnss) == false) goto L12;
            return (ICldReportGnss) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICldReportGnss getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICldReportGnss r8) {
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
