package com.obric.aikernel;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.obric.aikernel.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0246a extends Binder implements a {

        /* JADX INFO: renamed from: com.obric.aikernel.a$a$a, reason: collision with other inner class name */
        private static class C0247a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f5978a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f5979b;

            C0247a(IBinder r3) {
                this.f5979b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.aikernel.a
            public Bundle a(Bundle r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aikernel.AIKBinder");     // Catch: Throwable -> L21
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L8:
                if (this.f5979b.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                Bundle r4 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r1), Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L19
            L10:
                if (AbstractBinderC0246a.a() == null) goto L14;
                Bundle r6 = AbstractBinderC0246a.a().a(r5);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aikernel.a
            public void a(Bundle r5, b r6) {
                b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aikernel.AIKBinder");     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r7 == null) goto L9;
                IBinder r3 = r7.asBinder();     // Catch: Throwable -> L20
            L10:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.f5979b.transact(2, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (AbstractBinderC0246a.a() == null) goto L17;
                AbstractBinderC0246a.a().a(r5, r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r3 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5979b;
            }

            @Override // com.obric.aikernel.a
            public void b(Bundle r5, b r6) {
                b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aikernel.AIKBinder");     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r7 == null) goto L9;
                IBinder r3 = r7.asBinder();     // Catch: Throwable -> L20
            L10:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.f5979b.transact(3, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (AbstractBinderC0246a.a() == null) goto L17;
                AbstractBinderC0246a.a().b(r5, r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r3 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public static a a() {
            return C0247a.f5978a;
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.aikernel.AIKBinder");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0247a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            Bundle r1 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface("com.obric.aikernel.AIKBinder");
            if (r7.readInt() == 0) goto L27;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L27:
            Bundle r5 = a(r1);
            r8.writeNoException();
            if (r5 == null) goto L30;
            r8.writeInt(1);
            r5.writeToParcel(r8, 1);
        L31:
            return true;
        L30:
            r8.writeInt(0);
            goto L31
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface("com.obric.aikernel.AIKBinder");
            if (r7.readInt() == 0) goto L23;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L23:
            a(r1, b.a.asInterface(r7.readStrongBinder()));
        L18:
            r8.writeNoException();
            return true;
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface("com.obric.aikernel.AIKBinder");
            if (r7.readInt() == 0) goto L17;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L17:
            b(r1, b.a.asInterface(r7.readStrongBinder()));
            goto L18
        L9:
            if (r6 != 1598968902) goto L11;
            r8.writeString("com.obric.aikernel.AIKBinder");
            return true;
        L11:
            return super.onTransact(r6, r7, r8, r9);
        }
    }

    Bundle a(Bundle r1);

    void a(Bundle r1, b r2);

    void b(Bundle r1, b r2);
}
