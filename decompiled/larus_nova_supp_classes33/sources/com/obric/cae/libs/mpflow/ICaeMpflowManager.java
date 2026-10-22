package com.obric.cae.libs.mpflow;

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
public interface ICaeMpflowManager extends IInterface {
    public static final int SMART_NETWORK_FLOW_NET_TYPE_CELLULAR_1 = 0;
    public static final int SMART_NETWORK_FLOW_NET_TYPE_CELLULAR_2 = 1;
    public static final int SMART_NETWORK_FLOW_NET_TYPE_WIFI_1 = 2;
    public static final int SMART_NETWORK_FLOW_NET_TYPE_WIFI_2 = 3;

    public static class Default implements ICaeMpflowManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int bindNetByPid(int r1, int r2, boolean r3) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int bindNetByUid(int r1, int r2, boolean r3) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public void disconnectSocketByPid(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public void disconnectSocketByUid(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int modifyNetName(int r1, String r2) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int setSocketOptByUid(int r1, int r2, int r3) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int switchNetByPid(int r1, int r2, boolean r3) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int switchNetByUid(int r1, int r2, boolean r3) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ICaeMpflowManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.mpflow.ICaeMpflowManager";
        static final int TRANSACTION_bindNetByPid = 5;
        static final int TRANSACTION_bindNetByUid = 3;
        static final int TRANSACTION_disconnectSocketByPid = 7;
        static final int TRANSACTION_disconnectSocketByUid = 6;
        static final int TRANSACTION_modifyNetName = 1;
        static final int TRANSACTION_setSocketOptByUid = 8;
        static final int TRANSACTION_switchNetByPid = 4;
        static final int TRANSACTION_switchNetByUid = 2;

        public static class Proxy implements ICaeMpflowManager {
            public static ICaeMpflowManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public void disconnectSocketByPid(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().disconnectSocketByPid(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public void disconnectSocketByUid(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().disconnectSocketByUid(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int modifyNetName(int r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeString(r7);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r8 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r9 = Stub.getDefaultImpl().modifyNetName(r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int bindNetByPid(int r6, int r7, boolean r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7);     // Catch: Throwable -> L13
                r0.writeInt(r8 ? 1 : 0);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r9 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r10 = Stub.getDefaultImpl().bindNetByPid(r6, r7, r8);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r10;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int bindNetByUid(int r6, int r7, boolean r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7);     // Catch: Throwable -> L13
                r0.writeInt(r8 ? 1 : 0);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r9 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r10 = Stub.getDefaultImpl().bindNetByUid(r6, r7, r8);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r10;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int setSocketOptByUid(int r6, int r7, int r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7);     // Catch: Throwable -> L13
                r0.writeInt(r8);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r9 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r10 = Stub.getDefaultImpl().setSocketOptByUid(r6, r7, r8);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r10;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int switchNetByPid(int r6, int r7, boolean r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7);     // Catch: Throwable -> L13
                r0.writeInt(r8 ? 1 : 0);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r9 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r10 = Stub.getDefaultImpl().switchNetByPid(r6, r7, r8);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r10;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int switchNetByUid(int r6, int r7, boolean r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7);     // Catch: Throwable -> L13
                r0.writeInt(r8 ? 1 : 0);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r9 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r10 = Stub.getDefaultImpl().switchNetByUid(r6, r7, r8);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r10;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static ICaeMpflowManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeMpflowManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeMpflowManager) == false) goto L12;
            return (ICaeMpflowManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ICaeMpflowManager r1) {
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
            if (r4 == 1598968902) goto L36;
            boolean r0 = false;
            switch(r4) {
                case 1: goto L34;
                case 2: goto L29;
                case 3: goto L24;
                case 4: goto L19;
                case 5: goto L14;
                case 6: goto L12;
                case 7: goto L10;
                case 8: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            int r8 = setSocketOptByUid(r5.readInt(), r5.readInt(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r8);
            return true;
        L10:
            r5.enforceInterface(DESCRIPTOR);
            disconnectSocketByPid(r5.readInt());
            return true;
        L12:
            r5.enforceInterface(DESCRIPTOR);
            disconnectSocketByUid(r5.readInt());
            return true;
        L14:
            r5.enforceInterface(DESCRIPTOR);
            int r9 = r5.readInt();
            int r10 = r5.readInt();
            if (r5.readInt() == 0) goto L17;
            r0 = true;
        L17:
            int r11 = bindNetByPid(r9, r10, r0);
            r6.writeNoException();
            r6.writeInt(r11);
            return true;
        L19:
            r5.enforceInterface(DESCRIPTOR);
            int r12 = r5.readInt();
            int r13 = r5.readInt();
            if (r5.readInt() == 0) goto L22;
            r0 = true;
        L22:
            int r14 = switchNetByPid(r12, r13, r0);
            r6.writeNoException();
            r6.writeInt(r14);
            return true;
        L24:
            r5.enforceInterface(DESCRIPTOR);
            int r15 = r5.readInt();
            int r16 = r5.readInt();
            if (r5.readInt() == 0) goto L27;
            r0 = true;
        L27:
            int r17 = bindNetByUid(r15, r16, r0);
            r6.writeNoException();
            r6.writeInt(r17);
            return true;
        L29:
            r5.enforceInterface(DESCRIPTOR);
            int r18 = r5.readInt();
            int r19 = r5.readInt();
            if (r5.readInt() == 0) goto L32;
            r0 = true;
        L32:
            int r20 = switchNetByUid(r18, r19, r0);
            r6.writeNoException();
            r6.writeInt(r20);
            return true;
        L34:
            r5.enforceInterface(DESCRIPTOR);
            int r21 = modifyNetName(r5.readInt(), r5.readString());
            r6.writeNoException();
            r6.writeInt(r21);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L36:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    int bindNetByPid(int r1, int r2, boolean r3) throws RemoteException;

    int bindNetByUid(int r1, int r2, boolean r3) throws RemoteException;

    void disconnectSocketByPid(int r1) throws RemoteException;

    void disconnectSocketByUid(int r1) throws RemoteException;

    int modifyNetName(int r1, String r2) throws RemoteException;

    int setSocketOptByUid(int r1, int r2, int r3) throws RemoteException;

    int switchNetByPid(int r1, int r2, boolean r3) throws RemoteException;

    int switchNetByUid(int r1, int r2, boolean r3) throws RemoteException;
}
