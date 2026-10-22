package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadDiskSpaceAidlHandler extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadDiskSpaceAidlHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15496a = 0;

        public static class Proxy implements IDownloadDiskSpaceAidlHandler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15497a;

            public Proxy(IBinder r5) {
                this.f15497a = r5;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler
            public final boolean a(long r5, long r10, IDownloadDiskSpaceAidlCallback r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");     // Catch: Throwable -> L6
                r12.writeLong(r5);     // Catch: Throwable -> L6
                r12.writeLong(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                IDownloadDiskSpaceAidlCallback.Stub r14 = (IDownloadDiskSpaceAidlCallback.Stub) r11;     // Catch: Throwable -> L6
            L9:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L6
                boolean r15 = false;
                if (this.f15497a.transact(1, r12, r13, 0) == true) goto L12;
                int r16 = Stub.f15496a;     // Catch: Throwable -> L6
            L12:
                r13.readException();     // Catch: Throwable -> L6
                if (r13.readInt() == 0) goto L15;
                r15 = true;
            L15:
                r13.recycle();
                r12.recycle();
                return r15;
            L8:
                r14 = null;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15497a;
            }
        }

        public Stub() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static IDownloadDiskSpaceAidlHandler a(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            if (r10 == null) goto L12;
            if ((r10 instanceof IDownloadDiskSpaceAidlHandler) == false) goto L12;
            return (IDownloadDiskSpaceAidlHandler) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            long r5 = r11.readLong();
            long r14 = r11.readLong();
            IBinder r15 = r11.readStrongBinder();
            if (r15 != null) goto L13;
            IDownloadDiskSpaceAidlCallback r16 = null;
        L20:
            boolean r17 = a(r5, r14, r16);
            r12.writeNoException();
            r12.writeInt(r17 ? 1 : 0);
            return true;
        L13:
            IInterface r18 = r15.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            if (r18 != null) goto L16;
        L19:
            IDownloadDiskSpaceAidlCallback r19 = new IDownloadDiskSpaceAidlCallback.Stub.Proxy(r15);
        L18:
            r16 = r19;
            goto L20
        L16:
            if ((r18 instanceof IDownloadDiskSpaceAidlCallback) == false) goto L19;
            r19 = (IDownloadDiskSpaceAidlCallback) r18;
            goto L18
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    boolean a(long r5, long r10, IDownloadDiskSpaceAidlCallback r11);
}
