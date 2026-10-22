package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface ICapabilityFeedbackReceiver extends IInterface {

    public static abstract class Stub extends Binder implements ICapabilityFeedbackReceiver {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilityFeedbackReceiver";
        public static final int TRANSACTION_isCardViewVisible = 6;
        public static final int TRANSACTION_isKeyguardReallyLocked = 7;
        public static final int TRANSACTION_onActionResultRecv = 1;
        public static final int TRANSACTION_onFinishFloatingActivity = 5;
        public static final int TRANSACTION_onHideIntentResultCard = 3;
        public static final int TRANSACTION_onJobResultRecv = 4;
        public static final int TRANSACTION_onUpdateIntentResult = 2;
        public static final int TRANSACTION_onUpdateIntentResultWithRequest = 8;

        public static class Proxy implements ICapabilityFeedbackReceiver {
            public static ICapabilityFeedbackReceiver sDefaultImpl;
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

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public boolean isCardViewVisible(long r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeLong(r6);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L6;
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
                boolean r7 = Stub.getDefaultImpl().isCardViewVisible(r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r7;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public boolean isKeyguardReallyLocked() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L6;
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
                boolean r2 = Stub.getDefaultImpl().isKeyguardReallyLocked();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r2;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onActionResultRecv(String r5, String r6, boolean r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeInt(r7 ? 1 : 0);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onActionResultRecv(r5, r6, r7);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onFinishFloatingActivity(long r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onFinishFloatingActivity(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onHideIntentResultCard(long r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onHideIntentResultCard(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onJobResultRecv(String r6, String r7, boolean r8, JobResult r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r6);     // Catch: Throwable -> L16
                r0.writeString(r7);     // Catch: Throwable -> L16
                r0.writeInt(r8 ? 1 : 0);     // Catch: Throwable -> L16
                if (r9 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r9.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onJobResultRecv(r6, r7, r8, r9);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onUpdateIntentResult(long r9, IntentResult r11, boolean r12, Map r13) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeLong(r9);     // Catch: Throwable -> L16
                if (r11 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r11.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeInt(r12 ? 1 : 0);     // Catch: Throwable -> L16
                r0.writeMap(r13);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onUpdateIntentResult(r9, r11, r12, r13);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onUpdateIntentResultWithRequest(String r6, IntentResult r7, boolean r8, Map r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r6);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeInt(r8 ? 1 : 0);     // Catch: Throwable -> L16
                r0.writeMap(r9);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onUpdateIntentResultWithRequest(r6, r7, r8, r9);     // Catch: Throwable -> L16
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
            public static boolean INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static ICapabilityFeedbackReceiver asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICapabilityFeedbackReceiver) == false) goto L12;
            return (ICapabilityFeedbackReceiver) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICapabilityFeedbackReceiver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityFeedbackReceiver r1) {
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
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) throws RemoteException {
            if (r9 == 1598968902) goto L46;
            boolean r0 = false;
            IntentResult r3 = null;
            IntentResult r4 = null;
            JobResult r5 = null;
            switch(r9) {
                case 1: goto L41;
                case 2: goto L32;
                case 3: goto L30;
                case 4: goto L22;
                case 5: goto L20;
                case 6: goto L18;
                case 7: goto L16;
                case 8: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface(DESCRIPTOR);
            String r13 = r10.readString();
            if (r10.readInt() == 0) goto L12;
            IntentResult.CREATOR.getClass();
            r4 = IntentResult.b.b(r10);
        L12:
            if (r10.readInt() == 0) goto L14;
            r0 = true;
        L14:
            onUpdateIntentResultWithRequest(r13, r4, r0, r10.readHashMap(getClass().getClassLoader()));
            return true;
        L16:
            r10.enforceInterface(DESCRIPTOR);
            boolean r14 = isKeyguardReallyLocked();
            r11.writeNoException();
            r11.writeInt(r14 ? 1 : 0);
            return true;
        L18:
            r10.enforceInterface(DESCRIPTOR);
            boolean r15 = isCardViewVisible(r10.readLong());
            r11.writeNoException();
            r11.writeInt(r15 ? 1 : 0);
            return true;
        L20:
            r10.enforceInterface(DESCRIPTOR);
            onFinishFloatingActivity(r10.readLong());
            return true;
        L22:
            r10.enforceInterface(DESCRIPTOR);
            String r16 = r10.readString();
            String r17 = r10.readString();
            if (r10.readInt() == 0) goto L26;
            r0 = true;
        L26:
            if (r10.readInt() == 0) goto L28;
            r5 = JobResult.CREATOR.createFromParcel(r10);
        L28:
            onJobResultRecv(r16, r17, r0, r5);
            return true;
        L30:
            r10.enforceInterface(DESCRIPTOR);
            onHideIntentResultCard(r10.readLong());
            return true;
        L32:
            r10.enforceInterface(DESCRIPTOR);
            long r18 = r10.readLong();
            if (r10.readInt() == 0) goto L35;
            IntentResult.CREATOR.getClass();
            r3 = IntentResult.b.b(r10);
        L35:
            IntentResult r6 = r3;
            if (r10.readInt() == 0) goto L38;
            boolean r7 = true;
        L39:
            onUpdateIntentResult(r18, r6, r7, r10.readHashMap(getClass().getClassLoader()));
            return true;
        L38:
            r7 = false;
            goto L39
        L41:
            r10.enforceInterface(DESCRIPTOR);
            String r19 = r10.readString();
            String r110 = r10.readString();
            if (r10.readInt() == 0) goto L44;
            r0 = true;
        L44:
            onActionResultRecv(r19, r110, r0);
            return true;
        L7:
            return super.onTransact(r9, r10, r11, r12);
        L46:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    boolean isCardViewVisible(long r1) throws RemoteException;

    boolean isKeyguardReallyLocked() throws RemoteException;

    void onActionResultRecv(String r1, String r2, boolean r3) throws RemoteException;

    void onFinishFloatingActivity(long r1) throws RemoteException;

    void onHideIntentResultCard(long r1) throws RemoteException;

    void onJobResultRecv(String r1, String r2, boolean r3, JobResult r4) throws RemoteException;

    void onUpdateIntentResult(long r1, IntentResult r3, boolean r4, Map r5) throws RemoteException;

    void onUpdateIntentResultWithRequest(String r1, IntentResult r2, boolean r3, Map r4) throws RemoteException;
}
