package com.b.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.b.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0052a extends Binder implements a {

        /* JADX INFO: renamed from: com.b.a.a.a$a$a, reason: collision with other inner class name */
        private static class C0053a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f499a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f500b;

            C0053a(IBinder r3) {
                this.f500b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.b.a.a.a
            public boolean a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");     // Catch: Throwable -> L15
                boolean r2 = false;
                if (this.f500b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r2 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (AbstractBinderC0052a.f() == null) goto L10;
                boolean r4 = AbstractBinderC0052a.f().a();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f500b;
            }

            @Override // com.b.a.a.a
            public String b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");     // Catch: Throwable -> L13
                if (this.f500b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0052a.f() == null) goto L10;
                String r5 = AbstractBinderC0052a.f().b();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.b.a.a.a
            public String c() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");     // Catch: Throwable -> L13
                if (this.f500b.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0052a.f() == null) goto L10;
                String r5 = AbstractBinderC0052a.f().c();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.b.a.a.a
            public String d() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");     // Catch: Throwable -> L13
                if (this.f500b.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0052a.f() == null) goto L10;
                String r5 = AbstractBinderC0052a.f().d();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.b.a.a.a
            public String e() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");     // Catch: Throwable -> L13
                if (this.f500b.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0052a.f() == null) goto L10;
                String r5 = AbstractBinderC0052a.f().e();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
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
            IInterface r0 = r4.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0053a(r4);
        }

        public static a f() {
            return C0053a.f499a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            boolean r3 = a();
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            String r8 = b();
        L19:
            r6.writeNoException();
            r6.writeString(r8);
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            r8 = c();
            goto L19
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            r8 = d();
            goto L19
        L11:
            if (r4 != 5) goto L13;
            r5.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            r8 = e();
            goto L19
        L13:
            if (r4 != 1598968902) goto L15;
            r6.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return true;
        L15:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    boolean a();

    String b();

    String c();

    String d();

    String e();
}
