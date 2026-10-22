package com.ss.android.socialbase.downloader.depend;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadAidlFileProvider extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadAidlFileProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15484a = 0;

        public static class Proxy implements IDownloadAidlFileProvider {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15485a;

            public Proxy(IBinder r5) {
                this.f15485a = r5;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15485a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider
            public final Uri b(String r5, String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");     // Catch: Throwable -> L6
                r11.writeString(r5);     // Catch: Throwable -> L6
                r11.writeString(r10);     // Catch: Throwable -> L6
                if (this.f15485a.transact(1, r11, r12, 0) == true) goto L8;
                int r13 = Stub.f15484a;     // Catch: Throwable -> L6
            L8:
                r12.readException();     // Catch: Throwable -> L6
                if (r12.readInt() == 0) goto L12;
                Uri r14 = (Uri) Uri.CREATOR.createFromParcel(r12);     // Catch: Throwable -> L6
            L13:
                r12.recycle();
                r11.recycle();
                return r14;
            L12:
                r14 = null;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        }

        public static IDownloadAidlFileProvider a(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            if (r10 == null) goto L12;
            if ((r10 instanceof IDownloadAidlFileProvider) == false) goto L12;
            return (IDownloadAidlFileProvider) r10;
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
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            Uri r13 = b(r10.readString(), r10.readString());
            r11.writeNoException();
            if (r13 == null) goto L13;
            r11.writeInt(1);
            r13.writeToParcel(r11, 1);
        L14:
            return true;
        L13:
            r11.writeInt(0);
            goto L14
        L5:
            if (r5 != 1598968902) goto L7;
            r11.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            return true;
        L7:
            return super.onTransact(r5, r10, r11, r12);
        }
    }

    Uri b(String r5, String r10);
}
