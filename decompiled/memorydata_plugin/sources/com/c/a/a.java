package com.c.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.c.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0171a extends Binder implements a {

        /* JADX INFO: renamed from: com.c.a.a$a$a, reason: collision with other inner class name */
        private static class C0172a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f3394a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3395b;

            C0172a(IBinder r3) {
                this.f3395b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.c.a.a
            public String a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bun.lib.MsaIdInterface");     // Catch: Throwable -> L13
                if (this.f3395b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0171a.g() == null) goto L10;
                String r5 = AbstractBinderC0171a.g().a();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3395b;
            }

            @Override // com.c.a.a
            public boolean b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bun.lib.MsaIdInterface");     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f3395b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (AbstractBinderC0171a.g() == null) goto L10;
                boolean r4 = AbstractBinderC0171a.g().b();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.c.a.a
            public String c() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bun.lib.MsaIdInterface");     // Catch: Throwable -> L13
                if (this.f3395b.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0171a.g() == null) goto L10;
                String r5 = AbstractBinderC0171a.g().c();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.c.a.a
            public String d() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bun.lib.MsaIdInterface");     // Catch: Throwable -> L13
                if (this.f3395b.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0171a.g() == null) goto L10;
                String r5 = AbstractBinderC0171a.g().d();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.c.a.a
            public boolean e() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bun.lib.MsaIdInterface");     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f3395b.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (AbstractBinderC0171a.g() == null) goto L10;
                boolean r4 = AbstractBinderC0171a.g().e();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.c.a.a
            public void f() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bun.lib.MsaIdInterface");     // Catch: Throwable -> L13
                if (this.f3395b.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (AbstractBinderC0171a.g() == null) goto L10;
                AbstractBinderC0171a.g().f();     // Catch: Throwable -> L13
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

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.bun.lib.MsaIdInterface");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0172a(r4);
        }

        public static a g() {
            return C0172a.f3394a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L19;
            switch(r4) {
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L13;
                case 4: goto L11;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface("com.bun.lib.MsaIdInterface");
            f();
            r6.writeNoException();
            return true;
        L9:
            r5.enforceInterface("com.bun.lib.MsaIdInterface");
            boolean r3 = e();
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L11:
            r5.enforceInterface("com.bun.lib.MsaIdInterface");
            String r8 = d();
            r6.writeNoException();
            r6.writeString(r8);
            return true;
        L13:
            r5.enforceInterface("com.bun.lib.MsaIdInterface");
            String r9 = c();
            r6.writeNoException();
            r6.writeString(r9);
            return true;
        L15:
            r5.enforceInterface("com.bun.lib.MsaIdInterface");
            boolean r10 = b();
            r6.writeNoException();
            r6.writeInt(r10 ? 1 : 0);
            return true;
        L17:
            r5.enforceInterface("com.bun.lib.MsaIdInterface");
            String r11 = a();
            r6.writeNoException();
            r6.writeString(r11);
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L19:
            r6.writeString("com.bun.lib.MsaIdInterface");
            return true;
        }
    }

    String a();

    boolean b();

    String c();

    String d();

    boolean e();

    void f();
}
