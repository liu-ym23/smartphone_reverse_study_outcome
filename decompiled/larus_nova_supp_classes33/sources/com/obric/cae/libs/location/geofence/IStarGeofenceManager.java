package com.obric.cae.libs.location.geofence;

import android.content.ComponentName;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface IStarGeofenceManager extends IInterface {

    public static class Default implements IStarGeofenceManager {
        public Default() {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte addGeofence(StarGeofence r1) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte deleteGeofence(StarGeofence r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte deleteGeofenceById(String r1, String r2) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public StarGeofence findGeofenceById(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public ComponentName getComponent(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public String getVendorVersion() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public boolean isStarGeofencesRecovered() throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public List<StarGeofence> listGeofences(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte registerComponent(ComponentName r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void registerGeofenceCallback(String r1, IStarGeofenceCallback r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void sendDebugEvent(Location r1, int r2, StarGeofence r3) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte unregisterComponent(ComponentName r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void unregisterGeofenceCallback(String r1, IStarGeofenceCallback r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte updateGeofence(StarGeofence r1) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IStarGeofenceManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.geofence.IStarGeofenceManager";
        static final int TRANSACTION_addGeofence = 5;
        static final int TRANSACTION_deleteGeofence = 6;
        static final int TRANSACTION_deleteGeofenceById = 7;
        static final int TRANSACTION_findGeofenceById = 10;
        static final int TRANSACTION_getComponent = 3;
        static final int TRANSACTION_getVendorVersion = 1;
        static final int TRANSACTION_isStarGeofencesRecovered = 14;
        static final int TRANSACTION_listGeofences = 9;
        static final int TRANSACTION_registerComponent = 2;
        static final int TRANSACTION_registerGeofenceCallback = 12;
        static final int TRANSACTION_sendDebugEvent = 11;
        static final int TRANSACTION_unregisterComponent = 4;
        static final int TRANSACTION_unregisterGeofenceCallback = 13;
        static final int TRANSACTION_updateGeofence = 8;

        public static class Proxy implements IStarGeofenceManager {
            public static IStarGeofenceManager sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public String getVendorVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r2 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r3 = Stub.getDefaultImpl().getVendorVersion();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public boolean isStarGeofencesRecovered() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r4 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r2 = Stub.getDefaultImpl().isStarGeofencesRecovered();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r2;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte addGeofence(StarGeofence r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                byte r7 = r1.readByte();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r8 = Stub.getDefaultImpl().addGeofence(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte deleteGeofence(StarGeofence r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                byte r7 = r1.readByte();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r8 = Stub.getDefaultImpl().deleteGeofence(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public StarGeofence findGeofenceById(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                StarGeofence r7 = (StarGeofence) StarGeofence.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r7;
            L14:
                r7 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                StarGeofence r8 = Stub.getDefaultImpl().findGeofenceById(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r8;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public ComponentName getComponent(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                ComponentName r7 = (ComponentName) ComponentName.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r7;
            L14:
                r7 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                ComponentName r8 = Stub.getDefaultImpl().getComponent(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r8;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public List<StarGeofence> listGeofences(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r7 = r1.createTypedArrayList(StarGeofence.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<StarGeofence> r8 = Stub.getDefaultImpl().listGeofences(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte registerComponent(ComponentName r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                byte r7 = r1.readByte();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r8 = Stub.getDefaultImpl().registerComponent(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte unregisterComponent(ComponentName r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                byte r7 = r1.readByte();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r8 = Stub.getDefaultImpl().unregisterComponent(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte updateGeofence(StarGeofence r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                byte r2 = r1.readByte();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r6.readFromParcel(r1);     // Catch: Throwable -> L19
            L17:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r7 = Stub.getDefaultImpl().updateGeofence(r6);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte deleteGeofenceById(String r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                r0.writeString(r7);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                byte r8 = r1.readByte();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                byte r9 = Stub.getDefaultImpl().deleteGeofenceById(r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void registerGeofenceCallback(String r6, IStarGeofenceCallback r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerGeofenceCallback(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void unregisterGeofenceCallback(String r6, IStarGeofenceCallback r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterGeofenceCallback(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void sendDebugEvent(Location r6, int r7, StarGeofence r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L7:
                r0.writeInt(r7);     // Catch: Throwable -> L23
                if (r8 == null) goto L10;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r8.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L12:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L23
                if (r1.readInt() == 0) goto L21;
                r8.readFromParcel(r1);     // Catch: Throwable -> L23
            L21:
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().sendDebugEvent(r6, r7, r8);     // Catch: Throwable -> L23
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r0.writeInt(0);     // Catch: Throwable -> L23
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static IStarGeofenceManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IStarGeofenceManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarGeofenceManager) == false) goto L12;
            return (IStarGeofenceManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IStarGeofenceManager r1) {
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
            if (r5 == 1598968902) goto L70;
            StarGeofence r3 = null;
            switch(r5) {
                case 1: goto L68;
                case 2: goto L63;
                case 3: goto L58;
                case 4: goto L53;
                case 5: goto L48;
                case 6: goto L43;
                case 7: goto L41;
                case 8: goto L33;
                case 9: goto L31;
                case 10: goto L26;
                case 11: goto L14;
                case 12: goto L12;
                case 13: goto L10;
                case 14: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface(DESCRIPTOR);
            boolean r9 = isStarGeofencesRecovered();
            r7.writeNoException();
            r7.writeInt(r9 ? 1 : 0);
            return true;
        L10:
            r6.enforceInterface(DESCRIPTOR);
            unregisterGeofenceCallback(r6.readString(), IStarGeofenceCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L12:
            r6.enforceInterface(DESCRIPTOR);
            registerGeofenceCallback(r6.readString(), IStarGeofenceCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L14:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L17;
            Location r10 = (Location) Location.CREATOR.createFromParcel(r6);
        L18:
            int r11 = r6.readInt();
            if (r6.readInt() == 0) goto L21;
            r3 = (StarGeofence) StarGeofence.CREATOR.createFromParcel(r6);
        L21:
            sendDebugEvent(r10, r11, r3);
            r7.writeNoException();
            if (r3 == null) goto L24;
            r7.writeInt(1);
            r3.writeToParcel(r7, 1);
        L25:
            return true;
        L24:
            r7.writeInt(0);
            goto L25
        L17:
            r10 = null;
            goto L18
        L26:
            r6.enforceInterface(DESCRIPTOR);
            StarGeofence r12 = findGeofenceById(r6.readString());
            r7.writeNoException();
            if (r12 == null) goto L29;
            r7.writeInt(1);
            r12.writeToParcel(r7, 1);
        L30:
            return true;
        L29:
            r7.writeInt(0);
            goto L30
        L31:
            r6.enforceInterface(DESCRIPTOR);
            List<StarGeofence> r13 = listGeofences(r6.readString());
            r7.writeNoException();
            r7.writeTypedList(r13);
            return true;
        L33:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L36;
            r3 = (StarGeofence) StarGeofence.CREATOR.createFromParcel(r6);
        L36:
            byte r14 = updateGeofence(r3);
            r7.writeNoException();
            r7.writeByte(r14);
            if (r3 == null) goto L39;
            r7.writeInt(1);
            r3.writeToParcel(r7, 1);
        L40:
            return true;
        L39:
            r7.writeInt(0);
            goto L40
        L41:
            r6.enforceInterface(DESCRIPTOR);
            byte r15 = deleteGeofenceById(r6.readString(), r6.readString());
            r7.writeNoException();
            r7.writeByte(r15);
            return true;
        L43:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L46;
            r3 = (StarGeofence) StarGeofence.CREATOR.createFromParcel(r6);
        L46:
            byte r16 = deleteGeofence(r3);
            r7.writeNoException();
            r7.writeByte(r16);
            return true;
        L48:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L51;
            r3 = (StarGeofence) StarGeofence.CREATOR.createFromParcel(r6);
        L51:
            byte r17 = addGeofence(r3);
            r7.writeNoException();
            r7.writeByte(r17);
            return true;
        L53:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L56;
            r3 = (ComponentName) ComponentName.CREATOR.createFromParcel(r6);
        L56:
            byte r18 = unregisterComponent(r3);
            r7.writeNoException();
            r7.writeByte(r18);
            return true;
        L58:
            r6.enforceInterface(DESCRIPTOR);
            ComponentName r19 = getComponent(r6.readString());
            r7.writeNoException();
            if (r19 == null) goto L61;
            r7.writeInt(1);
            r19.writeToParcel(r7, 1);
        L62:
            return true;
        L61:
            r7.writeInt(0);
            goto L62
        L63:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L66;
            r3 = (ComponentName) ComponentName.CREATOR.createFromParcel(r6);
        L66:
            byte r20 = registerComponent(r3);
            r7.writeNoException();
            r7.writeByte(r20);
            return true;
        L68:
            r6.enforceInterface(DESCRIPTOR);
            String r21 = getVendorVersion();
            r7.writeNoException();
            r7.writeString(r21);
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L70:
            r7.writeString(DESCRIPTOR);
            return true;
        }
    }

    byte addGeofence(StarGeofence r1) throws RemoteException;

    byte deleteGeofence(StarGeofence r1) throws RemoteException;

    byte deleteGeofenceById(String r1, String r2) throws RemoteException;

    StarGeofence findGeofenceById(String r1) throws RemoteException;

    ComponentName getComponent(String r1) throws RemoteException;

    String getVendorVersion() throws RemoteException;

    boolean isStarGeofencesRecovered() throws RemoteException;

    List<StarGeofence> listGeofences(String r1) throws RemoteException;

    byte registerComponent(ComponentName r1) throws RemoteException;

    void registerGeofenceCallback(String r1, IStarGeofenceCallback r2) throws RemoteException;

    void sendDebugEvent(Location r1, int r2, StarGeofence r3) throws RemoteException;

    byte unregisterComponent(ComponentName r1) throws RemoteException;

    void unregisterGeofenceCallback(String r1, IStarGeofenceCallback r2) throws RemoteException;

    byte updateGeofence(StarGeofence r1) throws RemoteException;
}
