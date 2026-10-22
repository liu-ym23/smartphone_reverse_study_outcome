package com.obric.cae.libs.location.poi;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        /* JADX INFO: renamed from: com.obric.cae.libs.location.poi.d$a$a, reason: collision with other inner class name */
        public static class C0342a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f6990a;

            public C0342a(IBinder r3) {
                this.f6990a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.cae.libs.location.poi.d
            public void a() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L6
                this.f6990a.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public void a(int r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f6990a.transact(6, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public void a(Bundle r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L6
                b.a(r0, r4, 0);     // Catch: Throwable -> L6
                this.f6990a.transact(17, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public void a(c r3) {
                c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.f6990a.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public void a(boolean r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L6
                r0.writeInt(r4 ? 1 : 0);     // Catch: Throwable -> L6
                this.f6990a.transact(8, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6990a;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public Bundle b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L10
                this.f6990a.transact(3, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                Parcelable.Creator r4 = Bundle.CREATOR;     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L6;
                Object r5 = r4.createFromParcel(r1);     // Catch: Throwable -> L10
            L7:
                Bundle r6 = (Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r5 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public void b(int r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f6990a.transact(9, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public int c() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L6
                this.f6990a.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r4 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public void c(int r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f6990a.transact(11, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public Bundle d() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L10
                this.f6990a.transact(5, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                Parcelable.Creator r4 = Bundle.CREATOR;     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L6;
                Object r5 = r4.createFromParcel(r1);     // Catch: Throwable -> L10
            L7:
                Bundle r6 = (Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r5 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public void e() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L6
                this.f6990a.transact(7, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public int f() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L6
                this.f6990a.transact(10, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r4 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public Bundle g() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L10
                this.f6990a.transact(12, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                Parcelable.Creator r4 = Bundle.CREATOR;     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L6;
                Object r5 = r4.createFromParcel(r1);     // Catch: Throwable -> L10
            L7:
                Bundle r6 = (Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r5 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public void h() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L6
                this.f6990a.transact(13, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public void i() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L6
                this.f6990a.transact(14, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public Bundle j() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L10
                this.f6990a.transact(15, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                Parcelable.Creator r4 = Bundle.CREATOR;     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L6;
                Object r5 = r4.createFromParcel(r1);     // Catch: Throwable -> L10
            L7:
                Bundle r6 = (Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r5 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public void k() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L6
                this.f6990a.transact(16, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.d
            public void l() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarPoiManager");     // Catch: Throwable -> L6
                this.f6990a.transact(18, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.obric.cae.libs.location.poi.IStarPoiManager");
        }

        public static d a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.cae.libs.location.poi.IStarPoiManager");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L13;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin");
        L13:
            return new C0342a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("com.obric.cae.libs.location.poi.IStarPoiManager");
        L8:
            if (r4 == 1598968902) goto L37;
            switch(r4) {
                case 1: goto L35;
                case 2: goto L34;
                case 3: goto L32;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L23;
                case 9: goto L21;
                case 10: goto L20;
                case 11: goto L19;
                case 12: goto L18;
                case 13: goto L17;
                case 14: goto L16;
                case 15: goto L15;
                case 16: goto L14;
                case 17: goto L13;
                case 18: goto L12;
                default: goto L11;
            };
        L12:
            l();
        L36:
            return true;
        L13:
            a((Bundle) ZeusTransformUtils.preCheckCast(b.a(r5, Bundle.CREATOR), Bundle.class, "com.obric.memorydata.plugin"));
            goto L36
        L14:
            k();
            goto L36
        L15:
            Bundle r3 = j();
        L33:
            r6.writeNoException();
            b.a(r6, r3, 1);
            goto L36
        L16:
            i();
            goto L36
        L17:
            h();
            goto L36
        L18:
            r3 = g();
            goto L33
        L19:
            c(r5.readInt());
            goto L36
        L20:
            int r8 = f();
        L31:
            r6.writeNoException();
            r6.writeInt(r8);
            goto L36
        L21:
            b(r5.readInt());
            goto L36
        L27:
            e();
            goto L36
        L28:
            a(r5.readInt());
            goto L36
        L29:
            r3 = d();
            goto L33
        L30:
            r8 = c();
            goto L31
        L32:
            r3 = b();
            goto L33
        L34:
            a();
            goto L36
        L35:
            a(c.a.a(r5.readStrongBinder()));
            goto L36
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L23:
            if (r5.readInt() == 0) goto L25;
            boolean r9 = true;
        L26:
            a(r9);
            goto L36
        L25:
            r9 = false;
            goto L26
        L37:
            r6.writeString("com.obric.cae.libs.location.poi.IStarPoiManager");
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

        public static void a(Parcel r2, Parcelable r3, int r4) {
            Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L5;
            r2.writeInt(1);
            r5.writeToParcel(r2, r4);
            return;
        L5:
            r2.writeInt(0);
        }
    }

    void a();

    void a(int r1);

    void a(Bundle r1);

    void a(c r1);

    void a(boolean r1);

    Bundle b();

    void b(int r1);

    int c();

    void c(int r1);

    Bundle d();

    void e();

    int f();

    Bundle g();

    void h();

    void i();

    Bundle j();

    void k();

    void l();
}
