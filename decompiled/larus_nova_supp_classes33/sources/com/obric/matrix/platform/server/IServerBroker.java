package com.obric.matrix.platform.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface IServerBroker extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.server.IServerBroker";

    public static class Default implements IServerBroker {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public byte[] invoke(int r1, byte[] r2) throws RemoteException {
            return null;
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public void invokeAsyn(int r1, byte[] r2, IServerCallback r3) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public void registerServerCallback(String r1, IServerCallback r2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IServerBroker {
        static final int TRANSACTION_invoke = 1;
        static final int TRANSACTION_invokeAsyn = 2;
        static final int TRANSACTION_registerServerCallback = 3;

        public static class Proxy implements IServerBroker {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IServerBroker.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.matrix.platform.server.IServerBroker
            public byte[] invoke(int r4, byte[] r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IServerBroker.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeByteArray(r5);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_server_IServerBroker$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                byte[] r6 = r1.createByteArray();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.server.IServerBroker
            public void registerServerCallback(String r4, IServerCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IServerBroker.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_server_IServerBroker$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.server.IServerBroker
            public void invokeAsyn(int r4, byte[] r5, IServerCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IServerBroker.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeByteArray(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_server_IServerBroker$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_matrix_platform_server_IServerBroker$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r2 = SystemClock.uptimeMillis();
                boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
                long r8 = SystemClock.uptimeMillis() - r2;
                if (r8 < 100) goto L11;
                BinderPerformanceReporter.report(r8, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r0;
            L12:
                th = move-exception;
                long r9 = SystemClock.uptimeMillis() - r2;
                if (r9 < 100) goto L22;
                if (r15 != null) goto L17;
                String r1 = "";
            L18:
                BinderPerformanceReporter.report(r9, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r1 = r15.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r15.transact(r16, r17, r18, r19);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IServerBroker.DESCRIPTOR);
        }

        public static IServerBroker asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IServerBroker.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IServerBroker) == false) goto L12;
            return (IServerBroker) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IServerBroker.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(IServerBroker.DESCRIPTOR);
            return true;
        L11:
            if (r4 != 1) goto L13;
            byte[] r8 = invoke(r5.readInt(), r5.createByteArray());
            r6.writeNoException();
            r6.writeByteArray(r8);
        L21:
            return true;
        L13:
            if (r4 != 2) goto L15;
            invokeAsyn(r5.readInt(), r5.createByteArray(), IServerCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L21
        L15:
            if (r4 != 3) goto L17;
            registerServerCallback(r5.readString(), IServerCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L21
        L17:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    byte[] invoke(int r1, byte[] r2) throws RemoteException;

    void invokeAsyn(int r1, byte[] r2, IServerCallback r3) throws RemoteException;

    void registerServerCallback(String r1, IServerCallback r2) throws RemoteException;
}
