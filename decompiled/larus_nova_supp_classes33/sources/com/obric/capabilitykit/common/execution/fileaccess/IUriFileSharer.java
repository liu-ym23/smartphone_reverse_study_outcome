package com.obric.capabilitykit.common.execution.fileaccess;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface IUriFileSharer extends IInterface {

    public static class Default implements IUriFileSharer {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.execution.fileaccess.IUriFileSharer
        public int onRequestUriAccess(IUriFileReceiver r1, Uri r2, String r3) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IUriFileSharer {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.execution.fileaccess.IUriFileSharer";
        public static final int TRANSACTION_onRequestUriAccess = 1;

        public static class Proxy implements IUriFileSharer {
            public static IUriFileSharer sDefaultImpl;
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

            @Override // com.obric.capabilitykit.common.execution.fileaccess.IUriFileSharer
            public int onRequestUriAccess(IUriFileReceiver r6, Uri r7, String r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L20
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L20
                if (r7 == null) goto L10;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L11:
                r0.writeString(r8);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_execution_fileaccess_IUriFileSharer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L20
                int r9 = r1.readInt();     // Catch: Throwable -> L20
            L16:
                r1.recycle();
                r0.recycle();
                return r9;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                r9 = Stub.getDefaultImpl().onRequestUriAccess(r6, r7, r8);     // Catch: Throwable -> L20
                goto L16
            L10:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r2 = null;
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_capabilitykit_common_execution_fileaccess_IUriFileSharer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static IUriFileSharer asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IUriFileSharer) == false) goto L12;
            return (IUriFileSharer) r0;
        L12:
            return new Proxy(r2);
        }

        public static IUriFileSharer getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IUriFileSharer r1) {
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
            IUriFileReceiver r8 = IUriFileReceiver.Stub.asInterface(r5.readStrongBinder());
            if (r5.readInt() == 0) goto L13;
            Uri r9 = (Uri) Uri.CREATOR.createFromParcel(r5);
        L14:
            int r10 = onRequestUriAccess(r8, r9, r5.readString());
            r6.writeNoException();
            r6.writeInt(r10);
            return true;
        L13:
            r9 = null;
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    int onRequestUriAccess(IUriFileReceiver r1, Uri r2, String r3) throws RemoteException;
}
