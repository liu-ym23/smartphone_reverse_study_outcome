package com.obric.cae.libs.location;

import android.location.Address;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.cae.libs.location.geofence.IStarGeofenceManager;
import com.obric.cae.libs.location.poi.IStarAoiBoardManager;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface IStarLocationService extends IInterface {
    public static final int CITY_LISTEN_LEVEL1 = 1;
    public static final int CITY_LISTEN_LEVEL2 = 2;
    public static final int CITY_LISTEN_LEVEL3 = 3;
    public static final int CITY_LISTEN_LEVEL4 = 4;
    public static final int DIRECTION_TYPE_DRIVING = 2;
    public static final int DIRECTION_TYPE_RIDING = 4;
    public static final int DIRECTION_TYPE_TRANSIT = 1;
    public static final int DIRECTION_TYPE_WALKING = 3;

    public static class Default implements IStarLocationService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Address getCurCityInfo() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLocationFromBdGeo() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLocationFromZpp() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public IStarAoiBoardManager getStarAoiBoardManager() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public IStarGeofenceManager getStarGeofenceManager() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public String getStarVersion() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void registerCityCallback(int r1, IStarLocationCityCallback r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void runIndoorCheck(long r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Bundle searchDirectionFromBmap(double r1, double r3, double r5, double r7, byte r9, byte r10, Map r11, int r12) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Bundle searchDirectionFromBmapByAddress(double r1, double r3, String r5, byte r6, byte r7, Map r8, int r9) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public String searchPoiTextFromBd(String r1, int r2, int r3, String r4, String r5) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void unregisterCityCallback() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarLocationService {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.IStarLocationService";
        static final int TRANSACTION_getCurCityInfo = 12;
        static final int TRANSACTION_getLocationFromBdGeo = 4;
        static final int TRANSACTION_getLocationFromZpp = 3;
        static final int TRANSACTION_getStarAoiBoardManager = 11;
        static final int TRANSACTION_getStarGeofenceManager = 2;
        static final int TRANSACTION_getStarVersion = 1;
        static final int TRANSACTION_registerCityCallback = 7;
        static final int TRANSACTION_runIndoorCheck = 6;
        static final int TRANSACTION_searchDirectionFromBmap = 9;
        static final int TRANSACTION_searchDirectionFromBmapByAddress = 10;
        static final int TRANSACTION_searchPoiTextFromBd = 5;
        static final int TRANSACTION_unregisterCityCallback = 8;

        public static class Proxy implements IStarLocationService {
            public static IStarLocationService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Address getCurCityInfo() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Address r2 = (Address) Address.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r2;
            L14:
                r2 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Address r3 = Stub.getDefaultImpl().getCurCityInfo();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r3;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLocationFromBdGeo() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Location r2 = (Location) Location.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r2;
            L14:
                r2 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Location r3 = Stub.getDefaultImpl().getLocationFromBdGeo();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r3;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLocationFromZpp() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Location r2 = (Location) Location.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r2;
            L14:
                r2 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Location r3 = Stub.getDefaultImpl().getLocationFromZpp();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r3;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public IStarAoiBoardManager getStarAoiBoardManager() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IStarAoiBoardManager r2 = IStarAoiBoardManager.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IStarAoiBoardManager r3 = Stub.getDefaultImpl().getStarAoiBoardManager();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public IStarGeofenceManager getStarGeofenceManager() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IStarGeofenceManager r2 = IStarGeofenceManager.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IStarGeofenceManager r3 = Stub.getDefaultImpl().getStarGeofenceManager();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String getStarVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r2 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r3 = Stub.getDefaultImpl().getStarVersion();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void unregisterCityCallback() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterCityCallback();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
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

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void runIndoorCheck(long r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeLong(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().runIndoorCheck(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void registerCityCallback(int r6, IStarLocationCityCallback r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCityCallback(r6, r7);     // Catch: Throwable -> L17
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

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String searchPoiTextFromBd(String r10, int r11, int r12, String r13, String r14) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r10);     // Catch: Throwable -> L13
                r0.writeInt(r11);     // Catch: Throwable -> L13
                r0.writeInt(r12);     // Catch: Throwable -> L13
                r0.writeString(r13);     // Catch: Throwable -> L13
                r0.writeString(r14);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r15 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r15;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r16 = Stub.getDefaultImpl().searchPoiTextFromBd(r10, r11, r12, r13, r14);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r16;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Bundle searchDirectionFromBmapByAddress(double r16, double r18, String r20, byte r21, byte r22, Map r23, int r24) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r1.writeDouble(r16);     // Catch: Throwable -> L21
                r1.writeDouble(r18);     // Catch: Throwable -> L21
                r1.writeString(r20);     // Catch: Throwable -> L21
                r1.writeByte(r21);     // Catch: Throwable -> L21
                r1.writeByte(r22);     // Catch: Throwable -> L21
                r1.writeMap(r23);     // Catch: Throwable -> L21
                r1.writeInt(r24);     // Catch: Throwable -> L21
            L19:
                th = th;
            L23:
                r2.recycle();
                r1.recycle();
                throw th;
            L6:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r1, r2, 0) == false) goto L8;
            L12:
                r2.readException();     // Catch: Throwable -> L19
                if (r2.readInt() == 0) goto L16;
                Bundle r0 = (Bundle) Bundle.CREATOR.createFromParcel(r2);     // Catch: Throwable -> L19
            L17:
                r2.recycle();
                r1.recycle();
                return r0;
            L16:
                r0 = null;
                goto L17
            L8:
                if (Stub.getDefaultImpl() == null) goto L12;
                Bundle r3 = Stub.getDefaultImpl().searchDirectionFromBmapByAddress(r16, r18, r20, r21, r22, r23, r24);     // Catch: Throwable -> L19
                r2.recycle();
                r1.recycle();
                return r3;
            L21:
                th = th;
                goto L23
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Bundle searchDirectionFromBmap(double r17, double r19, double r21, double r23, byte r25, byte r26, Map r27, int r28) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r1.writeDouble(r17);     // Catch: Throwable -> L17
                r1.writeDouble(r19);     // Catch: Throwable -> L17
                r1.writeDouble(r21);     // Catch: Throwable -> L17
                r1.writeDouble(r23);     // Catch: Throwable -> L17
                r1.writeByte(r25);     // Catch: Throwable -> L17
                r1.writeByte(r26);     // Catch: Throwable -> L17
                r1.writeMap(r27);     // Catch: Throwable -> L17
                r1.writeInt(r28);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r1, r2, 0) == false) goto L6;
            L10:
                r2.readException();     // Catch: Throwable -> L17
                if (r2.readInt() == 0) goto L14;
                Bundle r0 = (Bundle) Bundle.CREATOR.createFromParcel(r2);     // Catch: Throwable -> L17
            L15:
                r2.recycle();
                r1.recycle();
                return r0;
            L14:
                r0 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Bundle r3 = Stub.getDefaultImpl().searchDirectionFromBmap(r17, r19, r21, r23, r25, r26, r27, r28);     // Catch: Throwable -> L17
                r2.recycle();
                r1.recycle();
                return r3;
            L17:
                th = move-exception;
                r2.recycle();
                r1.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarLocationService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IStarLocationService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarLocationService) == false) goto L12;
            return (IStarLocationService) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IStarLocationService r1) {
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
        public boolean onTransact(int r19, Parcel r20, Parcel r21, int r22) throws RemoteException {
            if (r19 == 1598968902) goto L53;
            IBinder r2 = null;
            switch(r19) {
                case 1: goto L51;
                case 2: goto L46;
                case 3: goto L41;
                case 4: goto L36;
                case 5: goto L34;
                case 6: goto L32;
                case 7: goto L30;
                case 8: goto L28;
                case 9: goto L23;
                case 10: goto L18;
                case 11: goto L13;
                case 12: goto L8;
                default: goto L7;
            };
        L8:
            r20.enforceInterface(DESCRIPTOR);
            Address r0 = getCurCityInfo();
            r21.writeNoException();
            if (r0 == null) goto L11;
            r21.writeInt(1);
            r0.writeToParcel(r21, 1);
        L12:
            return true;
        L11:
            r21.writeInt(0);
            goto L12
        L13:
            r20.enforceInterface(DESCRIPTOR);
            IStarAoiBoardManager r1 = getStarAoiBoardManager();
            r21.writeNoException();
            if (r1 == null) goto L16;
            r2 = r1.asBinder();
        L16:
            r21.writeStrongBinder(r2);
            return true;
        L18:
            r20.enforceInterface(DESCRIPTOR);
            Bundle r3 = searchDirectionFromBmapByAddress(r20.readDouble(), r20.readDouble(), r20.readString(), r20.readByte(), r20.readByte(), r20.readHashMap(getClass().getClassLoader()), r20.readInt());
            r21.writeNoException();
            if (r3 == null) goto L21;
            r21.writeInt(1);
            r3.writeToParcel(r21, 1);
        L22:
            return true;
        L21:
            r21.writeInt(0);
            goto L22
        L23:
            r20.enforceInterface(DESCRIPTOR);
            Bundle r4 = searchDirectionFromBmap(r20.readDouble(), r20.readDouble(), r20.readDouble(), r20.readDouble(), r20.readByte(), r20.readByte(), r20.readHashMap(getClass().getClassLoader()), r20.readInt());
            r21.writeNoException();
            if (r4 == null) goto L26;
            r21.writeInt(1);
            r4.writeToParcel(r21, 1);
        L27:
            return true;
        L26:
            r21.writeInt(0);
            goto L27
        L28:
            r20.enforceInterface(DESCRIPTOR);
            unregisterCityCallback();
            r21.writeNoException();
            return true;
        L30:
            r20.enforceInterface(DESCRIPTOR);
            registerCityCallback(r20.readInt(), IStarLocationCityCallback.Stub.asInterface(r20.readStrongBinder()));
            r21.writeNoException();
            return true;
        L32:
            r20.enforceInterface(DESCRIPTOR);
            runIndoorCheck(r20.readLong());
            r21.writeNoException();
            return true;
        L34:
            r20.enforceInterface(DESCRIPTOR);
            String r5 = searchPoiTextFromBd(r20.readString(), r20.readInt(), r20.readInt(), r20.readString(), r20.readString());
            r21.writeNoException();
            r21.writeString(r5);
            return true;
        L36:
            r20.enforceInterface(DESCRIPTOR);
            Location r6 = getLocationFromBdGeo();
            r21.writeNoException();
            if (r6 == null) goto L39;
            r21.writeInt(1);
            r6.writeToParcel(r21, 1);
        L40:
            return true;
        L39:
            r21.writeInt(0);
            goto L40
        L41:
            r20.enforceInterface(DESCRIPTOR);
            Location r7 = getLocationFromZpp();
            r21.writeNoException();
            if (r7 == null) goto L44;
            r21.writeInt(1);
            r7.writeToParcel(r21, 1);
        L45:
            return true;
        L44:
            r21.writeInt(0);
            goto L45
        L46:
            r20.enforceInterface(DESCRIPTOR);
            IStarGeofenceManager r8 = getStarGeofenceManager();
            r21.writeNoException();
            if (r8 == null) goto L49;
            r2 = r8.asBinder();
        L49:
            r21.writeStrongBinder(r2);
            return true;
        L51:
            r20.enforceInterface(DESCRIPTOR);
            String r9 = getStarVersion();
            r21.writeNoException();
            r21.writeString(r9);
            return true;
        L7:
            return super.onTransact(r19, r20, r21, r22);
        L53:
            r21.writeString(DESCRIPTOR);
            return true;
        }
    }

    Address getCurCityInfo() throws RemoteException;

    Location getLocationFromBdGeo() throws RemoteException;

    Location getLocationFromZpp() throws RemoteException;

    IStarAoiBoardManager getStarAoiBoardManager() throws RemoteException;

    IStarGeofenceManager getStarGeofenceManager() throws RemoteException;

    String getStarVersion() throws RemoteException;

    void registerCityCallback(int r1, IStarLocationCityCallback r2) throws RemoteException;

    void runIndoorCheck(long r1) throws RemoteException;

    Bundle searchDirectionFromBmap(double r1, double r3, double r5, double r7, byte r9, byte r10, Map r11, int r12) throws RemoteException;

    Bundle searchDirectionFromBmapByAddress(double r1, double r3, String r5, byte r6, byte r7, Map r8, int r9) throws RemoteException;

    String searchPoiTextFromBd(String r1, int r2, int r3, String r4, String r5) throws RemoteException;

    void unregisterCityCallback() throws RemoteException;
}
