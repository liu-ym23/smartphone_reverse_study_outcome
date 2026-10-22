package vendor.aware.sensorbridge;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes8.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: vendor.aware.sensorbridge.b$a$a, reason: collision with other inner class name */
        public static class C0910a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f20320a;

            public C0910a(IBinder r3) {
                this.f20320a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // vendor.aware.sensorbridge.b
            public int a(String r4, vendor.aware.sensorbridge.a r5) {
                vendor.aware.sensorbridge.a r6 = (vendor.aware.sensorbridge.a) ZeusTransformUtils.wrapperContextForParams(r5, vendor.aware.sensorbridge.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.aware.sensorbridge.ISensorBridgeService");     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                this.f20320a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r3 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // vendor.aware.sensorbridge.b
            public SensorBridgeSensor a(String r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.aware.sensorbridge.ISensorBridgeService");     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                this.f20320a.transact(3, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                Parcelable.Creator<SensorBridgeSensor> r3 = SensorBridgeSensor.CREATOR;     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L6;
                SensorBridgeSensor r5 = r3.createFromParcel(r1);     // Catch: Throwable -> L10
            L7:
                SensorBridgeSensor r6 = (SensorBridgeSensor) ZeusTransformUtils.preCheckCast(r5, SensorBridgeSensor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r5 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // vendor.aware.sensorbridge.b
            public void a(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.aware.sensorbridge.ISensorBridgeService");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f20320a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // vendor.aware.sensorbridge.b
            public void a(int r4, SensorBridgeRequest r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.aware.sensorbridge.ISensorBridgeService");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                C0911b.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.f20320a.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // vendor.aware.sensorbridge.b
            public void a(int r4, SensorBridgeSensor r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.aware.sensorbridge.ISensorBridgeService");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                C0911b.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.f20320a.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // vendor.aware.sensorbridge.b
            public void a(int r4, SensorBridgeSensor r5, int[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.aware.sensorbridge.ISensorBridgeService");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                C0911b.a(r0, r5, 0);     // Catch: Throwable -> L6
                r0.writeIntArray(r6);     // Catch: Throwable -> L6
                this.f20320a.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // vendor.aware.sensorbridge.b
            public void a(int r4, SensorBridgeSubscription r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.aware.sensorbridge.ISensorBridgeService");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                C0911b.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.f20320a.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f20320a;
            }
        }

        public static b a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("vendor.aware.sensorbridge.ISensorBridgeService");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0910a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("vendor.aware.sensorbridge.ISensorBridgeService");
        L8:
            if (r4 != 1598968902) goto L10;
            r6.writeString("vendor.aware.sensorbridge.ISensorBridgeService");
            return true;
        L10:
            switch(r4) {
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                default: goto L12;
            };
        L13:
            a(r5.readInt(), (SensorBridgeSensor) ZeusTransformUtils.preCheckCast(C0911b.a(r5, SensorBridgeSensor.CREATOR), SensorBridgeSensor.class, "com.obric.memorydata.plugin"));
        L19:
            r6.writeNoException();
        L21:
            return true;
        L14:
            a(r5.readInt(), (SensorBridgeRequest) ZeusTransformUtils.preCheckCast(C0911b.a(r5, SensorBridgeRequest.CREATOR), SensorBridgeRequest.class, "com.obric.memorydata.plugin"));
            goto L19
        L15:
            a(r5.readInt(), (SensorBridgeSensor) ZeusTransformUtils.preCheckCast(C0911b.a(r5, SensorBridgeSensor.CREATOR), SensorBridgeSensor.class, "com.obric.memorydata.plugin"), r5.createIntArray());
            goto L19
        L16:
            a(r5.readInt(), (SensorBridgeSubscription) ZeusTransformUtils.preCheckCast(C0911b.a(r5, SensorBridgeSubscription.CREATOR), SensorBridgeSubscription.class, "com.obric.memorydata.plugin"));
            goto L19
        L17:
            SensorBridgeSensor r3 = a(r5.readString());
            r6.writeNoException();
            C0911b.a(r6, r3, 1);
            goto L21
        L18:
            a(r5.readInt());
            goto L19
        L20:
            int r8 = a(r5.readString(), vendor.aware.sensorbridge.a.AbstractBinderC0908a.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r8);
            goto L21
        L12:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    /* JADX INFO: renamed from: vendor.aware.sensorbridge.b$b, reason: collision with other inner class name */
    public static class C0911b {
        public static Object a(Parcel r2, Parcelable.Creator r3) {
            Parcelable.Creator r4 = (Parcelable.Creator) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.Creator.class, "com.obric.memorydata.plugin");
            if (r2.readInt() != 0) goto L7;
            return null;
        L7:
            return r4.createFromParcel(r2);
        }

        public static void a(Parcel r2, Parcelable r3, int r4) {
            Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L5;
            r2.writeInt(1);
            r5.writeToParcel(r2, r4);
            return;
        L5:
            r2.writeInt(0);
        }
    }

    int a(String r1, vendor.aware.sensorbridge.a r2);

    SensorBridgeSensor a(String r1);

    void a(int r1);

    void a(int r1, SensorBridgeRequest r2);

    void a(int r1, SensorBridgeSensor r2);

    void a(int r1, SensorBridgeSensor r2, int[] r3);

    void a(int r1, SensorBridgeSubscription r2);
}
