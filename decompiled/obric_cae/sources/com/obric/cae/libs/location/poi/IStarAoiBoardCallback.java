package com.obric.cae.libs.location.poi;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
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
        public void onAoiBoardBreachReport(AoiBoard r8, Location r10, int r11) {
        }
    }

    public static abstract class Stub extends Binder implements IStarAoiBoardCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.poi.IStarAoiBoardCallback";
        static final int TRANSACTION_onAoiBoardBreachReport = 1;

        public static class Proxy implements IStarAoiBoardCallback {
            public static IStarAoiBoardCallback sDefaultImpl;
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

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardCallback
            public void onAoiBoardBreachReport(AoiBoard r8, Location r10, int r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r8 == null) goto L6;
                r12.writeInt(1);     // Catch: Throwable -> L19
                r8.writeToParcel(r12, 0);     // Catch: Throwable -> L19
            L7:
                if (r10 == null) goto L9;
                r12.writeInt(1);     // Catch: Throwable -> L19
                r10.writeToParcel(r12, 0);     // Catch: Throwable -> L19
            L10:
                r12.writeInt(r11);     // Catch: Throwable -> L19
                if (this.mRemote.transact(1, r12, null, 1) == false) goto L13;
            L17:
                r12.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onAoiBoardBreachReport(r8, r10, r11);     // Catch: Throwable -> L19
                r12.recycle();
                return;
            L9:
                r12.writeInt(0);     // Catch: Throwable -> L19
                goto L10
            L6:
                r12.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r12.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarAoiBoardCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IStarAoiBoardCallback) == false) goto L12;
            return (IStarAoiBoardCallback) r10;
        L12:
            return new Proxy(r8);
        }

        public static IStarAoiBoardCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IStarAoiBoardCallback r8) {
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
            if (r8 != 1) goto L5;
            r10.enforceInterface(DESCRIPTOR);
            Location r13 = null;
            if (r10.readInt() == 0) goto L13;
            AoiBoard r14 = AoiBoard.CREATOR.createFromParcel(r10);
        L15:
            if (r10.readInt() == 0) goto L17;
            r13 = (Location) Location.CREATOR.createFromParcel(r10);
        L17:
            onAoiBoardBreachReport(r14, r13, r10.readInt());
            return true;
        L13:
            r14 = null;
            goto L15
        L5:
            if (r8 != 1598968902) goto L7;
            r11.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void onAoiBoardBreachReport(AoiBoard r8, Location r10, int r11);
}
