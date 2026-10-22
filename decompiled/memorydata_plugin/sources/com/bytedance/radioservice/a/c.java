package com.bytedance.radioservice.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: com.bytedance.radioservice.a.c$a$a, reason: collision with other inner class name */
        public static class C0158a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f3091a;

            public C0158a(IBinder r3) {
                this.f3091a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.bytedance.radioservice.a.c
            public void a(int r3, int r4, String r5) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken("com.bytedance.radioservice.cellpoi.IHighConfidenceCellPoiCallback");     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.f3091a.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3091a;
            }
        }

        public a() {
            attachInterface(this, "com.bytedance.radioservice.cellpoi.IHighConfidenceCellPoiCallback");
        }

        public static c a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.bytedance.radioservice.cellpoi.IHighConfidenceCellPoiCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L13;
            return (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
        L13:
            return new C0158a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("com.bytedance.radioservice.cellpoi.IHighConfidenceCellPoiCallback");
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString("com.bytedance.radioservice.cellpoi.IHighConfidenceCellPoiCallback");
            return true;
        L11:
            if (r4 != 1) goto L13;
            int r8 = r5.readInt();
            int r9 = r5.readInt();
            String r10 = r5.readString();
            r5.enforceNoDataAvail();
            a(r8, r9, r10);
            return true;
        L13:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(int r1, int r2, String r3);
}
