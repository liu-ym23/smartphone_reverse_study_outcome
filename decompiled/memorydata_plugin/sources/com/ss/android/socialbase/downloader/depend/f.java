package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface f extends IInterface {

    public static abstract class a extends Binder implements f {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.f$a$a, reason: collision with other inner class name */
        private static class C0817a implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static f f15374a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15375b;

            C0817a(IBinder r3) {
                this.f15375b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.depend.f
            public boolean a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");     // Catch: Throwable -> L15
                boolean r2 = false;
                if (this.f15375b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r2 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (a.b() == null) goto L10;
                boolean r4 = a.b().a();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f15375b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
        }

        public static f a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L13;
            return (f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.memorydata.plugin");
        L13:
            return new C0817a(r4);
        }

        public static f b() {
            return C0817a.f15374a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            boolean r3 = a();
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    boolean a();
}
