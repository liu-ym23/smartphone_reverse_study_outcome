package com.obric.memorydata.sdk.assistant;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface IAssistantStateService extends IInterface {

    public static class Default implements IAssistantStateService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.assistant.IAssistantStateService
        public void onActive() throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.assistant.IAssistantStateService
        public void onQuery(QueryContext r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAssistantStateService {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.assistant.IAssistantStateService";
        static final int TRANSACTION_onActive = 2;
        static final int TRANSACTION_onQuery = 1;

        public static class Proxy implements IAssistantStateService {
            public static IAssistantStateService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.memorydata.sdk.assistant.IAssistantStateService
            public void onActive() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_assistant_IAssistantStateService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onActive();     // Catch: Throwable -> L12
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

            @Override // com.obric.memorydata.sdk.assistant.IAssistantStateService
            public void onQuery(QueryContext r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_assistant_IAssistantStateService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onQuery(r5);     // Catch: Throwable -> L16
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
            public static boolean INVOKEINTERFACE_com_obric_memorydata_sdk_assistant_IAssistantStateService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static IAssistantStateService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAssistantStateService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAssistantStateService) == false) goto L12;
            return (IAssistantStateService) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IAssistantStateService r1) {
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
            if (r5.readInt() == 0) goto L21;
            QueryContext.CREATOR.getClass();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            int r8 = r5.readInt();
            if (r5.dataAvail() <= 0) goto L19;
            int r9 = r5.readInt();
        L20:
            QueryContext r10 = new QueryContext(r8, r9);
        L22:
            onQuery(r10);
            return true;
        L19:
            r9 = 0;
            goto L20
        L21:
            r10 = null;
            goto L22
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            onActive();
            return true;
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onActive() throws RemoteException;

    void onQuery(QueryContext r1) throws RemoteException;
}
