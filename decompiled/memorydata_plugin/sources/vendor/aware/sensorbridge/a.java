package vendor.aware.sensorbridge;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes8.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: vendor.aware.sensorbridge.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0908a extends Binder implements a {
        static final int TRANSACTION_onSensorBridgeError = 2;
        static final int TRANSACTION_onSensorBridgeEvents = 1;

        /* JADX INFO: renamed from: vendor.aware.sensorbridge.a$a$a, reason: collision with other inner class name */
        public static class C0909a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f20319a;

            public C0909a(IBinder r3) {
                this.f20319a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f20319a;
            }

            @Override // vendor.aware.sensorbridge.a
            public void onSensorBridgeError(int r4, int r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.aware.sensorbridge.ISensorBridgeCallback");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                this.f20319a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // vendor.aware.sensorbridge.a
            public void onSensorBridgeEvents(SensorBridgeEvent[] r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("vendor.aware.sensorbridge.ISensorBridgeCallback");     // Catch: Throwable -> L6
                r0.writeTypedArray(r4, 0);     // Catch: Throwable -> L6
                this.f20319a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
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

        public AbstractBinderC0908a() {
            attachInterface(this, "vendor.aware.sensorbridge.ISensorBridgeCallback");
        }

        public static a asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("vendor.aware.sensorbridge.ISensorBridgeCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0909a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("vendor.aware.sensorbridge.ISensorBridgeCallback");
        L8:
            if (r4 == 1598968902) goto L18;
            if (r4 != 1) goto L11;
            onSensorBridgeEvents((SensorBridgeEvent[]) ZeusTransformUtils.preCheckCast(r5.createTypedArray(SensorBridgeEvent.CREATOR), SensorBridgeEvent[].class, "com.obric.memorydata.plugin"));
        L16:
            r6.writeNoException();
            return true;
        L11:
            if (r4 != 2) goto L13;
            onSensorBridgeError(r5.readInt(), r5.readInt(), r5.readString());
            goto L16
        L13:
            return super.onTransact(r4, r5, r6, r7);
        L18:
            r6.writeString("vendor.aware.sensorbridge.ISensorBridgeCallback");
            return true;
        }
    }

    void onSensorBridgeError(int r1, int r2, String r3);

    void onSensorBridgeEvents(SensorBridgeEvent[] r1);
}
