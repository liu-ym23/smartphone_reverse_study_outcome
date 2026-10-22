package com.obric.memorydata.sdk.memory;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface IMemoryService extends IInterface {

    public static class Default implements IMemoryService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public boolean getDialogueMemoryEnableState() throws RemoteException {
            return false;
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public void registerMemoryCallback(IMemoryCallback r1) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public void saveAssistantChatMemory(String r1, String r2, Bundle r3) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public void syncAssistantChat(String r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMemoryService {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.memory.IMemoryService";
        static final int TRANSACTION_getDialogueMemoryEnableState = 3;
        static final int TRANSACTION_registerMemoryCallback = 1;
        static final int TRANSACTION_saveAssistantChatMemory = 2;
        static final int TRANSACTION_syncAssistantChat = 4;

        public static class Proxy implements IMemoryService {
            public static IMemoryService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.memorydata.sdk.memory.IMemoryService
            public boolean getDialogueMemoryEnableState() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_memory_IMemoryService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r4 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r2 = Stub.getDefaultImpl().getDialogueMemoryEnableState();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r2;
            L15:
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

            @Override // com.obric.memorydata.sdk.memory.IMemoryService
            public void registerMemoryCallback(IMemoryCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_memory_IMemoryService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerMemoryCallback(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.memorydata.sdk.memory.IMemoryService
            public void syncAssistantChat(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_memory_IMemoryService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().syncAssistantChat(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.memory.IMemoryService
            public void saveAssistantChatMemory(String r6, String r7, Bundle r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r6);     // Catch: Throwable -> L16
                r0.writeString(r7);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_memory_IMemoryService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().saveAssistantChatMemory(r6, r7, r8);     // Catch: Throwable -> L16
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
            public static boolean INVOKEINTERFACE_com_obric_memorydata_sdk_memory_IMemoryService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static IMemoryService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IMemoryService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IMemoryService) == false) goto L12;
            return (IMemoryService) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IMemoryService r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            registerMemoryCallback(IMemoryCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            String r8 = r5.readString();
            String r9 = r5.readString();
            if (r5.readInt() == 0) goto L23;
            Bundle r10 = (Bundle) Bundle.CREATOR.createFromParcel(r5);
        L24:
            saveAssistantChatMemory(r8, r9, r10);
            return true;
        L23:
            r10 = null;
            goto L24
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            boolean r11 = getDialogueMemoryEnableState();
            r6.writeNoException();
            r6.writeInt(r11 ? 1 : 0);
            return true;
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface(DESCRIPTOR);
            syncAssistantChat(r5.readString());
            return true;
        L11:
            if (r4 != 1598968902) goto L13;
            r6.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    boolean getDialogueMemoryEnableState() throws RemoteException;

    void registerMemoryCallback(IMemoryCallback r1) throws RemoteException;

    void saveAssistantChatMemory(String r1, String r2, Bundle r3) throws RemoteException;

    void syncAssistantChat(String r1) throws RemoteException;
}
