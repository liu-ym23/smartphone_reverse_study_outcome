package com.ss.android.socialbase.downloader.db;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface ISqlCacheLoadCompleteCallbackAidl extends IInterface {

    public static abstract class Stub extends Binder implements ISqlCacheLoadCompleteCallbackAidl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15396a = 0;

        public static class Proxy implements ISqlCacheLoadCompleteCallbackAidl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15397a;

            public Proxy(IBinder r5) {
                this.f15397a = r5;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl
            public final void a(HashMap r5, Map r10, HashMap r11, boolean r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");     // Catch: Throwable -> L6
                r13.writeMap(r5);     // Catch: Throwable -> L6
                r13.writeMap(r10);     // Catch: Throwable -> L6
                r13.writeMap(r11);     // Catch: Throwable -> L6
                r13.writeInt(r12 ? 1 : 0);     // Catch: Throwable -> L6
                if (this.f15397a.transact(1, r13, r14, 0) == true) goto L8;
                int r15 = Stub.f15396a;     // Catch: Throwable -> L6
            L8:
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15397a;
            }
        }

        public Stub() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) {
            if (r5 != 1) goto L5;
            r10.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            ClassLoader r13 = getClass().getClassLoader();
            HashMap r14 = r10.readHashMap(r13);
            HashMap r15 = r10.readHashMap(r13);
            HashMap r16 = r10.readHashMap(r13);
            if (r10.readInt() == 0) goto L13;
            boolean r17 = true;
        L14:
            ((SqlDownloadCacheAidlWrapper.AnonymousClass4.AnonymousClass1) this).a(r14, r15, r16, r17);
            r11.writeNoException();
            return true;
        L13:
            r17 = false;
            goto L14
        L5:
            if (r5 != 1598968902) goto L7;
            r11.writeString("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            return true;
        L7:
            return super.onTransact(r5, r10, r11, r12);
        }
    }

    void a(HashMap r5, Map r10, HashMap r11, boolean r12);
}
