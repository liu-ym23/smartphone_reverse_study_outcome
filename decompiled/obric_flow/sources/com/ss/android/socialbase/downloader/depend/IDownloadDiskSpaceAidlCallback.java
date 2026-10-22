package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadDiskSpaceAidlCallback extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadDiskSpaceAidlCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15494a = 0;

        public static class Proxy implements IDownloadDiskSpaceAidlCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15495a;

            public Proxy(IBinder r5) {
                this.f15495a = r5;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15495a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback
            public final void f() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");     // Catch: Throwable -> L6
                if (this.f15495a.transact(1, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15494a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) {
            if (r5 != 1) goto L5;
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            f();
            r11.writeNoException();
            return true;
        L5:
            if (r5 != 1598968902) goto L7;
            r11.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            return true;
        L7:
            return super.onTransact(r5, r10, r11, r12);
        }
    }

    void f();
}
