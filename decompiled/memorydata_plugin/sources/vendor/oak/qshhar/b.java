package vendor.oak.qshhar;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes8.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: vendor.oak.qshhar.b$a$a, reason: collision with other inner class name */
        public static class C0914a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f20322a;

            public C0914a(IBinder r3) {
                this.f20322a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // vendor.oak.qshhar.b
            public void a(HarEventData r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.oak.qshhar.IQshHarService");     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f20322a.transact(7, r0, r1, 0);     // Catch: Throwable -> L10
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

            @Override // vendor.oak.qshhar.b
            public void a(HarMonitorParam r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.oak.qshhar.IQshHarService");     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f20322a.transact(6, r0, r1, 0);     // Catch: Throwable -> L10
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

            @Override // vendor.oak.qshhar.b
            public void a(QshHarRuntimeParamParcel r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.oak.qshhar.IQshHarService");     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f20322a.transact(1, r0, r1, 0);     // Catch: Throwable -> L10
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

            @Override // vendor.oak.qshhar.b
            public void a(QshHarWifiStandardData r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.oak.qshhar.IQshHarService");     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f20322a.transact(5, r0, r1, 0);     // Catch: Throwable -> L10
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

            @Override // vendor.oak.qshhar.b
            public void a(vendor.oak.qshhar.a r4, int r5) {
                vendor.oak.qshhar.a r6 = (vendor.oak.qshhar.a) ZeusTransformUtils.wrapperContextForParams(r4, vendor.oak.qshhar.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.oak.qshhar.IQshHarService");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.f20322a.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // vendor.oak.qshhar.b
            public void a(vendor.oak.qshhar.a r4, int r5, int r6, int r7) {
                vendor.oak.qshhar.a r8 = (vendor.oak.qshhar.a) ZeusTransformUtils.wrapperContextForParams(r4, vendor.oak.qshhar.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.oak.qshhar.IQshHarService");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r8);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeInt(r7);     // Catch: Throwable -> L6
                this.f20322a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // vendor.oak.qshhar.b
            public void a(int[] r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.oak.qshhar.IQshHarService");     // Catch: Throwable -> L6
                r0.writeIntArray(r4);     // Catch: Throwable -> L6
                this.f20322a.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f20322a;
            }
        }

        public static b a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("vendor.oak.qshhar.IQshHarService");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0914a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("vendor.oak.qshhar.IQshHarService");
        L8:
            if (r4 != 1598968902) goto L10;
            r6.writeString("vendor.oak.qshhar.IQshHarService");
            return true;
        L10:
            switch(r4) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                default: goto L12;
            };
        L13:
            a((HarEventData) ZeusTransformUtils.preCheckCast(C0915b.a(r5, HarEventData.CREATOR), HarEventData.class, "com.obric.memorydata.plugin"));
        L20:
            r6.writeNoException();
            return true;
        L14:
            a((HarMonitorParam) ZeusTransformUtils.preCheckCast(C0915b.a(r5, HarMonitorParam.CREATOR), HarMonitorParam.class, "com.obric.memorydata.plugin"));
            goto L20
        L15:
            a((QshHarWifiStandardData) ZeusTransformUtils.preCheckCast(C0915b.a(r5, QshHarWifiStandardData.CREATOR), QshHarWifiStandardData.class, "com.obric.memorydata.plugin"));
            goto L20
        L16:
            a(r5.createIntArray());
            goto L20
        L17:
            a(vendor.oak.qshhar.a.AbstractBinderC0912a.asInterface(r5.readStrongBinder()), r5.readInt());
            goto L20
        L18:
            a(vendor.oak.qshhar.a.AbstractBinderC0912a.asInterface(r5.readStrongBinder()), r5.readInt(), r5.readInt(), r5.readInt());
            goto L20
        L19:
            a((QshHarRuntimeParamParcel) ZeusTransformUtils.preCheckCast(C0915b.a(r5, QshHarRuntimeParamParcel.CREATOR), QshHarRuntimeParamParcel.class, "com.obric.memorydata.plugin"));
            goto L20
        L12:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    /* JADX INFO: renamed from: vendor.oak.qshhar.b$b, reason: collision with other inner class name */
    public static class C0915b {
        public static Object a(Parcel r2, Parcelable.Creator r3) {
            Parcelable.Creator r4 = (Parcelable.Creator) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.Creator.class, "com.obric.memorydata.plugin");
            if (r2.readInt() != 0) goto L7;
            return null;
        L7:
            return r4.createFromParcel(r2);
        }
    }

    void a(HarEventData r1);

    void a(HarMonitorParam r1);

    void a(QshHarRuntimeParamParcel r1);

    void a(QshHarWifiStandardData r1);

    void a(vendor.oak.qshhar.a r1, int r2);

    void a(vendor.oak.qshhar.a r1, int r2, int r3, int r4);

    void a(int[] r1);
}
