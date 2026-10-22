package com.obric.cae.libs.location;

import android.location.Address;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.cae.libs.location.geofence.IStarGeofenceManager;
import com.obric.cae.libs.location.poi.IStarAoiBoardManager;
import com.obric.cae.libs.location.poi.IStarPoiManager;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
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
        public String getCommSenseAARVersion() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Address getCurCityInfo() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLastKnownLocationFromZpp(int r8, String r10) {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLocationFromBdGeo() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLocationFromZpp() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public IStarAoiBoardManager getStarAoiBoardManager() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public IStarGeofenceManager getStarGeofenceManager() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public IStarPoiManager getStarPoiManager() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public String getStarVersion() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void registerCityCallback(int r8, IStarLocationCityCallback r10) {
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void runIndoorCheck(long r8) {
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Bundle searchDirectionFromBmap(double r8, double r10, double r11, double r12, byte r13, byte r14, Map r15, int r16) {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Bundle searchDirectionFromBmapByAddress(double r8, double r10, String r11, byte r12, byte r13, Map r14, int r15) {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public String searchPoiTextFromBd(String r8, int r10, int r11, String r12, String r13) {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void unregisterCityCallback() {
        }
    }

    public static abstract class Stub extends Binder implements IStarLocationService {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.IStarLocationService";
        static final int TRANSACTION_getCommSenseAARVersion = 14;
        static final int TRANSACTION_getCurCityInfo = 12;
        static final int TRANSACTION_getLastKnownLocationFromZpp = 13;
        static final int TRANSACTION_getLocationFromBdGeo = 4;
        static final int TRANSACTION_getLocationFromZpp = 3;
        static final int TRANSACTION_getStarAoiBoardManager = 11;
        static final int TRANSACTION_getStarGeofenceManager = 2;
        static final int TRANSACTION_getStarPoiManager = 15;
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

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String getCommSenseAARVersion() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(14, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                String r11 = r10.readString();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getCommSenseAARVersion();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Address getCurCityInfo() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                if (this.mRemote.transact(12, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L15
                if (r10.readInt() == 0) goto L14;
                Address r11 = (Address) Address.CREATOR.createFromParcel(r10);     // Catch: Throwable -> L15
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L14:
                r11 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getCurCityInfo();     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLastKnownLocationFromZpp(int r8, String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r11.writeInt(r8);     // Catch: Throwable -> L15
                r11.writeString(r10);     // Catch: Throwable -> L15
                if (this.mRemote.transact(13, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L15
                if (r12.readInt() == 0) goto L14;
                Location r13 = (Location) Location.CREATOR.createFromParcel(r12);     // Catch: Throwable -> L15
            L8:
                r12.recycle();
                r11.recycle();
                return r13;
            L14:
                r13 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r13 = Stub.getDefaultImpl().getLastKnownLocationFromZpp(r8, r10);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLocationFromBdGeo() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                if (this.mRemote.transact(4, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L15
                if (r10.readInt() == 0) goto L14;
                Location r11 = (Location) Location.CREATOR.createFromParcel(r10);     // Catch: Throwable -> L15
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L14:
                r11 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getLocationFromBdGeo();     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLocationFromZpp() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                if (this.mRemote.transact(3, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L15
                if (r10.readInt() == 0) goto L14;
                Location r11 = (Location) Location.CREATOR.createFromParcel(r10);     // Catch: Throwable -> L15
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L14:
                r11 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getLocationFromZpp();     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public IStarAoiBoardManager getStarAoiBoardManager() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(11, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                IStarAoiBoardManager r11 = IStarAoiBoardManager.Stub.asInterface(r10.readStrongBinder());     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getStarAoiBoardManager();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public IStarGeofenceManager getStarGeofenceManager() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                IStarGeofenceManager r11 = IStarGeofenceManager.Stub.asInterface(r10.readStrongBinder());     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getStarGeofenceManager();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public IStarPoiManager getStarPoiManager() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(15, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                IStarPoiManager r11 = IStarPoiManager.Stub.asInterface(r10.readStrongBinder());     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getStarPoiManager();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String getStarVersion() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                String r11 = r10.readString();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getStarVersion();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void registerCityCallback(int r8, IStarLocationCityCallback r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r11.writeInt(r8);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L16
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L16
                if (this.mRemote.transact(7, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L16
            L12:
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCityCallback(r8, r10);     // Catch: Throwable -> L16
                goto L12
            L6:
                r13 = null;
            L16:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void runIndoorCheck(long r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeLong(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().runIndoorCheck(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Bundle searchDirectionFromBmap(double r17, double r19, double r21, double r23, byte r25, byte r26, Map r27, int r28) {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r8.writeDouble(r17);     // Catch: Throwable -> L15
                r8.writeDouble(r19);     // Catch: Throwable -> L15
                r8.writeDouble(r21);     // Catch: Throwable -> L15
                r8.writeDouble(r23);     // Catch: Throwable -> L15
                r8.writeByte(r25);     // Catch: Throwable -> L15
                r8.writeByte(r26);     // Catch: Throwable -> L15
                r8.writeMap(r27);     // Catch: Throwable -> L15
                r8.writeInt(r28);     // Catch: Throwable -> L15
                if (this.mRemote.transact(9, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L15
                if (r10.readInt() == 0) goto L14;
                Bundle r11 = (Bundle) Bundle.CREATOR.createFromParcel(r10);     // Catch: Throwable -> L15
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L14:
                r11 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().searchDirectionFromBmap(r17, r19, r21, r23, r25, r26, r27, r28);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Bundle searchDirectionFromBmapByAddress(double r15, double r17, String r19, byte r20, byte r21, Map r22, int r23) {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r8.writeDouble(r15);     // Catch: Throwable -> L15
                r8.writeDouble(r17);     // Catch: Throwable -> L15
                r8.writeString(r19);     // Catch: Throwable -> L15
                r8.writeByte(r20);     // Catch: Throwable -> L15
                r8.writeByte(r21);     // Catch: Throwable -> L15
                r8.writeMap(r22);     // Catch: Throwable -> L15
                r8.writeInt(r23);     // Catch: Throwable -> L15
                if (this.mRemote.transact(10, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L15
                if (r10.readInt() == 0) goto L14;
                Bundle r11 = (Bundle) Bundle.CREATOR.createFromParcel(r10);     // Catch: Throwable -> L15
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L14:
                r11 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().searchDirectionFromBmapByAddress(r15, r17, r19, r20, r21, r22, r23);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String searchPoiTextFromBd(String r10, int r11, int r12, String r13, String r14) {
                Parcel r8 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r8.writeString(r10);     // Catch: Throwable -> L12
                r8.writeInt(r11);     // Catch: Throwable -> L12
                r8.writeInt(r12);     // Catch: Throwable -> L12
                r8.writeString(r13);     // Catch: Throwable -> L12
                r8.writeString(r14);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r8, r15, 0) == false) goto L6;
            L10:
                r15.readException();     // Catch: Throwable -> L12
                String r16 = r15.readString();     // Catch: Throwable -> L12
            L8:
                r15.recycle();
                r8.recycle();
                return r16;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r16 = Stub.getDefaultImpl().searchPoiTextFromBd(r10, r11, r12, r13, r14);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r15.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void unregisterCityCallback() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(8, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterCityCallback();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarLocationService asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IStarLocationService) == false) goto L12;
            return (IStarLocationService) r10;
        L12:
            return new Proxy(r8);
        }

        public static IStarLocationService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IStarLocationService r8) {
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
        public boolean onTransact(int r19, Parcel r20, Parcel r21, int r22) {
            if (r19 == 1598968902) goto L65;
            IBinder r8 = null;
            switch(r19) {
                case 1: goto L63;
                case 2: goto L58;
                case 3: goto L53;
                case 4: goto L48;
                case 5: goto L46;
                case 6: goto L44;
                case 7: goto L42;
                case 8: goto L40;
                case 9: goto L35;
                case 10: goto L30;
                case 11: goto L25;
                case 12: goto L20;
                case 13: goto L15;
                case 14: goto L13;
                case 15: goto L8;
                default: goto L7;
            };
        L8:
            r20.enforceInterface(DESCRIPTOR);
            IStarPoiManager r10 = getStarPoiManager();
            r21.writeNoException();
            if (r10 == null) goto L11;
            r8 = r10.asBinder();
        L11:
            r21.writeStrongBinder(r8);
            return true;
        L13:
            r20.enforceInterface(DESCRIPTOR);
            String r11 = getCommSenseAARVersion();
            r21.writeNoException();
            r21.writeString(r11);
            return true;
        L15:
            r20.enforceInterface(DESCRIPTOR);
            Location r12 = getLastKnownLocationFromZpp(r20.readInt(), r20.readString());
            r21.writeNoException();
            if (r12 == null) goto L18;
            r21.writeInt(1);
            r12.writeToParcel(r21, 1);
        L19:
            return true;
        L18:
            r21.writeInt(0);
            goto L19
        L20:
            r20.enforceInterface(DESCRIPTOR);
            Address r13 = getCurCityInfo();
            r21.writeNoException();
            if (r13 == null) goto L23;
            r21.writeInt(1);
            r13.writeToParcel(r21, 1);
        L24:
            return true;
        L23:
            r21.writeInt(0);
            goto L24
        L25:
            r20.enforceInterface(DESCRIPTOR);
            IStarAoiBoardManager r14 = getStarAoiBoardManager();
            r21.writeNoException();
            if (r14 == null) goto L28;
            r8 = r14.asBinder();
        L28:
            r21.writeStrongBinder(r8);
            return true;
        L30:
            r20.enforceInterface(DESCRIPTOR);
            Bundle r15 = searchDirectionFromBmapByAddress(r20.readDouble(), r20.readDouble(), r20.readString(), r20.readByte(), r20.readByte(), r20.readHashMap(getClass().getClassLoader()), r20.readInt());
            r21.writeNoException();
            if (r15 == null) goto L33;
            r21.writeInt(1);
            r15.writeToParcel(r21, 1);
        L34:
            return true;
        L33:
            r21.writeInt(0);
            goto L34
        L35:
            r20.enforceInterface(DESCRIPTOR);
            Bundle r16 = searchDirectionFromBmap(r20.readDouble(), r20.readDouble(), r20.readDouble(), r20.readDouble(), r20.readByte(), r20.readByte(), r20.readHashMap(getClass().getClassLoader()), r20.readInt());
            r21.writeNoException();
            if (r16 == null) goto L38;
            r21.writeInt(1);
            r16.writeToParcel(r21, 1);
        L39:
            return true;
        L38:
            r21.writeInt(0);
            goto L39
        L40:
            r20.enforceInterface(DESCRIPTOR);
            unregisterCityCallback();
            r21.writeNoException();
            return true;
        L42:
            r20.enforceInterface(DESCRIPTOR);
            registerCityCallback(r20.readInt(), IStarLocationCityCallback.Stub.asInterface(r20.readStrongBinder()));
            r21.writeNoException();
            return true;
        L44:
            r20.enforceInterface(DESCRIPTOR);
            runIndoorCheck(r20.readLong());
            r21.writeNoException();
            return true;
        L46:
            r20.enforceInterface(DESCRIPTOR);
            String r17 = searchPoiTextFromBd(r20.readString(), r20.readInt(), r20.readInt(), r20.readString(), r20.readString());
            r21.writeNoException();
            r21.writeString(r17);
            return true;
        L48:
            r20.enforceInterface(DESCRIPTOR);
            Location r18 = getLocationFromBdGeo();
            r21.writeNoException();
            if (r18 == null) goto L51;
            r21.writeInt(1);
            r18.writeToParcel(r21, 1);
        L52:
            return true;
        L51:
            r21.writeInt(0);
            goto L52
        L53:
            r20.enforceInterface(DESCRIPTOR);
            Location r23 = getLocationFromZpp();
            r21.writeNoException();
            if (r23 == null) goto L56;
            r21.writeInt(1);
            r23.writeToParcel(r21, 1);
        L57:
            return true;
        L56:
            r21.writeInt(0);
            goto L57
        L58:
            r20.enforceInterface(DESCRIPTOR);
            IStarGeofenceManager r24 = getStarGeofenceManager();
            r21.writeNoException();
            if (r24 == null) goto L61;
            r8 = r24.asBinder();
        L61:
            r21.writeStrongBinder(r8);
            return true;
        L63:
            r20.enforceInterface(DESCRIPTOR);
            String r25 = getStarVersion();
            r21.writeNoException();
            r21.writeString(r25);
            return true;
        L7:
            return super.onTransact(r19, r20, r21, r22);
        L65:
            r21.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getCommSenseAARVersion();

    Address getCurCityInfo();

    Location getLastKnownLocationFromZpp(int r8, String r10);

    Location getLocationFromBdGeo();

    Location getLocationFromZpp();

    IStarAoiBoardManager getStarAoiBoardManager();

    IStarGeofenceManager getStarGeofenceManager();

    IStarPoiManager getStarPoiManager();

    String getStarVersion();

    void registerCityCallback(int r8, IStarLocationCityCallback r10);

    void runIndoorCheck(long r8);

    Bundle searchDirectionFromBmap(double r8, double r10, double r11, double r12, byte r13, byte r14, Map r15, int r16);

    Bundle searchDirectionFromBmapByAddress(double r8, double r10, String r11, byte r12, byte r13, Map r14, int r15);

    String searchPoiTextFromBd(String r8, int r10, int r11, String r12, String r13);

    void unregisterCityCallback();
}
