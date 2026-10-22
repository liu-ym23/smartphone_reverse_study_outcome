package com.f.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.f.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0179a extends Binder implements a {

        /* JADX INFO: renamed from: com.f.a.a.a$a$a, reason: collision with other inner class name */
        private static class C0180a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f3720a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3721b;

            C0180a(IBinder r3) {
                this.f3721b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.f.a.a.a
            public String a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");     // Catch: Throwable -> L13
                if (this.f3721b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0179a.b() == null) goto L10;
                String r5 = AbstractBinderC0179a.b().a();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.f.a.a.a
            public String a(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f3721b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0179a.b() == null) goto L10;
                String r6 = AbstractBinderC0179a.b().a(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3721b;
            }

            @Override // com.f.a.a.a
            public String b(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f3721b.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0179a.b() == null) goto L10;
                String r6 = AbstractBinderC0179a.b().b(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0180a(r4);
        }

        public static a b() {
            return C0180a.f3720a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            String r3 = a();
        L15:
            r6.writeNoException();
            r6.writeString(r3);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            r3 = a(r5.readString());
            goto L15
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            r3 = b(r5.readString());
            goto L15
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    String a();

    String a(String r1);

    String b(String r1);
}
