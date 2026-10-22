package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface IOAIDCallBack extends IInterface {

    public static abstract class Stub extends Binder implements IOAIDCallBack {
        private static final String DESCRIPTOR = "com.hihonor.cloudservice.oaid.IOAIDCallBack";
        static final int TRANSACTION_basicTypes = 1;
        static final int TRANSACTION_handleResult = 2;

        public static class Proxy implements IOAIDCallBack {
            public static IOAIDCallBack sDefaultImpl;
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

            @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
            public void handleResult(int r6, Bundle r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IOAIDCallBack$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().handleResult(r6, r7);     // Catch: Throwable -> L17
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

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IOAIDCallBack$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

            @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
            public void basicTypes(int r14, long r15, boolean r17, float r18, double r19, String r21) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r1.writeInt(r14);     // Catch: Throwable -> L21
                r1.writeLong(r15);     // Catch: Throwable -> L21
                if (r17 == false) goto L6;
                int r7 = 1;
            L7:
                r1.writeInt(r7);     // Catch: Throwable -> L21
                r1.writeFloat(r18);     // Catch: Throwable -> L21
                r1.writeDouble(r19);     // Catch: Throwable -> L21
                r1.writeString(r21);     // Catch: Throwable -> L21
            L19:
                th = th;
            L23:
                r2.recycle();
                r1.recycle();
                throw th;
            L10:
                if (INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IOAIDCallBack$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r1, r2, 0) == false) goto L12;
            L16:
                r2.readException();     // Catch: Throwable -> L19
                r2.recycle();
                r1.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().basicTypes(r14, r15, r17, r18, r19, r21);     // Catch: Throwable -> L19
                r2.recycle();
                r1.recycle();
                return;
            L6:
                r7 = 0;
            L21:
                th = th;
                goto L23
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOAIDCallBack getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IOAIDCallBack asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IOAIDCallBack) == false) goto L12;
            return (IOAIDCallBack) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IOAIDCallBack r1) {
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
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) throws RemoteException {
            if (r11 != 1) goto L5;
            r12.enforceInterface(DESCRIPTOR);
            int r2 = r12.readInt();
            long r3 = r12.readLong();
            if (r12.readInt() == 0) goto L21;
            boolean r5 = true;
        L22:
            basicTypes(r2, r3, r5, r12.readFloat(), r12.readDouble(), r12.readString());
            r13.writeNoException();
            return true;
        L21:
            r5 = false;
            goto L22
        L5:
            if (r11 != 2) goto L7;
            r12.enforceInterface(DESCRIPTOR);
            int r15 = r12.readInt();
            if (r12.readInt() == 0) goto L15;
            Bundle r16 = (Bundle) Bundle.CREATOR.createFromParcel(r12);
        L16:
            handleResult(r15, r16);
            r13.writeNoException();
            return true;
        L15:
            r16 = null;
            goto L16
        L7:
            if (r11 != 1598968902) goto L9;
            r13.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r11, r12, r13, r14);
        }
    }

    void basicTypes(int r1, long r2, boolean r4, float r5, double r6, String r8) throws RemoteException;

    void handleResult(int r1, Bundle r2) throws RemoteException;
}
