package com.ss.android.socialbase.downloader.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.c.b$a$a, reason: collision with other inner class name */
        private static class C0810a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static b f15287a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15288b;

            C0810a(IBinder r3) {
                this.f15288b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.c.b
            public void a(Map r6, Map r7, Map r8, boolean r9) {
                Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
                Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
                Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");     // Catch: Throwable -> L17
                r0.writeMap(r10);     // Catch: Throwable -> L17
                r0.writeMap(r11);     // Catch: Throwable -> L17
                r0.writeMap(r12);     // Catch: Throwable -> L17
                if (r9 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L17
                if (this.f15288b.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.a() == null) goto L14;
                a.a().a(r10, r11, r12, r9);     // Catch: Throwable -> L17
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f15288b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
        }

        public static b a() {
            return C0810a.f15287a;
        }

        public static b a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0810a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            ClassLoader r8 = getClass().getClassLoader();
            HashMap r9 = r5.readHashMap(r8);
            HashMap r1 = r5.readHashMap(r8);
            HashMap r10 = r5.readHashMap(r8);
            if (r5.readInt() == 0) goto L13;
            boolean r11 = true;
        L14:
            a(r9, r1, r10, r11);
            r6.writeNoException();
            return true;
        L13:
            r11 = false;
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(Map r1, Map r2, Map r3, boolean r4);
}
