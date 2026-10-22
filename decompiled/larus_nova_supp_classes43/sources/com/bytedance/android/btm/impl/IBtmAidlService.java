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
public interface IBtmAidlService extends IInterface {

    public static class Default implements IBtmAidlService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.android.btm.impl.IBtmAidlService
        public String getPreBtm(String r1) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.android.btm.impl.IBtmAidlService
        public void setPreBtm(String r1, String r10, boolean r11) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IBtmAidlService {
        private static final String DESCRIPTOR = "com.bytedance.android.btm.impl.IBtmAidlService";
        static final int TRANSACTION_getPreBtm = 2;
        static final int TRANSACTION_setPreBtm = 1;

        public static class Proxy implements IBtmAidlService {
            public static IBtmAidlService sDefaultImpl;
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

            @Override // com.bytedance.android.btm.impl.IBtmAidlService
            public String getPreBtm(String r10) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r10);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_android_btm_impl_IBtmAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r11 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r12 = Stub.getDefaultImpl().getPreBtm(r10);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r12;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.android.btm.impl.IBtmAidlService
            public void setPreBtm(String r10, String r11, boolean r12) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r10);     // Catch: Throwable -> L17
                r0.writeString(r11);     // Catch: Throwable -> L17
                if (r12 == false) goto L6;
                int r13 = 1;
            L7:
                r0.writeInt(r13);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_android_btm_impl_IBtmAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setPreBtm(r10, r11, r12);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r13 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_android_btm_impl_IBtmAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IBtmAidlService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IBtmAidlService asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r10.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IBtmAidlService) == false) goto L12;
            return (IBtmAidlService) r0;
        L12:
            return new Proxy(r10);
        }

        public static boolean setDefaultImpl(IBtmAidlService r1) {
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
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
            if (r10 != 1) goto L5;
            r11.enforceInterface(DESCRIPTOR);
            String r14 = r11.readString();
            String r15 = r11.readString();
            if (r11.readInt() == 0) goto L17;
            boolean r16 = true;
        L18:
            setPreBtm(r14, r15, r16);
            r12.writeNoException();
            return true;
        L17:
            r16 = false;
            goto L18
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface(DESCRIPTOR);
            String r17 = getPreBtm(r11.readString());
            r12.writeNoException();
            r12.writeString(r17);
            return true;
        L7:
            if (r10 != 1598968902) goto L9;
            r12.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    String getPreBtm(String r1) throws RemoteException;

    void setPreBtm(String r1, String r10, boolean r11) throws RemoteException;
}
