package com.obric.memorydata.sdk.awareness;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public interface e extends IInterface {

    public static abstract class a extends Binder implements e {

        /* JADX INFO: renamed from: com.obric.memorydata.sdk.awareness.e$a$a, reason: collision with other inner class name */
        private static class C0694a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static e f12822a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f12823b;

            C0694a(IBinder r3) {
                this.f12823b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.memorydata.sdk.awareness.e
            public void a(Bundle r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.memorydata.sdk.awareness.IFeatureChangeListener");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f12823b.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.a() == null) goto L14;
                a.a().a(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12823b;
            }
        }

        public static e a() {
            return C0694a.f12822a;
        }

        public static e a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.memorydata.sdk.awareness.IFeatureChangeListener");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, e.class) == false) goto L13;
            return (e) ZeusTransformUtils.preCheckCast(r0, e.class, "com.obric.memorydata.plugin");
        L13:
            return new C0694a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.memorydata.sdk.awareness.IFeatureChangeListener");
            if (r5.readInt() == 0) goto L13;
            Bundle r8 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r5), Bundle.class, "com.obric.memorydata.plugin");
        L14:
            a(r8);
            r6.writeNoException();
            return true;
        L13:
            r8 = null;
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.obric.memorydata.sdk.awareness.IFeatureChangeListener");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(Bundle r1);
}
