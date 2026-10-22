package android.view;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: android.view.b$a$a, reason: collision with other inner class name */
        private static class bC0019a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static b f83a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f84b;

            bC0019a(IBinder r3) {
                this.f84b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.view.b
            public void a(IBinder r5) {
                IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.view.IFloatingTransitionSession");     // Catch: Throwable -> L13
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L13
                if (this.f84b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.a() == null) goto L10;
                a.a().a(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.b
            public void a(IBinder r5, Bundle r6) {
                IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.view.IFloatingTransitionSession");     // Catch: Throwable -> L17
                r0.writeStrongBinder(r7);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f84b.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.a() == null) goto L14;
                a.a().a(r7, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.b
            public boolean a(IBinder r5, android.view.a r6, c r7) {
                IBinder r8 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.memorydata.plugin");
                android.view.a r9 = (android.view.a) ZeusTransformUtils.wrapperContextForParams(r6, android.view.a.class, "com.obric.memorydata.plugin");
                c r10 = (c) ZeusTransformUtils.wrapperContextForParams(r7, c.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.view.IFloatingTransitionSession");     // Catch: Throwable -> L22
                r0.writeStrongBinder(r8);     // Catch: Throwable -> L22
                IBinder r2 = null;
                if (r9 == null) goto L6;
                IBinder r3 = r9.asBinder();     // Catch: Throwable -> L22
            L7:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L22
                if (r10 == null) goto L10;
                r2 = r10.asBinder();     // Catch: Throwable -> L22
            L10:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L22
                boolean r4 = false;
                if (this.f84b.transact(1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L22
                if (r1.readInt() == 0) goto L20;
                r4 = true;
            L20:
                r1.recycle();
                r0.recycle();
                return r4;
            L13:
                if (a.a() == null) goto L17;
                boolean r11 = a.a().a(r8, r9, r10);     // Catch: Throwable -> L22
                r1.recycle();
                r0.recycle();
                return r11;
            L6:
                r3 = null;
            L22:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f84b;
            }

            @Override // android.view.b
            public void b(IBinder r5) {
                IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.view.IFloatingTransitionSession");     // Catch: Throwable -> L13
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L13
                if (this.f84b.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.a() == null) goto L10;
                a.a().b(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.b
            public void c(IBinder r5) {
                IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.view.IFloatingTransitionSession");     // Catch: Throwable -> L13
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L13
                if (this.f84b.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.a() == null) goto L10;
                a.a().c(r6);     // Catch: Throwable -> L13
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

        public static b a() {
            return bC0019a.f83a;
        }

        public static b d(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("android.view.IFloatingTransitionSession");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new bC0019a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("android.view.IFloatingTransitionSession");
            boolean r3 = a(r5.readStrongBinder(), android.view.a.AbstractBinderC0017a.a(r5.readStrongBinder()), c.a.a(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface("android.view.IFloatingTransitionSession");
            a(r5.readStrongBinder());
        L19:
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface("android.view.IFloatingTransitionSession");
            IBinder r8 = r5.readStrongBinder();
            if (r5.readInt() == 0) goto L25;
            Bundle r9 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r5), Bundle.class, "com.obric.memorydata.plugin");
        L26:
            a(r8, r9);
            goto L19
        L25:
            r9 = null;
            goto L26
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface("android.view.IFloatingTransitionSession");
            b(r5.readStrongBinder());
            goto L19
        L11:
            if (r4 != 5) goto L13;
            r5.enforceInterface("android.view.IFloatingTransitionSession");
            c(r5.readStrongBinder());
            goto L19
        L13:
            if (r4 != 1598968902) goto L15;
            r6.writeString("android.view.IFloatingTransitionSession");
            return true;
        L15:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(IBinder r1);

    void a(IBinder r1, Bundle r2);

    boolean a(IBinder r1, android.view.a r2, c r3);

    void b(IBinder r1);

    void c(IBinder r1);
}
