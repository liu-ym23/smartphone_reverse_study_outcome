package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface ICldReportNetwork extends IInterface {
    public static final int CLD_ASSISTANT_REASON_FAILURE = 1;
    public static final int CLD_DATA_STALL_REASON_DNS = 1;
    public static final int CLD_DATA_STALL_REASON_TCP = 2;
    public static final int CLD_ERRCODE_NETWORK_ASSISTANT = 2;
    public static final int CLD_ERRCODE_NETWORK_DATA_STALL = 0;
    public static final int CLD_ERRCODE_NETWORK_HANDOVER = 1;
    public static final int CLD_ERRCODE_NETWORK_SELF_HEAL = 3;
    public static final int CLD_HANDOVER_REASON_INTERVENED = 3;
    public static final int CLD_HANDOVER_REASON_SWITCH = 1;
    public static final int CLD_HANDOVER_REASON_UNSWITCH = 2;
    public static final int CLD_HANDOVER_SUBREASON_INVALID = 3;
    public static final int CLD_HANDOVER_SUBREASON_L2QOE = 1;
    public static final int CLD_HANDOVER_SUBREASON_L4QOE = 2;
    public static final int CLD_HANDOVER_SUBREASON_NO_SWITCH_AND_INTERVENED = 5;
    public static final int CLD_HANDOVER_SUBREASON_SWITCH_AND_INTERVENED = 4;
    public static final int CLD_HANDOVER_SUBREASON_SWITCH_AND_NO_INTERVENED = 6;
    public static final int CLD_HANDOVER_SUBREASON_UNKNOWN = 0;
    public static final int CLD_HANDOVER_SUBREASON_WIFI_SCORE = 7;

    public static class Default implements ICldReportNetwork {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICldReportNetwork {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportNetwork";

        public static class Proxy implements ICldReportNetwork {
            public static ICldReportNetwork sDefaultImpl;
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

        public static ICldReportNetwork getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICldReportNetwork asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICldReportNetwork) == false) goto L12;
            return (ICldReportNetwork) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ICldReportNetwork r1) {
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
