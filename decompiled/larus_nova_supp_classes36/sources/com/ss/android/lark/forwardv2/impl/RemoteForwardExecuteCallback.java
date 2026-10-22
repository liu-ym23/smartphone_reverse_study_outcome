package com.ss.android.lark.forwardv2.impl;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface RemoteForwardExecuteCallback extends IInterface {

    public static class Default implements RemoteForwardExecuteCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecuteCallback
        public void onFailedDialog(String r1, String r2, boolean r3) throws RemoteException {
        }

        @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecuteCallback
        public void onFailedToast(String r1, boolean r2) throws RemoteException {
        }

        @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecuteCallback
        public void onSuccess(int r1, Intent r2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements RemoteForwardExecuteCallback {
        private static final String DESCRIPTOR = "com.ss.android.lark.forwardv2.impl.RemoteForwardExecuteCallback";
        static final int TRANSACTION_onFailedDialog = 3;
        static final int TRANSACTION_onFailedToast = 2;
        static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements RemoteForwardExecuteCallback {
            public static RemoteForwardExecuteCallback sDefaultImpl;
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

            @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecuteCallback
            public void onFailedToast(String r6, boolean r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r7 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_lark_forwardv2_impl_RemoteForwardExecuteCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onFailedToast(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecuteCallback
            public void onSuccess(int r6, Intent r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_ss_android_lark_forwardv2_impl_RemoteForwardExecuteCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onSuccess(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecuteCallback
            public void onFailedDialog(String r6, String r7, boolean r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeString(r7);     // Catch: Throwable -> L17
                if (r8 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_lark_forwardv2_impl_RemoteForwardExecuteCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onFailedDialog(r6, r7, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_lark_forwardv2_impl_RemoteForwardExecuteCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static RemoteForwardExecuteCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static RemoteForwardExecuteCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof RemoteForwardExecuteCallback) == false) goto L12;
            return (RemoteForwardExecuteCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(RemoteForwardExecuteCallback r1) {
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
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            if (r5 == 1) goto L24;
            boolean r3 = false;
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            String r9 = r6.readString();
            if (r6.readInt() == 0) goto L22;
            r3 = true;
        L22:
            onFailedToast(r9, r3);
            r7.writeNoException();
            return true;
        L7:
            if (r5 != 3) goto L9;
            r6.enforceInterface(DESCRIPTOR);
            String r10 = r6.readString();
            String r11 = r6.readString();
            if (r6.readInt() == 0) goto L17;
            r3 = true;
        L17:
            onFailedDialog(r10, r11, r3);
            r7.writeNoException();
            return true;
        L9:
            if (r5 != 1598968902) goto L11;
            r7.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r5, r6, r7, r8);
        L24:
            r6.enforceInterface(DESCRIPTOR);
            int r12 = r6.readInt();
            if (r6.readInt() == 0) goto L27;
            Intent r13 = (Intent) Intent.CREATOR.createFromParcel(r6);
        L28:
            onSuccess(r12, r13);
            r7.writeNoException();
            return true;
        L27:
            r13 = null;
            goto L28
        }
    }

    void onFailedDialog(String r1, String r2, boolean r3) throws RemoteException;

    void onFailedToast(String r1, boolean r2) throws RemoteException;

    void onSuccess(int r1, Intent r2) throws RemoteException;
}
