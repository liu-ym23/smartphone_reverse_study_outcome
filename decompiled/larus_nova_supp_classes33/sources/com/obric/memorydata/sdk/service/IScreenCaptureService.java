package com.obric.memorydata.sdk.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.memorydata.sdk.screencapture.ICaptureCurrentCallback;
import com.obric.memorydata.sdk.screencapture.IEventReactionCallback;
import com.obric.memorydata.sdk.screencapture.ScreenEventReaction;
import com.obric.memorydata.sdk.screencapture.TaskOptions;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface IScreenCaptureService extends IInterface {

    public static class Default implements IScreenCaptureService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
        public void captureCurrent(TaskOptions r1, String r2, ICaptureCurrentCallback r3) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
        public int getScreenEventReactionCount() throws RemoteException {
            return 0;
        }

        @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
        public void register(ScreenEventReaction r1, long r2, IEventReactionCallback r4) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
        public void unregister(String r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IScreenCaptureService {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.service.IScreenCaptureService";
        static final int TRANSACTION_captureCurrent = 4;
        static final int TRANSACTION_getScreenEventReactionCount = 3;
        static final int TRANSACTION_register = 1;
        static final int TRANSACTION_unregister = 2;

        public static class Proxy implements IScreenCaptureService {
            public static IScreenCaptureService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
            public int getScreenEventReactionCount() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_service_IScreenCaptureService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r2 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r3 = Stub.getDefaultImpl().getScreenEventReactionCount();     // Catch: Throwable -> L13
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

            @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
            public void unregister(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_service_IScreenCaptureService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregister(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
            public void captureCurrent(TaskOptions r6, String r7, ICaptureCurrentCallback r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L7:
                r0.writeString(r7);     // Catch: Throwable -> L21
                if (r8 == null) goto L10;
                IBinder r3 = r8.asBinder();     // Catch: Throwable -> L21
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_service_IScreenCaptureService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().captureCurrent(r6, r7, r8);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
            public void register(ScreenEventReaction r6, long r7, IEventReactionCallback r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L7:
                r0.writeLong(r7);     // Catch: Throwable -> L21
                if (r9 == null) goto L10;
                IBinder r4 = r9.asBinder();     // Catch: Throwable -> L21
            L11:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_service_IScreenCaptureService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().register(r6, r7, r9);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r4 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_memorydata_sdk_service_IScreenCaptureService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static IScreenCaptureService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IScreenCaptureService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IScreenCaptureService) == false) goto L12;
            return (IScreenCaptureService) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IScreenCaptureService r1) {
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
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            TaskOptions r0 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L28;
            r0 = (ScreenEventReaction) ScreenEventReaction.CREATOR.createFromParcel(r6);
        L28:
            register(r0, r6.readLong(), IEventReactionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            unregister(r6.readString());
            r7.writeNoException();
            return true;
        L7:
            if (r5 != 3) goto L9;
            r6.enforceInterface(DESCRIPTOR);
            int r9 = getScreenEventReactionCount();
            r7.writeNoException();
            r7.writeInt(r9);
            return true;
        L9:
            if (r5 != 4) goto L11;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L19;
            r0 = (TaskOptions) TaskOptions.CREATOR.createFromParcel(r6);
        L19:
            captureCurrent(r0, r6.readString(), ICaptureCurrentCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L11:
            if (r5 != 1598968902) goto L13;
            r7.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    void captureCurrent(TaskOptions r1, String r2, ICaptureCurrentCallback r3) throws RemoteException;

    int getScreenEventReactionCount() throws RemoteException;

    void register(ScreenEventReaction r1, long r2, IEventReactionCallback r4) throws RemoteException;

    void unregister(String r1) throws RemoteException;
}
