package com.cae.caed.net;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IL4NetInfoUpdateCb extends IInterface {

    public static class Default implements IL4NetInfoUpdateCb {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IL4NetInfoUpdateCb {
        static final int TRANSACTION_L4NetInfoUpdate = 1;

        public static class Proxy implements IL4NetInfoUpdateCb {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f4276a;

            public Proxy(IBinder r8) {
                this.f4276a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4276a;
            }
        }

        public Stub() {
            attachInterface(this, "com.cae.caed.net.IL4NetInfoUpdateCb");
        }

        public static IL4NetInfoUpdateCb asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.cae.caed.net.IL4NetInfoUpdateCb");
            if (r10 == null) goto L12;
            if ((r10 instanceof IL4NetInfoUpdateCb) == false) goto L12;
            return (IL4NetInfoUpdateCb) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface("com.cae.caed.net.IL4NetInfoUpdateCb");
        L8:
            if (r8 != 1598968902) goto L11;
            r11.writeString("com.cae.caed.net.IL4NetInfoUpdateCb");
            return true;
        L11:
            if (r8 != 1) goto L13;
            L4NetInfoUpdate((L4NetInfoParcel) r10.readTypedObject(L4NetInfoParcel.CREATOR));
            r11.writeNoException();
            return true;
        L13:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void L4NetInfoUpdate(L4NetInfoParcel r8);
}
