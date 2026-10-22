package com.obric.cae.libs.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.obric.cae.libs.bluetooth.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0318a extends Binder implements a {

        /* JADX INFO: renamed from: com.obric.cae.libs.bluetooth.a$a$a, reason: collision with other inner class name */
        public static class C0319a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f6951a;

            public C0319a(IBinder r3) {
                this.f6951a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.cae.libs.bluetooth.a
            public void a(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f6951a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.a
            public void a(SmartBluetoothEvent r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback");     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f6951a.transact(1, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6951a;
            }
        }

        public AbstractBinderC0318a() {
            attachInterface(this, "com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback");
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0319a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback");
        L8:
            if (r4 == 1598968902) goto L18;
            if (r4 != 1) goto L11;
            a((SmartBluetoothEvent) ZeusTransformUtils.preCheckCast(b.a(r5, SmartBluetoothEvent.CREATOR), SmartBluetoothEvent.class, "com.obric.memorydata.plugin"));
        L16:
            r6.writeNoException();
            return true;
        L11:
            if (r4 != 2) goto L13;
            a(r5.readInt());
            goto L16
        L13:
            return super.onTransact(r4, r5, r6, r7);
        L18:
            r6.writeString("com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback");
            return true;
        }
    }

    public static class b {
        public static Object a(Parcel r2, Parcelable.Creator r3) {
            Parcelable.Creator r4 = (Parcelable.Creator) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.Creator.class, "com.obric.memorydata.plugin");
            if (r2.readInt() != 0) goto L7;
            return null;
        L7:
            return r4.createFromParcel(r2);
        }
    }

    void a(int r1);

    void a(SmartBluetoothEvent r1);
}
