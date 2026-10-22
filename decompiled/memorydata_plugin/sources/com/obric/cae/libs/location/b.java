package com.obric.cae.libs.location;

import android.location.Address;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.libs.location.poi.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.obric.cae.libs.location.b$a$a, reason: collision with other inner class name */
        public static class C0328a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f6960a;

            public C0328a(IBinder r3) {
                this.f6960a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.cae.libs.location.b
            public Location a(int r4, String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L10
                r0.writeInt(r4);     // Catch: Throwable -> L10
                r0.writeString(r5);     // Catch: Throwable -> L10
                this.f6960a.transact(13, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                Parcelable.Creator r3 = Location.CREATOR;     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L6;
                Object r6 = r3.createFromParcel(r1);     // Catch: Throwable -> L10
            L7:
                Location r7 = (Location) ZeusTransformUtils.preCheckCast(r6, Location.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                r6 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.b
            public Bundle a(double r7, double r9, double r11, double r13, byte r15, byte r16, Map r17, int r18) {
                Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.memorydata.plugin");
                Parcel r2 = Parcel.obtain();
                Parcel r3 = Parcel.obtain();
                r2.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L10
                r2.writeDouble(r7);     // Catch: Throwable -> L10
                r2.writeDouble(r9);     // Catch: Throwable -> L10
                r2.writeDouble(r11);     // Catch: Throwable -> L10
                r2.writeDouble(r13);     // Catch: Throwable -> L10
                r2.writeByte(r15);     // Catch: Throwable -> L10
                r2.writeByte(r16);     // Catch: Throwable -> L10
                r2.writeMap(r0);     // Catch: Throwable -> L10
                r2.writeInt(r18);     // Catch: Throwable -> L10
                this.f6960a.transact(9, r2, r3, 0);     // Catch: Throwable -> L10
                r3.readException();     // Catch: Throwable -> L10
                Parcelable.Creator r1 = Bundle.CREATOR;     // Catch: Throwable -> L10
                if (r3.readInt() == 0) goto L6;
                Object r4 = r1.createFromParcel(r3);     // Catch: Throwable -> L10
            L7:
                Bundle r5 = (Bundle) ZeusTransformUtils.preCheckCast(r4, Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                r3.recycle();
                r2.recycle();
                return r5;
            L6:
                r4 = null;
            L10:
                th = move-exception;
                r3.recycle();
                r2.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.b
            public Bundle a(double r5, double r7, String r9, byte r10, byte r11, Map r12, int r13) {
                Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L10
                r0.writeDouble(r5);     // Catch: Throwable -> L10
                r0.writeDouble(r7);     // Catch: Throwable -> L10
                r0.writeString(r9);     // Catch: Throwable -> L10
                r0.writeByte(r10);     // Catch: Throwable -> L10
                r0.writeByte(r11);     // Catch: Throwable -> L10
                r0.writeMap(r14);     // Catch: Throwable -> L10
                r0.writeInt(r13);     // Catch: Throwable -> L10
                this.f6960a.transact(10, r0, r2, 0);     // Catch: Throwable -> L10
                r2.readException();     // Catch: Throwable -> L10
                Parcelable.Creator r4 = Bundle.CREATOR;     // Catch: Throwable -> L10
                if (r2.readInt() == 0) goto L6;
                Object r6 = r4.createFromParcel(r2);     // Catch: Throwable -> L10
            L7:
                Bundle r8 = (Bundle) ZeusTransformUtils.preCheckCast(r6, Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                r2.recycle();
                r0.recycle();
                return r8;
            L6:
                r6 = null;
            L10:
                th = move-exception;
                r2.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.b
            public String a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L6
                this.f6960a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.b
            public String a(String r4, int r5, int r6, String r7, String r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeString(r7);     // Catch: Throwable -> L6
                r0.writeString(r8);     // Catch: Throwable -> L6
                this.f6960a.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r3 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.b
            public void a(int r4, com.obric.cae.libs.location.a r5) {
                com.obric.cae.libs.location.a r6 = (com.obric.cae.libs.location.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.cae.libs.location.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                this.f6960a.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.b
            public void a(long r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L6
                r0.writeLong(r4);     // Catch: Throwable -> L6
                this.f6960a.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
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
                return this.f6960a;
            }

            @Override // com.obric.cae.libs.location.b
            public com.obric.cae.libs.location.geofence.b b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L6
                this.f6960a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                com.obric.cae.libs.location.geofence.b r4 = com.obric.cae.libs.location.geofence.b.a.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.b
            public Location c() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L10
                this.f6960a.transact(3, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                Parcelable.Creator r4 = Location.CREATOR;     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L6;
                Object r5 = r4.createFromParcel(r1);     // Catch: Throwable -> L10
            L7:
                Location r6 = (Location) ZeusTransformUtils.preCheckCast(r5, Location.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            @Override // com.obric.cae.libs.location.b
            public Location d() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L10
                this.f6960a.transact(4, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                Parcelable.Creator r4 = Location.CREATOR;     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L6;
                Object r5 = r4.createFromParcel(r1);     // Catch: Throwable -> L10
            L7:
                Location r6 = (Location) ZeusTransformUtils.preCheckCast(r5, Location.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            @Override // com.obric.cae.libs.location.b
            public void e() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L6
                this.f6960a.transact(8, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.b
            public com.obric.cae.libs.location.poi.b f() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L6
                this.f6960a.transact(11, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                com.obric.cae.libs.location.poi.b r4 = com.obric.cae.libs.location.poi.b.a.a(r1.readStrongBinder());     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.b
            public Address g() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L10
                this.f6960a.transact(12, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                Parcelable.Creator r4 = Address.CREATOR;     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L6;
                Object r5 = r4.createFromParcel(r1);     // Catch: Throwable -> L10
            L7:
                Address r6 = (Address) ZeusTransformUtils.preCheckCast(r5, Address.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            @Override // com.obric.cae.libs.location.b
            public String h() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L6
                this.f6960a.transact(14, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.b
            public d i() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L6
                this.f6960a.transact(15, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                d r4 = d.a.a(r1.readStrongBinder());     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.b
            public com.obric.cae.libs.location.indoor.b j() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.IStarLocationService");     // Catch: Throwable -> L6
                this.f6960a.transact(16, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                com.obric.cae.libs.location.indoor.b r4 = com.obric.cae.libs.location.indoor.b.a.a(r1.readStrongBinder());     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.obric.cae.libs.location.IStarLocationService");
        }

        public static b a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.cae.libs.location.IStarLocationService");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0328a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r18, Parcel r19, Parcel r20, int r21) {
            if (r18 < 1) goto L8;
            if (r18 > 16777215) goto L8;
            r19.enforceInterface("com.obric.cae.libs.location.IStarLocationService");
        L8:
            if (r18 == 1598968902) goto L33;
            switch(r18) {
                case 1: goto L30;
                case 2: goto L28;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L18;
                case 11: goto L17;
                case 12: goto L16;
                case 13: goto L15;
                case 14: goto L14;
                case 15: goto L13;
                case 16: goto L12;
                default: goto L11;
            };
        L12:
            IInterface r0 = j();
        L29:
            r20.writeNoException();
            r20.writeStrongInterface(r0);
        L32:
            return true;
        L13:
            r0 = i();
            goto L29
        L14:
            String r1 = h();
        L31:
            r20.writeNoException();
            r20.writeString(r1);
            goto L32
        L15:
            Parcelable r2 = a(r19.readInt(), r19.readString());
        L27:
            r20.writeNoException();
            C0329b.a(r20, r2);
            goto L32
        L16:
            r2 = g();
            goto L27
        L17:
            r0 = f();
            goto L29
        L18:
            r2 = a(r19.readDouble(), r19.readDouble(), r19.readString(), r19.readByte(), r19.readByte(), r19.readHashMap(getClass().getClassLoader()), r19.readInt());
            goto L27
        L19:
            r2 = a(r19.readDouble(), r19.readDouble(), r19.readDouble(), r19.readDouble(), r19.readByte(), r19.readByte(), r19.readHashMap(getClass().getClassLoader()), r19.readInt());
            goto L27
        L20:
            e();
        L23:
            r20.writeNoException();
            goto L32
        L21:
            a(r19.readInt(), com.obric.cae.libs.location.a.AbstractBinderC0326a.a(r19.readStrongBinder()));
            goto L23
        L22:
            a(r19.readLong());
            goto L23
        L24:
            r1 = a(r19.readString(), r19.readInt(), r19.readInt(), r19.readString(), r19.readString());
            goto L31
        L25:
            r2 = d();
            goto L27
        L26:
            r2 = c();
            goto L27
        L28:
            r0 = b();
            goto L29
        L30:
            r1 = a();
            goto L31
        L11:
            return super.onTransact(r18, r19, r20, r21);
        L33:
            r20.writeString("com.obric.cae.libs.location.IStarLocationService");
            return true;
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.libs.location.b$b, reason: collision with other inner class name */
    public static class C0329b {
        public static void a(Parcel r2, Parcelable r3) {
            Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L5;
            r2.writeInt(1);
            r4.writeToParcel(r2, 1);
            return;
        L5:
            r2.writeInt(0);
        }
    }

    Location a(int r1, String r2);

    Bundle a(double r1, double r3, double r5, double r7, byte r9, byte r10, Map r11, int r12);

    Bundle a(double r1, double r3, String r5, byte r6, byte r7, Map r8, int r9);

    String a();

    String a(String r1, int r2, int r3, String r4, String r5);

    void a(int r1, com.obric.cae.libs.location.a r2);

    @Deprecated
    void a(long r1);

    com.obric.cae.libs.location.geofence.b b();

    Location c();

    Location d();

    void e();

    com.obric.cae.libs.location.poi.b f();

    Address g();

    String h();

    d i();

    com.obric.cae.libs.location.indoor.b j();
}
