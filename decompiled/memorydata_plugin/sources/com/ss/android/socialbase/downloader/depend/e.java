package com.ss.android.socialbase.downloader.depend;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface e extends IInterface {

    public static abstract class a extends Binder implements e {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.e$a$a, reason: collision with other inner class name */
        private static class C0816a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static e f15372a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15373b;

            C0816a(IBinder r3) {
                this.f15373b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.depend.e
            public Uri a(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (this.f15373b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Uri r4 = (Uri) ZeusTransformUtils.preCheckCast(Uri.CREATOR.createFromParcel(r1), Uri.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (a.a() == null) goto L10;
                Uri r7 = a.a().a(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f15373b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        }

        public static e a() {
            return C0816a.f15372a;
        }

        public static e a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, e.class) == false) goto L13;
            return (e) ZeusTransformUtils.preCheckCast(r0, e.class, "com.obric.memorydata.plugin");
        L13:
            return new C0816a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            Uri r3 = a(r5.readString(), r5.readString());
            r6.writeNoException();
            if (r3 == null) goto L13;
            r6.writeInt(1);
            r3.writeToParcel(r6, 1);
        L14:
            return true;
        L13:
            r6.writeInt(0);
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    Uri a(String r1, String r2);
}
