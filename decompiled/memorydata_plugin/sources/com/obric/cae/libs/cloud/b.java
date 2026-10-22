package com.obric.cae.libs.cloud;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {
        static final int TRANSACTION_onCloudDataChange = 1;
        static final int TRANSACTION_onPostStateChange = 2;

        /* JADX INFO: renamed from: com.obric.cae.libs.cloud.b$a$a, reason: collision with other inner class name */
        public static class C0325a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f6955a;

            public C0325a(IBinder r3) {
                this.f6955a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6955a;
            }

            @Override // com.obric.cae.libs.cloud.b
            public void onCloudDataChange(String r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.cloud.ICloudEventCallback");     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.f6955a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cloud.b
            public void onPostStateChange(int r4, String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.cloud.ICloudEventCallback");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                this.f6955a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.obric.cae.libs.cloud.ICloudEventCallback");
        }

        public static b asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.cae.libs.cloud.ICloudEventCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0325a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("com.obric.cae.libs.cloud.ICloudEventCallback");
        L8:
            if (r4 == 1598968902) goto L18;
            if (r4 != 1) goto L11;
            onCloudDataChange(r5.readString());
        L16:
            r6.writeNoException();
            return true;
        L11:
            if (r4 != 2) goto L13;
            onPostStateChange(r5.readInt(), r5.readString(), r5.readString());
            goto L16
        L13:
            return super.onTransact(r4, r5, r6, r7);
        L18:
            r6.writeString("com.obric.cae.libs.cloud.ICloudEventCallback");
            return true;
        }
    }

    void onCloudDataChange(String r1);

    void onPostStateChange(int r1, String r2, String r3);
}
