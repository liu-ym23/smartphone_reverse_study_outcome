package com.obric.matrix.platform.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IServerCallback extends IInterface {

    public static class Default implements IServerCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IServerCallback {

        public static class Proxy implements IServerCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f6154a;

            public Proxy(IBinder r8) {
                this.f6154a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f6154a;
            }
        }

        public Stub() {
            attachInterface(this, "com.obric.matrix.platform.server.IServerCallback");
        }

        public static IServerCallback H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.obric.matrix.platform.server.IServerCallback");
            if (r10 == null) goto L12;
            if ((r10 instanceof IServerCallback) == false) goto L12;
            return (IServerCallback) r10;
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
            r10.enforceInterface("com.obric.matrix.platform.server.IServerCallback");
            a0(r10.readInt(), r10.createByteArray());
            r11.writeNoException();
            return true;
        L5:
            if (r8 != 1598968902) goto L7;
            r11.writeString("com.obric.matrix.platform.server.IServerCallback");
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void a0(int r8, byte[] r10);
}
