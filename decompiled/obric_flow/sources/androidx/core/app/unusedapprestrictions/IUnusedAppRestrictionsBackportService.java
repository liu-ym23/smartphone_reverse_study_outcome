package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface IUnusedAppRestrictionsBackportService extends IInterface {
    public static final String DESCRIPTOR = null;

    public static class Default implements IUnusedAppRestrictionsBackportService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
        public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback r5) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportService {
        static final int TRANSACTION_isPermissionRevocationEnabledForApp = 1;

        public static class Proxy implements IUnusedAppRestrictionsBackportService {
            private IBinder mRemote;

            public Proxy(IBinder r5) {
                this.mRemote = r5;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IUnusedAppRestrictionsBackportService.DESCRIPTOR;
            }

            @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
            public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback r5) throws RemoteException {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(IUnusedAppRestrictionsBackportService.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r10, null, 1);     // Catch: Throwable -> L6
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IUnusedAppRestrictionsBackportService.DESCRIPTOR);
        }

        public static IUnusedAppRestrictionsBackportService asInterface(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface(IUnusedAppRestrictionsBackportService.DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IUnusedAppRestrictionsBackportService) == false) goto L12;
            return (IUnusedAppRestrictionsBackportService) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) throws RemoteException {
            String r13 = IUnusedAppRestrictionsBackportService.DESCRIPTOR;
            if (r5 < 1) goto L8;
            if (r5 > 16777215) goto L8;
            r10.enforceInterface(r13);
        L8:
            if (r5 != 1598968902) goto L11;
            r11.writeString(r13);
            return true;
        L11:
            if (r5 != 1) goto L13;
            isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L13:
            return super.onTransact(r5, r10, r11, r12);
        }
    }

    static {
        DESCRIPTOR = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace(Typography.dollar, '.');
    }

    void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback r5) throws RemoteException;
}
