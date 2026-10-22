package com.ss.android.lark.forwardv2.impl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface RemoteForwardExecutor extends IInterface {

    public static class Default implements RemoteForwardExecutor {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecutor
        public void onForward(List<ForwardTarget> r1, Bundle r2, RemoteForwardExecuteCallback r3) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements RemoteForwardExecutor {
        private static final String DESCRIPTOR = "com.ss.android.lark.forwardv2.impl.RemoteForwardExecutor";
        static final int TRANSACTION_onForward = 1;

        public static class Proxy implements RemoteForwardExecutor {
            public static RemoteForwardExecutor sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecutor
            public void onForward(List<ForwardTarget> r6, Bundle r7, RemoteForwardExecuteCallback r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r0.writeTypedList(r6);     // Catch: Throwable -> L20
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r8 == null) goto L9;
                IBinder r4 = r8.asBinder();     // Catch: Throwable -> L20
            L10:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_ss_android_lark_forwardv2_impl_RemoteForwardExecutor$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onForward(r6, r7, r8);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r4 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_lark_forwardv2_impl_RemoteForwardExecutor$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
            attachInterface(this, DESCRIPTOR);
        }

        public static RemoteForwardExecutor getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static RemoteForwardExecutor asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof RemoteForwardExecutor) == false) goto L12;
            return (RemoteForwardExecutor) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(RemoteForwardExecutor r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            ArrayList r8 = r5.createTypedArrayList(ForwardTarget.CREATOR);
            if (r5.readInt() == 0) goto L13;
            Bundle r9 = (Bundle) Bundle.CREATOR.createFromParcel(r5);
        L14:
            onForward(r8, r9, RemoteForwardExecuteCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L13:
            r9 = null;
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onForward(List<ForwardTarget> r1, Bundle r2, RemoteForwardExecuteCallback r3) throws RemoteException;
}
