package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface INotificationClickAidlCallback extends IInterface {

    public static abstract class Stub extends Binder implements INotificationClickAidlCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15504a = 0;

        public static class Proxy implements INotificationClickAidlCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15505a;

            public Proxy(IBinder r5) {
                this.f15505a = r5;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15505a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
            public final boolean c(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");     // Catch: Throwable -> L6
                boolean r12 = true;
                if (r5 == null) goto L8;
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f15505a.transact(1, r10, r11, 0) == true) goto L12;
                int r13 = Stub.f15504a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() != 0) goto L16;
                r12 = false;
            L16:
                r11.recycle();
                r10.recycle();
                return r12;
            L8:
                r10.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
            public final boolean h(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");     // Catch: Throwable -> L6
                boolean r12 = true;
                if (r5 == null) goto L8;
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f15505a.transact(3, r10, r11, 0) == true) goto L12;
                int r13 = Stub.f15504a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() != 0) goto L16;
                r12 = false;
            L16:
                r11.recycle();
                r10.recycle();
                return r12;
            L8:
                r10.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
            public final boolean o(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");     // Catch: Throwable -> L6
                boolean r12 = true;
                if (r5 == null) goto L8;
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f15505a.transact(2, r10, r11, 0) == true) goto L12;
                int r13 = Stub.f15504a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() != 0) goto L16;
                r12 = false;
            L16:
                r11.recycle();
                r10.recycle();
                return r12;
            L8:
                r10.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
        }

        public static INotificationClickAidlCallback a(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (r10 == null) goto L12;
            if ((r10 instanceof INotificationClickAidlCallback) == false) goto L12;
            return (INotificationClickAidlCallback) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) {
            DownloadInfo r13 = null;
            if (r5 != 1) goto L5;
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (r10.readInt() == 0) goto L27;
            r13 = DownloadInfo.CREATOR.createFromParcel(r10);
        L27:
            boolean r14 = c(r13);
            r11.writeNoException();
            r11.writeInt(r14 ? 1 : 0);
            return true;
        L5:
            if (r5 != 2) goto L7;
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (r10.readInt() == 0) goto L22;
            r13 = DownloadInfo.CREATOR.createFromParcel(r10);
        L22:
            boolean r15 = o(r13);
            r11.writeNoException();
            r11.writeInt(r15 ? 1 : 0);
            return true;
        L7:
            if (r5 != 3) goto L9;
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (r10.readInt() == 0) goto L17;
            r13 = DownloadInfo.CREATOR.createFromParcel(r10);
        L17:
            boolean r16 = h(r13);
            r11.writeNoException();
            r11.writeInt(r16 ? 1 : 0);
            return true;
        L9:
            if (r5 != 1598968902) goto L11;
            r11.writeString("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            return true;
        L11:
            return super.onTransact(r5, r10, r11, r12);
        }
    }

    boolean c(DownloadInfo r5);

    boolean h(DownloadInfo r5);

    boolean o(DownloadInfo r5);
}
