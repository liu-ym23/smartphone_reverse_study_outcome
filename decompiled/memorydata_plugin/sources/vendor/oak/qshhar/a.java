package vendor.oak.qshhar;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes8.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: vendor.oak.qshhar.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0912a extends Binder implements a {
        static final int TRANSACTION_OnRecvQshHarEvent = 1;

        /* JADX INFO: renamed from: vendor.oak.qshhar.a$a$a, reason: collision with other inner class name */
        public static class C0913a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f20321a;

            public C0913a(IBinder r3) {
                this.f20321a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // vendor.oak.qshhar.a
            public void OnRecvQshHarEvent(QshHarEventParcel r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.oak.qshhar.IQshHarEventListener");     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f20321a.transact(1, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f20321a;
            }
        }

        public AbstractBinderC0912a() {
            attachInterface(this, "vendor.oak.qshhar.IQshHarEventListener");
        }

        public static a asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("vendor.oak.qshhar.IQshHarEventListener");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0913a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("vendor.oak.qshhar.IQshHarEventListener");
        L8:
            if (r4 == 1598968902) goto L14;
            if (r4 != 1) goto L11;
            OnRecvQshHarEvent((QshHarEventParcel) ZeusTransformUtils.preCheckCast(b.a(r5, QshHarEventParcel.CREATOR), QshHarEventParcel.class, "com.obric.memorydata.plugin"));
            r6.writeNoException();
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            r6.writeString("vendor.oak.qshhar.IQshHarEventListener");
            return true;
        }
    }

    public static class b {
        public static Object a(Parcel r2, Parcelable.Creator r3) {
            Parcelable.Creator r4 = (Parcelable.Creator) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.Creator.class, "com.obric.memorydata.plugin");
            if (r2.readInt() != 0) goto L7;
            return null;
        L7:
            return r4.createFromParcel(r2);
        }
    }

    void OnRecvQshHarEvent(QshHarEventParcel r1);
}
