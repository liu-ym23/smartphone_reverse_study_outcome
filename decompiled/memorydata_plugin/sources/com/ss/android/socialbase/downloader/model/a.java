package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.model.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0833a extends Binder implements a {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.model.a$a$a, reason: collision with other inner class name */
        private static class C0834a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f15561a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15562b;

            C0834a(IBinder r3) {
                this.f15562b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.g a(int r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.f15562b.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                com.ss.android.socialbase.downloader.depend.g r4 = com.ss.android.socialbase.downloader.depend.g.a.a(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0833a.k() == null) goto L10;
                com.ss.android.socialbase.downloader.depend.g r7 = AbstractBinderC0833a.k().a(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public DownloadInfo a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L17
                if (this.f15562b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                DownloadInfo r4 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r1), DownloadInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (AbstractBinderC0833a.k() == null) goto L10;
                DownloadInfo r5 = AbstractBinderC0833a.k().a();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int[] a(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.f15562b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int[] r4 = r1.createIntArray();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0833a.k() == null) goto L10;
                int[] r6 = AbstractBinderC0833a.k().a(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f15562b;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.g b(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.f15562b.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                com.ss.android.socialbase.downloader.depend.g r4 = com.ss.android.socialbase.downloader.depend.g.a.a(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0833a.k() == null) goto L10;
                com.ss.android.socialbase.downloader.depend.g r6 = AbstractBinderC0833a.k().b(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public z b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f15562b.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                z r4 = z.a.a(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0833a.k() == null) goto L10;
                z r5 = AbstractBinderC0833a.k().b();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ag c() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f15562b.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ag r4 = ag.a.a(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0833a.k() == null) goto L10;
                ag r5 = AbstractBinderC0833a.k().c();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public k c(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.f15562b.transact(14, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                k r4 = k.a.a(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0833a.k() == null) goto L10;
                k r6 = AbstractBinderC0833a.k().c(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.f d() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f15562b.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                com.ss.android.socialbase.downloader.depend.f r4 = com.ss.android.socialbase.downloader.depend.f.a.a(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0833a.k() == null) goto L10;
                com.ss.android.socialbase.downloader.depend.f r5 = AbstractBinderC0833a.k().d();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.d e() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f15562b.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                com.ss.android.socialbase.downloader.depend.d r4 = com.ss.android.socialbase.downloader.depend.d.a.a(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0833a.k() == null) goto L10;
                com.ss.android.socialbase.downloader.depend.d r5 = AbstractBinderC0833a.k().e();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public v f() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f15562b.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                v r4 = v.a.a(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0833a.k() == null) goto L10;
                v r5 = AbstractBinderC0833a.k().f();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public p g() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f15562b.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                p r4 = p.a.a(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0833a.k() == null) goto L10;
                p r5 = AbstractBinderC0833a.k().g();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public h h() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f15562b.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                h r4 = h.a.a(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0833a.k() == null) goto L10;
                h r5 = AbstractBinderC0833a.k().h();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.e i() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f15562b.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                com.ss.android.socialbase.downloader.depend.e r4 = com.ss.android.socialbase.downloader.depend.e.a.a(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0833a.k() == null) goto L10;
                com.ss.android.socialbase.downloader.depend.e r5 = AbstractBinderC0833a.k().i();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int j() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f15562b.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0833a.k() == null) goto L10;
                int r5 = AbstractBinderC0833a.k().j();     // Catch: Throwable -> L13
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

        public AbstractBinderC0833a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0834a(r4);
        }

        public static a k() {
            return C0834a.f15561a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L72;
            IBinder r0 = null;
            switch(r4) {
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
            r5.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            k r3 = c(r5.readInt());
            r6.writeNoException();
            if (r3 == null) goto L11;
            r0 = r3.asBinder();
        L11:
            r6.writeStrongBinder(r0);
            return true;
        L13:
            r5.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            int r8 = j();
            r6.writeNoException();
            r6.writeInt(r8);
            return true;
        L15:
            r5.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            com.ss.android.socialbase.downloader.depend.e r9 = i();
            r6.writeNoException();
            if (r9 == null) goto L18;
            r0 = r9.asBinder();
        L18:
            r6.writeStrongBinder(r0);
            return true;
        L20:
            r5.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            h r10 = h();
            r6.writeNoException();
            if (r10 == null) goto L23;
            r0 = r10.asBinder();
        L23:
            r6.writeStrongBinder(r0);
            return true;
        L25:
            r5.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            p r11 = g();
            r6.writeNoException();
            if (r11 == null) goto L28;
            r0 = r11.asBinder();
        L28:
            r6.writeStrongBinder(r0);
            return true;
        L30:
            r5.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            v r12 = f();
            r6.writeNoException();
            if (r12 == null) goto L33;
            r0 = r12.asBinder();
        L33:
            r6.writeStrongBinder(r0);
            return true;
        L35:
            r5.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            com.ss.android.socialbase.downloader.depend.d r13 = e();
            r6.writeNoException();
            if (r13 == null) goto L38;
            r0 = r13.asBinder();
        L38:
            r6.writeStrongBinder(r0);
            return true;
        L40:
            r5.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            com.ss.android.socialbase.downloader.depend.f r14 = d();
            r6.writeNoException();
            if (r14 == null) goto L43;
            r0 = r14.asBinder();
        L43:
            r6.writeStrongBinder(r0);
            return true;
        L45:
            r5.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            ag r15 = c();
            r6.writeNoException();
            if (r15 == null) goto L48;
            r0 = r15.asBinder();
        L48:
            r6.writeStrongBinder(r0);
            return true;
        L50:
            r5.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            z r16 = b();
            r6.writeNoException();
            if (r16 == null) goto L53;
            r0 = r16.asBinder();
        L53:
            r6.writeStrongBinder(r0);
            return true;
        L55:
            r5.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            com.ss.android.socialbase.downloader.depend.g r17 = b(r5.readInt());
            r6.writeNoException();
            if (r17 == null) goto L58;
            r0 = r17.asBinder();
        L58:
            r6.writeStrongBinder(r0);
            return true;
        L60:
            r5.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            com.ss.android.socialbase.downloader.depend.g r18 = a(r5.readInt(), r5.readInt());
            r6.writeNoException();
            if (r18 == null) goto L63;
            r0 = r18.asBinder();
        L63:
            r6.writeStrongBinder(r0);
            return true;
        L65:
            r5.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            int[] r19 = a(r5.readInt());
            r6.writeNoException();
            r6.writeIntArray(r19);
            return true;
        L67:
            r5.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            DownloadInfo r20 = a();
            r6.writeNoException();
            if (r20 == null) goto L70;
            r6.writeInt(1);
            r20.writeToParcel(r6, 1);
        L71:
            return true;
        L70:
            r6.writeInt(0);
            goto L71
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L72:
            r6.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            return true;
        }
    }

    com.ss.android.socialbase.downloader.depend.g a(int r1, int r2);

    DownloadInfo a();

    int[] a(int r1);

    com.ss.android.socialbase.downloader.depend.g b(int r1);

    z b();

    ag c();

    k c(int r1);

    com.ss.android.socialbase.downloader.depend.f d();

    com.ss.android.socialbase.downloader.depend.d e();

    v f();

    p g();

    h h();

    com.ss.android.socialbase.downloader.depend.e i();

    int j();
}
