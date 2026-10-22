package com.e.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.e.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0177a extends Binder implements a {

        /* JADX INFO: renamed from: com.e.a.a$a$a, reason: collision with other inner class name */
        private static class C0178a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f3718a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3719b;

            C0178a(IBinder r3) {
                this.f3719b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.e.a.a
            public String a(String r5, String r6, String r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.heytap.openid.IOpenID");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                r0.writeString(r7);     // Catch: Throwable -> L13
                if (this.f3719b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0177a.a() == null) goto L10;
                String r8 = AbstractBinderC0177a.a().a(r5, r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3719b;
            }
        }

        public static a a() {
            return C0178a.f3718a;
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.heytap.openid.IOpenID");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0178a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.heytap.openid.IOpenID");
            String r3 = a(r5.readString(), r5.readString(), r5.readString());
            r6.writeNoException();
            r6.writeString(r3);
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.heytap.openid.IOpenID");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    String a(String r1, String r2, String r3);
}
