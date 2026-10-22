package com.obric.capabilitykit.entity.search.global;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.capabilitykit.common.UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface IGlobalSearchService extends IInterface {

    public static class Default implements IGlobalSearchService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
        public void cancel(String r1) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
        public void startGlobalSearch(String r1, GlobalSearchRequest r2, IGlobalSearchCallback r3) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IGlobalSearchService {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.entity.search.global.IGlobalSearchService";
        public static final int TRANSACTION_cancel = 2;
        public static final int TRANSACTION_startGlobalSearch = 1;

        public static class Proxy implements IGlobalSearchService {
            public static IGlobalSearchService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
            public void cancel(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().cancel(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
            public void startGlobalSearch(String r6, GlobalSearchRequest r7, IGlobalSearchCallback r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r6);     // Catch: Throwable -> L19
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L7:
                if (r8 == null) goto L9;
                IBinder r4 = r8.asBinder();     // Catch: Throwable -> L19
            L10:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L19
                if (INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L19
            L15:
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().startGlobalSearch(r6, r7, r8);     // Catch: Throwable -> L19
                goto L15
            L9:
                r4 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGlobalSearchService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IGlobalSearchService) == false) goto L12;
            return (IGlobalSearchService) r0;
        L12:
            return new Proxy(r2);
        }

        public static IGlobalSearchService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IGlobalSearchService r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
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
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            String r8 = r5.readString();
            if (r5.readInt() == 0) goto L16;
            GlobalSearchRequest.CREATOR.getClass();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            GlobalSearchRequest r9 = (GlobalSearchRequest) GsonProtectorUtils.fromJson(UtilsKt.a(), r5.readString(), GlobalSearchRequest.class);
        L17:
            startGlobalSearch(r8, r9, IGlobalSearchCallback.Stub.asInterface(r5.readStrongBinder()));
        L18:
            r6.writeNoException();
            return true;
        L16:
            r9 = null;
            goto L17
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            cancel(r5.readString());
            goto L18
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void cancel(String r1) throws RemoteException;

    void startGlobalSearch(String r1, GlobalSearchRequest r2, IGlobalSearchCallback r3) throws RemoteException;
}
