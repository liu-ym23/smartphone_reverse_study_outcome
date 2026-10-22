package com.obric.cae.libs.location.geofence;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
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
        public void onBreachReport(String r8, Location r10, int r11) {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
        public void onGeofenceStatusReport(int r8, Location r10) {
        }
    }

    public static abstract class Stub extends Binder implements IStarGeofenceCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.geofence.IStarGeofenceCallback";
        static final int TRANSACTION_onBreachReport = 1;
        static final int TRANSACTION_onGeofenceStatusReport = 2;

        public static class Proxy implements IStarGeofenceCallback {
            public static IStarGeofenceCallback sDefaultImpl;
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

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
            public void onBreachReport(String r8, Location r10, int r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r12.writeString(r8);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                r12.writeInt(1);     // Catch: Throwable -> L16
                r10.writeToParcel(r12, 0);     // Catch: Throwable -> L16
            L7:
                r12.writeInt(r11);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r12, null, 1) == false) goto L10;
            L14:
                r12.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onBreachReport(r8, r10, r11);     // Catch: Throwable -> L16
                r12.recycle();
                return;
            L6:
                r12.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
            public void onGeofenceStatusReport(int r8, Location r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r11.writeInt(r8);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L16
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(2, r11, null, 1) == false) goto L10;
            L14:
                r11.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onGeofenceStatusReport(r8, r10);     // Catch: Throwable -> L16
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarGeofenceCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IStarGeofenceCallback) == false) goto L12;
            return (IStarGeofenceCallback) r10;
        L12:
            return new Proxy(r8);
        }

        public static IStarGeofenceCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IStarGeofenceCallback r8) {
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
            Location r13 = null;
            if (r8 != 1) goto L5;
            r10.enforceInterface(DESCRIPTOR);
            String r14 = r10.readString();
            if (r10.readInt() == 0) goto L20;
            r13 = (Location) Location.CREATOR.createFromParcel(r10);
        L20:
            onBreachReport(r14, r13, r10.readInt());
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            int r15 = r10.readInt();
            if (r10.readInt() == 0) goto L15;
            r13 = (Location) Location.CREATOR.createFromParcel(r10);
        L15:
            onGeofenceStatusReport(r15, r13);
            return true;
        L7:
            if (r8 != 1598968902) goto L9;
            r11.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void onBreachReport(String r8, Location r10, int r11);

    void onGeofenceStatusReport(int r8, Location r10);
}
