package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadForbiddenAidlHandler extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadForbiddenAidlHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15500a = 0;

        public static class Proxy implements IDownloadForbiddenAidlHandler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15501a;

            public Proxy(IBinder r5) {
                this.f15501a = r5;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler
            public final boolean a(IDownloadForbiddenAidlCallback r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                IBinder r12 = r5.asBinder();     // Catch: Throwable -> L6
            L9:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L6
                boolean r13 = false;
                if (this.f15501a.transact(1, r10, r11, 0) == true) goto L12;
                int r14 = Stub.f15500a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() == 0) goto L15;
                r13 = true;
            L15:
                r11.recycle();
                r10.recycle();
                return r13;
            L8:
                r12 = null;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15501a;
            }
        }

        public Stub() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static IDownloadForbiddenAidlHandler a(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            if (r10 == null) goto L12;
            if ((r10 instanceof IDownloadForbiddenAidlHandler) == false) goto L12;
            return (IDownloadForbiddenAidlHandler) r10;
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
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            IBinder r13 = r10.readStrongBinder();
            if (r13 != null) goto L13;
            IDownloadForbiddenAidlCallback r14 = null;
        L19:
            boolean r15 = a(r14);
            r11.writeNoException();
            r11.writeInt(r15 ? 1 : 0);
            return true;
        L13:
            IInterface r16 = r13.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            if (r16 != null) goto L16;
        L18:
            r14 = new IDownloadForbiddenAidlCallback.Stub.Proxy(r13);
            goto L19
        L16:
            if ((r16 instanceof IDownloadForbiddenAidlCallback) == false) goto L18;
            r14 = (IDownloadForbiddenAidlCallback) r16;
            goto L19
        L5:
            if (r5 != 1598968902) goto L7;
            r11.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            return true;
        L7:
            return super.onTransact(r5, r10, r11, r12);
        }
    }

    boolean a(IDownloadForbiddenAidlCallback r5);
}
