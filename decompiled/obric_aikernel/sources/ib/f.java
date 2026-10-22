package ib;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface f extends IInterface {

    public static abstract class a extends Binder implements f {

        /* JADX INFO: renamed from: ib.f$a$a, reason: collision with other inner class name */
        private static class C0189a implements f {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static f f9458g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9459c;

            C0189a(IBinder r10) {
                this.f9459c = r10;
            }

            @Override // ib.f
            public Uri K0(String r10, String r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");     // Catch: Throwable -> L17
                r12.writeString(r10);     // Catch: Throwable -> L17
                r12.writeString(r11);     // Catch: Throwable -> L17
                if (this.f9459c.transact(1, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L17
                if (r13.readInt() == 0) goto L14;
                Uri r14 = (Uri) Uri.CREATOR.createFromParcel(r13);     // Catch: Throwable -> L17
            L15:
                r13.recycle();
                r12.recycle();
                return r14;
            L14:
                r14 = null;
                goto L15
            L6:
                if (a.k1() == null) goto L10;
                Uri r15 = a.k1().K0(r10, r11);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return r15;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9459c;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        }

        public static f U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            if (r11 == null) goto L12;
            if ((r11 instanceof f) == false) goto L12;
            return (f) r11;
        L12:
            return new C0189a(r10);
        }

        public static f k1() {
            return C0189a.f9458g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            Uri r14 = K0(r11.readString(), r11.readString());
            r12.writeNoException();
            if (r14 == null) goto L13;
            r12.writeInt(1);
            r14.writeToParcel(r12, 1);
        L14:
            return true;
        L13:
            r12.writeInt(0);
            goto L14
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    Uri K0(String r10, String r11);
}
