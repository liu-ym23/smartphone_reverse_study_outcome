package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
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
        public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback r2) {
            IUnusedAppRestrictionsBackportCallback r1 = (IUnusedAppRestrictionsBackportCallback) ZeusTransformUtils.wrapperContextForParams(r2, IUnusedAppRestrictionsBackportCallback.class, "com.obric.memorydata.plugin");
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportService {
        static final int TRANSACTION_isPermissionRevocationEnabledForApp = 1;

        private static class Proxy implements IUnusedAppRestrictionsBackportService {
            private IBinder mRemote;

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
            public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback r3) {
                IUnusedAppRestrictionsBackportCallback r4 = (IUnusedAppRestrictionsBackportCallback) ZeusTransformUtils.wrapperContextForParams(r3, IUnusedAppRestrictionsBackportCallback.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IUnusedAppRestrictionsBackportService asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IUnusedAppRestrictionsBackportService.class) == false) goto L13;
            return (IUnusedAppRestrictionsBackportService) ZeusTransformUtils.preCheckCast(r0, IUnusedAppRestrictionsBackportService.class, "com.obric.memorydata.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            String r0 = DESCRIPTOR;
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(r0);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(r0);
            return true;
        L11:
            if (r4 != 1) goto L13;
            isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L13:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    static {
        DESCRIPTOR = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace(Typography.dollar, '.');
    }

    void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback r1);
}
