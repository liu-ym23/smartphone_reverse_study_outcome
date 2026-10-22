package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface o extends IInterface {

    public static abstract class a extends Binder implements o {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.o$a$a, reason: collision with other inner class name */
        private static class C0821a implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static o f15382a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15383b;

            C0821a(IBinder r3) {
                this.f15383b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.depend.o
            public void a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");     // Catch: Throwable -> L13
                if (this.f15383b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.b() == null) goto L10;
                a.b().a();     // Catch: Throwable -> L13
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
                return this.f15383b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
        }

        public static o a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, o.class) == false) goto L13;
            return (o) ZeusTransformUtils.preCheckCast(r0, o.class, "com.obric.memorydata.plugin");
        L13:
            return new C0821a(r4);
        }

        public static o b() {
            return C0821a.f15382a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            a();
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a();
}
