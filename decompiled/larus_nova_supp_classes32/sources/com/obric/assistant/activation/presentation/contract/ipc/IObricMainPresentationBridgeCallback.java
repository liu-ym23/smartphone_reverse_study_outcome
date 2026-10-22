package com.obric.assistant.activation.presentation.contract.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.SurfaceControl;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface IObricMainPresentationBridgeCallback extends IInterface {

    public static class Default implements IObricMainPresentationBridgeCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
        public void onChildFirstFrameReady(int r1, String r2, long r3) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
        public void onChildPresentationTimeout(long r1) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
        public void onChildSurfaceChanged(int r1, int r2, int r3, SurfaceControl r4) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
        public void onChildSurfaceDestroyed(int r1) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
        public void onFallbackStateChanged(boolean r1, ObricListeningPresentationState r2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IObricMainPresentationBridgeCallback {
        private static final String DESCRIPTOR = "com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback";
        static final int TRANSACTION_onChildFirstFrameReady = 4;
        static final int TRANSACTION_onChildPresentationTimeout = 5;
        static final int TRANSACTION_onChildSurfaceChanged = 2;
        static final int TRANSACTION_onChildSurfaceDestroyed = 3;
        static final int TRANSACTION_onFallbackStateChanged = 1;

        public static class Proxy implements IObricMainPresentationBridgeCallback {
            public static IObricMainPresentationBridgeCallback sDefaultImpl;
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

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
            public void onChildPresentationTimeout(long r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricMainPresentationBridgeCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onChildPresentationTimeout(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
            public void onChildSurfaceDestroyed(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricMainPresentationBridgeCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onChildSurfaceDestroyed(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
            public void onFallbackStateChanged(boolean r5, ObricListeningPresentationState r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L20
                if (r6 == null) goto L10;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L12:
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricMainPresentationBridgeCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().onFallbackStateChanged(r5, r6);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L12
            L6:
                r3 = 0;
            L20:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
            public void onChildFirstFrameReady(int r6, String r7, long r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                r0.writeLong(r8);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricMainPresentationBridgeCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onChildFirstFrameReady(r6, r7, r8);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
            public void onChildSurfaceChanged(int r6, int r7, int r8, SurfaceControl r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r6);     // Catch: Throwable -> L16
                r0.writeInt(r7);     // Catch: Throwable -> L16
                r0.writeInt(r8);     // Catch: Throwable -> L16
                if (r9 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r9.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricMainPresentationBridgeCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onChildSurfaceChanged(r6, r7, r8, r9);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricMainPresentationBridgeCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
                String r1 = NameKeys.UnloadStrategy_No_Strategy;
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

        public static IObricMainPresentationBridgeCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IObricMainPresentationBridgeCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IObricMainPresentationBridgeCallback) == false) goto L12;
            return (IObricMainPresentationBridgeCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IObricMainPresentationBridgeCallback r1) {
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
            ObricListeningPresentationState r0 = null;
            SurfaceControl r1 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L32;
            boolean r9 = true;
        L34:
            if (r6.readInt() == 0) goto L36;
            r0 = ObricListeningPresentationState.CREATOR.createFromParcel(r6);
        L36:
            onFallbackStateChanged(r9, r0);
            return true;
        L32:
            r9 = false;
            goto L34
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            int r10 = r6.readInt();
            int r11 = r6.readInt();
            int r12 = r6.readInt();
            if (r6.readInt() == 0) goto L27;
            r1 = (SurfaceControl) SurfaceControl.CREATOR.createFromParcel(r6);
        L27:
            onChildSurfaceChanged(r10, r11, r12, r1);
            return true;
        L7:
            if (r5 != 3) goto L9;
            r6.enforceInterface(DESCRIPTOR);
            onChildSurfaceDestroyed(r6.readInt());
            return true;
        L9:
            if (r5 != 4) goto L11;
            r6.enforceInterface(DESCRIPTOR);
            onChildFirstFrameReady(r6.readInt(), r6.readString(), r6.readLong());
            return true;
        L11:
            if (r5 != 5) goto L13;
            r6.enforceInterface(DESCRIPTOR);
            onChildPresentationTimeout(r6.readLong());
            return true;
        L13:
            if (r5 != 1598968902) goto L15;
            r7.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    void onChildFirstFrameReady(int r1, String r2, long r3) throws RemoteException;

    void onChildPresentationTimeout(long r1) throws RemoteException;

    void onChildSurfaceChanged(int r1, int r2, int r3, SurfaceControl r4) throws RemoteException;

    void onChildSurfaceDestroyed(int r1) throws RemoteException;

    void onFallbackStateChanged(boolean r1, ObricListeningPresentationState r2) throws RemoteException;
}
