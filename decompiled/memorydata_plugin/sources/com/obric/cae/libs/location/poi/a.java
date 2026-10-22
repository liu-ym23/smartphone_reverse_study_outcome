package com.obric.cae.libs.location.poi;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.obric.cae.libs.location.poi.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0337a extends Binder implements a {

        /* JADX INFO: renamed from: com.obric.cae.libs.location.poi.a$a$a, reason: collision with other inner class name */
        public static class C0338a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f6987a;

            public C0338a(IBinder r3) {
                this.f6987a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.cae.libs.location.poi.a
            public void a(AoiBoard r4, Location r5, int r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.location.poi.IStarAoiBoardCallback");     // Catch: Throwable -> L13
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                if (r5 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L10:
                r0.writeInt(r6);     // Catch: Throwable -> L13
                this.f6987a.transact(1, r0, null, 1);     // Catch: Throwable -> L13
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6987a;
            }
        }

        public AbstractBinderC0337a() {
            attachInterface(this, "com.obric.cae.libs.location.poi.IStarAoiBoardCallback");
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.cae.libs.location.poi.IStarAoiBoardCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0338a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("com.obric.cae.libs.location.poi.IStarAoiBoardCallback");
        L8:
            if (r4 == 1598968902) goto L14;
            if (r4 != 1) goto L11;
            a((AoiBoard) ZeusTransformUtils.preCheckCast(b.a(r5, AoiBoard.CREATOR), AoiBoard.class, "com.obric.memorydata.plugin"), (Location) ZeusTransformUtils.preCheckCast(b.a(r5, Location.CREATOR), Location.class, "com.obric.memorydata.plugin"), r5.readInt());
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            r6.writeString("com.obric.cae.libs.location.poi.IStarAoiBoardCallback");
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

    void a(AoiBoard r1, Location r2, int r3);
}
