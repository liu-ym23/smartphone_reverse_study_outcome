package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadNotificationEventAidlListener extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadNotificationEventAidlListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15502a = 0;

        public static class Proxy implements IDownloadNotificationEventAidlListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15503a;

            public Proxy(IBinder r5) {
                this.f15503a = r5;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
            public final void a(int r5, DownloadInfo r10, String r11, String r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");     // Catch: Throwable -> L6
                r13.writeInt(r5);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r13.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r13, 0);     // Catch: Throwable -> L6
            L9:
                r13.writeString(r11);     // Catch: Throwable -> L6
                r13.writeString(r12);     // Catch: Throwable -> L6
                if (this.f15503a.transact(1, r13, r14, 0) == true) goto L12;
                int r15 = Stub.f15502a;     // Catch: Throwable -> L6
            L12:
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L8:
                r13.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15503a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
            public final boolean b(boolean r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");     // Catch: Throwable -> L6
                r10.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L6
                boolean r12 = false;
                if (this.f15503a.transact(2, r10, r11, 0) == true) goto L8;
                int r13 = Stub.f15502a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() == 0) goto L11;
                r12 = true;
            L11:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
            public final String v() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");     // Catch: Throwable -> L6
                if (this.f15503a.transact(3, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15502a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                String r12 = r10.readString();     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r12;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
        }

        public static IDownloadNotificationEventAidlListener a(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            if (r10 == null) goto L12;
            if ((r10 instanceof IDownloadNotificationEventAidlListener) == false) goto L12;
            return (IDownloadNotificationEventAidlListener) r10;
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
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            int r13 = r10.readInt();
            if (r10.readInt() == 0) goto L25;
            DownloadInfo r14 = DownloadInfo.CREATOR.createFromParcel(r10);
        L26:
            a(r13, r14, r10.readString(), r10.readString());
            r11.writeNoException();
            return true;
        L25:
            r14 = null;
            goto L26
        L5:
            if (r5 != 2) goto L7;
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            if (r10.readInt() == 0) goto L19;
            boolean r15 = true;
        L20:
            boolean r16 = b(r15);
            r11.writeNoException();
            r11.writeInt(r16 ? 1 : 0);
            return true;
        L19:
            r15 = false;
            goto L20
        L7:
            if (r5 != 3) goto L9;
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            String r17 = v();
            r11.writeNoException();
            r11.writeString(r17);
            return true;
        L9:
            if (r5 != 1598968902) goto L11;
            r11.writeString("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            return true;
        L11:
            return super.onTransact(r5, r10, r11, r12);
        }
    }

    void a(int r5, DownloadInfo r10, String r11, String r12);

    boolean b(boolean r5);

    String v();
}
