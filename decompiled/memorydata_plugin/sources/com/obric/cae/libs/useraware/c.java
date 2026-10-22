package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {
        static final int TRANSACTION_addBssidsToAvoidRomingScan = 7;
        static final int TRANSACTION_addHomeWifiBssids = 3;
        static final int TRANSACTION_clearHomeWifiBssids = 4;
        static final int TRANSACTION_getHarMonitorParams = 13;
        static final int TRANSACTION_notifyGeofenceChanged = 6;
        static final int TRANSACTION_notifyHarEvent = 14;
        static final int TRANSACTION_notifyLearningSuccess = 16;
        static final int TRANSACTION_notifyRoomChangedPredicted = 5;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_registerSmartBluetoothEvent = 10;
        static final int TRANSACTION_setHarMonitorParams = 12;
        static final int TRANSACTION_setHarState = 8;
        static final int TRANSACTION_setLevel2DataCollection = 9;
        static final int TRANSACTION_setWifiRssiTriggerThresholds = 15;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_unregisterSmartBluetoothEvent = 11;

        /* JADX INFO: renamed from: com.obric.cae.libs.useraware.c$a$a, reason: collision with other inner class name */
        public static class C0347a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f7011a;

            public C0347a(IBinder r3) {
                this.f7011a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.cae.libs.useraware.c
            public void addBssidsToAvoidRomingScan(List<String> r4) {
                List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                r0.writeStringList(r5);     // Catch: Throwable -> L6
                this.f7011a.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.useraware.c
            public void addHomeWifiBssids(List<String> r4) {
                List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                r0.writeStringList(r5);     // Catch: Throwable -> L6
                this.f7011a.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
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
                return this.f7011a;
            }

            @Override // com.obric.cae.libs.useraware.c
            public void clearHomeWifiBssids() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                this.f7011a.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.useraware.c
            public HarMonitorParams getHarMonitorParams() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L10
                this.f7011a.transact(13, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                Parcelable.Creator<HarMonitorParams> r4 = HarMonitorParams.CREATOR;     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L6;
                HarMonitorParams r5 = r4.createFromParcel(r1);     // Catch: Throwable -> L10
            L7:
                HarMonitorParams r6 = (HarMonitorParams) ZeusTransformUtils.preCheckCast(r5, HarMonitorParams.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            @Override // com.obric.cae.libs.useraware.c
            public void notifyGeofenceChanged(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f7011a.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.useraware.c
            public void notifyHarEvent(HarEventData r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                b.a(r0, r4, 0);     // Catch: Throwable -> L6
                this.f7011a.transact(14, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.useraware.c
            public void notifyLearningSuccess(boolean r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                r0.writeInt(r4 ? 1 : 0);     // Catch: Throwable -> L6
                this.f7011a.transact(16, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.useraware.c
            public void notifyRoomChangedPredicted(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f7011a.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.useraware.c
            public void registerCallback(d r4) {
                d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.f7011a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.useraware.c
            public void registerSmartBluetoothEvent(com.obric.cae.libs.bluetooth.a r4) {
                com.obric.cae.libs.bluetooth.a r5 = (com.obric.cae.libs.bluetooth.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.cae.libs.bluetooth.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.f7011a.transact(10, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.useraware.c
            public void setHarMonitorParams(HarMonitorParams r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                b.a(r0, r4, 0);     // Catch: Throwable -> L6
                this.f7011a.transact(12, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.useraware.c
            public void setHarState(int r4, long r5, int r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeLong(r5);     // Catch: Throwable -> L6
                r0.writeInt(r7);     // Catch: Throwable -> L6
                this.f7011a.transact(8, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.useraware.c
            public void setLevel2DataCollection(List<HarLevel2DataReq> r4, int r5, com.obric.cae.libs.useraware.a r6) {
                List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
                com.obric.cae.libs.useraware.a r8 = (com.obric.cae.libs.useraware.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.cae.libs.useraware.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                r0.writeTypedList(r7);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r8);     // Catch: Throwable -> L6
                this.f7011a.transact(9, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.useraware.c
            public void setWifiRssiTriggerThresholds(int r4, int r5, int r6, int r7, int r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeInt(r7);     // Catch: Throwable -> L6
                r0.writeInt(r8);     // Catch: Throwable -> L6
                this.f7011a.transact(15, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.useraware.c
            public void unregisterCallback(d r4) {
                d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.f7011a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.useraware.c
            public void unregisterSmartBluetoothEvent(com.obric.cae.libs.bluetooth.a r4) {
                com.obric.cae.libs.bluetooth.a r5 = (com.obric.cae.libs.bluetooth.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.cae.libs.bluetooth.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAware");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.f7011a.transact(11, r0, r1, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, "com.obric.cae.libs.useraware.ICaeUserAware");
        }

        public static c asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.cae.libs.useraware.ICaeUserAware");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L13;
            return (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
        L13:
            return new C0347a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r9, Parcel r10, int r11) {
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r9.enforceInterface("com.obric.cae.libs.useraware.ICaeUserAware");
        L8:
            if (r8 != 1598968902) goto L10;
            r10.writeString("com.obric.cae.libs.useraware.ICaeUserAware");
            return true;
        L10:
            switch(r8) {
                case 1: goto L32;
                case 2: goto L31;
                case 3: goto L30;
                case 4: goto L29;
                case 5: goto L28;
                case 6: goto L27;
                case 7: goto L26;
                case 8: goto L25;
                case 9: goto L24;
                case 10: goto L23;
                case 11: goto L22;
                case 12: goto L21;
                case 13: goto L20;
                case 14: goto L19;
                case 15: goto L18;
                case 16: goto L14;
                default: goto L12;
            };
        L18:
            setWifiRssiTriggerThresholds(r9.readInt(), r9.readInt(), r9.readInt(), r9.readInt(), r9.readInt());
        L33:
            r10.writeNoException();
        L34:
            return true;
        L19:
            notifyHarEvent((HarEventData) ZeusTransformUtils.preCheckCast(b.a(r9, HarEventData.CREATOR), HarEventData.class, "com.obric.memorydata.plugin"));
            goto L33
        L20:
            HarMonitorParams r7 = getHarMonitorParams();
            r10.writeNoException();
            b.a(r10, r7, 1);
            goto L34
        L21:
            setHarMonitorParams((HarMonitorParams) ZeusTransformUtils.preCheckCast(b.a(r9, HarMonitorParams.CREATOR), HarMonitorParams.class, "com.obric.memorydata.plugin"));
            goto L33
        L22:
            unregisterSmartBluetoothEvent(com.obric.cae.libs.bluetooth.a.AbstractBinderC0318a.a(r9.readStrongBinder()));
            goto L33
        L23:
            registerSmartBluetoothEvent(com.obric.cae.libs.bluetooth.a.AbstractBinderC0318a.a(r9.readStrongBinder()));
            goto L33
        L24:
            setLevel2DataCollection(r9.createTypedArrayList(HarLevel2DataReq.CREATOR), r9.readInt(), com.obric.cae.libs.useraware.a.AbstractBinderC0345a.a(r9.readStrongBinder()));
            goto L33
        L25:
            setHarState(r9.readInt(), r9.readLong(), r9.readInt());
            goto L33
        L26:
            addBssidsToAvoidRomingScan(r9.createStringArrayList());
            goto L33
        L27:
            notifyGeofenceChanged(r9.readInt());
            goto L33
        L28:
            notifyRoomChangedPredicted(r9.readInt());
            goto L33
        L29:
            clearHomeWifiBssids();
            goto L33
        L30:
            addHomeWifiBssids(r9.createStringArrayList());
            goto L33
        L31:
            unregisterCallback(d.a.a(r9.readStrongBinder()));
            goto L33
        L32:
            registerCallback(d.a.a(r9.readStrongBinder()));
            goto L33
        L12:
            return super.onTransact(r8, r9, r10, r11);
        L14:
            if (r9.readInt() == 0) goto L16;
            boolean r12 = true;
        L17:
            notifyLearningSuccess(r12);
            goto L33
        L16:
            r12 = false;
            goto L17
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

    void addBssidsToAvoidRomingScan(List<String> r1);

    void addHomeWifiBssids(List<String> r1);

    void clearHomeWifiBssids();

    HarMonitorParams getHarMonitorParams();

    void notifyGeofenceChanged(int r1);

    void notifyHarEvent(HarEventData r1);

    void notifyLearningSuccess(boolean r1);

    void notifyRoomChangedPredicted(int r1);

    void registerCallback(d r1);

    void registerSmartBluetoothEvent(com.obric.cae.libs.bluetooth.a r1);

    void setHarMonitorParams(HarMonitorParams r1);

    void setHarState(int r1, long r2, int r4);

    void setLevel2DataCollection(List<HarLevel2DataReq> r1, int r2, com.obric.cae.libs.useraware.a r3);

    void setWifiRssiTriggerThresholds(int r1, int r2, int r3, int r4, int r5);

    void unregisterCallback(d r1);

    void unregisterSmartBluetoothEvent(com.obric.cae.libs.bluetooth.a r1);
}
