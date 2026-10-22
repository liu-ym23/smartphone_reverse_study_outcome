package com.obric.livecard.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IIslandStatusCallback extends IInterface {

    public static class Default implements IIslandStatusCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.livecard.api.IIslandStatusCallback
        public long getId() {
            return 0;
        }

        @Override // com.obric.livecard.api.IIslandStatusCallback
        public void keepAliveOnAOD(boolean r1) {
        }

        @Override // com.obric.livecard.api.IIslandStatusCallback
        public void onIslandDialogueMode(boolean r1) {
        }

        @Override // com.obric.livecard.api.IIslandStatusCallback
        public void onIslandExpand() {
        }

        @Override // com.obric.livecard.api.IIslandStatusCallback
        public void onIslandSessionChanged(int r1, int r2) {
        }

        @Override // com.obric.livecard.api.IIslandStatusCallback
        public void onIslandStartActivity() {
        }

        @Override // com.obric.livecard.api.IIslandStatusCallback
        public void onIslandWidthChange(int r1) {
        }
    }

    public static abstract class Stub extends Binder implements IIslandStatusCallback {
        private static final String DESCRIPTOR = "com.obric.livecard.api.IIslandStatusCallback";
        static final int TRANSACTION_getId = 2;
        static final int TRANSACTION_keepAliveOnAOD = 3;
        static final int TRANSACTION_onIslandDialogueMode = 6;
        static final int TRANSACTION_onIslandExpand = 1;
        static final int TRANSACTION_onIslandSessionChanged = 7;
        static final int TRANSACTION_onIslandStartActivity = 4;
        static final int TRANSACTION_onIslandWidthChange = 5;

        private static class Proxy implements IIslandStatusCallback {
            public static IIslandStatusCallback sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.livecard.api.IIslandStatusCallback
            public long getId() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                long r2 = r1.readLong();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long r3 = Stub.getDefaultImpl().getId();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.livecard.api.IIslandStatusCallback
            public void keepAliveOnAOD(boolean r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().keepAliveOnAOD(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.livecard.api.IIslandStatusCallback
            public void onIslandDialogueMode(boolean r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onIslandDialogueMode(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.livecard.api.IIslandStatusCallback
            public void onIslandExpand() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onIslandExpand();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandStatusCallback
            public void onIslandSessionChanged(int r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onIslandSessionChanged(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandStatusCallback
            public void onIslandStartActivity() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onIslandStartActivity();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandStatusCallback
            public void onIslandWidthChange(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onIslandWidthChange(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IIslandStatusCallback asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IIslandStatusCallback.class) == false) goto L13;
            return (IIslandStatusCallback) ZeusTransformUtils.preCheckCast(r0, IIslandStatusCallback.class, "com.obric.memorydata.plugin");
        L13:
            return new Proxy(r4);
        }

        public static IIslandStatusCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IIslandStatusCallback r2) {
            IIslandStatusCallback r3 = (IIslandStatusCallback) ZeusTransformUtils.wrapperContextForParams(r2, IIslandStatusCallback.class, "com.obric.memorydata.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L28;
            boolean r0 = false;
            switch(r4) {
                case 1: goto L26;
                case 2: goto L24;
                case 3: goto L19;
                case 4: goto L17;
                case 5: goto L15;
                case 6: goto L10;
                case 7: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            onIslandSessionChanged(r5.readInt(), r5.readInt());
            r6.writeNoException();
            return true;
        L10:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L13;
            r0 = true;
        L13:
            onIslandDialogueMode(r0);
            r6.writeNoException();
            return true;
        L15:
            r5.enforceInterface(DESCRIPTOR);
            onIslandWidthChange(r5.readInt());
            r6.writeNoException();
            return true;
        L17:
            r5.enforceInterface(DESCRIPTOR);
            onIslandStartActivity();
            r6.writeNoException();
            return true;
        L19:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L22;
            r0 = true;
        L22:
            keepAliveOnAOD(r0);
            r6.writeNoException();
            return true;
        L24:
            r5.enforceInterface(DESCRIPTOR);
            long r3 = getId();
            r6.writeNoException();
            r6.writeLong(r3);
            return true;
        L26:
            r5.enforceInterface(DESCRIPTOR);
            onIslandExpand();
            r6.writeNoException();
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L28:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    long getId();

    void keepAliveOnAOD(boolean r1);

    void onIslandDialogueMode(boolean r1);

    void onIslandExpand();

    void onIslandSessionChanged(int r1, int r2);

    void onIslandStartActivity();

    void onIslandWidthChange(int r1);
}
