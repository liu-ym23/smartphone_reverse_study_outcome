package com.tencent.wcdb;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface k extends IInterface {

    public static abstract class a extends Binder implements k {

        /* JADX INFO: renamed from: com.tencent.wcdb.k$a$a, reason: collision with other inner class name */
        private static class C0845a implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f15874a;

            C0845a(IBinder r3) {
                this.f15874a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.tencent.wcdb.k
            public void a(boolean r4, Uri r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.tencent.wcdb.IContentObserver");     // Catch: Throwable -> L14
                if (r4 == false) goto L6;
                int r6 = 1;
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L14
                if (r5 == null) goto L10;
                r0.writeInt(1);     // Catch: Throwable -> L14
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L14
            L11:
                this.f15874a.transact(1, r0, null, 1);     // Catch: Throwable -> L14
                r0.recycle();
                return;
            L10:
                r0.writeInt(0);     // Catch: Throwable -> L14
                goto L11
            L6:
                r6 = 0;
            L14:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f15874a;
            }
        }

        public static k a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.tencent.wcdb.IContentObserver");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, k.class) == false) goto L13;
            return (k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.memorydata.plugin");
        L13:
            return new C0845a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.tencent.wcdb.IContentObserver");
            if (r5.readInt() == 0) goto L13;
            boolean r8 = true;
        L15:
            if (r5.readInt() == 0) goto L17;
            Uri r9 = (Uri) ZeusTransformUtils.preCheckCast(Uri.CREATOR.createFromParcel(r5), Uri.class, "com.obric.memorydata.plugin");
        L18:
            a(r8, r9);
            return true;
        L17:
            r9 = null;
            goto L18
        L13:
            r8 = false;
            goto L15
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.tencent.wcdb.IContentObserver");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(boolean r1, Uri r2);
}
