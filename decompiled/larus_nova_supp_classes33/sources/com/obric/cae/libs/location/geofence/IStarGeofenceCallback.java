package com.obric.cae.libs.location.geofence;

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
public interface IStarGeofenceCallback extends IInterface {
    public static final int GEOFENCE_GEN_ALERT_GNSS_AVAILABLE = 2;
    public static final int GEOFENCE_GEN_ALERT_GNSS_UNAVAILABLE = 1;
    public static final int GEOFENCE_GEN_ALERT_OOS = 3;
    public static final int GEOFENCE_GEN_ALERT_TIME_INVALID = 4;

    public static class Default implements IStarGeofenceCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
        public void onBreachReport(String r1, Location r2, int r3) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
        public void onGeofenceStatusReport(int r1, Location r2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarGeofenceCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.geofence.IStarGeofenceCallback";
        static final int TRANSACTION_onBreachReport = 1;
        static final int TRANSACTION_onGeofenceStatusReport = 2;

        public static class Proxy implements IStarGeofenceCallback {
            public static IStarGeofenceCallback sDefaultImpl;
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

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
            public void onGeofenceStatusReport(int r6, Location r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r6);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onGeofenceStatusReport(r6, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
            public void onBreachReport(String r5, Location r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeInt(r7);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onBreachReport(r5, r6, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static IStarGeofenceCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IStarGeofenceCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarGeofenceCallback) == false) goto L12;
            return (IStarGeofenceCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IStarGeofenceCallback r1) {
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
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            Location r0 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            String r9 = r6.readString();
            if (r6.readInt() == 0) goto L20;
            r0 = (Location) Location.CREATOR.createFromParcel(r6);
        L20:
            onBreachReport(r9, r0, r6.readInt());
            return true;
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            int r10 = r6.readInt();
            if (r6.readInt() == 0) goto L15;
            r0 = (Location) Location.CREATOR.createFromParcel(r6);
        L15:
            onGeofenceStatusReport(r10, r0);
            return true;
        L7:
            if (r5 != 1598968902) goto L9;
            r7.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    void onBreachReport(String r1, Location r2, int r3) throws RemoteException;

    void onGeofenceStatusReport(int r1, Location r2) throws RemoteException;
}
