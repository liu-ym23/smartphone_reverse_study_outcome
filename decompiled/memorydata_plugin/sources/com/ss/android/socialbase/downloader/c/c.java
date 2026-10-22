package com.ss.android.socialbase.downloader.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.c.c$a$a, reason: collision with other inner class name */
        private static class C0811a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static c f15289a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15290b;

            C0811a(IBinder r3) {
                this.f15290b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public DownloadInfo a(int r5, long r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                r0.writeLong(r6);     // Catch: Throwable -> L17
                if (this.f15290b.transact(16, r0, r1, 0) == false) goto L6;
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
                if (a.e() == null) goto L10;
                DownloadInfo r7 = a.e().a(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public DownloadInfo a(int r9, long r10, String r12, String r13) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r0.writeInt(r9);     // Catch: Throwable -> L17
                r0.writeLong(r10);     // Catch: Throwable -> L17
                r0.writeString(r12);     // Catch: Throwable -> L17
                r0.writeString(r13);     // Catch: Throwable -> L17
                if (this.f15290b.transact(15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                DownloadInfo r8 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r1), DownloadInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r8;
            L14:
                r8 = null;
                goto L15
            L6:
                if (a.e() == null) goto L10;
                DownloadInfo r11 = a.e().a(r9, r10, r12, r13);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r11;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public List<DownloadInfo> a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                if (this.f15290b.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.e() == null) goto L10;
                List<DownloadInfo> r5 = a.e().a();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public List<DownloadInfo> a(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f15290b.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.e() == null) goto L10;
                List<DownloadInfo> r6 = a.e().a(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public List<DownloadInfo> a(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.f15290b.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.e() == null) goto L10;
                List<DownloadInfo> r7 = a.e().a(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public void a(b r5) {
                b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f15290b.transact(28, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.e() == null) goto L14;
                a.e().a(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public void a(boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                if (r6 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L17
                if (this.f15290b.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.e() == null) goto L14;
                a.e().a(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r4 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public boolean a(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f15290b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (a.e() == null) goto L10;
                boolean r4 = a.e().a(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public boolean a(DownloadInfo r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f15290b.transact(10, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (a.e() == null) goto L14;
                boolean r5 = a.e().a(r6);     // Catch: Throwable -> L20
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f15290b;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public DownloadInfo b(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (this.f15290b.transact(3, r0, r1, 0) == false) goto L6;
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
                if (a.e() == null) goto L10;
                DownloadInfo r6 = a.e().b(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public DownloadInfo b(int r5, long r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                r0.writeLong(r6);     // Catch: Throwable -> L17
                if (this.f15290b.transact(17, r0, r1, 0) == false) goto L6;
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
                if (a.e() == null) goto L10;
                DownloadInfo r7 = a.e().b(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public List<DownloadInfo> b(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f15290b.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.e() == null) goto L10;
                List<DownloadInfo> r6 = a.e().b(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public void b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                if (this.f15290b.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.e() == null) goto L10;
                a.e().b();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public void b(DownloadInfo r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f15290b.transact(26, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.e() == null) goto L14;
                a.e().b(r5);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.c.c
            public DownloadInfo c(int r5, long r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                r0.writeLong(r6);     // Catch: Throwable -> L17
                if (this.f15290b.transact(19, r0, r1, 0) == false) goto L6;
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
                if (a.e() == null) goto L10;
                DownloadInfo r7 = a.e().c(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public List<DownloadInfo> c(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f15290b.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.e() == null) goto L10;
                List<DownloadInfo> r6 = a.e().c(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public boolean c() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f15290b.transact(24, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (a.e() == null) goto L10;
                boolean r4 = a.e().c();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public boolean c(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f15290b.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (a.e() == null) goto L10;
                boolean r4 = a.e().c(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public DownloadInfo d(int r5, long r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                r0.writeLong(r6);     // Catch: Throwable -> L17
                if (this.f15290b.transact(20, r0, r1, 0) == false) goto L6;
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
                if (a.e() == null) goto L10;
                DownloadInfo r7 = a.e().d(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public List<DownloadInfo> d(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f15290b.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.e() == null) goto L10;
                List<DownloadInfo> r6 = a.e().d(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public boolean d() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f15290b.transact(25, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (a.e() == null) goto L10;
                boolean r4 = a.e().d();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public boolean d(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f15290b.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (a.e() == null) goto L10;
                boolean r4 = a.e().d(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public DownloadInfo e(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (this.f15290b.transact(14, r0, r1, 0) == false) goto L6;
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
                if (a.e() == null) goto L10;
                DownloadInfo r6 = a.e().e(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public DownloadInfo e(int r5, long r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                r0.writeLong(r6);     // Catch: Throwable -> L17
                if (this.f15290b.transact(21, r0, r1, 0) == false) goto L6;
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
                if (a.e() == null) goto L10;
                DownloadInfo r7 = a.e().e(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public DownloadInfo f(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (this.f15290b.transact(18, r0, r1, 0) == false) goto L6;
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
                if (a.e() == null) goto L10;
                DownloadInfo r6 = a.e().f(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public DownloadInfo g(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (this.f15290b.transact(22, r0, r1, 0) == false) goto L6;
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
                if (a.e() == null) goto L10;
                DownloadInfo r6 = a.e().g(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public DownloadInfo h(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (this.f15290b.transact(23, r0, r1, 0) == false) goto L6;
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
                if (a.e() == null) goto L10;
                DownloadInfo r6 = a.e().h(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public void i(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.f15290b.transact(27, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.e() == null) goto L10;
                a.e().i(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        public static c a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L13;
            return (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
        L13:
            return new C0811a(r4);
        }

        public static c e() {
            return C0811a.f15289a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r12, Parcel r13, Parcel r14, int r15) {
            if (r12 == 1598968902) goto L106;
            DownloadInfo r3 = null;
            boolean r4 = false;
            switch(r12) {
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
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            a(b.a.a(r13.readStrongBinder()));
            r14.writeNoException();
            return true;
        L10:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            i(r13.readInt());
            r14.writeNoException();
            return true;
        L12:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (r13.readInt() == 0) goto L15;
            r3 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r13), DownloadInfo.class, "com.obric.memorydata.plugin");
        L15:
            b(r3);
            r14.writeNoException();
            return true;
        L17:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            boolean r11 = d();
            r14.writeNoException();
            r14.writeInt(r11 ? 1 : 0);
            return true;
        L19:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            boolean r16 = c();
            r14.writeNoException();
            r14.writeInt(r16 ? 1 : 0);
            return true;
        L21:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r17 = h(r13.readInt());
            r14.writeNoException();
            if (r17 == null) goto L24;
            r14.writeInt(1);
            r17.writeToParcel(r14, 1);
        L25:
            return true;
        L24:
            r14.writeInt(0);
            goto L25
        L26:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r18 = g(r13.readInt());
            r14.writeNoException();
            if (r18 == null) goto L29;
            r14.writeInt(1);
            r18.writeToParcel(r14, 1);
        L30:
            return true;
        L29:
            r14.writeInt(0);
            goto L30
        L31:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r19 = e(r13.readInt(), r13.readLong());
            r14.writeNoException();
            if (r19 == null) goto L34;
            r14.writeInt(1);
            r19.writeToParcel(r14, 1);
        L35:
            return true;
        L34:
            r14.writeInt(0);
            goto L35
        L36:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r110 = d(r13.readInt(), r13.readLong());
            r14.writeNoException();
            if (r110 == null) goto L39;
            r14.writeInt(1);
            r110.writeToParcel(r14, 1);
        L40:
            return true;
        L39:
            r14.writeInt(0);
            goto L40
        L41:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r111 = c(r13.readInt(), r13.readLong());
            r14.writeNoException();
            if (r111 == null) goto L44;
            r14.writeInt(1);
            r111.writeToParcel(r14, 1);
        L45:
            return true;
        L44:
            r14.writeInt(0);
            goto L45
        L46:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r112 = f(r13.readInt());
            r14.writeNoException();
            if (r112 == null) goto L49;
            r14.writeInt(1);
            r112.writeToParcel(r14, 1);
        L50:
            return true;
        L49:
            r14.writeInt(0);
            goto L50
        L51:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r113 = b(r13.readInt(), r13.readLong());
            r14.writeNoException();
            if (r113 == null) goto L54;
            r14.writeInt(1);
            r113.writeToParcel(r14, 1);
        L55:
            return true;
        L54:
            r14.writeInt(0);
            goto L55
        L56:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r114 = a(r13.readInt(), r13.readLong());
            r14.writeNoException();
            if (r114 == null) goto L59;
            r14.writeInt(1);
            r114.writeToParcel(r14, 1);
        L60:
            return true;
        L59:
            r14.writeInt(0);
            goto L60
        L61:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r115 = a(r13.readInt(), r13.readLong(), r13.readString(), r13.readString());
            r14.writeNoException();
            if (r115 == null) goto L64;
            r14.writeInt(1);
            r115.writeToParcel(r14, 1);
        L65:
            return true;
        L64:
            r14.writeInt(0);
            goto L65
        L66:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r116 = e(r13.readInt());
            r14.writeNoException();
            if (r116 == null) goto L69;
            r14.writeInt(1);
            r116.writeToParcel(r14, 1);
        L70:
            return true;
        L69:
            r14.writeInt(0);
            goto L70
        L71:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            b();
            r14.writeNoException();
            return true;
        L73:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            boolean r117 = d(r13.readInt());
            r14.writeNoException();
            r14.writeInt(r117 ? 1 : 0);
            return true;
        L75:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            boolean r118 = c(r13.readInt());
            r14.writeNoException();
            r14.writeInt(r118 ? 1 : 0);
            return true;
        L77:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (r13.readInt() == 0) goto L80;
            r3 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r13), DownloadInfo.class, "com.obric.memorydata.plugin");
        L80:
            boolean r119 = a(r3);
            r14.writeNoException();
            r14.writeInt(r119 ? 1 : 0);
            return true;
        L82:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List<DownloadInfo> r120 = a(r13.readString(), r13.readString());
            r14.writeNoException();
            r14.writeTypedList(r120);
            return true;
        L84:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List<DownloadInfo> r121 = a();
            r14.writeNoException();
            r14.writeTypedList(r121);
            return true;
        L86:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List<DownloadInfo> r122 = d(r13.readString());
            r14.writeNoException();
            r14.writeTypedList(r122);
            return true;
        L88:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List<DownloadInfo> r123 = c(r13.readString());
            r14.writeNoException();
            r14.writeTypedList(r123);
            return true;
        L90:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List<DownloadInfo> r124 = b(r13.readString());
            r14.writeNoException();
            r14.writeTypedList(r124);
            return true;
        L92:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List<DownloadInfo> r125 = a(r13.readString());
            r14.writeNoException();
            r14.writeTypedList(r125);
            return true;
        L94:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r126 = b(r13.readInt());
            r14.writeNoException();
            if (r126 == null) goto L97;
            r14.writeInt(1);
            r126.writeToParcel(r14, 1);
        L98:
            return true;
        L97:
            r14.writeInt(0);
            goto L98
        L99:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            boolean r127 = a(r13.readInt());
            r14.writeNoException();
            r14.writeInt(r127 ? 1 : 0);
            return true;
        L101:
            r13.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (r13.readInt() == 0) goto L104;
            r4 = true;
        L104:
            a(r4);
            r14.writeNoException();
            return true;
        L7:
            return super.onTransact(r12, r13, r14, r15);
        L106:
            r14.writeString("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            return true;
        }
    }

    DownloadInfo a(int r1, long r2);

    DownloadInfo a(int r1, long r2, String r4, String r5);

    List<DownloadInfo> a();

    List<DownloadInfo> a(String r1);

    List<DownloadInfo> a(String r1, String r2);

    void a(b r1);

    void a(boolean r1);

    boolean a(int r1);

    boolean a(DownloadInfo r1);

    DownloadInfo b(int r1);

    DownloadInfo b(int r1, long r2);

    List<DownloadInfo> b(String r1);

    void b();

    void b(DownloadInfo r1);

    DownloadInfo c(int r1, long r2);

    List<DownloadInfo> c(String r1);

    boolean c();

    boolean c(int r1);

    DownloadInfo d(int r1, long r2);

    List<DownloadInfo> d(String r1);

    boolean d();

    boolean d(int r1);

    DownloadInfo e(int r1);

    DownloadInfo e(int r1, long r2);

    DownloadInfo f(int r1);

    DownloadInfo g(int r1);

    DownloadInfo h(int r1);

    void i(int r1);
}
