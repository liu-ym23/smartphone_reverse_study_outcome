package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadForbiddenAidlCallback extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadForbiddenAidlCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15498a = 0;

        public static class Proxy implements IDownloadForbiddenAidlCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15499a;

            public Proxy(IBinder r5) {
                this.f15499a = r5;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15499a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
            public final void c(ArrayList r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");     // Catch: Throwable -> L6
                r10.writeStringList(r5);     // Catch: Throwable -> L6
                if (this.f15499a.transact(1, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15498a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
            public final boolean h() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");     // Catch: Throwable -> L6
                boolean r11 = false;
                if (this.f15499a.transact(2, r5, r10, 0) == true) goto L8;
                int r12 = Stub.f15498a;     // Catch: Throwable -> L6
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) {
            if (r5 != 1) goto L5;
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            c(r10.createStringArrayList());
            r11.writeNoException();
            return true;
        L5:
            if (r5 != 2) goto L7;
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            boolean r13 = h();
            r11.writeNoException();
            r11.writeInt(r13 ? 1 : 0);
            return true;
        L7:
            if (r5 != 1598968902) goto L9;
            r11.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            return true;
        L9:
            return super.onTransact(r5, r10, r11, r12);
        }
    }

    void c(ArrayList r5);

    boolean h();
}
