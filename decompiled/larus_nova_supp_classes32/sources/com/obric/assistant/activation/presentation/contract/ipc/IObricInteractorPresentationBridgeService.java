package com.obric.assistant.activation.presentation.contract.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface IObricInteractorPresentationBridgeService extends IInterface {

    public static class Default implements IObricInteractorPresentationBridgeService {
        public Default() {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
        public void acknowledgeChildSurfaceLinked(int r1) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
        public void acknowledgeGesture(int r1) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
        public void confirmListeningStarted() throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
        public void registerMain(IObricMainPresentationBridgeCallback r1) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
        public void releaseChildSurfaceLink(int r1) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
        public void unregisterMain(IObricMainPresentationBridgeCallback r1) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
        public void updateListeningState(ObricListeningPresentationState r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IObricInteractorPresentationBridgeService {
        private static final String DESCRIPTOR = "com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService";
        static final int TRANSACTION_acknowledgeChildSurfaceLinked = 6;
        static final int TRANSACTION_acknowledgeGesture = 3;
        static final int TRANSACTION_confirmListeningStarted = 4;
        static final int TRANSACTION_registerMain = 1;
        static final int TRANSACTION_releaseChildSurfaceLink = 7;
        static final int TRANSACTION_unregisterMain = 2;
        static final int TRANSACTION_updateListeningState = 5;

        public static class Proxy implements IObricInteractorPresentationBridgeService {
            public static IObricInteractorPresentationBridgeService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
            public void confirmListeningStarted() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().confirmListeningStarted();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
            public void acknowledgeChildSurfaceLinked(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().acknowledgeChildSurfaceLinked(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
            public void acknowledgeGesture(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().acknowledgeGesture(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
            public void registerMain(IObricMainPresentationBridgeCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerMain(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
            public void releaseChildSurfaceLink(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().releaseChildSurfaceLink(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
            public void unregisterMain(IObricMainPresentationBridgeCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterMain(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
            public void updateListeningState(ObricListeningPresentationState r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateListeningState(r6);     // Catch: Throwable -> L16
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
            public static boolean INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static IObricInteractorPresentationBridgeService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IObricInteractorPresentationBridgeService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IObricInteractorPresentationBridgeService) == false) goto L12;
            return (IObricInteractorPresentationBridgeService) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IObricInteractorPresentationBridgeService r1) {
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
            if (r4 == 1598968902) goto L25;
            switch(r4) {
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L19;
                case 4: goto L17;
                case 5: goto L11;
                case 6: goto L9;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface(DESCRIPTOR);
            releaseChildSurfaceLink(r5.readInt());
            return true;
        L9:
            r5.enforceInterface(DESCRIPTOR);
            acknowledgeChildSurfaceLinked(r5.readInt());
            return true;
        L11:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L14;
            ObricListeningPresentationState r8 = ObricListeningPresentationState.CREATOR.createFromParcel(r5);
        L15:
            updateListeningState(r8);
            return true;
        L14:
            r8 = null;
            goto L15
        L17:
            r5.enforceInterface(DESCRIPTOR);
            confirmListeningStarted();
            return true;
        L19:
            r5.enforceInterface(DESCRIPTOR);
            acknowledgeGesture(r5.readInt());
            return true;
        L21:
            r5.enforceInterface(DESCRIPTOR);
            unregisterMain(IObricMainPresentationBridgeCallback.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L23:
            r5.enforceInterface(DESCRIPTOR);
            registerMain(IObricMainPresentationBridgeCallback.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L25:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    void acknowledgeChildSurfaceLinked(int r1) throws RemoteException;

    void acknowledgeGesture(int r1) throws RemoteException;

    void confirmListeningStarted() throws RemoteException;

    void registerMain(IObricMainPresentationBridgeCallback r1) throws RemoteException;

    void releaseChildSurfaceLink(int r1) throws RemoteException;

    void unregisterMain(IObricMainPresentationBridgeCallback r1) throws RemoteException;

    void updateListeningState(ObricListeningPresentationState r1) throws RemoteException;
}
