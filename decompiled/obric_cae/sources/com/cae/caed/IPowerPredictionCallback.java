package com.cae.caed;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IPowerPredictionCallback extends IInterface {

    public static class Default implements IPowerPredictionCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IPowerPredictionCallback {

        public static class Proxy implements IPowerPredictionCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f4127a;

            public Proxy(IBinder r8) {
                this.f4127a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4127a;
            }
        }

        public Stub() {
            attachInterface(this, "com.cae.caed.IPowerPredictionCallback");
        }

        public static IPowerPredictionCallback H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.cae.caed.IPowerPredictionCallback");
            if (r10 == null) goto L12;
            if ((r10 instanceof IPowerPredictionCallback) == false) goto L12;
            return (IPowerPredictionCallback) r10;
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
            r10.enforceInterface("com.cae.caed.IPowerPredictionCallback");
        L8:
            if (r8 != 1598968902) goto L11;
            r11.writeString("com.cae.caed.IPowerPredictionCallback");
            return true;
        L11:
            if (r8 != 1) goto L13;
            r10.createTypedArrayList(PowerPredictionParcel.CREATOR);
            k0();
            return true;
        L13:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void k0();
}
