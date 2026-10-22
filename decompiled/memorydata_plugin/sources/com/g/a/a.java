package com.g.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.g.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0181a extends Binder implements a {

        /* JADX INFO: renamed from: com.g.a.a$a$a, reason: collision with other inner class name */
        private static class C0182a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f3722a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3723b;

            C0182a(IBinder r3) {
                this.f3723b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.g.a.a
            public String a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");     // Catch: Throwable -> L13
                if (this.f3723b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0181a.d() == null) goto L10;
                String r5 = AbstractBinderC0181a.d().a();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.g.a.a
            public String a(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f3723b.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0181a.d() == null) goto L10;
                String r6 = AbstractBinderC0181a.d().a(r5);     // Catch: Throwable -> L13
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
                return this.f3723b;
            }

            @Override // com.g.a.a
            public String b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");     // Catch: Throwable -> L13
                if (this.f3723b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0181a.d() == null) goto L10;
                String r5 = AbstractBinderC0181a.d().b();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.g.a.a
            public String b(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f3723b.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0181a.d() == null) goto L10;
                String r6 = AbstractBinderC0181a.d().b(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.g.a.a
            public boolean c() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f3723b.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (AbstractBinderC0181a.d() == null) goto L10;
                boolean r4 = AbstractBinderC0181a.d().c();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
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
            IInterface r0 = r4.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0182a(r4);
        }

        public static a d() {
            return C0182a.f3722a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
            String r3 = a();
        L19:
            r6.writeNoException();
            r6.writeString(r3);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
            r3 = b();
            goto L19
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
            boolean r8 = c();
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
            r3 = a(r5.readString());
            goto L19
        L11:
            if (r4 != 5) goto L13;
            r5.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
            r3 = b(r5.readString());
            goto L19
        L13:
            if (r4 != 1598968902) goto L15;
            r6.writeString("com.zui.deviceidservice.IDeviceidInterface");
            return true;
        L15:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    String a();

    String a(String r1);

    String b();

    String b(String r1);

    boolean c();
}
