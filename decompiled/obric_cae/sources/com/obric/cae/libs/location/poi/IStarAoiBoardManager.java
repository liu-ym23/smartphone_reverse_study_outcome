package com.obric.cae.libs.location.poi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IStarAoiBoardManager extends IInterface {

    public static class Default implements IStarAoiBoardManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public AoiBoard findAoiBoardByPoiId(String r8) {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public boolean isAoiBoardsRecovered() {
            return false;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public List<AoiBoard> listAllAoiBoards() {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public List<AoiBoard> listAoiBoardsByType(int r8) {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public void registerAoiBoardCallback(IStarAoiBoardCallback r8) {
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public void unregisterAoiBoardCallback() {
        }
    }

    public static abstract class Stub extends Binder implements IStarAoiBoardManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.poi.IStarAoiBoardManager";
        static final int TRANSACTION_findAoiBoardByPoiId = 5;
        static final int TRANSACTION_isAoiBoardsRecovered = 6;
        static final int TRANSACTION_listAllAoiBoards = 3;
        static final int TRANSACTION_listAoiBoardsByType = 4;
        static final int TRANSACTION_registerAoiBoardCallback = 1;
        static final int TRANSACTION_unregisterAoiBoardCallback = 2;

        public static class Proxy implements IStarAoiBoardManager {
            public static IStarAoiBoardManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public AoiBoard findAoiBoardByPoiId(String r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r10.writeString(r8);     // Catch: Throwable -> L15
                if (this.mRemote.transact(5, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L14;
                AoiBoard r12 = AoiBoard.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L15
            L8:
                r11.recycle();
                r10.recycle();
                return r12;
            L14:
                r12 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r12 = Stub.getDefaultImpl().findAoiBoardByPoiId(r8);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public boolean isAoiBoardsRecovered() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r11 = false;
                if (this.mRemote.transact(6, r8, r10, 0) == false) goto L6;
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
                boolean r12 = Stub.getDefaultImpl().isAoiBoardsRecovered();     // Catch: Throwable -> L15
                r10.recycle();
                r8.recycle();
                return r12;
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public List<AoiBoard> listAllAoiBoards() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                List<AoiBoard> r11 = r10.createTypedArrayList(AoiBoard.CREATOR);     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().listAllAoiBoards();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public List<AoiBoard> listAoiBoardsByType(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
                List<AoiBoard> r12 = r11.createTypedArrayList(AoiBoard.CREATOR);     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r12 = Stub.getDefaultImpl().listAoiBoardsByType(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public void registerAoiBoardCallback(IStarAoiBoardCallback r8) {
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
                Stub.getDefaultImpl().registerAoiBoardCallback(r8);     // Catch: Throwable -> L16
                r10.recycle();
                return;
            L6:
                r11 = null;
            L16:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public void unregisterAoiBoardCallback() {
                Parcel r8 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r8, null, 1) == false) goto L6;
            L10:
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterAoiBoardCallback();     // Catch: Throwable -> L12
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

        public static IStarAoiBoardManager asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IStarAoiBoardManager) == false) goto L12;
            return (IStarAoiBoardManager) r10;
        L12:
            return new Proxy(r8);
        }

        public static IStarAoiBoardManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IStarAoiBoardManager r8) {
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
            if (r8 == 1598968902) goto L22;
            switch(r8) {
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r10.enforceInterface(DESCRIPTOR);
            boolean r13 = isAoiBoardsRecovered();
            r11.writeNoException();
            r11.writeInt(r13 ? 1 : 0);
            return true;
        L9:
            r10.enforceInterface(DESCRIPTOR);
            AoiBoard r14 = findAoiBoardByPoiId(r10.readString());
            r11.writeNoException();
            if (r14 == null) goto L12;
            r11.writeInt(1);
            r14.writeToParcel(r11, 1);
        L13:
            return true;
        L12:
            r11.writeInt(0);
            goto L13
        L14:
            r10.enforceInterface(DESCRIPTOR);
            List<AoiBoard> r15 = listAoiBoardsByType(r10.readInt());
            r11.writeNoException();
            r11.writeTypedList(r15);
            return true;
        L16:
            r10.enforceInterface(DESCRIPTOR);
            List<AoiBoard> r16 = listAllAoiBoards();
            r11.writeNoException();
            r11.writeTypedList(r16);
            return true;
        L18:
            r10.enforceInterface(DESCRIPTOR);
            unregisterAoiBoardCallback();
            return true;
        L20:
            r10.enforceInterface(DESCRIPTOR);
            registerAoiBoardCallback(IStarAoiBoardCallback.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L6:
            return super.onTransact(r8, r10, r11, r12);
        L22:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    AoiBoard findAoiBoardByPoiId(String r8);

    boolean isAoiBoardsRecovered();

    List<AoiBoard> listAllAoiBoards();

    List<AoiBoard> listAoiBoardsByType(int r8);

    void registerAoiBoardCallback(IStarAoiBoardCallback r8);

    void unregisterAoiBoardCallback();
}
