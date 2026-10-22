package com.obric.matrix.platform.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IServerBroker extends IInterface {

    public static class Default implements IServerBroker {
        public Default() {
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public final void I1(String r8, IServerCallback r10) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IServerBroker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f6153a = 0;

        public static class Proxy implements IServerBroker {
            @Override // com.obric.matrix.platform.server.IServerBroker
            public final void I1(String r8, IServerCallback r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.matrix.platform.server.IServerBroker");     // Catch: Throwable -> L9
                r11.writeString(r8);     // Catch: Throwable -> L9
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L9
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L9
                throw null;     // Catch: Throwable -> L9
            L6:
                r13 = null;
            L9:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }
        }

        public Stub() {
            attachInterface(this, "com.obric.matrix.platform.server.IServerBroker");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1) goto L5;
            r10.enforceInterface("com.obric.matrix.platform.server.IServerBroker");
            r10.readInt();
            r10.createByteArray();
            byte[] r13 = f();
            r11.writeNoException();
            r11.writeByteArray(r13);
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface("com.obric.matrix.platform.server.IServerBroker");
            r10.readInt();
            r10.createByteArray();
            IServerCallback.Stub.H2(r10.readStrongBinder());
            m2();
            r11.writeNoException();
            return true;
        L7:
            if (r8 != 3) goto L9;
            r10.enforceInterface("com.obric.matrix.platform.server.IServerBroker");
            I1(r10.readString(), IServerCallback.Stub.H2(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L9:
            if (r8 != 1598968902) goto L11;
            r11.writeString("com.obric.matrix.platform.server.IServerBroker");
            return true;
        L11:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void I1(String r8, IServerCallback r10);

    byte[] f();

    void m2();
}
