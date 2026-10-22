package com.obric.cae.libs.location.poi;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface IStarAoiBoardCallback extends IInterface {
    public static final int AOI_BOARD_EVENT_ENTER = 1;
    public static final int AOI_BOARD_EVENT_EXIT = 2;
    public static final int AOI_BOARD_EVENT_UNKNOWN = 0;

    public static class Default implements IStarAoiBoardCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardCallback
        public void onAoiBoardBreachReport(AoiBoard r1, Location r2, int r3) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarAoiBoardCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.poi.IStarAoiBoardCallback";
        static final int TRANSACTION_onAoiBoardBreachReport = 1;

        public static class Proxy implements IStarAoiBoardCallback {
            public static IStarAoiBoardCallback sDefaultImpl;
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

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardCallback
            public void onAoiBoardBreachReport(AoiBoard r5, Location r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L10:
                r0.writeInt(r7);     // Catch: Throwable -> L19
                if (INVOKEINTERFACE_com_obric_cae_libs_location_poi_IStarAoiBoardCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L13;
            L17:
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onAoiBoardBreachReport(r5, r6, r7);     // Catch: Throwable -> L19
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L19
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_location_poi_IStarAoiBoardCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r2 = SystemClock.uptimeMillis();
                boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
                long r8 = SystemClock.uptimeMillis() - r2;
                if (r8 < 100) goto L11;
                BinderPerformanceReporter.report(r8, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r0;
            L12:
                th = move-exception;
                long r9 = SystemClock.uptimeMillis() - r2;
                if (r9 < 100) goto L22;
                if (r15 != null) goto L17;
                String r1 = "";
            L18:
                BinderPerformanceReporter.report(r9, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r1 = r15.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r15.transact(r16, r17, r18, r19);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarAoiBoardCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IStarAoiBoardCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarAoiBoardCallback) == false) goto L12;
            return (IStarAoiBoardCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IStarAoiBoardCallback r1) {
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
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            Location r8 = null;
            if (r5.readInt() == 0) goto L13;
            AoiBoard r9 = (AoiBoard) AoiBoard.CREATOR.createFromParcel(r5);
        L15:
            if (r5.readInt() == 0) goto L17;
            r8 = (Location) Location.CREATOR.createFromParcel(r5);
        L17:
            onAoiBoardBreachReport(r9, r8, r5.readInt());
            return true;
        L13:
            r9 = null;
            goto L15
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onAoiBoardBreachReport(AoiBoard r1, Location r2, int r3) throws RemoteException;
}
