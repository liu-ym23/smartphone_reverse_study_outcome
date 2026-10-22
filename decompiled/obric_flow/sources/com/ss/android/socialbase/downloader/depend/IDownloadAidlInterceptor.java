package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadAidlInterceptor extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadAidlInterceptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15486a = 0;

        public static class Proxy implements IDownloadAidlInterceptor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15487a;

            public Proxy(IBinder r5) {
                this.f15487a = r5;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15487a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor
            public final boolean t() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");     // Catch: Throwable -> L6
                boolean r11 = false;
                if (this.f15487a.transact(1, r5, r10, 0) == true) goto L8;
                int r12 = Stub.f15486a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                if (r10.readInt() == 0) goto L11;
                r11 = true;
            L11:
                r10.recycle();
                r5.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
        }

        public static IDownloadAidlInterceptor a(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            if (r10 == null) goto L12;
            if ((r10 instanceof IDownloadAidlInterceptor) == false) goto L12;
            return (IDownloadAidlInterceptor) r10;
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
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            boolean r13 = t();
            r11.writeNoException();
            r11.writeInt(r13 ? 1 : 0);
            return true;
        L5:
            if (r5 != 1598968902) goto L7;
            r11.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            return true;
        L7:
            return super.onTransact(r5, r10, r11, r12);
        }
    }

    boolean t();
}
