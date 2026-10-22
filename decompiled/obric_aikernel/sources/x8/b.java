package x8;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.download.base.DownloadInfo;
import com.obric.download.base.DownloadTask;
import com.obric.download.base.TaskOperateResult;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: x8.b$a$a, reason: collision with other inner class name */
        private static class C0319a implements b {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static b f13574g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f13575c;

            C0319a(IBinder r10) {
                this.f13575c = r10;
            }

            @Override // x8.b
            public void I1(String r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L17
                r12.writeString(r10);     // Catch: Throwable -> L17
                if (r11 == false) goto L6;
                int r14 = 1;
            L7:
                r12.writeInt(r14);     // Catch: Throwable -> L17
                if (this.f13575c.transact(20, r12, r13, 0) == false) goto L10;
            L14:
                r13.readException();     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().I1(r10, r11);     // Catch: Throwable -> L17
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

            @Override // x8.b
            public void Q1(String r10, String r11, String r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L13
                r13.writeString(r10);     // Catch: Throwable -> L13
                r13.writeString(r11);     // Catch: Throwable -> L13
                r13.writeString(r12);     // Catch: Throwable -> L13
                if (this.f13575c.transact(21, r13, r14, 0) == false) goto L6;
            L10:
                r14.readException();     // Catch: Throwable -> L13
                r14.recycle();
                r13.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().Q1(r10, r11, r12);     // Catch: Throwable -> L13
                r14.recycle();
                r13.recycle();
                return;
            L13:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // x8.b
            public TaskOperateResult X1(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L17
                r11.writeInt(r10);     // Catch: Throwable -> L17
                if (this.f13575c.transact(7, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L17
                if (r12.readInt() == 0) goto L14;
                TaskOperateResult r13 = TaskOperateResult.CREATOR.a(r12);     // Catch: Throwable -> L17
            L15:
                r12.recycle();
                r11.recycle();
                return r13;
            L14:
                r13 = null;
                goto L15
            L6:
                if (a.k1() == null) goto L10;
                TaskOperateResult r14 = a.k1().X1(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return r14;
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // x8.b
            public DownloadInfo a(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L17
                r11.writeInt(r10);     // Catch: Throwable -> L17
                if (this.f13575c.transact(15, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L17
                if (r12.readInt() == 0) goto L14;
                DownloadInfo r13 = DownloadInfo.CREATOR.a(r12);     // Catch: Throwable -> L17
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
                return this.f13575c;
            }

            @Override // x8.b
            public TaskOperateResult d2(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L17
                r11.writeInt(r10);     // Catch: Throwable -> L17
                if (this.f13575c.transact(6, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L17
                if (r12.readInt() == 0) goto L14;
                TaskOperateResult r13 = TaskOperateResult.CREATOR.a(r12);     // Catch: Throwable -> L17
            L15:
                r12.recycle();
                r11.recycle();
                return r13;
            L14:
                r13 = null;
                goto L15
            L6:
                if (a.k1() == null) goto L10;
                TaskOperateResult r14 = a.k1().d2(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return r14;
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // x8.b
            public TaskOperateResult f1(DownloadTask r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L21
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L21
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L21
            L8:
                if (this.f13575c.transact(2, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L21
                if (r12.readInt() == 0) goto L18;
                TaskOperateResult r13 = TaskOperateResult.CREATOR.a(r12);     // Catch: Throwable -> L21
            L19:
                r12.recycle();
                r11.recycle();
                return r13;
            L18:
                r13 = null;
                goto L19
            L10:
                if (a.k1() == null) goto L14;
                TaskOperateResult r14 = a.k1().f1(r10);     // Catch: Throwable -> L21
                r12.recycle();
                r11.recycle();
                return r14;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // x8.b
            public void h1(String r10, String r11, int r12, String r13) {
                Parcel r14 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r14.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L13
                r14.writeString(r10);     // Catch: Throwable -> L13
                r14.writeString(r11);     // Catch: Throwable -> L13
                r14.writeInt(r12);     // Catch: Throwable -> L13
                r14.writeString(r13);     // Catch: Throwable -> L13
                if (this.f13575c.transact(1, r14, r15, 0) == false) goto L6;
            L10:
                r15.readException();     // Catch: Throwable -> L13
                r15.recycle();
                r14.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().h1(r10, r11, r12, r13);     // Catch: Throwable -> L13
                r15.recycle();
                r14.recycle();
                return;
            L13:
                th = move-exception;
                r15.recycle();
                r14.recycle();
                throw th;
            }

            @Override // x8.b
            public TaskOperateResult j1(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L17
                r11.writeInt(r10);     // Catch: Throwable -> L17
                if (this.f13575c.transact(9, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L17
                if (r12.readInt() == 0) goto L14;
                TaskOperateResult r13 = TaskOperateResult.CREATOR.a(r12);     // Catch: Throwable -> L17
            L15:
                r12.recycle();
                r11.recycle();
                return r13;
            L14:
                r13 = null;
                goto L15
            L6:
                if (a.k1() == null) goto L10;
                TaskOperateResult r14 = a.k1().j1(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return r14;
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // x8.b
            public void l1(String r10, String r11, x8.a r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L17
                r13.writeString(r10);     // Catch: Throwable -> L17
                r13.writeString(r11);     // Catch: Throwable -> L17
                if (r12 == null) goto L6;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L17
            L7:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L17
                if (this.f13575c.transact(4, r13, r14, 0) == false) goto L10;
            L14:
                r14.readException();     // Catch: Throwable -> L17
                r14.recycle();
                r13.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().l1(r10, r11, r12);     // Catch: Throwable -> L17
                r14.recycle();
                r13.recycle();
                return;
            L6:
                r15 = null;
            L17:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // x8.b
            public void x1(String r10, String r11, d r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L17
                r13.writeString(r10);     // Catch: Throwable -> L17
                r13.writeString(r11);     // Catch: Throwable -> L17
                if (r12 == null) goto L6;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L17
            L7:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L17
                if (this.f13575c.transact(19, r13, r14, 0) == false) goto L10;
            L14:
                r14.readException();     // Catch: Throwable -> L17
                r14.recycle();
                r13.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().x1(r10, r11, r12);     // Catch: Throwable -> L17
                r14.recycle();
                r13.recycle();
                return;
            L6:
                r15 = null;
            L17:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }
        }

        public static b U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.obric.download.aidl.IDownloadService");
            if (r11 == null) goto L12;
            if ((r11 instanceof b) == false) goto L12;
            return (b) r11;
        L12:
            return new C0319a(r10);
        }

        public static b k1() {
            return C0319a.f13574g;
        }
    }

    void I1(String r10, boolean r11);

    void Q1(String r10, String r11, String r12);

    TaskOperateResult X1(int r10);

    DownloadInfo a(int r10);

    TaskOperateResult d2(int r10);

    TaskOperateResult f1(DownloadTask r10);

    void h1(String r10, String r11, int r12, String r13);

    TaskOperateResult j1(int r10);

    void l1(String r10, String r11, x8.a r12);

    void x1(String r10, String r11, d r12);
}
