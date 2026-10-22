package com.obric.memorydata.sdk.awareness;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.memorydata.sdk.MemoryResponse;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IContextAwarenessService extends IInterface {

    public static abstract class Stub extends Binder implements IContextAwarenessService {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.awareness.IContextAwarenessService";
        static final int TRANSACTION_getFeature = 1;
        static final int TRANSACTION_getGeoFenceStatus = 9;
        static final int TRANSACTION_getLocation = 4;
        static final int TRANSACTION_registerEvent = 5;
        static final int TRANSACTION_registerFeature = 2;
        static final int TRANSACTION_registerFeatureDuration = 6;
        static final int TRANSACTION_setLocation = 8;
        static final int TRANSACTION_unregisterFeature = 3;
        static final int TRANSACTION_unregisterFeatureDuration = 7;

        public static class Proxy implements IContextAwarenessService {
            public static IContextAwarenessService sDefaultImpl;
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

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse getFeature(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r6);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L15
                MemoryResponse r7 = MemoryResponse.a.a(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L14:
                r7 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().getFeature(r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse getGeoFenceStatus(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r6);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L15
                MemoryResponse r7 = MemoryResponse.a.a(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L14:
                r7 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().getGeoFenceStatus(r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse getLocation(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r6);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L15
                MemoryResponse r7 = MemoryResponse.a.a(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L14:
                r7 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().getLocation(r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse registerEvent(String r7, IEventChangeListener r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r7);     // Catch: Throwable -> L19
                MemoryResponse r2 = null;
                if (r8 == null) goto L6;
                IBinder r3 = r8.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L19
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L19
                r2 = MemoryResponse.a.a(r1);     // Catch: Throwable -> L19
            L17:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                MemoryResponse r9 = Stub.getDefaultImpl().registerEvent(r7, r8);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                r3 = null;
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse registerFeature(String r7, IFeatureChangeListener r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r7);     // Catch: Throwable -> L19
                MemoryResponse r2 = null;
                if (r8 == null) goto L6;
                IBinder r3 = r8.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L19
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L19
                r2 = MemoryResponse.a.a(r1);     // Catch: Throwable -> L19
            L17:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                MemoryResponse r9 = Stub.getDefaultImpl().registerFeature(r7, r8);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                r3 = null;
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse unregisterFeature(String r7, IFeatureChangeListener r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r7);     // Catch: Throwable -> L19
                MemoryResponse r2 = null;
                if (r8 == null) goto L6;
                IBinder r3 = r8.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L19
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L19
                r2 = MemoryResponse.a.a(r1);     // Catch: Throwable -> L19
            L17:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                MemoryResponse r9 = Stub.getDefaultImpl().unregisterFeature(r7, r8);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                r3 = null;
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse registerFeatureDuration(String r12, String r13, long r14, boolean r16, IFeatureDurationListener r17) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L28
                r1.writeString(r12);     // Catch: Throwable -> L28
                r1.writeString(r13);     // Catch: Throwable -> L28
                r1.writeLong(r14);     // Catch: Throwable -> L28
                if (r16 == false) goto L6;
                int r4 = 1;
            L7:
                r1.writeInt(r4);     // Catch: Throwable -> L28
                MemoryResponse r5 = null;
                if (r17 == null) goto L10;
                IBinder r8 = r17.asBinder();     // Catch: Throwable -> L28
            L11:
                r1.writeStrongBinder(r8);     // Catch: Throwable -> L28
            L24:
                th = th;
            L30:
                r2.recycle();
                r1.recycle();
                throw th;
            L14:
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r1, r2, 0) == false) goto L16;
            L20:
                r2.readException();     // Catch: Throwable -> L24
                if (r2.readInt() == 0) goto L26;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L24
                r5 = MemoryResponse.a.a(r2);     // Catch: Throwable -> L24
            L26:
                r2.recycle();
                r1.recycle();
                return r5;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                MemoryResponse r0 = Stub.getDefaultImpl().registerFeatureDuration(r12, r13, r14, r16, r17);     // Catch: Throwable -> L24
                r2.recycle();
                r1.recycle();
                return r0;
            L10:
                r8 = null;
                goto L11
            L6:
                r4 = 0;
            L28:
                th = th;
                goto L30
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse setLocation(String r14, double r15, double r17, String r19, String r20) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r1.writeString(r14);     // Catch: Throwable -> L19
                r1.writeDouble(r15);     // Catch: Throwable -> L19
                r1.writeDouble(r17);     // Catch: Throwable -> L19
                r1.writeString(r19);     // Catch: Throwable -> L19
                r1.writeString(r20);     // Catch: Throwable -> L19
            L16:
                th = th;
            L21:
                r2.recycle();
                r1.recycle();
                throw th;
            L6:
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r1, r2, 0) == false) goto L8;
            L12:
                r2.readException();     // Catch: Throwable -> L16
                if (r2.readInt() == 0) goto L18;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L16
                MemoryResponse r0 = MemoryResponse.a.a(r2);     // Catch: Throwable -> L16
            L10:
                r2.recycle();
                r1.recycle();
                return r0;
            L18:
                r0 = null;
                goto L10
            L8:
                if (Stub.getDefaultImpl() == null) goto L12;
                r0 = Stub.getDefaultImpl().setLocation(r14, r15, r17, r19, r20);     // Catch: Throwable -> L16
            L19:
                th = th;
                goto L21
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse unregisterFeatureDuration(String r12, String r13, long r14, boolean r16, IFeatureDurationListener r17) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L28
                r1.writeString(r12);     // Catch: Throwable -> L28
                r1.writeString(r13);     // Catch: Throwable -> L28
                r1.writeLong(r14);     // Catch: Throwable -> L28
                if (r16 == false) goto L6;
                int r4 = 1;
            L7:
                r1.writeInt(r4);     // Catch: Throwable -> L28
                MemoryResponse r5 = null;
                if (r17 == null) goto L10;
                IBinder r8 = r17.asBinder();     // Catch: Throwable -> L28
            L11:
                r1.writeStrongBinder(r8);     // Catch: Throwable -> L28
            L24:
                th = th;
            L30:
                r2.recycle();
                r1.recycle();
                throw th;
            L14:
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r1, r2, 0) == false) goto L16;
            L20:
                r2.readException();     // Catch: Throwable -> L24
                if (r2.readInt() == 0) goto L26;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L24
                r5 = MemoryResponse.a.a(r2);     // Catch: Throwable -> L24
            L26:
                r2.recycle();
                r1.recycle();
                return r5;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                MemoryResponse r0 = Stub.getDefaultImpl().unregisterFeatureDuration(r12, r13, r14, r16, r17);     // Catch: Throwable -> L24
                r2.recycle();
                r1.recycle();
                return r0;
            L10:
                r8 = null;
                goto L11
            L6:
                r4 = 0;
            L28:
                th = th;
                goto L30
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IContextAwarenessService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IContextAwarenessService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IContextAwarenessService) == false) goto L12;
            return (IContextAwarenessService) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IContextAwarenessService r1) {
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
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) throws RemoteException {
            if (r11 != 1598968902) goto L5;
            r13.writeString(DESCRIPTOR);
            return true;
        L5:
            switch(r11) {
                case 1: goto L56;
                case 2: goto L51;
                case 3: goto L46;
                case 4: goto L41;
                case 5: goto L36;
                case 6: goto L27;
                case 7: goto L18;
                case 8: goto L13;
                case 9: goto L8;
                default: goto L7;
            };
        L8:
            r12.enforceInterface(DESCRIPTOR);
            MemoryResponse r15 = getGeoFenceStatus(r12.readString());
            r13.writeNoException();
            if (r15 == null) goto L11;
            r13.writeInt(1);
            r15.writeToParcel(r13, 1);
        L12:
            return true;
        L11:
            r13.writeInt(0);
            goto L12
        L13:
            r12.enforceInterface(DESCRIPTOR);
            MemoryResponse r16 = setLocation(r12.readString(), r12.readDouble(), r12.readDouble(), r12.readString(), r12.readString());
            r13.writeNoException();
            if (r16 == null) goto L16;
            r13.writeInt(1);
            r16.writeToParcel(r13, 1);
        L17:
            return true;
        L16:
            r13.writeInt(0);
            goto L17
        L18:
            r12.enforceInterface(DESCRIPTOR);
            String r3 = r12.readString();
            String r4 = r12.readString();
            long r5 = r12.readLong();
            if (r12.readInt() == 0) goto L21;
            boolean r7 = true;
        L22:
            MemoryResponse r17 = unregisterFeatureDuration(r3, r4, r5, r7, IFeatureDurationListener.Stub.asInterface(r12.readStrongBinder()));
            r13.writeNoException();
            if (r17 == null) goto L25;
            r13.writeInt(1);
            r17.writeToParcel(r13, 1);
        L26:
            return true;
        L25:
            r13.writeInt(0);
            goto L26
        L21:
            r7 = false;
            goto L22
        L27:
            r12.enforceInterface(DESCRIPTOR);
            String r6 = r12.readString();
            String r8 = r12.readString();
            long r9 = r12.readLong();
            if (r12.readInt() == 0) goto L30;
            boolean r10 = true;
        L31:
            MemoryResponse r18 = registerFeatureDuration(r6, r8, r9, r10, IFeatureDurationListener.Stub.asInterface(r12.readStrongBinder()));
            r13.writeNoException();
            if (r18 == null) goto L34;
            r13.writeInt(1);
            r18.writeToParcel(r13, 1);
        L35:
            return true;
        L34:
            r13.writeInt(0);
            goto L35
        L30:
            r10 = false;
            goto L31
        L36:
            r12.enforceInterface(DESCRIPTOR);
            MemoryResponse r19 = registerEvent(r12.readString(), IEventChangeListener.Stub.asInterface(r12.readStrongBinder()));
            r13.writeNoException();
            if (r19 == null) goto L39;
            r13.writeInt(1);
            r19.writeToParcel(r13, 1);
        L40:
            return true;
        L39:
            r13.writeInt(0);
            goto L40
        L41:
            r12.enforceInterface(DESCRIPTOR);
            MemoryResponse r110 = getLocation(r12.readString());
            r13.writeNoException();
            if (r110 == null) goto L44;
            r13.writeInt(1);
            r110.writeToParcel(r13, 1);
        L45:
            return true;
        L44:
            r13.writeInt(0);
            goto L45
        L46:
            r12.enforceInterface(DESCRIPTOR);
            MemoryResponse r111 = unregisterFeature(r12.readString(), IFeatureChangeListener.Stub.asInterface(r12.readStrongBinder()));
            r13.writeNoException();
            if (r111 == null) goto L49;
            r13.writeInt(1);
            r111.writeToParcel(r13, 1);
        L50:
            return true;
        L49:
            r13.writeInt(0);
            goto L50
        L51:
            r12.enforceInterface(DESCRIPTOR);
            MemoryResponse r112 = registerFeature(r12.readString(), IFeatureChangeListener.Stub.asInterface(r12.readStrongBinder()));
            r13.writeNoException();
            if (r112 == null) goto L54;
            r13.writeInt(1);
            r112.writeToParcel(r13, 1);
        L55:
            return true;
        L54:
            r13.writeInt(0);
            goto L55
        L56:
            r12.enforceInterface(DESCRIPTOR);
            MemoryResponse r113 = getFeature(r12.readString());
            r13.writeNoException();
            if (r113 == null) goto L59;
            r13.writeInt(1);
            r113.writeToParcel(r13, 1);
        L60:
            return true;
        L59:
            r13.writeInt(0);
            goto L60
        L7:
            return super.onTransact(r11, r12, r13, r14);
        }
    }

    MemoryResponse getFeature(String r1) throws RemoteException;

    MemoryResponse getGeoFenceStatus(String r1) throws RemoteException;

    MemoryResponse getLocation(String r1) throws RemoteException;

    MemoryResponse registerEvent(String r1, IEventChangeListener r2) throws RemoteException;

    MemoryResponse registerFeature(String r1, IFeatureChangeListener r2) throws RemoteException;

    MemoryResponse registerFeatureDuration(String r1, String r2, long r3, boolean r5, IFeatureDurationListener r6) throws RemoteException;

    MemoryResponse setLocation(String r1, double r2, double r4, String r6, String r7) throws RemoteException;

    MemoryResponse unregisterFeature(String r1, IFeatureChangeListener r2) throws RemoteException;

    MemoryResponse unregisterFeatureDuration(String r1, String r2, long r3, boolean r5, IFeatureDurationListener r6) throws RemoteException;
}
