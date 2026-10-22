package com.obric.cae.libs.cloud;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.obric.cae.libs.cloud.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0323a extends Binder implements a {

        /* JADX INFO: renamed from: com.obric.cae.libs.cloud.a$a$a, reason: collision with other inner class name */
        public static class C0324a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f6954a;

            public C0324a(IBinder r3) {
                this.f6954a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.cae.libs.cloud.a
            public void a(int r4, b r5) {
                b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.cloud.ICloud");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                this.f6954a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.cloud.a
            public void a(int r4, String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.cloud.ICloud");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.f6954a.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.cloud.a
            public void a(b r4) {
                b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.cloud.ICloud");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.f6954a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.cloud.a
            public void a(String r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.cloud.ICloud");     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.f6954a.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
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
                return this.f6954a;
            }

            @Override // com.obric.cae.libs.cloud.a
            public void b(b r4) {
                b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.cloud.ICloud");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.f6954a.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
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
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.cae.libs.cloud.ICloud");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0324a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("com.obric.cae.libs.cloud.ICloud");
        L8:
            if (r4 == 1598968902) goto L27;
            if (r4 != 1) goto L11;
            a(b.a.asInterface(r5.readStrongBinder()));
        L25:
            r6.writeNoException();
            return true;
        L11:
            if (r4 != 2) goto L13;
            a(r5.readInt(), b.a.asInterface(r5.readStrongBinder()));
            goto L25
        L13:
            if (r4 != 3) goto L15;
            b(b.a.asInterface(r5.readStrongBinder()));
            goto L25
        L15:
            if (r4 != 4) goto L17;
            a(r5.readString());
            goto L25
        L17:
            if (r4 != 5) goto L19;
            a(r5.readInt(), r5.readString());
            goto L25
        L19:
            return super.onTransact(r4, r5, r6, r7);
        L27:
            r6.writeString("com.obric.cae.libs.cloud.ICloud");
            return true;
        }
    }

    void a(int r1, b r2);

    void a(int r1, String r2);

    void a(b r1);

    void a(String r1);

    void b(b r1);
}
