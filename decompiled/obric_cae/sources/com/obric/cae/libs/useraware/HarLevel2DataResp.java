package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public interface HarLevel2DataResp extends IInterface {

    public static class Default implements HarLevel2DataResp {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.HarLevel2DataResp
        public void onCollectStats(boolean r8, ParcelFileDescriptor r10) {
        }

        @Override // com.obric.cae.libs.useraware.HarLevel2DataResp
        public void onDataReady(int r8, int r10) {
        }
    }

    public static abstract class Stub extends Binder implements HarLevel2DataResp {
        private static final String DESCRIPTOR = "com.obric.cae.libs.useraware.HarLevel2DataResp";
        static final int TRANSACTION_onCollectStats = 1;
        static final int TRANSACTION_onDataReady = 2;

        public static class Proxy implements HarLevel2DataResp {
            public static HarLevel2DataResp sDefaultImpl;
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

            @Override // com.obric.cae.libs.useraware.HarLevel2DataResp
            public void onCollectStats(boolean r8, ParcelFileDescriptor r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r11.writeInt(r8 ? 1 : 0);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L16
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(1, r11, null, 1) == false) goto L10;
            L14:
                r11.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onCollectStats(r8, r10);     // Catch: Throwable -> L16
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.HarLevel2DataResp
            public void onDataReady(int r8, int r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeInt(r8);     // Catch: Throwable -> L12
                r11.writeInt(r10);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r11, null, 1) == false) goto L6;
            L10:
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onDataReady(r8, r10);     // Catch: Throwable -> L12
                r11.recycle();
                return;
            L12:
                th = move-exception;
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static HarLevel2DataResp asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof HarLevel2DataResp) == false) goto L12;
            return (HarLevel2DataResp) r10;
        L12:
            return new Proxy(r8);
        }

        public static HarLevel2DataResp getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(HarLevel2DataResp r8) {
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
            if (r10.readInt() == 0) goto L17;
            boolean r13 = true;
        L19:
            if (r10.readInt() == 0) goto L21;
            ParcelFileDescriptor r14 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(r10);
        L22:
            onCollectStats(r13, r14);
            return true;
        L21:
            r14 = null;
            goto L22
        L17:
            r13 = false;
            goto L19
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            onDataReady(r10.readInt(), r10.readInt());
            return true;
        L7:
            if (r8 != 1598968902) goto L9;
            r11.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void onCollectStats(boolean r8, ParcelFileDescriptor r10);

    void onDataReady(int r8, int r10);
}
