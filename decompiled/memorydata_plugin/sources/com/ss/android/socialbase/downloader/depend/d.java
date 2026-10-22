package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.d$a$a, reason: collision with other inner class name */
        private static class C0815a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static d f15370a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15371b;

            C0815a(IBinder r3) {
                this.f15371b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.depend.d
            public void a(DownloadInfo r5, BaseException r6, int r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L10:
                r0.writeInt(r7);     // Catch: Throwable -> L20
                if (this.f15371b.transact(1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (a.a() == null) goto L17;
                a.a().a(r5, r6, r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L20
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
                return this.f15371b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
        }

        public static d a() {
            return C0815a.f15370a;
        }

        public static d a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L13;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin");
        L13:
            return new C0815a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            BaseException r1 = null;
            if (r5.readInt() == 0) goto L13;
            DownloadInfo r8 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r5), DownloadInfo.class, "com.obric.memorydata.plugin");
        L15:
            if (r5.readInt() == 0) goto L17;
            r1 = (BaseException) ZeusTransformUtils.preCheckCast(BaseException.CREATOR.createFromParcel(r5), BaseException.class, "com.obric.memorydata.plugin");
        L17:
            a(r8, r1, r5.readInt());
            r6.writeNoException();
            return true;
        L13:
            r8 = null;
            goto L15
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(DownloadInfo r1, BaseException r2, int r3);
}
