package com.obric.assistant.activation.presentation.contract.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface IObricInteractorBridgeService extends IInterface {

    public static class Default implements IObricInteractorBridgeService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
        public IInteractionSessionProxy getInteractionSessionProxy() throws RemoteException {
            return null;
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
        public void registerPresentationBridge(IBinder r1) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
        public void unregisterPresentationBridge(IBinder r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IObricInteractorBridgeService {
        private static final String DESCRIPTOR = "com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService";
        static final int TRANSACTION_getInteractionSessionProxy = 1;
        static final int TRANSACTION_registerPresentationBridge = 2;
        static final int TRANSACTION_unregisterPresentationBridge = 3;

        public static class Proxy implements IObricInteractorBridgeService {
            public static IObricInteractorBridgeService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
            public IInteractionSessionProxy getInteractionSessionProxy() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IInteractionSessionProxy r2 = IInteractionSessionProxy.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IInteractionSessionProxy r3 = Stub.getDefaultImpl().getInteractionSessionProxy();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
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

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
            public void registerPresentationBridge(IBinder r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().registerPresentationBridge(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
            public void unregisterPresentationBridge(IBinder r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterPresentationBridge(r6);     // Catch: Throwable -> L13
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
            public static boolean INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static IObricInteractorBridgeService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IObricInteractorBridgeService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IObricInteractorBridgeService) == false) goto L12;
            return (IObricInteractorBridgeService) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IObricInteractorBridgeService r1) {
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
            IInteractionSessionProxy r8 = getInteractionSessionProxy();
            r6.writeNoException();
            if (r8 == null) goto L21;
            IBinder r9 = r8.asBinder();
        L22:
            r6.writeStrongBinder(r9);
            return true;
        L21:
            r9 = null;
            goto L22
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            registerPresentationBridge(r5.readStrongBinder());
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            unregisterPresentationBridge(r5.readStrongBinder());
            r6.writeNoException();
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    IInteractionSessionProxy getInteractionSessionProxy() throws RemoteException;

    void registerPresentationBridge(IBinder r1) throws RemoteException;

    void unregisterPresentationBridge(IBinder r1) throws RemoteException;
}
