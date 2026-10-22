package android.view;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: android.view.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0017a extends Binder implements a {

        /* JADX INFO: renamed from: android.view.a$a$a, reason: collision with other inner class name */
        private static class aC0018a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f81a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f82b;

            aC0018a(IBinder r3) {
                this.f82b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.view.a
            public void a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.view.IFloatingTransitionCallback");     // Catch: Throwable -> L13
                if (this.f82b.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (AbstractBinderC0017a.c() == null) goto L10;
                AbstractBinderC0017a.c().a();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.a
            public boolean a(SurfaceControl r6, Bundle r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.view.IFloatingTransitionCallback");     // Catch: Throwable -> L23
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L7:
                if (r7 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L11:
                if (this.f82b.transact(2, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L23
                if (r1.readInt() != 0) goto L21;
                r2 = false;
            L21:
                r1.recycle();
                r0.recycle();
                return r2;
            L13:
                if (AbstractBinderC0017a.c() == null) goto L17;
                boolean r5 = AbstractBinderC0017a.c().a(r6, r7);     // Catch: Throwable -> L23
                r1.recycle();
                r0.recycle();
                return r5;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L23
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.a
            public boolean a(SurfaceControl r5, SurfaceControl r6, Bundle r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.view.IFloatingTransitionCallback");     // Catch: Throwable -> L26
                boolean r2 = true;
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L26
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L26
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L26
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L26
            L10:
                if (r7 == null) goto L12;
                r0.writeInt(1);     // Catch: Throwable -> L26
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L26
            L14:
                if (this.f82b.transact(1, r0, r1, 0) == false) goto L16;
            L20:
                r1.readException();     // Catch: Throwable -> L26
                if (r1.readInt() != 0) goto L24;
                r2 = false;
            L24:
                r1.recycle();
                r0.recycle();
                return r2;
            L16:
                if (AbstractBinderC0017a.c() == null) goto L20;
                boolean r4 = AbstractBinderC0017a.c().a(r5, r6, r7);     // Catch: Throwable -> L26
                r1.recycle();
                r0.recycle();
                return r4;
            L12:
                r0.writeInt(0);     // Catch: Throwable -> L26
                goto L14
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L26
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L26
            L26:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f82b;
            }

            @Override // android.view.a
            public void b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.view.IFloatingTransitionCallback");     // Catch: Throwable -> L13
                if (this.f82b.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (AbstractBinderC0017a.c() == null) goto L10;
                AbstractBinderC0017a.c().b();     // Catch: Throwable -> L13
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

        public AbstractBinderC0017a() {
            attachInterface(this, "android.view.IFloatingTransitionCallback");
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("android.view.IFloatingTransitionCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new aC0018a(r4);
        }

        public static a c() {
            return aC0018a.f81a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            Bundle r1 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface("android.view.IFloatingTransitionCallback");
            if (r7.readInt() == 0) goto L32;
            SurfaceControl r10 = (SurfaceControl) ZeusTransformUtils.preCheckCast(SurfaceControl.CREATOR.createFromParcel(r7), SurfaceControl.class, "com.obric.memorydata.plugin");
        L34:
            if (r7.readInt() == 0) goto L36;
            SurfaceControl r11 = (SurfaceControl) ZeusTransformUtils.preCheckCast(SurfaceControl.CREATOR.createFromParcel(r7), SurfaceControl.class, "com.obric.memorydata.plugin");
        L38:
            if (r7.readInt() == 0) goto L40;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L40:
            boolean r5 = a(r10, r11, r1);
            r8.writeNoException();
            r8.writeInt(r5 ? 1 : 0);
            return true;
        L36:
            r11 = null;
            goto L38
        L32:
            r10 = null;
            goto L34
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface("android.view.IFloatingTransitionCallback");
            if (r7.readInt() == 0) goto L23;
            SurfaceControl r12 = (SurfaceControl) ZeusTransformUtils.preCheckCast(SurfaceControl.CREATOR.createFromParcel(r7), SurfaceControl.class, "com.obric.memorydata.plugin");
        L25:
            if (r7.readInt() == 0) goto L27;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L27:
            boolean r13 = a(r12, r1);
            r8.writeNoException();
            r8.writeInt(r13 ? 1 : 0);
            return true;
        L23:
            r12 = null;
            goto L25
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface("android.view.IFloatingTransitionCallback");
            a();
        L17:
            r8.writeNoException();
            return true;
        L9:
            if (r6 != 4) goto L11;
            r7.enforceInterface("android.view.IFloatingTransitionCallback");
            b();
            goto L17
        L11:
            if (r6 != 1598968902) goto L13;
            r8.writeString("android.view.IFloatingTransitionCallback");
            return true;
        L13:
            return super.onTransact(r6, r7, r8, r9);
        }
    }

    void a();

    boolean a(SurfaceControl r1, Bundle r2);

    boolean a(SurfaceControl r1, SurfaceControl r2, Bundle r3);

    void b();
}
