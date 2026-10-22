package com.obric.capabilitykit.common;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface ICapabilityActionHandler extends IInterface {

    public static abstract class Stub extends Binder implements ICapabilityActionHandler {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilityActionHandler";
        public static final int TRANSACTION_getVersion = 1;
        public static final int TRANSACTION_handleAction = 2;
        public static final int TRANSACTION_handleIntentCalling = 3;
        public static final int TRANSACTION_isTaskRunning = 7;
        public static final int TRANSACTION_openUriFile = 4;
        public static final int TRANSACTION_stopAction = 6;
        public static final int TRANSACTION_stopComplexTask = 5;

        public static class Proxy implements ICapabilityActionHandler {
            public static ICapabilityActionHandler sDefaultImpl;
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

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public int getVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r2 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r2 = Stub.getDefaultImpl().getVersion();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean handleAction(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r6);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
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
                boolean r7 = Stub.getDefaultImpl().handleAction(r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r7;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean handleIntentCalling(IntentCalling r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r8 = Stub.getDefaultImpl().handleIntentCalling(r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public int isTaskRunning(String r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r8 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r8 = Stub.getDefaultImpl().isTaskRunning(r6, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean openUriFile(Uri r7, IUriFileReceiver r8, String r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                boolean r2 = true;
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L7:
                if (r8 == null) goto L9;
                IBinder r4 = r8.asBinder();     // Catch: Throwable -> L23
            L10:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L23
                r0.writeString(r9);     // Catch: Throwable -> L23
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L23
                if (r1.readInt() != 0) goto L21;
                r2 = false;
            L21:
                r1.recycle();
                r0.recycle();
                return r2;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                boolean r10 = Stub.getDefaultImpl().openUriFile(r7, r8, r9);     // Catch: Throwable -> L23
                r1.recycle();
                r0.recycle();
                return r10;
            L9:
                r4 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean stopAction(String r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r6);     // Catch: Throwable -> L15
                r0.writeString(r7);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L6;
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
                boolean r8 = Stub.getDefaultImpl().stopAction(r6, r7);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r8;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean stopComplexTask(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r6);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
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
                boolean r7 = Stub.getDefaultImpl().stopComplexTask(r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r7;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static ICapabilityActionHandler asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICapabilityActionHandler) == false) goto L12;
            return (ICapabilityActionHandler) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICapabilityActionHandler getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityActionHandler r1) {
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
            IntentCalling r0 = null;
            Uri r1 = null;
            switch(r4) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L17;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            int r8 = isTaskRunning(r5.readString(), r5.readString());
        L9:
            r6.writeNoException();
            r6.writeInt(r8);
            return true;
        L11:
            r5.enforceInterface(DESCRIPTOR);
            r8 = stopAction(r5.readString(), r5.readString());
            goto L9
        L12:
            r5.enforceInterface(DESCRIPTOR);
            r8 = stopComplexTask(r5.readString());
            goto L9
        L13:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L16;
            r1 = (Uri) Uri.CREATOR.createFromParcel(r5);
        L16:
            r8 = openUriFile(r1, IUriFileReceiver.Stub.asInterface(r5.readStrongBinder()), r5.readString());
            goto L9
        L17:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L20;
            r0 = IntentCalling.CREATOR.createFromParcel(r5);
        L20:
            r8 = handleIntentCalling(r0);
            goto L9
        L21:
            r5.enforceInterface(DESCRIPTOR);
            r8 = handleAction(r5.readString());
            goto L9
        L22:
            r5.enforceInterface(DESCRIPTOR);
            r8 = getVersion();
            goto L9
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L23:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getVersion() throws RemoteException;

    boolean handleAction(String r1) throws RemoteException;

    boolean handleIntentCalling(IntentCalling r1) throws RemoteException;

    int isTaskRunning(String r1, String r2) throws RemoteException;

    boolean openUriFile(Uri r1, IUriFileReceiver r2, String r3) throws RemoteException;

    boolean stopAction(String r1, String r2) throws RemoteException;

    boolean stopComplexTask(String r1) throws RemoteException;
}
