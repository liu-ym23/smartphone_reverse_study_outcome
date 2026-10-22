package com.obric.memorydata.sdk.memory;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.obric.memorydata.sdk.memory.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0696a extends Binder implements a {

        /* JADX INFO: renamed from: com.obric.memorydata.sdk.memory.a$a$a, reason: collision with other inner class name */
        private static class C0697a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f12837a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f12838b;

            C0697a(IBinder r3) {
                this.f12838b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.memorydata.sdk.memory.a
            public void a(boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.memorydata.sdk.memory.IMemoryCallback");     // Catch: Throwable -> L17
                if (r6 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L17
                if (this.f12838b.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (AbstractBinderC0696a.a() == null) goto L14;
                AbstractBinderC0696a.a().a(r6);     // Catch: Throwable -> L17
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
                return this.f12838b;
            }
        }

        public static a a() {
            return C0697a.f12837a;
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.memorydata.sdk.memory.IMemoryCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0697a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.memorydata.sdk.memory.IMemoryCallback");
            if (r5.readInt() == 0) goto L13;
            boolean r8 = true;
        L14:
            a(r8);
            r6.writeNoException();
            return true;
        L13:
            r8 = false;
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.obric.memorydata.sdk.memory.IMemoryCallback");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(boolean r1);
}
