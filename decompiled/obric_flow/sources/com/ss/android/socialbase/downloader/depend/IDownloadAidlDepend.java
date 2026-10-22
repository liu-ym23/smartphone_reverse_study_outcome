package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadAidlDepend extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadAidlDepend {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15482a = 0;

        public static class Proxy implements IDownloadAidlDepend {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15483a;

            public Proxy(IBinder r5) {
                this.f15483a = r5;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend
            public final void a(DownloadInfo r5, BaseException r10, int r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L9:
                if (r10 == null) goto L11;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r12.writeInt(r10.f15601a);     // Catch: Throwable -> L6
                r12.writeString(r10.f15602b);     // Catch: Throwable -> L6
                r12.writeString(r10.f15603c);     // Catch: Throwable -> L6
            L12:
                r12.writeInt(r11);     // Catch: Throwable -> L6
                if (this.f15483a.transact(1, r12, r13, 0) == true) goto L15;
                int r14 = Stub.f15482a;     // Catch: Throwable -> L6
            L15:
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L11:
                r12.writeInt(0);     // Catch: Throwable -> L6
                goto L12
            L8:
                r12.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15483a;
            }
        }

        public Stub() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
        }

        public static IDownloadAidlDepend a(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            if (r10 == null) goto L12;
            if ((r10 instanceof IDownloadAidlDepend) == false) goto L12;
            return (IDownloadAidlDepend) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) {
            if (r5 != 1) goto L5;
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            BaseException r13 = null;
            if (r10.readInt() == 0) goto L13;
            DownloadInfo r14 = DownloadInfo.CREATOR.createFromParcel(r10);
        L15:
            if (r10.readInt() == 0) goto L17;
            r13 = BaseException.CREATOR.createFromParcel(r10);
        L17:
            a(r14, r13, r10.readInt());
            r11.writeNoException();
            return true;
        L13:
            r14 = null;
            goto L15
        L5:
            if (r5 != 1598968902) goto L7;
            r11.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            return true;
        L7:
            return super.onTransact(r5, r10, r11, r12);
        }
    }

    void a(DownloadInfo r5, BaseException r10, int r11);
}
