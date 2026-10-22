package com.tencent.qqmusic.third.api.contract;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IQQMusicApi extends IInterface {

    public static abstract class Stub extends Binder implements IQQMusicApi {
        private static final String DESCRIPTOR = "com.tencent.qqmusic.third.api.contract.IQQMusicApi";
        static final int TRANSACTION_execute = 1;
        static final int TRANSACTION_executeAsync = 2;
        static final int TRANSACTION_registerEventListener = 3;
        static final int TRANSACTION_unregisterEventListener = 4;

        public static class Proxy implements IQQMusicApi {
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

            @Override // com.tencent.qqmusic.third.api.contract.IQQMusicApi
            public Bundle execute(String r4, Bundle r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L14
                r0.writeString(r4);     // Catch: Throwable -> L14
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L14
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L14
            L7:
                INVOKEINTERFACE_com_tencent_qqmusic_third_api_contract_IQQMusicApi$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L14
                r1.readException();     // Catch: Throwable -> L14
                if (r1.readInt() == 0) goto L11;
                Bundle r6 = (Bundle) Bundle.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L14
            L12:
                r1.recycle();
                r0.recycle();
                return r6;
            L11:
                r6 = null;
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L14
            L14:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.tencent.qqmusic.third.api.contract.IQQMusicApi
            public Bundle registerEventListener(List<String> r5, IQQMusicApiEventListener r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeStringList(r5);     // Catch: Throwable -> L12
                Bundle r7 = null;
                if (r6 == null) goto L6;
                IBinder r8 = r6.asBinder();     // Catch: Throwable -> L12
            L7:
                r0.writeStrongBinder(r8);     // Catch: Throwable -> L12
                INVOKEINTERFACE_com_tencent_qqmusic_third_api_contract_IQQMusicApi$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0);     // Catch: Throwable -> L12
                r1.readException();     // Catch: Throwable -> L12
                if (r1.readInt() == 0) goto L10;
                r7 = (Bundle) Bundle.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L12
            L10:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                r8 = null;
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.tencent.qqmusic.third.api.contract.IQQMusicApi
            public Bundle unregisterEventListener(List<String> r5, IQQMusicApiEventListener r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeStringList(r5);     // Catch: Throwable -> L12
                Bundle r7 = null;
                if (r6 == null) goto L6;
                IBinder r8 = r6.asBinder();     // Catch: Throwable -> L12
            L7:
                r0.writeStrongBinder(r8);     // Catch: Throwable -> L12
                INVOKEINTERFACE_com_tencent_qqmusic_third_api_contract_IQQMusicApi$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0);     // Catch: Throwable -> L12
                r1.readException();     // Catch: Throwable -> L12
                if (r1.readInt() == 0) goto L10;
                r7 = (Bundle) Bundle.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L12
            L10:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                r8 = null;
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.tencent.qqmusic.third.api.contract.IQQMusicApi
            public void executeAsync(String r3, Bundle r4, IQQMusicApiCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L14
                r0.writeString(r3);     // Catch: Throwable -> L14
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L14
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L14
            L8:
                if (r5 == null) goto L10;
                IBinder r6 = r5.asBinder();     // Catch: Throwable -> L14
            L11:
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L14
                INVOKEINTERFACE_com_tencent_qqmusic_third_api_contract_IQQMusicApi$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1);     // Catch: Throwable -> L14
                r0.recycle();
                return;
            L10:
                r6 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L14
            L14:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_tencent_qqmusic_third_api_contract_IQQMusicApi$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
                String r1 = BuildConfig.FLAVOR;
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

        public static IQQMusicApi asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IQQMusicApi) == false) goto L12;
            return (IQQMusicApi) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) throws RemoteException {
            Bundle r0 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface(DESCRIPTOR);
            String r10 = r7.readString();
            if (r7.readInt() == 0) goto L34;
            r0 = (Bundle) Bundle.CREATOR.createFromParcel(r7);
        L34:
            Bundle r11 = execute(r10, r0);
            r8.writeNoException();
            if (r11 == null) goto L37;
            r8.writeInt(1);
            r11.writeToParcel(r8, 1);
        L38:
            return true;
        L37:
            r8.writeInt(0);
            goto L38
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface(DESCRIPTOR);
            String r12 = r7.readString();
            if (r7.readInt() == 0) goto L29;
            r0 = (Bundle) Bundle.CREATOR.createFromParcel(r7);
        L29:
            executeAsync(r12, r0, IQQMusicApiCallback.Stub.asInterface(r7.readStrongBinder()));
            return true;
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface(DESCRIPTOR);
            Bundle r13 = registerEventListener(r7.createStringArrayList(), IQQMusicApiEventListener.Stub.asInterface(r7.readStrongBinder()));
            r8.writeNoException();
            if (r13 == null) goto L24;
            r8.writeInt(1);
            r13.writeToParcel(r8, 1);
        L25:
            return true;
        L24:
            r8.writeInt(0);
            goto L25
        L9:
            if (r6 != 4) goto L11;
            r7.enforceInterface(DESCRIPTOR);
            Bundle r14 = unregisterEventListener(r7.createStringArrayList(), IQQMusicApiEventListener.Stub.asInterface(r7.readStrongBinder()));
            r8.writeNoException();
            if (r14 == null) goto L19;
            r8.writeInt(1);
            r14.writeToParcel(r8, 1);
        L20:
            return true;
        L19:
            r8.writeInt(0);
            goto L20
        L11:
            if (r6 != 1598968902) goto L13;
            r8.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r6, r7, r8, r9);
        }
    }

    Bundle execute(String r1, Bundle r2) throws RemoteException;

    void executeAsync(String r1, Bundle r2, IQQMusicApiCallback r3) throws RemoteException;

    Bundle registerEventListener(List<String> r1, IQQMusicApiEventListener r2) throws RemoteException;

    Bundle unregisterEventListener(List<String> r1, IQQMusicApiEventListener r2) throws RemoteException;
}
