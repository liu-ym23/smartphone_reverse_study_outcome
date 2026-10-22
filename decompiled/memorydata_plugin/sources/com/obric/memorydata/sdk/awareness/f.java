package com.obric.memorydata.sdk.awareness;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public interface f extends IInterface {

    public static abstract class a extends Binder implements f {

        /* JADX INFO: renamed from: com.obric.memorydata.sdk.awareness.f$a$a, reason: collision with other inner class name */
        private static class C0695a implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static f f12824a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f12825b;

            C0695a(IBinder r3) {
                this.f12825b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.memorydata.sdk.awareness.f
            public void a(String r5, String r6, long r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.memorydata.sdk.awareness.IFeatureDurationListener");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                r0.writeLong(r7);     // Catch: Throwable -> L13
                if (this.f12825b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.a() == null) goto L10;
                a.a().a(r5, r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12825b;
            }
        }

        public static f a() {
            return C0695a.f12824a;
        }

        public static f a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.memorydata.sdk.awareness.IFeatureDurationListener");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L13;
            return (f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.memorydata.plugin");
        L13:
            return new C0695a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.memorydata.sdk.awareness.IFeatureDurationListener");
            a(r5.readString(), r5.readString(), r5.readLong());
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.obric.memorydata.sdk.awareness.IFeatureDurationListener");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(String r1, String r2, long r3);
}
