package com.obric.cae.libs.location.geofence;

import android.content.ComponentName;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {
        static final int TRANSACTION_addGeofence = 5;
        static final int TRANSACTION_deleteGeofence = 6;
        static final int TRANSACTION_deleteGeofenceById = 7;
        static final int TRANSACTION_findGeofenceById = 10;
        static final int TRANSACTION_findGeofenceByPoiId = 15;
        static final int TRANSACTION_getComponent = 3;
        static final int TRANSACTION_getVendorVersion = 1;
        static final int TRANSACTION_isStarGeofencesRecovered = 14;
        static final int TRANSACTION_listGeofences = 9;
        static final int TRANSACTION_registerComponent = 2;
        static final int TRANSACTION_registerGeofenceCallback = 12;
        static final int TRANSACTION_sendDebugEvent = 11;
        static final int TRANSACTION_unregisterComponent = 4;
        static final int TRANSACTION_unregisterGeofenceCallback = 13;
        static final int TRANSACTION_updateGeofence = 8;

        /* JADX INFO: renamed from: com.obric.cae.libs.location.geofence.b$a$a, reason: collision with other inner class name */
        public static class C0332a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f6972a;

            public C0332a(IBinder r3) {
                this.f6972a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.cae.libs.location.geofence.b
            public byte addGeofence(StarGeofence r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L6
                C0333b.a(r0, r4, 0);     // Catch: Throwable -> L6
                this.f6972a.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                byte r3 = r1.readByte();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6972a;
            }

            @Override // com.obric.cae.libs.location.geofence.b
            public byte deleteGeofence(StarGeofence r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L6
                C0333b.a(r0, r4, 0);     // Catch: Throwable -> L6
                this.f6972a.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                byte r3 = r1.readByte();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.b
            public byte deleteGeofenceById(String r4, String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.f6972a.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                byte r3 = r1.readByte();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.b
            public StarGeofence findGeofenceById(String r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                this.f6972a.transact(10, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                Parcelable.Creator<StarGeofence> r3 = StarGeofence.CREATOR;     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L6;
                StarGeofence r5 = r3.createFromParcel(r1);     // Catch: Throwable -> L10
            L7:
                StarGeofence r6 = (StarGeofence) ZeusTransformUtils.preCheckCast(r5, StarGeofence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            @Override // com.obric.cae.libs.location.geofence.b
            public StarGeofence findGeofenceByPoiId(String r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                this.f6972a.transact(15, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                Parcelable.Creator<StarGeofence> r3 = StarGeofence.CREATOR;     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L6;
                StarGeofence r5 = r3.createFromParcel(r1);     // Catch: Throwable -> L10
            L7:
                StarGeofence r6 = (StarGeofence) ZeusTransformUtils.preCheckCast(r5, StarGeofence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            @Override // com.obric.cae.libs.location.geofence.b
            public ComponentName getComponent(String r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                this.f6972a.transact(3, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                Parcelable.Creator r3 = ComponentName.CREATOR;     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L6;
                Object r5 = r3.createFromParcel(r1);     // Catch: Throwable -> L10
            L7:
                ComponentName r6 = (ComponentName) ZeusTransformUtils.preCheckCast(r5, ComponentName.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            @Override // com.obric.cae.libs.location.geofence.b
            public String getVendorVersion() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L6
                this.f6972a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r4 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.b
            public boolean isStarGeofencesRecovered() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L8
                boolean r3 = false;
                this.f6972a.transact(14, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.b
            public List<StarGeofence> listGeofences(String r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.f6972a.transact(9, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r3 = r1.createTypedArrayList(StarGeofence.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.b
            public byte registerComponent(ComponentName r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L6
                C0333b.a(r0, r4, 0);     // Catch: Throwable -> L6
                this.f6972a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                byte r3 = r1.readByte();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.b
            public void registerGeofenceCallback(String r4, com.obric.cae.libs.location.geofence.a r5) {
                com.obric.cae.libs.location.geofence.a r6 = (com.obric.cae.libs.location.geofence.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.cae.libs.location.geofence.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                this.f6972a.transact(12, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.geofence.b
            public void sendDebugEvent(Location r4, int r5, StarGeofence r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L8
                C0333b.a(r0, r4, 0);     // Catch: Throwable -> L8
                r0.writeInt(r5);     // Catch: Throwable -> L8
                C0333b.a(r0, r6, 0);     // Catch: Throwable -> L8
                this.f6972a.transact(11, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r6.readFromParcel(r1);     // Catch: Throwable -> L8
            L6:
                r1.recycle();
                r0.recycle();
                return;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.b
            public byte unregisterComponent(ComponentName r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L6
                C0333b.a(r0, r4, 0);     // Catch: Throwable -> L6
                this.f6972a.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                byte r3 = r1.readByte();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.b
            public void unregisterGeofenceCallback(String r4, com.obric.cae.libs.location.geofence.a r5) {
                com.obric.cae.libs.location.geofence.a r6 = (com.obric.cae.libs.location.geofence.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.cae.libs.location.geofence.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                this.f6972a.transact(13, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.geofence.b
            public byte updateGeofence(StarGeofence r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.geofence.IStarGeofenceManager");     // Catch: Throwable -> L8
                C0333b.a(r0, r5, 0);     // Catch: Throwable -> L8
                this.f6972a.transact(8, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                byte r4 = r1.readByte();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r5.readFromParcel(r1);     // Catch: Throwable -> L8
            L6:
                r1.recycle();
                r0.recycle();
                return r4;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.obric.cae.libs.location.geofence.IStarGeofenceManager");
        }

        public static b asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.cae.libs.location.geofence.IStarGeofenceManager");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0332a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("com.obric.cae.libs.location.geofence.IStarGeofenceManager");
        L8:
            if (r4 != 1598968902) goto L10;
            r6.writeString("com.obric.cae.libs.location.geofence.IStarGeofenceManager");
            return true;
        L10:
            switch(r4) {
                case 1: goto L30;
                case 2: goto L28;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L22;
                case 8: goto L21;
                case 9: goto L20;
                case 10: goto L19;
                case 11: goto L18;
                case 12: goto L16;
                case 13: goto L15;
                case 14: goto L14;
                case 15: goto L13;
                default: goto L12;
            };
        L13:
            Parcelable r3 = findGeofenceByPoiId(r5.readString());
        L27:
            r6.writeNoException();
            C0333b.a(r6, r3, 1);
        L31:
            return true;
        L14:
            boolean r8 = isStarGeofencesRecovered();
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            goto L31
        L15:
            unregisterGeofenceCallback(r5.readString(), com.obric.cae.libs.location.geofence.a.AbstractBinderC0330a.a(r5.readStrongBinder()));
        L17:
            r6.writeNoException();
            goto L31
        L16:
            registerGeofenceCallback(r5.readString(), com.obric.cae.libs.location.geofence.a.AbstractBinderC0330a.a(r5.readStrongBinder()));
            goto L17
        L18:
            Location r9 = (Location) ZeusTransformUtils.preCheckCast(C0333b.a(r5, Location.CREATOR), Location.class, "com.obric.memorydata.plugin");
            int r10 = r5.readInt();
            StarGeofence r11 = (StarGeofence) ZeusTransformUtils.preCheckCast(C0333b.a(r5, StarGeofence.CREATOR), StarGeofence.class, "com.obric.memorydata.plugin");
            sendDebugEvent(r9, r10, r11);
            r6.writeNoException();
            C0333b.a(r6, r11, 1);
            goto L31
        L19:
            r3 = findGeofenceById(r5.readString());
            goto L27
        L20:
            List<StarGeofence> r12 = listGeofences(r5.readString());
            r6.writeNoException();
            r6.writeTypedList(r12);
            goto L31
        L21:
            StarGeofence r13 = (StarGeofence) ZeusTransformUtils.preCheckCast(C0333b.a(r5, StarGeofence.CREATOR), StarGeofence.class, "com.obric.memorydata.plugin");
            byte r14 = updateGeofence(r13);
            r6.writeNoException();
            r6.writeByte(r14);
            C0333b.a(r6, r13, 1);
            goto L31
        L22:
            byte r15 = deleteGeofenceById(r5.readString(), r5.readString());
        L29:
            r6.writeNoException();
            r6.writeByte(r15);
            goto L31
        L23:
            r15 = deleteGeofence((StarGeofence) ZeusTransformUtils.preCheckCast(C0333b.a(r5, StarGeofence.CREATOR), StarGeofence.class, "com.obric.memorydata.plugin"));
            goto L29
        L24:
            r15 = addGeofence((StarGeofence) ZeusTransformUtils.preCheckCast(C0333b.a(r5, StarGeofence.CREATOR), StarGeofence.class, "com.obric.memorydata.plugin"));
            goto L29
        L25:
            r15 = unregisterComponent((ComponentName) ZeusTransformUtils.preCheckCast(C0333b.a(r5, ComponentName.CREATOR), ComponentName.class, "com.obric.memorydata.plugin"));
            goto L29
        L26:
            r3 = getComponent(r5.readString());
            goto L27
        L28:
            r15 = registerComponent((ComponentName) ZeusTransformUtils.preCheckCast(C0333b.a(r5, ComponentName.CREATOR), ComponentName.class, "com.obric.memorydata.plugin"));
            goto L29
        L30:
            String r16 = getVendorVersion();
            r6.writeNoException();
            r6.writeString(r16);
            goto L31
        L12:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.libs.location.geofence.b$b, reason: collision with other inner class name */
    public static class C0333b {
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

    byte addGeofence(StarGeofence r1);

    byte deleteGeofence(StarGeofence r1);

    byte deleteGeofenceById(String r1, String r2);

    StarGeofence findGeofenceById(String r1);

    StarGeofence findGeofenceByPoiId(String r1);

    ComponentName getComponent(String r1);

    String getVendorVersion();

    boolean isStarGeofencesRecovered();

    List<StarGeofence> listGeofences(String r1);

    byte registerComponent(ComponentName r1);

    void registerGeofenceCallback(String r1, com.obric.cae.libs.location.geofence.a r2);

    void sendDebugEvent(Location r1, int r2, StarGeofence r3);

    byte unregisterComponent(ComponentName r1);

    void unregisterGeofenceCallback(String r1, com.obric.cae.libs.location.geofence.a r2);

    byte updateGeofence(StarGeofence r1);
}
