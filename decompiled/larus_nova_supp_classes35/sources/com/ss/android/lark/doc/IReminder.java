package com.ss.android.lark.doc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IReminder extends IInterface {

    public static class Default implements IReminder {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.lark.doc.IReminder
        public void getRemindState(String r1, IFetchRemindCallback r2) throws RemoteException {
        }

        @Override // com.ss.android.lark.doc.IReminder
        public void registerRemindListener(IRemindStateChangeListener r1) throws RemoteException {
        }

        @Override // com.ss.android.lark.doc.IReminder
        public void setRemind(String r1, boolean r2, IPutRemindCallback r3) throws RemoteException {
        }

        @Override // com.ss.android.lark.doc.IReminder
        public void unRegisterRemindListener(IRemindStateChangeListener r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IReminder {
        private static final String DESCRIPTOR = "com.ss.android.lark.doc.IReminder";
        static final int TRANSACTION_getRemindState = 2;
        static final int TRANSACTION_registerRemindListener = 3;
        static final int TRANSACTION_setRemind = 1;
        static final int TRANSACTION_unRegisterRemindListener = 4;

        public static class Proxy implements IReminder {
            public static IReminder sDefaultImpl;
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

            @Override // com.ss.android.lark.doc.IReminder
            public void registerRemindListener(IRemindStateChangeListener r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_ss_android_lark_doc_IReminder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerRemindListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.lark.doc.IReminder
            public void unRegisterRemindListener(IRemindStateChangeListener r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_ss_android_lark_doc_IReminder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unRegisterRemindListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.lark.doc.IReminder
            public void getRemindState(String r6, IFetchRemindCallback r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r6);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_ss_android_lark_doc_IReminder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().getRemindState(r6, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.lark.doc.IReminder
            public void setRemind(String r5, boolean r6, IPutRemindCallback r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r0.writeString(r5);     // Catch: Throwable -> L20
                if (r6 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L20
                if (r7 == null) goto L10;
                IBinder r3 = r7.asBinder();     // Catch: Throwable -> L20
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_ss_android_lark_doc_IReminder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().setRemind(r5, r6, r7);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r2 = 0;
            L20:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_lark_doc_IReminder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
                String r1 = BuildConfig.FLAVOR;
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

        public static IReminder getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IReminder asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IReminder) == false) goto L12;
            return (IReminder) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IReminder r1) {
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
            String r8 = r5.readString();
            if (r5.readInt() == 0) goto L25;
            boolean r9 = true;
        L26:
            setRemind(r8, r9, IPutRemindCallback.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L25:
            r9 = false;
            goto L26
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            getRemindState(r5.readString(), IFetchRemindCallback.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            registerRemindListener(IRemindStateChangeListener.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface(DESCRIPTOR);
            unRegisterRemindListener(IRemindStateChangeListener.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L11:
            if (r4 != 1598968902) goto L13;
            r6.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void getRemindState(String r1, IFetchRemindCallback r2) throws RemoteException;

    void registerRemindListener(IRemindStateChangeListener r1) throws RemoteException;

    void setRemind(String r1, boolean r2, IPutRemindCallback r3) throws RemoteException;

    void unRegisterRemindListener(IRemindStateChangeListener r1) throws RemoteException;
}
