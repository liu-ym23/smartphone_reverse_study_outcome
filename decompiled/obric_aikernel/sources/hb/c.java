package hb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: hb.c$a$a, reason: collision with other inner class name */
        private static class C0179a implements c {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static c f9203g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9204c;

            C0179a(IBinder r10) {
                this.f9204c = r10;
            }

            @Override // hb.c
            public void A(boolean r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                if (r10 == false) goto L6;
                int r13 = 1;
            L7:
                r11.writeInt(r13);     // Catch: Throwable -> L17
                if (this.f9204c.transact(1, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.q2() == null) goto L14;
                a.q2().A(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r13 = 0;
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public boolean A0() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L15
                boolean r12 = false;
                if (this.f9204c.transact(25, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L13;
                r12 = true;
            L13:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (a.q2() == null) goto L10;
                boolean r13 = a.q2().A0();     // Catch: Throwable -> L15
                r11.recycle();
                r10.recycle();
                return r13;
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // hb.c
            public DownloadInfo B0(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r11.writeInt(r10);     // Catch: Throwable -> L17
                if (this.f9204c.transact(23, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L17
                if (r12.readInt() == 0) goto L14;
                DownloadInfo r13 = DownloadInfo.CREATOR.createFromParcel(r12);     // Catch: Throwable -> L17
            L15:
                r12.recycle();
                r11.recycle();
                return r13;
            L14:
                r13 = null;
                goto L15
            L6:
                if (a.q2() == null) goto L10;
                DownloadInfo r14 = a.q2().B0(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return r14;
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public DownloadInfo E(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r11.writeInt(r10);     // Catch: Throwable -> L17
                if (this.f9204c.transact(18, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L17
                if (r12.readInt() == 0) goto L14;
                DownloadInfo r13 = DownloadInfo.CREATOR.createFromParcel(r12);     // Catch: Throwable -> L17
            L15:
                r12.recycle();
                r11.recycle();
                return r13;
            L14:
                r13 = null;
                goto L15
            L6:
                if (a.q2() == null) goto L10;
                DownloadInfo r14 = a.q2().E(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return r14;
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public DownloadInfo I0(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r11.writeInt(r10);     // Catch: Throwable -> L17
                if (this.f9204c.transact(22, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L17
                if (r12.readInt() == 0) goto L14;
                DownloadInfo r13 = DownloadInfo.CREATOR.createFromParcel(r12);     // Catch: Throwable -> L17
            L15:
                r12.recycle();
                r11.recycle();
                return r13;
            L14:
                r13 = null;
                goto L15
            L6:
                if (a.q2() == null) goto L10;
                DownloadInfo r14 = a.q2().I0(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return r14;
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public DownloadInfo V(int r10, long r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r12.writeInt(r10);     // Catch: Throwable -> L17
                r12.writeLong(r11);     // Catch: Throwable -> L17
                if (this.f9204c.transact(17, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L17
                if (r13.readInt() == 0) goto L14;
                DownloadInfo r14 = DownloadInfo.CREATOR.createFromParcel(r13);     // Catch: Throwable -> L17
            L15:
                r13.recycle();
                r12.recycle();
                return r14;
            L14:
                r14 = null;
                goto L15
            L6:
                if (a.q2() == null) goto L10;
                DownloadInfo r15 = a.q2().V(r10, r11);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return r15;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // hb.c
            public DownloadInfo a(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r11.writeInt(r10);     // Catch: Throwable -> L17
                if (this.f9204c.transact(3, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L17
                if (r12.readInt() == 0) goto L14;
                DownloadInfo r13 = DownloadInfo.CREATOR.createFromParcel(r12);     // Catch: Throwable -> L17
            L15:
                r12.recycle();
                r11.recycle();
                return r13;
            L14:
                r13 = null;
                goto L15
            L6:
                if (a.q2() == null) goto L10;
                DownloadInfo r14 = a.q2().a(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return r14;
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9204c;
            }

            @Override // hb.c
            public boolean b(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L20
                boolean r13 = true;
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L20
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f9204c.transact(10, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L20
                if (r12.readInt() != 0) goto L18;
                r13 = false;
            L18:
                r12.recycle();
                r11.recycle();
                return r13;
            L10:
                if (a.q2() == null) goto L14;
                boolean r14 = a.q2().b(r10);     // Catch: Throwable -> L20
                r12.recycle();
                r11.recycle();
                return r14;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public void c() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                if (this.f9204c.transact(13, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (a.q2() == null) goto L10;
                a.q2().c();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // hb.c
            public boolean d() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L15
                boolean r12 = false;
                if (this.f9204c.transact(24, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L13;
                r12 = true;
            L13:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (a.q2() == null) goto L10;
                boolean r13 = a.q2().d();     // Catch: Throwable -> L15
                r11.recycle();
                r10.recycle();
                return r13;
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // hb.c
            public DownloadInfo d0(int r10, long r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r12.writeInt(r10);     // Catch: Throwable -> L17
                r12.writeLong(r11);     // Catch: Throwable -> L17
                if (this.f9204c.transact(19, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L17
                if (r13.readInt() == 0) goto L14;
                DownloadInfo r14 = DownloadInfo.CREATOR.createFromParcel(r13);     // Catch: Throwable -> L17
            L15:
                r13.recycle();
                r12.recycle();
                return r14;
            L14:
                r14 = null;
                goto L15
            L6:
                if (a.q2() == null) goto L10;
                DownloadInfo r15 = a.q2().d0(r10, r11);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return r15;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // hb.c
            public List<DownloadInfo> e(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.f9204c.transact(5, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                ArrayList r13 = r12.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.q2() == null) goto L10;
                List<DownloadInfo> r14 = a.q2().e(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public List<DownloadInfo> f(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.f9204c.transact(7, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                ArrayList r13 = r12.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.q2() == null) goto L10;
                List<DownloadInfo> r14 = a.q2().f(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public List<DownloadInfo> g(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.f9204c.transact(6, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                ArrayList r13 = r12.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.q2() == null) goto L10;
                List<DownloadInfo> r14 = a.q2().g(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public boolean h(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L15
                r11.writeInt(r10);     // Catch: Throwable -> L15
                boolean r13 = false;
                if (this.f9204c.transact(11, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L15
                if (r12.readInt() == 0) goto L13;
                r13 = true;
            L13:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.q2() == null) goto L10;
                boolean r14 = a.q2().h(r10);     // Catch: Throwable -> L15
                r12.recycle();
                r11.recycle();
                return r14;
            L15:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public void i(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f9204c.transact(27, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (a.q2() == null) goto L10;
                a.q2().i(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public boolean j(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L15
                r11.writeInt(r10);     // Catch: Throwable -> L15
                boolean r13 = false;
                if (this.f9204c.transact(12, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L15
                if (r12.readInt() == 0) goto L13;
                r13 = true;
            L13:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.q2() == null) goto L10;
                boolean r14 = a.q2().j(r10);     // Catch: Throwable -> L15
                r12.recycle();
                r11.recycle();
                return r14;
            L15:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public List<DownloadInfo> k() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                if (this.f9204c.transact(8, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                ArrayList r12 = r11.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (a.q2() == null) goto L10;
                List<DownloadInfo> r13 = a.q2().k();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // hb.c
            public List<DownloadInfo> l(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.f9204c.transact(4, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                ArrayList r13 = r12.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.q2() == null) goto L10;
                List<DownloadInfo> r14 = a.q2().l(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public List<DownloadInfo> m(String r10, String r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                r12.writeString(r10);     // Catch: Throwable -> L13
                r12.writeString(r11);     // Catch: Throwable -> L13
                if (this.f9204c.transact(9, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L13
                ArrayList r14 = r13.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                if (a.q2() == null) goto L10;
                List<DownloadInfo> r15 = a.q2().m(r10, r11);     // Catch: Throwable -> L13
                r13.recycle();
                r12.recycle();
                return r15;
            L13:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // hb.c
            public DownloadInfo n0(int r10, long r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r12.writeInt(r10);     // Catch: Throwable -> L17
                r12.writeLong(r11);     // Catch: Throwable -> L17
                if (this.f9204c.transact(16, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L17
                if (r13.readInt() == 0) goto L14;
                DownloadInfo r14 = DownloadInfo.CREATOR.createFromParcel(r13);     // Catch: Throwable -> L17
            L15:
                r13.recycle();
                r12.recycle();
                return r14;
            L14:
                r14 = null;
                goto L15
            L6:
                if (a.q2() == null) goto L10;
                DownloadInfo r15 = a.q2().n0(r10, r11);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return r15;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // hb.c
            public void s1(b r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L17
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L17
                if (this.f9204c.transact(28, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.q2() == null) goto L14;
                a.q2().s1(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r13 = null;
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public DownloadInfo t0(int r10, long r11, String r12, String r13) {
                Parcel r14 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r14.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r14.writeInt(r10);     // Catch: Throwable -> L17
                r14.writeLong(r11);     // Catch: Throwable -> L17
                r14.writeString(r12);     // Catch: Throwable -> L17
                r14.writeString(r13);     // Catch: Throwable -> L17
                if (this.f9204c.transact(15, r14, r15, 0) == false) goto L6;
            L10:
                r15.readException();     // Catch: Throwable -> L17
                if (r15.readInt() == 0) goto L14;
                DownloadInfo r16 = DownloadInfo.CREATOR.createFromParcel(r15);     // Catch: Throwable -> L17
            L15:
                r15.recycle();
                r14.recycle();
                return r16;
            L14:
                r16 = null;
                goto L15
            L6:
                if (a.q2() == null) goto L10;
                DownloadInfo r17 = a.q2().t0(r10, r11, r12, r13);     // Catch: Throwable -> L17
                r15.recycle();
                r14.recycle();
                return r17;
            L17:
                th = move-exception;
                r15.recycle();
                r14.recycle();
                throw th;
            }

            @Override // hb.c
            public void v(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L17
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f9204c.transact(26, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.q2() == null) goto L14;
                a.q2().v(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public DownloadInfo w0(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r11.writeInt(r10);     // Catch: Throwable -> L17
                if (this.f9204c.transact(14, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L17
                if (r12.readInt() == 0) goto L14;
                DownloadInfo r13 = DownloadInfo.CREATOR.createFromParcel(r12);     // Catch: Throwable -> L17
            L15:
                r12.recycle();
                r11.recycle();
                return r13;
            L14:
                r13 = null;
                goto L15
            L6:
                if (a.q2() == null) goto L10;
                DownloadInfo r14 = a.q2().w0(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return r14;
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // hb.c
            public DownloadInfo y(int r10, long r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r12.writeInt(r10);     // Catch: Throwable -> L17
                r12.writeLong(r11);     // Catch: Throwable -> L17
                if (this.f9204c.transact(20, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L17
                if (r13.readInt() == 0) goto L14;
                DownloadInfo r14 = DownloadInfo.CREATOR.createFromParcel(r13);     // Catch: Throwable -> L17
            L15:
                r13.recycle();
                r12.recycle();
                return r14;
            L14:
                r14 = null;
                goto L15
            L6:
                if (a.q2() == null) goto L10;
                DownloadInfo r15 = a.q2().y(r10, r11);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return r15;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        public static c p2(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (r11 == null) goto L12;
            if ((r11 instanceof c) == false) goto L12;
            return (c) r11;
        L12:
            return new C0179a(r10);
        }

        public static c q2() {
            return C0179a.f9203g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) {
            if (r11 == 1598968902) goto L106;
            DownloadInfo r10 = null;
            boolean r15 = false;
            switch(r11) {
                case 1: goto L101;
                case 2: goto L99;
                case 3: goto L94;
                case 4: goto L92;
                case 5: goto L90;
                case 6: goto L88;
                case 7: goto L86;
                case 8: goto L84;
                case 9: goto L82;
                case 10: goto L77;
                case 11: goto L75;
                case 12: goto L73;
                case 13: goto L71;
                case 14: goto L66;
                case 15: goto L61;
                case 16: goto L56;
                case 17: goto L51;
                case 18: goto L46;
                case 19: goto L41;
                case 20: goto L36;
                case 21: goto L31;
                case 22: goto L26;
                case 23: goto L21;
                case 24: goto L19;
                case 25: goto L17;
                case 26: goto L12;
                case 27: goto L10;
                case 28: goto L8;
                default: goto L7;
            };
        L8:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            s1(b.a.U0(r12.readStrongBinder()));
            r13.writeNoException();
            return true;
        L10:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            i(r12.readInt());
            r13.writeNoException();
            return true;
        L12:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (r12.readInt() == 0) goto L15;
            r10 = DownloadInfo.CREATOR.createFromParcel(r12);
        L15:
            v(r10);
            r13.writeNoException();
            return true;
        L17:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            boolean r16 = A0();
            r13.writeNoException();
            r13.writeInt(r16 ? 1 : 0);
            return true;
        L19:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            boolean r17 = d();
            r13.writeNoException();
            r13.writeInt(r17 ? 1 : 0);
            return true;
        L21:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r18 = B0(r12.readInt());
            r13.writeNoException();
            if (r18 == null) goto L24;
            r13.writeInt(1);
            r18.writeToParcel(r13, 1);
        L25:
            return true;
        L24:
            r13.writeInt(0);
            goto L25
        L26:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r19 = I0(r12.readInt());
            r13.writeNoException();
            if (r19 == null) goto L29;
            r13.writeInt(1);
            r19.writeToParcel(r13, 1);
        L30:
            return true;
        L29:
            r13.writeInt(0);
            goto L30
        L31:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r110 = R0(r12.readInt(), r12.readLong());
            r13.writeNoException();
            if (r110 == null) goto L34;
            r13.writeInt(1);
            r110.writeToParcel(r13, 1);
        L35:
            return true;
        L34:
            r13.writeInt(0);
            goto L35
        L36:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r111 = y(r12.readInt(), r12.readLong());
            r13.writeNoException();
            if (r111 == null) goto L39;
            r13.writeInt(1);
            r111.writeToParcel(r13, 1);
        L40:
            return true;
        L39:
            r13.writeInt(0);
            goto L40
        L41:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r112 = d0(r12.readInt(), r12.readLong());
            r13.writeNoException();
            if (r112 == null) goto L44;
            r13.writeInt(1);
            r112.writeToParcel(r13, 1);
        L45:
            return true;
        L44:
            r13.writeInt(0);
            goto L45
        L46:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r113 = E(r12.readInt());
            r13.writeNoException();
            if (r113 == null) goto L49;
            r13.writeInt(1);
            r113.writeToParcel(r13, 1);
        L50:
            return true;
        L49:
            r13.writeInt(0);
            goto L50
        L51:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r114 = V(r12.readInt(), r12.readLong());
            r13.writeNoException();
            if (r114 == null) goto L54;
            r13.writeInt(1);
            r114.writeToParcel(r13, 1);
        L55:
            return true;
        L54:
            r13.writeInt(0);
            goto L55
        L56:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r115 = n0(r12.readInt(), r12.readLong());
            r13.writeNoException();
            if (r115 == null) goto L59;
            r13.writeInt(1);
            r115.writeToParcel(r13, 1);
        L60:
            return true;
        L59:
            r13.writeInt(0);
            goto L60
        L61:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r116 = t0(r12.readInt(), r12.readLong(), r12.readString(), r12.readString());
            r13.writeNoException();
            if (r116 == null) goto L64;
            r13.writeInt(1);
            r116.writeToParcel(r13, 1);
        L65:
            return true;
        L64:
            r13.writeInt(0);
            goto L65
        L66:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r117 = w0(r12.readInt());
            r13.writeNoException();
            if (r117 == null) goto L69;
            r13.writeInt(1);
            r117.writeToParcel(r13, 1);
        L70:
            return true;
        L69:
            r13.writeInt(0);
            goto L70
        L71:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            c();
            r13.writeNoException();
            return true;
        L73:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            boolean r118 = j(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r118 ? 1 : 0);
            return true;
        L75:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            boolean r119 = h(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r119 ? 1 : 0);
            return true;
        L77:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (r12.readInt() == 0) goto L80;
            r10 = DownloadInfo.CREATOR.createFromParcel(r12);
        L80:
            boolean r120 = b(r10);
            r13.writeNoException();
            r13.writeInt(r120 ? 1 : 0);
            return true;
        L82:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List<DownloadInfo> r121 = m(r12.readString(), r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r121);
            return true;
        L84:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List<DownloadInfo> r122 = k();
            r13.writeNoException();
            r13.writeTypedList(r122);
            return true;
        L86:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List<DownloadInfo> r123 = f(r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r123);
            return true;
        L88:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List<DownloadInfo> r124 = g(r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r124);
            return true;
        L90:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List<DownloadInfo> r125 = e(r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r125);
            return true;
        L92:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List<DownloadInfo> r126 = l(r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r126);
            return true;
        L94:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r127 = a(r12.readInt());
            r13.writeNoException();
            if (r127 == null) goto L97;
            r13.writeInt(1);
            r127.writeToParcel(r13, 1);
        L98:
            return true;
        L97:
            r13.writeInt(0);
            goto L98
        L99:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            boolean r128 = Q0(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r128 ? 1 : 0);
            return true;
        L101:
            r12.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (r12.readInt() == 0) goto L104;
            r15 = true;
        L104:
            A(r15);
            r13.writeNoException();
            return true;
        L7:
            return super.onTransact(r11, r12, r13, r14);
        L106:
            r13.writeString("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            return true;
        }
    }

    void A(boolean r10);

    boolean A0();

    DownloadInfo B0(int r10);

    DownloadInfo E(int r10);

    DownloadInfo I0(int r10);

    boolean Q0(int r10);

    DownloadInfo R0(int r10, long r11);

    DownloadInfo V(int r10, long r11);

    DownloadInfo a(int r10);

    boolean b(DownloadInfo r10);

    void c();

    boolean d();

    DownloadInfo d0(int r10, long r11);

    List<DownloadInfo> e(String r10);

    List<DownloadInfo> f(String r10);

    List<DownloadInfo> g(String r10);

    boolean h(int r10);

    void i(int r10);

    boolean j(int r10);

    List<DownloadInfo> k();

    List<DownloadInfo> l(String r10);

    List<DownloadInfo> m(String r10, String r11);

    DownloadInfo n0(int r10, long r11);

    void s1(b r10);

    DownloadInfo t0(int r10, long r11, String r12, String r13);

    void v(DownloadInfo r10);

    DownloadInfo w0(int r10);

    DownloadInfo y(int r10, long r11);
}
