package android.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: android.a.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0001a extends Binder implements a {

        /* JADX INFO: renamed from: android.a.a.a.a$a$a, reason: collision with other inner class name */
        private static class C0002a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f22a;

            C0002a(IBinder r3) {
                this.f22a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.a.a.a.a
            public void a(double r3, double r5, String r7) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken("android.datacenter.feature.integration.ILocationReportService");     // Catch: Throwable -> L6
                r0.writeDouble(r3);     // Catch: Throwable -> L6
                r0.writeDouble(r5);     // Catch: Throwable -> L6
                r0.writeString(r7);     // Catch: Throwable -> L6
                this.f22a.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.a.a.a.a
            public void a(boolean r3, String r4) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken("android.datacenter.feature.integration.ILocationReportService");     // Catch: Throwable -> L6
                r0.writeBoolean(r3);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.f22a.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f22a;
            }

            @Override // android.a.a.a.a
            public void b(double r3, double r5, String r7) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken("android.datacenter.feature.integration.ILocationReportService");     // Catch: Throwable -> L6
                r0.writeDouble(r3);     // Catch: Throwable -> L6
                r0.writeDouble(r5);     // Catch: Throwable -> L6
                r0.writeString(r7);     // Catch: Throwable -> L6
                this.f22a.transact(4, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.a.a.a.a
            public void b(boolean r3, String r4) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken("android.datacenter.feature.integration.ILocationReportService");     // Catch: Throwable -> L6
                r0.writeBoolean(r3);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.f22a.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("android.datacenter.feature.integration.ILocationReportService");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0002a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) {
            if (r9 < 1) goto L8;
            if (r9 > 16777215) goto L8;
            r10.enforceInterface("android.datacenter.feature.integration.ILocationReportService");
        L8:
            if (r9 != 1598968902) goto L11;
            r11.writeString("android.datacenter.feature.integration.ILocationReportService");
            return true;
        L11:
            if (r9 != 1) goto L13;
            boolean r1 = r10.readBoolean();
            String r2 = r10.readString();
            r10.enforceNoDataAvail();
            a(r1, r2);
        L24:
            return true;
        L13:
            if (r9 != 2) goto L15;
            boolean r3 = r10.readBoolean();
            String r4 = r10.readString();
            r10.enforceNoDataAvail();
            b(r3, r4);
            goto L24
        L15:
            if (r9 != 3) goto L17;
            double r5 = r10.readDouble();
            double r6 = r10.readDouble();
            String r7 = r10.readString();
            r10.enforceNoDataAvail();
            a(r5, r6, r7);
            goto L24
        L17:
            if (r9 != 4) goto L19;
            double r8 = r10.readDouble();
            double r13 = r10.readDouble();
            String r14 = r10.readString();
            r10.enforceNoDataAvail();
            b(r8, r13, r14);
            goto L24
        L19:
            return super.onTransact(r9, r10, r11, r12);
        }
    }

    void a(double r1, double r3, String r5);

    void a(boolean r1, String r2);

    void b(double r1, double r3, String r5);

    void b(boolean r1, String r2);
}
