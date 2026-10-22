package com.obric.cae.libs.location.geofence;

import android.content.ComponentName;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IStarGeofenceManager extends IInterface {

    public static class Default implements IStarGeofenceManager {
        public Default() {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte addGeofence(StarGeofence r8) {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte deleteGeofence(StarGeofence r8) {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte deleteGeofenceById(String r8, String r10) {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public StarGeofence findGeofenceById(String r8) {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public StarGeofence findGeofenceByPoiId(String r8) {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public ComponentName getComponent(String r8) {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public String getVendorVersion() {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public boolean isStarGeofencesRecovered() {
            return false;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public List<StarGeofence> listGeofences(String r8) {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte registerComponent(ComponentName r8) {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void registerGeofenceCallback(String r8, IStarGeofenceCallback r10) {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void sendDebugEvent(Location r8, int r10, StarGeofence r11) {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte unregisterComponent(ComponentName r8) {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void unregisterGeofenceCallback(String r8, IStarGeofenceCallback r10) {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte updateGeofence(StarGeofence r8) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IStarGeofenceManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.geofence.IStarGeofenceManager";
        static final int TRANSACTION_addGeofence = 5;
        static final int TRANSACTION_deleteGeofence = 6;
        static final int TRANSACTION_deleteGeofenceById = 7;
        static final int TRANSACTION_findGeofenceById = 10;
        static final int TRANSACTION_findGeofenceByPoiId = 15;
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

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte addGeofence(StarGeofence r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(5, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
                byte r12 = r11.readByte();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return r12;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r12 = Stub.getDefaultImpl().addGeofence(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte deleteGeofence(StarGeofence r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(6, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
                byte r12 = r11.readByte();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return r12;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r12 = Stub.getDefaultImpl().deleteGeofence(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte deleteGeofenceById(String r8, String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeString(r8);     // Catch: Throwable -> L12
                r11.writeString(r10);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L12
                byte r13 = r12.readByte();     // Catch: Throwable -> L12
            L8:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r13 = Stub.getDefaultImpl().deleteGeofenceById(r8, r10);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public StarGeofence findGeofenceById(String r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r10.writeString(r8);     // Catch: Throwable -> L15
                if (this.mRemote.transact(10, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L14;
                StarGeofence r12 = StarGeofence.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L15
            L8:
                r11.recycle();
                r10.recycle();
                return r12;
            L14:
                r12 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r12 = Stub.getDefaultImpl().findGeofenceById(r8);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public StarGeofence findGeofenceByPoiId(String r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r10.writeString(r8);     // Catch: Throwable -> L15
                if (this.mRemote.transact(15, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L14;
                StarGeofence r12 = StarGeofence.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L15
            L8:
                r11.recycle();
                r10.recycle();
                return r12;
            L14:
                r12 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r12 = Stub.getDefaultImpl().findGeofenceByPoiId(r8);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public ComponentName getComponent(String r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r10.writeString(r8);     // Catch: Throwable -> L15
                if (this.mRemote.transact(3, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L14;
                ComponentName r12 = (ComponentName) ComponentName.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L15
            L8:
                r11.recycle();
                r10.recycle();
                return r12;
            L14:
                r12 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r12 = Stub.getDefaultImpl().getComponent(r8);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public String getVendorVersion() {
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
                r11 = Stub.getDefaultImpl().getVendorVersion();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public boolean isStarGeofencesRecovered() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r11 = false;
                if (this.mRemote.transact(14, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L15
                if (r10.readInt() == 0) goto L13;
                r11 = true;
            L13:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r12 = Stub.getDefaultImpl().isStarGeofencesRecovered();     // Catch: Throwable -> L15
                r10.recycle();
                r8.recycle();
                return r12;
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public List<StarGeofence> listGeofences(String r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeString(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(9, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
                List<StarGeofence> r12 = r11.createTypedArrayList(StarGeofence.CREATOR);     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r12 = Stub.getDefaultImpl().listGeofences(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte registerComponent(ComponentName r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(2, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
                byte r12 = r11.readByte();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return r12;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r12 = Stub.getDefaultImpl().registerComponent(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void registerGeofenceCallback(String r8, IStarGeofenceCallback r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r11.writeString(r8);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L16
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L16
                if (this.mRemote.transact(12, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L16
            L12:
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerGeofenceCallback(r8, r10);     // Catch: Throwable -> L16
                goto L12
            L6:
                r13 = null;
            L16:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void sendDebugEvent(Location r8, int r10, StarGeofence r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L22
                if (r8 == null) goto L6;
                r12.writeInt(1);     // Catch: Throwable -> L22
                r8.writeToParcel(r12, 0);     // Catch: Throwable -> L22
            L7:
                r12.writeInt(r10);     // Catch: Throwable -> L22
                if (r11 == null) goto L10;
                r12.writeInt(1);     // Catch: Throwable -> L22
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L22
            L12:
                if (this.mRemote.transact(11, r12, r13, 0) == false) goto L14;
            L18:
                r13.readException();     // Catch: Throwable -> L22
                if (r13.readInt() != 0) goto L20;
            L16:
                r13.recycle();
                r12.recycle();
                return;
            L20:
                r11.readFromParcel(r13);     // Catch: Throwable -> L22
                goto L16
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().sendDebugEvent(r8, r10, r11);     // Catch: Throwable -> L22
                goto L16
            L10:
                r12.writeInt(0);     // Catch: Throwable -> L22
                goto L12
            L6:
                r12.writeInt(0);     // Catch: Throwable -> L22
            L22:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte unregisterComponent(ComponentName r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(4, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
                byte r12 = r11.readByte();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return r12;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r12 = Stub.getDefaultImpl().unregisterComponent(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void unregisterGeofenceCallback(String r8, IStarGeofenceCallback r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r11.writeString(r8);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L16
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L16
                if (this.mRemote.transact(13, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L16
            L12:
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterGeofenceCallback(r8, r10);     // Catch: Throwable -> L16
                goto L12
            L6:
                r13 = null;
            L16:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte updateGeofence(StarGeofence r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L18
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L18
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L18
            L8:
                if (this.mRemote.transact(8, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L18
                byte r12 = r11.readByte();     // Catch: Throwable -> L18
                if (r11.readInt() != 0) goto L16;
            L12:
                r11.recycle();
                r10.recycle();
                return r12;
            L16:
                r8.readFromParcel(r11);     // Catch: Throwable -> L18
                goto L12
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r12 = Stub.getDefaultImpl().updateGeofence(r8);     // Catch: Throwable -> L18
                goto L12
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L18
            L18:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarGeofenceManager asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IStarGeofenceManager) == false) goto L12;
            return (IStarGeofenceManager) r10;
        L12:
            return new Proxy(r8);
        }

        public static IStarGeofenceManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IStarGeofenceManager r8) {
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
            if (r8 == 1598968902) goto L75;
            ComponentName r13 = null;
            StarGeofence r14 = null;
            StarGeofence r15 = null;
            StarGeofence r16 = null;
            StarGeofence r17 = null;
            ComponentName r18 = null;
            switch(r8) {
                case 1: goto L73;
                case 2: goto L68;
                case 3: goto L63;
                case 4: goto L58;
                case 5: goto L53;
                case 6: goto L48;
                case 7: goto L46;
                case 8: goto L38;
                case 9: goto L36;
                case 10: goto L31;
                case 11: goto L19;
                case 12: goto L17;
                case 13: goto L15;
                case 14: goto L13;
                case 15: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface(DESCRIPTOR);
            StarGeofence r19 = findGeofenceByPoiId(r10.readString());
            r11.writeNoException();
            if (r19 == null) goto L11;
            r11.writeInt(1);
            r19.writeToParcel(r11, 1);
        L12:
            return true;
        L11:
            r11.writeInt(0);
            goto L12
        L13:
            r10.enforceInterface(DESCRIPTOR);
            boolean r20 = isStarGeofencesRecovered();
            r11.writeNoException();
            r11.writeInt(r20 ? 1 : 0);
            return true;
        L15:
            r10.enforceInterface(DESCRIPTOR);
            unregisterGeofenceCallback(r10.readString(), IStarGeofenceCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L17:
            r10.enforceInterface(DESCRIPTOR);
            registerGeofenceCallback(r10.readString(), IStarGeofenceCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L19:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L22;
            Location r21 = (Location) Location.CREATOR.createFromParcel(r10);
        L23:
            int r22 = r10.readInt();
            if (r10.readInt() == 0) goto L26;
            r14 = StarGeofence.CREATOR.createFromParcel(r10);
        L26:
            sendDebugEvent(r21, r22, r14);
            r11.writeNoException();
            if (r14 == null) goto L29;
            r11.writeInt(1);
            r14.writeToParcel(r11, 1);
        L30:
            return true;
        L29:
            r11.writeInt(0);
            goto L30
        L22:
            r21 = null;
            goto L23
        L31:
            r10.enforceInterface(DESCRIPTOR);
            StarGeofence r23 = findGeofenceById(r10.readString());
            r11.writeNoException();
            if (r23 == null) goto L34;
            r11.writeInt(1);
            r23.writeToParcel(r11, 1);
        L35:
            return true;
        L34:
            r11.writeInt(0);
            goto L35
        L36:
            r10.enforceInterface(DESCRIPTOR);
            List<StarGeofence> r24 = listGeofences(r10.readString());
            r11.writeNoException();
            r11.writeTypedList(r24);
            return true;
        L38:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L41;
            r15 = StarGeofence.CREATOR.createFromParcel(r10);
        L41:
            byte r25 = updateGeofence(r15);
            r11.writeNoException();
            r11.writeByte(r25);
            if (r15 == null) goto L44;
            r11.writeInt(1);
            r15.writeToParcel(r11, 1);
        L45:
            return true;
        L44:
            r11.writeInt(0);
            goto L45
        L46:
            r10.enforceInterface(DESCRIPTOR);
            byte r26 = deleteGeofenceById(r10.readString(), r10.readString());
            r11.writeNoException();
            r11.writeByte(r26);
            return true;
        L48:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L51;
            r16 = StarGeofence.CREATOR.createFromParcel(r10);
        L51:
            byte r27 = deleteGeofence(r16);
            r11.writeNoException();
            r11.writeByte(r27);
            return true;
        L53:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L56;
            r17 = StarGeofence.CREATOR.createFromParcel(r10);
        L56:
            byte r28 = addGeofence(r17);
            r11.writeNoException();
            r11.writeByte(r28);
            return true;
        L58:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L61;
            r18 = (ComponentName) ComponentName.CREATOR.createFromParcel(r10);
        L61:
            byte r29 = unregisterComponent(r18);
            r11.writeNoException();
            r11.writeByte(r29);
            return true;
        L63:
            r10.enforceInterface(DESCRIPTOR);
            ComponentName r30 = getComponent(r10.readString());
            r11.writeNoException();
            if (r30 == null) goto L66;
            r11.writeInt(1);
            r30.writeToParcel(r11, 1);
        L67:
            return true;
        L66:
            r11.writeInt(0);
            goto L67
        L68:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L71;
            r13 = (ComponentName) ComponentName.CREATOR.createFromParcel(r10);
        L71:
            byte r31 = registerComponent(r13);
            r11.writeNoException();
            r11.writeByte(r31);
            return true;
        L73:
            r10.enforceInterface(DESCRIPTOR);
            String r32 = getVendorVersion();
            r11.writeNoException();
            r11.writeString(r32);
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        L75:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    byte addGeofence(StarGeofence r8);

    byte deleteGeofence(StarGeofence r8);

    byte deleteGeofenceById(String r8, String r10);

    StarGeofence findGeofenceById(String r8);

    StarGeofence findGeofenceByPoiId(String r8);

    ComponentName getComponent(String r8);

    String getVendorVersion();

    boolean isStarGeofencesRecovered();

    List<StarGeofence> listGeofences(String r8);

    byte registerComponent(ComponentName r8);

    void registerGeofenceCallback(String r8, IStarGeofenceCallback r10);

    void sendDebugEvent(Location r8, int r10, StarGeofence r11);

    byte unregisterComponent(ComponentName r8);

    void unregisterGeofenceCallback(String r8, IStarGeofenceCallback r10);

    byte updateGeofence(StarGeofence r8);
}
