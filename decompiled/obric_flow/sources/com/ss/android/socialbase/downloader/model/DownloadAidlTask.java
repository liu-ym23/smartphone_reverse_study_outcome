package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;

/* JADX INFO: loaded from: classes3.dex */
public interface DownloadAidlTask extends IInterface {

    public static abstract class Stub extends Binder implements DownloadAidlTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15800a = 0;

        public static class Proxy implements DownloadAidlTask {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15801a;

            public Proxy(IBinder r5) {
                this.f15801a = r5;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15801a;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public final IDownloadAidlListener c(int r5, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L6
                r11.writeInt(r5);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                if (this.f15801a.transact(3, r11, r12, 0) == true) goto L8;
                int r13 = Stub.f15800a;     // Catch: Throwable -> L6
            L8:
                r12.readException();     // Catch: Throwable -> L6
                IDownloadAidlListener r14 = IDownloadAidlListener.Stub.a(r12.readStrongBinder());     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r14;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public final int i() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L6
                if (this.f15801a.transact(13, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15800a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                int r12 = r10.readInt();     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r12;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public final INotificationClickAidlCallback k() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L6
                if (this.f15801a.transact(6, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15800a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                INotificationClickAidlCallback r12 = INotificationClickAidlCallback.Stub.a(r10.readStrongBinder());     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r12;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public final IDownloadAidlListener l(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                if (this.f15801a.transact(4, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15800a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                IDownloadAidlListener r13 = IDownloadAidlListener.Stub.a(r11.readStrongBinder());     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r13;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public final DownloadInfo m() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L6
                if (this.f15801a.transact(1, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15800a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                if (r10.readInt() == 0) goto L12;
                DownloadInfo r12 = DownloadInfo.CREATOR.createFromParcel(r10);     // Catch: Throwable -> L6
            L13:
                r10.recycle();
                r5.recycle();
                return r12;
            L12:
                r12 = null;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public final IDownloadAidlFileProvider n() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L6
                if (this.f15801a.transact(12, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15800a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                IDownloadAidlFileProvider r12 = IDownloadAidlFileProvider.Stub.a(r10.readStrongBinder());     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r12;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public final IDownloadForbiddenAidlHandler o() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L6
                if (this.f15801a.transact(9, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15800a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                IDownloadForbiddenAidlHandler r12 = IDownloadForbiddenAidlHandler.Stub.a(r10.readStrongBinder());     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r12;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public final IDownloadAidlInterceptor p() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L6
                if (this.f15801a.transact(7, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15800a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                IDownloadAidlInterceptor r12 = IDownloadAidlInterceptor.Stub.a(r10.readStrongBinder());     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r12;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public final IDownloadDiskSpaceAidlHandler q() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L6
                if (this.f15801a.transact(10, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15800a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                IDownloadDiskSpaceAidlHandler r12 = IDownloadDiskSpaceAidlHandler.Stub.a(r10.readStrongBinder());     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r12;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public final IDownloadAidlMonitorDepend r() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L6
                if (this.f15801a.transact(11, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15800a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                IDownloadAidlMonitorDepend r12 = IDownloadAidlMonitorDepend.Stub.a(r10.readStrongBinder());     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r12;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public final IDownloadNotificationEventAidlListener s() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L6
                if (this.f15801a.transact(5, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15800a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                IDownloadNotificationEventAidlListener r12 = IDownloadNotificationEventAidlListener.Stub.a(r10.readStrongBinder());     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r12;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public final IDownloadAidlDepend u() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L6
                if (this.f15801a.transact(8, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15800a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                IDownloadAidlDepend r12 = IDownloadAidlDepend.Stub.a(r10.readStrongBinder());     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r12;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public final IDownloadCompleteAidlHandler n(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                if (this.f15801a.transact(14, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15800a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                IDownloadCompleteAidlHandler r13 = IDownloadCompleteAidlHandler.Stub.a(r11.readStrongBinder());     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r13;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public final int[] m(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                if (this.f15801a.transact(2, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15800a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                int[] r13 = r11.createIntArray();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r13;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static DownloadAidlTask a(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (r10 == null) goto L12;
            if ((r10 instanceof DownloadAidlTask) == false) goto L12;
            return (DownloadAidlTask) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) {
            if (r5 == 1598968902) goto L72;
            IBinder r13 = null;
            switch(r5) {
                case 1: goto L67;
                case 2: goto L65;
                case 3: goto L60;
                case 4: goto L55;
                case 5: goto L50;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L35;
                case 9: goto L30;
                case 10: goto L25;
                case 11: goto L20;
                case 12: goto L15;
                case 13: goto L13;
                case 14: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            IDownloadCompleteAidlHandler r14 = n(r10.readInt());
            r11.writeNoException();
            if (r14 == null) goto L11;
            r13 = (IDownloadCompleteAidlHandler.Stub) r14;
        L11:
            r11.writeStrongBinder(r13);
            return true;
        L13:
            r10.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            int r15 = i();
            r11.writeNoException();
            r11.writeInt(r15);
            return true;
        L15:
            r10.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            IDownloadAidlFileProvider r16 = n();
            r11.writeNoException();
            if (r16 == null) goto L18;
            r13 = (IDownloadAidlFileProvider.Stub) r16;
        L18:
            r11.writeStrongBinder(r13);
            return true;
        L20:
            r10.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            IDownloadAidlMonitorDepend r17 = r();
            r11.writeNoException();
            if (r17 == null) goto L23;
            r13 = (IDownloadAidlMonitorDepend.Stub) r17;
        L23:
            r11.writeStrongBinder(r13);
            return true;
        L25:
            r10.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            IDownloadDiskSpaceAidlHandler r18 = q();
            r11.writeNoException();
            if (r18 == null) goto L28;
            r13 = (IDownloadDiskSpaceAidlHandler.Stub) r18;
        L28:
            r11.writeStrongBinder(r13);
            return true;
        L30:
            r10.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            IDownloadForbiddenAidlHandler r19 = o();
            r11.writeNoException();
            if (r19 == null) goto L33;
            r13 = (IDownloadForbiddenAidlHandler.Stub) r19;
        L33:
            r11.writeStrongBinder(r13);
            return true;
        L35:
            r10.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            IDownloadAidlDepend r20 = u();
            r11.writeNoException();
            if (r20 == null) goto L38;
            r13 = (IDownloadAidlDepend.Stub) r20;
        L38:
            r11.writeStrongBinder(r13);
            return true;
        L40:
            r10.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            IDownloadAidlInterceptor r21 = p();
            r11.writeNoException();
            if (r21 == null) goto L43;
            r13 = (IDownloadAidlInterceptor.Stub) r21;
        L43:
            r11.writeStrongBinder(r13);
            return true;
        L45:
            r10.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            INotificationClickAidlCallback r22 = k();
            r11.writeNoException();
            if (r22 == null) goto L48;
            r13 = (INotificationClickAidlCallback.Stub) r22;
        L48:
            r11.writeStrongBinder(r13);
            return true;
        L50:
            r10.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            IDownloadNotificationEventAidlListener r23 = s();
            r11.writeNoException();
            if (r23 == null) goto L53;
            r13 = (IDownloadNotificationEventAidlListener.Stub) r23;
        L53:
            r11.writeStrongBinder(r13);
            return true;
        L55:
            r10.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            IDownloadAidlListener r24 = l(r10.readInt());
            r11.writeNoException();
            if (r24 == null) goto L58;
            r13 = (IDownloadAidlListener.Stub) r24;
        L58:
            r11.writeStrongBinder(r13);
            return true;
        L60:
            r10.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            IDownloadAidlListener r25 = c(r10.readInt(), r10.readInt());
            r11.writeNoException();
            if (r25 == null) goto L63;
            r13 = (IDownloadAidlListener.Stub) r25;
        L63:
            r11.writeStrongBinder(r13);
            return true;
        L65:
            r10.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            int[] r26 = m(r10.readInt());
            r11.writeNoException();
            r11.writeIntArray(r26);
            return true;
        L67:
            r10.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            DownloadInfo r27 = m();
            r11.writeNoException();
            if (r27 == null) goto L70;
            r11.writeInt(1);
            r27.writeToParcel(r11, 1);
        L71:
            return true;
        L70:
            r11.writeInt(0);
            goto L71
        L7:
            return super.onTransact(r5, r10, r11, r12);
        L72:
            r11.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            return true;
        }
    }

    IDownloadAidlListener c(int r5, int r10);

    int i();

    INotificationClickAidlCallback k();

    IDownloadAidlListener l(int r5);

    DownloadInfo m();

    int[] m(int r5);

    IDownloadAidlFileProvider n();

    IDownloadCompleteAidlHandler n(int r5);

    IDownloadForbiddenAidlHandler o();

    IDownloadAidlInterceptor p();

    IDownloadDiskSpaceAidlHandler q();

    IDownloadAidlMonitorDepend r();

    IDownloadNotificationEventAidlListener s();

    IDownloadAidlDepend u();
}
