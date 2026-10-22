package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface u extends IInterface {

    public static abstract class a extends Binder implements u {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.u$a$a, reason: collision with other inner class name */
        private static class C0823a implements u {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static u f15386a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f15387b;

            C0823a(IBinder r3) {
                this.f15387b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.android.socialbase.downloader.depend.u
            public void a(List<String> r5) {
                List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");     // Catch: Throwable -> L13
                r0.writeStringList(r6);     // Catch: Throwable -> L13
                if (this.f15387b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.b() == null) goto L10;
                a.b().a(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.u
            public boolean a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.f15387b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (a.b() == null) goto L10;
                boolean r4 = a.b().a();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f15387b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
        }

        public static u a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, u.class) == false) goto L13;
            return (u) ZeusTransformUtils.preCheckCast(r0, u.class, "com.obric.memorydata.plugin");
        L13:
            return new C0823a(r4);
        }

        public static u b() {
            return C0823a.f15386a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            a(r5.createStringArrayList());
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            boolean r3 = a();
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(List<String> r1);

    boolean a();
}
