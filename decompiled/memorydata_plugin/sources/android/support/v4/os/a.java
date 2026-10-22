package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f79a = null;

    /* JADX INFO: renamed from: android.support.v4.os.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0015a extends Binder implements a {

        /* JADX INFO: renamed from: android.support.v4.os.a$a$a, reason: collision with other inner class name */
        private static class C0016a implements a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f80b;

            C0016a(IBinder r3) {
                this.f80b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.support.v4.os.a
            public void a(int r3, Bundle r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(f79a);     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                b.a(r0, r4, 0);     // Catch: Throwable -> L6
                this.f80b.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f80b;
            }
        }

        public AbstractBinderC0015a() {
            attachInterface(this, f79a);
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(f79a);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0016a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            String r0 = f79a;
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(r0);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(r0);
            return true;
        L11:
            if (r4 != 1) goto L13;
            a(r5.readInt(), (Bundle) ZeusTransformUtils.preCheckCast(b.a(r5, Bundle.CREATOR), Bundle.class, "com.obric.memorydata.plugin"));
            return true;
        L13:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    public static class b {
        static /* synthetic */ Object a(Parcel r2, Parcelable.Creator r3) {
            return b(r2, (Parcelable.Creator) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.Creator.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ void a(Parcel r2, Parcelable r3, int r4) {
            b(r2, (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"), r4);
        }

        private static <T> T b(Parcel r2, Parcelable.Creator<T> r3) {
            Parcelable.Creator r4 = (Parcelable.Creator) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.Creator.class, "com.obric.memorydata.plugin");
            if (r2.readInt() != 0) goto L5;
            return null;
        L5:
            return (T) r4.createFromParcel(r2);
        }

        private static <T extends Parcelable> void b(Parcel r2, T r3, int r4) {
            Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L5;
            r2.writeInt(1);
            r5.writeToParcel(r2, r4);
            return;
        L5:
            r2.writeInt(0);
        }
    }

    static {
        f79a = "android$support$v4$os$IResultReceiver".replace(Typography.dollar, '.');
    }

    void a(int r1, Bundle r2);
}
