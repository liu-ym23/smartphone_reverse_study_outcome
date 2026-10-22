package com.obric.memorydata.sdk.realtime;

import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface IRealTimeContextService extends IInterface {

    public static class Default implements IRealTimeContextService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public void onHandleAssist(AssistStructure r1, List<AppEntity> r2) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public void onHandleAssistWithCallback(AssistStructure r1, List<AppEntity> r2, IRealTimeContextCallback r3) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public void onHandleScreenshot(Bitmap r1) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public RealTimeContextResult queryRealTimeContext(String r1, String r2, String r3) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IRealTimeContextService {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.realtime.IRealTimeContextService";
        static final int TRANSACTION_onHandleAssist = 1;
        static final int TRANSACTION_onHandleAssistWithCallback = 4;
        static final int TRANSACTION_onHandleScreenshot = 2;
        static final int TRANSACTION_queryRealTimeContext = 3;

        public static class Proxy implements IRealTimeContextService {
            public static IRealTimeContextService sDefaultImpl;
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

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
            public void onHandleScreenshot(Bitmap r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onHandleScreenshot(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
            public void onHandleAssist(AssistStructure r5, List<AppEntity> r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeTypedList(r6);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onHandleAssist(r5, r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
            public void onHandleAssistWithCallback(AssistStructure r6, List<AppEntity> r7, IRealTimeContextCallback r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                r0.writeTypedList(r7);     // Catch: Throwable -> L20
                if (r8 == null) goto L10;
                IBinder r3 = r8.asBinder();     // Catch: Throwable -> L20
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().onHandleAssistWithCallback(r6, r7, r8);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
            public RealTimeContextResult queryRealTimeContext(String r6, String r7, String r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeString(r7);     // Catch: Throwable -> L17
                r0.writeString(r8);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                RealTimeContextResult r9 = (RealTimeContextResult) RealTimeContextResult.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r9;
            L14:
                r9 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                RealTimeContextResult r10 = Stub.getDefaultImpl().queryRealTimeContext(r6, r7, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r10;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static IRealTimeContextService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IRealTimeContextService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IRealTimeContextService) == false) goto L12;
            return (IRealTimeContextService) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IRealTimeContextService r1) {
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
            AssistStructure r0 = null;
            AssistStructure r1 = null;
            Bitmap r2 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L34;
            r0 = (AssistStructure) AssistStructure.CREATOR.createFromParcel(r6);
        L34:
            onHandleAssist(r0, r6.createTypedArrayList(AppEntity.CREATOR));
            return true;
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L29;
            r2 = (Bitmap) Bitmap.CREATOR.createFromParcel(r6);
        L29:
            onHandleScreenshot(r2);
            return true;
        L7:
            if (r5 != 3) goto L9;
            r6.enforceInterface(DESCRIPTOR);
            RealTimeContextResult r9 = queryRealTimeContext(r6.readString(), r6.readString(), r6.readString());
            r7.writeNoException();
            if (r9 == null) goto L24;
            r7.writeInt(1);
            r9.writeToParcel(r7, 1);
        L25:
            return true;
        L24:
            r7.writeInt(0);
            goto L25
        L9:
            if (r5 != 4) goto L11;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L19;
            r1 = (AssistStructure) AssistStructure.CREATOR.createFromParcel(r6);
        L19:
            onHandleAssistWithCallback(r1, r6.createTypedArrayList(AppEntity.CREATOR), IRealTimeContextCallback.Stub.asInterface(r6.readStrongBinder()));
            return true;
        L11:
            if (r5 != 1598968902) goto L13;
            r7.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    void onHandleAssist(AssistStructure r1, List<AppEntity> r2) throws RemoteException;

    void onHandleAssistWithCallback(AssistStructure r1, List<AppEntity> r2, IRealTimeContextCallback r3) throws RemoteException;

    void onHandleScreenshot(Bitmap r1) throws RemoteException;

    RealTimeContextResult queryRealTimeContext(String r1, String r2, String r3) throws RemoteException;
}
