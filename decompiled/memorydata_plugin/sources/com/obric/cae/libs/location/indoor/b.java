package com.obric.cae.libs.location.indoor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.obric.cae.libs.location.indoor.b$a$a, reason: collision with other inner class name */
        public static class C0336a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f6974a;

            public C0336a(IBinder r3) {
                this.f6974a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.cae.libs.location.indoor.b
            public void a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.indoor.IStarIndoorCheckManager");     // Catch: Throwable -> L6
                this.f6974a.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.indoor.b
            public void a(com.obric.cae.libs.location.indoor.a r4) {
                com.obric.cae.libs.location.indoor.a r5 = (com.obric.cae.libs.location.indoor.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.cae.libs.location.indoor.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.indoor.IStarIndoorCheckManager");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.f6974a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.indoor.b
            public void a(com.obric.cae.libs.location.indoor.a r4, String r5) {
                com.obric.cae.libs.location.indoor.a r6 = (com.obric.cae.libs.location.indoor.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.cae.libs.location.indoor.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.indoor.IStarIndoorCheckManager");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.f6974a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
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
                return this.f6974a;
            }
        }

        public a() {
            attachInterface(this, "com.obric.cae.libs.location.indoor.IStarIndoorCheckManager");
        }

        public static b a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.cae.libs.location.indoor.IStarIndoorCheckManager");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0336a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("com.obric.cae.libs.location.indoor.IStarIndoorCheckManager");
        L8:
            if (r4 == 1598968902) goto L21;
            if (r4 != 1) goto L11;
            a(com.obric.cae.libs.location.indoor.a.AbstractBinderC0334a.asInterface(r5.readStrongBinder()), r5.readString());
        L19:
            r6.writeNoException();
            return true;
        L11:
            if (r4 != 2) goto L13;
            a(com.obric.cae.libs.location.indoor.a.AbstractBinderC0334a.asInterface(r5.readStrongBinder()));
            goto L19
        L13:
            if (r4 != 3) goto L15;
            a();
            goto L19
        L15:
            return super.onTransact(r4, r5, r6, r7);
        L21:
            r6.writeString("com.obric.cae.libs.location.indoor.IStarIndoorCheckManager");
            return true;
        }
    }

    void a();

    void a(com.obric.cae.libs.location.indoor.a r1);

    void a(com.obric.cae.libs.location.indoor.a r1, String r2);
}
