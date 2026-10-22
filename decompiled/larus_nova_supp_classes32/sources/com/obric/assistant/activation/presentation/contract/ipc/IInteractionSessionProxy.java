package com.obric.assistant.activation.presentation.contract.ipc;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
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
public interface IInteractionSessionProxy extends IInterface {

    public static class Default implements IInteractionSessionProxy {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
        public void onHandleAssist(long r1, int r3, int r4, boolean r5, Bundle r6, AssistStructure r7, AssistContent r8) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
        public void onHandleScreenshot(long r1, Bitmap r3) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
        public void onSessionCreated(long r1, VoiceInteractionSessionController r3) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
        public void onSessionDestroyed(long r1) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
        public void onShow(long r1, Bundle r3, int r4) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IInteractionSessionProxy {
        private static final String DESCRIPTOR = "com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy";
        static final int TRANSACTION_onHandleAssist = 2;
        static final int TRANSACTION_onHandleScreenshot = 3;
        static final int TRANSACTION_onSessionCreated = 1;
        static final int TRANSACTION_onSessionDestroyed = 5;
        static final int TRANSACTION_onShow = 4;

        public static class Proxy implements IInteractionSessionProxy {
            public static IInteractionSessionProxy sDefaultImpl;
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

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
            public void onSessionDestroyed(long r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeLong(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IInteractionSessionProxy$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSessionDestroyed(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
            public void onHandleScreenshot(long r6, Bitmap r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeLong(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r8.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IInteractionSessionProxy$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onHandleScreenshot(r6, r8);     // Catch: Throwable -> L17
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

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
            public void onSessionCreated(long r6, VoiceInteractionSessionController r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeLong(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IInteractionSessionProxy$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onSessionCreated(r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
            public void onShow(long r6, Bundle r8, int r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeLong(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r8.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L7:
                r0.writeInt(r9);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IInteractionSessionProxy$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onShow(r6, r8, r9);     // Catch: Throwable -> L17
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
            public static boolean INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IInteractionSessionProxy$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
            public void onHandleAssist(long r14, int r16, int r17, boolean r18, Bundle r19, AssistStructure r20, AssistContent r21) throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L30
                r10.writeLong(r14);     // Catch: Throwable -> L30
                r10.writeInt(r16);     // Catch: Throwable -> L30
                r10.writeInt(r17);     // Catch: Throwable -> L30
                if (r18 == false) goto L6;
                int r7 = 1;
            L7:
                r10.writeInt(r7);     // Catch: Throwable -> L30
                if (r19 == null) goto L10;
                r10.writeInt(1);     // Catch: Throwable -> L30
                r19.writeToParcel(r10, 0);     // Catch: Throwable -> L30
            L11:
                if (r20 == null) goto L13;
                r10.writeInt(1);     // Catch: Throwable -> L30
                r20.writeToParcel(r10, 0);     // Catch: Throwable -> L30
            L14:
                if (r21 == null) goto L16;
                r10.writeInt(1);     // Catch: Throwable -> L30
                r21.writeToParcel(r10, 0);     // Catch: Throwable -> L30
            L34:
            L28:
                th = th;
            L32:
                r11.recycle();
                r10.recycle();
                throw th;
            L19:
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IInteractionSessionProxy$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r10, r11, 0) == false) goto L21;
            L25:
                r11.readException();     // Catch: Throwable -> L28
                r11.recycle();
                r10.recycle();
                return;
            L21:
                if (Stub.getDefaultImpl() == null) goto L25;
                Stub.getDefaultImpl().onHandleAssist(r14, r16, r17, r18, r19, r20, r21);     // Catch: Throwable -> L28
                r11.recycle();
                r10.recycle();
                return;
            L16:
                r10.writeInt(0);     // Catch: Throwable -> L30
                goto L34
            L13:
                r10.writeInt(0);     // Catch: Throwable -> L30
                goto L14
            L10:
                r10.writeInt(0);     // Catch: Throwable -> L30
                goto L11
            L6:
                r7 = 0;
            L30:
                th = th;
                goto L32
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IInteractionSessionProxy getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IInteractionSessionProxy asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IInteractionSessionProxy) == false) goto L12;
            return (IInteractionSessionProxy) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IInteractionSessionProxy r1) {
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
        public boolean onTransact(int r15, Parcel r16, Parcel r17, int r18) throws RemoteException {
            if (r15 == 1) goto L48;
            Bitmap r4 = null;
            Bundle r5 = null;
            if (r15 != 2) goto L7;
            r16.enforceInterface(DESCRIPTOR);
            long r2 = r16.readLong();
            int r6 = r16.readInt();
            int r7 = r16.readInt();
            if (r16.readInt() == 0) goto L33;
            boolean r8 = true;
        L35:
            if (r16.readInt() == 0) goto L37;
            Bundle r9 = (Bundle) Bundle.CREATOR.createFromParcel(r16);
        L39:
            if (r16.readInt() == 0) goto L41;
            AssistStructure r12 = (AssistStructure) AssistStructure.CREATOR.createFromParcel(r16);
        L43:
            if (r16.readInt() == 0) goto L45;
            AssistContent r13 = (AssistContent) AssistContent.CREATOR.createFromParcel(r16);
        L46:
            onHandleAssist(r2, r6, r7, r8, r9, r12, r13);
            r17.writeNoException();
            return true;
        L45:
            r13 = null;
            goto L46
        L41:
            r12 = null;
            goto L43
        L37:
            r9 = null;
            goto L39
        L33:
            r8 = false;
            goto L35
        L7:
            if (r15 != 3) goto L9;
            r16.enforceInterface(DESCRIPTOR);
            long r3 = r16.readLong();
            if (r16.readInt() == 0) goto L28;
            r4 = (Bitmap) Bitmap.CREATOR.createFromParcel(r16);
        L28:
            onHandleScreenshot(r3, r4);
            r17.writeNoException();
            return true;
        L9:
            if (r15 != 4) goto L11;
            r16.enforceInterface(DESCRIPTOR);
            long r10 = r16.readLong();
            if (r16.readInt() == 0) goto L23;
            r5 = (Bundle) Bundle.CREATOR.createFromParcel(r16);
        L23:
            onShow(r10, r5, r16.readInt());
            r17.writeNoException();
            return true;
        L11:
            if (r15 != 5) goto L13;
            r16.enforceInterface(DESCRIPTOR);
            onSessionDestroyed(r16.readLong());
            r17.writeNoException();
            return true;
        L13:
            if (r15 != 1598968902) goto L15;
            r17.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r15, r16, r17, r18);
        L48:
            r16.enforceInterface(DESCRIPTOR);
            onSessionCreated(r16.readLong(), VoiceInteractionSessionController.Stub.asInterface(r16.readStrongBinder()));
            r17.writeNoException();
            return true;
        }
    }

    void onHandleAssist(long r1, int r3, int r4, boolean r5, Bundle r6, AssistStructure r7, AssistContent r8) throws RemoteException;

    void onHandleScreenshot(long r1, Bitmap r3) throws RemoteException;

    void onSessionCreated(long r1, VoiceInteractionSessionController r3) throws RemoteException;

    void onSessionDestroyed(long r1) throws RemoteException;

    void onShow(long r1, Bundle r3, int r4) throws RemoteException;
}
