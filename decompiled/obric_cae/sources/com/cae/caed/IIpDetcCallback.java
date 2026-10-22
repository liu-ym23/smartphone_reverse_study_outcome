package com.cae.caed;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IIpDetcCallback extends IInterface {

    public static class Default implements IIpDetcCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IIpDetcCallback {

        public static class Proxy implements IIpDetcCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f4124a;

            public Proxy(IBinder r8) {
                this.f4124a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4124a;
            }
        }

        public Stub() {
            attachInterface(this, "com.cae.caed.IIpDetcCallback");
        }

        public static IIpDetcCallback H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.cae.caed.IIpDetcCallback");
            if (r10 == null) goto L12;
            if ((r10 instanceof IIpDetcCallback) == false) goto L12;
            return (IIpDetcCallback) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface("com.cae.caed.IIpDetcCallback");
        L8:
            if (r8 != 1598968902) goto L11;
            r11.writeString("com.cae.caed.IIpDetcCallback");
            return true;
        L11:
            if (r8 != 1) goto L13;
            r10.readInt();
            r10.readString();
            q();
            r11.writeNoException();
            return true;
        L13:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void q();
}
