package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface g extends IInterface {

    public static abstract class a extends Binder implements g {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.g$a$a, reason: collision with other inner class name */
        private static class C0818a implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static g f15376a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15377b;

            C0818a(IBinder r3) {
                this.f15377b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public int a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L13
                if (this.f15377b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.b() == null) goto L10;
                int r5 = a.b().a();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public void a(DownloadInfo r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f15377b.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().a(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public void a(DownloadInfo r5, BaseException r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L11:
                if (this.f15377b.transact(7, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (a.b() == null) goto L17;
                a.b().a(r5, r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L11
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
                return this.f15377b;
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public void b(DownloadInfo r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f15377b.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().b(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public void b(DownloadInfo r5, BaseException r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L11:
                if (this.f15377b.transact(11, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (a.b() == null) goto L17;
                a.b().b(r5, r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public void c(DownloadInfo r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f15377b.transact(4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().c(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public void c(DownloadInfo r5, BaseException r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L11:
                if (this.f15377b.transact(12, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (a.b() == null) goto L17;
                a.b().c(r5, r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public void d(DownloadInfo r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f15377b.transact(5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().d(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public void e(DownloadInfo r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f15377b.transact(6, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().e(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public void f(DownloadInfo r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f15377b.transact(8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().f(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public void g(DownloadInfo r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f15377b.transact(9, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().g(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public void h(DownloadInfo r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f15377b.transact(10, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().h(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public void i(DownloadInfo r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f15377b.transact(13, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().i(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        }

        public static g a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, g.class) == false) goto L13;
            return (g) ZeusTransformUtils.preCheckCast(r0, g.class, "com.obric.memorydata.plugin");
        L13:
            return new C0818a(r4);
        }

        public static g b() {
            return C0818a.f15376a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            if (r5 == 1598968902) goto L82;
            DownloadInfo r3 = null;
            DownloadInfo r4 = null;
            BaseException r9 = null;
            BaseException r10 = null;
            DownloadInfo r11 = null;
            DownloadInfo r12 = null;
            DownloadInfo r13 = null;
            BaseException r14 = null;
            DownloadInfo r15 = null;
            DownloadInfo r16 = null;
            DownloadInfo r17 = null;
            DownloadInfo r18 = null;
            switch(r5) {
                case 1: goto L80;
                case 2: goto L75;
                case 3: goto L70;
                case 4: goto L65;
                case 5: goto L60;
                case 6: goto L55;
                case 7: goto L46;
                case 8: goto L41;
                case 9: goto L36;
                case 10: goto L31;
                case 11: goto L22;
                case 12: goto L13;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r6.readInt() == 0) goto L11;
            r4 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r6), DownloadInfo.class, "com.obric.memorydata.plugin");
        L11:
            i(r4);
            r7.writeNoException();
            return true;
        L13:
            r6.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r6.readInt() == 0) goto L16;
            DownloadInfo r19 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r6), DownloadInfo.class, "com.obric.memorydata.plugin");
        L18:
            if (r6.readInt() == 0) goto L20;
            r9 = (BaseException) ZeusTransformUtils.preCheckCast(BaseException.CREATOR.createFromParcel(r6), BaseException.class, "com.obric.memorydata.plugin");
        L20:
            c(r19, r9);
            r7.writeNoException();
            return true;
        L16:
            r19 = null;
            goto L18
        L22:
            r6.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r6.readInt() == 0) goto L25;
            DownloadInfo r20 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r6), DownloadInfo.class, "com.obric.memorydata.plugin");
        L27:
            if (r6.readInt() == 0) goto L29;
            r10 = (BaseException) ZeusTransformUtils.preCheckCast(BaseException.CREATOR.createFromParcel(r6), BaseException.class, "com.obric.memorydata.plugin");
        L29:
            b(r20, r10);
            r7.writeNoException();
            return true;
        L25:
            r20 = null;
            goto L27
        L31:
            r6.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r6.readInt() == 0) goto L34;
            r11 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r6), DownloadInfo.class, "com.obric.memorydata.plugin");
        L34:
            h(r11);
            r7.writeNoException();
            return true;
        L36:
            r6.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r6.readInt() == 0) goto L39;
            r12 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r6), DownloadInfo.class, "com.obric.memorydata.plugin");
        L39:
            g(r12);
            r7.writeNoException();
            return true;
        L41:
            r6.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r6.readInt() == 0) goto L44;
            r13 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r6), DownloadInfo.class, "com.obric.memorydata.plugin");
        L44:
            f(r13);
            r7.writeNoException();
            return true;
        L46:
            r6.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r6.readInt() == 0) goto L49;
            DownloadInfo r21 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r6), DownloadInfo.class, "com.obric.memorydata.plugin");
        L51:
            if (r6.readInt() == 0) goto L53;
            r14 = (BaseException) ZeusTransformUtils.preCheckCast(BaseException.CREATOR.createFromParcel(r6), BaseException.class, "com.obric.memorydata.plugin");
        L53:
            a(r21, r14);
            r7.writeNoException();
            return true;
        L49:
            r21 = null;
            goto L51
        L55:
            r6.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r6.readInt() == 0) goto L58;
            r15 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r6), DownloadInfo.class, "com.obric.memorydata.plugin");
        L58:
            e(r15);
            r7.writeNoException();
            return true;
        L60:
            r6.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r6.readInt() == 0) goto L63;
            r16 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r6), DownloadInfo.class, "com.obric.memorydata.plugin");
        L63:
            d(r16);
            r7.writeNoException();
            return true;
        L65:
            r6.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r6.readInt() == 0) goto L68;
            r17 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r6), DownloadInfo.class, "com.obric.memorydata.plugin");
        L68:
            c(r17);
            r7.writeNoException();
            return true;
        L70:
            r6.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r6.readInt() == 0) goto L73;
            r18 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r6), DownloadInfo.class, "com.obric.memorydata.plugin");
        L73:
            b(r18);
            r7.writeNoException();
            return true;
        L75:
            r6.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r6.readInt() == 0) goto L78;
            r3 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r6), DownloadInfo.class, "com.obric.memorydata.plugin");
        L78:
            a(r3);
            r7.writeNoException();
            return true;
        L80:
            r6.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            int r22 = a();
            r7.writeNoException();
            r7.writeInt(r22);
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L82:
            r7.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            return true;
        }
    }

    int a();

    void a(DownloadInfo r1);

    void a(DownloadInfo r1, BaseException r2);

    void b(DownloadInfo r1);

    void b(DownloadInfo r1, BaseException r2);

    void c(DownloadInfo r1);

    void c(DownloadInfo r1, BaseException r2);

    void d(DownloadInfo r1);

    void e(DownloadInfo r1);

    void f(DownloadInfo r1);

    void g(DownloadInfo r1);

    void h(DownloadInfo r1);

    void i(DownloadInfo r1);
}
