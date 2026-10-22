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
import com.obric.capabilitykit.entity.EntityExtKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface IGlobalSearchCallback extends IInterface {

    public static class Default implements IGlobalSearchCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
        public void onAllCompleted() throws RemoteException {
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
        public void onCompleted(int r1) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
        public void onError(int r1, int r2, String r3) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
        public void onSearchResult(GlobalSearchResult r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IGlobalSearchCallback {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback";
        public static final int TRANSACTION_onAllCompleted = 3;
        public static final int TRANSACTION_onCompleted = 2;
        public static final int TRANSACTION_onError = 4;
        public static final int TRANSACTION_onSearchResult = 1;

        public static class Proxy implements IGlobalSearchCallback {
            public static IGlobalSearchCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onAllCompleted() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAllCompleted();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onCompleted(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onCompleted(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onError(int r6, int r7, String r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                r0.writeInt(r7);     // Catch: Throwable -> L12
                r0.writeString(r8);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onError(r6, r7, r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onSearchResult(GlobalSearchResult r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onSearchResult(r6);     // Catch: Throwable -> L16
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static IGlobalSearchCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IGlobalSearchCallback) == false) goto L12;
            return (IGlobalSearchCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static IGlobalSearchCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IGlobalSearchCallback r1) {
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
            if (r4 == 1598968902) goto L23;
            if (r4 != 1) goto L6;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L19;
            GlobalSearchResult.CREATOR.getClass();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            GlobalSearchResult r8 = (GlobalSearchResult) GsonProtectorUtils.fromJson(EntityExtKt.a(), r5.readString(), GlobalSearchResult.class);
        L20:
            onSearchResult(r8);
        L21:
            r6.writeNoException();
            return true;
        L19:
            r8 = null;
            goto L20
        L6:
            if (r4 != 2) goto L8;
            r5.enforceInterface(DESCRIPTOR);
            onCompleted(r5.readInt());
            goto L21
        L8:
            if (r4 != 3) goto L10;
            r5.enforceInterface(DESCRIPTOR);
            onAllCompleted();
            goto L21
        L10:
            if (r4 != 4) goto L12;
            r5.enforceInterface(DESCRIPTOR);
            onError(r5.readInt(), r5.readInt(), r5.readString());
            goto L21
        L12:
            return super.onTransact(r4, r5, r6, r7);
        L23:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onAllCompleted() throws RemoteException;

    void onCompleted(int r1) throws RemoteException;

    void onError(int r1, int r2, String r3) throws RemoteException;

    void onSearchResult(GlobalSearchResult r1) throws RemoteException;
}
