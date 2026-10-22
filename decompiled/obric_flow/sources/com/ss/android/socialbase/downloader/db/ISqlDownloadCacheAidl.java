package com.ss.android.socialbase.downloader.db;

import android.content.ContentValues;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.core.app.NotificationCompat;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ISqlDownloadCacheAidl extends IInterface {

    public static abstract class Stub extends Binder implements ISqlDownloadCacheAidl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15398a = 0;

        public static class Proxy implements ISqlDownloadCacheAidl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15399a;

            public Proxy(IBinder r5) {
                this.f15399a = r5;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final void a(boolean r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r10.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L6
                if (this.f15399a.transact(1, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15398a;     // Catch: Throwable -> L6
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

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15399a;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final List b(String r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r10.writeString(r5);     // Catch: Throwable -> L6
                if (this.f15399a.transact(5, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                ArrayList r13 = r11.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r13;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final List c(String r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r10.writeString(r5);     // Catch: Throwable -> L6
                if (this.f15399a.transact(4, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                ArrayList r13 = r11.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r13;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final List d(String r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r10.writeString(r5);     // Catch: Throwable -> L6
                if (this.f15399a.transact(7, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                ArrayList r13 = r11.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r13;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final DownloadInfo e(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                if (this.f15399a.transact(18, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() == 0) goto L12;
                DownloadInfo r13 = DownloadInfo.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L6
            L13:
                r11.recycle();
                r10.recycle();
                return r13;
            L12:
                r13 = null;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final DownloadInfo h(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                if (this.f15399a.transact(14, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() == 0) goto L12;
                DownloadInfo r13 = DownloadInfo.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L6
            L13:
                r11.recycle();
                r10.recycle();
                return r13;
            L12:
                r13 = null;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final DownloadInfo j(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                if (this.f15399a.transact(23, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() == 0) goto L12;
                DownloadInfo r13 = DownloadInfo.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L6
            L13:
                r11.recycle();
                r10.recycle();
                return r13;
            L12:
                r13 = null;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final DownloadInfo k(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                if (this.f15399a.transact(22, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() == 0) goto L12;
                DownloadInfo r13 = DownloadInfo.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L6
            L13:
                r11.recycle();
                r10.recycle();
                return r13;
            L12:
                r13 = null;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final DownloadInfo a(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                if (this.f15399a.transact(3, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() == 0) goto L12;
                DownloadInfo r13 = DownloadInfo.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L6
            L13:
                r11.recycle();
                r10.recycle();
                return r13;
            L12:
                r13 = null;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final boolean b(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                boolean r12 = false;
                if (this.f15399a.transact(11, r10, r11, 0) == true) goto L8;
                int r13 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() == 0) goto L11;
                r12 = true;
            L11:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final DownloadInfo c(int r5, long r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r11.writeInt(r5);     // Catch: Throwable -> L6
                r11.writeLong(r10);     // Catch: Throwable -> L6
                if (this.f15399a.transact(17, r11, r12, 0) == true) goto L8;
                int r13 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r12.readException();     // Catch: Throwable -> L6
                if (r12.readInt() == 0) goto L12;
                DownloadInfo r14 = DownloadInfo.CREATOR.createFromParcel(r12);     // Catch: Throwable -> L6
            L13:
                r12.recycle();
                r11.recycle();
                return r14;
            L12:
                r14 = null;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final List d() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                if (this.f15399a.transact(8, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                ArrayList r12 = r10.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r12;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final boolean e() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                boolean r11 = false;
                if (this.f15399a.transact(25, r5, r10, 0) == true) goto L8;
                int r12 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                if (r10.readInt() == 0) goto L11;
                r11 = true;
            L11:
                r10.recycle();
                r5.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final boolean d(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                boolean r12 = false;
                if (this.f15399a.transact(12, r10, r11, 0) == true) goto L8;
                int r13 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() == 0) goto L11;
                r12 = true;
            L11:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final List a(String r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r10.writeString(r5);     // Catch: Throwable -> L6
                if (this.f15399a.transact(6, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                ArrayList r13 = r11.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r13;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final DownloadInfo b(int r5, long r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r11.writeInt(r5);     // Catch: Throwable -> L6
                r11.writeLong(r10);     // Catch: Throwable -> L6
                if (this.f15399a.transact(16, r11, r12, 0) == true) goto L8;
                int r13 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r12.readException();     // Catch: Throwable -> L6
                if (r12.readInt() == 0) goto L12;
                DownloadInfo r14 = DownloadInfo.CREATOR.createFromParcel(r12);     // Catch: Throwable -> L6
            L13:
                r12.recycle();
                r11.recycle();
                return r14;
            L12:
                r14 = null;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final boolean c() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                boolean r11 = false;
                if (this.f15399a.transact(24, r5, r10, 0) == true) goto L8;
                int r12 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                if (r10.readInt() == 0) goto L11;
                r11 = true;
            L11:
                r10.recycle();
                r5.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final DownloadInfo d(int r5, long r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r11.writeInt(r5);     // Catch: Throwable -> L6
                r11.writeLong(r10);     // Catch: Throwable -> L6
                if (this.f15399a.transact(19, r11, r12, 0) == true) goto L8;
                int r13 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r12.readException();     // Catch: Throwable -> L6
                if (r12.readInt() == 0) goto L12;
                DownloadInfo r14 = DownloadInfo.CREATOR.createFromParcel(r12);     // Catch: Throwable -> L6
            L13:
                r12.recycle();
                r11.recycle();
                return r14;
            L12:
                r14 = null;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final List a(String r5, String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r11.writeString(r5);     // Catch: Throwable -> L6
                r11.writeString(r10);     // Catch: Throwable -> L6
                if (this.f15399a.transact(9, r11, r12, 0) == true) goto L8;
                int r13 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r12.readException();     // Catch: Throwable -> L6
                ArrayList r14 = r12.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r14;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final void c(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                if (this.f15399a.transact(27, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15398a;     // Catch: Throwable -> L6
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final void b(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
                if (this.f15399a.transact(26, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15398a;     // Catch: Throwable -> L6
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final boolean a(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                boolean r12 = true;
                if (r5 == null) goto L8;
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f15399a.transact(10, r10, r11, 0) == true) goto L12;
                int r13 = Stub.f15398a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() != 0) goto L16;
                r12 = false;
            L16:
                r11.recycle();
                r10.recycle();
                return r12;
            L8:
                r10.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final void a() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                if (this.f15399a.transact(13, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final DownloadInfo a(int r5, long r10, String r11, String r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r13.writeInt(r5);     // Catch: Throwable -> L6
                r13.writeLong(r10);     // Catch: Throwable -> L6
                r13.writeString(r11);     // Catch: Throwable -> L6
                r13.writeString(r12);     // Catch: Throwable -> L6
                if (this.f15399a.transact(15, r13, r14, 0) == true) goto L8;
                int r15 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r14.readException();     // Catch: Throwable -> L6
                if (r14.readInt() == 0) goto L12;
                DownloadInfo r16 = DownloadInfo.CREATOR.createFromParcel(r14);     // Catch: Throwable -> L6
            L13:
                r14.recycle();
                r13.recycle();
                return r16;
            L12:
                r16 = null;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final DownloadInfo a(int r5, long r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                r11.writeInt(r5);     // Catch: Throwable -> L6
                r11.writeLong(r10);     // Catch: Throwable -> L6
                if (this.f15399a.transact(20, r11, r12, 0) == true) goto L8;
                int r13 = Stub.f15398a;     // Catch: Throwable -> L6
            L8:
                r12.readException();     // Catch: Throwable -> L6
                if (r12.readInt() == 0) goto L12;
                DownloadInfo r14 = DownloadInfo.CREATOR.createFromParcel(r12);     // Catch: Throwable -> L6
            L13:
                r12.recycle();
                r11.recycle();
                return r14;
            L12:
                r14 = null;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public final void a(ISqlCacheLoadCompleteCallbackAidl r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                IBinder r12 = r5.asBinder();     // Catch: Throwable -> L6
            L9:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L6
                if (this.f15399a.transact(28, r10, r11, 0) == true) goto L12;
                int r13 = Stub.f15398a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L8:
                r12 = null;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r16, Parcel r17, Parcel r18, int r19) {
            if (r16 == 1598968902) goto L91;
            DownloadInfo r5 = null;
            ISqlCacheLoadCompleteCallbackAidl r10 = null;
            boolean r11 = false;
            int r12 = 0;
            r12 = 0;
            switch(r16) {
                case 1: goto L86;
                case 2: goto L78;
                case 3: goto L73;
                case 4: goto L71;
                case 5: goto L69;
                case 6: goto L67;
                case 7: goto L65;
                case 8: goto L63;
                case 9: goto L61;
                case 10: goto L56;
                case 11: goto L54;
                case 12: goto L52;
                case 13: goto L50;
                case 14: goto L48;
                case 15: goto L46;
                case 16: goto L44;
                case 17: goto L42;
                case 18: goto L40;
                case 19: goto L38;
                case 20: goto L36;
                case 21: goto L34;
                case 22: goto L32;
                case 23: goto L30;
                case 24: goto L28;
                case 25: goto L26;
                case 26: goto L21;
                case 27: goto L19;
                case 28: goto L8;
                default: goto L7;
            };
        L8:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            IBinder r13 = r17.readStrongBinder();
            if (r13 == null) goto L17;
            IInterface r14 = r13.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            if (r14 != null) goto L14;
        L16:
            r10 = new ISqlCacheLoadCompleteCallbackAidl.Stub.Proxy(r13);
            goto L17
        L14:
            if ((r14 instanceof ISqlCacheLoadCompleteCallbackAidl) == false) goto L16;
            r10 = (ISqlCacheLoadCompleteCallbackAidl) r14;
        L17:
            ((SqlDownloadCache) this).f15410i = r10;
            r18.writeNoException();
            return true;
        L19:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            r17.readInt();
            r18.writeNoException();
            return true;
        L21:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (r17.readInt() == 0) goto L24;
            DownloadInfo r15 = DownloadInfo.CREATOR.createFromParcel(r17);
        L24:
            r18.writeNoException();
            return true;
        L26:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            r18.writeNoException();
            r18.writeInt(0);
            return true;
        L28:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            boolean r20 = ((SqlDownloadCache) this).d;
            r18.writeNoException();
            r18.writeInt(r20 ? 1 : 0);
            return true;
        L30:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            ((SqlDownloadCache) this).j(r17.readInt());
            r18.writeNoException();
            r18.writeInt(0);
            return true;
        L32:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            ((SqlDownloadCache) this).k(r17.readInt());
            r18.writeNoException();
            r18.writeInt(0);
            return true;
        L34:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            int r21 = r17.readInt();
            long r22 = r17.readLong();
            ContentValues r23 = new ContentValues();
            r23.put(NotificationCompat.CATEGORY_STATUS, -4);
            r23.put("curBytes", Long.valueOf(r22));
            DownloadComponentManager.a(new SqlDownloadCache.AnonymousClass19((SqlDownloadCache) this, r21, r23));
            r18.writeNoException();
            r18.writeInt(0);
            return true;
        L36:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            ((SqlDownloadCache) this).a(r17.readInt(), r17.readLong());
            r18.writeNoException();
            r18.writeInt(0);
            return true;
        L38:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            ((SqlDownloadCache) this).d(r17.readInt(), r17.readLong());
            r18.writeNoException();
            r18.writeInt(0);
            return true;
        L40:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            ((SqlDownloadCache) this).e(r17.readInt());
            r18.writeNoException();
            r18.writeInt(0);
            return true;
        L42:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            ((SqlDownloadCache) this).c(r17.readInt(), r17.readLong());
            r18.writeNoException();
            r18.writeInt(0);
            return true;
        L44:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            ((SqlDownloadCache) this).b(r17.readInt(), r17.readLong());
            r18.writeNoException();
            r18.writeInt(0);
            return true;
        L46:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            ((SqlDownloadCache) this).a(r17.readInt(), r17.readLong(), r17.readString(), r17.readString());
            r18.writeNoException();
            r18.writeInt(0);
            return true;
        L48:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            r17.readInt();
            r18.writeNoException();
            r18.writeInt(0);
            return true;
        L50:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadComponentManager.a(new SqlDownloadCache.AnonymousClass18((SqlDownloadCache) this));
            r18.writeNoException();
            return true;
        L52:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadComponentManager.a(new SqlDownloadCache.AnonymousClass17((SqlDownloadCache) this, r17.readInt()));
            r18.writeNoException();
            r18.writeInt(1);
            return true;
        L54:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadComponentManager.a(new SqlDownloadCache.AnonymousClass16((SqlDownloadCache) this, r17.readInt()));
            r18.writeNoException();
            r18.writeInt(1);
            return true;
        L56:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (r17.readInt() == 0) goto L59;
            r5 = DownloadInfo.CREATOR.createFromParcel(r17);
        L59:
            boolean r24 = ((SqlDownloadCache) this).a(r5);
            r18.writeNoException();
            r18.writeInt(r24 ? 1 : 0);
            return true;
        L61:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            r17.readString();
            r17.readString();
            r18.writeNoException();
            r18.writeTypedList(null);
            return true;
        L63:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List r25 = ((SqlDownloadCache) this).d();
            r18.writeNoException();
            r18.writeTypedList(r25);
            return true;
        L65:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List r26 = ((SqlDownloadCache) this).d(r17.readString());
            r18.writeNoException();
            r18.writeTypedList(r26);
            return true;
        L67:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List r27 = ((SqlDownloadCache) this).a(r17.readString());
            r18.writeNoException();
            r18.writeTypedList(r27);
            return true;
        L69:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List r28 = ((SqlDownloadCache) this).b(r17.readString());
            r18.writeNoException();
            r18.writeTypedList(r28);
            return true;
        L71:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            List r29 = ((SqlDownloadCache) this).c(r17.readString());
            r18.writeNoException();
            r18.writeTypedList(r29);
            return true;
        L73:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            DownloadInfo r30 = ((SqlDownloadCache) this).a(r17.readInt());
            r18.writeNoException();
            if (r30 == null) goto L76;
            r18.writeInt(1);
            r30.writeToParcel(r18, 1);
        L77:
            return true;
        L76:
            r18.writeInt(0);
            goto L77
        L78:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            int r31 = r17.readInt();
            if (((SqlDownloadCache) this).a(r31) == null) goto L84;
            r12 = 1;
        L84:
            r18.writeNoException();
            r18.writeInt(r12);
            return true;
        L82:
            th = move-exception;
            th.printStackTrace();
            Logger.a("SqlDownloadCache", r31, "cacheExist", "Error:" + th);
            goto L84
        L86:
            r17.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (r17.readInt() == 0) goto L89;
            r11 = true;
        L89:
            ((SqlDownloadCache) this).a(r11);
            r18.writeNoException();
            return true;
        L7:
            return super.onTransact(r16, r17, r18, r19);
        L91:
            r18.writeString("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            return true;
        }
    }

    DownloadInfo a(int r5);

    DownloadInfo a(int r5, long r10);

    DownloadInfo a(int r5, long r10, String r11, String r12);

    List a(String r5);

    List a(String r5, String r10);

    void a();

    void a(ISqlCacheLoadCompleteCallbackAidl r5);

    void a(boolean r5);

    boolean a(DownloadInfo r5);

    DownloadInfo b(int r5, long r10);

    List b(String r5);

    void b(DownloadInfo r5);

    boolean b(int r5);

    DownloadInfo c(int r5, long r10);

    List c(String r5);

    void c(int r5);

    boolean c();

    DownloadInfo d(int r5, long r10);

    List d();

    List d(String r5);

    boolean d(int r5);

    DownloadInfo e(int r5);

    boolean e();

    DownloadInfo h(int r5);

    DownloadInfo j(int r5);

    DownloadInfo k(int r5);
}
