package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface h extends IInterface {

    public static abstract class a extends Binder implements h {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.h$a$a, reason: collision with other inner class name */
        private static class C0819a implements h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static h f15378a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15379b;

            C0819a(IBinder r3) {
                this.f15379b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.depend.h
            public String a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");     // Catch: Throwable -> L13
                if (this.f15379b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.c() == null) goto L10;
                String r5 = a.c().a();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.h
            public void a(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f15379b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.c() == null) goto L10;
                a.c().a(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f15379b;
            }

            @Override // com.ss.android.socialbase.downloader.depend.h
            public int[] b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");     // Catch: Throwable -> L13
                if (this.f15379b.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int[] r4 = r1.createIntArray();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.c() == null) goto L10;
                int[] r5 = a.c().b();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
        }

        public static h a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, h.class) == false) goto L13;
            return (h) ZeusTransformUtils.preCheckCast(r0, h.class, "com.obric.memorydata.plugin");
        L13:
            return new C0819a(r4);
        }

        public static h c() {
            return C0819a.f15378a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            a(r5.readString());
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            String r3 = a();
            r6.writeNoException();
            r6.writeString(r3);
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            int[] r8 = b();
            r6.writeNoException();
            r6.writeIntArray(r8);
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    String a();

    void a(String r1);

    int[] b();
}
