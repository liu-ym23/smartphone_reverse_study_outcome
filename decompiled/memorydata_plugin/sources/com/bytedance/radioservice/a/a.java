package com.bytedance.radioservice.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.bytedance.radioservice.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0155a extends Binder implements a {

        /* JADX INFO: renamed from: com.bytedance.radioservice.a.a$a$a, reason: collision with other inner class name */
        public static class C0156a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f3089a;

            public C0156a(IBinder r3) {
                this.f3089a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.bytedance.radioservice.a.a
            public void a(int r3, int r4, int r5, int r6, long r7, int r9, String r10) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken("com.bytedance.radioservice.cellpoi.ICellPoiCallback");     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeLong(r7);     // Catch: Throwable -> L6
                r0.writeInt(r9);     // Catch: Throwable -> L6
                r0.writeString(r10);     // Catch: Throwable -> L6
                this.f3089a.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3089a;
            }
        }

        public AbstractBinderC0155a() {
            attachInterface(this, "com.bytedance.radioservice.cellpoi.ICellPoiCallback");
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.bytedance.radioservice.cellpoi.ICellPoiCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0156a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) {
            if (r11 < 1) goto L8;
            if (r11 > 16777215) goto L8;
            r12.enforceInterface("com.bytedance.radioservice.cellpoi.ICellPoiCallback");
        L8:
            if (r11 != 1598968902) goto L11;
            r13.writeString("com.bytedance.radioservice.cellpoi.ICellPoiCallback");
            return true;
        L11:
            if (r11 != 1) goto L13;
            int r2 = r12.readInt();
            int r3 = r12.readInt();
            int r4 = r12.readInt();
            int r5 = r12.readInt();
            long r6 = r12.readLong();
            int r8 = r12.readInt();
            String r9 = r12.readString();
            r12.enforceNoDataAvail();
            a(r2, r3, r4, r5, r6, r8, r9);
            return true;
        L13:
            return super.onTransact(r11, r12, r13, r14);
        }
    }

    void a(int r1, int r2, int r3, int r4, long r5, int r7, String r8);
}
