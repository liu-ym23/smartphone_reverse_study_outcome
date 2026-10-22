package com.bytedance.radioservice.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.bytedance.radioservice.a.b$a$a, reason: collision with other inner class name */
        public static class C0157a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f3090a;

            public C0157a(IBinder r3) {
                this.f3090a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.bytedance.radioservice.a.b
            public int a(com.bytedance.radioservice.a.a r4) {
                com.bytedance.radioservice.a.a r5 = (com.bytedance.radioservice.a.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.radioservice.a.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain(asBinder());
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bytedance.radioservice.cellpoi.ICellPoiService");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.f3090a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.radioservice.a.b
            public int a(c r4) {
                c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain(asBinder());
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bytedance.radioservice.cellpoi.ICellPoiService");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.f3090a.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.radioservice.a.b
            public String a(int r4, int r5, int r6, long r7) {
                Parcel r0 = Parcel.obtain(asBinder());
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bytedance.radioservice.cellpoi.ICellPoiService");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeLong(r7);     // Catch: Throwable -> L6
                this.f3090a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.radioservice.a.b
            public void a(int r4) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken("com.bytedance.radioservice.cellpoi.ICellPoiService");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f3090a.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3090a;
            }

            @Override // com.bytedance.radioservice.a.b
            public void b(int r4) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken("com.bytedance.radioservice.cellpoi.ICellPoiService");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f3090a.transact(5, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public static b a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.bytedance.radioservice.cellpoi.ICellPoiService");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0157a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r9, Parcel r10, int r11) {
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r9.enforceInterface("com.bytedance.radioservice.cellpoi.ICellPoiService");
        L8:
            if (r8 != 1598968902) goto L11;
            r10.writeString("com.bytedance.radioservice.cellpoi.ICellPoiService");
            return true;
        L11:
            if (r8 != 1) goto L13;
            int r2 = r9.readInt();
            int r3 = r9.readInt();
            int r4 = r9.readInt();
            long r5 = r9.readLong();
            r9.enforceNoDataAvail();
            String r7 = a(r2, r3, r4, r5);
            r10.writeNoException();
            r10.writeString(r7);
        L28:
            return true;
        L13:
            if (r8 != 2) goto L15;
            com.bytedance.radioservice.a.a r12 = com.bytedance.radioservice.a.a.AbstractBinderC0155a.a(r9.readStrongBinder());
            r9.enforceNoDataAvail();
            int r13 = a(r12);
        L26:
            r10.writeNoException();
            r10.writeInt(r13);
            goto L28
        L15:
            if (r8 != 3) goto L17;
            int r14 = r9.readInt();
            r9.enforceNoDataAvail();
            a(r14);
            goto L28
        L17:
            if (r8 != 4) goto L19;
            c r15 = c.a.a(r9.readStrongBinder());
            r9.enforceNoDataAvail();
            r13 = a(r15);
            goto L26
        L19:
            if (r8 != 5) goto L21;
            int r16 = r9.readInt();
            r9.enforceNoDataAvail();
            b(r16);
            goto L28
        L21:
            return super.onTransact(r8, r9, r10, r11);
        }
    }

    int a(com.bytedance.radioservice.a.a r1);

    int a(c r1);

    String a(int r1, int r2, int r3, long r4);

    void a(int r1);

    void b(int r1);
}
