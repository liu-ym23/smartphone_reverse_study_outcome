package com.obric.aivoice;

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
public interface AIVoiceBinder extends IInterface {

    public static class Default implements AIVoiceBinder {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aivoice.AIVoiceBinder
        public void callVoice(Bundle r1, AIVoiceListener r2) throws RemoteException {
        }

        @Override // com.obric.aivoice.AIVoiceBinder
        public Bundle callVoiceSync(Bundle r1) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements AIVoiceBinder {
        private static final String DESCRIPTOR = "com.obric.aivoice.AIVoiceBinder";
        static final int TRANSACTION_callVoice = 2;
        static final int TRANSACTION_callVoiceSync = 1;

        public static class Proxy implements AIVoiceBinder {
            public static AIVoiceBinder sDefaultImpl;
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

            @Override // com.obric.aivoice.AIVoiceBinder
            public Bundle callVoiceSync(Bundle r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L8:
                if (INVOKEINTERFACE_com_obric_aivoice_AIVoiceBinder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                Bundle r7 = (Bundle) Bundle.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r7;
            L18:
                r7 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Bundle r8 = Stub.getDefaultImpl().callVoiceSync(r6);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aivoice.AIVoiceBinder
            public void callVoice(Bundle r6, AIVoiceListener r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r7 == null) goto L9;
                IBinder r3 = r7.asBinder();     // Catch: Throwable -> L20
            L10:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_aivoice_AIVoiceBinder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().callVoice(r6, r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r3 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aivoice_AIVoiceBinder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static AIVoiceBinder getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static AIVoiceBinder asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof AIVoiceBinder) == false) goto L12;
            return (AIVoiceBinder) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(AIVoiceBinder r1) {
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
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            Bundle r0 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L20;
            r0 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L20:
            Bundle r9 = callVoiceSync(r0);
            r7.writeNoException();
            if (r9 == null) goto L23;
            r7.writeInt(1);
            r9.writeToParcel(r7, 1);
        L24:
            return true;
        L23:
            r7.writeInt(0);
            goto L24
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L15;
            r0 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L15:
            callVoice(r0, AIVoiceListener.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L7:
            if (r5 != 1598968902) goto L9;
            r7.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    void callVoice(Bundle r1, AIVoiceListener r2) throws RemoteException;

    Bundle callVoiceSync(Bundle r1) throws RemoteException;
}
