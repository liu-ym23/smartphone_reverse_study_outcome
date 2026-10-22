package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface ag extends IInterface {

    public static abstract class a extends Binder implements ag {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.ag$a$a, reason: collision with other inner class name */
        private static class C0813a implements ag {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static ag f15366a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15367b;

            C0813a(IBinder r3) {
                this.f15367b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.depend.ag
            public boolean a(DownloadInfo r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f15367b.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (a.a() == null) goto L14;
                boolean r4 = a.a().a(r5);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f15367b;
            }

            @Override // com.ss.android.socialbase.downloader.depend.ag
            public boolean b(DownloadInfo r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f15367b.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (a.a() == null) goto L14;
                boolean r5 = a.a().b(r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.ag
            public boolean c(DownloadInfo r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f15367b.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (a.a() == null) goto L14;
                boolean r5 = a.a().c(r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
        }

        public static ag a() {
            return C0813a.f15366a;
        }

        public static ag a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ag.class) == false) goto L13;
            return (ag) ZeusTransformUtils.preCheckCast(r0, ag.class, "com.obric.memorydata.plugin");
        L13:
            return new C0813a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            DownloadInfo r1 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (r7.readInt() == 0) goto L27;
            r1 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r7), DownloadInfo.class, "com.obric.memorydata.plugin");
        L27:
            boolean r5 = a(r1);
            r8.writeNoException();
            r8.writeInt(r5 ? 1 : 0);
            return true;
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (r7.readInt() == 0) goto L22;
            r1 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r7), DownloadInfo.class, "com.obric.memorydata.plugin");
        L22:
            boolean r10 = b(r1);
            r8.writeNoException();
            r8.writeInt(r10 ? 1 : 0);
            return true;
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (r7.readInt() == 0) goto L17;
            r1 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r7), DownloadInfo.class, "com.obric.memorydata.plugin");
        L17:
            boolean r11 = c(r1);
            r8.writeNoException();
            r8.writeInt(r11 ? 1 : 0);
            return true;
        L9:
            if (r6 != 1598968902) goto L11;
            r8.writeString("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            return true;
        L11:
            return super.onTransact(r6, r7, r8, r9);
        }
    }

    boolean a(DownloadInfo r1);

    boolean b(DownloadInfo r1);

    boolean c(DownloadInfo r1);
}
