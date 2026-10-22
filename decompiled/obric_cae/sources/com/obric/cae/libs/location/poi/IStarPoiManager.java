package com.obric.cae.libs.location.poi;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IStarPoiManager extends IInterface {

    public static class Default implements IStarPoiManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public Bundle getLastNearPoiExtras() {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public Bundle getPoiDetectInfo() {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public int getPoiDetectState() {
            return 0;
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void registerNearPoiCallback(IStarPoiCallback r8) {
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void setDebugBypassNearPoiCheck(boolean r8) {
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void setPoiDetectStateDebug(int r8) {
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void setStationaryDelaySeconds(int r8) {
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void triggerNearPoiLocation() {
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void unregisterNearPoiCallback() {
        }
    }

    public static abstract class Stub extends Binder implements IStarPoiManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.poi.IStarPoiManager";
        static final int TRANSACTION_getLastNearPoiExtras = 3;
        static final int TRANSACTION_getPoiDetectInfo = 5;
        static final int TRANSACTION_getPoiDetectState = 4;
        static final int TRANSACTION_registerNearPoiCallback = 1;
        static final int TRANSACTION_setDebugBypassNearPoiCheck = 8;
        static final int TRANSACTION_setPoiDetectStateDebug = 6;
        static final int TRANSACTION_setStationaryDelaySeconds = 9;
        static final int TRANSACTION_triggerNearPoiLocation = 7;
        static final int TRANSACTION_unregisterNearPoiCallback = 2;

        public static class Proxy implements IStarPoiManager {
            public static IStarPoiManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public Bundle getLastNearPoiExtras() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                if (this.mRemote.transact(3, r8, r10, 0) == false) goto L6;
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
                r11 = Stub.getDefaultImpl().getLastNearPoiExtras();     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public Bundle getPoiDetectInfo() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                if (this.mRemote.transact(5, r8, r10, 0) == false) goto L6;
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
                r11 = Stub.getDefaultImpl().getPoiDetectInfo();     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public int getPoiDetectState() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                int r11 = r10.readInt();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getPoiDetectState();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public void registerNearPoiCallback(IStarPoiCallback r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r11 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r11);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r10, null, 1) == false) goto L10;
            L14:
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerNearPoiCallback(r8);     // Catch: Throwable -> L16
                r10.recycle();
                return;
            L6:
                r11 = null;
            L16:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public void setDebugBypassNearPoiCheck(boolean r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(8, r10, null, 1) == false) goto L6;
            L10:
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setDebugBypassNearPoiCheck(r8);     // Catch: Throwable -> L12
                r10.recycle();
                return;
            L12:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public void setPoiDetectStateDebug(int r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r10, null, 1) == false) goto L6;
            L10:
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setPoiDetectStateDebug(r8);     // Catch: Throwable -> L12
                r10.recycle();
                return;
            L12:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public void setStationaryDelaySeconds(int r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(9, r10, null, 1) == false) goto L6;
            L10:
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setStationaryDelaySeconds(r8);     // Catch: Throwable -> L12
                r10.recycle();
                return;
            L12:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public void triggerNearPoiLocation() {
                Parcel r8 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r8, null, 1) == false) goto L6;
            L10:
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().triggerNearPoiLocation();     // Catch: Throwable -> L12
                r8.recycle();
                return;
            L12:
                th = move-exception;
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public void unregisterNearPoiCallback() {
                Parcel r8 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r8, null, 1) == false) goto L6;
            L10:
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterNearPoiCallback();     // Catch: Throwable -> L12
                r8.recycle();
                return;
            L12:
                th = move-exception;
                r8.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarPoiManager asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IStarPoiManager) == false) goto L12;
            return (IStarPoiManager) r10;
        L12:
            return new Proxy(r8);
        }

        public static IStarPoiManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IStarPoiManager r8) {
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
            if (r8 == 1598968902) goto L35;
            boolean r13 = false;
            switch(r8) {
                case 1: goto L33;
                case 2: goto L31;
                case 3: goto L26;
                case 4: goto L24;
                case 5: goto L19;
                case 6: goto L17;
                case 7: goto L15;
                case 8: goto L10;
                case 9: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface(DESCRIPTOR);
            setStationaryDelaySeconds(r10.readInt());
            return true;
        L10:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L13;
            r13 = true;
        L13:
            setDebugBypassNearPoiCheck(r13);
            return true;
        L15:
            r10.enforceInterface(DESCRIPTOR);
            triggerNearPoiLocation();
            return true;
        L17:
            r10.enforceInterface(DESCRIPTOR);
            setPoiDetectStateDebug(r10.readInt());
            return true;
        L19:
            r10.enforceInterface(DESCRIPTOR);
            Bundle r14 = getPoiDetectInfo();
            r11.writeNoException();
            if (r14 == null) goto L22;
            r11.writeInt(1);
            r14.writeToParcel(r11, 1);
        L23:
            return true;
        L22:
            r11.writeInt(0);
            goto L23
        L24:
            r10.enforceInterface(DESCRIPTOR);
            int r15 = getPoiDetectState();
            r11.writeNoException();
            r11.writeInt(r15);
            return true;
        L26:
            r10.enforceInterface(DESCRIPTOR);
            Bundle r16 = getLastNearPoiExtras();
            r11.writeNoException();
            if (r16 == null) goto L29;
            r11.writeInt(1);
            r16.writeToParcel(r11, 1);
        L30:
            return true;
        L29:
            r11.writeInt(0);
            goto L30
        L31:
            r10.enforceInterface(DESCRIPTOR);
            unregisterNearPoiCallback();
            return true;
        L33:
            r10.enforceInterface(DESCRIPTOR);
            registerNearPoiCallback(IStarPoiCallback.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        L35:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    Bundle getLastNearPoiExtras();

    Bundle getPoiDetectInfo();

    int getPoiDetectState();

    void registerNearPoiCallback(IStarPoiCallback r8);

    void setDebugBypassNearPoiCheck(boolean r8);

    void setPoiDetectStateDebug(int r8);

    void setStationaryDelaySeconds(int r8);

    void triggerNearPoiLocation();

    void unregisterNearPoiCallback();
}
