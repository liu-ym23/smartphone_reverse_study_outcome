package com.ss.android.socialbase.downloader.downloader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface g extends IInterface {

    public static abstract class a extends Binder implements g {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.downloader.g$a$a, reason: collision with other inner class name */
        private static class C0827a implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static g f15422a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15423b;

            C0827a(IBinder r3) {
                this.f15423b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public int a(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.f15423b.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.f() == null) goto L10;
                int r7 = a.f().a(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public List<DownloadInfo> a(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.f() == null) goto L10;
                List<DownloadInfo> r6 = a.f().a(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                if (this.f15423b.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.f() == null) goto L10;
                a.f().a();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void a(int r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.f15423b.transact(40, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.f() == null) goto L10;
                a.f().a(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void a(int r8, int r9, com.ss.android.socialbase.downloader.depend.g r10, int r11, boolean r12) {
                com.ss.android.socialbase.downloader.depend.g r3 = (com.ss.android.socialbase.downloader.depend.g) ZeusTransformUtils.wrapperContextForParams(r10, com.ss.android.socialbase.downloader.depend.g.class, "com.obric.memorydata.plugin");
                Parcel r13 = Parcel.obtain();
                Parcel r6 = Parcel.obtain();
                r13.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L21
                r13.writeInt(r8);     // Catch: Throwable -> L21
                r13.writeInt(r9);     // Catch: Throwable -> L21
                if (r3 == null) goto L6;
                IBinder r0 = r3.asBinder();     // Catch: Throwable -> L21
            L7:
                r13.writeStrongBinder(r0);     // Catch: Throwable -> L21
                r13.writeInt(r11);     // Catch: Throwable -> L21
                if (r12 == false) goto L10;
                int r1 = 1;
            L11:
                r13.writeInt(r1);     // Catch: Throwable -> L21
                if (this.f15423b.transact(24, r13, r6, 0) == false) goto L14;
            L18:
                r6.readException();     // Catch: Throwable -> L21
                r6.recycle();
                r13.recycle();
                return;
            L14:
                if (a.f() == null) goto L18;
                a.f().a(r8, r9, r3, r11, r12);     // Catch: Throwable -> L21
                r6.recycle();
                r13.recycle();
                return;
            L10:
                r1 = 0;
                goto L11
            L6:
                r0 = null;
            L21:
                th = move-exception;
                r6.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void a(int r9, int r10, com.ss.android.socialbase.downloader.depend.g r11, int r12, boolean r13, boolean r14) {
                com.ss.android.socialbase.downloader.depend.g r3 = (com.ss.android.socialbase.downloader.depend.g) ZeusTransformUtils.wrapperContextForParams(r11, com.ss.android.socialbase.downloader.depend.g.class, "com.obric.memorydata.plugin");
                Parcel r15 = Parcel.obtain();
                Parcel r7 = Parcel.obtain();
                r15.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L25
                r15.writeInt(r9);     // Catch: Throwable -> L25
                r15.writeInt(r10);     // Catch: Throwable -> L25
                if (r3 == null) goto L6;
                IBinder r0 = r3.asBinder();     // Catch: Throwable -> L25
            L7:
                r15.writeStrongBinder(r0);     // Catch: Throwable -> L25
                r15.writeInt(r12);     // Catch: Throwable -> L25
                int r1 = 1;
                if (r13 == false) goto L10;
                int r2 = 1;
            L11:
                r15.writeInt(r2);     // Catch: Throwable -> L25
                if (r14 == true) goto L15;
                r1 = 0;
            L15:
                r15.writeInt(r1);     // Catch: Throwable -> L25
                if (this.f15423b.transact(26, r15, r7, 0) == false) goto L18;
            L22:
                r7.readException();     // Catch: Throwable -> L25
                r7.recycle();
                r15.recycle();
                return;
            L18:
                if (a.f() == null) goto L22;
                a.f().a(r9, r10, r3, r12, r13, r14);     // Catch: Throwable -> L25
                r7.recycle();
                r15.recycle();
                return;
            L10:
                r2 = 0;
                goto L11
            L6:
                r0 = null;
            L25:
                th = move-exception;
                r7.recycle();
                r15.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void a(int r5, long r6, int r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeLong(r6);     // Catch: Throwable -> L13
                r0.writeInt(r8);     // Catch: Throwable -> L13
                if (this.f15423b.transact(45, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.f() == null) goto L10;
                a.f().a(r5, r6, r8);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void a(int r5, z r6) {
                z r7 = (z) ZeusTransformUtils.wrapperContextForParams(r6, z.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f15423b.transact(43, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.f() == null) goto L14;
                a.f().a(r5, r7);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void a(int r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r6 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (this.f15423b.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.f() == null) goto L14;
                a.f().a(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void a(int r6, boolean r7, boolean r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L21
                r0.writeInt(r6);     // Catch: Throwable -> L21
                int r2 = 1;
                if (r7 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L21
                if (r8 == true) goto L11;
                r2 = 0;
            L11:
                r0.writeInt(r2);     // Catch: Throwable -> L21
                if (this.f15423b.transact(22, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (a.f() == null) goto L18;
                a.f().a(r6, r7, r8);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r4 = 0;
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void a(aj r5) {
                aj r6 = (aj) ZeusTransformUtils.wrapperContextForParams(r5, aj.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f15423b.transact(39, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.f() == null) goto L14;
                a.f().a(r6);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void a(com.ss.android.socialbase.downloader.model.a r5) {
                com.ss.android.socialbase.downloader.model.a r6 = (com.ss.android.socialbase.downloader.model.a) ZeusTransformUtils.wrapperContextForParams(r5, com.ss.android.socialbase.downloader.model.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f15423b.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.f() == null) goto L14;
                a.f().a(r6);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void a(List<String> r5) {
                List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeStringList(r6);     // Catch: Throwable -> L13
                if (this.f15423b.transact(20, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.f() == null) goto L10;
                a.f().a(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public boolean a(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f15423b.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (a.f() == null) goto L10;
                boolean r4 = a.f().a(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public boolean a(DownloadInfo r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f15423b.transact(27, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (a.f() == null) goto L14;
                boolean r5 = a.f().a(r6);     // Catch: Throwable -> L20
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
                return this.f15423b;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public DownloadInfo b(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (this.f15423b.transact(14, r0, r1, 0) == false) goto L6;
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
                if (a.f() == null) goto L10;
                DownloadInfo r7 = a.f().b(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public List<DownloadInfo> b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                if (this.f15423b.transact(18, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.f() == null) goto L10;
                List<DownloadInfo> r5 = a.f().b();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public List<DownloadInfo> b(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.f() == null) goto L10;
                List<DownloadInfo> r6 = a.f().b(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void b(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.f() == null) goto L10;
                a.f().b(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void b(int r8, int r9, com.ss.android.socialbase.downloader.depend.g r10, int r11, boolean r12) {
                com.ss.android.socialbase.downloader.depend.g r3 = (com.ss.android.socialbase.downloader.depend.g) ZeusTransformUtils.wrapperContextForParams(r10, com.ss.android.socialbase.downloader.depend.g.class, "com.obric.memorydata.plugin");
                Parcel r13 = Parcel.obtain();
                Parcel r6 = Parcel.obtain();
                r13.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L21
                r13.writeInt(r8);     // Catch: Throwable -> L21
                r13.writeInt(r9);     // Catch: Throwable -> L21
                if (r3 == null) goto L6;
                IBinder r0 = r3.asBinder();     // Catch: Throwable -> L21
            L7:
                r13.writeStrongBinder(r0);     // Catch: Throwable -> L21
                r13.writeInt(r11);     // Catch: Throwable -> L21
                if (r12 == false) goto L10;
                int r1 = 1;
            L11:
                r13.writeInt(r1);     // Catch: Throwable -> L21
                if (this.f15423b.transact(25, r13, r6, 0) == false) goto L14;
            L18:
                r6.readException();     // Catch: Throwable -> L21
                r6.recycle();
                r13.recycle();
                return;
            L14:
                if (a.f() == null) goto L18;
                a.f().b(r8, r9, r3, r11, r12);     // Catch: Throwable -> L21
                r6.recycle();
                r13.recycle();
                return;
            L10:
                r1 = 0;
                goto L11
            L6:
                r0 = null;
            L21:
                th = move-exception;
                r6.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void b(int r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r6 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (this.f15423b.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.f() == null) goto L14;
                a.f().b(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void b(List<String> r5) {
                List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeStringList(r6);     // Catch: Throwable -> L13
                if (this.f15423b.transact(21, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.f() == null) goto L10;
                a.f().b(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public boolean b(DownloadInfo r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f15423b.transact(34, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (a.f() == null) goto L14;
                boolean r5 = a.f().b(r6);     // Catch: Throwable -> L20
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

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public List<DownloadInfo> c(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(16, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.f() == null) goto L10;
                List<DownloadInfo> r6 = a.f().c(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public List<DownloadInfo> c(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.f15423b.transact(19, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.f() == null) goto L10;
                List<DownloadInfo> r7 = a.f().c(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void c(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.f() == null) goto L10;
                a.f().c(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void c(int r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r6 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (this.f15423b.transact(23, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.f() == null) goto L14;
                a.f().c(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public boolean c() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f15423b.transact(28, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (a.f() == null) goto L10;
                boolean r4 = a.f().c();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public long d(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                long r4 = r1.readLong();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.f() == null) goto L10;
                long r6 = a.f().d(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public List<DownloadInfo> d(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(17, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.f() == null) goto L10;
                List<DownloadInfo> r6 = a.f().d(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void d(int r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r6 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (this.f15423b.transact(32, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.f() == null) goto L14;
                a.f().d(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public boolean d() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f15423b.transact(31, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (a.f() == null) goto L10;
                boolean r4 = a.f().d();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public int e(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.f() == null) goto L10;
                int r6 = a.f().e(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public List<DownloadInfo> e(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(29, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.f() == null) goto L10;
                List<DownloadInfo> r6 = a.f().e(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void e() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                if (this.f15423b.transact(37, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.f() == null) goto L10;
                a.f().e();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public boolean f(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f15423b.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (a.f() == null) goto L10;
                boolean r4 = a.f().f(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public DownloadInfo g(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (this.f15423b.transact(11, r0, r1, 0) == false) goto L6;
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
                if (a.f() == null) goto L10;
                DownloadInfo r6 = a.f().g(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void h(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(30, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.f() == null) goto L10;
                a.f().h(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public int i(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(33, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.f() == null) goto L10;
                int r6 = a.f().i(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public boolean j(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f15423b.transact(35, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (a.f() == null) goto L10;
                boolean r4 = a.f().j(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public boolean k(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f15423b.transact(36, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (a.f() == null) goto L10;
                boolean r4 = a.f().k(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public void l(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(38, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.f() == null) goto L10;
                a.f().l(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public z m(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(41, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                z r4 = z.a.a(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.f() == null) goto L10;
                z r6 = a.f().m(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public ag n(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(42, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ag r4 = ag.a.a(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.f() == null) goto L10;
                ag r6 = a.f().n(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public com.ss.android.socialbase.downloader.depend.e o(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.f15423b.transact(44, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                com.ss.android.socialbase.downloader.depend.e r4 = com.ss.android.socialbase.downloader.depend.e.a.a(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.f() == null) goto L10;
                com.ss.android.socialbase.downloader.depend.e r6 = a.f().o(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        }

        public static g a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, g.class) == false) goto L13;
            return (g) ZeusTransformUtils.preCheckCast(r0, g.class, "com.obric.memorydata.plugin");
        L13:
            return new C0827a(r4);
        }

        public static g f() {
            return C0827a.f15422a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 == 1598968902) goto L151;
            DownloadInfo r5 = null;
            IBinder r6 = null;
            IBinder r7 = null;
            IBinder r8 = null;
            DownloadInfo r9 = null;
            boolean r14 = false;
            switch(r10) {
                case 1: goto L149;
                case 2: goto L144;
                case 3: goto L139;
                case 4: goto L137;
                case 5: goto L135;
                case 6: goto L133;
                case 7: goto L131;
                case 8: goto L129;
                case 9: goto L127;
                case 10: goto L125;
                case 11: goto L120;
                case 12: goto L118;
                case 13: goto L116;
                case 14: goto L111;
                case 15: goto L109;
                case 16: goto L107;
                case 17: goto L105;
                case 18: goto L103;
                case 19: goto L101;
                case 20: goto L99;
                case 21: goto L97;
                case 22: goto L88;
                case 23: goto L83;
                case 24: goto L78;
                case 25: goto L73;
                case 26: goto L64;
                case 27: goto L59;
                case 28: goto L57;
                case 29: goto L55;
                case 30: goto L53;
                case 31: goto L51;
                case 32: goto L46;
                case 33: goto L44;
                case 34: goto L39;
                case 35: goto L37;
                case 36: goto L35;
                case 37: goto L33;
                case 38: goto L31;
                case 39: goto L29;
                case 40: goto L27;
                case 41: goto L22;
                case 42: goto L17;
                case 43: goto L15;
                case 44: goto L10;
                case 45: goto L8;
                default: goto L7;
            };
        L8:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            a(r11.readInt(), r11.readLong(), r11.readInt());
            r12.writeNoException();
            return true;
        L10:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            com.ss.android.socialbase.downloader.depend.e r0 = o(r11.readInt());
            r12.writeNoException();
            if (r0 == null) goto L13;
            r6 = r0.asBinder();
        L13:
            r12.writeStrongBinder(r6);
            return true;
        L15:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            a(r11.readInt(), z.a.a(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L17:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ag r1 = n(r11.readInt());
            r12.writeNoException();
            if (r1 == null) goto L20;
            r7 = r1.asBinder();
        L20:
            r12.writeStrongBinder(r7);
            return true;
        L22:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            z r2 = m(r11.readInt());
            r12.writeNoException();
            if (r2 == null) goto L25;
            r8 = r2.asBinder();
        L25:
            r12.writeStrongBinder(r8);
            return true;
        L27:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            a(r11.readInt(), r11.readInt());
            r12.writeNoException();
            return true;
        L29:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            a(aj.a.a(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L31:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            l(r11.readInt());
            r12.writeNoException();
            return true;
        L33:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            e();
            r12.writeNoException();
            return true;
        L35:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r3 = k(r11.readInt());
            r12.writeNoException();
            r12.writeInt(r3 ? 1 : 0);
            return true;
        L37:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r4 = j(r11.readInt());
            r12.writeNoException();
            r12.writeInt(r4 ? 1 : 0);
            return true;
        L39:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (r11.readInt() == 0) goto L42;
            r9 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r11), DownloadInfo.class, "com.obric.memorydata.plugin");
        L42:
            boolean r15 = b(r9);
            r12.writeNoException();
            r12.writeInt(r15 ? 1 : 0);
            return true;
        L44:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r16 = i(r11.readInt());
            r12.writeNoException();
            r12.writeInt(r16);
            return true;
        L46:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r17 = r11.readInt();
            if (r11.readInt() == 0) goto L49;
            r14 = true;
        L49:
            d(r17, r14);
            r12.writeNoException();
            return true;
        L51:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r18 = d();
            r12.writeNoException();
            r12.writeInt(r18 ? 1 : 0);
            return true;
        L53:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            h(r11.readInt());
            r12.writeNoException();
            return true;
        L55:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            List<DownloadInfo> r19 = e(r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r19);
            return true;
        L57:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r20 = c();
            r12.writeNoException();
            r12.writeInt(r20 ? 1 : 0);
            return true;
        L59:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (r11.readInt() == 0) goto L62;
            r5 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r11), DownloadInfo.class, "com.obric.memorydata.plugin");
        L62:
            boolean r21 = a(r5);
            r12.writeNoException();
            r12.writeInt(r21 ? 1 : 0);
            return true;
        L64:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r22 = r11.readInt();
            int r23 = r11.readInt();
            com.ss.android.socialbase.downloader.depend.g r24 = com.ss.android.socialbase.downloader.depend.g.a.a(r11.readStrongBinder());
            int r25 = r11.readInt();
            if (r11.readInt() == 0) goto L67;
            boolean r26 = true;
        L69:
            if (r11.readInt() == 0) goto L71;
            r14 = true;
        L71:
            a(r22, r23, r24, r25, r26, r14);
            r12.writeNoException();
            return true;
        L67:
            r26 = false;
            goto L69
        L73:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r27 = r11.readInt();
            int r28 = r11.readInt();
            com.ss.android.socialbase.downloader.depend.g r29 = com.ss.android.socialbase.downloader.depend.g.a.a(r11.readStrongBinder());
            int r30 = r11.readInt();
            if (r11.readInt() == 0) goto L76;
            r14 = true;
        L76:
            b(r27, r28, r29, r30, r14);
            r12.writeNoException();
            return true;
        L78:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r31 = r11.readInt();
            int r32 = r11.readInt();
            com.ss.android.socialbase.downloader.depend.g r33 = com.ss.android.socialbase.downloader.depend.g.a.a(r11.readStrongBinder());
            int r34 = r11.readInt();
            if (r11.readInt() == 0) goto L81;
            r14 = true;
        L81:
            a(r31, r32, r33, r34, r14);
            r12.writeNoException();
            return true;
        L83:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r35 = r11.readInt();
            if (r11.readInt() == 0) goto L86;
            r14 = true;
        L86:
            c(r35, r14);
            r12.writeNoException();
            return true;
        L88:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r36 = r11.readInt();
            if (r11.readInt() == 0) goto L91;
            boolean r37 = true;
        L93:
            if (r11.readInt() == 0) goto L95;
            r14 = true;
        L95:
            a(r36, r37, r14);
            r12.writeNoException();
            return true;
        L91:
            r37 = false;
            goto L93
        L97:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            b(r11.createStringArrayList());
            r12.writeNoException();
            return true;
        L99:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            a(r11.createStringArrayList());
            r12.writeNoException();
            return true;
        L101:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            List<DownloadInfo> r38 = c(r11.readString(), r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r38);
            return true;
        L103:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            List<DownloadInfo> r39 = b();
            r12.writeNoException();
            r12.writeTypedList(r39);
            return true;
        L105:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            List<DownloadInfo> r40 = d(r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r40);
            return true;
        L107:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            List<DownloadInfo> r41 = c(r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r41);
            return true;
        L109:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            List<DownloadInfo> r42 = b(r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r42);
            return true;
        L111:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            DownloadInfo r43 = b(r11.readString(), r11.readString());
            r12.writeNoException();
            if (r43 == null) goto L114;
            r12.writeInt(1);
            r43.writeToParcel(r12, 1);
        L115:
            return true;
        L114:
            r12.writeInt(0);
            goto L115
        L116:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r44 = a(r11.readString(), r11.readString());
            r12.writeNoException();
            r12.writeInt(r44);
            return true;
        L118:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            List<DownloadInfo> r45 = a(r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r45);
            return true;
        L120:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            DownloadInfo r46 = g(r11.readInt());
            r12.writeNoException();
            if (r46 == null) goto L123;
            r12.writeInt(1);
            r46.writeToParcel(r12, 1);
        L124:
            return true;
        L123:
            r12.writeInt(0);
            goto L124
        L125:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r47 = f(r11.readInt());
            r12.writeNoException();
            r12.writeInt(r47 ? 1 : 0);
            return true;
        L127:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r48 = e(r11.readInt());
            r12.writeNoException();
            r12.writeInt(r48);
            return true;
        L129:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            long r49 = d(r11.readInt());
            r12.writeNoException();
            r12.writeLong(r49);
            return true;
        L131:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            a();
            r12.writeNoException();
            return true;
        L133:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            c(r11.readInt());
            r12.writeNoException();
            return true;
        L135:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            b(r11.readInt());
            r12.writeNoException();
            return true;
        L137:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r50 = a(r11.readInt());
            r12.writeNoException();
            r12.writeInt(r50 ? 1 : 0);
            return true;
        L139:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r51 = r11.readInt();
            if (r11.readInt() == 0) goto L142;
            r14 = true;
        L142:
            b(r51, r14);
            r12.writeNoException();
            return true;
        L144:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r52 = r11.readInt();
            if (r11.readInt() == 0) goto L147;
            r14 = true;
        L147:
            a(r52, r14);
            r12.writeNoException();
            return true;
        L149:
            r11.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            a(com.ss.android.socialbase.downloader.model.a.AbstractBinderC0833a.a(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        L151:
            r12.writeString("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            return true;
        }
    }

    int a(String r1, String r2);

    List<DownloadInfo> a(String r1);

    void a();

    void a(int r1, int r2);

    void a(int r1, int r2, com.ss.android.socialbase.downloader.depend.g r3, int r4, boolean r5);

    void a(int r1, int r2, com.ss.android.socialbase.downloader.depend.g r3, int r4, boolean r5, boolean r6);

    void a(int r1, long r2, int r4);

    void a(int r1, z r2);

    void a(int r1, boolean r2);

    void a(int r1, boolean r2, boolean r3);

    void a(aj r1);

    void a(com.ss.android.socialbase.downloader.model.a r1);

    void a(List<String> r1);

    boolean a(int r1);

    boolean a(DownloadInfo r1);

    DownloadInfo b(String r1, String r2);

    List<DownloadInfo> b();

    List<DownloadInfo> b(String r1);

    void b(int r1);

    void b(int r1, int r2, com.ss.android.socialbase.downloader.depend.g r3, int r4, boolean r5);

    void b(int r1, boolean r2);

    void b(List<String> r1);

    boolean b(DownloadInfo r1);

    List<DownloadInfo> c(String r1);

    List<DownloadInfo> c(String r1, String r2);

    void c(int r1);

    void c(int r1, boolean r2);

    boolean c();

    long d(int r1);

    List<DownloadInfo> d(String r1);

    void d(int r1, boolean r2);

    boolean d();

    int e(int r1);

    List<DownloadInfo> e(String r1);

    void e();

    boolean f(int r1);

    DownloadInfo g(int r1);

    void h(int r1);

    int i(int r1);

    boolean j(int r1);

    boolean k(int r1);

    void l(int r1);

    z m(int r1);

    ag n(int r1);

    com.ss.android.socialbase.downloader.depend.e o(int r1);
}
