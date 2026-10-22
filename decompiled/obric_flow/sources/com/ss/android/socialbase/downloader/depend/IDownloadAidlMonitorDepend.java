package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadAidlMonitorDepend extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadAidlMonitorDepend {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15490a = 0;

        public static class Proxy implements IDownloadAidlMonitorDepend {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15491a;

            public Proxy(IBinder r5) {
                this.f15491a = r5;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15491a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
            public final void e(String r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");     // Catch: Throwable -> L6
                r10.writeString(r5);     // Catch: Throwable -> L6
                if (this.f15491a.transact(1, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15490a;     // Catch: Throwable -> L6
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
            public final String g() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");     // Catch: Throwable -> L6
                if (this.f15491a.transact(2, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15490a;     // Catch: Throwable -> L6
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
            public final int[] l() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");     // Catch: Throwable -> L6
                if (this.f15491a.transact(3, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15490a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                int[] r12 = r10.createIntArray();     // Catch: Throwable -> L6
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
        }

        public static IDownloadAidlMonitorDepend a(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            if (r10 == null) goto L12;
            if ((r10 instanceof IDownloadAidlMonitorDepend) == false) goto L12;
            return (IDownloadAidlMonitorDepend) r10;
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
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            e(r10.readString());
            r11.writeNoException();
            return true;
        L5:
            if (r5 != 2) goto L7;
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            String r13 = g();
            r11.writeNoException();
            r11.writeString(r13);
            return true;
        L7:
            if (r5 != 3) goto L9;
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            int[] r14 = l();
            r11.writeNoException();
            r11.writeIntArray(r14);
            return true;
        L9:
            if (r5 != 1598968902) goto L11;
            r11.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            return true;
        L11:
            return super.onTransact(r5, r10, r11, r12);
        }
    }

    void e(String r5);

    String g();

    int[] l();
}
