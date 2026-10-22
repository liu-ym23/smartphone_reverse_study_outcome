package jb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ib.c0;
import ib.j0;
import ib.m0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface h extends IInterface {

    public static abstract class a extends Binder implements h {

        /* JADX INFO: renamed from: jb.h$a$a, reason: collision with other inner class name */
        private static class C0209a implements h {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static h f9870g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9871c;

            C0209a(IBinder r10) {
                this.f9871c = r10;
            }

            @Override // jb.h
            public void D(int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                r12.writeInt(r10);     // Catch: Throwable -> L17
                if (r11 == false) goto L6;
                int r14 = 1;
            L7:
                r12.writeInt(r14);     // Catch: Throwable -> L17
                if (this.f9871c.transact(32, r12, r13, 0) == false) goto L10;
            L14:
                r13.readException();     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().D(r10, r11);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L6:
                r14 = 0;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // jb.h
            public j0 F0(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(42, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                j0 r13 = j0.a.U0(r12.readStrongBinder());     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                j0 r14 = a.k1().F0(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public void H0(int r10, boolean r11, boolean r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L21
                r13.writeInt(r10);     // Catch: Throwable -> L21
                int r15 = 1;
                if (r11 == false) goto L6;
                int r16 = 1;
            L7:
                r13.writeInt(r16);     // Catch: Throwable -> L21
                if (r12 == true) goto L11;
                r15 = 0;
            L11:
                r13.writeInt(r15);     // Catch: Throwable -> L21
                if (this.f9871c.transact(22, r13, r14, 0) == false) goto L14;
            L18:
                r14.readException();     // Catch: Throwable -> L21
                r14.recycle();
                r13.recycle();
                return;
            L14:
                if (a.k1() == null) goto L18;
                a.k1().H0(r10, r11, r12);     // Catch: Throwable -> L21
                r14.recycle();
                r13.recycle();
                return;
            L6:
                r16 = 0;
            L21:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // jb.h
            public void J0(int r10, int r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r12.writeInt(r10);     // Catch: Throwable -> L13
                r12.writeInt(r11);     // Catch: Throwable -> L13
                if (this.f9871c.transact(40, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L13
                r13.recycle();
                r12.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().J0(r10, r11);     // Catch: Throwable -> L13
                r13.recycle();
                r12.recycle();
                return;
            L13:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // jb.h
            public boolean L(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L20
                boolean r13 = true;
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L20
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f9871c.transact(27, r11, r12, 0) == false) goto L10;
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
                boolean r14 = a.k1().L(r10);     // Catch: Throwable -> L20
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

            @Override // jb.h
            public c0 O(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(41, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                c0 r13 = c0.a.U0(r12.readStrongBinder());     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                c0 r14 = a.k1().O(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public List<DownloadInfo> P(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(16, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                ArrayList r13 = r12.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                List<DownloadInfo> r14 = a.k1().P(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public void U1(com.ss.android.socialbase.downloader.model.a r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L17
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L17
                if (this.f9871c.transact(1, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().U1(r10);     // Catch: Throwable -> L17
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

            @Override // jb.h
            public void Y0(int r10, int r11, ib.h r12, int r13, boolean r14) {
                Parcel r15 = Parcel.obtain();
                Parcel r16 = Parcel.obtain();
                r15.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L21
                r15.writeInt(r10);     // Catch: Throwable -> L21
                r15.writeInt(r11);     // Catch: Throwable -> L21
                if (r12 == null) goto L6;
                IBinder r17 = r12.asBinder();     // Catch: Throwable -> L21
            L7:
                r15.writeStrongBinder(r17);     // Catch: Throwable -> L21
                r15.writeInt(r13);     // Catch: Throwable -> L21
                if (r14 == false) goto L10;
                int r18 = 1;
            L11:
                r15.writeInt(r18);     // Catch: Throwable -> L21
                if (this.f9871c.transact(24, r15, r16, 0) == false) goto L14;
            L18:
                r16.readException();     // Catch: Throwable -> L21
                r16.recycle();
                r15.recycle();
                return;
            L14:
                if (a.k1() == null) goto L18;
                a.k1().Y0(r10, r11, r12, r13, r14);     // Catch: Throwable -> L21
                r16.recycle();
                r15.recycle();
                return;
            L10:
                r18 = 0;
                goto L11
            L6:
                r17 = null;
            L21:
                th = move-exception;
                r16.recycle();
                r15.recycle();
                throw th;
            }

            @Override // jb.h
            public void Y1(int r10, c0 r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                r12.writeInt(r10);     // Catch: Throwable -> L17
                if (r11 == null) goto L6;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L17
            L7:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L17
                if (this.f9871c.transact(43, r12, r13, 0) == false) goto L10;
            L14:
                r13.readException();     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().Y1(r10, r11);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L6:
                r14 = null;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // jb.h
            public DownloadInfo a(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                r11.writeInt(r10);     // Catch: Throwable -> L17
                if (this.f9871c.transact(11, r11, r12, 0) == false) goto L6;
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
                if (a.k1() == null) goto L10;
                DownloadInfo r14 = a.k1().a(r10);     // Catch: Throwable -> L17
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
                return this.f9871c;
            }

            @Override // jb.h
            public boolean b(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L20
                boolean r13 = true;
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L20
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f9871c.transact(34, r11, r12, 0) == false) goto L10;
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
                boolean r14 = a.k1().b(r10);     // Catch: Throwable -> L20
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

            @Override // jb.h
            public void c() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                if (this.f9871c.transact(37, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().c();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // jb.h
            public boolean d() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L15
                boolean r12 = false;
                if (this.f9871c.transact(31, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L13;
                r12 = true;
            L13:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (a.k1() == null) goto L10;
                boolean r13 = a.k1().d();     // Catch: Throwable -> L15
                r11.recycle();
                r10.recycle();
                return r13;
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // jb.h
            public List<DownloadInfo> e(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(15, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                ArrayList r13 = r12.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                List<DownloadInfo> r14 = a.k1().e(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public void e1(int r10, int r11, ib.h r12, int r13, boolean r14) {
                Parcel r15 = Parcel.obtain();
                Parcel r16 = Parcel.obtain();
                r15.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L21
                r15.writeInt(r10);     // Catch: Throwable -> L21
                r15.writeInt(r11);     // Catch: Throwable -> L21
                if (r12 == null) goto L6;
                IBinder r17 = r12.asBinder();     // Catch: Throwable -> L21
            L7:
                r15.writeStrongBinder(r17);     // Catch: Throwable -> L21
                r15.writeInt(r13);     // Catch: Throwable -> L21
                if (r14 == false) goto L10;
                int r18 = 1;
            L11:
                r15.writeInt(r18);     // Catch: Throwable -> L21
                if (this.f9871c.transact(25, r15, r16, 0) == false) goto L14;
            L18:
                r16.readException();     // Catch: Throwable -> L21
                r16.recycle();
                r15.recycle();
                return;
            L14:
                if (a.k1() == null) goto L18;
                a.k1().e1(r10, r11, r12, r13, r14);     // Catch: Throwable -> L21
                r16.recycle();
                r15.recycle();
                return;
            L10:
                r18 = 0;
                goto L11
            L6:
                r17 = null;
            L21:
                th = move-exception;
                r16.recycle();
                r15.recycle();
                throw th;
            }

            @Override // jb.h
            public List<DownloadInfo> f(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(17, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                ArrayList r13 = r12.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                List<DownloadInfo> r14 = a.k1().f(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public boolean f0(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L15
                r11.writeInt(r10);     // Catch: Throwable -> L15
                boolean r13 = false;
                if (this.f9871c.transact(4, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L15
                if (r12.readInt() == 0) goto L13;
                r13 = true;
            L13:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                boolean r14 = a.k1().f0(r10);     // Catch: Throwable -> L15
                r12.recycle();
                r11.recycle();
                return r14;
            L15:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public List<DownloadInfo> g(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(29, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                ArrayList r13 = r12.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                List<DownloadInfo> r14 = a.k1().g(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public void g1(int r10, int r11, ib.h r12, int r13, boolean r14, boolean r15) {
                Parcel r16 = Parcel.obtain();
                Parcel r17 = Parcel.obtain();
                r16.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L25
                r16.writeInt(r10);     // Catch: Throwable -> L25
                r16.writeInt(r11);     // Catch: Throwable -> L25
                if (r12 == null) goto L6;
                IBinder r18 = r12.asBinder();     // Catch: Throwable -> L25
            L7:
                r16.writeStrongBinder(r18);     // Catch: Throwable -> L25
                r16.writeInt(r13);     // Catch: Throwable -> L25
                int r19 = 1;
                if (r14 == false) goto L10;
                int r20 = 1;
            L11:
                r16.writeInt(r20);     // Catch: Throwable -> L25
                if (r15 == true) goto L15;
                r19 = 0;
            L15:
                r16.writeInt(r19);     // Catch: Throwable -> L25
                if (this.f9871c.transact(26, r16, r17, 0) == false) goto L18;
            L22:
                r17.readException();     // Catch: Throwable -> L25
                r17.recycle();
                r16.recycle();
                return;
            L18:
                if (a.k1() == null) goto L22;
                a.k1().g1(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L25
                r17.recycle();
                r16.recycle();
                return;
            L10:
                r20 = 0;
                goto L11
            L6:
                r18 = null;
            L25:
                th = move-exception;
                r17.recycle();
                r16.recycle();
                throw th;
            }

            @Override // jb.h
            public boolean h(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L15
                r11.writeInt(r10);     // Catch: Throwable -> L15
                boolean r13 = false;
                if (this.f9871c.transact(35, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L15
                if (r12.readInt() == 0) goto L13;
                r13 = true;
            L13:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                boolean r14 = a.k1().h(r10);     // Catch: Throwable -> L15
                r12.recycle();
                r11.recycle();
                return r14;
            L15:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public void i(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(38, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().i(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public long i0(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(8, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                long r13 = r12.readLong();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                long r14 = a.k1().i0(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public boolean j(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L15
                r11.writeInt(r10);     // Catch: Throwable -> L15
                boolean r13 = false;
                if (this.f9871c.transact(36, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L15
                if (r12.readInt() == 0) goto L13;
                r13 = true;
            L13:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                boolean r14 = a.k1().j(r10);     // Catch: Throwable -> L15
                r12.recycle();
                r11.recycle();
                return r14;
            L15:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public List<DownloadInfo> k() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                if (this.f9871c.transact(18, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                ArrayList r12 = r11.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (a.k1() == null) goto L10;
                List<DownloadInfo> r13 = a.k1().k();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // jb.h
            public List<DownloadInfo> l(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(12, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                ArrayList r13 = r12.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                List<DownloadInfo> r14 = a.k1().l(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public List<DownloadInfo> m(String r10, String r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r12.writeString(r10);     // Catch: Throwable -> L13
                r12.writeString(r11);     // Catch: Throwable -> L13
                if (this.f9871c.transact(19, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L13
                ArrayList r14 = r13.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                if (a.k1() == null) goto L10;
                List<DownloadInfo> r15 = a.k1().m(r10, r11);     // Catch: Throwable -> L13
                r13.recycle();
                r12.recycle();
                return r15;
            L13:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // jb.h
            public int n(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(9, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                int r13 = r12.readInt();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                int r14 = a.k1().n(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public boolean o(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L15
                r11.writeInt(r10);     // Catch: Throwable -> L15
                boolean r13 = false;
                if (this.f9871c.transact(10, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L15
                if (r12.readInt() == 0) goto L13;
                r13 = true;
            L13:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                boolean r14 = a.k1().o(r10);     // Catch: Throwable -> L15
                r12.recycle();
                r11.recycle();
                return r14;
            L15:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public void o0(int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                r12.writeInt(r10);     // Catch: Throwable -> L17
                if (r11 == false) goto L6;
                int r14 = 1;
            L7:
                r12.writeInt(r14);     // Catch: Throwable -> L17
                if (this.f9871c.transact(2, r12, r13, 0) == false) goto L10;
            L14:
                r13.readException();     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().o0(r10, r11);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L6:
                r14 = 0;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // jb.h
            public void p(int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                r12.writeInt(r10);     // Catch: Throwable -> L17
                if (r11 == false) goto L6;
                int r14 = 1;
            L7:
                r12.writeInt(r14);     // Catch: Throwable -> L17
                if (this.f9871c.transact(46, r12, r13, 0) == false) goto L10;
            L14:
                r13.readException();     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().p(r10, r11);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L6:
                r14 = 0;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // jb.h
            public void q(int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                r12.writeInt(r10);     // Catch: Throwable -> L17
                if (r11 == false) goto L6;
                int r14 = 1;
            L7:
                r12.writeInt(r14);     // Catch: Throwable -> L17
                if (this.f9871c.transact(3, r12, r13, 0) == false) goto L10;
            L14:
                r13.readException();     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().q(r10, r11);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L6:
                r14 = 0;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // jb.h
            public void r(List<String> r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeStringList(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(21, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().r(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public void s(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(5, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().s(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public void t(int r10, long r11, int r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r13.writeInt(r10);     // Catch: Throwable -> L13
                r13.writeLong(r11);     // Catch: Throwable -> L13
                r13.writeInt(r12);     // Catch: Throwable -> L13
                if (this.f9871c.transact(45, r13, r14, 0) == false) goto L6;
            L10:
                r14.readException();     // Catch: Throwable -> L13
                r14.recycle();
                r13.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().t(r10, r11, r12);     // Catch: Throwable -> L13
                r14.recycle();
                r13.recycle();
                return;
            L13:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // jb.h
            public void u() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                if (this.f9871c.transact(7, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().u();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // jb.h
            public ib.f v0(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(44, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                ib.f r13 = ib.f.a.U0(r12.readStrongBinder());     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                ib.f r14 = a.k1().v0(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public void v1(m0 r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L17
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L17
                if (this.f9871c.transact(39, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().v1(r10);     // Catch: Throwable -> L17
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

            @Override // jb.h
            public void w(List<String> r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeStringList(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(20, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().w(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public void x(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(30, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().x(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public int y0(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(33, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                int r13 = r12.readInt();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.k1() == null) goto L10;
                int r14 = a.k1().y0(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // jb.h
            public void z(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f9871c.transact(6, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().z(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        }

        public static h U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (r11 == null) goto L12;
            if ((r11 instanceof h) == false) goto L12;
            return (h) r11;
        L12:
            return new C0209a(r10);
        }

        public static h k1() {
            return C0209a.f9870g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) {
            if (r11 == 1598968902) goto L157;
            DownloadInfo r10 = null;
            IBinder r15 = null;
            IBinder r16 = null;
            IBinder r17 = null;
            DownloadInfo r18 = null;
            boolean r19 = false;
            switch(r11) {
                case 1: goto L155;
                case 2: goto L150;
                case 3: goto L145;
                case 4: goto L143;
                case 5: goto L141;
                case 6: goto L139;
                case 7: goto L137;
                case 8: goto L135;
                case 9: goto L133;
                case 10: goto L131;
                case 11: goto L126;
                case 12: goto L124;
                case 13: goto L122;
                case 14: goto L117;
                case 15: goto L115;
                case 16: goto L113;
                case 17: goto L111;
                case 18: goto L109;
                case 19: goto L107;
                case 20: goto L105;
                case 21: goto L103;
                case 22: goto L94;
                case 23: goto L89;
                case 24: goto L84;
                case 25: goto L79;
                case 26: goto L69;
                case 27: goto L64;
                case 28: goto L62;
                case 29: goto L60;
                case 30: goto L58;
                case 31: goto L56;
                case 32: goto L51;
                case 33: goto L49;
                case 34: goto L44;
                case 35: goto L42;
                case 36: goto L40;
                case 37: goto L38;
                case 38: goto L36;
                case 39: goto L34;
                case 40: goto L32;
                case 41: goto L27;
                case 42: goto L22;
                case 43: goto L20;
                case 44: goto L15;
                case 45: goto L13;
                case 46: goto L8;
                default: goto L7;
            };
        L8:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r20 = r12.readInt();
            if (r12.readInt() == 0) goto L11;
            r19 = true;
        L11:
            p(r20, r19);
            r13.writeNoException();
            return true;
        L13:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            t(r12.readInt(), r12.readLong(), r12.readInt());
            r13.writeNoException();
            return true;
        L15:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ib.f r21 = v0(r12.readInt());
            r13.writeNoException();
            if (r21 == null) goto L18;
            r15 = r21.asBinder();
        L18:
            r13.writeStrongBinder(r15);
            return true;
        L20:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            Y1(r12.readInt(), c0.a.U0(r12.readStrongBinder()));
            r13.writeNoException();
            return true;
        L22:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            j0 r22 = F0(r12.readInt());
            r13.writeNoException();
            if (r22 == null) goto L25;
            r16 = r22.asBinder();
        L25:
            r13.writeStrongBinder(r16);
            return true;
        L27:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            c0 r23 = O(r12.readInt());
            r13.writeNoException();
            if (r23 == null) goto L30;
            r17 = r23.asBinder();
        L30:
            r13.writeStrongBinder(r17);
            return true;
        L32:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            J0(r12.readInt(), r12.readInt());
            r13.writeNoException();
            return true;
        L34:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            v1(m0.a.U0(r12.readStrongBinder()));
            r13.writeNoException();
            return true;
        L36:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            i(r12.readInt());
            r13.writeNoException();
            return true;
        L38:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            c();
            r13.writeNoException();
            return true;
        L40:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r24 = j(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r24 ? 1 : 0);
            return true;
        L42:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r25 = h(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r25 ? 1 : 0);
            return true;
        L44:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (r12.readInt() == 0) goto L47;
            r18 = DownloadInfo.CREATOR.createFromParcel(r12);
        L47:
            boolean r26 = b(r18);
            r13.writeNoException();
            r13.writeInt(r26 ? 1 : 0);
            return true;
        L49:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r27 = y0(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r27);
            return true;
        L51:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r28 = r12.readInt();
            if (r12.readInt() == 0) goto L54;
            r19 = true;
        L54:
            D(r28, r19);
            r13.writeNoException();
            return true;
        L56:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r29 = d();
            r13.writeNoException();
            r13.writeInt(r29 ? 1 : 0);
            return true;
        L58:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            x(r12.readInt());
            r13.writeNoException();
            return true;
        L60:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            List<DownloadInfo> r30 = g(r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r30);
            return true;
        L62:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r31 = Y();
            r13.writeNoException();
            r13.writeInt(r31 ? 1 : 0);
            return true;
        L64:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (r12.readInt() == 0) goto L67;
            r10 = DownloadInfo.CREATOR.createFromParcel(r12);
        L67:
            boolean r32 = L(r10);
            r13.writeNoException();
            r13.writeInt(r32 ? 1 : 0);
            return true;
        L69:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r33 = r12.readInt();
            int r34 = r12.readInt();
            ib.h r35 = ib.h.a.U0(r12.readStrongBinder());
            int r36 = r12.readInt();
            if (r12.readInt() == 0) goto L72;
            boolean r37 = true;
        L74:
            if (r12.readInt() == 0) goto L76;
            boolean r38 = true;
        L77:
            g1(r33, r34, r35, r36, r37, r38);
            r13.writeNoException();
            return true;
        L76:
            r38 = false;
            goto L77
        L72:
            r37 = false;
            goto L74
        L79:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r39 = r12.readInt();
            int r40 = r12.readInt();
            ib.h r41 = ib.h.a.U0(r12.readStrongBinder());
            int r42 = r12.readInt();
            if (r12.readInt() == 0) goto L82;
            r19 = true;
        L82:
            e1(r39, r40, r41, r42, r19);
            r13.writeNoException();
            return true;
        L84:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r43 = r12.readInt();
            int r44 = r12.readInt();
            ib.h r45 = ib.h.a.U0(r12.readStrongBinder());
            int r46 = r12.readInt();
            if (r12.readInt() == 0) goto L87;
            r19 = true;
        L87:
            Y0(r43, r44, r45, r46, r19);
            r13.writeNoException();
            return true;
        L89:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r47 = r12.readInt();
            if (r12.readInt() == 0) goto L92;
            r19 = true;
        L92:
            O0(r47, r19);
            r13.writeNoException();
            return true;
        L94:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r48 = r12.readInt();
            if (r12.readInt() == 0) goto L97;
            boolean r49 = true;
        L99:
            if (r12.readInt() == 0) goto L101;
            r19 = true;
        L101:
            H0(r48, r49, r19);
            r13.writeNoException();
            return true;
        L97:
            r49 = false;
            goto L99
        L103:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            r(r12.createStringArrayList());
            r13.writeNoException();
            return true;
        L105:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            w(r12.createStringArrayList());
            r13.writeNoException();
            return true;
        L107:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            List<DownloadInfo> r50 = m(r12.readString(), r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r50);
            return true;
        L109:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            List<DownloadInfo> r51 = k();
            r13.writeNoException();
            r13.writeTypedList(r51);
            return true;
        L111:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            List<DownloadInfo> r52 = f(r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r52);
            return true;
        L113:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            List<DownloadInfo> r53 = P(r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r53);
            return true;
        L115:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            List<DownloadInfo> r54 = e(r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r54);
            return true;
        L117:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            DownloadInfo r55 = n1(r12.readString(), r12.readString());
            r13.writeNoException();
            if (r55 == null) goto L120;
            r13.writeInt(1);
            r55.writeToParcel(r13, 1);
        L121:
            return true;
        L120:
            r13.writeInt(0);
            goto L121
        L122:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r56 = b0(r12.readString(), r12.readString());
            r13.writeNoException();
            r13.writeInt(r56);
            return true;
        L124:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            List<DownloadInfo> r57 = l(r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r57);
            return true;
        L126:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            DownloadInfo r58 = a(r12.readInt());
            r13.writeNoException();
            if (r58 == null) goto L129;
            r13.writeInt(1);
            r58.writeToParcel(r13, 1);
        L130:
            return true;
        L129:
            r13.writeInt(0);
            goto L130
        L131:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r59 = o(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r59 ? 1 : 0);
            return true;
        L133:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r60 = n(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r60);
            return true;
        L135:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            long r61 = i0(r12.readInt());
            r13.writeNoException();
            r13.writeLong(r61);
            return true;
        L137:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            u();
            r13.writeNoException();
            return true;
        L139:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            z(r12.readInt());
            r13.writeNoException();
            return true;
        L141:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            s(r12.readInt());
            r13.writeNoException();
            return true;
        L143:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r62 = f0(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r62 ? 1 : 0);
            return true;
        L145:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r63 = r12.readInt();
            if (r12.readInt() == 0) goto L148;
            r19 = true;
        L148:
            q(r63, r19);
            r13.writeNoException();
            return true;
        L150:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r64 = r12.readInt();
            if (r12.readInt() == 0) goto L153;
            r19 = true;
        L153:
            o0(r64, r19);
            r13.writeNoException();
            return true;
        L155:
            r12.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            U1(com.ss.android.socialbase.downloader.model.a.AbstractBinderC0149a.U0(r12.readStrongBinder()));
            r13.writeNoException();
            return true;
        L7:
            return super.onTransact(r11, r12, r13, r14);
        L157:
            r13.writeString("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            return true;
        }
    }

    void D(int r10, boolean r11);

    j0 F0(int r10);

    void H0(int r10, boolean r11, boolean r12);

    void J0(int r10, int r11);

    boolean L(DownloadInfo r10);

    c0 O(int r10);

    void O0(int r10, boolean r11);

    List<DownloadInfo> P(String r10);

    void U1(com.ss.android.socialbase.downloader.model.a r10);

    boolean Y();

    void Y0(int r10, int r11, ib.h r12, int r13, boolean r14);

    void Y1(int r10, c0 r11);

    DownloadInfo a(int r10);

    boolean b(DownloadInfo r10);

    int b0(String r10, String r11);

    void c();

    boolean d();

    List<DownloadInfo> e(String r10);

    void e1(int r10, int r11, ib.h r12, int r13, boolean r14);

    List<DownloadInfo> f(String r10);

    boolean f0(int r10);

    List<DownloadInfo> g(String r10);

    void g1(int r10, int r11, ib.h r12, int r13, boolean r14, boolean r15);

    boolean h(int r10);

    void i(int r10);

    long i0(int r10);

    boolean j(int r10);

    List<DownloadInfo> k();

    List<DownloadInfo> l(String r10);

    List<DownloadInfo> m(String r10, String r11);

    int n(int r10);

    DownloadInfo n1(String r10, String r11);

    boolean o(int r10);

    void o0(int r10, boolean r11);

    void p(int r10, boolean r11);

    void q(int r10, boolean r11);

    void r(List<String> r10);

    void s(int r10);

    void t(int r10, long r11, int r12);

    void u();

    ib.f v0(int r10);

    void v1(m0 r10);

    void w(List<String> r10);

    void x(int r10);

    int y0(int r10);

    void z(int r10);
}
