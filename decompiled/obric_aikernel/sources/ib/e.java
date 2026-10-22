package ib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface e extends IInterface {

    public static abstract class a extends Binder implements e {

        /* JADX INFO: renamed from: ib.e$a$a, reason: collision with other inner class name */
        private static class C0188a implements e {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static e f9456g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9457c;

            C0188a(IBinder r10) {
                this.f9457c = r10;
            }

            @Override // ib.e
            public void E0(DownloadInfo r10, BaseException r11, int r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");     // Catch: Throwable -> L20
                if (r10 == null) goto L6;
                r13.writeInt(1);     // Catch: Throwable -> L20
                r10.writeToParcel(r13, 0);     // Catch: Throwable -> L20
            L7:
                if (r11 == null) goto L9;
                r13.writeInt(1);     // Catch: Throwable -> L20
                r11.writeToParcel(r13, 0);     // Catch: Throwable -> L20
            L10:
                r13.writeInt(r12);     // Catch: Throwable -> L20
                if (this.f9457c.transact(1, r13, r14, 0) == false) goto L13;
            L17:
                r14.readException();     // Catch: Throwable -> L20
                r14.recycle();
                r13.recycle();
                return;
            L13:
                if (a.k1() == null) goto L17;
                a.k1().E0(r10, r11, r12);     // Catch: Throwable -> L20
                r14.recycle();
                r13.recycle();
                return;
            L9:
                r13.writeInt(0);     // Catch: Throwable -> L20
                goto L10
            L6:
                r13.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9457c;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
        }

        public static e U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            if (r11 == null) goto L12;
            if ((r11 instanceof e) == false) goto L12;
            return (e) r11;
        L12:
            return new C0188a(r10);
        }

        public static e k1() {
            return C0188a.f9456g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            BaseException r14 = null;
            if (r11.readInt() == 0) goto L13;
            DownloadInfo r15 = DownloadInfo.CREATOR.createFromParcel(r11);
        L15:
            if (r11.readInt() == 0) goto L17;
            r14 = BaseException.CREATOR.createFromParcel(r11);
        L17:
            E0(r15, r14, r11.readInt());
            r12.writeNoException();
            return true;
        L13:
            r15 = null;
            goto L15
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void E0(DownloadInfo r10, BaseException r11, int r12);
}
