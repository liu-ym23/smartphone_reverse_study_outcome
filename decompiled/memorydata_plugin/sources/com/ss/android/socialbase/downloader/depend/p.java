package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface p extends IInterface {

    public static abstract class a extends Binder implements p {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.p$a$a, reason: collision with other inner class name */
        private static class C0822a implements p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static p f15384a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15385b;

            C0822a(IBinder r3) {
                this.f15385b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.depend.p
            public boolean a(long r8, long r10, o r12) {
                o r5 = (o) ZeusTransformUtils.wrapperContextForParams(r12, o.class, "com.obric.memorydata.plugin");
                Parcel r13 = Parcel.obtain();
                Parcel r6 = Parcel.obtain();
                r13.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");     // Catch: Throwable -> L19
                r13.writeLong(r8);     // Catch: Throwable -> L19
                r13.writeLong(r10);     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                IBinder r0 = r5.asBinder();     // Catch: Throwable -> L19
            L7:
                r13.writeStrongBinder(r0);     // Catch: Throwable -> L19
                boolean r1 = false;
                if (this.f15385b.transact(1, r13, r6, 0) == false) goto L10;
            L14:
                r6.readException();     // Catch: Throwable -> L19
                if (r6.readInt() == 0) goto L17;
                r1 = true;
            L17:
                r6.recycle();
                r13.recycle();
                return r1;
            L10:
                if (a.a() == null) goto L14;
                boolean r7 = a.a().a(r8, r10, r5);     // Catch: Throwable -> L19
                r6.recycle();
                r13.recycle();
                return r7;
            L6:
                r0 = null;
            L19:
                th = move-exception;
                r6.recycle();
                r13.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f15385b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static p a() {
            return C0822a.f15384a;
        }

        public static p a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, p.class) == false) goto L13;
            return (p) ZeusTransformUtils.preCheckCast(r0, p.class, "com.obric.memorydata.plugin");
        L13:
            return new C0822a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r9, Parcel r10, int r11) {
            if (r8 != 1) goto L5;
            r9.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            boolean r7 = a(r9.readLong(), r9.readLong(), o.a.a(r9.readStrongBinder()));
            r10.writeNoException();
            r10.writeInt(r7 ? 1 : 0);
            return true;
        L5:
            if (r8 != 1598968902) goto L7;
            r10.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            return true;
        L7:
            return super.onTransact(r8, r9, r10, r11);
        }
    }

    boolean a(long r1, long r3, o r5);
}
