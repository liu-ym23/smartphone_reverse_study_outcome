package com.bytedance.android.btm.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IAppLogAidlService extends IInterface {

    public static class Default implements IAppLogAidlService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.android.btm.impl.IAppLogAidlService
        public void onEventV1(String r1, String r10, String r11, long r12, long r13, boolean r14, String r15) throws RemoteException {
        }

        @Override // com.bytedance.android.btm.impl.IAppLogAidlService
        public void onEventV3(String r1, String r10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAppLogAidlService {
        private static final String DESCRIPTOR = "com.bytedance.android.btm.impl.IAppLogAidlService";
        static final int TRANSACTION_onEventV1 = 1;
        static final int TRANSACTION_onEventV3 = 2;

        public static class Proxy implements IAppLogAidlService {
            public static IAppLogAidlService sDefaultImpl;
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

            @Override // com.bytedance.android.btm.impl.IAppLogAidlService
            public void onEventV3(String r10, String r11) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r10);     // Catch: Throwable -> L13
                r0.writeString(r11);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_android_btm_impl_IAppLogAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onEventV3(r10, r11);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_android_btm_impl_IAppLogAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r10 = SystemClock.uptimeMillis();
                boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
                long r11 = SystemClock.uptimeMillis() - r10;
                if (r11 < 100) goto L11;
                BinderPerformanceReporter.report(r11, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r0;
            L12:
                th = move-exception;
                long r12 = SystemClock.uptimeMillis() - r10;
                if (r12 < 100) goto L22;
                if (r15 != null) goto L17;
                String r1 = "";
            L18:
                BinderPerformanceReporter.report(r12, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r1 = r15.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r15.transact(r16, r17, r18, r19);
            }

            @Override // com.bytedance.android.btm.impl.IAppLogAidlService
            public void onEventV1(String r15, String r16, String r17, long r18, long r20, boolean r22, String r23) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r1.writeString(r15);     // Catch: Throwable -> L21
                r1.writeString(r16);     // Catch: Throwable -> L21
                r1.writeString(r17);     // Catch: Throwable -> L21
                r1.writeLong(r18);     // Catch: Throwable -> L21
                r1.writeLong(r20);     // Catch: Throwable -> L21
                if (r22 == false) goto L6;
                int r11 = 1;
            L7:
                r1.writeInt(r11);     // Catch: Throwable -> L21
                r1.writeString(r23);     // Catch: Throwable -> L21
            L19:
                th = th;
            L23:
                r10.recycle();
                r1.recycle();
                throw th;
            L10:
                if (INVOKEINTERFACE_com_bytedance_android_btm_impl_IAppLogAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r1, r10, 0) == false) goto L12;
            L16:
                r10.readException();     // Catch: Throwable -> L19
                r10.recycle();
                r1.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().onEventV1(r15, r16, r17, r18, r20, r22, r23);     // Catch: Throwable -> L19
                r10.recycle();
                r1.recycle();
                return;
            L6:
                r11 = 0;
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

        public static IAppLogAidlService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAppLogAidlService asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r10.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAppLogAidlService) == false) goto L12;
            return (IAppLogAidlService) r0;
        L12:
            return new Proxy(r10);
        }

        public static boolean setDefaultImpl(IAppLogAidlService r1) {
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
        public boolean onTransact(int r12, Parcel r13, Parcel r14, int r15) throws RemoteException {
            if (r12 != 1) goto L5;
            r13.enforceInterface(DESCRIPTOR);
            String r10 = r13.readString();
            String r11 = r13.readString();
            String r16 = r13.readString();
            long r17 = r13.readLong();
            long r18 = r13.readLong();
            if (r13.readInt() == 0) goto L17;
            boolean r19 = true;
        L18:
            onEventV1(r10, r11, r16, r17, r18, r19, r13.readString());
            r14.writeNoException();
            return true;
        L17:
            r19 = false;
            goto L18
        L5:
            if (r12 != 2) goto L7;
            r13.enforceInterface(DESCRIPTOR);
            onEventV3(r13.readString(), r13.readString());
            r14.writeNoException();
            return true;
        L7:
            if (r12 != 1598968902) goto L9;
            r14.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r12, r13, r14, r15);
        }
    }

    void onEventV1(String r1, String r10, String r11, long r12, long r13, boolean r14, String r15) throws RemoteException;

    void onEventV3(String r1, String r10) throws RemoteException;
}
