package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface v extends IInterface {

    public static abstract class a extends Binder implements v {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.v$a$a, reason: collision with other inner class name */
        private static class C0824a implements v {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static v f15388a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15389b;

            C0824a(IBinder r3) {
                this.f15389b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.depend.v
            public boolean a(u r5) {
                u r6 = (u) ZeusTransformUtils.wrapperContextForParams(r5, u.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");     // Catch: Throwable -> L19
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L19
                boolean r3 = false;
                if (this.f15389b.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r3 = true;
            L17:
                r1.recycle();
                r0.recycle();
                return r3;
            L10:
                if (a.a() == null) goto L14;
                boolean r4 = a.a().a(r6);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                r2 = null;
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f15389b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static v a() {
            return C0824a.f15388a;
        }

        public static v a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, v.class) == false) goto L13;
            return (v) ZeusTransformUtils.preCheckCast(r0, v.class, "com.obric.memorydata.plugin");
        L13:
            return new C0824a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            boolean r3 = a(u.a.a(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    boolean a(u r1);
}
