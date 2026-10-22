package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IDeviceInfoCallback extends IInterface {

    public static class Default implements IDeviceInfoCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDeviceInfoCallback {

        public static class Proxy implements IDeviceInfoCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f6121a;

            public Proxy(IBinder r8) {
                this.f6121a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f6121a;
            }
        }

        public Stub() {
            attachInterface(this, "com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
        }

        public static IDeviceInfoCallback H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
            if (r10 == null) goto L12;
            if ((r10 instanceof IDeviceInfoCallback) == false) goto L12;
            return (IDeviceInfoCallback) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1) goto L5;
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
            MatrixTeaManager$deviceInfoCallback$1 r13 = (MatrixTeaManager$deviceInfoCallback$1) this;
            r13.I2(r10.readString());
        L13:
            r11.writeNoException();
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
            MatrixTeaManager$deviceInfoCallback$1 r14 = (MatrixTeaManager$deviceInfoCallback$1) this;
            r14.J2(r10.readString());
            goto L13
        L7:
            if (r8 != 1598968902) goto L9;
            r11.writeString("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
            return true;
        L9:
            return super.onTransact(r8, r10, r11, r12);
        }
    }
}
