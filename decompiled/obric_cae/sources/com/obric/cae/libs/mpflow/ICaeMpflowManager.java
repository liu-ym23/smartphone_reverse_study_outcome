package com.obric.cae.libs.mpflow;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
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
        public int bindNetByPid(int r8, int r10, boolean r11) {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int bindNetByUid(int r8, int r10, boolean r11) {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public void disconnectSocketByPid(int r8) {
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public void disconnectSocketByUid(int r8) {
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int modifyNetName(int r8, String r10) {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int setSocketOptByUid(int r8, int r10, int r11) {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int switchNetByPid(int r8, int r10, boolean r11) {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int switchNetByUid(int r8, int r10, boolean r11) {
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

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int bindNetByPid(int r8, int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r12.writeInt(r8);     // Catch: Throwable -> L12
                r12.writeInt(r10);     // Catch: Throwable -> L12
                r12.writeInt(r11 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L12
                int r14 = r13.readInt();     // Catch: Throwable -> L12
            L8:
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r14 = Stub.getDefaultImpl().bindNetByPid(r8, r10, r11);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int bindNetByUid(int r8, int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r12.writeInt(r8);     // Catch: Throwable -> L12
                r12.writeInt(r10);     // Catch: Throwable -> L12
                r12.writeInt(r11 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L12
                int r14 = r13.readInt();     // Catch: Throwable -> L12
            L8:
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r14 = Stub.getDefaultImpl().bindNetByUid(r8, r10, r11);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public void disconnectSocketByPid(int r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r10, null, 1) == false) goto L6;
            L10:
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().disconnectSocketByPid(r8);     // Catch: Throwable -> L12
                r10.recycle();
                return;
            L12:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public void disconnectSocketByUid(int r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r10, null, 1) == false) goto L6;
            L10:
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().disconnectSocketByUid(r8);     // Catch: Throwable -> L12
                r10.recycle();
                return;
            L12:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int modifyNetName(int r8, String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeInt(r8);     // Catch: Throwable -> L12
                r11.writeString(r10);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L12
                int r13 = r12.readInt();     // Catch: Throwable -> L12
            L8:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r13 = Stub.getDefaultImpl().modifyNetName(r8, r10);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int setSocketOptByUid(int r8, int r10, int r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r12.writeInt(r8);     // Catch: Throwable -> L12
                r12.writeInt(r10);     // Catch: Throwable -> L12
                r12.writeInt(r11);     // Catch: Throwable -> L12
                if (this.mRemote.transact(8, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L12
                int r14 = r13.readInt();     // Catch: Throwable -> L12
            L8:
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r14 = Stub.getDefaultImpl().setSocketOptByUid(r8, r10, r11);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int switchNetByPid(int r8, int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r12.writeInt(r8);     // Catch: Throwable -> L12
                r12.writeInt(r10);     // Catch: Throwable -> L12
                r12.writeInt(r11 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L12
                int r14 = r13.readInt();     // Catch: Throwable -> L12
            L8:
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r14 = Stub.getDefaultImpl().switchNetByPid(r8, r10, r11);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int switchNetByUid(int r8, int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r12.writeInt(r8);     // Catch: Throwable -> L12
                r12.writeInt(r10);     // Catch: Throwable -> L12
                r12.writeInt(r11 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L12
                int r14 = r13.readInt();     // Catch: Throwable -> L12
            L8:
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r14 = Stub.getDefaultImpl().switchNetByUid(r8, r10, r11);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeMpflowManager asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeMpflowManager) == false) goto L12;
            return (ICaeMpflowManager) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeMpflowManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeMpflowManager r8) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r8 == null) goto L7;
            Proxy.sDefaultImpl = r8;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 == 1598968902) goto L36;
            boolean r13 = false;
            switch(r8) {
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
            r10.enforceInterface(DESCRIPTOR);
            int r14 = setSocketOptByUid(r10.readInt(), r10.readInt(), r10.readInt());
            r11.writeNoException();
            r11.writeInt(r14);
            return true;
        L10:
            r10.enforceInterface(DESCRIPTOR);
            disconnectSocketByPid(r10.readInt());
            return true;
        L12:
            r10.enforceInterface(DESCRIPTOR);
            disconnectSocketByUid(r10.readInt());
            return true;
        L14:
            r10.enforceInterface(DESCRIPTOR);
            int r15 = r10.readInt();
            int r16 = r10.readInt();
            if (r10.readInt() == 0) goto L17;
            r13 = true;
        L17:
            int r17 = bindNetByPid(r15, r16, r13);
            r11.writeNoException();
            r11.writeInt(r17);
            return true;
        L19:
            r10.enforceInterface(DESCRIPTOR);
            int r18 = r10.readInt();
            int r19 = r10.readInt();
            if (r10.readInt() == 0) goto L22;
            r13 = true;
        L22:
            int r20 = switchNetByPid(r18, r19, r13);
            r11.writeNoException();
            r11.writeInt(r20);
            return true;
        L24:
            r10.enforceInterface(DESCRIPTOR);
            int r21 = r10.readInt();
            int r22 = r10.readInt();
            if (r10.readInt() == 0) goto L27;
            r13 = true;
        L27:
            int r23 = bindNetByUid(r21, r22, r13);
            r11.writeNoException();
            r11.writeInt(r23);
            return true;
        L29:
            r10.enforceInterface(DESCRIPTOR);
            int r24 = r10.readInt();
            int r25 = r10.readInt();
            if (r10.readInt() == 0) goto L32;
            r13 = true;
        L32:
            int r26 = switchNetByUid(r24, r25, r13);
            r11.writeNoException();
            r11.writeInt(r26);
            return true;
        L34:
            r10.enforceInterface(DESCRIPTOR);
            int r27 = modifyNetName(r10.readInt(), r10.readString());
            r11.writeNoException();
            r11.writeInt(r27);
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        L36:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    int bindNetByPid(int r8, int r10, boolean r11);

    int bindNetByUid(int r8, int r10, boolean r11);

    void disconnectSocketByPid(int r8);

    void disconnectSocketByUid(int r8);

    int modifyNetName(int r8, String r10);

    int setSocketOptByUid(int r8, int r10, int r11);

    int switchNetByPid(int r8, int r10, boolean r11);

    int switchNetByUid(int r8, int r10, boolean r11);
}
