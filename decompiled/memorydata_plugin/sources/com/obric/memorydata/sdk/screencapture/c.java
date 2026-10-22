package com.obric.memorydata.sdk.screencapture;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: com.obric.memorydata.sdk.screencapture.c$a$a, reason: collision with other inner class name */
        private static class C0700a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static c f12846a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f12847b;

            C0700a(IBinder r3) {
                this.f12847b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.memorydata.sdk.screencapture.c
            public void a(int r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.memorydata.sdk.screencapture.ICaptureCurrentCallback");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.f12847b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.a() == null) goto L10;
                a.a().a(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.screencapture.c
            public void a(ScreenData r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.memorydata.sdk.screencapture.ICaptureCurrentCallback");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f12847b.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.a() == null) goto L14;
                a.a().a(r5);     // Catch: Throwable -> L17
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12847b;
            }
        }

        public a() {
            attachInterface(this, "com.obric.memorydata.sdk.screencapture.ICaptureCurrentCallback");
        }

        public static c a() {
            return C0700a.f12846a;
        }

        public static c a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.memorydata.sdk.screencapture.ICaptureCurrentCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L13;
            return (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
        L13:
            return new C0700a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.memorydata.sdk.screencapture.ICaptureCurrentCallback");
            if (r5.readInt() == 0) goto L18;
            ScreenData r8 = (ScreenData) ZeusTransformUtils.preCheckCast(ScreenData.CREATOR.createFromParcel(r5), ScreenData.class, "com.obric.memorydata.plugin");
        L19:
            a(r8);
        L13:
            r6.writeNoException();
            return true;
        L18:
            r8 = null;
            goto L19
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface("com.obric.memorydata.sdk.screencapture.ICaptureCurrentCallback");
            a(r5.readInt(), r5.readString());
            goto L13
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString("com.obric.memorydata.sdk.screencapture.ICaptureCurrentCallback");
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(int r1, String r2);

    void a(ScreenData r1);
}
