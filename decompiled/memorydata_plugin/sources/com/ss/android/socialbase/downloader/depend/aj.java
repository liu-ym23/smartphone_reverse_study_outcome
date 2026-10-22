package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface aj extends IInterface {

    public static abstract class a extends Binder implements aj {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.aj$a$a, reason: collision with other inner class name */
        private static class C0814a implements aj {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static aj f15368a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15369b;

            C0814a(IBinder r3) {
                this.f15369b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.depend.aj
            public void a(int r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.f15369b.transact(1, r0, r1, 0) == false) goto L6;
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f15369b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        public static aj a() {
            return C0814a.f15368a;
        }

        public static aj a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, aj.class) == false) goto L13;
            return (aj) ZeusTransformUtils.preCheckCast(r0, aj.class, "com.obric.memorydata.plugin");
        L13:
            return new C0814a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            a(r5.readInt(), r5.readInt());
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(int r1, int r2);
}
