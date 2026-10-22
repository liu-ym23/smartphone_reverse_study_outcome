package com.obric.memorydata.sdk.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.memorydata.sdk.screencapture.ScreenEventReaction;
import com.obric.memorydata.sdk.screencapture.TaskOptions;
import com.obric.memorydata.sdk.screencapture.c;
import com.obric.memorydata.sdk.screencapture.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.obric.memorydata.sdk.service.b$a$a, reason: collision with other inner class name */
        private static class C0704a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static b f12860a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f12861b;

            C0704a(IBinder r3) {
                this.f12861b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.memorydata.sdk.service.b
            public int a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.memorydata.sdk.service.IScreenCaptureService");     // Catch: Throwable -> L13
                if (this.f12861b.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.b() == null) goto L10;
                int r5 = a.b().a();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.service.b
            public void a(ScreenEventReaction r6, long r7, d r9) {
                d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.memorydata.sdk.service.IScreenCaptureService");     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L7:
                r0.writeLong(r7);     // Catch: Throwable -> L21
                if (r10 == null) goto L10;
                IBinder r4 = r10.asBinder();     // Catch: Throwable -> L21
            L11:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L21
                if (this.f12861b.transact(1, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (a.b() == null) goto L18;
                a.b().a(r6, r7, r10);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r4 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.service.b
            public void a(TaskOptions r5, String r6, c r7) {
                c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r7, c.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.memorydata.sdk.service.IScreenCaptureService");     // Catch: Throwable -> L21
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L7:
                r0.writeString(r6);     // Catch: Throwable -> L21
                if (r8 == null) goto L10;
                IBinder r3 = r8.asBinder();     // Catch: Throwable -> L21
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L21
                if (this.f12861b.transact(4, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (a.b() == null) goto L18;
                a.b().a(r5, r6, r8);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.service.b
            public void a(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.memorydata.sdk.service.IScreenCaptureService");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f12861b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.b() == null) goto L10;
                a.b().a(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12861b;
            }
        }

        public a() {
            attachInterface(this, "com.obric.memorydata.sdk.service.IScreenCaptureService");
        }

        public static b a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.memorydata.sdk.service.IScreenCaptureService");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0704a(r4);
        }

        public static b b() {
            return C0704a.f12860a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            ScreenEventReaction r1 = null;
            TaskOptions r2 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface("com.obric.memorydata.sdk.service.IScreenCaptureService");
            if (r7.readInt() == 0) goto L28;
            r1 = (ScreenEventReaction) ZeusTransformUtils.preCheckCast(ScreenEventReaction.CREATOR.createFromParcel(r7), ScreenEventReaction.class, "com.obric.memorydata.plugin");
        L28:
            a(r1, r7.readLong(), d.a.a(r7.readStrongBinder()));
            r8.writeNoException();
            return true;
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface("com.obric.memorydata.sdk.service.IScreenCaptureService");
            a(r7.readString());
            r8.writeNoException();
            return true;
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface("com.obric.memorydata.sdk.service.IScreenCaptureService");
            int r5 = a();
            r8.writeNoException();
            r8.writeInt(r5);
            return true;
        L9:
            if (r6 != 4) goto L11;
            r7.enforceInterface("com.obric.memorydata.sdk.service.IScreenCaptureService");
            if (r7.readInt() == 0) goto L19;
            r2 = (TaskOptions) ZeusTransformUtils.preCheckCast(TaskOptions.CREATOR.createFromParcel(r7), TaskOptions.class, "com.obric.memorydata.plugin");
        L19:
            a(r2, r7.readString(), c.a.a(r7.readStrongBinder()));
            r8.writeNoException();
            return true;
        L11:
            if (r6 != 1598968902) goto L13;
            r8.writeString("com.obric.memorydata.sdk.service.IScreenCaptureService");
            return true;
        L13:
            return super.onTransact(r6, r7, r8, r9);
        }
    }

    int a();

    void a(ScreenEventReaction r1, long r2, d r4);

    void a(TaskOptions r1, String r2, c r3);

    void a(String r1);
}
