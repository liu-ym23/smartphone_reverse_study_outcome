package ib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface c0 extends IInterface {

    public static abstract class a extends Binder implements c0 {

        /* JADX INFO: renamed from: ib.c0$a$a, reason: collision with other inner class name */
        private static class C0187a implements c0 {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static c0 f9454g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9455c;

            C0187a(IBinder r10) {
                this.f9455c = r10;
            }

            @Override // ib.c0
            public void C(int r10, DownloadInfo r11, String r12, String r13) {
                Parcel r14 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r14.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");     // Catch: Throwable -> L17
                r14.writeInt(r10);     // Catch: Throwable -> L17
                if (r11 == null) goto L6;
                r14.writeInt(1);     // Catch: Throwable -> L17
                r11.writeToParcel(r14, 0);     // Catch: Throwable -> L17
            L7:
                r14.writeString(r12);     // Catch: Throwable -> L17
                r14.writeString(r13);     // Catch: Throwable -> L17
                if (this.f9455c.transact(1, r14, r15, 0) == false) goto L10;
            L14:
                r15.readException();     // Catch: Throwable -> L17
                r15.recycle();
                r14.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().C(r10, r11, r12, r13);     // Catch: Throwable -> L17
                r15.recycle();
                r14.recycle();
                return;
            L6:
                r14.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r15.recycle();
                r14.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9455c;
            }

            @Override // ib.c0
            public String g0() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");     // Catch: Throwable -> L13
                if (this.f9455c.transact(3, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                String r12 = r11.readString();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (a.k1() == null) goto L10;
                String r13 = a.k1().g0();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // ib.c0
            public boolean s0(boolean r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");     // Catch: Throwable -> L20
                boolean r13 = true;
                if (r10 == false) goto L6;
                int r14 = 1;
            L7:
                r11.writeInt(r14);     // Catch: Throwable -> L20
                if (this.f9455c.transact(2, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L20
                if (r12.readInt() != 0) goto L18;
                r13 = false;
            L18:
                r12.recycle();
                r11.recycle();
                return r13;
            L10:
                if (a.k1() == null) goto L14;
                boolean r15 = a.k1().s0(r10);     // Catch: Throwable -> L20
                r12.recycle();
                r11.recycle();
                return r15;
            L6:
                r14 = 0;
            L20:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
        }

        public static c0 U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            if (r11 == null) goto L12;
            if ((r11 instanceof c0) == false) goto L12;
            return (c0) r11;
        L12:
            return new C0187a(r10);
        }

        public static c0 k1() {
            return C0187a.f9454g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            int r14 = r11.readInt();
            if (r11.readInt() == 0) goto L25;
            DownloadInfo r15 = DownloadInfo.CREATOR.createFromParcel(r11);
        L26:
            C(r14, r15, r11.readString(), r11.readString());
            r12.writeNoException();
            return true;
        L25:
            r15 = null;
            goto L26
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            if (r11.readInt() == 0) goto L19;
            boolean r16 = true;
        L20:
            boolean r17 = s0(r16);
            r12.writeNoException();
            r12.writeInt(r17 ? 1 : 0);
            return true;
        L19:
            r16 = false;
            goto L20
        L7:
            if (r10 != 3) goto L9;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            String r18 = g0();
            r12.writeNoException();
            r12.writeString(r18);
            return true;
        L9:
            if (r10 != 1598968902) goto L11;
            r12.writeString("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            return true;
        L11:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void C(int r10, DownloadInfo r11, String r12, String r13);

    String g0();

    boolean s0(boolean r10);
}
