package com.obric.mcpclient.complextasksdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        /* JADX INFO: renamed from: com.obric.mcpclient.complextasksdk.d$a$a, reason: collision with other inner class name */
        private static class C0411a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static d f8287a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f8288b;

            C0411a(IBinder r3) {
                this.f8288b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.mcpclient.complextasksdk.d
            public void a(String r6, boolean r7, c r8) {
                c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r8, c.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.mcpclient.complextasksdk.IComplexTaskHandle");     // Catch: Throwable -> L21
                r0.writeString(r6);     // Catch: Throwable -> L21
                if (r7 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L21
                if (r9 == null) goto L10;
                IBinder r5 = r9.asBinder();     // Catch: Throwable -> L21
            L11:
                r0.writeStrongBinder(r5);     // Catch: Throwable -> L21
                if (this.f8288b.transact(1, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (a.a() == null) goto L18;
                a.a().a(r6, r7, r9);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r5 = null;
                goto L11
            L6:
                r4 = 0;
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8288b;
            }
        }

        public static d a() {
            return C0411a.f8287a;
        }

        public static d a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.mcpclient.complextasksdk.IComplexTaskHandle");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L13;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin");
        L13:
            return new C0411a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.mcpclient.complextasksdk.IComplexTaskHandle");
            String r8 = r5.readString();
            if (r5.readInt() == 0) goto L13;
            boolean r9 = true;
        L14:
            a(r8, r9, c.a.a(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L13:
            r9 = false;
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.obric.mcpclient.complextasksdk.IComplexTaskHandle");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(String r1, boolean r2, c r3);
}
