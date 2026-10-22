package com.obric.cae.libs.location.poi;

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

        /* JADX INFO: renamed from: com.obric.cae.libs.location.poi.b$a$a, reason: collision with other inner class name */
        public static class C0339a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f6988a;

            public C0339a(IBinder r3) {
                this.f6988a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.cae.libs.location.poi.b
            public AoiBoard a(String r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarAoiBoardManager");     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                this.f6988a.transact(5, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                Parcelable.Creator<AoiBoard> r3 = AoiBoard.CREATOR;     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L6;
                AoiBoard r5 = r3.createFromParcel(r1);     // Catch: Throwable -> L10
            L7:
                AoiBoard r6 = (AoiBoard) ZeusTransformUtils.preCheckCast(r5, AoiBoard.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            @Override // com.obric.cae.libs.location.poi.b
            public List<AoiBoard> a(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarAoiBoardManager");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f6988a.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r3 = r1.createTypedArrayList(AoiBoard.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.b
            public void a() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarAoiBoardManager");     // Catch: Throwable -> L6
                this.f6988a.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.b
            public void a(com.obric.cae.libs.location.poi.a r3) {
                com.obric.cae.libs.location.poi.a r4 = (com.obric.cae.libs.location.poi.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.location.poi.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarAoiBoardManager");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.f6988a.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.b
            public void a(com.obric.cae.libs.location.poi.a r3, int r4) {
                com.obric.cae.libs.location.poi.a r5 = (com.obric.cae.libs.location.poi.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.location.poi.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarAoiBoardManager");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f6988a.transact(7, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6988a;
            }

            @Override // com.obric.cae.libs.location.poi.b
            public List<AoiBoard> b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarAoiBoardManager");     // Catch: Throwable -> L6
                this.f6988a.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r4 = r1.createTypedArrayList(AoiBoard.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.b
            public boolean c() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarAoiBoardManager");     // Catch: Throwable -> L8
                boolean r3 = false;
                this.f6988a.transact(6, r0, r1, 0);     // Catch: Throwable -> L8
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
        }

        public a() {
            attachInterface(this, "com.obric.cae.libs.location.poi.IStarAoiBoardManager");
        }

        public static b a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.cae.libs.location.poi.IStarAoiBoardManager");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0339a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("com.obric.cae.libs.location.poi.IStarAoiBoardManager");
        L8:
            if (r4 == 1598968902) goto L21;
            switch(r4) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                default: goto L11;
            };
        L12:
            a(com.obric.cae.libs.location.poi.a.AbstractBinderC0337a.a(r5.readStrongBinder()), r5.readInt());
        L20:
            return true;
        L13:
            boolean r3 = c();
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            goto L20
        L14:
            AoiBoard r8 = a(r5.readString());
            r6.writeNoException();
            C0340b.a(r6, r8);
            goto L20
        L15:
            List<AoiBoard> r9 = a(r5.readInt());
        L17:
            r6.writeNoException();
            r6.writeTypedList(r9);
            goto L20
        L16:
            r9 = b();
            goto L17
        L18:
            a();
            goto L20
        L19:
            a(com.obric.cae.libs.location.poi.a.AbstractBinderC0337a.a(r5.readStrongBinder()));
            goto L20
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L21:
            r6.writeString("com.obric.cae.libs.location.poi.IStarAoiBoardManager");
            return true;
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.libs.location.poi.b$b, reason: collision with other inner class name */
    public static class C0340b {
        public static void a(Parcel r1, AoiBoard r2) {
            if (r2 == null) goto L4;
            r1.writeInt(1);
            r2.writeToParcel(r1, 1);
            return;
        L4:
            r1.writeInt(0);
        }
    }

    AoiBoard a(String r1);

    List<AoiBoard> a(int r1);

    void a();

    void a(com.obric.cae.libs.location.poi.a r1);

    void a(com.obric.cae.libs.location.poi.a r1, int r2);

    List<AoiBoard> b();

    boolean c();
}
