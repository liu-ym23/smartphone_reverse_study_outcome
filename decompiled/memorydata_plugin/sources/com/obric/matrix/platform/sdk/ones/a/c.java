package com.obric.matrix.platform.sdk.ones.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.a.c$a$a, reason: collision with other inner class name */
        private static class C0398a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static c f8056a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f8057b;

            C0398a(IBinder r3) {
                this.f8057b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.matrix.platform.sdk.ones.a.c
            public void a(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f8057b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.a() == null) goto L10;
                a.a().a(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8057b;
            }

            @Override // com.obric.matrix.platform.sdk.ones.a.c
            public void b(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f8057b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.a() == null) goto L10;
                a.a().b(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
        }

        public static c a() {
            return C0398a.f8056a;
        }

        public static c a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L13;
            return (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
        L13:
            return new C0398a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
            a(r5.readString());
        L13:
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
            b(r5.readString());
            goto L13
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(String r1);

    void b(String r1);
}
