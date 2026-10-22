package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        /* JADX INFO: renamed from: com.obric.cae.libs.useraware.d$a$a, reason: collision with other inner class name */
        public static class C0348a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f7012a;

            public C0348a(IBinder r3) {
                this.f7012a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.cae.libs.useraware.d
            public void a(int r3, String r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAwareCallback");     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.f7012a.transact(7, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.d
            public void a(CellAwareInfo r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAwareCallback");     // Catch: Throwable -> L10
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f7012a.transact(4, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.d
            public void a(WifiStandardData r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAwareCallback");     // Catch: Throwable -> L10
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f7012a.transact(2, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.d
            public void a(String r3, String r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAwareCallback");     // Catch: Throwable -> L6
                r0.writeString(r3);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.f7012a.transact(6, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.d
            public void a(List<WifiStandardData> r3) {
                List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAwareCallback");     // Catch: Throwable -> L6
                r0.writeTypedList(r4);     // Catch: Throwable -> L6
                this.f7012a.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.d
            public void a(boolean r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAwareCallback");     // Catch: Throwable -> L6
                r0.writeInt(r4 ? 1 : 0);     // Catch: Throwable -> L6
                this.f7012a.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7012a;
            }

            @Override // com.obric.cae.libs.useraware.d
            public void b(List<CellAwareInfo> r4) {
                List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.useraware.ICaeUserAwareCallback");     // Catch: Throwable -> L6
                r0.writeTypedList(r5);     // Catch: Throwable -> L6
                this.f7012a.transact(5, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.obric.cae.libs.useraware.ICaeUserAwareCallback");
        }

        public static d a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.cae.libs.useraware.ICaeUserAwareCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L13;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin");
        L13:
            return new C0348a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("com.obric.cae.libs.useraware.ICaeUserAwareCallback");
        L8:
            if (r4 != 1598968902) goto L10;
            r6.writeString("com.obric.cae.libs.useraware.ICaeUserAwareCallback");
            return true;
        L10:
            switch(r4) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L18;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                default: goto L12;
            };
        L13:
            a(r5.readInt(), r5.readString());
        L24:
            return true;
        L14:
            a(r5.readString(), r5.readString());
            goto L24
        L15:
            b(r5.createTypedArrayList(CellAwareInfo.CREATOR));
            goto L24
        L16:
            a((CellAwareInfo) ZeusTransformUtils.preCheckCast(b.a(r5, CellAwareInfo.CREATOR), CellAwareInfo.class, "com.obric.memorydata.plugin"));
            goto L24
        L22:
            a((WifiStandardData) ZeusTransformUtils.preCheckCast(b.a(r5, WifiStandardData.CREATOR), WifiStandardData.class, "com.obric.memorydata.plugin"));
            goto L24
        L23:
            a(r5.createTypedArrayList(WifiStandardData.CREATOR));
            goto L24
        L12:
            return super.onTransact(r4, r5, r6, r7);
        L18:
            if (r5.readInt() == 0) goto L20;
            boolean r8 = true;
        L21:
            a(r8);
            goto L24
        L20:
            r8 = false;
            goto L21
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

    void a(int r1, String r2);

    void a(CellAwareInfo r1);

    void a(WifiStandardData r1);

    void a(String r1, String r2);

    void a(List<WifiStandardData> r1);

    void a(boolean r1);

    void b(List<CellAwareInfo> r1);
}
