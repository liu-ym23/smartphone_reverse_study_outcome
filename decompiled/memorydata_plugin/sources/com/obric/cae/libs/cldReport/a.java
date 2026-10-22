package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.obric.cae.libs.cldReport.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0320a extends Binder implements a {

        /* JADX INFO: renamed from: com.obric.cae.libs.cldReport.a$a$a, reason: collision with other inner class name */
        public static class C0321a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f6952a;

            public C0321a(IBinder r3) {
                this.f6952a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.cae.libs.cldReport.a
            public void a(boolean r4, int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.cldReport.ICldReportCallback");     // Catch: Throwable -> L6
                r0.writeInt(r4 ? 1 : 0);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.f6952a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.cldReport.a
            public void a(boolean r4, int r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.cldReport.ICldReportCallback");     // Catch: Throwable -> L6
                r0.writeInt(r4 ? 1 : 0);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                this.f6952a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
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
                return this.f6952a;
            }
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.cae.libs.cldReport.ICldReportCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0321a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("com.obric.cae.libs.cldReport.ICldReportCallback");
        L8:
            if (r4 == 1598968902) goto L25;
            boolean r1 = false;
            if (r4 == 1) goto L20;
            if (r4 == 2) goto L16;
            return super.onTransact(r4, r5, r6, r7);
        L16:
            if (r5.readInt() == 0) goto L18;
            r1 = true;
        L18:
            a(r1, r5.readInt(), r5.readString());
        L23:
            r6.writeNoException();
            return true;
        L20:
            if (r5.readInt() == 0) goto L22;
            r1 = true;
        L22:
            a(r1, r5.readInt());
            goto L23
        L25:
            r6.writeString("com.obric.cae.libs.cldReport.ICldReportCallback");
            return true;
        }
    }

    void a(boolean r1, int r2);

    void a(boolean r1, int r2, String r3);
}
